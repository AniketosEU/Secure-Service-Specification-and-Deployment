/*
* NRInst.java
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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.Element;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.Goal;
import eu.aniketos.srcm.SRS.NonRepudiation;
import eu.aniketos.srcm.SRS.SRS;
import eu.aniketos.srcm.mapping.Mapping;
import eu.aniketos.srcm.mapping.RelatesTo;

/** this class manages the Non-Repudiation Instantiation
 * @author Mattia Salnitri
 *
 */
public class NRInst {
	
	/**
	 * @param commitment Commitment to instantiate
	 * @param mapping the mapping used to instantiate the commitment
	 * @param srs the list of commitment
	 * @param undecCommitmentList List of undecidable commitments
	 */
	public static void instantiateCommitment(Commitment commitment, Mapping mapping, SRS srs, HashSet<Commitment> undecCommitmentList)
	{
		
		NonRepudiation nonRepudiation = (NonRepudiation)commitment.getPostCondition();
		//retrieve the goal list
		Vector<Goal> goalList = nonRepudiation.getGoalList();
		
		//check if the goal list is empty, in this case i delete the commitment from srs
		if (goalList.size()==0)
		{
			System.out.println("WARNING: commitment " + commitment.getId() + " has been removed from the SRS list during instantiation phase: the goal set is empty");
			srs.removeCommitment(commitment);
			undecCommitmentList.add(commitment);
			return;
		}
		
		Iterator<Goal> goalIter = goalList.iterator();
		Hashtable<String, Activity> activitySet=null;
		//for every goal specified in the non repudiation post condition
		while(goalIter.hasNext())
		{
			Goal goal = goalIter.next();
			activitySet = searchRelatedActivities(mapping, goal);
		}
		
		//if something is wrong in the commitment, i delete it from the srs
		if (activitySet==null || activitySet.size()==0)
		{
			System.out.println("WARNING: commitment " + commitment.getId() + " has been removed from the SRS list during instantiation phase: no tasks mapped to the goals of the commitment");
			srs.removeCommitment(commitment);
			undecCommitmentList.add(commitment);
			return;
		}
		
		//for every activity related to the goals for which there is a requirement of non repudiation
		Iterator<Map.Entry<String, Activity>> activityIter = activitySet.entrySet().iterator();
		boolean isFirst = true; 
		while (activityIter.hasNext())
		{
			Map.Entry<String, Activity> entry = activityIter.next();
			
			Activity activity = (Activity) entry.getValue();
			
			//create a list with only one element
			Vector actList= new Vector();
			actList.add(activity);
			
			if (isFirst)
			{
				nonRepudiation.setGoalList(actList);
				isFirst=false;
			}
			else
			{
				//create and setup new commitment
				Commitment newComm = new Commitment();
				newComm.setCreditor(commitment.getCreditor());
				newComm.setDebtor(commitment.getDebtor());
				newComm.setPrecondition(commitment.getPrecondition());
				
				NonRepudiation newNonRep = new NonRepudiation();
				newNonRep.setGoalList(actList);
				newComm.setPostCondition(newNonRep);
				
				//add new commitment to the list
				srs.addCommitment(newComm);
			}
			
		}
		
	}
	
	//search all the activities related to a given goal
	private static Hashtable<String, Activity> searchRelatedActivities(Mapping mapping, Goal goal)
	{
		//Vector<Activity> activityList = new Vector<Activity>();
		//hashtable with the activity as value, and the ID as key
		//i use hash table to avoid having duplicate elements
		Hashtable<String, Activity> activitySet = new Hashtable<String, Activity>();
		
		Vector<RelatesTo> relatesToList = mapping.getRelatesToList();
		
		Iterator<RelatesTo> relToIter = relatesToList.iterator();
		while (relToIter.hasNext())
		{
			RelatesTo relatesTo = relToIter.next();
			if (relatesTo.getGoal().getId().compareToIgnoreCase(goal.getId())==0)
			{
				activitySet.put(relatesTo.getActivity().getId(), relatesTo.getActivity());
			}
				
		}
		
		return activitySet;
	}

}
