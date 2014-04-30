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

import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;

import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.ThreatsMapping;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getRelatesTo <em>Relates To</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getRepresents <em>Represents</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getIsA <em>Is A</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getPlays <em>Plays</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getSoDBoDProperties <em>So DBo DProperties</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl#getThreats <em>Threats</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingTypeImpl extends EObjectImpl implements MappingType {
	/**
	 * The cached value of the '{@link #getRelatesTo() <em>Relates To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatesTo()
	 * @generated
	 * @ordered
	 */
	protected EList<RelatesToType> relatesTo;

	/**
	 * The cached value of the '{@link #getRepresents() <em>Represents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresents()
	 * @generated
	 * @ordered
	 */
	protected EList<RepresentsType> represents;

	/**
	 * The cached value of the '{@link #getIsA() <em>Is A</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsA()
	 * @generated
	 * @ordered
	 */
	protected EList<IsaType> isA;

	/**
	 * The cached value of the '{@link #getPlays() <em>Plays</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlays()
	 * @generated
	 * @ordered
	 */
	protected EList<PlaysType> plays;

	/**
	 * The cached value of the '{@link #getSoDBoDProperties() <em>So DBo DProperties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoDBoDProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<SoDBoDType> soDBoDProperties;

	/**
	 * The cached value of the '{@link #getThreats() <em>Threats</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreats()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreatsMapping> threats;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelatesToType> getRelatesTo() {
		if (relatesTo == null) {
			relatesTo = new EObjectContainmentEList<RelatesToType>(RelatesToType.class, this, MappingPackage.MAPPING_TYPE__RELATES_TO);
		}
		return relatesTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepresentsType> getRepresents() {
		if (represents == null) {
			represents = new EObjectContainmentEList<RepresentsType>(RepresentsType.class, this, MappingPackage.MAPPING_TYPE__REPRESENTS);
		}
		return represents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IsaType> getIsA() {
		if (isA == null) {
			isA = new EObjectContainmentEList<IsaType>(IsaType.class, this, MappingPackage.MAPPING_TYPE__IS_A);
		}
		return isA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlaysType> getPlays() {
		if (plays == null) {
			plays = new EObjectContainmentEList<PlaysType>(PlaysType.class, this, MappingPackage.MAPPING_TYPE__PLAYS);
		}
		return plays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SoDBoDType> getSoDBoDProperties() {
		if (soDBoDProperties == null) {
			soDBoDProperties = new EObjectContainmentEList<SoDBoDType>(SoDBoDType.class, this, MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES);
		}
		return soDBoDProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ThreatsMapping> getThreats() {
		if (threats == null) {
			threats = new EObjectContainmentEList<ThreatsMapping>(ThreatsMapping.class, this, MappingPackage.MAPPING_TYPE__THREATS);
		}
		return threats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_TYPE__RELATES_TO:
				return ((InternalEList<?>)getRelatesTo()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING_TYPE__REPRESENTS:
				return ((InternalEList<?>)getRepresents()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING_TYPE__IS_A:
				return ((InternalEList<?>)getIsA()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING_TYPE__PLAYS:
				return ((InternalEList<?>)getPlays()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES:
				return ((InternalEList<?>)getSoDBoDProperties()).basicRemove(otherEnd, msgs);
			case MappingPackage.MAPPING_TYPE__THREATS:
				return ((InternalEList<?>)getThreats()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_TYPE__RELATES_TO:
				return getRelatesTo();
			case MappingPackage.MAPPING_TYPE__REPRESENTS:
				return getRepresents();
			case MappingPackage.MAPPING_TYPE__IS_A:
				return getIsA();
			case MappingPackage.MAPPING_TYPE__PLAYS:
				return getPlays();
			case MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES:
				return getSoDBoDProperties();
			case MappingPackage.MAPPING_TYPE__THREATS:
				return getThreats();
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
			case MappingPackage.MAPPING_TYPE__RELATES_TO:
				getRelatesTo().clear();
				getRelatesTo().addAll((Collection<? extends RelatesToType>)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__REPRESENTS:
				getRepresents().clear();
				getRepresents().addAll((Collection<? extends RepresentsType>)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__IS_A:
				getIsA().clear();
				getIsA().addAll((Collection<? extends IsaType>)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__PLAYS:
				getPlays().clear();
				getPlays().addAll((Collection<? extends PlaysType>)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES:
				getSoDBoDProperties().clear();
				getSoDBoDProperties().addAll((Collection<? extends SoDBoDType>)newValue);
				return;
			case MappingPackage.MAPPING_TYPE__THREATS:
				getThreats().clear();
				getThreats().addAll((Collection<? extends ThreatsMapping>)newValue);
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
			case MappingPackage.MAPPING_TYPE__RELATES_TO:
				getRelatesTo().clear();
				return;
			case MappingPackage.MAPPING_TYPE__REPRESENTS:
				getRepresents().clear();
				return;
			case MappingPackage.MAPPING_TYPE__IS_A:
				getIsA().clear();
				return;
			case MappingPackage.MAPPING_TYPE__PLAYS:
				getPlays().clear();
				return;
			case MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES:
				getSoDBoDProperties().clear();
				return;
			case MappingPackage.MAPPING_TYPE__THREATS:
				getThreats().clear();
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
			case MappingPackage.MAPPING_TYPE__RELATES_TO:
				return relatesTo != null && !relatesTo.isEmpty();
			case MappingPackage.MAPPING_TYPE__REPRESENTS:
				return represents != null && !represents.isEmpty();
			case MappingPackage.MAPPING_TYPE__IS_A:
				return isA != null && !isA.isEmpty();
			case MappingPackage.MAPPING_TYPE__PLAYS:
				return plays != null && !plays.isEmpty();
			case MappingPackage.MAPPING_TYPE__SO_DBO_DPROPERTIES:
				return soDBoDProperties != null && !soDBoDProperties.isEmpty();
			case MappingPackage.MAPPING_TYPE__THREATS:
				return threats != null && !threats.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingTypeImpl
