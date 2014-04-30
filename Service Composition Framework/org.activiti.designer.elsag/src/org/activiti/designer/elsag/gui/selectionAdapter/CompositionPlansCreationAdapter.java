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
package org.activiti.designer.elsag.gui.selectionAdapter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.wsdl.WSDLException;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.wsdl.WsdlParser;
import org.activiti.designer.elsag.xml.XMLParser;
import org.apache.log4j.Logger;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.ServiceQuery;
import eu.aniketos.scf.data.impl.AgreementTemplate;
import eu.aniketos.scf.data.impl.CompositionPlan;
import eu.aniketos.scf.data.impl.ConsumerPolicy;
import eu.aniketos.scf.data.impl.Service;
import eu.aniketos.scpm.userinterface.views.ScpmUI;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class CompositionPlansCreationAdapter extends SelectionAdapter{
	
	private final Shell shell;
	private static Diagram diagram;
	private static String processId;
	private IWorkbenchPage page;
	
	final private static Logger log = Logger.getLogger(CompositionPlansCreationAdapter.class);

	public CompositionPlansCreationAdapter(Shell shell, IWorkbenchPage page) {
		this.shell = shell;
		this.page = page;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		page.saveAllEditors(false);

		final boolean response = MessageDialog.openQuestion(shell, "Creating composition plans","Do you want to discover again all the services?");
		BusyIndicator.showWhile(PlatformUI.getWorkbench().getDisplay(), new Runnable() {
			public void run() {
				if(response){
					Job job = discoverAllServices();
					while(job.getResult() == null){

					}
					if(job.getResult().isOK())
						createCompositionPlans();
				} else {
					createCompositionPlans();
				
				}
			}
			});
		

	}
	
	public IStatus createCompositionPlans(){
		log.debug("Creating the composition plans");
		
		Job job = new Job("Creating the composition plans") {

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Creating the composition plans", 100);
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
														monitor.subTask("Checking if services have been discovered");
														monitor.worked(20);
														Set<Service> services = hashOperation.get(operationField+offset);
														hashTableLocations.put(task.getId(), services);

														org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,(Hashtable<String,Set<Service>>)hashTableLocations);
													}catch(NullPointerException e){
														showErrorMessage("Discover each service task and select a valid operation");
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
									monitor.subTask("Creating composition Plans");
									monitor.worked(20);
									final List<ICompositionPlan> listCompositionPlan = scf.createCompositionPlans(compositionPlan, hashTableLocations);
									for(ICompositionPlan plan : listCompositionPlan){
										org.activiti.designer.elsag.data.Data.compositionPlans.add(plan.getCompositionPlanID());
									}
									
									final IFolder folder = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf("."))).getFolder("CompositionPlans");
									try {
										if(folder!=null){
											IResource[] resource = folder.members();
											for(int i = 0; i<resource.length; i++){
												IEditorReference[] references = page.getEditorReferences();
												for(int j=0; j < references.length; j++){
													references[j].getEditor(true);
												}
												resource[i].delete(true, null);
											}
											log.debug("CompositionPlans folder emptied");
										}
									} catch (CoreException e) {
										log.error("CompositionPlans folder does not exist");
									}
									
									final ScpmUI scpmUI = ScpmUI.getUI();
									Display.getDefault().syncExec(new Runnable() {
										public void run(){
											scpmUI.clearCompositionPlans();
										}
									});		
									
									log.debug("Taking the Consumer Policies during plans creations");
									IFolder folderConsumerPolicies = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf("."))).getFolder("ConsumerPolicies");
									IResource[] files;
									String[] consumerPolicies = new String[0];
									try {
										files = folderConsumerPolicies.members();
										consumerPolicies = new String[files.length];
										for(int i=0; i<files.length; i++){
											String consumerPolicy = XMLParser.convertXMLFileToString(files[i].getLocation().toString());
											consumerPolicies[i] = consumerPolicy;
											log.debug("ConsumerPolicy found: "+consumerPolicy);
										}
									} catch (CoreException e1) {
										log.error(e1);
									} catch (IOException e1) {
										log.error(e1);
									}
									
									final IConsumerPolicy consumerPolicy = new ConsumerPolicy();

									for(final ICompositionPlan composition : listCompositionPlan){

										final IAgreementTemplate agreementTemplate = new AgreementTemplate("id");
										agreementTemplate.setXML("");
										
										consumerPolicy.setXmlContents(consumerPolicies);

										String activitiFileString = "";
										try {
											activitiFileString = XMLParser.convertXMLFileToString(fileActivitiResource.getLocation().toString());
										} catch (IOException e) {
											return Status.CANCEL_STATUS;
										}
										composition.setActivitiFile(activitiFileString);
										monitor.subTask("Updating UI");
										monitor.worked(60);

										Display.getDefault().syncExec(new Runnable() {
											public void run(){
												scpmUI.saveCompositionPlan(composition,folder.getLocation().toString());
											}
										});	

									}

									if(listCompositionPlan.size()>0){
										showOkMessage(listCompositionPlan.size(), shell);
										return Status.OK_STATUS;

									} else {
										showErrorMessage("Some errors occured trying to create the composition plans. Try restarting the SCF");
										return Status.CANCEL_STATUS;
									}
								} else {
									showErrorMessage("An error has occured trying to create the composition plans. You must discover all the services");
									return Status.CANCEL_STATUS;
								}
						} else {
							showErrorMessage("An error has occured trying to create the composition plans. You must discover all the services");
							return Status.CANCEL_STATUS;
						}
					} else {
						showErrorMessage("An error has occured trying to create the composition plans. You have to open the SCPM View");
						return Status.CANCEL_STATUS;
					}
				} else{
					showErrorMessage("Xml file not yet created. Save the diagram");
					return Status.CANCEL_STATUS;
				}
			}
		};
		job.setUser(true);
		job.schedule();
		
		return job.getResult();
	}
	
	public Job discoverAllServices(){
		log.debug("Discovering services in the Marketplace for all the service tasks");
		Job job = new Job("Discovering services in the Marketplace for all the service tasks") {

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Discovering services in the Marketplace for all the service tasks", 100);
				ServiceCompositionFrameworkInterface scf = org.activiti.designer.elsag.Activator.getDefault().getServiceCompositionFramework();
				URI uri = diagram.eResource().getURI();
				URI bpmnUri = uri.trimFragment();
				bpmnUri = bpmnUri.trimFileExtension();
				bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");

				String platformString = bpmnUri.toPlatformString(true);
				IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
				if(fileResource != null){
					boolean discovered = true;
					ServiceTask task = null;
					List<String> serviceTasksDiscovered = new Vector<String>();
					EList<PictogramLink> list = diagram.getPictogramLinks();
					List<List<String>> servicesNotDiscovered = new Vector<List<String>>();
					for(PictogramLink link : list){
						EList<EObject> elist = link.getBusinessObjects();
						for(EObject ob : elist){
							if(ob instanceof ServiceTask){
								task = (ServiceTask) ob;
								if(!serviceTasksDiscovered.contains(task.getId())){
									String taskId = task.getId();
									
									Hashtable<String,Set<Service>> hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
									if(hashTableLocations == null){
										hashTableLocations = new Hashtable<String,Set<Service>>();
									}
									
									Set<Service> setOld = hashTableLocations.get(taskId);
									if(setOld != null){
										hashTableLocations.put(taskId, setOld);
										org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId, hashTableLocations);
									} else {
										hashTableLocations.put(taskId, new HashSet<Service>());
										org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId, hashTableLocations);
									}
									
									Hashtable<String,Hashtable<String,List<List<String>>>> hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
									if(hashTableTaskOperationInputType == null){
										hashTableTaskOperationInputType = new Hashtable<String,Hashtable<String,List<List<String>>>>();
									}
									Hashtable<String,List<List<String>>> hashTableInputTypeOld = hashTableTaskOperationInputType.get(taskId);
									if(hashTableInputTypeOld != null){
										hashTableTaskOperationInputType.put(taskId, hashTableInputTypeOld);
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);
									} else {
										hashTableTaskOperationInputType.put(taskId, new Hashtable<String,List<List<String>>>());
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);
									}
									
									Hashtable<String,Hashtable<String,List<String>>> hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
									if(hashTableTaskOperationOutputType == null){
										hashTableTaskOperationOutputType = new Hashtable<String,Hashtable<String,List<String>>>();
									}
									Hashtable<String, List<String>> hashTableOperationOutputTypeOld = hashTableTaskOperationOutputType.get(taskId);
									if(hashTableOperationOutputTypeOld != null){
										hashTableTaskOperationOutputType.put(taskId, hashTableOperationOutputTypeOld);
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.put(processId, hashTableTaskOperationOutputType);
									} else {
										hashTableTaskOperationOutputType.put(taskId, new Hashtable<String, List<String>>());
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.put(processId, hashTableTaskOperationOutputType);
									}
									
									Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
									if(hashTableTaskOperations == null){
										hashTableTaskOperations = new Hashtable<String,Hashtable<String,Set<Service>>>();
									}
									Hashtable<String,Set<Service>> hashTableOld = hashTableTaskOperations.get(taskId);
									if(hashTableOld != null){
										hashTableTaskOperations.put(taskId, hashTableOld);
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
									} else {
										hashTableTaskOperations.put(taskId, new Hashtable<String,Set<Service>>());
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
									}
									monitor.subTask("Connecting to the Marketplace");
									monitor.worked(20);
									
									Hashtable<String, Set<Service>> hashOperations = new Hashtable<String, Set<Service>>();
									List<FieldExtension> fieldExtensions = task.getFieldExtensions();
									for(FieldExtension field : fieldExtensions){
										if(field.getFieldname().equals("type")){
											String type = field.getExpression();
											String secReq = "";
											if(!type.equals("")){
												ServiceQuery serviceQuery = new ServiceQuery(type, secReq);
												Set<Service> servicesDiscovered = null;
												try{
													
													log.debug("Connecting to the SCF bundle");
													Properties prop = Activator.getConfigProperties();
													scf.setProxy(prop.getProperty("proxyHost"), prop.getProperty("proxyPort"),prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));
													servicesDiscovered = scf.discoverServices(serviceQuery, prop.getProperty("MarketplaceAddress"));
													log.debug("Services discovered");
												}catch(javax.xml.ws.WebServiceException ex) {
													log.error("Unable to connect to the Marketplace");
													showErrorMessage("Unable to connect to the Marketplace");
													System.out.println("Unable to connect to the Marketplace");
													System.out.println(ex);
													return Status.CANCEL_STATUS;
												}
												Set<String> locations = new HashSet<String>();
												
												if(servicesDiscovered.size() == 0){
													List<String> typeAndId = new Vector<String>();
													typeAndId.add(0,type);
													typeAndId.add(1,taskId);
													typeAndId.add(2,task.getName());
													boolean contains = false;
													for(List<String> service : servicesNotDiscovered){
														if(service.get(1).equals(taskId))
															contains = true;
													}
													if(!contains)
														servicesNotDiscovered.add(typeAndId);
													break;
												}

												for(Service service : servicesDiscovered){
													locations.add(service.getLocation());
												}
				
												hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
												hashTableLocations.put(task.getId(), servicesDiscovered);
												org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,(Hashtable<String,Set<Service>>)hashTableLocations);
												serviceTasksDiscovered.add(task.getId());
												
												if(locations.size()>0){
													log.debug("Discovered " + locations.size() +" services for "+ type);
													
													log.debug("Locations:");
													

													Hashtable<String, List<List<String>>> hashTableOperationInputType = new Hashtable<String, List<List<String>>>();
													Hashtable<String, List<String>> hashTableOperationOutputType = new Hashtable<String, List<String>>();
													
													
													String[] labels = null;
													List<String> operations = new Vector<String>();
													String errorMsg = "";
													Iterator<Service> it = servicesDiscovered.iterator();
													while(it.hasNext()){
														Service service = it.next();
														String location = service.getLocation();
														log.debug("--- "+location);
					
														List<String> listOperations = new Vector<String>();
														try {
															listOperations = WsdlParser.getInstance().getOperations(location);
														} catch (WSDLException e) {
															if(errorMsg.startsWith("Unable to")){
																errorMsg = errorMsg + location + "\n";
															} else {
																errorMsg = "Unable to reach WSDL at location: \n" +
																		location +"\n";
															}
															it.remove();
														}

														List<String> inputTypes = null;
														String outputType = null;

														for(int i = 0; i<listOperations.size(); i++){
															inputTypes = WsdlParser.getInstance().getInputTypes(location, listOperations.get(i));
															outputType = WsdlParser.getInstance().getOutputTypes(location, listOperations.get(i));
															
															List<List<String>> actualInputTypes = hashTableOperationInputType.get(listOperations.get(i));
															List<String> actualOutputTypes = hashTableOperationOutputType.get(listOperations.get(i));

															if(actualInputTypes == null){
																actualInputTypes = new Vector<List<String>>();
															}

															if(actualOutputTypes == null){
																actualOutputTypes = new Vector<String>();
															}

															if(outputType.equals("")){
																outputType = "void";
															}

															if(!actualInputTypes.contains(inputTypes) && !actualOutputTypes.contains(outputType)){
																actualInputTypes.add(inputTypes);
																//    									hashTableOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputType.get(task.getId());
																hashTableOperationInputType.put(listOperations.get(i), actualInputTypes);
																hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
																hashTableTaskOperationInputType.put(taskId, hashTableOperationInputType);
																org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);

																actualOutputTypes.add(outputType);
																//										hashTableOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputType.get(task.getId());
																hashTableOperationOutputType.put(listOperations.get(i), actualOutputTypes);
																hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
																hashTableTaskOperationOutputType.put(taskId, hashTableOperationOutputType);
																org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.put(processId, hashTableTaskOperationOutputType);

																String offset = "";
																for(String inputType : inputTypes){
																	offset = offset+inputType;
																}
																offset = offset + "O" + outputType;

																if(hashOperations.containsKey(listOperations.get(i)+offset)){
																	Set<Service> services = hashOperations.get(listOperations.get(i)+offset);
																	Set<String> locs = new HashSet<String>();
																	for(Service s : services){
																		String l = s.getLocation();
																		locs.add(l);
																	}
																	if(!locs.contains(location)){
																		services.add(service);
																		hashOperations.put(listOperations.get(i)+offset, services);
																		hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																		hashTableTaskOperations.put(taskId, hashOperations);
																		org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																	}
																} else {
																	Set<Service> services = new HashSet<Service>();
																	services.add(service);
																	hashOperations.put(listOperations.get(i)+offset, services);
																	hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																	hashTableTaskOperations.put(taskId, hashOperations);
																	org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																}

																operations.add(listOperations.get(i));

															} else if (!actualInputTypes.contains(inputTypes) && actualOutputTypes.contains(outputType)){
																actualInputTypes.add(inputTypes);
																//    									hashTableOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputType.get(task.getId());
																hashTableOperationInputType.put(listOperations.get(i), actualInputTypes);
																hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
																hashTableTaskOperationInputType.put(taskId, hashTableOperationInputType);
																org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);

																String offset = "";
																for(String inputType : inputTypes){
																	offset = offset+inputType;
																}
																offset = offset + "O" + outputType;

																if(hashOperations.containsKey(listOperations.get(i)+offset)){
																	Set<Service> services = hashOperations.get(listOperations.get(i)+offset);
																	Set<String> locs = new HashSet<String>();
																	for(Service s : services){
																		String l = s.getLocation();
																		locs.add(l);
																	}
																	if(!locs.contains(location)){
																		services.add(service);
																		hashOperations.put(listOperations.get(i)+offset, services);
																		hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																		hashTableTaskOperations.put(taskId, hashOperations);
																		org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																	}
																} else {
																	Set<Service> services = new HashSet<Service>();
																	services.add(service);
																	hashOperations.put(listOperations.get(i)+offset, services);
																	hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																	hashTableTaskOperations.put(taskId, hashOperations);
																	org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																}

																operations.add(listOperations.get(i));

															} else if (actualInputTypes.contains(inputTypes) && !actualOutputTypes.contains(outputType)){
																actualOutputTypes.add(outputType);
																//										hashTableOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputType.get(task.getId());
																hashTableOperationOutputType.put(listOperations.get(i), actualOutputTypes);
																hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
																hashTableTaskOperationOutputType.put(taskId, hashTableOperationOutputType);

																String offset = "";
																for(String inputType : inputTypes){
																	offset = offset+inputType;
																}
																offset = offset + "O" + outputType;

																if(hashOperations.containsKey(listOperations.get(i)+offset)){
																	Set<Service> services = hashOperations.get(listOperations.get(i)+offset);
																	Set<String> locs = new HashSet<String>();
																	for(Service s : services){
																		String l = s.getLocation();
																		locs.add(l);
																	}
																	if(!locs.contains(location)){
																		services.add(service);
																		hashOperations.put(listOperations.get(i)+offset, services);
																		hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																		hashTableTaskOperations.put(taskId, hashOperations);
																		org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																	}
																} else {
																	Set<Service> services = new HashSet<Service>();
																	services.add(service);
																	hashOperations.put(listOperations.get(i)+offset, services);
																	hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																	hashTableTaskOperations.put(taskId, hashOperations);
																	org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																}

																operations.add(listOperations.get(i));

															} else {
																String offset = "";
																for(String inputType : inputTypes){
																	offset = offset+inputType;
																}
																offset = offset + "O" + outputType;
																if(hashOperations.containsKey(listOperations.get(i)+offset)){
																	Set<Service> services = hashOperations.get(listOperations.get(i)+offset);
																	Set<String> locs = new HashSet<String>();
																	for(Service s : services){
																		String l = s.getLocation();
																		locs.add(l);
																	}
																	if(!locs.contains(location)){
																		services.add(service);
																		hashOperations.put(listOperations.get(i)+offset, services);
																		hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																		hashTableTaskOperations.put(taskId, hashOperations);
																		org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																	}
																} else {
																	Set<Service> services = new HashSet<Service>();
																	services.add(service);
																	hashOperations.put(listOperations.get(i)+offset, services);
																	hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
																	hashTableTaskOperations.put(taskId, hashOperations);
																	org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
																}

																operations.add(listOperations.get(i));
															}


														}

														

													}
													monitor.subTask("Parsing WSDL files");
													monitor.worked(60);

													hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
													hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
													Set<String>  setOperations = hashTableTaskOperationInputType.get(taskId).keySet();
													Object[] operationsArray = setOperations.toArray();
													int size = 0;

													size = hashOperations.size();
													if(!errorMsg.equals("")){
														showErrorMessage(errorMsg);
													}
													if(size == 0){
														List<String> typeAndId = new Vector<String>();
														typeAndId.add(0,type);
														typeAndId.add(1,taskId);
														typeAndId.add(2,task.getName());
														servicesNotDiscovered.add(typeAndId);
														
													}

													labels = new String[size];

													Hashtable<String,String> hashLabel = new Hashtable<String,String>();

													for(int j=0; j<operationsArray.length; j++){
														List<List<String>> inputT = hashTableTaskOperationInputType.get(taskId).get(operationsArray[j]);

														List<String> outputT = hashTableTaskOperationOutputType.get(taskId).get(operationsArray[j]);

														for(List<String> list1 : inputT){
															String inputTypeString = "";
															Iterator<String> iterator = list1.iterator();
															while(iterator.hasNext()){
																inputTypeString = inputTypeString + iterator.next();
																if(iterator.hasNext()){
																	inputTypeString = inputTypeString + ", ";
																}
															}

															for(String outputString : outputT){
																if(outputString.equals("")){
																	outputString = "void";
																}
																String stringValue = operationsArray[j] + " (input: " + inputTypeString + ")" + " (output: " + outputString + ")";
																hashLabel.put(stringValue, stringValue);
															}

														}
													}

													Set<String> keys = hashLabel.keySet();
													int cont = 0;
													for(String key : keys){
														labels[cont] = hashLabel.get(key);
														cont++;
													}
													
													Hashtable<String,Set<Service>> hashTableLocations1 = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);

													hashTableLocations1.put(taskId, servicesDiscovered);
													org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,hashTableLocations1);

												}
											}
										}
									}
						
								}
							}
						}
					}
					if(serviceTasksDiscovered.size() == getListOfServiceTasks().size() && servicesNotDiscovered.size() == 0){
						monitor.subTask("Services Discovered");
						monitor.worked(20);
						monitor.done(); 
						log.debug("All the services have been successfully discovered");
						return Status.OK_STATUS;
					} else if(discovered){
						String message = "";
						for(List<String> service : servicesNotDiscovered){
							String type = service.get(0);
							String id = service.get(1);
							String name = service.get(2);
							message = message + "Id:" + id + " Name: " + name + " Type: " + type + " \n";
						}
						showErrorMessage("Unable to find services for the following Service Tasks:\n" +
								message + "\n\n" +
								"Check the types and click again on the \"Create composition plans\" button");
						return Status.CANCEL_STATUS;
					} else {
						return Status.CANCEL_STATUS;
					}
					
				} else {
					
					return Status.CANCEL_STATUS;
				}
			}
		};
		job.setUser(true);
		job.schedule();
		
		return job;
	}

	
	public static void setDiagram(Diagram d){
		diagram = d;
	}
	
	public static void setProcessId(String pid){
		processId = pid;
	}

	
	private void showErrorMessage(final String message) {
		log.error(message);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Creating composition plans",message);
			}
		});

	}
	
	private void showOkMessage(final int number, final Shell shell) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
//				PropertyAniketosPlanningDeploySection.setVisiblePropertyLabel(true);
				if(number == 1){
					log.info("Created "+number+" composition plan");
					MessageDialog.open(MessageDialog.INFORMATION, shell, "Creating composition plans",
							"Created "+number+" composition plan", SWT.NONE);
				} else {
					log.info("Created "+number+" composition plans");
					MessageDialog.open(MessageDialog.INFORMATION, shell, "Creating composition plans",
							"Created "+number+" composition plans", SWT.NONE);
				}
			}
		});
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
