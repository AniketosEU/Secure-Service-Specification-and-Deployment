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
import org.eclipse.bpmn2.FormValue;

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
 * An implementation of the model object '<em><b>Form Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getReadable <em>Readable</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getWriteable <em>Writeable</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.FormPropertyImpl#getFormValues <em>Form Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormPropertyImpl extends BaseElementImpl implements FormProperty {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReadable() <em>Readable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadable()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean READABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReadable() <em>Readable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadable()
	 * @generated
	 * @ordered
	 */
	protected Boolean readable = READABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWriteable() <em>Writeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteable()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean WRITEABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWriteable() <em>Writeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriteable()
	 * @generated
	 * @ordered
	 */
	protected Boolean writeable = WRITEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean REQUIRED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected Boolean required = REQUIRED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormValues() <em>Form Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FormValue> formValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getFormProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getReadable() {
		return readable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadable(Boolean newReadable) {
		Boolean oldReadable = readable;
		readable = newReadable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__READABLE, oldReadable, readable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getWriteable() {
		return writeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWriteable(Boolean newWriteable) {
		Boolean oldWriteable = writeable;
		writeable = newWriteable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__WRITEABLE, oldWriteable, writeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(Boolean newRequired) {
		Boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.FORM_PROPERTY__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<FormValue> getFormValues() {
		if (formValues == null) {
			formValues = new EObjectContainmentEList<FormValue>(FormValue.class, this, Bpmn2Package.FORM_PROPERTY__FORM_VALUES);
		}
		return formValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.FORM_PROPERTY__FORM_VALUES:
				return ((InternalEList<?>)getFormValues()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.FORM_PROPERTY__NAME:
				return getName();
			case Bpmn2Package.FORM_PROPERTY__TYPE:
				return getType();
			case Bpmn2Package.FORM_PROPERTY__VALUE:
				return getValue();
			case Bpmn2Package.FORM_PROPERTY__READABLE:
				return getReadable();
			case Bpmn2Package.FORM_PROPERTY__WRITEABLE:
				return getWriteable();
			case Bpmn2Package.FORM_PROPERTY__REQUIRED:
				return getRequired();
			case Bpmn2Package.FORM_PROPERTY__FORM_VALUES:
				return getFormValues();
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
			case Bpmn2Package.FORM_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__TYPE:
				setType((String)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__VALUE:
				setValue((String)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__READABLE:
				setReadable((Boolean)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__WRITEABLE:
				setWriteable((Boolean)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case Bpmn2Package.FORM_PROPERTY__FORM_VALUES:
				getFormValues().clear();
				getFormValues().addAll((Collection<? extends FormValue>)newValue);
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
			case Bpmn2Package.FORM_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__READABLE:
				setReadable(READABLE_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__WRITEABLE:
				setWriteable(WRITEABLE_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case Bpmn2Package.FORM_PROPERTY__FORM_VALUES:
				getFormValues().clear();
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
			case Bpmn2Package.FORM_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Bpmn2Package.FORM_PROPERTY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case Bpmn2Package.FORM_PROPERTY__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case Bpmn2Package.FORM_PROPERTY__READABLE:
				return READABLE_EDEFAULT == null ? readable != null : !READABLE_EDEFAULT.equals(readable);
			case Bpmn2Package.FORM_PROPERTY__WRITEABLE:
				return WRITEABLE_EDEFAULT == null ? writeable != null : !WRITEABLE_EDEFAULT.equals(writeable);
			case Bpmn2Package.FORM_PROPERTY__REQUIRED:
				return REQUIRED_EDEFAULT == null ? required != null : !REQUIRED_EDEFAULT.equals(required);
			case Bpmn2Package.FORM_PROPERTY__FORM_VALUES:
				return formValues != null && !formValues.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", value: ");
		result.append(value);
		result.append(", readable: ");
		result.append(readable);
		result.append(", writeable: ");
		result.append(writeable);
		result.append(", required: ");
		result.append(required);
		result.append(')');
		return result.toString();
	}

} //FormPropertyImpl
