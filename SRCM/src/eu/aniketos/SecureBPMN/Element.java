/*
* Element.java
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

import java.util.HashMap;

import eu.aniketos.srcm.SRS.Goal;


/** Class which represents the general Business Process element.
 * It extents Goal class because at the instantiation phase all goal elements will be transformed in Business Process elements 
 * @author Mattia Salnitri
 *
 */
public class Element extends Goal
{
	private HashMap<String,Element> nextList;
	private HashMap<String,Element> previousList;
	private String id;
	
	/**
	 * Constructor of the Class
	 */
	public Element()
	{
		nextList = new HashMap<String, Element>();
		previousList = new HashMap<String, Element>();
	}
	
	/* (non-Javadoc)
	 * @see eu.aniketos.wp4.srcm.SRS.Goal#getId()
	 */
	public String getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see eu.aniketos.wp4.srcm.SRS.Goal#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	
//next setters and getters
	/** Getter of the list of the next Business Process elements
	 * @return next elements list
	 */
	public HashMap<String,Element> getNextList() {
		return nextList;
	}
	/**This function adds a given Element to the list of next Elements
	 * @param next element that will be added to the next elements list
	 */
	public void addNext(Element next) 
	{
		this.nextList.put(next.id, next);
	}
	
	/**This function removes a given Element from the list of next Elements
	 * @param next element that will be removed to the next elements list
	 */
	public void removeNext(Element next) 
	{
		this.nextList.remove(next);
	}
	
//previous setters and getters
	/**Getter of the list of the previous Business Process elements
	 * @return previous elements list
	 */
	public HashMap<String,Element> getPreviousList() {
		return previousList;
	}
	
	/**This function adds a given Element to the list of previous Elements
	 * @param previous element that will be added to the previous elements list
	 */
	public void addPrevious(Element previous) 
	{
		this.previousList.put(previous.id, previous);
	}
	
	/**This function removes a given Element from the list of previous Elements
	 * @param previous element that will be removed to the previous elements list
	 */
	public void removePrevious(Element previous) 
	{
		this.previousList.remove(previous);
	}

}
