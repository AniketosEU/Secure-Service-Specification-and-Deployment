/*
* SRS.java
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
package eu.aniketos.srcm.SRS;

import java.util.HashMap;
import java.util.Vector;

/**This Class manages the SRS elements
 * @author Mattia Salnitri
 *
 */
public class SRS 
{
	private Vector<Commitment> commitment;
	private KnowledgeBase knowledgeBase;
	
	//list used in the instiation phase 
	private  HashMap<String, Role> roleList;
	private  HashMap<String, Agent> agentList;
	private  HashMap<String, Goal> goalList;
	private  HashMap<String, Information> informationList;
	private  HashMap<String, eu.aniketos.srcm.SRS.Document> documentList;
	
	/**
	 * Constructor of the class
	 */
	public SRS()
	{
		commitment = new Vector<Commitment>();
	}

	/** Getter of the knowledge base
	 * @return the knowledge base
	 */
	public KnowledgeBase getKnowledgeBase() {
		return knowledgeBase;
	}

	/**Setter of the knowledge base
	 * @param knowledgeBase the knowledge base that has to be setted
	 */
	public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
	}

	/**Getter of the commitment list 
	 * @return the commitment list
	 */
	public Vector<Commitment> getCommitmentList() {
		return commitment;
	}
	
	/**Setter of the commitment list 
	 * @param commitment the commitment list
	 */
	public void setCommitmentList(Vector<Commitment> commitment) {
		this.commitment=commitment;
	}

	/**This class adds a commitment to the commitments list
	 * @param commitment the commitment that will be added
	 */
	public void addCommitment(Commitment commitment) {
		this.commitment.add(commitment);
	}
	
	/**This class removes a commitment to the commitments list
	 * @param commitment the commitment that will be removed
	 */
	public void removeCommitment(Commitment commitment) {
		this.commitment.remove(commitment);
	}

	
	/**Getter of the role list
	 * @return the role list
	 */
	public   HashMap<String, Role> getRoleList() {
		return roleList;
	}

	/**Setter of the role list
	 * @param roleList the role list that has to be set
	 */
	public void setRoleList(HashMap<String, Role> roleList) {
		this.roleList = roleList;
	}

	/**Getter of the agent list
	 * @return the agent list
	 */
	public   HashMap<String, Agent> getAgentList() {
		return agentList;
	}

	/**Setter of the agent list
	 * @param agentList the agent list that has to be set
	 */
	public   void setAgentList(HashMap<String, Agent> agentList) {
		this.agentList = agentList;
	}

	/**Getter of the goal list
	 * @return the goal list
	 */
	public   HashMap<String, Goal> getGoalList() {
		return goalList;
	}

	/**Setter of the goal list
	 * @param goalList the goal list that has to be set
	 */
	public   void setGoalList(HashMap<String, Goal> goalList) {
		this.goalList = goalList;
	}

	/**Getter of the information list
	 * @return the information list
	 */
	public   HashMap<String, Information> getInformationList() {
		return informationList;
	}

	/**Setter of the information list
	 * @param informationList the information list that has to be set
	 */
	public   void setInformationList(HashMap<String, Information> informationList) {
		this.informationList = informationList;
	}
	
	/**Getter of the SRS document list
	 * @return the information list
	 */
	public   HashMap<String, eu.aniketos.srcm.SRS.Document> getDocumentList() {
		return documentList;
	}

	/**Setter of the SRS document list
	 * @param documentList thet SRS document list that has to be set
	 */
	public   void setDocumentList(HashMap<String, eu.aniketos.srcm.SRS.Document> documentList) {
		this.documentList = documentList;
	}

}
