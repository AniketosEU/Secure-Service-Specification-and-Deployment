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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Based Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.EventBasedGateway#getEventGatewayType <em>Event Gateway Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.EventBasedGateway#isInstantiate <em>Instantiate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getEventBasedGateway()
 * @model extendedMetaData="name='tEventBasedGateway' kind='elementOnly'"
 * @generated
 */
public interface EventBasedGateway extends Gateway {
	/**
	 * Returns the value of the '<em><b>Event Gateway Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.bpmn2.EventBasedGatewayType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Gateway Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Gateway Type</em>' attribute.
	 * @see org.eclipse.bpmn2.EventBasedGatewayType
	 * @see #setEventGatewayType(EventBasedGatewayType)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getEventBasedGateway_EventGatewayType()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='eventGatewayType'"
	 * @generated
	 */
	EventBasedGatewayType getEventGatewayType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.EventBasedGateway#getEventGatewayType <em>Event Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Gateway Type</em>' attribute.
	 * @see org.eclipse.bpmn2.EventBasedGatewayType
	 * @see #getEventGatewayType()
	 * @generated
	 */
	void setEventGatewayType(EventBasedGatewayType value);

	/**
	 * Returns the value of the '<em><b>Instantiate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiate</em>' attribute.
	 * @see #setInstantiate(boolean)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getEventBasedGateway_Instantiate()
	 * @model default="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='instantiate'"
	 * @generated
	 */
	boolean isInstantiate();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.EventBasedGateway#isInstantiate <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instantiate</em>' attribute.
	 * @see #isInstantiate()
	 * @generated
	 */
	void setInstantiate(boolean value);

} // EventBasedGateway
