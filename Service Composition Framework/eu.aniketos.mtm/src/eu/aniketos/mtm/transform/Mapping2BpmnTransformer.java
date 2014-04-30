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
package eu.aniketos.mtm.transform;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import es.esi.gemde.modeltransformator.ModelTransformatorPlugin;
import es.esi.gemde.modeltransformator.service.IModelTransformationService;
import eu.aniketos.mtm.Activator;
import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.DocType;
import eu.aniketos.mtm.mapping.DocumentRoot;
import eu.aniketos.mtm.mapping.IntegrityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.SRRType;
import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.mapping.VarType;
import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Definitions;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowElement;
import eu.aniketos.mtm.model.mtm_bpmn2.FormProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.HumanPerformer;
import eu.aniketos.mtm.model.mtm_bpmn2.Process;
import eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask;
import eu.aniketos.mtm.model.mtm_bpmn2.UserTask;
import eu.aniketos.mtm.util.BpmnManager;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.MofscriptUtils;
import eu.aniketos.mtm.util.Which;
import eu.aniketos.mtm.utils.Utils;

/**
 * 
 * Class that perform the transformation from a mapping model to a BPMN model.
 * The transformation is takes place in 2 steps:
 * 1. A base transformation described in the MOFscript mapping2activiti.m2t, performed using an extension to the GEMDE plugin.
 * 2. A second transformation in pure Java to work with model elements that MOFscript can't deal with.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class Mapping2BpmnTransformer {
	private final static String ENGINE_NAME = "MOFScript";
	private final static String TRANSFORMATION_NAME = "mapping2activiti";
	
	// This constant should be parametrized or programmatically determined (only used in development environment)
	//private final static String WORKSPACE_PATH = "c:\\tecnalia\\src\\ws_aniketos\\ws_mtm\\";

	private IModelTransformationService mts;
	
	private String classpath = "";
	
	private Map<String, String> confAlgorithms = new HashMap<String, String>();
	
	/**
	 * Public constructor.
	 */
	public Mapping2BpmnTransformer() {
		initClasspath();
		mts = ModelTransformatorPlugin.getService();
		confAlgorithms.put("low", "Basic128Sha256Rsa15");
		confAlgorithms.put("medium", "Basic192Sha256Rsa15");
		confAlgorithms.put("strong", "Basic256Sha256Rsa15");
	}
	
	/**
	 * Initializes the classpath needed by the MOFscript to perform calls to {@link MofscriptUtils} Java methods.
	 */
	private void initClasspath() {
		try {
			// Programmatically get the classpath jar files from classes needed from eu.aniketos.mtm.
			classpath = "";
			classpath += Which.jarFile(MofscriptUtils.class).toString();
			classpath += ";" + Which.jarFile(HumanPerformer.class).toString();
			classpath += ";" + Which.jarFile(FormProperty.class).toString();
		} catch(Exception e) {
			// Development classpath
			classpath = "";
			classpath += Platform.getBundle(Activator.PLUGIN_ID).getLocation().replace("reference:file:", "") + "bin/".replace('/', File.separatorChar);
//			classpath += ";" + WORKSPACE_PATH + "eu.aniketos.mtm.bpmn20extended/bin/".replace('/', File.separatorChar);
//			classpath += ";" + WORKSPACE_PATH + "eu.aniketos.mtm.activiti/bin/".replace('/', File.separatorChar);
		}
		
		try {
			// Programmatically get the classpath jar files from classes needed from EMF
			classpath += ";" + Which.jarFile(EStructuralFeature.class).toString();
			classpath += ";" + Which.jarFile(Notifier.class).toString();
			classpath += ";" + Which.jarFile(EcoreResourceFactoryImpl.class).toString();
		} catch(Exception e) {
		}
	}

	/**
	 * Transforms from mapping to BPMN Activiti extended.
	 * @param document The mapping document root to transform.
	 * @param outputPath The path (without file name) of the output BPMN Activiti file.
	 * @param fileName The file name of of the output BPMN Activiti file.
	 */
	public void transform(DocumentRoot document, String outputPath, String fileName) {
		if (mts.transformationExists(TRANSFORMATION_NAME)) {
			try {
				ArrayList<EObject> inputs = new ArrayList<EObject>();
				inputs.add(document);
				// Output file name is passed to the MOFscript as a system property
				System.setProperty("ACTIVITI_FILE_NAME", fileName);
				// The classpath used for Java calls is passed to the MOFscript as a system property
				System.setProperty("UTILS_CLASSPATH", classpath);
				mts.executeTransformation(inputs, TRANSFORMATION_NAME, ENGINE_NAME, outputPath);
				
				// Perform from Java some transformations that can't be done from MOFScript.
				javaTransform(document.getMapping(), outputPath + File.separatorChar + fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Transforms from mapping to BPMN Activiti extended (2nd step).
	 * Performs transformations that can't be done from MOFscript.
	 * The pre-transformed BPMN Activiti file is used both as an input an as an output.
	 * @param mapping The mapping element to transform.
	 * @param path The complete path of the input/output BPMN Activiti file.
	 */
	private void javaTransform(MappingType mapping, String path) {
		try {		
			
			// Get the singletons for working with mapping and BPMN models
			BpmnManager bpmnManager = BpmnManager.getInstance();
			MappingManager mappingManager = MappingManager.getInstance();
			
			// Load the definitions root BPMN element from the specified path
			eu.aniketos.mtm.model.mtm_bpmn2.DocumentRoot documentRoot = bpmnManager.getDocumentRootImpl(path);
			Definitions definitions = documentRoot.getDefinitions();	
			// Extracts the first (and presumibly only) process element from the definitions
			Process process = bpmnManager.getProcess(definitions);
			
			if(process == null) {
				return;
			}
			
			// RepresentsType list with variable new IDs
			List<IsaType> newIsaTypes = new ArrayList<IsaType>();
			List<PlaysType> newPlaysTypes = new ArrayList<PlaysType>();
			List<RepresentsType> newRepresenList = new ArrayList<RepresentsType>();
			Map<String, List<VarType>> mapVar = new HashMap<String, List<VarType>>();
			
			// Iterate through all relatesTo elements in mapping model to access to goal/task relationships
			EList<RelatesToType> rtList = mapping.getRelatesTo();
			for(RelatesToType rt : rtList) {
				ActivityType activity = rt.getActivity();
				
				// Extract the corresponding task from the BPMN model
				FlowElement task = bpmnManager.getTask(process, activity.getId());
				if(task == null) {
					break;
				}
				
				if (task instanceof UserTask || task instanceof ServiceTask){
					// 1- Add participants to the tasks
					// Get the IDs of all the participants associated to the task from the mapping model
					EList<String> participantIdList = activity.getParticipant();
					List<String> newParticipants = new ArrayList<String>();
					for(String partId : participantIdList) {
						// Extract the corresponding participant element from the mapping model
						String newRoleId = null;
						// Check if exists user+role
						IsaType isaType = mappingManager.getIsaParticipantById(mapping, partId);
						if(isaType != null){
							newRoleId = Utils.generateUniqueID();
							String newUserid = Utils.generateUniqueID();
							bpmnManager.addParticipantToTask(task, newUserid, isaType.getBPPart().get(0).getValue(), newRoleId, isaType.getBPRole().get(0).getValue());
							newParticipants.add(newUserid);
							// Create a new IsaType with new ids
							BPPType bppType = mappingManager.createBPPart(newUserid, isaType.getBPPart().get(0).getValue(), isaType.getBPPart().get(0).getType());
							BPRType bprType = mappingManager.createBPRole(newRoleId, isaType.getBPRole().get(0).getValue(), isaType.getBPRole().get(0).getType());
							SRAType sraType = mappingManager.createSRAgent(isaType.getSRAgent().get(0).getId(), isaType.getSRAgent().get(0).getValue());
							newIsaTypes.add(mappingManager.createIsA(sraType, bppType, bprType));							
						}
						else{
							// Check if exists only role
							PlaysType playsType = mappingManager.getPlaysParticipantById(mapping, partId);
							newRoleId = Utils.generateUniqueID();
							newParticipants.add(newRoleId);
							bpmnManager.addRoleToTask(task, newRoleId, playsType.getBPPart().getValue());
							
							 // Create a new PlaysType with new id
							BPPType bppType = mappingManager.createBPPart(newRoleId, playsType.getBPPart().getValue(), playsType.getBPPart().getType());
							SRRType srrType = mappingManager.createSRRole(playsType.getSRRole().getId(), playsType.getSRRole().getValue());
							newPlaysTypes.add(mappingManager.createPlays(srrType, bppType));
						}				
						
						if(newRoleId != null && activity.getPermission() != null && activity.getPermission().size() > 0){
							for (PermissionType pt : activity.getPermission()) {
								pt.setRole(newRoleId);
							}
							
						}
					}
					activity.getParticipant().clear();
					activity.getParticipant().addAll(newParticipants);
					
					// 2- Add variables to the tasks
					// Get the IDs of all the variables associated to the task from the mapping model
					EList<ActivityVar> varList = activity.getVariable();
					for(ActivityVar activityVar : varList) {
						// Extract the corresponding variable element from the mapping model
						RepresentsType rep = mappingManager.getRepresentsByVarId(mapping, activityVar.getId());
						VarType var = rep.getVariable();
						// Associate the variable suitably to the (user/service) task in the BPMN model. Get ID
						String oldId = activityVar.getId();
						String id = bpmnManager.addVariableToTask(task, var.getValue(), activityVar.getType().getName());
						activityVar.setId(id);
						VarType newVar = null;
						// Create a new representsType for the variable - doc
						Vector<FieldExtension> fes = new Vector<FieldExtension>();
						if(task instanceof ServiceTask){
							ServiceTask serviceTask = (ServiceTask) task;
							for (FieldExtension fe : serviceTask.getFieldExtensions()) {
								if(fe.getId().equals(id)){
									fes.add(fe);
									break;
								}
							}
						}
						else if(task instanceof UserTask){
							UserTask userTask = (UserTask) task;
							if(activityVar.getType().equals(TypeType2.INPUT)){
								for (ActivitiListener activitiListener : userTask.getActivitiListeners()) {
									if(activitiListener.getImplementation().equals("eu.aniketos.tasklistener")){
										for (FieldExtension fe : activitiListener.getFieldExtensions()) {
											if(fe.getFieldname().equals("input")){
												fes.add(fe);
												break;
											}											
										}										
									}
								}
							}
							else{
								newVar = mappingManager.createVariable(id, var.getValue(), 0);
								List<DocType> newDocList = new ArrayList<DocType>();
								for (DocType doc : rep.getDocument()) {
									newDocList.add(mappingManager.createDocument(doc.getId(), doc.getValue()));
								}
								newRepresenList.add(mappingManager.createRepresents(newDocList, newVar));
							}
						}
						for (FieldExtension fe : fes) {
							// Get order (in case of Field extension with form ${vble1}~${vble2}...)
							int q = getVariablesQuantity (fe.getExpression());
							newVar = mappingManager.createVariable(id, var.getValue(), q-1);
							//  Clone Doc
							List<DocType> newDocList = new ArrayList<DocType>();
							for (DocType doc : rep.getDocument()) {
								newDocList.add(mappingManager.createDocument(doc.getId(), doc.getValue()));
							}
							newRepresenList.add(mappingManager.createRepresents(newDocList, newVar));
						}
						if(newVar != null){
							if(mapVar.get(oldId) != null){
								List<VarType> varTypes = mapVar.get(oldId);
								varTypes.add(newVar);
							}
							else{
								List<VarType> varTypes = new ArrayList<VarType>();
								varTypes.add(newVar);
								mapVar.put(oldId, varTypes);
							}
						}						
					}
					// Update ActivityVar List
					List<String> uniqueIds = new ArrayList<String>();
					List<ActivityVar> toRemove = new ArrayList<ActivityVar>();
					for (ActivityVar activityVar : varList) {
						if(uniqueIds.contains(activityVar.getId())){
							toRemove.add(activityVar);
						}
						else{
							if(activityVar.getConfidentiality() != null && activityVar.getConfidentiality().getAlgorithm() != null){
								activityVar.getConfidentiality().setAlgorithm(confAlgorithms.get(activityVar.getConfidentiality().getAlgorithm()));
							}
							uniqueIds.add(activityVar.getId());
						}
					}
					varList.removeAll(toRemove);
					
					// 3- Add confidentiality
					for (ActivityVar activityVar : varList) {
						if(activityVar.getType().equals(TypeType2.INPUT) && activityVar.getConfidentiality() != null){
							bpmnManager.addConfidentialityToServiceTask(task, activityVar.getType().getName(), activityVar.getConfidentiality().getAlgorithm());
						}
						else if(activityVar.getType().equals(TypeType2.OUTPUT) && activityVar.getConfidentiality() != null){
							bpmnManager.addConfidentialityToServiceTask(task, activityVar.getType().getName(), activityVar.getConfidentiality().getAlgorithm());
						}
					}
					
					// 4- Add trustworthiness to Service task
					if(task instanceof ServiceTask && activity.getTrustworthiness() != 0){
						bpmnManager.addTrustToServiceTask(task, activity.getTrustworthiness()+"");
					}
					
					// 5- Add integrity to Service task
					if(task instanceof ServiceTask && activity.getIntegrity().size() > 0){
						EList<IntegrityType> integrityTypes = activity.getIntegrity();
						for (IntegrityType integrityType : integrityTypes) {
							bpmnManager.addIntegrityToServiceTask(task, integrityType.getWith(), integrityType.getType(), integrityType.getAlgorithm());
						}
					}
					
									
				}
			}
			// Remove old IsATypes and add new ones in the mapping
			mapping.getIsA().clear();
			mapping.getIsA().addAll(newIsaTypes);

			// Remove old PlaysTypes and add new ones in the mapping
			mapping.getPlays().clear();
			mapping.getPlays().addAll(newPlaysTypes);

			// Remove old Represents and add new ones in the mapping
			mapping.getRepresents().clear();
			mapping.getRepresents().addAll(newRepresenList);
			
			for (RelatesToType relatesToType : rtList) {
				ActivityType activity = relatesToType.getActivity();
				// Update integrity var IDs in the mapping
				if(activity.getIntegrity() != null && activity.getIntegrity().size() > 0){
					for (IntegrityType integrityType : activity.getIntegrity()) {						
						List<VarType> varTypes = mapVar.get(integrityType.getVariable());
						for (VarType varType : varTypes) {
							for (ActivityVar activityVar : activity.getVariable()) {
								if(varType.getId().equals(activityVar.getId())){
									integrityType.setVariable(varType.getId());
									break;
								}
							}
						}
					}
				}
			}
			
			
			// Save the modified definitions root BMPN element to its original file
			bpmnManager.saveDefinitions(definitions, path);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getVariablesQuantity(String expression) {
		String [] splitted = expression.split("~");
		return splitted.length;
	}
	
	
}
