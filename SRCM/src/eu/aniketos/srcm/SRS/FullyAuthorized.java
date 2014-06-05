/*
* FullyAuthorized.java
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

/**This class manages the Fully-Authorized SRS relation 
 * @author Mattia Salnitri
 *
 */
public class FullyAuthorized 
{
	private Actor owner;
	private Information information;
	
	/** Getter of the owner (the actor fully authorized) of the resource
	 * @return the owner of the resource
	 */
	public Actor getOwner() {
		return owner;
	}
	
	/**Setter of the owner (the actor fully authorized) of the resource
	 * @param owner the owner of the resource
	 */
	public void setOwner(Actor owner) {
		this.owner = owner;
	}
	
	/** Getter of the information targeted by the relation
	 * @return the information targeted
	 */
	public Information getInformation() {
		return information;
	}
	
	/**Setter of the information targeted by the relation
	 * @param information the information targeted
	 */
	public void setInformation(Information information) {
		this.information = information;
	}
}
