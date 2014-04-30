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
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.SrsPackage;
import eu.aniketos.mtm.srs.ThreatType;

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
 * An implementation of the model object '<em><b>Threat Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getDocument <em>Document</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getGoal <em>Goal</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl#getRepositoryID <em>Repository ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreatTypeImpl extends EObjectImpl implements ThreatType {
	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorType> actor;

	/**
	 * The cached value of the '{@link #getDocument() <em>Document</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocument()
	 * @generated
	 * @ordered
	 */
	protected EList<DocType> document;

	/**
	 * The cached value of the '{@link #getGoal() <em>Goal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected EList<GoalType> goal;

	/**
	 * The cached value of the '{@link #getDelegation() <em>Delegation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegation()
	 * @generated
	 * @ordered
	 */
	protected EList<DelType> delegation;

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
	 * The default value of the '{@link #getRepositoryID() <em>Repository ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryID()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryID() <em>Repository ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryID()
	 * @generated
	 * @ordered
	 */
	protected String repositoryID = REPOSITORY_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreatTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.THREAT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorType> getActor() {
		if (actor == null) {
			actor = new EObjectContainmentEList<ActorType>(ActorType.class, this, SrsPackage.THREAT_TYPE__ACTOR);
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDocument() {
		if (document == null) {
			document = new EObjectContainmentEList<DocType>(DocType.class, this, SrsPackage.THREAT_TYPE__DOCUMENT);
		}
		return document;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GoalType> getGoal() {
		if (goal == null) {
			goal = new EObjectContainmentEList<GoalType>(GoalType.class, this, SrsPackage.THREAT_TYPE__GOAL);
		}
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DelType> getDelegation() {
		if (delegation == null) {
			delegation = new EObjectContainmentEList<DelType>(DelType.class, this, SrsPackage.THREAT_TYPE__DELEGATION);
		}
		return delegation;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.THREAT_TYPE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.THREAT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryID() {
		return repositoryID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryID(String newRepositoryID) {
		String oldRepositoryID = repositoryID;
		repositoryID = newRepositoryID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.THREAT_TYPE__REPOSITORY_ID, oldRepositoryID, repositoryID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.THREAT_TYPE__ACTOR:
				return ((InternalEList<?>)getActor()).basicRemove(otherEnd, msgs);
			case SrsPackage.THREAT_TYPE__DOCUMENT:
				return ((InternalEList<?>)getDocument()).basicRemove(otherEnd, msgs);
			case SrsPackage.THREAT_TYPE__GOAL:
				return ((InternalEList<?>)getGoal()).basicRemove(otherEnd, msgs);
			case SrsPackage.THREAT_TYPE__DELEGATION:
				return ((InternalEList<?>)getDelegation()).basicRemove(otherEnd, msgs);
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
			case SrsPackage.THREAT_TYPE__ACTOR:
				return getActor();
			case SrsPackage.THREAT_TYPE__DOCUMENT:
				return getDocument();
			case SrsPackage.THREAT_TYPE__GOAL:
				return getGoal();
			case SrsPackage.THREAT_TYPE__DELEGATION:
				return getDelegation();
			case SrsPackage.THREAT_TYPE__ID:
				return getId();
			case SrsPackage.THREAT_TYPE__NAME:
				return getName();
			case SrsPackage.THREAT_TYPE__REPOSITORY_ID:
				return getRepositoryID();
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
			case SrsPackage.THREAT_TYPE__ACTOR:
				getActor().clear();
				getActor().addAll((Collection<? extends ActorType>)newValue);
				return;
			case SrsPackage.THREAT_TYPE__DOCUMENT:
				getDocument().clear();
				getDocument().addAll((Collection<? extends DocType>)newValue);
				return;
			case SrsPackage.THREAT_TYPE__GOAL:
				getGoal().clear();
				getGoal().addAll((Collection<? extends GoalType>)newValue);
				return;
			case SrsPackage.THREAT_TYPE__DELEGATION:
				getDelegation().clear();
				getDelegation().addAll((Collection<? extends DelType>)newValue);
				return;
			case SrsPackage.THREAT_TYPE__ID:
				setId((String)newValue);
				return;
			case SrsPackage.THREAT_TYPE__NAME:
				setName((String)newValue);
				return;
			case SrsPackage.THREAT_TYPE__REPOSITORY_ID:
				setRepositoryID((String)newValue);
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
			case SrsPackage.THREAT_TYPE__ACTOR:
				getActor().clear();
				return;
			case SrsPackage.THREAT_TYPE__DOCUMENT:
				getDocument().clear();
				return;
			case SrsPackage.THREAT_TYPE__GOAL:
				getGoal().clear();
				return;
			case SrsPackage.THREAT_TYPE__DELEGATION:
				getDelegation().clear();
				return;
			case SrsPackage.THREAT_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case SrsPackage.THREAT_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SrsPackage.THREAT_TYPE__REPOSITORY_ID:
				setRepositoryID(REPOSITORY_ID_EDEFAULT);
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
			case SrsPackage.THREAT_TYPE__ACTOR:
				return actor != null && !actor.isEmpty();
			case SrsPackage.THREAT_TYPE__DOCUMENT:
				return document != null && !document.isEmpty();
			case SrsPackage.THREAT_TYPE__GOAL:
				return goal != null && !goal.isEmpty();
			case SrsPackage.THREAT_TYPE__DELEGATION:
				return delegation != null && !delegation.isEmpty();
			case SrsPackage.THREAT_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SrsPackage.THREAT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SrsPackage.THREAT_TYPE__REPOSITORY_ID:
				return REPOSITORY_ID_EDEFAULT == null ? repositoryID != null : !REPOSITORY_ID_EDEFAULT.equals(repositoryID);
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
		result.append(", name: ");
		result.append(name);
		result.append(", repositoryID: ");
		result.append(repositoryID);
		result.append(')');
		return result.toString();
	}

} //ThreatTypeImpl
