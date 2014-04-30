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
import org.activiti.designer.elsag.data.ServiceDiscovered;
import org.activiti.designer.elsag.gui.property.PropertyAniketosServiceTaskSection;
import org.activiti.designer.elsag.wsdl.WsdlParser;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import eu.aniketos.marketplace.ServiceOperation;
import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.ServiceQuery;
import eu.aniketos.scf.data.impl.Service;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class DiscoverSelectionAdapter extends SelectionAdapter{

	private final Shell shell;
	private static Diagram diagram;
	private static String processId;
	private static String taskId;
	
	private  IWorkbenchPage page;

	final private static Logger log = Logger.getLogger(DiscoverSelectionAdapter.class);
	
	public DiscoverSelectionAdapter(Shell shell, IWorkbenchPage page) {
		this.shell = shell;
		this.page = page;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		
		//save the diagram
		page.saveAllEditors(false);
		
		Job job = new Job("Discovering services in the Marketplace") {

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Discovering services in the Marketplace", 100);
				
				PropertyAniketosServiceTaskSection.cleanOperationNameList();
				
				ServiceCompositionFrameworkInterface scf = org.activiti.designer.elsag.Activator.getDefault().getServiceCompositionFramework();
				URI uri = diagram.eResource().getURI();
				URI bpmnUri = uri.trimFragment();
				bpmnUri = bpmnUri.trimFileExtension();
				bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");

				String platformString = bpmnUri.toPlatformString(true);
				IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
				if(fileResource != null){
					Hashtable<String,String> hashTableField = org.activiti.designer.elsag.data.Data.hashTableFieldProcess.get(processId);
					String type = hashTableField.get(taskId);
					String secReq = null;
					//    				Hashtable<String, Set<String>> hashOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperations.get(task.getId());
					//    				if(hashOperations == null){
					Hashtable<String, Set<Service>> hashOperations = new Hashtable<String, Set<Service>>();
					//					}

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
							log.debug("Unable to connect to the Marketplace");
							log.debug(ex);
							return Status.CANCEL_STATUS;
						}

						Set<String> locations = new HashSet<String>();
						List<ServiceOperation> returnedOperations = null;
						
						for(Service service : servicesDiscovered){
							locations.add(service.getLocation());
							returnedOperations = service.getOperations();
						}

						if(locations.size()>0){

							log.debug("Disovered " + locations.size() +" services for "+ type);
							log.debug("Locations:");

							Hashtable<String, List<List<String>>> hashTableOperationInputType = new Hashtable<String, List<List<String>>>();
							Hashtable<String, List<String>> hashTableOperationOutputType = new Hashtable<String, List<String>>();
							
							List<String> operations = new Vector<String>();
							String errorMsg = "";
							
							
							Iterator<Service> it = servicesDiscovered.iterator();
							int index = 0;
//							if(PropertyAniketosServiceTaskSection.operationNameList.getItemCount() >0 ){
//								index = 0;
//							}
							List<ServiceDiscovered> listServiceDiscovered = new Vector<ServiceDiscovered>();
							while(it.hasNext()){
								Service service = it.next();
								String location = service.getLocation();
								log.debug("--- "+location);

								List<String> listOperations = new Vector<String>();
								try {
									List<String> operationsWSDL = WsdlParser.getInstance().getOperations(location);
									log.debug("Discovered operations: "+operationsWSDL);
									for(ServiceOperation operation : returnedOperations){
										if(operationsWSDL.contains(operation.getMethod().getValue())){
											listOperations.add(operation.getMethod().getValue());
										}
									}
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
									log.debug("Input Types for "+listOperations.get(i) + ": " + inputTypes);
									log.debug("Output Type for "+listOperations.get(i) + ": " + outputType);
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
										Hashtable<String,Hashtable<String,List<List<String>>>> hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
										hashTableTaskOperationInputType.put(taskId, hashTableOperationInputType);
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);

										actualOutputTypes.add(outputType);
										//										hashTableOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputType.get(task.getId());
										hashTableOperationOutputType.put(listOperations.get(i), actualOutputTypes);
										Hashtable<String,Hashtable<String,List<String>>> hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
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
												Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
												hashTableTaskOperations.put(taskId, hashOperations);
												org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
											}
										} else {
											Set<Service> services = new HashSet<Service>();
											services.add(service);
											hashOperations.put(listOperations.get(i)+offset, services);
											Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
											hashTableTaskOperations.put(taskId, hashOperations);
											org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
										}

										operations.add(listOperations.get(i));

									} else if (!actualInputTypes.contains(inputTypes) && actualOutputTypes.contains(outputType)){
										actualInputTypes.add(inputTypes);
										//    									hashTableOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputType.get(task.getId());
										hashTableOperationInputType.put(listOperations.get(i), actualInputTypes);
										Hashtable<String,Hashtable<String,List<List<String>>>> hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
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
												Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
												hashTableTaskOperations.put(taskId, hashOperations);
												org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
											}
										} else {
											Set<Service> services = new HashSet<Service>();
											services.add(service);
											hashOperations.put(listOperations.get(i)+offset, services);
											Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
											hashTableTaskOperations.put(taskId, hashOperations);
											org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
										}

										operations.add(listOperations.get(i));

									} else if (actualInputTypes.contains(inputTypes) && !actualOutputTypes.contains(outputType)){
										actualOutputTypes.add(outputType);
										//										hashTableOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputType.get(task.getId());
										hashTableOperationOutputType.put(listOperations.get(i), actualOutputTypes);
										Hashtable<String,Hashtable<String,List<String>>> hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
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
												Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
												hashTableTaskOperations.put(taskId, hashOperations);
												org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
											}
										} else {
											Set<Service> services = new HashSet<Service>();
											services.add(service);
											hashOperations.put(listOperations.get(i)+offset, services);
											Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
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
												Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
												hashTableTaskOperations.put(taskId, hashOperations);
												org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
											}
										} else {
											Set<Service> services = new HashSet<Service>();
											services.add(service);
											hashOperations.put(listOperations.get(i)+offset, services);
											Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
											hashTableTaskOperations.put(taskId, hashOperations);
											org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
										}

										operations.add(listOperations.get(i));
									}
									
									Hashtable<String, List<ServiceDiscovered>> hashTableTaskServiceDiscovered = org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.get(processId);
//									List<ServiceDiscovered> listServiceDiscovered = hashTableTaskServiceDiscovered.get(taskId);
									boolean contained = false;
									for(ServiceDiscovered containedService : listServiceDiscovered){
										if(containedService.getName().equals(listOperations.get(i)) && containedService.getInput().equals(inputTypes) && containedService.getOutput().equals(outputType)){
											contained = true;
											log.debug("service already added to the list");
										}
									}
									if(!contained){
										log.debug("service not yet added to the list");
										ServiceDiscovered serviceDiscovered = new ServiceDiscovered(index, listOperations.get(i), inputTypes, outputType);
										listServiceDiscovered.add(serviceDiscovered);
										hashTableTaskServiceDiscovered.put(taskId, listServiceDiscovered);
										org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.put(processId, hashTableTaskServiceDiscovered);
										PropertyAniketosServiceTaskSection.addOperationNameToList(listOperations.get(i), index);
										index++;
									}
									
								}

								monitor.subTask("Parsing WSDL files");
								monitor.worked(40);

							}

							Hashtable<String,Hashtable<String,List<List<String>>>> hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
							Hashtable<String,Hashtable<String,List<String>>> hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
							Set<String>  setOperations = hashTableTaskOperationInputType.get(taskId).keySet();
							Object[] operationsArray = setOperations.toArray();
							int size = 0;

							size = hashOperations.size();
							if(!errorMsg.equals("")){
								showErrorMessage(errorMsg);
							}
							if(size == 0){
								showErrorMessage("Discovered 0 services for Service Task \""+ taskId + "\" with type \""+ type +"\" \n" +
										"Try to change the type and click again on the \"Discover service candidates button\"");
								return Status.CANCEL_STATUS;
							}

							Hashtable<String,String> hashLabel = new Hashtable<String,String>();
							
							for(int j=0; j<operationsArray.length; j++){
								
								List<List<String>> inputT = hashTableTaskOperationInputType.get(taskId).get(operationsArray[j]);

								List<String> outputT = hashTableTaskOperationOutputType.get(taskId).get(operationsArray[j]);

								for(List<String> list : inputT){
									String inputTypeString = "";
									Iterator<String> iterator = list.iterator();
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

							monitor.subTask("Updating UI");
							monitor.worked(20);

//							PropertyAniketosServiceTaskSection.setComboOperation(labels);

							Hashtable<String,Set<Service>> hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);

							hashTableLocations.put(taskId, servicesDiscovered);
							org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId,hashTableLocations);
							
							int numberOfDiscoveredServices = servicesDiscovered.size();
							showOkMessage(type, numberOfDiscoveredServices);
							return Status.OK_STATUS;

						} else {
							showErrorMessage("Discovered 0 services. Try to change the type and discover again in the Marketplace");
							return Status.CANCEL_STATUS;
						}
					} else {
						showErrorMessage("Insert a valid type value");
						return Status.CANCEL_STATUS;
					}
				} else{
					showErrorMessage("Xml file not yet created. Set the type for each service task and then save the diagram");
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
	
	private void showOkMessage(final String type, final int numberOfDiscoveredServices) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if(numberOfDiscoveredServices == 1){
					MessageDialog.openInformation(shell, "Service discovery",
							"Discovered " + numberOfDiscoveredServices + " service for type: "+ type);
				} else {
					MessageDialog.openInformation(shell, "Service discovery",
							"Discovered " + numberOfDiscoveredServices + " services for type: "+ type);
				}
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
	
	public static void setTaskId(String tid){
		taskId = tid;
	}

}
