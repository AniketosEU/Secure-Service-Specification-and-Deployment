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

import java.util.Collection;
import java.util.List;

import org.eclipse.bpmn2.impl.BaseElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.securebpmn2.Action;
import org.eclipse.securebpmn2.AuthorizationConstraint;
import org.eclipse.securebpmn2.Delegation;
import org.eclipse.securebpmn2.Permission;
import org.eclipse.securebpmn2.Role;
import org.eclipse.securebpmn2.Securebpmn2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.impl.PermissionImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.PermissionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.PermissionImpl#getAuthorizationConstraints <em>Authorization Constraints</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.PermissionImpl#getPName <em>PName</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.PermissionImpl#getDelegations <em>Delegations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionImpl extends BaseElementImpl implements Permission {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getAuthorizationConstraints() <em>Authorization Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorizationConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<AuthorizationConstraint> authorizationConstraints;

	/**
	 * The default value of the '{@link #getPName() <em>PName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPName()
	 * @generated
	 * @ordered
	 */
	protected static final String PNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPName() <em>PName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPName()
	 * @generated
	 * @ordered
	 */
	protected String pName = PNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDelegations() <em>Delegations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegations()
	 * @generated
	 * @ordered
	 */
	protected EList<Delegation> delegations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectWithInverseResolvingEList.ManyInverse<Role>(Role.class, this, Securebpmn2Package.PERMISSION__ROLES, Securebpmn2Package.ROLE__PERMISSIONS);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Action> getActions() {
		if (actions == null) {
			actions = new EObjectWithInverseResolvingEList.ManyInverse<Action>(Action.class, this, Securebpmn2Package.PERMISSION__ACTIONS, Securebpmn2Package.ACTION__PERMISSIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<AuthorizationConstraint> getAuthorizationConstraints() {
		if (authorizationConstraints == null) {
			authorizationConstraints = new EObjectWithInverseResolvingEList.ManyInverse<AuthorizationConstraint>(AuthorizationConstraint.class, this, Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS, Securebpmn2Package.AUTHORIZATION_CONSTRAINT__PERMISSIONS);
		}
		return authorizationConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPName() {
		return pName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPName(String newPName) {
		String oldPName = pName;
		pName = newPName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.PERMISSION__PNAME, oldPName, pName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Delegation> getDelegations() {
		if (delegations == null) {
			delegations = new EObjectWithInverseResolvingEList.ManyInverse<Delegation>(Delegation.class, this, Securebpmn2Package.PERMISSION__DELEGATIONS, Securebpmn2Package.DELEGATION__PERMISSIONS);
		}
		return delegations;
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
			case Securebpmn2Package.PERMISSION__ROLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRoles()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActions()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAuthorizationConstraints()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDelegations()).basicAdd(otherEnd, msgs);
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
			case Securebpmn2Package.PERMISSION__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				return ((InternalEList<?>)getAuthorizationConstraints()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				return ((InternalEList<?>)getDelegations()).basicRemove(otherEnd, msgs);
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
			case Securebpmn2Package.PERMISSION__ROLES:
				return getRoles();
			case Securebpmn2Package.PERMISSION__ACTIONS:
				return getActions();
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				return getAuthorizationConstraints();
			case Securebpmn2Package.PERMISSION__PNAME:
				return getPName();
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				return getDelegations();
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
			case Securebpmn2Package.PERMISSION__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case Securebpmn2Package.PERMISSION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				getAuthorizationConstraints().clear();
				getAuthorizationConstraints().addAll((Collection<? extends AuthorizationConstraint>)newValue);
				return;
			case Securebpmn2Package.PERMISSION__PNAME:
				setPName((String)newValue);
				return;
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				getDelegations().clear();
				getDelegations().addAll((Collection<? extends Delegation>)newValue);
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
			case Securebpmn2Package.PERMISSION__ROLES:
				getRoles().clear();
				return;
			case Securebpmn2Package.PERMISSION__ACTIONS:
				getActions().clear();
				return;
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				getAuthorizationConstraints().clear();
				return;
			case Securebpmn2Package.PERMISSION__PNAME:
				setPName(PNAME_EDEFAULT);
				return;
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				getDelegations().clear();
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
			case Securebpmn2Package.PERMISSION__ROLES:
				return roles != null && !roles.isEmpty();
			case Securebpmn2Package.PERMISSION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case Securebpmn2Package.PERMISSION__AUTHORIZATION_CONSTRAINTS:
				return authorizationConstraints != null && !authorizationConstraints.isEmpty();
			case Securebpmn2Package.PERMISSION__PNAME:
				return PNAME_EDEFAULT == null ? pName != null : !PNAME_EDEFAULT.equals(pName);
			case Securebpmn2Package.PERMISSION__DELEGATIONS:
				return delegations != null && !delegations.isEmpty();
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
		result.append(" (pName: ");
		result.append(pName);
		result.append(')');
		return result.toString();
	}

} //PermissionImpl
