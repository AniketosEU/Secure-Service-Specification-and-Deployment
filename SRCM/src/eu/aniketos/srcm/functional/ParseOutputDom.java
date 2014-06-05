/*
* ParseOutputDom.java
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

import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.Goal;
import eu.aniketos.srcm.SRS.Information;
import eu.aniketos.srcm.SRS.NonDisclosure;
import eu.aniketos.srcm.SRS.NonModification;
import eu.aniketos.srcm.SRS.NonProduction;
import eu.aniketos.srcm.SRS.NonRepudiation;
import eu.aniketos.srcm.SRS.NonUsage;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.SRS.Trustworthiness;

/**This class parses the list of commitments processed by the verification algorithms and creates the XML document containing the results information of the SRCM  
 * @author Mattia Salnitri
 *
 */
public class ParseOutputDom 
{ 
 
	/**Constructor of the class
	 * @param domSRS the srs document
	 * @param satCommitmentList the list of the commitments satisfied by the BPM
	 * @param unsatCommitmentList the list of the commitments unsatisfied by the BPM
	 * @param undecCommitmentList the list of the commitments for which is impossible to understand whether they are satisfied by the BPM or not.
	 * @return
	 */
	public String createDom(Document domSRS, HashSet<Commitment> satCommitmentList, HashSet<Commitment> unsatCommitmentList, HashSet<Commitment> undecCommitmentList) 
	{
		
		//parse(again) srs class structure
		ParseSRSDom parseSRSDom = new ParseSRSDom(domSRS);
		SRS srs = parseSRSDom.getSrs();
		
		//filters out duplicates
		HashSet<Commitment>[] results = filter(satCommitmentList, unsatCommitmentList, undecCommitmentList);
		//update lists
		satCommitmentList=results[0];
		unsatCommitmentList=results[1];
		undecCommitmentList=results[2];
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("output");
		doc.appendChild(rootElement);
		
		// set attribute to root element
		Attr attr = doc.createAttribute("xmlns:xsi");
		attr.setValue("http://www.w3.org/2001/XMLSchema-instance");
		rootElement.setAttributeNode(attr);
		
		attr = doc.createAttribute("xsi:noNamespaceSchemaLocation");
		attr.setValue("output.xsd");
		rootElement.setAttributeNode(attr);
		
		
		// sat element
		if (satCommitmentList.size()>0)
		{
			Element sat = doc.createElement("sat");
			rootElement.appendChild(sat);
			
			Iterator<Commitment> satIt = satCommitmentList.iterator();
			while (satIt.hasNext())
			{
				Commitment satCommitment = satIt.next();
				// sat commitments
				Element satComm = doc.createElement("commitment");
				sat.appendChild(satComm);
				satComm.setAttribute("name", satCommitment.getId());
				
				addInfo(satCommitment, satComm, doc, srs.getCommitmentList());
			}
		}
		
		// unsat element
		if (unsatCommitmentList.size()>0)
		{
			// unsat element
			Element unsat = doc.createElement("unsat");
			rootElement.appendChild(unsat);
			
			Iterator<Commitment> unsatIt = unsatCommitmentList.iterator();
			while (unsatIt.hasNext())
			{
				Commitment unsatCommitment = unsatIt.next();
		 
				// unsat commitments
				Element unsatComm = doc.createElement("commitment");
				unsat.appendChild(unsatComm);
				unsatComm.setAttribute("name", unsatCommitment.getId());
				addInfo(unsatCommitment, unsatComm, doc, srs.getCommitmentList());
			}
		}

		if (undecCommitmentList.size()>0)
		{
			// undec element
			Element undec = doc.createElement("undec");
			rootElement.appendChild(undec);
			
			Iterator<Commitment> undecIt = undecCommitmentList.iterator();
			while (undecIt.hasNext())
			{
				Commitment undecCommitment = undecIt.next();
		 
				// sat commitments
				Element undecComm = doc.createElement("commitment");
				undec.appendChild(undecComm);
				undecComm.setAttribute("name", undecCommitment.getId());
				addInfo(undecCommitment, undecComm, doc, srs.getCommitmentList());
			}
		}
		
 
		//trasform the xml Document in string
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		String output; 
		try 
		{
			transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			//transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			try 
			{
				transformer.transform(new DOMSource(doc), new StreamResult(writer));
			} 
			catch (TransformerException e) 
			{
				System.err.println("Error in trasforming output XML document in String");
				return null;
				//e.printStackTrace();
			}
			output = writer.getBuffer().toString();//.replaceAll("\n|\r", "");
		} 
		catch (TransformerConfigurationException e) 
		{
			System.err.println("Error in trasforming output XML document in String");
			return null;
			//e.printStackTrace();
		}

		
		/*write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		//StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
		// Output to console for testing
		 StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);*/
 
		return output;
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } /*catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }*/
	  
	  return null;
	}
	
	
	//add tags with information about the commitments
	private void addInfo(Commitment commitment, Element element, Document doc, Vector<Commitment> or_commitment)
	{
		
		//Element performer = doc.createElement("performer");
		//element.appendChild(performer);
		//performer.setTextContent(commitment.getDebtor().getName().toString());
		
		if (commitment.getPostCondition().getClass()==Trustworthiness.class)
		{
			Trustworthiness trustworthiness= (Trustworthiness) commitment.getPostCondition();
			element.setAttribute("type", "Trustworthiness");
			
			//original target tag
			Element originalTarget = doc.createElement("originalTarget");
			element.appendChild(originalTarget);
			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//for all all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					//cast original postcondition
					Trustworthiness or_trustworthiness= (Trustworthiness) or_com.getPostCondition();
					//retrieve original target
					originalTarget.setTextContent(or_trustworthiness.getGoal().getName());
				}
			}

			
			//target tag
			Element commTarget= doc.createElement("target");
			element.appendChild(commTarget);
			commTarget.setTextContent(trustworthiness.getGoal().getName());
		}
		else if (commitment.getPostCondition().getClass()==NonDisclosure.class)
		{
			NonDisclosure nonDisclosure = (NonDisclosure) commitment.getPostCondition();
			element.setAttribute("type", "NonDisclosure");
			
			//original target tag

			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//for all all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					NonDisclosure or_NonDisclosure = (NonDisclosure)or_com.getPostCondition();
					Vector<Information> infoList = or_NonDisclosure.getInformationList();
					Iterator<Information> i = infoList.iterator();
					while (i.hasNext())
					{
						Element originalTarget = doc.createElement("originalTarget");
						element.appendChild(originalTarget);
						Information information = i.next();
						originalTarget.setTextContent(information.getName());
						
					}
				}
			}
			
			//target tag

			//for all information
			Vector<Information> infoList = nonDisclosure.getInformationList();
			Iterator<Information> i = infoList.iterator();
			while (i.hasNext())
			{
				
				Element commTarget= doc.createElement("target");
				element.appendChild(commTarget);
				Information information = i.next();
				commTarget.setTextContent(information.getName());
				
			}

		}
		else if (commitment.getPostCondition().getClass()==NonModification.class)
		{
			NonModification nonModification = (NonModification) commitment.getPostCondition();
			element.setAttribute("type", "NonModification");
			
			//original target tag

			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//for all all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					NonModification or_NonModification = (NonModification)or_com.getPostCondition();
					Vector<Information> infoList = or_NonModification.getInformationList();
					Iterator<Information> i = infoList.iterator();
					while (i.hasNext())
					{
						Element originalTarget = doc.createElement("originalTarget");
						element.appendChild(originalTarget);
						Information information = i.next();
						originalTarget.setTextContent(information.getName());
						
					}
				}
			}

			
			//target tag
			
			//for all information
			Vector<Information> infoList = nonModification.getInformationList();
			Iterator<Information> i = infoList.iterator();
			while (i.hasNext())
			{
				
				Element commTarget= doc.createElement("target");
				element.appendChild(commTarget);
				Information information = i.next();
				commTarget.setTextContent(information.getName());
				
			}
		}
		else if (commitment.getPostCondition().getClass()==NonProduction.class)
		{
			NonProduction nonProduction = (NonProduction) commitment.getPostCondition();
			element.setAttribute("type", "NonProduction");
			
			//original target tag

			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//for all all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					NonProduction or_NonProduction = (NonProduction)or_com.getPostCondition();
					Vector<Information> infoList = or_NonProduction.getInformationList();
					Iterator<Information> i = infoList.iterator();
					while (i.hasNext())
					{
						Element originalTarget = doc.createElement("originalTarget");
						element.appendChild(originalTarget);
						Information information = i.next();
						originalTarget.setTextContent(information.getName());
						
					}
				}
			}

			
			//target tag
			
			//for all information
			Vector<Information> infoList = nonProduction.getInformationList();
			Iterator<Information> i = infoList.iterator();
			while (i.hasNext())
			{
				
				Element commTarget= doc.createElement("target");
				element.appendChild(commTarget);
				Information information = i.next();
				commTarget.setTextContent(information.getName());
				
			}
		}
		else if (commitment.getPostCondition().getClass()==NonUsage.class)
		{
			NonUsage nonUsage = (NonUsage) commitment.getPostCondition();
			element.setAttribute("type", "NonUsage");

			//original target tag

			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//for all all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					NonUsage or_NonUsage = (NonUsage)or_com.getPostCondition();
					Vector<Information> infoList = or_NonUsage.getInformationList();
					Iterator<Information> i = infoList.iterator();
					while (i.hasNext())
					{
						Element originalTarget = doc.createElement("originalTarget");
						element.appendChild(originalTarget);
						Information information = i.next();
						originalTarget.setTextContent(information.getName());
						
					}
				}
			}

			
			//target tag
			
			//for all information
			Vector<Information> infoList = nonUsage.getInformationList();
			Iterator<Information> i = infoList.iterator();
			while (i.hasNext())
			{
				
				Element commTarget= doc.createElement("target");
				element.appendChild(commTarget);
				Information information = i.next();
				commTarget.setTextContent(information.getName());
				
			}
		}
		else if (commitment.getPostCondition().getClass()==NonRepudiation.class)
		{
			NonRepudiation nonRepudiation = (NonRepudiation) commitment.getPostCondition();
			element.setAttribute("type", "NonRepudiation");
			
			//original target tag
			//retrieve the original commitment
			Iterator<Commitment> it = or_commitment.iterator();
			//scall all original commitments
			while (it.hasNext())
			{
				Commitment or_com = it.next();
				if (or_com.getId().compareTo(commitment.getId())==0)
				{
					//cast original postcondition
					NonRepudiation or_NonRepudiation= (NonRepudiation) or_com.getPostCondition();
					//retrieve original target
					Vector<Goal> goalList = or_NonRepudiation.getGoalList();
					Iterator<Goal> it_g = goalList.iterator();
					while(it_g.hasNext())
					{
						Goal goal = it_g.next();
						
						Element originalTarget = doc.createElement("originalTarget");
						element.appendChild(originalTarget);
						originalTarget.setNodeValue(goal.getName());
					}
					
					
					
				}
			}

			
			//target tag
			
			Element commTarget= doc.createElement("target");
			element.appendChild(commTarget);
			Goal goal = nonRepudiation.getGoalList().firstElement();
			commTarget.setTextContent(goal.getName());
		}		
	}
	
	
	//remove commitments that seems duplicate for the output ( the output does not print the creditor)
	//and
	//check if sat list contains commitment of unsat, i don't want to print in sat commitments some unsat commitment.
	//in the list of sat commitments there could be commitment that can be confused 
	//with the ones printed in sat, because the output does not print 
	private HashSet<Commitment>[] filter(HashSet<Commitment> satCommitmentList, HashSet<Commitment> unsatCommitmentList, HashSet<Commitment> undecCommitmentList)
	{
		//i clone the list commitment because i need to operate on the list
		//clone is safe here, i just need a duplicate of the list
		HashSet<Commitment> clonedSatCommitmentList=(HashSet<Commitment>) satCommitmentList.clone();
		HashSet<Commitment> clonedUnsatCommitmentList=(HashSet<Commitment>) unsatCommitmentList.clone(); 
		HashSet<Commitment> clonedUndecCommitmentList=(HashSet<Commitment>) undecCommitmentList.clone();
		
		
		//the order is important, first i check unsat, then undec and then sat!
		
		//list of commitment id
		Vector<String> commName = new Vector<String>();
		
		//remove duplicates unsat
		Iterator<Commitment> i = unsatCommitmentList.iterator();
		while (i.hasNext())
		{
			Commitment commitment = i.next();
			if (!commName.contains(commitment.getId()))//if is not duplicated i add it and i keep it
			{
				commName.add(commitment.getId());
			}
			else
			{
				clonedUnsatCommitmentList.remove(commitment);
			}
		}
		
		//remove duplicates undec
		i = undecCommitmentList.iterator();
		while (i.hasNext())
		{
			Commitment commitment = i.next();
			if (!commName.contains(commitment.getId()))
			{
				commName.add(commitment.getId());
			}
			else
			{
				clonedUndecCommitmentList.remove(commitment);
			}
		}
		
		//remove duplicates sat
		i = satCommitmentList.iterator();
		while (i.hasNext())
		{
			Commitment commitment = i.next();
			if (!commName.contains(commitment.getId()))
			{
				commName.add(commitment.getId());
			}
			else
			{
				clonedSatCommitmentList.remove(commitment);
			}
		}
		
		HashSet<Commitment>[] results = new HashSet[3];
		results[0]=clonedSatCommitmentList;
		results[1]=clonedUnsatCommitmentList;
		results[2]=clonedUndecCommitmentList;
		
		return results;

	}
	
}
