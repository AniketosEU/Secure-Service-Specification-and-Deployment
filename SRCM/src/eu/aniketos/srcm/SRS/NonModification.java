/*
* NonModification.java
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

/**This class manages the non modification security need
 * @author Mattia Salnitri
 *
 */
public class NonModification extends SecurityNeed
{
	private Vector<Information> InformationList;
	
	/**
	 * Constructor of the class 
	 */
	public NonModification()
	{
		InformationList = new Vector<Information>();
	}

	/**Getter of the information that cannot be modified
	 * @return the list of the information 
	 */
	public Vector<Information> getInformationList() {
		return InformationList;
	}
	

	/**This function adds an information to the information list
	 * @param information the information that has to be added
	 */
	public void addInformation(Information information) 
	{
		InformationList.add(information);
	}

	/**This function removes an information to the information list
	 * @param information the information that has to be removed
	 */
	public void removeInformation(Information information) 
	{
		InformationList.remove(information);
	}

	/**Setter of the information list
	 * @param informationList the information list that has to be set
	 */
	public void setInformationList(Vector<Information> informationList) {
		InformationList = informationList;
	}

}
