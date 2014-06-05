/*
* NonRepudiation.java
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

/**This class manages the non repudiation security need
 * @author Mattia Salnitri
 *
 */
public class NonRepudiation extends SecurityNeed
{
	private Vector<Goal> goalList;
	
	/**
	 * Constructor of the class 
	 */
	public NonRepudiation()
	{
		goalList = new Vector<Goal>();
	}

	/**Getter of the goal list that cannot be repudiated
	 * @return the goal list
	 */
	public Vector<Goal> getGoalList() {
		return goalList;
	}
	
	/**Setter of the goal list that cannot be repudiated
	 * @param goalList that has to be set
	 */
	public void setGoalList(Vector<Goal> goalList)
	{
		this.goalList= goalList;
	}

	/**This function adds a goal to the goal list
	 * @param goal the goal that has to be added
	 */
	public void addGoal(Goal goal) {
		this.goalList.add(goal);
	}
	

	/**This function removes a goal to the goal list
	 * @param goal the goal that has to be removed
	 */	
	public void removeGoal(Goal goal) {
		this.goalList.remove(goal);
	}

}
