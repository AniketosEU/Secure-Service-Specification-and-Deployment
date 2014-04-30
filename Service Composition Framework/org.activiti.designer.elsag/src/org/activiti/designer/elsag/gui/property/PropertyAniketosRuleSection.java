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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import org.activiti.designer.elsag.dialog.RuleEditorDialog;
import org.activiti.designer.elsag.gui.selectionAdapter.RuleEditorSelectionAdapter;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.apache.log4j.Logger;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.mihalis.opal.dynamictablecolumns.DynamicTable;
import org.mihalis.opal.dynamictablecolumns.DynamicTableColumn;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosRuleSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	static Display display;
	static Composite controlsContainer;
//	static Composite container;
	static Diagram diagram;
	private static Composite parent;
	private static Shell parentShell;
	private static Label labelAdvise;
	
	private static Button createRuleButton;
	
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd-HH-mm-ss";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_TIME_PATTERN);
	
	private static final String FILENAME_PATTERN = "$originalNameWithoutExtension";
	
	private static final String REGEX_DATE_TIME = "\\" + "$dateTime" + "";
	private static final String REGEX_FILENAME = "\\" + "$originalFile" + "";
	private static final String REGEX_FILENAME_WITHOUT_EXTENSION = "\\" + "$originalNameWithoutExtension" + "";
	private static final String REGEX_EXTENSION = "\\" + "$originalExtension" + "";
	
	final private static Logger log = Logger.getLogger(PropertyAniketosRuleSection.class);
	
	public PropertyAniketosRuleSection(){
		controlsContainer = null;
	}
	
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		PropertyAniketosRuleSection.parent = parent;
//		container = new Composite(parent, SWT.NULL);
		display = parent.getDisplay();
		parentShell = parent.getShell();
		GridLayout gridLayout = new GridLayout(1,true);
		parent.setLayout(gridLayout);
		parent.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	}
	
	public static void updateControls() {

		if (controlsContainer != null){
			controlsContainer.dispose();
		}
//		if(container == null){
//			container = new Composite(parent, SWT.NULL);
//			display = container.getDisplay();
//			parentShell = parent.getShell();
//			GridLayout gridLayout = new GridLayout(1,true);
//			container.setLayout(gridLayout);
//			container.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
//		}
		
		controlsContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		controlsContainer.setLayout(layout);
		controlsContainer.setBackground(controlsContainer.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		Label labelLoad = new Label(controlsContainer, SWT.NONE);
		FontData[] fD3 = labelLoad.getFont().getFontData();
		fD3[0].setHeight(14);
		fD3[0].setStyle(SWT.BOLD);
		labelLoad.setFont(new Font(display,fD3[0]));
		labelLoad.setText("Rules for dynamic runtime");
        GridData gridData = new GridData(SWT.LEFT, SWT.FILL, false, false);
        gridData.horizontalSpan= 3;
        gridData.widthHint = 300;
        labelLoad.setLayoutData(gridData);
        labelLoad.setBackground(controlsContainer.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        
        createRuleButton = new Button(controlsContainer, SWT.PUSH);
        createRuleButton.setText("Create a new rule...");
        gridData = new GridData(SWT.LEFT, SWT.FILL, false, false);
        gridData.horizontalSpan= 1;
        createRuleButton.setLayoutData(gridData);
        createRuleButton.addSelectionListener(createRuleListener);
        
        labelAdvise = new Label(controlsContainer, SWT.NONE);
        labelAdvise.setText("You have to generate and select a composition plan before creating a rule");
        gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        gridData.horizontalSpan= 2;
        gridData.widthHint = 400;
        labelAdvise.setLayoutData(gridData);
        labelAdvise.setBackground(controlsContainer.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		Composite rulesComposite = new Composite(controlsContainer, SWT.NONE);
		gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
        gridData.horizontalSpan= 3;
        rulesComposite.setLayoutData(gridData);
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.VERTICAL;
		rulesComposite.setLayout(fillLayout);

		if(!fileExists(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule"))){
			java.util.List<ServiceTask> serviceTasks = getListOfServiceTasks();
			java.util.List<ServiceTask> serviceTasksDiscovered = new Vector<ServiceTask>();
			for(ServiceTask serviceTask : serviceTasks){
				java.util.List<FieldExtension> list = serviceTask.getFieldExtensions();
				
				for(FieldExtension field : list){
					if(field.getFieldname().equals("location")){
						serviceTasksDiscovered.add(serviceTask);
					}
				}
			}
			if(serviceTasks.size() == serviceTasksDiscovered.size()){
				createRuleButton.setEnabled(true);
				labelAdvise.setVisible(false);
			} else {
				createRuleButton.setEnabled(false);
				labelAdvise.setVisible(true);
			}
			parent.layout();
		} else {
			Composite ruleComposite = new Composite(rulesComposite, SWT.NONE);
			GridLayout layoutGrid = new GridLayout(2, false);
			ruleComposite.setLayout(layoutGrid);
			ruleComposite.setBackground(ruleComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

			java.util.List<String> servicesList = getServicesListFromRulesFile();
			for(String serviceTask : servicesList){

        		SAXBuilder builder = new SAXBuilder();

        		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
        		File xmlFile = new File(fileResource.getLocation().toString());
        		try {
        			Document doc = (Document) builder.build(xmlFile);
        			Element rules = doc.getRootElement();
        			
        			Composite titleComposite = new Composite(ruleComposite, SWT.NONE);
	            	GridLayout layoutGrid2 = new GridLayout(2, true);
	            	titleComposite.setLayout(layoutGrid2);
	            	gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
	            	gridData.horizontalSpan= 2;
	            	titleComposite.setLayoutData(gridData);
	            	titleComposite.setBackground(titleComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	            	
	            	Composite tableComposite = new Composite(ruleComposite, SWT.BORDER);
	            	gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
	            	gridData.horizontalSpan= 1;
	            	GridLayout layoutGrid3 = new GridLayout(1, true);
	            	tableComposite.setLayoutData(gridData);
	            	tableComposite.setLayout(layoutGrid3);
	            	tableComposite.setBackground(tableComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

	            	Composite editComposite = new Composite(ruleComposite, SWT.NONE);
	            	gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
	            	gridData.horizontalSpan= 1;
	            	GridLayout layoutGrid4 = new GridLayout(1, true);
	            	editComposite.setLayout(layoutGrid4);
	            	editComposite.setLayoutData(gridData);
	            	editComposite.setBackground(editComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	            	
	            	Label labelTaskName = new Label(titleComposite, SWT.NONE);
	        		FontData[] fD4 = labelTaskName.getFont().getFontData();
	        		fD3[0].setHeight(13);
	        		labelTaskName.setFont(new Font(display,fD4[0]));
	        		String taskId = serviceTask.substring(0,serviceTask.indexOf("-"));
	        		labelTaskName.setText(serviceTask.substring(serviceTask.indexOf("-")+1, serviceTask.length()) + " - " + taskId);
	        		gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
	        		gridData.horizontalSpan= 2;
	        		labelTaskName.setLayoutData(gridData);
	        		labelTaskName.setBackground(titleComposite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        			
        			final DynamicTable tblDyn = new DynamicTable(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
        			gridData = new GridData(SWT.LEFT, SWT.FILL, true, false);
        			gridData.horizontalSpan= 1;
        			gridData.widthHint = 550;
        			tblDyn.setLayoutData(gridData);
        			tblDyn.setHeaderVisible(true);
        			tblDyn.setLinesVisible(true);
        			
        			Button editButton = new Button(editComposite, SWT.PUSH);
	            	editButton.setText("Edit");
	                gridData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
	                gridData.horizontalSpan= 1;
	                editButton.setLayoutData(gridData);
	                editButton.addSelectionListener(new RuleEditorSelectionAdapter(parentShell,tblDyn));
	                
	                Button removeButton = new Button(editComposite, SWT.PUSH);
	                removeButton.setText("Remove");
	                gridData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
	                gridData.horizontalSpan= 1;
	                removeButton.setLayoutData(gridData);
	                removeButton.addSelectionListener(new SelectionListener(){

						@Override
						public void widgetSelected(SelectionEvent e) {
							
							TableItem[] item = tblDyn.getSelection();
							if(item.length==0){
								showErrorMessage("Select a rule to edit");
							} else {
								String ruleId = item[0].getText();
								removeRule(ruleId);
							}
						}

						@Override
						public void widgetDefaultSelected(SelectionEvent e) {
							
							
						}
	                	
	                });
        			
        			DynamicTableColumn tblcId = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcId.setText("ID");
					tblcId.setWidth("25px");

					DynamicTableColumn tblcType = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcType.setText("Type");
					tblcType.setWidth("100px");

					DynamicTableColumn tblcDescription = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcDescription.setText("Description");
					tblcDescription.setWidth("100px");

					DynamicTableColumn tblcValue = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcValue.setText("Value");
					tblcValue.setWidth("100px");

					DynamicTableColumn tblcScope = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcScope.setText("Scope");
					tblcScope.setWidth("100px");

					DynamicTableColumn tblcAction = new DynamicTableColumn(tblDyn, SWT.NONE);
					tblcAction.setText("Action");
					tblcAction.setWidth("100px");

        			@SuppressWarnings("unchecked")
					java.util.List<Element> rulesList = rules.getChildren("rule");
        			for(Element rule : rulesList){
        				String ruleId = rule.getAttributeValue("id");
        				Element service = rule.getChild("service");
        				String taskIdRule = service.getAttributeValue("taskId");
        				if(taskIdRule.equals(taskId)){
        					Element typeE = rule.getChild("type");
        					String type = typeE.getText();
        					String description = rule.getChildText("description");
        					String value = rule.getChildText("value");
        					String comparison = rule.getChild("value").getAttribute("comparison").getValue();
        					Element scopeE = rule.getChild("scope");
        					String scopeTaskId = "";
        					String scopeType = "";
        					if(scopeE!=null){
        						@SuppressWarnings("unchecked")
								java.util.List<Element> scopeList = scopeE.getChildren();
        						for(Element childScope : scopeList){
        							scopeType = childScope.getName();
        							scopeTaskId = childScope.getAttributeValue("taskId");
        						}
        					}
        					Element actionE = rule.getChild("action");
        					@SuppressWarnings("unchecked")
							java.util.List<Element> actionList = actionE.getChildren();
        					String action = "";
        					for(Element childAction : actionList){
        						if(childAction.getName().equals("changeRuntime")){
        							@SuppressWarnings("unchecked")
									java.util.List<Element> list = childAction.getChildren();
        							for(Element actionTypeE : list){
        								String a = actionTypeE.getName();
        								if(a.equals("recompositionAndReconfiguration")){
        									action = "recomposition and reconfiguration";
        								} else {
        									action = a;
        								}
        							}
        						} else {

        						}
        					}

        					TableItem tbli = new TableItem(tblDyn, SWT.NONE);
        					tbli.setText(0, ruleId);
        					tbli.setText(1, type);
        					if(description!=null){
        						tbli.setText(2, description);
        					} else {
        						tbli.setText(2, " ");
        					}
        					tbli.setText(3, comparison+value);
        					if(scopeE!=null){
        						tbli.setText(4, scopeType + " " + scopeTaskId);
        					} else {
        						tbli.setText(4, "no scope");
        					}

        					tbli.setText(5, action);
        					tblDyn.layout();
        				}
        			}



        		} catch (IOException e) {
        			log.error(e);
        		} catch (JDOMException e) {
        			log.error(e);
        		}
        		
        	}
			java.util.List<ServiceTask> serviceTasks = getListOfServiceTasks();
			java.util.List<ServiceTask> serviceTasksDiscovered = new Vector<ServiceTask>();
			for(ServiceTask serviceTask : serviceTasks){
				java.util.List<FieldExtension> list = serviceTask.getFieldExtensions();
				
				for(FieldExtension field : list){
					if(field.getFieldname().equals("location")){
						serviceTasksDiscovered.add(serviceTask);
					}
				}
			}
			if(serviceTasks.size() == serviceTasksDiscovered.size()){
				createRuleButton.setEnabled(true);
				labelAdvise.setVisible(false);
			} else {
				createRuleButton.setEnabled(false);
				labelAdvise.setVisible(true);
			}

			parent.layout();
        }
	}

	@Override
	public void refresh() {
		updateControls();
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		diagram = getDiagram();
		
		RuleEditorSelectionAdapter.setDiagram(diagram);	
		updateControls();
	}
	
	private static SelectionListener createRuleListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			RuleEditorDialog dialog = new RuleEditorDialog(display, diagram);
			dialog.createContents(null);
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	private static boolean fileExists(final URI uri){

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IFile file = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));

		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected static URI getRelativeURIForDiagram(final Diagram diagram, final String relativePath) {
		final URI originalURI = getResourceForDiagram(diagram).getURI();

		String finalSegment = relativePath;
		final URI parentURI = originalURI.trimSegments(1);

		// Parse any replacement variables in the filename
		final Calendar now = Calendar.getInstance();

		finalSegment = finalSegment.replaceAll(REGEX_DATE_TIME, SDF.format(now.getTime()));
		finalSegment = finalSegment.replaceAll(REGEX_EXTENSION, originalURI.fileExtension());
		finalSegment = finalSegment.replaceAll(REGEX_FILENAME, originalURI.lastSegment());
		finalSegment = finalSegment.replaceAll(REGEX_FILENAME_WITHOUT_EXTENSION, originalURI.trimFileExtension().lastSegment());

		return parentURI.appendSegment(finalSegment);
	}
	
	protected static Resource getResourceForDiagram(final Diagram diagram) {
		return diagram.eResource();
	}
	
	public static java.util.List<String> getServicesListFromRulesFile(){
		SAXBuilder builder = new SAXBuilder();

		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
		File xmlFile = new File(fileResource.getLocation().toString());
		java.util.List<String> servicesList = new Vector<String>();
		try {
			Document doc = (Document) builder.build(xmlFile);
			Element rules = doc.getRootElement();
			@SuppressWarnings("unchecked")
			java.util.List<Element> rulesList = rules.getChildren("rule");
			for(Element rule : rulesList){
				Element service = rule.getChild("service");
				String taskName = service.getAttributeValue("taskName");
				String taskId = service.getAttributeValue("taskId");
				if(!servicesList.contains(taskId + "-" + taskName)){
					servicesList.add(taskId + "-" + taskName);
				}
			}
		} catch (IOException e) {
			log.error(e);
		} catch (JDOMException e) {
			log.error(e);
		}
		return servicesList;
	}
	

	private static void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), "Rule editor",message);
			}
		});

	}
	
	private static void removeRule(String ruleId){
		SAXBuilder builder = new SAXBuilder();

		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
		File xmlFile = new File(fileResource.getLocation().toString());
		try {
			Document doc = (Document) builder.build(xmlFile);

			Element rules = doc.getRootElement();

			@SuppressWarnings("unchecked")
			java.util.List<Element> rulesList = rules.getChildren("rule");

			for(Element r : rulesList){
				String idString = r.getAttribute("id").getValue();
				if(idString.equals(ruleId)){
					rules.removeContent(r);
					break;
				}
			}
			
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());

			xmlOutput.output(doc, new FileWriter(fileResource.getLocation().toString()));

		} catch (IOException e) {
			log.error(e);
		} catch (JDOMException e) {
			log.error(e);
		}
		
		updateControls();
	}
	
	private static java.util.List<ServiceTask> getListOfServiceTasks(){

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
