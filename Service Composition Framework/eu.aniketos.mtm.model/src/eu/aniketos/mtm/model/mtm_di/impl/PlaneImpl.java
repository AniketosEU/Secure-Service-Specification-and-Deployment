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
package eu.aniketos.mtm.model.mtm_di.impl;

import eu.aniketos.mtm.model.mtm_di.DiPackage;
import eu.aniketos.mtm.model.mtm_di.DiagramElement;
import eu.aniketos.mtm.model.mtm_di.Plane;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl#getDiagramElementGroup <em>Diagram Element Group</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl#getDiagramElement <em>Diagram Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PlaneImpl extends NodeImpl implements Plane {
	/**
	 * The cached value of the '{@link #getDiagramElementGroup() <em>Diagram Element Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramElementGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap diagramElementGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.PLANE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getDiagramElementGroup() {
		if (diagramElementGroup == null) {
			diagramElementGroup = new BasicFeatureMap(this, DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP);
		}
		return diagramElementGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramElement> getDiagramElement() {
		return getDiagramElementGroup().list(DiPackage.Literals.PLANE__DIAGRAM_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP:
				return ((InternalEList<?>)getDiagramElementGroup()).basicRemove(otherEnd, msgs);
			case DiPackage.PLANE__DIAGRAM_ELEMENT:
				return ((InternalEList<?>)getDiagramElement()).basicRemove(otherEnd, msgs);
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
			case DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP:
				if (coreType) return getDiagramElementGroup();
				return ((FeatureMap.Internal)getDiagramElementGroup()).getWrapper();
			case DiPackage.PLANE__DIAGRAM_ELEMENT:
				return getDiagramElement();
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
			case DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP:
				((FeatureMap.Internal)getDiagramElementGroup()).set(newValue);
				return;
			case DiPackage.PLANE__DIAGRAM_ELEMENT:
				getDiagramElement().clear();
				getDiagramElement().addAll((Collection<? extends DiagramElement>)newValue);
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
			case DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP:
				getDiagramElementGroup().clear();
				return;
			case DiPackage.PLANE__DIAGRAM_ELEMENT:
				getDiagramElement().clear();
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
			case DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP:
				return diagramElementGroup != null && !diagramElementGroup.isEmpty();
			case DiPackage.PLANE__DIAGRAM_ELEMENT:
				return !getDiagramElement().isEmpty();
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
		result.append(" (diagramElementGroup: ");
		result.append(diagramElementGroup);
		result.append(')');
		return result.toString();
	}

} //PlaneImpl
