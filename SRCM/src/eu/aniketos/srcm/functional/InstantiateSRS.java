/*
* InstantiateSRS.java
*
* This file is part of the SRCM module.
* Copyright (c) 2012-2013 "University of Trento - DISI" All rights reserved.
*
* Is strictly forbidden to remove this copyright notice from this source code.
*
* Disclaimer of Warranty:
* SRCM (this software) is provided "as-is" and without warranty of any kind, 
* express, implied or otherwise, including without limitation, any warranty of 
* merchantability or fitness for a particular purpose.
* In no event shall the copyright holder or contributors be liable for any direct,
* indirect, incidental, special, exemplary, or consequential damages
* including, but not limited to, procurement of substitute goods or services;
* loss of use, data, or profits; or business interruption) however caused and on
* any theory of liability, whether in contract, strict liability, or tort (including
* negligence or otherwise) arising in any way out of the use of this software, even 
* if advised of the possibility of such damage.
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License version 3
* as published by the Free Software Foundation with the addition of the
* following permission added to Section 15 as permitted in Section 7(a):
* FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY 
* "University of Trento - DISI","University of Trento - DISI" DISCLAIMS THE
* WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
*
* See the GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program; if not, see http://www.gnu.org/licenses or write to
* the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA, 02110-1301 USA.
*
* For more information, please contact Mattia Salnitri group at this
* address: mattia.salnitri@unitn.it
*
*/
package eu.aniketos.srcm.functional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.SecureBPMN.Participant;
import eu.aniketos.SecureBPMN.Variable;
import eu.aniketos.srcm.SRS.Actor;
import eu.aniketos.srcm.SRS.Agent;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.FullyAuthorized;
import eu.aniketos.srcm.SRS.Goal;
import eu.aniketos.srcm.SRS.Information;
import eu.aniketos.srcm.SRS.NonDisclosure;
import eu.aniketos.srcm.SRS.NonModification;
import eu.aniketos.srcm.SRS.NonProduction;
import eu.aniketos.srcm.SRS.NonRepudiation;
import eu.aniketos.srcm.SRS.NonUsage;
import eu.aniketos.srcm.SRS.Owns;
import eu.aniketos.srcm.SRS.Role;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.SRS.TangibleBy;
import eu.aniketos.srcm.SRS.Trustworthiness;
import eu.aniketos.srcm.mapping.IsA;
import eu.aniketos.srcm.mapping.Mapping;
import eu.aniketos.srcm.mapping.Plays;
import eu.aniketos.srcm.mapping.Represents;

/**This class manages the SRS instantiation
 * @author Mattia Salnitri
 *
 */
public class InstantiateSRS 
{
	//instantiate the srs, it modify directly the SRS
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void instantiateSRS(SRS srs, Mapping mapping, EABPM bpm, HashSet<Commitment> undecCommitmentList) throws Exception
	{
		//retrieve the list of object that have to be instantiated
		//i clone them couse i will modify the srs lists during the inspection of the local list copies
		HashMap<String, Role> roleList = (HashMap<String, Role>) srs.getRoleList().clone();
		HashMap<String, Agent> agentList = (HashMap<String, Agent>) srs.getAgentList().clone();
		HashMap<String, Goal> goalList = (HashMap<String, Goal>) srs.getGoalList().clone();
		HashMap<String, Information> informationList = (HashMap<String, Information>) srs.getInformationList().clone();
		HashMap<String, eu.aniketos.srcm.SRS.Document> documentList = (HashMap<String, eu.aniketos.srcm.SRS.Document>) srs.getDocumentList().clone();
		
		Vector<Commitment> commList = (Vector<Commitment>) srs.getCommitmentList().clone();
		
		//attention: all list are cloned 
		
		/*
		 * ATTENTION:
		 * in commitment
		 * debtor: is the responsible of the commitment, i.e. who must change the world to sat the post condition of the commitment, if the precondition are true
		 * creditor: is the requester of the commitment
		 */
		
		
		//get rid of all debtors
		Iterator<Commitment> i = commList.iterator();
		//for all commitments
		while(i.hasNext())
		{
			Commitment commitment = i.next();
			
			//instantiate deb
			HashSet<Participant> partSet = new HashSet<Participant>();
			
			Actor deb = commitment.getDebtor();
			
			//if it's a role i have to search also in the plays relations
			if (commitment.getDebtor().getClass()==Role.class)
			{
				Vector<Plays> playsList = mapping.getPlaysList();
				Iterator<Plays> playsIT = playsList.iterator();
				while (playsIT.hasNext())
				{
					Plays plays = playsIT.next();
					if (plays.getActor().getId()==deb.getId())
						partSet.add(plays.getParticipant());
					
				}
			}
			
			Vector<IsA> isaList = mapping.getIsaList();
			Iterator<IsA> isaIT = isaList.iterator();
			while(isaIT.hasNext())
			{
				IsA isa = isaIT.next();
				if(isa.getActor().getId()==deb.getId())
					partSet.add(isa.getParticipant());
			}
			
			
			//special case for those commitments where debtor and creditor are the same actor
			if (commitment.getPostCondition().getClass()== Trustworthiness.class)
			{
				if (partSet.size()==0)
				{
					//it means there is no mapping, so in the BP there are no such elements, simply delete the commitment
					//and put in the undecidable
					undecCommitmentList.add(commitment);
					srs.getCommitmentList().remove(commitment);
				}
				else if (partSet.size()==1)
				{
					//setup the instantiated commitment
					commitment.setDebtor(partSet.iterator().next());
					commitment.setCreditor(commitment.getDebtor());//same creditor/debtor
				}
				else //more than one debtor
				{
					Iterator<Participant> debIT=partSet.iterator();
					//i use the first debtor simply substituting the already existing commitment 
					commitment.setDebtor(debIT.next());
					commitment.setCreditor(commitment.getDebtor());
					
					//for all the other debtors i duplicate the commitment
					//attention : i duplicate only the commitment object, not all the other objects referenced
					while (debIT.hasNext())
					{
						Commitment newCommitment = new Commitment();
						
						//set the other parameters as the old one
						newCommitment.setPrecondition(commitment.getPrecondition());
						newCommitment.setPostCondition(commitment.getPostCondition());
						newCommitment.setId(commitment.getId());
						//set the new debtor and creditor
						newCommitment.setDebtor(debIT.next());
						newCommitment.setCreditor(newCommitment.getDebtor());
						
						//add the new commtments
						srs.getCommitmentList().add(newCommitment);
						
					}
				}

			}
			//end of special case
			else
			{
				//commented because it doesn't matter if the creditor is not instantiated, in other words is not present in the service composition
				//if the set is composed by only one elements, i simply substituting, else i have to create new commitments
				if (partSet.size()==0)
				{
					//it means there is no mapping, so in the BP there are no such elements,
					
					//the responsible, i.e. the debtor must be istantiatedm, otherwise it means there is no mapped responsible in the bp,
					//i.e. there is no participant who is in charge of sat the commitment
					undecCommitmentList.add(commitment);
					srs.getCommitmentList().remove(commitment);
					
					//just set the creditor to null
					//commitment.setDebtor(null);
				}
				else if (partSet.size()==1)
				{
					//setup the instantiated commitment
					commitment.setDebtor(partSet.iterator().next());
				}
				else //more than one debtor
				{
					Iterator<Participant> debIT=partSet.iterator();
					//i use the first debtor simply substituting the already existing commitment 
					commitment.setDebtor(debIT.next());
					
					//for all the other debtors i duplicate the commitment
					//attention : i duplicate only the commitment object, not all the other objects referenced
					while (debIT.hasNext())
					{
						Commitment newCommiment = new Commitment();
						
						//set the other parameters as the old one
						newCommiment.setCreditor(commitment.getCreditor());
						newCommiment.setPrecondition(commitment.getPrecondition());
						newCommiment.setPostCondition(commitment.getPostCondition());
						newCommiment.setId(commitment.getId());
						//set the new debtor
						newCommiment.setDebtor(debIT.next());
						
						//add the new commitments
						srs.getCommitmentList().add(newCommiment);
						
					}
				}
			}
		}
		
		//once i instantiated all the debtor, i instantiate all the creditors
		//since i have modified the commitment list during the first operations, i need to update the internal commitment list
		commList = (Vector<Commitment>) srs.getCommitmentList().clone();
		i = commList.iterator();
		//for all commitments
		while(i.hasNext())
		{
			Commitment commitment = i.next();

			if (! (commitment.getPostCondition().getClass() == Trustworthiness.class))
			{
				//instantiate creditor
				//clear old stuff
				HashSet<Participant> partSet = new HashSet<Participant>();
				
				Actor cred = commitment.getCreditor();
				
				//if it's a role i have to search also in the plays relations
				if (commitment.getCreditor().getClass()==Role.class)
				{
					Vector<Plays> playsList = mapping.getPlaysList();
					Iterator<Plays> playsIT = playsList.iterator();
					while (playsIT.hasNext())
					{
						Plays plays = playsIT.next();
						if (plays.getActor().getId()==cred.getId())
							partSet.add(plays.getParticipant());
						
					}
				}
				
				
				Vector<IsA> isaList = mapping.getIsaList();
				Iterator<IsA> isaIT = isaList.iterator();
				while(isaIT.hasNext())
				{
					IsA isa = isaIT.next();
					if(isa.getActor().getId()==cred.getId())
						partSet.add(isa.getParticipant());
				}
				
				
				
				if (partSet.size()==0)
				{
					//it means there is no mapping of creditor, so in the BP there are no such elements, simply delete the commitment
					//and put in the undecidable

					//add the commitment to undec list only if is not in the list already
					//if (!searchCommitment(commitment, undecCommitmentList))
					//	undecCommitmentList.add(commitment);
					//srs.getCommitmentList().remove(commitment);
					
					commitment.setCreditor(null);
				}
				//if the set is composed by only one elements, i simply substituting, else i have to create new commitments
				else if (partSet.size()==1)
				{
					//setup the instantiated commitment
					commitment.setCreditor(partSet.iterator().next());
				}
				else if (partSet.size()>=1)//more than one creditor
				{
					Iterator<Participant> debIT=partSet.iterator();
					//i use the first creditor simply substituting the already existing commitment 
					commitment.setCreditor(debIT.next());
					
					//for all the other creditor i duplicate the commitment
					//attention : i duplicate only the commitment object, not all the other objects referenced
					while (debIT.hasNext())
					{
						Commitment newCommitment = new Commitment();
						
						//set the other parameters as the old one
						newCommitment.setDebtor(commitment.getDebtor());
						newCommitment.setPrecondition(commitment.getPrecondition());
						newCommitment.setPostCondition(commitment.getPostCondition());
						newCommitment.setId(commitment.getId());
						//set the new creditor
						newCommitment.setCreditor(debIT.next());
						
						//add the new commitments
						srs.getCommitmentList().add(newCommitment);
						
					}
				}
			}
		}
		
		//once i instantiated all the creditor and all the debtors, i examine the post condition part
		//since i have modified the commitment list during the first operations, i need to update the internal commitment list
		//with this workaround i can update the original list of commitment while i'm iterating o the cloned one.
		commList = (Vector<Commitment>) srs.getCommitmentList().clone();
		
		
		i = commList.iterator();
		//for all commitments
		while(i.hasNext())
		{
			Commitment commitment = i.next();
			
			//check the type of commitment and perform the respective instantiation
			//pay attention to avoid to update the list because are only clones, if you want to update permanently the srs, do it through its object
			if (commitment.getPostCondition().getClass()==NonRepudiation.class)
			{
				//non repudiation
				NRInst.instantiateCommitment(commitment, mapping, srs, undecCommitmentList);
			}
			else if (commitment.getPostCondition().getClass()==NonDisclosure.class || 
					commitment.getPostCondition().getClass()==NonModification.class ||
					commitment.getPostCondition().getClass()==NonUsage.class ||
					commitment.getPostCondition().getClass()==NonProduction.class)
			{ 				
				OperationInst.instatiateCommitment(commitment, srs, mapping, undecCommitmentList);
			}
			else if (commitment.getPostCondition().getClass()==Trustworthiness.class)
			{
				TWInst.instantiateCommitment(commitment, mapping, srs, undecCommitmentList);
			}
			
		}
		
		
		//instantiate the kb
		//owners
		Vector<Owns> ownsList = srs.getKnowledgeBase().getOwnsList();
		Vector<Owns> newOwnsList = new Vector<Owns>();
		Iterator<Owns> ownsListIT = ownsList.iterator();
		while (ownsListIT.hasNext())
		{
			Owns owns = ownsListIT.next();
			
			//maps the actors
			HashSet<Participant> partSet = new HashSet<Participant>();
			
			//if it's a role i have to search also in the plays relations
			if (owns.getOwner().getClass()==Role.class)
			{
				Vector<Plays> playsList = mapping.getPlaysList();
				Iterator<Plays> playsIT = playsList.iterator();
				while (playsIT.hasNext())
				{
					Plays plays = playsIT.next();
					if (plays.getActor().getId()==owns.getOwner().getId())
						partSet.add(plays.getParticipant());
					
				}
			}
			
			Vector<IsA> isaList = mapping.getIsaList();
			Iterator<IsA> isaIT = isaList.iterator();
			while(isaIT.hasNext())
			{
				IsA isa = isaIT.next();
				if(isa.getActor().getId()==owns.getOwner().getId())
					partSet.add(isa.getParticipant());
			}
			
			//maps the documents
			HashSet<eu.aniketos.srcm.SRS.Document> DocuSet = new HashSet<eu.aniketos.srcm.SRS.Document>();
			
			Information info = owns.getInformation();
			
			//for all the document related to these info
			Vector<TangibleBy> tangibleByList = srs.getKnowledgeBase().getTangibleByList();
			Iterator<TangibleBy> tanByIT = tangibleByList.iterator();
			
			while (tanByIT.hasNext())
			{
				TangibleBy tangibleBy = tanByIT.next(); 
				if (tangibleBy.getInformation()==info)
					{
						DocuSet.add(tangibleBy.getDocument());
					}
			}
			
			//set of variable associated at the set of document that made tangible the information of the non-disclosure
			Vector<Variable> varList= new Vector<Variable>();
			
			//once the possible documents set are filled, i search all the mapping in the mapping data structure
			Iterator<eu.aniketos.srcm.SRS.Document> docuIT = DocuSet.iterator();
			while (docuIT.hasNext())
			{
				eu.aniketos.srcm.SRS.Document doc= docuIT.next();
				
				Vector<Represents> representsList = mapping.getRepresentsList();
				Iterator<Represents> reprIT = representsList.iterator();
				while(reprIT.hasNext())
				{
					Represents represents = reprIT.next();
					if (represents.getDocument()==doc)
						varList.add(represents.getVariable());
				}
			}
			
			//at this point i have all the variable and all the owners of that variables
			//i create the new owner relations
			Iterator<Participant> partSetIT = partSet.iterator();
			while (partSetIT.hasNext())
			{
				Participant owner = partSetIT.next();
				@SuppressWarnings("rawtypes")
				Iterator varListIT = varList.iterator();
				while (varListIT.hasNext())
				{
					Owns ownsRel = new Owns();
					ownsRel.setOwner(owner);
					ownsRel.setInformation((Variable)varListIT.next());
					newOwnsList.add(ownsRel);
				}
			}
		}
		
		//set the new list
		srs.getKnowledgeBase().setOwnsList(newOwnsList);
		
		
		//fully authorize relation instantiation
		Vector<FullyAuthorized> faList = srs.getKnowledgeBase().getFullyAuthorizedList();
		Vector<FullyAuthorized> newfaList = new Vector<FullyAuthorized>();
		Iterator<FullyAuthorized> faListIT = faList.iterator();
		while (faListIT.hasNext())
		{
			FullyAuthorized fa = faListIT.next();
			
			//maps the actors
			HashSet<Participant> partSet = new HashSet<Participant>();
			
			//if it's a role i have to search also in the plays relations
			if (fa.getOwner().getClass()==Role.class)
			{
				Vector<Plays> playsList = mapping.getPlaysList();
				Iterator<Plays> playsIT = playsList.iterator();
				while (playsIT.hasNext())
				{
					Plays plays = playsIT.next();
					if (plays.getActor().getId()==fa.getOwner().getId())
						partSet.add(plays.getParticipant());
					
				}
			}
			
			Vector<IsA> isaList = mapping.getIsaList();
			Iterator<IsA> isaIT = isaList.iterator();
			while(isaIT.hasNext())
			{
				IsA isa = isaIT.next();
				if(isa.getActor().getId()==fa.getOwner().getId())
					partSet.add(isa.getParticipant());
			}
			
			//maps the documents
			HashSet<eu.aniketos.srcm.SRS.Document> DocuSet = new HashSet<eu.aniketos.srcm.SRS.Document>();
			
			Information info = fa.getInformation();
			
			//for all the document related to these info
			Vector<TangibleBy> tangibleByList = srs.getKnowledgeBase().getTangibleByList();
			Iterator<TangibleBy> tanByIT = tangibleByList.iterator();
			
			while (tanByIT.hasNext())
			{
				TangibleBy tangibleBy = tanByIT.next(); 
				if (tangibleBy.getInformation()==info)
					{
						DocuSet.add(tangibleBy.getDocument());
					}
			}
			
			//set of variable associated at the set of document that made tangible the information of the non-disclosure
			Vector<Variable> varList= new Vector<Variable>();
			
			//once the possible documents set are filled, i search all the mapping in the mapping data structure
			Iterator<eu.aniketos.srcm.SRS.Document> docuIT = DocuSet.iterator();
			while (docuIT.hasNext())
			{
				eu.aniketos.srcm.SRS.Document doc= docuIT.next();
				
				Vector<Represents> representsList = mapping.getRepresentsList();
				Iterator<Represents> reprIT = representsList.iterator();
				while(reprIT.hasNext())
				{
					Represents represents = reprIT.next();
					if (represents.getDocument()==doc)
						varList.add(represents.getVariable());
				}
			}
			
			//at this point i have all the variable and all the owners of that variables
			//i create the new fully auth relations
			Iterator<Participant> partSetIT = partSet.iterator();
			while (partSetIT.hasNext())
			{
				Participant fullyAuthorized = partSetIT.next();
				Iterator varListIT = varList.iterator();
				while (varListIT.hasNext())
				{
					FullyAuthorized faRel = new FullyAuthorized();
					faRel.setOwner(fullyAuthorized);
					faRel.setInformation((Variable)varListIT.next());
					newfaList.add(faRel);
				}
			}
		}
		
		//set the new list
		srs.getKnowledgeBase().setFullyAuthorizedList(newfaList);
	}

	//it return true if the commitment is contained in the list of commitment
	private Boolean searchCommitment (Commitment commitment, HashSet<Commitment> commitmentList)
	{
		Iterator<Commitment> commListIT = commitmentList.iterator();
		while (commListIT.hasNext())
		{
			Commitment commExtracted= commListIT.next();
			if (commitment.getId().compareTo(commExtracted.getId())==0)
				return true;
		}
		
		return false;
	}
	
}
