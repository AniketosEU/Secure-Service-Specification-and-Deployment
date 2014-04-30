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
package eu.aniketos.mtm.model.mtm_securebpmn2.impl;

import eu.aniketos.mtm.model.mtm_securebpmn2.Delegation;
import eu.aniketos.mtm.model.mtm_securebpmn2.Delegator;
import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl#getParentDelegators <em>Parent Delegators</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl#getChildDelegators <em>Child Delegators</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl#getMaxDelegationDepth <em>Max Delegation Depth</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl#getExecutedDelegations <em>Executed Delegations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelegatorImpl extends UserImpl implements Delegator {
	/**
	 * The cached value of the '{@link #getParentDelegators() <em>Parent Delegators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentDelegators()
	 * @generated
	 * @ordered
	 */
	protected EList<Delegator> parentDelegators;

	/**
	 * The cached value of the '{@link #getChildDelegators() <em>Child Delegators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildDelegators()
	 * @generated
	 * @ordered
	 */
	protected EList<Delegator> childDelegators;

	/**
	 * The default value of the '{@link #getMaxDelegationDepth() <em>Max Delegation Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDelegationDepth()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_DELEGATION_DEPTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxDelegationDepth() <em>Max Delegation Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDelegationDepth()
	 * @generated
	 * @ordered
	 */
	protected int maxDelegationDepth = MAX_DELEGATION_DEPTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExecutedDelegations() <em>Executed Delegations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutedDelegations()
	 * @generated
	 * @ordered
	 */
	protected EList<Delegation> executedDelegations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelegatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.DELEGATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Delegator> getParentDelegators() {
		if (parentDelegators == null) {
			parentDelegators = new EObjectWithInverseResolvingEList.ManyInverse<Delegator>(Delegator.class, this, Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS, Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS);
		}
		return parentDelegators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Delegator> getChildDelegators() {
		if (childDelegators == null) {
			childDelegators = new EObjectWithInverseResolvingEList.ManyInverse<Delegator>(Delegator.class, this, Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS, Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS);
		}
		return childDelegators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxDelegationDepth() {
		return maxDelegationDepth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxDelegationDepth(int newMaxDelegationDepth) {
		int oldMaxDelegationDepth = maxDelegationDepth;
		maxDelegationDepth = newMaxDelegationDepth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.DELEGATOR__MAX_DELEGATION_DEPTH, oldMaxDelegationDepth, maxDelegationDepth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Delegation> getExecutedDelegations() {
		if (executedDelegations == null) {
			executedDelegations = new EObjectResolvingEList<Delegation>(Delegation.class, this, Securebpmn2Package.DELEGATOR__EXECUTED_DELEGATIONS);
		}
		return executedDelegations;
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParentDelegators()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildDelegators()).basicAdd(otherEnd, msgs);
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				return ((InternalEList<?>)getParentDelegators()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				return ((InternalEList<?>)getChildDelegators()).basicRemove(otherEnd, msgs);
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				return getParentDelegators();
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				return getChildDelegators();
			case Securebpmn2Package.DELEGATOR__MAX_DELEGATION_DEPTH:
				return getMaxDelegationDepth();
			case Securebpmn2Package.DELEGATOR__EXECUTED_DELEGATIONS:
				return getExecutedDelegations();
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				getParentDelegators().clear();
				getParentDelegators().addAll((Collection<? extends Delegator>)newValue);
				return;
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				getChildDelegators().clear();
				getChildDelegators().addAll((Collection<? extends Delegator>)newValue);
				return;
			case Securebpmn2Package.DELEGATOR__MAX_DELEGATION_DEPTH:
				setMaxDelegationDepth((Integer)newValue);
				return;
			case Securebpmn2Package.DELEGATOR__EXECUTED_DELEGATIONS:
				getExecutedDelegations().clear();
				getExecutedDelegations().addAll((Collection<? extends Delegation>)newValue);
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				getParentDelegators().clear();
				return;
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				getChildDelegators().clear();
				return;
			case Securebpmn2Package.DELEGATOR__MAX_DELEGATION_DEPTH:
				setMaxDelegationDepth(MAX_DELEGATION_DEPTH_EDEFAULT);
				return;
			case Securebpmn2Package.DELEGATOR__EXECUTED_DELEGATIONS:
				getExecutedDelegations().clear();
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
			case Securebpmn2Package.DELEGATOR__PARENT_DELEGATORS:
				return parentDelegators != null && !parentDelegators.isEmpty();
			case Securebpmn2Package.DELEGATOR__CHILD_DELEGATORS:
				return childDelegators != null && !childDelegators.isEmpty();
			case Securebpmn2Package.DELEGATOR__MAX_DELEGATION_DEPTH:
				return maxDelegationDepth != MAX_DELEGATION_DEPTH_EDEFAULT;
			case Securebpmn2Package.DELEGATOR__EXECUTED_DELEGATIONS:
				return executedDelegations != null && !executedDelegations.isEmpty();
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
		result.append(" (maxDelegationDepth: ");
		result.append(maxDelegationDepth);
		result.append(')');
		return result.toString();
	}

} //DelegatorImpl
