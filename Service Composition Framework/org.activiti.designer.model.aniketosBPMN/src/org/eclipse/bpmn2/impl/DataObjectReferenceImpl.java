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
import org.eclipse.bpmn2.DataObject;
import org.eclipse.bpmn2.DataObjectReference;
import org.eclipse.bpmn2.DataState;
import org.eclipse.bpmn2.ItemAwareElement;
import org.eclipse.bpmn2.ItemDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.securebpmn2.ItemAwareElementAction;
import org.eclipse.securebpmn2.Securebpmn2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Object Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.DataObjectReferenceImpl#getDataState <em>Data State</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.DataObjectReferenceImpl#getItemSubjectRef <em>Item Subject Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.DataObjectReferenceImpl#getItemAwareElementActions <em>Item Aware Element Actions</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.DataObjectReferenceImpl#getDataObjectRef <em>Data Object Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataObjectReferenceImpl extends FlowElementImpl implements DataObjectReference {
	/**
	 * The cached value of the '{@link #getDataState() <em>Data State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataState()
	 * @generated
	 * @ordered
	 */
	protected DataState dataState;

	/**
	 * The cached value of the '{@link #getItemSubjectRef() <em>Item Subject Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemSubjectRef()
	 * @generated
	 * @ordered
	 */
	protected ItemDefinition itemSubjectRef;

	/**
	 * The cached value of the '{@link #getItemAwareElementActions() <em>Item Aware Element Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemAwareElementActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ItemAwareElementAction> itemAwareElementActions;

	/**
	 * The cached value of the '{@link #getDataObjectRef() <em>Data Object Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataObjectRef()
	 * @generated
	 * @ordered
	 */
	protected DataObject dataObjectRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataObjectReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getDataObjectReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataState getDataState() {
		return dataState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataState(DataState newDataState, NotificationChain msgs) {
		DataState oldDataState = dataState;
		dataState = newDataState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE, oldDataState, newDataState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataState(DataState newDataState) {
		if (newDataState != dataState) {
			NotificationChain msgs = null;
			if (dataState != null)
				msgs = ((InternalEObject)dataState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE, null, msgs);
			if (newDataState != null)
				msgs = ((InternalEObject)newDataState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE, null, msgs);
			msgs = basicSetDataState(newDataState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE, newDataState, newDataState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemDefinition getItemSubjectRef() {
		if (itemSubjectRef != null && itemSubjectRef.eIsProxy()) {
			InternalEObject oldItemSubjectRef = (InternalEObject)itemSubjectRef;
			itemSubjectRef = (ItemDefinition)eResolveProxy(oldItemSubjectRef);
			if (itemSubjectRef != oldItemSubjectRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF, oldItemSubjectRef, itemSubjectRef));
			}
		}
		return itemSubjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemDefinition basicGetItemSubjectRef() {
		return itemSubjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemSubjectRef(ItemDefinition newItemSubjectRef) {
		ItemDefinition oldItemSubjectRef = itemSubjectRef;
		itemSubjectRef = newItemSubjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF, oldItemSubjectRef, itemSubjectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ItemAwareElementAction> getItemAwareElementActions() {
		if (itemAwareElementActions == null) {
			itemAwareElementActions = new EObjectContainmentWithInverseEList<ItemAwareElementAction>(ItemAwareElementAction.class, this, Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS, Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT);
		}
		return itemAwareElementActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject getDataObjectRef() {
		return dataObjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataObjectRef(DataObject newDataObjectRef) {
		DataObject oldDataObjectRef = dataObjectRef;
		dataObjectRef = newDataObjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_OBJECT_REF, oldDataObjectRef, dataObjectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getItemAwareElementActions()).basicAdd(otherEnd, msgs);
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
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE:
				return basicSetDataState(null, msgs);
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				return ((InternalEList<?>)getItemAwareElementActions()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE:
				return getDataState();
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF:
				if (resolve) return getItemSubjectRef();
				return basicGetItemSubjectRef();
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				return getItemAwareElementActions();
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_OBJECT_REF:
				return getDataObjectRef();
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
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE:
				setDataState((DataState)newValue);
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF:
				setItemSubjectRef((ItemDefinition)newValue);
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				getItemAwareElementActions().clear();
				getItemAwareElementActions().addAll((Collection<? extends ItemAwareElementAction>)newValue);
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_OBJECT_REF:
				setDataObjectRef((DataObject)newValue);
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
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE:
				setDataState((DataState)null);
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF:
				setItemSubjectRef((ItemDefinition)null);
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				getItemAwareElementActions().clear();
				return;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_OBJECT_REF:
				setDataObjectRef((DataObject)null);
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
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE:
				return dataState != null;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF:
				return itemSubjectRef != null;
			case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS:
				return itemAwareElementActions != null && !itemAwareElementActions.isEmpty();
			case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_OBJECT_REF:
				return dataObjectRef != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ItemAwareElement.class) {
			switch (derivedFeatureID) {
				case Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE: return Bpmn2Package.ITEM_AWARE_ELEMENT__DATA_STATE;
				case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF: return Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF;
				case Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS: return Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENT_ACTIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ItemAwareElement.class) {
			switch (baseFeatureID) {
				case Bpmn2Package.ITEM_AWARE_ELEMENT__DATA_STATE: return Bpmn2Package.DATA_OBJECT_REFERENCE__DATA_STATE;
				case Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF: return Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_SUBJECT_REF;
				case Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENT_ACTIONS: return Bpmn2Package.DATA_OBJECT_REFERENCE__ITEM_AWARE_ELEMENT_ACTIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //DataObjectReferenceImpl
