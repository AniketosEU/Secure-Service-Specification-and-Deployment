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
package eu.aniketos.mtm.model.mtm_securebpmn2.impl;

import eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty;
import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding Of Duty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl#getMaxUsers <em>Max Users</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl#getSameUserActionCount <em>Same User Action Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BindingOfDutyImpl extends AuthorizationConstraintImpl implements BindingOfDuty {
	/**
	 * The default value of the '{@link #getMaxUsers() <em>Max Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxUsers()
	 * @generated
	 * @ordered
	 */
	protected static final Integer MAX_USERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxUsers() <em>Max Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxUsers()
	 * @generated
	 * @ordered
	 */
	protected Integer maxUsers = MAX_USERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSameUserActionCount() <em>Same User Action Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSameUserActionCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SAME_USER_ACTION_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSameUserActionCount() <em>Same User Action Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSameUserActionCount()
	 * @generated
	 * @ordered
	 */
	protected Integer sameUserActionCount = SAME_USER_ACTION_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingOfDutyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.BINDING_OF_DUTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMaxUsers() {
		return maxUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxUsers(Integer newMaxUsers) {
		Integer oldMaxUsers = maxUsers;
		maxUsers = newMaxUsers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.BINDING_OF_DUTY__MAX_USERS, oldMaxUsers, maxUsers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getSameUserActionCount() {
		return sameUserActionCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameUserActionCount(Integer newSameUserActionCount) {
		Integer oldSameUserActionCount = sameUserActionCount;
		sameUserActionCount = newSameUserActionCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.BINDING_OF_DUTY__SAME_USER_ACTION_COUNT, oldSameUserActionCount, sameUserActionCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Securebpmn2Package.BINDING_OF_DUTY__MAX_USERS:
				return getMaxUsers();
			case Securebpmn2Package.BINDING_OF_DUTY__SAME_USER_ACTION_COUNT:
				return getSameUserActionCount();
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
			case Securebpmn2Package.BINDING_OF_DUTY__MAX_USERS:
				setMaxUsers((Integer)newValue);
				return;
			case Securebpmn2Package.BINDING_OF_DUTY__SAME_USER_ACTION_COUNT:
				setSameUserActionCount((Integer)newValue);
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
			case Securebpmn2Package.BINDING_OF_DUTY__MAX_USERS:
				setMaxUsers(MAX_USERS_EDEFAULT);
				return;
			case Securebpmn2Package.BINDING_OF_DUTY__SAME_USER_ACTION_COUNT:
				setSameUserActionCount(SAME_USER_ACTION_COUNT_EDEFAULT);
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
			case Securebpmn2Package.BINDING_OF_DUTY__MAX_USERS:
				return MAX_USERS_EDEFAULT == null ? maxUsers != null : !MAX_USERS_EDEFAULT.equals(maxUsers);
			case Securebpmn2Package.BINDING_OF_DUTY__SAME_USER_ACTION_COUNT:
				return SAME_USER_ACTION_COUNT_EDEFAULT == null ? sameUserActionCount != null : !SAME_USER_ACTION_COUNT_EDEFAULT.equals(sameUserActionCount);
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
		result.append(" (maxUsers: ");
		result.append(maxUsers);
		result.append(", sameUserActionCount: ");
		result.append(sameUserActionCount);
		result.append(')');
		return result.toString();
	}

} //BindingOfDutyImpl
