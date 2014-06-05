/*
* EABPM.java
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

import eu.aniketos.srcm.functional.BPM;
import eu.aniketos.srcm.mapping.IsA;

/**This is the main class which represents the Business Process Model received in input by the SRCM.
 * @author Mattia Salnitri 
 *
 */
public class EABPM extends BPM
{
	private Vector<Participant> participants;
	private Vector<Element> elements;
	private Vector<Variable> variables;
	
	/**
	 * Constructuor of the class
	 */
	public EABPM()
	{
		participants = new Vector<Participant>();
		elements = new Vector<Element>();
		variables = new Vector<Variable>();
	}
	
//participants setters and getters
	/**this function set the list of participant in the class
	 * @param participants
	 */
	public void setParticipantsList(Vector<Participant> participants) {
		this.participants = participants;
	}
	
	/**Getter of the list of participants 
	 * @return the participant list
	 */
	public Vector<Participant> getParticipantsList() {
		return participants;
	}
	
	/** This function adds a given Participant element to the list of participants
	 * @param participant that will be added
	 */
	public void addParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	/**This function removes a given Participant element to the list of participants
	 * @param participant that will be removed
	 */
	public void removeParticipant(Participant participant) {
		this.participants.remove(participant);
	}
	
//element getters and setters
	/**Getter of the list of Elements
	 * @return the element list
	 */
	public Vector<Element> getElementsList() {
		return elements;
	}
	
	/**This function adds a given Element to the list of Elements
	 * @param element that will be added
	 */
	public void addElement(Element element) {
		this.elements.add(element);
	}
	
	/**This function removes a given Element from the list of elements
	 * @param element that will be removed
	 */
	public void removeElement(Element element) {
		this.elements.remove(element);
	}
	
//variable getters and setters
	/**Getter of the list of Variable
	 * @return the variable list
	 */
	public Vector<Variable> getVariablesList() {
		return variables;
	}
	
	/**This function add a given Variable element to the list of variables
	 * @param variable that will be added
	 */
	public void addVariables(Variable variable) {
		this.variables.add(variable);
	}

	/**This function removes a given Variable from the list of variables
	 * @param variable that will be removed
	 */
	public void removeVariables(Variable variable) {
		this.variables.add(variable);
	}


	/**This function set the list of variables contained in the class
	 * @param variables
	 */
	public void setVariablesList(Vector<Variable> variables) {
		this.variables = variables;
	}
		
}
