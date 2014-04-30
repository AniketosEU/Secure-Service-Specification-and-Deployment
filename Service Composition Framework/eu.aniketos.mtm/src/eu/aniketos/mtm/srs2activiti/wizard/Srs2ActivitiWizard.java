/*******************************************************************************
 * Copyright (c) 2012, Project: FP7-ICT-257930 Aniketos
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 *  -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  -  Neither the name of institution nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package eu.aniketos.mtm.srs2activiti.wizard;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import eu.aniketos.mtm.implementation.Transformation;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs2activiti.wizard.pages.CustomPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.NewPerformersPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.NewPerformersRolePage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.NewVariablesPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.SoDBoDPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.TasksPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.ThreatPage;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;

/**
 * 
 * MTM tranformation wizard; SRS to BPMN activiti converter wizard.
 * 
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class Srs2ActivitiWizard extends Wizard implements INewWizard {
	public final static String mappingExtension = "mapping";
	public final static String bpmnExtension = "bpmn";
	public final static String outputExtension = "activiti";
	
	private NewPerformersPage newPerformersPage;
	private NewPerformersRolePage newPerformersRolePage;
	private TasksPage tasksPage;
	private NewVariablesPage newVariablesPage;
//	private OutputFilePage outputFilePage;
	private SoDBoDPage soDBoDPage;
	private ThreatPage threatPage;
	
	private SecReqSpeType srs;
	private MappingType mapping;
	
	private String srsPath;
	
	/**
	 * Constructor.
	 */
	public Srs2ActivitiWizard() {
		this(null);
	}
	
	/**
	 * Constructor.
	 * @param srsPath Complete path of the SRS input file.
	 */
	public Srs2ActivitiWizard(String srsPath) {
		super();
		setWindowTitle("MTM Transformation - BPMN generation from SRS");
		this.srsPath = srsPath;
		
		try {
			if(this.srsPath == null) {
				srs = SrsManager.getInstance().createSecReqSpeType();
			} else {
				srs = SrsManager.getInstance().loadSecReqSpeType(this.srsPath);
			}
			mapping = MappingManager.getInstance().createMappingType();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Add all the pages involved in the wizard.
	 */
	@Override
	public void addPages() {
		newPerformersPage = new NewPerformersPage(srs);		
		newPerformersRolePage = new NewPerformersRolePage(srs);		
		newVariablesPage = new NewVariablesPage(srs);		
		tasksPage = new TasksPage(srs);
		soDBoDPage = new SoDBoDPage(srs);
		threatPage = new ThreatPage(srs);
		
		addPage(newPerformersPage);
		addPage(newPerformersRolePage);
		addPage(newVariablesPage);
		addPage(tasksPage);		
		
		boolean soDBodFound = false, threatFound = false;		
		if(soDBoDPage.getCommitmentTypeList() != null && soDBoDPage.getCommitmentTypeList().size() > 0){
			soDBodFound = true;
		}				
		if(threatPage.getThreats() != null && threatPage.getThreats().size() > 0){
			threatFound = true;
		}
		
		if(!soDBodFound && !threatFound){
			// taskpage canFinish
			tasksPage.setCanFinish(true);
		}
		else if(soDBodFound && !threatFound){
			// soDBoDPage canFinish
			soDBoDPage.setCanFinish(true);
			addPage(soDBoDPage);
		}
		else if(!soDBodFound && threatFound){
			// threatPage canFinish
			threatPage.setCanFinish(true);
			addPage(threatPage);
		}
		else{
			addPage(soDBoDPage);
			// threatPage canFinish
			threatPage.setCanFinish(true);
			addPage(threatPage);
		}
		
//		outputFilePage = new OutputFilePage(new String[] { "*." + outputExtension }, getActivitiPathSuggestion(srsPath));
//		addPage(outputFilePage);
		
		// add listeners
		addListeners();
	}
	

	/**
	 * 
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		System.out.println("Srs2ActivitiWizard.init() called");
	}
	
	/**
	 * Invokes onAppear() method in the incoming page before loading it.
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(nextPage instanceof CustomPage) {
			((CustomPage)nextPage).onAppear();
		}
		return nextPage;
	}

	
	/**
	 * Delegates canFinish() on child pages.
	 */
	@Override
	public boolean canFinish() {
		CustomPage currentPage = (CustomPage)getContainer().getCurrentPage();
		return currentPage.canFinish();
	}

	/**
	 * Saves the mapping model in the specified file when finished.
	 */
	@Override
	public boolean performFinish() {
		CustomPage currentPage = (CustomPage)getContainer().getCurrentPage();
		currentPage.performFinish();
		
		Transformation transformation = new Transformation();
		if(transformation.transform(mapping, srsPath)){
			MessageDialog.openInformation(getShell(), "Transformation Completed", "The transformation has completed successfully.");
		}
		else{
			MessageDialog.openError(getShell(), "Cannot Transform", "An error occurred during the transformation process.");
		}
		
		return true;
	}
	
	private void addListeners (){
		// Add listener to update size after the page is changed
		((WizardDialog)this.getContainer()).addPageChangedListener(new IPageChangedListener() {
			
			@Override
			public void pageChanged(PageChangedEvent event) {
				((WizardDialog)getContainer()).updateSize();		
				
			}
		});
	}
	
	/**
	 * Gets SecReqSpeType root element of the associated SRS input model.
	 * @return The SecReqSpeType element.
	 */
	public SecReqSpeType getSrs() {
		return srs;
	}
	
	/**
	 * Gets MappingType root element of the associated mapping input model.
	 * @return The MappingType element.
	 */
	public MappingType getMapping() {
		return mapping;
	}

	
}
