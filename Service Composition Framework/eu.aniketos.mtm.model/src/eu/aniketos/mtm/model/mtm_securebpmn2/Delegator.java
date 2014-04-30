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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delegator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getParentDelegators <em>Parent Delegators</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getChildDelegators <em>Child Delegators</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getMaxDelegationDepth <em>Max Delegation Depth</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getExecutedDelegations <em>Executed Delegations</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegator()
 * @model
 * @generated
 */
public interface Delegator extends User {
	/**
	 * Returns the value of the '<em><b>Parent Delegators</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getChildDelegators <em>Child Delegators</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Delegators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Delegators</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegator_ParentDelegators()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getChildDelegators
	 * @model opposite="childDelegators"
	 * @generated
	 */
	EList<Delegator> getParentDelegators();

	/**
	 * Returns the value of the '<em><b>Child Delegators</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getParentDelegators <em>Parent Delegators</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Delegators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Delegators</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegator_ChildDelegators()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getParentDelegators
	 * @model opposite="parentDelegators"
	 * @generated
	 */
	EList<Delegator> getChildDelegators();

	/**
	 * Returns the value of the '<em><b>Max Delegation Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Delegation Depth</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Delegation Depth</em>' attribute.
	 * @see #setMaxDelegationDepth(int)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegator_MaxDelegationDepth()
	 * @model
	 * @generated
	 */
	int getMaxDelegationDepth();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getMaxDelegationDepth <em>Max Delegation Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Delegation Depth</em>' attribute.
	 * @see #getMaxDelegationDepth()
	 * @generated
	 */
	void setMaxDelegationDepth(int value);

	/**
	 * Returns the value of the '<em><b>Executed Delegations</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executed Delegations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executed Delegations</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getDelegator_ExecutedDelegations()
	 * @model transient="true"
	 * @generated
	 */
	EList<Delegation> getExecutedDelegations();

} // Delegator
