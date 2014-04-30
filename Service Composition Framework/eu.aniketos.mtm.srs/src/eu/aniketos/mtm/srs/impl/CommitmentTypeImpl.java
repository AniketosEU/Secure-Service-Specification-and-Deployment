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
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.PreType;
import eu.aniketos.mtm.srs.SrsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Commitment Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl#getDebtor <em>Debtor</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl#getCreditor <em>Creditor</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommitmentTypeImpl extends EObjectImpl implements CommitmentType {
	/**
	 * The cached value of the '{@link #getDebtor() <em>Debtor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDebtor()
	 * @generated
	 * @ordered
	 */
	protected ActorType debtor;

	/**
	 * The cached value of the '{@link #getCreditor() <em>Creditor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreditor()
	 * @generated
	 * @ordered
	 */
	protected ActorType creditor;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected PreType precondition;

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected PostType postcondition;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommitmentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.COMMITMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorType getDebtor() {
		return debtor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDebtor(ActorType newDebtor, NotificationChain msgs) {
		ActorType oldDebtor = debtor;
		debtor = newDebtor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__DEBTOR, oldDebtor, newDebtor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebtor(ActorType newDebtor) {
		if (newDebtor != debtor) {
			NotificationChain msgs = null;
			if (debtor != null)
				msgs = ((InternalEObject)debtor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__DEBTOR, null, msgs);
			if (newDebtor != null)
				msgs = ((InternalEObject)newDebtor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__DEBTOR, null, msgs);
			msgs = basicSetDebtor(newDebtor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__DEBTOR, newDebtor, newDebtor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorType getCreditor() {
		return creditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreditor(ActorType newCreditor, NotificationChain msgs) {
		ActorType oldCreditor = creditor;
		creditor = newCreditor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__CREDITOR, oldCreditor, newCreditor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreditor(ActorType newCreditor) {
		if (newCreditor != creditor) {
			NotificationChain msgs = null;
			if (creditor != null)
				msgs = ((InternalEObject)creditor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__CREDITOR, null, msgs);
			if (newCreditor != null)
				msgs = ((InternalEObject)newCreditor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__CREDITOR, null, msgs);
			msgs = basicSetCreditor(newCreditor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__CREDITOR, newCreditor, newCreditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreType getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrecondition(PreType newPrecondition, NotificationChain msgs) {
		PreType oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__PRECONDITION, oldPrecondition, newPrecondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(PreType newPrecondition) {
		if (newPrecondition != precondition) {
			NotificationChain msgs = null;
			if (precondition != null)
				msgs = ((InternalEObject)precondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__PRECONDITION, null, msgs);
			if (newPrecondition != null)
				msgs = ((InternalEObject)newPrecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__PRECONDITION, null, msgs);
			msgs = basicSetPrecondition(newPrecondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__PRECONDITION, newPrecondition, newPrecondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostType getPostcondition() {
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPostcondition(PostType newPostcondition, NotificationChain msgs) {
		PostType oldPostcondition = postcondition;
		postcondition = newPostcondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__POSTCONDITION, oldPostcondition, newPostcondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostcondition(PostType newPostcondition) {
		if (newPostcondition != postcondition) {
			NotificationChain msgs = null;
			if (postcondition != null)
				msgs = ((InternalEObject)postcondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__POSTCONDITION, null, msgs);
			if (newPostcondition != null)
				msgs = ((InternalEObject)newPostcondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.COMMITMENT_TYPE__POSTCONDITION, null, msgs);
			msgs = basicSetPostcondition(newPostcondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__POSTCONDITION, newPostcondition, newPostcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.COMMITMENT_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.COMMITMENT_TYPE__DEBTOR:
				return basicSetDebtor(null, msgs);
			case SrsPackage.COMMITMENT_TYPE__CREDITOR:
				return basicSetCreditor(null, msgs);
			case SrsPackage.COMMITMENT_TYPE__PRECONDITION:
				return basicSetPrecondition(null, msgs);
			case SrsPackage.COMMITMENT_TYPE__POSTCONDITION:
				return basicSetPostcondition(null, msgs);
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
			case SrsPackage.COMMITMENT_TYPE__DEBTOR:
				return getDebtor();
			case SrsPackage.COMMITMENT_TYPE__CREDITOR:
				return getCreditor();
			case SrsPackage.COMMITMENT_TYPE__PRECONDITION:
				return getPrecondition();
			case SrsPackage.COMMITMENT_TYPE__POSTCONDITION:
				return getPostcondition();
			case SrsPackage.COMMITMENT_TYPE__ID:
				return getId();
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
			case SrsPackage.COMMITMENT_TYPE__DEBTOR:
				setDebtor((ActorType)newValue);
				return;
			case SrsPackage.COMMITMENT_TYPE__CREDITOR:
				setCreditor((ActorType)newValue);
				return;
			case SrsPackage.COMMITMENT_TYPE__PRECONDITION:
				setPrecondition((PreType)newValue);
				return;
			case SrsPackage.COMMITMENT_TYPE__POSTCONDITION:
				setPostcondition((PostType)newValue);
				return;
			case SrsPackage.COMMITMENT_TYPE__ID:
				setId((String)newValue);
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
			case SrsPackage.COMMITMENT_TYPE__DEBTOR:
				setDebtor((ActorType)null);
				return;
			case SrsPackage.COMMITMENT_TYPE__CREDITOR:
				setCreditor((ActorType)null);
				return;
			case SrsPackage.COMMITMENT_TYPE__PRECONDITION:
				setPrecondition((PreType)null);
				return;
			case SrsPackage.COMMITMENT_TYPE__POSTCONDITION:
				setPostcondition((PostType)null);
				return;
			case SrsPackage.COMMITMENT_TYPE__ID:
				setId(ID_EDEFAULT);
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
			case SrsPackage.COMMITMENT_TYPE__DEBTOR:
				return debtor != null;
			case SrsPackage.COMMITMENT_TYPE__CREDITOR:
				return creditor != null;
			case SrsPackage.COMMITMENT_TYPE__PRECONDITION:
				return precondition != null;
			case SrsPackage.COMMITMENT_TYPE__POSTCONDITION:
				return postcondition != null;
			case SrsPackage.COMMITMENT_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //CommitmentTypeImpl
