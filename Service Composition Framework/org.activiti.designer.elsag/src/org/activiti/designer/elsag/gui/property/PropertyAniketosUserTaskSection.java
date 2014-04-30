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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.activiti.designer.model.FieldExtensionModel;
import org.activiti.designer.util.BpmnBOUtil;
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.ActivitiListener;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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
public class PropertyAniketosUserTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants{
	
	private Composite composite;
	
	private Text inputText;
	
	private final static String CLASS_TYPE = "classType";
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		inputText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.right = new FormAttachment(100, 0);
	    inputText.setLayoutData(data);
	    inputText.addFocusListener(listener);
		
		CLabel typeVariableLabel = factory.createCLabel(composite, "Input:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(inputText, -HSPACE);
	    data.top = new FormAttachment(inputText, 0, SWT.TOP);
	    typeVariableLabel.setLayoutData(data);
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
		
	}
	
	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			inputText.removeFocusListener(listener);
			
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;
			
			UserTask userTask = (UserTask) bo;
			
			List<ActivitiListener> list = userTask.getActivitiListeners();
			for(ActivitiListener listener : list){
				List<FieldExtension> listField = listener.getFieldExtensions();
				for(FieldExtension field : listField){
					if(field.getFieldname().equals("input")){
						inputText.setText(field.getExpression());
					}
				}
			}
			inputText.addFocusListener(listener);
		}

	}

	private FocusListener listener = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {

		}

		@Override
		public void focusLost(FocusEvent e) {
			PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
				final Object bo = BpmnBOUtil.getExecutionListenerBO(pe, getDiagram());
				if (bo == null) {
					return;
				}
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						UserTask userTask = (UserTask)  bo;
						List<ActivitiListener> list = userTask.getActivitiListeners();
						boolean containsTaskListener = false;
						if(list!=null){
							for(ActivitiListener listener : list){
								if(listener.getImplementation().equals("eu.aniketos.tasklistener")){
									List<FieldExtensionModel> fieldExtensionList = new ArrayList<FieldExtensionModel>();
									FieldExtensionModel fieldModel = new FieldExtensionModel();
									fieldModel.fieldName = "input";
									fieldModel.expression = inputText.getText();
									fieldExtensionList.add(fieldModel);
									setFieldsInListener(listener, fieldExtensionList);
									containsTaskListener = true;
									break;
								} else {
									containsTaskListener = false;
								}
							}
							if(!containsTaskListener){
								ActivitiListener newListener = Bpmn2Factory.eINSTANCE.createActivitiListener();
								newListener.setEvent("create");
								newListener.setImplementationType(CLASS_TYPE);
								newListener.setImplementation("eu.aniketos.tasklistener");
								List<FieldExtensionModel> fieldExtensionList = new ArrayList<FieldExtensionModel>();
								FieldExtensionModel fieldModel = new FieldExtensionModel();
								fieldModel.fieldName = "input";
								fieldModel.expression = inputText.getText();
								fieldExtensionList.add(fieldModel);
								setFieldsInListener(newListener, fieldExtensionList);
								BpmnBOUtil.addListener(bo, newListener);
							}
						}
					}
				}, editingDomain, "Model Update");
			}

		};


	};
	
	private void setFieldsInListener(ActivitiListener listener, List<FieldExtensionModel> fieldList) {
		if(fieldList == null || fieldList.size() == 0) {
			if(listener != null && listener.getFieldExtensions() != null && 
					listener.getFieldExtensions().size() > 0) {

				removeFieldExtensionsNotInList(listener.getFieldExtensions(), null);
			}
			return;
		}
		for (FieldExtensionModel fieldModel : fieldList) {
			FieldExtension fieldExtension = fieldExtensionExists(listener.getFieldExtensions(), fieldModel.fieldName);
			if(fieldExtension == null) {
				fieldExtension = Bpmn2Factory.eINSTANCE.createFieldExtension();
				listener.getFieldExtensions().add(fieldExtension);
			}
			fieldExtension.setFieldname(fieldModel.fieldName);
			fieldExtension.setExpression(fieldModel.expression);
		}
		removeFieldExtensionsNotInList(listener.getFieldExtensions(), fieldList);
	}

	private void removeFieldExtensionsNotInList(List<FieldExtension> fieldList, List<FieldExtensionModel> newfieldList) {
		Iterator<FieldExtension> entryIterator = fieldList.iterator();
		while(entryIterator.hasNext()) {
			FieldExtension fieldExtension = entryIterator.next();
			boolean found = false;
			if(newfieldList != null && newfieldList.size() > 0) {
				for (FieldExtensionModel field : newfieldList) {
					if(field.fieldName.equals(fieldExtension.getFieldname())) {
						found = true;
						break;
					}
				}
			}
			if(found == false) {
				getDiagram().eResource().getContents().remove(fieldExtension);
				entryIterator.remove();
			}
		}
	}

	private FieldExtension fieldExtensionExists(List<FieldExtension> fieldList, String fieldname) {
		if(fieldList == null) return null;
		for(FieldExtension fieldExtension : fieldList) {
			if(fieldname.equalsIgnoreCase(fieldExtension.getFieldname())) {
				return fieldExtension;
			}
		}
		return null;
	}
	
}
