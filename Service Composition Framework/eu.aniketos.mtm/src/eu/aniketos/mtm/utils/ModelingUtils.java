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
package eu.aniketos.mtm.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.ThreatEvent;
import org.eclipse.bpmn2.ActivitiListener;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.securebpmn2.ActivityAction;
import org.eclipse.securebpmn2.AtomicActivityAction;
import org.eclipse.securebpmn2.AuthorizationConstraint;
import org.eclipse.securebpmn2.Permission;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesFactory;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness;
import eu.aniketos.mtm.mapping.IntegrityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.AgentType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalSetTypeMin2;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.PreType;
import eu.aniketos.mtm.srs.RoleType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.ThreatType;
import eu.aniketos.mtm.srs2activiti.wizard.ConSpecGenerationWizard.CommitmentWrapper;

/**
 * This class includes some utilities to handle SRS, Mapping and Activiti models together.
 * 
 * @author Adrian Noguero (adrian.noguero@tecnalia.com)
 *
 */

public class ModelingUtils {

	public static final String POLICY_TRUSTWORTHINESS = "Trustworthiness";
	public static final String POLICY_CONFIDENTIALITY = "Confidentiality";
	public static final String POLICY_INTEGRITY = "Integrity";
	public static final String POLICY_BoD = "BindingOfDuty";
	public static final String POLICY_SoD = "SeparationOfDuty";
	public static final String POLICY_NO_DELEGATION = "NoDelegation";
	public static final String POLICY_NO_REPUDIATION = "NoRepudiation";
	
	private SecReqSpeType srs;
	private MappingType mapping;
	private Resource activiti;
	
	/**
	 * Create a configured instance of the utility class.
	 * 
	 * @param srsModel SRS model
	 * @param mappingModel Mapping model
	 * @param activitiModel Resource containing the Activiti model
	 * @return the configured instance
	 */
	public static ModelingUtils configure(SecReqSpeType srsModel,	MappingType mappingModel, Resource activitiModel) {
		return new ModelingUtils(srsModel, mappingModel, activitiModel);
	}
	
	private ModelingUtils(SecReqSpeType srsModel, MappingType mappingModel, Resource activitiModel) {
		srs = srsModel;
		mapping = mappingModel;
		activiti = activitiModel;
	}

	/**
	 * Get the Task in the Activiti model associated to a SRS Goal.
	 * 
	 * @param goal the SRS Goal
	 * @return the Task in Activity or null.
	 */
	public Task getTaskFromGoal(GoalType goal) {
		try {
			for (RelatesToType rel : mapping.getRelatesTo()) {
				for (eu.aniketos.mtm.mapping.GoalType g : rel.getGoal()) {
					if (goal.getId().equals(g.getId())) {
						// Found mapping rule!
						String taskID = rel.getActivity().getId();
						TreeIterator<EObject> i = activiti.getAllContents();
						while (i.hasNext()) {
							EObject o = i.next();
							if (o instanceof Task && ((Task)o).getId().equals(taskID)) {
								return ((Task)o);
							}
						}
						return null;
					}
				}
			}
			return null;
		}
		catch (NullPointerException e) {
			// Just in case the model is not correct...
			return null;
		}
	}

	/**
	 * Get the BPMN variable(s) associated to a SRS document
	 * 
	 * @param document the SRS document
	 * @return a list containing the associated variables. It can be empty
	 */
	public ArrayList<FieldExtension> getVariableFromDocument(DocType document) {
		ArrayList<FieldExtension> ret = new ArrayList<FieldExtension>();
		
		for (RepresentsType rep : mapping.getRepresents()) {
			for (eu.aniketos.mtm.mapping.DocType doc : rep.getDocument()) {
				if (document.getId().equals(doc.getId())) {
					// Found map!!
					TreeIterator<EObject> i = activiti.getAllContents();
					while (i.hasNext()) {
						EObject o = i.next();
						if ((o instanceof FieldExtension) && ((FieldExtension)o).getId() != null && ((FieldExtension)o).getId().startsWith(rep.getVariable().getId())) {
							// Found var!!
							ret.add( (FieldExtension)o );						
						}
					}
				}
			}			
		}
		
		return ret;
	}

	/**
	 * Create an adequate Policy type for the associated Commitment
	 * 
	 * @param c the commitment
	 * @return the Policy element of the adequate type or null if the commitment cannot be transformed.
	 */
	public Policy getPolicyFromCommitment(CommitmentWrapper cw) {
		CommitmentType c = cw.getCommitment();
		PreType pre = c.getPrecondition();
		PostType post = c.getPostcondition();
		
		Policy ret = null;
		
		if (pre != null) {
			if (pre.getTrustworthiness() != null) {
				Trustworthiness t = ConsumerpoliciesFactory.eINSTANCE.createTrustworthiness();
				
				t.setID(c.getId());
				Task task = getTaskFromGoal(c.getPrecondition().getTrustworthiness().getGoal());
				if (task != null) {
					t.setGuardedTask(task.getName());
				}
				else {
					return null;
				}
				t.setMinLevel(Float.parseFloat(c.getPrecondition().getTrustworthiness().getMinLevel()));
				
				ret = t;
				return ret;
			}
		}
		
		if (post != null) {
			if (post.getAchieveInCombination() != null) {
				BindingOfDuty bod = ConsumerpoliciesFactory.eINSTANCE.createBindingOfDuty();
				
				bod.setID(c.getId());
				
				for (GoalType goal : c.getPostcondition().getAchieveInCombination().getGoalSet().getGoal()) {
					Task t = getTaskFromGoal(goal);
					if (t != null) {
						bod.getGuardedTasks().add(t.getName());
					}
					else {
						return null;
					}
				}
				
				ret = bod;
				return ret;
			}
//			else if(post.getAvailability() != null) {
//				 return "A" + post.getAvailability().getMinLevel();
//			}
			else if (post.getIntegrity() != null) {
				Integrity i = ConsumerpoliciesFactory.eINSTANCE.createIntegrity();
				i.setID(c.getId());
				
				FieldExtension fe = cw.getVar();
				ServiceTask orig = cw.getServiceTask();
				org.eclipse.aniketos.Integrity integrity = getIntegrity(orig, fe);
				ServiceTask target = (ServiceTask) getTaskByID(integrity.getWith());
				
				i.setGeneratingService(orig.getName());
				i.setProcessingService(target.getName());
				i.setAlgorithm(orig.getSecurityExtensions().getIntegrityReq().get(0).getAlgorithm());
				FieldExtension role = getRoleForTask(orig);
				if (role != null) {
					i.setGuardedSender(role.getExpression());
				}
				
				ret = i;
				return ret;
			}
			else if (post.getNotAchieveInCombination() != null) {
				SeparationOfDuty sod = ConsumerpoliciesFactory.eINSTANCE.createSeparationOfDuty();
				
				sod.setID(c.getId());
				
				for (GoalType goal : c.getPostcondition().getNotAchieveInCombination().getGoalSet().getGoal()) {
					Task t = getTaskFromGoal(goal);
					if (t != null) {
						sod.getGuardedTasks().add(t.getName());
					}
					else {
						return null;
					}
				}
				
				ret = sod;
				return ret;
			}
//			else if (post.getNotPlayBoth() != null) {
//				
//				
//				return ret;
//			}
//			else if (post.getPlayBoth() != null) {
//				
//				
//				return ret;
//			}
//			else if (post.getRedundancy() != null) {
//				return "R" + post.getRedundancy().getMultiplicity().getValue();
//			}
			else if (post.getNonDelegation() != null) {
				NoDelegation nd = ConsumerpoliciesFactory.eINSTANCE.createNoDelegation();
				
				nd.setID(c.getId());
				
				if (c.getPostcondition().getNonDelegation().getGoalSet().getGoal().size() != 1) {
					return null;
				}
				
				Task t = getTaskFromGoal(c.getPostcondition().getNonDelegation().getGoalSet().getGoal().get(0));
				if (t == null) {
					return null;
				}
				nd.setGuardedTask(t.getName());
				if (t instanceof ServiceTask) {
					
					// Get the role through Actor in SRS
					ActorType actor = c.getDebtor();
					
					FieldExtension role = getRoleFromActor(actor);
					
					if (role == null) {
						return null;
					}
					
					nd.setAllowedRole(role.getExpression());

				}
				else if (t instanceof UserTask) {
					if (((UserTask)t).getAssignee() != null) {
						nd.setAllowedRole(((UserTask)t).getCandidateGroups().get(0).getGroup());
					}
				}
				else {
					return null;
				}
				
				ret = nd;
				return ret;
			}
			else if (post.getNonRepudiation() != null) {
				NoRepudiation rd = ConsumerpoliciesFactory.eINSTANCE.createNoRepudiation();
				
				rd.setID(c.getId());
				
				if (c.getPostcondition().getNonRepudiation().getGoalSet().getGoal().size() != 1) {
					return null;
				}
				
				Task t = getTaskFromGoal(c.getPostcondition().getNonRepudiation().getGoalSet().getGoal().get(0));
				if (t == null || !(t instanceof ServiceTask)) {
					return null;
				}
				rd.setGuardedTask(t.getName());
				
				ret = rd;
				return ret;
			}
			else if (post.getConfidentiality() != null){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality conf = ConsumerpoliciesFactory.eINSTANCE.createConfidentiality();
				conf.setID(c.getId());
				
				FieldExtension fe = cw.getVar();
				ServiceTask st = cw.getServiceTask();
				conf.setGuardedTask(st.getName());
				
				for (Confidentiality confidentiality : st.getSecurityExtensions().getConfidentialityReq()) {
					if(confidentiality.getType().equals(fe.getFieldname()) && confidentiality.getType().equals("input")){
						conf.setInputSuite(confidentiality.getAlgorithm());
					}
					else if (confidentiality.getType().equals("output") && fe.getFieldname().equals("resultVariable")){
						conf.setOutputSuite(confidentiality.getAlgorithm());
					}
				}
				
				ret = conf;
				return ret;
				
			}

		}
		
		return ret;
	}

	public FieldExtension getRoleFromActor(ActorType actor) {
		FieldExtension ret = null;
		
		for (PlaysType p : mapping.getPlays()) {
			if ((actor.getAgent() != null && p.getSRRole() != null && p.getSRRole().getId().equals(actor.getAgent().getId())) 
					|| (actor.getRole() != null && p.getSRRole() != null && p.getSRRole().getId().equals(actor.getRole().getId()))) {
				TreeIterator<EObject> i = activiti.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof FieldExtension && ((FieldExtension)o).getId().startsWith(p.getBPPart().getId())) {
						return (FieldExtension)o;
					}
				}
			}
		}
		for (IsaType is : mapping.getIsA()) {
			if ((actor.getAgent() != null &&  is.getSRAgent() != null && is.getSRAgent().size() > 0 && is.getSRAgent().get(0).getId().equals(actor.getAgent().getId())) 
					|| (actor.getRole() != null && is.getSRRole() != null && is.getSRRole().size() > 0 && is.getSRRole().get(0).getId().equals(actor.getRole().getId()))) {
				TreeIterator<EObject> i = activiti.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof FieldExtension && ((FieldExtension)o).getId().startsWith(is.getBPRole().get(0).getId())) {
						return (FieldExtension)o;
					}
				}
			}
		}
		
		return ret;
	}

	/**
	 * Get the Field Extensions that represent the Roles associated to a BPMN ServiceTask
	 * 
	 * @param t the BPMN ServiceTask
	 * @return a list of FieldExtensions.
	 */
	public FieldExtension getRoleForTask(ServiceTask t) {				
		if (t instanceof ServiceTask) {
			for (FieldExtension fe : ((ServiceTask)t).getFieldExtensions()) {
				if(fe.getFieldname().equals("RequestedServiceProviderRole")){
					return fe;
				}
			}
		}
		
		return null;
	}

	/**
	 * Get the transformation name for a commitment.
	 * 
	 * @param c the commitment element
	 * @return the name of the adequate transformation or null if the commitment cannot be transformed.
	 */
	public String getTransformationFromCommitment(CommitmentType c) {
		PreType pre = c.getPrecondition();
		PostType post = c.getPostcondition();
		
		if (pre != null) {
			if (pre.getTrustworthiness() != null) {
				return POLICY_TRUSTWORTHINESS;
			}
		}
		
		if (post != null) {
			if (post.getAchieveInCombination() != null) {
				return POLICY_BoD;
			}
//			else if(post.getAvailability() != null) {
//				 return "Availability";
//			}
			else if (post.getIntegrity() != null) {
				return POLICY_INTEGRITY;
			}
			else if (post.getNotAchieveInCombination() != null) {
				return POLICY_SoD;
			}
//			else if (post.getNotPlayBoth() != null) {
//				return "SeparationOfDuty";
//			}
//			else if (post.getPlayBoth() != null) {
//				return "BindingOfDuty";
//			}
//			else if (post.getRedundancy() != null) {
//				return "R";
//			}
			else if (post.getNonDelegation() != null) {
				return POLICY_NO_DELEGATION;
			}
			else if (post.getNonRepudiation() != null) {
				return POLICY_NO_REPUDIATION;
			}
			else if(post.getConfidentiality() != null){
				return POLICY_CONFIDENTIALITY;
			}

		}
		
		return null;
	}
	
	/**
	 * Get the transformation name for a security requirement.
	 * 
	 * @param p the policy element
	 * @return the name of the adequate transformation or null if the commitment cannot be transformed.
	 */
	public String getTransformationFromPolicy(Policy p) {
		
		if(p instanceof Trustworthiness){
			return "Trustworthiness";
		}
		else if (p instanceof Integrity){
			return "Integrity";
		}
		else if (p instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality){
			return "Confidentiality";
		}
		else if (p instanceof BindingOfDuty){
			return "BindingOfDuty";
		}
		else if (p instanceof SeparationOfDuty){
			return "SeparationOfDuty";
		}
		
		return null;
	}

	/**
	 * Get the BPMN ServiceTask that declares a FieldExtension.
	 * 
	 * @param fe the FieldExtension object to be found.
	 * @return the first ServiceTask declaring it. 
	 */
	public ServiceTask getTaskUsingVariable(FieldExtension fe) {
		TreeIterator<EObject> i = activiti.getAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ServiceTask) {
				if (((ServiceTask)o).getFieldExtensions().contains(fe)) {
					return (ServiceTask)o;
				}
			}
		}
		return null;
	}

	public Vector<Task> getTasksUsingVariable(FieldExtension var) {
		Vector<Task> ret = new Vector<Task>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ServiceTask) {
				if (((ServiceTask)o).getFieldExtensions().contains(var)) {
					ret.add((ServiceTask)o);
				}
			}
			else if(o instanceof UserTask){
				if(((UserTask)o).getActivitiListeners() != null && ((UserTask)o).getActivitiListeners().size() > 0){
					for (ActivitiListener activitiListener : ((UserTask)o).getActivitiListeners()) {
						if(activitiListener.getImplementation().equals("eu.aniketos.tasklistener")){
							if(activitiListener.getFieldExtensions().contains(var)){
								ret.add((UserTask) o);
							}
						}
					}
				}
			}
		}
		return ret;
	}

	/**
	 * Get a BPMN Task object by ID
	 * 
	 * @param taskID the ID of the Task
	 * @return the BPMN Task object with the selected ID or null if the ID was not found 
	 */
	public Task getTaskByID(String taskID) {
		TreeIterator<EObject> i = activiti.getAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Task) {
				if (((Task)o).getId().equals(taskID)) {
					return (Task)o;
				}
			}
		}
		return null;
	}

	public ArrayList<ServiceTask> getTasksWithIntegrity() {
		ArrayList<ServiceTask> ret = new ArrayList<ServiceTask>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ServiceTask && ((ServiceTask)o).getSecurityExtensions() != null && ((ServiceTask)o).getSecurityExtensions().getIntegrityReq() != null && ((ServiceTask)o).getSecurityExtensions().getIntegrityReq().size() > 0) {
				ret.add((ServiceTask)o);
			}
		}
		return ret;
	}
	
	public org.eclipse.aniketos.Integrity getIntegrity (ServiceTask origin, FieldExtension fe){
		if(origin.getFieldExtensions().contains(fe)){
			for (RelatesToType relatesToType : mapping.getRelatesTo()) {
				if(relatesToType.getActivity().getId().equals(origin.getId())){
					if(relatesToType.getActivity().getIntegrity() != null){
						for (IntegrityType integrityType : relatesToType.getActivity().getIntegrity()) {
							if(integrityType.getVariable().equals(fe.getId())){
								for (org.eclipse.aniketos.Integrity i : origin.getSecurityExtensions().getIntegrityReq()) {
									if(i.getAlgorithm().equals(integrityType.getAlgorithm()) && i.getType().equals(integrityType.getType()) && i.getWith().equals(integrityType.getWith())){
										return i;
									}
								}
							}
						}
					}
					break;
				}
			}
		}	
		
		return null;
	}
	
	public ArrayList<ServiceTask> getTasksWithConfidentiality() {
		ArrayList<ServiceTask> ret = new ArrayList<ServiceTask>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ServiceTask && ((ServiceTask)o).getSecurityExtensions() != null && ((ServiceTask)o).getSecurityExtensions().getIntegrityReq() != null && ((ServiceTask)o).getSecurityExtensions().getConfidentialityReq().size() > 0) {
				ret.add((ServiceTask)o);
			}
		}
		return ret;
	}

	/**
	 * Get all the tasks in the activity model
	 * 
	 * @return  vector with all the Task objects.
	 */
	public Vector<Task> getActivityTasks() {
		Vector<Task> ret = new Vector<Task>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ServiceTask || o instanceof UserTask) {
				ret.add((Task)o);
			}
		}
		return ret;
	}
	
	/**
	 * Get all the threats in the activity model
	 * 
	 * @return  vector with all the Threat objects.
	 */
	public Vector<ThreatEvent> getActivityThreats() {
		Vector<ThreatEvent> ret = new Vector<ThreatEvent>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ThreatEvent) {
				ret.add((ThreatEvent)o);
			}
		}
		return ret;
	}
	
	/**
	 * Get all the threats in the activity model
	 * 
	 * @return  vector with all the Threat objects.
	 */
	public Vector<ThreatEvent> getActivityThreatsByRepositoryId (String repositoryId) {
		Vector<ThreatEvent> ret = new Vector<ThreatEvent>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ThreatEvent && ((ThreatEvent)o).getEventDefinitions() != null && ((ThreatEvent)o).getEventDefinitions().size() > 0) {
				for (EventDefinition ed : ((ThreatEvent)o).getEventDefinitions()) {
					if(ed instanceof ErrorEventDefinition && ((ErrorEventDefinition) ed).getErrorCode() != null && ((ErrorEventDefinition) ed).getErrorCode().equals(repositoryId)){
						ret.add((ThreatEvent)o);
					}
				}				
			}
		}
		return ret;
	}
	
	/**
	 * Return a list with all the Goals defined in the SRS model
	 * 
	 * @return a vector with the GoalType objects.
	 */
	public Vector<GoalType> getSRSGoals() {
		Vector<GoalType> ret = new Vector<GoalType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof GoalType) {
				boolean found = false;
				for (GoalType g2 : ret) {
					if (g2.getValue().equals(((GoalType)o).getValue())) {
						found = true;
						break;
					}
				}
				if (!found) {
					ret.add((GoalType)o);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Return all the Roles defined in the SRS
	 * 
	 * @return a Vector containing a single copy of each Role.
	 */
	public Vector<RoleType> getSRSRoles() {
		Vector<RoleType> ret = new Vector<RoleType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof RoleType) {
				boolean found = false;
				for (RoleType g2 : ret) {
					if (g2.getValue().equals(((RoleType)o).getValue())) {
						found = true;
						break;
					}
				}
				if (!found && ((RoleType)o).getValue() != null && !((RoleType)o).getValue().equals("")) {
					ret.add((RoleType)o);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Return all the Agents defined in the SRS
	 * 
	 * @return a Vector containing a single copy of each Agent.
	 */
	public Vector<AgentType> getSRSAgents() {
		Vector<AgentType> ret = new Vector<AgentType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof AgentType) {
				boolean found = false;
				for (AgentType g2 : ret) {
					if (g2.getValue().equals(((AgentType)o).getValue())) {
						found = true;
						break;
					}
				}
				if (!found && ((AgentType)o).getValue() != null && !((AgentType)o).getValue().equals("")) {
					ret.add((AgentType)o);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Return the activity performers defined in the Activity model
	 * 
	 * @return a vector containing the FieldExtensions defining such
	 */
	public Map<Task, String> getActivityPerformers() {
		Map<Task, String> ret = new HashMap<Task, String>();
		
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if(o instanceof ServiceTask){
				String role = null;
				String name = null;
				if(((ServiceTask)o).getFieldExtensions() != null && ((ServiceTask)o).getFieldExtensions().size() > 0){
					for (FieldExtension fieldExtension : ((ServiceTask)o).getFieldExtensions()) {
						if(fieldExtension.getFieldname().equals("RequestedServiceProvider")){
							name = fieldExtension.getExpression();
						}
						if(fieldExtension.getFieldname().equals("RequestedServiceProviderRole")){
							role = fieldExtension.getExpression();
						}
					}
					String performer = null;
					if(role != null){
						performer = "Role: " + role;
					}
					if(name != null){
						performer = performer != null ? "Name: " + name + " / " + performer : "Name: " + name;
					}
					if(performer != null){
						ret.put((ServiceTask)o, performer);
					}					
				
				}
			}
			else if (o instanceof UserTask){
				String name = ((UserTask)o).getAssignee();
				String performer = "";
				if(((UserTask)o).getCandidateGroups() != null && ((UserTask)o).getCandidateGroups().size() > 0){
					String role = ((UserTask)o).getCandidateGroups().get(0).getGroup();
					performer = "Role: " + role;
				}
				
				if(name != null && !name.equals("")){
					performer = "Name: " + name + " / " + performer;
				}
				if(!performer.equals("") && !ret.containsKey(performer)){
					ret.put((UserTask)o, performer);
				}			
			}
		}
		
		return ret;
	}
	
	
//	public Vector<Task> getTasksWithPerformer(String performer) {
//		Vector<Task> ret = new Vector<Task>();
//		TreeIterator<EObject> i = activiti.getAllContents();
//		while (i.hasNext()) {
//			EObject o = i.next();
//			if (o instanceof ServiceTask) {
//				boolean found = false;
//				for (FieldExtension fe : ((ServiceTask)o).getFieldExtensions()) {
//					if (fe.getExpression().equals(performer)) {
//						found = true;
//						break;
//					}
//				}
//				if (found) {
//					ret.add((Task)o);
//				}
//			}
//			else if (o instanceof UserTask && ((UserTask)o).getAssignee() != null && ((UserTask)o).getAssignee().equals(performer)) {
//				ret.add((Task)o);
//			}
//		}
//		return ret;
//	}

	/**
	 * Return all the document objects defined in the SRS.
	 * 
	 * @return a vector with the results
	 */
	public Vector<DocType> getSRSDocuments() {
		Vector<DocType> ret = new Vector<DocType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof DocType) {
				boolean found = false;
				for (DocType g2 : ret) {
					if (g2.getValue().equals(((DocType)o).getValue())) {
						found = true;
						break;
					}
				}
				if (!found) {
					ret.add((DocType)o);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Return all the threats objects defined in the SRS.
	 * 
	 * @return a vector with the results
	 */
	public Vector<ThreatType> getSRSThreats() {
		Vector<ThreatType> ret = new Vector<ThreatType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof ThreatType) {
				boolean found = false;
				for (ThreatType t2 : ret) {
					if (t2.getId().equals(((ThreatType)o).getId())) {
						found = true;
						break;
					}
				}
				if (!found) {
					ret.add((ThreatType)o);
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * Return all the field extensions representing variables in the Activity model.
	 * 
	 * @return a vector with the results
	 */
	public Vector<FieldExtension> getActivityVariables() {
		Vector<FieldExtension> ret = new Vector<FieldExtension>();
		
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof FieldExtension && ((FieldExtension)o).getFieldname() != null && (((FieldExtension)o).getFieldname().equals("input") || ((FieldExtension)o).getFieldname().equals("output") || ((FieldExtension)o).getFieldname().equals("resultVariable"))) {
				ret.add((FieldExtension)o);
			}
		}
		
		return ret;
	}

	public Vector<String> getVarsInFieldExtension(FieldExtension var) {
		Vector<String> ret = new Vector<String>();
		
		String exp = var.getExpression();
		if (exp != null && !exp.equals("")) {
			String [] vars = exp.split("~");
			for (String v : vars) {
				if (v.contains("${") && v.contains("}")) {
					ret.add( v.substring(v.indexOf("${") + 2, v.indexOf('}', v.indexOf("${"))).trim() );
				}
				else {
					ret.add(v);
				}
			}
		}
		
		return ret;
	}
	
	public Vector<FieldExtension> getVarForTask(Task t){
		Vector<FieldExtension> ret = new Vector<FieldExtension>();
		
		if(t instanceof ServiceTask){
			for (FieldExtension fe : ((ServiceTask)t).getFieldExtensions()) {
				if(fe.getFieldname().equals("input") || fe.getFieldname().equals("resultVariable")){
					ret.add(fe);
				}
			}
		}
		else{
			if(((UserTask)t).getActivitiListeners() != null && ((UserTask)t).getActivitiListeners().size() > 0){
				for (ActivitiListener activitiListener : ((UserTask)t).getActivitiListeners()) {
					if(activitiListener.getImplementation().equals("eu.aniketos.tasklistener")){
						for (FieldExtension fe : activitiListener.getFieldExtensions()) {
							if(fe.getFieldname().equals("input")){
								ret.add(fe);
							}
						}
					}
				}
			}
		}
		
		return ret;
	}

	public Vector<GoalType> getSRSGoalsByName(String value) {
		Vector<GoalType> ret = new Vector<GoalType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof GoalType && ((GoalType)o).getValue().equals(value)) {
				ret.add((GoalType)o);
			}
		}
		
		return ret;
	}
	
	public Vector<DocType> getSRSDocsByName(String value) {
		Vector<DocType> ret = new Vector<DocType>();
		
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof DocType && ((DocType)o).getValue().equals(value)) {
				ret.add((DocType)o);
			}
		}
		
		return ret;
	}
	
	public Vector<org.eclipse.securebpmn2.BindingOfDuty> getActivityBoDs() {
		Vector<org.eclipse.securebpmn2.BindingOfDuty> ret = new Vector<org.eclipse.securebpmn2.BindingOfDuty>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof org.eclipse.securebpmn2.BindingOfDuty) {
				ret.add((org.eclipse.securebpmn2.BindingOfDuty) o);
			}
		}
		return ret;
	}
	
	public Vector<org.eclipse.securebpmn2.SeparationOfDuty> getActivitySoDs() {
		Vector<org.eclipse.securebpmn2.SeparationOfDuty> ret = new Vector<org.eclipse.securebpmn2.SeparationOfDuty>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof org.eclipse.securebpmn2.SeparationOfDuty) {
				ret.add((org.eclipse.securebpmn2.SeparationOfDuty) o);
			}
		}
		return ret;
	}
	
	public FieldExtension getPerformerNameForTask(ServiceTask task) {
		if (task instanceof ServiceTask) {
			ServiceTask st = (ServiceTask)task;
			for (FieldExtension fe : st.getFieldExtensions()) {
				if (fe.getFieldname().equals("RequestedServiceProvider")) {
					return fe;
				}
			}
		}
		
		return null;
	}

	public CommitmentType getCommitmentWithBoDSoD(String value, String value2) {
		TreeIterator<EObject> i = srs.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof CommitmentType && ((CommitmentType)o).getPostcondition() != null && ((CommitmentType)o).getPostcondition().getAchieveInCombination() != null) {
				GoalSetTypeMin2 set = ((CommitmentType)o).getPostcondition().getAchieveInCombination().getGoalSet();
				try {
					if ((set.getGoal().get(0).getValue().equals(value) && set.getGoal().get(1).getValue().equals(value2)) || (set.getGoal().get(0).getValue().equals(value2) && set.getGoal().get(1).getValue().equals(value))) {
						return (CommitmentType)o;
					}
				}
				catch (NullPointerException e) {
					// Prevent errors in model
				}
			}
			else if (o instanceof CommitmentType && ((CommitmentType)o).getPostcondition() != null && ((CommitmentType)o).getPostcondition().getNotAchieveInCombination() != null) {
				GoalSetTypeMin2 set = ((CommitmentType)o).getPostcondition().getNotAchieveInCombination().getGoalSet();
				try {
					if ((set.getGoal().get(0).getValue().equals(value) && set.getGoal().get(1).getValue().equals(value2)) || (set.getGoal().get(0).getValue().equals(value2) && set.getGoal().get(1).getValue().equals(value))) {
						return (CommitmentType)o;
					}
				}
				catch (NullPointerException e) {
					// Prevent errors in model
				}
			}
		}
		return null;
	}

	public AtomicActivityAction getAtomicActionForTask(Task key) {
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof AtomicActivityAction && ((AtomicActivityAction)o).getActivity() != null && ((AtomicActivityAction)o).getActivity().equals(key)) {
				return (AtomicActivityAction)o;
			}
		}
		return null;
	}

	public String getMappedVar(FieldExtension fe, DocType document) {
		for (RepresentsType rep : mapping.getRepresents()) {
			for (eu.aniketos.mtm.mapping.DocType doc : rep.getDocument()) {
				if (document.getId().equals(doc.getId()) && rep.getVariable().getId().equals(fe.getId())) {
					// Found!!
					try {
						return getVarsInFieldExtension(fe).get(rep.getVariable().getOrder());
					}
					catch (NullPointerException e) {
						return "";
					}
				}
			}			
		}
		return "";
	}

	public Vector<FormProperty> getFormProperties() {
		Vector<FormProperty> ret = new Vector<FormProperty>();
		
		TreeIterator<EObject> i = activiti.getAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof FormProperty && ((FormProperty)o).getName() != null) {
				ret.add((FormProperty)o);
			}
		}
		
		return ret;
		
	}

	public UserTask getTaskUsingFormProperty(FormProperty formProperty) {
		TreeIterator<EObject> i = activiti.getAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			if (o instanceof UserTask) {
				if (((UserTask)o).getFormProperties().contains(formProperty)) {
					return (UserTask)o;
				}
			}
		}
		return null;
	}
	
	public Confidentiality getConfidentialityForTask(ServiceTask st, String varType){
		if (st.getSecurityExtensions() != null && st.getSecurityExtensions().getConfidentialityReq() != null && st.getSecurityExtensions().getConfidentialityReq().size() > 0) {
			for (Confidentiality c : st.getSecurityExtensions().getConfidentialityReq()) {
				if(varType.equals("resultVariable") && c.getType().equals("output")){
					return c;
				}
				else if(varType.equals("input") && c.getType().equals("input")){
					return c;
				}
			}
		}
		return null;
	}

	public Vector<Task> getTaskRelatedToAuthorizationConstraint (String id){
		Vector<Task> ret = new Vector<Task>();
		TreeIterator<EObject> i = activiti.getAllContents();
		while(i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Task) {
				if(((Task)o).getActivityActions() != null){
					for (ActivityAction aa : ((Task)o).getActivityActions()) {
						if(aa.getPermissions() != null){
							for (Permission p : aa.getPermissions()) {
								if(p.getAuthorizationConstraints() != null){
									for (AuthorizationConstraint ac : p.getAuthorizationConstraints()) {
										if(ac.getId().equals(id)){
											ret.add((Task) o);
										}
									}
								}
							}
						}
					}
				}					
			}
		}
		return ret;
	}
	

}
