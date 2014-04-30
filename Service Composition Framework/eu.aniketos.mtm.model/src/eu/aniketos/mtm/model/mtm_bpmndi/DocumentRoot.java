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
package eu.aniketos.mtm.model.mtm_bpmndi;

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
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNDiagram <em>BPMN Diagram</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNEdge <em>BPMN Edge</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabel <em>BPMN Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabelStyle <em>BPMN Label Style</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNPlane <em>BPMN Plane</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNShape <em>BPMN Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot()
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
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_Mixed()
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
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_XMLNSPrefixMap()
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
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>BPMN Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Diagram</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Diagram</em>' containment reference.
	 * @see #setBPMNDiagram(BPMNDiagram)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNDiagram()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNDiagram' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNDiagram getBPMNDiagram();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNDiagram <em>BPMN Diagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Diagram</em>' containment reference.
	 * @see #getBPMNDiagram()
	 * @generated
	 */
	void setBPMNDiagram(BPMNDiagram value);

	/**
	 * Returns the value of the '<em><b>BPMN Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Edge</em>' containment reference.
	 * @see #setBPMNEdge(BPMNEdge)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNEdge()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNEdge' namespace='##targetNamespace' affiliation='http://www.omg.org/spec/DD/20100524/DI#DiagramElement'"
	 * @generated
	 */
	BPMNEdge getBPMNEdge();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNEdge <em>BPMN Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Edge</em>' containment reference.
	 * @see #getBPMNEdge()
	 * @generated
	 */
	void setBPMNEdge(BPMNEdge value);

	/**
	 * Returns the value of the '<em><b>BPMN Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Label</em>' containment reference.
	 * @see #setBPMNLabel(BPMNLabel)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNLabel()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNLabel' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNLabel getBPMNLabel();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabel <em>BPMN Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Label</em>' containment reference.
	 * @see #getBPMNLabel()
	 * @generated
	 */
	void setBPMNLabel(BPMNLabel value);

	/**
	 * Returns the value of the '<em><b>BPMN Label Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Label Style</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Label Style</em>' containment reference.
	 * @see #setBPMNLabelStyle(BPMNLabelStyle)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNLabelStyle()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNLabelStyle' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNLabelStyle getBPMNLabelStyle();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabelStyle <em>BPMN Label Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Label Style</em>' containment reference.
	 * @see #getBPMNLabelStyle()
	 * @generated
	 */
	void setBPMNLabelStyle(BPMNLabelStyle value);

	/**
	 * Returns the value of the '<em><b>BPMN Plane</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Plane</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Plane</em>' containment reference.
	 * @see #setBPMNPlane(BPMNPlane)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNPlane()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNPlane' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNPlane getBPMNPlane();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNPlane <em>BPMN Plane</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Plane</em>' containment reference.
	 * @see #getBPMNPlane()
	 * @generated
	 */
	void setBPMNPlane(BPMNPlane value);

	/**
	 * Returns the value of the '<em><b>BPMN Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Shape</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Shape</em>' containment reference.
	 * @see #setBPMNShape(BPMNShape)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getDocumentRoot_BPMNShape()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BPMNShape' namespace='##targetNamespace' affiliation='http://www.omg.org/spec/DD/20100524/DI#DiagramElement'"
	 * @generated
	 */
	BPMNShape getBPMNShape();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNShape <em>BPMN Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Shape</em>' containment reference.
	 * @see #getBPMNShape()
	 * @generated
	 */
	void setBPMNShape(BPMNShape value);

} // DocumentRoot
