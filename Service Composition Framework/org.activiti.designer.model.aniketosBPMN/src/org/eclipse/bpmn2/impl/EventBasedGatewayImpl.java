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
import org.eclipse.bpmn2.EventBasedGateway;
import org.eclipse.bpmn2.EventBasedGatewayType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Based Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.EventBasedGatewayImpl#getEventGatewayType <em>Event Gateway Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.EventBasedGatewayImpl#isInstantiate <em>Instantiate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBasedGatewayImpl extends GatewayImpl implements EventBasedGateway {
	/**
	 * The default value of the '{@link #getEventGatewayType() <em>Event Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventGatewayType()
	 * @generated
	 * @ordered
	 */
	protected static final EventBasedGatewayType EVENT_GATEWAY_TYPE_EDEFAULT = EventBasedGatewayType.PARALLEL;

	/**
	 * The cached value of the '{@link #getEventGatewayType() <em>Event Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventGatewayType()
	 * @generated
	 * @ordered
	 */
	protected EventBasedGatewayType eventGatewayType = EVENT_GATEWAY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected boolean instantiate = INSTANTIATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBasedGatewayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getEventBasedGateway();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBasedGatewayType getEventGatewayType() {
		return eventGatewayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventGatewayType(EventBasedGatewayType newEventGatewayType) {
		EventBasedGatewayType oldEventGatewayType = eventGatewayType;
		eventGatewayType = newEventGatewayType == null ? EVENT_GATEWAY_TYPE_EDEFAULT : newEventGatewayType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE, oldEventGatewayType, eventGatewayType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiate() {
		return instantiate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiate(boolean newInstantiate) {
		boolean oldInstantiate = instantiate;
		instantiate = newInstantiate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE, oldInstantiate, instantiate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
				return getEventGatewayType();
			case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
				return isInstantiate();
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
			case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
				setEventGatewayType((EventBasedGatewayType)newValue);
				return;
			case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
				setInstantiate((Boolean)newValue);
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
			case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
				setEventGatewayType(EVENT_GATEWAY_TYPE_EDEFAULT);
				return;
			case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
				setInstantiate(INSTANTIATE_EDEFAULT);
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
			case Bpmn2Package.EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE:
				return eventGatewayType != EVENT_GATEWAY_TYPE_EDEFAULT;
			case Bpmn2Package.EVENT_BASED_GATEWAY__INSTANTIATE:
				return instantiate != INSTANTIATE_EDEFAULT;
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
		result.append(" (eventGatewayType: ");
		result.append(eventGatewayType);
		result.append(", instantiate: ");
		result.append(instantiate);
		result.append(')');
		return result.toString();
	}

} //EventBasedGatewayImpl
