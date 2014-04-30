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

import org.eclipse.securebpmn2.SecurityFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.FlowNode#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.FlowNode#getLanes <em>Lanes</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.FlowNode#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.FlowNode#getIncomingSecurityFlow <em>Incoming Security Flow</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.FlowNode#getOutgoingSecurityFlow <em>Outgoing Security Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode()
 * @model abstract="true"
 *        extendedMetaData="name='tFlowNode' kind='elementOnly'"
 * @generated
 */
public interface FlowNode extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.SequenceFlow}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.SequenceFlow#getTargetRef <em>Target Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode_Incoming()
	 * @see org.eclipse.bpmn2.SequenceFlow#getTargetRef
	 * @model opposite="targetRef" resolveProxies="false" ordered="false"
	 *        extendedMetaData="kind='element' name='incoming' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	List<SequenceFlow> getIncoming();

	/**
	 * Returns the value of the '<em><b>Lanes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.Lane}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.Lane#getFlowNodeRefs <em>Flow Node Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lanes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanes</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode_Lanes()
	 * @see org.eclipse.bpmn2.Lane#getFlowNodeRefs
	 * @model opposite="flowNodeRefs" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	List<Lane> getLanes();

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.SequenceFlow}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.SequenceFlow#getSourceRef <em>Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode_Outgoing()
	 * @see org.eclipse.bpmn2.SequenceFlow#getSourceRef
	 * @model opposite="sourceRef" resolveProxies="false"
	 *        extendedMetaData="kind='element' name='outgoing' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	List<SequenceFlow> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.SecurityFlow}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.securebpmn2.SecurityFlow#getTargetRefNode <em>Target Ref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Security Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Security Flow</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode_IncomingSecurityFlow()
	 * @see org.eclipse.securebpmn2.SecurityFlow#getTargetRefNode
	 * @model opposite="targetRefNode"
	 * @generated
	 */
	List<SecurityFlow> getIncomingSecurityFlow();

	/**
	 * Returns the value of the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.SecurityFlow}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.securebpmn2.SecurityFlow#getSourceRefNode <em>Source Ref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Security Flow</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Security Flow</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getFlowNode_OutgoingSecurityFlow()
	 * @see org.eclipse.securebpmn2.SecurityFlow#getSourceRefNode
	 * @model opposite="sourceRefNode"
	 * @generated
	 */
	List<SecurityFlow> getOutgoingSecurityFlow();

} // FlowNode
