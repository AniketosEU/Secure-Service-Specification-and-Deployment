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

import org.activiti.designer.elsag.data.ProcessVariable;
import org.activiti.designer.elsag.gui.selectionAdapter.SRCMSelectionAdapter;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.apache.log4j.Logger;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosGeneralSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Composite composite;
	
	private Button checkSRCMButton;
	private Button openConspecButton;
	private Button createAgreementButton;
	private Diagram diagram;
	
	private Display display;
	
	public final static String CLASS_TYPE = "classType";

	final private static Logger log = Logger.getLogger(PropertyAniketosGeneralSection.class);
	
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		display = parent.getDisplay();
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;
		
        Group securityGroup = factory.createGroup(composite, "Conspec Editor");
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        securityGroup.setLayoutData(data);
        
        FormLayout layout = new FormLayout ();
        securityGroup.setLayout(layout);
        
        openConspecButton = factory.createButton(securityGroup, "", SWT.BUTTON1);
        openConspecButton.setText("Create Consumer Policies");
        openConspecButton.addSelectionListener(new SelectionAdapter(){
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		showErrorMessage();
        	}
        });
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        data.bottom = new FormAttachment(100, -20);
        openConspecButton.setLayoutData(data);
        openConspecButton.setToolTipText("Use the conspec editor to create the Agreement Template and refine the Consumer Policy");
        
        createAgreementButton = factory.createButton(securityGroup, "", SWT.BUTTON1);
        createAgreementButton.setText("Create Agreement Template");
        createAgreementButton.addSelectionListener(new SelectionAdapter() {
        	
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		showErrorMessage();
        	}
		});
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(openConspecButton, 20);
        data.bottom = new FormAttachment(100, -20);
        createAgreementButton.setLayoutData(data);
        
        Group consumerPolicyGroup = factory.createGroup(composite, "Consumer Policy");
        data = new FormData();
        data.top = new FormAttachment(securityGroup, 20);
        data.left = new FormAttachment(0, 20);
        consumerPolicyGroup.setLayoutData(data);
        consumerPolicyGroup.setLayout(layout);
        
        checkSRCMButton = factory.createButton(consumerPolicyGroup, "", SWT.BUTTON1);
        checkSRCMButton.setText("Check if the BPMN is compliant with the SRS");
        checkSRCMButton.addSelectionListener(new SRCMSelectionAdapter(composite.getShell()));
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        data.bottom = new FormAttachment(100, -20);
        checkSRCMButton.setLayoutData(data);
        
	}

	@Override
	public void refresh() {
		
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
		diagram = getDiagram();
		
		SRCMSelectionAdapter.setDiagram(diagram);

	}
	
	public List<String> getListOfTasksId(){

		List<String> tasksDiscovered = new Vector<String>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
					}
				}
			}
		}

		return tasksDiscovered;
	}
	
	public List<String> getListOfTasksName(){

		List<String> tasksDiscovered = new Vector<String>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getName())){
						tasksDiscovered.add(task.getName());
					}
				}
			}
		}

		return tasksDiscovered;

	}
	
	public List<ProcessVariable> getProcessVariables(){
		List<String> tasksDiscovered = new Vector<String>();
		List<ProcessVariable> variables = new Vector<ProcessVariable>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
						List<FieldExtension> listFields = task.getFieldExtensions();
						String value = "";
						String type = "";
						for(FieldExtension field : listFields){
							if(field.getFieldname().equals("resultVariable")){
								value = field.getExpression();
							} else if(field.getFieldname().equals("outputType")){
								type= field.getExpression();
							}
						}
						if(!value.equals("") && !type.equals("")){
							ProcessVariable processVariable = new ProcessVariable(task.getId(), task.getName(), value, type);
							variables.add(processVariable);
						}
					}
				} else if(ob instanceof StartEvent){
					StartEvent event = (StartEvent) ob;
					if(!tasksDiscovered.contains(event.getId())){
						tasksDiscovered.add(event.getId());
						List<FormProperty> formPropertyList = event.getFormProperties();
						for(FormProperty prop : formPropertyList){
							ProcessVariable processVariable = new ProcessVariable(event.getId(), event.getName(), prop.getId(), prop.getType());
							variables.add(processVariable);
						}
					}
				} else if(ob instanceof UserTask){
					UserTask task = (UserTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
						List<FormProperty> formPropertyList = task.getFormProperties();
						for(FormProperty prop : formPropertyList){
							ProcessVariable processVariable = new ProcessVariable(task.getId(), task.getName(), prop.getId(), prop.getType());
							variables.add(processVariable);
						}
					}
				}

			}
		}
		return variables;
	}
	
	public java.util.List<ServiceTask> getListOfServiceTasks(){

		java.util.List<String> tasksDiscovered = new Vector<String>();
		java.util.List<ServiceTask> servicetasksList = new Vector<ServiceTask>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
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
	
	private void showErrorMessage() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(display.getActiveShell(), "Conspec Editor not available",
							"The Conspec Editor is not available in the free package edition");
			}
		});

	}

}
