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
import org.eclipse.bpmn2.ExtensionAttributeDefinition;
import org.eclipse.bpmn2.ExtensionDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.ExtensionAttributeDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ExtensionAttributeDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ExtensionAttributeDefinitionImpl#isIsReference <em>Is Reference</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.ExtensionAttributeDefinitionImpl#getExtensionDefinition <em>Extension Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionAttributeDefinitionImpl extends EObjectImpl implements ExtensionAttributeDefinition {
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
	 * The default value of the '{@link #isIsReference() <em>Is Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReference() <em>Is Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReference()
	 * @generated
	 * @ordered
	 */
	protected boolean isReference = IS_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionAttributeDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getExtensionAttributeDefinition();
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
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsReference() {
		return isReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsReference(boolean newIsReference) {
		boolean oldIsReference = isReference;
		isReference = newIsReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE, oldIsReference, isReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinition getExtensionDefinition() {
		if (eContainerFeatureID() != Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION) return null;
		return (ExtensionDefinition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionDefinition(ExtensionDefinition newExtensionDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExtensionDefinition, Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionDefinition(ExtensionDefinition newExtensionDefinition) {
		if (newExtensionDefinition != eInternalContainer() || (eContainerFeatureID() != Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION && newExtensionDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newExtensionDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtensionDefinition != null)
				msgs = ((InternalEObject)newExtensionDefinition).eInverseAdd(this, Bpmn2Package.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS, ExtensionDefinition.class, msgs);
			msgs = basicSetExtensionDefinition(newExtensionDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION, newExtensionDefinition, newExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExtensionDefinition((ExtensionDefinition)otherEnd, msgs);
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
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				return basicSetExtensionDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				return eInternalContainer().eInverseRemove(this, Bpmn2Package.EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS, ExtensionDefinition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__NAME:
				return getName();
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__TYPE:
				return getType();
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE:
				return isIsReference();
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				return getExtensionDefinition();
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
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__TYPE:
				setType((String)newValue);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE:
				setIsReference((Boolean)newValue);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				setExtensionDefinition((ExtensionDefinition)newValue);
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
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE:
				setIsReference(IS_REFERENCE_EDEFAULT);
				return;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				setExtensionDefinition((ExtensionDefinition)null);
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
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE:
				return isReference != IS_REFERENCE_EDEFAULT;
			case Bpmn2Package.EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION:
				return getExtensionDefinition() != null;
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
		result.append(", isReference: ");
		result.append(isReference);
		result.append(')');
		return result.toString();
	}

} //ExtensionAttributeDefinitionImpl
