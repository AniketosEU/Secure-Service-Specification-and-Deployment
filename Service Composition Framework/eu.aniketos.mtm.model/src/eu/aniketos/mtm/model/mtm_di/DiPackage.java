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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see eu.aniketos.mtm.model.mtm_di.DiFactory
 * @model kind="package"
 *        annotation="emf.gen basePackage='eu.aniketos.wp5.mtm'"
 * @generated
 */
public interface DiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mtm_di";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/DD/20100524/DI";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mtm_di";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiPackage eINSTANCE = eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiagramImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__DOCUMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__NAME = 2;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__RESOLUTION = 3;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiagramElementImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDiagramElement()
	 * @generated
	 */
	int DIAGRAM_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__ID = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.EdgeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__EXTENSION = DIAGRAM_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = DIAGRAM_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ANY_ATTRIBUTE = DIAGRAM_ELEMENT__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Waypoint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__WAYPOINT = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.ExtensionTypeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getExtensionType()
	 * @generated
	 */
	int EXTENSION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE__ANY = 0;

	/**
	 * The number of structural features of the '<em>Extension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.NodeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 7;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EXTENSION = DIAGRAM_ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = DIAGRAM_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ANY_ATTRIBUTE = DIAGRAM_ELEMENT__ANY_ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.LabelImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 4;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__EXTENSION = NODE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ANY_ATTRIBUTE = NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__BOUNDS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabeledEdgeImpl <em>Labeled Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.LabeledEdgeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabeledEdge()
	 * @generated
	 */
	int LABELED_EDGE = 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_EDGE__EXTENSION = EDGE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_EDGE__ID = EDGE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_EDGE__ANY_ATTRIBUTE = EDGE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Waypoint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_EDGE__WAYPOINT = EDGE__WAYPOINT;

	/**
	 * The number of structural features of the '<em>Labeled Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.ShapeImpl <em>Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.ShapeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getShape()
	 * @generated
	 */
	int SHAPE = 9;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__EXTENSION = NODE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__ANY_ATTRIBUTE = NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE__BOUNDS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHAPE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabeledShapeImpl <em>Labeled Shape</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.LabeledShapeImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabeledShape()
	 * @generated
	 */
	int LABELED_SHAPE = 6;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_SHAPE__EXTENSION = SHAPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_SHAPE__ID = SHAPE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_SHAPE__ANY_ATTRIBUTE = SHAPE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_SHAPE__BOUNDS = SHAPE__BOUNDS;

	/**
	 * The number of structural features of the '<em>Labeled Shape</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABELED_SHAPE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl <em>Plane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getPlane()
	 * @generated
	 */
	int PLANE = 8;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE__EXTENSION = NODE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE__ANY_ATTRIBUTE = NODE__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Diagram Element Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE__DIAGRAM_ELEMENT_GROUP = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Diagram Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE__DIAGRAM_ELEMENT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Plane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.StyleImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__ID = 0;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl
	 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 11;

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
	 * The feature id for the '<em><b>Diagram Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DIAGRAM_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DIAGRAM = 4;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__EDGE = 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LABEL = 6;

	/**
	 * The feature id for the '<em><b>Labeled Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LABELED_EDGE = 7;

	/**
	 * The feature id for the '<em><b>Labeled Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LABELED_SHAPE = 8;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__NODE = 9;

	/**
	 * The feature id for the '<em><b>Plane</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PLANE = 10;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SHAPE = 11;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__STYLE = 12;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 13;


	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.Diagram#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Diagram#getDocumentation()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.Diagram#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Diagram#getId()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.Diagram#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Diagram#getName()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.Diagram#getResolution <em>Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolution</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Diagram#getResolution()
	 * @see #getDiagram()
	 * @generated
	 */
	EAttribute getDiagram_Resolution();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DiagramElement
	 * @generated
	 */
	EClass getDiagramElement();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DiagramElement#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DiagramElement#getExtension()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_Extension();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.DiagramElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DiagramElement#getId()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_Id();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.model.mtm_di.DiagramElement#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DiagramElement#getAnyAttribute()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EAttribute getDiagramElement_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.model.mtm_di.Edge#getWaypoint <em>Waypoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Waypoint</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Edge#getWaypoint()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Waypoint();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.ExtensionType <em>Extension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Type</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.ExtensionType
	 * @generated
	 */
	EClass getExtensionType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.model.mtm_di.ExtensionType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.ExtensionType#getAny()
	 * @see #getExtensionType()
	 * @generated
	 */
	EAttribute getExtensionType_Any();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.Label#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Label#getBounds()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_Bounds();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.LabeledEdge <em>Labeled Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.LabeledEdge
	 * @generated
	 */
	EClass getLabeledEdge();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.LabeledShape <em>Labeled Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Labeled Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.LabeledShape
	 * @generated
	 */
	EClass getLabeledShape();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Plane <em>Plane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plane</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Plane
	 * @generated
	 */
	EClass getPlane();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.model.mtm_di.Plane#getDiagramElementGroup <em>Diagram Element Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Diagram Element Group</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Plane#getDiagramElementGroup()
	 * @see #getPlane()
	 * @generated
	 */
	EAttribute getPlane_DiagramElementGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.model.mtm_di.Plane#getDiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagram Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Plane#getDiagramElement()
	 * @see #getPlane()
	 * @generated
	 */
	EReference getPlane_DiagramElement();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Shape
	 * @generated
	 */
	EClass getShape();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.Shape#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Shape#getBounds()
	 * @see #getShape()
	 * @generated
	 */
	EReference getShape_Bounds();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_di.Style#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.Style#getId()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagram Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagramElement()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_DiagramElement();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagram</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getDiagram()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Diagram();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getEdge()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Edge();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Label</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Label();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledEdge <em>Labeled Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Labeled Edge</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledEdge()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LabeledEdge();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledShape <em>Labeled Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Labeled Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getLabeledShape()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_LabeledShape();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getNode()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Node();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getPlane <em>Plane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plane</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getPlane()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Plane();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shape</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getShape()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Shape();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.model.mtm_di.DocumentRoot#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style</em>'.
	 * @see eu.aniketos.mtm.model.mtm_di.DocumentRoot#getStyle()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Style();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiFactory getDiFactory();

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
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiagramImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__DOCUMENTATION = eINSTANCE.getDiagram_Documentation();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__ID = eINSTANCE.getDiagram_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__NAME = eINSTANCE.getDiagram_Name();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM__RESOLUTION = eINSTANCE.getDiagram_Resolution();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiagramElementImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDiagramElement()
		 * @generated
		 */
		EClass DIAGRAM_ELEMENT = eINSTANCE.getDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__EXTENSION = eINSTANCE.getDiagramElement_Extension();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__ID = eINSTANCE.getDiagramElement_Id();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ELEMENT__ANY_ATTRIBUTE = eINSTANCE.getDiagramElement_AnyAttribute();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.EdgeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Waypoint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__WAYPOINT = eINSTANCE.getEdge_Waypoint();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.ExtensionTypeImpl <em>Extension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.ExtensionTypeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getExtensionType()
		 * @generated
		 */
		EClass EXTENSION_TYPE = eINSTANCE.getExtensionType();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_TYPE__ANY = eINSTANCE.getExtensionType_Any();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.LabelImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__BOUNDS = eINSTANCE.getLabel_Bounds();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabeledEdgeImpl <em>Labeled Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.LabeledEdgeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabeledEdge()
		 * @generated
		 */
		EClass LABELED_EDGE = eINSTANCE.getLabeledEdge();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.LabeledShapeImpl <em>Labeled Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.LabeledShapeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getLabeledShape()
		 * @generated
		 */
		EClass LABELED_SHAPE = eINSTANCE.getLabeledShape();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.NodeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl <em>Plane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.PlaneImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getPlane()
		 * @generated
		 */
		EClass PLANE = eINSTANCE.getPlane();

		/**
		 * The meta object literal for the '<em><b>Diagram Element Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLANE__DIAGRAM_ELEMENT_GROUP = eINSTANCE.getPlane_DiagramElementGroup();

		/**
		 * The meta object literal for the '<em><b>Diagram Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLANE__DIAGRAM_ELEMENT = eINSTANCE.getPlane_DiagramElement();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.ShapeImpl <em>Shape</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.ShapeImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getShape()
		 * @generated
		 */
		EClass SHAPE = eINSTANCE.getShape();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHAPE__BOUNDS = eINSTANCE.getShape_Bounds();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.StyleImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__ID = eINSTANCE.getStyle_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DocumentRootImpl
		 * @see eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Diagram Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DIAGRAM_ELEMENT = eINSTANCE.getDocumentRoot_DiagramElement();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DIAGRAM = eINSTANCE.getDocumentRoot_Diagram();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__EDGE = eINSTANCE.getDocumentRoot_Edge();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LABEL = eINSTANCE.getDocumentRoot_Label();

		/**
		 * The meta object literal for the '<em><b>Labeled Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LABELED_EDGE = eINSTANCE.getDocumentRoot_LabeledEdge();

		/**
		 * The meta object literal for the '<em><b>Labeled Shape</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LABELED_SHAPE = eINSTANCE.getDocumentRoot_LabeledShape();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__NODE = eINSTANCE.getDocumentRoot_Node();

		/**
		 * The meta object literal for the '<em><b>Plane</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PLANE = eINSTANCE.getDocumentRoot_Plane();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SHAPE = eINSTANCE.getDocumentRoot_Shape();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__STYLE = eINSTANCE.getDocumentRoot_Style();

	}

} //DiPackage
