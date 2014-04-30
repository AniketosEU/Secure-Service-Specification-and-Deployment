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
package org.activiti.designer.elsag.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.activiti.designer.elsag.xml.XMLParser;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.data.impl.AgreementTemplate;
import eu.aniketos.scf.data.impl.CompositionPlan;
import eu.aniketos.scf.data.impl.ConsumerPolicy;
import eu.aniketos.scf.data.impl.Service;
import eu.aniketos.scpm.userinterface.views.ScpmUI;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class CompositionPlansDialog {
	
	private Diagram diagram;
	private Display display;
	private String processId;
	private IWorkbenchPage page;
	
	public CompositionPlansDialog(Display display, Diagram diagram, String processId, IWorkbenchPage page) {
		this.display = display;
		this.diagram = diagram;
		this.processId = processId;
		this.page = page;
	}

	public void createContents() {
		
		final Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setText("Create Composition Plans");

		final Composite composite = new Composite(shell, SWT.NONE);
		final FormLayout formLayout= new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		composite.setLayout(formLayout);

		FormData data;
		
		final Text aTemplatePathText = new Text(composite, SWT.BORDER);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(60, 0);
	    data.top = new FormAttachment(0, 20);
	    aTemplatePathText.setLayoutData(data);

	    Button aTemplateButton = new Button(composite, SWT.BUTTON1);
	    aTemplateButton.setText("Select desired Agreement Template");
	    data = new FormData();
	    data.left = new FormAttachment(aTemplatePathText, 10);
	    data.top = new FormAttachment(0, 20);
	    aTemplateButton.setLayoutData(data);
	    aTemplateButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		FileDialog dialog = new FileDialog(shell, SWT.NULL);
	    		String[] extension = new String[1];
	    		extension[0] = "*.xml";
	    		dialog.setFilterExtensions(extension);
	    		String path = dialog.open();
	    		if (path != null) {

	    			File file = new File(path);
	    			if (file.isFile())
	    				displayFiles(new String[] { file.toString()});
	    			else
	    				displayFiles(file.list());

	    		}
	    	}
	    	
	    	private void displayFiles(String[] files) {
	    		for (int i = 0; files != null && i < files.length; i++) {
	    			aTemplatePathText.setText(files[i]);
	    			aTemplatePathText.setEditable(true);
	    		}
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    final Text cPolicyPathText = new Text(composite, SWT.BORDER);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(60, 0);
	    data.top = new FormAttachment(aTemplatePathText, 20);
	    cPolicyPathText.setLayoutData(data);

	    Button cPolicyButton = new Button(composite, SWT.BUTTON1);
	    cPolicyButton.setText("Select Consumer Policy");
	    data = new FormData();
	    data.left = new FormAttachment(cPolicyPathText, 10);
	    data.top = new FormAttachment(aTemplatePathText, 20);
	    cPolicyButton.setLayoutData(data);
	    cPolicyButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		FileDialog dialog = new FileDialog(shell, SWT.NULL);
	    		String[] extension = new String[1];
	    		extension[0] = "*.xml";
	    		dialog.setFilterExtensions(extension);
	    		String path = dialog.open();
	    		if (path != null) {

	    			File file = new File(path);
	    			if (file.isFile())
	    				displayFiles(new String[] { file.toString()});
	    			else
	    				displayFiles(file.list());

	    		}
	    	}
	    	
	    	private void displayFiles(String[] files) {
	    		for (int i = 0; files != null && i < files.length; i++) {
	    			cPolicyPathText.setText(files[i]);
	    			cPolicyPathText.setEditable(true);
	    		}
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    Button createButton = new Button(composite, SWT.BUTTON1);
	    createButton.setText("Create");
	    data = new FormData();
	    data.left = new FormAttachment(50, -75);
	    data.right = new FormAttachment(50, 75);
	    data.top = new FormAttachment(cPolicyPathText, 20);
	    createButton.setLayoutData(data);
	    createButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		final String agreementPath = aTemplatePathText.getText();
	    		final String policyPath = cPolicyPathText.getText();
	    		Job job = new Job("Creating the composition plans") {

	    			protected IStatus run(IProgressMonitor monitor) {
	    				Display.getDefault().syncExec(new Runnable() {
	    					public void run() {
	    						page.saveAllEditors(true);
	    					}
	    				});
	    				
	    				
	    				ServiceCompositionFrameworkInterface scf = org.activiti.designer.elsag.Activator.getDefault().getServiceCompositionFramework();
	    				URI uri = diagram.eResource().getURI();
	    				URI bpmnUri = uri.trimFragment();
	    				bpmnUri = bpmnUri.trimFileExtension();
	    				bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");
	    				
	    				URI activitiUri = uri.trimFragment();
	    				activitiUri = activitiUri.trimFileExtension();
	    				activitiUri = activitiUri.appendFileExtension("activiti");
	    				
	    				String activitiPlatformString = activitiUri.toPlatformString(true);
	    				IResource fileActivitiResource = ResourcesPlugin.getWorkspace().getRoot().findMember(activitiPlatformString);
	    				
	    				ServiceTask task = null;

	    				String platformString = bpmnUri.toPlatformString(true);
	    				IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
	    				if(fileResource != null){
	    					if(ScpmUI.getUI()!=null){
	    						String serviceSpecification = "";
	    						try{
	    							serviceSpecification = XMLParser.convertXMLFileToString(fileResource.getLocation().toString());
	    						}catch(IOException e){
	    							e.printStackTrace();
	    						}

	    						ICompositionPlan compositionPlan = new CompositionPlan(serviceSpecification);

	    						compositionPlan.setCompositionPlanID(processId);

	    						if(org.activiti.designer.elsag.data.Data.hashTableLocationsProcess != null){
	    							Map<String,Set<Service>> hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
	    								if(hashTableLocations != null){
	    									
	    									List<String> serviceTasksDiscovered = new Vector<String>();
	    									EList<PictogramLink> list = diagram.getPictogramLinks();
	    									for(PictogramLink link : list){
	    										EList<EObject> elist = link.getBusinessObjects();
	    										for(EObject ob : elist){
	    											if(ob instanceof ServiceTask){
	    												task = (ServiceTask) ob;
	    												if(!serviceTasksDiscovered.contains(task.getId())){
	    													serviceTasksDiscovered.add(task.getId());

	    													List<FieldExtension> listField = task.getFieldExtensions();
	    													
	    													String operationField = "";
	    													String inputTypeField = "";
	    													String outputTypeField = "";
	    													
	    													for(FieldExtension field : listField){
	    														if(field.getFieldname().equals("operation")){
	    															operationField = field.getExpression();

	    														}
	    														if(field.getFieldname().equals("inputType")){
	    															inputTypeField = field.getExpression();
	    														}
	    														if(field.getFieldname().equals("outputType")){
	    															outputTypeField = field.getExpression();
	    														}
	    													}
	    													
	    													
	    													String input = "";
	    													while(inputTypeField.contains(",")){
	    														input = input + inputTypeField.substring(0,inputTypeField.indexOf(","));
	    														inputTypeField = inputTypeField.substring(inputTypeField.indexOf(",")+2, inputTypeField.length());
	    													}
	    													input = input + inputTypeField;
	    													
	    													String offset = input+"O"+outputTypeField;
	    													
	    													
	    													Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
	    													
	    													Hashtable<String, Set<Service>> hashOperation = hashTableTaskOperations.get(task.getId());
	    													
	    													try{
	    														Set<Service> services = hashOperation.get(operationField+offset);
	    														hashTableLocations.put(task.getId(), services);

	    														org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,(Hashtable<String,Set<Service>>)hashTableLocations);
	    													}catch(NullPointerException e){
	    														showErrorMessage("Discover each service task and select a valid operation");
	    														closeShell(shell);
	    														return Status.CANCEL_STATUS;
	    													}
	    													
	    												
	    													
	    												}
	    											}
	    										}
	    									}

	    									Set<String> keys = hashTableLocations.keySet();
	    									Vector<String> tasksToBeRemoved = new Vector<String>();
											for(String key : keys){
												Set<Service> actualServices = hashTableLocations.get(key);
												if(actualServices.isEmpty()){
													tasksToBeRemoved.add(key);
												}
											}
											
											for(String taskToBeRemoved : tasksToBeRemoved){
												hashTableLocations.remove(taskToBeRemoved);
											}
	    									final List<ICompositionPlan> listCompositionPlan = scf.createCompositionPlans(compositionPlan, hashTableLocations);
	    									for(ICompositionPlan plan : listCompositionPlan){
	    										org.activiti.designer.elsag.data.Data.compositionPlans.add(plan.getCompositionPlanID());
	    									}

	    									final ScpmUI scpmUI = ScpmUI.getUI();
	    									Display.getDefault().syncExec(new Runnable() {
	    										public void run(){
	    											scpmUI.clearCompositionPlans();
	    										}
	    									});									

	    									for(final ICompositionPlan composition : listCompositionPlan){

//	    										final List<IAgreementTemplate> agreementTemplates = scf.getAgreementTemplates(composition);
	    										final IAgreementTemplate agreementTemplate = new AgreementTemplate("id");
	    										try{
	    											agreementTemplate.setXML(XMLParser.convertXMLFileToString(agreementPath));
	    										} catch (IOException e){
	    											showErrorMessage("Select a valid Agreement Template file");
	    											return Status.CANCEL_STATUS;
	    										}
	    										final IConsumerPolicy consumerPolicy = new ConsumerPolicy();
	    										try{
	    											consumerPolicy.setXML(XMLParser.convertXMLFileToString(policyPath));
	    										} catch (IOException e){
	    											showErrorMessage("Select a valid Consumer Policy file");
	    											return Status.CANCEL_STATUS;
	    										}
	    										String activitiFileString = "";
	    										try {
													activitiFileString = XMLParser.convertXMLFileToString(fileActivitiResource.getLocation().toString());
												} catch (IOException e) {
													return Status.CANCEL_STATUS;
												}
	    										composition.setActivitiFile(activitiFileString);

	    										Display.getDefault().syncExec(new Runnable() {
	    											public void run(){
	    												
//	    												scpmUI.saveCompositionPlan(composition, agreementTemplate,consumerPolicy);
	    											}
	    										});	

	    									}

	    									if(listCompositionPlan.size()>0){
	    										showOkMessage(listCompositionPlan.size(), shell);
	    										return Status.OK_STATUS;

	    									} else {
	    										Display.getDefault().syncExec(new Runnable() {
	    										    public void run(){
//	    										    	PropertyAniketosPlanningSection.setTextPropertyLabel("Composition Plans not created");
//	    										    	PropertyAniketosPlanningSection.setVisiblePropertyLabel(true);
	    										      }
	    										    });
	    										showErrorMessage("Some errors occured trying to create the composition plans. Try restarting the SCF");
	    										closeShell(shell);
	    										return Status.CANCEL_STATUS;
	    									}
	    								} else {
	    									showErrorMessage("An error has occured trying to create the composition plans. You must discover all the services");
	    									closeShell(shell);
	    									return Status.CANCEL_STATUS;
	    								}
	    						} else {
	    							showErrorMessage("An error has occured trying to create the composition plans. You must discover all the services");
	    							closeShell(shell);
	    							return Status.CANCEL_STATUS;
	    						}
	    					} else {
	    						showErrorMessage("An error has occured trying to create the composition plans. You have to open the SCPM View");
	    						closeShell(shell);
	    						return Status.CANCEL_STATUS;
	    					}
	    				} else{
	    					showErrorMessage("Xml file not yet created. Save the diagram");
	    					closeShell(shell);
	    					return Status.CANCEL_STATUS;
	    				}
	    			}
	    		};
	    		job.setUser(true);
	    		job.schedule();
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    shell.setSize(600, 200);
	    final Toolkit toolkit = Toolkit.getDefaultToolkit();
	    final Dimension screenSize = toolkit.getScreenSize();
	    final int x = (screenSize.width - 600) / 2;
	    final int y = (screenSize.height - 200) / 2;
	    shell.setLocation(x, y);
	    shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch())
	    		display.sleep();
	    }

	    shell.dispose();
	}

	private void showOkMessage(final int number, final Shell shell) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				if(number == 1){
					MessageDialog.open(MessageDialog.INFORMATION, display.getActiveShell(), "Creating composition plans",
							"Created "+number+" composition plan", SWT.NONE);
				} else {
					MessageDialog.open(MessageDialog.INFORMATION, display.getActiveShell(), "Creating composition plans",
							"Created "+number+" composition plans", SWT.NONE);
				}
				shell.close();
			}
		});
	}

	private void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), "Creating composition plans",message);
			}
		});

	}
	
	private void closeShell(final Shell shell){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				shell.close();
			}
		});
	}

}

