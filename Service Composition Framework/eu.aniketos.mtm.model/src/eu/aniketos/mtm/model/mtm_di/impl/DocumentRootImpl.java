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
import eu.aniketos.mtm.model.mtm_di.Diagram;
import eu.aniketos.mtm.model.mtm_di.DiagramElement;
import eu.aniketos.mtm.model.mtm_di.DocumentRoot;
import eu.aniketos.mtm.model.mtm_di.Edge;
import eu.aniketos.mtm.model.mtm_di.Label;
import eu.aniketos.mtm.model.mtm_di.LabeledEdge;
import eu.aniketos.mtm.model.mtm_di.LabeledShape;
import eu.aniketos.mtm.model.mtm_di.Node;
import eu.aniketos.mtm.model.mtm_di.Plane;
import eu.aniketos.mtm.model.mtm_di.Shape;
import eu.aniketos.mtm.model.mtm_di.Style;

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
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getDiagramElement <em>Diagram Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getEdge <em>Edge</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getLabeledEdge <em>Labeled Edge</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getLabeledShape <em>Labeled Shape</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getNode <em>Node</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getPlane <em>Plane</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl#getStyle <em>Style</em>}</li>
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
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DiPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramElement getDiagramElement() {
		return (DiagramElement)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagramElement(DiagramElement newDiagramElement, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM_ELEMENT, newDiagramElement, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramElement(DiagramElement newDiagramElement) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM_ELEMENT, newDiagramElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getDiagram() {
		return (Diagram)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagram(Diagram newDiagram, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM, newDiagram, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__DIAGRAM, newDiagram);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge() {
		return (Edge)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__EDGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdge(Edge newEdge, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__EDGE, newEdge, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(Edge newEdge) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__EDGE, newEdge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabel() {
		return (Label)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(Label newLabel, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__LABEL, newLabel, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(Label newLabel) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__LABEL, newLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledEdge getLabeledEdge() {
		return (LabeledEdge)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__LABELED_EDGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabeledEdge(LabeledEdge newLabeledEdge, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__LABELED_EDGE, newLabeledEdge, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabeledEdge(LabeledEdge newLabeledEdge) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__LABELED_EDGE, newLabeledEdge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabeledShape getLabeledShape() {
		return (LabeledShape)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__LABELED_SHAPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabeledShape(LabeledShape newLabeledShape, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__LABELED_SHAPE, newLabeledShape, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabeledShape(LabeledShape newLabeledShape) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__LABELED_SHAPE, newLabeledShape);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		return (Node)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(Node newNode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__NODE, newNode, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__NODE, newNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plane getPlane() {
		return (Plane)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__PLANE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlane(Plane newPlane, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__PLANE, newPlane, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlane(Plane newPlane) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__PLANE, newPlane);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shape getShape() {
		return (Shape)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__SHAPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShape(Shape newShape, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__SHAPE, newShape, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShape(Shape newShape) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__SHAPE, newShape);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style getStyle() {
		return (Style)getMixed().get(DiPackage.Literals.DOCUMENT_ROOT__STYLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStyle(Style newStyle, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(DiPackage.Literals.DOCUMENT_ROOT__STYLE, newStyle, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(Style newStyle) {
		((FeatureMap.Internal)getMixed()).set(DiPackage.Literals.DOCUMENT_ROOT__STYLE, newStyle);
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
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case DiPackage.DOCUMENT_ROOT__DIAGRAM_ELEMENT:
				return basicSetDiagramElement(null, msgs);
			case DiPackage.DOCUMENT_ROOT__DIAGRAM:
				return basicSetDiagram(null, msgs);
			case DiPackage.DOCUMENT_ROOT__EDGE:
				return basicSetEdge(null, msgs);
			case DiPackage.DOCUMENT_ROOT__LABEL:
				return basicSetLabel(null, msgs);
			case DiPackage.DOCUMENT_ROOT__LABELED_EDGE:
				return basicSetLabeledEdge(null, msgs);
			case DiPackage.DOCUMENT_ROOT__LABELED_SHAPE:
				return basicSetLabeledShape(null, msgs);
			case DiPackage.DOCUMENT_ROOT__NODE:
				return basicSetNode(null, msgs);
			case DiPackage.DOCUMENT_ROOT__PLANE:
				return basicSetPlane(null, msgs);
			case DiPackage.DOCUMENT_ROOT__SHAPE:
				return basicSetShape(null, msgs);
			case DiPackage.DOCUMENT_ROOT__STYLE:
				return basicSetStyle(null, msgs);
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
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case DiPackage.DOCUMENT_ROOT__DIAGRAM_ELEMENT:
				return getDiagramElement();
			case DiPackage.DOCUMENT_ROOT__DIAGRAM:
				return getDiagram();
			case DiPackage.DOCUMENT_ROOT__EDGE:
				return getEdge();
			case DiPackage.DOCUMENT_ROOT__LABEL:
				return getLabel();
			case DiPackage.DOCUMENT_ROOT__LABELED_EDGE:
				return getLabeledEdge();
			case DiPackage.DOCUMENT_ROOT__LABELED_SHAPE:
				return getLabeledShape();
			case DiPackage.DOCUMENT_ROOT__NODE:
				return getNode();
			case DiPackage.DOCUMENT_ROOT__PLANE:
				return getPlane();
			case DiPackage.DOCUMENT_ROOT__SHAPE:
				return getShape();
			case DiPackage.DOCUMENT_ROOT__STYLE:
				return getStyle();
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
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__DIAGRAM_ELEMENT:
				setDiagramElement((DiagramElement)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__DIAGRAM:
				setDiagram((Diagram)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__EDGE:
				setEdge((Edge)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__LABEL:
				setLabel((Label)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__LABELED_EDGE:
				setLabeledEdge((LabeledEdge)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__LABELED_SHAPE:
				setLabeledShape((LabeledShape)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__NODE:
				setNode((Node)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__PLANE:
				setPlane((Plane)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__SHAPE:
				setShape((Shape)newValue);
				return;
			case DiPackage.DOCUMENT_ROOT__STYLE:
				setStyle((Style)newValue);
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
			case DiPackage.DOCUMENT_ROOT__DIAGRAM_ELEMENT:
				setDiagramElement((DiagramElement)null);
				return;
			case DiPackage.DOCUMENT_ROOT__DIAGRAM:
				setDiagram((Diagram)null);
				return;
			case DiPackage.DOCUMENT_ROOT__EDGE:
				setEdge((Edge)null);
				return;
			case DiPackage.DOCUMENT_ROOT__LABEL:
				setLabel((Label)null);
				return;
			case DiPackage.DOCUMENT_ROOT__LABELED_EDGE:
				setLabeledEdge((LabeledEdge)null);
				return;
			case DiPackage.DOCUMENT_ROOT__LABELED_SHAPE:
				setLabeledShape((LabeledShape)null);
				return;
			case DiPackage.DOCUMENT_ROOT__NODE:
				setNode((Node)null);
				return;
			case DiPackage.DOCUMENT_ROOT__PLANE:
				setPlane((Plane)null);
				return;
			case DiPackage.DOCUMENT_ROOT__SHAPE:
				setShape((Shape)null);
				return;
			case DiPackage.DOCUMENT_ROOT__STYLE:
				setStyle((Style)null);
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
			case DiPackage.DOCUMENT_ROOT__DIAGRAM_ELEMENT:
				return getDiagramElement() != null;
			case DiPackage.DOCUMENT_ROOT__DIAGRAM:
				return getDiagram() != null;
			case DiPackage.DOCUMENT_ROOT__EDGE:
				return getEdge() != null;
			case DiPackage.DOCUMENT_ROOT__LABEL:
				return getLabel() != null;
			case DiPackage.DOCUMENT_ROOT__LABELED_EDGE:
				return getLabeledEdge() != null;
			case DiPackage.DOCUMENT_ROOT__LABELED_SHAPE:
				return getLabeledShape() != null;
			case DiPackage.DOCUMENT_ROOT__NODE:
				return getNode() != null;
			case DiPackage.DOCUMENT_ROOT__PLANE:
				return getPlane() != null;
			case DiPackage.DOCUMENT_ROOT__SHAPE:
				return getShape() != null;
			case DiPackage.DOCUMENT_ROOT__STYLE:
				return getStyle() != null;
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
