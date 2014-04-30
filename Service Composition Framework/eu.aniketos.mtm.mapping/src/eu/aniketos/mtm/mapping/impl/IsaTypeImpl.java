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

import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.SRRType;

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
 * An implementation of the model object '<em><b>Isa Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl#getBPRole <em>BP Role</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl#getBPPart <em>BP Part</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl#getSRRole <em>SR Role</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl#getSRAgent <em>SR Agent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IsaTypeImpl extends EObjectImpl implements IsaType {
	/**
	 * The cached value of the '{@link #getBPRole() <em>BP Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPRole()
	 * @generated
	 * @ordered
	 */
	protected EList<BPRType> bPRole;

	/**
	 * The cached value of the '{@link #getBPPart() <em>BP Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPPart()
	 * @generated
	 * @ordered
	 */
	protected EList<BPPType> bPPart;

	/**
	 * The cached value of the '{@link #getSRRole() <em>SR Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRRole()
	 * @generated
	 * @ordered
	 */
	protected EList<SRRType> sRRole;

	/**
	 * The cached value of the '{@link #getSRAgent() <em>SR Agent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSRAgent()
	 * @generated
	 * @ordered
	 */
	protected EList<SRAType> sRAgent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IsaTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ISA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPRType> getBPRole() {
		if (bPRole == null) {
			bPRole = new EObjectContainmentEList<BPRType>(BPRType.class, this, MappingPackage.ISA_TYPE__BP_ROLE);
		}
		return bPRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPPType> getBPPart() {
		if (bPPart == null) {
			bPPart = new EObjectContainmentEList<BPPType>(BPPType.class, this, MappingPackage.ISA_TYPE__BP_PART);
		}
		return bPPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SRRType> getSRRole() {
		if (sRRole == null) {
			sRRole = new EObjectContainmentEList<SRRType>(SRRType.class, this, MappingPackage.ISA_TYPE__SR_ROLE);
		}
		return sRRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SRAType> getSRAgent() {
		if (sRAgent == null) {
			sRAgent = new EObjectContainmentEList<SRAType>(SRAType.class, this, MappingPackage.ISA_TYPE__SR_AGENT);
		}
		return sRAgent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.ISA_TYPE__BP_ROLE:
				return ((InternalEList<?>)getBPRole()).basicRemove(otherEnd, msgs);
			case MappingPackage.ISA_TYPE__BP_PART:
				return ((InternalEList<?>)getBPPart()).basicRemove(otherEnd, msgs);
			case MappingPackage.ISA_TYPE__SR_ROLE:
				return ((InternalEList<?>)getSRRole()).basicRemove(otherEnd, msgs);
			case MappingPackage.ISA_TYPE__SR_AGENT:
				return ((InternalEList<?>)getSRAgent()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.ISA_TYPE__BP_ROLE:
				return getBPRole();
			case MappingPackage.ISA_TYPE__BP_PART:
				return getBPPart();
			case MappingPackage.ISA_TYPE__SR_ROLE:
				return getSRRole();
			case MappingPackage.ISA_TYPE__SR_AGENT:
				return getSRAgent();
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
			case MappingPackage.ISA_TYPE__BP_ROLE:
				getBPRole().clear();
				getBPRole().addAll((Collection<? extends BPRType>)newValue);
				return;
			case MappingPackage.ISA_TYPE__BP_PART:
				getBPPart().clear();
				getBPPart().addAll((Collection<? extends BPPType>)newValue);
				return;
			case MappingPackage.ISA_TYPE__SR_ROLE:
				getSRRole().clear();
				getSRRole().addAll((Collection<? extends SRRType>)newValue);
				return;
			case MappingPackage.ISA_TYPE__SR_AGENT:
				getSRAgent().clear();
				getSRAgent().addAll((Collection<? extends SRAType>)newValue);
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
			case MappingPackage.ISA_TYPE__BP_ROLE:
				getBPRole().clear();
				return;
			case MappingPackage.ISA_TYPE__BP_PART:
				getBPPart().clear();
				return;
			case MappingPackage.ISA_TYPE__SR_ROLE:
				getSRRole().clear();
				return;
			case MappingPackage.ISA_TYPE__SR_AGENT:
				getSRAgent().clear();
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
			case MappingPackage.ISA_TYPE__BP_ROLE:
				return bPRole != null && !bPRole.isEmpty();
			case MappingPackage.ISA_TYPE__BP_PART:
				return bPPart != null && !bPPart.isEmpty();
			case MappingPackage.ISA_TYPE__SR_ROLE:
				return sRRole != null && !sRRole.isEmpty();
			case MappingPackage.ISA_TYPE__SR_AGENT:
				return sRAgent != null && !sRAgent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //IsaTypeImpl
