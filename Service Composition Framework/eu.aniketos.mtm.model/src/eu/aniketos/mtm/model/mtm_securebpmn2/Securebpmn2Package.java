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
package eu.aniketos.mtm.model.mtm_securebpmn2;

import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;

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
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Factory
 * @model kind="package"
 * @generated
 */
public interface Securebpmn2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mtm_securebpmn2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://securebpmn_mtm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mtm_securebpmn2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Securebpmn2Package eINSTANCE = eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowNodeImpl <em>Security Flow Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowNodeImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSecurityFlowNode()
	 * @generated
	 */
	int SECURITY_FLOW_NODE = 0;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__EXTENSION_VALUES = Bpmn2Package.FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__DOCUMENTATION = Bpmn2Package.FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__EXTENSION_DEFINITIONS = Bpmn2Package.FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__ID = Bpmn2Package.FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__AUDITING = Bpmn2Package.FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__MONITORING = Bpmn2Package.FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__CATEGORY_VALUE_REF = Bpmn2Package.FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__NAME = Bpmn2Package.FLOW_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__INCOMING = Bpmn2Package.FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__LANES = Bpmn2Package.FLOW_NODE__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__OUTGOING = Bpmn2Package.FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__INCOMING_SECURITY_FLOW = Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE__OUTGOING_SECURITY_FLOW = Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW;

	/**
	 * The number of structural features of the '<em>Security Flow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_NODE_FEATURE_COUNT = Bpmn2Package.FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl <em>Security Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSecurityFlow()
	 * @generated
	 */
	int SECURITY_FLOW = 1;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__EXTENSION_VALUES = Bpmn2Package.FLOW_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__DOCUMENTATION = Bpmn2Package.FLOW_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__EXTENSION_DEFINITIONS = Bpmn2Package.FLOW_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__ID = Bpmn2Package.FLOW_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__AUDITING = Bpmn2Package.FLOW_ELEMENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__MONITORING = Bpmn2Package.FLOW_ELEMENT__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__CATEGORY_VALUE_REF = Bpmn2Package.FLOW_ELEMENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__NAME = Bpmn2Package.FLOW_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source Ref Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__SOURCE_REF_NODE = Bpmn2Package.FLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Ref Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW__TARGET_REF_NODE = Bpmn2Package.FLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Security Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_FLOW_FEATURE_COUNT = Bpmn2Package.FLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.RoleImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 2;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__EXTENSION_VALUES = SECURITY_FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DOCUMENTATION = SECURITY_FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__EXTENSION_DEFINITIONS = SECURITY_FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = SECURITY_FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__AUDITING = SECURITY_FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__MONITORING = SECURITY_FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__CATEGORY_VALUE_REF = SECURITY_FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = SECURITY_FLOW_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__INCOMING = SECURITY_FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__LANES = SECURITY_FLOW_NODE__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OUTGOING = SECURITY_FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__INCOMING_SECURITY_FLOW = SECURITY_FLOW_NODE__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OUTGOING_SECURITY_FLOW = SECURITY_FLOW_NODE__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ROLE_NAME = SECURITY_FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PARENT_ROLES = SECURITY_FLOW_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SUBJECTS = SECURITY_FLOW_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Child Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__CHILD_ROLES = SECURITY_FLOW_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PERMISSIONS = SECURITY_FLOW_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = SECURITY_FLOW_NODE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SubjectImpl <em>Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SubjectImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSubject()
	 * @generated
	 */
	int SUBJECT = 3;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__ROLES = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__GROUPS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Received Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT__RECEIVED_DELEGATIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBJECT_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.UserImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getUser()
	 * @generated
	 */
	int USER = 4;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EXTENSION_VALUES = SUBJECT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DOCUMENTATION = SUBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EXTENSION_DEFINITIONS = SUBJECT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ID = SUBJECT__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ROLES = SUBJECT__ROLES;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__GROUPS = SUBJECT__GROUPS;

	/**
	 * The feature id for the '<em><b>Received Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__RECEIVED_DELEGATIONS = SUBJECT__RECEIVED_DELEGATIONS;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_NAME = SUBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = SUBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.GroupImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 5;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__EXTENSION_VALUES = SUBJECT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DOCUMENTATION = SUBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__EXTENSION_DEFINITIONS = SUBJECT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = SUBJECT__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ROLES = SUBJECT__ROLES;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GROUPS = SUBJECT__GROUPS;

	/**
	 * The feature id for the '<em><b>Received Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__RECEIVED_DELEGATIONS = SUBJECT__RECEIVED_DELEGATIONS;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__GROUP_NAME = SUBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__SUBJECTS = SUBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = SUBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 6;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTION_NAME = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PERMISSIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityActionImpl <em>Activity Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getActivityAction()
	 * @generated
	 */
	int ACTIVITY_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__EXTENSION_VALUES = ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__DOCUMENTATION = ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__EXTENSION_DEFINITIONS = ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__ID = ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__ACTION_NAME = ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__PERMISSIONS = ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Activity Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION__ACTIVITY = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Activity Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicActivityActionImpl <em>Atomic Activity Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicActivityActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicActivityAction()
	 * @generated
	 */
	int ATOMIC_ACTIVITY_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__EXTENSION_VALUES = ACTIVITY_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__DOCUMENTATION = ACTIVITY_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__EXTENSION_DEFINITIONS = ACTIVITY_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__ID = ACTIVITY_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__ACTION_NAME = ACTIVITY_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__PERMISSIONS = ACTIVITY_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Activity Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS = ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION__ACTIVITY = ACTIVITY_ACTION__ACTIVITY;

	/**
	 * The number of structural features of the '<em>Atomic Activity Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ACTIVITY_ACTION_FEATURE_COUNT = ACTIVITY_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeActivityActionImpl <em>Composite Activity Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeActivityActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeActivityAction()
	 * @generated
	 */
	int COMPOSITE_ACTIVITY_ACTION = 9;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__EXTENSION_VALUES = ACTIVITY_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__DOCUMENTATION = ACTIVITY_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__EXTENSION_DEFINITIONS = ACTIVITY_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__ID = ACTIVITY_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__ACTION_NAME = ACTIVITY_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__PERMISSIONS = ACTIVITY_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Activity Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS = ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__ACTIVITY = ACTIVITY_ACTION__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Activity Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION__ACTIVITY_ACTIONS = ACTIVITY_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Activity Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ACTIVITY_ACTION_FEATURE_COUNT = ACTIVITY_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.PermissionImpl <em>Permission</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.PermissionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getPermission()
	 * @generated
	 */
	int PERMISSION = 10;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ROLES = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__ACTIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Authorization Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__AUTHORIZATION_CONSTRAINTS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>PName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__PNAME = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION__DELEGATIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Permission</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.NeedToKnowImpl <em>Need To Know</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.NeedToKnowImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getNeedToKnow()
	 * @generated
	 */
	int NEED_TO_KNOW = 11;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__EXTENSION_VALUES = PERMISSION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__DOCUMENTATION = PERMISSION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__EXTENSION_DEFINITIONS = PERMISSION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__ID = PERMISSION__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__ROLES = PERMISSION__ROLES;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__ACTIONS = PERMISSION__ACTIONS;

	/**
	 * The feature id for the '<em><b>Authorization Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__AUTHORIZATION_CONSTRAINTS = PERMISSION__AUTHORIZATION_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>PName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__PNAME = PERMISSION__PNAME;

	/**
	 * The feature id for the '<em><b>Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW__DELEGATIONS = PERMISSION__DELEGATIONS;

	/**
	 * The number of structural features of the '<em>Need To Know</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEED_TO_KNOW_FEATURE_COUNT = PERMISSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AuthorizationConstraintImpl <em>Authorization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AuthorizationConstraintImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAuthorizationConstraint()
	 * @generated
	 */
	int AUTHORIZATION_CONSTRAINT = 14;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__EXTENSION_VALUES = SECURITY_FLOW_NODE__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__DOCUMENTATION = SECURITY_FLOW_NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__EXTENSION_DEFINITIONS = SECURITY_FLOW_NODE__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__ID = SECURITY_FLOW_NODE__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__AUDITING = SECURITY_FLOW_NODE__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__MONITORING = SECURITY_FLOW_NODE__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__CATEGORY_VALUE_REF = SECURITY_FLOW_NODE__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__NAME = SECURITY_FLOW_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__INCOMING = SECURITY_FLOW_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__LANES = SECURITY_FLOW_NODE__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__OUTGOING = SECURITY_FLOW_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__INCOMING_SECURITY_FLOW = SECURITY_FLOW_NODE__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__OUTGOING_SECURITY_FLOW = SECURITY_FLOW_NODE__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME = SECURITY_FLOW_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__EXPRESSION = SECURITY_FLOW_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__PERMISSIONS = SECURITY_FLOW_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dynamic Enforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT = SECURITY_FLOW_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Authorization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHORIZATION_CONSTRAINT_FEATURE_COUNT = SECURITY_FLOW_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SeparationOfDutyImpl <em>Separation Of Duty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SeparationOfDutyImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSeparationOfDuty()
	 * @generated
	 */
	int SEPARATION_OF_DUTY = 12;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__EXTENSION_VALUES = AUTHORIZATION_CONSTRAINT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__DOCUMENTATION = AUTHORIZATION_CONSTRAINT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__EXTENSION_DEFINITIONS = AUTHORIZATION_CONSTRAINT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__ID = AUTHORIZATION_CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__AUDITING = AUTHORIZATION_CONSTRAINT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__MONITORING = AUTHORIZATION_CONSTRAINT__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__CATEGORY_VALUE_REF = AUTHORIZATION_CONSTRAINT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__NAME = AUTHORIZATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__INCOMING = AUTHORIZATION_CONSTRAINT__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__LANES = AUTHORIZATION_CONSTRAINT__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__OUTGOING = AUTHORIZATION_CONSTRAINT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__INCOMING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__OUTGOING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__CONSTRAINT_NAME = AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__EXPRESSION = AUTHORIZATION_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__PERMISSIONS = AUTHORIZATION_CONSTRAINT__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Dynamic Enforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__DYNAMIC_ENFORCEMENT = AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT;

	/**
	 * The feature id for the '<em><b>Minimum Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__MINIMUM_USERS = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max User Actions Permitted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Separation Of Duty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATION_OF_DUTY_FEATURE_COUNT = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl <em>Binding Of Duty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getBindingOfDuty()
	 * @generated
	 */
	int BINDING_OF_DUTY = 13;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__EXTENSION_VALUES = AUTHORIZATION_CONSTRAINT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__DOCUMENTATION = AUTHORIZATION_CONSTRAINT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__EXTENSION_DEFINITIONS = AUTHORIZATION_CONSTRAINT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__ID = AUTHORIZATION_CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__AUDITING = AUTHORIZATION_CONSTRAINT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__MONITORING = AUTHORIZATION_CONSTRAINT__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__CATEGORY_VALUE_REF = AUTHORIZATION_CONSTRAINT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__NAME = AUTHORIZATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__INCOMING = AUTHORIZATION_CONSTRAINT__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__LANES = AUTHORIZATION_CONSTRAINT__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__OUTGOING = AUTHORIZATION_CONSTRAINT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__INCOMING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__OUTGOING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__CONSTRAINT_NAME = AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__EXPRESSION = AUTHORIZATION_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__PERMISSIONS = AUTHORIZATION_CONSTRAINT__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Dynamic Enforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__DYNAMIC_ENFORCEMENT = AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT;

	/**
	 * The feature id for the '<em><b>Max Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__MAX_USERS = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Same User Action Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY__SAME_USER_ACTION_COUNT = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binding Of Duty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_OF_DUTY_FEATURE_COUNT = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityAuthorizationConstraintImpl <em>Activity Authorization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityAuthorizationConstraintImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getActivityAuthorizationConstraint()
	 * @generated
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT = 15;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__EXTENSION_VALUES = AUTHORIZATION_CONSTRAINT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__DOCUMENTATION = AUTHORIZATION_CONSTRAINT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__EXTENSION_DEFINITIONS = AUTHORIZATION_CONSTRAINT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__ID = AUTHORIZATION_CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__AUDITING = AUTHORIZATION_CONSTRAINT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__MONITORING = AUTHORIZATION_CONSTRAINT__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__CATEGORY_VALUE_REF = AUTHORIZATION_CONSTRAINT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__NAME = AUTHORIZATION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__INCOMING = AUTHORIZATION_CONSTRAINT__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__LANES = AUTHORIZATION_CONSTRAINT__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__OUTGOING = AUTHORIZATION_CONSTRAINT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__INCOMING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__OUTGOING_SECURITY_FLOW = AUTHORIZATION_CONSTRAINT__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Constraint Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME = AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__EXPRESSION = AUTHORIZATION_CONSTRAINT__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__PERMISSIONS = AUTHORIZATION_CONSTRAINT__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Dynamic Enforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT = AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT;

	/**
	 * The feature id for the '<em><b>Activities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT__ACTIVITIES = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Activity Authorization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_AUTHORIZATION_CONSTRAINT_FEATURE_COUNT = AUTHORIZATION_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl <em>Process Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getProcessAction()
	 * @generated
	 */
	int PROCESS_ACTION = 16;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__EXTENSION_VALUES = ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__DOCUMENTATION = ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__EXTENSION_DEFINITIONS = ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__ID = ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__ACTION_NAME = ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__PERMISSIONS = ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Process Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Process</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION__PROCESS = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Process Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicProcessActionImpl <em>Atomic Process Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicProcessActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicProcessAction()
	 * @generated
	 */
	int ATOMIC_PROCESS_ACTION = 17;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__EXTENSION_VALUES = PROCESS_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__DOCUMENTATION = PROCESS_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__EXTENSION_DEFINITIONS = PROCESS_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__ID = PROCESS_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__ACTION_NAME = PROCESS_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__PERMISSIONS = PROCESS_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Process Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS = PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS;

	/**
	 * The feature id for the '<em><b>Process</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION__PROCESS = PROCESS_ACTION__PROCESS;

	/**
	 * The number of structural features of the '<em>Atomic Process Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_PROCESS_ACTION_FEATURE_COUNT = PROCESS_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeProcessActionImpl <em>Composite Process Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeProcessActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeProcessAction()
	 * @generated
	 */
	int COMPOSITE_PROCESS_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__EXTENSION_VALUES = PROCESS_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__DOCUMENTATION = PROCESS_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__EXTENSION_DEFINITIONS = PROCESS_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__ID = PROCESS_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__ACTION_NAME = PROCESS_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__PERMISSIONS = PROCESS_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Process Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS = PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS;

	/**
	 * The feature id for the '<em><b>Process</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__PROCESS = PROCESS_ACTION__PROCESS;

	/**
	 * The feature id for the '<em><b>Process Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION__PROCESS_ACTIONS = PROCESS_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Process Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PROCESS_ACTION_FEATURE_COUNT = PROCESS_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ItemAwareElementActionImpl <em>Item Aware Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ItemAwareElementActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getItemAwareElementAction()
	 * @generated
	 */
	int ITEM_AWARE_ELEMENT_ACTION = 19;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__EXTENSION_VALUES = ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__DOCUMENTATION = ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__EXTENSION_DEFINITIONS = ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__ID = ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__ACTION_NAME = ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__PERMISSIONS = ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Item Aware Element Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item Aware Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Item Aware Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicItemAwareElementActionImpl <em>Atomic Item Aware Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicItemAwareElementActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicItemAwareElementAction()
	 * @generated
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION = 20;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__EXTENSION_VALUES = ITEM_AWARE_ELEMENT_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__DOCUMENTATION = ITEM_AWARE_ELEMENT_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__EXTENSION_DEFINITIONS = ITEM_AWARE_ELEMENT_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__ID = ITEM_AWARE_ELEMENT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__ACTION_NAME = ITEM_AWARE_ELEMENT_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__PERMISSIONS = ITEM_AWARE_ELEMENT_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Item Aware Element Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS = ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS;

	/**
	 * The feature id for the '<em><b>Item Aware Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT = ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Atomic Item Aware Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT = ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeItemAwareElementActionImpl <em>Composite Item Aware Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeItemAwareElementActionImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeItemAwareElementAction()
	 * @generated
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION = 21;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__EXTENSION_VALUES = ITEM_AWARE_ELEMENT_ACTION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__DOCUMENTATION = ITEM_AWARE_ELEMENT_ACTION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__EXTENSION_DEFINITIONS = ITEM_AWARE_ELEMENT_ACTION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ID = ITEM_AWARE_ELEMENT_ACTION__ID;

	/**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ACTION_NAME = ITEM_AWARE_ELEMENT_ACTION__ACTION_NAME;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__PERMISSIONS = ITEM_AWARE_ELEMENT_ACTION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Composite Item Aware Element Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS = ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS;

	/**
	 * The feature id for the '<em><b>Item Aware Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT = ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Item Aware Element Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS = ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Item Aware Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT = ITEM_AWARE_ELEMENT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl <em>Delegation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getDelegation()
	 * @generated
	 */
	int DELEGATION = 22;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Delegator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__DELEGATOR = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Delegatee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__DELEGATEE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Negotiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__NEGOTIABLE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__PERMISSIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Delegatable Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION__DELEGATABLE_PERMISSIONS = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Delegation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATION_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SimpleDelegationImpl <em>Simple Delegation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SimpleDelegationImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSimpleDelegation()
	 * @generated
	 */
	int SIMPLE_DELEGATION = 23;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__EXTENSION_VALUES = DELEGATION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__DOCUMENTATION = DELEGATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__EXTENSION_DEFINITIONS = DELEGATION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__ID = DELEGATION__ID;

	/**
	 * The feature id for the '<em><b>Delegator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__DELEGATOR = DELEGATION__DELEGATOR;

	/**
	 * The feature id for the '<em><b>Delegatee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__DELEGATEE = DELEGATION__DELEGATEE;

	/**
	 * The feature id for the '<em><b>Negotiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__NEGOTIABLE = DELEGATION__NEGOTIABLE;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__PERMISSIONS = DELEGATION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Delegatable Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION__DELEGATABLE_PERMISSIONS = DELEGATION__DELEGATABLE_PERMISSIONS;

	/**
	 * The number of structural features of the '<em>Simple Delegation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_DELEGATION_FEATURE_COUNT = DELEGATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.TransferDelegationImpl <em>Transfer Delegation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.TransferDelegationImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getTransferDelegation()
	 * @generated
	 */
	int TRANSFER_DELEGATION = 24;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__EXTENSION_VALUES = DELEGATION__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__DOCUMENTATION = DELEGATION__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__EXTENSION_DEFINITIONS = DELEGATION__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__ID = DELEGATION__ID;

	/**
	 * The feature id for the '<em><b>Delegator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__DELEGATOR = DELEGATION__DELEGATOR;

	/**
	 * The feature id for the '<em><b>Delegatee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__DELEGATEE = DELEGATION__DELEGATEE;

	/**
	 * The feature id for the '<em><b>Negotiable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__NEGOTIABLE = DELEGATION__NEGOTIABLE;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__PERMISSIONS = DELEGATION__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Delegatable Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION__DELEGATABLE_PERMISSIONS = DELEGATION__DELEGATABLE_PERMISSIONS;

	/**
	 * The number of structural features of the '<em>Transfer Delegation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFER_DELEGATION_FEATURE_COUNT = DELEGATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl <em>Delegator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getDelegator()
	 * @generated
	 */
	int DELEGATOR = 25;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__EXTENSION_VALUES = USER__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__DOCUMENTATION = USER__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__EXTENSION_DEFINITIONS = USER__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__ID = USER__ID;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__ROLES = USER__ROLES;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__GROUPS = USER__GROUPS;

	/**
	 * The feature id for the '<em><b>Received Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__RECEIVED_DELEGATIONS = USER__RECEIVED_DELEGATIONS;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__USER_NAME = USER__USER_NAME;

	/**
	 * The feature id for the '<em><b>Parent Delegators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__PARENT_DELEGATORS = USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child Delegators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__CHILD_DELEGATORS = USER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Delegation Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__MAX_DELEGATION_DEPTH = USER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Executed Delegations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR__EXECUTED_DELEGATIONS = USER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Delegator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEGATOR_FEATURE_COUNT = USER_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlowNode <em>Security Flow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Flow Node</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlowNode
	 * @generated
	 */
	EClass getSecurityFlowNode();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow <em>Security Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Flow</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow
	 * @generated
	 */
	EClass getSecurityFlow();

	/**
	 * Returns the meta object for the reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow#getSourceRefNode <em>Source Ref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Ref Node</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow#getSourceRefNode()
	 * @see #getSecurityFlow()
	 * @generated
	 */
	EReference getSecurityFlow_SourceRefNode();

	/**
	 * Returns the meta object for the reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow#getTargetRefNode <em>Target Ref Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Ref Node</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow#getTargetRefNode()
	 * @see #getSecurityFlow()
	 * @generated
	 */
	EReference getSecurityFlow_TargetRefNode();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getRoleName <em>Role Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getRoleName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_RoleName();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getParentRoles <em>Parent Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Roles</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getParentRoles()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_ParentRoles();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subjects</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getSubjects()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Subjects();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getChildRoles <em>Child Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Roles</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getChildRoles()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_ChildRoles();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Role#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permissions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Role#getPermissions()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Permissions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subject</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Subject
	 * @generated
	 */
	EClass getSubject();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getRoles()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_Roles();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Groups</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getGroups()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_Groups();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getReceivedDelegations <em>Received Delegations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Received Delegations</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Subject#getReceivedDelegations()
	 * @see #getSubject()
	 * @generated
	 */
	EReference getSubject_ReceivedDelegations();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.User#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.User#getUserName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserName();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Group#getGroupName <em>Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Group#getGroupName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_GroupName();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Group#getSubjects <em>Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subjects</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Group#getSubjects()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Subjects();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Action#getActionName <em>Action Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Action#getActionName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ActionName();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Action#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permissions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Action#getPermissions()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Permissions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction <em>Activity Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction
	 * @generated
	 */
	EClass getActivityAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction#getCompositeActivityActions <em>Composite Activity Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composite Activity Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction#getCompositeActivityActions()
	 * @see #getActivityAction()
	 * @generated
	 */
	EReference getActivityAction_CompositeActivityActions();

	/**
	 * Returns the meta object for the reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAction#getActivity()
	 * @see #getActivityAction()
	 * @generated
	 */
	EReference getActivityAction_Activity();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AtomicActivityAction <em>Atomic Activity Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Activity Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AtomicActivityAction
	 * @generated
	 */
	EClass getAtomicActivityAction();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeActivityAction <em>Composite Activity Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Activity Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeActivityAction
	 * @generated
	 */
	EClass getCompositeActivityAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeActivityAction#getActivityActions <em>Activity Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Activity Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeActivityAction#getActivityActions()
	 * @see #getCompositeActivityAction()
	 * @generated
	 */
	EReference getCompositeActivityAction_ActivityActions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission
	 * @generated
	 */
	EClass getPermission();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getRoles()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_Roles();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getActions()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_Actions();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getAuthorizationConstraints <em>Authorization Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Authorization Constraints</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getAuthorizationConstraints()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_AuthorizationConstraints();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getPName <em>PName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>PName</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getPName()
	 * @see #getPermission()
	 * @generated
	 */
	EAttribute getPermission_PName();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getDelegations <em>Delegations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delegations</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Permission#getDelegations()
	 * @see #getPermission()
	 * @generated
	 */
	EReference getPermission_Delegations();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.NeedToKnow <em>Need To Know</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Need To Know</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.NeedToKnow
	 * @generated
	 */
	EClass getNeedToKnow();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty <em>Separation Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Separation Of Duty</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty
	 * @generated
	 */
	EClass getSeparationOfDuty();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty#getMinimumUsers <em>Minimum Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimum Users</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty#getMinimumUsers()
	 * @see #getSeparationOfDuty()
	 * @generated
	 */
	EAttribute getSeparationOfDuty_MinimumUsers();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty#getMaxUserActionsPermitted <em>Max User Actions Permitted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max User Actions Permitted</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SeparationOfDuty#getMaxUserActionsPermitted()
	 * @see #getSeparationOfDuty()
	 * @generated
	 */
	EAttribute getSeparationOfDuty_MaxUserActionsPermitted();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty <em>Binding Of Duty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Of Duty</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty
	 * @generated
	 */
	EClass getBindingOfDuty();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getMaxUsers <em>Max Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Users</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getMaxUsers()
	 * @see #getBindingOfDuty()
	 * @generated
	 */
	EAttribute getBindingOfDuty_MaxUsers();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getSameUserActionCount <em>Same User Action Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Same User Action Count</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getSameUserActionCount()
	 * @see #getBindingOfDuty()
	 * @generated
	 */
	EAttribute getBindingOfDuty_SameUserActionCount();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint <em>Authorization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Authorization Constraint</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint
	 * @generated
	 */
	EClass getAuthorizationConstraint();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getConstraintName <em>Constraint Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint Name</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getConstraintName()
	 * @see #getAuthorizationConstraint()
	 * @generated
	 */
	EAttribute getAuthorizationConstraint_ConstraintName();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getExpression()
	 * @see #getAuthorizationConstraint()
	 * @generated
	 */
	EAttribute getAuthorizationConstraint_Expression();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permissions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#getPermissions()
	 * @see #getAuthorizationConstraint()
	 * @generated
	 */
	EReference getAuthorizationConstraint_Permissions();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#isDynamicEnforcement <em>Dynamic Enforcement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dynamic Enforcement</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AuthorizationConstraint#isDynamicEnforcement()
	 * @see #getAuthorizationConstraint()
	 * @generated
	 */
	EAttribute getAuthorizationConstraint_DynamicEnforcement();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAuthorizationConstraint <em>Activity Authorization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Authorization Constraint</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAuthorizationConstraint
	 * @generated
	 */
	EClass getActivityAuthorizationConstraint();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAuthorizationConstraint#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Activities</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ActivityAuthorizationConstraint#getActivities()
	 * @see #getActivityAuthorizationConstraint()
	 * @generated
	 */
	EReference getActivityAuthorizationConstraint_Activities();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction <em>Process Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction
	 * @generated
	 */
	EClass getProcessAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getCompositeProcessActions <em>Composite Process Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composite Process Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getCompositeProcessActions()
	 * @see #getProcessAction()
	 * @generated
	 */
	EReference getProcessAction_CompositeProcessActions();

	/**
	 * Returns the meta object for the container reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Process</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction#getProcess()
	 * @see #getProcessAction()
	 * @generated
	 */
	EReference getProcessAction_Process();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AtomicProcessAction <em>Atomic Process Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Process Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AtomicProcessAction
	 * @generated
	 */
	EClass getAtomicProcessAction();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeProcessAction <em>Composite Process Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Process Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeProcessAction
	 * @generated
	 */
	EClass getCompositeProcessAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeProcessAction#getProcessActions <em>Process Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Process Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeProcessAction#getProcessActions()
	 * @see #getCompositeProcessAction()
	 * @generated
	 */
	EReference getCompositeProcessAction_ProcessActions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction <em>Item Aware Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Aware Element Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction
	 * @generated
	 */
	EClass getItemAwareElementAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getCompositeItemAwareElementActions <em>Composite Item Aware Element Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composite Item Aware Element Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getCompositeItemAwareElementActions()
	 * @see #getItemAwareElementAction()
	 * @generated
	 */
	EReference getItemAwareElementAction_CompositeItemAwareElementActions();

	/**
	 * Returns the meta object for the container reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getItemAwareElement <em>Item Aware Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Item Aware Element</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getItemAwareElement()
	 * @see #getItemAwareElementAction()
	 * @generated
	 */
	EReference getItemAwareElementAction_ItemAwareElement();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.AtomicItemAwareElementAction <em>Atomic Item Aware Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Item Aware Element Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.AtomicItemAwareElementAction
	 * @generated
	 */
	EClass getAtomicItemAwareElementAction();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeItemAwareElementAction <em>Composite Item Aware Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Item Aware Element Action</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeItemAwareElementAction
	 * @generated
	 */
	EClass getCompositeItemAwareElementAction();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeItemAwareElementAction#getItemAwareElementActions <em>Item Aware Element Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Item Aware Element Actions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.CompositeItemAwareElementAction#getItemAwareElementActions()
	 * @see #getCompositeItemAwareElementAction()
	 * @generated
	 */
	EReference getCompositeItemAwareElementAction_ItemAwareElementActions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegation</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation
	 * @generated
	 */
	EClass getDelegation();

	/**
	 * Returns the meta object for the reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegator <em>Delegator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegator</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegator()
	 * @see #getDelegation()
	 * @generated
	 */
	EReference getDelegation_Delegator();

	/**
	 * Returns the meta object for the reference '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatee <em>Delegatee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Delegatee</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatee()
	 * @see #getDelegation()
	 * @generated
	 */
	EReference getDelegation_Delegatee();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#isNegotiable <em>Negotiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negotiable</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#isNegotiable()
	 * @see #getDelegation()
	 * @generated
	 */
	EAttribute getDelegation_Negotiable();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permissions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getPermissions()
	 * @see #getDelegation()
	 * @generated
	 */
	EReference getDelegation_Permissions();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatablePermissions <em>Delegatable Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delegatable Permissions</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegation#getDelegatablePermissions()
	 * @see #getDelegation()
	 * @generated
	 */
	EAttribute getDelegation_DelegatablePermissions();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.SimpleDelegation <em>Simple Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Delegation</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.SimpleDelegation
	 * @generated
	 */
	EClass getSimpleDelegation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.TransferDelegation <em>Transfer Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transfer Delegation</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.TransferDelegation
	 * @generated
	 */
	EClass getTransferDelegation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator <em>Delegator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delegator</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator
	 * @generated
	 */
	EClass getDelegator();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getParentDelegators <em>Parent Delegators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parent Delegators</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getParentDelegators()
	 * @see #getDelegator()
	 * @generated
	 */
	EReference getDelegator_ParentDelegators();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getChildDelegators <em>Child Delegators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Child Delegators</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getChildDelegators()
	 * @see #getDelegator()
	 * @generated
	 */
	EReference getDelegator_ChildDelegators();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getMaxDelegationDepth <em>Max Delegation Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Delegation Depth</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getMaxDelegationDepth()
	 * @see #getDelegator()
	 * @generated
	 */
	EAttribute getDelegator_MaxDelegationDepth();

	/**
	 * Returns the meta object for the reference list '{@link eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getExecutedDelegations <em>Executed Delegations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Executed Delegations</em>'.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Delegator#getExecutedDelegations()
	 * @see #getDelegator()
	 * @generated
	 */
	EReference getDelegator_ExecutedDelegations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Securebpmn2Factory getSecurebpmn2Factory();

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
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowNodeImpl <em>Security Flow Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowNodeImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSecurityFlowNode()
		 * @generated
		 */
		EClass SECURITY_FLOW_NODE = eINSTANCE.getSecurityFlowNode();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl <em>Security Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSecurityFlow()
		 * @generated
		 */
		EClass SECURITY_FLOW = eINSTANCE.getSecurityFlow();

		/**
		 * The meta object literal for the '<em><b>Source Ref Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_FLOW__SOURCE_REF_NODE = eINSTANCE.getSecurityFlow_SourceRefNode();

		/**
		 * The meta object literal for the '<em><b>Target Ref Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_FLOW__TARGET_REF_NODE = eINSTANCE.getSecurityFlow_TargetRefNode();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.RoleImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Role Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__ROLE_NAME = eINSTANCE.getRole_RoleName();

		/**
		 * The meta object literal for the '<em><b>Parent Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__PARENT_ROLES = eINSTANCE.getRole_ParentRoles();

		/**
		 * The meta object literal for the '<em><b>Subjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__SUBJECTS = eINSTANCE.getRole_Subjects();

		/**
		 * The meta object literal for the '<em><b>Child Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__CHILD_ROLES = eINSTANCE.getRole_ChildRoles();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__PERMISSIONS = eINSTANCE.getRole_Permissions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SubjectImpl <em>Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SubjectImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSubject()
		 * @generated
		 */
		EClass SUBJECT = eINSTANCE.getSubject();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__ROLES = eINSTANCE.getSubject_Roles();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__GROUPS = eINSTANCE.getSubject_Groups();

		/**
		 * The meta object literal for the '<em><b>Received Delegations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBJECT__RECEIVED_DELEGATIONS = eINSTANCE.getSubject_ReceivedDelegations();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.UserImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_NAME = eINSTANCE.getUser_UserName();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.GroupImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__GROUP_NAME = eINSTANCE.getGroup_GroupName();

		/**
		 * The meta object literal for the '<em><b>Subjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__SUBJECTS = eINSTANCE.getGroup_Subjects();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Action Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__ACTION_NAME = eINSTANCE.getAction_ActionName();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__PERMISSIONS = eINSTANCE.getAction_Permissions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityActionImpl <em>Activity Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getActivityAction()
		 * @generated
		 */
		EClass ACTIVITY_ACTION = eINSTANCE.getActivityAction();

		/**
		 * The meta object literal for the '<em><b>Composite Activity Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS = eINSTANCE.getActivityAction_CompositeActivityActions();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_ACTION__ACTIVITY = eINSTANCE.getActivityAction_Activity();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicActivityActionImpl <em>Atomic Activity Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicActivityActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicActivityAction()
		 * @generated
		 */
		EClass ATOMIC_ACTIVITY_ACTION = eINSTANCE.getAtomicActivityAction();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeActivityActionImpl <em>Composite Activity Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeActivityActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeActivityAction()
		 * @generated
		 */
		EClass COMPOSITE_ACTIVITY_ACTION = eINSTANCE.getCompositeActivityAction();

		/**
		 * The meta object literal for the '<em><b>Activity Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ACTIVITY_ACTION__ACTIVITY_ACTIONS = eINSTANCE.getCompositeActivityAction_ActivityActions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.PermissionImpl <em>Permission</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.PermissionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getPermission()
		 * @generated
		 */
		EClass PERMISSION = eINSTANCE.getPermission();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__ROLES = eINSTANCE.getPermission_Roles();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__ACTIONS = eINSTANCE.getPermission_Actions();

		/**
		 * The meta object literal for the '<em><b>Authorization Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__AUTHORIZATION_CONSTRAINTS = eINSTANCE.getPermission_AuthorizationConstraints();

		/**
		 * The meta object literal for the '<em><b>PName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION__PNAME = eINSTANCE.getPermission_PName();

		/**
		 * The meta object literal for the '<em><b>Delegations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMISSION__DELEGATIONS = eINSTANCE.getPermission_Delegations();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.NeedToKnowImpl <em>Need To Know</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.NeedToKnowImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getNeedToKnow()
		 * @generated
		 */
		EClass NEED_TO_KNOW = eINSTANCE.getNeedToKnow();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SeparationOfDutyImpl <em>Separation Of Duty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SeparationOfDutyImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSeparationOfDuty()
		 * @generated
		 */
		EClass SEPARATION_OF_DUTY = eINSTANCE.getSeparationOfDuty();

		/**
		 * The meta object literal for the '<em><b>Minimum Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEPARATION_OF_DUTY__MINIMUM_USERS = eINSTANCE.getSeparationOfDuty_MinimumUsers();

		/**
		 * The meta object literal for the '<em><b>Max User Actions Permitted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED = eINSTANCE.getSeparationOfDuty_MaxUserActionsPermitted();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl <em>Binding Of Duty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.BindingOfDutyImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getBindingOfDuty()
		 * @generated
		 */
		EClass BINDING_OF_DUTY = eINSTANCE.getBindingOfDuty();

		/**
		 * The meta object literal for the '<em><b>Max Users</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_OF_DUTY__MAX_USERS = eINSTANCE.getBindingOfDuty_MaxUsers();

		/**
		 * The meta object literal for the '<em><b>Same User Action Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_OF_DUTY__SAME_USER_ACTION_COUNT = eINSTANCE.getBindingOfDuty_SameUserActionCount();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AuthorizationConstraintImpl <em>Authorization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AuthorizationConstraintImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAuthorizationConstraint()
		 * @generated
		 */
		EClass AUTHORIZATION_CONSTRAINT = eINSTANCE.getAuthorizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME = eINSTANCE.getAuthorizationConstraint_ConstraintName();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHORIZATION_CONSTRAINT__EXPRESSION = eINSTANCE.getAuthorizationConstraint_Expression();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHORIZATION_CONSTRAINT__PERMISSIONS = eINSTANCE.getAuthorizationConstraint_Permissions();

		/**
		 * The meta object literal for the '<em><b>Dynamic Enforcement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT = eINSTANCE.getAuthorizationConstraint_DynamicEnforcement();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityAuthorizationConstraintImpl <em>Activity Authorization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ActivityAuthorizationConstraintImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getActivityAuthorizationConstraint()
		 * @generated
		 */
		EClass ACTIVITY_AUTHORIZATION_CONSTRAINT = eINSTANCE.getActivityAuthorizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Activities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_AUTHORIZATION_CONSTRAINT__ACTIVITIES = eINSTANCE.getActivityAuthorizationConstraint_Activities();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl <em>Process Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getProcessAction()
		 * @generated
		 */
		EClass PROCESS_ACTION = eINSTANCE.getProcessAction();

		/**
		 * The meta object literal for the '<em><b>Composite Process Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS = eINSTANCE.getProcessAction_CompositeProcessActions();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_ACTION__PROCESS = eINSTANCE.getProcessAction_Process();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicProcessActionImpl <em>Atomic Process Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicProcessActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicProcessAction()
		 * @generated
		 */
		EClass ATOMIC_PROCESS_ACTION = eINSTANCE.getAtomicProcessAction();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeProcessActionImpl <em>Composite Process Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeProcessActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeProcessAction()
		 * @generated
		 */
		EClass COMPOSITE_PROCESS_ACTION = eINSTANCE.getCompositeProcessAction();

		/**
		 * The meta object literal for the '<em><b>Process Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PROCESS_ACTION__PROCESS_ACTIONS = eINSTANCE.getCompositeProcessAction_ProcessActions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ItemAwareElementActionImpl <em>Item Aware Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.ItemAwareElementActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getItemAwareElementAction()
		 * @generated
		 */
		EClass ITEM_AWARE_ELEMENT_ACTION = eINSTANCE.getItemAwareElementAction();

		/**
		 * The meta object literal for the '<em><b>Composite Item Aware Element Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS = eINSTANCE.getItemAwareElementAction_CompositeItemAwareElementActions();

		/**
		 * The meta object literal for the '<em><b>Item Aware Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT = eINSTANCE.getItemAwareElementAction_ItemAwareElement();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicItemAwareElementActionImpl <em>Atomic Item Aware Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.AtomicItemAwareElementActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getAtomicItemAwareElementAction()
		 * @generated
		 */
		EClass ATOMIC_ITEM_AWARE_ELEMENT_ACTION = eINSTANCE.getAtomicItemAwareElementAction();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeItemAwareElementActionImpl <em>Composite Item Aware Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.CompositeItemAwareElementActionImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getCompositeItemAwareElementAction()
		 * @generated
		 */
		EClass COMPOSITE_ITEM_AWARE_ELEMENT_ACTION = eINSTANCE.getCompositeItemAwareElementAction();

		/**
		 * The meta object literal for the '<em><b>Item Aware Element Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS = eINSTANCE.getCompositeItemAwareElementAction_ItemAwareElementActions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl <em>Delegation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegationImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getDelegation()
		 * @generated
		 */
		EClass DELEGATION = eINSTANCE.getDelegation();

		/**
		 * The meta object literal for the '<em><b>Delegator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATION__DELEGATOR = eINSTANCE.getDelegation_Delegator();

		/**
		 * The meta object literal for the '<em><b>Delegatee</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATION__DELEGATEE = eINSTANCE.getDelegation_Delegatee();

		/**
		 * The meta object literal for the '<em><b>Negotiable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELEGATION__NEGOTIABLE = eINSTANCE.getDelegation_Negotiable();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATION__PERMISSIONS = eINSTANCE.getDelegation_Permissions();

		/**
		 * The meta object literal for the '<em><b>Delegatable Permissions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELEGATION__DELEGATABLE_PERMISSIONS = eINSTANCE.getDelegation_DelegatablePermissions();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SimpleDelegationImpl <em>Simple Delegation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.SimpleDelegationImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getSimpleDelegation()
		 * @generated
		 */
		EClass SIMPLE_DELEGATION = eINSTANCE.getSimpleDelegation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.TransferDelegationImpl <em>Transfer Delegation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.TransferDelegationImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getTransferDelegation()
		 * @generated
		 */
		EClass TRANSFER_DELEGATION = eINSTANCE.getTransferDelegation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl <em>Delegator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.DelegatorImpl
		 * @see eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl#getDelegator()
		 * @generated
		 */
		EClass DELEGATOR = eINSTANCE.getDelegator();

		/**
		 * The meta object literal for the '<em><b>Parent Delegators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATOR__PARENT_DELEGATORS = eINSTANCE.getDelegator_ParentDelegators();

		/**
		 * The meta object literal for the '<em><b>Child Delegators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATOR__CHILD_DELEGATORS = eINSTANCE.getDelegator_ChildDelegators();

		/**
		 * The meta object literal for the '<em><b>Max Delegation Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELEGATOR__MAX_DELEGATION_DEPTH = eINSTANCE.getDelegator_MaxDelegationDepth();

		/**
		 * The meta object literal for the '<em><b>Executed Delegations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEGATOR__EXECUTED_DELEGATIONS = eINSTANCE.getDelegator_ExecutedDelegations();

	}

} //Securebpmn2Package
