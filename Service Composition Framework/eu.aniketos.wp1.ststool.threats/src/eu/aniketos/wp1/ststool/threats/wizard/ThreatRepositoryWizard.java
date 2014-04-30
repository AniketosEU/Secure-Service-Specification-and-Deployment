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
/*
* GenerateReportWizard.java
*/
package eu.aniketos.wp1.ststool.threats.wizard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.activiti.designer.eclipse.editor.ActivitiDiagramEditor;
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.EndEvent;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.parts.ContainerShapeEditPart;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import eu.aniketos.threatrepository.schema.download.Threat;
import eu.aniketos.threatrepository.schema.download.Threat.Metadata;



public class ThreatRepositoryWizard extends Wizard {

	private LookupThreatsPage page1;
	
	private ActivitiDiagramEditor editor;
	

	public ThreatRepositoryWizard(ActivitiDiagramEditor editor) {

		this.editor = editor;
		setNeedsProgressMonitor(true);
		setWindowTitle("Import threat definition");
		
		page1 = new LookupThreatsPage();
	}


	@Override
	public void addPages(){		
		super.addPages();
		addPage(page1);
	}
	
	
	@Override
	public boolean canFinish(){
		return page1.isPageComplete();
	}

	
	@Override
	public boolean performFinish() {	

		try {
			updateSelectedElement(page1.getSelectedThreat());			
		} catch (Exception ex) {
			page1.setErrorMessage(ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	
	
	public void updateSelectedElement(Threat threat) throws Exception {
		Metadata threatData = threat.getMetadata(); 
		final String newThreatName = threatData.getName();
		final String threatId = threatData.getThreatId();

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		DiagramEditor diagramEditor = (DiagramEditor) window.getActivePage().getActiveEditor();

		ISelection selection = window.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		final ContainerShapeEditPart selectElement = ((ContainerShapeEditPart) structuredSelection.getFirstElement());
		final Diagram diagram = diagramEditor.getDiagramTypeProvider().getDiagram();
		TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
		ActivitiUiUtil.runModelChange(new Runnable() {
			public void run() {

				EObject ob = (EObject) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(selectElement.getPictogramElement());
				if(ob instanceof EndEvent){
					EndEvent event = (EndEvent) ob;
					event.setName(newThreatName);
					List<EventDefinition> list = event.getEventDefinitions();
					ErrorEventDefinition errorDefinition = (ErrorEventDefinition) list.get(0);
					errorDefinition.setErrorCode(threatId);
				} else if (ob instanceof BoundaryEvent){
					BoundaryEvent boundaryEvent = (BoundaryEvent) ob;
					boundaryEvent.setName(newThreatName);
					ErrorEventDefinition errorDefinition = (ErrorEventDefinition) boundaryEvent.getEventDefinitions().get(0);
					errorDefinition.setErrorCode(threatId);
				}
			}

		}, editingDomain, "Model Update");	
		org.activiti.designer.elsag.gui.property.ThreatEventPropertySection.updateControls();
	}
}
