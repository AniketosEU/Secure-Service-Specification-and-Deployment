/*
* ParseBPMDom.java
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
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import eu.aniketos.SecureBPMN.*;
import eu.aniketos.SecureBPMN.Activity.Type;
import eu.aniketos.SecureBPMN.Participant.participantType;


/**This class parses the Business process XML document received as inputs, and instantiates the correspondent data structure
 * it supposes the name of the variable is unique
 * @author Mattia Salnitri
 *
 */
public class ParseSecureBPMNDom 
{
	//this parser supports both activiti 5.8 and 5.9.3
	private static boolean ACTIVITY59=true;
	
	//list of reference to the object that may be referenced more than one time in the EABPM 
	private static HashMap<String, Participant> participantList;//key is the name => participants name is unique
	private static HashMap<String, Element> elementList; //key is the id
	private static Vector<Variable> variableList; //vector, because there are duplications on names and id, temporary duplication
	
	//used to store the pairs source-destination used for the control flow 
	//private static HashMap<String, String> bpFlow;
	private static Vector<String[]> bpFlow;
	
	private EABPM eabpm;
	
	/**Constructor of the class 
	 * @param domBPM the XML document
	 */
	public ParseSecureBPMNDom(Document domBPM)
	{
		
		//instantiate hash maps
		participantList = new HashMap<String, Participant>();
		elementList = new HashMap<String, Element>();
		variableList = new Vector<Variable>();
		//bpFlow = new HashMap<String, String>();
		bpFlow = new Vector<String[]>(); 
		
		eabpm = new EABPM();
		
		eabpm = setupBPM(domBPM, eabpm);
		
		Iterator<String[]> Flowit = bpFlow.iterator();
		
		//setup previous for double linked  list
		while(Flowit.hasNext())
		{
			String[] pair = Flowit.next();
			
			Element source = elementList.get(pair[0]);
			Element target = elementList.get(pair[1]);
			source.addNext(target);
			target.addPrevious(source);
		}
		
		//Maintain only an object for every variable
		Iterator elementIt = elementList.values().iterator();
		
		while(elementIt.hasNext())
		{	
			Object tmp = elementIt.next();
			if (tmp.getClass()==Activity.class)
			{
				Activity activity = (Activity) tmp;
				
				//check if the activity has a participant, if not stop the execution.
				if (activity.getCandidateOwners().size()==0)
				{
					System.err.println("ERROR: the activity ID='"+activity.getId()+"' has no candidate performer(s) associated");
					eabpm=null;
					break;
				}
					
				
				Vector<Variable> inVarList = activity.getInVariablesList();
				Vector<Variable> outVarList = activity.getOutVariablesList();
				
				//in var
				for (int i=0; i<inVarList.size(); i++)//while (varIt.hasNext())
				{
					//if the object is already contained i'm ok, otherwise i have to serach the another variable object with the same name
					if (!variableList.contains(inVarList.get(i)))//Variable actVar= (Variable) varIt.next();
					{
						//search through all the var to search the one with the same name
						Iterator varListIt = variableList.iterator();
						while (varListIt.hasNext())
						{
							Variable variable =(Variable) varListIt.next();
							//i found the var who corresponds to the match i substitute and (i quit)
							if (variable.getName().compareToIgnoreCase(inVarList.get(i).getName())==0)
							{
								inVarList.remove(i);
								inVarList.add(i, variable);
							}
						}
					}
				}
				
				//out var
				for (int i=0; i<outVarList.size(); i++)//while (varIt.hasNext())
				{
					if (!variableList.contains(outVarList.get(i)))//Variable actVar= (Variable) varIt.next();
					{
						//search through all the var to search the one with the same name
						Iterator varListIt = variableList.iterator();
						while (varListIt.hasNext())
						{
							Variable variable =(Variable) varListIt.next();
							//i found the var who corresponds to the match i substitute and (i quit)
							if (variable.getName().compareToIgnoreCase(outVarList.get(i).getName())==0)
							{
								outVarList.remove(i);
								outVarList.add(i, variable);
							}
						}
					}
				}
			}
			
		}
		
		if (eabpm!=null)
		{
			//setup the participant in the BP
			Iterator<Participant> partIT = participantList.values().iterator();
			while (partIT.hasNext())
				eabpm.addParticipant(partIT.next());
			
			//setup the variables
			eabpm.setVariablesList(variableList);
		}
		
	}

    @SuppressWarnings("static-access")
	private static EABPM setupBPM (Node node, Object father)   
    { 
    	
		//maintain compatibility with activiti 5.9.3 and actviti 5.8
		String tagAct;
		if (ACTIVITY59)
			tagAct="";
		else
			tagAct="bpmn2:";
    	
       Object newFather=null;
       
       if (node.getNodeType() == node.ELEMENT_NODE)    
       {       
    	   //node name
           //System.out.print("<"+node.getNodeName());
           
           if (node.getNodeName().equalsIgnoreCase("definitions"))
           {
        	   //first node
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase(tagAct+"process"))
           {
        	   //keep going on
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("documentation"))
           {
        	   //keep going on
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase(tagAct+"startevent") || node.getNodeName().equalsIgnoreCase(tagAct+"endevent"))
           {
//body start event
        	   //cast father
        	   EABPM eabpm = (EABPM) father;
        	   //create new item
        	   Event event = new Event();
        	   
        	   if (node.getNodeName().equalsIgnoreCase(tagAct+"startevent"))
        		   event.setType(Event.Type.START);
        	   else
        		   event.setType(Event.Type.END);
        	   
        	   //new object (use in the recursive call)
        	   newFather=event;
        	   
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   event.setId(attr.getNodeValue());
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
        	   //add element to internal hashmap, for the ordering
               //add after, couse i need to know the valie of the ID
        	   addElement(event);
        	   //add event to eabpm
        	   eabpm.addElement(event);
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase(tagAct+"userTask") || node.getNodeName().equalsIgnoreCase(tagAct+"serviceTask") )
           {
//body User task
        	   //cast father
        	   EABPM eabpm = (EABPM) father;
        	   //create new item
        	   Activity activity = new Activity();
        	   //add event to eabpm
        	   eabpm.addElement(activity);
        	   
        	   if (node.getNodeName().equalsIgnoreCase(tagAct+"userTask"))
        		   activity.setType(Activity.Type.USER);
        	   else
        		   activity.setType(Activity.Type.SERVICE);

        	   
        	   //new object (use in the recursive call)
        	   //leaf tag
        	   newFather=activity;
        	   
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   activity.setId(attr.getNodeValue());
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("name")==0)
                   {
                	   activity.setName(attr.getNodeValue());
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("activiti:assignee")==0)
                   {
                	   Participant part = new Participant();
                	   //duplicate name unique
                	   part.setName(attr.getNodeValue());
                	   part.setId(attr.getNodeValue());
                	   
                	   part = addUniqueParticipant(part);
                	   
                	   activity.setOwner(part);
                	   
                   }
                   if (attr.getNodeName().compareToIgnoreCase("activiti:securityAnnotationType")==0)
                   {   
                	   if (attr.getNodeValue().compareToIgnoreCase("ack")==0)
                		   activity.setType(Type.ACK);
                   }
               }
               
        	   //add element to internal hash map, for the ordering
        	   //add after, because i need to know the value of the ID
        	   addElement(activity);
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("extensionElements") )
           {  
        	   //do nothing
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("activiti:field") )
           {
        	   if(father.getClass()==Activity.class)
        	   {
        		   Activity activity = (Activity) father;
        		   
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("name")==0)
	                   { 
	                	   String attrContent=attr.getNodeValue();
	                	   //if (attrContent.compareToIgnoreCase("Service Provider")==0) RequestedServiceProvider
	                	   if (attrContent.compareToIgnoreCase("RequestedServiceProvider")==0) //if it's an isa relation it can only be connected to an agent,   
	                	   {
	                		   Participant part = new Participant();
	                		   
	                		   part.setType(participantType.BPAGENT);
	                		   //activity.setOwner(part);//placeholder for next tag
	                		   activity.pushCandidateOwner(part);//added this couse at this point an activity may have 2 executors, a role and an agent, in the mapping thena, i chose which one to keep and then i set the owner attribute
	                		   newFather=part;
	                	   }
	                	   else if (attrContent.compareToIgnoreCase("RequestedServiceProviderRole")==0)
	                	   {
	                		   Participant part = new Participant();
	                		   part.setType(participantType.BPROLE);
	                		   activity.pushCandidateOwner(part);
	                		   newFather=part;
	                	   }
	                	   else if (attrContent.matches("^input[0-9]*"))
	                	   {
	        	        	   Variable variable = new Variable();
	        	        	   newFather=father;
	                		   activity.addInVariable(variable);
	                	   }
	                	   else//otherwise in an output
	                	   {
	        	        	   Variable variable = new Variable();
	        	        	   newFather=father;
	                		   activity.addOutVariable(variable);
	                	   }
	
	                   }
	               }
        	   }
           }
           //var name
           else if (node.getNodeName().equalsIgnoreCase("activiti:string") )
           {
         	  newFather=father;
        	   
           }
           else if (node.getNodeName().equalsIgnoreCase("activiti:executionListener") )
           {
        	 //do nothing
        	  newFather=father;
           }
           //user task input variable
           else if (node.getNodeName().equalsIgnoreCase("activiti:formProperty") )
           {
        	   if (father.getClass()==Activity.class)
        	   {
        		   Variable variable = new Variable();
        		   
	               NamedNodeMap startAttr = node.getAttributes();
	               for (int i = 0; i < startAttr.getLength(); i++) 
	               {   
	                   Node attr = startAttr.item(i);
	                   //node parameter
	                   if (attr.getNodeName().compareToIgnoreCase("name")==0)
	                   { 
	                	   variable.setName(attr.getNodeValue());
	                   }
	                   else if (attr.getNodeName().compareToIgnoreCase("id")==0)
	                   {
	                	   variable.setId(attr.getNodeValue());
	                   }
	                	   
	               }
	               
	               ((Activity)father).addOutVariable(variable);
	               
	               newFather=variable;
	               addUniqueVariable(variable);
        	   }

           }
           else if (node.getNodeName().equalsIgnoreCase(tagAct+"parallelGateway") || node.getNodeName().equalsIgnoreCase(tagAct+"exclusiveGateway") || node.getNodeName().equalsIgnoreCase(tagAct+"inclusiveGateway"))
           {
//body gateways
        	   //cast father
        	   EABPM eabpm = (EABPM) father;
        	   //create new item
        	   Gateway gateway = new Gateway();
        	   //add element to bp
        	   eabpm.addElement(gateway);

        	   
        	   if (node.getNodeName().equalsIgnoreCase(tagAct+"inclusiveGateway"))
        		   gateway.setType(Gateway.Type.INCLUSIVE);
    		   else if (node.getNodeName().equalsIgnoreCase(tagAct+"parallelGateway"))
    			   gateway.setType(Gateway.Type.PARALLEL);
    		   else
    			   gateway.setType(Gateway.Type.EXCLUSIVE);
        	   
        	   //new object (use in the recursive call)
        	   newFather=gateway;
        	   
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   gateway.setId(attr.getNodeValue());
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
        	   //add element to internal hashmap, for the ordering
        	   //add after, couse i need to know the valid of the ID
        	   addElement(gateway);
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase(tagAct+"sequenceFlow"))
           {
//body control flow
        	   
        	   String sourceRef="";
        	   String targetRef="";
        	   
        	   //new object (use in the recursive call)
        	   newFather=father;
        	   
               NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("sourceRef")==0)
                   {
                	   sourceRef=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("targetRef")==0)
                   {
                	   targetRef=attr.getNodeValue();
                	   //System.out.print(" "+attr.getNodeName() + "=\""+attr.getNodeValue()+"\"");
                   }
               }
               
               //bpFlow.put(sourceRef, targetRef);
               String[] tmp = new String[2];
               tmp[0]=sourceRef;
               tmp[1]=targetRef;
               bpFlow.add(tmp);
//end body
           }
           else if (node.getNodeName().equalsIgnoreCase("aniketos:security") )
           {  
        	   //do nothing
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("aniketos:trustworthiness") )
           {  
        	   Activity activity= (Activity)father;
               
        	   NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("value")==0)
                   {
                	   activity.setTrustworthiness(new Float(attr.getNodeValue()));
                   }
               }
        	   
        	   //do nothing
        	   newFather=father;
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
           
    	   //if father is an instance of class Variable
    	   //I can read the content of the tag and set the name of the variable.
    	   //this is for service task variables
    	   if (father.getClass()==Activity.class)
    	   {
    		   //delete useless character ${var} ->var
    		   //content=content.replaceAll("[ ${} \t \n \r \f ]", ""); 
    		   content=content.replaceAll("[ \t \n \r \f ]", "");
    		   
    		   if(!content.equals(""))
    		   {
    			   Activity activity = (Activity) father;
    			   
    			   //if the name ogf the variable contains a $ in means it is a input variable.
    			   if(content.contains("$"))
    			   {
    				   //split string as ${V1}~${V2} on V1, V2
	    			   Pattern pattern = Pattern.compile("[\\$\\{ \\}~\\{ \\}]");
	    			   String[] inputList = pattern.split(content);
	    			  	    			   
    				   Vector<Variable> varList = activity.getInVariablesList();
    				   Iterator<Variable> varListIT = varList.iterator();
    				   
    				   //search for the first available variable name
    				   int nextVar=0;
    				   for(int i=0; i<inputList.length; i++)
	    			   {
	    				   String input = inputList[i];
	    				   if (input.length()<=0)
	    					   nextVar++;
	    				   else
	    					   break;
	    			   }
    				   
    				   //search in the list of the variable of the activity, the only one which does not have a name (the one insertet in the tag just above))
    				   while (varListIT.hasNext())
    				   {
    					 Variable var = varListIT.next();
    					 if (var.getId()==null)
    					 {
    						 var.setId(inputList[nextVar]);
    						 var.setName(inputList[nextVar]);
    						 addUniqueVariable(var);
    						 break;
    					 }
    				   }
	    			   
    				   //incremant the variable, otherwise i'll examine twice the same var name
    				   nextVar++;
    				   
    				   
    				   //for all the other var name, i creates new variables and i insert them in the list of input var. 
	    			   for(int i=nextVar; i<inputList.length; i++)
	    			   {
	    				   String input = inputList[i];
	    				   if (input.length()>0)
	    				   {
	    					   Variable var = new Variable();
	    					   var.setId(input);
	    					   var.setName(input);
	    					   activity.addInVariable(var);
	    					   addUniqueVariable(var);
	    				   }
	    			   }
    				   
    			   }
    			   else
    			   {
    				   Vector<Variable> varList = activity.getOutVariablesList();
    				   
        			   Variable variable = varList.get(0);//only one output variable for every service tasks
        			   variable.setName(content);
        			   variable.setId(content);
        			   //System.out.println("Var name: "+ content);
        			   addUniqueVariable(variable);
    				   
    			   }
    			   

    		   }
    	   }
    	   //set up participant in case of service tasks
    	   if (father.getClass()==Participant.class)
    	   {
    		   Participant part = (Participant) father;
    		   
    		   content=content.replaceAll("[ ${} \t \n \r \f ]", "");
    		   
    		   if (content.length()!=0)
    		   {
	        	   
	        	   //duplicate name unique
	        	   part.setName(content);
	        	   part.setId(content);
	        	   
	        	   part = addUniqueParticipant(part);//i can add participants that will not be used next, the purpose of this list is to avoid duplicatons
	        	   
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
            setupBPM(child,newFather);   
        }   
           
        //if the XML is well formed, once i have parsed all the child i have to meet the close tag
        if (node.getNodeType() == node.ELEMENT_NODE)    
        {     
        	//do nothing
        	//but i have to read it in order to go on
            //System.out.print("</"+node.getNodeName()+">");   
        }

        //end of the recursion?
        if (father.getClass()==EABPM.class)
        	return (EABPM) father;
        else
        	return null;
    }

//EABPM getters and setters
	/**Getters of the instantiated Business Process data structure
	 * @return the instantiated data structure
	 */
	public EABPM getEabpm() {
		return eabpm;
	}

	/**Setter of the instantiated Business Process  data structure
	 * @param eabpm the instantiated data structure
	 */
	public void setEabpm(EABPM eabpm) {
		this.eabpm = eabpm;
	}

//participant getters and setters
	/**Getter of the participants list
	 * @return the participant list
	 */
	public static HashMap<String, Participant> getParticipantList() {
		return participantList;
	}

	/**This function adds a participant to the participants list
	 * @param participant the participant that have to be added to the list
	 */
	public static void addParticipant(Participant participant) {
		ParseSecureBPMNDom.participantList.put(participant.getName(), participant);
	}
	
	/**This function removes a given participant from the participant list
	 * @param participant the participant that have to be removed
	 */
	public static void removeParticipant(Participant participant) {
		ParseSecureBPMNDom.participantList.remove(participant);
	}
	
	/**This function adds a given element only if there is no other element in the participant list with the same name.
	 * @param participant the participant that have to be added
	 * @return the same object received in input, if the is no participant, or the participant object in the list with the same name
	 */
	public static Participant addUniqueParticipant(Participant participant) 
	{
		
		if (participantList.containsKey(participant.getName()))
			return participantList.get(participant.getName());
		else
		{
			participantList.put(participant.getName(), participant);
			return participant;
		}
	}

//elements getters and setters
	/**Getter of the element list
	 * @return the list of the elements
	 */
	public static HashMap<String, Element> getElementList() {
		return elementList;
	}

	/**This function adds an element to the participants list
	 * @param element the element that have to be added to the list
	 */
	public static void addElement(Element element) {
		ParseSecureBPMNDom.elementList.put(element.getId(),element);
	}
	
	/**This function removes a given element from the participant list
	 * @param element the element that have to be removed
	 */
	public static void removeElement(Element element) {
		ParseSecureBPMNDom.elementList.remove(element);
	}

//variable getters and setters
	/**Getter of the variable list
	 * @return the list of all the variables
	 */
	public static Vector<Variable> getVariableList() {
		return variableList;
	}

	/**This function adds a variable to the participants list
	 * @param variable the variable that have to be added to the list
	 */
	public static void addVariable(Variable variable) {
		ParseSecureBPMNDom.variableList.add(variable);
	}

	/**This function removes a given variable from the participant list 
	 * @param variable the variable that have to be removed
	 */
	public static void removeVariable(Variable variable) {
		ParseSecureBPMNDom.variableList.remove(variable);
	}
	
	//the key is name+id 
	/**This function adds a given variable only if there is no other variable in the variable list with the same name and id.
	 * @param variable the variable that have to be added
	 * @return the same object received in input, if the is no variable with the same id and name, or the variable object in the list with the same name
	 */
	public static Variable addUniqueVariable(Variable variable) 
	{
		//i have to search through all the variable, i cannot use "contains" method because i have to compare the names
		
		Iterator<Variable> varIT = variableList.iterator();
		while (varIT.hasNext())
		{
			Variable varComp = varIT.next();
			if (variable.getName().compareToIgnoreCase(varComp.getName())==0)
			{
				return varComp;
			}
		}
		
		variableList.add(variable);
		return variable;
		
	}
}
