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
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.StartEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.StartEventImpl#isIsInterrupting <em>Is Interrupting</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.StartEventImpl#getFormKey <em>Form Key</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.StartEventImpl#getFormProperties <em>Form Properties</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.StartEventImpl#getInitiator <em>Initiator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StartEventImpl extends CatchEventImpl implements StartEvent {
	/**
	 * The default value of the '{@link #isIsInterrupting() <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterrupting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INTERRUPTING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsInterrupting() <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsInterrupting()
	 * @generated
	 * @ordered
	 */
	protected boolean isInterrupting = IS_INTERRUPTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormKey() <em>Form Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormKey()
	 * @generated
	 * @ordered
	 */
	protected static final String FORM_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormKey() <em>Form Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormKey()
	 * @generated
	 * @ordered
	 */
	protected String formKey = FORM_KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormProperties() <em>Form Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<FormProperty> formProperties;

	/**
	 * The default value of the '{@link #getInitiator() <em>Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiator()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitiator() <em>Initiator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiator()
	 * @generated
	 * @ordered
	 */
	protected String initiator = INITIATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getStartEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsInterrupting() {
		return isInterrupting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInterrupting(boolean newIsInterrupting) {
		boolean oldIsInterrupting = isInterrupting;
		isInterrupting = newIsInterrupting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.START_EVENT__IS_INTERRUPTING, oldIsInterrupting, isInterrupting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormKey() {
		return formKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormKey(String newFormKey) {
		String oldFormKey = formKey;
		formKey = newFormKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.START_EVENT__FORM_KEY, oldFormKey, formKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<FormProperty> getFormProperties() {
		if (formProperties == null) {
			formProperties = new EObjectContainmentEList<FormProperty>(FormProperty.class, this, Bpmn2Package.START_EVENT__FORM_PROPERTIES);
		}
		return formProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitiator() {
		return initiator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiator(String newInitiator) {
		String oldInitiator = initiator;
		initiator = newInitiator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.START_EVENT__INITIATOR, oldInitiator, initiator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.START_EVENT__FORM_PROPERTIES:
				return ((InternalEList<?>)getFormProperties()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.START_EVENT__IS_INTERRUPTING:
				return isIsInterrupting();
			case Bpmn2Package.START_EVENT__FORM_KEY:
				return getFormKey();
			case Bpmn2Package.START_EVENT__FORM_PROPERTIES:
				return getFormProperties();
			case Bpmn2Package.START_EVENT__INITIATOR:
				return getInitiator();
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
			case Bpmn2Package.START_EVENT__IS_INTERRUPTING:
				setIsInterrupting((Boolean)newValue);
				return;
			case Bpmn2Package.START_EVENT__FORM_KEY:
				setFormKey((String)newValue);
				return;
			case Bpmn2Package.START_EVENT__FORM_PROPERTIES:
				getFormProperties().clear();
				getFormProperties().addAll((Collection<? extends FormProperty>)newValue);
				return;
			case Bpmn2Package.START_EVENT__INITIATOR:
				setInitiator((String)newValue);
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
			case Bpmn2Package.START_EVENT__IS_INTERRUPTING:
				setIsInterrupting(IS_INTERRUPTING_EDEFAULT);
				return;
			case Bpmn2Package.START_EVENT__FORM_KEY:
				setFormKey(FORM_KEY_EDEFAULT);
				return;
			case Bpmn2Package.START_EVENT__FORM_PROPERTIES:
				getFormProperties().clear();
				return;
			case Bpmn2Package.START_EVENT__INITIATOR:
				setInitiator(INITIATOR_EDEFAULT);
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
			case Bpmn2Package.START_EVENT__IS_INTERRUPTING:
				return isInterrupting != IS_INTERRUPTING_EDEFAULT;
			case Bpmn2Package.START_EVENT__FORM_KEY:
				return FORM_KEY_EDEFAULT == null ? formKey != null : !FORM_KEY_EDEFAULT.equals(formKey);
			case Bpmn2Package.START_EVENT__FORM_PROPERTIES:
				return formProperties != null && !formProperties.isEmpty();
			case Bpmn2Package.START_EVENT__INITIATOR:
				return INITIATOR_EDEFAULT == null ? initiator != null : !INITIATOR_EDEFAULT.equals(initiator);
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
		result.append(" (isInterrupting: ");
		result.append(isInterrupting);
		result.append(", formKey: ");
		result.append(formKey);
		result.append(", initiator: ");
		result.append(initiator);
		result.append(')');
		return result.toString();
	}

} //StartEventImpl
