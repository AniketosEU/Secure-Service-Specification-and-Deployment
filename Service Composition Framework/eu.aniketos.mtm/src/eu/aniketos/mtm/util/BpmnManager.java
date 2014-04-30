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
package eu.aniketos.mtm.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.model.mtm_aniketos.AniketosFactory;
import eu.aniketos.mtm.model.mtm_aniketos.Confidentiality;
import eu.aniketos.mtm.model.mtm_aniketos.Integrity;
import eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension;
import eu.aniketos.mtm.model.mtm_aniketos.Trustworthiness;
import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Activity;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Factory;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;
import eu.aniketos.mtm.model.mtm_bpmn2.CandidateGroup;
import eu.aniketos.mtm.model.mtm_bpmn2.CandidateUser;
import eu.aniketos.mtm.model.mtm_bpmn2.Definitions;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowElement;
import eu.aniketos.mtm.model.mtm_bpmn2.FormProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.Process;
import eu.aniketos.mtm.model.mtm_bpmn2.RootElement;
import eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask;
import eu.aniketos.mtm.model.mtm_bpmn2.UserTask;
import eu.aniketos.mtm.model.mtm_bpmn2.impl.DocumentRootImpl;
import eu.aniketos.mtm.model.mtm_bpmn2.util.Bpmn2ResourceFactoryImpl;
import eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction;
import eu.aniketos.mtm.model.mtm_securebpmn2.AtomicActivityAction;
import eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty;
import eu.aniketos.mtm.model.mtm_securebpmn2.Permission;
import eu.aniketos.mtm.model.mtm_securebpmn2.Role;
import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Factory;
import eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty;
import eu.aniketos.mtm.utils.Utils;


/**
 * 
 * Singleton for managing complex operations over the BPMN Activiti model.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class BpmnManager {
	public final static String ROOT_ELEMENT = "definitions";
	
	private static BpmnManager bpmnManager = null;

	private ResourceSet resourceSet;
	private Bpmn2Package bpmn2Package;
	private Bpmn2Factory bpmn2Factory;
	private AniketosFactory aniketosFactory;
	private Securebpmn2Factory securebpmn2Factory;
	
	/**
	 * Returns an instance of the singleton.
	 * @return Instance of the singleton.
	 */
	public static BpmnManager getInstance() {
		if(bpmnManager == null) {
			bpmnManager = new BpmnManager();
		}
		return bpmnManager;
	}
	
	/**
	 * Private constructor.
	 */
	private BpmnManager() {
		bpmn2Package = Bpmn2Package.eINSTANCE;
		bpmn2Factory = Bpmn2Factory.eINSTANCE;	
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bpmn", new Bpmn2ResourceFactoryImpl());
		aniketosFactory = AniketosFactory.eINSTANCE;
		securebpmn2Factory = Securebpmn2Factory.eINSTANCE;
	}

	/**
	 * Creates a BPMN definitions root element.
	 * @return A new BPMN definitions root element.
	 */
	public Definitions createDefinitions() {
		return bpmn2Factory.createDefinitions();
	}

	public DocumentRootImpl getDocumentRootImpl (String path) throws IOException{
		Resource resource = resourceSet.createResource(URI.createFileURI(path));
		resource.load(Collections.EMPTY_MAP);
		DocumentRootImpl root = (DocumentRootImpl)resource.getContents().get(0);
		return root;
	}
	
	/**
	 * Saves a BPMN definitions root element into a file.
	 * @param definitions The BPMN definitions root element to be saved.
	 * @param path The target file path.
	 * @throws IOException
	 */
	public void saveDefinitions(Definitions definitions, String path) throws IOException {	
		Resource res = resourceSet.createResource(URI.createFileURI(path));
		DocumentRootImpl rootObject = createRootObject(definitions);
		res.getContents().add(rootObject);
		res.save(null);
	}
	
	public Resource addContentsDefinitions(Definitions definitions, String path) throws IOException {	
		Resource res = resourceSet.createResource(URI.createFileURI(path));
		DocumentRootImpl rootObject = createRootObject(definitions);
		res.getContents().add(rootObject);
		return res;
	}

	/**
	 * Creates a document root element that contains a given definitions element.
	 * @param definitions The definitions element to be added.
	 * @return The new root element containing the definitions.
	 */
	public DocumentRootImpl createRootObject(Definitions definitions) {	
		DocumentRootImpl rootObject = createInitialModel();
		rootObject.setDefinitions(definitions);
		return rootObject;
	}
	
	/**
	 * Return the first process element from a definitions root element.
	 * @param definitions The definitions element containing the process.
	 * @return The contained process element.
	 */
	public Process getProcess(Definitions definitions) {
		try {
			List<RootElement> rootElements = definitions.getRootElements();
			// TODO: Multiprocess
			for(RootElement element : rootElements) {
				if(element instanceof Process) {
					return (Process)element;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Creates a new document root element.
	 * @return The new document root element.
	 */
	private DocumentRootImpl createInitialModel() {
		EClass eClass = ExtendedMetaData.INSTANCE.getDocumentRoot(bpmn2Package);
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(ROOT_ELEMENT);
		EObject rootObject = bpmn2Factory.create(eClass);
		rootObject.eSet(eStructuralFeature, EcoreUtil.create((EClass)eStructuralFeature.getEType()));
		return ((DocumentRootImpl)rootObject);
	}
	
	/**
	 * Adds a participant to a user/service task in the defined format.
	 * @param task The target task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	public void addParticipantToTask(FlowElement task, String userid, String username, String roleid, String rolename) {
		if(task instanceof UserTask) {
			addUserToUserTask((UserTask)task, username);
			addRoleToUserTask((UserTask)task, rolename);
		} else if(task instanceof ServiceTask) {
			addUserToServiceTask((ServiceTask)task, userid, username);
			addRoleToServiceTask((ServiceTask)task, roleid, rolename);
		}
	}
	
	/**
	 * Adds a role to a user/service task in the defined format.
	 * @param task The target task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	public void addRoleToTask(FlowElement task, String roleid, String rolename) {
		if(task instanceof UserTask) {
			addRoleToUserTask((UserTask)task, rolename);
		} else if(task instanceof ServiceTask) {
			addRoleToServiceTask((ServiceTask)task, roleid, rolename);
		}
	}
	
	/**
	 * Sets an user task assignee.
	 * @param task The target user task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	private void addUserToUserTask(UserTask task,String name) {
		task.setAssignee(name);
	}
	
	/**
	 * Adds an user task candidate group.
	 * @param task The target user task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	private void addRoleToUserTask(UserTask task, String name) {
		CandidateGroup candidateGroup = bpmn2Factory.createCandidateGroup();
		candidateGroup.setGroup(name);
		task.getCandidateGroups().add(candidateGroup);
	}
	
	/**
	 * Adds an user task candidate user.
	 * @param task The target user task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	private void addUserToCandidateUserTask(UserTask task, String name) {
		CandidateUser candidateUser = bpmn2Factory.createCandidateUser();
		candidateUser.setUser(name);	
		task.getCandidateUsers().add(candidateUser);
	}
	
	/**
	 * Adds a "Service Provider" field to a service task.
	 * @param task The target service task.
	 * @param id The participant ID.
	 * @param name The participant name.
	 */
	private void addUserToServiceTask(ServiceTask task, String id, String name) {
		try {
			FieldExtension fieldExtension = bpmn2Factory.createFieldExtension();
			fieldExtension.setFieldname("RequestedServiceProvider");
			fieldExtension.setExpression(name);
			fieldExtension.setId(id);
			task.getFieldExtensions().add(fieldExtension);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addRoleToServiceTask(ServiceTask task, String id, String name) {
		try {
			FieldExtension fieldExtension = bpmn2Factory.createFieldExtension();
			fieldExtension.setFieldname("RequestedServiceProviderRole");
			fieldExtension.setExpression(name);
			fieldExtension.setId(id); 
			task.getFieldExtensions().add(fieldExtension);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a variable to a user/service task in the defined format.
	 * @param task The target task.
	 * @param id The variable ID.
	 * @param name The variable name.
	 */
	public String addVariableToTask(FlowElement task, String name, String type) {
		if(task instanceof UserTask) {
			return addVariableToUserTask((UserTask)task, name, type);
		} else if(task instanceof ServiceTask) {
			return addVariableToServiceTask((ServiceTask)task, name, type);
		}
		return null;
	}
	
	/**
	 * Adds a variable to a user task as a form property.
	 * @param task The target user task.
	 * @param id The variable ID.
	 * @param name The variable name.
	 */
	private String addVariableToUserTask(UserTask task, String name, String type) {		
		if(type.equals(TypeType2.OUTPUT.getName())){
			FormProperty formProperty = bpmn2Factory.createFormProperty();
			formProperty.setId("variable_"+Utils.generateUniqueID()); // Set unique id in BPMN
			formProperty.setName(name);
			formProperty.setType("output");
			task.getFormProperties().add(formProperty);
			return formProperty.getId();
		}
		else{
			String id = null;
			// set input: create an activitiListener and field extension "input" with form ${vble1}~${vble2}...
			if(task.getActivitiListeners() != null && task.getActivitiListeners().size() > 0){
				boolean activitiListenerFound = false;
				for (ActivitiListener activitiListener : task.getActivitiListeners()) {
					if(activitiListener.getImplementation().equals("eu.aniketos.tasklistener")){
						if(activitiListener.getFieldExtensions() != null && activitiListener.getFieldExtensions().size() > 0){
							boolean fieldExtensionFound = false;
							for (FieldExtension fieldExtension : activitiListener.getFieldExtensions()) {
								if(fieldExtension.getFieldname().equals("input")){
									// Add variable
									fieldExtension.setExpression(fieldExtension.getExpression() + "~${" + name + "}");
									id = fieldExtension.getId();
								}
								fieldExtensionFound = true;
								break;
							}
							if(!fieldExtensionFound){
								// Create field extension "input"
								FieldExtension fieldExtension = createInputFieldExtension("variable_"+Utils.generateUniqueID(), name);
								activitiListener.getFieldExtensions().add(fieldExtension);
								id = fieldExtension.getId();
							}
						}	
						activitiListenerFound = true;
						break;
					}
				}
				if(!activitiListenerFound){
					// create Activiti Listener
					id = "variable_"+Utils.generateUniqueID();
					ActivitiListener activitiListener = createActivitiListenerforInputVariable(id, name, type);
					task.getActivitiListeners().add(activitiListener);
				}
			}
			else{
				// create Activiti Listener
				id = "variable_"+Utils.generateUniqueID();
				ActivitiListener activitiListener = createActivitiListenerforInputVariable(id, name, type);
				task.getActivitiListeners().add(activitiListener);
			}	
			return id;
		}		
	}
	
	private ActivitiListener createActivitiListenerforInputVariable (String id, String name, String type){
		ActivitiListener activitiListener = bpmn2Factory.createActivitiListener();
		activitiListener.setEvent("create");
		activitiListener.setImplementationType("classType");
		activitiListener.setImplementation("eu.aniketos.tasklistener");
		
		// Create field extension "input"
		FieldExtension fieldExtension = createInputFieldExtension(id, name);
		activitiListener.getFieldExtensions().add(fieldExtension);
		
		return activitiListener;
	}
	
	private FieldExtension createInputFieldExtension (String id, String name){
		FieldExtension fieldExtension = bpmn2Factory.createFieldExtension();
		fieldExtension.setFieldname("input");
		fieldExtension.setId(id);
		fieldExtension.setExpression("${" + name + "}");
		return fieldExtension;
	}

	
	/**
	 * Adds a variable to a service task as an "input" field.
	 * @param task The target service task.
	 * @param id The variable ID.
	 * @param name The variable name.
	 */
	private String addVariableToServiceTask(ServiceTask task, String name, String type) {	
		String id = null;
		if(type.equals(TypeType2.INPUT.getName())){
			// Set input: ${vble1}~${vble2}...
			FieldExtension fieldExtension = null;
			for (FieldExtension fExtension : task.getFieldExtensions()) {
				if(fExtension.getFieldname().equals("input")){
					fieldExtension = fExtension;
					break;
				}
			}
			if(fieldExtension == null){
				fieldExtension = createInputFieldExtension("variable_"+Utils.generateUniqueID(), name);
				task.getFieldExtensions().add(fieldExtension);
			}
			else{
				fieldExtension.setExpression(fieldExtension.getExpression() + "~${" + name + "}");
			}	
			id = fieldExtension.getId();
		}
		else{
			// Set output
			FieldExtension fieldExtension = bpmn2Factory.createFieldExtension();
			fieldExtension.setFieldname("resultVariable");
			fieldExtension.setId("variable_"+Utils.generateUniqueID()); // Set unique id in BPMN
			fieldExtension.setExpression(name);
			task.getFieldExtensions().add(fieldExtension);
			id = fieldExtension.getId();
		}	
		return id;
	}
	
	/**
	 * Extracts a task (given its ID) from a given process element.
	 * @param process The process parent element.
	 * @param taskId The ID of the task to be extracted.
	 * @return The requested task element.
	 */
	public FlowElement getTask(Process process, String taskId) {
		try {
			List<FlowElement> flowElements = process.getFlowElements();
			for(FlowElement flowElement : flowElements) {
				if(flowElement.getId().equals(taskId)) {
					if(flowElement instanceof UserTask || flowElement instanceof ServiceTask) {
						return flowElement;
					}
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addTrustToServiceTask(FlowElement task, String trustworthiness){
		if(task instanceof ServiceTask){
			ServiceTask serviceTask = (ServiceTask) task;
			Trustworthiness trustworthinessElement = aniketosFactory.createTrustworthiness();
			trustworthinessElement.setValue(trustworthiness);			
			if(serviceTask.getSecurityExtensions() !=null){
				serviceTask.getSecurityExtensions().setTrustworthinessValue(trustworthinessElement);
			}
			else{
				SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
				securityExtension.setTrustworthinessValue(trustworthinessElement);
				serviceTask.setSecurityExtensions(securityExtension);
			}			
		}
	}
	
	public void addIntegrityToServiceTask(FlowElement task, String with, String type, String algorithm){
		if(task instanceof ServiceTask){
			ServiceTask serviceTask = (ServiceTask) task;
			Integrity integrity = aniketosFactory.createIntegrity();
			integrity.setWith(with);
			integrity.setType(type);
			integrity.setAlgorithm(algorithm);
			if(serviceTask.getSecurityExtensions() !=null){
				serviceTask.getSecurityExtensions().getIntegrityReq().add(integrity);
			}
			else{
				SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
				securityExtension.getIntegrityReq().add(integrity);
				serviceTask.setSecurityExtensions(securityExtension);
			}			
		}
	}
	
	public void addConfidentialityToServiceTask(FlowElement task, String type, String alg){
		if(task instanceof ServiceTask){
			ServiceTask st = (ServiceTask) task;
			Confidentiality c = aniketosFactory.createConfidentiality();
			c.setType(type);
			c.setAlgorithm(alg);
			if(st.getSecurityExtensions() !=null){
				st.getSecurityExtensions().getConfidentialityReq().add(c);
			}
			else{
				SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
				securityExtension.getConfidentialityReq().add(c);
				st.setSecurityExtensions(securityExtension);
			}	
		}
	}
	
	public Role createRole (String roleId, String roleName){
		Role role = securebpmn2Factory.createRole();
		role.setId(roleId);
		role.setRoleName(roleName);
		role.setName("Role"+roleId);
		return role;
	}
	
	public Permission createPermission (String permissionId, Role role){
		Permission permission = securebpmn2Factory.createPermission();
		permission.setId(permissionId);
		permission.setPName(permissionId);
		permission.getRoles().add(role);
		return permission;
	}
	
	public AtomicActivityAction createAtomicActivityAction (String action, Permission permission){
		AtomicActivityAction atomicActivityAction = securebpmn2Factory.createAtomicActivityAction();
		atomicActivityAction.setId(Utils.generateUniqueID());
		atomicActivityAction.setActionName(action);
		atomicActivityAction.getPermissions().add(permission);
		return atomicActivityAction;
	}
	
	public SeparationOfDuty createSeparationOfDuty (String id){
		SeparationOfDuty separationOfDuty = securebpmn2Factory.createSeparationOfDuty();
		separationOfDuty.setId(id);
		separationOfDuty.setName("SoD_"+id);
		return separationOfDuty;
	}
	
	public BindingOfDuty createBindingOfDuty(String id){
		BindingOfDuty bindingOfDuty = securebpmn2Factory.createBindingOfDuty();
		bindingOfDuty.setId(id);
		bindingOfDuty.setName("SoD_"+id);
		return bindingOfDuty;
	}
	
	public Permission findPermissionById (Process process, String id){
		for(FlowElement flowElement : process.getFlowElements()) {
			if(flowElement instanceof Activity){
				Activity activity = (Activity) flowElement;
				for (ActivityAction	activityAction : activity.getActivityActions()) {
					for (Permission permission : activityAction.getPermissions()) {
						if(permission.getId().equals(id)){
							return permission;
						}
					}
				}
			}
		}
		return null;
	}

}
