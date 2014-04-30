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

import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.KBType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.SrsPackage;

import eu.aniketos.mtm.srs.ThreatListType;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sec Req Spe Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl#getCommitment <em>Commitment</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl#getKnowledgeBase <em>Knowledge Base</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl#getThreatList <em>Threat List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecReqSpeTypeImpl extends EObjectImpl implements SecReqSpeType {
	/**
	 * The cached value of the '{@link #getCommitment() <em>Commitment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommitment()
	 * @generated
	 * @ordered
	 */
	protected EList<CommitmentType> commitment;

	/**
	 * The cached value of the '{@link #getKnowledgeBase() <em>Knowledge Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKnowledgeBase()
	 * @generated
	 * @ordered
	 */
	protected KBType knowledgeBase;

	/**
	 * The cached value of the '{@link #getThreatList() <em>Threat List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreatList()
	 * @generated
	 * @ordered
	 */
	protected ThreatListType threatList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecReqSpeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.SEC_REQ_SPE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommitmentType> getCommitment() {
		if (commitment == null) {
			commitment = new EObjectContainmentEList<CommitmentType>(CommitmentType.class, this, SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT);
		}
		return commitment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KBType getKnowledgeBase() {
		return knowledgeBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKnowledgeBase(KBType newKnowledgeBase, NotificationChain msgs) {
		KBType oldKnowledgeBase = knowledgeBase;
		knowledgeBase = newKnowledgeBase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE, oldKnowledgeBase, newKnowledgeBase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKnowledgeBase(KBType newKnowledgeBase) {
		if (newKnowledgeBase != knowledgeBase) {
			NotificationChain msgs = null;
			if (knowledgeBase != null)
				msgs = ((InternalEObject)knowledgeBase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE, null, msgs);
			if (newKnowledgeBase != null)
				msgs = ((InternalEObject)newKnowledgeBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE, null, msgs);
			msgs = basicSetKnowledgeBase(newKnowledgeBase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE, newKnowledgeBase, newKnowledgeBase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatListType getThreatList() {
		return threatList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThreatList(ThreatListType newThreatList, NotificationChain msgs) {
		ThreatListType oldThreatList = threatList;
		threatList = newThreatList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST, oldThreatList, newThreatList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreatList(ThreatListType newThreatList) {
		if (newThreatList != threatList) {
			NotificationChain msgs = null;
			if (threatList != null)
				msgs = ((InternalEObject)threatList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST, null, msgs);
			if (newThreatList != null)
				msgs = ((InternalEObject)newThreatList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST, null, msgs);
			msgs = basicSetThreatList(newThreatList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST, newThreatList, newThreatList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT:
				return ((InternalEList<?>)getCommitment()).basicRemove(otherEnd, msgs);
			case SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE:
				return basicSetKnowledgeBase(null, msgs);
			case SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST:
				return basicSetThreatList(null, msgs);
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
			case SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT:
				return getCommitment();
			case SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE:
				return getKnowledgeBase();
			case SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST:
				return getThreatList();
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
			case SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT:
				getCommitment().clear();
				getCommitment().addAll((Collection<? extends CommitmentType>)newValue);
				return;
			case SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE:
				setKnowledgeBase((KBType)newValue);
				return;
			case SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST:
				setThreatList((ThreatListType)newValue);
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
			case SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT:
				getCommitment().clear();
				return;
			case SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE:
				setKnowledgeBase((KBType)null);
				return;
			case SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST:
				setThreatList((ThreatListType)null);
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
			case SrsPackage.SEC_REQ_SPE_TYPE__COMMITMENT:
				return commitment != null && !commitment.isEmpty();
			case SrsPackage.SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE:
				return knowledgeBase != null;
			case SrsPackage.SEC_REQ_SPE_TYPE__THREAT_LIST:
				return threatList != null;
		}
		return super.eIsSet(featureID);
	}

} //SecReqSpeTypeImpl
