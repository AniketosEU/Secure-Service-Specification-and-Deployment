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
 * A representation of the model object '<em><b>Activiti Listener</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getEvent <em>Event</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getFieldExtensions <em>Field Extensions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getRunAs <em>Run As</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getScriptProcessor <em>Script Processor</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener()
 * @model
 * @generated
 */
public interface ActivitiListener extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see #setImplementationType(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_ImplementationType()
	 * @model
	 * @generated
	 */
	String getImplementationType();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see #getImplementationType()
	 * @generated
	 */
	void setImplementationType(String value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_Implementation()
	 * @model
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' attribute.
	 * @see #setEvent(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_Event()
	 * @model
	 * @generated
	 */
	String getEvent();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getEvent <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' attribute.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(String value);

	/**
	 * Returns the value of the '<em><b>Field Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Extensions</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_FieldExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<FieldExtension> getFieldExtensions();

	/**
	 * Returns the value of the '<em><b>Run As</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run As</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run As</em>' attribute.
	 * @see #setRunAs(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_RunAs()
	 * @model
	 * @generated
	 */
	String getRunAs();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getRunAs <em>Run As</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run As</em>' attribute.
	 * @see #getRunAs()
	 * @generated
	 */
	void setRunAs(String value);

	/**
	 * Returns the value of the '<em><b>Script Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Processor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Processor</em>' attribute.
	 * @see #setScriptProcessor(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getActivitiListener_ScriptProcessor()
	 * @model
	 * @generated
	 */
	String getScriptProcessor();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener#getScriptProcessor <em>Script Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Processor</em>' attribute.
	 * @see #getScriptProcessor()
	 * @generated
	 */
	void setScriptProcessor(String value);

} // ActivitiListener
