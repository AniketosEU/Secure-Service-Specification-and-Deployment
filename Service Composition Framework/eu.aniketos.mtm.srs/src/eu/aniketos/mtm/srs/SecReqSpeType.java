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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sec Req Spe Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.SecReqSpeType#getCommitment <em>Commitment</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.SecReqSpeType#getKnowledgeBase <em>Knowledge Base</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.SecReqSpeType#getThreatList <em>Threat List</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getSecReqSpeType()
 * @model extendedMetaData="name='secReqSpe_._type' kind='elementOnly'"
 * @generated
 */
public interface SecReqSpeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Commitment</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.srs.CommitmentType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commitment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commitment</em>' containment reference list.
	 * @see eu.aniketos.mtm.srs.SrsPackage#getSecReqSpeType_Commitment()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='commitment' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CommitmentType> getCommitment();

	/**
	 * Returns the value of the '<em><b>Knowledge Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Knowledge Base</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Knowledge Base</em>' containment reference.
	 * @see #setKnowledgeBase(KBType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getSecReqSpeType_KnowledgeBase()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='knowledgeBase' namespace='##targetNamespace'"
	 * @generated
	 */
	KBType getKnowledgeBase();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.SecReqSpeType#getKnowledgeBase <em>Knowledge Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Knowledge Base</em>' containment reference.
	 * @see #getKnowledgeBase()
	 * @generated
	 */
	void setKnowledgeBase(KBType value);

	/**
	 * Returns the value of the '<em><b>Threat List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threat List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat List</em>' containment reference.
	 * @see #setThreatList(ThreatListType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getSecReqSpeType_ThreatList()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='threatList' namespace='##targetNamespace'"
	 * @generated
	 */
	ThreatListType getThreatList();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.SecReqSpeType#getThreatList <em>Threat List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threat List</em>' containment reference.
	 * @see #getThreatList()
	 * @generated
	 */
	void setThreatList(ThreatListType value);

} // SecReqSpeType
