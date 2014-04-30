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

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Participant;
import org.eclipse.bpmn2.ParticipantAssociation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.ParticipantAssociationImpl#getInnerParticipantRef <em>Inner Participant Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ParticipantAssociationImpl#getOuterParticipantRef <em>Outer Participant Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParticipantAssociationImpl extends BaseElementImpl implements ParticipantAssociation {
	/**
	 * The cached value of the '{@link #getInnerParticipantRef() <em>Inner Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerParticipantRef()
	 * @generated
	 * @ordered
	 */
	protected Participant innerParticipantRef;

	/**
	 * The cached value of the '{@link #getOuterParticipantRef() <em>Outer Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterParticipantRef()
	 * @generated
	 * @ordered
	 */
	protected Participant outerParticipantRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getParticipantAssociation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getInnerParticipantRef() {
		if (innerParticipantRef != null && innerParticipantRef.eIsProxy()) {
			InternalEObject oldInnerParticipantRef = (InternalEObject)innerParticipantRef;
			innerParticipantRef = (Participant)eResolveProxy(oldInnerParticipantRef);
			if (innerParticipantRef != oldInnerParticipantRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF, oldInnerParticipantRef, innerParticipantRef));
			}
		}
		return innerParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetInnerParticipantRef() {
		return innerParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerParticipantRef(Participant newInnerParticipantRef) {
		Participant oldInnerParticipantRef = innerParticipantRef;
		innerParticipantRef = newInnerParticipantRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF, oldInnerParticipantRef, innerParticipantRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getOuterParticipantRef() {
		if (outerParticipantRef != null && outerParticipantRef.eIsProxy()) {
			InternalEObject oldOuterParticipantRef = (InternalEObject)outerParticipantRef;
			outerParticipantRef = (Participant)eResolveProxy(oldOuterParticipantRef);
			if (outerParticipantRef != oldOuterParticipantRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF, oldOuterParticipantRef, outerParticipantRef));
			}
		}
		return outerParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetOuterParticipantRef() {
		return outerParticipantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterParticipantRef(Participant newOuterParticipantRef) {
		Participant oldOuterParticipantRef = outerParticipantRef;
		outerParticipantRef = newOuterParticipantRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF, oldOuterParticipantRef, outerParticipantRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF:
				if (resolve) return getInnerParticipantRef();
				return basicGetInnerParticipantRef();
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF:
				if (resolve) return getOuterParticipantRef();
				return basicGetOuterParticipantRef();
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
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF:
				setInnerParticipantRef((Participant)newValue);
				return;
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF:
				setOuterParticipantRef((Participant)newValue);
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
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF:
				setInnerParticipantRef((Participant)null);
				return;
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF:
				setOuterParticipantRef((Participant)null);
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
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF:
				return innerParticipantRef != null;
			case Bpmn2Package.PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF:
				return outerParticipantRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ParticipantAssociationImpl
