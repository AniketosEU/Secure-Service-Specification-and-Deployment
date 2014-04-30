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

import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosStartEventSection extends ActivitiPropertySection implements ITabbedPropertyConstants{
	
	private Composite composite;
	private Text inputText;
	private Button addButton;
	private Button removeButton;
	private List inputList;

	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2,true);
		composite.setLayout(gridLayout);
		composite.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		GridData data;
		
		Composite variableComposite = new Composite(composite, SWT.NONE);
		GridLayout gridLayout2 = new GridLayout(3, false);
		variableComposite.setLayout(gridLayout2);
		data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
        data.widthHint = 250;
        variableComposite.setLayoutData(data);
        variableComposite.setBackground(variableComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		CLabel variableLabel = new CLabel(variableComposite, SWT.NONE);
		data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
	    variableLabel.setLayoutData(data);
	    variableLabel.setText("Variable");
		
		inputText = new Text(variableComposite, SWT.BORDER);
		data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
        data.widthHint = 70;
	    inputText.setLayoutData(data);
	    inputText.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if((inputText.getText().equals(""))){
					addButton.setEnabled(false);
				} else {
					addButton.setEnabled(true);
				}
				
			}
        	
        });
	    
	    addButton = new Button(variableComposite, SWT.BUTTON1);
	    addButton.setText("Add");
	    addButton.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				final String variable = inputText.getText();
				if(!variable.equals("")){
					inputList.add(variable);
					inputText.setText("");
					addButton.setEnabled(false);
					PictogramElement pe = getSelectedPictogramElement();
					if (pe != null) {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
						if (bo instanceof StartEvent) {
							DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
							@SuppressWarnings("restriction")
							TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
							ActivitiUiUtil.runModelChange(new Runnable() {
								public void run() {
									Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
									StartEvent startEvent = (StartEvent) bo;
									java.util.List<FormProperty> formPropertyList = startEvent.getFormProperties();
									FormProperty newFormProperty = Bpmn2Factory.eINSTANCE.createFormProperty();
									newFormProperty.setId(variable);
									newFormProperty.setName(variable);
									formPropertyList.add(newFormProperty);
								}
							}, editingDomain, "Model Update");
						}
					}
					if(inputList.getItemCount() > 0){
						removeButton.setEnabled(true);
					} else {
						removeButton.setEnabled(false);
					}

				}
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
	    	
	    });
        data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
        addButton.setLayoutData(data);
        addButton.setEnabled(false);
        
        Composite rightComposite = new Composite(composite, SWT.NONE);
        GridLayout gridLayout3 = new GridLayout(2, false);
        rightComposite.setLayout(gridLayout3);
		data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
        data.widthHint = 250;
        rightComposite.setLayoutData(data);
        rightComposite.setBackground(rightComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        
        inputList = new List(rightComposite, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
        data = new GridData(SWT.LEFT, SWT.FILL, false, false);
        data.horizontalSpan= 1;
        inputList.setLayoutData(data);
        data.widthHint = 150;
        data.heightHint = 200;
		
        removeButton = new Button(rightComposite, SWT.BUTTON1);
        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				final String variable = inputList.getSelection()[0];
				if(!variable.equals("") || variable == null){
					inputList.remove(variable);
					PictogramElement pe = getSelectedPictogramElement();
					if (pe != null) {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
						if (bo instanceof StartEvent) {
							DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
							@SuppressWarnings("restriction")
							TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
							ActivitiUiUtil.runModelChange(new Runnable() {
								public void run() {
									Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
									StartEvent startEvent = (StartEvent) bo;
									java.util.List<FormProperty> formPropertyList = startEvent.getFormProperties();
									int c = 0;
									for(int i =0; i< formPropertyList.size(); i++){
										FormProperty formProperty = formPropertyList.get(i);
										if(formProperty.getId().equals(variable)){
											c = i;
											break;
										}
									}
									formPropertyList.remove(c);									
								}
							}, editingDomain, "Model Update");
						}
					}
					if(inputList.getItemCount() > 0){
						removeButton.setEnabled(true);
					} else {
						removeButton.setEnabled(false);
					}
				}
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
	    	
	    });
        data = new GridData(SWT.LEFT, SWT.TOP, false, false);
        data.horizontalSpan= 1;
        removeButton.setLayoutData(data);

	}
	
	
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
	}
	
	@Override
	public void refresh() {
		inputList.removeAll();
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof StartEvent) {
				StartEvent startEvent = (StartEvent) bo;
				java.util.List<FormProperty> formPropertyList = startEvent.getFormProperties();
				for(FormProperty formProperty : formPropertyList){
					inputList.add(formProperty.getId());
				}
			}
		}
		if(inputList.getItemCount() > 0){
			removeButton.setEnabled(true);
		} else {
			removeButton.setEnabled(false);
		}

	}

}
