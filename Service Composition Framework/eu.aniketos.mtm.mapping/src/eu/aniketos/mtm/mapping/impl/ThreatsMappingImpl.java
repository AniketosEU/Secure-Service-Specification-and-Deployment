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

import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.ThreatType;
import eu.aniketos.mtm.mapping.ThreatsMapping;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Threats Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl#getBPThreat <em>BP Threat</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl#getSRThreat <em>SR Threat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreatsMappingImpl extends EObjectImpl implements ThreatsMapping {
	/**
	 * The cached value of the '{@link #getBPThreat() <em>BP Threat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPThreat()
	 * @generated
	 * @ordered
	 */
	protected ThreatType bPThreat;

	/**
	 * The cached value of the '{@link #getSRThreat() <em>SR Threat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRThreat()
	 * @generated
	 * @ordered
	 */
	protected ThreatType sRThreat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatsMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.THREATS_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType getBPThreat() {
		return bPThreat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPThreat(ThreatType newBPThreat, NotificationChain msgs) {
		ThreatType oldBPThreat = bPThreat;
		bPThreat = newBPThreat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.THREATS_MAPPING__BP_THREAT, oldBPThreat, newBPThreat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPThreat(ThreatType newBPThreat) {
		if (newBPThreat != bPThreat) {
			NotificationChain msgs = null;
			if (bPThreat != null)
				msgs = ((InternalEObject)bPThreat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.THREATS_MAPPING__BP_THREAT, null, msgs);
			if (newBPThreat != null)
				msgs = ((InternalEObject)newBPThreat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.THREATS_MAPPING__BP_THREAT, null, msgs);
			msgs = basicSetBPThreat(newBPThreat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.THREATS_MAPPING__BP_THREAT, newBPThreat, newBPThreat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType getSRThreat() {
		return sRThreat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSRThreat(ThreatType newSRThreat, NotificationChain msgs) {
		ThreatType oldSRThreat = sRThreat;
		sRThreat = newSRThreat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.THREATS_MAPPING__SR_THREAT, oldSRThreat, newSRThreat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSRThreat(ThreatType newSRThreat) {
		if (newSRThreat != sRThreat) {
			NotificationChain msgs = null;
			if (sRThreat != null)
				msgs = ((InternalEObject)sRThreat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.THREATS_MAPPING__SR_THREAT, null, msgs);
			if (newSRThreat != null)
				msgs = ((InternalEObject)newSRThreat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.THREATS_MAPPING__SR_THREAT, null, msgs);
			msgs = basicSetSRThreat(newSRThreat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.THREATS_MAPPING__SR_THREAT, newSRThreat, newSRThreat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.THREATS_MAPPING__BP_THREAT:
				return basicSetBPThreat(null, msgs);
			case MappingPackage.THREATS_MAPPING__SR_THREAT:
				return basicSetSRThreat(null, msgs);
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
			case MappingPackage.THREATS_MAPPING__BP_THREAT:
				return getBPThreat();
			case MappingPackage.THREATS_MAPPING__SR_THREAT:
				return getSRThreat();
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
			case MappingPackage.THREATS_MAPPING__BP_THREAT:
				setBPThreat((ThreatType)newValue);
				return;
			case MappingPackage.THREATS_MAPPING__SR_THREAT:
				setSRThreat((ThreatType)newValue);
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
			case MappingPackage.THREATS_MAPPING__BP_THREAT:
				setBPThreat((ThreatType)null);
				return;
			case MappingPackage.THREATS_MAPPING__SR_THREAT:
				setSRThreat((ThreatType)null);
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
			case MappingPackage.THREATS_MAPPING__BP_THREAT:
				return bPThreat != null;
			case MappingPackage.THREATS_MAPPING__SR_THREAT:
				return sRThreat != null;
		}
		return super.eIsSet(featureID);
	}

} //ThreatsMappingImpl
