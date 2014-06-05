/*
* SRCM.java
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
package eu.aniketos.srcm;

import java.awt.color.CMMException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.activiti.Activiti;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.functional.ParseActivitiDom;
import eu.aniketos.srcm.functional.ParseSecureBPMNDom;
import eu.aniketos.srcm.functional.ParseMappingDom;
import eu.aniketos.srcm.functional.ParseSRSDom;
import eu.aniketos.srcm.functional.VerifyAlignment;
import eu.aniketos.srcm.interfaces.ICompliance;
import eu.aniketos.srcm.mapping.Mapping;




/**Main class of the SRCM module, it manages the XML document received in input and generates the output XML document 
 * @author Mattia Salnitri
 *
 */
public class SRCM implements ICompliance
{
	private Document SecureBPMN;
	private Document domMapping;
	private Document domSRS;
	private Document domActiviti;



	/** Function which calls the parsers for every XML documents and return the compliance results status as another XML document 
	 * @return XML document
	 */
	@Override
	public String getComplianceStatus(String xmlSRS, String xmlMapping, String xmlSecureBPMN, String xmlActiviti) 
	{
		
		if (xmlSecureBPMN==null)
		{
			System.err.println("Error: SecureBPMN input required is missing");
			return "Error: SecureBPMN input required is missing";
		}
		else
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
		    
			try 
			{
				builder = factory.newDocumentBuilder();
			    InputSource is = new InputSource(new StringReader(xmlSecureBPMN));
				try 
				{
					this.SecureBPMN=builder.parse(is);
					if (this.SecureBPMN==null)
						return "Error in creating dom structure of SecureBPMN input";
				} 
				catch (SAXException e) 
				{
					System.err.println("ERROR in creating dom structure of SecureBPMN input");
					return "ERROR in creating dom structure of SecureBPMN input";
					//e.printStackTrace();
				} 
				catch (IOException e) 
				{
					System.err.println("ERROR in creating dom structure of SecureBPMN input");
					return "ERROR in creating dom structure of SecureBPMN input";
					//e.printStackTrace();
				}
				
			} 
			catch (ParserConfigurationException e) 
			{
				System.err.println("ERROR in creating dom structure of SecureBPMN input");
				return "ERROR in creating dom structure of SecureBPMN input";
				//e.printStackTrace();
			}
			
		}
		
		if (xmlMapping==null)
		{
			System.err.println("Error: Mapping input required is missing");
			return "Error: Mapping input required is missing";
		}
		else
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
		    
			try 
			{
				builder = factory.newDocumentBuilder();
			    InputSource is = new InputSource(new StringReader(xmlMapping));
				try 
				{
					this.domMapping=builder.parse(is);
					if (this.domMapping==null)
						return "Error in creating dom structure of Mapping input";
				} 
				catch (SAXException e) 
				{
					System.err.println("ERROR in creating dom structure of mapping input");
					return "ERROR in creating dom structure of mapping input";
					//e.printStackTrace();
				} 
				catch (IOException e) 
				{
					System.err.println("ERROR in creating dom structure of mapping input");
					return "ERROR in creating dom structure of mapping input";
					//e.printStackTrace();
				}
				
			} 
			catch (ParserConfigurationException e) 
			{
				System.err.println("ERROR in creating dom structure of mapping input");
				return "ERROR in creating dom structure of mapping input";
				//e.printStackTrace();
			}
		}
		
		if (xmlSRS==null)
		{
			System.err.println("Error: SRS input required is missing");
			return "Error: SRS input required is missing";
		}
		else
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
		    
			try 
			{
				builder = factory.newDocumentBuilder();
			    InputSource is = new InputSource(new StringReader(xmlSRS));
				try 
				{
					this.domSRS=builder.parse(is);
					if (this.domSRS==null)
						return "Error in creating dom structure of SRS input";
				} 
				catch (SAXException e) 
				{
					System.err.println("ERROR in creating dom structure of SRS input");
					return "ERROR in creating dom structure of SRS input";
					//e.printStackTrace();
				} 
				catch (IOException e) 
				{
					System.err.println("ERROR in creating dom structure of SRS input");
					return "ERROR in creating dom structure of SRS input";
					//e.printStackTrace();
				}
				
			} 
			catch (ParserConfigurationException e) 
			{
				System.err.println("ERROR in creating dom structure of SRS input");
				return "ERROR in creating dom structure of SRS input";
				//e.printStackTrace();
			}
		}
		
		if (xmlActiviti==null)
		{
			System.err.println("Error: Activiti input required is missing");
			return "Error: Activiti input required is missing";
		}
		else
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder;
		    
			try 
			{
				builder = factory.newDocumentBuilder();
			    InputSource is = new InputSource(new StringReader(xmlActiviti));
				try 
				{
					this.domActiviti=builder.parse(is);
					if (this.domActiviti==null)
						return "Error in creating dom structure of Activiti input";
				} 
				catch (SAXException e) 
				{
					System.err.println("ERROR in creating dom structure of Activiti input");
					return "ERROR in creating dom structure of Activiti input";
					//e.printStackTrace();
				} 
				catch (IOException e) 
				{
					System.err.println("ERROR in creating dom structure of Activiti input");
					return "ERROR in creating dom structure of Activiti input";
					//e.printStackTrace();
				}
				
			} 
			catch (ParserConfigurationException e) 
			{
				System.err.println("ERROR in creating dom structure of Activiti input");
				return "ERROR in creating dom structure of Activiti input";
				//e.printStackTrace();
			}
		}
		
		//parse the .activiti file
		ParseActivitiDom parseActivitiDom = new ParseActivitiDom(domActiviti);
		Activiti activiti = parseActivitiDom.getActiviti();
		//if it's null, some problems occurred during the parsing
		if (activiti==null)
			return "ERROR in parsing Activiti input";
		
		//parse srs class structure
		ParseSRSDom parseSRSDom = new ParseSRSDom(this.domSRS);
		SRS srs = parseSRSDom.getSrs();
		//if it's null, some problems occurred during the parsing
		if (srs==null)
			return "ERROR in parsing SRS input";	
		
		//clean up srs with unsupported commitments
		removeCommitmentsNotSupported(srs);

		
		//instantiate BPM class structure
		ParseSecureBPMNDom parseBPMDom = new ParseSecureBPMNDom(this.SecureBPMN);
		EABPM eabpm = parseBPMDom.getEabpm();
		//if eabpmn is null some problem occurs during the parsing
		if (eabpm==null)
			return "ERROR in parsing SRCM input";

		//instantiate the mapping vector
		ParseMappingDom parseMappingDom = new ParseMappingDom(
				this.domMapping, ParseSecureBPMNDom.getParticipantList(), 
				parseSRSDom.getRoleList(), 
				parseSRSDom.getAgentList(), 
				parseSRSDom.getGoalList(), 
				ParseSecureBPMNDom.getElementList(), 
				parseSRSDom.getDocumentList(), 
				ParseSecureBPMNDom.getVariableList());
		
		//if it's null, some problems occurred during the parsing
		if (parseMappingDom==null)
			return "ERROR in parsing Mapping input";
		
		Mapping mapping = parseMappingDom.getMapping();
		
		//check alignment
		VerifyAlignment verifyAlignment = new VerifyAlignment(srs, this.domSRS,mapping, eabpm, activiti);
		
		return verifyAlignment.checkAlignment();
	}	
	
	private void printDom(Document doc) throws TransformerException
	{
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		//initialize StreamResult with File object to save to file
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);
		transformer.transform(source, result);
		String xmlString = result.getWriter().toString();
		System.out.println(xmlString);
	}


	/** Getter for the BPM XML document 
	 * @return domBPM a XML document
	 */
	public Document getDomBPM() {
		return SecureBPMN;
	}


	/** Setter for the BPM XML document
	 * @param domBPM a XML document
	 */
	public void setDomBPM(Document domBPM) {
		this.SecureBPMN = domBPM;
	}


	/** Getter for the Mapping XML document
	 * @return domMapping a XML document
	 */
	public Document getDomMapping() {
		return domMapping;
	}


	/** Setter for the Mapping XML document
	 * @param domMapping a XML document
	 */
	public void setDomMapping(Document domMapping) {
		this.domMapping = domMapping;
	}


	/** Getter for the SRS XML document
	 * @return domSRS a XML document
	 */
	public Document getDomSRS() {
		return domSRS;
	}


	/** Setter for the SRS XML document
	 * @param domSRS a XML document 
	 */
	public void setDomSRS(Document domSRS) {
		this.domSRS = domSRS;
	}

	private void removeCommitmentsNotSupported(SRS srs)
	{
		//cloned, so i cane work on the commitment list, then i copy the updated list
		Vector<Commitment> commList = (Vector<Commitment>) srs.getCommitmentList().clone();
		
		Iterator<Commitment> i = commList.iterator();
		//for all commitments
		while(i.hasNext())
		{
			Commitment commitment = i.next();
		
			if (commitment.getPostCondition()==null)
			{
				i.remove();
				System.out.println("WARNING: Skipped check of commitment " + commitment.getId() + ", type of commitment not supported");
			}
		}
		
		//update srs with the new list
		srs.setCommitmentList(commList);
		
	}
	

}
