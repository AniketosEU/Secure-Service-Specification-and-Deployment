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
 * A representation of the model object '<em><b>Authorization Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getConstraintName <em>Constraint Name</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getExpression <em>Expression</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#isDynamicEnforcement <em>Dynamic Enforcement</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getAuthorizationConstraint()
 * @model
 * @generated
 */
public interface AuthorizationConstraint extends SecurityFlowNode {
	/**
	 * Returns the value of the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Name</em>' attribute.
	 * @see #setConstraintName(String)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getAuthorizationConstraint_ConstraintName()
	 * @model
	 * @generated
	 */
	String getConstraintName();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getConstraintName <em>Constraint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Name</em>' attribute.
	 * @see #getConstraintName()
	 * @generated
	 */
	void setConstraintName(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getAuthorizationConstraint_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getAuthorizationConstraints <em>Authorization Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getAuthorizationConstraint_Permissions()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getAuthorizationConstraints
	 * @model opposite="authorizationConstraints" required="true"
	 * @generated
	 */
	EList<Permission> getPermissions();

	/**
	 * Returns the value of the '<em><b>Dynamic Enforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dynamic Enforcement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Enforcement</em>' attribute.
	 * @see #setDynamicEnforcement(boolean)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getAuthorizationConstraint_DynamicEnforcement()
	 * @model
	 * @generated
	 */
	boolean isDynamicEnforcement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#isDynamicEnforcement <em>Dynamic Enforcement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Enforcement</em>' attribute.
	 * @see #isDynamicEnforcement()
	 * @generated
	 */
	void setDynamicEnforcement(boolean value);

} // AuthorizationConstraint
