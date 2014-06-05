/*
* ActorVarOperation.java
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

import eu.aniketos.SecureBPMN.Activity;
import eu.aniketos.SecureBPMN.Participant;
import eu.aniketos.SecureBPMN.Variable;
import eu.aniketos.srcm.SRS.Authorization;
import eu.aniketos.srcm.SRS.Authorization.Operation;

	/** This class is used to manage the authorization table
	 * @author Mattia Salnitri
	 *
	 */
class ActorVarOperation 
	{
		private HashSet<Operation> operations;
		Participant target;
		private Variable variable;
		
		public ActorVarOperation(Variable variable, Participant target)
		{
			operations=new HashSet<Authorization.Operation>();
			
			this.target=target;
			this.variable=variable;
			//set up all the permissions
			operations.add(Authorization.Operation.USE);
			operations.add(Authorization.Operation.MODIFY);
			operations.add(Authorization.Operation.PRODUCE);
			operations.add(Authorization.Operation.DISTRIBUTE);
		}
		
		/** Getter of the target
		 * @return the participant targeted
		 */
		public Participant getTarget()
		{
			return target;
		}
		
		/**Setter of the target
		 * @param target the participant that will be targeted by the instance of this class
		 */
		public void setTarget(Participant target)
		{
			this.target=target;
		}
		
		/** Setter of the variable
		 * @param variable the variable targeted
		 */
		public void setVariable(Variable variable)
		{
			this.variable=variable;
		}
		
		/**Getter of the variable
		 * @return the variable targeted by the instance of this class
		 */
		public Variable getVarible()
		{
			return this.variable;
		}
		
		/**This methods removes the USE operation authorization
		 * @return true, if the authorization is correctly removed
		 */
		public boolean removeUse()
		{
			return operations.remove(Authorization.Operation.USE);
		}

		/**This methods removes the MODIFY operation authorization
		 * @return true, if the authorization is correctly removed
		 */
		public boolean removeModify()
		{
			return operations.remove(Authorization.Operation.MODIFY);
		}
		
		/**This methods removes the PRODUCE operation authorization
		 * @return true, if the authorization is correctly removed
		 */
		public boolean removeProduce()
		{
			return operations.remove(Authorization.Operation.PRODUCE);
		}
		
		/**This methods removes the DISTRIBUTE operation authorization
		 * @return true, if the authorization is correctly removed
		 */
		public boolean removeDistribute()
		{
			return operations.remove(Authorization.Operation.DISTRIBUTE);
		}
		
		/**This methods adds the USE operation authorization
		 * @return true, if the authorization is correctly added
		 */
		public boolean addUse()
		{
			return operations.add(Authorization.Operation.USE);
		}
		
		/**This methods adds the MODIFY operation authorization
		 * @return true, if the authorization is correctly added
		 */
		public boolean addModify()
		{
			return operations.add(Authorization.Operation.MODIFY);
		}
		
		/**This methods adds the PRODUCE operation authorization
		 * @return true, if the authorization is correctly added
		 */
		public boolean addProduce()
		{
			return operations.add(Authorization.Operation.PRODUCE);
		}
		
		/**This methods adds the DISTRIBUTE operation authorization
		 * @return true, if the authorization is correctly added
		 */
		public boolean addDistribute()
		{
			return operations.add(Authorization.Operation.DISTRIBUTE);
		}

		/**Getter of the authorization set 
		 * @return the authorization set
		 */
		public HashSet<Operation> getOperations() {
			return operations;
		}

		/**Setter of the authorization set
		 * @param operations the authorization set
		 */
		public void setOperations(HashSet<Operation> operations) {
			this.operations = operations;
		}

	}
