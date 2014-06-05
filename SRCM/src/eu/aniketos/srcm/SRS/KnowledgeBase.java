/*
* KnowledgeBase.java
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

import java.util.Vector;

/**This class manages the Knowledge base part of SRS
 * @author Mattia Salnitri
 *
 */
public class KnowledgeBase 
{
	private Vector<Owns> ownsList;
	private Vector<FullyAuthorized> fullyAuthorizedList;
	private Vector<PartOf> partOfList;
	private Vector<TangibleBy> tangibleByList;
	
	/**
	 * Constructor of the class
	 */
	public KnowledgeBase()
	{
		ownsList = new Vector<Owns>();
		fullyAuthorizedList = new Vector<FullyAuthorized>();
		partOfList = new Vector<PartOf>();
		tangibleByList = new Vector<TangibleBy>();
	}

	/** Getter of the Owns relations list
	 * @return the Owns relations list
	 */
	public Vector<Owns> getOwnsList() {
		return ownsList;
	}

	/**This function adds an Owns relation to the list
	 * @param owns the relation that have to be added
	 */
	public void addOwns(Owns owns) {
		this.ownsList.add(owns);
	}
	
	/**This function removes an Owns relation to the list
	 * @param owns the relation that have to be removed
	 */
	public void removeOwns(Owns owns) {
		this.ownsList.remove(ownsList);
	}

	/** Getter of the Fully Authorized relations list
	 * @return the Fully Authorized relations list
	 */
	public Vector<FullyAuthorized> getFullyAuthorizedList() {
		return fullyAuthorizedList;
	}

	/**This function adds a Fully Authorized relation to the list
	 * @param fullyAuthorized the relation that have to be added
	 */
	public void addFullyAuthorized(FullyAuthorized fullyAuthorized) {
		this.fullyAuthorizedList.add(fullyAuthorized);
	}

	/**This function removes an Owns relation to the list
	 * @param fullyAuthorized the relation that have to be removed
	 */
	public void removeFullyAuthorized(FullyAuthorized fullyAuthorized) {
		this.fullyAuthorizedList.remove(fullyAuthorized);
	}

	/** Getter of the Part OF relations list
	 * @return the Part Of relations list
	 */
	public Vector<PartOf> getPartOfList() {
		return partOfList;
	}

	/**This function adds a Part Of relation to the list
	 * @param partOf the relation that have to be added
	 */
	public void addPartOf(PartOf partOf) {
		this.partOfList.add(partOf);
	}
	
	/**This function removes a Part Of relation to the list
	 * @param partOf the relation that have to be removed
	 */
	public void removePartOf(PartOf partOf) {
		this.partOfList.remove(partOf);
	}

	/** Getter of the Tangible By relations list
	 * @return the Tangible By relations list
	 */
	public Vector<TangibleBy> getTangibleByList() {
		return tangibleByList;
	}

	/**This function adds a Tangible By relation to the list
	 * @param tangibleBy the relation that have to be added
	 */
	public void addTangibleBy(TangibleBy tangibleBy) {
		this.tangibleByList.add(tangibleBy);
	}
	
	/**This function removes a Tangible by relation to the list
	 * @param tangibleBy the relation that have to be removed
	 */
	public void removeTangibleBy(TangibleBy tangibleBy) {
		this.tangibleByList.remove(tangibleBy);
	}

	/**Setter of the Own relations list
	 * @param ownsList list the own relation list that have to be setted
	 */
	public void setOwnsList(Vector<Owns> ownsList) {
		this.ownsList = ownsList;
	}

	/** Setter of the Fully Authorized relations list
	 * @param fullyAuthorizedList the list that have to be setted
	 */
	public void setFullyAuthorizedList(Vector<FullyAuthorized> fullyAuthorizedList) {
		this.fullyAuthorizedList = fullyAuthorizedList;
	}
}
