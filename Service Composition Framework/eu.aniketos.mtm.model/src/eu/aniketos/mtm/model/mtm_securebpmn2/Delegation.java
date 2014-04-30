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

import eu.aniketos.mtm.model.mtm_bpmn2.BaseElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegator <em>Delegator</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatee <em>Delegatee</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#isNegotiable <em>Negotiable</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatablePermissions <em>Delegatable Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation()
 * @model abstract="true"
 * @generated
 */
public interface Delegation extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Delegator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegator</em>' reference.
	 * @see #setDelegator(Delegator)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation_Delegator()
	 * @model required="true"
	 * @generated
	 */
	Delegator getDelegator();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegator <em>Delegator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegator</em>' reference.
	 * @see #getDelegator()
	 * @generated
	 */
	void setDelegator(Delegator value);

	/**
	 * Returns the value of the '<em><b>Delegatee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegatee</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegatee</em>' reference.
	 * @see #setDelegatee(Subject)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation_Delegatee()
	 * @model required="true" transient="true"
	 * @generated
	 */
	Subject getDelegatee();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatee <em>Delegatee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegatee</em>' reference.
	 * @see #getDelegatee()
	 * @generated
	 */
	void setDelegatee(Subject value);

	/**
	 * Returns the value of the '<em><b>Negotiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negotiable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negotiable</em>' attribute.
	 * @see #setNegotiable(boolean)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation_Negotiable()
	 * @model
	 * @generated
	 */
	boolean isNegotiable();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#isNegotiable <em>Negotiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negotiable</em>' attribute.
	 * @see #isNegotiable()
	 * @generated
	 */
	void setNegotiable(boolean value);

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getDelegations <em>Delegations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation_Permissions()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getDelegations
	 * @model opposite="delegations" required="true"
	 * @generated
	 */
	EList<Permission> getPermissions();

	/**
	 * Returns the value of the '<em><b>Delegatable Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegatable Permissions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegatable Permissions</em>' attribute.
	 * @see #setDelegatablePermissions(EList)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegation_DelegatablePermissions()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Permission> getDelegatablePermissions();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatablePermissions <em>Delegatable Permissions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegatable Permissions</em>' attribute.
	 * @see #getDelegatablePermissions()
	 * @generated
	 */
	void setDelegatablePermissions(EList<Permission> value);

} // Delegation
