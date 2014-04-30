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
package eu.aniketos.mtm.model.mtm_aniketos.impl;

import eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage;
import eu.aniketos.mtm.model.mtm_aniketos.Confidentiality;
import eu.aniketos.mtm.model.mtm_aniketos.Integrity;
import eu.aniketos.mtm.model.mtm_aniketos.SecurityExtension;
import eu.aniketos.mtm.model.mtm_aniketos.Trustworthiness;

import eu.aniketos.mtm.model.mtm_bpmn2.impl.BaseElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.impl.SecurityExtensionImpl#getIntegrityReq <em>Integrity Req</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.impl.SecurityExtensionImpl#getTrustworthinessValue <em>Trustworthiness Value</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_aniketos.impl.SecurityExtensionImpl#getConfidentialityReq <em>Confidentiality Req</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecurityExtensionImpl extends BaseElementImpl implements SecurityExtension {
	/**
	 * The cached value of the '{@link #getIntegrityReq() <em>Integrity Req</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrityReq()
	 * @generated
	 * @ordered
	 */
	protected EList<Integrity> integrityReq;

	/**
	 * The cached value of the '{@link #getTrustworthinessValue() <em>Trustworthiness Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrustworthinessValue()
	 * @generated
	 * @ordered
	 */
	protected Trustworthiness trustworthinessValue;

	/**
	 * The cached value of the '{@link #getConfidentialityReq() <em>Confidentiality Req</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityReq()
	 * @generated
	 * @ordered
	 */
	protected EList<Confidentiality> confidentialityReq;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecurityExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AniketosPackage.Literals.SECURITY_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integrity> getIntegrityReq() {
		if (integrityReq == null) {
			integrityReq = new EObjectContainmentEList<Integrity>(Integrity.class, this, AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ);
		}
		return integrityReq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trustworthiness getTrustworthinessValue() {
		return trustworthinessValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrustworthinessValue(Trustworthiness newTrustworthinessValue, NotificationChain msgs) {
		Trustworthiness oldTrustworthinessValue = trustworthinessValue;
		trustworthinessValue = newTrustworthinessValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE, oldTrustworthinessValue, newTrustworthinessValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrustworthinessValue(Trustworthiness newTrustworthinessValue) {
		if (newTrustworthinessValue != trustworthinessValue) {
			NotificationChain msgs = null;
			if (trustworthinessValue != null)
				msgs = ((InternalEObject)trustworthinessValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE, null, msgs);
			if (newTrustworthinessValue != null)
				msgs = ((InternalEObject)newTrustworthinessValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE, null, msgs);
			msgs = basicSetTrustworthinessValue(newTrustworthinessValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE, newTrustworthinessValue, newTrustworthinessValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Confidentiality> getConfidentialityReq() {
		if (confidentialityReq == null) {
			confidentialityReq = new EObjectContainmentEList<Confidentiality>(Confidentiality.class, this, AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ);
		}
		return confidentialityReq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ:
				return ((InternalEList<?>)getIntegrityReq()).basicRemove(otherEnd, msgs);
			case AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE:
				return basicSetTrustworthinessValue(null, msgs);
			case AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ:
				return ((InternalEList<?>)getConfidentialityReq()).basicRemove(otherEnd, msgs);
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
			case AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ:
				return getIntegrityReq();
			case AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE:
				return getTrustworthinessValue();
			case AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ:
				return getConfidentialityReq();
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
			case AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ:
				getIntegrityReq().clear();
				getIntegrityReq().addAll((Collection<? extends Integrity>)newValue);
				return;
			case AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE:
				setTrustworthinessValue((Trustworthiness)newValue);
				return;
			case AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ:
				getConfidentialityReq().clear();
				getConfidentialityReq().addAll((Collection<? extends Confidentiality>)newValue);
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
			case AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ:
				getIntegrityReq().clear();
				return;
			case AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE:
				setTrustworthinessValue((Trustworthiness)null);
				return;
			case AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ:
				getConfidentialityReq().clear();
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
			case AniketosPackage.SECURITY_EXTENSION__INTEGRITY_REQ:
				return integrityReq != null && !integrityReq.isEmpty();
			case AniketosPackage.SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE:
				return trustworthinessValue != null;
			case AniketosPackage.SECURITY_EXTENSION__CONFIDENTIALITY_REQ:
				return confidentialityReq != null && !confidentialityReq.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SecurityExtensionImpl
