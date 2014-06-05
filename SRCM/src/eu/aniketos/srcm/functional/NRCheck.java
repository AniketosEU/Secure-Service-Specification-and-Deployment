/*
* NRCheck.java
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.SecureBPMN.Element;
import eu.aniketos.SecureBPMN.Event;
import eu.aniketos.SecureBPMN.Gateway;
import eu.aniketos.SecureBPMN.Participant;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.NonRepudiation;
import eu.aniketos.srcm.SRS.SRS;

/**this class manages the Non-Repudiation algorithms
 * @author Mattia Salnitri
 *
 */
public class NRCheck 
{

	/**check if the given non-repudiation commitment is respected in the business process
	 * @param commitment the commitment that has to be checked
	 * @param bpm the business process that has to respect the commitment
	 * @param undecCommitmentList list of undecidable commitments
	 * @param satCommitmentList list of satisfied commitments
	 * @param unSatCommitmentList list of unsatisfied commitments
	 */
	public static void checkNonRepudiation(Commitment commitment, EABPM bpm, HashSet<Commitment> undecCommitmentList, HashSet<Commitment> satCommitmentList,	HashSet<Commitment> unSatCommitmentList)
	{
	
		HashMap<String, Element> visited = new HashMap<String, Element>();
		NonRepudiation nonRepudiation =(NonRepudiation) commitment.getPostCondition();
		//his is an instantiated commitment, so it has a list with only one element, this element is an activity.
		Vector goalList = nonRepudiation.getGoalList();
		Activity actNR = (Activity) goalList.get(0);
		
		Element startElement=null;
		
		Iterator <Element> eleIT  = bpm.getElementsList().iterator();
		while (eleIT.hasNext())
		{
			startElement= eleIT.next();
			if (startElement.getPreviousList().size()==0)
				break;
		}
		
		if (startElement==null)
		{
			System.err.println("WARNING: Business process not well formed: start event does not exists");
			undecCommitmentList.add(commitment);
		}
		
		boolean verified = verifyNR(actNR, startElement, false, visited);
		
		if (verified)
			satCommitmentList.add(commitment);
		else
			unSatCommitmentList.add(commitment);
	}
	
	//switch can not be used due to some java 6 limitations
	//algorithm described in D4.2
	//i don't need the Participants parameter because is an information already contained in the actNR 
	private static boolean verifyNR(Activity actNR, Element elemCurr, boolean found, HashMap<String, Element> visited)
	{
		//add the element to the one already visited
		visited.put(elemCurr.getId(),elemCurr);
		
		if (elemCurr.getClass()==Gateway.class)
		{
			HashMap<String, Element> next = elemCurr.getNextList();
			Iterator nextIter = next.entrySet().iterator();
			
			Gateway gway=(Gateway) elemCurr;
			
			//right scope here!
			//it has to be reset every gateway
			boolean verified;
			//this variable permit to check if the algorithms proceeds at least with a path  
			boolean noPaths=true;
			
			if (gway.getType()==Gateway.Type.EXCLUSIVE)
			{
				//neutral AND element
				verified=true;
				
				while (nextIter.hasNext())
				{
					Map.Entry pairs = (Map.Entry)nextIter.next();
					Element nextElement=(Element) pairs.getValue();
					
					//i proceed with the verification only if next element was not already visited
					if (!visited.containsKey(nextElement.getId()))
					{
						noPaths=false;
						verified = verified && verifyNR(actNR, nextElement, found, visited);
					}
				}
			}
			else //inclusive gateway || parallel
			{
				//neutral OR element
				verified = false;
				
				while (nextIter.hasNext())
				{
					Map.Entry pairs = (Map.Entry)nextIter.next();
					Element nextElement=(Element) pairs.getValue();
					
					//i proceed with the verification only if next element was not already visited
					if (!visited.containsKey(nextElement.getId()))
					{
						noPaths=false;
						verified = verified || verifyNR(actNR, nextElement, found, visited);
					}
				}
			}
			
			if (noPaths)
				//if the algorithm reach a point in which it's not possible to continue because all the paths are already vidited, it behaves like it reaches an END point
				return !found;
			else
				return verified;
		}
		else if(elemCurr.getClass()==Activity.class)
		{
			Activity actCurr = (Activity) elemCurr;
			if (actCurr.getType()== Activity.Type.ACK)
			{
				//check if the ack is for the activity i'm looking for.
				//and that the owner of the ack is the same of the activity i'm checking 
				if (actCurr.getName().compareToIgnoreCase(actNR.getName())==0 && actCurr.getOwner().getId().compareToIgnoreCase(actNR.getOwner().getId())==0)
					return true;
			}
			else
			{
				//if i find the activity i set found to true
				if(actCurr==actNR)
					found=true;
				//extract the first and only element from the hash map containing the next activities of the activity i'm examinating
				Set<String> keySet = elemCurr.getNextList().keySet();
				Element nextElement = elemCurr.getNextList().get(keySet.iterator().next());
				
				//i proceed with the verification only if next element was not already visited
				if (!visited.containsKey(nextElement.getId()))
					return verifyNR(actNR, nextElement , found, visited);
				else
					//if i reach a point where it's not possible to continue i behave like i would found an END
					return !found;
			}
		}
		else //if (elemCurr.getClass()==Event.class) -> there are no other possibilities
		{
			//if i reach the end of the BP 
			//and i did't find the activity i'm looking for (found =false) i return true, because there is no need of sending an ack if the activity is not preformed
			//otherwise if i found the activity(found = true), and i reach the end without finding the ack, then i return false 
			Event eventCurr= (Event) elemCurr;
			if (eventCurr.getType()==Event.Type.END)
				return !found;
			else if (eventCurr.getType()==Event.Type.START)
			{
				//extract the first and only element from the hash map containing the next activities of the activity i'm examinating
				Set<String> keySet = elemCurr.getNextList().keySet();
				Element nextElement = elemCurr.getNextList().get(keySet.iterator().next());
				
				return verifyNR(actNR, nextElement , found, visited);
			}
		}
		
		//algorithm should never reach this point
		System.err.println("Non-Repudiation algorithm error : problem in parsing the Business process");
		return false;
	}

}
