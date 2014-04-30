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
package eu.aniketos.mtm.mapping.impl;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.IntegrityType;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.mapping.TypeType1;
import eu.aniketos.mtm.mapping.TypeType;

import java.math.BigInteger;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getTrustworthiness <em>Trustworthiness</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getThreat <em>Threat</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl#getUsertype <em>Usertype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityTypeImpl extends EObjectImpl implements ActivityType {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

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
	 * The default value of the '{@link #getUsertype() <em>Usertype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsertype()
	 * @generated
	 * @ordered
	 */
	protected static final UsertypeType USERTYPE_EDEFAULT = UsertypeType.USER_TASK;

	/**
	 * The cached value of the '{@link #getUsertype() <em>Usertype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsertype()
	 * @generated
	 * @ordered
	 */
	protected UsertypeType usertype = USERTYPE_EDEFAULT;

	/**
	 * This is true if the Usertype attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean usertypeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ACTIVITY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, MappingPackage.ACTIVITY_TYPE__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)getMixed().get(MappingPackage.Literals.ACTIVITY_TYPE__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		((FeatureMap.Internal)getMixed()).set(MappingPackage.Literals.ACTIVITY_TYPE__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityVar> getVariable() {
		return getMixed().list(MappingPackage.Literals.ACTIVITY_TYPE__VARIABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParticipant() {
		return getMixed().list(MappingPackage.Literals.ACTIVITY_TYPE__PARTICIPANT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTrustworthiness() {
		return (Float)getMixed().get(MappingPackage.Literals.ACTIVITY_TYPE__TRUSTWORTHINESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrustworthiness(float newTrustworthiness) {
		((FeatureMap.Internal)getMixed()).set(MappingPackage.Literals.ACTIVITY_TYPE__TRUSTWORTHINESS, newTrustworthiness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTrustworthiness() {
		((FeatureMap.Internal)getMixed()).clear(MappingPackage.Literals.ACTIVITY_TYPE__TRUSTWORTHINESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTrustworthiness() {
		return !((FeatureMap.Internal)getMixed()).isEmpty(MappingPackage.Literals.ACTIVITY_TYPE__TRUSTWORTHINESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegrityType> getIntegrity() {
		return getMixed().list(MappingPackage.Literals.ACTIVITY_TYPE__INTEGRITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PermissionType> getPermission() {
		return getMixed().list(MappingPackage.Literals.ACTIVITY_TYPE__PERMISSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getThreat() {
		return getMixed().list(MappingPackage.Literals.ACTIVITY_TYPE__THREAT);
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ACTIVITY_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsertypeType getUsertype() {
		return usertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsertype(UsertypeType newUsertype) {
		UsertypeType oldUsertype = usertype;
		usertype = newUsertype == null ? USERTYPE_EDEFAULT : newUsertype;
		boolean oldUsertypeESet = usertypeESet;
		usertypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ACTIVITY_TYPE__USERTYPE, oldUsertype, usertype, !oldUsertypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUsertype() {
		UsertypeType oldUsertype = usertype;
		boolean oldUsertypeESet = usertypeESet;
		usertype = USERTYPE_EDEFAULT;
		usertypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MappingPackage.ACTIVITY_TYPE__USERTYPE, oldUsertype, USERTYPE_EDEFAULT, oldUsertypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUsertype() {
		return usertypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.ACTIVITY_TYPE__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case MappingPackage.ACTIVITY_TYPE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case MappingPackage.ACTIVITY_TYPE__INTEGRITY:
				return ((InternalEList<?>)getIntegrity()).basicRemove(otherEnd, msgs);
			case MappingPackage.ACTIVITY_TYPE__PERMISSION:
				return ((InternalEList<?>)getPermission()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.ACTIVITY_TYPE__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case MappingPackage.ACTIVITY_TYPE__VALUE:
				return getValue();
			case MappingPackage.ACTIVITY_TYPE__VARIABLE:
				return getVariable();
			case MappingPackage.ACTIVITY_TYPE__PARTICIPANT:
				return getParticipant();
			case MappingPackage.ACTIVITY_TYPE__TRUSTWORTHINESS:
				return getTrustworthiness();
			case MappingPackage.ACTIVITY_TYPE__INTEGRITY:
				return getIntegrity();
			case MappingPackage.ACTIVITY_TYPE__PERMISSION:
				return getPermission();
			case MappingPackage.ACTIVITY_TYPE__THREAT:
				return getThreat();
			case MappingPackage.ACTIVITY_TYPE__ID:
				return getId();
			case MappingPackage.ACTIVITY_TYPE__USERTYPE:
				return getUsertype();
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
			case MappingPackage.ACTIVITY_TYPE__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends ActivityVar>)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__PARTICIPANT:
				getParticipant().clear();
				getParticipant().addAll((Collection<? extends String>)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__TRUSTWORTHINESS:
				setTrustworthiness((Float)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__INTEGRITY:
				getIntegrity().clear();
				getIntegrity().addAll((Collection<? extends IntegrityType>)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__PERMISSION:
				getPermission().clear();
				getPermission().addAll((Collection<? extends PermissionType>)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__THREAT:
				getThreat().clear();
				getThreat().addAll((Collection<? extends String>)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__ID:
				setId((String)newValue);
				return;
			case MappingPackage.ACTIVITY_TYPE__USERTYPE:
				setUsertype((UsertypeType)newValue);
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
			case MappingPackage.ACTIVITY_TYPE__MIXED:
				getMixed().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case MappingPackage.ACTIVITY_TYPE__VARIABLE:
				getVariable().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__PARTICIPANT:
				getParticipant().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__TRUSTWORTHINESS:
				unsetTrustworthiness();
				return;
			case MappingPackage.ACTIVITY_TYPE__INTEGRITY:
				getIntegrity().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__PERMISSION:
				getPermission().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__THREAT:
				getThreat().clear();
				return;
			case MappingPackage.ACTIVITY_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case MappingPackage.ACTIVITY_TYPE__USERTYPE:
				unsetUsertype();
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
			case MappingPackage.ACTIVITY_TYPE__MIXED:
				return mixed != null && !mixed.isEmpty();
			case MappingPackage.ACTIVITY_TYPE__VALUE:
				return VALUE_EDEFAULT == null ? getValue() != null : !VALUE_EDEFAULT.equals(getValue());
			case MappingPackage.ACTIVITY_TYPE__VARIABLE:
				return !getVariable().isEmpty();
			case MappingPackage.ACTIVITY_TYPE__PARTICIPANT:
				return !getParticipant().isEmpty();
			case MappingPackage.ACTIVITY_TYPE__TRUSTWORTHINESS:
				return isSetTrustworthiness();
			case MappingPackage.ACTIVITY_TYPE__INTEGRITY:
				return !getIntegrity().isEmpty();
			case MappingPackage.ACTIVITY_TYPE__PERMISSION:
				return !getPermission().isEmpty();
			case MappingPackage.ACTIVITY_TYPE__THREAT:
				return !getThreat().isEmpty();
			case MappingPackage.ACTIVITY_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case MappingPackage.ACTIVITY_TYPE__USERTYPE:
				return isSetUsertype();
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(", id: ");
		result.append(id);
		result.append(", usertype: ");
		if (usertypeESet) result.append(usertype); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ActivityTypeImpl
