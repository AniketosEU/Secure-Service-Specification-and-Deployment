/*
* OperationInst.java
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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import eu.aniketos.SecureBPMN.Variable;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.Information;
import eu.aniketos.srcm.SRS.NonDisclosure;
import eu.aniketos.srcm.SRS.NonModification;
import eu.aniketos.srcm.SRS.NonProduction;
import eu.aniketos.srcm.SRS.NonUsage;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.SRS.TangibleBy;
import eu.aniketos.srcm.mapping.Mapping;
import eu.aniketos.srcm.mapping.Represents;

/**This class manages the authorization operation instantiation algorithms
 * @author Mattia Salnitri
 *
 */
public class OperationInst {
	
	/**This methods instantiate all the authorization commitments (non usage, non disclosure, non production and non modification)
	 * @param commitment the non disclosure commitment that has to be instantiated
	 * @param srs the security requirement specification, used for the relation contained in knowledge base
	 * @param mapping the mapping between STS-ml elements and secureBPMN elements 
	 * @param undecCommitmentList list of undecidable commitments
	 */
	public static void instatiateCommitment(Commitment commitment, SRS srs, Mapping mapping, HashSet<Commitment> undecCommitmentList)
	{
		Vector<Information> infoList=null;
		
		NonDisclosure nonDisclosure=null;
		NonModification nonModification=null;
		NonUsage nonUsage=null;
		NonProduction nonProduction=null;

		//due to duplication of commitment if one actor is mapped to more than one participant, the condition and the post condition objects pointer are duplicated
		//thus one modification on a post condition in a commitment, affects all the other duplicated commitments.
		//this is an optimization because avoid to iterate through all duplicated commitment, but only for the original commitments.
		//here i check if the post condition is already instantiated, in this case i skip everything
		//and
		//check which type of operation manages information
		if (commitment.getPostCondition().getClass()==NonDisclosure.class)
		{
			nonDisclosure = (NonDisclosure) commitment.getPostCondition();
			if(nonDisclosure.getInformationList().firstElement().getClass()==Variable.class)
				return;
			
			infoList = nonDisclosure.getInformationList();
		}
		if (commitment.getPostCondition().getClass()==NonModification.class)
		{
			nonModification= (NonModification) commitment.getPostCondition();
			if(nonModification.getInformationList().firstElement().getClass()==Variable.class)
				return;
			
			infoList = nonModification.getInformationList();
		}
		
		if (commitment.getPostCondition().getClass()==NonUsage.class)
		{
			nonUsage = (NonUsage) commitment.getPostCondition();
			if(nonUsage.getInformationList().firstElement().getClass()==Variable.class)
				return;
			
			infoList = nonUsage.getInformationList();
		}
		
		if (commitment.getPostCondition().getClass()==NonProduction.class)
		{
			nonProduction= (NonProduction) commitment.getPostCondition();
			if(nonProduction.getInformationList().firstElement().getClass()==Variable.class)
				return;
			
			infoList = nonProduction.getInformationList();
		}		
				

		
		HashSet<eu.aniketos.srcm.SRS.Document> DocuSet = new HashSet<eu.aniketos.srcm.SRS.Document>();
		
		//for all the information
		Iterator<Information> infoListIT= infoList.iterator();
		while(infoListIT.hasNext())
		{
			Information info = infoListIT.next();
			
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

		//now it's possible to instantiate the commitment
		if (varList.size()==0)
		{
			//if there are no variables correspondent to the information specified in the commitment
			undecCommitmentList.add(commitment);
			srs.getCommitmentList().remove(commitment);
			
		}
		else if (varList.size()>=1) //if there are one ore more variables i simply substitute the post condition
		{
			//take care of all types of operation
			if (nonDisclosure!=null)
				nonDisclosure.setInformationList(new Vector<Information>());
			else if (nonUsage!=null)
				nonUsage.setInformationList(new Vector<Information>());
			else if (nonProduction!=null)
				nonProduction.setInformationList(new Vector<Information>());
			else if (nonModification!=null)
				nonModification.setInformationList(new Vector<Information>());
			
			Iterator<Variable> varIT = varList.iterator();
			while (varIT.hasNext())
			{
				if (nonDisclosure!=null)
					nonDisclosure.addInformation(varIT.next());
				else if (nonUsage!=null)
					nonUsage.addInformation(varIT.next());
				else if (nonProduction!=null)
					nonProduction.addInformation(varIT.next());
				else if (nonModification!=null)
					nonModification.addInformation(varIT.next());
			}
				
		}
	}

}
