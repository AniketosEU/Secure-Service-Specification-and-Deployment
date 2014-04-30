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

import eu.aniketos.mtm.srs.KBType;
import eu.aniketos.mtm.srs.OwnsType;
import eu.aniketos.mtm.srs.PartOfType;
import eu.aniketos.mtm.srs.SrsPackage;
import eu.aniketos.mtm.srs.TangibleByType;

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
 * An implementation of the model object '<em><b>KB Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.KBTypeImpl#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.KBTypeImpl#getTangibleBy <em>Tangible By</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.KBTypeImpl#getOwns <em>Owns</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.KBTypeImpl#getFullyAuthorized <em>Fully Authorized</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KBTypeImpl extends EObjectImpl implements KBType {
	/**
	 * The cached value of the '{@link #getPartOf() <em>Part Of</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartOf()
	 * @generated
	 * @ordered
	 */
	protected EList<PartOfType> partOf;

	/**
	 * The cached value of the '{@link #getTangibleBy() <em>Tangible By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTangibleBy()
	 * @generated
	 * @ordered
	 */
	protected EList<TangibleByType> tangibleBy;

	/**
	 * The cached value of the '{@link #getOwns() <em>Owns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwns()
	 * @generated
	 * @ordered
	 */
	protected EList<OwnsType> owns;

	/**
	 * The cached value of the '{@link #getFullyAuthorized() <em>Fully Authorized</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFullyAuthorized()
	 * @generated
	 * @ordered
	 */
	protected EList<OwnsType> fullyAuthorized;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KBTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.KB_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PartOfType> getPartOf() {
		if (partOf == null) {
			partOf = new EObjectContainmentEList<PartOfType>(PartOfType.class, this, SrsPackage.KB_TYPE__PART_OF);
		}
		return partOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TangibleByType> getTangibleBy() {
		if (tangibleBy == null) {
			tangibleBy = new EObjectContainmentEList<TangibleByType>(TangibleByType.class, this, SrsPackage.KB_TYPE__TANGIBLE_BY);
		}
		return tangibleBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OwnsType> getOwns() {
		if (owns == null) {
			owns = new EObjectContainmentEList<OwnsType>(OwnsType.class, this, SrsPackage.KB_TYPE__OWNS);
		}
		return owns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OwnsType> getFullyAuthorized() {
		if (fullyAuthorized == null) {
			fullyAuthorized = new EObjectContainmentEList<OwnsType>(OwnsType.class, this, SrsPackage.KB_TYPE__FULLY_AUTHORIZED);
		}
		return fullyAuthorized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.KB_TYPE__PART_OF:
				return ((InternalEList<?>)getPartOf()).basicRemove(otherEnd, msgs);
			case SrsPackage.KB_TYPE__TANGIBLE_BY:
				return ((InternalEList<?>)getTangibleBy()).basicRemove(otherEnd, msgs);
			case SrsPackage.KB_TYPE__OWNS:
				return ((InternalEList<?>)getOwns()).basicRemove(otherEnd, msgs);
			case SrsPackage.KB_TYPE__FULLY_AUTHORIZED:
				return ((InternalEList<?>)getFullyAuthorized()).basicRemove(otherEnd, msgs);
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
			case SrsPackage.KB_TYPE__PART_OF:
				return getPartOf();
			case SrsPackage.KB_TYPE__TANGIBLE_BY:
				return getTangibleBy();
			case SrsPackage.KB_TYPE__OWNS:
				return getOwns();
			case SrsPackage.KB_TYPE__FULLY_AUTHORIZED:
				return getFullyAuthorized();
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
			case SrsPackage.KB_TYPE__PART_OF:
				getPartOf().clear();
				getPartOf().addAll((Collection<? extends PartOfType>)newValue);
				return;
			case SrsPackage.KB_TYPE__TANGIBLE_BY:
				getTangibleBy().clear();
				getTangibleBy().addAll((Collection<? extends TangibleByType>)newValue);
				return;
			case SrsPackage.KB_TYPE__OWNS:
				getOwns().clear();
				getOwns().addAll((Collection<? extends OwnsType>)newValue);
				return;
			case SrsPackage.KB_TYPE__FULLY_AUTHORIZED:
				getFullyAuthorized().clear();
				getFullyAuthorized().addAll((Collection<? extends OwnsType>)newValue);
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
			case SrsPackage.KB_TYPE__PART_OF:
				getPartOf().clear();
				return;
			case SrsPackage.KB_TYPE__TANGIBLE_BY:
				getTangibleBy().clear();
				return;
			case SrsPackage.KB_TYPE__OWNS:
				getOwns().clear();
				return;
			case SrsPackage.KB_TYPE__FULLY_AUTHORIZED:
				getFullyAuthorized().clear();
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
			case SrsPackage.KB_TYPE__PART_OF:
				return partOf != null && !partOf.isEmpty();
			case SrsPackage.KB_TYPE__TANGIBLE_BY:
				return tangibleBy != null && !tangibleBy.isEmpty();
			case SrsPackage.KB_TYPE__OWNS:
				return owns != null && !owns.isEmpty();
			case SrsPackage.KB_TYPE__FULLY_AUTHORIZED:
				return fullyAuthorized != null && !fullyAuthorized.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //KBTypeImpl
