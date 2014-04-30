/*******************************************************************************
 * Copyright (c) 2012, Project: FP7-ICT-257930 Aniketos
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 *  -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  -  Neither the name of institution nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
/**
 */
package eu.aniketos.mtm.model.mtm_securebpmn2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getRoleName <em>Role Name</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getParentRoles <em>Parent Roles</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getSubjects <em>Subjects</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getChildRoles <em>Child Roles</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getPermissions <em>Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole()
 * @model
 * @generated
 */
public interface Role extends SecurityFlowNode {
	/**
	 * Returns the value of the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Name</em>' attribute.
	 * @see #setRoleName(String)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole_RoleName()
	 * @model
	 * @generated
	 */
	String getRoleName();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getRoleName <em>Role Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Name</em>' attribute.
	 * @see #getRoleName()
	 * @generated
	 */
	void setRoleName(String value);

	/**
	 * Returns the value of the '<em><b>Parent Roles</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Role}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getChildRoles <em>Child Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Roles</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole_ParentRoles()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getChildRoles
	 * @model opposite="childRoles"
	 * @generated
	 */
	EList<Role> getParentRoles();

	/**
	 * Returns the value of the '<em><b>Subjects</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subjects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subjects</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole_Subjects()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getRoles
	 * @model opposite="roles" transient="true"
	 * @generated
	 */
	EList<Subject> getSubjects();

	/**
	 * Returns the value of the '<em><b>Child Roles</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Role}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getParentRoles <em>Parent Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Roles</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole_ChildRoles()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getParentRoles
	 * @model opposite="parentRoles"
	 * @generated
	 */
	EList<Role> getChildRoles();

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getRole_Permissions()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getRoles
	 * @model opposite="roles"
	 * @generated
	 */
	EList<Permission> getPermissions();

} // Role
