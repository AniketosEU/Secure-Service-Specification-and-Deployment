/**
 * 
 */
package eu.aniketos.srcm.functional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import eu.aniketos.activiti.Activiti;
import eu.aniketos.activiti.ActivitiNeedToKnow;
import eu.aniketos.activiti.ActivitiRole;


/**
 * @author mattia
 *
 */
public class ParseActivitiDom 
{
	private Activiti activiti;
	
	private static HashMap <String, ActivitiNeedToKnow> permissions = new HashMap<String, ActivitiNeedToKnow>();
	private static HashMap <String, ActivitiRole> roles = new HashMap<String, ActivitiRole>();
	
	
	/**this class part the activiti XML files
	 * @param activitiDom the document that contain the XML file
	 */
	public ParseActivitiDom(Document activitiDom)
	{
		activiti = new Activiti();
		setupActiviti(activitiDom, activiti);
		
		
		//setup the pointers using IDs
	    Iterator <Entry<String, ActivitiNeedToKnow>> it = permissions.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	        Map.Entry <String, ActivitiNeedToKnow> pairs = (Entry<String, ActivitiNeedToKnow>)it.next();
	        
	        ActivitiNeedToKnow activitiNeedToKnow = pairs.getValue();
	        
	        ActivitiRole activitiRole= roles.get(activitiNeedToKnow.getActivitiRoleID());
	        
	        //setup the pointers
	        activitiNeedToKnow.setActivitiRole(activitiRole);
	        activitiRole.addPermissions(activitiNeedToKnow);
	        
	    }
	    
	    activiti.setPermissions(permissions);
		activiti.setRoles(roles);
	}
	
	private static Activiti setupActiviti (Node node, Object father)   
    { 

    	
       Object newFather=null;
       
       if (node.getNodeType() == node.ELEMENT_NODE)    
       {       
           
           if (node.getNodeName().equalsIgnoreCase("securebpmn2:Role"))
           {
        	   ActivitiRole activitiRole = new ActivitiRole();

        	   //inspects attributes
        	   NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   activitiRole.setId(attr.getNodeValue());
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("name")==0)
                   {
                	   activitiRole.setName(attr.getNodeValue());
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("permissions")==0)
                   {
                	   activitiRole.setPermissionsID(attr.getNodeValue());
                   }
               }
        	   
               roles.put(activitiRole.getId(), activitiRole);
               
        	   //first node
        	   //new object (use in the recursive call)
        	   newFather=father;
           }
           else if (node.getNodeName().equalsIgnoreCase("securebpmn2:NeedToKnow"))
           {
        	   ActivitiNeedToKnow activitiNeedToKnow = new ActivitiNeedToKnow();
        	   
        	   //inspects attributes
        	   NamedNodeMap startAttr = node.getAttributes();
               for (int i = 0; i < startAttr.getLength(); i++) 
               {   
                   Node attr = startAttr.item(i);
                   //node parameter
                   if (attr.getNodeName().compareToIgnoreCase("id")==0)
                   {
                	   activitiNeedToKnow.setId(attr.getNodeValue());
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("roles")==0)
                   {
                	   activitiNeedToKnow.setActivitiRoleID(attr.getNodeValue());
                   }
                   else if (attr.getNodeName().compareToIgnoreCase("pName")==0)
                   {
    				   //split string as ${V1}~${V2} on V1, V2
	    			   Pattern pattern = Pattern.compile("[-]");
	    			   String[] inputList = pattern.split(attr.getNodeValue());
    				   
	    			   activitiNeedToKnow.setVariable(inputList[2]);
	    			   
	    			   activitiNeedToKnow.setTaskID(inputList[1]);
	    			   
	    			   if (inputList[3].compareToIgnoreCase("Read")==0)
	    			   {
	    				   activitiNeedToKnow.setPermission(ActivitiNeedToKnow.Permission.READ);
	    			   }
	    			   else if (inputList[3].compareToIgnoreCase("Write")==0)
	    			   {
	    				   activitiNeedToKnow.setPermission(ActivitiNeedToKnow.Permission.WRITE);
	    			   }
	    			   else
	    			   {
	    				   activitiNeedToKnow.setPermission(ActivitiNeedToKnow.Permission.READ_WRITE);
	    			   }

                   }
               }
               
               permissions.put(activitiNeedToKnow.getId(), activitiNeedToKnow);
        	   
        	   //keep going on
        	   //new object (use in the recursive call)
        	   newFather=father;
           }

       }
//*****
//if the child is a piece of text, it means is the name of the father
//*****
       else if (node.getNodeType() == node.TEXT_NODE)  
       {    	   
    	   String content= node.getNodeValue();
       }   
         
       //for each the child recall the functions
       //it works because the text node has no children
       //placed here in order to avoid code duplication
       
       //this have to be done since the text element is always checked, even if in the xml there is no element text
       if (newFather==null)
    	   newFather=father;
       
        for (Node child = node.getFirstChild();    
            child != null;   
            child = child.getNextSibling())   
        {   
        	//if there will be any child, this will be done only after the element node
            setupActiviti(child,newFather);   
        }   
           
        //if the XML is well formed, once i have parsed all the child i have to meet the close tag
        if (node.getNodeType() == node.ELEMENT_NODE)    
        {     
        	//do nothing
        	//but i have to read it in order to go on
            //System.out.print("</"+node.getNodeName()+">");   
        }

        //end of the recursion?
        if (father.getClass()==Activiti.class)
        	return (Activiti) father;
        else
        	return null;
    }


	/**
	 * @return the activiti
	 */
	public Activiti getActiviti() {
		return activiti;
	}
	
	/**
	 * @param activiti the activiti to set
	 */
	public void setActiviti(Activiti activiti) {
		this.activiti = activiti;
	}


}
