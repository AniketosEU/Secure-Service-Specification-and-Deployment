/*
* Authorization.java
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

import java.util.HashSet;
import java.util.Vector;

/** This class manage the authorizations set
 * @author Mattia Salnitri
 *
 */
public class Authorization extends Precondition
{
	private Actor destination;
	private Actor source;
	private Vector<Goal> goalList;
	private Vector<Information> informationList;
	private Boolean transferable;

	/** This enum enlists the possible authorization types . */
	public enum Operation {
		/** Authorization is a USE authorization .*/
		USE,
		/** Authorization is a PRODUCE authorization .*/
		PRODUCE, 
		/** Authorization is a MODIFY authorization .*/
		MODIFY, 
		/** Authorization is a DISTRIBUTE authorization .*/
		DISTRIBUTE, 
		};
	
	private HashSet<Operation> operations;
	
	/**
	 * Constructor of the class
	 */
	public Authorization()
	{
		goalList = new Vector<Goal>();
		informationList = new Vector<Information>();
		operations= new HashSet<Authorization.Operation>();
	}

	/** Getter of the target of the authorizations set 
	 * @return the actor targeted
	 */
	public Actor getDestination() {
		return destination;
	}

	/** Setter of the target of the authorizations set
	 * @param destination the actor targeted
	 */
	public void setDestination(Actor destination) {
		this.destination = destination;
	}

	/** Getter of the source of the authorizations set
	 * @return the source actor 
	 */
	public Actor getSource() {
		return source;
	}

	/** Setter of the source of the authorizations set
	 * @param source the source actor
	 */
	public void setSource(Actor source) {
		this.source = source;
	}

	/** Getter of the goal list for which authorization set is valid 
	 * @return the goal list 
	 */
	public Vector<Goal> getGoalList() {
		return goalList;
	}

	/**This functions adds a goal to the goal list
	 * @param goal the goal list
	 */
	public void addGoal(Goal goal) {
		this.goalList.add(goal);
	}

	/**This functions removes a given goal  from the goal list
	 * @param goal the goal that have to be removed
	 */
	public void removeGoal(Goal goal) {
		this.goalList.remove(goal);
	}

	/** Getter of the information list for which authorization set is valid 
	 * @return information list 
	 */
	public Vector<Information> getInformationList() {
		return informationList;
	}

	/**This functions adds an information to the information list
	 * @param information the information list
	 */
	public void addInformation(Information information) {
		this.informationList.add(information);
	}
	
	/**This functions removes a information from the information list
	 * @param information the information that have to be removed
	 */
	public void removeInformation(Information information) {
		this.informationList.remove(information);
	}


	/** Getter of the authorizations set 
	 * @return  the authorization set 
	 */
	public HashSet<Operation> getOperations() {
		return operations;
	}

	/**This functions adds an authorization to the authorizations set
	 * @param operation the goal list
	 */
	public void addOperations(Operation operation) 
	{
		this.operations.add(operation);
	}
	
	/**This functions removes a given authorization from the authorizations set
	 * @param operation the operation that have to be removed
	 */
	public void removeOperations(Operation operation) 
	{
		this.operations.remove(operation);
	}

	
	/**Getter of the transferable options
	 * @return the value of the transferable option
	 */
	public Boolean getTransferable() {
		return transferable;
	}

	/**Setter of the transferable option
	 * @param transferable the value of the transferable option that has to be set
	 */
	public void setTransferable(Boolean transferable) {
		this.transferable = transferable;
	}

}
