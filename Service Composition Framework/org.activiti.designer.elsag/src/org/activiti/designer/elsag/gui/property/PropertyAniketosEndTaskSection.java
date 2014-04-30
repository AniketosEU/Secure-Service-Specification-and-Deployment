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
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.EndEvent;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosEndTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants{
	
	private Composite composite;
	
	private CCombo comboVariables;
	private Text textVariable;

	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		comboVariables = factory.createCCombo(composite, SWT.BORDER);
	    data = new FormData();
	    data.left = new FormAttachment(0, 140);
	    data.right = new FormAttachment(60, 0);
	    data.top = new FormAttachment(0, 20);
	    comboVariables.setLayoutData(data);
	    comboVariables.addFocusListener(listener);
	    comboVariables.addSelectionListener(selectionListener);
		
		CLabel resultVariableLabel = factory.createCLabel(composite, "Select a variable:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(comboVariables, -HSPACE);
	    data.top = new FormAttachment(0,20);
	    resultVariableLabel.setLayoutData(data);
	    
	    textVariable = factory.createText(composite, "", SWT.BORDER);
	    data = new FormData();
	    data.top = new FormAttachment(comboVariables, 20);
	    data.left = new FormAttachment(0, 140);
	    data.right = new FormAttachment(45, 0);
	    textVariable.setLayoutData(data);
	   
	    
	    CLabel variableLabel = factory.createCLabel(composite, "Actual result variable:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(textVariable, -HSPACE);
	    data.top = new FormAttachment(comboVariables, 20);
	    variableLabel.setLayoutData(data);
	    
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		textVariable.setEditable(false);
		
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
		String[] vars = new String[variables.size()];
		int cont=0;
		for(ProcessVariable var : variables){
			vars[cont] = var.getValue() + " - (Type: "+var.getType()+", Returned by: " + var.getTaskName() + ")";
			cont++;
		}
		comboVariables.setItems(vars);
		
		
	}
	
	@Override
	public void refresh() {
		
		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo == null)
			return;
		EndEvent endEvent = (EndEvent) bo;
		String variable = endEvent.getResultVariable();
		if(variable != null){
			textVariable.setText(variable);
		}

	}

	private FocusListener listener = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent e) {
			

		};


	};
	
	private SelectionListener selectionListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
				final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
				if (bo instanceof EndEvent) {
					DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
					@SuppressWarnings("restriction")
					TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
					ActivitiUiUtil.runModelChange(new Runnable() {
						public void run() {
							EndEvent endEvent = (EndEvent) bo;
							String text = comboVariables.getText();
							if(!text.equals("")){
								String variable = text.substring(0, text.indexOf("-")-1);
								endEvent.setResultVariable(variable);
								textVariable.setText(variable);
							} else {
								endEvent.setResultVariable(null);
							}
						}

					}, editingDomain, "Model Update");
				}
			}
		
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
}
