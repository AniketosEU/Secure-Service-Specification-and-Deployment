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

import eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getAuditing <em>Auditing</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getMonitoring <em>Monitoring</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getProperties <em>Properties</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getResources <em>Resources</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getCorrelationSubscriptions <em>Correlation Subscriptions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getSupports <em>Supports</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getDefinitionalCollaborationRef <em>Definitional Collaboration Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#isIsClosed <em>Is Closed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#isIsExecutable <em>Is Executable</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getFilename <em>Filename</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getExecutionListeners <em>Execution Listeners</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getProcessActions <em>Process Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess()
 * @model extendedMetaData="name='tProcess' kind='elementOnly'"
 * @generated
 */
public interface Process extends CallableElement, FlowElementsContainer {
	/**
	 * Returns the value of the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auditing</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auditing</em>' containment reference.
	 * @see #setAuditing(Auditing)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Auditing()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='auditing' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	Auditing getAuditing();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getAuditing <em>Auditing</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auditing</em>' containment reference.
	 * @see #getAuditing()
	 * @generated
	 */
	void setAuditing(Auditing value);

	/**
	 * Returns the value of the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitoring</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring</em>' containment reference.
	 * @see #setMonitoring(Monitoring)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Monitoring()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='monitoring' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	Monitoring getMonitoring();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getMonitoring <em>Monitoring</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoring</em>' containment reference.
	 * @see #getMonitoring()
	 * @generated
	 */
	void setMonitoring(Monitoring value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Properties()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='property' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.Artifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifacts</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Artifacts()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='artifact' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL' group='http://www.omg.org/spec/BPMN/20100524/MODEL#artifact'"
	 * @generated
	 */
	EList<Artifact> getArtifacts();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.ResourceRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Resources()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='resourceRole' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL' group='http://www.omg.org/spec/BPMN/20100524/MODEL#resourceRole'"
	 * @generated
	 */
	EList<ResourceRole> getResources();

	/**
	 * Returns the value of the '<em><b>Correlation Subscriptions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationSubscription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Subscriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Subscriptions</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_CorrelationSubscriptions()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='correlationSubscription' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<CorrelationSubscription> getCorrelationSubscriptions();

	/**
	 * Returns the value of the '<em><b>Supports</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.Process}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Supports()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='supports' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<Process> getSupports();

	/**
	 * Returns the value of the '<em><b>Definitional Collaboration Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitional Collaboration Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitional Collaboration Ref</em>' reference.
	 * @see #setDefinitionalCollaborationRef(Collaboration)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_DefinitionalCollaborationRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='definitionalCollaborationRef'"
	 * @generated
	 */
	Collaboration getDefinitionalCollaborationRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getDefinitionalCollaborationRef <em>Definitional Collaboration Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definitional Collaboration Ref</em>' reference.
	 * @see #getDefinitionalCollaborationRef()
	 * @generated
	 */
	void setDefinitionalCollaborationRef(Collaboration value);

	/**
	 * Returns the value of the '<em><b>Is Closed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Closed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Closed</em>' attribute.
	 * @see #setIsClosed(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_IsClosed()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='isClosed'"
	 * @generated
	 */
	boolean isIsClosed();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#isIsClosed <em>Is Closed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Closed</em>' attribute.
	 * @see #isIsClosed()
	 * @generated
	 */
	void setIsClosed(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Executable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Executable</em>' attribute.
	 * @see #setIsExecutable(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_IsExecutable()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='isExecutable'"
	 * @generated
	 */
	boolean isIsExecutable();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#isIsExecutable <em>Is Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Executable</em>' attribute.
	 * @see #isIsExecutable()
	 * @generated
	 */
	void setIsExecutable(boolean value);

	/**
	 * Returns the value of the '<em><b>Process Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.model.mtm_bpmn2.ProcessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Type</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ProcessType
	 * @see #setProcessType(ProcessType)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_ProcessType()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='processType'"
	 * @generated
	 */
	ProcessType getProcessType();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getProcessType <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Type</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ProcessType
	 * @see #getProcessType()
	 * @generated
	 */
	void setProcessType(ProcessType value);

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Filename()
	 * @model default=""
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Execution Listeners</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Listeners</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Listeners</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_ExecutionListeners()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActivitiListener> getExecutionListeners();

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Process Actions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Actions</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getProcess_ProcessActions()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getProcess
	 * @model opposite="process" containment="true"
	 * @generated
	 */
	EList<ProcessAction> getProcessActions();

} // Process
