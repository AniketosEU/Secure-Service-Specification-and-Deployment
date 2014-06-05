/*
* Mapping.java
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
package eu.aniketos.srcm.mapping;

import java.util.Iterator;
import java.util.Vector;

/**This is the main class of the mapping class structure. 
 * This class contains the list of all the relations between the Business Process and the SRS
 * @author Mattia Salnitri
 *
 */
public class Mapping 
{
	private Vector<Plays> playsList;
	private Vector<IsA> isaList;
	private Vector<RelatesTo> relatesToList;
	private Vector<Represents> representsList;
	
	/**Constructor of the class
	 * 
	 */
	public Mapping()
	{
		playsList = new Vector<Plays>();
		isaList = new Vector<IsA>();
		relatesToList = new Vector<RelatesTo>();
		representsList = new Vector<Represents>();
	}
	
	/**Clean up all the lists removing all the relations which has one of the two target set to null.
	 * This happens when there is no correspondent elements in the mapping. 
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public void clearLists()
	{
		Iterator i;/* = this.playsList.iterator();
		while (i.hasNext())
		{
			Plays play = (Plays) i.next();
			if (play.getActor()==null || play.getParticipant()==null)
				i.remove();
				//playsList.remove(play);
		}
		
		i = this.isaList.iterator();
		while (i.hasNext())
		{
			IsA isa=(IsA) i.next();
			if (isa.getActor()==null || isa.getParticipant()==null)
				i.remove();
				//playsList.remove(isa);
		}*/
		
		i = this.relatesToList.iterator();
		while (i.hasNext())
		{
			RelatesTo relatesTo = (RelatesTo) i.next();
			if (relatesTo.getActivity()==null || relatesTo.getGoal()==null)
				i.remove();
				//playsList.remove(relatesTo);
		}
		
		i = this.representsList.iterator();
		while (i.hasNext())
		{
			Represents represents = (Represents) i.next();
			if (represents.getDocument()==null || represents.getVariable()==null)
				i.remove();
				//playsList.remove(represents);
		}
		
	}
	
//plays list getters and setters
	/**Getter of plays relations
	 * @return plays list
	 */
	public Vector<Plays> getPlaysList() {
		return playsList;
	}
	
	/**This function adds a relation to the list
	 * @param playsRelation the relation that has to be added
	 */
	public void addPlaysRelation(Plays playsRelation) {
		this.playsList.add(playsRelation);
	}
	
	/**This function removes a relation to the list
	 * @param playsRelation the relation that has to be removed
	 */
	public void removePlaysRelation(Plays playsRelation) {
		this.playsList.remove(playsRelation);
	}
	
// isa List getters and setters
	/**Getter of is-a relations
	 * @return is-a list
	 */
	public Vector<IsA> getIsaList() {
		return isaList;
	}
	
	/**This function adds a relation to the list
	 * @param isaRelation the relation that has to be added
	 */
	public void addIsaRelation(IsA isaRelation) {
		this.isaList.add(isaRelation);
	}
	
	/**This function removes a relation to the list
	 * @param isaRelation the relation that has to be removed
	 */
	public void removeIsaRelation(IsA isaRelation) {
		this.isaList.remove(isaRelation);
	}
	
// relatesTo list getters and setters
	/**Getter of relates-to relations
	 * @return relates-to list
	 */
	public Vector<RelatesTo> getRelatesToList() {
		return relatesToList;
	}
	
	/**This function adds a relation to the list
	 * @param relatesToRelation the relation that has to be added
	 */
	public void addRelatesToRelation(RelatesTo relatesToRelation) {
		this.relatesToList.add(relatesToRelation);
	}
	
	/**This function removes a relation to the list
	 * @param relatesToRelation the relation that has to be removed
	 */
	public void removeRelatesToRelation(RelatesTo relatesToRelation) {
		this.relatesToList.remove(relatesToRelation);
	}
	
//represents  getters and setters
	/**Getter of Represents relations
	 * @return the represents relations list
	 */
	public Vector<Represents> getRepresentsList() {
		return representsList;
	}
	
	/**This function adds a relation to the list
	 * @param representsRelation the relation that has to be added
	 */
	public void addRepresentsRelation(Represents representsRelation) {
		this.representsList.add(representsRelation);
	}
	
	/**This function removes a relation to the list
	 * @param representsRelation the relation that has to be removed
	 */
	public void removeRepresentsRelation(Represents representsRelation) {
		this.representsList.remove(representsRelation);
	}
	
	
}
