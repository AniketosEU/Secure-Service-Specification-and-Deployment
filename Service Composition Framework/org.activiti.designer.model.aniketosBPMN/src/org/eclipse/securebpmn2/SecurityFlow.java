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
package org.eclipse.securebpmn2;

import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.FlowNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.SecurityFlow#getSourceRefNode <em>Source Ref Node</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.SecurityFlow#getTargetRefNode <em>Target Ref Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSecurityFlow()
 * @model
 * @generated
 */
public interface SecurityFlow extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Source Ref Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.FlowNode#getOutgoingSecurityFlow <em>Outgoing Security Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Ref Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Ref Node</em>' reference.
	 * @see #setSourceRefNode(FlowNode)
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSecurityFlow_SourceRefNode()
	 * @see org.eclipse.bpmn2.FlowNode#getOutgoingSecurityFlow
	 * @model opposite="outgoingSecurityFlow" resolveProxies="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='sourceRef'"
	 * @generated
	 */
	FlowNode getSourceRefNode();

	/**
	 * Sets the value of the '{@link org.eclipse.securebpmn2.SecurityFlow#getSourceRefNode <em>Source Ref Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Ref Node</em>' reference.
	 * @see #getSourceRefNode()
	 * @generated
	 */
	void setSourceRefNode(FlowNode value);

	/**
	 * Returns the value of the '<em><b>Target Ref Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.FlowNode#getIncomingSecurityFlow <em>Incoming Security Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Ref Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ref Node</em>' reference.
	 * @see #setTargetRefNode(FlowNode)
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSecurityFlow_TargetRefNode()
	 * @see org.eclipse.bpmn2.FlowNode#getIncomingSecurityFlow
	 * @model opposite="incomingSecurityFlow" resolveProxies="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='targetRef'"
	 * @generated
	 */
	FlowNode getTargetRefNode();

	/**
	 * Sets the value of the '{@link org.eclipse.securebpmn2.SecurityFlow#getTargetRefNode <em>Target Ref Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Ref Node</em>' reference.
	 * @see #getTargetRefNode()
	 * @generated
	 */
	void setTargetRefNode(FlowNode value);

} // SecurityFlow
