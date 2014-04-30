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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throw Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.ThrowEvent#getDataInputs <em>Data Inputs</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ThrowEvent#getDataInputAssociation <em>Data Input Association</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ThrowEvent#getInputSet <em>Input Set</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ThrowEvent#getEventDefinitions <em>Event Definitions</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ThrowEvent#getEventDefinitionRefs <em>Event Definition Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent()
 * @model abstract="true"
 *        extendedMetaData="name='tThrowEvent' kind='elementOnly'"
 * @generated
 */
public interface ThrowEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Data Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.DataInput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Inputs</em>' containment reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent_DataInputs()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='dataInput' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	List<DataInput> getDataInputs();

	/**
	 * Returns the value of the '<em><b>Data Input Association</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.DataInputAssociation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Input Association</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Input Association</em>' containment reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent_DataInputAssociation()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='dataInputAssociation' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	List<DataInputAssociation> getDataInputAssociation();

	/**
	 * Returns the value of the '<em><b>Input Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Set</em>' containment reference.
	 * @see #setInputSet(InputSet)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent_InputSet()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='inputSet' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	InputSet getInputSet();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ThrowEvent#getInputSet <em>Input Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Set</em>' containment reference.
	 * @see #getInputSet()
	 * @generated
	 */
	void setInputSet(InputSet value);

	/**
	 * Returns the value of the '<em><b>Event Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Definitions</em>' containment reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent_EventDefinitions()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='eventDefinition' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL' group='http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition'"
	 * @generated
	 */
	List<EventDefinition> getEventDefinitions();

	/**
	 * Returns the value of the '<em><b>Event Definition Refs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Definition Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Definition Refs</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getThrowEvent_EventDefinitionRefs()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='eventDefinitionRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	List<EventDefinition> getEventDefinitionRefs();

} // ThrowEvent
