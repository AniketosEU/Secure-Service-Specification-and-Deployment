/*
* VerifyAlignment.java
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

import java.awt.color.CMMException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import org.w3c.dom.Document;

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.SecureBPMN.Element;
import eu.aniketos.SecureBPMN.Participant;
import eu.aniketos.SecureBPMN.Variable;
import eu.aniketos.activiti.Activiti;
import eu.aniketos.srcm.SRS.*;
import eu.aniketos.srcm.SRS.Authorization.Operation;
import eu.aniketos.srcm.mapping.IsA;
import eu.aniketos.srcm.mapping.Mapping;
import eu.aniketos.srcm.mapping.Plays;
import eu.aniketos.srcm.mapping.Represents;

/**This class instantiates the SRS and it calls the appropriate compliance algorithms for every commitments.  
 * @author Mattia Salnitri
 *
 */
public class VerifyAlignment 
{
	private SRS srs;
	private Document domSRS;
	private Mapping mapping;
	private EABPM bpm;
	private Activiti activiti;
	
	private HashSet<Commitment> undecCommitmentList;
	private HashSet<Commitment> satCommitmentList;
	private HashSet<Commitment> unSatCommitmentList;
	
	/**Constructor of the class
	 * @param srs The Security Requirements Specification class structure
	 * @param domSRS The SRS document
	 * @param mapping The mapping class structure
	 * @param bpm The Business Process Model class structure
	 * @param activiti the activiti set of information
	 */
	public VerifyAlignment(SRS srs, Document domSRS, Mapping mapping, BPM bpm, Activiti activiti)
	{
		this.srs=srs;
		this.domSRS=domSRS;
		this.mapping=mapping;
		this.bpm=(EABPM)bpm;
		this.activiti=activiti;
		
		undecCommitmentList = new HashSet<Commitment>();
		satCommitmentList = new HashSet<Commitment>();
		unSatCommitmentList = new HashSet<Commitment>();
		
	}
	
	/**Main method of the class, it instantiate the SRS and check all the commitments
	 * ATTENTION: this class can supports almost all commitments, 
	 * except commitments on provision of documents, because in STS file the documents "provided" to actors are duplicated,
	 * i.e. they have the same name as the original but with different IDs.
	 * Some commitments are on provision, hence they refer to such documents, and there is no reference in the data object created.
	 * In the mapping file there are all the documents linked to one variable. 
	 * This information is transformed in the data structure representing the mapping simply 
	 * adding as many "refers" relations as the number of documents specified. (TODO)
	 * what is missing is the link between information and the documents duplicated, because the Made-tangible-by 
	 * relation only links the information to the original document, not the duplicated one.   
	 * @return the output XML document
	 */
	public String checkAlignment()
	{
		//instantiate the commitment
		try 
		{
			InstantiateSRS instSRS = new InstantiateSRS();
			instSRS.instantiateSRS(srs, mapping, bpm, undecCommitmentList);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
		//check the alignment and create the the authorization table
		return checkCommitments();
	}
	
	
	private String checkCommitments()
	{
		//for each commitment
		//control commitment
		//update collections of commitment sat, not sat, undec
		
		Vector<ActorVarOperation> operations = new Vector<ActorVarOperation>();
		
		//instantiate the authorization table
		AuthCheck.createAuthTable(srs, undecCommitmentList, operations);
		
		//at this point the list of permission should be formed
		//for all the activities, check the input output
		AuthCheck.checkAuthorizationTable(bpm, srs, operations, undecCommitmentList, satCommitmentList, unSatCommitmentList, mapping, activiti);
 
		//clean commitment list
		cleanCommitmentList();
		
		//check all the other commitments
		CommitmentCheck.checkAll(bpm, srs, undecCommitmentList, satCommitmentList, unSatCommitmentList);
		
		//create the dom for the output
		ParseOutputDom parsOut = new ParseOutputDom();
		return parsOut.createDom(domSRS, satCommitmentList, unSatCommitmentList, undecCommitmentList);
	}
	
	
	//clean up list of commitments
	//delete all authorization commitment and move commitment that are not in unsat list in sat list
	private void cleanCommitmentList()
	{
		Vector<Commitment> commList = srs.getCommitmentList();
		
		//i clone the commitment list because during the cycle i modify the commitment list
		//at the end of the function i substitute le commitment list with the updated one
		Vector<Commitment> commListUpdated = (Vector<Commitment>) commList.clone();
		
		Iterator<Commitment> commListIt = commList.iterator();
		while (commListIt.hasNext())
		{
			Commitment comm = commListIt.next();
			//if the commitmen is an authorization commitment
			if (comm.getPostCondition().getClass()==NonDisclosure.class || 
					comm.getPostCondition().getClass()==NonModification.class || 
					comm.getPostCondition().getClass()==NonProduction.class || 
					comm.getPostCondition().getClass()==NonUsage.class)
			{
				//remove the commitment from the list of all commitments
				commListUpdated.remove(comm);
				//if the commitment is NOT in the list of the un sat comm, put it in sat list
				if (!unSatCommitmentList.contains(comm))
				{
					satCommitmentList.add(comm);
				}
				
			}
		}
		
		srs.setCommitmentList(commListUpdated);
		
	}


	
	/**Getter of the  undecidable commitments list
	 * @return The undecidable commitments list
	 */
	public HashSet<Commitment> getUndecCommitmentList() {
		return undecCommitmentList;
	}

	/**Setter of the undecidable commitments list
	 * @param undecCommitmentList the undecidable commitments list
	 */
	public void setUndecCommitmentList(HashSet<Commitment> undecCommitmentList) {
		this.undecCommitmentList = undecCommitmentList;
	}

	/**Getter of the  satisfied commitments list
	 * @return The satisfied commitments list
	 */
	public HashSet<Commitment> getSatCommitmentList() {
		return satCommitmentList;
	}

	/**Setter of the satisfied commitments list
	 * @param satCommitmentList the satisfied commitments list
	 */
	public void setSatCommitmentList(HashSet<Commitment> satCommitmentList) {
		this.satCommitmentList = satCommitmentList;
	}

	/**Getter of the  unsatisfied commitments list
	 * @return The unsatisfied commitments list
	 */
	public HashSet<Commitment> getUnSatCommitmentList() {
		return unSatCommitmentList;
	}

	/**Setter of the unsatisfied commitments list
	 * @param unSatCommitmentList the unsatisfied commitments list
	 */
	public void setUnSatCommitmentList(HashSet<Commitment> unSatCommitmentList) {
		this.unSatCommitmentList = unSatCommitmentList;
	} 
	

}
