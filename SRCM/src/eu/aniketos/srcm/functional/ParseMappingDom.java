/*
* ParseMappingDom.java
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
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import eu.aniketos.SecureBPMN.*;
import eu.aniketos.SecureBPMN.Participant.participantType;
import eu.aniketos.srcm.SRS.*;
import eu.aniketos.srcm.mapping.*;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**This class parses the Mapping XML document received as inputs, and instantiates the correspondent data structure
 * @author Mattia Salnitri
 *
 */
public class ParseMappingDom 
{
	
	//list of reference to the object that may be referenced more than one time in the SRS 
	private static HashMap<String, Participant> BPParticipantList; //key is the name => participants name is unique
	private static HashMap<String, Role> SRRoleList;
	private static HashMap<String, Agent> SRAgentList;
	private static HashMap<String, Goal> SRGoalList; 
	private static HashMap<String, Element> BPActivityList; //key is the id
	private static HashMap<String, eu.aniketos.srcm.SRS.Document> SRDocumentList;
	private static Vector<Variable> BPVariableList; //the key is the name+id
	//temp vector, store the mapping during the parsing
	private static Vector<Variable> BPVariableListTmp; //the key is the name+id
	

	private Mapping mapping;
	
	/** Constructor of the class.
	 * This class should be instantiated after both the BPM and the SRS are already parsed. 
	 * @param domMapping the XML mapping document 
	 * @param BPParticipantList the list of the BPM participants 
	 * @param SRRoleList the list of the STS-ml roles
	 * @param SRAgentList the list of the STS-ml agents
	 * @param SRGoalList the list of the STS-ml goals
	 * @param BPActivityList the list of the BPM activities
	 * @param SRDocumentList the list of the STS-ml documents
	 * @param BPVariableList the list of the BPM variables
	 */
	@SuppressWarnings("static-access")
	public ParseMappingDom(Document domMapping, HashMap<String, Participant> BPParticipantList, 
			HashMap<String, Role> SRRoleList, 
			HashMap<String, Agent> SRAgentList,
			HashMap<String, Goal> SRGoalList,
			HashMap<String, Element> BPActivityList,
			HashMap<String, eu.aniketos.srcm.SRS.Document> SRDocumentList,
			Vector<Variable> BPVariableList)
	{
		//instantiate the mapping
		mapping = new Mapping();
		
		//set up all the hashmaps
		this.BPParticipantList=BPParticipantList;
		this.SRRoleList= SRRoleList;
		this.SRAgentList=SRAgentList;
		this.SRGoalList = SRGoalList;
		this.BPActivityList = BPActivityList;
		this.SRDocumentList = SRDocumentList;
		this.BPVariableList=BPVariableList;
		BPVariableListTmp = new Vector<Variable>();
		
		try {
			mapping = (Mapping) setupMapping(domMapping, mapping, mapping);
			
		} catch (Exception e) 
		{
			System.err.println("error in the Mapping class structure instantiation");
		}
		//last step consists to match the variables
		//since from the mapping we collected the matching on variable and document but in the BP we have stream that are identified with (name + id)
		//to do in the checking algorithm
		
		//clean up the mapping
		mapping.clearLists();
		
		//assign owners to activities
		this.assignOwners(BPActivityList);
		
	}
	
	/**
	 *	assigns to all activities an owner
	 *rationale:
	 *if only 1 of the candidate owners are presents in the mapping is-a list, i assign that owner
	 *if both agent and role are present in the list, i assign the agent to the owner 
	 * 
	 * @param BPActivityList: the list of activities in the BP
	 */
	public void assignOwners(HashMap<String, Element> BPActivityList)
	{
		@SuppressWarnings("rawtypes")
		Iterator it = BPActivityList.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			
			if ( pairs.getValue().getClass()!=Activity.class)//i'm interested only in activities, i skip events
				continue;
			
			Activity act = (Activity) pairs.getValue();
			Vector<Participant> candidateOwners = act.getCandidateOwners();
			
			Iterator<Participant> itCandidateOwners = candidateOwners.iterator(); 
			while(itCandidateOwners.hasNext())//for all candidate users they are 1 or 2
			{
				Participant candidateOwner = itCandidateOwners.next(); 
				//search in the is-a f exist at least a relation which map the participant to a role
				
				//for all the is-a
				Vector<IsA> isAList = mapping.getIsaList();
				Iterator<IsA> itIsA = isAList.iterator();
				while (itIsA.hasNext())
				{
					IsA isA = itIsA.next();
					
					if (isA.getParticipant().getId().equals(candidateOwner.getId()))
					{
						act.setOwner(candidateOwner);//found, the first, stop here
						break;
					}
				}
				
				//if there is still no owner i check the play relations
				if (act.getOwner()==null)
				{
					Vector<Plays> playsList= mapping.getPlaysList();
					Iterator<Plays> itPlays = playsList.iterator();
					while(itPlays.hasNext())
					{
						Plays plays = itPlays.next();
						if (plays.getParticipant().getId().equals(candidateOwner.getId()))
						{
							act.setOwner(candidateOwner);
							break;
						}
					}
				}
				
				if (act.getOwner()!=null && act.getOwner().getType()==participantType.BPAGENT)//if the participant is an agent, we finish here, otherwise we keep searching for the role
					break;
				
			}
			
			//at this point the activity should have the owner set
			if (act.getOwner()==null)
				System.err.println("Owner of activity " +act.getName()+" not found!");
			
		}
	}
	
	//return type is not mappoing couse the return value may be also of type "Variable"
    @SuppressWarnings("static-access")
	private static Object setupMapping (Node node, Object father, Mapping mapping) throws Exception   
    {
    	
       Object newFather=null;
       
       //global couse are used in the recursive step
       Variable variable=null;
       
       if (node.getNodeType() == node.ELEMENT_NODE)    
       {       
    	   //node name
           //System.out.print("<"+node.getNodeName());
           
           if (node.getNodeName().equalsIgnoreCase("mapping"))
           {
        	   //first node
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           if (node.getNodeName().equalsIgnoreCase("participant"))
           {
        	   //Do nothing
        	   newFather=father;
           }
           if (node.getNodeName().equalsIgnoreCase("value"))
           {
        	   //Do nothing
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("relatesTo"))
           {
        	   //cast the father
        	   //Mapping mapping = (Mapping) father;
        	   
        	   //set up new relation
        	   RelatesTo relatesTo = new RelatesTo();
        	   //add relation to the mapping
        	   mapping.addRelatesToRelation(relatesTo);
        	   
        	   //new father for next recursive calls
        	   newFather=relatesTo;
           }
           else if (node.getNodeName().equalsIgnoreCase("represents"))
           {
        	   //cast the father
        	   //Mapping mapping = (Mapping) father;
        	   
        	   //set up the relation
        	   Represents represents = new Represents();
        	   //add the relation
        	   mapping.addRepresentsRelation(represents);
        	   
        	   //new father for next recursive calls
        	   newFather=represents;
           }
           else if (node.getNodeName().equalsIgnoreCase("is-a"))
           {
        	   //cast the father
        	   //Mapping mapping = (Mapping) father;
        	   
        	   //set up the relation
        	   IsA isA = new IsA();
        	   
        	   //add the relation
        	   //mapping.addIsaRelation(isA);//added when parsing an inner tag, to avoid duplication
        	   
        	   //new father for next recursive calls
        	   newFather=isA;
           }
           else if (node.getNodeName().equalsIgnoreCase("plays"))
           {
        	   //cast the father
        	   //Mapping mapping = (Mapping) father;
        	   
        	   //set up the relation
        	   Plays plays = new Plays();
        	   //add the relation
        	   mapping.addPlaysRelation(plays);
        	   
        	   //new father for next recursive calls
        	   newFather=plays;
           }
           else if (node.getNodeName().equalsIgnoreCase("activity"))
           {
//body activity
        	   //cast father
        	  RelatesTo relatesTo = (RelatesTo) father;
        	  
        	  String id="";
        	  //retrieve the ID
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   id=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
               if (id.compareTo("")==0)
               {
            	   System.err.println("invalid Activity ID");
        		   throw new Exception();
               }
               
        	   //search the id among all the element already collected in the BPM XML file
        	   Activity activity = (Activity) BPActivityList.get(id);
        	   
        	   //it means it is not found in the activity list, so the commitment never mentioned it, so it is useless
        	   if (activity==null)
        	   {
        		   return null;
        	   }
        			   
        	   //add element to relation
        	   relatesTo.setActivity(activity);
        	   
               //new object (use in the recursive call)
               newFather=activity;
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("goal"))
           {
//body goal
        	   //cast father
        	  RelatesTo relatesTo = (RelatesTo) father;
        	  
        	  String id="";
        	  //retrieve the ID
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   id=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
        	   if (id.compareTo("")==0)
        	   {
        		   System.err.println("invalid goal ID");
        		   throw new Exception();
        	   }
               
        	   //search the id among all the element already collected in the BPM XML file
        	   Goal goal = SRGoalList.get(id);
        	   
        	   //it means it is not found in the goal list, so the commitment never mentioned it, so it is useless
        	   if (goal==null)
        	   {
        		   return null;
        	   }
        			   
        	   //add element to relation
        	   relatesTo.setGoal(goal);
        	   
               //new object (use in the recursive call)
               newFather=goal;
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("variable"))
           {
//body variable
        	  if (father.getClass()== Represents.class)
        	  {
	        	   //cast father
	        	  Represents represents = (Represents) father;
	        	  
	        	  String id="";
	        	  //retrieve the ID
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   id=attr.getNodeValue();
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	               }
	               
	        	   if (id.compareTo("")==0)
	        	   {
	        		   System.err.println("invalid variable ID");
	        		   throw new Exception();
	        	   }
	               
	        	   //create a variable, i still do not know if it's duplicate, couse i don't know the name 
	               variable = new Variable();
	        	   variable.setId(id);
	        	   
	        	   //add to the list anyway
	        	   BPVariableListTmp.add(variable);
	        			   
	        	   //add element to relation
	        	   represents.setVariable(variable);
        	  }
               //new object (use in the recursive call)
               newFather=variable;
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("document"))
           {
//body document
        	   //cast father
        	  Represents represents = (Represents) father;
        	  
        	  //in case the document have been already set, it means it is a duplicate, hence i have to create a new relation and add it to the mapping data structure
        	  //i use the global variable to add the relation to the mapping data structure
        	  if (represents.getDocument()!=null)
        	  {
        		  System.out.println("Duplication of document, creating new represents to relation");
        		  Represents representsDupl = new Represents();
        		  
        		  //add to the mapping data structure
        		  mapping.addRepresentsRelation(representsDupl);
        		  
        		  representsDupl.setVariable(represents.getVariable());//the variable should be already set because of the XSD of mapping file
        		  
        		  //substitute the relation, in order to update the correct one
        		  represents= representsDupl;
        		  
        	  }
        	  
        	  String id="";
        	  //retrieve the ID
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   id=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
        	   if (id.compareTo("")==0)
        	   {
        		   System.err.println("Invalid document ID");
        		   throw new Exception();
        	   }
               
        	   //search the id among all the element already collected in the BPM XML file
        	   eu.aniketos.srcm.SRS.Document document = SRDocumentList.get(id);
        			   
        	   //it means it is not found in the goal list, i.e. it is a duplicate
        	   if (document==null)
        	   {
        		   //add it to set
        		   
        		   document = new eu.aniketos.srcm.SRS.Document();
        		   document.setId(id);//for the name i have to wait next iteration, because the name is between tag, not a property ad ID
        		   
        	   }
        	   
        	   //add element to relation
        	   represents.setDocument(document);
        	   
               //new object (use in the recursive call)
               newFather=document;
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("BPPart") || node.getNodeName().equalsIgnoreCase("BPRole"))
           {
//body Participant
        	  if (!(father.getClass()==Plays.class) || node.getNodeName().equalsIgnoreCase("BPPart"))// role of play, it links a BP participant only to a srs role: play -> bp play i.e. if the relation is a play then the tag has to be a BPRole, otherwise skip  
        	  {
        	   
	        	  String id="";
	        	  //retrieve the ID
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   id=attr.getNodeValue();
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	               }
	               
	        	   if (id.compareTo("")==0)
	        	   {
	        		   System.err.println("Invalid BPPart/BProle ID");
	        		   throw new Exception();
	        	   }
	               
	        	   //search the id among all the elements already collected in the BPM XML file
	        	   Participant participant = BPParticipantList.get(id);
	        	   
	        	   //add element to relation
	        	   //cast father
	        	   if (father.getClass()==IsA.class) 
	    		   {
	        		   IsA isa = (IsA) father;
	        		   if (isa.getParticipant()!=null)//if the participant is != from null, it means an isa has been already created hence i createa new one 
	        			   isa = new IsA();
	        		   
	            	   if (participant==null)//if the participant is null it means there is no id that correspond to participants collected in BP, but i have to search also in the content of the tag, so i created a placeholder variable.
	            	   {
	            		   participant= new Participant();
	            		   
	            		   if (node.getNodeName().equalsIgnoreCase("BPPart"))
	            			   participant.setType(participantType.BPAGENT);
	            		   else
	            			   participant.setType(participantType.BPROLE);
	            		   
	            		   isa.setParticipant(participant);
	            	   }
	            	   else
	            		   isa.setParticipant(participant);
	            	   
	            	   mapping.addIsaRelation(isa);
	            	   
	        		   newFather=isa;
	    		   }
	        	   else
	        	   {
	        		   Plays plays = (Plays) father;
	        		   if (participant==null)//if the participant is null it means there is no id that correspond to participants collected in BP, but i have to search also in the content of the tag, so i created a placeholder variable.
	            	   {
	            		   participant= new Participant();
	            		   
	            		   if (node.getNodeName().equalsIgnoreCase("BPPart"))
	            			   participant.setType(participantType.BPAGENT);
	            		   else
	            			   participant.setType(participantType.BPROLE);
	            		   
	            		   plays.setParticipant(participant);
	            	   }
	        		   else
	        			   plays.setParticipant(participant);
	        		   
	        		   newFather=plays;
	        	   }
        	  }
        	  else
        	  {
        		  System.out.println("BPAgent skipped because of play relation in mapping");
        		  newFather=father;//skip tag
        	  }
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("SRAgent") || node.getNodeName().equalsIgnoreCase("SRRole"))
           {
//body actor
        	 //at this point i search the isa relations that has an empty actor, they may be 2 or one, depending if only one or both the ggs BPRole or BPAgents has been used in the mapping
        	   
        	  String id="";
        	  //retrieve the ID
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   id=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
        	   if (id.compareTo("")==0)
        	   {
        		   System.err.println("Invalid SRAgent/SRRole ID");
        		   throw new Exception();
        	   }
               
               Actor actor;
               
        	   //search the id among all the element already collected in the BPM XML file
               if (node.getNodeName().equalsIgnoreCase("SRAgent"))
               {
            	   actor = SRAgentList.get(id);
               }
               else
               {
            	   actor = SRRoleList.get(id);
               }
        	   

        	   //add element to relation
        	   //cast father
        	   if (father.getClass()==IsA.class) 
    		   {
                   //now i have the actor/ role or agent linked to the is-a,
                   //at this point i fetch the relations in the is-a list in the mapping that does not have associated any actors, i.e. the two is-a relation created when the parsed visited the tags BProle and BPAgent
                   
                   Vector<IsA> isaList = mapping.getIsaList();
                   Vector<IsA> isaToBeRemoved = new Vector<IsA>();//list of isa relations (it should be only one) to be removed
                   for (IsA isa: isaList)
                   {
                	   if (isa.getActor()==null)//candidate found
                	   {
                		   if (actor.getClass()==Agent.class && isa.getParticipant().getType()==participantType.BPAGENT)
                		   {
                			   newFather=isa;
                			   isa.setActor(actor);
                		   }
                		   else if (actor.getClass()==Role.class && isa.getParticipant().getType()==participantType.BPROLE)
                		   {
                			   newFather=isa;
                			   isa.setActor(actor);
                		   }
                		   else
                			   isaToBeRemoved.add(isa);
                	   }
                   }
                   isaList.removeAll(isaToBeRemoved);
        		   
    		   }
        	   else
        	   {
        		   Plays plays = (Plays) father;
        		   plays.setActor(actor);
        		   newFather=plays;
        	   }
//end body
           }
           else
           {
        	   //other tags, do nothing
           }
           
       }
//*****
//if the child is a piece of text, it means is the name of the father
//*****
       else if (node.getNodeType() == node.TEXT_NODE)  
       {    	   
           //System.out.print(node.getNodeValue());
           
    	   String content= node.getNodeValue();
    	   content=content.replaceAll("[\n'\t]", "");
    	   
           if (father.getClass()==Variable.class)
           {
        	   //it has the same pinter to the global variable "variable", this is passed via parameter
        	   Variable variableF = (Variable) father;
        	   
               //i create a new variable in the new array, if it does not exists yet.
               Iterator<Variable> i = BPVariableListTmp.iterator();
               
               boolean found = false;
               
               while (i.hasNext())
               {
            	   Variable varTmp= (Variable) i.next();
            	   if (varTmp.getId().compareToIgnoreCase(variableF.getId())==0 && varTmp.getName()!=null && varTmp.getName().compareToIgnoreCase(content)==0)
            	   {
            		   //is a diplicate
            		   BPVariableListTmp.remove(variableF);
            		   //return the var to substitute
            		   newFather=varTmp;
            		   found = true;
            		   break;
            	   }
               }
               //if there is no duplicate, set the name
               if (!found)
            	   variableF.setName(content);           	
           }
           else if (father.getClass()==IsA.class || father.getClass()==Plays.class)
           {
        	   
        	   if (father.getClass()==IsA.class)//i have to reach the 2 ( or one o no one that has a part empty
        	   {
        		   IsA isA = (IsA) father;
        		   if (isA.getParticipant()!=null && isA.getParticipant().getId()==null)//if it's a place holder variable a read and setup the participant
        		   {
        			   Participant part = BPParticipantList.get(content);
        			   part.setType(isA.getParticipant().getType());
        			   isA.setParticipant(part);   
        		   }
        		   
        	   }
        	   else if (father.getClass()==Plays.class)
        	   {
        		   Plays plays = (Plays) father;
        		   if (plays.getParticipant()!=null && plays.getParticipant().getId()==null)//if it's a place holder variable a read and setup the participant
        		   {
        			   Participant part = BPParticipantList.get(content);
        			   part.setType(plays.getParticipant().getType());
        			   plays.setParticipant(part);   
        		   }
        	   }
        	   
        	   
           }
           else if (father.getClass()==eu.aniketos.srcm.SRS.Document.class)
           {
        	   eu.aniketos.srcm.SRS.Document document = (eu.aniketos.srcm.SRS.Document) father;
        	   if (document.getName()==null)
        	   {
        		   System.out.println("set name duplicated document to: " + content);
        		   document.setName(content);
        	   }
           }
       }   
         
       //for each the child recall the functions
       //it works because the text node has no child
       //placed here in order to avoid code duplication
       
       //this have to be done since the text element is always checked, even if in the xml there is no element text
       if (newFather==null)
    	   newFather=father;
       
        for (Node child = node.getFirstChild();    
            child != null;   
            child = child.getNextSibling())   
        {   
        	//if there will be any child, this will be done only after the element node
            Object returnValue = setupMapping(child,newFather, mapping);
            //if the variable has the name set, it means is has be mantained in the vector (it is not duplicated)
            //otherwise the var is duplicated
            if (returnValue!=null && returnValue.getClass()==Variable.class && variable!=null)
            {
            	if (variable!=(Variable) returnValue)
            		//if true the variable was a duplicate, so i have to substitute it in the relation
            		((Represents)father).setVariable(((Variable) returnValue));
            }
        }   
           
        //if the XML is well formed, once i have parsed all the child i have to meet the close tag
        if (node.getNodeType() == node.ELEMENT_NODE)    
        {     
        	//do nothing
        	//but i have to read it in order to go on
            //System.out.print("</"+node.getNodeName()+">");
        }

        if (father.getClass()==Mapping.class)
        	return (Mapping) father;
        else if (newFather.getClass()==Variable.class)
        	return newFather;
        else
        	return null;
    }

	/**Getter of the  mapping data structure
	 * @return the mapping data structure
	 */
	public Mapping getMapping() {
		return mapping;
	}

	/**Setter of the mapping data structure
	 * @param mapping the mapping data structure
	 */
	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}
	
 
	
}
