/*
* ActivitiRole.java
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
package eu.aniketos.activiti;

import java.util.HashMap;
import java.util.HashSet;

/**This class represents the role concepts in activiti files  
 * @author Mattia Salnitri
 *
 */
public class ActivitiRole 
{
	private String id;
	private String name;
	private HashSet<ActivitiNeedToKnow> permissions;
	private String permissionsID;
	
	public ActivitiRole()
	{
		permissions = new HashSet<ActivitiNeedToKnow>();
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param ntk the permissions to add
	 */
	public void addPermissions(ActivitiNeedToKnow ntk) {
		this.permissions.add(ntk);
	}	
	/**
	 * @return the permissions
	 */
	public HashSet<ActivitiNeedToKnow> getPermissions() {
		return permissions;
	}
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(HashSet<ActivitiNeedToKnow> permissions) {
		this.permissions = permissions;
	}
	/**
	 * @return the permissionsID
	 */
	public String getPermissionsID() {
		return permissionsID;
	}
	/**
	 * @param permissionsID the permissionsID to set
	 */
	public void setPermissionsID(String permissionsID) {
		this.permissionsID = permissionsID;
	}

}
