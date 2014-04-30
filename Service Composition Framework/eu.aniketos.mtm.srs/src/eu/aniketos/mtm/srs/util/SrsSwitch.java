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
package eu.aniketos.mtm.srs.util;

import eu.aniketos.mtm.srs.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.srs.SrsPackage
 * @generated
 */
public class SrsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SrsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SrsSwitch() {
		if (modelPackage == null) {
			modelPackage = SrsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SrsPackage.ACTOR_SET_TYPE_MIN2: {
				ActorSetTypeMin2 actorSetTypeMin2 = (ActorSetTypeMin2)theEObject;
				T result = caseActorSetTypeMin2(actorSetTypeMin2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.ACTOR_TYPE: {
				ActorType actorType = (ActorType)theEObject;
				T result = caseActorType(actorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.AGENT_TYPE: {
				AgentType agentType = (AgentType)theEObject;
				T result = caseAgentType(agentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.AUTH_TYPE: {
				AuthType authType = (AuthType)theEObject;
				T result = caseAuthType(authType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.AUTH_TYPE1: {
				AuthType1 authType1 = (AuthType1)theEObject;
				T result = caseAuthType1(authType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.AVAILABILITY_TYPE: {
				AvailabilityType availabilityType = (AvailabilityType)theEObject;
				T result = caseAvailabilityType(availabilityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.BO_DSO_DACTOR_TYPE: {
				BoDSoDActorType boDSoDActorType = (BoDSoDActorType)theEObject;
				T result = caseBoDSoDActorType(boDSoDActorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.BO_DSO_DGOAL_TYPE: {
				BoDSoDGoalType boDSoDGoalType = (BoDSoDGoalType)theEObject;
				T result = caseBoDSoDGoalType(boDSoDGoalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.COMMITMENT_TYPE: {
				CommitmentType commitmentType = (CommitmentType)theEObject;
				T result = caseCommitmentType(commitmentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.CONFIDENTIALITY_TYPE: {
				ConfidentialityType confidentialityType = (ConfidentialityType)theEObject;
				T result = caseConfidentialityType(confidentialityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.DEL_TYPE: {
				DelType delType = (DelType)theEObject;
				T result = caseDelType(delType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.DOC_TYPE: {
				DocType docType = (DocType)theEObject;
				T result = caseDocType(docType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.GOAL_SET_TYPE: {
				GoalSetType goalSetType = (GoalSetType)theEObject;
				T result = caseGoalSetType(goalSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.GOAL_SET_TYPE_MIN2: {
				GoalSetTypeMin2 goalSetTypeMin2 = (GoalSetTypeMin2)theEObject;
				T result = caseGoalSetTypeMin2(goalSetTypeMin2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.GOAL_TYPE: {
				GoalType goalType = (GoalType)theEObject;
				T result = caseGoalType(goalType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.INFO_DOC_TYPE: {
				InfoDocType infoDocType = (InfoDocType)theEObject;
				T result = caseInfoDocType(infoDocType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.INFO_SET_TYPE: {
				InfoSetType infoSetType = (InfoSetType)theEObject;
				T result = caseInfoSetType(infoSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.INFO_TYPE: {
				InfoType infoType = (InfoType)theEObject;
				T result = caseInfoType(infoType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.INTEGRITY_TYPE: {
				IntegrityType integrityType = (IntegrityType)theEObject;
				T result = caseIntegrityType(integrityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.KB_TYPE: {
				KBType kbType = (KBType)theEObject;
				T result = caseKBType(kbType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.ND_TYPE: {
				NDType ndType = (NDType)theEObject;
				T result = caseNDType(ndType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.NR_TYPE: {
				NRType nrType = (NRType)theEObject;
				T result = caseNRType(nrType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.NTK_TYPE: {
				NTKType ntkType = (NTKType)theEObject;
				T result = caseNTKType(ntkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.OPERATION_SET_TYPE: {
				OperationSetType operationSetType = (OperationSetType)theEObject;
				T result = caseOperationSetType(operationSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.OWNS_TYPE: {
				OwnsType ownsType = (OwnsType)theEObject;
				T result = caseOwnsType(ownsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.PART_OF_TYPE: {
				PartOfType partOfType = (PartOfType)theEObject;
				T result = casePartOfType(partOfType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.POST_TYPE: {
				PostType postType = (PostType)theEObject;
				T result = casePostType(postType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.PRE_TYPE: {
				PreType preType = (PreType)theEObject;
				T result = casePreType(preType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.PROV_TYPE: {
				ProvType provType = (ProvType)theEObject;
				T result = caseProvType(provType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.RED_TYPE: {
				RedType redType = (RedType)theEObject;
				T result = caseRedType(redType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.ROLE_TYPE: {
				RoleType roleType = (RoleType)theEObject;
				T result = caseRoleType(roleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.SEC_REQ_SPE_TYPE: {
				SecReqSpeType secReqSpeType = (SecReqSpeType)theEObject;
				T result = caseSecReqSpeType(secReqSpeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.TANGIBLE_BY_TYPE: {
				TangibleByType tangibleByType = (TangibleByType)theEObject;
				T result = caseTangibleByType(tangibleByType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.THREAT_LIST_TYPE: {
				ThreatListType threatListType = (ThreatListType)theEObject;
				T result = caseThreatListType(threatListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.THREAT_TYPE: {
				ThreatType threatType = (ThreatType)theEObject;
				T result = caseThreatType(threatType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SrsPackage.TRUSTWORTHINESS_TYPE: {
				TrustworthinessType trustworthinessType = (TrustworthinessType)theEObject;
				T result = caseTrustworthinessType(trustworthinessType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Set Type Min2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Set Type Min2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorSetTypeMin2(ActorSetTypeMin2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActorType(ActorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Agent Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Agent Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAgentType(AgentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Auth Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auth Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthType(AuthType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Auth Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Auth Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthType1(AuthType1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Availability Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Availability Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvailabilityType(AvailabilityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bo DSo DActor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bo DSo DActor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoDSoDActorType(BoDSoDActorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bo DSo DGoal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bo DSo DGoal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoDSoDGoalType(BoDSoDGoalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Commitment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Commitment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommitmentType(CommitmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Confidentiality Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Confidentiality Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfidentialityType(ConfidentialityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Del Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Del Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelType(DelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Doc Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocType(DocType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoalSetType(GoalSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal Set Type Min2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal Set Type Min2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoalSetTypeMin2(GoalSetTypeMin2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoalType(GoalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info Doc Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfoDocType(InfoDocType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfoSetType(InfoSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfoType(InfoType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integrity Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integrity Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegrityType(IntegrityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>KB Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>KB Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKBType(KBType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ND Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ND Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNDType(NDType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NR Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NR Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNRType(NRType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NTK Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NTK Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNTKType(NTKType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationSetType(OperationSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owns Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owns Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwnsType(OwnsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part Of Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part Of Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartOfType(PartOfType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Post Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Post Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostType(PostType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreType(PreType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prov Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prov Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProvType(ProvType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Red Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Red Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedType(RedType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleType(RoleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sec Req Spe Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sec Req Spe Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecReqSpeType(SecReqSpeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tangible By Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tangible By Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTangibleByType(TangibleByType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatListType(ThreatListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Threat Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreatType(ThreatType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trustworthiness Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trustworthiness Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrustworthinessType(TrustworthinessType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SrsSwitch
