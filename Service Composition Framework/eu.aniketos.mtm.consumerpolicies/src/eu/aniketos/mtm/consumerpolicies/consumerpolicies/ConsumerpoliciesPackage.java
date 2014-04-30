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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesFactory
 * @model kind="package"
 *        annotation="emf.gen basePackage='eu.aniketos.mtm.consumerpolicies'"
 * @generated
 */
public interface ConsumerpoliciesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "consumerpolicies";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eu.aniketos.mtm/consumerpolicies";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ConsumerPolicies";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConsumerpoliciesPackage eINSTANCE = eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.PolicyImpl <em>Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.PolicyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getPolicy()
	 * @generated
	 */
	int POLICY = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY__ID = 0;

	/**
	 * The number of structural features of the '<em>Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLICY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.GuardedTaskPolicyImpl <em>Guarded Task Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.GuardedTaskPolicyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getGuardedTaskPolicy()
	 * @generated
	 */
	int GUARDED_TASK_POLICY = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_TASK_POLICY__ID = POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_TASK_POLICY__GUARDED_TASK = POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guarded Task Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARDED_TASK_POLICY_FEATURE_COUNT = POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.MultipleGuardedTaskPolicyImpl <em>Multiple Guarded Task Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.MultipleGuardedTaskPolicyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getMultipleGuardedTaskPolicy()
	 * @generated
	 */
	int MULTIPLE_GUARDED_TASK_POLICY = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_GUARDED_TASK_POLICY__ID = POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Tasks</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_GUARDED_TASK_POLICY__GUARDED_TASKS = POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple Guarded Task Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_GUARDED_TASK_POLICY_FEATURE_COUNT = POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AllowedRolePolicyImpl <em>Allowed Role Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AllowedRolePolicyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getAllowedRolePolicy()
	 * @generated
	 */
	int ALLOWED_ROLE_POLICY = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOWED_ROLE_POLICY__ID = POLICY__ID;

	/**
	 * The feature id for the '<em><b>Allowed Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOWED_ROLE_POLICY__ALLOWED_ROLE = POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Allowed Role Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOWED_ROLE_POLICY_FEATURE_COUNT = POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.LevelPolicyImpl <em>Level Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.LevelPolicyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getLevelPolicy()
	 * @generated
	 */
	int LEVEL_POLICY = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_POLICY__ID = POLICY__ID;

	/**
	 * The feature id for the '<em><b>Min Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_POLICY__MIN_LEVEL = POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Level Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_POLICY_FEATURE_COUNT = POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.TrustworthinessImpl <em>Trustworthiness</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.TrustworthinessImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getTrustworthiness()
	 * @generated
	 */
	int TRUSTWORTHINESS = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__ID = LEVEL_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Min Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__MIN_LEVEL = LEVEL_POLICY__MIN_LEVEL;

	/**
	 * The feature id for the '<em><b>Guarded Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__GUARDED_TASK = LEVEL_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trustworthiness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_FEATURE_COUNT = LEVEL_POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AvailabilityImpl <em>Availability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AvailabilityImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getAvailability()
	 * @generated
	 */
	int AVAILABILITY = 6;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY__ID = LEVEL_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Min Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY__MIN_LEVEL = LEVEL_POLICY__MIN_LEVEL;

	/**
	 * The number of structural features of the '<em>Availability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_FEATURE_COUNT = LEVEL_POLICY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl <em>Integrity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getIntegrity()
	 * @generated
	 */
	int INTEGRITY = 7;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__ID = POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__GUARDED_SENDER = POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processing Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__PROCESSING_SERVICE = POLICY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generating Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__GENERATING_SERVICE = POLICY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__ALGORITHM = POLICY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Integrity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_FEATURE_COUNT = POLICY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoDelegationImpl <em>No Delegation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoDelegationImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getNoDelegation()
	 * @generated
	 */
	int NO_DELEGATION = 8;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_DELEGATION__ID = GUARDED_TASK_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_DELEGATION__GUARDED_TASK = GUARDED_TASK_POLICY__GUARDED_TASK;

	/**
	 * The feature id for the '<em><b>Allowed Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_DELEGATION__ALLOWED_ROLE = GUARDED_TASK_POLICY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>No Delegation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_DELEGATION_FEATURE_COUNT = GUARDED_TASK_POLICY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoRepudiationImpl <em>No Repudiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoRepudiationImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getNoRepudiation()
	 * @generated
	 */
	int NO_REPUDIATION = 9;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_REPUDIATION__ID = GUARDED_TASK_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_REPUDIATION__GUARDED_TASK = GUARDED_TASK_POLICY__GUARDED_TASK;

	/**
	 * The number of structural features of the '<em>No Repudiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_REPUDIATION_FEATURE_COUNT = GUARDED_TASK_POLICY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.BindingOfDutyImpl <em>Binding Of Duty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.BindingOfDutyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getBindingOfDuty()
	 * @generated
	 */
	int BINDING_OF_DUTY = 10;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__ID = MULTIPLE_GUARDED_TASK_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Tasks</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__GUARDED_TASKS = MULTIPLE_GUARDED_TASK_POLICY__GUARDED_TASKS;

	/**
	 * The number of structural features of the '<em>Binding Of Duty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY_FEATURE_COUNT = MULTIPLE_GUARDED_TASK_POLICY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.SeparationOfDutyImpl <em>Separation Of Duty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.SeparationOfDutyImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getSeparationOfDuty()
	 * @generated
	 */
	int SEPARATION_OF_DUTY = 11;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__ID = MULTIPLE_GUARDED_TASK_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Tasks</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__GUARDED_TASKS = MULTIPLE_GUARDED_TASK_POLICY__GUARDED_TASKS;

	/**
	 * The number of structural features of the '<em>Separation Of Duty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY_FEATURE_COUNT = MULTIPLE_GUARDED_TASK_POLICY_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl <em>Confidentiality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getConfidentiality()
	 * @generated
	 */
	int CONFIDENTIALITY = 12;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__ID = GUARDED_TASK_POLICY__ID;

	/**
	 * The feature id for the '<em><b>Guarded Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__GUARDED_TASK = GUARDED_TASK_POLICY__GUARDED_TASK;

	/**
	 * The feature id for the '<em><b>Input Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__INPUT_SUITE = GUARDED_TASK_POLICY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__OUTPUT_SUITE = GUARDED_TASK_POLICY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Confidentiality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_FEATURE_COUNT = GUARDED_TASK_POLICY_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Policy</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy
	 * @generated
	 */
	EClass getPolicy();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy#getID()
	 * @see #getPolicy()
	 * @generated
	 */
	EAttribute getPolicy_ID();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy <em>Guarded Task Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guarded Task Policy</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy
	 * @generated
	 */
	EClass getGuardedTaskPolicy();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy#getGuardedTask <em>Guarded Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guarded Task</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy#getGuardedTask()
	 * @see #getGuardedTaskPolicy()
	 * @generated
	 */
	EAttribute getGuardedTaskPolicy_GuardedTask();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy <em>Multiple Guarded Task Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple Guarded Task Policy</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy
	 * @generated
	 */
	EClass getMultipleGuardedTaskPolicy();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy#getGuardedTasks <em>Guarded Tasks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Guarded Tasks</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy#getGuardedTasks()
	 * @see #getMultipleGuardedTaskPolicy()
	 * @generated
	 */
	EAttribute getMultipleGuardedTaskPolicy_GuardedTasks();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy <em>Allowed Role Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allowed Role Policy</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy
	 * @generated
	 */
	EClass getAllowedRolePolicy();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy#getAllowedRole <em>Allowed Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allowed Role</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy#getAllowedRole()
	 * @see #getAllowedRolePolicy()
	 * @generated
	 */
	EAttribute getAllowedRolePolicy_AllowedRole();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy <em>Level Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level Policy</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy
	 * @generated
	 */
	EClass getLevelPolicy();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy#getMinLevel <em>Min Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Level</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy#getMinLevel()
	 * @see #getLevelPolicy()
	 * @generated
	 */
	EAttribute getLevelPolicy_MinLevel();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness <em>Trustworthiness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trustworthiness</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness
	 * @generated
	 */
	EClass getTrustworthiness();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Availability <em>Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Availability</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Availability
	 * @generated
	 */
	EClass getAvailability();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity <em>Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integrity</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity
	 * @generated
	 */
	EClass getIntegrity();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGuardedSender <em>Guarded Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guarded Sender</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGuardedSender()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_GuardedSender();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getProcessingService <em>Processing Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processing Service</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getProcessingService()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_ProcessingService();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGeneratingService <em>Generating Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generating Service</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGeneratingService()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_GeneratingService();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getAlgorithm()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_Algorithm();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation <em>No Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Delegation</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation
	 * @generated
	 */
	EClass getNoDelegation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation <em>No Repudiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Repudiation</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation
	 * @generated
	 */
	EClass getNoRepudiation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty <em>Binding Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Of Duty</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty
	 * @generated
	 */
	EClass getBindingOfDuty();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty <em>Separation Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Separation Of Duty</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty
	 * @generated
	 */
	EClass getSeparationOfDuty();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality <em>Confidentiality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Confidentiality</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality
	 * @generated
	 */
	EClass getConfidentiality();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getInputSuite <em>Input Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Suite</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getInputSuite()
	 * @see #getConfidentiality()
	 * @generated
	 */
	EAttribute getConfidentiality_InputSuite();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getOutputSuite <em>Output Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Suite</em>'.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getOutputSuite()
	 * @see #getConfidentiality()
	 * @generated
	 */
	EAttribute getConfidentiality_OutputSuite();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConsumerpoliciesFactory getConsumerpoliciesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.PolicyImpl <em>Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.PolicyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getPolicy()
		 * @generated
		 */
		EClass POLICY = eINSTANCE.getPolicy();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POLICY__ID = eINSTANCE.getPolicy_ID();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.GuardedTaskPolicyImpl <em>Guarded Task Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.GuardedTaskPolicyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getGuardedTaskPolicy()
		 * @generated
		 */
		EClass GUARDED_TASK_POLICY = eINSTANCE.getGuardedTaskPolicy();

		/**
		 * The meta object literal for the '<em><b>Guarded Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARDED_TASK_POLICY__GUARDED_TASK = eINSTANCE.getGuardedTaskPolicy_GuardedTask();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.MultipleGuardedTaskPolicyImpl <em>Multiple Guarded Task Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.MultipleGuardedTaskPolicyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getMultipleGuardedTaskPolicy()
		 * @generated
		 */
		EClass MULTIPLE_GUARDED_TASK_POLICY = eINSTANCE.getMultipleGuardedTaskPolicy();

		/**
		 * The meta object literal for the '<em><b>Guarded Tasks</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLE_GUARDED_TASK_POLICY__GUARDED_TASKS = eINSTANCE.getMultipleGuardedTaskPolicy_GuardedTasks();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AllowedRolePolicyImpl <em>Allowed Role Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AllowedRolePolicyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getAllowedRolePolicy()
		 * @generated
		 */
		EClass ALLOWED_ROLE_POLICY = eINSTANCE.getAllowedRolePolicy();

		/**
		 * The meta object literal for the '<em><b>Allowed Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALLOWED_ROLE_POLICY__ALLOWED_ROLE = eINSTANCE.getAllowedRolePolicy_AllowedRole();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.LevelPolicyImpl <em>Level Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.LevelPolicyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getLevelPolicy()
		 * @generated
		 */
		EClass LEVEL_POLICY = eINSTANCE.getLevelPolicy();

		/**
		 * The meta object literal for the '<em><b>Min Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL_POLICY__MIN_LEVEL = eINSTANCE.getLevelPolicy_MinLevel();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.TrustworthinessImpl <em>Trustworthiness</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.TrustworthinessImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getTrustworthiness()
		 * @generated
		 */
		EClass TRUSTWORTHINESS = eINSTANCE.getTrustworthiness();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AvailabilityImpl <em>Availability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.AvailabilityImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getAvailability()
		 * @generated
		 */
		EClass AVAILABILITY = eINSTANCE.getAvailability();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl <em>Integrity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getIntegrity()
		 * @generated
		 */
		EClass INTEGRITY = eINSTANCE.getIntegrity();

		/**
		 * The meta object literal for the '<em><b>Guarded Sender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__GUARDED_SENDER = eINSTANCE.getIntegrity_GuardedSender();

		/**
		 * The meta object literal for the '<em><b>Processing Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__PROCESSING_SERVICE = eINSTANCE.getIntegrity_ProcessingService();

		/**
		 * The meta object literal for the '<em><b>Generating Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__GENERATING_SERVICE = eINSTANCE.getIntegrity_GeneratingService();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__ALGORITHM = eINSTANCE.getIntegrity_Algorithm();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoDelegationImpl <em>No Delegation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoDelegationImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getNoDelegation()
		 * @generated
		 */
		EClass NO_DELEGATION = eINSTANCE.getNoDelegation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoRepudiationImpl <em>No Repudiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.NoRepudiationImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getNoRepudiation()
		 * @generated
		 */
		EClass NO_REPUDIATION = eINSTANCE.getNoRepudiation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.BindingOfDutyImpl <em>Binding Of Duty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.BindingOfDutyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getBindingOfDuty()
		 * @generated
		 */
		EClass BINDING_OF_DUTY = eINSTANCE.getBindingOfDuty();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.SeparationOfDutyImpl <em>Separation Of Duty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.SeparationOfDutyImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getSeparationOfDuty()
		 * @generated
		 */
		EClass SEPARATION_OF_DUTY = eINSTANCE.getSeparationOfDuty();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl <em>Confidentiality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl
		 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConsumerpoliciesPackageImpl#getConfidentiality()
		 * @generated
		 */
		EClass CONFIDENTIALITY = eINSTANCE.getConfidentiality();

		/**
		 * The meta object literal for the '<em><b>Input Suite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY__INPUT_SUITE = eINSTANCE.getConfidentiality_InputSuite();

		/**
		 * The meta object literal for the '<em><b>Output Suite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY__OUTPUT_SUITE = eINSTANCE.getConfidentiality_OutputSuite();

	}

} //ConsumerpoliciesPackage
