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
package org.eclipse.securebpmn2.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.securebpmn2.Securebpmn2Package;
import org.eclipse.securebpmn2.SeparationOfDuty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Separation Of Duty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.impl.SeparationOfDutyImpl#getMinimumUsers <em>Minimum Users</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.SeparationOfDutyImpl#getMaxUserActionsPermitted <em>Max User Actions Permitted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeparationOfDutyImpl extends AuthorizationConstraintImpl implements SeparationOfDuty {
	/**
	 * The default value of the '{@link #getMinimumUsers() <em>Minimum Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumUsers()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MINIMUM_USERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinimumUsers() <em>Minimum Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumUsers()
	 * @generated
	 * @ordered
	 */
	protected Integer minimumUsers = MINIMUM_USERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxUserActionsPermitted() <em>Max User Actions Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxUserActionsPermitted()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_USER_ACTIONS_PERMITTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxUserActionsPermitted() <em>Max User Actions Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxUserActionsPermitted()
	 * @generated
	 * @ordered
	 */
	protected Integer maxUserActionsPermitted = MAX_USER_ACTIONS_PERMITTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeparationOfDutyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.SEPARATION_OF_DUTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMinimumUsers() {
		return minimumUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumUsers(Integer newMinimumUsers) {
		Integer oldMinimumUsers = minimumUsers;
		minimumUsers = newMinimumUsers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SEPARATION_OF_DUTY__MINIMUM_USERS, oldMinimumUsers, minimumUsers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxUserActionsPermitted() {
		return maxUserActionsPermitted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxUserActionsPermitted(Integer newMaxUserActionsPermitted) {
		Integer oldMaxUserActionsPermitted = maxUserActionsPermitted;
		maxUserActionsPermitted = newMaxUserActionsPermitted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED, oldMaxUserActionsPermitted, maxUserActionsPermitted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Securebpmn2Package.SEPARATION_OF_DUTY__MINIMUM_USERS:
				return getMinimumUsers();
			case Securebpmn2Package.SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED:
				return getMaxUserActionsPermitted();
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
			case Securebpmn2Package.SEPARATION_OF_DUTY__MINIMUM_USERS:
				setMinimumUsers((Integer)newValue);
				return;
			case Securebpmn2Package.SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED:
				setMaxUserActionsPermitted((Integer)newValue);
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
			case Securebpmn2Package.SEPARATION_OF_DUTY__MINIMUM_USERS:
				setMinimumUsers(MINIMUM_USERS_EDEFAULT);
				return;
			case Securebpmn2Package.SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED:
				setMaxUserActionsPermitted(MAX_USER_ACTIONS_PERMITTED_EDEFAULT);
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
			case Securebpmn2Package.SEPARATION_OF_DUTY__MINIMUM_USERS:
				return MINIMUM_USERS_EDEFAULT == null ? minimumUsers != null : !MINIMUM_USERS_EDEFAULT.equals(minimumUsers);
			case Securebpmn2Package.SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED:
				return MAX_USER_ACTIONS_PERMITTED_EDEFAULT == null ? maxUserActionsPermitted != null : !MAX_USER_ACTIONS_PERMITTED_EDEFAULT.equals(maxUserActionsPermitted);
		}
		return super.eIsSet(featureID);
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
		result.append(" (minimumUsers: ");
		result.append(minimumUsers);
		result.append(", maxUserActionsPermitted: ");
		result.append(maxUserActionsPermitted);
		result.append(')');
		return result.toString();
	}

} //SeparationOfDutyImpl
