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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Gateway#getGatewayDirection <em>Gateway Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getGateway()
 * @model abstract="true"
 *        extendedMetaData="name='tGateway' kind='elementOnly'"
 * @generated
 */
public interface Gateway extends FlowNode {
	/**
	 * Returns the value of the '<em><b>Gateway Direction</b></em>' attribute.
	 * The default value is <code>"unspecified"</code>.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.model.mtm_bpmn2.GatewayDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway Direction</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GatewayDirection
	 * @see #setGatewayDirection(GatewayDirection)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getGateway_GatewayDirection()
	 * @model default="unspecified" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='gatewayDirection'"
	 * @generated
	 */
	GatewayDirection getGatewayDirection();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Gateway#getGatewayDirection <em>Gateway Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway Direction</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GatewayDirection
	 * @see #getGatewayDirection()
	 * @generated
	 */
	void setGatewayDirection(GatewayDirection value);

} // Gateway
