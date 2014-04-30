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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies.util;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage
 * @generated
 */
public class ConsumerpoliciesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConsumerpoliciesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerpoliciesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConsumerpoliciesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsumerpoliciesSwitch<Adapter> modelSwitch =
		new ConsumerpoliciesSwitch<Adapter>() {
			@Override
			public Adapter casePolicy(Policy object) {
				return createPolicyAdapter();
			}
			@Override
			public Adapter caseGuardedTaskPolicy(GuardedTaskPolicy object) {
				return createGuardedTaskPolicyAdapter();
			}
			@Override
			public Adapter caseMultipleGuardedTaskPolicy(MultipleGuardedTaskPolicy object) {
				return createMultipleGuardedTaskPolicyAdapter();
			}
			@Override
			public Adapter caseAllowedRolePolicy(AllowedRolePolicy object) {
				return createAllowedRolePolicyAdapter();
			}
			@Override
			public Adapter caseLevelPolicy(LevelPolicy object) {
				return createLevelPolicyAdapter();
			}
			@Override
			public Adapter caseTrustworthiness(Trustworthiness object) {
				return createTrustworthinessAdapter();
			}
			@Override
			public Adapter caseAvailability(Availability object) {
				return createAvailabilityAdapter();
			}
			@Override
			public Adapter caseIntegrity(Integrity object) {
				return createIntegrityAdapter();
			}
			@Override
			public Adapter caseNoDelegation(NoDelegation object) {
				return createNoDelegationAdapter();
			}
			@Override
			public Adapter caseNoRepudiation(NoRepudiation object) {
				return createNoRepudiationAdapter();
			}
			@Override
			public Adapter caseBindingOfDuty(BindingOfDuty object) {
				return createBindingOfDutyAdapter();
			}
			@Override
			public Adapter caseSeparationOfDuty(SeparationOfDuty object) {
				return createSeparationOfDutyAdapter();
			}
			@Override
			public Adapter caseConfidentiality(Confidentiality object) {
				return createConfidentialityAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy
	 * @generated
	 */
	public Adapter createPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy <em>Guarded Task Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy
	 * @generated
	 */
	public Adapter createGuardedTaskPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy <em>Multiple Guarded Task Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy
	 * @generated
	 */
	public Adapter createMultipleGuardedTaskPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy <em>Allowed Role Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy
	 * @generated
	 */
	public Adapter createAllowedRolePolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy <em>Level Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy
	 * @generated
	 */
	public Adapter createLevelPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness <em>Trustworthiness</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness
	 * @generated
	 */
	public Adapter createTrustworthinessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Availability <em>Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Availability
	 * @generated
	 */
	public Adapter createAvailabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity <em>Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity
	 * @generated
	 */
	public Adapter createIntegrityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation <em>No Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation
	 * @generated
	 */
	public Adapter createNoDelegationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation <em>No Repudiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation
	 * @generated
	 */
	public Adapter createNoRepudiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty <em>Binding Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty
	 * @generated
	 */
	public Adapter createBindingOfDutyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty <em>Separation Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty
	 * @generated
	 */
	public Adapter createSeparationOfDutyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality <em>Confidentiality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality
	 * @generated
	 */
	public Adapter createConfidentialityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConsumerpoliciesAdapterFactory
