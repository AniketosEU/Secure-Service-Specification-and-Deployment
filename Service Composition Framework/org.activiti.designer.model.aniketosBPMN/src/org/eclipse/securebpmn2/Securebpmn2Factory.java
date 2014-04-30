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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.securebpmn2.Securebpmn2Package
 * @generated
 */
public interface Securebpmn2Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Securebpmn2Factory eINSTANCE = org.eclipse.securebpmn2.impl.Securebpmn2FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Security Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Flow Node</em>'.
	 * @generated
	 */
	SecurityFlowNode createSecurityFlowNode();

	/**
	 * Returns a new object of class '<em>Security Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Security Flow</em>'.
	 * @generated
	 */
	SecurityFlow createSecurityFlow();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	Group createGroup();

	/**
	 * Returns a new object of class '<em>Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Action</em>'.
	 * @generated
	 */
	ActivityAction createActivityAction();

	/**
	 * Returns a new object of class '<em>Atomic Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Activity Action</em>'.
	 * @generated
	 */
	AtomicActivityAction createAtomicActivityAction();

	/**
	 * Returns a new object of class '<em>Composite Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Activity Action</em>'.
	 * @generated
	 */
	CompositeActivityAction createCompositeActivityAction();

	/**
	 * Returns a new object of class '<em>Permission</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Permission</em>'.
	 * @generated
	 */
	Permission createPermission();

	/**
	 * Returns a new object of class '<em>Need To Know</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Need To Know</em>'.
	 * @generated
	 */
	NeedToKnow createNeedToKnow();

	/**
	 * Returns a new object of class '<em>Separation Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Separation Of Duty</em>'.
	 * @generated
	 */
	SeparationOfDuty createSeparationOfDuty();

	/**
	 * Returns a new object of class '<em>Binding Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Of Duty</em>'.
	 * @generated
	 */
	BindingOfDuty createBindingOfDuty();

	/**
	 * Returns a new object of class '<em>Authorization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Authorization Constraint</em>'.
	 * @generated
	 */
	AuthorizationConstraint createAuthorizationConstraint();

	/**
	 * Returns a new object of class '<em>Activity Authorization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Authorization Constraint</em>'.
	 * @generated
	 */
	ActivityAuthorizationConstraint createActivityAuthorizationConstraint();

	/**
	 * Returns a new object of class '<em>Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Action</em>'.
	 * @generated
	 */
	ProcessAction createProcessAction();

	/**
	 * Returns a new object of class '<em>Atomic Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Process Action</em>'.
	 * @generated
	 */
	AtomicProcessAction createAtomicProcessAction();

	/**
	 * Returns a new object of class '<em>Composite Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Process Action</em>'.
	 * @generated
	 */
	CompositeProcessAction createCompositeProcessAction();

	/**
	 * Returns a new object of class '<em>Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item Aware Element Action</em>'.
	 * @generated
	 */
	ItemAwareElementAction createItemAwareElementAction();

	/**
	 * Returns a new object of class '<em>Atomic Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Item Aware Element Action</em>'.
	 * @generated
	 */
	AtomicItemAwareElementAction createAtomicItemAwareElementAction();

	/**
	 * Returns a new object of class '<em>Composite Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Item Aware Element Action</em>'.
	 * @generated
	 */
	CompositeItemAwareElementAction createCompositeItemAwareElementAction();

	/**
	 * Returns a new object of class '<em>Simple Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Delegation</em>'.
	 * @generated
	 */
	SimpleDelegation createSimpleDelegation();

	/**
	 * Returns a new object of class '<em>Transfer Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transfer Delegation</em>'.
	 * @generated
	 */
	TransferDelegation createTransferDelegation();

	/**
	 * Returns a new object of class '<em>Delegator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delegator</em>'.
	 * @generated
	 */
	Delegator createDelegator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Securebpmn2Package getSecurebpmn2Package();

} //Securebpmn2Factory
