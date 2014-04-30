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
package org.eclipse.bpmn2;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.InteractionNode#getIncomingConversationLinks <em>Incoming Conversation Links</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.InteractionNode#getOutgoingConversationLinks <em>Outgoing Conversation Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getInteractionNode()
 * @model abstract="true"
 * @generated
 */
public interface InteractionNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Conversation Links</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.ConversationLink}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.ConversationLink#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Conversation Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Conversation Links</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getInteractionNode_IncomingConversationLinks()
	 * @see org.eclipse.bpmn2.ConversationLink#getTargetRef
	 * @model opposite="targetRef" resolveProxies="false" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	List<ConversationLink> getIncomingConversationLinks();

	/**
	 * Returns the value of the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.ConversationLink}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.ConversationLink#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Conversation Links</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Conversation Links</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getInteractionNode_OutgoingConversationLinks()
	 * @see org.eclipse.bpmn2.ConversationLink#getSourceRef
	 * @model opposite="sourceRef" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	List<ConversationLink> getOutgoingConversationLinks();

} // InteractionNode
