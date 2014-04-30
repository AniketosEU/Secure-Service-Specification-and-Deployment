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
package eu.aniketos.mtm.srs.impl;

import eu.aniketos.mtm.srs.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SrsFactoryImpl extends EFactoryImpl implements SrsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SrsFactory init() {
		try {
			SrsFactory theSrsFactory = (SrsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sts-tool-eu/xsd/SRS_1.8.xsd"); 
			if (theSrsFactory != null) {
				return theSrsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SrsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SrsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SrsPackage.ACTOR_SET_TYPE_MIN2: return createActorSetTypeMin2();
			case SrsPackage.ACTOR_TYPE: return createActorType();
			case SrsPackage.AGENT_TYPE: return createAgentType();
			case SrsPackage.AUTH_TYPE: return createAuthType();
			case SrsPackage.AUTH_TYPE1: return createAuthType1();
			case SrsPackage.AVAILABILITY_TYPE: return createAvailabilityType();
			case SrsPackage.BO_DSO_DACTOR_TYPE: return createBoDSoDActorType();
			case SrsPackage.BO_DSO_DGOAL_TYPE: return createBoDSoDGoalType();
			case SrsPackage.COMMITMENT_TYPE: return createCommitmentType();
			case SrsPackage.CONFIDENTIALITY_TYPE: return createConfidentialityType();
			case SrsPackage.DEL_TYPE: return createDelType();
			case SrsPackage.DOC_TYPE: return createDocType();
			case SrsPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case SrsPackage.GOAL_SET_TYPE: return createGoalSetType();
			case SrsPackage.GOAL_SET_TYPE_MIN2: return createGoalSetTypeMin2();
			case SrsPackage.GOAL_TYPE: return createGoalType();
			case SrsPackage.INFO_DOC_TYPE: return createInfoDocType();
			case SrsPackage.INFO_SET_TYPE: return createInfoSetType();
			case SrsPackage.INFO_TYPE: return createInfoType();
			case SrsPackage.INTEGRITY_TYPE: return createIntegrityType();
			case SrsPackage.KB_TYPE: return createKBType();
			case SrsPackage.ND_TYPE: return createNDType();
			case SrsPackage.NR_TYPE: return createNRType();
			case SrsPackage.NTK_TYPE: return createNTKType();
			case SrsPackage.OPERATION_SET_TYPE: return createOperationSetType();
			case SrsPackage.OWNS_TYPE: return createOwnsType();
			case SrsPackage.PART_OF_TYPE: return createPartOfType();
			case SrsPackage.POST_TYPE: return createPostType();
			case SrsPackage.PRE_TYPE: return createPreType();
			case SrsPackage.PROV_TYPE: return createProvType();
			case SrsPackage.RED_TYPE: return createRedType();
			case SrsPackage.ROLE_TYPE: return createRoleType();
			case SrsPackage.SEC_REQ_SPE_TYPE: return createSecReqSpeType();
			case SrsPackage.TANGIBLE_BY_TYPE: return createTangibleByType();
			case SrsPackage.THREAT_LIST_TYPE: return createThreatListType();
			case SrsPackage.THREAT_TYPE: return createThreatType();
			case SrsPackage.TRUSTWORTHINESS_TYPE: return createTrustworthinessType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SrsPackage.MULTIPLICITY_TYPE:
				return createMultiplicityTypeFromString(eDataType, initialValue);
			case SrsPackage.OPERATION_TYPE:
				return createOperationTypeFromString(eDataType, initialValue);
			case SrsPackage.TYPE_TYPE:
				return createTypeTypeFromString(eDataType, initialValue);
			case SrsPackage.TYPE_TYPE1:
				return createTypeType1FromString(eDataType, initialValue);
			case SrsPackage.MULTIPLICITY_TYPE_OBJECT:
				return createMultiplicityTypeObjectFromString(eDataType, initialValue);
			case SrsPackage.OPERATION_TYPE_OBJECT:
				return createOperationTypeObjectFromString(eDataType, initialValue);
			case SrsPackage.TYPE_TYPE_OBJECT:
				return createTypeTypeObjectFromString(eDataType, initialValue);
			case SrsPackage.TYPE_TYPE_OBJECT1:
				return createTypeTypeObject1FromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SrsPackage.MULTIPLICITY_TYPE:
				return convertMultiplicityTypeToString(eDataType, instanceValue);
			case SrsPackage.OPERATION_TYPE:
				return convertOperationTypeToString(eDataType, instanceValue);
			case SrsPackage.TYPE_TYPE:
				return convertTypeTypeToString(eDataType, instanceValue);
			case SrsPackage.TYPE_TYPE1:
				return convertTypeType1ToString(eDataType, instanceValue);
			case SrsPackage.MULTIPLICITY_TYPE_OBJECT:
				return convertMultiplicityTypeObjectToString(eDataType, instanceValue);
			case SrsPackage.OPERATION_TYPE_OBJECT:
				return convertOperationTypeObjectToString(eDataType, instanceValue);
			case SrsPackage.TYPE_TYPE_OBJECT:
				return convertTypeTypeObjectToString(eDataType, instanceValue);
			case SrsPackage.TYPE_TYPE_OBJECT1:
				return convertTypeTypeObject1ToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorSetTypeMin2 createActorSetTypeMin2() {
		ActorSetTypeMin2Impl actorSetTypeMin2 = new ActorSetTypeMin2Impl();
		return actorSetTypeMin2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorType createActorType() {
		ActorTypeImpl actorType = new ActorTypeImpl();
		return actorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentType createAgentType() {
		AgentTypeImpl agentType = new AgentTypeImpl();
		return agentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType createAuthType() {
		AuthTypeImpl authType = new AuthTypeImpl();
		return authType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType1 createAuthType1() {
		AuthType1Impl authType1 = new AuthType1Impl();
		return authType1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityType createAvailabilityType() {
		AvailabilityTypeImpl availabilityType = new AvailabilityTypeImpl();
		return availabilityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDActorType createBoDSoDActorType() {
		BoDSoDActorTypeImpl boDSoDActorType = new BoDSoDActorTypeImpl();
		return boDSoDActorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDGoalType createBoDSoDGoalType() {
		BoDSoDGoalTypeImpl boDSoDGoalType = new BoDSoDGoalTypeImpl();
		return boDSoDGoalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommitmentType createCommitmentType() {
		CommitmentTypeImpl commitmentType = new CommitmentTypeImpl();
		return commitmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityType createConfidentialityType() {
		ConfidentialityTypeImpl confidentialityType = new ConfidentialityTypeImpl();
		return confidentialityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelType createDelType() {
		DelTypeImpl delType = new DelTypeImpl();
		return delType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocType createDocType() {
		DocTypeImpl docType = new DocTypeImpl();
		return docType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSetType createGoalSetType() {
		GoalSetTypeImpl goalSetType = new GoalSetTypeImpl();
		return goalSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalSetTypeMin2 createGoalSetTypeMin2() {
		GoalSetTypeMin2Impl goalSetTypeMin2 = new GoalSetTypeMin2Impl();
		return goalSetTypeMin2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalType createGoalType() {
		GoalTypeImpl goalType = new GoalTypeImpl();
		return goalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoDocType createInfoDocType() {
		InfoDocTypeImpl infoDocType = new InfoDocTypeImpl();
		return infoDocType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoSetType createInfoSetType() {
		InfoSetTypeImpl infoSetType = new InfoSetTypeImpl();
		return infoSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoType createInfoType() {
		InfoTypeImpl infoType = new InfoTypeImpl();
		return infoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityType createIntegrityType() {
		IntegrityTypeImpl integrityType = new IntegrityTypeImpl();
		return integrityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KBType createKBType() {
		KBTypeImpl kbType = new KBTypeImpl();
		return kbType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NDType createNDType() {
		NDTypeImpl ndType = new NDTypeImpl();
		return ndType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NRType createNRType() {
		NRTypeImpl nrType = new NRTypeImpl();
		return nrType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NTKType createNTKType() {
		NTKTypeImpl ntkType = new NTKTypeImpl();
		return ntkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSetType createOperationSetType() {
		OperationSetTypeImpl operationSetType = new OperationSetTypeImpl();
		return operationSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OwnsType createOwnsType() {
		OwnsTypeImpl ownsType = new OwnsTypeImpl();
		return ownsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartOfType createPartOfType() {
		PartOfTypeImpl partOfType = new PartOfTypeImpl();
		return partOfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostType createPostType() {
		PostTypeImpl postType = new PostTypeImpl();
		return postType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreType createPreType() {
		PreTypeImpl preType = new PreTypeImpl();
		return preType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvType createProvType() {
		ProvTypeImpl provType = new ProvTypeImpl();
		return provType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedType createRedType() {
		RedTypeImpl redType = new RedTypeImpl();
		return redType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoleType createRoleType() {
		RoleTypeImpl roleType = new RoleTypeImpl();
		return roleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecReqSpeType createSecReqSpeType() {
		SecReqSpeTypeImpl secReqSpeType = new SecReqSpeTypeImpl();
		return secReqSpeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TangibleByType createTangibleByType() {
		TangibleByTypeImpl tangibleByType = new TangibleByTypeImpl();
		return tangibleByType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatListType createThreatListType() {
		ThreatListTypeImpl threatListType = new ThreatListTypeImpl();
		return threatListType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThreatType createThreatType() {
		ThreatTypeImpl threatType = new ThreatTypeImpl();
		return threatType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrustworthinessType createTrustworthinessType() {
		TrustworthinessTypeImpl trustworthinessType = new TrustworthinessTypeImpl();
		return trustworthinessType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityType createMultiplicityTypeFromString(EDataType eDataType, String initialValue) {
		MultiplicityType result = MultiplicityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationType createOperationTypeFromString(EDataType eDataType, String initialValue) {
		OperationType result = OperationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeTypeFromString(EDataType eDataType, String initialValue) {
		TypeType result = TypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType1 createTypeType1FromString(EDataType eDataType, String initialValue) {
		TypeType1 result = TypeType1.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeType1ToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityType createMultiplicityTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createMultiplicityTypeFromString(SrsPackage.Literals.MULTIPLICITY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicityTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertMultiplicityTypeToString(SrsPackage.Literals.MULTIPLICITY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationType createOperationTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createOperationTypeFromString(SrsPackage.Literals.OPERATION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertOperationTypeToString(SrsPackage.Literals.OPERATION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createTypeTypeFromString(SrsPackage.Literals.TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTypeTypeToString(SrsPackage.Literals.TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType1 createTypeTypeObject1FromString(EDataType eDataType, String initialValue) {
		return createTypeType1FromString(SrsPackage.Literals.TYPE_TYPE1, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTypeObject1ToString(EDataType eDataType, Object instanceValue) {
		return convertTypeType1ToString(SrsPackage.Literals.TYPE_TYPE1, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SrsPackage getSrsPackage() {
		return (SrsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SrsPackage getPackage() {
		return SrsPackage.eINSTANCE;
	}

} //SrsFactoryImpl
