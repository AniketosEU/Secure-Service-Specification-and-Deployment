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

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import javax.wsdl.WSDLException;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.gui.property.PropertyAniketosGeneralSection;
import org.activiti.designer.elsag.wsdl.WsdlParser;
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.ServiceQuery;
import eu.aniketos.scf.data.impl.Service;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class DiscoverAllSelectionAdapter extends SelectionAdapter{

	private final Shell shell;
	private static Diagram diagram;
	private static String processId;
	private static DiagramEditor diagramEditor;

	public DiscoverAllSelectionAdapter(Shell shell)  {
		this.shell = shell;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Job job = new Job("Discovering services in the Marketplace for all the service tasks") {

			protected IStatus run(IProgressMonitor monitor) {
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
													monitor.subTask("Connecting to the Marketplace");
													monitor.worked(40);
													Properties prop = Activator.getConfigProperties();
													scf.setProxy(prop.getProperty("proxyHost"), prop.getProperty("proxyPort"),prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));
													servicesDiscovered = scf.discoverServices(serviceQuery, prop.getProperty("MarketplaceAddress"));
												}catch(javax.xml.ws.WebServiceException ex) {
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

												System.out.println("Services for "+ task.getId() +" discovered");
												System.out.println("Locations:");
												for(String location:locations){
													System.out.println("--- "+location);
												}

												hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
												hashTableLocations.put(task.getId(), servicesDiscovered);
												org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,(Hashtable<String,Set<Service>>)hashTableLocations);
												serviceTasksDiscovered.add(task.getId());
												
												if(locations.size()>0){

													System.out.println("Disovered " + locations.size() +" services for "+ type);
													System.out.println("Locations:");

													Hashtable<String, List<List<String>>> hashTableOperationInputType = new Hashtable<String, List<List<String>>>();
													Hashtable<String, List<String>> hashTableOperationOutputType = new Hashtable<String, List<String>>();
													
													
													String[] labels = null;
													List<String> operations = new Vector<String>();
													String errorMsg = "";
													Iterator<Service> it = servicesDiscovered.iterator();
													while(it.hasNext()){
														Service service = it.next();
														String location = service.getLocation();
														System.out.println("--- "+location);

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
																System.out.println(offset);

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

														monitor.subTask("Parsing WSDL files");
														monitor.worked(40);

													}

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
													monitor.subTask("Updating UI");
													monitor.worked(20);

//													PropertyAniketosServiceTaskSection.setComboOperation(labels);

													Hashtable<String,Set<Service>> hashTableLocations1 = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);

													hashTableLocations1.put(taskId, servicesDiscovered);
													org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,hashTableLocations1);

												}
												//    			discoveryLabel.setVisible(true);

												//    			createPlansButton.setEnabled(true);
											}
										}
									}
						
								}
							}
						}
					}
					if(serviceTasksDiscovered.size() == getListOfServiceTasks().size() && servicesNotDiscovered.size() == 0){
						showOkMessage();
						return Status.OK_STATUS;
					} else if(discovered){
						String message = "";
						for(List<String> service : servicesNotDiscovered){
							String type = service.get(0);
							String id = service.get(1);
							String name = service.get(2);
							message = message + "Id:" + id + " Name: " + name + " Type: " + type + " \n";
						}
						showErrorMessage("Unable to find services for Service Tasks:\n" +
								message + "\n\n" +
								"Check the types and click again on the \"Discover service candidates button\"");
						return Status.CANCEL_STATUS;
					} else {
						return Status.CANCEL_STATUS;
					}
					
				} else {
					showErrorMessage("Xml file not yet created. Set the type for each service task and then save the diagram");
					ServiceTask task = null;
        			List<String> serviceTasksDiscovered = new Vector<String>();
        			EList<PictogramLink> list = diagram.getPictogramLinks();
        			for(PictogramLink link : list){
        				EList<EObject> elist = link.getBusinessObjects();
        				for(EObject ob : elist){
        					if(ob instanceof ServiceTask){
        						task = (ServiceTask) ob;
        						if(!serviceTasksDiscovered.contains(task.getId())){
        							serviceTasksDiscovered.add(task.getId());
        							
        							saveImplementationType(PropertyAniketosGeneralSection.CLASS_TYPE, task);
        						}
        					}
        				}
        			}
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
	
	private void showOkMessage() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, "Service discovery",
						"Services discovered");
			}
		});

	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Service discovery",message);
			}
		});

	}
	
	public static void setDiagram(Diagram d){
		diagram = d;
	}
	
	public static void setProcessId(String pid){
		processId = pid;
	}
	
	public static void setDiagramEditor(DiagramEditor editor){
		diagramEditor = editor;
	}
	
	private void saveImplementationType(final String type, final ServiceTask serviceTask) {

		DiagramEditor diagramEditor = (DiagramEditor)this.diagramEditor;
		@SuppressWarnings("restriction")
		TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
		ActivitiUiUtil.runModelChange(new Runnable() {
			public void run() {
				serviceTask.setImplementationType(type);
				serviceTask.setImplementation("org.aniketos.runtime.AniketosClientDelegation");
			}
		}, editingDomain, "Model Update");
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
