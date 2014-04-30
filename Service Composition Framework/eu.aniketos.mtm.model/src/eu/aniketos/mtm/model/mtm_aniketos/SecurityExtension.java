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
package eu.aniketos.mtm.model.mtm_aniketos;

import eu.aniketos.mtm.model.mtm_bpmn2.BaseElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension#getIntegrityReq <em>Integrity Req</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension#getTrustworthinessValue <em>Trustworthiness Value</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension#getConfidentialityReq <em>Confidentiality Req</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage#getSecurityExtension()
 * @model
 * @generated
 */
public interface SecurityExtension extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Integrity Req</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_aniketos.Integrity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integrity Req</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integrity Req</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage#getSecurityExtension_IntegrityReq()
	 * @model containment="true"
	 * @generated
	 */
	EList<Integrity> getIntegrityReq();

	/**
	 * Returns the value of the '<em><b>Trustworthiness Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trustworthiness Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trustworthiness Value</em>' containment reference.
	 * @see #setTrustworthinessValue(Trustworthiness)
	 * @see eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage#getSecurityExtension_TrustworthinessValue()
	 * @model containment="true"
	 * @generated
	 */
	Trustworthiness getTrustworthinessValue();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension#getTrustworthinessValue <em>Trustworthiness Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trustworthiness Value</em>' containment reference.
	 * @see #getTrustworthinessValue()
	 * @generated
	 */
	void setTrustworthinessValue(Trustworthiness value);

	/**
	 * Returns the value of the '<em><b>Confidentiality Req</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_aniketos.Confidentiality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidentiality Req</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidentiality Req</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage#getSecurityExtension_ConfidentialityReq()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<Confidentiality> getConfidentialityReq();

} // SecurityExtension
