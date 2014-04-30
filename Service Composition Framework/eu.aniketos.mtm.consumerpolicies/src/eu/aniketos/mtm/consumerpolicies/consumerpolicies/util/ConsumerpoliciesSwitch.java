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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage
 * @generated
 */
public class ConsumerpoliciesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConsumerpoliciesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerpoliciesSwitch() {
		if (modelPackage == null) {
			modelPackage = ConsumerpoliciesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConsumerpoliciesPackage.POLICY: {
				Policy policy = (Policy)theEObject;
				T result = casePolicy(policy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.GUARDED_TASK_POLICY: {
				GuardedTaskPolicy guardedTaskPolicy = (GuardedTaskPolicy)theEObject;
				T result = caseGuardedTaskPolicy(guardedTaskPolicy);
				if (result == null) result = casePolicy(guardedTaskPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.MULTIPLE_GUARDED_TASK_POLICY: {
				MultipleGuardedTaskPolicy multipleGuardedTaskPolicy = (MultipleGuardedTaskPolicy)theEObject;
				T result = caseMultipleGuardedTaskPolicy(multipleGuardedTaskPolicy);
				if (result == null) result = casePolicy(multipleGuardedTaskPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.ALLOWED_ROLE_POLICY: {
				AllowedRolePolicy allowedRolePolicy = (AllowedRolePolicy)theEObject;
				T result = caseAllowedRolePolicy(allowedRolePolicy);
				if (result == null) result = casePolicy(allowedRolePolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.LEVEL_POLICY: {
				LevelPolicy levelPolicy = (LevelPolicy)theEObject;
				T result = caseLevelPolicy(levelPolicy);
				if (result == null) result = casePolicy(levelPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.TRUSTWORTHINESS: {
				Trustworthiness trustworthiness = (Trustworthiness)theEObject;
				T result = caseTrustworthiness(trustworthiness);
				if (result == null) result = caseLevelPolicy(trustworthiness);
				if (result == null) result = caseGuardedTaskPolicy(trustworthiness);
				if (result == null) result = casePolicy(trustworthiness);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.AVAILABILITY: {
				Availability availability = (Availability)theEObject;
				T result = caseAvailability(availability);
				if (result == null) result = caseLevelPolicy(availability);
				if (result == null) result = casePolicy(availability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.INTEGRITY: {
				Integrity integrity = (Integrity)theEObject;
				T result = caseIntegrity(integrity);
				if (result == null) result = casePolicy(integrity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.NO_DELEGATION: {
				NoDelegation noDelegation = (NoDelegation)theEObject;
				T result = caseNoDelegation(noDelegation);
				if (result == null) result = caseGuardedTaskPolicy(noDelegation);
				if (result == null) result = caseAllowedRolePolicy(noDelegation);
				if (result == null) result = casePolicy(noDelegation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.NO_REPUDIATION: {
				NoRepudiation noRepudiation = (NoRepudiation)theEObject;
				T result = caseNoRepudiation(noRepudiation);
				if (result == null) result = caseGuardedTaskPolicy(noRepudiation);
				if (result == null) result = casePolicy(noRepudiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.BINDING_OF_DUTY: {
				BindingOfDuty bindingOfDuty = (BindingOfDuty)theEObject;
				T result = caseBindingOfDuty(bindingOfDuty);
				if (result == null) result = caseMultipleGuardedTaskPolicy(bindingOfDuty);
				if (result == null) result = casePolicy(bindingOfDuty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.SEPARATION_OF_DUTY: {
				SeparationOfDuty separationOfDuty = (SeparationOfDuty)theEObject;
				T result = caseSeparationOfDuty(separationOfDuty);
				if (result == null) result = caseMultipleGuardedTaskPolicy(separationOfDuty);
				if (result == null) result = casePolicy(separationOfDuty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConsumerpoliciesPackage.CONFIDENTIALITY: {
				Confidentiality confidentiality = (Confidentiality)theEObject;
				T result = caseConfidentiality(confidentiality);
				if (result == null) result = caseGuardedTaskPolicy(confidentiality);
				if (result == null) result = casePolicy(confidentiality);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePolicy(Policy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guarded Task Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guarded Task Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardedTaskPolicy(GuardedTaskPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Guarded Task Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Guarded Task Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleGuardedTaskPolicy(MultipleGuardedTaskPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allowed Role Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allowed Role Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllowedRolePolicy(AllowedRolePolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Level Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Level Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLevelPolicy(LevelPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trustworthiness</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trustworthiness</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrustworthiness(Trustworthiness object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Availability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Availability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvailability(Availability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integrity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integrity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegrity(Integrity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Delegation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoDelegation(NoDelegation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Repudiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Repudiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoRepudiation(NoRepudiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Of Duty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingOfDuty(BindingOfDuty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Separation Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Separation Of Duty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeparationOfDuty(SeparationOfDuty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Confidentiality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Confidentiality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfidentiality(Confidentiality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ConsumerpoliciesSwitch
