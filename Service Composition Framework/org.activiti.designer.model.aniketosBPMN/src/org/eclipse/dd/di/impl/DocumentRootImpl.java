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
package org.eclipse.dd.di.impl;

import java.util.Map;

import org.eclipse.dd.di.BPMNDiagram;
import org.eclipse.dd.di.BPMNEdge;
import org.eclipse.dd.di.BPMNLabel;
import org.eclipse.dd.di.BPMNLabelStyle;
import org.eclipse.dd.di.BPMNPlane;
import org.eclipse.dd.di.BPMNShape;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.dd.di.DocumentRoot;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNDiagram <em>BPMN Diagram</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNEdge <em>BPMN Edge</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNLabel <em>BPMN Label</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNLabelStyle <em>BPMN Label Style</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNPlane <em>BPMN Plane</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.DocumentRootImpl#getBPMNShape <em>BPMN Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
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
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, DiPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNDiagram getBPMNDiagram() {
		return (BPMNDiagram)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_DIAGRAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNDiagram(BPMNDiagram newBPMNDiagram, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_DIAGRAM, newBPMNDiagram, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNDiagram(BPMNDiagram newBPMNDiagram) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_DIAGRAM, newBPMNDiagram);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNEdge getBPMNEdge() {
		return (BPMNEdge)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_EDGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNEdge(BPMNEdge newBPMNEdge, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_EDGE, newBPMNEdge, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNEdge(BPMNEdge newBPMNEdge) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_EDGE, newBPMNEdge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabel getBPMNLabel() {
		return (BPMNLabel)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNLabel(BPMNLabel newBPMNLabel, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL, newBPMNLabel, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNLabel(BPMNLabel newBPMNLabel) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL, newBPMNLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabelStyle getBPMNLabelStyle() {
		return (BPMNLabelStyle)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL_STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNLabelStyle(BPMNLabelStyle newBPMNLabelStyle, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL_STYLE, newBPMNLabelStyle, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNLabelStyle(BPMNLabelStyle newBPMNLabelStyle) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_LABEL_STYLE, newBPMNLabelStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNPlane getBPMNPlane() {
		return (BPMNPlane)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_PLANE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNPlane(BPMNPlane newBPMNPlane, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_PLANE, newBPMNPlane, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNPlane(BPMNPlane newBPMNPlane) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_PLANE, newBPMNPlane);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNShape getBPMNShape() {
		return (BPMNShape)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__BPMN_SHAPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNShape(BPMNShape newBPMNShape, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__BPMN_SHAPE, newBPMNShape, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNShape(BPMNShape newBPMNShape) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__BPMN_SHAPE, newBPMNShape);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)((EMap.InternalMapView<String, String>)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)((EMap.InternalMapView<String, String>)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_DIAGRAM:
				return basicSetBPMNDiagram(null, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_EDGE:
				return basicSetBPMNEdge(null, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL:
				return basicSetBPMNLabel(null, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL_STYLE:
				return basicSetBPMNLabelStyle(null, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_PLANE:
				return basicSetBPMNPlane(null, msgs);
			case DiPackage.DOCUMENT_ROOT__BPMN_SHAPE:
				return basicSetBPMNShape(null, msgs);
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
			case DiPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView<String, String>)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView<String, String>)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case DiPackage.DOCUMENT_ROOT__BPMN_DIAGRAM:
				return getBPMNDiagram();
			case DiPackage.DOCUMENT_ROOT__BPMN_EDGE:
				return getBPMNEdge();
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL:
				return getBPMNLabel();
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL_STYLE:
				return getBPMNLabelStyle();
			case DiPackage.DOCUMENT_ROOT__BPMN_PLANE:
				return getBPMNPlane();
			case DiPackage.DOCUMENT_ROOT__BPMN_SHAPE:
				return getBPMNShape();
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
			case DiPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, String>)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView<String, String>)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_DIAGRAM:
				setBPMNDiagram((BPMNDiagram)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_EDGE:
				setBPMNEdge((BPMNEdge)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL:
				setBPMNLabel((BPMNLabel)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL_STYLE:
				setBPMNLabelStyle((BPMNLabelStyle)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_PLANE:
				setBPMNPlane((BPMNPlane)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_SHAPE:
				setBPMNShape((BPMNShape)newValue);
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
			case DiPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_DIAGRAM:
				setBPMNDiagram((BPMNDiagram)null);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_EDGE:
				setBPMNEdge((BPMNEdge)null);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL:
				setBPMNLabel((BPMNLabel)null);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL_STYLE:
				setBPMNLabelStyle((BPMNLabelStyle)null);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_PLANE:
				setBPMNPlane((BPMNPlane)null);
				return;
			case DiPackage.DOCUMENT_ROOT__BPMN_SHAPE:
				setBPMNShape((BPMNShape)null);
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
			case DiPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case DiPackage.DOCUMENT_ROOT__BPMN_DIAGRAM:
				return getBPMNDiagram() != null;
			case DiPackage.DOCUMENT_ROOT__BPMN_EDGE:
				return getBPMNEdge() != null;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL:
				return getBPMNLabel() != null;
			case DiPackage.DOCUMENT_ROOT__BPMN_LABEL_STYLE:
				return getBPMNLabelStyle() != null;
			case DiPackage.DOCUMENT_ROOT__BPMN_PLANE:
				return getBPMNPlane() != null;
			case DiPackage.DOCUMENT_ROOT__BPMN_SHAPE:
				return getBPMNShape() != null;
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
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
