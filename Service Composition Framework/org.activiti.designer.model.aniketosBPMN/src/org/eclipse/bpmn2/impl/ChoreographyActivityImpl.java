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
package org.eclipse.bpmn2.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ChoreographyActivity;
import org.eclipse.bpmn2.ChoreographyLoopType;
import org.eclipse.bpmn2.CorrelationKey;
import org.eclipse.bpmn2.Participant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choreography Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.ChoreographyActivityImpl#getParticipantRefs <em>Participant Refs</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ChoreographyActivityImpl#getCorrelationKeys <em>Correlation Keys</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ChoreographyActivityImpl#getInitiatingParticipantRef <em>Initiating Participant Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ChoreographyActivityImpl#getLoopType <em>Loop Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ChoreographyActivityImpl extends FlowNodeImpl implements ChoreographyActivity {
	/**
	 * The cached value of the '{@link #getParticipantRefs() <em>Participant Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participantRefs;

	/**
	 * The cached value of the '{@link #getCorrelationKeys() <em>Correlation Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrelationKey> correlationKeys;

	/**
	 * The cached value of the '{@link #getInitiatingParticipantRef() <em>Initiating Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatingParticipantRef()
	 * @generated
	 * @ordered
	 */
	protected Participant initiatingParticipantRef;

	/**
	 * The default value of the '{@link #getLoopType() <em>Loop Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopType()
	 * @generated
	 * @ordered
	 */
	protected static final ChoreographyLoopType LOOP_TYPE_EDEFAULT = ChoreographyLoopType.NONE;

	/**
	 * The cached value of the '{@link #getLoopType() <em>Loop Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopType()
	 * @generated
	 * @ordered
	 */
	protected ChoreographyLoopType loopType = LOOP_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoreographyActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getChoreographyActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Participant> getParticipantRefs() {
		if (participantRefs == null) {
			participantRefs = new EObjectResolvingEList<Participant>(Participant.class, this, Bpmn2Package.CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS);
		}
		return participantRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CorrelationKey> getCorrelationKeys() {
		if (correlationKeys == null) {
			correlationKeys = new EObjectContainmentEList<CorrelationKey>(CorrelationKey.class, this, Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS);
		}
		return correlationKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getInitiatingParticipantRef() {
		if (initiatingParticipantRef != null && initiatingParticipantRef.eIsProxy()) {
			InternalEObject oldInitiatingParticipantRef = (InternalEObject)initiatingParticipantRef;
			initiatingParticipantRef = (Participant)eResolveProxy(oldInitiatingParticipantRef);
			if (initiatingParticipantRef != oldInitiatingParticipantRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF, oldInitiatingParticipantRef, initiatingParticipantRef));
			}
		}
		return initiatingParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetInitiatingParticipantRef() {
		return initiatingParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatingParticipantRef(Participant newInitiatingParticipantRef) {
		Participant oldInitiatingParticipantRef = initiatingParticipantRef;
		initiatingParticipantRef = newInitiatingParticipantRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF, oldInitiatingParticipantRef, initiatingParticipantRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoreographyLoopType getLoopType() {
		return loopType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopType(ChoreographyLoopType newLoopType) {
		ChoreographyLoopType oldLoopType = loopType;
		loopType = newLoopType == null ? LOOP_TYPE_EDEFAULT : newLoopType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CHOREOGRAPHY_ACTIVITY__LOOP_TYPE, oldLoopType, loopType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS:
				return ((InternalEList<?>)getCorrelationKeys()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS:
				return getParticipantRefs();
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS:
				return getCorrelationKeys();
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF:
				if (resolve) return getInitiatingParticipantRef();
				return basicGetInitiatingParticipantRef();
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__LOOP_TYPE:
				return getLoopType();
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
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS:
				getParticipantRefs().clear();
				getParticipantRefs().addAll((Collection<? extends Participant>)newValue);
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				getCorrelationKeys().addAll((Collection<? extends CorrelationKey>)newValue);
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF:
				setInitiatingParticipantRef((Participant)newValue);
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__LOOP_TYPE:
				setLoopType((ChoreographyLoopType)newValue);
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
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS:
				getParticipantRefs().clear();
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF:
				setInitiatingParticipantRef((Participant)null);
				return;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__LOOP_TYPE:
				setLoopType(LOOP_TYPE_EDEFAULT);
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
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS:
				return participantRefs != null && !participantRefs.isEmpty();
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS:
				return correlationKeys != null && !correlationKeys.isEmpty();
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF:
				return initiatingParticipantRef != null;
			case Bpmn2Package.CHOREOGRAPHY_ACTIVITY__LOOP_TYPE:
				return loopType != LOOP_TYPE_EDEFAULT;
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
		result.append(" (loopType: ");
		result.append(loopType);
		result.append(')');
		return result.toString();
	}

} //ChoreographyActivityImpl
