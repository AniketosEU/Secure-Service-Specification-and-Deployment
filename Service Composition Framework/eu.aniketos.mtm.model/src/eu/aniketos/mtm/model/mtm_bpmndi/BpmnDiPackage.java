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

import eu.aniketos.mtm.model.mtm_di.DiPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiFactory
 * @model kind="package"
 *        annotation="emf.gen basePackage='eu.aniketos.wp5.mtm'"
 * @generated
 */
public interface BpmnDiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mtm_bpmndi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/BPMN/20100524/DI";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mtm_bpmndi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BpmnDiPackage eINSTANCE = eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl <em>BPMN Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNDiagram()
	 * @generated
	 */
	int BPMN_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__DOCUMENTATION = DiPackage.DIAGRAM__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__ID = DiPackage.DIAGRAM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__NAME = DiPackage.DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__RESOLUTION = DiPackage.DIAGRAM__RESOLUTION;

	/**
	 * The feature id for the '<em><b>BPMN Plane</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__BPMN_PLANE = DiPackage.DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>BPMN Label Style</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM__BPMN_LABEL_STYLE = DiPackage.DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BPMN Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DIAGRAM_FEATURE_COUNT = DiPackage.DIAGRAM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl <em>BPMN Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNEdge()
	 * @generated
	 */
	int BPMN_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__EXTENSION = DiPackage.LABELED_EDGE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__ID = DiPackage.LABELED_EDGE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__ANY_ATTRIBUTE = DiPackage.LABELED_EDGE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Waypoint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__WAYPOINT = DiPackage.LABELED_EDGE__WAYPOINT;

	/**
	 * The feature id for the '<em><b>BPMN Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__BPMN_LABEL = DiPackage.LABELED_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bpmn Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__BPMN_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message Visible Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__MESSAGE_VISIBLE_KIND = DiPackage.LABELED_EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__SOURCE_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE__TARGET_ELEMENT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>BPMN Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EDGE_FEATURE_COUNT = DiPackage.LABELED_EDGE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelImpl <em>BPMN Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNLabel()
	 * @generated
	 */
	int BPMN_LABEL = 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL__EXTENSION = DiPackage.LABEL__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL__ID = DiPackage.LABEL__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL__ANY_ATTRIBUTE = DiPackage.LABEL__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL__BOUNDS = DiPackage.LABEL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Label Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL__LABEL_STYLE = DiPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPMN Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL_FEATURE_COUNT = DiPackage.LABEL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelStyleImpl <em>BPMN Label Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelStyleImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNLabelStyle()
	 * @generated
	 */
	int BPMN_LABEL_STYLE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL_STYLE__ID = DiPackage.STYLE__ID;

	/**
	 * The feature id for the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL_STYLE__FONT = DiPackage.STYLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPMN Label Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LABEL_STYLE_FEATURE_COUNT = DiPackage.STYLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNPlaneImpl <em>BPMN Plane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNPlaneImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNPlane()
	 * @generated
	 */
	int BPMN_PLANE = 4;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__EXTENSION = DiPackage.PLANE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__ID = DiPackage.PLANE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__ANY_ATTRIBUTE = DiPackage.PLANE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Diagram Element Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__DIAGRAM_ELEMENT_GROUP = DiPackage.PLANE__DIAGRAM_ELEMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Diagram Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__DIAGRAM_ELEMENT = DiPackage.PLANE__DIAGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Bpmn Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE__BPMN_ELEMENT = DiPackage.PLANE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPMN Plane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_PLANE_FEATURE_COUNT = DiPackage.PLANE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNShapeImpl <em>BPMN Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNShapeImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNShape()
	 * @generated
	 */
	int BPMN_SHAPE = 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__EXTENSION = DiPackage.LABELED_SHAPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__ID = DiPackage.LABELED_SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__ANY_ATTRIBUTE = DiPackage.LABELED_SHAPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__BOUNDS = DiPackage.LABELED_SHAPE__BOUNDS;

	/**
	 * The feature id for the '<em><b>BPMN Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__BPMN_LABEL = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bpmn Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__BPMN_ELEMENT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Choreography Activity Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__IS_EXPANDED = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Horizontal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__IS_HORIZONTAL = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Marker Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__IS_MARKER_VISIBLE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Message Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__IS_MESSAGE_VISIBLE = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Participant Band Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE__PARTICIPANT_BAND_KIND = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>BPMN Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SHAPE_FEATURE_COUNT = DiPackage.LABELED_SHAPE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.DocumentRootImpl
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>BPMN Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_DIAGRAM = 3;

	/**
	 * The feature id for the '<em><b>BPMN Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_EDGE = 4;

	/**
	 * The feature id for the '<em><b>BPMN Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_LABEL = 5;

	/**
	 * The feature id for the '<em><b>BPMN Label Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_LABEL_STYLE = 6;

	/**
	 * The feature id for the '<em><b>BPMN Plane</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_PLANE = 7;

	/**
	 * The feature id for the '<em><b>BPMN Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BPMN_SHAPE = 8;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind <em>Message Visible Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getMessageVisibleKind()
	 * @generated
	 */
	int MESSAGE_VISIBLE_KIND = 7;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind <em>Participant Band Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getParticipantBandKind()
	 * @generated
	 */
	int PARTICIPANT_BAND_KIND = 8;

	/**
	 * The meta object id for the '<em>Message Visible Kind Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getMessageVisibleKindObject()
	 * @generated
	 */
	int MESSAGE_VISIBLE_KIND_OBJECT = 9;

	/**
	 * The meta object id for the '<em>Participant Band Kind Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getParticipantBandKindObject()
	 * @generated
	 */
	int PARTICIPANT_BAND_KIND_OBJECT = 10;


	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram <em>BPMN Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Diagram</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram
	 * @generated
	 */
	EClass getBPMNDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram#getBPMNPlane <em>BPMN Plane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Plane</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram#getBPMNPlane()
	 * @see #getBPMNDiagram()
	 * @generated
	 */
	EReference getBPMNDiagram_BPMNPlane();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram#getBPMNLabelStyle <em>BPMN Label Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BPMN Label Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram#getBPMNLabelStyle()
	 * @see #getBPMNDiagram()
	 * @generated
	 */
	EReference getBPMNDiagram_BPMNLabelStyle();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge <em>BPMN Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge
	 * @generated
	 */
	EClass getBPMNEdge();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBPMNLabel <em>BPMN Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBPMNLabel()
	 * @see #getBPMNEdge()
	 * @generated
	 */
	EReference getBPMNEdge_BPMNLabel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBpmnElement <em>Bpmn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bpmn Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBpmnElement()
	 * @see #getBPMNEdge()
	 * @generated
	 */
	EAttribute getBPMNEdge_BpmnElement();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Visible Kind</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind()
	 * @see #getBPMNEdge()
	 * @generated
	 */
	EAttribute getBPMNEdge_MessageVisibleKind();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getSourceElement()
	 * @see #getBPMNEdge()
	 * @generated
	 */
	EAttribute getBPMNEdge_SourceElement();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getTargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getTargetElement()
	 * @see #getBPMNEdge()
	 * @generated
	 */
	EAttribute getBPMNEdge_TargetElement();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabel <em>BPMN Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabel
	 * @generated
	 */
	EClass getBPMNLabel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabel#getLabelStyle <em>Label Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabel#getLabelStyle()
	 * @see #getBPMNLabel()
	 * @generated
	 */
	EAttribute getBPMNLabel_LabelStyle();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle <em>BPMN Label Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Label Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle
	 * @generated
	 */
	EClass getBPMNLabelStyle();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle#getFont()
	 * @see #getBPMNLabelStyle()
	 * @generated
	 */
	EReference getBPMNLabelStyle_Font();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNPlane <em>BPMN Plane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Plane</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNPlane
	 * @generated
	 */
	EClass getBPMNPlane();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNPlane#getBpmnElement <em>Bpmn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bpmn Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNPlane#getBpmnElement()
	 * @see #getBPMNPlane()
	 * @generated
	 */
	EAttribute getBPMNPlane_BpmnElement();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape <em>BPMN Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPMN Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape
	 * @generated
	 */
	EClass getBPMNShape();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBPMNLabel <em>BPMN Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBPMNLabel()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EReference getBPMNShape_BPMNLabel();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBpmnElement <em>Bpmn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bpmn Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBpmnElement()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_BpmnElement();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Choreography Activity Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getChoreographyActivityShape()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_ChoreographyActivityShape();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded <em>Is Expanded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Expanded</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_IsExpanded();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal <em>Is Horizontal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Horizontal</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_IsHorizontal();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Marker Visible</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_IsMarkerVisible();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible <em>Is Message Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Message Visible</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_IsMessageVisible();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind <em>Participant Band Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Participant Band Kind</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind()
	 * @see #getBPMNShape()
	 * @generated
	 */
	EAttribute getBPMNShape_ParticipantBandKind();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNDiagram <em>BPMN Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Diagram</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNDiagram()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNEdge <em>BPMN Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNEdge()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNEdge();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabel <em>BPMN Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNLabel();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabelStyle <em>BPMN Label Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Label Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNLabelStyle()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNLabelStyle();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNPlane <em>BPMN Plane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Plane</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNPlane()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNPlane();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNShape <em>BPMN Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BPMN Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.DocumentRoot#getBPMNShape()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_BPMNShape();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind <em>Message Visible Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Message Visible Kind</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @generated
	 */
	EEnum getMessageVisibleKind();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind <em>Participant Band Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Participant Band Kind</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @generated
	 */
	EEnum getParticipantBandKind();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind <em>Message Visible Kind Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Message Visible Kind Object</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @model instanceClass="eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind"
	 *        extendedMetaData="name='MessageVisibleKind:Object' baseType='MessageVisibleKind'"
	 * @generated
	 */
	EDataType getMessageVisibleKindObject();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind <em>Participant Band Kind Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Participant Band Kind Object</em>'.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @model instanceClass="eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind"
	 *        extendedMetaData="name='ParticipantBandKind:Object' baseType='ParticipantBandKind'"
	 * @generated
	 */
	EDataType getParticipantBandKindObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BpmnDiFactory getBpmnDiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl <em>BPMN Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNDiagram()
		 * @generated
		 */
		EClass BPMN_DIAGRAM = eINSTANCE.getBPMNDiagram();

		/**
		 * The meta object literal for the '<em><b>BPMN Plane</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_DIAGRAM__BPMN_PLANE = eINSTANCE.getBPMNDiagram_BPMNPlane();

		/**
		 * The meta object literal for the '<em><b>BPMN Label Style</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_DIAGRAM__BPMN_LABEL_STYLE = eINSTANCE.getBPMNDiagram_BPMNLabelStyle();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl <em>BPMN Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNEdge()
		 * @generated
		 */
		EClass BPMN_EDGE = eINSTANCE.getBPMNEdge();

		/**
		 * The meta object literal for the '<em><b>BPMN Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EDGE__BPMN_LABEL = eINSTANCE.getBPMNEdge_BPMNLabel();

		/**
		 * The meta object literal for the '<em><b>Bpmn Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_EDGE__BPMN_ELEMENT = eINSTANCE.getBPMNEdge_BpmnElement();

		/**
		 * The meta object literal for the '<em><b>Message Visible Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_EDGE__MESSAGE_VISIBLE_KIND = eINSTANCE.getBPMNEdge_MessageVisibleKind();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_EDGE__SOURCE_ELEMENT = eINSTANCE.getBPMNEdge_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_EDGE__TARGET_ELEMENT = eINSTANCE.getBPMNEdge_TargetElement();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelImpl <em>BPMN Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNLabel()
		 * @generated
		 */
		EClass BPMN_LABEL = eINSTANCE.getBPMNLabel();

		/**
		 * The meta object literal for the '<em><b>Label Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_LABEL__LABEL_STYLE = eINSTANCE.getBPMNLabel_LabelStyle();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelStyleImpl <em>BPMN Label Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNLabelStyleImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNLabelStyle()
		 * @generated
		 */
		EClass BPMN_LABEL_STYLE = eINSTANCE.getBPMNLabelStyle();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LABEL_STYLE__FONT = eINSTANCE.getBPMNLabelStyle_Font();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNPlaneImpl <em>BPMN Plane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNPlaneImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNPlane()
		 * @generated
		 */
		EClass BPMN_PLANE = eINSTANCE.getBPMNPlane();

		/**
		 * The meta object literal for the '<em><b>Bpmn Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_PLANE__BPMN_ELEMENT = eINSTANCE.getBPMNPlane_BpmnElement();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNShapeImpl <em>BPMN Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNShapeImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getBPMNShape()
		 * @generated
		 */
		EClass BPMN_SHAPE = eINSTANCE.getBPMNShape();

		/**
		 * The meta object literal for the '<em><b>BPMN Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_SHAPE__BPMN_LABEL = eINSTANCE.getBPMNShape_BPMNLabel();

		/**
		 * The meta object literal for the '<em><b>Bpmn Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__BPMN_ELEMENT = eINSTANCE.getBPMNShape_BpmnElement();

		/**
		 * The meta object literal for the '<em><b>Choreography Activity Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE = eINSTANCE.getBPMNShape_ChoreographyActivityShape();

		/**
		 * The meta object literal for the '<em><b>Is Expanded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__IS_EXPANDED = eINSTANCE.getBPMNShape_IsExpanded();

		/**
		 * The meta object literal for the '<em><b>Is Horizontal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__IS_HORIZONTAL = eINSTANCE.getBPMNShape_IsHorizontal();

		/**
		 * The meta object literal for the '<em><b>Is Marker Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__IS_MARKER_VISIBLE = eINSTANCE.getBPMNShape_IsMarkerVisible();

		/**
		 * The meta object literal for the '<em><b>Is Message Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__IS_MESSAGE_VISIBLE = eINSTANCE.getBPMNShape_IsMessageVisible();

		/**
		 * The meta object literal for the '<em><b>Participant Band Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SHAPE__PARTICIPANT_BAND_KIND = eINSTANCE.getBPMNShape_ParticipantBandKind();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.DocumentRootImpl
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>BPMN Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_DIAGRAM = eINSTANCE.getDocumentRoot_BPMNDiagram();

		/**
		 * The meta object literal for the '<em><b>BPMN Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_EDGE = eINSTANCE.getDocumentRoot_BPMNEdge();

		/**
		 * The meta object literal for the '<em><b>BPMN Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_LABEL = eINSTANCE.getDocumentRoot_BPMNLabel();

		/**
		 * The meta object literal for the '<em><b>BPMN Label Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_LABEL_STYLE = eINSTANCE.getDocumentRoot_BPMNLabelStyle();

		/**
		 * The meta object literal for the '<em><b>BPMN Plane</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_PLANE = eINSTANCE.getDocumentRoot_BPMNPlane();

		/**
		 * The meta object literal for the '<em><b>BPMN Shape</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__BPMN_SHAPE = eINSTANCE.getDocumentRoot_BPMNShape();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind <em>Message Visible Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getMessageVisibleKind()
		 * @generated
		 */
		EEnum MESSAGE_VISIBLE_KIND = eINSTANCE.getMessageVisibleKind();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind <em>Participant Band Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getParticipantBandKind()
		 * @generated
		 */
		EEnum PARTICIPANT_BAND_KIND = eINSTANCE.getParticipantBandKind();

		/**
		 * The meta object literal for the '<em>Message Visible Kind Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getMessageVisibleKindObject()
		 * @generated
		 */
		EDataType MESSAGE_VISIBLE_KIND_OBJECT = eINSTANCE.getMessageVisibleKindObject();

		/**
		 * The meta object literal for the '<em>Participant Band Kind Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
		 * @see eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl#getParticipantBandKindObject()
		 * @generated
		 */
		EDataType PARTICIPANT_BAND_KIND_OBJECT = eINSTANCE.getParticipantBandKindObject();

	}

} //BpmnDiPackage
