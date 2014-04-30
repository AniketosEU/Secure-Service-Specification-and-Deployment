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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.AgentType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.ConfidentialityType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalSetType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.InfoSetType;
import eu.aniketos.mtm.srs.InfoType;
import eu.aniketos.mtm.srs.IntegrityType;
import eu.aniketos.mtm.srs.KBType;
import eu.aniketos.mtm.srs.ProvType;
import eu.aniketos.mtm.srs.RoleType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.SrsFactory;
import eu.aniketos.mtm.srs.SrsPackage;
import eu.aniketos.mtm.srs.TangibleByType;
import eu.aniketos.mtm.srs.TrustworthinessType;
import eu.aniketos.mtm.srs.impl.DocumentRootImpl;
import eu.aniketos.mtm.srs.util.SrsResourceFactoryImpl;

/**
 * 
 * Singleton for managing complex operations over the SRS model.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class SrsManager {
	public final static String ROOT_ELEMENT = "secReqSpe";
	
	public final static String COMMIT_TRUSTWORTHINESS = "trustworthiness";
	public final static String COMMIT_INTEGRITY = "integrity";
	
	private static SrsManager srsManager = null;
	
	private ResourceSet resourceSet;
	private SrsPackage srsPackage;
	private SrsFactory srsFactory;
	
	/**
	 * Returns an instance of the singleton.
	 * @return Instance of the singleton.
	 */
	public static SrsManager getInstance() {
		if(srsManager == null) {
			srsManager = new SrsManager();
		}
		return srsManager;
	}
	
	/**
	 * Private constructor.
	 */
	private SrsManager() {
		srsPackage = SrsPackage.eINSTANCE;
		srsFactory = SrsFactory.eINSTANCE;
		resourceSet = new ResourceSetImpl();
		SrsResourceFactoryImpl srsImpl = new SrsResourceFactoryImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("srs", srsImpl);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", srsImpl);
		resourceSet.getPackageRegistry().put(srsPackage.getNsURI(), srsPackage);
	}

	/**
	 * Creates a SRS SecReqSpe root element.
	 * @return A new SRS SecReqSpe root element.
	 */
	public SecReqSpeType createSecReqSpeType() {
		return srsFactory.createSecReqSpeType();
	}

	/**
	 * Loads a SRS SecReqSpe root element from a given existing file.
	 * @param path The path of the SRS file.
	 * @return The loaded SRS SecReqSpe root element.
	 * @throws IOException
	 */
	public SecReqSpeType loadSecReqSpeType(String path) throws IOException {		
		Resource resource = resourceSet.createResource(URI.createFileURI(path));
		resource.load(Collections.EMPTY_MAP);
		DocumentRootImpl root = (DocumentRootImpl)resource.getContents().get(0);
		SecReqSpeType srs = root.getSecReqSpe();		
		return srs;
	}

	/**
	 * Saves a SRS SecReqSpe root element into a file.
	 * @param definitions The SRS SecReqSpe root element to be saved.
	 * @param path The target file path.
	 * @throws IOException
	 */
	public void saveSecReqSpeType(SecReqSpeType srs, String path) throws IOException {	
		Resource res = resourceSet.createResource(URI.createFileURI(path));
		DocumentRootImpl rootObject = createInitialModel();
		rootObject.setSecReqSpe(srs);
		res.getContents().add(rootObject);
		res.save(null);
	}
	
	/**
	 * Creates a new document root element.
	 * @return The new document root element.
	 */
	private DocumentRootImpl createInitialModel() {
		EClass eClass = ExtendedMetaData.INSTANCE.getDocumentRoot(srsPackage);
		EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(ROOT_ELEMENT);
		EObject rootObject = srsFactory.create(eClass);
		rootObject.eSet(eStructuralFeature, EcoreUtil.create((EClass)eStructuralFeature.getEType()));
		return ((DocumentRootImpl)rootObject);
	}

	/**
	 * Extracts a list containing all the agent elements found hanging from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list with all the agent elements.
	 */
	public ArrayList<AgentType> extractAgentList(SecReqSpeType srs) {
		ArrayList<AgentType> agentList = new ArrayList<AgentType>();
		
		TreeIterator<EObject> iterator = srs.eAllContents();
		while(iterator.hasNext()) {
			EObject object = iterator.next();
			if(object instanceof AgentType) {
				AgentType newAgent = (AgentType)object;
				if(!newAgent.getId().equals("*")){ // Filters Agent elements with * id, i.e expressing "All agents"
					boolean found = false;
					for(AgentType agent : agentList) {
						if(agent.getId().equals(newAgent.getId())) {
							found = true;
							break;
						}
					}
					if(!found) {
						agentList.add(newAgent);
					}
				}				
			}
		}
		
		return agentList;
	}

	/**
	 * Extracts a list containing all the role elements found hanging from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list with all the role elements.
	 */
	public ArrayList<RoleType> extractRoleList(SecReqSpeType srs) {
		ArrayList<RoleType> roleList = new ArrayList<RoleType>();
		
		TreeIterator<EObject> iterator = srs.eAllContents();
		while(iterator.hasNext()) {
			EObject object = iterator.next();
			if(object instanceof RoleType) {
				RoleType newRole = (RoleType)object;
				boolean found = false;
				for(RoleType role : roleList) {
					if(role.getId().equals(newRole.getId())) {
						found = true;
						break;
					}
				}
				if(!found) {
					roleList.add(newRole);
				}
			}
		}
		
		return roleList;
	}

	/**
	 * Extracts a list containing all the goal elements found hanging from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list with all the goal elements.
	 */
	public ArrayList<GoalType> extractGoalList(SecReqSpeType srs) {
		ArrayList<GoalType> goalList = new ArrayList<GoalType>();
		
		TreeIterator<EObject> iterator = srs.eAllContents();
		while(iterator.hasNext()) {
			EObject object = iterator.next();
			if(object instanceof GoalType) {
				GoalType newGoal = (GoalType)object;
				boolean found = false;
				for(GoalType goal : goalList) {
					if(goal.getId().equals(newGoal.getId())) {
						found = true;
						break;
					}
				}
				if(!found) {
					goalList.add(newGoal);
				}
			}
		}
		
		return goalList;
	}
	
	
	/**
	 * Extracts a list containing all the documents elements found hanging from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list with all the documents elements.
	 */
	public ArrayList<DocType> extractDocumentList(SecReqSpeType srs) {
		ArrayList<DocType> docList = new ArrayList<DocType>();
		
		TreeIterator<EObject> iterator = srs.eAllContents();
		while(iterator.hasNext()) {
			EObject object = iterator.next();
			if(object instanceof DocType) {
				DocType newDoc = (DocType) object;

				boolean found = false;
				for(DocType doc : docList) {
					if(doc.getId().equals(newDoc.getId())) {
						found = true;
						break;
					}
				}
				if(!found) {
					docList.add(newDoc);
				}
			}
		}
		
		return docList;
	}
	
	/**
	 * Extracts a list containing all the documents elements by each different doc name from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A map where the key is the document name and the value is the list of the documents that have the same name
	 */
	public Map<String, List<DocType>> extractRelatedDocuments(SecReqSpeType srs) {
		Map<String, List<DocType>> docMap = new HashMap<String, List<DocType>>();
		
		List<DocType> allDocList = extractDocumentList(srs);
		for (DocType docType : allDocList) {
			if(docMap.containsKey(docType.getValue())){
				List<DocType> docs = docMap.get(docType.getValue());
				docs.add(docType);
			}
			else{
				List<DocType> docs = new ArrayList<DocType>();
				docs.add(docType);
				docMap.put(docType.getValue(), docs);
			}
		}
		
		return docMap;
	}
	
	/**
	 * Extracts a map containing a list of goal elements by each different goal name from a SecReqSpe element tree.
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A map where the key is the goal name and the value is the list of the goals that have the same name
	 */
	public Map<String, List<GoalType>> extractRelatedGoals (SecReqSpeType srs){
		Map<String, List<GoalType>> goalMap = new HashMap<String, List<GoalType>>();
		
		List<GoalType> allGoalList = extractGoalList(srs);
		for (GoalType goalType : allGoalList) {
			if(goalMap.containsKey(goalType.getValue())){
				List<GoalType> goals = goalMap.get(goalType.getValue());
				goals.add(goalType);
			}
			else{
				List<GoalType> goals = new ArrayList<GoalType>();
				goals.add(goalType);
				goalMap.put(goalType.getValue(), goals);
			}
		}
		
		return goalMap;		
	}
	
	
	/**
	 * Extracts a list from a SRS SecReqSpe parent element containing all the document elements made tangible by information authorized for a given goal in a precondition.
	 * @param srs The SRS SecReqSpe parent element.
	 * @param goal The goal element.
	 * @return A list with the documents.
	 */
	public ArrayList<DocType> getAuthDocuments(SecReqSpeType srs, String goalId) {
		ArrayList<DocType> docList = new ArrayList<DocType>();
		Map<InfoType, ArrayList<DocType>> docMap = getAuthorizationDocuments(srs, goalId);		
		Iterator<InfoType> iterator = docMap.keySet().iterator();
		while (iterator.hasNext()) {
			InfoType infoType = (InfoType) iterator.next();
			ArrayList<DocType> docs = docMap.get(infoType);
			for (DocType docType : docs) {
				// Add the document element to the list if it has not been added yet
				if(!docList.contains(docType)){
					docList.add(docType);
				}
			}
		}		
		
		return docList;
	}
	
	/**
	 * Extracts a list from a SRS SecReqSpe parent element containing all the document elements that make tangible information authorized for a given goal in a precondition.
	 * @param srs The SRS SecReqSpe parent element.
	 * @param goalId The ID of the goal.
	 * @return A list with the documents.
	 */
	public Map<InfoType, ArrayList<DocType>> getAuthorizationDocuments(SecReqSpeType srs, String goalId) {
		Map<InfoType, ArrayList<DocType>> docMap = new HashMap<InfoType, ArrayList<DocType>>();		
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getAuthorization() != null 
					&& commitmentType.getPrecondition().getAuthorization().getScopeSet() != null){
				GoalSetType goalSetType = commitmentType.getPrecondition().getAuthorization().getScopeSet();
				EList<GoalType> goals = goalSetType.getGoal();				
				GoalType goalFound = null;
				for (GoalType goalType : goals) {
					if(goalType.getId().equals(goalId)){
						goalFound = goalType;
						break;
					}
				}
				if(goalFound != null){
					InfoSetType infoSetType = commitmentType.getPrecondition().getAuthorization().getInfoSet();
					EList<InfoType> infos = infoSetType.getInformation();
					for (InfoType infoType : infos) {
						if(!docMap.keySet().contains(infoType)){
							ArrayList<DocType> docSubList = getTangibleDocuments(srs, infoType);
							docMap.put(infoType, docSubList);
						}
					}
				}
			}
		}
		return docMap;
		
	}
	
	public void extractAuthorization (SecReqSpeType srs, String docId){
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getAuthorization() != null){
				
			}
					
		}
	}
	
	/**
	 * Extracts a list from a SRS SecReqSpe parent element containing all the actor elements (source or destination) involved in delegation preconditions.
	 * @param srs The SRS SecReqSpe parent element.
	 * @param goalId The ID of the goal.
	 * @return A list with the actors.
	 */
	public List<ActorType> getDelActorsById (SecReqSpeType srs, String goalId) {
		List<ActorType> actorList = new ArrayList<ActorType>();
//		List<DelType> delTypes = new ArrayList<DelType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		// find all delegation involved in commitments that contains the goal
		for (CommitmentType commitmentType : commitments) {
			if((commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getDelegation() != null)
					|| (commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getDelegation() != null)){
				DelType delType = null;
				if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getDelegation() != null){
					delType = commitmentType.getPrecondition().getDelegation();
				}
				else if (commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getDelegation() != null){
					delType = commitmentType.getPostcondition().getDelegation();
				}
				GoalSetType goalSetType = delType.getGoalSet();
				EList<GoalType> goals = goalSetType.getGoal();				
				GoalType goalFound = null;
				for (GoalType goalType : goals) {
					if(goalType.getId().equals(goalId)){
						goalFound = goalType;
						break;
					}
				}
				if(goalFound != null){
					ActorType actorType = delType.getDestination();
					if(!actorList.contains(actorType)){
						actorList.add(actorType);
					}				
				}
			}
		}
		
		return actorList;
	}
	
	/**
	 * Extracts a list from a SRS SecReqSpe parent element containing all the actor elements (source or destination) involved in delegation preconditions.
	 * @param srs The SRS SecReqSpe parent element.
	 * @param goalName The name of the goal.
	 * @return A list with the actors.
	 */
	public List<ActorType> getDelActorsByName(SecReqSpeType srs, String goalName) {
		List<ActorType> actorList = new ArrayList<ActorType>();
		List<DelType> delTypes = new ArrayList<DelType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		// find all delegation involved in commitments that contains the goal
		for (CommitmentType commitmentType : commitments) {
			if((commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getDelegation() != null)
					|| (commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getDelegation() != null)){
				DelType delType = null;
				if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getDelegation() != null){
					delType = commitmentType.getPrecondition().getDelegation();
				}
				else if (commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getDelegation() != null){
					delType = commitmentType.getPostcondition().getDelegation();
				}
				GoalSetType goalSetType = delType.getGoalSet();
				EList<GoalType> goals = goalSetType.getGoal();				
				GoalType goalFound = null;
				for (GoalType goalType : goals) {
					if(goalType.getValue().equals(goalName)){
						goalFound = goalType;
						break;
					}
				}
				if(goalFound != null){
					delTypes.add(delType);					
				}
			}
		}
		
		// Identify delegation chain and the last destination actor to return
		List<ActorType> actorTypes = findActorinDelChain(delTypes);
		if(actorTypes != null){
			return actorTypes;
		}
		else{
			// else return all destination actors found
			for (DelType delType : delTypes) {
				ActorType actorType2 = delType.getDestination();
				if(!actorList.contains(actorType2)){
					actorList.add(actorType2);
				}
			}	
		}			
		
		return actorList;
	}
	
	// TODO
	private List<ActorType> findActorinDelChain (List<DelType> delTypes){
		List<ActorType> lastDestinations = new ArrayList<ActorType>();
		List<String> actorIdsFound = new ArrayList<String>();
		
		for (DelType delType : delTypes) {
			DelType nextDelType = null;
			for (DelType delType2 : delTypes) {
				if(!delType2.equals(delType)){
					String destActorId= getActorId(delType.getDestination());
					String sourceActorId = getActorId(delType2.getSource());
					if(destActorId.equals(sourceActorId)){
						nextDelType = delType2;
						break;
					}
				}				
			}
			if(nextDelType == null){
				String destActorId = getActorId(delType.getDestination());
				if(!actorIdsFound.contains(destActorId)){
					lastDestinations.add(delType.getDestination());
					actorIdsFound.add(destActorId);
				}				
			}
		}
		
		return lastDestinations;
	}
	
	/**
	 * Extracts a list from a SRS SecReqSpe parent element containing all the documents that make tangible a given information.
	 * @param srs The SRS SecReqSpe parent element.
	 * @param info The information element.
	 * @return A list with the documents.
	 */
	public ArrayList<DocType> getTangibleDocuments(SecReqSpeType srs, InfoType info) {
		ArrayList<DocType> list = new ArrayList<DocType>();
		KBType kb = srs.getKnowledgeBase();
		EList<TangibleByType> tbList = kb.getTangibleBy();
		for (TangibleByType tb : tbList) {
			try {
				InfoType tmpType = tb.getInformation();
				if(tmpType.getId().equals(info.getId())) {
					DocType doc = tb.getDocument();
					boolean found = false;
					for(DocType tmpDoc : list) {
						if(tmpDoc.getId().equals(doc.getId())) {
							found = true;
							break;
						}
					}
					if(!found) {
						list.add(doc);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * Gets an actors ID.
	 * @param actor The actor element.
	 * @return The actor's ID.
	 */
	public String getActorId(ActorType actor) {
		String id = null;
		if(actor.getRole() != null) {
			id = actor.getRole().getId();
		} else if(actor.getAgent() != null) {
			id = actor.getAgent().getId();
		}
		return id;
	}
	
	/**
	 * Gets an actors name.
	 * @param actor The actor element.
	 * @return The actor's name.
	 */
	public String getActorValue(ActorType actor) {
		String name = null;
		if(actor.getRole() != null) {
			name = actor.getRole().getValue();
		} else if(actor.getAgent() != null) {
			name = actor.getAgent().getValue();
		}
		return name;
	}
	
	/**
	 * 	Extracts a list of Trustworthiness commitments from a SRS SecReqSpe parent element
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list of trustworthiness commitments
	 */
	public ArrayList<TrustworthinessType> extractCommitmentTrust (SecReqSpeType srs){
		ArrayList<TrustworthinessType> list = new ArrayList<TrustworthinessType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getTrustworthiness() != null){
				list.add(commitmentType.getPrecondition().getTrustworthiness());
			}
		}
		return list;
	}
	
	
	/**
	 * Extracts a trustworthiness commitment associated to a goal
	 * @param srs The SRS SecReqSpe parent element.
	 * @param goalId The ID of the goal.
	 * @return Trustworthiness commitment associated to the goal
	 */
	public TrustworthinessType extractCommitmentTrust (SecReqSpeType srs, String goalId){
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPrecondition() != null && commitmentType.getPrecondition().getTrustworthiness() != null){
				TrustworthinessType trustworthinessType = commitmentType.getPrecondition().getTrustworthiness();
				if(trustworthinessType.getGoal().getId().equals(goalId)){
					return trustworthinessType;
				}
			}
		}
		return null;
	}
	
	/**
	 * Extracts a list of Integrity commitments from a SRS SecReqSpe parent element
	 * @param srs The SRS SecReqSpe parent element.
	 * @return A list of Integrity commitments
	 */
	public ArrayList<CommitmentType> extractCommitmentIntegrity (SecReqSpeType srs){
		ArrayList<CommitmentType> list = new ArrayList<CommitmentType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getIntegrity() != null){
				list.add(commitmentType);
			}
		}
		return list;
	}
	
	/**
	 * Extracts a list of Integrity commitments associated to a Document from a SRS SecReqSpe parent element 
	 * @param srs The SRS SecReqSpe parent element.
	 * @param docId The ID of the Document
	 * @return A list of Integrity commitments
	 */
	public ArrayList<CommitmentType> extractCommitmentIntegrityByDoc (SecReqSpeType srs, String docId){
		ArrayList<CommitmentType> list = new ArrayList<CommitmentType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getIntegrity() != null){
				IntegrityType integrityType = commitmentType.getPostcondition().getIntegrity();
				// Get provision related to the document involved in Integrity commitment (supposing never is empty when integrity commitment exits)
				ProvType provType =  commitmentType.getPrecondition().getProvision();
				if(integrityType.getDocument().getId().equals(provType.getDocument().getId())){
					DocType docType = integrityType.getDocument();
					if(docType.getId().equals(docId)){
						list.add(commitmentType);
					}
				}
			}
		}
		
		return list;
	}
	
	public ArrayList<CommitmentType> extractCommitmentConfidentialityByDoc (SecReqSpeType srs, String docId){
		ArrayList<CommitmentType> list = new ArrayList<CommitmentType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPostcondition() != null && commitmentType.getPostcondition().getConfidentiality() != null){
				ConfidentialityType ct = commitmentType.getPostcondition().getConfidentiality();
				// Get provision related to the document involved in Confidentiality commitment (supposing never is empty when confidentiality commitment exits)
				ProvType provType =  commitmentType.getPrecondition().getProvision();
				if(ct.getDocument().getId().equals(provType.getDocument().getId())){
					DocType docType = ct.getDocument();
					if(docType.getId().equals(docId)){
						list.add(commitmentType);
					}
				}
			}
		}
		
		return list;
	}

	public List<CommitmentType> extractSoDBoDByGoalName (SecReqSpeType srs){
		List<CommitmentType> list = new ArrayList<CommitmentType>();
		EList<CommitmentType> commitments = srs.getCommitment();
		for (CommitmentType commitmentType : commitments) {
			if(commitmentType.getPostcondition().getAchieveInCombination() != null){
				list.add(commitmentType);
			}
			else if(commitmentType.getPostcondition().getNotAchieveInCombination() != null){
				list.add(commitmentType);
			}
		}
		
		return list;
	}
		
}
 
