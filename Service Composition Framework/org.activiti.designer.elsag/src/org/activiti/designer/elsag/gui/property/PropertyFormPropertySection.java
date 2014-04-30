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

import org.activiti.designer.property.ui.FormPropertyEditor;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyFormPropertySection extends ActivitiPropertySection implements ITabbedPropertyConstants {

  private FormPropertyEditor formPropertyEditor;
  
  private String processId;
  private String taskId;

  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
    super.createControls(parent, tabbedPropertySheetPage);

    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    Composite composite = factory.createFlatFormComposite(parent);
    FormData data;
    
    Composite formPropertiesComposite = factory.createComposite(composite, SWT.WRAP);
    data = new FormData();
    data.left = new FormAttachment(0, 150);
    data.right = new FormAttachment(100, 0);
    data.top = new FormAttachment(0, VSPACE);
    formPropertiesComposite.setLayoutData(data);
    GridLayout layout = new GridLayout();
    layout.marginTop = 0;
    layout.numColumns = 1;
    formPropertiesComposite.setLayout(layout);
    formPropertyEditor = new FormPropertyEditor("formPropertyEditor", formPropertiesComposite);
    formPropertyEditor.getLabelControl(formPropertiesComposite).setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
    
    CLabel formPropertiesLabel = factory.createCLabel(composite, "Form properties:"); //$NON-NLS-1$
    data = new FormData();
    data.left = new FormAttachment(0, 0);
    data.right = new FormAttachment(formPropertiesComposite, -HSPACE);
    data.top = new FormAttachment(formPropertiesComposite, 0, SWT.TOP);
    formPropertiesLabel.setLayoutData(data);
  }

  public void setInput(IWorkbenchPart part, ISelection selection) {
	  super.setInput(part, selection);

	  EList<EObject> list = getDiagram().eResource().getContents();
	  processId = "";
	  for(EObject ob : list){
		  if(ob instanceof org.eclipse.bpmn2.Process){
			  org.eclipse.bpmn2.Process process = (org.eclipse.bpmn2.Process) ob;
			  processId = process.getId();
		  }
	  }

  }

  @Override
  public void refresh() {

	  PictogramElement pe = getSelectedPictogramElement();
	  if (pe != null) {
		  Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		  if (bo == null)
        return;
      
      List<FormProperty> formPropertyList = null;
      if(bo instanceof UserTask) {
    	  formPropertyList = ((UserTask) bo).getFormProperties();
    	  taskId = ((UserTask) bo).getId();
      } else if(bo instanceof StartEvent) {
    	  formPropertyList = ((StartEvent) bo).getFormProperties();
    	  taskId = ((StartEvent) bo).getId();
      } else {
    	  return;
      }

      formPropertyEditor.pictogramElement = pe;
      formPropertyEditor.diagramEditor = getDiagramEditor();
      formPropertyEditor.diagram = getDiagram();
      formPropertyEditor.initialize(formPropertyList);

//      Hashtable<String,List<String>> taskVariables = org.activiti.designer.elsag.data.Data.hashTableVariables.get(processId);
//      if(taskVariables == null){
//    	  taskVariables = new Hashtable<String,List<String>>();
//      }
//      List<String> variables = new Vector<String>();
//
//      for(FormProperty prop : formPropertyList){
//    	  if(!variables.contains(prop.getId())){
//    		  variables.add(prop.getId());
//    	  }
//      }
//      taskVariables.put(taskId, variables);
//      System.out.println("taskId: "+taskId);
//      System.out.println(taskVariables.size());
//      org.activiti.designer.elsag.data.Data.hashTableVariables.put(processId, taskVariables);
//      System.out.println("processId: "+processId);
    }
  }

}
