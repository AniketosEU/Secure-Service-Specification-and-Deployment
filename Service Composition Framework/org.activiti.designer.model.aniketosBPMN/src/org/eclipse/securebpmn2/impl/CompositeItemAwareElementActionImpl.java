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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.securebpmn2.CompositeItemAwareElementAction;
import org.eclipse.securebpmn2.ItemAwareElementAction;
import org.eclipse.securebpmn2.Securebpmn2Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Item Aware Element Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.impl.CompositeItemAwareElementActionImpl#getItemAwareElementActions <em>Item Aware Element Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeItemAwareElementActionImpl extends ItemAwareElementActionImpl implements CompositeItemAwareElementAction {
	/**
	 * The cached value of the '{@link #getItemAwareElementActions() <em>Item Aware Element Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemAwareElementActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ItemAwareElementAction> itemAwareElementActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeItemAwareElementActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ItemAwareElementAction> getItemAwareElementActions() {
		if (itemAwareElementActions == null) {
			itemAwareElementActions = new EObjectWithInverseResolvingEList.ManyInverse<ItemAwareElementAction>(ItemAwareElementAction.class, this, Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS, Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS);
		}
		return itemAwareElementActions;
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
				return getItemAwareElementActions();
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
				getItemAwareElementActions().clear();
				getItemAwareElementActions().addAll((Collection<? extends ItemAwareElementAction>)newValue);
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
				getItemAwareElementActions().clear();
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
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS:
				return itemAwareElementActions != null && !itemAwareElementActions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeItemAwareElementActionImpl
