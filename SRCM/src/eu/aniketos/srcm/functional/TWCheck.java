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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.EABPM;
import eu.aniketos.SecureBPMN.Element;
import eu.aniketos.srcm.SRS.Commitment;
import eu.aniketos.srcm.SRS.Trustworthiness;

/**this class manages the trustworthiness check
 * @author Mattia Salnitri
 *
 */
public class TWCheck {

	/**
	 * Function which check the trustworthiness security requirement
	 * 
	 * @param commitment the trustworthiness commitment
	 * @param bpm the secure service composition to check
	 * @param undecCommitmentList the list of undecidable security requirements
	 * @param satCommitmentList the list of fulfilled security requirements
	 * @param unSatCommitmentList the list of violated security requirements
	 */
	public static void checkTrustworthiness(Commitment commitment, EABPM bpm, HashSet<Commitment> undecCommitmentList, HashSet<Commitment> satCommitmentList,	HashSet<Commitment> unSatCommitmentList)
	{
		Vector<Element> ElementsList = bpm.getElementsList();
		
		Iterator<Element> ElementsListIT = ElementsList.iterator();
		
		while (ElementsListIT.hasNext())
		{
			Element element = ElementsListIT.next();
			Trustworthiness trustworthiness = (Trustworthiness) commitment.getPostCondition();
			
			//is the element of the trustworthiness refers to the element we are analyzing in the BP
			//and the element is an activity (not a gateway or event)
			if (element.getId().compareTo(trustworthiness.getGoal().getId())==0 && element.getClass()==Activity.class)
			{
				Activity activity = (Activity) element;
				if (activity.getType()==Activity.Type.SERVICE)
					undecCommitmentList.add(commitment);
				else if (activity.getTrustworthiness()<trustworthiness.getLevel())
					unSatCommitmentList.add(commitment);
				else
					satCommitmentList.add(commitment);
					
			}
			
		}
		
	}
	
}
