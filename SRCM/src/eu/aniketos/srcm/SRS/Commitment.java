/*
* Commitment.java
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

/**This class manages the commitment SRS element
 * @author Mattia Salnitri
 *
 */
public class Commitment 
{
	/*
	 * for trustworthiness commitments, and all other commitments where the post condition is the delegation/authorization,
	 * the commitment is stored inverted, 
	 * i.e. in pre condition we store the delegation and in post condition is stored the trustworthiness.  
	 */
	
	private String id;
	private Actor debtor;
	private Actor creditor;
	private Precondition precondition; //Delegation. authorozation
	private SecurityNeed postCondition; //Trustworthiness
	
	/** Getter of actor who plays the debtor role in the commitment
	 * @return the debtor of the commitment 
	 */
	public Actor getDebtor() {
		return debtor;
	}
	
	/** Setter of the actor who plays the debtor role in the commitment 
	 * @param debtor the debtor that has to be set
	 */
	public void setDebtor(Actor debtor) {
		this.debtor = debtor;
	}

	/** Getter of actor who plays the creditor role in the commitment
	 * @return the creditor of the commitment 
	 */
	public Actor getCreditor() {
		return creditor;
	}

	/** Setter of the actor who plays the creditor role in the commitment 
	 * @param creditor the creditor that has to be set
	 */
	public void setCreditor(Actor creditor) {
		this.creditor = creditor;
	}

	/**Getter of the commitment precondition 
	 * @return the precondition of the commitment
	 */
	public Precondition getPrecondition() {
		return precondition;
	}

	/**Setter of the commitment precondition
	 * @param precondition the precondition of the commitment
	 */
	public void setPrecondition(Precondition precondition) {
		this.precondition = precondition;
	}

	/**Getter of the commitment postcondition 
	 * @return the postcondition of the commitment
	 */
	public SecurityNeed getPostCondition() {
		return postCondition;
	}

	/**Setter of the commitment postcondition
	 * @param postCondition the postcondition of the commitment
	 */
	public void setPostCondition(SecurityNeed postCondition) {
		this.postCondition = postCondition;
	}

	/**Getter of the commitment ID
	 * @return the commitment id
	 */
	public String getId() {
		return id;
	}

	/**Setter of the commitment ID
	 * @param id the commitment ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	

}
