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
package eu.aniketos.mtm.bpmnimport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.designer.eclipse.bpmn.GraphicInfo;
import org.activiti.designer.eclipse.bpmn.SequenceFlowModel;
import org.eclipse.aniketos.AniketosFactory;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.ThreatEvent;
import org.eclipse.aniketos.Trustworthiness;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.CandidateGroup;
import org.eclipse.bpmn2.CandidateUser;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.securebpmn2.ActivityAction;
import org.eclipse.securebpmn2.AtomicActivityAction;
import org.eclipse.securebpmn2.AuthorizationConstraint;
import org.eclipse.securebpmn2.BindingOfDuty;
import org.eclipse.securebpmn2.Permission;
import org.eclipse.securebpmn2.Role;
import org.eclipse.securebpmn2.Securebpmn2Factory;
import org.eclipse.securebpmn2.SeparationOfDuty;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.ThreatType;
import eu.aniketos.mtm.mapping.TypeType1;
import eu.aniketos.mtm.model.mtm_aniketos.Confidentiality;
import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Definitions;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowElement;
import eu.aniketos.mtm.model.mtm_bpmn2.FormProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.Process;
import eu.aniketos.mtm.model.mtm_bpmn2.RootElement;
import eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask;
import eu.aniketos.mtm.model.mtm_bpmn2.UserTask;
import eu.aniketos.mtm.model.mtm_bpmn2.impl.DocumentRootImpl;
import eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram;
import eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape;
import eu.aniketos.mtm.model.mtm_di.DiagramElement;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.utils.Utils;

/**
 * It parses all Bpmn elements from a file and stores in Bpmn2 metamodel's objects.
 * 
 * @author Eider Iturbe, Tecnalia
 *
 */
public class BpmnParser {
	private org.eclipse.bpmn2.Bpmn2Factory bpmn2FactoryActiviti;
	private AniketosFactory aniketosFactory;
	private Securebpmn2Factory securebpmn2Factory;
	
	public List<org.eclipse.bpmn2.FlowElement> bpmnList = new ArrayList<org.eclipse.bpmn2.FlowElement>();
	public List<SequenceFlowModel> sequenceFlowList = new ArrayList<SequenceFlowModel>();
	public List<SecuritySequenceFlowModel> securitySequenceFlowList = new ArrayList<SecuritySequenceFlowModel>();
	public Map<FlowNode, String> defaultFlowMap = new HashMap<FlowNode, String>();
	public Map<String, GraphicInfo> locationMap = new HashMap<String, GraphicInfo>();
	public Map<String, List<GraphicInfo>> flowLocationMap = new HashMap<String, List<GraphicInfo>>();
	public org.eclipse.bpmn2.Process process;
	private Map<AuthorizationConstraint, List<Activity>> authMap = new HashMap<AuthorizationConstraint, List<Activity>>();
	private List<Role> roles = new ArrayList<Role>();
	
	public BpmnParser() {
		bpmn2FactoryActiviti = org.eclipse.bpmn2.Bpmn2Factory.eINSTANCE;
		aniketosFactory = AniketosFactory.eINSTANCE;
		securebpmn2Factory = Securebpmn2Factory.eINSTANCE;
	}
	
	public void parseBpmn (String filename, MappingType mapping){
							
		// Load participant from mapping
		List<UserRoleBean> userRoleBeans = new ArrayList<BpmnParser.UserRoleBean>();
		for (IsaType isaType : mapping.getIsA()) {
			if(isaType.getBPPart().get(0) != null && isaType.getBPRole().get(0) != null){
				String userid = isaType.getBPPart().get(0).getId();
				String user = isaType.getBPPart().get(0).getValue();
				String roleid = isaType.getBPRole().get(0).getId();
				String role = isaType.getBPRole().get(0).getValue();
				userRoleBeans.add(new UserRoleBean(userid, user, roleid, role));
			}			
		}
		for (PlaysType playsType : mapping.getPlays()) {
			if(playsType.getBPPart() != null){
				String id = playsType.getBPPart().getId();
				String role = playsType.getBPPart().getValue();
				userRoleBeans.add(new UserRoleBean(id, null, id, role));
			}
		}
		
							
		DocumentRootImpl documentRoot = loadBpmn(filename);
		Definitions definitions = documentRoot.getDefinitions();
		List<RootElement> rootElements = definitions.getRootElements();
	
		Process processMTM = null;		
		for(RootElement element : rootElements) {
			if(element instanceof Process) {
				processMTM = (Process)element;
			}
		}
		
		BPMNDiagram diagram = definitions.getDiagrams().get(0);		
		
		// Set Process
		if(processMTM != null){
									
			// Set Tasks
			for(FlowElement flowElement : processMTM.getFlowElements()) {
				if(flowElement instanceof UserTask) {
					UserTask userTaskMTM = (UserTask) flowElement;					
					org.eclipse.bpmn2.UserTask userTaskActiviti = bpmn2FactoryActiviti.createUserTask();
					
					userTaskActiviti.setAssignee(userTaskMTM.getAssignee()); // Set Assignee
					userTaskActiviti.setDueDate(userTaskMTM.getDueDate()); // Set Duedate
					userTaskActiviti.setFormKey(userTaskMTM.getFormKey()); // Set Formkey
					userTaskActiviti.setId(userTaskMTM.getId()); // Set ID
					userTaskActiviti.setName(userTaskMTM.getName()); // Set Name
					
					// Set Candidate Users
					if(!userTaskMTM.getCandidateUsers().isEmpty()){
						CandidateUser candidateUser = bpmn2FactoryActiviti.createCandidateUser();
						candidateUser.setUser(userTaskMTM.getCandidateUsers().get(0).getUser());
						userTaskActiviti.getCandidateUsers().add(candidateUser);
					}					
					
					// Set Candidate Groups
					if(!userTaskMTM.getCandidateGroups().isEmpty()){
						CandidateGroup candidateGroup = bpmn2FactoryActiviti.createCandidateGroup();
						candidateGroup.setGroup(userTaskMTM.getCandidateGroups().get(0).getGroup());
						userTaskActiviti.getCandidateGroups().add(candidateGroup);
					}					
					
					// Form properties
					for(FormProperty formProperty : userTaskMTM.getFormProperties()){
						userTaskActiviti.getFormProperties().add(setFormProperty(formProperty));
					}		
					
					// Activiti Listeners
					for (ActivitiListener activitiListener : userTaskMTM.getActivitiListeners()) {
						userTaskActiviti.getActivitiListeners().add(setActivitiListener(activitiListener));
					}					
					
					bpmnList.add(userTaskActiviti);
				}
				else if(flowElement instanceof ServiceTask){
					ServiceTask serviceTaskMTM = (ServiceTask) flowElement;
					org.eclipse.bpmn2.ServiceTask serviceTaskActiviti = bpmn2FactoryActiviti.createServiceTask();
					
					serviceTaskActiviti.setId(serviceTaskMTM.getId()); //Set ID
					serviceTaskActiviti.setName(serviceTaskMTM.getName()); // Set Name
					serviceTaskActiviti.setResultVariableName(serviceTaskMTM.getResultVariableName()); // Set ResultVariable
					serviceTaskActiviti.setImplementationType(serviceTaskMTM.getImplementationType()); // Set Implementation Type: classType, expressionType, delegateExpressionType 
					serviceTaskActiviti.setImplementation(serviceTaskMTM.getImplementation()); // Set implementation
					
					// Field Extensions
					for(FieldExtension fieldExtension : serviceTaskMTM.getFieldExtensions()){
						serviceTaskActiviti.getFieldExtensions().add(setFieldExtension(fieldExtension));
					}
					
					// Add trustworthiness
					if(serviceTaskMTM.getSecurityExtensions() != null && serviceTaskMTM.getSecurityExtensions().getTrustworthinessValue() != null){
						Trustworthiness trustworthinessActiviti = aniketosFactory.createTrustworthiness();
						trustworthinessActiviti.setValue(serviceTaskMTM.getSecurityExtensions().getTrustworthinessValue().getValue());
						if(serviceTaskActiviti.getSecurityExtensions() == null){
							SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
							securityExtension.setTrustworthinessValue(trustworthinessActiviti);
							serviceTaskActiviti.setSecurityExtensions(securityExtension);
						}
						else{
							serviceTaskActiviti.getSecurityExtensions().setTrustworthinessValue(trustworthinessActiviti);
						}						
					}
					
					// Add Integrity
					if(serviceTaskMTM.getSecurityExtensions() != null && serviceTaskMTM.getSecurityExtensions().getIntegrityReq().size() > 0){
						EList<eu.aniketos.mtm.model.mtm_aniketos.Integrity> integrities = serviceTaskMTM.getSecurityExtensions().getIntegrityReq();
						for (eu.aniketos.mtm.model.mtm_aniketos.Integrity integrity : integrities) {
							Integrity integrityActiviti = aniketosFactory.createIntegrity();
							integrityActiviti.setWith(integrity.getWith());
							integrityActiviti.setType(integrity.getType());
							integrityActiviti.setAlgorithm(integrity.getAlgorithm());
							if(serviceTaskActiviti.getSecurityExtensions() == null){
								SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
								securityExtension.getIntegrityReq().add(integrityActiviti);
								serviceTaskActiviti.setSecurityExtensions(securityExtension);
							}
							else{
								serviceTaskActiviti.getSecurityExtensions().getIntegrityReq().add(integrityActiviti);
							}
						}						
					}
					
					// Add Confidentiality
					if(serviceTaskMTM.getSecurityExtensions() != null && serviceTaskMTM.getSecurityExtensions().getConfidentialityReq().size() > 0){
						EList<Confidentiality> confidentialities = serviceTaskMTM.getSecurityExtensions().getConfidentialityReq();
						for (Confidentiality confidentiality : confidentialities) {
							org.eclipse.aniketos.Confidentiality c = aniketosFactory.createConfidentiality();
							c.setType(confidentiality.getType());
							c.setAlgorithm(confidentiality.getAlgorithm());
							if(serviceTaskActiviti.getSecurityExtensions() == null){
								SecurityExtension securityExtension = aniketosFactory.createSecurityExtension();
								securityExtension.getConfidentialityReq().add(c);
								serviceTaskActiviti.setSecurityExtensions(securityExtension);
							}
							else{
								serviceTaskActiviti.getSecurityExtensions().getConfidentialityReq().add(c);
							}
						}
					}
					
					bpmnList.add(serviceTaskActiviti);
				}
			}
			
			// Add permission and threat to task
			for(RelatesToType rt : mapping.getRelatesTo()) {
				ActivityType activity = rt.getActivity();
				Activity activityBPMN = findActivityById(activity.getId());
				// Add permission to task
				if(activity.getPermission() != null && activity.getPermission().size() > 0){
					for (PermissionType permissionType : activity.getPermission()) {
						UserRoleBean userRoleBean = null;
						Role role = null;
						for (UserRoleBean userRoleBean2 : userRoleBeans) {
							if(userRoleBean2.getRoleid().equals(permissionType.getRole())){
								userRoleBean = userRoleBean2;
								break;
							}
						}
						if(userRoleBean != null){
							role = findRoleById(userRoleBean.getRoleid());
							if(role == null){
								role = createRole(userRoleBean.getRoleid(),userRoleBean.getRolename());	
								roles.add(role);
							}
						}						
						
						if(role != null){
							Permission permission = createPermission(permissionType.getId(), role);						
							AtomicActivityAction atomicActivityAction = createAtomicActivityAction(permissionType.getAction(), permission);						
							activityBPMN.getActivityActions().add(atomicActivityAction);
						}						
					}
				}	
				// Add threat
				if(activity.getThreat() != null && activity.getThreat().size() > 0){
					for (String  threatId : activity.getThreat()) {
						ThreatEvent te = aniketosFactory.createThreatEvent();
						te.setAttachedToRef(activityBPMN);
						ThreatType tt = MappingManager.getInstance().findBPThreatByBPThreatId(mapping, threatId);
						te.setId(tt.getId());
						te.setName(tt.getName());
						ErrorEventDefinition eed = bpmn2FactoryActiviti.createErrorEventDefinition();
						if(tt.getRepositoryID() != null){
							eed.setErrorCode(tt.getRepositoryID());							
						}
						te.getEventDefinitions().add(eed);
						bpmnList.add(te);
					}					
				}
			}
			
			// Add SoDBoD
			int index = 1;
			for (SoDBoDType soDBoDType : mapping.getSoDBoDProperties()) {
				AuthorizationConstraint authorizationConstraint = null;
				if(soDBoDType.getType().equals(TypeType1.SO_D)){
					authorizationConstraint = createSeparationOfDuty(soDBoDType.getId(), soDBoDType.getType()+"_"+index++);					
				}
				else if(soDBoDType.getType().equals(TypeType1.BO_D)){
					authorizationConstraint = createBindingOfDuty(soDBoDType.getId(), soDBoDType.getType()+"_"+index++);			
				}
				if(authorizationConstraint != null){
					definitions.eResource().getContents().add(authorizationConstraint);
					for (String permissionId : soDBoDType.getPermission()) {
						Permission permission = findPermissionById (permissionId, authorizationConstraint);
						permission.getAuthorizationConstraints().add(authorizationConstraint);
					}
				}				
			}			
			
		}
		
		if(diagram != null){
			for(DiagramElement diagramElement : diagram.getBPMNPlane().getDiagramElement()){
				if(diagramElement instanceof BPMNShape){
					BPMNShape shape = (BPMNShape) diagramElement;
					GraphicInfo graphicInfo = new GraphicInfo();
					graphicInfo.x = (int) shape.getBounds().getX();
					graphicInfo.y = (int) shape.getBounds().getY();
					graphicInfo.height = (int) shape.getBounds().getHeight();
					graphicInfo.width = (int) shape.getBounds().getWidth();
					locationMap.put(shape.getBpmnElement().getLocalPart(), graphicInfo);
				}
				
			}
			if(authMap.keySet().size() >0){
				// create SoD/BoD shapes in diagram
				int offsetX = 70;
				int offsetY = 50;
				int height = 55;
				int width = 105;
				int x = 0;
				int y = 0;
				
				for (AuthorizationConstraint authorizationConstraint : authMap.keySet()) {
					GraphicInfo graphicInfo = new GraphicInfo();
					x = x + width + offsetX;
					y = y + height + offsetY;
					graphicInfo.x = x;
					graphicInfo.y = y;
					graphicInfo.height = height;
					graphicInfo.width = width;
					locationMap.put(authorizationConstraint.getId(), graphicInfo);
					
					// Add sequenceFlow
					List<Activity>activities = authMap.get(authorizationConstraint);
					
					SecuritySequenceFlowModel sequenceFlowModel1 = createSecuritySequenceFlowModel(
							authorizationConstraint.getName() + "_1",
							authorizationConstraint.getId(), 
							activities.get(0).getId());
					this.securitySequenceFlowList.add(sequenceFlowModel1);
					SecuritySequenceFlowModel sequenceFlowModel2 = createSecuritySequenceFlowModel(
							authorizationConstraint.getName() + "_2",
							authorizationConstraint.getId(), 
							activities.get(1).getId());
					this.securitySequenceFlowList.add(sequenceFlowModel2);
				}
			}			
		}
	}

	private DocumentRootImpl loadBpmn (String filename){
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(filename));
		try {
			resource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (DocumentRootImpl)resource.getContents().get(0);
	}
	
	private org.eclipse.bpmn2.FormProperty setFormProperty (FormProperty formProperty){
		org.eclipse.bpmn2.FormProperty formPropertyActiviti = bpmn2FactoryActiviti.createFormProperty();
		formPropertyActiviti.setId(formProperty.getId());
		formPropertyActiviti.setName(formProperty.getName());
		formPropertyActiviti.setReadable(formProperty.getReadable());
		formPropertyActiviti.setRequired(formProperty.getRequired());
		formPropertyActiviti.setType(formProperty.getType());
		formPropertyActiviti.setValue(formProperty.getValue());
		formPropertyActiviti.setWriteable(formProperty.getWriteable());		
		return formPropertyActiviti;
	}
	
	private org.eclipse.bpmn2.FieldExtension setFieldExtension (FieldExtension fieldExtension){
		org.eclipse.bpmn2.FieldExtension fieldExtensionActiviti = bpmn2FactoryActiviti.createFieldExtension();
		fieldExtensionActiviti.setExpression(fieldExtension.getExpression());
		fieldExtensionActiviti.setFieldname(fieldExtension.getFieldname());
		fieldExtensionActiviti.setId(fieldExtension.getId());		
		return fieldExtensionActiviti;
	}
	
	private org.eclipse.bpmn2.ActivitiListener setActivitiListener (ActivitiListener activitiListenerMTM){
		org.eclipse.bpmn2.ActivitiListener activitiListener = bpmn2FactoryActiviti.createActivitiListener();
		activitiListener.setEvent(activitiListenerMTM.getEvent());
		activitiListener.setImplementationType(activitiListenerMTM.getImplementationType());
		activitiListener.setImplementation(activitiListenerMTM.getImplementation());
		for (FieldExtension fieldExtensionMTM : activitiListenerMTM.getFieldExtensions()) {
			activitiListener.getFieldExtensions().add(setFieldExtension(fieldExtensionMTM));
		}
		
		return activitiListener;
	}
	
	private Activity findActivityById (String id){
		for (org.eclipse.bpmn2.FlowElement flowElement : bpmnList) {
			if(flowElement.getId().equals(id)){
				return (Activity) flowElement;
			}
		}
		return null;
	}
	
	private Role findRoleById (String id){
		for (Role role : roles) {
			if(role.getName().endsWith(id)){
				return role;
			}
		}
		return null;
	}
	
	public Role createRole (String roleId, String roleName){
		Role role = securebpmn2Factory.createRole();
		role.setId(Utils.generateUniqueID());
		role.setRoleName(roleName+"."+roleId);
		role.setName(roleName);
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
	
	public SeparationOfDuty createSeparationOfDuty (String id, String name){
		SeparationOfDuty separationOfDuty = securebpmn2Factory.createSeparationOfDuty();
		separationOfDuty.setId(id);
		separationOfDuty.setName(name);
		return separationOfDuty;
	}
	
	public BindingOfDuty createBindingOfDuty(String id, String name){
		BindingOfDuty bindingOfDuty = securebpmn2Factory.createBindingOfDuty();
		bindingOfDuty.setId(id);
		bindingOfDuty.setName(name);
		return bindingOfDuty;
	}
	
	public Permission findPermissionById (String id, AuthorizationConstraint authorizationConstraint){
		for (org.eclipse.bpmn2.FlowElement flowElement : bpmnList) {
			if(flowElement instanceof Activity){
				Activity activity = (Activity) flowElement;
				for (ActivityAction	activityAction : activity.getActivityActions()) {
					for (Permission permission : activityAction.getPermissions()) {
						if(permission.getId().equals(id)){
							// Check authMap is completed
							checkAuthMap(authorizationConstraint, activity);
							return permission;
						}
					}
				}
			}
		}
		return null;
	}
	
	private void checkAuthMap (AuthorizationConstraint authorizationConstraint, Activity activity){
		if(authMap.containsKey(authorizationConstraint)){
			List<Activity> activities = authMap.get(authorizationConstraint);
			if(activities != null){
				if(!activities.contains(activity)){
					activities.add(activity);
				}
			}
			else{
				activities = new ArrayList<Activity>();
				activities.add(activity);
			}
		}
		else{
			List<Activity> activities = new ArrayList<Activity>();
			activities.add(activity);
			authMap.put(authorizationConstraint, activities);
		}
	}
	
	public SecuritySequenceFlowModel createSecuritySequenceFlowModel (String id, String sourceRef, String targetRef){
		SecuritySequenceFlowModel sequenceFlowModel = new SecuritySequenceFlowModel();
		sequenceFlowModel.id = id;
		sequenceFlowModel.sourceRef = sourceRef;
		sequenceFlowModel.targetRef = targetRef;
		return sequenceFlowModel;
	}
	
	protected class UserRoleBean{
		private String userid;
		private String username;
		private String roleid;
		private String rolename;
		
		public UserRoleBean() {
		}

		public UserRoleBean(String userid, String username, String roleid,
				String rolename) {
			super();
			this.userid = userid;
			this.username = username;
			this.roleid = roleid;
			this.rolename = rolename;
		}
		
		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getRoleid() {
			return roleid;
		}

		public void setRoleid(String roleid) {
			this.roleid = roleid;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRolename() {
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}
	
	}
}
