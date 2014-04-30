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

import java.util.List;

import org.eclipse.bpmn2.BaseElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.Subject#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.Subject#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.Subject#getReceivedDelegations <em>Received Delegations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSubject()
 * @model abstract="true"
 * @generated
 */
public interface Subject extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.Role}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.securebpmn2.Role#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSubject_Roles()
	 * @see org.eclipse.securebpmn2.Role#getSubjects
	 * @model opposite="subjects" transient="true"
	 * @generated
	 */
	List<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.Group}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.securebpmn2.Group#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' reference list.
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSubject_Groups()
	 * @see org.eclipse.securebpmn2.Group#getSubjects
	 * @model opposite="subjects"
	 * @generated
	 */
	List<Group> getGroups();

	/**
	 * Returns the value of the '<em><b>Received Delegations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.Delegation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Received Delegations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Received Delegations</em>' reference list.
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSubject_ReceivedDelegations()
	 * @model transient="true"
	 * @generated
	 */
	List<Delegation> getReceivedDelegations();

} // Subject
