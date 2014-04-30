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
package eu.aniketos.mtm.mapping.impl;

import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.SRRType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plays Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.PlaysTypeImpl#getBPPart <em>BP Part</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.PlaysTypeImpl#getSRRole <em>SR Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaysTypeImpl extends EObjectImpl implements PlaysType {
	/**
	 * The cached value of the '{@link #getBPPart() <em>BP Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPPart()
	 * @generated
	 * @ordered
	 */
	protected BPPType bPPart;

	/**
	 * The cached value of the '{@link #getSRRole() <em>SR Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRRole()
	 * @generated
	 * @ordered
	 */
	protected SRRType sRRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaysTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.PLAYS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPPType getBPPart() {
		return bPPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPPart(BPPType newBPPart, NotificationChain msgs) {
		BPPType oldBPPart = bPPart;
		bPPart = newBPPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.PLAYS_TYPE__BP_PART, oldBPPart, newBPPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPPart(BPPType newBPPart) {
		if (newBPPart != bPPart) {
			NotificationChain msgs = null;
			if (bPPart != null)
				msgs = ((InternalEObject)bPPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.PLAYS_TYPE__BP_PART, null, msgs);
			if (newBPPart != null)
				msgs = ((InternalEObject)newBPPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.PLAYS_TYPE__BP_PART, null, msgs);
			msgs = basicSetBPPart(newBPPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.PLAYS_TYPE__BP_PART, newBPPart, newBPPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRRType getSRRole() {
		return sRRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSRRole(SRRType newSRRole, NotificationChain msgs) {
		SRRType oldSRRole = sRRole;
		sRRole = newSRRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.PLAYS_TYPE__SR_ROLE, oldSRRole, newSRRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSRRole(SRRType newSRRole) {
		if (newSRRole != sRRole) {
			NotificationChain msgs = null;
			if (sRRole != null)
				msgs = ((InternalEObject)sRRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.PLAYS_TYPE__SR_ROLE, null, msgs);
			if (newSRRole != null)
				msgs = ((InternalEObject)newSRRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.PLAYS_TYPE__SR_ROLE, null, msgs);
			msgs = basicSetSRRole(newSRRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.PLAYS_TYPE__SR_ROLE, newSRRole, newSRRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.PLAYS_TYPE__BP_PART:
				return basicSetBPPart(null, msgs);
			case MappingPackage.PLAYS_TYPE__SR_ROLE:
				return basicSetSRRole(null, msgs);
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
			case MappingPackage.PLAYS_TYPE__BP_PART:
				return getBPPart();
			case MappingPackage.PLAYS_TYPE__SR_ROLE:
				return getSRRole();
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
			case MappingPackage.PLAYS_TYPE__BP_PART:
				setBPPart((BPPType)newValue);
				return;
			case MappingPackage.PLAYS_TYPE__SR_ROLE:
				setSRRole((SRRType)newValue);
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
			case MappingPackage.PLAYS_TYPE__BP_PART:
				setBPPart((BPPType)null);
				return;
			case MappingPackage.PLAYS_TYPE__SR_ROLE:
				setSRRole((SRRType)null);
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
			case MappingPackage.PLAYS_TYPE__BP_PART:
				return bPPart != null;
			case MappingPackage.PLAYS_TYPE__SR_ROLE:
				return sRRole != null;
		}
		return super.eIsSet(featureID);
	}

} //PlaysTypeImpl
