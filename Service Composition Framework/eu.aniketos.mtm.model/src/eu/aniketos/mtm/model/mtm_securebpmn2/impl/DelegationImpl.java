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

import eu.aniketos.mtm.model.mtm_bpmn2.impl.BaseElementImpl;

import eu.aniketos.mtm.model.mtm_securebpmn2.Delegation;
import eu.aniketos.mtm.model.mtm_securebpmn2.Delegator;
import eu.aniketos.mtm.model.mtm_securebpmn2.Permission;
import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;
import eu.aniketos.mtm.model.mtm_securebpmn2.Subject;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl#getDelegator <em>Delegator</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl#getDelegatee <em>Delegatee</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl#isNegotiable <em>Negotiable</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl#getDelegatablePermissions <em>Delegatable Permissions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DelegationImpl extends BaseElementImpl implements Delegation {
	/**
	 * The cached value of the '{@link #getDelegator() <em>Delegator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegator()
	 * @generated
	 * @ordered
	 */
	protected Delegator delegator;

	/**
	 * The cached value of the '{@link #getDelegatee() <em>Delegatee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegatee()
	 * @generated
	 * @ordered
	 */
	protected Subject delegatee;

	/**
	 * The default value of the '{@link #isNegotiable() <em>Negotiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegotiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEGOTIABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNegotiable() <em>Negotiable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegotiable()
	 * @generated
	 * @ordered
	 */
	protected boolean negotiable = NEGOTIABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPermissions() <em>Permissions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissions()
	 * @generated
	 * @ordered
	 */
	protected EList<Permission> permissions;

	/**
	 * The cached value of the '{@link #getDelegatablePermissions() <em>Delegatable Permissions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegatablePermissions()
	 * @generated
	 * @ordered
	 */
	protected EList<Permission> delegatablePermissions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelegationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.DELEGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delegator getDelegator() {
		if (delegator != null && delegator.eIsProxy()) {
			InternalEObject oldDelegator = (InternalEObject)delegator;
			delegator = (Delegator)eResolveProxy(oldDelegator);
			if (delegator != oldDelegator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Securebpmn2Package.DELEGATION__DELEGATOR, oldDelegator, delegator));
			}
		}
		return delegator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delegator basicGetDelegator() {
		return delegator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegator(Delegator newDelegator) {
		Delegator oldDelegator = delegator;
		delegator = newDelegator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.DELEGATION__DELEGATOR, oldDelegator, delegator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject getDelegatee() {
		if (delegatee != null && delegatee.eIsProxy()) {
			InternalEObject oldDelegatee = (InternalEObject)delegatee;
			delegatee = (Subject)eResolveProxy(oldDelegatee);
			if (delegatee != oldDelegatee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Securebpmn2Package.DELEGATION__DELEGATEE, oldDelegatee, delegatee));
			}
		}
		return delegatee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subject basicGetDelegatee() {
		return delegatee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegatee(Subject newDelegatee) {
		Subject oldDelegatee = delegatee;
		delegatee = newDelegatee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.DELEGATION__DELEGATEE, oldDelegatee, delegatee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNegotiable() {
		return negotiable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNegotiable(boolean newNegotiable) {
		boolean oldNegotiable = negotiable;
		negotiable = newNegotiable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.DELEGATION__NEGOTIABLE, oldNegotiable, negotiable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Permission> getPermissions() {
		if (permissions == null) {
			permissions = new EObjectWithInverseResolvingEList.ManyInverse<Permission>(Permission.class, this, Securebpmn2Package.DELEGATION__PERMISSIONS, Securebpmn2Package.PERMISSION__DELEGATIONS);
		}
		return permissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Permission> getDelegatablePermissions() {
		return delegatablePermissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegatablePermissions(EList<Permission> newDelegatablePermissions) {
		EList<Permission> oldDelegatablePermissions = delegatablePermissions;
		delegatablePermissions = newDelegatablePermissions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.DELEGATION__DELEGATABLE_PERMISSIONS, oldDelegatablePermissions, delegatablePermissions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPermissions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				return ((InternalEList<?>)getPermissions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Securebpmn2Package.DELEGATION__DELEGATOR:
				if (resolve) return getDelegator();
				return basicGetDelegator();
			case Securebpmn2Package.DELEGATION__DELEGATEE:
				if (resolve) return getDelegatee();
				return basicGetDelegatee();
			case Securebpmn2Package.DELEGATION__NEGOTIABLE:
				return isNegotiable();
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				return getPermissions();
			case Securebpmn2Package.DELEGATION__DELEGATABLE_PERMISSIONS:
				return getDelegatablePermissions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Securebpmn2Package.DELEGATION__DELEGATOR:
				setDelegator((Delegator)newValue);
				return;
			case Securebpmn2Package.DELEGATION__DELEGATEE:
				setDelegatee((Subject)newValue);
				return;
			case Securebpmn2Package.DELEGATION__NEGOTIABLE:
				setNegotiable((Boolean)newValue);
				return;
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				getPermissions().clear();
				getPermissions().addAll((Collection<? extends Permission>)newValue);
				return;
			case Securebpmn2Package.DELEGATION__DELEGATABLE_PERMISSIONS:
				setDelegatablePermissions((EList<Permission>)newValue);
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
			case Securebpmn2Package.DELEGATION__DELEGATOR:
				setDelegator((Delegator)null);
				return;
			case Securebpmn2Package.DELEGATION__DELEGATEE:
				setDelegatee((Subject)null);
				return;
			case Securebpmn2Package.DELEGATION__NEGOTIABLE:
				setNegotiable(NEGOTIABLE_EDEFAULT);
				return;
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				getPermissions().clear();
				return;
			case Securebpmn2Package.DELEGATION__DELEGATABLE_PERMISSIONS:
				setDelegatablePermissions((EList<Permission>)null);
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
			case Securebpmn2Package.DELEGATION__DELEGATOR:
				return delegator != null;
			case Securebpmn2Package.DELEGATION__DELEGATEE:
				return delegatee != null;
			case Securebpmn2Package.DELEGATION__NEGOTIABLE:
				return negotiable != NEGOTIABLE_EDEFAULT;
			case Securebpmn2Package.DELEGATION__PERMISSIONS:
				return permissions != null && !permissions.isEmpty();
			case Securebpmn2Package.DELEGATION__DELEGATABLE_PERMISSIONS:
				return delegatablePermissions != null;
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
		result.append(" (negotiable: ");
		result.append(negotiable);
		result.append(", delegatablePermissions: ");
		result.append(delegatablePermissions);
		result.append(')');
		return result.toString();
	}

} //DelegationImpl
