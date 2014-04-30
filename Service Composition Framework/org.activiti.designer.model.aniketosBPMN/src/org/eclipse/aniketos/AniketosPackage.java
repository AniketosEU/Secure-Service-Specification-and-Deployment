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
package org.eclipse.aniketos;

import org.eclipse.bpmn2.Bpmn2Package;

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
 * @see org.eclipse.aniketos.AniketosFactory
 * @model kind="package"
 * @generated
 */
public interface AniketosPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "aniketos";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://aniketos.eu";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "aniketos";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AniketosPackage eINSTANCE = org.eclipse.aniketos.impl.AniketosPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.aniketos.impl.SecurityExtensionImpl <em>Security Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.aniketos.impl.SecurityExtensionImpl
	 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getSecurityExtension()
	 * @generated
	 */
	int SECURITY_EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Integrity Req</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__INTEGRITY_REQ = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trustworthiness Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Confidentiality Req</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION__CONFIDENTIALITY_REQ = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Security Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_EXTENSION_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.aniketos.impl.IntegrityImpl <em>Integrity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.aniketos.impl.IntegrityImpl
	 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getIntegrity()
	 * @generated
	 */
	int INTEGRITY = 1;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Security Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__SECURITY_REF = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__TYPE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__WITH = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY__ALGORITHM = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Integrity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.aniketos.impl.TrustworthinessImpl <em>Trustworthiness</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.aniketos.impl.TrustworthinessImpl
	 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getTrustworthiness()
	 * @generated
	 */
	int TRUSTWORTHINESS = 2;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__VALUE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Security Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS__SECURITY_REF = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trustworthiness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.aniketos.impl.ConfidentialityImpl <em>Confidentiality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.aniketos.impl.ConfidentialityImpl
	 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getConfidentiality()
	 * @generated
	 */
	int CONFIDENTIALITY = 3;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__EXTENSION_VALUES = Bpmn2Package.BASE_ELEMENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__DOCUMENTATION = Bpmn2Package.BASE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__EXTENSION_DEFINITIONS = Bpmn2Package.BASE_ELEMENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__ID = Bpmn2Package.BASE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__TYPE = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Security Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__SECURITY_REF = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY__ALGORITHM = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Confidentiality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_FEATURE_COUNT = Bpmn2Package.BASE_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.aniketos.impl.ThreatEventImpl <em>Threat Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.aniketos.impl.ThreatEventImpl
	 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getThreatEvent()
	 * @generated
	 */
	int THREAT_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Extension Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__EXTENSION_VALUES = Bpmn2Package.BOUNDARY_EVENT__EXTENSION_VALUES;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__DOCUMENTATION = Bpmn2Package.BOUNDARY_EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Extension Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__EXTENSION_DEFINITIONS = Bpmn2Package.BOUNDARY_EVENT__EXTENSION_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__ID = Bpmn2Package.BOUNDARY_EVENT__ID;

	/**
	 * The feature id for the '<em><b>Auditing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__AUDITING = Bpmn2Package.BOUNDARY_EVENT__AUDITING;

	/**
	 * The feature id for the '<em><b>Monitoring</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__MONITORING = Bpmn2Package.BOUNDARY_EVENT__MONITORING;

	/**
	 * The feature id for the '<em><b>Category Value Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__CATEGORY_VALUE_REF = Bpmn2Package.BOUNDARY_EVENT__CATEGORY_VALUE_REF;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__NAME = Bpmn2Package.BOUNDARY_EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__INCOMING = Bpmn2Package.BOUNDARY_EVENT__INCOMING;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__LANES = Bpmn2Package.BOUNDARY_EVENT__LANES;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__OUTGOING = Bpmn2Package.BOUNDARY_EVENT__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__INCOMING_SECURITY_FLOW = Bpmn2Package.BOUNDARY_EVENT__INCOMING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Outgoing Security Flow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__OUTGOING_SECURITY_FLOW = Bpmn2Package.BOUNDARY_EVENT__OUTGOING_SECURITY_FLOW;

	/**
	 * The feature id for the '<em><b>Incoming Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__INCOMING_CONVERSATION_LINKS = Bpmn2Package.BOUNDARY_EVENT__INCOMING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Outgoing Conversation Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__OUTGOING_CONVERSATION_LINKS = Bpmn2Package.BOUNDARY_EVENT__OUTGOING_CONVERSATION_LINKS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__PROPERTIES = Bpmn2Package.BOUNDARY_EVENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Data Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__DATA_OUTPUTS = Bpmn2Package.BOUNDARY_EVENT__DATA_OUTPUTS;

	/**
	 * The feature id for the '<em><b>Data Output Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__DATA_OUTPUT_ASSOCIATION = Bpmn2Package.BOUNDARY_EVENT__DATA_OUTPUT_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Output Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__OUTPUT_SET = Bpmn2Package.BOUNDARY_EVENT__OUTPUT_SET;

	/**
	 * The feature id for the '<em><b>Event Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__EVENT_DEFINITIONS = Bpmn2Package.BOUNDARY_EVENT__EVENT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Event Definition Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__EVENT_DEFINITION_REFS = Bpmn2Package.BOUNDARY_EVENT__EVENT_DEFINITION_REFS;

	/**
	 * The feature id for the '<em><b>Parallel Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__PARALLEL_MULTIPLE = Bpmn2Package.BOUNDARY_EVENT__PARALLEL_MULTIPLE;

	/**
	 * The feature id for the '<em><b>Attached To Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__ATTACHED_TO_REF = Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF;

	/**
	 * The feature id for the '<em><b>Cancel Activity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT__CANCEL_ACTIVITY = Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY;

	/**
	 * The number of structural features of the '<em>Threat Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_EVENT_FEATURE_COUNT = Bpmn2Package.BOUNDARY_EVENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.aniketos.SecurityExtension <em>Security Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Extension</em>'.
	 * @see org.eclipse.aniketos.SecurityExtension
	 * @generated
	 */
	EClass getSecurityExtension();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.aniketos.SecurityExtension#getIntegrityReq <em>Integrity Req</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Integrity Req</em>'.
	 * @see org.eclipse.aniketos.SecurityExtension#getIntegrityReq()
	 * @see #getSecurityExtension()
	 * @generated
	 */
	EReference getSecurityExtension_IntegrityReq();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.aniketos.SecurityExtension#getTrustworthinessValue <em>Trustworthiness Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trustworthiness Value</em>'.
	 * @see org.eclipse.aniketos.SecurityExtension#getTrustworthinessValue()
	 * @see #getSecurityExtension()
	 * @generated
	 */
	EReference getSecurityExtension_TrustworthinessValue();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.aniketos.SecurityExtension#getConfidentialityReq <em>Confidentiality Req</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Confidentiality Req</em>'.
	 * @see org.eclipse.aniketos.SecurityExtension#getConfidentialityReq()
	 * @see #getSecurityExtension()
	 * @generated
	 */
	EReference getSecurityExtension_ConfidentialityReq();

	/**
	 * Returns the meta object for class '{@link org.eclipse.aniketos.Integrity <em>Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integrity</em>'.
	 * @see org.eclipse.aniketos.Integrity
	 * @generated
	 */
	EClass getIntegrity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.aniketos.Integrity#getSecurityRef <em>Security Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Security Ref</em>'.
	 * @see org.eclipse.aniketos.Integrity#getSecurityRef()
	 * @see #getIntegrity()
	 * @generated
	 */
	EReference getIntegrity_SecurityRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Integrity#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.aniketos.Integrity#getType()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Integrity#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see org.eclipse.aniketos.Integrity#getWith()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_With();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Integrity#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see org.eclipse.aniketos.Integrity#getAlgorithm()
	 * @see #getIntegrity()
	 * @generated
	 */
	EAttribute getIntegrity_Algorithm();

	/**
	 * Returns the meta object for class '{@link org.eclipse.aniketos.Trustworthiness <em>Trustworthiness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trustworthiness</em>'.
	 * @see org.eclipse.aniketos.Trustworthiness
	 * @generated
	 */
	EClass getTrustworthiness();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Trustworthiness#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.aniketos.Trustworthiness#getValue()
	 * @see #getTrustworthiness()
	 * @generated
	 */
	EAttribute getTrustworthiness_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.aniketos.Trustworthiness#getSecurityRef <em>Security Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Security Ref</em>'.
	 * @see org.eclipse.aniketos.Trustworthiness#getSecurityRef()
	 * @see #getTrustworthiness()
	 * @generated
	 */
	EReference getTrustworthiness_SecurityRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.aniketos.Confidentiality <em>Confidentiality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Confidentiality</em>'.
	 * @see org.eclipse.aniketos.Confidentiality
	 * @generated
	 */
	EClass getConfidentiality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Confidentiality#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.aniketos.Confidentiality#getType()
	 * @see #getConfidentiality()
	 * @generated
	 */
	EAttribute getConfidentiality_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.aniketos.Confidentiality#getSecurityRef <em>Security Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Security Ref</em>'.
	 * @see org.eclipse.aniketos.Confidentiality#getSecurityRef()
	 * @see #getConfidentiality()
	 * @generated
	 */
	EReference getConfidentiality_SecurityRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.aniketos.Confidentiality#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see org.eclipse.aniketos.Confidentiality#getAlgorithm()
	 * @see #getConfidentiality()
	 * @generated
	 */
	EAttribute getConfidentiality_Algorithm();

	/**
	 * Returns the meta object for class '{@link org.eclipse.aniketos.ThreatEvent <em>Threat Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Event</em>'.
	 * @see org.eclipse.aniketos.ThreatEvent
	 * @generated
	 */
	EClass getThreatEvent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AniketosFactory getAniketosFactory();

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
		 * The meta object literal for the '{@link org.eclipse.aniketos.impl.SecurityExtensionImpl <em>Security Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.aniketos.impl.SecurityExtensionImpl
		 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getSecurityExtension()
		 * @generated
		 */
		EClass SECURITY_EXTENSION = eINSTANCE.getSecurityExtension();

		/**
		 * The meta object literal for the '<em><b>Integrity Req</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_EXTENSION__INTEGRITY_REQ = eINSTANCE.getSecurityExtension_IntegrityReq();

		/**
		 * The meta object literal for the '<em><b>Trustworthiness Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE = eINSTANCE.getSecurityExtension_TrustworthinessValue();

		/**
		 * The meta object literal for the '<em><b>Confidentiality Req</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECURITY_EXTENSION__CONFIDENTIALITY_REQ = eINSTANCE.getSecurityExtension_ConfidentialityReq();

		/**
		 * The meta object literal for the '{@link org.eclipse.aniketos.impl.IntegrityImpl <em>Integrity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.aniketos.impl.IntegrityImpl
		 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getIntegrity()
		 * @generated
		 */
		EClass INTEGRITY = eINSTANCE.getIntegrity();

		/**
		 * The meta object literal for the '<em><b>Security Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGRITY__SECURITY_REF = eINSTANCE.getIntegrity_SecurityRef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__TYPE = eINSTANCE.getIntegrity_Type();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__WITH = eINSTANCE.getIntegrity_With();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY__ALGORITHM = eINSTANCE.getIntegrity_Algorithm();

		/**
		 * The meta object literal for the '{@link org.eclipse.aniketos.impl.TrustworthinessImpl <em>Trustworthiness</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.aniketos.impl.TrustworthinessImpl
		 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getTrustworthiness()
		 * @generated
		 */
		EClass TRUSTWORTHINESS = eINSTANCE.getTrustworthiness();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRUSTWORTHINESS__VALUE = eINSTANCE.getTrustworthiness_Value();

		/**
		 * The meta object literal for the '<em><b>Security Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUSTWORTHINESS__SECURITY_REF = eINSTANCE.getTrustworthiness_SecurityRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.aniketos.impl.ConfidentialityImpl <em>Confidentiality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.aniketos.impl.ConfidentialityImpl
		 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getConfidentiality()
		 * @generated
		 */
		EClass CONFIDENTIALITY = eINSTANCE.getConfidentiality();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY__TYPE = eINSTANCE.getConfidentiality_Type();

		/**
		 * The meta object literal for the '<em><b>Security Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIDENTIALITY__SECURITY_REF = eINSTANCE.getConfidentiality_SecurityRef();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY__ALGORITHM = eINSTANCE.getConfidentiality_Algorithm();

		/**
		 * The meta object literal for the '{@link org.eclipse.aniketos.impl.ThreatEventImpl <em>Threat Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.aniketos.impl.ThreatEventImpl
		 * @see org.eclipse.aniketos.impl.AniketosPackageImpl#getThreatEvent()
		 * @generated
		 */
		EClass THREAT_EVENT = eINSTANCE.getThreatEvent();

	}

} //AniketosPackage
