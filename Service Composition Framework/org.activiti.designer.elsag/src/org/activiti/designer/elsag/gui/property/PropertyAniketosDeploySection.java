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

import org.activiti.designer.elsag.data.Process;

import org.activiti.designer.elsag.dialog.AlternativesDialog;
import org.activiti.designer.elsag.gui.selectionAdapter.DeploySelectionAdapter;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.mihalis.opal.dynamictablecolumns.DynamicTable;
import org.mihalis.opal.dynamictablecolumns.DynamicTableColumn;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosDeploySection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Label serviceNameLabel;
	private Label serviceOperationLabel;
	private Label serviceTagsLabel;
	
	public Text serviceNameText;
	public Text operationText;
	public Text tagsText;
	
	private Composite composite;
	@SuppressWarnings("unused")
	private Composite parent;
	
	private Button alternativeButton;
	private Button deployButton;
	private Button removeAlternativeButton;
	private Diagram diagram;
	@SuppressWarnings("unused")
	private DiagramEditor diagramEditor;
	
	private Label labelAdvise;
	
	private static DynamicTable alternativeList;
	
	
	public final static String CLASS_TYPE = "classType";

	
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		this.parent = parent;
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;
        
        serviceNameLabel = factory.createLabel(composite, "Service Name:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(0, VSPACE+20);
	    serviceNameLabel.setLayoutData(data);
        
        serviceNameText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(serviceNameLabel, HSPACE);
	    data.top = new FormAttachment(0, VSPACE+20);
	    serviceNameText.setLayoutData(data);
	    
	    serviceOperationLabel = factory.createLabel(composite, "Name of the operation that will be provided by the service:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(serviceNameLabel, 30);
	    serviceOperationLabel.setLayoutData(data);
        
	    operationText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(serviceOperationLabel, HSPACE);
	    data.top = new FormAttachment(serviceNameLabel, 30);
	    operationText.setLayoutData(data);
	    
	    serviceTagsLabel = factory.createLabel(composite, "Operation type (to be announced in the Marketplace):");
	    data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(serviceOperationLabel, 30);
	    serviceTagsLabel.setLayoutData(data);
        
	    tagsText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(serviceTagsLabel, HSPACE);
	    data.top = new FormAttachment(serviceOperationLabel, 30);
	    tagsText.setLayoutData(data);
	    
        alternativeButton = factory.createButton(composite, "", SWT.BUTTON1);
        alternativeButton.setText("Select alternative BPMN processes");
        data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(serviceTagsLabel, 30);
        alternativeButton.setLayoutData(data);
        alternativeButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				AlternativesDialog dialog = new AlternativesDialog();
				dialog.createContents();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
        
	    alternativeList = new DynamicTable(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
	    data = new FormData();
	    data.left = new FormAttachment(alternativeButton, 20);
	    data.top = new FormAttachment(serviceTagsLabel, 30);
	    data.width = 280;
	    data.height = 200;
	    alternativeList.setLayoutData(data);
	    alternativeList.setHeaderVisible(true);
	    alternativeList.setLinesVisible(true);
	    
	    removeAlternativeButton = factory.createButton(composite, "", SWT.BUTTON1);
        removeAlternativeButton.setText("Remove");
        data = new FormData();
	    data.left = new FormAttachment(alternativeButton, 310);
	    data.top = new FormAttachment(serviceTagsLabel, 30);
	    removeAlternativeButton.setLayoutData(data);
	    removeAlternativeButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				 int[] selection = alternativeList.getSelectionIndices();
				 alternativeList.remove(selection);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	    
	    deployButton = factory.createButton(composite, "", SWT.BUTTON1);
        deployButton.setText("Deploy Composition Plan");
        deployButton.addSelectionListener(new DeploySelectionAdapter(composite.getShell(), serviceNameText, operationText, tagsText, alternativeList));
        data = new FormData();
        data.top = new FormAttachment(removeAlternativeButton, 230);
        data.left = new FormAttachment(0, 20);
        deployButton.setLayoutData(data);
        
        labelAdvise = factory.createLabel(composite, "");
        labelAdvise.setText("You have to select one of the generated composition plan to deploy the composite service");
        data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(deployButton, 10);
	    data.bottom = new FormAttachment(100, -20);
	    data.width = 600;
        labelAdvise.setLayoutData(data);
	    
	    

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
			deployButton.setEnabled(true);
			labelAdvise.setVisible(false);
		}
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		
		diagram = getDiagram();
		diagramEditor = (DiagramEditor) getDiagramEditor();
		
		DynamicTableColumn tblcId = new DynamicTableColumn(alternativeList, SWT.NONE);
		tblcId.setText("processId");
		tblcId.setWidth("150px");
		DynamicTableColumn tblcPath = new DynamicTableColumn(alternativeList, SWT.NONE);
		tblcPath.setText("Path");
		tblcPath.setWidth("100px");
		
		DeploySelectionAdapter.setDiagram(diagram);
		
		deployButton.setEnabled(false);
		labelAdvise.setVisible(true);

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
	
	public static void addProcessesToList(List<Process> processes){
		if(alternativeList!=null && !alternativeList.isDisposed()){
			for(Process process : processes){
				TableItem tbli = new TableItem(alternativeList, SWT.NONE);
				tbli.setText(0, process.getId());
				tbli.setText(1, process.getPath());
			}
		}
		
	}
	

}
