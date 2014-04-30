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
package org.activiti.designer.elsag.gui.property;

import java.util.List;
import java.util.Vector;

import org.activiti.designer.elsag.gui.selectionAdapter.CompositionPlansCreationAdapter;
import org.activiti.designer.elsag.gui.selectionAdapter.DiscoverAllSelectionAdapter;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosPlanningSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	
	private Button createPlansButton;
	public Text serviceNameText;
	public Text operationText;
	public Text tagsText;
	
	private Composite composite;
	private String processId;
	private Diagram diagram;
	
	public final static String CLASS_TYPE = "classType";

	
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;

        Group planningGroup = factory.createGroup(composite, "Plan");
		data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        planningGroup.setLayoutData(data);
        
        FormLayout layout3 = new FormLayout ();
        planningGroup.setLayout(layout3);
        
        Label labelAdvise = factory.createLabel(planningGroup, "");
        labelAdvise.setText("The number of combinations is related to how many web services have been found for each service task");
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        data.width = 600;
        labelAdvise.setLayoutData(data);

		createPlansButton = factory.createButton(planningGroup, "", SWT.BUTTON1);
		createPlansButton.setText("Create Composition Plans");
		data = new FormData();
        data.top = new FormAttachment(labelAdvise, 20);
        data.left = new FormAttachment(0, 20);
        data.bottom = new FormAttachment(100, -20);
        createPlansButton.setLayoutData(data);
		createPlansButton.setEnabled(true);
        
        IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = workbenchWindow.getActivePage();
		
		createPlansButton.addSelectionListener(new CompositionPlansCreationAdapter(composite.getShell(), page));
	}

	@Override
	public void refresh() {
		List<ServiceTask> serviceTasks = getListOfServiceTasks();
		List<ServiceTask> serviceTasksDiscovered = new Vector<ServiceTask>();
		for(ServiceTask serviceTask : serviceTasks){
			List<FieldExtension> list = serviceTask.getFieldExtensions();
			
			for(FieldExtension field : list){
				if(field.getFieldname().equals("location")){
					serviceTasksDiscovered.add(serviceTask);
				}
			}
		}
		if(serviceTasks.size() == serviceTasksDiscovered.size()){
			createPlansButton.setEnabled(false);
		}
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
		diagram = getDiagram();
		
		CompositionPlansCreationAdapter.setDiagram(diagram);
		DiscoverAllSelectionAdapter.setDiagram(diagram);
		
		EList<EObject> list = getDiagram().eResource().getContents();
		processId = "";
		for(EObject ob : list){
			if(ob instanceof org.eclipse.bpmn2.Process){
				org.eclipse.bpmn2.Process process = (org.eclipse.bpmn2.Process) ob;
				processId = process.getId();
				CompositionPlansCreationAdapter.setProcessId(processId);
				DiscoverAllSelectionAdapter.setProcessId(processId);
			}
		}
		
		createPlansButton.setEnabled(true);
		
	}
	
	public java.util.List<ServiceTask> getListOfServiceTasks(){

		java.util.List<String> tasksDiscovered = new Vector<String>();
		java.util.List<ServiceTask> servicetasksList = new Vector<ServiceTask>();
		EList<PictogramLink> list = diagram.getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
						servicetasksList.add(task);
					}
				}
			}
		}

		return servicetasksList;
	}
	

}
