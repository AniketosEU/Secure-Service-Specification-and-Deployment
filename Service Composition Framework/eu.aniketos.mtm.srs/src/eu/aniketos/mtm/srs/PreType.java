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
package eu.aniketos.mtm.srs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pre Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.PreType#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PreType#getAuthorization <em>Authorization</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PreType#getProvision <em>Provision</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PreType#getTrustworthiness <em>Trustworthiness</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getPreType()
 * @model extendedMetaData="name='preType' kind='elementOnly'"
 * @generated
 */
public interface PreType extends EObject {
	/**
	 * Returns the value of the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegation</em>' containment reference.
	 * @see #setDelegation(DelType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPreType_Delegation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='delegation' namespace='##targetNamespace'"
	 * @generated
	 */
	DelType getDelegation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PreType#getDelegation <em>Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegation</em>' containment reference.
	 * @see #getDelegation()
	 * @generated
	 */
	void setDelegation(DelType value);

	/**
	 * Returns the value of the '<em><b>Authorization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authorization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authorization</em>' containment reference.
	 * @see #setAuthorization(AuthType1)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPreType_Authorization()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='authorization' namespace='##targetNamespace'"
	 * @generated
	 */
	AuthType1 getAuthorization();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PreType#getAuthorization <em>Authorization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Authorization</em>' containment reference.
	 * @see #getAuthorization()
	 * @generated
	 */
	void setAuthorization(AuthType1 value);

	/**
	 * Returns the value of the '<em><b>Provision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provision</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provision</em>' containment reference.
	 * @see #setProvision(ProvType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPreType_Provision()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='provision' namespace='##targetNamespace'"
	 * @generated
	 */
	ProvType getProvision();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PreType#getProvision <em>Provision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provision</em>' containment reference.
	 * @see #getProvision()
	 * @generated
	 */
	void setProvision(ProvType value);

	/**
	 * Returns the value of the '<em><b>Trustworthiness</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trustworthiness</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trustworthiness</em>' containment reference.
	 * @see #setTrustworthiness(TrustworthinessType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPreType_Trustworthiness()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='trustworthiness' namespace='##targetNamespace'"
	 * @generated
	 */
	TrustworthinessType getTrustworthiness();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PreType#getTrustworthiness <em>Trustworthiness</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trustworthiness</em>' containment reference.
	 * @see #getTrustworthiness()
	 * @generated
	 */
	void setTrustworthiness(TrustworthinessType value);

} // PreType
