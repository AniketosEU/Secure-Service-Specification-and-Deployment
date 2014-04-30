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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import eu.aniketos.mtm.srs2activiti.wizard.pages.CustomPage;
import eu.aniketos.mtm.srs2activiti.wizard.pages.SRSSelectorPage;

public class MtmWizard extends Wizard implements INewWizard {
	
	private SRSSelectorPage srsSelectorPage;	
	private String srsPath;
	
	public MtmWizard() {
		setWindowTitle("MTM Transformation Wizard");
	}
	
	/**
	 * Add all the pages involved in the wizard.
	 */
	@Override
	public void addPages() {
		srsSelectorPage = new  SRSSelectorPage();
		addPage(srsSelectorPage);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		System.out.println("MtmWizard.init() called");
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

	@Override
	public boolean performFinish() {	
		if(!srsSelectorPage.getSrsFile().equals(null)){
			srsPath = srsSelectorPage.getSrsFile();	
			Srs2ActivitiWizard srs2ActivitiWizard = new Srs2ActivitiWizard(srsPath);
			srs2ActivitiWizard.init(PlatformUI.getWorkbench(), null);				
			// Instantiates the wizard container with the wizard and opens it
			WizardDialog dialog = new WizardDialog(getShell(), srs2ActivitiWizard);
			dialog.create();
			dialog.open();
			
			if(getContainer() instanceof WizardDialog){
				WizardDialog wDialog = (WizardDialog) getContainer();
				wDialog.close();
			}
		}
		
		return false;		
	}
	
	

}
