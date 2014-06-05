/*
* AuthCheck.java
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
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.SecureBPMN.Element;
import eu.aniketos.SecureBPMN.Participant;
import eu.aniketos.SecureBPMN.Variable;
import eu.aniketos.activiti.Activiti;
import eu.aniketos.activiti.ActivitiNeedToKnow;
import eu.aniketos.activiti.ActivitiRole;
import eu.aniketos.activiti.ActivitiNeedToKnow.Permission;
import eu.aniketos.srcm.SRS.Actor;
import eu.aniketos.srcm.SRS.Authorization;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.Document;
import eu.aniketos.srcm.SRS.FullyAuthorized;
import eu.aniketos.srcm.SRS.Information;
import eu.aniketos.srcm.SRS.NonDisclosure;
import eu.aniketos.srcm.SRS.NonModification;
import eu.aniketos.srcm.SRS.NonProduction;
import eu.aniketos.srcm.SRS.NonRepudiation;
import eu.aniketos.srcm.SRS.NonUsage;
import eu.aniketos.srcm.SRS.Owns;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.SRS.TangibleBy;
import eu.aniketos.srcm.mapping.IsA;
import eu.aniketos.srcm.mapping.Mapping;
import eu.aniketos.srcm.mapping.Plays;
import eu.aniketos.srcm.mapping.Represents;

/**This class manages authorization algorithms and the authorization table
 * @author Mattia Salnitri
 *
 */
//TODO cambiare nome classe!
public class AuthCheck 
{
	/**
	 * @param srs
	 * @param undecCommitmentList
	 * @param operations
	 */
	public static void createAuthTable(SRS srs, HashSet<Commitment> undecCommitmentList, Vector<ActorVarOperation> operations)
	{
		//create the operations lists from the commitments ( understand, from commitments, what is allowed)
		Vector<Commitment> commList = srs.getCommitmentList();
		Iterator<Commitment> i = commList.iterator();
		while(i.hasNext())
		{
			Commitment commitment = i.next();
			//check the type of commitment and set up the authorization table
			if (commitment.getPostCondition().getClass()==NonDisclosure.class)
			{
				//non disclosure
				NonDisclosure nonDisclosure = (NonDisclosure) commitment.getPostCondition();
				
				//this is a vector of variables (that extend information)
				Iterator<Information> varIT =nonDisclosure.getInformationList().iterator();
				while (varIT.hasNext())
				{
					Variable variable = (Variable) varIT.next();
					Participant target =(Participant) commitment.getDebtor();//debtor have to be instantiated so cannot be null
					ActorVarOperation operAuth = searchAuthorizationTable(operations, variable, target);
					if (operAuth==null)
					{
						operAuth = new ActorVarOperation(variable, target);
						operations.add(operAuth);
					}
					//remove what it is not permitted by that commitment
					operAuth.removeDistribute();
				}
				
			}
			else if (commitment.getPostCondition().getClass()==NonModification.class)
			{
				//non modification
				NonModification nonModification = (NonModification) commitment.getPostCondition();
				
				//this is a vector of variables (that extend information)
				Iterator<Information> varIT =nonModification.getInformationList().iterator();
				while (varIT.hasNext())
				{
					Variable variable = (Variable) varIT.next();
					Participant target =(Participant) commitment.getDebtor();//debtor have to be instantiated so cannot be null
					ActorVarOperation operAuth = searchAuthorizationTable(operations, variable, target);
					if (operAuth==null)
					{
						operAuth = new ActorVarOperation(variable, target);
						operations.add(operAuth);
					}
					//remove what it is not permitted by that commitment
					operAuth.removeModify();
				}
				
			}
			else if (commitment.getPostCondition().getClass()==NonUsage.class)
			{
				//non Usage
				NonUsage nonUsage = (NonUsage) commitment.getPostCondition();
				
				//this is a vector of variables (that extend information)
				Iterator<Information> varIT =nonUsage.getInformationList().iterator();
				while (varIT.hasNext())
				{
					Variable variable = (Variable) varIT.next();
					Participant target =(Participant) commitment.getDebtor();//debtor have to be instantiated so cannot be null
					ActorVarOperation operAuth = searchAuthorizationTable(operations, variable, target);
					if (operAuth==null)
					{
						operAuth = new ActorVarOperation(variable, target);								
						operations.add(operAuth);
					}
					//remove what it is not permitted by that commitment
					operAuth.removeUse();
				}
				
			}
			else if (commitment.getPostCondition().getClass()==NonProduction.class)
			{
				//non Production
				NonProduction nonProduction = (NonProduction) commitment.getPostCondition();
				
				//this is a vector of variables (that extend information)
				Iterator<Information> varIT =nonProduction.getInformationList().iterator();
				while (varIT.hasNext())
				{
					Variable variable = (Variable) varIT.next();
					Participant target =(Participant) commitment.getDebtor();//debtor have to be instantiated so cannot be null
					ActorVarOperation operAuth = searchAuthorizationTable(operations, variable, target);
					if (operAuth==null)
					{
						operAuth = new ActorVarOperation(variable, target);
						operations.add(operAuth);
					}
					//remove what it is not permitted by that commitment
					operAuth.removeProduce();
				}
				
			}
		}
		
		//add to the list the owners
		Vector<Owns> ownsList = srs.getKnowledgeBase().getOwnsList();
		Iterator<Owns> ownsListIT = ownsList.iterator();
		while (ownsListIT.hasNext())
		{
			Owns ownsRel = ownsListIT.next();
			//i skip if the owner is null ( no owner in the BP)
			if (ownsRel.getOwner()==null)
				continue;
			
			ActorVarOperation operAuth = searchAuthorizationTable(operations, (Variable) ownsRel.getInformation(), (Participant) ownsRel.getOwner());
			if (operAuth==null)
			{
				//it should be null, because the owner shouldn't commit to other the restrictions to it's variables 
				operAuth = new ActorVarOperation((Variable) ownsRel.getInformation(), (Participant) ownsRel.getOwner());
				operations.add(operAuth);
			}
		}
		
		//add to the list the fully authorized actors
		Vector<FullyAuthorized> faList = srs.getKnowledgeBase().getFullyAuthorizedList();
		Iterator<FullyAuthorized> faListIT = faList.iterator();
		while (faListIT.hasNext())
		{
			FullyAuthorized faRel = faListIT.next();
			
			//i skip if the fully authorized bp is null ( no fa in the BP)
			if (faRel.getOwner()==null)
				continue;
			
			ActorVarOperation operAuth = searchAuthorizationTable(operations, (Variable) faRel.getInformation(), (Participant) faRel.getOwner());
			if (operAuth==null)
			{
				//it should be null, because the owner shouldn't commit to other the restrictions to it's variables 
				operAuth = new ActorVarOperation((Variable) faRel.getInformation(), (Participant) faRel.getOwner());
				operations.add(operAuth);
			}
		}
				
	}

	/** this function check the authorization table against the BP examined
	 * @param bpm the BP to examine
	 * @param srs the list of security commitments
	 * @param operations authorization table
	 * @param undecCommitmentList list of undecidable commitments
	 * @param satCommitmentList list of unsat commitments
	 * @param unSatCommitmentList list of sat commitments
	 */
	static void checkAuthorizationTable(EABPM bpm, SRS srs, Vector<ActorVarOperation> operations, HashSet<Commitment> undecCommitmentList, HashSet<Commitment> satCommitmentList,	HashSet<Commitment> unSatCommitmentList, Mapping mapping, Activiti activiti)
	{
		//first check: check if the ntk information stored in .activity file are coherent with the authorization table
		HashMap<String, ActivitiNeedToKnow> ntk = activiti.getPermissions();
		
	    Iterator <Entry<String, ActivitiNeedToKnow>> it = ntk.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	        Map.Entry <String, ActivitiNeedToKnow> pairs = (Entry<String, ActivitiNeedToKnow>)it.next();
	        ActivitiNeedToKnow activitiNeedToKnow = pairs.getValue();
	        
	        //for every ntk, check if the authorization table is in conflict
	        Variable var = new Variable();
	        var.setId(activitiNeedToKnow.getVariable());
	        var.setName(activitiNeedToKnow.getVariable());
	        
	        //for the participant i have to search the activity to which the ntk refers
	        String activityID = activitiNeedToKnow.getTaskID();
	        Activity activity = searchAct(bpm, activityID);
	        
	        Participant part = activity.getOwner();
	        
	        //search the authorization for the given variable and the given participant
	        ActorVarOperation operation = searchAuthorizationTable(operations,var,part);
	        
	        //if there is an authorization, check if operation specified in the ntk are a subset of the operations allowed by the authorization
	        //if it is not the case, retrieve the commitment and put it in the violated list.
	        /* mapping between read/write operations and use/production/modify/distribute operations
	         * Read -> allows you to use and distribute the variable:  {use, distribute}
			 * Write ->  allows you to produce a fresh value: {produce}
			 * Read & write -> allows you to modify a variable: {modify}
	         */
	        if (operation!=null)
	        {
	        	if (activitiNeedToKnow.getPermission()==Permission.READ)
	        	{
	        		/*if (!operation.getOperations().contains(Authorization.Operation.USE) || why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        				!operation.getOperations().contains(Authorization.Operation.DISTRIBUTE)	) why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        		{*/
	        			
	        			//if (!operation.getOperations().contains(Authorization.Operation.USE)) why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        			//{
							Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.USE, operation.getVarible(), operation.getTarget(), srs);
							if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
								unSatCommitmentList.add(violatedComm);
							
//System.err.println("ntk check: commitment "+violatedComm.getId()+" violated by USAGE of variable " + var.getId() + ", by participant " + part.getId());
	        			//}
						
	        			//if (!operation.getOperations().contains(Authorization.Operation.DISTRIBUTE)) why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        			//{
							violatedComm = searchViolatedAuthCommitment(Authorization.Operation.DISTRIBUTE, operation.getVarible(), operation.getTarget(), srs);
							if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
								unSatCommitmentList.add(violatedComm);
							
//System.err.println("ntk check: commitment "+violatedComm.getId()+" violated by DISTRIBUTION of variable " + var.getId() + ", by participant " + part.getId());
	        			//}
	        		//}
	        	}
	        	else if (activitiNeedToKnow.getPermission()==Permission.WRITE)//produce
	        	{
	        		
	        		//if (!operation.getOperations().contains(Authorization.Operation.PRODUCE)) why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        		//{
						Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.PRODUCE, operation.getVarible(), operation.getTarget(), srs);
						if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
							unSatCommitmentList.add(violatedComm);
						
//System.err.println("ntk check: commitment "+violatedComm.getId()+" violated by USAGE of variable " + var.getId() + ", by participant " + part.getId());
	        		//}
	        	}
	        	else if (activitiNeedToKnow.getPermission()==Permission.READ_WRITE)//modify
	        	{
	        		/*if (!//operation.getOperations().contains(Authorization.Operation.USE) ||
	        				//!operation.getOperations().contains(Authorization.Operation.DISTRIBUTE) ||
	        				//!operation.getOperations().contains(Authorization.Operation.PRODUCE) ||
	        				!operation.getOperations().contains(Authorization.Operation.MODIFY)  )
	        		{*/
						
	        			//if (!operation.getOperations().contains(Authorization.Operation.MODIFY)) why there has to be an operations performed? the ntk in activiti file specifies that operations!
	        			//{
							Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.MODIFY, operation.getVarible(), operation.getTarget(), srs);
							if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
								unSatCommitmentList.add(violatedComm);
	        			//}
	        		//}
	        	}
	        }
	        else
	        {
	        	System.out.println("WARNING: no authorization for for variable " + var.getId() + ", and " + part.getId() + "NTK check skipped");
	        }
	    }
		
				
		//second check: check if the SecureBPMN is compliant
		//retrieve the set of the operations
		Vector<Element> elemList = bpm.getElementsList();
		Iterator<Element> elemListIT = elemList.iterator();
		boolean violationAuthorizationCommitment = false;
		while (elemListIT.hasNext())
		{
			Element element = elemListIT.next();
			if (element.getClass()==Activity.class)	
			{
				Activity activity = (Activity) element;
				//retrieve the flow of variable
				
				//skip if it's an event or a gateway, etc
				if (!(activity.getType()==Activity.Type.SERVICE || activity.getType()==Activity.Type.USER))
					continue;
				
				Vector<ActorVarOperation> operationsPerf = new Vector<ActorVarOperation>();
				
				Vector<Variable> inVarList = activity.getInVariablesList();
				Iterator<Variable> inVarListIT = inVarList.iterator();

				//for each input variable of the activity create the table of the operation performed
				//all the variable-target should appear only once, because it is not  possible having two message with the same variable to the same activity 
				while (inVarListIT.hasNext())
				{
					Variable inVar = inVarListIT.next();
					
					ActorVarOperation operAuth = AuthCheck.searchAuthorizationTable(operationsPerf, inVar, activity.getOwner());
					if (operAuth==null)
					{
						//create a new entry in the table 
						operAuth = new ActorVarOperation(inVar, activity.getOwner());
						
						//only use if is in input
						operAuth.removeDistribute();
						operAuth.removeModify();
						operAuth.removeProduce();
	
						operationsPerf.add(operAuth);
					}
					
				}
				
				Vector<Variable> outVarList = activity.getOutVariablesList();
				Iterator<Variable> outVarListIT = outVarList.iterator();
				
				//for each output variable of the activity update the table of the operation performed
				while (outVarListIT.hasNext())
				{
					Variable outVar = outVarListIT.next();
					ActorVarOperation operAuth = AuthCheck.searchAuthorizationTable(operationsPerf, outVar, activity.getOwner());
					if (operAuth==null)//only output var
					{
						operAuth = new ActorVarOperation(outVar, activity.getOwner());
						//use,Production distribution if is in output
						operAuth.removeModify();
						operationsPerf.add(operAuth);
					}
					else//it already exists so is both in input and output
					{
						//added modify and distribution
						operAuth.addModify();
						operAuth.addDistribute();
					}
				}
				
				//at this point the table of the operation performed by the activity is created
				//i check if the table is a subset of the permissions,
				//otherwise it does not respect the commitments
				
				Iterator<ActorVarOperation> operationPerfIT = operationsPerf.iterator();
				while (operationPerfIT.hasNext())
				{
					ActorVarOperation operPerf = operationPerfIT.next();
					ActorVarOperation operAuth = AuthCheck.searchAuthorizationTable(operations, operPerf.getVarible(), activity.getOwner());
					if (operAuth==null)
					{
//System.out.println("WARNING: no entries in authorization table for variable: " + operPerf.getVarible().getName() + " and participant: " + activity.getOwner().getName() + ". No commitment violated!");
					}
					else
					{
						//check if the operations in the activity is a subset of the operation permitted for that var
						HashSet<Authorization.Operation> authPerfSet = operPerf.getOperations();//operation performed by the activity
						HashSet<Authorization.Operation> authSet = operAuth.getOperations();//authorization about variable-target
						if (authPerfSet.contains(Authorization.Operation.USE))
							if (!authSet.contains(Authorization.Operation.USE))
							{
								//error
//System.err.println("operation not permitted: variable "  + operAuth.getVarible().getName() + " cannot be used by " + operAuth.getTarget().getName());
								//retrieve the commitment
								Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.USE, operAuth.getVarible(), operAuth.getTarget(), srs);
								//put the commitment
								if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
									unSatCommitmentList.add(violatedComm);
								
							}
						
						if (authPerfSet.contains(Authorization.Operation.MODIFY))
							if (!authSet.contains(Authorization.Operation.MODIFY))
							{
								//error
//System.err.println("operation not permitted: variable "  + operAuth.getVarible().getName() + " cannot be modified by " + operAuth.getTarget().getName());
								//retrieve the commitment
								Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.MODIFY, operAuth.getVarible(), operAuth.getTarget(), srs);
								//put the commitment
								if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
									unSatCommitmentList.add(violatedComm);
							}
						
						if (authPerfSet.contains(Authorization.Operation.PRODUCE))
							if (!authSet.contains(Authorization.Operation.PRODUCE))
							{
								//error
//System.err.println("operation not permitted: variable "  + operAuth.getVarible().getName() + " cannot be produced by " + operAuth.getTarget().getName());
								//retrieve the commitment
								Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.PRODUCE, operAuth.getVarible(), operAuth.getTarget(), srs);
								//put the commitment
								if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
									unSatCommitmentList.add(violatedComm);
							}
						
						if (authPerfSet.contains(Authorization.Operation.DISTRIBUTE))
							if (!authSet.contains(Authorization.Operation.DISTRIBUTE))
							{
								
								//retrieve the commitment
								Commitment violatedComm = searchViolatedAuthCommitment(Authorization.Operation.DISTRIBUTE, operAuth.getVarible(), operAuth.getTarget(), srs);
								
								HashSet<Participant> receivers = searchReceivers(activity, operAuth.getVarible(), null, null);

//TODO: IMPORTANT THIS IS BASED ON THE ASSUMPTION THAT IN STS-ML IT IS NOT POSSIBLE THE MULKTIPLE OWNERSHIP
//A->I1->D->V1
//A->I2->D
//no matter what, one document must be linked to one actor
								//retrieve all the participant who is owner of the variable
								//( i.e. they own the information, made tangible by the document, represented by the variable)
								
								//this is already computed in the instantiation phase
								//now we have to retrieve the results in the owns list.
								HashSet <Participant> authPart = new HashSet<Participant>();
								//owner
								Vector<Owns> ownsList = srs.getKnowledgeBase().getOwnsList();
								Iterator<Owns> ownsListI = ownsList.iterator();
								while (ownsListI.hasNext())
								{
									Owns owns = ownsListI.next();
									if (owns.getInformation().getId().compareToIgnoreCase(operAuth.getVarible().getId())==0)
									{
										authPart.add((Participant)owns.getOwner());
									}
								}

								
								//retrieve all the participant linked to the actor owner of the information -> document-> variable 
								//if the receivers of the flow belong to the participants owner, the commitment is not violated
								
								//this variable is true if the set of actor retrieved from variable participant 
								//is a subset of the set of actors retrieved by the variable authorization
								Boolean authUsage = true;
								

								Iterator<Participant> receivesI = receivers.iterator();
								while (receivesI.hasNext())
								{
									Participant receiver = receivesI.next(); 
									if (!((receiver==violatedComm.getCreditor()) || authPart.contains(receiver)))
									{
										authUsage=false;
									}
									
/*									//retrieve all the actors linked to that participant
									Vector<IsA> isAList = mapping.getIsaList();
									Iterator<IsA> isAlistI = isAList.iterator();
									boolean misused=false;
									while( isAlistI.hasNext())
									{
										IsA isA = isAlistI.next();
										//as soon as a participant is not linked to the variable i set the misused var to true
										if (isA.getParticipant().getId().compareToIgnoreCase(receiver.getId())==0 && 
												!(isA.getActor())
											misused=true;
									}
									if (misused)// is a participant is not linked to the actor i set the violated var to false
										violated=false;
									
									Vector<Plays> playsList = mapping.getPlaysList();
									Iterator<Plays> playsListI = playsList.iterator();
									misused=false;
									while(playsListI.hasNext())
									{
										Plays plays = playsListI.next();
										//as soon as a participant is not linked to the variable i set the misused var to true
										if ((plays.getParticipant()!=null &&
												plays.getParticipant().getId().compareToIgnoreCase(receiver.getId())==0 &&
												(
														plays.getActor()==null
														||
														!(plays.getActor().getId().compareToIgnoreCase(authPart.getId())==0))
														
												)
												)
											misused=true;
									}
									if (misused)// is a participant is not linked to the actor i set the violated var to false
										violated=false;*/
								}
								
								if (!authUsage)
								{
//System.err.println("operation not permitted: variable "  + operAuth.getVarible().getName() + " cannot be distributed by " + operAuth.getTarget().getName());
									//System.err.println("violated commitment : " + violatedComm.getId());
									if (!searchCommitment(violatedComm, unSatCommitmentList)) // put in unsat list only if it is not already there
										unSatCommitmentList.add(violatedComm);
								}
							}
						
					}
				}
			}	
		}
	}
	
	//it return trues if the commitment is contained in the list of commitment
	private static Boolean searchCommitment (Commitment commitment, HashSet<Commitment> commitmentList)
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
	
	//search an authorization commitment in the instantiated SRS
	private static Commitment searchViolatedAuthCommitment(eu.aniketos.srcm.SRS.Authorization.Operation op, Variable variable, Participant participant, SRS srs)
	{
		Vector<Commitment> commList = srs.getCommitmentList();
		Iterator<Commitment> i = commList.iterator();
		while(i.hasNext())
		{
			Commitment commitment = i.next();
			if (commitment.getDebtor().getName().compareToIgnoreCase(participant.getName())==0)
			{
				if (op==Authorization.Operation.DISTRIBUTE)
				{
					if(commitment.getPostCondition().getClass()==NonDisclosure.class)
					{
						NonDisclosure nonDisclosure = (NonDisclosure) commitment.getPostCondition();
						Iterator nonDisclIT = nonDisclosure.getInformationList().iterator();
						boolean found = false;
						while(nonDisclIT.hasNext())
						{
							Variable varCom = (Variable) nonDisclIT.next();
							if (varCom.getId().compareToIgnoreCase(variable.getId())==0)
								return commitment;
						}
					}
				}
				else if (op==Authorization.Operation.USE)
				{
					if(commitment.getPostCondition().getClass()==NonUsage.class)
					{
						NonUsage nonUsage = (NonUsage) commitment.getPostCondition();
						Iterator nonUsageIT = nonUsage.getInformationList().iterator();
						boolean found = false;
						while(nonUsageIT.hasNext())
						{
							Variable varCom = (Variable) nonUsageIT.next();
							if (varCom.getId().compareToIgnoreCase(variable.getId())==0)
								return commitment;
						}
					}
				}
				else if (op==Authorization.Operation.PRODUCE)
				{
					if(commitment.getPostCondition().getClass()==NonProduction.class)
					{
						NonProduction nonProduction = (NonProduction) commitment.getPostCondition();
						Iterator nonProductionIT = nonProduction.getInformationList().iterator();
						boolean found = false;
						while(nonProductionIT.hasNext())
						{
							Variable varCom = (Variable) nonProductionIT.next();
							if (varCom.getId().compareToIgnoreCase(variable.getId())==0)
								return commitment;
						}
					}
				}
				else if (op==Authorization.Operation.MODIFY)
				{
					if(commitment.getPostCondition().getClass()==NonModification.class)
					{
						NonModification nonModification = (NonModification) commitment.getPostCondition();
						Iterator nonModificationIT = nonModification.getInformationList().iterator();
						boolean found = false;
						while(nonModificationIT.hasNext())
						{
							Variable varCom = (Variable) nonModificationIT.next();
							if (varCom.getId().compareToIgnoreCase(variable.getId())==0)
								return commitment;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	private static HashSet<Participant> searchReceivers(Element element, Variable variable, HashSet<Element> visited, HashSet<Participant> receivers)
	{
		//boolean that is set to true, if is is the first call of the function 
		boolean first = false;
		//at the first step i have to instantiate the internal sets
		if (visited==null)
		{
			visited = new HashSet<Element>();
			first = true;
		}
		if (receivers==null)
			receivers = new HashSet<Participant>();
		
		//if the node is already visited we are in a cycle, then the function will stop
		if (visited.contains(element))
			return receivers;
		
		visited.add(element);
		
		//if the element is not an activity, i skip the rest of the function
		//if this is the first call of the function, i.e. the aim of the function is to search the receivers of this activity, i skip this activity 
		//(i don't want to include among the receivers of the variable sent by this activity, this activity itself)
		if (element.getClass()==Activity.class && !first)
		{
			Activity activity = (Activity) element;
			
			//if it receives the variable, the i add it (this control check both the variable name and id)
			Iterator<Variable> varIT = activity.getInVariablesList().iterator();
			while (varIT.hasNext())
			{	
				Variable inVar = varIT.next();
				if (inVar.getName().compareToIgnoreCase(variable.getName())==0)// && inVar.getId().compareToIgnoreCase(variable.getId())==0)
					receivers.add(activity.getOwner());
			}
		}
		
		Iterator<Element> receiversIT = element.getNextList().values().iterator();
		while (receiversIT.hasNext())
		{
			searchReceivers(receiversIT.next(), variable, visited, receivers);
		}
		
		return receivers;
	}
	
	//search if the variable is already present in the authorization list
	private static ActorVarOperation searchAuthorizationTable(Vector<ActorVarOperation> operations, Variable variable, Participant target)
	{
		Iterator<ActorVarOperation> opAuthIT = operations.iterator();
		while (opAuthIT.hasNext())
		{
			ActorVarOperation operAuth = opAuthIT.next();
			if (operAuth.getVarible().getName().compareToIgnoreCase(variable.getName())==0 && 
				//operAuth.getVarible().getName().compareToIgnoreCase(variable.getName())==0 && same?? 
				operAuth.getTarget().getName().compareToIgnoreCase(target.getName())==0)
				
				return operAuth;
		}
		return null;
	}
	
	//search an activity using the id of the activity
	private static Activity searchAct(EABPM bpm, String actID)
	{
		Vector<Element> elementList = bpm.getElementsList();
		Iterator<Element> ElementListIT = elementList.iterator();
		while (ElementListIT.hasNext())
		{
			Element element = ElementListIT.next();
			if (element.getClass()==Activity.class)
			{
				Activity activity = (Activity) element;
				if (activity.getId().compareToIgnoreCase(actID)==0)
					return activity;
			}
		}
		
		return null;
	}
	
}


















