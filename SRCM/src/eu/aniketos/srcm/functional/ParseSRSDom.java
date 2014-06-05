/*
* ParseSRSDom.java
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

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import eu.aniketos.srcm.SRS.*;

/**This class parses the SRS XML document received as inputs, and instantiates the correspondent data structure
 * @author Mattia Salnitri
 *
 */
public class ParseSRSDom 
{
	//list of reference to the object that may be referenced more than one time in the SRS 
	private HashMap<String, Role> roleList;
	private HashMap<String, Agent> agentList;
	private HashMap<String, Goal> goalList;
	private HashMap<String, Information> informationList;
	private HashMap<String, eu.aniketos.srcm.SRS.Document> documentList;
	
	private SRS srs;
	
	/**constructor of the class
	 * @param domSRS the SRS XML document
	 */
	public ParseSRSDom(Document domSRS)
	{
		//instantiate the first class of the SRS class structure
		srs = new SRS();
		
		//instantiate the has maps
		roleList = new HashMap<String, Role>();
		agentList = new HashMap<String, Agent>();
		goalList = new HashMap<String, Goal>();
		informationList = new HashMap<String, Information>();
		documentList = new HashMap<String, eu.aniketos.srcm.SRS.Document>();
		
		try {
			setupSRS(domSRS, srs);
			//set up the lists
			srs.setRoleList(roleList);
			srs.setAgentList(agentList);
			srs.setGoalList(goalList);
			srs.setInformationList(informationList);
			srs.setDocumentList(documentList);
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			System.err.println("XML file not well formed");
			srs=null;
		}
	}
	

	private SRS setupSRS (Node node, Object father) throws Exception   
    { 
    	
       Object newFather=null;
       
       if (node.getNodeType() == node.ELEMENT_NODE)    
       {       
    	   //node name
           //System.out.print("<"+node.getNodeName());
           
           if (node.getNodeName().equalsIgnoreCase("secReqSpe"))
           {   
        	   //first node
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("commitment"))
           {
//body commitment
        	   //if the father is a boolean, ignore everithing ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //cast father
	        	   SRS srs = (SRS) father;
	        	   //create new item
	        	   Commitment commitment = new Commitment();
	        	   //add commitment to SRS
	        	   srs.addCommitment(commitment);
	        	   //new object (use in the recursive call)
	        	   newFather=commitment;
	        	   
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   commitment.setId(attr.getNodeValue());
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	                   else
	                   {
	                	   //error in the xml structure
	                	   System.err.println("error in SRS xml structure");
	                	   return null;
	                   }
	               }
        	   }
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("non-repudiation"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   NonRepudiation nonRepudiation = new NonRepudiation();
	        	   commitment.setPostCondition(nonRepudiation);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=nonRepudiation;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("non-disclosure"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   NonDisclosure nonDisclosure = new NonDisclosure();
	        	   commitment.setPostCondition(nonDisclosure);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=nonDisclosure;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("non-modification"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   NonModification nonModification = new NonModification();
	        	   commitment.setPostCondition(nonModification);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=nonModification;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("non-usage"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   NonUsage nonUsage = new NonUsage();
	        	   commitment.setPostCondition(nonUsage);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=nonUsage;
        	   }
        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("non-production"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   NonProduction nonProduction = new NonProduction();
	        	   commitment.setPostCondition(nonProduction);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=nonProduction;
        	   }
        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("trustworthiness"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Commitment commitment = (Commitment) father;
	        	   Trustworthiness trustworthiness = new Trustworthiness();
	        	   commitment.setPostCondition(trustworthiness);
	        	   
	        	   //read the id attributes
	    		   NamedNodeMap startAttr = node.getAttributes();
	    		   for (int i = 0; i < startAttr.getLength(); i++) 
	    		   {   
	    			   Node attr = startAttr.item(i);
	    			   //node parameter
	    			   if (attr.getNodeName().compareToIgnoreCase("minLevel")==0)
	    			   {
	    				   trustworthiness.setLevel(new Integer(attr.getNodeValue()));
	    				   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	    			   }
	    			   else
	    				   //error in the xml structure
	    				   return null;
	    		   }
	        	   //new object (use in the recursive call)
	        	   newFather=trustworthiness;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("debtor"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //set a placeholder for next step,
	        	   ((Commitment)father).setDebtor(new Actor());
	        	   //since i do not create any object which represent the father i keep the old father
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("creditor"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //set a placeholder for next step,
	        	   ((Commitment)father).setCreditor(new Actor());
	        	   //since i do not create any object which represent the father i keep the old father
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("precondition"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("postcondition"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("delegation"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //cast father
	        	   Commitment commitment = (Commitment) father;
	        	   //create new item
	        	   Delegation delegation = new Delegation();
	        	   //add delegation to commitment
	        	   commitment.setPrecondition(delegation);//! for commitments where preconditions contains the delegation and or authorization, they are inverted
	        	   //new object (use in the recursive call)
	        	   newFather=delegation;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("authorization"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //cast father
	        	   Commitment commitment = (Commitment) father;
	        	   //create new item
	        	   Authorization authorization = new Authorization();
	        	   //add delegation to commitment
	        	   commitment.setPrecondition(authorization);
	        	   //new object (use in the recursive call)
	        	   newFather=authorization;
        	   }
               //delegation has no attribute
           }
           else if (node.getNodeName().equalsIgnoreCase("source"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	  //set a placeholder for next step
	        	   if (father.getClass()==Delegation.class)
	        		   ((Delegation)father).setSource(new Actor());
	        	   else
	        		   ((Authorization)father).setSource(new Actor());
	        	   
	        	   //since i do not create any object which represent the father i keep the old father
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("destination"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	         	  //set a placeholder for next step,
	        	   if (father.getClass()==Delegation.class)
	        		   ((Delegation)father).setDestination(new Actor());
	        	   else if (father.getClass()==Authorization.class)
	        		   ((Authorization)father).setDestination(new Actor());
	        	   else if (father.getClass()==Trustworthiness.class)
	        	   {
	        		   //do nothing, i set up role or agent next tag
	        	   }
	        	   
	        	   //since i do not create any object which represent the father i keep the old father
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("goalSet"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("transferable"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("goal"))
           {
//body goal
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Goal goal = new Goal();
	        	   
	        	   //read the id attributes
	    		   NamedNodeMap startAttr = node.getAttributes();
	    		   for (int i = 0; i < startAttr.getLength(); i++) 
	    		   {   
	    			   Node attr = startAttr.item(i);
	    			   //node parameter
	    			   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	    			   {
	    				   goal.setId(attr.getNodeValue());
	    				   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	    			   }
	    			   else
	    				   //error in the xml structure
	    				   return null;
	    		   }
	    		   
	    		   //add new goal or retrieve the correspondent one if it has already been encountered in the xml
	        	   goal=addUniqueGoal(goal);
	    		   
	        	   if (father.getClass()==Delegation.class)
	        	   {
	        		   Delegation delegation = (Delegation) father;        		   
	        		   delegation.addGoal(goal);
	        	   }
	        	   else if (father.getClass()==Authorization.class)
	        	   {
	        		   Authorization authorization = (Authorization) father;
	        		   authorization.addGoal(goal);
	        	   }  
	        	   else if (father.getClass()==NonRepudiation.class)
	        	   {
	        		   NonRepudiation nonRepudiation = (NonRepudiation) father;
	        		   nonRepudiation.addGoal(goal);
	        	   }
	        	   else if (father.getClass()==Trustworthiness.class)
	        	   {
	        		   Trustworthiness trustworthiness = (Trustworthiness) father;
	        		   trustworthiness.setGoal(goal);
	        	   }
	        	   
	    		   //new object (use in the recoursive call)
	    		   newFather=goal;
        	   }

//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("infoSet"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("scopeSet"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("operationSet"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("container"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   PartOf partOf = (PartOf) father;
	        	   partOf.setContainer(new Resource());
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("content"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   PartOf partOf = (PartOf) father;
	        	   partOf.setContent(new Resource());
	        	   newFather=father;
        	   }
           }
           else if (node.getNodeName().equalsIgnoreCase("information"))
           {
//body information
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   Information information = new Information();
	        	   
	        	   //retrieve the id attributes
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   information.setId(attr.getNodeValue());
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	                   else
	                	   //error in the xml structure
	                	   return null;
	               }
	               
	               //only one instance for the same information
	               information=addUniqueInformation(information); 
	        	   
	        	   if (father.getClass()==Authorization.class)
	        	   {
		        	   Authorization authorization = (Authorization) father;
		        	   authorization.addInformation(information);
	        	   }
	        	   else if (father.getClass()==NonDisclosure.class)
	        	   {
	        		   NonDisclosure nonDisclosure = (NonDisclosure) father;
	        		   nonDisclosure.addInformation(information);
	        	   }
	        	   else if (father.getClass()==NonProduction.class)
	        	   {
	        		   NonProduction nonProduction = (NonProduction) father;
	        		   nonProduction.addInformation(information);
	        	   }
	        	   else if (father.getClass()==NonUsage.class)
	        	   {
	        		   NonUsage nonUsage = (NonUsage) father;
	        		   nonUsage.addInformation(information);
	        	   }
	        	   else if (father.getClass()==NonModification.class)
	        	   {
	        		   NonModification nonModification = (NonModification) father;
	        		   nonModification.addInformation(information);
	        	   }
	        	   else if (father.getClass()==PartOf.class)
	        	   {
	        		   PartOf partOf = (PartOf) father;
	        		   //first time i set the contents, the second is the container
	        		   if (partOf.getContents()!=null && partOf.getContents().getClass()==Resource.class)
	        			   partOf.setContent(information);
	        		   else
	        			   partOf.setContainer(information);
	        	   }
	        	   else if (father.getClass()==TangibleBy.class)
	        	   {
	        		   TangibleBy tangibleBy = (TangibleBy) father;
	        		   tangibleBy.setInformation(information);
	        	   }
	        	   else if (father.getClass()==Owns.class)
	        	   {
	        		   Owns owns = (Owns) father;
	        		   owns.setInformation(information);
	        	   }
	        	   else if (father.getClass()==FullyAuthorized.class)
	        	   {
	        		   FullyAuthorized fullyAuthorized = (FullyAuthorized) father;
	        		   fullyAuthorized.setInformation(information);
	        	   }
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=information;
        	   }

//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("operation"))
           {
        	   //since i do not create any object which represent the father i keep the old father
        	   newFather=father;        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("knowledgeBase"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   SRS srs = (SRS) father;
	        	   KnowledgeBase knowledgeBase = new KnowledgeBase();
	        	   srs.setKnowledgeBase(knowledgeBase);
	
	        	   //new object (use in the recursive call)
	        	   newFather=knowledgeBase;
        	   }
        	   
        	   //it has no attributes
           }
           else if (node.getNodeName().equalsIgnoreCase("partOf"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {        	   
	        	   KnowledgeBase knowledgeBase = (KnowledgeBase) father;
	        	   PartOf partOf = new PartOf();
	        	   knowledgeBase.addPartOf(partOf);
	
	        	   //new object (use in the recursive call)
	        	   newFather=partOf;
        	   }

           }
           else if (node.getNodeName().equalsIgnoreCase("tangibleBy"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   KnowledgeBase knowledgeBase = (KnowledgeBase) father;
	        	   TangibleBy tangibleBy = new TangibleBy();
	        	   knowledgeBase.addTangibleBy(tangibleBy);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=tangibleBy;
        	   }
        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("owns"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   KnowledgeBase knowledgeBase = (KnowledgeBase) father;
	        	   Owns owns = new Owns();
	        	   knowledgeBase.addOwns(owns);
	
	        	   //new object (use in the recursive call)
	        	   newFather=owns;
        	   }
        	           	   
           }
           else if (node.getNodeName().equalsIgnoreCase("fullyAuthorized"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   KnowledgeBase knowledgeBase = (KnowledgeBase) father;
	        	   FullyAuthorized fullyAuthorized = new FullyAuthorized();
	        	   knowledgeBase.addFullyAuthorized(fullyAuthorized);
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=fullyAuthorized;
        	   }
        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("document"))
           {
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	    		   eu.aniketos.srcm.SRS.Document document = new eu.aniketos.srcm.SRS.Document();
	    		   
	    		   
	    		   //read the ID attribute
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   document.setId(attr.getNodeValue());
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	                   else
	                	   //error in the xml structure
	                	   return null;
	               }
	               
	               //only one instance for the same document
	               document = addUniqueDocument(document);
	    		   
	        	   if (father.getClass()==PartOf.class)
	        	   {
	        		   PartOf partOf = (PartOf) father;  
	        		   //first time i set the contents, the second is the container
	        		   if (partOf.getContents()!=null && partOf.getContents().getClass()==Resource.class)
	        			   partOf.setContent(document);
	        		   else
	        			   partOf.setContainer(document);
	        	   }
	        	   else if (father.getClass()==TangibleBy.class)
	        	   {
	        		   TangibleBy tangibleBy = (TangibleBy) father;
	        		   tangibleBy.setDocument(document);
	        	   }
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=document;
        	   }
        	  
           }
           else if (node.getNodeName().equalsIgnoreCase("agent"))
           {
//body agent
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	        	   //create new item
	        	   Agent agent = new Agent();
	        	   
	        	   //retrieve the id attribute
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   agent.setId(attr.getNodeValue());
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	                   else
	                	   //error in the xml structure
	                	   return null;
	               }
	               
	               //only one instance for the same agent
	               agent = addUniqueAgent(agent);
	        	   
	        	   if (father.getClass()==Commitment.class)
	        	   {
	        		   //cast father, for the debtor is the commitment
		        	   Commitment commitment = (Commitment) father;
		        	   //if i'm working with the debtor
	        		   if(commitment.getDebtor().getClass()==Actor.class)
	        		   {   
			        	   //add debtor to commitment
			        	   commitment.setDebtor(agent);
	
		        	   }
		        	   else //i'm working with the creditor
		        	   {
			        	   //add debtor to commitment
			        	   commitment.setCreditor(agent);
		        	   }
	        	   }
	        	   else if (father.getClass()==Delegation.class)
	        	   {
	        		   Delegation delegation = (Delegation) father;
	        		   //if i'm working with the source
	        		   if (delegation.getSource().getClass()==Actor.class)
	        		   {
	        			   //set source
	        			   delegation.setSource(agent);			   
	        		   }
	        		   else //i'm working with the destination
	        		   {
	        			   //set source
	        			   delegation.setDestination(agent);
	        		   }
	        	   }
	        	   else if (father.getClass()==Authorization.class)
	        	   {
	        		   Authorization authorization = (Authorization) father;
	        		   //if i'm working with the source
	        		   if (authorization.getSource().getClass()==Actor.class)
	        		   {
	        			   //set source
	        			   authorization.setSource(agent);
	        		   }
	        		   else //i'm wotking with the destination
	        		   {
	        			   //set source
	        			   authorization.setDestination(agent);
	        		   }
	        	   }
	        	   else if (father.getClass()==Owns.class)
	        	   {
	        		   Owns owns = (Owns) father;
	        		   owns.setOwner(agent);
	        	   }
	        	   else if (father.getClass()==FullyAuthorized.class)
	        	   {
	        		   FullyAuthorized fullyAuthorized = (FullyAuthorized) father;
	        		   fullyAuthorized.setOwner(agent);
	        	   }
	        	   else if (father.getClass()==Trustworthiness.class)
	        	   {
	        		   Trustworthiness trustworthiness = (Trustworthiness) father;
	        		   trustworthiness.setActor(agent);
	        	   }
	        	   
	        	   //new object (use in the recoursive call)
	        	   newFather=agent;
        	   }
        	  
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("role"))
           {
//body role
        	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
        	   if (!(father.getClass()==Boolean.class))
        	   {
	  			 //create new item
	        	   Role role = new Role();
	        	   
	        	   //retieve the id attribute
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   role.setId(attr.getNodeValue());
	                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
	                   }
	                   else
	                	   //error in the xml structure
	                	   return null;
	               }        	   
	        	   
	               //only one instance for the same role
	               role = addUniqueRole(role);
	               
	        	   if (father.getClass()==Commitment.class)
	        	   {
	        		   //cast father, for the debtor is the commitment
		        	   Commitment commitment = (Commitment) father;
		        	   //if i'm working with the debtor
	        		   if(commitment.getDebtor().getClass()==Actor.class)
	        		   {
	    	        	   //add debtor to commitment
	    	        	   commitment.setDebtor(role);
	        		   }
	        		   else //i'm working with the creditor
	        		   {
	    	        	   //add debtor to commitment
	    	        	   commitment.setCreditor(role);
	        		   }
	        	   }
	        	   else if (father.getClass()==Delegation.class)
	        	   {
	        		   Delegation delegation = (Delegation) father;
	        		   //if i'm working with the source
	        		   if (delegation.getSource().getClass()==Actor.class)
	        		   {
	        			   //set source
	        			   delegation.setSource(role);
	        		   }
	        		   else //i'm working with the destination
	        		   {
	        			   //set source
	        			   delegation.setDestination(role);
	        		   }
	        	   }
	        	   else if (father.getClass()==Authorization.class)
	        	   {
	        		   Authorization authorization = (Authorization) father;
	        		   //if i'm working with the source
	        		   if (authorization.getSource().getClass()==Actor.class)
	        		   {
	        			   //set source
	        			   authorization.setSource(role);
	        		   }
	        		   else//i'm working with the destination
	        		   {
	        			   //set source
	        			   authorization.setDestination(role);
	        		   }
	        	   }
	        	   else if (father.getClass()==Owns.class)
	        	   {
	        		   Owns owns = (Owns) father;
	        		   owns.setOwner(role);
	        	   }
	        	   else if (father.getClass()==FullyAuthorized.class)
	        	   {
	        		   FullyAuthorized fullyAuthorized = (FullyAuthorized) father;
	        		   fullyAuthorized.setOwner(role);
	        	   }
	        	   else if (father.getClass()==Trustworthiness.class)
	        	   {
	        		   Trustworthiness trustworthiness = (Trustworthiness) father;
	        		   trustworthiness.setActor(role);
	        	   }
	        	   
	        	   //new object (use in the recursive call)
	        	   newFather=role;
        	   }
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("actor"))
           {
        	   //new object (use in the recursive call)
        	   newFather=father;
        	   
           }
           else
           {
        	   //if the parser do not recognize the tag, ignore everything from this point to the leaf nodes.
        	   father = new Boolean(true);
           }
           
       }
//*****
//if the child is a piece of text, it means is the name of the father
//*****
       else if (node.getNodeType() == node.TEXT_NODE)  
       {    	   
           //System.out.print(node.getNodeValue());
    	   //if the father is a boolean, ignore everything ( a parent tag was not recognized
    	   if (!(father.getClass()==Boolean.class))
    	   {           
	    	   String content= node.getNodeValue();
	    	   content=content.replaceAll("[\n'\t ]", "");
	    	   //System.out.println("content="+content);
	    	   if (father.getClass()==Delegation.class && !content.isEmpty())
	    	   {
	    		   Delegation delegation = (Delegation) father;
	    		   if (content.compareToIgnoreCase("true")==0)
	    			   delegation.setTransferable(true);
	    		   else
	    			   delegation.setTransferable(false);
	    		   //delegation.setTransferable(new Integer(Integer.parseInt(content)));
	    	   }
	    	   else if (father.getClass()==Authorization.class && !content.isEmpty())
	    	   {
	
	        	   Authorization authorization = (Authorization) father;
	        	   
	        	   if (content.compareToIgnoreCase("use")==0)
	        		   authorization.addOperations(Authorization.Operation.USE);
	        	   else if (content.compareToIgnoreCase("modify")==0)
	        		   authorization.addOperations(Authorization.Operation.MODIFY);
	        	   else if (content.compareToIgnoreCase("produce")==0)
	        		   authorization.addOperations(Authorization.Operation.PRODUCE);
	        	   else if (content.compareToIgnoreCase("distribute")==0)
	        		   authorization.addOperations(Authorization.Operation.DISTRIBUTE);
	        	   else //if it's not an operation, it must be a boolean for the transferable property
	        	   {
	        		   if (content.compareToIgnoreCase("true")==0)
	        			   authorization.setTransferable(true);
	        		   else
	        			   authorization.setTransferable(false);
	        	   }
	
	
	    	   }
	           else if (father.getClass()==Goal.class && !content.isEmpty())
	           {
	        	   Goal goal = (Goal) father;
	        	   goal.setName(content);
	           }
	           else if (father.getClass()==Information.class && !content.isEmpty())
	           {
	        	   Information information = (Information) father;
	        	   information.setName(content);
	           }
	           else if (father.getClass()==eu.aniketos.srcm.SRS.Document.class && !content.isEmpty())
	           {
	        	   eu.aniketos.srcm.SRS.Document document= (eu.aniketos.srcm.SRS.Document) father;
	        	   document.setName(content);
	           }
	           else if ((father.getClass()==Agent.class || father.getClass()==Role.class)  && !content.isEmpty())
	           {
	        	   //i cast it to actor, since name attribute is  in that class
	        	   Actor actor = (Actor) father;
	        	   actor.setName(content);
	           }
    	   }
       }   
         
       //for each the childs recall the functions
       //it works because the text node has no childs
       //placed here in order to avoid code duplication
       
       //this have to be done since the text element is always checked, even if in the xml there is no element text
       if (newFather==null)
    	   newFather=father;
       
        for (Node child = node.getFirstChild();    
            child != null;   
            child = child.getNextSibling())   
        {   
        	//if there will be any child, this will be done only after the element node
            setupSRS(child,newFather);   
        }   
           
        //if the XML is well formed, once i have parsed all the child i have to meet the close tag
        if (node.getNodeType() == node.ELEMENT_NODE)    
        {     
        	//do nothing
        	//but i have to read it in order to go on
            //System.out.print("</"+node.getNodeName()+">");   
        }
        
               
        if (father.getClass()==SRS.class)
        	return (SRS) father;
        else
        	return null;
    }


	/**Getter of the SRS instantiated data structure
	 * @return the instantiated data structure
	 */
	public SRS getSrs() {
		return srs;
	}


	/**Setter of the instantiated data structure
	 * @param srs the instantiated data structure
	 */
	public void setSrs(SRS srs) {
		this.srs = srs;
	}


//role getters and setters
	/**Getter of the list of the roles
	 * @return
	 */
	public HashMap<String, Role> getRoleList() {
		return roleList;
	}

	/**This adds a role to the role list 
	 * @param role the role that have to be added
	 */
	public void addRole(Role role) 
	{
		this.roleList.put(role.getId(), role);
	}
	
	/**This class removes a given role frol the role list 
	 * @param role the role that have to be removed
	 */
	public void removeRole(Role role) 
	{
		this.roleList.remove(role.getId());
	}
	
 
	/**
	 * this functions helps in maintaining the objects in the list unique
	 * @param role the role that have to be added
	 * @return the element itself if it is not present in the hash map (first time meet), the correspondent element if it is already present in the hash map
	 */
	public Role addUniqueRole(Role role) 
	{
		
		if (roleList.containsKey(role.getId()))
			return roleList.get(role.getId());
		else
		{
			roleList.put(role.getId(), role);
			return role;
		}
	}

//agent getters and setters
	/**Getter of the agent list
	 * @return the agent list
	 */
	public HashMap<String, Agent> getAgentList() {
		return agentList;
	}

	/**This functions adds a given agent to the agent list 
	 * @param agent the agent that have to be added
	 */
	public void addAgent(Agent agent) {
		this.agentList.put(agent.getId(), agent);
	}

	/**This function removes a given agent from the agent list
	 * @param agent the agent that have to be removed
	 */
	public void removeAgent(Agent agent) {
		this.agentList.remove(agent.getId());
	}
 
	/** this functions helps in maintaining the objects in the list unique
	 * @param agent
	 * @return the element itself if it is not present in the hash map (first time meet), the correspondent element if it is already present in the hash map
	 */
	public Agent addUniqueAgent(Agent agent) 
	{
		
		if (agentList.containsKey(agent.getId()))
			return agentList.get(agent.getId());
		else
		{
			agentList.put(agent.getId(), agent);
			return agent;
		}
	}
	
//goal getters and setters
	/**Getter of the goal list
	 * @return the goal list
	 */
	public HashMap<String, Goal> getGoalList() {
		return goalList;
	}

	/**This functions adds a given goal to the goal list
	 * @param goal the goal that have to be added
	 */
	public void addGoal(Goal goal) {
		this.goalList.put(goal.getId(), goal);
	}

	/**This functions removes a given goal to the goal list
	 * @param goal the goal that have to be removed
	 */
	public void removeGoal(Goal goal) {
		this.goalList.remove(goal.getId());
	}
 
	/**this functions helps in maintaining the objects in the list unique
	 * @param goal the goal that have to be added
	 * @return the element itself if it is not present in the hash map (first time meet), the correspondent element if it is already present in the hash map
	 */
	public Goal addUniqueGoal(Goal goal) 
	{
		
		if (goalList.containsKey(goal.getId()))
			return goalList.get(goal.getId());
		else
		{
			goalList.put(goal.getId(), goal);
			return goal;
		}
	}
	
//information getters and setters
	/**Getter of the information list 
	 * @return the information list
	 */
	public HashMap<String, Information> getInformationList() {
		return informationList;
	}

	/**This functions adds a given information to the information list
	 * @param information the information that have to be added to the list
	 */
	public void addInformation(Information information) {
		this.informationList.put(information.getId(), information);
	}
	
	/**This functions removes a given information to the information list
	 * @param information the information that have to be removed from the list
	 */
	public void removeInformation(Information information) {
		this.informationList.remove(information.getId());
	}
 
	/** this functions helps in maintaining the objects in the list unique
	 * @param information the information that have to be added
	 * @return it returns the element itself if it is not present in the hash map (first time meet), the correspondent element if it is already present in the hash map
	 */
	public Information addUniqueInformation(Information information) 
	{
		
		if (informationList.containsKey(information.getId()))
			return informationList.get(information.getId());
		else
		{
			informationList.put(information.getId(), information);
			return information;
		}
	}
	
//Document getters and setters
	/**Getter of the document list
	 * @return the list of document
	 */
	public HashMap<String, eu.aniketos.srcm.SRS.Document> getDocumentList() {
		return documentList;
	}

	/**This functions adds a given document to the document list
	 * @param document the document that have to be added
	 */
	public void addDocument(eu.aniketos.srcm.SRS.Document document) {
		this.documentList.put(document.getId(), document);
	}	
	
	/**This functions removes a given document to the document list
	 * @param document the document that have to be removed
	 */
	public void removeDocument(eu.aniketos.srcm.SRS.Document document) {
		this.documentList.remove(document.getId());
	}	

 
	/**this functions helps in maintaining the objects in the list unique
	 * @param document the document that have to be added
	 * @return it returns the element itself if it is not present in the hash map (first time meet), the correspondent element if it is already present in the hash map
	 */
	public eu.aniketos.srcm.SRS.Document addUniqueDocument(eu.aniketos.srcm.SRS.Document document) 
	{
		
		if (documentList.containsKey(document.getId()))
			return documentList.get(document.getId());
		else
		{
			documentList.put(document.getId(), document);
			return document;
		}
	}
}
