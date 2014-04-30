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
import eu.aniketos.mtm.srs.AuthType1;
import eu.aniketos.mtm.srs.GoalSetType;
import eu.aniketos.mtm.srs.InfoSetType;
import eu.aniketos.mtm.srs.OperationSetType;
import eu.aniketos.mtm.srs.SrsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Auth Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getSource <em>Source</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getDestination <em>Destination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getInfoSet <em>Info Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getScopeSet <em>Scope Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getOperationSet <em>Operation Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.AuthType1Impl#getTransferable <em>Transferable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthType1Impl extends EObjectImpl implements AuthType1 {
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
	 * The cached value of the '{@link #getInfoSet() <em>Info Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfoSet()
	 * @generated
	 * @ordered
	 */
	protected InfoSetType infoSet;

	/**
	 * The cached value of the '{@link #getScopeSet() <em>Scope Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeSet()
	 * @generated
	 * @ordered
	 */
	protected GoalSetType scopeSet;

	/**
	 * The cached value of the '{@link #getOperationSet() <em>Operation Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationSet()
	 * @generated
	 * @ordered
	 */
	protected OperationSetType operationSet;

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
	protected AuthType1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.AUTH_TYPE1;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__SOURCE, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__SOURCE, newSource, newSource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__DESTINATION, oldDestination, newDestination);
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
				msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__DESTINATION, null, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__DESTINATION, null, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoSetType getInfoSet() {
		return infoSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfoSet(InfoSetType newInfoSet, NotificationChain msgs) {
		InfoSetType oldInfoSet = infoSet;
		infoSet = newInfoSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__INFO_SET, oldInfoSet, newInfoSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfoSet(InfoSetType newInfoSet) {
		if (newInfoSet != infoSet) {
			NotificationChain msgs = null;
			if (infoSet != null)
				msgs = ((InternalEObject)infoSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__INFO_SET, null, msgs);
			if (newInfoSet != null)
				msgs = ((InternalEObject)newInfoSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__INFO_SET, null, msgs);
			msgs = basicSetInfoSet(newInfoSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__INFO_SET, newInfoSet, newInfoSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSetType getScopeSet() {
		return scopeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScopeSet(GoalSetType newScopeSet, NotificationChain msgs) {
		GoalSetType oldScopeSet = scopeSet;
		scopeSet = newScopeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__SCOPE_SET, oldScopeSet, newScopeSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopeSet(GoalSetType newScopeSet) {
		if (newScopeSet != scopeSet) {
			NotificationChain msgs = null;
			if (scopeSet != null)
				msgs = ((InternalEObject)scopeSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__SCOPE_SET, null, msgs);
			if (newScopeSet != null)
				msgs = ((InternalEObject)newScopeSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__SCOPE_SET, null, msgs);
			msgs = basicSetScopeSet(newScopeSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__SCOPE_SET, newScopeSet, newScopeSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSetType getOperationSet() {
		return operationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationSet(OperationSetType newOperationSet, NotificationChain msgs) {
		OperationSetType oldOperationSet = operationSet;
		operationSet = newOperationSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__OPERATION_SET, oldOperationSet, newOperationSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationSet(OperationSetType newOperationSet) {
		if (newOperationSet != operationSet) {
			NotificationChain msgs = null;
			if (operationSet != null)
				msgs = ((InternalEObject)operationSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__OPERATION_SET, null, msgs);
			if (newOperationSet != null)
				msgs = ((InternalEObject)newOperationSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.AUTH_TYPE1__OPERATION_SET, null, msgs);
			msgs = basicSetOperationSet(newOperationSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__OPERATION_SET, newOperationSet, newOperationSet));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.AUTH_TYPE1__TRANSFERABLE, oldTransferable, transferable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.AUTH_TYPE1__SOURCE:
				return basicSetSource(null, msgs);
			case SrsPackage.AUTH_TYPE1__DESTINATION:
				return basicSetDestination(null, msgs);
			case SrsPackage.AUTH_TYPE1__INFO_SET:
				return basicSetInfoSet(null, msgs);
			case SrsPackage.AUTH_TYPE1__SCOPE_SET:
				return basicSetScopeSet(null, msgs);
			case SrsPackage.AUTH_TYPE1__OPERATION_SET:
				return basicSetOperationSet(null, msgs);
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
			case SrsPackage.AUTH_TYPE1__SOURCE:
				return getSource();
			case SrsPackage.AUTH_TYPE1__DESTINATION:
				return getDestination();
			case SrsPackage.AUTH_TYPE1__INFO_SET:
				return getInfoSet();
			case SrsPackage.AUTH_TYPE1__SCOPE_SET:
				return getScopeSet();
			case SrsPackage.AUTH_TYPE1__OPERATION_SET:
				return getOperationSet();
			case SrsPackage.AUTH_TYPE1__TRANSFERABLE:
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
			case SrsPackage.AUTH_TYPE1__SOURCE:
				setSource((ActorType)newValue);
				return;
			case SrsPackage.AUTH_TYPE1__DESTINATION:
				setDestination((ActorType)newValue);
				return;
			case SrsPackage.AUTH_TYPE1__INFO_SET:
				setInfoSet((InfoSetType)newValue);
				return;
			case SrsPackage.AUTH_TYPE1__SCOPE_SET:
				setScopeSet((GoalSetType)newValue);
				return;
			case SrsPackage.AUTH_TYPE1__OPERATION_SET:
				setOperationSet((OperationSetType)newValue);
				return;
			case SrsPackage.AUTH_TYPE1__TRANSFERABLE:
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
			case SrsPackage.AUTH_TYPE1__SOURCE:
				setSource((ActorType)null);
				return;
			case SrsPackage.AUTH_TYPE1__DESTINATION:
				setDestination((ActorType)null);
				return;
			case SrsPackage.AUTH_TYPE1__INFO_SET:
				setInfoSet((InfoSetType)null);
				return;
			case SrsPackage.AUTH_TYPE1__SCOPE_SET:
				setScopeSet((GoalSetType)null);
				return;
			case SrsPackage.AUTH_TYPE1__OPERATION_SET:
				setOperationSet((OperationSetType)null);
				return;
			case SrsPackage.AUTH_TYPE1__TRANSFERABLE:
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
			case SrsPackage.AUTH_TYPE1__SOURCE:
				return source != null;
			case SrsPackage.AUTH_TYPE1__DESTINATION:
				return destination != null;
			case SrsPackage.AUTH_TYPE1__INFO_SET:
				return infoSet != null;
			case SrsPackage.AUTH_TYPE1__SCOPE_SET:
				return scopeSet != null;
			case SrsPackage.AUTH_TYPE1__OPERATION_SET:
				return operationSet != null;
			case SrsPackage.AUTH_TYPE1__TRANSFERABLE:
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

} //AuthType1Impl
