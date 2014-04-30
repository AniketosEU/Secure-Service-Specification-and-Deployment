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
 * A representation of the model object '<em><b>Catch Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getDataOutputs <em>Data Outputs</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getDataOutputAssociation <em>Data Output Association</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getOutputSet <em>Output Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getEventDefinitions <em>Event Definitions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getEventDefinitionRefs <em>Event Definition Refs</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#isParallelMultiple <em>Parallel Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent()
 * @model abstract="true"
 *        extendedMetaData="name='tCatchEvent' kind='elementOnly'"
 * @generated
 */
public interface CatchEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Data Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.DataOutput}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Outputs</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_DataOutputs()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='dataOutput' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<DataOutput> getDataOutputs();

	/**
	 * Returns the value of the '<em><b>Data Output Association</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.DataOutputAssociation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Output Association</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Output Association</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_DataOutputAssociation()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='dataOutputAssociation' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<DataOutputAssociation> getDataOutputAssociation();

	/**
	 * Returns the value of the '<em><b>Output Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Set</em>' containment reference.
	 * @see #setOutputSet(OutputSet)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_OutputSet()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='outputSet' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	OutputSet getOutputSet();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#getOutputSet <em>Output Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Set</em>' containment reference.
	 * @see #getOutputSet()
	 * @generated
	 */
	void setOutputSet(OutputSet value);

	/**
	 * Returns the value of the '<em><b>Event Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Definitions</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_EventDefinitions()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='eventDefinition' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL' group='http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition'"
	 * @generated
	 */
	EList<EventDefinition> getEventDefinitions();

	/**
	 * Returns the value of the '<em><b>Event Definition Refs</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Definition Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Definition Refs</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_EventDefinitionRefs()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='eventDefinitionRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<EventDefinition> getEventDefinitionRefs();

	/**
	 * Returns the value of the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel Multiple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel Multiple</em>' attribute.
	 * @see #setParallelMultiple(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCatchEvent_ParallelMultiple()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='parallelMultiple'"
	 * @generated
	 */
	boolean isParallelMultiple();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent#isParallelMultiple <em>Parallel Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel Multiple</em>' attribute.
	 * @see #isParallelMultiple()
	 * @generated
	 */
	void setParallelMultiple(boolean value);

} // CatchEvent
