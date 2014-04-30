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
package eu.aniketos.mtm.srs2activiti.wizard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.Vector;

import org.activiti.designer.eclipse.bpmn.GraphicInfo;
import org.eclipse.aniketos.AniketosFactory;
import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.ThreatEvent;
import org.eclipse.aniketos.Trustworthiness;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.securebpmn2.AtomicActivityAction;
import org.eclipse.securebpmn2.AuthorizationConstraint;
import org.eclipse.securebpmn2.BindingOfDuty;
import org.eclipse.securebpmn2.Permission;
import org.eclipse.securebpmn2.Role;
import org.eclipse.securebpmn2.Securebpmn2Factory;
import org.eclipse.securebpmn2.SecurityFlow;
import org.eclipse.securebpmn2.SeparationOfDuty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.DocumentRoot;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingFactory;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.SRRType;
import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.mapping.TypeType1;
import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.mapping.VarType;
import eu.aniketos.mtm.srs.AgentType;
import eu.aniketos.mtm.srs.BoDSoDGoalType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.ConfidentialityType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalSetTypeMin2;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.IntegrityType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.RoleType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.ThreatType;
import eu.aniketos.mtm.srs.TrustworthinessType;
import eu.aniketos.mtm.srs2activiti.wizard.resources.BodSodCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.BodSodCorrection.BodSodKind;
import eu.aniketos.mtm.srs2activiti.wizard.resources.ConfidentialityCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.IntegrityCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.SecurityCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.ThreatCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.TrustworthinessCorrection;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.utils.ModelingUtils;
import eu.aniketos.mtm.utils.Utils;

/**
 * MTM mapping wizard which maps an existing Activiti BPMN file to a SRS file.
 * 
 * @author Tecnalia
 *
 */
public class MappingGeneratorWizard extends Wizard {

	private static final String[] FILTERS_SRS = {"*.xml", "*.srs"};
	private static final String[] FILTERS_ACTIVITI = {"*.activiti"};
	
	private static int x = 0, y = 0, height = 55, width = 105, offsetX = 70, offsetY = 200;
	private static final int TASK_WIDTH = 105;
	private static final int TASK_HEIGHT = 55;
	// Information to be filled
	private String srsModelPath = null;
	private SecReqSpeType srsModel = null;
	private String activitiModelPath = null;
	private Resource activitiModel = null; // Stored as EMF Resource as there is no root element
	private String outputDir = null;
	private boolean modelsChanged = false;
	private String logMessages = new String();
	private Map<SecurityCorrection, String> msgCorrections = new HashMap<SecurityCorrection, String>();
	private Vector<SecurityCorrection> corrected = new Vector<SecurityCorrection>();
	private Vector<SecurityCorrection> corrections = new Vector<SecurityCorrection>();
	
	// Resource Set for handling models
	private ResourceSet rs = new ResourceSetImpl();
	private ResourceSet activityRS = new ResourceSetImpl(); // Added a second RS to prevent IllegalStateExceptions when editing mapping by hand
	
	// Object to store the mapping decisions made by the user
	private MappingInformation info = new MappingInformation();
	
	// Map to store confidentiality algorithms
	private Map<String, String> confAlgorithms = new HashMap<String, String>();

	public MappingGeneratorWizard() {
		super();
		confAlgorithms.put("low", "Basic128Sha256Rsa15");
		confAlgorithms.put("medium", "Basic192Sha256Rsa15");
		confAlgorithms.put("strong", "Basic256Sha256Rsa15");
	}
	
	@Override
	public void addPages() {
		super.addPages();
		addPage(new SelectModelsPageWizardPage("SelectModelsPage"));
		addPage(new MapTasksToGoalsPage("MapTasksToGoalsPage"));
		addPage(new MapPerformersToActorsPage("MapPerformersToActorsPage"));
		addPage(new MapVariablesToDocsPage("MapVariablesToDocsPage"));
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if(nextPage instanceof MapVariablesToDocsPage){
			((MapVariablesToDocsPage) getPage("MapVariablesToDocsPage")).onAppear();
		}
		return nextPage;
	}
	
	@Override
	public boolean canFinish() {
		return getPage("MapVariablesToDocsPage").isPageComplete();
	}
	
	@Override
	public boolean performFinish() {
		ModelingUtils mu = ModelingUtils.configure(srsModel, null, activitiModel);
		
		final Map<ThreatEvent, ThreatType> correctedThreats = new HashMap<ThreatEvent, ThreatType>();
		
		if (corrections.size() > 0) {
			if (MessageDialog.openConfirm(getShell(), "Automatic Corrections Available", "The wizard detected security related inconsistencies in your Activiti model.\nDo you want the MTM to support you to correct them?")) {
				Vector<SecurityCorrection> configurableCorrections = new Vector<SecurityCorrection>();
				for (SecurityCorrection c : corrections) {
					if (c instanceof TrustworthinessCorrection) {
						ServiceTask t = ((TrustworthinessCorrection) c).getTarget();
						
						SecurityExtension se = null;
						if (t.getSecurityExtensions() == null) {
							se = AniketosFactory.eINSTANCE.createSecurityExtension();
							se.setId(UUID.randomUUID().toString());
							activitiModel.getContents().add(se);
						}
						else {
							se = t.getSecurityExtensions();
						}
						
						Trustworthiness trust = AniketosFactory.eINSTANCE.createTrustworthiness();
						trust.setValue(String.valueOf(((TrustworthinessCorrection) c).getMinLevel()));
						trust.setId(UUID.randomUUID().toString());
						se.setTrustworthinessValue(trust);
						t.setSecurityExtensions(se);
						
						// Add to the resource
						activitiModel.getContents().add(trust);
						corrected.add(c);
					}
					else if(c instanceof ThreatCorrection){
						
						final ThreatCorrection tc = (ThreatCorrection) c;
						// Get the Feature Provider
						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(activitiModel.getResourceSet());
						if (editingDomain == null) {
							// Not yet existing, create one
							editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(activitiModel.getResourceSet());
						}						

						RecordingCommand rc = new RecordingCommand(editingDomain) {

							@Override
							protected void doExecute() {
								// Threat Correction
								ServiceTask t = tc.getTarget();
								
								ThreatEvent te = AniketosFactory.eINSTANCE.createThreatEvent();
								te.setAttachedToRef(t);
								te.setId(Utils.generateUniqueID());
								te.setName(tc.getTt().getName());
								ErrorEventDefinition eed = Bpmn2Factory.eINSTANCE.createErrorEventDefinition();
								if(tc.getTt().getRepositoryID() != null){
									eed.setErrorCode(tc.getTt().getRepositoryID());									
								}	
								te.getEventDefinitions().add(eed);
								
								// Now add the Threat event to the diagram
								// Get the diagram
								Diagram diagram = null;
								TreeIterator<EObject> it = activitiModel.getAllContents();
								while (it.hasNext()) {
									EObject o = it.next();
									if (o instanceof Diagram) {
										diagram = (Diagram)o;
										break;
									}
								}
								
								if (diagram != null) {
									IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, "org.activiti.designer.diagram.ActivitiBPMNDiagramTypeProvider").getFeatureProvider();
									AddContext addContext = new AddContext();
									
									ILinkService linkService = Graphiti.getLinkService();
									List<PictogramElement> pictoList = linkService.getPictogramElements(diagram, te.getAttachedToRef());
									if(pictoList != null && pictoList.size() > 0) {
										addContext.setTargetContainer((ContainerShape) pictoList.get(0));
									}

									addContext.setNewObject(te);
									addContext.setX(TASK_WIDTH - 25);
								    addContext.setY(TASK_HEIGHT - 25);					

									IAddFeature addFeature = featureProvider.getAddFeature(addContext);
									if (addFeature.canAdd(addContext)) {
										addFeature.add(addContext);
									}
								}
								
								// Add threat mapping info
								info.mapThreat2Task(tc.getTt(), t);
								
								corrected.add(tc);
								correctedThreats.put(te, tc.getTt());
							}
						};
						
						// Execute changes
						editingDomain.getCommandStack().execute(rc);
						
					}
					else {
						configurableCorrections.add(c);
					}
				}
				
				if (configurableCorrections.size() > 0) {
					ConfigureCorrectionsWizard wiz = new ConfigureCorrectionsWizard(configurableCorrections);
					WizardDialog dialog = new WizardDialog(getShell(), wiz);
					dialog.setHelpAvailable(false);
					if (dialog.open() == Window.OK) {
						
						for (final SecurityCorrection sc : wiz.getCorrections()) {
							// Get the Feature Provider
							TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(activitiModel.getResourceSet());
							if (editingDomain == null) {
								// Not yet existing, create one
								editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(activitiModel.getResourceSet());
							}
							if (sc instanceof BodSodCorrection) {
									
								RecordingCommand rc = new RecordingCommand(editingDomain) {
									
									@Override
									protected void doExecute() {
										
										BodSodCorrection bsc = (BodSodCorrection) sc;
										
										// Create things...
										AuthorizationConstraint auth = bsc.getKind().equals(BodSodKind.BOD) ? Securebpmn2Factory.eINSTANCE.createBindingOfDuty() : Securebpmn2Factory.eINSTANCE.createSeparationOfDuty();
										auth.setId((bsc.getKind().equals(BodSodKind.BOD) ? "BoD_" : "SoD_") + UUID.randomUUID().toString());
										auth.setName((bsc.getKind().equals(BodSodKind.BOD) ? "BoD_" : "SoD_") + bsc.getTask1().getName() + "_" + bsc.getTask2().getName());
										
										SecurityFlow flow1 = Securebpmn2Factory.eINSTANCE.createSecurityFlow();
										SecurityFlow flow2 = Securebpmn2Factory.eINSTANCE.createSecurityFlow();
										
										Role role1 = Securebpmn2Factory.eINSTANCE.createRole();
										AtomicActivityAction aaa1 = Securebpmn2Factory.eINSTANCE.createAtomicActivityAction();
										Permission perm1 = Securebpmn2Factory.eINSTANCE.createPermission();
										
										Role role2 = Securebpmn2Factory.eINSTANCE.createRole();
										AtomicActivityAction aaa2 = Securebpmn2Factory.eINSTANCE.createAtomicActivityAction();
										Permission perm2 = Securebpmn2Factory.eINSTANCE.createPermission();
										
										role1.setId("role_" + UUID.randomUUID().toString());
										role1.setName(bsc.getRole1());
										role1.setRoleName(bsc.getRole1());
										role1.getPermissions().add(perm1);
										
										aaa1.setActivity(bsc.getTask1());
										aaa1.setId("action_" + UUID.randomUUID().toString());
										aaa1.setActionName(bsc.getAction1());
										aaa1.getPermissions().add(perm1);
										
										perm1.setId("perm_" + UUID.randomUUID().toString());
										perm1.setPName(perm1.getId());
										perm1.getAuthorizationConstraints().add(auth);
										perm1.getActions().add(aaa1);
										perm1.getRoles().add(role1);
										
										role2.setId("role_" + UUID.randomUUID().toString());
										role2.setName(bsc.getRole2());
										role2.setRoleName(bsc.getRole2());
										role2.getPermissions().add(perm2);
										
										aaa2.setActivity(bsc.getTask2());
										aaa2.setId("action_" + UUID.randomUUID().toString());
										aaa2.setActionName(bsc.getAction2());
										aaa2.getPermissions().add(perm2);
										
										perm2.setId("perm_" + UUID.randomUUID().toString());
										perm2.setPName(perm2.getId());
										perm2.getAuthorizationConstraints().add(auth);
										perm2.getActions().add(aaa2);
										perm2.getRoles().add(role2);
										
										auth.getPermissions().add(perm1);
										auth.getPermissions().add(perm2);
										
										flow1.setId(UUID.randomUUID().toString());
										flow2.setId(UUID.randomUUID().toString());
										
										flow1.setSourceRefNode(auth);
										flow2.setSourceRefNode(auth);
										
										flow1.setTargetRefNode(bsc.getTask1());
										flow2.setTargetRefNode(bsc.getTask2());
																				
										// Add them to the resource
										activitiModel.getContents().add(auth);
										activitiModel.getContents().add(flow1);
										activitiModel.getContents().add(flow2);
										activitiModel.getContents().add(aaa1);
										activitiModel.getContents().add(aaa2);
										activitiModel.getContents().add(role1);
										activitiModel.getContents().add(role2);
										activitiModel.getContents().add(perm1);
										activitiModel.getContents().add(perm2);
										
										// Now add the Sod / Bod node to the diagram
										// Get the diagram
										Diagram diagram = null;
										TreeIterator<EObject> it = activitiModel.getAllContents();
										while (it.hasNext()) {
											EObject o = it.next();
											if (o instanceof Diagram) {
												diagram = (Diagram)o;
												break;
											}
										}
										
										if (diagram != null) {
											
											IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, "org.activiti.designer.diagram.ActivitiBPMNDiagramTypeProvider").getFeatureProvider();
											
											// Create the shape and add it to the diagram
											GraphicInfo graphicInfo = new GraphicInfo();
											// Update location to prevent painting all shapes in the same place
											x = x + width + offsetX;
											y = y + height + offsetY;
											
											graphicInfo.x = x;
											graphicInfo.y = y;
											graphicInfo.height = height;
											graphicInfo.width = width;
											
											AddContext addContext = new AddContext();
											addContext.setNewObject(auth);
											addContext.setTargetContainer(diagram);
											addContext.setX(graphicInfo.x);

											addContext.setHeight(graphicInfo.height);
											addContext.setWidth(graphicInfo.width);
											

											IAddFeature addFeature = featureProvider.getAddFeature(addContext);
											if (addFeature.canAdd(addContext)) {
												addFeature.add(addContext);
											}
											
											// Create the security flows
											
											ContainerShape source = null, target1 = null, target2 = null;
											// Find source/target diagram elements
											for (PictogramLink pl : diagram.getPictogramLinks()) {
												if (pl.getBusinessObjects().contains(bsc.getTask1()) && pl.getPictogramElement() instanceof ContainerShape) {
													target1 = (ContainerShape) pl.getPictogramElement();
												}
												else if (pl.getBusinessObjects().contains(bsc.getTask2()) && pl.getPictogramElement() instanceof ContainerShape) {
													target2 = (ContainerShape) pl.getPictogramElement();
												}
												else if (pl.getBusinessObjects().contains(auth) && pl.getPictogramElement() instanceof ContainerShape) {
													source = (ContainerShape) pl.getPictogramElement();
												}
											}
											
											if (source != null && target1 != null && target2 != null) {
												// Get Anchors
												Anchor sourceAnchor = null, targetAnchor1 = null, targetAnchor2 = null;
												for (Anchor a : source.getAnchors()) {
													if (a instanceof ChopboxAnchor) {
														sourceAnchor = a;
													}
												}
												for (Anchor a : target1.getAnchors()) {
													if (a instanceof ChopboxAnchor) {
														targetAnchor1 = a;
													}
												}
												for (Anchor a : target2.getAnchors()) {
													if (a instanceof ChopboxAnchor) {
														targetAnchor2 = a;
													}
												}
												
												// Draw Flow 1
												AddConnectionContext flowAddContext1 = new AddConnectionContext(sourceAnchor, targetAnchor1);
												flowAddContext1.setNewObject(flow1);
												featureProvider.addIfPossible(flowAddContext1);
												
												// Draw Flow 2
												AddConnectionContext flowAddContext2 = new AddConnectionContext(sourceAnchor, targetAnchor2);
												flowAddContext2.setNewObject(flow2);
												featureProvider.addIfPossible(flowAddContext2);
											}
										}
										corrected.add(sc);
									}
								};
								
								// Execute changes
								editingDomain.getCommandStack().execute(rc);
								
							}
							else if (sc instanceof IntegrityCorrection) {

								RecordingCommand rc = new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										Integrity integrity = AniketosFactory.eINSTANCE.createIntegrity();
										SecurityExtension se = null;
										if(((IntegrityCorrection)sc).getTask() instanceof ServiceTask){
											if (((ServiceTask)((IntegrityCorrection)sc).getTask()).getSecurityExtensions() != null) {
												se = ((ServiceTask)((IntegrityCorrection)sc).getTask()).getSecurityExtensions();
											}
											else {
												se = AniketosFactory.eINSTANCE.createSecurityExtension();
												se.setId(UUID.randomUUID().toString());
												activitiModel.getContents().add(se);
											}

											integrity.setId(UUID.randomUUID().toString());
											integrity.setType(((IntegrityCorrection)sc).getType());
											integrity.setAlgorithm(((IntegrityCorrection)sc).getAlgorithm());
											integrity.setWith(((IntegrityCorrection)sc).getDestinationTask().getId() + " - " + ((IntegrityCorrection)sc).getDestinationTask().getName());

											se.getIntegrityReq().add(integrity);

											((ServiceTask)((IntegrityCorrection)sc).getTask()).setSecurityExtensions(se);

											activitiModel.getContents().add(integrity);
											corrected.add(sc);
										}										
									}
								};
								
								// Execute changes
								editingDomain.getCommandStack().execute(rc);
							}
							else if(sc instanceof ConfidentialityCorrection){								

								RecordingCommand rc = new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										Confidentiality conf = AniketosFactory.eINSTANCE.createConfidentiality();
										SecurityExtension se = null;
										if(((ConfidentialityCorrection) sc).getTask() instanceof ServiceTask){
											if (((ServiceTask)((ConfidentialityCorrection)sc).getTask()).getSecurityExtensions() != null) {
												se = ((ServiceTask)((ConfidentialityCorrection)sc).getTask()).getSecurityExtensions();
											}
											else {
												se = AniketosFactory.eINSTANCE.createSecurityExtension();
												se.setId(UUID.randomUUID().toString());
												activitiModel.getContents().add(se);
											}

											conf.setId(UUID.randomUUID().toString());
											conf.setType(((ConfidentialityCorrection) sc).getType());									
											conf.setAlgorithm(confAlgorithms.get(((ConfidentialityCorrection) sc).getAlgorithm()));
											se.getConfidentialityReq().add(conf);

											((ServiceTask)((ConfidentialityCorrection)sc).getTask()).setSecurityExtensions(se);

											activitiModel.getContents().add(conf);
											corrected.add(sc);
										}										
									}
								};
								
								// Execute changes
								editingDomain.getCommandStack().execute(rc);
							}
						}
					}
					else {
						MessageDialog.openWarning(getShell(), "Corrections cancelled", "Automatic corrections were cancelled by the user.");
					}
				}
				
				try {
					activitiModel.save(null);
				} catch (IOException e1) {
					e1.printStackTrace();
					return false;
				}
			}
		}
		
		// Generate the mapping file with the information stored
		String pName = null;
		TreeIterator<EObject> i = activitiModel.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Process) {
				pName = ((Process)o).getName();
				break;
			}
		}
		
		if (pName == null) {
			pName = "DefaultProcess";
		}
		
		Resource r = rs.createResource(URI.createFileURI(outputDir + File.separator + pName + ".mapping"));
		MappingType mapping = MappingFactory.eINSTANCE.createMappingType();
		
		// Generate IsA objects
		for (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.RoleTriple t : info.performers2roles) {
			if (t.agent != null) {
				IsaType isa = MappingFactory.eINSTANCE.createIsaType();
				SRAType sra = MappingFactory.eINSTANCE.createSRAType();
				BPRType bpr = MappingFactory.eINSTANCE.createBPRType();
				BPPType bpp = MappingFactory.eINSTANCE.createBPPType();
				
				sra.setId(t.agent.getId());
				sra.setValue(t.agent.getValue());
				
				if (t.task instanceof ServiceTask) {
					FieldExtension user = mu.getPerformerNameForTask((ServiceTask)t.task);
					if(user != null){
						bpp.setId(user.getId());
						bpp.setValue(user.getExpression());
					}
				}
				else{
					if(((UserTask)t.task).getAssignee() != null){
						bpp.setId(((UserTask)t.task).getId()+"."+((UserTask)t.task).getAssignee());
						bpp.setValue(((UserTask)t.task).getAssignee());
					}
				}				
								
				bpp.setType(t.task instanceof ServiceTask ? TypeType.SERVICE : TypeType.HUMAN);
				
				if (t.task instanceof ServiceTask) {
					FieldExtension fe = mu.getRoleForTask((ServiceTask)t.task);
					if(fe != null){
						bpr.setId(fe.getId());
						bpr.setValue(fe.getExpression());
					}					
				}
				else{
					if(((UserTask)t.task).getCandidateGroups() != null && ((UserTask)t.task).getCandidateGroups().size() > 0){
						bpr.setId(((UserTask)t.task).getId()+"."+((UserTask)t.task).getCandidateGroups().get(0).getGroup());
						bpr.setValue(((UserTask)t.task).getCandidateGroups().get(0).getGroup());
					}
				}
				bpr.setType(t.task instanceof ServiceTask ? TypeType.SERVICE : TypeType.HUMAN);
								
				isa.getSRAgent().add(sra);
				isa.getBPRole().add(bpr);
				isa.getBPPart().add(bpp);
				
				mapping.getIsA().add(isa);
			}
		}
		
		// Generate Plays objects
		for (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.RoleTriple t : info.performers2roles) {
			if (t.role != null) {
				PlaysType p = MappingFactory.eINSTANCE.createPlaysType();
				SRRType srr = MappingFactory.eINSTANCE.createSRRType();
				BPPType bpp = MappingFactory.eINSTANCE.createBPPType();
				
				srr.setId(t.role.getId());
				srr.setValue(t.role.getValue());
				
				if (t.task instanceof ServiceTask) {
					FieldExtension fe = mu.getRoleForTask((ServiceTask)t.task);
					if(fe != null){
						bpp.setId(fe.getId());
						bpp.setValue(fe.getExpression());
					}					
				}
				else{
					if(((UserTask)t.task).getCandidateGroups() != null && ((UserTask)t.task).getCandidateGroups().size() > 0){
						bpp.setId(((UserTask)t.task).getId()+"."+((UserTask)t.task).getCandidateGroups().get(0).getGroup());
						bpp.setValue(((UserTask)t.task).getCandidateGroups().get(0).getGroup());
					}
				}
				bpp.setType(t.task instanceof ServiceTask ? TypeType.SERVICE : TypeType.HUMAN);
				
				p.setBPPart(bpp);
				p.setSRRole(srr);
				
				mapping.getPlays().add(p);
			}
		}
		
		// Generate Represents objects
		for (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarCuadruple c : info.vars2docs) {
			RepresentsType rt = MappingFactory.eINSTANCE.createRepresentsType();
			VarType vt = MappingFactory.eINSTANCE.createVarType();
			eu.aniketos.mtm.mapping.DocType dt = MappingFactory.eINSTANCE.createDocType();
			
			if(c instanceof eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple){
				eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple varFieldExtensionCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple) c;
				vt.setId(varFieldExtensionCuadruple.var.getId());
				if(varFieldExtensionCuadruple.var.getFieldname().equals("input")){
					vt.setValue(mu.getVarsInFieldExtension(varFieldExtensionCuadruple.var).get(varFieldExtensionCuadruple.index));
				}
				else{
					vt.setValue(varFieldExtensionCuadruple.var.getExpression());
				}				
			}
			else{
				eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple varFormPropertyCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple) c;
				vt.setId(varFormPropertyCuadruple.var.getId());				
				vt.setValue(varFormPropertyCuadruple.var.getName());
			}
			vt.setOrder(c.index);
			
			dt.setId(c.doc.getId());
			dt.setValue(c.doc.getValue());
			
			rt.getDocument().add(dt);
			rt.setVariable(vt);
			
			mapping.getRepresents().add(rt);
		}		
		
		// Generate ThreatsMapping objects
		Map<ThreatEvent, ThreatType> mappedThreats = new HashMap<ThreatEvent, ThreatType>();
		for (Task t : info.threats.keySet()) {
			Vector<ThreatType> ttList = info.threats.get(t);
			for (ThreatType tt : ttList) {
				ThreatEvent te = null;
				Vector<ThreatEvent> tEvents = mu.getActivityThreatsByRepositoryId(tt.getRepositoryID());
				for (ThreatEvent threatEvent : tEvents) {
					if(threatEvent.getAttachedToRef().equals(t)){
						te = threatEvent;
						break;
					}
				}
				if(te == null){
					for (ThreatEvent threatEvent : correctedThreats.keySet()) {
						if(correctedThreats.get(threatEvent).equals(tt)){
							te = threatEvent;
							break;
						}
					}
				}
				if(te != null){
					// Create ThreatsMapping
					eu.aniketos.mtm.mapping.ThreatType srThreat = MappingManager.getInstance().createThreatType(tt.getId(), tt.getRepositoryID(), tt.getName());
					eu.aniketos.mtm.mapping.ThreatType bpThreat = MappingManager.getInstance().createThreatType(te.getId(), tt.getRepositoryID(), te.getName());
					mapping.getThreats().add(MappingManager.getInstance().createThreatsMappingType(srThreat, bpThreat));
					mappedThreats.put(te, tt);
				}				
			}			
		}
		
		// Generate RelatesTo objects
		MappingManager mm =  MappingManager.getInstance();
		for (Entry<Task, GoalType> e : info.tasks2goals.entrySet()) {
			RelatesToType rt = MappingFactory.eINSTANCE.createRelatesToType();
			ActivityType at = MappingFactory.eINSTANCE.createActivityType();
			Vector<GoalType> goals = mu.getSRSGoalsByName(e.getValue().getValue());			
			
			at.setId(e.getKey().getId());
			at.setUsertype(e.getKey() instanceof ServiceTask ? UsertypeType.SERVICE_TASK : UsertypeType.USER_TASK);
			at.setValue(e.getKey().getName());
			
			if (e.getKey() instanceof ServiceTask) {
				ServiceTask st = (ServiceTask) e.getKey();
				// Add trustworthiness
				if (st.getSecurityExtensions() != null && st.getSecurityExtensions().getTrustworthinessValue() != null) {					
					at.setTrustworthiness(Float.parseFloat(st.getSecurityExtensions().getTrustworthinessValue().getValue()));
				}
				// Add participant to task
				FieldExtension fe = mu.getPerformerNameForTask(st);
				if(fe != null && mm.getIsaParticipantOrRoleById(mapping, fe.getId()) != null){
					at.getParticipant().add(fe.getId());
				}
				else{
					FieldExtension feRole = mu.getRoleForTask(st);
					if(feRole != null && (mm.getMappingIsAByBprId(mapping, feRole.getId()) != null || mm.getPlaysParticipantById(mapping, feRole.getId()) != null)){
						at.getParticipant().add(feRole.getId());
					}
				}
				// Add variables to task
				Vector<FieldExtension> fes = mu.getVarForTask(st);
				if(fes != null && fes.size() > 0){
					for (FieldExtension fieldExtension : fes) {
						if(mm.getRepresentsByVarId(mapping, fieldExtension.getId()) != null){
							ActivityVar av = MappingFactory.eINSTANCE.createActivityVar();
							av.setId(fieldExtension.getId());
							av.setType(fieldExtension.getFieldname().equals("input") ? TypeType2.INPUT : TypeType2.OUTPUT);
							// Add confidentiality
							Confidentiality c = mu.getConfidentialityForTask(st, fieldExtension.getFieldname());
							if(c != null){
								eu.aniketos.mtm.mapping.ConfidentialityType ct = MappingFactory.eINSTANCE.createConfidentialityType();
								ct.setAlgorithm(c.getAlgorithm());
								av.setConfidentiality(ct);
							}
							at.getVariable().add(av);
						}						
					}
				}				
				// Add integrity
				if (st.getSecurityExtensions() != null && st.getSecurityExtensions().getIntegrityReq() != null && st.getSecurityExtensions().getIntegrityReq().size() > 0) {
					for (Integrity integrity : st.getSecurityExtensions().getIntegrityReq()) {
						eu.aniketos.mtm.mapping.IntegrityType it = MappingFactory.eINSTANCE.createIntegrityType();
						it.setWith(integrity.getWith());
						it.setAlgorithm(integrity.getAlgorithm());
						it.setType(integrity.getType());
						Vector<FieldExtension> fes2 = mu.getVarForTask(st);
						if(fes != null && fes2.size() > 0){
							for (FieldExtension fieldExtension : fes) {
								if(fieldExtension.getFieldname().equals("resultVariable")){
									it.setVariable(fieldExtension.getId());
								}
							}
						}
						at.getIntegrity().add(it);
					}
				}
				// Add threat
				if(info.threats.containsKey(st)){
					Vector<ThreatType> ttList = info.threats.get(st);
					ThreatEvent threatEvent = null;
					for (ThreatType threatType : ttList) {
						for (ThreatEvent te : mappedThreats.keySet()) {
							if(te.getAttachedToRef().equals(st) && mappedThreats.get(te).equals(threatType)){
								threatEvent = te;
							}
						}
						if(threatEvent != null){
							at.getThreat().add(threatEvent.getId());
						}
					}
					
				}
				
			}
			else if (e.getKey() instanceof UserTask) {
				// Add participant to task 
				UserTask ut = (UserTask) e.getKey();
				if(ut.getAssignee() != null && mm.getIsaParticipantOrRoleById(mapping, ut.getId()+"."+ut.getAssignee()) != null){
					at.getParticipant().add(ut.getId()+"."+ut.getAssignee());
				}	
				else{
					if(ut.getCandidateGroups() != null && ut.getCandidateGroups().size() > 0){
						String id = ut.getId() + "." + ut.getCandidateGroups().get(0).getGroup();
						if(mm.getMappingIsAByBprId(mapping, id) != null || mm.getPlaysParticipantById(mapping, id) != null){
							at.getParticipant().add(id);
						}						
					}
				}
				// Add variables to task 
				Vector<FieldExtension> fes = mu.getVarForTask(ut);
				if(fes != null && fes.size() > 0){
					for (FieldExtension fieldExtension : fes) {
						if(mm.getRepresentsByVarId(mapping, fieldExtension.getId()) != null){
							ActivityVar av = MappingFactory.eINSTANCE.createActivityVar();
							av.setId(fieldExtension.getId());
							av.setType(fieldExtension.getFieldname().equals("input") ? TypeType2.INPUT : TypeType2.OUTPUT);
							at.getVariable().add(av);
						}	
					}
				}
				for (FormProperty fp : ut.getFormProperties()) {
					if(mm.getRepresentsByVarId(mapping, fp.getId()) != null){
						ActivityVar av = MappingFactory.eINSTANCE.createActivityVar();
						av.setId(fp.getId());
						av.setType(fp.getType().equals("input") ? TypeType2.INPUT : TypeType2.OUTPUT);
						at.getVariable().add(av);
					}					
				}
			}
					
			AtomicActivityAction aaa = mu.getAtomicActionForTask(e.getKey());
			if (aaa != null) {
				for (Permission p : aaa.getPermissions()) {
					PermissionType pt = MappingFactory.eINSTANCE.createPermissionType();
					pt.setId(p.getId());
					pt.setAction(aaa.getActionName());
					pt.setRole(p.getRoles().get(0).getId());
					at.getPermission().add(pt);
				}
			}
			
			rt.setActivity(at);
			
			Vector<String> usedIDs = new Vector<String>();
			for (GoalType goal : goals) {
				if (!usedIDs.contains(goal.getId())) {
					eu.aniketos.mtm.mapping.GoalType gt  = MappingFactory.eINSTANCE.createGoalType();
					gt.setId(goal.getId());
					gt.setValue(goal.getValue());
					rt.getGoal().add(gt);
					usedIDs.add(goal.getId());
				}
			}
			
			mapping.getRelatesTo().add(rt);
		}
		
		// Generate SodBod objects
		Vector<BindingOfDuty> bods = mu.getActivityBoDs();
		Vector<SeparationOfDuty> sods = mu.getActivitySoDs();
		for (BindingOfDuty bod : bods) {
			if(bod.getOutgoingSecurityFlow().size() == 2){
				SoDBoDType sbt = MappingFactory.eINSTANCE.createSoDBoDType();
				sbt.setId(bod.getId());
				sbt.setType(TypeType1.BO_D);
				
				for (Permission p : bod.getPermissions()) {
					sbt.getPermission().add(p.getId());
				}
				
				
				GoalType g1 = null, g2 = null;
				try {
					g1 = info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(0).getTargetRefNode());
					g2 = info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(1).getTargetRefNode());
				}
				catch (NullPointerException e) {
					// Prevent the crash
				}
				
				CommitmentType c = (g1 == null || g2 == null) ? null : mu.getCommitmentWithBoDSoD(g1.getValue(), g2.getValue());
				if (c == null) {
					logMessages += "INFO:\tThe Binding of Duty '"+bod.getId()+"' defined in the Activiti model does not match any SRS commitment.\n";
				}
				else {
					sbt.setCommitmentID(c.getId());
				}
				mapping.getSoDBoDProperties().add(sbt);
			}			
		}
		
		for (SeparationOfDuty sod : sods) {
			if(sod.getOutgoingSecurityFlow().size() == 2){
				SoDBoDType sbt = MappingFactory.eINSTANCE.createSoDBoDType();
				sbt.setId(sod.getId());
				sbt.setType(TypeType1.SO_D);
				
				for (Permission p : sod.getPermissions()) {
					sbt.getPermission().add(p.getId());
				}
				
				GoalType g1 = null, g2 = null;
				try {
					g1 = info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(0).getTargetRefNode());
					g2 = info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(1).getTargetRefNode());
				}
				catch (NullPointerException e) {
					// Prevent the crash
				}
				
				CommitmentType c = null;
				if(g1 != null && g2 != null){
					c = mu.getCommitmentWithBoDSoD(g1.getValue(), g2.getValue());
				}
				
				if (c == null) {
					logMessages += "INFO:\tThe Separation of Duty '"+sod.getId()+"' defined in the Activiti model does not match any SRS commitment.\n";
				}
				else {
					sbt.setCommitmentID(c.getId());
				}
				mapping.getSoDBoDProperties().add(sbt);
			}			
		}
		
		// Add objects to the resource and save
		DocumentRoot root = MappingFactory.eINSTANCE.createDocumentRoot();
		root.setMapping(mapping);
		r.getContents().add(root);
		try {
			r.save(null);
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
		
		// Generate the logs file
		for (SecurityCorrection sc : msgCorrections.keySet()) {
			if(corrected.contains(sc)){
				logMessages += "WARNING*:" + msgCorrections.get(sc);
			}
			else{
				logMessages += "WARNING:" + msgCorrections.get(sc);
			}			
		}
		File logFile = new File(outputDir + File.separatorChar + "log.txt");
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(logFile));
			br.write("MTM Mapping Generation Log - " + new Date() + "\n");
			br.write("Warnings marked with '*' have been automatically corrected.\n");
			br.write("-----------------------------------------------------------------------------------------------------\n");
			br.write(logMessages);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		return true;
	}
	
	private void updateWarningMessage() {
		// Clear the proposed corrections
		corrections.clear();
		corrected.clear();
		msgCorrections.clear();
		
		// Update the warning message on the page (if applicable).
		boolean showWarning1 = false, showWarning2 = false, showWarning3 = false;
		String warningMessage1 = "", warningMessage2 = "", warningMessage3 = "";
		logMessages = new String();
		
		if (srsModel == null || activitiModel == null) {
			return;
		}
		
		ModelingUtils mu = ModelingUtils.configure(srsModel, null, activitiModel);
		
		// 1.- Check that all the goals are mapped
		boolean allGoalsMapped = true;
		
		for (GoalType g : mu.getSRSGoals()) {
			boolean found = false;
			for (GoalType g2 : info.tasks2goals.values()) {
				if (g2.getValue().equals(g.getValue())) {
					found = true;
					break;
				}
			}
			if (!found) {
				allGoalsMapped = false;
				logMessages += "WARNING:\tGoal '" + g.getValue() + "' was not mapped to a task.\n";
			}
			
		}
		
		if (!allGoalsMapped) {
			showWarning1 = true;
			warningMessage1 += "Current status: Not all the goals are mapped to Activiti tasks.\n";
			
		}
		
		// 2.- Check that goals are mapped to tasks that match the Security Requirements
		boolean allTaskMapsCorrect = true;
		for (Entry<Task, GoalType> e : info.tasks2goals.entrySet()) {
			// 2.1.- Check Trustworthiness
			Vector<GoalType> goalObjs = mu.getSRSGoalsByName(e.getValue().getValue());
			for (GoalType g : goalObjs) {
				if (g.eContainer() instanceof TrustworthinessType) {
					TrustworthinessType tt = (TrustworthinessType) g.eContainer();
					if ( !(e.getKey() instanceof ServiceTask) || ((ServiceTask)e.getKey()).getSecurityExtensions() == null || ((ServiceTask)e.getKey()).getSecurityExtensions().getTrustworthinessValue() == null || Integer.parseInt(((ServiceTask)e.getKey()).getSecurityExtensions().getTrustworthinessValue().getValue()) < Integer.parseInt(tt.getMinLevel())) {
						allTaskMapsCorrect = false;
						String logMsg = "\tTask '"+ e.getKey().getName() +"' does not match the trustworthiness >= "+ tt.getMinLevel() +" requirement elicitated by Goal '"+ g.getValue() +"'";
						if (tt.eContainer().eContainer() instanceof CommitmentType) {
							logMessages += " in SRS Commitment '"+ ((CommitmentType)tt.eContainer().eContainer()).getId() + "'";
						}
						logMsg += "\n";
						
						// Create a correction if possible!!
						if (e.getKey() instanceof ServiceTask) {
							TrustworthinessCorrection c = new TrustworthinessCorrection((ServiceTask) e.getKey(), Integer.parseInt(tt.getMinLevel()));
							TrustworthinessCorrection del = null;
							boolean mustAdd = true;
							for (SecurityCorrection cor : corrections) {
								if (cor instanceof TrustworthinessCorrection && ((TrustworthinessCorrection)cor).getTarget().equals((ServiceTask) e.getKey())) {
									if (((TrustworthinessCorrection)cor).getMinLevel() <= c.getMinLevel()) {
										del = (TrustworthinessCorrection) cor;
									}
									else {
										mustAdd = false;
									}
								}
							}

							if (del != null) {
								corrections.remove(del);
								logMessages += "WARNING:" + msgCorrections.get(del);
								msgCorrections.remove(del);
							}

							if (mustAdd) {
								corrections.add(c);
								msgCorrections.put(c, logMsg);
							}
						}
						else{
							logMessages += "WARNING:" + logMsg;
						}
						
					}
				}
			}
			
			// 2.2.- Check BoD & SoD
			for (GoalType g : goalObjs) {
				if (g.eContainer() instanceof GoalSetTypeMin2 && g.eContainer().eContainer() instanceof BoDSoDGoalType && g.eContainer().eContainer().eContainer() instanceof PostType) {
					PostType post = (PostType) g.eContainer().eContainer().eContainer();
					if (post.getAchieveInCombination() != null) {
						// BoD
						GoalType g2 = ((GoalSetTypeMin2)g.eContainer()).getGoal().get(0).equals(g) ? ((GoalSetTypeMin2)g.eContainer()).getGoal().get(1) : ((GoalSetTypeMin2)g.eContainer()).getGoal().get(0);
						
						boolean found = false;
						for (BindingOfDuty bod : mu.getActivityBoDs()) {
							if(bod.getOutgoingSecurityFlow().size() == 2) {
								if (bod.getOutgoingSecurityFlow().get(0).getTargetRefNode().equals(e.getKey())) {
									if (info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(1).getTargetRefNode()) != null && info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(1).getTargetRefNode()).getValue().equals(g2.getValue())) {
										found = true;
										break;
									}
								}
								else if (bod.getOutgoingSecurityFlow().get(1).getTargetRefNode().equals(e.getKey())) {
									if (info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(0).getTargetRefNode()) != null && info.tasks2goals.get(bod.getOutgoingSecurityFlow().get(0).getTargetRefNode()).getValue().equals(g2.getValue())) {
										found = true;
										break;
									}
								}
							}
						}
						
						if (!found) {
							allTaskMapsCorrect = false;
							if (!info.isGoalMapped(g2.getValue())) {
								logMessages += "WARNING:\tTask '"+ e.getKey().getName() +"' does not match the Binding of Duty requirement elicitated by Goal '"+ g.getValue() +"' with Goal'"+g2.getValue()+"'\n";
							}
							else {
								String logMsg = "\tTask '"+ e.getKey().getName() +"' does not match the Binding of Duty requirement elicitated by Goal '"+ g.getValue() +"' with Goal'"+g2.getValue()+"'\n";
								BodSodCorrection c = new BodSodCorrection(e.getKey(), info.getMappedTask(g2.getValue()), BodSodKind.BOD);
								boolean mustAdd = true;
								for (SecurityCorrection sc : corrections) {
									if (sc instanceof BodSodCorrection && ((BodSodCorrection)sc).getKind().equals(c.getKind())) {
										BodSodCorrection c2 = (BodSodCorrection)sc;
										if ((c.getTask1().equals(c2.getTask1()) && c.getTask2().equals(c2.getTask2())) || (c.getTask1().equals(c2.getTask2()) && c.getTask2().equals(c2.getTask1()))) {
											mustAdd = false;
										}
									}
								}
								
								if (mustAdd) {
									corrections.add(c);
									msgCorrections.put(c, logMsg);
								}
							}
						}
					}
					else if (post.getNotAchieveInCombination() != null) {
						// SoD
						GoalType g2 = ((GoalSetTypeMin2)g.eContainer()).getGoal().get(0).equals(g) ? ((GoalSetTypeMin2)g.eContainer()).getGoal().get(1) : ((GoalSetTypeMin2)g.eContainer()).getGoal().get(0);
						
						boolean found = false;
						for (SeparationOfDuty sod : mu.getActivitySoDs()) {
							if(sod.getOutgoingSecurityFlow().size() == 2){
								if (sod.getOutgoingSecurityFlow().get(0).getTargetRefNode().equals(e.getKey())) {
									if (info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(1).getTargetRefNode()) != null && info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(1).getTargetRefNode()).getValue().equals(g2.getValue())) {
										found = true;
										break;
									}
								}
								else if (sod.getOutgoingSecurityFlow().get(1).getTargetRefNode().equals(e.getKey())) {
									if (info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(0).getTargetRefNode()) != null && info.tasks2goals.get(sod.getOutgoingSecurityFlow().get(0).getTargetRefNode()).getValue().equals(g2.getValue())) {
										found = true;
										break;
									}
								}
							}							
						}
						
						if (!found) {
							allTaskMapsCorrect = false;
							if (!info.isGoalMapped(g2.getValue())) {
								logMessages += "WARNING:\tTask '"+ e.getKey().getName() +"' does not match the Separation of Duty requirement elicitated by Goal '"+ g.getValue() +"' with Goal'"+g2.getValue()+"'\n";
							}
							else {
								String logMsg = "\tTask '"+ e.getKey().getName() +"' does not match the Separation of Duty requirement elicitated by Goal '"+ g.getValue() +"' with Goal'"+g2.getValue()+"'\n";
								BodSodCorrection c = new BodSodCorrection(e.getKey(), info.getMappedTask(g2.getValue()), BodSodKind.SOD);
								boolean mustAdd = true;
								for (SecurityCorrection sc : corrections) {
									if (sc instanceof BodSodCorrection && ((BodSodCorrection)sc).getKind().equals(c.getKind())) {
										BodSodCorrection c2 = (BodSodCorrection)sc;
										if ((c.getTask1().equals(c2.getTask1()) && c.getTask2().equals(c2.getTask2())) || (c.getTask1().equals(c2.getTask2()) && c.getTask2().equals(c2.getTask1()))) {
											mustAdd = false;
										}
									}
								}
								
								if (mustAdd) {
									corrections.add(c);
									msgCorrections.put(c, logMsg);
								}
							}
						}
					}
				}
			}
		}
		
		if (!allTaskMapsCorrect) {
			showWarning1 = true;
			warningMessage1 += "Some mapped tasks do not match the security requirements of the goals.\n";
		}
		
		// 3.- Check that all Agents/Roles defined in the SRS are mapped
		boolean allActorsMapped = true;
		
		for (AgentType a : mu.getSRSAgents()) {
			if (a.getValue() != null && !a.getValue().equals("")) {
				boolean found = false;
				for (MappingInformation.RoleTriple rt : info.performers2roles) {
					if (rt.agent != null && rt.agent.getValue().equals(a.getValue())) {
						found = true;
						break;
					}
				}
				if (!found) {
					allActorsMapped = false;
					logMessages += "INFO:\t\tAgent '" + a.getValue() + "' was not mapped to a performer.\n";
				}
			}
		}
		for (RoleType r : mu.getSRSRoles()) {
			if (r.getValue() != null && !r.getValue().equals("")) {
				boolean found = false;
				for (MappingInformation.RoleTriple rt : info.performers2roles) {
					if (rt.role != null && rt.role.getValue().equals(r.getValue())) {
						found = true;
						break;
					}
				}
				if (!found) {
					allActorsMapped = false;
					logMessages += "INFO:\t\tRole '" + r.getValue() + "' was not mapped to a performer.\n";
				}
			}
		}
		
		if (!allActorsMapped) {
			showWarning2 = true;
			warningMessage2 += "Some actors have not been mapped to the Activiti model.\n";
		}
		
		// 4.- Check that all Documents defined in the SRS are mapped
		boolean allDocsMapped = true;
		
		for (DocType d : mu.getSRSDocuments()) {
			boolean found = false;
			for (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarCuadruple c : info.vars2docs) {
				if (c.doc.getValue().equals(d.getValue())) {
					found = true;
					break;
				}
			}
			if (!found) {
				allDocsMapped = false;
				logMessages += "INFO:\t\tDocument '" + d.getValue() + "' was not mapped to a variable in a task.\n";
			}
			
		}
		
		if (!allDocsMapped) {
			showWarning3 = true;
			warningMessage3 += "Current status: Not all the documents are mapped to Activity variables.\n";
			
		}
		
		// 5.- Check that documents are mapped to vars in tasks with the appropriate security requirements
		boolean allDocsMappedCorrectly = true;
		
		for (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarCuadruple c : info.vars2docs) {				
			Vector<DocType> docs = mu.getSRSDocsByName(c.doc.getValue());
			for (DocType d : docs) {
				if (d.eContainer() instanceof IntegrityType) {
					if((c instanceof eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple && ((eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple)c).var.getFieldname().equals("resultVariable")) ||
							(c instanceof eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple  && ((eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple)c).var.getType().equals("output"))){
						if (!(c.task instanceof ServiceTask) || ((ServiceTask)c.task).getSecurityExtensions() == null || ((ServiceTask)c.task).getSecurityExtensions().getIntegrityReq() == null || ((ServiceTask)c.task).getSecurityExtensions().getIntegrityReq().isEmpty()) {
							allDocsMappedCorrectly = false;
							String varName = "";
							String logMsg = "";
							if(c instanceof eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple){
								eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple varFieldExtensionCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple) c;
								varName = mu.getVarsInFieldExtension(varFieldExtensionCuadruple.var).get(c.index);
								logMsg = "\tTask '"+ c.task.getName() +"' does not match the integrity requirement elicitated for Document '"+ d.getValue() +"' associated to Variable '"+ varName +"'\n";
							}
							else{
								eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple varFormPropertyCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple) c;
								varName = varFormPropertyCuadruple.var.getName();
								logMsg = "\tTask '"+ c.task.getName() +"' does not match the integrity requirement elicitated for Document '"+ d.getValue() +"' associated to Variable '"+ varName +"'\n";
							}
							IntegrityCorrection ic = new IntegrityCorrection(c.task, varName);
							boolean mustAdd = true;
							for (SecurityCorrection sc : corrections) {
								if (sc instanceof IntegrityCorrection && ((IntegrityCorrection)sc).getTask().equals(ic.getTask()) && ((IntegrityCorrection)sc).getVar().equals(varName)) {
									mustAdd = false;
								}
							}
							
							if (mustAdd) {
								corrections.add(ic);
								msgCorrections.put(ic, logMsg);
							}
						}
					}						
				}
				if(d.eContainer() instanceof ConfidentialityType){
					if (!(c.task instanceof ServiceTask) || ((ServiceTask)c.task).getSecurityExtensions() == null || ((ServiceTask)c.task).getSecurityExtensions().getConfidentialityReq() == null || ((ServiceTask)c.task).getSecurityExtensions().getConfidentialityReq().isEmpty()) {
						allDocsMappedCorrectly = false;
						String varName, type, logMsg = "";
						if(c instanceof eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple){
							eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple varFieldExtensionCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFieldExtensionCuadruple) c;
							varName = mu.getVarsInFieldExtension(varFieldExtensionCuadruple.var).get(c.index);
							type = (varFieldExtensionCuadruple.var.getFieldname().equals("resultVariable") || varFieldExtensionCuadruple.var.getFieldname().equals("output")) ? "output" : "input";
							logMsg = "\tTask '"+ c.task.getName() +"' does not match the confidentiality requirement elicitated for Document '"+ d.getValue() +"' associated to Variable '"+ varName +"'\n";
						}
						else{
							eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple varFormPropertyCuadruple = (eu.aniketos.mtm.srs2activiti.wizard.MappingGeneratorWizard.MappingInformation.VarFormPropertyCuadruple) c;
							varName = varFormPropertyCuadruple.var.getName();
							type = varFormPropertyCuadruple.var.getType().equalsIgnoreCase("output") ? "output" : "input";
							logMsg = "\tTask '"+ c.task.getName() +"' does not match the confidentiality requirement elicitated for Document '"+ d.getValue() +"' associated to Variable '"+ varName +"'\n";
						}
						ConfidentialityCorrection cc = new ConfidentialityCorrection(c.task, type, varName);

						boolean mustAdd = true;
						for (SecurityCorrection sc : corrections) {
							if (sc instanceof ConfidentialityCorrection && ((ConfidentialityCorrection)sc).getTask().equals(cc.getTask()) && ((ConfidentialityCorrection)sc).getVar().equals(varName)) {
								mustAdd = false;
							}
						}

						if (mustAdd) {
							corrections.add(cc);
							msgCorrections.put(cc, logMsg);
						}
					}

				}
			}
		}
		
		if (!allDocsMappedCorrectly) {
			showWarning3 = true;
			warningMessage3 += "Current status: Not all the documents are mapped to a variable in a task with the adequate security requirements.\n";
			
		}
		
		// 6.- Check threats
		info.threats.clear();
		boolean allThreatMapsCorrect = true;
		Vector<ThreatType> srsThreats = mu.getSRSThreats();
		for (ThreatType tt : srsThreats) {
			Vector<ThreatEvent> threatList = mu.getActivityThreatsByRepositoryId(tt.getRepositoryID());
			List<Task> listForCorrection = new ArrayList<Task>();
			
			if(tt.getGoal() != null && tt.getGoal().size() >= 0){
				for (eu.aniketos.mtm.srs.GoalType g : tt.getGoal()) {
					Task t = info.getMappedTask(g.getValue());
					if(t !=null){
						boolean found = false;
						for (ThreatEvent threatEvent : threatList) {
							if(threatEvent.getAttachedToRef().equals(t) && t instanceof ServiceTask){
								found = true;
								info.mapThreat2Task(tt, (ServiceTask) t);
								break;
							}
						}
						if(!found){
							if(!listForCorrection.contains(t)){
								listForCorrection.add(t);	
							}											
						}	
					}
					else{
						allThreatMapsCorrect = false;
					}
				}
			}
			if(tt.getActor() != null && tt.getActor().size() >= 0){
				for (eu.aniketos.mtm.srs.ActorType a : tt.getActor()) {
					Vector<Task> tList = new Vector<Task>();
					if(a.getAgent() != null){
						tList = info.getTaskForMappedAgent(a.getAgent());
					}
					else if(a.getRole() != null){
						tList = info.getTaskForMappedRole(a.getRole());
					}
						
					for (Task t : tList) {
						boolean found = false;
						for (ThreatEvent threatEvent : threatList) {
							if(threatEvent.getAttachedToRef().equals(t) && t instanceof ServiceTask){
								found = true;
								info.mapThreat2Task(tt, (ServiceTask) t);
								break;
							}
						}
						if(!found){
							if(!listForCorrection.contains(t)){
								listForCorrection.add(t);	
							}				
						}	
					}
				}
			}
			if(tt.getDelegation() != null && tt.getDelegation().size() >= 0){
				for (DelType d : tt.getDelegation()) {
					for (eu.aniketos.mtm.srs.GoalType g : d.getGoalSet().getGoal()) {
						Task t = info.getMappedTask(g.getValue());
						if(t != null){
							boolean found = false;
							for (ThreatEvent threatEvent : threatList) {
								if(threatEvent.getAttachedToRef().equals(t) && t instanceof ServiceTask){
									found = true;
									info.mapThreat2Task(tt, (ServiceTask) t);
									break;
								}
							}
							if(!found){
								if(!listForCorrection.contains(t)){
									listForCorrection.add(t);	
								}			
							}	
						}
						else{
							allThreatMapsCorrect = false;
						}							
					}
				}
			}
			if(tt.getDocument() != null && tt.getDocument().size() >= 0){
				for (eu.aniketos.mtm.srs.DocType d : tt.getDocument()) {
					Vector<Task> tList = info.getTaskForMappedDoc(d);
					for (Task t : tList) {
						boolean found = false;
						for (ThreatEvent threatEvent : threatList) {
							if(threatEvent.getAttachedToRef().equals(t) && t instanceof ServiceTask){
								found = true;
								info.mapThreat2Task(tt, (ServiceTask) t);
								break;
							}
						}
						if(!found){
							if(!listForCorrection.contains(t)){
								listForCorrection.add(t);	
							}				
						}	
					}
				}
			}
			if(listForCorrection.size() > 0){
				allThreatMapsCorrect = false;
				if(listForCorrection.size() > 0){
					for (Task t : listForCorrection) {					
						if(t instanceof ServiceTask){
							String logMsg = "\tThreat "+tt.getName()+" (linked to the task "+ t.getName() +") was not mapped to a ThreatEvent.\n";
							ThreatCorrection tc = new ThreatCorrection((ServiceTask) t, tt);
							corrections.add(tc);
							msgCorrections.put(tc, logMsg);
						}
						else{
							logMessages += "WARNING:\tThreat "+tt.getName()+" (linked to the task "+ t.getName() +") was not mapped to a ThreatEvent. The task related to the threat is an user task, which cannot have a threat event linked.\n";
						}	
					}
				}
				else{
					logMessages += "WARNING:\tThreat "+tt.getName()+" was not mapped to a ThreatEvent. There is no task mapped to the goal related to the threat.\n";
				}				
			}
		}
		
		if (!allThreatMapsCorrect) {
			showWarning1 = true;
			warningMessage1 += "Not all the threats are mapped to an event linked to the correspondent task.\n";
			
		}
		// 7.- Show the warnings (if applicable)
		if (showWarning1) {
			((WizardPage)getPage("MapTasksToGoalsPage")).setErrorMessage(((WizardPage)getPage("MapTasksToGoalsPage")).getDescription() + "\n" + warningMessage1);
		}
		else {
			((WizardPage)getPage("MapTasksToGoalsPage")).setErrorMessage(null);
		}
		
		if (showWarning2) {
			((WizardPage)getPage("MapPerformersToActorsPage")).setErrorMessage(((WizardPage)getPage("MapPerformersToActorsPage")).getDescription() + "\n" + warningMessage2);
		}
		else {
			((WizardPage)getPage("MapPerformersToActorsPage")).setErrorMessage(null);
		}
		
		if (showWarning3) {
			((WizardPage)getPage("MapVariablesToDocsPage")).setErrorMessage(((WizardPage)getPage("MapVariablesToDocsPage")).getDescription() + "\n" + warningMessage3);
		}
		else {
			((WizardPage)getPage("MapVariablesToDocsPage")).setErrorMessage(null);
		}
	}
	
	private class SelectModelsPageWizardPage extends WizardPage {

		private Text elem1;
		private Button elem2;
		private Text elem7;
		private Button elem8;
		private Text elem10;
		private Button elem11;
		
		public SelectModelsPageWizardPage(String pageName) {
			super(pageName);
		}
		
		private void checkPageCompleted() {
			boolean isCompleted = srsModel != null && activitiModel != null && outputDir != null;
			if (outputDir != null) {
				File f = new File(outputDir);
				isCompleted &= f.exists() && f.isDirectory();
			}
			if (isCompleted && modelsChanged) {
				modelsChanged = false;
				((MapTasksToGoalsPage)getPage("MapTasksToGoalsPage")).refreshPageContents();
				((MapPerformersToActorsPage)getPage("MapPerformersToActorsPage")).refreshPageContents();
				((MapVariablesToDocsPage)getPage("MapVariablesToDocsPage")).refreshPageContents();
			}
			setPageComplete(isCompleted);
		}
		
		private boolean loadActiviti() {
			activitiModel = null;
			if (activitiModelPath == null || activitiModelPath.equals("")) {
				return false;
			}
			
			try {
				activitiModel = activityRS.getResource(URI.createFileURI(activitiModelPath), true);
				if (activitiModel == null) {
					return false;
				}
				TreeIterator<EObject> i = activitiModel.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof ServiceTask || o instanceof UserTask || o instanceof FieldExtension) {
						modelsChanged = true;
						return true;
					}
				}
			}
			catch (Exception e) {
				return false;
			}
			
			return false;
		}
		
		private boolean loadSRS() {
			srsModel = null;
			if (srsModelPath == null || srsModelPath.equals("")) {
				return false;
			}
			try {
				Resource r = rs.getResource(URI.createFileURI(srsModelPath), true);
				if (r == null) {
					return false;
				}
				TreeIterator<EObject> i = r.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof SecReqSpeType) {
						srsModel = (SecReqSpeType) o;
						modelsChanged = true;
					}
				}
			}
			catch (Exception e) {
				return false;
			}
			
			return (srsModel != null);
		}

		/* 
		 * createControl() method
		 * (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(6, true);
			topPanel.setLayout(layout);


			Label elem0 = new Label(topPanel, SWT.NONE);
			GridData elem0Data = new GridData(GridData.FILL_HORIZONTAL);
			elem0Data.horizontalSpan = 1;
			elem0.setText("SRS Model:");
			elem0.setLayoutData(elem0Data);

			elem1 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem1Data = new GridData(GridData.FILL_HORIZONTAL);
			elem1Data.horizontalSpan = 4;
			elem1.setText("");
			elem1.setLayoutData(elem1Data);
			elem1.setEnabled(false);

			elem2 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem2Data = new GridData(GridData.FILL_HORIZONTAL);
			elem2Data.horizontalSpan = 1;
			elem2.setText("Browse...");
			elem2.setLayoutData(elem2Data);
			elem2.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
					fd.setFilterExtensions(FILTERS_SRS);
					String file = fd.open();
					if (file != null) {
						srsModelPath = file;
						if (loadSRS()) {
							elem1.setText(file);
						}
						else {
							srsModelPath = null;
							elem1.setText("");
							MessageDialog.openError(getShell(), "Invalid SRS file", "The provided SRS file couldn't be loaded. Please select a valid SRS model.");
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
			
			Label elem6 = new Label(topPanel, SWT.NONE);
			GridData elem6Data = new GridData(GridData.FILL_HORIZONTAL);
			elem6Data.horizontalSpan = 1;
			elem6.setText("Activiti Model:");
			elem6.setLayoutData(elem6Data);

			elem7 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem7Data = new GridData(GridData.FILL_HORIZONTAL);
			elem7Data.horizontalSpan = 4;
			elem7.setText("");
			elem7.setLayoutData(elem7Data);
			elem7.setEnabled(false);


			elem8 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem8Data = new GridData(GridData.FILL_HORIZONTAL);
			elem8Data.horizontalSpan = 1;
			elem8.setText("Browse...");
			elem8.setLayoutData(elem8Data);
			elem8.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
					fd.setFilterExtensions(FILTERS_ACTIVITI);
					String file = fd.open();
					if (file != null) {
						activitiModelPath = file;
						if (loadActiviti()) {
							elem7.setText(file);
						}
						else {
							activitiModelPath = null;
							elem7.setText("");
							MessageDialog.openError(getShell(), "Invalid activiti file", "The provided activiti file couldn't be loaded. Please select a valid activiti model.");
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
			
			Label separator = new Label(topPanel, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
			GridData sepData = new GridData(GridData.FILL_HORIZONTAL);
			sepData.horizontalSpan = 6;
			separator.setLayoutData(sepData);
			
			Label elem9 = new Label(topPanel, SWT.NONE);
			GridData elem9Data = new GridData(GridData.FILL_HORIZONTAL);
			elem9Data.horizontalSpan = 1;
			elem9.setText("Output path:");
			elem9.setLayoutData(elem9Data);

			elem10 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem10Data = new GridData(GridData.FILL_HORIZONTAL);
			elem10Data.horizontalSpan = 4;
			elem10.setText("");
			elem10.setLayoutData(elem10Data);
			elem10.setEnabled(false);


			elem11 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem11Data = new GridData(GridData.FILL_HORIZONTAL);
			elem11Data.horizontalSpan = 1;
			elem11.setText("Browse...");
			elem11.setLayoutData(elem11Data);
			elem11.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog dd = new DirectoryDialog(getShell(), SWT.OPEN);
					String folder = dd.open();
					if (folder != null) {
						outputDir = folder;
						elem10.setText(folder);
					}
					else {
						outputDir = null;
						elem10.setText("");
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});

			// Set the title & description
			setTitle("Select the models to be mapped");
			setDescription("Select the SRS model (.xml) and the Activiti model (.activiti) you want to map. \n Select the Output path for the mapping model and the inconsistencies report (empty report if none).");
			
			// Set the control
			setControl(topPanel);
			
			// Set page completion...
			setPageComplete(false);
		}
	}
	
	private class MapTasksToGoalsPage extends WizardPage {

		private ScrolledComposite sc;
		private Composite topPanel;
		
		public MapTasksToGoalsPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			sc = new ScrolledComposite(parent, SWT.V_SCROLL);
			topPanel = new Composite(sc, SWT.NONE);
			GridLayout layout = new GridLayout(7, true);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Define the mapping rules for the Activiti tasks");
			setDescription("Select the mapping rules that will be used to link Activiti tasks and SRS goals.");

			// Set the control
			setControl(sc);
			sc.setContent(topPanel);
			sc.setAlwaysShowScrollBars(true);

			// Set page completion...
			setPageComplete(true);
		}
		
		public void refreshPageContents() {
			// Clear current contents
			for (Control c : topPanel.getChildren()) {
				c.dispose();
			}
			
			// Gather required information
			ModelingUtils mu = ModelingUtils.configure(srsModel, null, activitiModel);
			Vector<Task> tasks = mu.getActivityTasks(); 
			Vector<GoalType> goals = mu.getSRSGoals();
			
			Label leftLabel = new Label(topPanel, SWT.NONE);
			GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
			leftData.horizontalSpan = 5;
			leftLabel.setLayoutData(leftData);
			leftLabel.setText("Activiti Tasks:");
			
			Label rightLabel = new Label(topPanel, SWT.NONE);
			GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
			rightData.horizontalSpan = 2;
			rightLabel.setLayoutData(rightData);
			rightLabel.setText("SRS Goals:");
			
			// Rebuild the page
			for (Task t : tasks) {
				Label nameLabel = new Label(topPanel, SWT.NONE);
				GridData nameLabelData = new GridData(GridData.FILL_HORIZONTAL);
				nameLabelData.horizontalSpan = 3;
				nameLabel.setLayoutData(nameLabelData);
				nameLabel.setText(t.getName());
				
				Label arroyLabel = new Label(topPanel, SWT.CENTER);
				GridData arrowLabelData = new GridData(GridData.FILL_HORIZONTAL);
				arrowLabelData.horizontalSpan = 2;
				arroyLabel.setLayoutData(arrowLabelData);
				arroyLabel.setText("----------->");
				
				Combo goalsCombo = new Combo(topPanel, SWT.NONE | SWT.READ_ONLY);
				GridData goalsComboData = new GridData(GridData.FILL_HORIZONTAL);
				goalsComboData.horizontalSpan = 2;
				goalsCombo.setLayoutData(goalsComboData);
				
				goalsCombo.add("None - N/A");
				for (GoalType g : goals) {
					goalsCombo.add(g.getValue());
				}
				goalsCombo.select(0);
				
				goalsCombo.addSelectionListener(new GoalComboChangeListener(t, goals));
			}
			
			setPageComplete(true);
			
			sc.setExpandVertical(true);
			sc.setExpandHorizontal(true);
			//sc.setMinSize(sc.getParent().computeSize(SWT.DEFAULT, SWT.DEFAULT));
			topPanel.layout();
			sc.setMinHeight(topPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			sc.layout();
			
			// Clear the info
			info.getTasks2goals().clear();
			updateWarningMessage();
		}
		
	}
	
	private class MapPerformersToActorsPage extends WizardPage {

		private ScrolledComposite sc;
		private Composite topPanel;
		
		public MapPerformersToActorsPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			sc = new ScrolledComposite(parent, SWT.V_SCROLL);
			topPanel = new Composite(sc, SWT.NONE);
			GridLayout layout = new GridLayout(7, true);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Define the mapping rules for the Activiti performers");
			setDescription("Select the mapping rules that will be used to link Activiti performers and SRS actors and roles.");

			// Set the control
			setControl(sc);
			sc.setContent(topPanel);
			sc.setAlwaysShowScrollBars(true);

			// Set page completion...
			setPageComplete(true);
		}
		
		public void refreshPageContents() {
			// Clear current contents
			for (Control c : topPanel.getChildren()) {
				c.dispose();
			}
			
			// Gather required information
			ModelingUtils mu = ModelingUtils.configure(srsModel, null, activitiModel);
			Vector<RoleType> roles = mu.getSRSRoles();
			Vector<AgentType> agents = mu.getSRSAgents();
			Map<Task, String> performers = mu.getActivityPerformers();
			
			Label leftLabel = new Label(topPanel, SWT.NONE);
			GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
			leftData.horizontalSpan = 5;
			leftLabel.setLayoutData(leftData);
			leftLabel.setText("Activiti Performers:");
			
			Label rightLabel = new Label(topPanel, SWT.NONE);
			GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
			rightData.horizontalSpan = 2;
			rightLabel.setLayoutData(rightData);
			rightLabel.setText("SRS Actors/Roles:");
			
			// Rebuild the page			
			for (Task t : performers.keySet()) {
				String performer = performers.get(t);

				Label nameLabel = new Label(topPanel, SWT.NONE);
				GridData nameLabelData = new GridData(GridData.FILL_HORIZONTAL);
				nameLabelData.horizontalSpan = 3;
				nameLabel.setLayoutData(nameLabelData);
				nameLabel.setText(performer +" (in task " +t.getName() + ")");

				Label arroyLabel = new Label(topPanel, SWT.CENTER);
				GridData arrowLabelData = new GridData(GridData.FILL_HORIZONTAL);
				arrowLabelData.horizontalSpan = 2;
				arroyLabel.setLayoutData(arrowLabelData);
				arroyLabel.setText("----------->");

				Combo rolesCombo = new Combo(topPanel, SWT.NONE | SWT.READ_ONLY);
				GridData rolesComboData = new GridData(GridData.FILL_HORIZONTAL);
				rolesComboData.horizontalSpan = 2;
				rolesCombo.setLayoutData(rolesComboData);

				rolesCombo.add("None - N/A");
				for (RoleType r : roles) {
					if (r.getValue() != null && !r.getValue().equals("")) {
						rolesCombo.add("Role: "+ r.getValue());
					}
				}
				for (AgentType r : agents) {
					if (r.getValue() != null && !r.getValue().equals("")) {
						rolesCombo.add("Agent: "+ r.getValue());
					}
				}
				rolesCombo.select(0);

				rolesCombo.addSelectionListener(new RoleActorComboChangeListener(performer, t, roles, agents));
			}
			
			setPageComplete(true);
			
			sc.setExpandVertical(true);
			sc.setExpandHorizontal(true);
			//sc.setMinSize(sc.getParent().computeSize(SWT.DEFAULT, SWT.DEFAULT));
			topPanel.layout();
			sc.setMinHeight(topPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			sc.layout();
			
			// Clear the info
			info.getPerformers2roles().clear();
			updateWarningMessage();
		}
		
	}
	
	private class MapVariablesToDocsPage extends WizardPage {
		
		private ScrolledComposite sc;
		private Composite topPanel;
		
		public MapVariablesToDocsPage(String pageName) {
			super(pageName);
		}
		
		@Override
		public boolean canFlipToNextPage() {
			return false;
		}

		@Override
		public void createControl(Composite parent) {
			sc = new ScrolledComposite(parent, SWT.V_SCROLL);
			topPanel = new Composite(sc, SWT.NONE);
			GridLayout layout = new GridLayout(7, true);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Define the mapping rules for the Activiti variables");
			setDescription("Select the mapping rules that will be used to link Activiti variables and SRS documents.");

			// Set the control
			setControl(sc);
			sc.setContent(topPanel);
			sc.setAlwaysShowScrollBars(true);
			//sc.setMinSize(topPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT));

			// Set page completion...
			setPageComplete(false);
		}
		
		public void refreshPageContents() {
			//sc.setContent(null);
			// Clear current contents
			for (Control c : topPanel.getChildren()) {
				c.dispose();
			}

			// Gather required information
			ModelingUtils mu = ModelingUtils.configure(srsModel, null, activitiModel);
			Vector<DocType> docs = mu.getSRSDocuments();
			Vector<FieldExtension> vars = mu.getActivityVariables();
			Vector<FormProperty> formProperties = mu.getFormProperties();
			
			Label leftLabel = new Label(topPanel, SWT.NONE);
			GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
			leftData.horizontalSpan = 5;
			leftLabel.setLayoutData(leftData);
			leftLabel.setText("Activiti Variables:");
			
			Label rightLabel = new Label(topPanel, SWT.NONE);
			GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
			rightData.horizontalSpan = 2;
			rightLabel.setLayoutData(rightData);
			rightLabel.setText("SRS Documents:");

			// Rebuild the page
			for (FieldExtension var : vars) {
				Vector<Task> tasks = mu.getTasksUsingVariable(var);
				for (Task t : tasks) {
					Vector<String> varNames = mu.getVarsInFieldExtension(var);
					String type = var.getFieldname().equals("resultVariable")? "result" : var.getFieldname();
					
					for (int i = 0; i < varNames.size(); i++) {

						Label nameLabel = new Label(topPanel, SWT.NONE);
						GridData nameLabelData = new GridData(GridData.FILL_HORIZONTAL);
						nameLabelData.horizontalSpan = 3;
						nameLabel.setLayoutData(nameLabelData);
						nameLabel.setText(varNames.get(i) + "("+ type +" variable) in task " + t.getName());

						Label arroyLabel = new Label(topPanel, SWT.CENTER);
						GridData arrowLabelData = new GridData(GridData.FILL_HORIZONTAL);
						arrowLabelData.horizontalSpan = 2;
						arroyLabel.setLayoutData(arrowLabelData);
						arroyLabel.setText("----------->");

						Combo docsCombo = new Combo(topPanel, SWT.NONE | SWT.READ_ONLY);
						GridData docsComboData = new GridData(GridData.FILL_HORIZONTAL);
						docsComboData.horizontalSpan = 2;
						docsCombo.setLayoutData(docsComboData);

						docsCombo.add("None - N/A");
						for (DocType d : docs) {
							docsCombo.add(d.getValue());
						}
						docsCombo.select(0);

						docsCombo.addSelectionListener(new VarComboChangeListener(var, i, t, docs));

					}
				}
			}
			for (FormProperty formProperty : formProperties) {
				UserTask t = mu.getTaskUsingFormProperty(formProperty);
				
				if(t != null){
					Label nameLabel = new Label(topPanel, SWT.NONE);
					GridData nameLabelData = new GridData(GridData.FILL_HORIZONTAL);
					nameLabelData.horizontalSpan = 3;
					nameLabel.setLayoutData(nameLabelData);
					nameLabel.setText(formProperty.getName()  + "("+ formProperty.getType() + " variable) in task " + t.getName());

					Label arroyLabel = new Label(topPanel, SWT.CENTER);
					GridData arrowLabelData = new GridData(GridData.FILL_HORIZONTAL);
					arrowLabelData.horizontalSpan = 2;
					arroyLabel.setLayoutData(arrowLabelData);
					arroyLabel.setText("----------->");

					Combo docsCombo = new Combo(topPanel, SWT.NONE | SWT.READ_ONLY);
					GridData docsComboData = new GridData(GridData.FILL_HORIZONTAL);
					docsComboData.horizontalSpan = 2;
					docsCombo.setLayoutData(docsComboData);

					docsCombo.add("None - N/A");
					for (DocType d : docs) {
						docsCombo.add(d.getValue());
					}
					docsCombo.select(0);

					docsCombo.addSelectionListener(new VarFomPropertyComboChangeListener(formProperty, 0, t, docs));
				}
			}
			
			setPageComplete(false);
			
			sc.setExpandVertical(true);
			sc.setExpandHorizontal(true);
			//sc.setMinSize(sc.getParent().computeSize(SWT.DEFAULT, SWT.DEFAULT));
			topPanel.layout();
			sc.setMinHeight(topPanel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			sc.layout();
			
			// Clear the info
			info.getVars2docs().clear();
			updateWarningMessage();
		}
		
		public void onAppear(){
			setPageComplete(true);
		}
		
	}
	
	private class MappingInformation {
		
		private HashMap<Task, GoalType> tasks2goals;
		private Vector<RoleTriple> performers2roles;
		private Vector<VarCuadruple> vars2docs;
		private HashMap<ServiceTask, Vector<ThreatType>> threats;
		
		public MappingInformation() {
			tasks2goals = new HashMap<Task, GoalType>();
			performers2roles = new Vector<RoleTriple>();
			vars2docs = new Vector<VarCuadruple>();
			threats = new HashMap<ServiceTask,  Vector<ThreatType>>();
		}
		
		public boolean isGoalMapped(String goal) {
			for (Entry<Task, GoalType> e : tasks2goals.entrySet()) {
				if (e.getValue().getValue() != null && e.getValue().getValue().equals(goal)) {
					return true;
				}
			}
			return false;
		}
		
		public Task getMappedTask(String goal) {
			for (Entry<Task, GoalType> e : tasks2goals.entrySet()) {
				if (e.getValue().getValue() != null && e.getValue().getValue().equals(goal)) {
					return e.getKey();
				}
			}
			return null;
		}
		
		public Vector<Task> getTaskForMappedAgent (AgentType agent) {
			Vector<Task> ret = new Vector<Task>();
			for (RoleTriple roleTriple : performers2roles) {
				if(roleTriple.agent != null && roleTriple.agent.getValue().equals(agent.getValue())){
					ret.add(roleTriple.task);
				}
			}
			
			return ret;
		}
		
		public Vector<Task> getTaskForMappedRole (RoleType role) {
			Vector<Task> ret = new Vector<Task>();
			for (RoleTriple roleTriple : performers2roles) {
				if(roleTriple.role != null && roleTriple.role.getValue().equals(role.getValue())){
					ret.add(roleTriple.task);
				}
			}
			
			return ret;
		}
		
		public Vector<Task> getTaskForMappedDoc (DocType doc) {
			Vector<Task> ret = new Vector<Task>();
			for (VarCuadruple varCuadruple : vars2docs) {
				if(varCuadruple.doc != null && varCuadruple.doc.getValue().equals(doc.getValue())){
					ret.add(varCuadruple.task);
				}
			}
			
			return ret;
		}

		public void mapTask2Goal(Task t, GoalType g) {
			tasks2goals.put(t, g);
		}
		
		public void unmapTask(Task t) {
			tasks2goals.remove(t);
		}
		
		public void mapPerformer2Role(String perf, Task t, RoleType role) {
			performers2roles.add(new RoleTriple(perf, t, role));
		}
		
		public void mapPerformer2Agent(String perf, Task t, AgentType agent) {
			performers2roles.add(new RoleTriple(perf, t, agent));
		}
		
		public void unmapPerformer(String perf, Task t) {
			RoleTriple tbr = null;
			for (RoleTriple r : performers2roles) {
				if (r.getPerformer().equals(perf) && r.task.equals(t)) {
					tbr = r;
					break;
				}
			}
			if (tbr != null) {
				performers2roles.remove(tbr);
			}
		}
		
		public void mapVar2Doc(FieldExtension v, int index, Task t, DocType d) {
			vars2docs.add(new VarFieldExtensionCuadruple(v, index, t, d));
		}
		
		public void unmapVar(FieldExtension v, int index, Task t) {
			VarCuadruple tbr = null;
			for (VarCuadruple var : vars2docs) {
				if(var instanceof VarFieldExtensionCuadruple){
					if (((VarFieldExtensionCuadruple)var).var.equals(v) && var.index == index && var.task.equals(t)) {
						tbr = var;
						break;
					}
				}
				
			}
			if (tbr != null) {
				vars2docs.remove(tbr);
			}
		}
		
		public void mapVar2Doc(FormProperty fp, int index, Task t, DocType d) {
			vars2docs.add(new VarFormPropertyCuadruple(fp, index, t, d));
		}
		
		public void unmapVar(FormProperty fp, int index, Task t) {
			VarCuadruple tbr = null;
			for (VarCuadruple var : vars2docs) {
				if(var instanceof VarFormPropertyCuadruple){
					if (((VarFormPropertyCuadruple)var).var.equals(fp) && var.index == index && var.task.equals(t)) {
						tbr = var;
						break;
					}
				}
				
			}
			if (tbr != null) {
				vars2docs.remove(tbr);
			}
		}
		
		public void mapThreat2Task (ThreatType tt, ServiceTask t){
			Vector<ThreatType> ttList = threats.get(t);
			if(ttList == null){
				ttList = new Vector<ThreatType>();
				if(!ttList.contains(tt)){
					ttList.add(tt);
				}				
				threats.put(t, ttList);
			}
			else{
				if(!ttList.contains(tt)){
					ttList.add(tt);
				}
			}			
		}
		
		public HashMap<Task, GoalType> getTasks2goals() {
			return tasks2goals;
		}

		public Vector<RoleTriple> getPerformers2roles() {
			return performers2roles;
		}

		public Vector<VarCuadruple> getVars2docs() {
			return vars2docs;
		}

		public class RoleTriple {
			
			private String username;
			private String rolename;
			private Task task;
			private RoleType role;
			private AgentType agent;
			
			public RoleTriple(String p, Task t, RoleType r) {
				username = getUsername(p);
				rolename = getRolename(p);
				task = t;
				role = r;
			}
			
			public RoleTriple(String p, Task t, AgentType a) {
				username = getUsername(p);
				rolename = getRolename(p);
				task = t;
				agent = a;
			}
			
			public String getPerformer (){
				String performer = "Role: " + rolename;
				if(username != null){
					performer = "Name: " + username + " / " + performer;
				}
				return performer;
			}
			
			private String getUsername (String performer){
				String[] splittedPerformer = performer.split("/");
				for (int i = 0; i < splittedPerformer.length; i++) {
					String e = splittedPerformer[i];
					if(e.startsWith("Name:")){
						return e.substring(e.lastIndexOf("Name:")).trim();						
					}	
				}
				return null;
			}
			
			private String getRolename (String performer){
				String[] splittedPerformer = performer.split("/");
				for (int i = 0; i < splittedPerformer.length; i++) {
					String e = splittedPerformer[i];
					if(e.startsWith("Role:")){
						return e.substring(e.lastIndexOf("Role:")).trim();						
					}	
				}
				return null;
			}
		}
		
		public abstract class VarCuadruple {
			protected int index;
			protected Task task;
			protected DocType doc;			
		}
		
		public class VarFieldExtensionCuadruple extends VarCuadruple {
			
			private FieldExtension var;
						
			public VarFieldExtensionCuadruple(FieldExtension v, int index, Task t, DocType d) {
				var = v;
				this.index = index;
				task = t;
				doc = d;
			}			
		}
		
		public class VarFormPropertyCuadruple extends VarCuadruple {
			
			private FormProperty var;
			
			public VarFormPropertyCuadruple(FormProperty v, int index, Task t, DocType d) {
				var = v;
				this.index = index;
				task = t;
				doc = d;
			}
			
		}
	}
	
	private class GoalComboChangeListener implements SelectionListener {

		private Task t;
		private Vector<GoalType> goals;
		
		public GoalComboChangeListener(Task t, Vector<GoalType> goals) {
			this.t = t;
			this.goals = goals;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			int sel = ((Combo)e.widget).getSelectionIndex();
			info.unmapTask(t);
			if (sel > 0) {
				info.mapTask2Goal(t, goals.get(sel - 1));
			}
			updateWarningMessage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
		
	}
	
	private class RoleActorComboChangeListener implements SelectionListener {

		private String p;
		private Task t;
		private Vector<RoleType> roles;
		private Vector<AgentType> agents;
		
		public RoleActorComboChangeListener(String performer, Task t, Vector<RoleType> roles, Vector<AgentType> agents) {
			this.p = performer;
			this.t = t;
			this.roles = roles;
			this.agents = agents;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			int sel = ((Combo)e.widget).getSelectionIndex();
			info.unmapPerformer(p, t);
			if (sel > 0) {
				if ((sel-1) < roles.size()) {
					info.mapPerformer2Role(p, t, roles.get(sel-1));
				}
				else {
					info.mapPerformer2Agent(p, t, agents.get(sel-roles.size()-1));
				}
			}
			updateWarningMessage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
		
	}
	
	private class VarComboChangeListener implements SelectionListener {

		private FieldExtension v;
		private int index;
		private Task t;
		private Vector<DocType> docs;
		
		public VarComboChangeListener(FieldExtension v, int index, Task t, Vector<DocType> docs) {
			this.v = v;
			this.index = index;
			this.t = t;
			this.docs = docs;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			int sel = ((Combo)e.widget).getSelectionIndex();
			info.unmapVar(v, index, t);
			if (sel > 0) {
				info.mapVar2Doc(v, index, t, docs.get(sel-1));
			}
			updateWarningMessage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
		
	}
	
	private class VarFomPropertyComboChangeListener implements SelectionListener {

		private FormProperty fp;
		private int index;
		private Task t;
		private Vector<DocType> docs;
		
		public VarFomPropertyComboChangeListener(FormProperty fp, int index, Task t, Vector<DocType> docs) {
			this.fp = fp;
			this.index = index;
			this.t = t;
			this.docs = docs;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			int sel = ((Combo)e.widget).getSelectionIndex();
			info.unmapVar(fp, index, t);
			if (sel > 0) {
				info.mapVar2Doc(fp, index, t, docs.get(sel-1));
			}
			updateWarningMessage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
		
	}

}
