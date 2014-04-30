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
package eu.aniketos.mtm.srs.impl;

import eu.aniketos.mtm.srs.BoDSoDGoalType;
import eu.aniketos.mtm.srs.GoalSetTypeMin2;
import eu.aniketos.mtm.srs.SrsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bo DSo DGoal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.BoDSoDGoalTypeImpl#getGoalSet <em>Goal Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoDSoDGoalTypeImpl extends EObjectImpl implements BoDSoDGoalType {
	/**
	 * The cached value of the '{@link #getGoalSet() <em>Goal Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalSet()
	 * @generated
	 * @ordered
	 */
	protected GoalSetTypeMin2 goalSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoDSoDGoalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.BO_DSO_DGOAL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSetTypeMin2 getGoalSet() {
		return goalSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoalSet(GoalSetTypeMin2 newGoalSet, NotificationChain msgs) {
		GoalSetTypeMin2 oldGoalSet = goalSet;
		goalSet = newGoalSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET, oldGoalSet, newGoalSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoalSet(GoalSetTypeMin2 newGoalSet) {
		if (newGoalSet != goalSet) {
			NotificationChain msgs = null;
			if (goalSet != null)
				msgs = ((InternalEObject)goalSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET, null, msgs);
			if (newGoalSet != null)
				msgs = ((InternalEObject)newGoalSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET, null, msgs);
			msgs = basicSetGoalSet(newGoalSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET, newGoalSet, newGoalSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET:
				return basicSetGoalSet(null, msgs);
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
			case SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET:
				return getGoalSet();
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
			case SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET:
				setGoalSet((GoalSetTypeMin2)newValue);
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
			case SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET:
				setGoalSet((GoalSetTypeMin2)null);
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
			case SrsPackage.BO_DSO_DGOAL_TYPE__GOAL_SET:
				return goalSet != null;
		}
		return super.eIsSet(featureID);
	}

} //BoDSoDGoalTypeImpl
