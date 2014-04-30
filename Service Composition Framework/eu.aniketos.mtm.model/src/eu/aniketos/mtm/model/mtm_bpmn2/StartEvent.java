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
 * A representation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#isIsInterrupting <em>Is Interrupting</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#getFormKey <em>Form Key</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#getFormProperties <em>Form Properties</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#getInitiator <em>Initiator</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getStartEvent()
 * @model extendedMetaData="name='tStartEvent' kind='elementOnly'"
 * @generated
 */
public interface StartEvent extends CatchEvent {
	/**
	 * Returns the value of the '<em><b>Is Interrupting</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Interrupting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Interrupting</em>' attribute.
	 * @see #setIsInterrupting(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getStartEvent_IsInterrupting()
	 * @model default="true" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='isInterrupting'"
	 * @generated
	 */
	boolean isIsInterrupting();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#isIsInterrupting <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Interrupting</em>' attribute.
	 * @see #isIsInterrupting()
	 * @generated
	 */
	void setIsInterrupting(boolean value);

	/**
	 * Returns the value of the '<em><b>Form Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Key</em>' attribute.
	 * @see #setFormKey(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getStartEvent_FormKey()
	 * @model
	 * @generated
	 */
	String getFormKey();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#getFormKey <em>Form Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Form Key</em>' attribute.
	 * @see #getFormKey()
	 * @generated
	 */
	void setFormKey(String value);

	/**
	 * Returns the value of the '<em><b>Form Properties</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.FormProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Form Properties</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getStartEvent_FormProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormProperty> getFormProperties();

	/**
	 * Returns the value of the '<em><b>Initiator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiator</em>' attribute.
	 * @see #setInitiator(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getStartEvent_Initiator()
	 * @model
	 * @generated
	 */
	String getInitiator();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent#getInitiator <em>Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiator</em>' attribute.
	 * @see #getInitiator()
	 * @generated
	 */
	void setInitiator(String value);

} // StartEvent
