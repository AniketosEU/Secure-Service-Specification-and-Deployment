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
package eu.aniketos.mtm.mapping;

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
 * @see eu.aniketos.mtm.mapping.MappingFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface MappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "XSD_mapping_V0.14";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingPackage eINSTANCE = eu.aniketos.mtm.mapping.impl.MappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl <em>Activity Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ActivityTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActivityType()
	 * @generated
	 */
	int ACTIVITY_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Participant</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__PARTICIPANT = 3;

	/**
	 * The feature id for the '<em><b>Trustworthiness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__TRUSTWORTHINESS = 4;

	/**
	 * The feature id for the '<em><b>Integrity</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__INTEGRITY = 5;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__PERMISSION = 6;

	/**
	 * The feature id for the '<em><b>Threat</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__THREAT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__ID = 8;

	/**
	 * The feature id for the '<em><b>Usertype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE__USERTYPE = 9;

	/**
	 * The number of structural features of the '<em>Activity Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_TYPE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ActivityVarImpl <em>Activity Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ActivityVarImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActivityVar()
	 * @generated
	 */
	int ACTIVITY_VAR = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_VAR__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Confidentiality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_VAR__CONFIDENTIALITY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_VAR__ID = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_VAR__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Activity Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_VAR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ActorTypeImpl <em>Actor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ActorTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActorType()
	 * @generated
	 */
	int ACTOR_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Actor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ParticipantTypeImpl <em>Participant Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ParticipantTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getParticipantType()
	 * @generated
	 */
	int PARTICIPANT_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_TYPE__COUNTRY = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_TYPE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Participant Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.BPPTypeImpl <em>BPP Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.BPPTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getBPPType()
	 * @generated
	 */
	int BPP_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPP_TYPE__VALUE = PARTICIPANT_TYPE__VALUE;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPP_TYPE__COUNTRY = PARTICIPANT_TYPE__COUNTRY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPP_TYPE__TYPE = PARTICIPANT_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPP_TYPE__ID = PARTICIPANT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPP Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPP_TYPE_FEATURE_COUNT = PARTICIPANT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.BPRTypeImpl <em>BPR Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.BPRTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getBPRType()
	 * @generated
	 */
	int BPR_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPR_TYPE__VALUE = PARTICIPANT_TYPE__VALUE;

	/**
	 * The feature id for the '<em><b>Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPR_TYPE__COUNTRY = PARTICIPANT_TYPE__COUNTRY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPR_TYPE__TYPE = PARTICIPANT_TYPE__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPR_TYPE__ID = PARTICIPANT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BPR Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPR_TYPE_FEATURE_COUNT = PARTICIPANT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ConfidentialityTypeImpl <em>Confidentiality Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ConfidentialityTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getConfidentialityType()
	 * @generated
	 */
	int CONFIDENTIALITY_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE__ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Commitment ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE__COMMITMENT_ID = 2;

	/**
	 * The number of structural features of the '<em>Confidentiality Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.DocTypeImpl <em>Doc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.DocTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getDocType()
	 * @generated
	 */
	int DOC_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Doc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.DocumentRootImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 7;

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
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MAPPING = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.GoalTypeImpl <em>Goal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.GoalTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getGoalType()
	 * @generated
	 */
	int GOAL_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Goal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.IntegrityTypeImpl <em>Integrity Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.IntegrityTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getIntegrityType()
	 * @generated
	 */
	int INTEGRITY_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__WITH = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__ALGORITHM = 3;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__VARIABLE = 4;

	/**
	 * The number of structural features of the '<em>Integrity Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl <em>Isa Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.IsaTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getIsaType()
	 * @generated
	 */
	int ISA_TYPE = 10;

	/**
	 * The feature id for the '<em><b>BP Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISA_TYPE__BP_ROLE = 0;

	/**
	 * The feature id for the '<em><b>BP Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISA_TYPE__BP_PART = 1;

	/**
	 * The feature id for the '<em><b>SR Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISA_TYPE__SR_ROLE = 2;

	/**
	 * The feature id for the '<em><b>SR Agent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISA_TYPE__SR_AGENT = 3;

	/**
	 * The number of structural features of the '<em>Isa Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISA_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.MappingTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getMappingType()
	 * @generated
	 */
	int MAPPING_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Relates To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__RELATES_TO = 0;

	/**
	 * The feature id for the '<em><b>Represents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__REPRESENTS = 1;

	/**
	 * The feature id for the '<em><b>Is A</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__IS_A = 2;

	/**
	 * The feature id for the '<em><b>Plays</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__PLAYS = 3;

	/**
	 * The feature id for the '<em><b>So DBo DProperties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__SO_DBO_DPROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Threats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE__THREATS = 5;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.PermissionTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getPermissionType()
	 * @generated
	 */
	int PERMISSION_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__ROLE = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__ACTION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE__ID = 3;

	/**
	 * The number of structural features of the '<em>Permission Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMISSION_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.PlaysTypeImpl <em>Plays Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.PlaysTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getPlaysType()
	 * @generated
	 */
	int PLAYS_TYPE = 14;

	/**
	 * The feature id for the '<em><b>BP Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYS_TYPE__BP_PART = 0;

	/**
	 * The feature id for the '<em><b>SR Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYS_TYPE__SR_ROLE = 1;

	/**
	 * The number of structural features of the '<em>Plays Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.RelatesToTypeImpl <em>Relates To Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.RelatesToTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getRelatesToType()
	 * @generated
	 */
	int RELATES_TO_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATES_TO_TYPE__ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATES_TO_TYPE__GOAL = 1;

	/**
	 * The number of structural features of the '<em>Relates To Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATES_TO_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.RepresentsTypeImpl <em>Represents Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.RepresentsTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getRepresentsType()
	 * @generated
	 */
	int REPRESENTS_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTS_TYPE__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTS_TYPE__DOCUMENT = 1;

	/**
	 * The number of structural features of the '<em>Represents Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.SoDBoDTypeImpl <em>So DBo DType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.SoDBoDTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSoDBoDType()
	 * @generated
	 */
	int SO_DBO_DTYPE = 17;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE__PERMISSION = 1;

	/**
	 * The feature id for the '<em><b>Commitment ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE__COMMITMENT_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE__ID = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE__TYPE = 4;

	/**
	 * The number of structural features of the '<em>So DBo DType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SO_DBO_DTYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.SRATypeImpl <em>SRA Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.SRATypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSRAType()
	 * @generated
	 */
	int SRA_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRA_TYPE__VALUE = ACTOR_TYPE__VALUE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRA_TYPE__ID = ACTOR_TYPE__ID;

	/**
	 * The number of structural features of the '<em>SRA Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRA_TYPE_FEATURE_COUNT = ACTOR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.SRRTypeImpl <em>SRR Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.SRRTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSRRType()
	 * @generated
	 */
	int SRR_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRR_TYPE__VALUE = ACTOR_TYPE__VALUE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRR_TYPE__ID = ACTOR_TYPE__ID;

	/**
	 * The number of structural features of the '<em>SRR Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRR_TYPE_FEATURE_COUNT = ACTOR_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl <em>Threats Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getThreatsMapping()
	 * @generated
	 */
	int THREATS_MAPPING = 20;

	/**
	 * The feature id for the '<em><b>BP Threat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREATS_MAPPING__BP_THREAT = 0;

	/**
	 * The feature id for the '<em><b>SR Threat</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREATS_MAPPING__SR_THREAT = 1;

	/**
	 * The number of structural features of the '<em>Threats Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREATS_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.ThreatTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getThreatType()
	 * @generated
	 */
	int THREAT_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Repository ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__REPOSITORY_ID = 3;

	/**
	 * The number of structural features of the '<em>Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.impl.VarTypeImpl <em>Var Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.impl.VarTypeImpl
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getVarType()
	 * @generated
	 */
	int VAR_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TYPE__ID = 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TYPE__ORDER = 2;

	/**
	 * The number of structural features of the '<em>Var Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.TypeType <em>Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 23;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.TypeType1 <em>Type Type1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType1
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType1()
	 * @generated
	 */
	int TYPE_TYPE1 = 24;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.TypeType2 <em>Type Type2</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType2
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType2()
	 * @generated
	 */
	int TYPE_TYPE2 = 25;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.mapping.UsertypeType <em>Usertype Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getUsertypeType()
	 * @generated
	 */
	int USERTYPE_TYPE = 26;

	/**
	 * The meta object id for the '<em>Commitment ID Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getCommitmentIDType()
	 * @generated
	 */
	int COMMITMENT_ID_TYPE = 27;

	/**
	 * The meta object id for the '<em>Commitment ID Type1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getCommitmentIDType1()
	 * @generated
	 */
	int COMMITMENT_ID_TYPE1 = 28;

	/**
	 * The meta object id for the '<em>Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT = 29;


	/**
	 * The meta object id for the '<em>Type Type Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType1
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject1()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT1 = 30;

	/**
	 * The meta object id for the '<em>Type Type Object2</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.TypeType2
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject2()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT2 = 31;

	/**
	 * The meta object id for the '<em>Usertype Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getUsertypeTypeObject()
	 * @generated
	 */
	int USERTYPE_TYPE_OBJECT = 32;

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ActivityType <em>Activity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType
	 * @generated
	 */
	EClass getActivityType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.ActivityType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getMixed()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getValue()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.ActivityType#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getVariable()
	 * @see #getActivityType()
	 * @generated
	 */
	EReference getActivityType_Variable();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.ActivityType#getParticipant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Participant</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getParticipant()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Participant();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness <em>Trustworthiness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trustworthiness</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Trustworthiness();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.ActivityType#getIntegrity <em>Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Integrity</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getIntegrity()
	 * @see #getActivityType()
	 * @generated
	 */
	EReference getActivityType_Integrity();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.ActivityType#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permission</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getPermission()
	 * @see #getActivityType()
	 * @generated
	 */
	EReference getActivityType_Permission();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.ActivityType#getThreat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Threat</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getThreat()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Threat();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getId()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityType#getUsertype <em>Usertype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usertype</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityType#getUsertype()
	 * @see #getActivityType()
	 * @generated
	 */
	EAttribute getActivityType_Usertype();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ActivityVar <em>Activity Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Var</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityVar
	 * @generated
	 */
	EClass getActivityVar();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.ActivityVar#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityVar#getMixed()
	 * @see #getActivityVar()
	 * @generated
	 */
	EAttribute getActivityVar_Mixed();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.ActivityVar#getConfidentiality <em>Confidentiality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Confidentiality</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityVar#getConfidentiality()
	 * @see #getActivityVar()
	 * @generated
	 */
	EReference getActivityVar_Confidentiality();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityVar#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityVar#getId()
	 * @see #getActivityVar()
	 * @generated
	 */
	EAttribute getActivityVar_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActivityVar#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ActivityVar#getType()
	 * @see #getActivityVar()
	 * @generated
	 */
	EAttribute getActivityVar_Type();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ActorType <em>Actor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ActorType
	 * @generated
	 */
	EClass getActorType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActorType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.ActorType#getValue()
	 * @see #getActorType()
	 * @generated
	 */
	EAttribute getActorType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ActorType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.ActorType#getId()
	 * @see #getActorType()
	 * @generated
	 */
	EAttribute getActorType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.BPPType <em>BPP Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPP Type</em>'.
	 * @see eu.aniketos.mtm.mapping.BPPType
	 * @generated
	 */
	EClass getBPPType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.BPPType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.BPPType#getId()
	 * @see #getBPPType()
	 * @generated
	 */
	EAttribute getBPPType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.BPRType <em>BPR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BPR Type</em>'.
	 * @see eu.aniketos.mtm.mapping.BPRType
	 * @generated
	 */
	EClass getBPRType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.BPRType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.BPRType#getId()
	 * @see #getBPRType()
	 * @generated
	 */
	EAttribute getBPRType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ConfidentialityType <em>Confidentiality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Confidentiality Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ConfidentialityType
	 * @generated
	 */
	EClass getConfidentialityType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ConfidentialityType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.ConfidentialityType#getValue()
	 * @see #getConfidentialityType()
	 * @generated
	 */
	EAttribute getConfidentialityType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ConfidentialityType#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see eu.aniketos.mtm.mapping.ConfidentialityType#getAlgorithm()
	 * @see #getConfidentialityType()
	 * @generated
	 */
	EAttribute getConfidentialityType_Algorithm();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ConfidentialityType#getCommitmentID <em>Commitment ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commitment ID</em>'.
	 * @see eu.aniketos.mtm.mapping.ConfidentialityType#getCommitmentID()
	 * @see #getConfidentialityType()
	 * @generated
	 */
	EAttribute getConfidentialityType_CommitmentID();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Type</em>'.
	 * @see eu.aniketos.mtm.mapping.DocType
	 * @generated
	 */
	EClass getDocType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.DocType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.DocType#getValue()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.DocType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.DocType#getId()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see eu.aniketos.mtm.mapping.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.mapping.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see eu.aniketos.mtm.mapping.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.mapping.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see eu.aniketos.mtm.mapping.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.DocumentRoot#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see eu.aniketos.mtm.mapping.DocumentRoot#getMapping()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Mapping();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.GoalType <em>Goal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Type</em>'.
	 * @see eu.aniketos.mtm.mapping.GoalType
	 * @generated
	 */
	EClass getGoalType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.GoalType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.GoalType#getValue()
	 * @see #getGoalType()
	 * @generated
	 */
	EAttribute getGoalType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.GoalType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.GoalType#getId()
	 * @see #getGoalType()
	 * @generated
	 */
	EAttribute getGoalType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.IntegrityType <em>Integrity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integrity Type</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType
	 * @generated
	 */
	EClass getIntegrityType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.IntegrityType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType#getMixed()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EAttribute getIntegrityType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.IntegrityType#getWith <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType#getWith()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EAttribute getIntegrityType_With();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.IntegrityType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType#getType()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EAttribute getIntegrityType_Type();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.IntegrityType#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType#getAlgorithm()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EAttribute getIntegrityType_Algorithm();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.IntegrityType#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see eu.aniketos.mtm.mapping.IntegrityType#getVariable()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EAttribute getIntegrityType_Variable();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.IsaType <em>Isa Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Isa Type</em>'.
	 * @see eu.aniketos.mtm.mapping.IsaType
	 * @generated
	 */
	EClass getIsaType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.IsaType#getBPRole <em>BP Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BP Role</em>'.
	 * @see eu.aniketos.mtm.mapping.IsaType#getBPRole()
	 * @see #getIsaType()
	 * @generated
	 */
	EReference getIsaType_BPRole();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.IsaType#getBPPart <em>BP Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>BP Part</em>'.
	 * @see eu.aniketos.mtm.mapping.IsaType#getBPPart()
	 * @see #getIsaType()
	 * @generated
	 */
	EReference getIsaType_BPPart();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.IsaType#getSRRole <em>SR Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SR Role</em>'.
	 * @see eu.aniketos.mtm.mapping.IsaType#getSRRole()
	 * @see #getIsaType()
	 * @generated
	 */
	EReference getIsaType_SRRole();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.IsaType#getSRAgent <em>SR Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SR Agent</em>'.
	 * @see eu.aniketos.mtm.mapping.IsaType#getSRAgent()
	 * @see #getIsaType()
	 * @generated
	 */
	EReference getIsaType_SRAgent();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.MappingType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType
	 * @generated
	 */
	EClass getMappingType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getRelatesTo <em>Relates To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relates To</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getRelatesTo()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_RelatesTo();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getRepresents <em>Represents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Represents</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getRepresents()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_Represents();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getIsA <em>Is A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is A</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getIsA()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_IsA();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getPlays <em>Plays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plays</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getPlays()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_Plays();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getSoDBoDProperties <em>So DBo DProperties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>So DBo DProperties</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getSoDBoDProperties()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_SoDBoDProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.MappingType#getThreats <em>Threats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threats</em>'.
	 * @see eu.aniketos.mtm.mapping.MappingType#getThreats()
	 * @see #getMappingType()
	 * @generated
	 */
	EReference getMappingType_Threats();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ParticipantType <em>Participant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ParticipantType
	 * @generated
	 */
	EClass getParticipantType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ParticipantType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.ParticipantType#getValue()
	 * @see #getParticipantType()
	 * @generated
	 */
	EAttribute getParticipantType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ParticipantType#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country</em>'.
	 * @see eu.aniketos.mtm.mapping.ParticipantType#getCountry()
	 * @see #getParticipantType()
	 * @generated
	 */
	EAttribute getParticipantType_Country();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ParticipantType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ParticipantType#getType()
	 * @see #getParticipantType()
	 * @generated
	 */
	EAttribute getParticipantType_Type();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.PermissionType <em>Permission Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permission Type</em>'.
	 * @see eu.aniketos.mtm.mapping.PermissionType
	 * @generated
	 */
	EClass getPermissionType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.PermissionType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.PermissionType#getMixed()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Mixed();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.PermissionType#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see eu.aniketos.mtm.mapping.PermissionType#getRole()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Role();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.PermissionType#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see eu.aniketos.mtm.mapping.PermissionType#getAction()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Action();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.PermissionType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.PermissionType#getId()
	 * @see #getPermissionType()
	 * @generated
	 */
	EAttribute getPermissionType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.PlaysType <em>Plays Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plays Type</em>'.
	 * @see eu.aniketos.mtm.mapping.PlaysType
	 * @generated
	 */
	EClass getPlaysType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.PlaysType#getBPPart <em>BP Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BP Part</em>'.
	 * @see eu.aniketos.mtm.mapping.PlaysType#getBPPart()
	 * @see #getPlaysType()
	 * @generated
	 */
	EReference getPlaysType_BPPart();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.PlaysType#getSRRole <em>SR Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SR Role</em>'.
	 * @see eu.aniketos.mtm.mapping.PlaysType#getSRRole()
	 * @see #getPlaysType()
	 * @generated
	 */
	EReference getPlaysType_SRRole();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.RelatesToType <em>Relates To Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relates To Type</em>'.
	 * @see eu.aniketos.mtm.mapping.RelatesToType
	 * @generated
	 */
	EClass getRelatesToType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.RelatesToType#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activity</em>'.
	 * @see eu.aniketos.mtm.mapping.RelatesToType#getActivity()
	 * @see #getRelatesToType()
	 * @generated
	 */
	EReference getRelatesToType_Activity();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.RelatesToType#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.mapping.RelatesToType#getGoal()
	 * @see #getRelatesToType()
	 * @generated
	 */
	EReference getRelatesToType_Goal();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.RepresentsType <em>Represents Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Represents Type</em>'.
	 * @see eu.aniketos.mtm.mapping.RepresentsType
	 * @generated
	 */
	EClass getRepresentsType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.RepresentsType#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see eu.aniketos.mtm.mapping.RepresentsType#getVariable()
	 * @see #getRepresentsType()
	 * @generated
	 */
	EReference getRepresentsType_Variable();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.mapping.RepresentsType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Document</em>'.
	 * @see eu.aniketos.mtm.mapping.RepresentsType#getDocument()
	 * @see #getRepresentsType()
	 * @generated
	 */
	EReference getRepresentsType_Document();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.SoDBoDType <em>So DBo DType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>So DBo DType</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType
	 * @generated
	 */
	EClass getSoDBoDType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.SoDBoDType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType#getMixed()
	 * @see #getSoDBoDType()
	 * @generated
	 */
	EAttribute getSoDBoDType_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.mapping.SoDBoDType#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Permission</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType#getPermission()
	 * @see #getSoDBoDType()
	 * @generated
	 */
	EAttribute getSoDBoDType_Permission();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.SoDBoDType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType#getId()
	 * @see #getSoDBoDType()
	 * @generated
	 */
	EAttribute getSoDBoDType_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.SoDBoDType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType#getType()
	 * @see #getSoDBoDType()
	 * @generated
	 */
	EAttribute getSoDBoDType_Type();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.SoDBoDType#getCommitmentID <em>Commitment ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commitment ID</em>'.
	 * @see eu.aniketos.mtm.mapping.SoDBoDType#getCommitmentID()
	 * @see #getSoDBoDType()
	 * @generated
	 */
	EAttribute getSoDBoDType_CommitmentID();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.SRAType <em>SRA Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRA Type</em>'.
	 * @see eu.aniketos.mtm.mapping.SRAType
	 * @generated
	 */
	EClass getSRAType();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.SRRType <em>SRR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRR Type</em>'.
	 * @see eu.aniketos.mtm.mapping.SRRType
	 * @generated
	 */
	EClass getSRRType();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ThreatsMapping <em>Threats Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threats Mapping</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatsMapping
	 * @generated
	 */
	EClass getThreatsMapping();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.ThreatsMapping#getBPThreat <em>BP Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>BP Threat</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatsMapping#getBPThreat()
	 * @see #getThreatsMapping()
	 * @generated
	 */
	EReference getThreatsMapping_BPThreat();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.mapping.ThreatsMapping#getSRThreat <em>SR Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SR Threat</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatsMapping#getSRThreat()
	 * @see #getThreatsMapping()
	 * @generated
	 */
	EReference getThreatsMapping_SRThreat();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.ThreatType <em>Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatType
	 * @generated
	 */
	EClass getThreatType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ThreatType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatType#getValue()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ThreatType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatType#getId()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ThreatType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatType#getName()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.ThreatType#getRepositoryID <em>Repository ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository ID</em>'.
	 * @see eu.aniketos.mtm.mapping.ThreatType#getRepositoryID()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_RepositoryID();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.mapping.VarType <em>Var Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Type</em>'.
	 * @see eu.aniketos.mtm.mapping.VarType
	 * @generated
	 */
	EClass getVarType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.VarType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.mapping.VarType#getValue()
	 * @see #getVarType()
	 * @generated
	 */
	EAttribute getVarType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.VarType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.mapping.VarType#getId()
	 * @see #getVarType()
	 * @generated
	 */
	EAttribute getVarType_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.mapping.VarType#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see eu.aniketos.mtm.mapping.VarType#getOrder()
	 * @see #getVarType()
	 * @generated
	 */
	EAttribute getVarType_Order();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.mapping.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType
	 * @generated
	 */
	EEnum getTypeType();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.mapping.TypeType1 <em>Type Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type1</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType1
	 * @generated
	 */
	EEnum getTypeType1();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.mapping.TypeType2 <em>Type Type2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type2</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType2
	 * @generated
	 */
	EEnum getTypeType2();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.mapping.UsertypeType <em>Usertype Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Usertype Type</em>'.
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @generated
	 */
	EEnum getUsertypeType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Commitment ID Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Commitment ID Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='commitmentID_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' length='1'"
	 * @generated
	 */
	EDataType getCommitmentIDType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Commitment ID Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Commitment ID Type1</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='commitmentID_._1_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' length='1'"
	 * @generated
	 */
	EDataType getCommitmentIDType1();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.mapping.TypeType <em>Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType
	 * @model instanceClass="eu.aniketos.mtm.mapping.TypeType"
	 *        extendedMetaData="name='type_._type:Object' baseType='type_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.mapping.TypeType1 <em>Type Type Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object1</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType1
	 * @model instanceClass="eu.aniketos.mtm.mapping.TypeType1"
	 *        extendedMetaData="name='type_._1_._type:Object' baseType='type_._1_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject1();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.mapping.TypeType2 <em>Type Type Object2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object2</em>'.
	 * @see eu.aniketos.mtm.mapping.TypeType2
	 * @model instanceClass="eu.aniketos.mtm.mapping.TypeType2"
	 *        extendedMetaData="name='type_._2_._type:Object' baseType='type_._2_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject2();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.mapping.UsertypeType <em>Usertype Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Usertype Type Object</em>'.
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @model instanceClass="eu.aniketos.mtm.mapping.UsertypeType"
	 *        extendedMetaData="name='usertype_._type:Object' baseType='usertype_._type'"
	 * @generated
	 */
	EDataType getUsertypeTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MappingFactory getMappingFactory();

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
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ActivityTypeImpl <em>Activity Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ActivityTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActivityType()
		 * @generated
		 */
		EClass ACTIVITY_TYPE = eINSTANCE.getActivityType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__MIXED = eINSTANCE.getActivityType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__VALUE = eINSTANCE.getActivityType_Value();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_TYPE__VARIABLE = eINSTANCE.getActivityType_Variable();

		/**
		 * The meta object literal for the '<em><b>Participant</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__PARTICIPANT = eINSTANCE.getActivityType_Participant();

		/**
		 * The meta object literal for the '<em><b>Trustworthiness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__TRUSTWORTHINESS = eINSTANCE.getActivityType_Trustworthiness();

		/**
		 * The meta object literal for the '<em><b>Integrity</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_TYPE__INTEGRITY = eINSTANCE.getActivityType_Integrity();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_TYPE__PERMISSION = eINSTANCE.getActivityType_Permission();

		/**
		 * The meta object literal for the '<em><b>Threat</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__THREAT = eINSTANCE.getActivityType_Threat();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__ID = eINSTANCE.getActivityType_Id();

		/**
		 * The meta object literal for the '<em><b>Usertype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_TYPE__USERTYPE = eINSTANCE.getActivityType_Usertype();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ActivityVarImpl <em>Activity Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ActivityVarImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActivityVar()
		 * @generated
		 */
		EClass ACTIVITY_VAR = eINSTANCE.getActivityVar();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_VAR__MIXED = eINSTANCE.getActivityVar_Mixed();

		/**
		 * The meta object literal for the '<em><b>Confidentiality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_VAR__CONFIDENTIALITY = eINSTANCE.getActivityVar_Confidentiality();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_VAR__ID = eINSTANCE.getActivityVar_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_VAR__TYPE = eINSTANCE.getActivityVar_Type();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ActorTypeImpl <em>Actor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ActorTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getActorType()
		 * @generated
		 */
		EClass ACTOR_TYPE = eINSTANCE.getActorType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_TYPE__VALUE = eINSTANCE.getActorType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_TYPE__ID = eINSTANCE.getActorType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.BPPTypeImpl <em>BPP Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.BPPTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getBPPType()
		 * @generated
		 */
		EClass BPP_TYPE = eINSTANCE.getBPPType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPP_TYPE__ID = eINSTANCE.getBPPType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.BPRTypeImpl <em>BPR Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.BPRTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getBPRType()
		 * @generated
		 */
		EClass BPR_TYPE = eINSTANCE.getBPRType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPR_TYPE__ID = eINSTANCE.getBPRType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ConfidentialityTypeImpl <em>Confidentiality Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ConfidentialityTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getConfidentialityType()
		 * @generated
		 */
		EClass CONFIDENTIALITY_TYPE = eINSTANCE.getConfidentialityType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY_TYPE__VALUE = eINSTANCE.getConfidentialityType_Value();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY_TYPE__ALGORITHM = eINSTANCE.getConfidentialityType_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Commitment ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIDENTIALITY_TYPE__COMMITMENT_ID = eINSTANCE.getConfidentialityType_CommitmentID();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.DocTypeImpl <em>Doc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.DocTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getDocType()
		 * @generated
		 */
		EClass DOC_TYPE = eINSTANCE.getDocType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__VALUE = eINSTANCE.getDocType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__ID = eINSTANCE.getDocType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.DocumentRootImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__MAPPING = eINSTANCE.getDocumentRoot_Mapping();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.GoalTypeImpl <em>Goal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.GoalTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getGoalType()
		 * @generated
		 */
		EClass GOAL_TYPE = eINSTANCE.getGoalType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_TYPE__VALUE = eINSTANCE.getGoalType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_TYPE__ID = eINSTANCE.getGoalType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.IntegrityTypeImpl <em>Integrity Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.IntegrityTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getIntegrityType()
		 * @generated
		 */
		EClass INTEGRITY_TYPE = eINSTANCE.getIntegrityType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY_TYPE__MIXED = eINSTANCE.getIntegrityType_Mixed();

		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY_TYPE__WITH = eINSTANCE.getIntegrityType_With();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY_TYPE__TYPE = eINSTANCE.getIntegrityType_Type();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY_TYPE__ALGORITHM = eINSTANCE.getIntegrityType_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGRITY_TYPE__VARIABLE = eINSTANCE.getIntegrityType_Variable();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.IsaTypeImpl <em>Isa Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.IsaTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getIsaType()
		 * @generated
		 */
		EClass ISA_TYPE = eINSTANCE.getIsaType();

		/**
		 * The meta object literal for the '<em><b>BP Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISA_TYPE__BP_ROLE = eINSTANCE.getIsaType_BPRole();

		/**
		 * The meta object literal for the '<em><b>BP Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISA_TYPE__BP_PART = eINSTANCE.getIsaType_BPPart();

		/**
		 * The meta object literal for the '<em><b>SR Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISA_TYPE__SR_ROLE = eINSTANCE.getIsaType_SRRole();

		/**
		 * The meta object literal for the '<em><b>SR Agent</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISA_TYPE__SR_AGENT = eINSTANCE.getIsaType_SRAgent();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.MappingTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.MappingTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getMappingType()
		 * @generated
		 */
		EClass MAPPING_TYPE = eINSTANCE.getMappingType();

		/**
		 * The meta object literal for the '<em><b>Relates To</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__RELATES_TO = eINSTANCE.getMappingType_RelatesTo();

		/**
		 * The meta object literal for the '<em><b>Represents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__REPRESENTS = eINSTANCE.getMappingType_Represents();

		/**
		 * The meta object literal for the '<em><b>Is A</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__IS_A = eINSTANCE.getMappingType_IsA();

		/**
		 * The meta object literal for the '<em><b>Plays</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__PLAYS = eINSTANCE.getMappingType_Plays();

		/**
		 * The meta object literal for the '<em><b>So DBo DProperties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__SO_DBO_DPROPERTIES = eINSTANCE.getMappingType_SoDBoDProperties();

		/**
		 * The meta object literal for the '<em><b>Threats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TYPE__THREATS = eINSTANCE.getMappingType_Threats();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ParticipantTypeImpl <em>Participant Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ParticipantTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getParticipantType()
		 * @generated
		 */
		EClass PARTICIPANT_TYPE = eINSTANCE.getParticipantType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT_TYPE__VALUE = eINSTANCE.getParticipantType_Value();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT_TYPE__COUNTRY = eINSTANCE.getParticipantType_Country();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT_TYPE__TYPE = eINSTANCE.getParticipantType_Type();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.PermissionTypeImpl <em>Permission Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.PermissionTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getPermissionType()
		 * @generated
		 */
		EClass PERMISSION_TYPE = eINSTANCE.getPermissionType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__MIXED = eINSTANCE.getPermissionType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__ROLE = eINSTANCE.getPermissionType_Role();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__ACTION = eINSTANCE.getPermissionType_Action();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMISSION_TYPE__ID = eINSTANCE.getPermissionType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.PlaysTypeImpl <em>Plays Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.PlaysTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getPlaysType()
		 * @generated
		 */
		EClass PLAYS_TYPE = eINSTANCE.getPlaysType();

		/**
		 * The meta object literal for the '<em><b>BP Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYS_TYPE__BP_PART = eINSTANCE.getPlaysType_BPPart();

		/**
		 * The meta object literal for the '<em><b>SR Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYS_TYPE__SR_ROLE = eINSTANCE.getPlaysType_SRRole();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.RelatesToTypeImpl <em>Relates To Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.RelatesToTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getRelatesToType()
		 * @generated
		 */
		EClass RELATES_TO_TYPE = eINSTANCE.getRelatesToType();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATES_TO_TYPE__ACTIVITY = eINSTANCE.getRelatesToType_Activity();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATES_TO_TYPE__GOAL = eINSTANCE.getRelatesToType_Goal();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.RepresentsTypeImpl <em>Represents Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.RepresentsTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getRepresentsType()
		 * @generated
		 */
		EClass REPRESENTS_TYPE = eINSTANCE.getRepresentsType();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTS_TYPE__VARIABLE = eINSTANCE.getRepresentsType_Variable();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTS_TYPE__DOCUMENT = eINSTANCE.getRepresentsType_Document();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.SoDBoDTypeImpl <em>So DBo DType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.SoDBoDTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSoDBoDType()
		 * @generated
		 */
		EClass SO_DBO_DTYPE = eINSTANCE.getSoDBoDType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SO_DBO_DTYPE__MIXED = eINSTANCE.getSoDBoDType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SO_DBO_DTYPE__PERMISSION = eINSTANCE.getSoDBoDType_Permission();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SO_DBO_DTYPE__ID = eINSTANCE.getSoDBoDType_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SO_DBO_DTYPE__TYPE = eINSTANCE.getSoDBoDType_Type();

		/**
		 * The meta object literal for the '<em><b>Commitment ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SO_DBO_DTYPE__COMMITMENT_ID = eINSTANCE.getSoDBoDType_CommitmentID();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.SRATypeImpl <em>SRA Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.SRATypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSRAType()
		 * @generated
		 */
		EClass SRA_TYPE = eINSTANCE.getSRAType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.SRRTypeImpl <em>SRR Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.SRRTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getSRRType()
		 * @generated
		 */
		EClass SRR_TYPE = eINSTANCE.getSRRType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl <em>Threats Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ThreatsMappingImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getThreatsMapping()
		 * @generated
		 */
		EClass THREATS_MAPPING = eINSTANCE.getThreatsMapping();

		/**
		 * The meta object literal for the '<em><b>BP Threat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREATS_MAPPING__BP_THREAT = eINSTANCE.getThreatsMapping_BPThreat();

		/**
		 * The meta object literal for the '<em><b>SR Threat</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREATS_MAPPING__SR_THREAT = eINSTANCE.getThreatsMapping_SRThreat();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.ThreatTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getThreatType()
		 * @generated
		 */
		EClass THREAT_TYPE = eINSTANCE.getThreatType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE__VALUE = eINSTANCE.getThreatType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE__ID = eINSTANCE.getThreatType_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE__NAME = eINSTANCE.getThreatType_Name();

		/**
		 * The meta object literal for the '<em><b>Repository ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAT_TYPE__REPOSITORY_ID = eINSTANCE.getThreatType_RepositoryID();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.impl.VarTypeImpl <em>Var Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.impl.VarTypeImpl
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getVarType()
		 * @generated
		 */
		EClass VAR_TYPE = eINSTANCE.getVarType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_TYPE__VALUE = eINSTANCE.getVarType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_TYPE__ID = eINSTANCE.getVarType_Id();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_TYPE__ORDER = eINSTANCE.getVarType_Order();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.TypeType <em>Type Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType()
		 * @generated
		 */
		EEnum TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.TypeType1 <em>Type Type1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType1
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType1()
		 * @generated
		 */
		EEnum TYPE_TYPE1 = eINSTANCE.getTypeType1();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.TypeType2 <em>Type Type2</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType2
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeType2()
		 * @generated
		 */
		EEnum TYPE_TYPE2 = eINSTANCE.getTypeType2();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.mapping.UsertypeType <em>Usertype Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.UsertypeType
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getUsertypeType()
		 * @generated
		 */
		EEnum USERTYPE_TYPE = eINSTANCE.getUsertypeType();

		/**
		 * The meta object literal for the '<em>Commitment ID Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getCommitmentIDType()
		 * @generated
		 */
		EDataType COMMITMENT_ID_TYPE = eINSTANCE.getCommitmentIDType();

		/**
		 * The meta object literal for the '<em>Commitment ID Type1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getCommitmentIDType1()
		 * @generated
		 */
		EDataType COMMITMENT_ID_TYPE1 = eINSTANCE.getCommitmentIDType1();

		/**
		 * The meta object literal for the '<em>Type Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT = eINSTANCE.getTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Type Type Object1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType1
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject1()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT1 = eINSTANCE.getTypeTypeObject1();

		/**
		 * The meta object literal for the '<em>Type Type Object2</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.TypeType2
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getTypeTypeObject2()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT2 = eINSTANCE.getTypeTypeObject2();

		/**
		 * The meta object literal for the '<em>Usertype Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.mapping.UsertypeType
		 * @see eu.aniketos.mtm.mapping.impl.MappingPackageImpl#getUsertypeTypeObject()
		 * @generated
		 */
		EDataType USERTYPE_TYPE_OBJECT = eINSTANCE.getUsertypeTypeObject();

	}

} //MappingPackage
