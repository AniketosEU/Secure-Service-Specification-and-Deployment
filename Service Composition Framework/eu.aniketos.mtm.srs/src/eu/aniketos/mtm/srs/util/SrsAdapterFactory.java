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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.srs.SrsPackage
 * @generated
 */
public class SrsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SrsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SrsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SrsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SrsSwitch<Adapter> modelSwitch =
		new SrsSwitch<Adapter>() {
			@Override
			public Adapter caseActorSetTypeMin2(ActorSetTypeMin2 object) {
				return createActorSetTypeMin2Adapter();
			}
			@Override
			public Adapter caseActorType(ActorType object) {
				return createActorTypeAdapter();
			}
			@Override
			public Adapter caseAgentType(AgentType object) {
				return createAgentTypeAdapter();
			}
			@Override
			public Adapter caseAuthType(AuthType object) {
				return createAuthTypeAdapter();
			}
			@Override
			public Adapter caseAuthType1(AuthType1 object) {
				return createAuthType1Adapter();
			}
			@Override
			public Adapter caseAvailabilityType(AvailabilityType object) {
				return createAvailabilityTypeAdapter();
			}
			@Override
			public Adapter caseBoDSoDActorType(BoDSoDActorType object) {
				return createBoDSoDActorTypeAdapter();
			}
			@Override
			public Adapter caseBoDSoDGoalType(BoDSoDGoalType object) {
				return createBoDSoDGoalTypeAdapter();
			}
			@Override
			public Adapter caseCommitmentType(CommitmentType object) {
				return createCommitmentTypeAdapter();
			}
			@Override
			public Adapter caseConfidentialityType(ConfidentialityType object) {
				return createConfidentialityTypeAdapter();
			}
			@Override
			public Adapter caseDelType(DelType object) {
				return createDelTypeAdapter();
			}
			@Override
			public Adapter caseDocType(DocType object) {
				return createDocTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseGoalSetType(GoalSetType object) {
				return createGoalSetTypeAdapter();
			}
			@Override
			public Adapter caseGoalSetTypeMin2(GoalSetTypeMin2 object) {
				return createGoalSetTypeMin2Adapter();
			}
			@Override
			public Adapter caseGoalType(GoalType object) {
				return createGoalTypeAdapter();
			}
			@Override
			public Adapter caseInfoDocType(InfoDocType object) {
				return createInfoDocTypeAdapter();
			}
			@Override
			public Adapter caseInfoSetType(InfoSetType object) {
				return createInfoSetTypeAdapter();
			}
			@Override
			public Adapter caseInfoType(InfoType object) {
				return createInfoTypeAdapter();
			}
			@Override
			public Adapter caseIntegrityType(IntegrityType object) {
				return createIntegrityTypeAdapter();
			}
			@Override
			public Adapter caseKBType(KBType object) {
				return createKBTypeAdapter();
			}
			@Override
			public Adapter caseNDType(NDType object) {
				return createNDTypeAdapter();
			}
			@Override
			public Adapter caseNRType(NRType object) {
				return createNRTypeAdapter();
			}
			@Override
			public Adapter caseNTKType(NTKType object) {
				return createNTKTypeAdapter();
			}
			@Override
			public Adapter caseOperationSetType(OperationSetType object) {
				return createOperationSetTypeAdapter();
			}
			@Override
			public Adapter caseOwnsType(OwnsType object) {
				return createOwnsTypeAdapter();
			}
			@Override
			public Adapter casePartOfType(PartOfType object) {
				return createPartOfTypeAdapter();
			}
			@Override
			public Adapter casePostType(PostType object) {
				return createPostTypeAdapter();
			}
			@Override
			public Adapter casePreType(PreType object) {
				return createPreTypeAdapter();
			}
			@Override
			public Adapter caseProvType(ProvType object) {
				return createProvTypeAdapter();
			}
			@Override
			public Adapter caseRedType(RedType object) {
				return createRedTypeAdapter();
			}
			@Override
			public Adapter caseRoleType(RoleType object) {
				return createRoleTypeAdapter();
			}
			@Override
			public Adapter caseSecReqSpeType(SecReqSpeType object) {
				return createSecReqSpeTypeAdapter();
			}
			@Override
			public Adapter caseTangibleByType(TangibleByType object) {
				return createTangibleByTypeAdapter();
			}
			@Override
			public Adapter caseThreatListType(ThreatListType object) {
				return createThreatListTypeAdapter();
			}
			@Override
			public Adapter caseThreatType(ThreatType object) {
				return createThreatTypeAdapter();
			}
			@Override
			public Adapter caseTrustworthinessType(TrustworthinessType object) {
				return createTrustworthinessTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ActorSetTypeMin2 <em>Actor Set Type Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ActorSetTypeMin2
	 * @generated
	 */
	public Adapter createActorSetTypeMin2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ActorType <em>Actor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ActorType
	 * @generated
	 */
	public Adapter createActorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.AgentType <em>Agent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.AgentType
	 * @generated
	 */
	public Adapter createAgentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.AuthType <em>Auth Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.AuthType
	 * @generated
	 */
	public Adapter createAuthTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.AuthType1 <em>Auth Type1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.AuthType1
	 * @generated
	 */
	public Adapter createAuthType1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.AvailabilityType <em>Availability Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.AvailabilityType
	 * @generated
	 */
	public Adapter createAvailabilityTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.BoDSoDActorType <em>Bo DSo DActor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.BoDSoDActorType
	 * @generated
	 */
	public Adapter createBoDSoDActorTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.BoDSoDGoalType <em>Bo DSo DGoal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.BoDSoDGoalType
	 * @generated
	 */
	public Adapter createBoDSoDGoalTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.CommitmentType <em>Commitment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.CommitmentType
	 * @generated
	 */
	public Adapter createCommitmentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ConfidentialityType <em>Confidentiality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ConfidentialityType
	 * @generated
	 */
	public Adapter createConfidentialityTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.DelType <em>Del Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.DelType
	 * @generated
	 */
	public Adapter createDelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.DocType
	 * @generated
	 */
	public Adapter createDocTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.GoalSetType <em>Goal Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.GoalSetType
	 * @generated
	 */
	public Adapter createGoalSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.GoalSetTypeMin2 <em>Goal Set Type Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.GoalSetTypeMin2
	 * @generated
	 */
	public Adapter createGoalSetTypeMin2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.GoalType <em>Goal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.GoalType
	 * @generated
	 */
	public Adapter createGoalTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.InfoDocType <em>Info Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.InfoDocType
	 * @generated
	 */
	public Adapter createInfoDocTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.InfoSetType <em>Info Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.InfoSetType
	 * @generated
	 */
	public Adapter createInfoSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.InfoType <em>Info Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.InfoType
	 * @generated
	 */
	public Adapter createInfoTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.IntegrityType <em>Integrity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.IntegrityType
	 * @generated
	 */
	public Adapter createIntegrityTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.KBType <em>KB Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.KBType
	 * @generated
	 */
	public Adapter createKBTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.NDType <em>ND Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.NDType
	 * @generated
	 */
	public Adapter createNDTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.NRType <em>NR Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.NRType
	 * @generated
	 */
	public Adapter createNRTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.NTKType <em>NTK Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.NTKType
	 * @generated
	 */
	public Adapter createNTKTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.OperationSetType <em>Operation Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.OperationSetType
	 * @generated
	 */
	public Adapter createOperationSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.OwnsType <em>Owns Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.OwnsType
	 * @generated
	 */
	public Adapter createOwnsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.PartOfType <em>Part Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.PartOfType
	 * @generated
	 */
	public Adapter createPartOfTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.PostType <em>Post Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.PostType
	 * @generated
	 */
	public Adapter createPostTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.PreType <em>Pre Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.PreType
	 * @generated
	 */
	public Adapter createPreTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ProvType <em>Prov Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ProvType
	 * @generated
	 */
	public Adapter createProvTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.RedType <em>Red Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.RedType
	 * @generated
	 */
	public Adapter createRedTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.RoleType <em>Role Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.RoleType
	 * @generated
	 */
	public Adapter createRoleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.SecReqSpeType <em>Sec Req Spe Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.SecReqSpeType
	 * @generated
	 */
	public Adapter createSecReqSpeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.TangibleByType <em>Tangible By Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.TangibleByType
	 * @generated
	 */
	public Adapter createTangibleByTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ThreatListType <em>Threat List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ThreatListType
	 * @generated
	 */
	public Adapter createThreatListTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.ThreatType <em>Threat Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.ThreatType
	 * @generated
	 */
	public Adapter createThreatTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.srs.TrustworthinessType <em>Trustworthiness Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.srs.TrustworthinessType
	 * @generated
	 */
	public Adapter createTrustworthinessTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SrsAdapterFactory
