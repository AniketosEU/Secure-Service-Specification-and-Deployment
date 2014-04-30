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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trustworthiness</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.TrustworthinessImpl#getGuardedTask <em>Guarded Task</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrustworthinessImpl extends LevelPolicyImpl implements Trustworthiness {
	/**
	 * The default value of the '{@link #getGuardedTask() <em>Guarded Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardedTask()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARDED_TASK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuardedTask() <em>Guarded Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardedTask()
	 * @generated
	 * @ordered
	 */
	protected String guardedTask = GUARDED_TASK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TrustworthinessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConsumerpoliciesPackage.Literals.TRUSTWORTHINESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuardedTask() {
		return guardedTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardedTask(String newGuardedTask) {
		String oldGuardedTask = guardedTask;
		guardedTask = newGuardedTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK, oldGuardedTask, guardedTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK:
				return getGuardedTask();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK:
				setGuardedTask((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK:
				setGuardedTask(GUARDED_TASK_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK:
				return GUARDED_TASK_EDEFAULT == null ? guardedTask != null : !GUARDED_TASK_EDEFAULT.equals(guardedTask);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == GuardedTaskPolicy.class) {
			switch (derivedFeatureID) {
				case ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK: return ConsumerpoliciesPackage.GUARDED_TASK_POLICY__GUARDED_TASK;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GuardedTaskPolicy.class) {
			switch (baseFeatureID) {
				case ConsumerpoliciesPackage.GUARDED_TASK_POLICY__GUARDED_TASK: return ConsumerpoliciesPackage.TRUSTWORTHINESS__GUARDED_TASK;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (guardedTask: ");
		result.append(guardedTask);
		result.append(')');
		return result.toString();
	}

} //TrustworthinessImpl
