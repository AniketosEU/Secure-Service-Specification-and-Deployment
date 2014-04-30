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
package eu.aniketos.mtm.srs;

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
 * @see eu.aniketos.mtm.srs.SrsFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface SrsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "srs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sts-tool-eu/xsd/SRS_1.8.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "srs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SrsPackage eINSTANCE = eu.aniketos.mtm.srs.impl.SrsPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ActorSetTypeMin2Impl <em>Actor Set Type Min2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ActorSetTypeMin2Impl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getActorSetTypeMin2()
	 * @generated
	 */
	int ACTOR_SET_TYPE_MIN2 = 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_SET_TYPE_MIN2__ROLE = 0;

	/**
	 * The number of structural features of the '<em>Actor Set Type Min2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_SET_TYPE_MIN2_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ActorTypeImpl <em>Actor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ActorTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getActorType()
	 * @generated
	 */
	int ACTOR_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Agent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE__AGENT = 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE__ROLE = 1;

	/**
	 * The number of structural features of the '<em>Actor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.AgentTypeImpl <em>Agent Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.AgentTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAgentType()
	 * @generated
	 */
	int AGENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Agent Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.AuthTypeImpl <em>Auth Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.AuthTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAuthType()
	 * @generated
	 */
	int AUTH_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Info Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE__INFO_SET = 0;

	/**
	 * The number of structural features of the '<em>Auth Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.AuthType1Impl <em>Auth Type1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.AuthType1Impl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAuthType1()
	 * @generated
	 */
	int AUTH_TYPE1 = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Info Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__INFO_SET = 2;

	/**
	 * The feature id for the '<em><b>Scope Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__SCOPE_SET = 3;

	/**
	 * The feature id for the '<em><b>Operation Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__OPERATION_SET = 4;

	/**
	 * The feature id for the '<em><b>Transferable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1__TRANSFERABLE = 5;

	/**
	 * The number of structural features of the '<em>Auth Type1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTH_TYPE1_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.AvailabilityTypeImpl <em>Availability Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.AvailabilityTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAvailabilityType()
	 * @generated
	 */
	int AVAILABILITY_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_TYPE__GOAL = 0;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_TYPE__DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Min Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_TYPE__MIN_LEVEL = 2;

	/**
	 * The number of structural features of the '<em>Availability Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABILITY_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.BoDSoDActorTypeImpl <em>Bo DSo DActor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.BoDSoDActorTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getBoDSoDActorType()
	 * @generated
	 */
	int BO_DSO_DACTOR_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Actor Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BO_DSO_DACTOR_TYPE__ACTOR_SET = 0;

	/**
	 * The number of structural features of the '<em>Bo DSo DActor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BO_DSO_DACTOR_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.BoDSoDGoalTypeImpl <em>Bo DSo DGoal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.BoDSoDGoalTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getBoDSoDGoalType()
	 * @generated
	 */
	int BO_DSO_DGOAL_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BO_DSO_DGOAL_TYPE__GOAL_SET = 0;

	/**
	 * The number of structural features of the '<em>Bo DSo DGoal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BO_DSO_DGOAL_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl <em>Commitment Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.CommitmentTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getCommitmentType()
	 * @generated
	 */
	int COMMITMENT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Debtor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE__DEBTOR = 0;

	/**
	 * The feature id for the '<em><b>Creditor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE__CREDITOR = 1;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE__PRECONDITION = 2;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE__POSTCONDITION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE__ID = 4;

	/**
	 * The number of structural features of the '<em>Commitment Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMITMENT_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ConfidentialityTypeImpl <em>Confidentiality Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ConfidentialityTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getConfidentialityType()
	 * @generated
	 */
	int CONFIDENTIALITY_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE__DOCUMENT = 0;

	/**
	 * The number of structural features of the '<em>Confidentiality Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIDENTIALITY_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.DelTypeImpl <em>Del Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.DelTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDelType()
	 * @generated
	 */
	int DEL_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEL_TYPE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEL_TYPE__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEL_TYPE__GOAL_SET = 2;

	/**
	 * The feature id for the '<em><b>Transferable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEL_TYPE__TRANSFERABLE = 3;

	/**
	 * The number of structural features of the '<em>Del Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEL_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.DocTypeImpl <em>Doc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.DocTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDocType()
	 * @generated
	 */
	int DOC_TYPE = 11;

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
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.DocumentRootImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 12;

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
	 * The feature id for the '<em><b>Sec Req Spe</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SEC_REQ_SPE = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.GoalSetTypeImpl <em>Goal Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.GoalSetTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalSetType()
	 * @generated
	 */
	int GOAL_SET_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SET_TYPE__GOAL = 0;

	/**
	 * The number of structural features of the '<em>Goal Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SET_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.GoalSetTypeMin2Impl <em>Goal Set Type Min2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.GoalSetTypeMin2Impl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalSetTypeMin2()
	 * @generated
	 */
	int GOAL_SET_TYPE_MIN2 = 14;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SET_TYPE_MIN2__GOAL = 0;

	/**
	 * The number of structural features of the '<em>Goal Set Type Min2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SET_TYPE_MIN2_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.GoalTypeImpl <em>Goal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.GoalTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalType()
	 * @generated
	 */
	int GOAL_TYPE = 15;

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
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.InfoDocTypeImpl <em>Info Doc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.InfoDocTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoDocType()
	 * @generated
	 */
	int INFO_DOC_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_DOC_TYPE__DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_DOC_TYPE__INFORMATION = 1;

	/**
	 * The number of structural features of the '<em>Info Doc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_DOC_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.InfoSetTypeImpl <em>Info Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.InfoSetTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoSetType()
	 * @generated
	 */
	int INFO_SET_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SET_TYPE__INFORMATION = 0;

	/**
	 * The number of structural features of the '<em>Info Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SET_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.InfoTypeImpl <em>Info Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.InfoTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoType()
	 * @generated
	 */
	int INFO_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Info Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.IntegrityTypeImpl <em>Integrity Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.IntegrityTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getIntegrityType()
	 * @generated
	 */
	int INTEGRITY_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE__DOCUMENT = 0;

	/**
	 * The number of structural features of the '<em>Integrity Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGRITY_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.KBTypeImpl <em>KB Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.KBTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getKBType()
	 * @generated
	 */
	int KB_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Part Of</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KB_TYPE__PART_OF = 0;

	/**
	 * The feature id for the '<em><b>Tangible By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KB_TYPE__TANGIBLE_BY = 1;

	/**
	 * The feature id for the '<em><b>Owns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KB_TYPE__OWNS = 2;

	/**
	 * The feature id for the '<em><b>Fully Authorized</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KB_TYPE__FULLY_AUTHORIZED = 3;

	/**
	 * The number of structural features of the '<em>KB Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KB_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.NDTypeImpl <em>ND Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.NDTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNDType()
	 * @generated
	 */
	int ND_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ND_TYPE__GOAL_SET = 0;

	/**
	 * The number of structural features of the '<em>ND Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ND_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.NRTypeImpl <em>NR Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.NRTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNRType()
	 * @generated
	 */
	int NR_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NR_TYPE__GOAL_SET = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NR_TYPE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>NR Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NR_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.NTKTypeImpl <em>NTK Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.NTKTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNTKType()
	 * @generated
	 */
	int NTK_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTK_TYPE__GOAL_SET = 0;

	/**
	 * The number of structural features of the '<em>NTK Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NTK_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.OperationSetTypeImpl <em>Operation Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.OperationSetTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationSetType()
	 * @generated
	 */
	int OPERATION_SET_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET_TYPE__OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Operation Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.OwnsTypeImpl <em>Owns Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.OwnsTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOwnsType()
	 * @generated
	 */
	int OWNS_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNS_TYPE__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNS_TYPE__INFORMATION = 1;

	/**
	 * The number of structural features of the '<em>Owns Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNS_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.PartOfTypeImpl <em>Part Of Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.PartOfTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPartOfType()
	 * @generated
	 */
	int PART_OF_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OF_TYPE__CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OF_TYPE__CONTENT = 1;

	/**
	 * The number of structural features of the '<em>Part Of Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OF_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.PostTypeImpl <em>Post Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.PostTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPostType()
	 * @generated
	 */
	int POST_TYPE = 27;

	/**
	 * The feature id for the '<em><b>Non Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_DELEGATION = 0;

	/**
	 * The feature id for the '<em><b>Non Repudiation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_REPUDIATION = 1;

	/**
	 * The feature id for the '<em><b>Redundancy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__REDUNDANCY = 2;

	/**
	 * The feature id for the '<em><b>Need To Know</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NEED_TO_KNOW = 3;

	/**
	 * The feature id for the '<em><b>Non Disclosure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_DISCLOSURE = 4;

	/**
	 * The feature id for the '<em><b>Non Modification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_MODIFICATION = 5;

	/**
	 * The feature id for the '<em><b>Non Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_USAGE = 6;

	/**
	 * The feature id for the '<em><b>Non Production</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NON_PRODUCTION = 7;

	/**
	 * The feature id for the '<em><b>Play Both</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__PLAY_BOTH = 8;

	/**
	 * The feature id for the '<em><b>Not Play Both</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NOT_PLAY_BOTH = 9;

	/**
	 * The feature id for the '<em><b>Achieve In Combination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__ACHIEVE_IN_COMBINATION = 10;

	/**
	 * The feature id for the '<em><b>Not Achieve In Combination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__NOT_ACHIEVE_IN_COMBINATION = 11;

	/**
	 * The feature id for the '<em><b>Integrity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__INTEGRITY = 12;

	/**
	 * The feature id for the '<em><b>Availability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__AVAILABILITY = 13;

	/**
	 * The feature id for the '<em><b>Confidentiality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__CONFIDENTIALITY = 14;

	/**
	 * The feature id for the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE__DELEGATION = 15;

	/**
	 * The number of structural features of the '<em>Post Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POST_TYPE_FEATURE_COUNT = 16;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.PreTypeImpl <em>Pre Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.PreTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPreType()
	 * @generated
	 */
	int PRE_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_TYPE__DELEGATION = 0;

	/**
	 * The feature id for the '<em><b>Authorization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_TYPE__AUTHORIZATION = 1;

	/**
	 * The feature id for the '<em><b>Provision</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_TYPE__PROVISION = 2;

	/**
	 * The feature id for the '<em><b>Trustworthiness</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_TYPE__TRUSTWORTHINESS = 3;

	/**
	 * The number of structural features of the '<em>Pre Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ProvTypeImpl <em>Prov Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ProvTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getProvType()
	 * @generated
	 */
	int PROV_TYPE = 29;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROV_TYPE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROV_TYPE__DESTINATION = 1;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROV_TYPE__DOCUMENT = 2;

	/**
	 * The number of structural features of the '<em>Prov Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROV_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.RedTypeImpl <em>Red Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.RedTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getRedType()
	 * @generated
	 */
	int RED_TYPE = 30;

	/**
	 * The feature id for the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_TYPE__GOAL_SET = 0;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_TYPE__MULTIPLICITY = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_TYPE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Red Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RED_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.RoleTypeImpl <em>Role Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.RoleTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getRoleType()
	 * @generated
	 */
	int ROLE_TYPE = 31;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TYPE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TYPE__ID = 1;

	/**
	 * The number of structural features of the '<em>Role Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl <em>Sec Req Spe Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getSecReqSpeType()
	 * @generated
	 */
	int SEC_REQ_SPE_TYPE = 32;

	/**
	 * The feature id for the '<em><b>Commitment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEC_REQ_SPE_TYPE__COMMITMENT = 0;

	/**
	 * The feature id for the '<em><b>Knowledge Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE = 1;

	/**
	 * The feature id for the '<em><b>Threat List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEC_REQ_SPE_TYPE__THREAT_LIST = 2;

	/**
	 * The number of structural features of the '<em>Sec Req Spe Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEC_REQ_SPE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.TangibleByTypeImpl <em>Tangible By Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.TangibleByTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTangibleByType()
	 * @generated
	 */
	int TANGIBLE_BY_TYPE = 33;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANGIBLE_BY_TYPE__INFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANGIBLE_BY_TYPE__DOCUMENT = 1;

	/**
	 * The number of structural features of the '<em>Tangible By Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TANGIBLE_BY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ThreatListTypeImpl <em>Threat List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ThreatListTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getThreatListType()
	 * @generated
	 */
	int THREAT_LIST_TYPE = 34;

	/**
	 * The feature id for the '<em><b>Threat</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_LIST_TYPE__THREAT = 0;

	/**
	 * The number of structural features of the '<em>Threat List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_LIST_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.ThreatTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getThreatType()
	 * @generated
	 */
	int THREAT_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Document</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__DOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__GOAL = 2;

	/**
	 * The feature id for the '<em><b>Delegation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__DELEGATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__ID = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__NAME = 5;

	/**
	 * The feature id for the '<em><b>Repository ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE__REPOSITORY_ID = 6;

	/**
	 * The number of structural features of the '<em>Threat Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAT_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.impl.TrustworthinessTypeImpl <em>Trustworthiness Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.impl.TrustworthinessTypeImpl
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTrustworthinessType()
	 * @generated
	 */
	int TRUSTWORTHINESS_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_TYPE__DESTINATION = 0;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_TYPE__GOAL = 1;

	/**
	 * The feature id for the '<em><b>Min Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_TYPE__MIN_LEVEL = 2;

	/**
	 * The number of structural features of the '<em>Trustworthiness Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUSTWORTHINESS_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.MultiplicityType <em>Multiplicity Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.MultiplicityType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getMultiplicityType()
	 * @generated
	 */
	int MULTIPLICITY_TYPE = 37;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.OperationType <em>Operation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.OperationType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationType()
	 * @generated
	 */
	int OPERATION_TYPE = 38;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.TypeType <em>Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.TypeType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 39;

	/**
	 * The meta object id for the '{@link eu.aniketos.mtm.srs.TypeType1 <em>Type Type1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.TypeType1
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeType1()
	 * @generated
	 */
	int TYPE_TYPE1 = 40;

	/**
	 * The meta object id for the '<em>Multiplicity Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.MultiplicityType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getMultiplicityTypeObject()
	 * @generated
	 */
	int MULTIPLICITY_TYPE_OBJECT = 41;

	/**
	 * The meta object id for the '<em>Operation Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.OperationType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationTypeObject()
	 * @generated
	 */
	int OPERATION_TYPE_OBJECT = 42;

	/**
	 * The meta object id for the '<em>Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.TypeType
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeTypeObject()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT = 43;

	/**
	 * The meta object id for the '<em>Type Type Object1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.aniketos.mtm.srs.TypeType1
	 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeTypeObject1()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT1 = 44;


	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ActorSetTypeMin2 <em>Actor Set Type Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Set Type Min2</em>'.
	 * @see eu.aniketos.mtm.srs.ActorSetTypeMin2
	 * @generated
	 */
	EClass getActorSetTypeMin2();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ActorSetTypeMin2#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Role</em>'.
	 * @see eu.aniketos.mtm.srs.ActorSetTypeMin2#getRole()
	 * @see #getActorSetTypeMin2()
	 * @generated
	 */
	EReference getActorSetTypeMin2_Role();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ActorType <em>Actor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Type</em>'.
	 * @see eu.aniketos.mtm.srs.ActorType
	 * @generated
	 */
	EClass getActorType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ActorType#getAgent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Agent</em>'.
	 * @see eu.aniketos.mtm.srs.ActorType#getAgent()
	 * @see #getActorType()
	 * @generated
	 */
	EReference getActorType_Agent();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ActorType#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role</em>'.
	 * @see eu.aniketos.mtm.srs.ActorType#getRole()
	 * @see #getActorType()
	 * @generated
	 */
	EReference getActorType_Role();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.AgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent Type</em>'.
	 * @see eu.aniketos.mtm.srs.AgentType
	 * @generated
	 */
	EClass getAgentType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.AgentType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.srs.AgentType#getValue()
	 * @see #getAgentType()
	 * @generated
	 */
	EAttribute getAgentType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.AgentType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.AgentType#getId()
	 * @see #getAgentType()
	 * @generated
	 */
	EAttribute getAgentType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.AuthType <em>Auth Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auth Type</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType
	 * @generated
	 */
	EClass getAuthType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType#getInfoSet <em>Info Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Info Set</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType#getInfoSet()
	 * @see #getAuthType()
	 * @generated
	 */
	EReference getAuthType_InfoSet();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.AuthType1 <em>Auth Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auth Type1</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1
	 * @generated
	 */
	EClass getAuthType1();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType1#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getSource()
	 * @see #getAuthType1()
	 * @generated
	 */
	EReference getAuthType1_Source();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType1#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getDestination()
	 * @see #getAuthType1()
	 * @generated
	 */
	EReference getAuthType1_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType1#getInfoSet <em>Info Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Info Set</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getInfoSet()
	 * @see #getAuthType1()
	 * @generated
	 */
	EReference getAuthType1_InfoSet();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType1#getScopeSet <em>Scope Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope Set</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getScopeSet()
	 * @see #getAuthType1()
	 * @generated
	 */
	EReference getAuthType1_ScopeSet();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AuthType1#getOperationSet <em>Operation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Set</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getOperationSet()
	 * @see #getAuthType1()
	 * @generated
	 */
	EReference getAuthType1_OperationSet();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.AuthType1#getTransferable <em>Transferable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transferable</em>'.
	 * @see eu.aniketos.mtm.srs.AuthType1#getTransferable()
	 * @see #getAuthType1()
	 * @generated
	 */
	EAttribute getAuthType1_Transferable();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.AvailabilityType <em>Availability Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Availability Type</em>'.
	 * @see eu.aniketos.mtm.srs.AvailabilityType
	 * @generated
	 */
	EClass getAvailabilityType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AvailabilityType#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.srs.AvailabilityType#getGoal()
	 * @see #getAvailabilityType()
	 * @generated
	 */
	EReference getAvailabilityType_Goal();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.AvailabilityType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.AvailabilityType#getDocument()
	 * @see #getAvailabilityType()
	 * @generated
	 */
	EReference getAvailabilityType_Document();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.AvailabilityType#getMinLevel <em>Min Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Level</em>'.
	 * @see eu.aniketos.mtm.srs.AvailabilityType#getMinLevel()
	 * @see #getAvailabilityType()
	 * @generated
	 */
	EAttribute getAvailabilityType_MinLevel();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.BoDSoDActorType <em>Bo DSo DActor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bo DSo DActor Type</em>'.
	 * @see eu.aniketos.mtm.srs.BoDSoDActorType
	 * @generated
	 */
	EClass getBoDSoDActorType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.BoDSoDActorType#getActorSet <em>Actor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actor Set</em>'.
	 * @see eu.aniketos.mtm.srs.BoDSoDActorType#getActorSet()
	 * @see #getBoDSoDActorType()
	 * @generated
	 */
	EReference getBoDSoDActorType_ActorSet();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.BoDSoDGoalType <em>Bo DSo DGoal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bo DSo DGoal Type</em>'.
	 * @see eu.aniketos.mtm.srs.BoDSoDGoalType
	 * @generated
	 */
	EClass getBoDSoDGoalType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.BoDSoDGoalType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.BoDSoDGoalType#getGoalSet()
	 * @see #getBoDSoDGoalType()
	 * @generated
	 */
	EReference getBoDSoDGoalType_GoalSet();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.CommitmentType <em>Commitment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Commitment Type</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType
	 * @generated
	 */
	EClass getCommitmentType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.CommitmentType#getDebtor <em>Debtor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Debtor</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType#getDebtor()
	 * @see #getCommitmentType()
	 * @generated
	 */
	EReference getCommitmentType_Debtor();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.CommitmentType#getCreditor <em>Creditor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Creditor</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType#getCreditor()
	 * @see #getCommitmentType()
	 * @generated
	 */
	EReference getCommitmentType_Creditor();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.CommitmentType#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Precondition</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType#getPrecondition()
	 * @see #getCommitmentType()
	 * @generated
	 */
	EReference getCommitmentType_Precondition();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.CommitmentType#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Postcondition</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType#getPostcondition()
	 * @see #getCommitmentType()
	 * @generated
	 */
	EReference getCommitmentType_Postcondition();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.CommitmentType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.CommitmentType#getId()
	 * @see #getCommitmentType()
	 * @generated
	 */
	EAttribute getCommitmentType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ConfidentialityType <em>Confidentiality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Confidentiality Type</em>'.
	 * @see eu.aniketos.mtm.srs.ConfidentialityType
	 * @generated
	 */
	EClass getConfidentialityType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ConfidentialityType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.ConfidentialityType#getDocument()
	 * @see #getConfidentialityType()
	 * @generated
	 */
	EReference getConfidentialityType_Document();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.DelType <em>Del Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Del Type</em>'.
	 * @see eu.aniketos.mtm.srs.DelType
	 * @generated
	 */
	EClass getDelType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.DelType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see eu.aniketos.mtm.srs.DelType#getSource()
	 * @see #getDelType()
	 * @generated
	 */
	EReference getDelType_Source();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.DelType#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see eu.aniketos.mtm.srs.DelType#getDestination()
	 * @see #getDelType()
	 * @generated
	 */
	EReference getDelType_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.DelType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.DelType#getGoalSet()
	 * @see #getDelType()
	 * @generated
	 */
	EReference getDelType_GoalSet();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.DelType#getTransferable <em>Transferable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transferable</em>'.
	 * @see eu.aniketos.mtm.srs.DelType#getTransferable()
	 * @see #getDelType()
	 * @generated
	 */
	EAttribute getDelType_Transferable();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Type</em>'.
	 * @see eu.aniketos.mtm.srs.DocType
	 * @generated
	 */
	EClass getDocType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.DocType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.srs.DocType#getValue()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.DocType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.DocType#getId()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see eu.aniketos.mtm.srs.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.srs.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see eu.aniketos.mtm.srs.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.srs.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see eu.aniketos.mtm.srs.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link eu.aniketos.mtm.srs.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see eu.aniketos.mtm.srs.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.DocumentRoot#getSecReqSpe <em>Sec Req Spe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sec Req Spe</em>'.
	 * @see eu.aniketos.mtm.srs.DocumentRoot#getSecReqSpe()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_SecReqSpe();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.GoalSetType <em>Goal Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Set Type</em>'.
	 * @see eu.aniketos.mtm.srs.GoalSetType
	 * @generated
	 */
	EClass getGoalSetType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.GoalSetType#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.srs.GoalSetType#getGoal()
	 * @see #getGoalSetType()
	 * @generated
	 */
	EReference getGoalSetType_Goal();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.GoalSetTypeMin2 <em>Goal Set Type Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Set Type Min2</em>'.
	 * @see eu.aniketos.mtm.srs.GoalSetTypeMin2
	 * @generated
	 */
	EClass getGoalSetTypeMin2();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.GoalSetTypeMin2#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.srs.GoalSetTypeMin2#getGoal()
	 * @see #getGoalSetTypeMin2()
	 * @generated
	 */
	EReference getGoalSetTypeMin2_Goal();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.GoalType <em>Goal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Type</em>'.
	 * @see eu.aniketos.mtm.srs.GoalType
	 * @generated
	 */
	EClass getGoalType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.GoalType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.srs.GoalType#getValue()
	 * @see #getGoalType()
	 * @generated
	 */
	EAttribute getGoalType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.GoalType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.GoalType#getId()
	 * @see #getGoalType()
	 * @generated
	 */
	EAttribute getGoalType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.InfoDocType <em>Info Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info Doc Type</em>'.
	 * @see eu.aniketos.mtm.srs.InfoDocType
	 * @generated
	 */
	EClass getInfoDocType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.InfoDocType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.InfoDocType#getDocument()
	 * @see #getInfoDocType()
	 * @generated
	 */
	EReference getInfoDocType_Document();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.InfoDocType#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see eu.aniketos.mtm.srs.InfoDocType#getInformation()
	 * @see #getInfoDocType()
	 * @generated
	 */
	EReference getInfoDocType_Information();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.InfoSetType <em>Info Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info Set Type</em>'.
	 * @see eu.aniketos.mtm.srs.InfoSetType
	 * @generated
	 */
	EClass getInfoSetType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.InfoSetType#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Information</em>'.
	 * @see eu.aniketos.mtm.srs.InfoSetType#getInformation()
	 * @see #getInfoSetType()
	 * @generated
	 */
	EReference getInfoSetType_Information();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.InfoType <em>Info Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info Type</em>'.
	 * @see eu.aniketos.mtm.srs.InfoType
	 * @generated
	 */
	EClass getInfoType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.InfoType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.srs.InfoType#getValue()
	 * @see #getInfoType()
	 * @generated
	 */
	EAttribute getInfoType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.InfoType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.InfoType#getId()
	 * @see #getInfoType()
	 * @generated
	 */
	EAttribute getInfoType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.IntegrityType <em>Integrity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integrity Type</em>'.
	 * @see eu.aniketos.mtm.srs.IntegrityType
	 * @generated
	 */
	EClass getIntegrityType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.IntegrityType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.IntegrityType#getDocument()
	 * @see #getIntegrityType()
	 * @generated
	 */
	EReference getIntegrityType_Document();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.KBType <em>KB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>KB Type</em>'.
	 * @see eu.aniketos.mtm.srs.KBType
	 * @generated
	 */
	EClass getKBType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.KBType#getPartOf <em>Part Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part Of</em>'.
	 * @see eu.aniketos.mtm.srs.KBType#getPartOf()
	 * @see #getKBType()
	 * @generated
	 */
	EReference getKBType_PartOf();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.KBType#getTangibleBy <em>Tangible By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tangible By</em>'.
	 * @see eu.aniketos.mtm.srs.KBType#getTangibleBy()
	 * @see #getKBType()
	 * @generated
	 */
	EReference getKBType_TangibleBy();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.KBType#getOwns <em>Owns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns</em>'.
	 * @see eu.aniketos.mtm.srs.KBType#getOwns()
	 * @see #getKBType()
	 * @generated
	 */
	EReference getKBType_Owns();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.KBType#getFullyAuthorized <em>Fully Authorized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fully Authorized</em>'.
	 * @see eu.aniketos.mtm.srs.KBType#getFullyAuthorized()
	 * @see #getKBType()
	 * @generated
	 */
	EReference getKBType_FullyAuthorized();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.NDType <em>ND Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ND Type</em>'.
	 * @see eu.aniketos.mtm.srs.NDType
	 * @generated
	 */
	EClass getNDType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.NDType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.NDType#getGoalSet()
	 * @see #getNDType()
	 * @generated
	 */
	EReference getNDType_GoalSet();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.NRType <em>NR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NR Type</em>'.
	 * @see eu.aniketos.mtm.srs.NRType
	 * @generated
	 */
	EClass getNRType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.NRType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.NRType#getGoalSet()
	 * @see #getNRType()
	 * @generated
	 */
	EReference getNRType_GoalSet();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.NRType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.srs.NRType#getType()
	 * @see #getNRType()
	 * @generated
	 */
	EAttribute getNRType_Type();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.NTKType <em>NTK Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NTK Type</em>'.
	 * @see eu.aniketos.mtm.srs.NTKType
	 * @generated
	 */
	EClass getNTKType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.NTKType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.NTKType#getGoalSet()
	 * @see #getNTKType()
	 * @generated
	 */
	EReference getNTKType_GoalSet();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.OperationSetType <em>Operation Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Set Type</em>'.
	 * @see eu.aniketos.mtm.srs.OperationSetType
	 * @generated
	 */
	EClass getOperationSetType();

	/**
	 * Returns the meta object for the attribute list '{@link eu.aniketos.mtm.srs.OperationSetType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operation</em>'.
	 * @see eu.aniketos.mtm.srs.OperationSetType#getOperation()
	 * @see #getOperationSetType()
	 * @generated
	 */
	EAttribute getOperationSetType_Operation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.OwnsType <em>Owns Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Owns Type</em>'.
	 * @see eu.aniketos.mtm.srs.OwnsType
	 * @generated
	 */
	EClass getOwnsType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.OwnsType#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actor</em>'.
	 * @see eu.aniketos.mtm.srs.OwnsType#getActor()
	 * @see #getOwnsType()
	 * @generated
	 */
	EReference getOwnsType_Actor();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.OwnsType#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see eu.aniketos.mtm.srs.OwnsType#getInformation()
	 * @see #getOwnsType()
	 * @generated
	 */
	EReference getOwnsType_Information();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.PartOfType <em>Part Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part Of Type</em>'.
	 * @see eu.aniketos.mtm.srs.PartOfType
	 * @generated
	 */
	EClass getPartOfType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PartOfType#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see eu.aniketos.mtm.srs.PartOfType#getContainer()
	 * @see #getPartOfType()
	 * @generated
	 */
	EReference getPartOfType_Container();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PartOfType#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see eu.aniketos.mtm.srs.PartOfType#getContent()
	 * @see #getPartOfType()
	 * @generated
	 */
	EReference getPartOfType_Content();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.PostType <em>Post Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Post Type</em>'.
	 * @see eu.aniketos.mtm.srs.PostType
	 * @generated
	 */
	EClass getPostType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonDelegation <em>Non Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Delegation</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonDelegation()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonDelegation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonRepudiation <em>Non Repudiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Repudiation</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonRepudiation()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonRepudiation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getRedundancy <em>Redundancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Redundancy</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getRedundancy()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_Redundancy();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNeedToKnow <em>Need To Know</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Need To Know</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNeedToKnow()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NeedToKnow();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonDisclosure <em>Non Disclosure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Disclosure</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonDisclosure()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonDisclosure();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonModification <em>Non Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Modification</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonModification()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonModification();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonUsage <em>Non Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Usage</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonUsage()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonUsage();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNonProduction <em>Non Production</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Non Production</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNonProduction()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NonProduction();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getPlayBoth <em>Play Both</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Play Both</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getPlayBoth()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_PlayBoth();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNotPlayBoth <em>Not Play Both</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Not Play Both</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNotPlayBoth()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NotPlayBoth();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getAchieveInCombination <em>Achieve In Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Achieve In Combination</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getAchieveInCombination()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_AchieveInCombination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getNotAchieveInCombination <em>Not Achieve In Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Not Achieve In Combination</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getNotAchieveInCombination()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_NotAchieveInCombination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getIntegrity <em>Integrity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Integrity</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getIntegrity()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_Integrity();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getAvailability <em>Availability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Availability</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getAvailability()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_Availability();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getConfidentiality <em>Confidentiality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Confidentiality</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getConfidentiality()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_Confidentiality();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PostType#getDelegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delegation</em>'.
	 * @see eu.aniketos.mtm.srs.PostType#getDelegation()
	 * @see #getPostType()
	 * @generated
	 */
	EReference getPostType_Delegation();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.PreType <em>Pre Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Type</em>'.
	 * @see eu.aniketos.mtm.srs.PreType
	 * @generated
	 */
	EClass getPreType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PreType#getDelegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delegation</em>'.
	 * @see eu.aniketos.mtm.srs.PreType#getDelegation()
	 * @see #getPreType()
	 * @generated
	 */
	EReference getPreType_Delegation();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PreType#getAuthorization <em>Authorization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Authorization</em>'.
	 * @see eu.aniketos.mtm.srs.PreType#getAuthorization()
	 * @see #getPreType()
	 * @generated
	 */
	EReference getPreType_Authorization();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PreType#getProvision <em>Provision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Provision</em>'.
	 * @see eu.aniketos.mtm.srs.PreType#getProvision()
	 * @see #getPreType()
	 * @generated
	 */
	EReference getPreType_Provision();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.PreType#getTrustworthiness <em>Trustworthiness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trustworthiness</em>'.
	 * @see eu.aniketos.mtm.srs.PreType#getTrustworthiness()
	 * @see #getPreType()
	 * @generated
	 */
	EReference getPreType_Trustworthiness();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ProvType <em>Prov Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prov Type</em>'.
	 * @see eu.aniketos.mtm.srs.ProvType
	 * @generated
	 */
	EClass getProvType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ProvType#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see eu.aniketos.mtm.srs.ProvType#getSource()
	 * @see #getProvType()
	 * @generated
	 */
	EReference getProvType_Source();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ProvType#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see eu.aniketos.mtm.srs.ProvType#getDestination()
	 * @see #getProvType()
	 * @generated
	 */
	EReference getProvType_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.ProvType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.ProvType#getDocument()
	 * @see #getProvType()
	 * @generated
	 */
	EReference getProvType_Document();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.RedType <em>Red Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Red Type</em>'.
	 * @see eu.aniketos.mtm.srs.RedType
	 * @generated
	 */
	EClass getRedType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.RedType#getGoalSet <em>Goal Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal Set</em>'.
	 * @see eu.aniketos.mtm.srs.RedType#getGoalSet()
	 * @see #getRedType()
	 * @generated
	 */
	EReference getRedType_GoalSet();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.RedType#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see eu.aniketos.mtm.srs.RedType#getMultiplicity()
	 * @see #getRedType()
	 * @generated
	 */
	EAttribute getRedType_Multiplicity();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.RedType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.aniketos.mtm.srs.RedType#getType()
	 * @see #getRedType()
	 * @generated
	 */
	EAttribute getRedType_Type();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.RoleType <em>Role Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Type</em>'.
	 * @see eu.aniketos.mtm.srs.RoleType
	 * @generated
	 */
	EClass getRoleType();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.RoleType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.aniketos.mtm.srs.RoleType#getValue()
	 * @see #getRoleType()
	 * @generated
	 */
	EAttribute getRoleType_Value();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.RoleType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.RoleType#getId()
	 * @see #getRoleType()
	 * @generated
	 */
	EAttribute getRoleType_Id();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.SecReqSpeType <em>Sec Req Spe Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sec Req Spe Type</em>'.
	 * @see eu.aniketos.mtm.srs.SecReqSpeType
	 * @generated
	 */
	EClass getSecReqSpeType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.SecReqSpeType#getCommitment <em>Commitment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commitment</em>'.
	 * @see eu.aniketos.mtm.srs.SecReqSpeType#getCommitment()
	 * @see #getSecReqSpeType()
	 * @generated
	 */
	EReference getSecReqSpeType_Commitment();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.SecReqSpeType#getKnowledgeBase <em>Knowledge Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Knowledge Base</em>'.
	 * @see eu.aniketos.mtm.srs.SecReqSpeType#getKnowledgeBase()
	 * @see #getSecReqSpeType()
	 * @generated
	 */
	EReference getSecReqSpeType_KnowledgeBase();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.SecReqSpeType#getThreatList <em>Threat List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Threat List</em>'.
	 * @see eu.aniketos.mtm.srs.SecReqSpeType#getThreatList()
	 * @see #getSecReqSpeType()
	 * @generated
	 */
	EReference getSecReqSpeType_ThreatList();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.TangibleByType <em>Tangible By Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tangible By Type</em>'.
	 * @see eu.aniketos.mtm.srs.TangibleByType
	 * @generated
	 */
	EClass getTangibleByType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.TangibleByType#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see eu.aniketos.mtm.srs.TangibleByType#getInformation()
	 * @see #getTangibleByType()
	 * @generated
	 */
	EReference getTangibleByType_Information();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.TangibleByType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.TangibleByType#getDocument()
	 * @see #getTangibleByType()
	 * @generated
	 */
	EReference getTangibleByType_Document();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ThreatListType <em>Threat List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat List Type</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatListType
	 * @generated
	 */
	EClass getThreatListType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ThreatListType#getThreat <em>Threat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threat</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatListType#getThreat()
	 * @see #getThreatListType()
	 * @generated
	 */
	EReference getThreatListType_Threat();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.ThreatType <em>Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Threat Type</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType
	 * @generated
	 */
	EClass getThreatType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ThreatType#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getActor()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Actor();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ThreatType#getDocument <em>Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Document</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getDocument()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Document();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ThreatType#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getGoal()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Goal();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.aniketos.mtm.srs.ThreatType#getDelegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Delegation</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getDelegation()
	 * @see #getThreatType()
	 * @generated
	 */
	EReference getThreatType_Delegation();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.ThreatType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getId()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_Id();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.ThreatType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getName()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_Name();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.ThreatType#getRepositoryID <em>Repository ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repository ID</em>'.
	 * @see eu.aniketos.mtm.srs.ThreatType#getRepositoryID()
	 * @see #getThreatType()
	 * @generated
	 */
	EAttribute getThreatType_RepositoryID();

	/**
	 * Returns the meta object for class '{@link eu.aniketos.mtm.srs.TrustworthinessType <em>Trustworthiness Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trustworthiness Type</em>'.
	 * @see eu.aniketos.mtm.srs.TrustworthinessType
	 * @generated
	 */
	EClass getTrustworthinessType();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.TrustworthinessType#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see eu.aniketos.mtm.srs.TrustworthinessType#getDestination()
	 * @see #getTrustworthinessType()
	 * @generated
	 */
	EReference getTrustworthinessType_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link eu.aniketos.mtm.srs.TrustworthinessType#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Goal</em>'.
	 * @see eu.aniketos.mtm.srs.TrustworthinessType#getGoal()
	 * @see #getTrustworthinessType()
	 * @generated
	 */
	EReference getTrustworthinessType_Goal();

	/**
	 * Returns the meta object for the attribute '{@link eu.aniketos.mtm.srs.TrustworthinessType#getMinLevel <em>Min Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Level</em>'.
	 * @see eu.aniketos.mtm.srs.TrustworthinessType#getMinLevel()
	 * @see #getTrustworthinessType()
	 * @generated
	 */
	EAttribute getTrustworthinessType_MinLevel();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.srs.MultiplicityType <em>Multiplicity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicity Type</em>'.
	 * @see eu.aniketos.mtm.srs.MultiplicityType
	 * @generated
	 */
	EEnum getMultiplicityType();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.srs.OperationType <em>Operation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation Type</em>'.
	 * @see eu.aniketos.mtm.srs.OperationType
	 * @generated
	 */
	EEnum getOperationType();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.srs.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type</em>'.
	 * @see eu.aniketos.mtm.srs.TypeType
	 * @generated
	 */
	EEnum getTypeType();

	/**
	 * Returns the meta object for enum '{@link eu.aniketos.mtm.srs.TypeType1 <em>Type Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type1</em>'.
	 * @see eu.aniketos.mtm.srs.TypeType1
	 * @generated
	 */
	EEnum getTypeType1();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.srs.MultiplicityType <em>Multiplicity Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Multiplicity Type Object</em>'.
	 * @see eu.aniketos.mtm.srs.MultiplicityType
	 * @model instanceClass="eu.aniketos.mtm.srs.MultiplicityType"
	 *        extendedMetaData="name='multiplicity_._type:Object' baseType='multiplicity_._type'"
	 * @generated
	 */
	EDataType getMultiplicityTypeObject();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.srs.OperationType <em>Operation Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Operation Type Object</em>'.
	 * @see eu.aniketos.mtm.srs.OperationType
	 * @model instanceClass="eu.aniketos.mtm.srs.OperationType"
	 *        extendedMetaData="name='operationType:Object' baseType='operationType'"
	 * @generated
	 */
	EDataType getOperationTypeObject();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.srs.TypeType <em>Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object</em>'.
	 * @see eu.aniketos.mtm.srs.TypeType
	 * @model instanceClass="eu.aniketos.mtm.srs.TypeType"
	 *        extendedMetaData="name='type_._type:Object' baseType='type_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link eu.aniketos.mtm.srs.TypeType1 <em>Type Type Object1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object1</em>'.
	 * @see eu.aniketos.mtm.srs.TypeType1
	 * @model instanceClass="eu.aniketos.mtm.srs.TypeType1"
	 *        extendedMetaData="name='type_._1_._type:Object' baseType='type_._1_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject1();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SrsFactory getSrsFactory();

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
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ActorSetTypeMin2Impl <em>Actor Set Type Min2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ActorSetTypeMin2Impl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getActorSetTypeMin2()
		 * @generated
		 */
		EClass ACTOR_SET_TYPE_MIN2 = eINSTANCE.getActorSetTypeMin2();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_SET_TYPE_MIN2__ROLE = eINSTANCE.getActorSetTypeMin2_Role();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ActorTypeImpl <em>Actor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ActorTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getActorType()
		 * @generated
		 */
		EClass ACTOR_TYPE = eINSTANCE.getActorType();

		/**
		 * The meta object literal for the '<em><b>Agent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TYPE__AGENT = eINSTANCE.getActorType_Agent();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_TYPE__ROLE = eINSTANCE.getActorType_Role();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.AgentTypeImpl <em>Agent Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.AgentTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAgentType()
		 * @generated
		 */
		EClass AGENT_TYPE = eINSTANCE.getAgentType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_TYPE__VALUE = eINSTANCE.getAgentType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_TYPE__ID = eINSTANCE.getAgentType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.AuthTypeImpl <em>Auth Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.AuthTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAuthType()
		 * @generated
		 */
		EClass AUTH_TYPE = eINSTANCE.getAuthType();

		/**
		 * The meta object literal for the '<em><b>Info Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE__INFO_SET = eINSTANCE.getAuthType_InfoSet();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.AuthType1Impl <em>Auth Type1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.AuthType1Impl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAuthType1()
		 * @generated
		 */
		EClass AUTH_TYPE1 = eINSTANCE.getAuthType1();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE1__SOURCE = eINSTANCE.getAuthType1_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE1__DESTINATION = eINSTANCE.getAuthType1_Destination();

		/**
		 * The meta object literal for the '<em><b>Info Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE1__INFO_SET = eINSTANCE.getAuthType1_InfoSet();

		/**
		 * The meta object literal for the '<em><b>Scope Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE1__SCOPE_SET = eINSTANCE.getAuthType1_ScopeSet();

		/**
		 * The meta object literal for the '<em><b>Operation Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTH_TYPE1__OPERATION_SET = eINSTANCE.getAuthType1_OperationSet();

		/**
		 * The meta object literal for the '<em><b>Transferable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTH_TYPE1__TRANSFERABLE = eINSTANCE.getAuthType1_Transferable();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.AvailabilityTypeImpl <em>Availability Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.AvailabilityTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getAvailabilityType()
		 * @generated
		 */
		EClass AVAILABILITY_TYPE = eINSTANCE.getAvailabilityType();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABILITY_TYPE__GOAL = eINSTANCE.getAvailabilityType_Goal();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABILITY_TYPE__DOCUMENT = eINSTANCE.getAvailabilityType_Document();

		/**
		 * The meta object literal for the '<em><b>Min Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABILITY_TYPE__MIN_LEVEL = eINSTANCE.getAvailabilityType_MinLevel();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.BoDSoDActorTypeImpl <em>Bo DSo DActor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.BoDSoDActorTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getBoDSoDActorType()
		 * @generated
		 */
		EClass BO_DSO_DACTOR_TYPE = eINSTANCE.getBoDSoDActorType();

		/**
		 * The meta object literal for the '<em><b>Actor Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BO_DSO_DACTOR_TYPE__ACTOR_SET = eINSTANCE.getBoDSoDActorType_ActorSet();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.BoDSoDGoalTypeImpl <em>Bo DSo DGoal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.BoDSoDGoalTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getBoDSoDGoalType()
		 * @generated
		 */
		EClass BO_DSO_DGOAL_TYPE = eINSTANCE.getBoDSoDGoalType();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BO_DSO_DGOAL_TYPE__GOAL_SET = eINSTANCE.getBoDSoDGoalType_GoalSet();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.CommitmentTypeImpl <em>Commitment Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.CommitmentTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getCommitmentType()
		 * @generated
		 */
		EClass COMMITMENT_TYPE = eINSTANCE.getCommitmentType();

		/**
		 * The meta object literal for the '<em><b>Debtor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMITMENT_TYPE__DEBTOR = eINSTANCE.getCommitmentType_Debtor();

		/**
		 * The meta object literal for the '<em><b>Creditor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMITMENT_TYPE__CREDITOR = eINSTANCE.getCommitmentType_Creditor();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMITMENT_TYPE__PRECONDITION = eINSTANCE.getCommitmentType_Precondition();

		/**
		 * The meta object literal for the '<em><b>Postcondition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMITMENT_TYPE__POSTCONDITION = eINSTANCE.getCommitmentType_Postcondition();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMITMENT_TYPE__ID = eINSTANCE.getCommitmentType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ConfidentialityTypeImpl <em>Confidentiality Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ConfidentialityTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getConfidentialityType()
		 * @generated
		 */
		EClass CONFIDENTIALITY_TYPE = eINSTANCE.getConfidentialityType();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIDENTIALITY_TYPE__DOCUMENT = eINSTANCE.getConfidentialityType_Document();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.DelTypeImpl <em>Del Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.DelTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDelType()
		 * @generated
		 */
		EClass DEL_TYPE = eINSTANCE.getDelType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEL_TYPE__SOURCE = eINSTANCE.getDelType_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEL_TYPE__DESTINATION = eINSTANCE.getDelType_Destination();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEL_TYPE__GOAL_SET = eINSTANCE.getDelType_GoalSet();

		/**
		 * The meta object literal for the '<em><b>Transferable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEL_TYPE__TRANSFERABLE = eINSTANCE.getDelType_Transferable();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.DocTypeImpl <em>Doc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.DocTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDocType()
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
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.DocumentRootImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Sec Req Spe</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__SEC_REQ_SPE = eINSTANCE.getDocumentRoot_SecReqSpe();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.GoalSetTypeImpl <em>Goal Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.GoalSetTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalSetType()
		 * @generated
		 */
		EClass GOAL_SET_TYPE = eINSTANCE.getGoalSetType();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_SET_TYPE__GOAL = eINSTANCE.getGoalSetType_Goal();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.GoalSetTypeMin2Impl <em>Goal Set Type Min2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.GoalSetTypeMin2Impl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalSetTypeMin2()
		 * @generated
		 */
		EClass GOAL_SET_TYPE_MIN2 = eINSTANCE.getGoalSetTypeMin2();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_SET_TYPE_MIN2__GOAL = eINSTANCE.getGoalSetTypeMin2_Goal();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.GoalTypeImpl <em>Goal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.GoalTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getGoalType()
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
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.InfoDocTypeImpl <em>Info Doc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.InfoDocTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoDocType()
		 * @generated
		 */
		EClass INFO_DOC_TYPE = eINSTANCE.getInfoDocType();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFO_DOC_TYPE__DOCUMENT = eINSTANCE.getInfoDocType_Document();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFO_DOC_TYPE__INFORMATION = eINSTANCE.getInfoDocType_Information();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.InfoSetTypeImpl <em>Info Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.InfoSetTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoSetType()
		 * @generated
		 */
		EClass INFO_SET_TYPE = eINSTANCE.getInfoSetType();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFO_SET_TYPE__INFORMATION = eINSTANCE.getInfoSetType_Information();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.InfoTypeImpl <em>Info Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.InfoTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getInfoType()
		 * @generated
		 */
		EClass INFO_TYPE = eINSTANCE.getInfoType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFO_TYPE__VALUE = eINSTANCE.getInfoType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFO_TYPE__ID = eINSTANCE.getInfoType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.IntegrityTypeImpl <em>Integrity Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.IntegrityTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getIntegrityType()
		 * @generated
		 */
		EClass INTEGRITY_TYPE = eINSTANCE.getIntegrityType();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGRITY_TYPE__DOCUMENT = eINSTANCE.getIntegrityType_Document();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.KBTypeImpl <em>KB Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.KBTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getKBType()
		 * @generated
		 */
		EClass KB_TYPE = eINSTANCE.getKBType();

		/**
		 * The meta object literal for the '<em><b>Part Of</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KB_TYPE__PART_OF = eINSTANCE.getKBType_PartOf();

		/**
		 * The meta object literal for the '<em><b>Tangible By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KB_TYPE__TANGIBLE_BY = eINSTANCE.getKBType_TangibleBy();

		/**
		 * The meta object literal for the '<em><b>Owns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KB_TYPE__OWNS = eINSTANCE.getKBType_Owns();

		/**
		 * The meta object literal for the '<em><b>Fully Authorized</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KB_TYPE__FULLY_AUTHORIZED = eINSTANCE.getKBType_FullyAuthorized();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.NDTypeImpl <em>ND Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.NDTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNDType()
		 * @generated
		 */
		EClass ND_TYPE = eINSTANCE.getNDType();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ND_TYPE__GOAL_SET = eINSTANCE.getNDType_GoalSet();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.NRTypeImpl <em>NR Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.NRTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNRType()
		 * @generated
		 */
		EClass NR_TYPE = eINSTANCE.getNRType();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NR_TYPE__GOAL_SET = eINSTANCE.getNRType_GoalSet();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NR_TYPE__TYPE = eINSTANCE.getNRType_Type();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.NTKTypeImpl <em>NTK Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.NTKTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getNTKType()
		 * @generated
		 */
		EClass NTK_TYPE = eINSTANCE.getNTKType();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NTK_TYPE__GOAL_SET = eINSTANCE.getNTKType_GoalSet();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.OperationSetTypeImpl <em>Operation Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.OperationSetTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationSetType()
		 * @generated
		 */
		EClass OPERATION_SET_TYPE = eINSTANCE.getOperationSetType();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_SET_TYPE__OPERATION = eINSTANCE.getOperationSetType_Operation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.OwnsTypeImpl <em>Owns Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.OwnsTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOwnsType()
		 * @generated
		 */
		EClass OWNS_TYPE = eINSTANCE.getOwnsType();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWNS_TYPE__ACTOR = eINSTANCE.getOwnsType_Actor();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OWNS_TYPE__INFORMATION = eINSTANCE.getOwnsType_Information();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.PartOfTypeImpl <em>Part Of Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.PartOfTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPartOfType()
		 * @generated
		 */
		EClass PART_OF_TYPE = eINSTANCE.getPartOfType();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART_OF_TYPE__CONTAINER = eINSTANCE.getPartOfType_Container();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART_OF_TYPE__CONTENT = eINSTANCE.getPartOfType_Content();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.PostTypeImpl <em>Post Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.PostTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPostType()
		 * @generated
		 */
		EClass POST_TYPE = eINSTANCE.getPostType();

		/**
		 * The meta object literal for the '<em><b>Non Delegation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_DELEGATION = eINSTANCE.getPostType_NonDelegation();

		/**
		 * The meta object literal for the '<em><b>Non Repudiation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_REPUDIATION = eINSTANCE.getPostType_NonRepudiation();

		/**
		 * The meta object literal for the '<em><b>Redundancy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__REDUNDANCY = eINSTANCE.getPostType_Redundancy();

		/**
		 * The meta object literal for the '<em><b>Need To Know</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NEED_TO_KNOW = eINSTANCE.getPostType_NeedToKnow();

		/**
		 * The meta object literal for the '<em><b>Non Disclosure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_DISCLOSURE = eINSTANCE.getPostType_NonDisclosure();

		/**
		 * The meta object literal for the '<em><b>Non Modification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_MODIFICATION = eINSTANCE.getPostType_NonModification();

		/**
		 * The meta object literal for the '<em><b>Non Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_USAGE = eINSTANCE.getPostType_NonUsage();

		/**
		 * The meta object literal for the '<em><b>Non Production</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NON_PRODUCTION = eINSTANCE.getPostType_NonProduction();

		/**
		 * The meta object literal for the '<em><b>Play Both</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__PLAY_BOTH = eINSTANCE.getPostType_PlayBoth();

		/**
		 * The meta object literal for the '<em><b>Not Play Both</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NOT_PLAY_BOTH = eINSTANCE.getPostType_NotPlayBoth();

		/**
		 * The meta object literal for the '<em><b>Achieve In Combination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__ACHIEVE_IN_COMBINATION = eINSTANCE.getPostType_AchieveInCombination();

		/**
		 * The meta object literal for the '<em><b>Not Achieve In Combination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__NOT_ACHIEVE_IN_COMBINATION = eINSTANCE.getPostType_NotAchieveInCombination();

		/**
		 * The meta object literal for the '<em><b>Integrity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__INTEGRITY = eINSTANCE.getPostType_Integrity();

		/**
		 * The meta object literal for the '<em><b>Availability</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__AVAILABILITY = eINSTANCE.getPostType_Availability();

		/**
		 * The meta object literal for the '<em><b>Confidentiality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__CONFIDENTIALITY = eINSTANCE.getPostType_Confidentiality();

		/**
		 * The meta object literal for the '<em><b>Delegation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POST_TYPE__DELEGATION = eINSTANCE.getPostType_Delegation();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.PreTypeImpl <em>Pre Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.PreTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getPreType()
		 * @generated
		 */
		EClass PRE_TYPE = eINSTANCE.getPreType();

		/**
		 * The meta object literal for the '<em><b>Delegation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRE_TYPE__DELEGATION = eINSTANCE.getPreType_Delegation();

		/**
		 * The meta object literal for the '<em><b>Authorization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRE_TYPE__AUTHORIZATION = eINSTANCE.getPreType_Authorization();

		/**
		 * The meta object literal for the '<em><b>Provision</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRE_TYPE__PROVISION = eINSTANCE.getPreType_Provision();

		/**
		 * The meta object literal for the '<em><b>Trustworthiness</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRE_TYPE__TRUSTWORTHINESS = eINSTANCE.getPreType_Trustworthiness();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ProvTypeImpl <em>Prov Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ProvTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getProvType()
		 * @generated
		 */
		EClass PROV_TYPE = eINSTANCE.getProvType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROV_TYPE__SOURCE = eINSTANCE.getProvType_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROV_TYPE__DESTINATION = eINSTANCE.getProvType_Destination();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROV_TYPE__DOCUMENT = eINSTANCE.getProvType_Document();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.RedTypeImpl <em>Red Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.RedTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getRedType()
		 * @generated
		 */
		EClass RED_TYPE = eINSTANCE.getRedType();

		/**
		 * The meta object literal for the '<em><b>Goal Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RED_TYPE__GOAL_SET = eINSTANCE.getRedType_GoalSet();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_TYPE__MULTIPLICITY = eINSTANCE.getRedType_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RED_TYPE__TYPE = eINSTANCE.getRedType_Type();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.RoleTypeImpl <em>Role Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.RoleTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getRoleType()
		 * @generated
		 */
		EClass ROLE_TYPE = eINSTANCE.getRoleType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_TYPE__VALUE = eINSTANCE.getRoleType_Value();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE_TYPE__ID = eINSTANCE.getRoleType_Id();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl <em>Sec Req Spe Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.SecReqSpeTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getSecReqSpeType()
		 * @generated
		 */
		EClass SEC_REQ_SPE_TYPE = eINSTANCE.getSecReqSpeType();

		/**
		 * The meta object literal for the '<em><b>Commitment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEC_REQ_SPE_TYPE__COMMITMENT = eINSTANCE.getSecReqSpeType_Commitment();

		/**
		 * The meta object literal for the '<em><b>Knowledge Base</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE = eINSTANCE.getSecReqSpeType_KnowledgeBase();

		/**
		 * The meta object literal for the '<em><b>Threat List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEC_REQ_SPE_TYPE__THREAT_LIST = eINSTANCE.getSecReqSpeType_ThreatList();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.TangibleByTypeImpl <em>Tangible By Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.TangibleByTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTangibleByType()
		 * @generated
		 */
		EClass TANGIBLE_BY_TYPE = eINSTANCE.getTangibleByType();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TANGIBLE_BY_TYPE__INFORMATION = eINSTANCE.getTangibleByType_Information();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TANGIBLE_BY_TYPE__DOCUMENT = eINSTANCE.getTangibleByType_Document();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ThreatListTypeImpl <em>Threat List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ThreatListTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getThreatListType()
		 * @generated
		 */
		EClass THREAT_LIST_TYPE = eINSTANCE.getThreatListType();

		/**
		 * The meta object literal for the '<em><b>Threat</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_LIST_TYPE__THREAT = eINSTANCE.getThreatListType_Threat();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.ThreatTypeImpl <em>Threat Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.ThreatTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getThreatType()
		 * @generated
		 */
		EClass THREAT_TYPE = eINSTANCE.getThreatType();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__ACTOR = eINSTANCE.getThreatType_Actor();

		/**
		 * The meta object literal for the '<em><b>Document</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__DOCUMENT = eINSTANCE.getThreatType_Document();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__GOAL = eINSTANCE.getThreatType_Goal();

		/**
		 * The meta object literal for the '<em><b>Delegation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAT_TYPE__DELEGATION = eINSTANCE.getThreatType_Delegation();

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
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.impl.TrustworthinessTypeImpl <em>Trustworthiness Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.impl.TrustworthinessTypeImpl
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTrustworthinessType()
		 * @generated
		 */
		EClass TRUSTWORTHINESS_TYPE = eINSTANCE.getTrustworthinessType();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUSTWORTHINESS_TYPE__DESTINATION = eINSTANCE.getTrustworthinessType_Destination();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRUSTWORTHINESS_TYPE__GOAL = eINSTANCE.getTrustworthinessType_Goal();

		/**
		 * The meta object literal for the '<em><b>Min Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRUSTWORTHINESS_TYPE__MIN_LEVEL = eINSTANCE.getTrustworthinessType_MinLevel();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.MultiplicityType <em>Multiplicity Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.MultiplicityType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getMultiplicityType()
		 * @generated
		 */
		EEnum MULTIPLICITY_TYPE = eINSTANCE.getMultiplicityType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.OperationType <em>Operation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.OperationType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationType()
		 * @generated
		 */
		EEnum OPERATION_TYPE = eINSTANCE.getOperationType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.TypeType <em>Type Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.TypeType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeType()
		 * @generated
		 */
		EEnum TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '{@link eu.aniketos.mtm.srs.TypeType1 <em>Type Type1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.TypeType1
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeType1()
		 * @generated
		 */
		EEnum TYPE_TYPE1 = eINSTANCE.getTypeType1();

		/**
		 * The meta object literal for the '<em>Multiplicity Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.MultiplicityType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getMultiplicityTypeObject()
		 * @generated
		 */
		EDataType MULTIPLICITY_TYPE_OBJECT = eINSTANCE.getMultiplicityTypeObject();

		/**
		 * The meta object literal for the '<em>Operation Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.OperationType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getOperationTypeObject()
		 * @generated
		 */
		EDataType OPERATION_TYPE_OBJECT = eINSTANCE.getOperationTypeObject();

		/**
		 * The meta object literal for the '<em>Type Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.TypeType
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeTypeObject()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT = eINSTANCE.getTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Type Type Object1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.aniketos.mtm.srs.TypeType1
		 * @see eu.aniketos.mtm.srs.impl.SrsPackageImpl#getTypeTypeObject1()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT1 = eINSTANCE.getTypeTypeObject1();

	}

} //SrsPackage
