/*
* Activity.java
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
package eu.aniketos.SecureBPMN;

import java.util.Vector;

/**This class contains all the information related to the Activity Business Process elements
 * @author Mattia Salnitri
 *
 */
public class Activity extends Element
{

	/** This enum enlists the possible activity types . */
	public enum Type {
		/**Activity is a user task .*/
		USER, 
		/**Activity is a service task.*/
		SERVICE,
		/**Activity is a ack task.*/
		ACK,
		};
	private Type type;
	
	private String name;
	
	private Vector<Variable> inVariables;
	private Vector<Variable> outVariables;
	
	// contains the possible executor, that is a role or a agent, this is used only before the reading of the mapping file, after that one among role and agents is chosen
	private Vector<Participant> candidateOwners;
	
	private Participant owner;
	
	private Float trustworthiness=new Float(0);


	/**
	 * Constructor of the class
	 */
	public Activity()
	{
		inVariables = new Vector<Variable>();
		outVariables = new Vector<Variable>();
		candidateOwners = new Vector<Participant>(2);// size of 2: the role and the agent in the pb
	}
	
	/**
	 * @return the candidateOwner
	 */
	public Vector<Participant> getCandidateOwners() {
		return candidateOwners;
	}

	/**
	 * @param candidateOwner the candidateOwner to set
	 */
	public void setCandidateOwners(Vector<Participant> candidateOwner) {
		this.candidateOwners = candidateOwner;
	}
	
	/**
	 * @return the first candidate owners candidateOwner
	 */
	public Participant popCandidateOwner() {
		return candidateOwners.remove(0);
	}

	/**
	 * @param candidateOwner the candidateOwner to add to the candidate owners set
	 */
	public void pushCandidateOwner(Participant candidateOwner) {
		this.candidateOwners.add(candidateOwner);
	}
	

	/** Getter of the activity type  
	 * @return activity type
	 */
	public Type getType() {
		return type;
	}
	
	/** Setter of the Activity type
	 * @param type of the activity
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
//in var getters and setters 
	/** Getter of the list of variables received in input 
	 * @return input variable list
	 */
	public Vector<Variable> getInVariablesList() {
		return inVariables;
	}
	
	/**This function adds a given input variable to the list of input variables
	 * @param inVariable that will be added to the list
	 */
	public void addInVariable(Variable inVariable) {
		this.inVariables.add(inVariable);
	}
	
	
	/**This function removed a given input variable to the list of input variables
	 * @param inVariable that will be removed to the list
	 */
	public void removeInVariable(Variable inVariable) {
		this.inVariables.remove(inVariable);
	}
	
//out var getters and setters
	/**Getter of the list of variables sent as output 
	 * @return output variable list
	 */
	public Vector<Variable> getOutVariablesList() {
		return outVariables;
	}
	
	/**This function adds a given output variable to the list of output variables
	 * @param outVariable that will be added to the list
	 */
	public void addOutVariable(Variable outVariable) {
		this.outVariables.add(outVariable);
	}

	/**This function adds a given output variable to the list of output variables
	 * @param outVariable that will be removed to the list
	 */
	public void removeOutVariable(Variable outVariable) {
		this.outVariables.remove(outVariable);
	}

	/** Getter of the owner of the activity 
	 * @return owner of the activity
	 */
	public Participant getOwner() {
		return owner;
	}

	/** Setter of the owner of the activity
	 * @param owner that will be set
	 */
	public void setOwner(Participant owner) {
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see eu.aniketos.wp4.srcm.SRS.Goal#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see eu.aniketos.wp4.srcm.SRS.Goal#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the trustworthiness
	 */
	public Float getTrustworthiness() {
		return trustworthiness;
	}

	/**
	 * @param trustworthiness the trustworthiness to set
	 */
	public void setTrustworthiness(Float trustworthiness) {
		this.trustworthiness = trustworthiness;
	}
	
}
