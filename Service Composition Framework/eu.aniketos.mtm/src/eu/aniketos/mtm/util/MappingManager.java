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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.ActorType;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.ConfidentialityType;
import eu.aniketos.mtm.mapping.DocType;
import eu.aniketos.mtm.mapping.GoalType;
import eu.aniketos.mtm.mapping.IntegrityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingFactory;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.ParticipantType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.SRRType;
import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.ThreatsMapping;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.mapping.TypeType1;
import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.mapping.VarType;
import eu.aniketos.mtm.mapping.impl.DocumentRootImpl;
import eu.aniketos.mtm.mapping.util.MappingResourceFactoryImpl;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.ThreatType;
import eu.aniketos.mtm.utils.Utils;

/**
 * 
 * Singleton for managing complex operations over the SRS/BPMN Activiti mapping model.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class MappingManager {
	public final static String ROOT_ELEMENT = "mapping";
	
	private static MappingManager mappingManager = null;

	private ResourceSet resourceSet;
	private MappingPackage mappingPackage;
	private MappingFactory mappingFactory;

		
	/**
	 * Returns an instance of the singleton.
	 * @return Instance of the singleton.
	 */
	public static MappingManager getInstance() {
		if(mappingManager == null) {
			mappingManager = new MappingManager();
		}
		return mappingManager;
	}
	
	/**
	 * Private constructor.
	 */
	private MappingManager() {
		mappingPackage = MappingPackage.eINSTANCE;
		mappingFactory = MappingFactory.eINSTANCE;
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mapping", new MappingResourceFactoryImpl());
	}

	/**
	 * Creates a mapping root element.
	 * @return A new mapping root element.
	 */
	public MappingType createMappingType() {
		return mappingFactory.createMappingType();
	}

	/**
	 * Loads a mapping root element from a given existing file.
	 * @param path The path of the mapping file.
	 * @return The loaded mapping root element.
	 * @throws IOException
	 */
	public MappingType loadMappingType(String path) throws IOException {		
		Resource resource = resourceSet.createResource(URI.createFileURI(path));
		resource.load(Collections.EMPTY_MAP);
		DocumentRootImpl root = (DocumentRootImpl)resource.getContents().get(0);
		MappingType mapping = root.getMapping();		
		return mapping;
	}

	/**
	 * Saves a mapping root element into a file.
	 * @param mapping The SRS mapping root element to be saved.
	 * @param path The target file path.
	 * @throws IOException
	 */
	public void saveMappingType(MappingType mapping, String path) throws IOException {	
		Resource res = resourceSet.createResource(URI.createFileURI(path));
		DocumentRootImpl rootObject = getRootObject(mapping);
		res.getContents().add(rootObject);
		res.save(null);
	}

	/**
	 * Creates a document root element that contains a given mapping element.
	 * @param mapping The mapping element to be added.
	 * @return The new root element containing the mapping.
	 */
	public DocumentRootImpl getRootObject(MappingType mapping) {	
		DocumentRootImpl rootObject = createInitialModel();
		rootObject.setMapping(mapping);
		return rootObject;
	}
	
	/**
	 * Creates a new document root element.
	 * @return The new document root element.
	 */
	private DocumentRootImpl createInitialModel() {
		EClass eClass = ExtendedMetaData.INSTANCE.getDocumentRoot(mappingPackage);
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(ROOT_ELEMENT);
		EObject rootObject = mappingFactory.create(eClass);
		rootObject.eSet(eStructuralFeature, EcoreUtil.create((EClass)eStructuralFeature.getEType()));
		return ((DocumentRootImpl)rootObject);
	}
	
	/**
	 * Clears all plays elements hanging from a mapping element.
	 * @param mapping The mapping parent element.
	 */
	public void resetPlaysList(MappingType mapping) {
		mapping.getPlays().clear();
	}
	
	/**
	 * Adds a plays element to a parent mapping.
	 * @param mapping The mapping parent element.
	 * @param plays The plays element to add.
	 */
	public void addPlays(MappingType mapping, PlaysType plays) {
		mapping.getPlays().add(plays);
	}
	
	/**
	 * Clears all isA elements hanging from a mapping element.
	 * @param mapping The mapping parent element.
	 */
	public void resetIsAList(MappingType mapping) {
		mapping.getIsA().clear();
	}
	
	/**
	 * Adds an isA element to a parent mapping.
	 * @param mapping The mapping parent element.
	 * @param isa The isA element to add.
	 */
	public void addIsA(MappingType mapping, IsaType isa) {
		mapping.getIsA().add(isa);
	}
	
	/**
	 * Creates a new SRS agent element.
	 * @param id The agent ID.
	 * @param value The agent name.
	 * @return The new agent element.
	 */
	public SRAType createSRAgent(String id, String value) {
		SRAType sra = mappingFactory.createSRAType();
		sra.setId(id);
		sra.setValue(value);
		return sra;
	}
	
	/**
	 * Creates a new SRS role element.
	 * @param id The role ID.
	 * @param value The role name.
	 * @return The new role element.
	 */
	public SRRType createSRRole(String id, String value) {
		SRRType srr = mappingFactory.createSRRType();
		srr.setId(id);
		srr.setValue(value);
		return srr;
	}
	
	/**
	 * Creates a new BPMN participant element.
	 * @param id The participant ID.
	 * @param value The participant name.
	 * @return The new participant element.
	 */
	public BPPType createBPPart(String id, String value) {
		BPPType bpp = mappingFactory.createBPPType();
		bpp.setId(id);
		bpp.setValue(value);
		return bpp;
	}
	
	/**
	 * Creates a new BPMN participant element.
	 * @param id The participant ID.
	 * @param value The participant name.
	 * @param type The type of the participant: service or human.
	 * @return The new participant element.
	 */
	public BPPType createBPPart(String id, String value, TypeType type) {
		BPPType bpp = mappingFactory.createBPPType();
		bpp.setId(id);
		bpp.setValue(value);
		bpp.setType(type);
		return bpp;
	}
	
	/**
	 * Creates a new BPMN participant role element.
	 * @param id The participant role ID.
	 * @param value The participant role name.
	 * @param type The type of the participant: service or human.
	 * @return The new participant role element.
	 */
	public BPRType createBPRole(String id, String value, TypeType type){
		BPRType bprType = mappingFactory.createBPRType();
		bprType.setId(id);
		bprType.setValue(value);
		bprType.setType(type);		
		return bprType;		
	}
	
	/**
	 * Creates an isA relationship element, given a SRS agent and a BPMN participant.
	 * @param sra A SRS agent.
	 * @param bpp A BPMN participant.
	 * @return The new isA element.
	 */
	public IsaType createIsA(SRAType sra, BPPType bpp) {
		IsaType isa = mappingFactory.createIsaType();
		isa.getSRAgent().add(sra);
		isa.getBPPart().add(bpp);
		return isa;
	}
	
	/**
	 * Creates an isA relationship element, given a SRS agent, a BPMN participant and a BPMN role participant.
	 * @param sra A SRS agent.
	 * @param bpp A BPMN participant.
	 * @param bpr A BPMN role participant.
	 * @return The new isA element.
	 */
	public IsaType createIsA(SRAType sra, BPPType bpp, BPRType bpr) {
		IsaType isa = mappingFactory.createIsaType();
		isa.getSRAgent().add(sra);
		isa.getBPPart().add(bpp);
		isa.getBPRole().add(bpr);
		return isa;
	}
	
	/**
	 * Creates an isA relationship element, given a SRS role and a BPMN participant.
	 * @param srr A SRS role.
	 * @param bpp A BPMN participant.
	 * @return The new isA element.
	 */
	public IsaType createIsA(SRRType srr, BPPType bpp) {
		IsaType isa = mappingFactory.createIsaType();
		isa.getSRRole().add(srr);
		isa.getBPPart().add(bpp);
		return isa;
	}
	
	/**
	 * Creates a plays relationship element.
	 * @param srr A SRS role.
	 * @param bpp A BPMN participant.
	 * @return The new plays element.
	 */
	public PlaysType createPlays(SRRType srr, BPPType bpp) {
		PlaysType plays = mappingFactory.createPlaysType();
		plays.setSRRole(srr);
		plays.setBPPart(bpp);
		return plays;
	}
	
	/**
	 * Clears all relatesTo elements hanging from a mapping element.
	 * @param mapping The mapping parent element.
	 */
	public void resetRelatesToList(MappingType mapping) {
		mapping.getRelatesTo().clear();
	}
	
	/**
	 * Adds a relatesTo element to a parent mapping.
	 * @param mapping The mapping parent element.
	 * @param relatesTo The relatesTo element to add.
	 */
	public void addRelatesTo(MappingType mapping, RelatesToType relatesTo) {
		mapping.getRelatesTo().add(relatesTo);
	}
	
	/**
	 * Creates a SRS goal element.
	 * @param id The goal ID.
	 * @param value The goal name.
	 * @return The new goal element.
	 */
	public GoalType createGoal(String id, String value) {
		GoalType goal = mappingFactory.createGoalType();
		goal.setId(id);
		goal.setValue(value);
		return goal;
	}
	
	/**
	 * Creates a new BPMN activity (task) element.
	 * @param id The activity ID.
	 * @param value The activity name.
	 * @return The new activity element.
	 */
	public ActivityType createActivity(String id, String value) {
		ActivityType activity = mappingFactory.createActivityType();
		activity.setId(id);
		activity.setValue(value);
		return activity;
	}
	

	/**
	 * Associates a variable to an BPMN activity (task) element.
	 * @param activity The parent activity element.
	 * @param id The ID of the variable to add.
	 */
	public void addActivityVariable(ActivityType activity, String id, TypeType2 type, String confAlg) {
		ActivityVar var = mappingFactory.createActivityVar();
		var.setId(id);
		var.setType(type);
		if(confAlg != null){
			ConfidentialityType ct = mappingFactory.createConfidentialityType();
			ct.setAlgorithm(confAlg);
			var.setConfidentiality(ct);
		}
		activity.getVariable().add(var);
	}
	
	/**
	 * Associates a BPMN participant.
	 * @param activity The parent activity element.
	 * @param part The participant to add.
	 */
	public void addActivityParticipant(ActivityType activity, ParticipantType part) {
		addActivityParticipant(activity, getParticipantId(part));
	}
	
	/**
	 * Associates a BPMN participant.
	 * @param activity The parent activity element.
	 * @param id The ID of the participant to add.
	 */
	public void addActivityParticipant(ActivityType activity, String id) {
		activity.getParticipant().add(id);
	}

	/**
	 * Associates the trustworthiness property to a activity
	 * @param activity The parent activity element.
	 * @param trust The trustworthiness level treshhold to add
	 */
	public void addActivityTrustworthinessProperty(ActivityType activity, String trust){
		activity.setTrustworthiness(Float.parseFloat(trust));
	}
	
	public void addActivityIntegrityProperty(ActivityType activity, String variableId, String withServiceTaskId, String type, String algorithm){
		IntegrityType integrityType = mappingFactory.createIntegrityType();
		integrityType.setWith(withServiceTaskId);
		integrityType.setType(type);
		integrityType.setAlgorithm(algorithm);
		integrityType.setVariable(variableId);
		activity.getIntegrity().add(integrityType);
	}
	
	public void resetActivityIntegrity (ActivityType activity){
		activity.getIntegrity().clear();
	}
	
	public void removeActivityIntegrity (ActivityType activity, String variableId){
		IntegrityType integrityTypeToRemove = null;
		for (IntegrityType integrityType : activity.getIntegrity()) {
			if(integrityType.getVariable().equals(variableId)){
				integrityTypeToRemove = integrityType;
				break;
			}
		}
		if(integrityTypeToRemove != null){
			activity.getIntegrity().remove(integrityTypeToRemove);
		}
	}
	
	/**
	 * Sets the BPMN activity type (user/service task).
	 * @param activity The activity to be set.
	 * @param type The new type of the activity.
	 */
	public void setActivityType(ActivityType activity, UsertypeType type) {
		activity.setUsertype(type);
	}
	
	/**
	 * Creates a new relatesTo relationship element.
	 * @param goal A SRS goal element.
	 * @param activity A BPMN activity element.
	 * @return The new relatesTo element.
	 */
	public RelatesToType createRelatesTo(List<GoalType> goalList, ActivityType activity) {
		RelatesToType relatesTo = mappingFactory.createRelatesToType();
		for (GoalType goalType : goalList) {
			relatesTo.getGoal().add(goalType);
		}		
		relatesTo.setActivity(activity);
		return relatesTo;
	}
	
	/**
	 * Clears all plays elements hanging from a mapping element.
	 * @param mapping The mapping parent element.
	 */
	public void resetRepresentsList(MappingType mapping) {
		mapping.getRepresents().clear();
	}
	
	/**
	 * Adds a represents element to a parent mapping.
	 * @param mapping The mapping parent element.
	 * @param plays The represents element to add.
	 */
	public void addRepresents(MappingType mapping, RepresentsType represents) {
		mapping.getRepresents().add(represents);
	}
	
	/**
	 * Creates a SRS document element.
	 * @param id The document ID.
	 * @param value The document name.
	 * @return The new document element.
	 */
	public DocType createDocument(String id, String value) {
		DocType doc = mappingFactory.createDocType();
		doc.setId("" + id);
		doc.setValue(value);
		return doc;
	}
	
	/**
	 * Creates a new BPMN variable element.
	 * @param id The variable ID.
	 * @param value The variable name.
	 * @return The new variable element.
	 */
	public VarType createVariable(String id, String value, int order) {
		VarType var = mappingFactory.createVarType();
		var.setId(id);
		var.setValue(value);
		var.setOrder(order);
		return var;
	}
	
	/**
	 * Creates a new represents relationship element.
	 * @param goal A SRS goal element.
	 * @param activity A BPMN activity.
	 * @return The new represents element.
	 */
	public RepresentsType createRepresents(DocType doc, VarType var) {
		RepresentsType represents = mappingFactory.createRepresentsType();
		represents.getDocument().add(doc);
		represents.setVariable(var);
		return represents;
	}
	
	public RepresentsType createRepresents (List<DocType> docList, VarType var){
		RepresentsType represents = mappingFactory.createRepresentsType();
		represents.getDocument().addAll(docList);
		represents.setVariable(var);
		return represents;
	}
	
	
	/**
	 * Extracts a BPMN participant element (given its ID) hanging from a mapping parent element tree.
	 * @param mapping The parent mapping element.
	 * @param partId The participant ID.
	 * @return The BPMN participant found.
	 */
//	public ParticipantType getParticipantById(MappingType mapping, String partId) {
//		EList<PlaysType> playsList = mapping.getPlays();
//		for(PlaysType plays : playsList) {
//			try {
//				BPPType bpp = plays.getBPPart();
//				if(bpp.getId().equals(partId)) {
//					return bpp;
//				}
//			} catch(Exception e) {
//			}
//		}
//		EList<IsaType> isaList = mapping.getIsA();
//		for(IsaType isa : isaList) {
//			try {
//				EList<BPPType> bppList = isa.getBPPart();
//				for(BPPType bpp : bppList) {
//					if(bpp.getId().equals(partId)) {
//						return bpp;
//					}
//				}
//				EList<BPRType> bprList = isa.getBPRole();
//				for(BPRType bpr : bprList) {
//					if(bpr.getId().equals(partId)) {
//						return bpr;
//					}
//				}
//			} catch(Exception e) {
//			}
//		}
//		return null;
//	}
	
	public IsaType getIsaParticipantById(MappingType mapping, String id){
		EList<IsaType> isaList = mapping.getIsA();
		for (IsaType isaType : isaList) {
			if(isaType.getBPPart().get(0).getId().equals(id)){
				return isaType;
			}
		}
		return null;
	}
	
	public IsaType getIsaParticipantOrRoleById(MappingType mapping, String id){
		EList<IsaType> isaList = mapping.getIsA();
		for (IsaType isaType : isaList) {
			if(isaType.getBPPart() != null && isaType.getBPPart().get(0) != null && isaType.getBPPart().get(0).getId() != null){
				if(isaType.getBPPart().get(0).getId().equals(id)){
					return isaType;
				}
			}
			else if (isaType.getBPRole() != null && isaType.getBPRole().get(0) != null && isaType.getBPRole().get(0).getId() != null){
				if(isaType.getBPRole().get(0).getId().equals(id)){
					return isaType;
				}
			}
		}
		return null;
	}
	
	public PlaysType getPlaysParticipantById (MappingType mapping, String id){
		EList<PlaysType> playsList = mapping.getPlays();
		for (PlaysType playsType : playsList) {
			if(playsType.getBPPart().getId().equals(id)){
				return playsType;
			}
		}
		return null;
	}
	
	/**
	 * Gets a Participant's ID.
	 * @param part The participant.
	 * @return The ID.
	 */
	public String getParticipantId(ParticipantType part) {
		if(part instanceof BPPType) {
			return ((BPPType)part).getId();
		} else if(part instanceof BPRType) {
			return ((BPRType)part).getId();
		}
		return null;
	}
	
	/**
	 * Gets the BPMN variable to which a SRS document is mapped in a represents relationship.
	 * @param mapping The parent mapping element.
	 * @param doc The document element mapped.
	 * @return The variable element that maps the document.
	 */
	public VarType getVar(MappingType mapping, DocType doc) {
		return getVar(mapping, doc.getId());
	}
	
	/**
	 * Gets the BPMN variable to which a SRS document is mapped in a represents relationship.
	 * @param mapping The parent mapping element.
	 * @param docId The ID of the document element mapped.
	 * @return The variable element that maps the document.
	 */
	public VarType getVar(MappingType mapping, String docId) {
		EList<RepresentsType> repList = mapping.getRepresents();
		for(RepresentsType rep : repList) {
			try {
				for (DocType doc : rep.getDocument()) {
					if(doc.getId().equals(docId)){
						return rep.getVariable();
					}
				}
			} catch(Exception e) {
			}
		}
		return null;
	}
	
	/**
	 * Extracts a BPMN variable element (given its ID) hanging from a mapping parent element tree.
	 * @param mapping The parent mapping element.
	 * @param varId The variable ID.
	 * @return The BPMN variable element found.
	 */
	public VarType getVarById(MappingType mapping, String varId) {
		EList<RepresentsType> repList = mapping.getRepresents();
		for(RepresentsType rep : repList) {
			try {
				VarType var = rep.getVariable();
				if(var.getId().equals(varId)) {
					return var;
				}
			} catch(Exception e) {
			}
		}
		return null;
	}
	
	public RepresentsType getRepresentsByVarId (MappingType mapping, String varId){
		EList<RepresentsType> repList = mapping.getRepresents();
		for(RepresentsType rep : repList) {
			VarType var = rep.getVariable();
			if(var.getId().equals(varId)) {
				return rep;
			}
		}
		return null;
	}
	
	
	/**
	 * Gets the BPMN participants to which a SRS actor is mapped in a plays or is-a relationship.
	 * @param mapping The parent mapping element.
	 * @param actorId The ID of the actor element mapped.
	 * @return The list of participant elements that map the actor.
	 */
	public ArrayList<ParticipantType> getParticipants(MappingType mapping, String actorId) {
		ArrayList<ParticipantType> partList =  new ArrayList<ParticipantType>();

		ArrayList<ParticipantType> tmpList = new ArrayList<ParticipantType>();
		
		// Plays relationship
		EList<PlaysType> playsList = mapping.getPlays();
		for(PlaysType plays : playsList) {
			try {
				ActorType actor = plays.getSRRole();
				if(actor.getId().equals(actorId)) {
					tmpList.add(plays.getBPPart());
				}
			} catch(Exception e) {
			}
		}
		
		// Is-a relationship
		EList<IsaType> isaList = mapping.getIsA();
		for(IsaType isa : isaList) {
			try {
				boolean found = false;
				EList<SRAType> agentList = isa.getSRAgent();
				for(ActorType actor : agentList) {
					if(actor.getId().equals(actorId)) {
						found = true;
						break;
					}
				}
				if(!found) {
					EList<SRRType> roleList = isa.getSRRole();
					for(ActorType actor : roleList) {
						if(actor.getId().equals(actorId)) {
							found = true;
							break;
						}
					}
				}
				if(found) {
					tmpList.addAll(isa.getBPPart());
					tmpList.addAll(isa.getBPRole());
				}
			} catch(Exception e) {
			}
		}
		
		// Add unrepeated
		for(ParticipantType tmpPart : tmpList) {
			boolean found = false;
			for(ParticipantType part : partList) {
				try {
					if(getParticipantId(part).equals(getParticipantId(tmpPart))) {
						found = true;
						break;
					}
				} catch(Exception e) {
				}
			}
			if(!found) {
				partList.add(tmpPart);
			}
		}
		
		return partList;
	}	
		
	public ActivityType findActivityById(MappingType mapping, String activityId){
		EList<RelatesToType> relatesToTypes = mapping.getRelatesTo();
		for (RelatesToType relatesToType : relatesToTypes) {
			if(relatesToType.getActivity().getId().equals(activityId)){
				return relatesToType.getActivity();
			}
		}
		return null;
	}
	
	public List<DocType > getDocsByVariableId (MappingType mapping, String variableId){
		EList<RepresentsType> representsTypes = mapping.getRepresents();
		for (RepresentsType representsType : representsTypes) {
			if(representsType.getVariable().getId().equals(variableId)){
				return representsType.getDocument();
			}			
		}
		return null;
	}
	
	public ActivityType getActivityByGoalId (MappingType mapping, String goalId){
		EList<RelatesToType> relatesToTypes = mapping.getRelatesTo();
		for (RelatesToType relatesToType : relatesToTypes) {			
			EList<GoalType> goalTypes = relatesToType.getGoal();
			for (GoalType goalType : goalTypes) {
				if(goalType.getId().equals(goalId)){
					return relatesToType.getActivity();
				}
			}
		}
		return null;
	}
	
	public PermissionType createPermission (String role, String action){
		PermissionType permissionType = mappingFactory.createPermissionType();
		permissionType.setId(Utils.generateUniqueID());
		permissionType.setRole(role);
		permissionType.setAction(action);
		return permissionType;
	}
	
	public void resetActivityPermission (ActivityType activity){
		activity.getPermission().clear();
	}
	
	public SoDBoDType createSoDBoD (String type, String commitmentID){
		SoDBoDType soDBoDType = mappingFactory.createSoDBoDType();
		soDBoDType.setId(Utils.generateUniqueID());
		if(type.equals(TypeType1.SO_D.getName())){
			soDBoDType.setType(TypeType1.SO_D);
		}
		else if(type.equals(TypeType1.BO_D.getName())){
			soDBoDType.setType(TypeType1.BO_D);
		}
		soDBoDType.setCommitmentID(commitmentID);
		
		return soDBoDType;
	}
	
	public void resetSoDBoDList (MappingType mapping){
		mapping.getSoDBoDProperties().clear();
	}
		
	public IsaType getMappingIsAByBprId (MappingType mapping, String id){
		for (IsaType isaType : mapping.getIsA()) {
			if(isaType.getBPRole().get(0).getId().equals(id)){
				return isaType;
			}			
		}
		return null;
	}
	
//	public String findRoleIdByAgentId (MappingType mapping, String id){
//		IsaType isaType = getIsaParticipantById(mapping, id);
//		if(isaType != null){
//			return isaType.getBPPart().get(0).getId();
//		}
//		else{
//			PlaysType playsType = getPlaysParticipantById(mapping, id);
//			if(playsType != null){
//				return playsType.getBPPart().getId();
//			}
//		}
//		return null;
//	}
//	
	public eu.aniketos.mtm.mapping.ThreatType createThreatType (String id, String repositoryId, String name){
		eu.aniketos.mtm.mapping.ThreatType t = mappingFactory.createThreatType();
		t.setId(id);
		t.setRepositoryID(repositoryId);
		t.setName(name);
		return t;
	}
	
	public ThreatsMapping createThreatsMappingType (eu.aniketos.mtm.mapping.ThreatType srThreatType, eu.aniketos.mtm.mapping.ThreatType bpThreatType){
		ThreatsMapping tm = mappingFactory.createThreatsMapping();
		tm.setSRThreat(srThreatType);
		tm.setBPThreat(bpThreatType);
		return tm;
	}
	
	public eu.aniketos.mtm.mapping.ThreatType findBPThreatBySRThreatId (MappingType mapping, String id){
		for (ThreatsMapping t : mapping.getThreats()) {
			if(t.getSRThreat().getId().equals(id)) {
				return t.getBPThreat();
			}
		}
		return null;
	}
	
	public eu.aniketos.mtm.mapping.ThreatType findBPThreatByBPThreatId (MappingType mapping, String id){
		for (ThreatsMapping t : mapping.getThreats()) {
			if(t.getBPThreat().getId().equals(id)) {
				return t.getBPThreat();
			}
		}
		return null;
	}
	
	public List<ActivityType> getServiceTypeActivities (MappingType mapping){
		List<ActivityType> list = new ArrayList<ActivityType>();
		for (RelatesToType rt : mapping.getRelatesTo()) {
			if(rt.getActivity().getUsertype().equals(UsertypeType.SERVICE_TASK)){
				list.add(rt.getActivity());
			}
		}
		return list;
	}
	
	public List<ActivityType> getActivitiesRelatedToThreat (MappingType mapping, ThreatType threat){
		List<ActivityType> list = new ArrayList<ActivityType>();
		if(threat.getGoal() != null && threat.getGoal().size() >= 0){
			for (eu.aniketos.mtm.srs.GoalType g : threat.getGoal()) {
				ActivityType at = getActivityByGoalId(mapping, g.getId());
				if(at.getUsertype().equals(UsertypeType.SERVICE_TASK) && !list.contains(at)){
					list.add(at);
				}				
			}
		}
		if(threat.getActor() != null && threat.getActor().size() >= 0){
			for (eu.aniketos.mtm.srs.ActorType a : threat.getActor()) {
				ArrayList<ParticipantType> parts = getParticipants(mapping, SrsManager.getInstance().getActorId(a));
				for (ParticipantType participantType : parts) {
					for (ActivityType at : getServiceTypeActivities(mapping)) {
						if(at.getParticipant().contains(getParticipantId(participantType))){
							if(at.getUsertype().equals(UsertypeType.SERVICE_TASK) && !list.contains(at)){
								list.add(at);
							}	
						}
					}
				}
			}
		}
		if(threat.getDelegation() != null && threat.getDelegation().size() >= 0){
			for (DelType d : threat.getDelegation()) {
				for (eu.aniketos.mtm.srs.GoalType g : d.getGoalSet().getGoal()) {
					ActivityType at = getActivityByGoalId(mapping, g.getId());
					if(at.getUsertype().equals(UsertypeType.SERVICE_TASK) && !list.contains(at)){
						list.add(at);
					}	
				}
			}
		}
		if(threat.getDocument() != null && threat.getDocument().size() >= 0){
			for (eu.aniketos.mtm.srs.DocType d : threat.getDocument()) {
				VarType v = getVar(mapping, d.getId());
				for (ActivityType at : getServiceTypeActivities(mapping)) {
					for (ActivityVar av : at.getVariable()) {
						if(av.getId().equals(v.getId())){
							if(at.getUsertype().equals(UsertypeType.SERVICE_TASK) && !list.contains(at)){
								list.add(at);
							}	
						}
					}
				}
			}
		}			
		
		return list;
	}

}
