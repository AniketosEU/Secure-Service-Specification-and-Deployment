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
package eu.aniketos.mtm.srs.impl;

import eu.aniketos.mtm.srs.AuthType1;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.PreType;
import eu.aniketos.mtm.srs.ProvType;
import eu.aniketos.mtm.srs.SrsPackage;
import eu.aniketos.mtm.srs.TrustworthinessType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pre Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PreTypeImpl#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PreTypeImpl#getAuthorization <em>Authorization</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PreTypeImpl#getProvision <em>Provision</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PreTypeImpl#getTrustworthiness <em>Trustworthiness</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreTypeImpl extends EObjectImpl implements PreType {
	/**
	 * The cached value of the '{@link #getDelegation() <em>Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegation()
	 * @generated
	 * @ordered
	 */
	protected DelType delegation;

	/**
	 * The cached value of the '{@link #getAuthorization() <em>Authorization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthorization()
	 * @generated
	 * @ordered
	 */
	protected AuthType1 authorization;

	/**
	 * The cached value of the '{@link #getProvision() <em>Provision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvision()
	 * @generated
	 * @ordered
	 */
	protected ProvType provision;

	/**
	 * The cached value of the '{@link #getTrustworthiness() <em>Trustworthiness</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustworthiness()
	 * @generated
	 * @ordered
	 */
	protected TrustworthinessType trustworthiness;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.PRE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelType getDelegation() {
		return delegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelegation(DelType newDelegation, NotificationChain msgs) {
		DelType oldDelegation = delegation;
		delegation = newDelegation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__DELEGATION, oldDelegation, newDelegation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegation(DelType newDelegation) {
		if (newDelegation != delegation) {
			NotificationChain msgs = null;
			if (delegation != null)
				msgs = ((InternalEObject)delegation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__DELEGATION, null, msgs);
			if (newDelegation != null)
				msgs = ((InternalEObject)newDelegation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__DELEGATION, null, msgs);
			msgs = basicSetDelegation(newDelegation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__DELEGATION, newDelegation, newDelegation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType1 getAuthorization() {
		return authorization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthorization(AuthType1 newAuthorization, NotificationChain msgs) {
		AuthType1 oldAuthorization = authorization;
		authorization = newAuthorization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__AUTHORIZATION, oldAuthorization, newAuthorization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorization(AuthType1 newAuthorization) {
		if (newAuthorization != authorization) {
			NotificationChain msgs = null;
			if (authorization != null)
				msgs = ((InternalEObject)authorization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__AUTHORIZATION, null, msgs);
			if (newAuthorization != null)
				msgs = ((InternalEObject)newAuthorization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__AUTHORIZATION, null, msgs);
			msgs = basicSetAuthorization(newAuthorization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__AUTHORIZATION, newAuthorization, newAuthorization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvType getProvision() {
		return provision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvision(ProvType newProvision, NotificationChain msgs) {
		ProvType oldProvision = provision;
		provision = newProvision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__PROVISION, oldProvision, newProvision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvision(ProvType newProvision) {
		if (newProvision != provision) {
			NotificationChain msgs = null;
			if (provision != null)
				msgs = ((InternalEObject)provision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__PROVISION, null, msgs);
			if (newProvision != null)
				msgs = ((InternalEObject)newProvision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__PROVISION, null, msgs);
			msgs = basicSetProvision(newProvision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__PROVISION, newProvision, newProvision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrustworthinessType getTrustworthiness() {
		return trustworthiness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrustworthiness(TrustworthinessType newTrustworthiness, NotificationChain msgs) {
		TrustworthinessType oldTrustworthiness = trustworthiness;
		trustworthiness = newTrustworthiness;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__TRUSTWORTHINESS, oldTrustworthiness, newTrustworthiness);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrustworthiness(TrustworthinessType newTrustworthiness) {
		if (newTrustworthiness != trustworthiness) {
			NotificationChain msgs = null;
			if (trustworthiness != null)
				msgs = ((InternalEObject)trustworthiness).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__TRUSTWORTHINESS, null, msgs);
			if (newTrustworthiness != null)
				msgs = ((InternalEObject)newTrustworthiness).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.PRE_TYPE__TRUSTWORTHINESS, null, msgs);
			msgs = basicSetTrustworthiness(newTrustworthiness, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.PRE_TYPE__TRUSTWORTHINESS, newTrustworthiness, newTrustworthiness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.PRE_TYPE__DELEGATION:
				return basicSetDelegation(null, msgs);
			case SrsPackage.PRE_TYPE__AUTHORIZATION:
				return basicSetAuthorization(null, msgs);
			case SrsPackage.PRE_TYPE__PROVISION:
				return basicSetProvision(null, msgs);
			case SrsPackage.PRE_TYPE__TRUSTWORTHINESS:
				return basicSetTrustworthiness(null, msgs);
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
			case SrsPackage.PRE_TYPE__DELEGATION:
				return getDelegation();
			case SrsPackage.PRE_TYPE__AUTHORIZATION:
				return getAuthorization();
			case SrsPackage.PRE_TYPE__PROVISION:
				return getProvision();
			case SrsPackage.PRE_TYPE__TRUSTWORTHINESS:
				return getTrustworthiness();
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
			case SrsPackage.PRE_TYPE__DELEGATION:
				setDelegation((DelType)newValue);
				return;
			case SrsPackage.PRE_TYPE__AUTHORIZATION:
				setAuthorization((AuthType1)newValue);
				return;
			case SrsPackage.PRE_TYPE__PROVISION:
				setProvision((ProvType)newValue);
				return;
			case SrsPackage.PRE_TYPE__TRUSTWORTHINESS:
				setTrustworthiness((TrustworthinessType)newValue);
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
			case SrsPackage.PRE_TYPE__DELEGATION:
				setDelegation((DelType)null);
				return;
			case SrsPackage.PRE_TYPE__AUTHORIZATION:
				setAuthorization((AuthType1)null);
				return;
			case SrsPackage.PRE_TYPE__PROVISION:
				setProvision((ProvType)null);
				return;
			case SrsPackage.PRE_TYPE__TRUSTWORTHINESS:
				setTrustworthiness((TrustworthinessType)null);
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
			case SrsPackage.PRE_TYPE__DELEGATION:
				return delegation != null;
			case SrsPackage.PRE_TYPE__AUTHORIZATION:
				return authorization != null;
			case SrsPackage.PRE_TYPE__PROVISION:
				return provision != null;
			case SrsPackage.PRE_TYPE__TRUSTWORTHINESS:
				return trustworthiness != null;
		}
		return super.eIsSet(featureID);
	}

} //PreTypeImpl
