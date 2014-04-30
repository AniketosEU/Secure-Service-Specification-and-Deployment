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

import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.GoalSetType;
import eu.aniketos.mtm.srs.SrsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Del Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.DelTypeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.DelTypeImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.DelTypeImpl#getGoalSet <em>Goal Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.DelTypeImpl#getTransferable <em>Transferable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelTypeImpl extends EObjectImpl implements DelType {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ActorType source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ActorType destination;

	/**
	 * The cached value of the '{@link #getGoalSet() <em>Goal Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalSet()
	 * @generated
	 * @ordered
	 */
	protected GoalSetType goalSet;

	/**
	 * The default value of the '{@link #getTransferable() <em>Transferable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferable()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFERABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransferable() <em>Transferable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferable()
	 * @generated
	 * @ordered
	 */
	protected String transferable = TRANSFERABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.DEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorType getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ActorType newSource, NotificationChain msgs) {
		ActorType oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ActorType newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorType getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(ActorType newDestination, NotificationChain msgs) {
		ActorType oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(ActorType newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__DESTINATION, null, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__DESTINATION, null, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSetType getGoalSet() {
		return goalSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGoalSet(GoalSetType newGoalSet, NotificationChain msgs) {
		GoalSetType oldGoalSet = goalSet;
		goalSet = newGoalSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__GOAL_SET, oldGoalSet, newGoalSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoalSet(GoalSetType newGoalSet) {
		if (newGoalSet != goalSet) {
			NotificationChain msgs = null;
			if (goalSet != null)
				msgs = ((InternalEObject)goalSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__GOAL_SET, null, msgs);
			if (newGoalSet != null)
				msgs = ((InternalEObject)newGoalSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.DEL_TYPE__GOAL_SET, null, msgs);
			msgs = basicSetGoalSet(newGoalSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__GOAL_SET, newGoalSet, newGoalSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransferable() {
		return transferable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransferable(String newTransferable) {
		String oldTransferable = transferable;
		transferable = newTransferable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.DEL_TYPE__TRANSFERABLE, oldTransferable, transferable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.DEL_TYPE__SOURCE:
				return basicSetSource(null, msgs);
			case SrsPackage.DEL_TYPE__DESTINATION:
				return basicSetDestination(null, msgs);
			case SrsPackage.DEL_TYPE__GOAL_SET:
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
			case SrsPackage.DEL_TYPE__SOURCE:
				return getSource();
			case SrsPackage.DEL_TYPE__DESTINATION:
				return getDestination();
			case SrsPackage.DEL_TYPE__GOAL_SET:
				return getGoalSet();
			case SrsPackage.DEL_TYPE__TRANSFERABLE:
				return getTransferable();
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
			case SrsPackage.DEL_TYPE__SOURCE:
				setSource((ActorType)newValue);
				return;
			case SrsPackage.DEL_TYPE__DESTINATION:
				setDestination((ActorType)newValue);
				return;
			case SrsPackage.DEL_TYPE__GOAL_SET:
				setGoalSet((GoalSetType)newValue);
				return;
			case SrsPackage.DEL_TYPE__TRANSFERABLE:
				setTransferable((String)newValue);
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
			case SrsPackage.DEL_TYPE__SOURCE:
				setSource((ActorType)null);
				return;
			case SrsPackage.DEL_TYPE__DESTINATION:
				setDestination((ActorType)null);
				return;
			case SrsPackage.DEL_TYPE__GOAL_SET:
				setGoalSet((GoalSetType)null);
				return;
			case SrsPackage.DEL_TYPE__TRANSFERABLE:
				setTransferable(TRANSFERABLE_EDEFAULT);
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
			case SrsPackage.DEL_TYPE__SOURCE:
				return source != null;
			case SrsPackage.DEL_TYPE__DESTINATION:
				return destination != null;
			case SrsPackage.DEL_TYPE__GOAL_SET:
				return goalSet != null;
			case SrsPackage.DEL_TYPE__TRANSFERABLE:
				return TRANSFERABLE_EDEFAULT == null ? transferable != null : !TRANSFERABLE_EDEFAULT.equals(transferable);
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
		result.append(" (transferable: ");
		result.append(transferable);
		result.append(')');
		return result.toString();
	}

} //DelTypeImpl
