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
package org.eclipse.securebpmn2.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.ItemAwareElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.securebpmn2.CompositeItemAwareElementAction;
import org.eclipse.securebpmn2.ItemAwareElementAction;
import org.eclipse.securebpmn2.Securebpmn2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Aware Element Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.impl.ItemAwareElementActionImpl#getCompositeItemAwareElementActions <em>Composite Item Aware Element Actions</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.impl.ItemAwareElementActionImpl#getItemAwareElement <em>Item Aware Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemAwareElementActionImpl extends ActionImpl implements ItemAwareElementAction {
	/**
	 * The cached value of the '{@link #getCompositeItemAwareElementActions() <em>Composite Item Aware Element Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeItemAwareElementActions()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeItemAwareElementAction> compositeItemAwareElementActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemAwareElementActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.ITEM_AWARE_ELEMENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<CompositeItemAwareElementAction> getCompositeItemAwareElementActions() {
		if (compositeItemAwareElementActions == null) {
			compositeItemAwareElementActions = new EObjectWithInverseResolvingEList.ManyInverse<CompositeItemAwareElementAction>(CompositeItemAwareElementAction.class, this, Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS, Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS);
		}
		return compositeItemAwareElementActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElement getItemAwareElement() {
		if (eContainerFeatureID() != Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT) return null;
		return (ItemAwareElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItemAwareElement(ItemAwareElement newItemAwareElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newItemAwareElement, Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemAwareElement(ItemAwareElement newItemAwareElement) {
		if (newItemAwareElement != eInternalContainer() || (eContainerFeatureID() != Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT && newItemAwareElement != null)) {
			if (EcoreUtil.isAncestor(this, newItemAwareElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newItemAwareElement != null)
				msgs = ((InternalEObject)newItemAwareElement).eInverseAdd(this, Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENT_ACTIONS, ItemAwareElement.class, msgs);
			msgs = basicSetItemAwareElement(newItemAwareElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT, newItemAwareElement, newItemAwareElement));
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompositeItemAwareElementActions()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetItemAwareElement((ItemAwareElement)otherEnd, msgs);
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				return ((InternalEList<?>)getCompositeItemAwareElementActions()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				return basicSetItemAwareElement(null, msgs);
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, Bpmn2Package.ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENT_ACTIONS, ItemAwareElement.class, msgs);
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				return getCompositeItemAwareElementActions();
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				return getItemAwareElement();
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				getCompositeItemAwareElementActions().clear();
				getCompositeItemAwareElementActions().addAll((Collection<? extends CompositeItemAwareElementAction>)newValue);
				return;
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				setItemAwareElement((ItemAwareElement)newValue);
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				getCompositeItemAwareElementActions().clear();
				return;
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				setItemAwareElement((ItemAwareElement)null);
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
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS:
				return compositeItemAwareElementActions != null && !compositeItemAwareElementActions.isEmpty();
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT:
				return getItemAwareElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //ItemAwareElementActionImpl
