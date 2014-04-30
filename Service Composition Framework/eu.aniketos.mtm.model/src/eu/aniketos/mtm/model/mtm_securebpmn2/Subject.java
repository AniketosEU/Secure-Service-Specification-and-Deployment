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
package eu.aniketos.mtm.model.mtm_securebpmn2;

import eu.aniketos.mtm.model.mtm_bpmn2.BaseElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getRoles <em>Roles</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getGroups <em>Groups</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getReceivedDelegations <em>Received Delegations</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getSubject()
 * @model abstract="true"
 * @generated
 */
public interface Subject extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Role}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getSubject_Roles()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getSubjects
	 * @model opposite="subjects" transient="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Group}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Group#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getSubject_Groups()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Group#getSubjects
	 * @model opposite="subjects"
	 * @generated
	 */
	EList<Group> getGroups();

	/**
	 * Returns the value of the '<em><b>Received Delegations</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Received Delegations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Received Delegations</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getSubject_ReceivedDelegations()
	 * @model transient="true"
	 * @generated
	 */
	EList<Delegation> getReceivedDelegations();

} // Subject
