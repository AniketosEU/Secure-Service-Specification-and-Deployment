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
 * A representation of the model object '<em><b>User Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getRenderings <em>Renderings</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getAssignee <em>Assignee</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getCandidateUsers <em>Candidate Users</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getCandidateGroups <em>Candidate Groups</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getFormKey <em>Form Key</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getFormProperties <em>Form Properties</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getPriority <em>Priority</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getDueDate <em>Due Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask()
 * @model extendedMetaData="name='tUserTask' kind='elementOnly'"
 * @generated
 */
public interface UserTask extends Task {
	/**
	 * Returns the value of the '<em><b>Renderings</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.Rendering}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderings</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_Renderings()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='rendering' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<Rendering> getRenderings();

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
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_Implementation()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='implementation'"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Assignee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignee</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignee</em>' attribute.
	 * @see #setAssignee(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_Assignee()
	 * @model
	 * @generated
	 */
	String getAssignee();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getAssignee <em>Assignee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignee</em>' attribute.
	 * @see #getAssignee()
	 * @generated
	 */
	void setAssignee(String value);

	/**
	 * Returns the value of the '<em><b>Candidate Users</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.CandidateUser}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate Users</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate Users</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_CandidateUsers()
	 * @model containment="true"
	 * @generated
	 */
	EList<CandidateUser> getCandidateUsers();

	/**
	 * Returns the value of the '<em><b>Candidate Groups</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.CandidateGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate Groups</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_CandidateGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<CandidateGroup> getCandidateGroups();

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
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_FormKey()
	 * @model
	 * @generated
	 */
	String getFormKey();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getFormKey <em>Form Key</em>}' attribute.
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
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_FormProperties()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormProperty> getFormProperties();

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(Integer)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_Priority()
	 * @model
	 * @generated
	 */
	Integer getPriority();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Integer value);

	/**
	 * Returns the value of the '<em><b>Due Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Due Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Due Date</em>' attribute.
	 * @see #setDueDate(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getUserTask_DueDate()
	 * @model
	 * @generated
	 */
	String getDueDate();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask#getDueDate <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Due Date</em>' attribute.
	 * @see #getDueDate()
	 * @generated
	 */
	void setDueDate(String value);

} // UserTask
