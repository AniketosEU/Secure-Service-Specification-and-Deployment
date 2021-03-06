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
package eu.aniketos.mtm.model.mtm_di;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagramElement <em>Diagram Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getEdge <em>Edge</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabel <em>Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledEdge <em>Labeled Edge</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledShape <em>Labeled Shape</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getNode <em>Node</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getPlane <em>Plane</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getShape <em>Shape</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Diagram Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Element</em>' containment reference.
	 * @see #setDiagramElement(DiagramElement)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_DiagramElement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='DiagramElement' namespace='##targetNamespace'"
	 * @generated
	 */
	DiagramElement getDiagramElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagramElement <em>Diagram Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Element</em>' containment reference.
	 * @see #getDiagramElement()
	 * @generated
	 */
	void setDiagramElement(DiagramElement value);

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' containment reference.
	 * @see #setDiagram(Diagram)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Diagram()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Diagram' namespace='##targetNamespace'"
	 * @generated
	 */
	Diagram getDiagram();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagram <em>Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' containment reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(Diagram value);

	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference.
	 * @see #setEdge(Edge)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Edge()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Edge' namespace='##targetNamespace'"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getEdge <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' containment reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' containment reference.
	 * @see #setLabel(Label)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Label()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Label' namespace='##targetNamespace'"
	 * @generated
	 */
	Label getLabel();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabel <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' containment reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(Label value);

	/**
	 * Returns the value of the '<em><b>Labeled Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labeled Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labeled Edge</em>' containment reference.
	 * @see #setLabeledEdge(LabeledEdge)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_LabeledEdge()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='LabeledEdge' namespace='##targetNamespace'"
	 * @generated
	 */
	LabeledEdge getLabeledEdge();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledEdge <em>Labeled Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Labeled Edge</em>' containment reference.
	 * @see #getLabeledEdge()
	 * @generated
	 */
	void setLabeledEdge(LabeledEdge value);

	/**
	 * Returns the value of the '<em><b>Labeled Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labeled Shape</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labeled Shape</em>' containment reference.
	 * @see #setLabeledShape(LabeledShape)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_LabeledShape()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='LabeledShape' namespace='##targetNamespace'"
	 * @generated
	 */
	LabeledShape getLabeledShape();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledShape <em>Labeled Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Labeled Shape</em>' containment reference.
	 * @see #getLabeledShape()
	 * @generated
	 */
	void setLabeledShape(LabeledShape value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(Node)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Node()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Node' namespace='##targetNamespace'"
	 * @generated
	 */
	Node getNode();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Returns the value of the '<em><b>Plane</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plane</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plane</em>' containment reference.
	 * @see #setPlane(Plane)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Plane()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Plane' namespace='##targetNamespace'"
	 * @generated
	 */
	Plane getPlane();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getPlane <em>Plane</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plane</em>' containment reference.
	 * @see #getPlane()
	 * @generated
	 */
	void setPlane(Plane value);

	/**
	 * Returns the value of the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' containment reference.
	 * @see #setShape(Shape)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Shape()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Shape' namespace='##targetNamespace'"
	 * @generated
	 */
	Shape getShape();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getShape <em>Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' containment reference.
	 * @see #getShape()
	 * @generated
	 */
	void setShape(Shape value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference.
	 * @see #setStyle(Style)
	 * @see eu.aniketos.mtm.model.mtm_di.DiPackage#getDocumentRoot_Style()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Style' namespace='##targetNamespace'"
	 * @generated
	 */
	Style getStyle();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getStyle <em>Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' containment reference.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Style value);

} // DocumentRoot
