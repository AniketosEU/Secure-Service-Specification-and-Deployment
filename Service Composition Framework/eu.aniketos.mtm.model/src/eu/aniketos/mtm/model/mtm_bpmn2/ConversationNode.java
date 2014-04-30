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
package eu.aniketos.mtm.model.mtm_bpmn2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conversation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode#getParticipantRefs <em>Participant Refs</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode#getMessageFlowRefs <em>Message Flow Refs</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode#getCorrelationKeys <em>Correlation Keys</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getConversationNode()
 * @model abstract="true"
 *        extendedMetaData="name='tConversationNode' kind='elementOnly'"
 * @generated
 */
public interface ConversationNode extends BaseElement, InteractionNode {
	/**
	 * Returns the value of the '<em><b>Participant Refs</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant Refs</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getConversationNode_ParticipantRefs()
	 * @model lower="2" ordered="false"
	 *        extendedMetaData="kind='element' name='participantRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<Participant> getParticipantRefs();

	/**
	 * Returns the value of the '<em><b>Message Flow Refs</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.MessageFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Flow Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Flow Refs</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getConversationNode_MessageFlowRefs()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='messageFlowRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<MessageFlow> getMessageFlowRefs();

	/**
	 * Returns the value of the '<em><b>Correlation Keys</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Keys</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Keys</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getConversationNode_CorrelationKeys()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='correlationKey' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<CorrelationKey> getCorrelationKeys();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getConversationNode_Name()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ConversationNode
