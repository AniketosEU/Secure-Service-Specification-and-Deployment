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
package eu.aniketos.mtm.model.mtm_bpmn2.impl;

import eu.aniketos.mtm.model.mtm_aniketos.AniketosPackage;

import eu.aniketos.mtm.model.mtm_aniketos.impl.AniketosPackageImpl;

import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Activity;
import eu.aniketos.mtm.model.mtm_bpmn2.AdHocOrdering;
import eu.aniketos.mtm.model.mtm_bpmn2.AdHocSubProcess;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoMailTask;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptBase;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptTask;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoStartEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoUserTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Artifact;
import eu.aniketos.mtm.model.mtm_bpmn2.Assignment;
import eu.aniketos.mtm.model.mtm_bpmn2.Association;
import eu.aniketos.mtm.model.mtm_bpmn2.AssociationDirection;
import eu.aniketos.mtm.model.mtm_bpmn2.Auditing;
import eu.aniketos.mtm.model.mtm_bpmn2.BaseElement;
import eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Factory;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;
import eu.aniketos.mtm.model.mtm_bpmn2.BusinessRuleTask;
import eu.aniketos.mtm.model.mtm_bpmn2.CallActivity;
import eu.aniketos.mtm.model.mtm_bpmn2.CallChoreography;
import eu.aniketos.mtm.model.mtm_bpmn2.CallConversation;
import eu.aniketos.mtm.model.mtm_bpmn2.CallableElement;
import eu.aniketos.mtm.model.mtm_bpmn2.CancelEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.CandidateGroup;
import eu.aniketos.mtm.model.mtm_bpmn2.CandidateUser;
import eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.Category;
import eu.aniketos.mtm.model.mtm_bpmn2.CategoryValue;
import eu.aniketos.mtm.model.mtm_bpmn2.Choreography;
import eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyActivity;
import eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyLoopType;
import eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Collaboration;
import eu.aniketos.mtm.model.mtm_bpmn2.CompensateEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.ComplexBehaviorDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.ComplexDataType;
import eu.aniketos.mtm.model.mtm_bpmn2.ComplexGateway;
import eu.aniketos.mtm.model.mtm_bpmn2.ConditionalEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.Conversation;
import eu.aniketos.mtm.model.mtm_bpmn2.ConversationAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.ConversationLink;
import eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode;
import eu.aniketos.mtm.model.mtm_bpmn2.CorrelationKey;
import eu.aniketos.mtm.model.mtm_bpmn2.CorrelationProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyBinding;
import eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyRetrievalExpression;
import eu.aniketos.mtm.model.mtm_bpmn2.CorrelationSubscription;
import eu.aniketos.mtm.model.mtm_bpmn2.CustomProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.DataAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.DataGrid;
import eu.aniketos.mtm.model.mtm_bpmn2.DataGridField;
import eu.aniketos.mtm.model.mtm_bpmn2.DataGridRow;
import eu.aniketos.mtm.model.mtm_bpmn2.DataInput;
import eu.aniketos.mtm.model.mtm_bpmn2.DataInputAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.DataObject;
import eu.aniketos.mtm.model.mtm_bpmn2.DataObjectReference;
import eu.aniketos.mtm.model.mtm_bpmn2.DataOutput;
import eu.aniketos.mtm.model.mtm_bpmn2.DataOutputAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.DataState;
import eu.aniketos.mtm.model.mtm_bpmn2.DataStore;
import eu.aniketos.mtm.model.mtm_bpmn2.DataStoreReference;
import eu.aniketos.mtm.model.mtm_bpmn2.Definitions;
import eu.aniketos.mtm.model.mtm_bpmn2.DocumentRoot;
import eu.aniketos.mtm.model.mtm_bpmn2.Documentation;
import eu.aniketos.mtm.model.mtm_bpmn2.EndEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.EndPoint;
import eu.aniketos.mtm.model.mtm_bpmn2.ErrorEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.Escalation;
import eu.aniketos.mtm.model.mtm_bpmn2.EscalationEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.Event;
import eu.aniketos.mtm.model.mtm_bpmn2.EventBasedGateway;
import eu.aniketos.mtm.model.mtm_bpmn2.EventBasedGatewayType;
import eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.ExclusiveGateway;
import eu.aniketos.mtm.model.mtm_bpmn2.Expression;
import eu.aniketos.mtm.model.mtm_bpmn2.Extension;
import eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeValue;
import eu.aniketos.mtm.model.mtm_bpmn2.ExtensionDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowElement;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowElementsContainer;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowNode;
import eu.aniketos.mtm.model.mtm_bpmn2.FormProperty;
import eu.aniketos.mtm.model.mtm_bpmn2.FormValue;
import eu.aniketos.mtm.model.mtm_bpmn2.FormalExpression;
import eu.aniketos.mtm.model.mtm_bpmn2.Gateway;
import eu.aniketos.mtm.model.mtm_bpmn2.GatewayDirection;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalBusinessRuleTask;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalChoreographyTask;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalConversation;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalManualTask;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalScriptTask;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalTask;
import eu.aniketos.mtm.model.mtm_bpmn2.GlobalUserTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Group;
import eu.aniketos.mtm.model.mtm_bpmn2.HumanPerformer;
import eu.aniketos.mtm.model.mtm_bpmn2.IOParameter;
import eu.aniketos.mtm.model.mtm_bpmn2.ImplicitThrowEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.Import;
import eu.aniketos.mtm.model.mtm_bpmn2.InclusiveGateway;
import eu.aniketos.mtm.model.mtm_bpmn2.InputOutputBinding;
import eu.aniketos.mtm.model.mtm_bpmn2.InputOutputSpecification;
import eu.aniketos.mtm.model.mtm_bpmn2.InputSet;
import eu.aniketos.mtm.model.mtm_bpmn2.InteractionNode;
import eu.aniketos.mtm.model.mtm_bpmn2.Interface;
import eu.aniketos.mtm.model.mtm_bpmn2.IntermediateCatchEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.IntermediateThrowEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.ItemAwareElement;
import eu.aniketos.mtm.model.mtm_bpmn2.ItemDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.ItemKind;
import eu.aniketos.mtm.model.mtm_bpmn2.Lane;
import eu.aniketos.mtm.model.mtm_bpmn2.LaneSet;
import eu.aniketos.mtm.model.mtm_bpmn2.LinkEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.LoopCharacteristics;
import eu.aniketos.mtm.model.mtm_bpmn2.MailTask;
import eu.aniketos.mtm.model.mtm_bpmn2.ManualTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Message;
import eu.aniketos.mtm.model.mtm_bpmn2.MessageEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.MessageFlow;
import eu.aniketos.mtm.model.mtm_bpmn2.MessageFlowAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.Monitoring;
import eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceBehavior;
import eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics;
import eu.aniketos.mtm.model.mtm_bpmn2.Operation;
import eu.aniketos.mtm.model.mtm_bpmn2.OutputSet;
import eu.aniketos.mtm.model.mtm_bpmn2.ParallelGateway;
import eu.aniketos.mtm.model.mtm_bpmn2.Participant;
import eu.aniketos.mtm.model.mtm_bpmn2.ParticipantAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.ParticipantMultiplicity;
import eu.aniketos.mtm.model.mtm_bpmn2.PartnerEntity;
import eu.aniketos.mtm.model.mtm_bpmn2.PartnerRole;
import eu.aniketos.mtm.model.mtm_bpmn2.Performer;
import eu.aniketos.mtm.model.mtm_bpmn2.PotentialOwner;
import eu.aniketos.mtm.model.mtm_bpmn2.ProcessType;
import eu.aniketos.mtm.model.mtm_bpmn2.Property;
import eu.aniketos.mtm.model.mtm_bpmn2.ReceiveTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Relationship;
import eu.aniketos.mtm.model.mtm_bpmn2.RelationshipDirection;
import eu.aniketos.mtm.model.mtm_bpmn2.Rendering;
import eu.aniketos.mtm.model.mtm_bpmn2.Resource;
import eu.aniketos.mtm.model.mtm_bpmn2.ResourceAssignmentExpression;
import eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameter;
import eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameterBinding;
import eu.aniketos.mtm.model.mtm_bpmn2.ResourceRole;
import eu.aniketos.mtm.model.mtm_bpmn2.RootElement;
import eu.aniketos.mtm.model.mtm_bpmn2.ScriptTask;
import eu.aniketos.mtm.model.mtm_bpmn2.SendTask;
import eu.aniketos.mtm.model.mtm_bpmn2.SequenceFlow;
import eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Signal;
import eu.aniketos.mtm.model.mtm_bpmn2.SignalEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.StandardLoopCharacteristics;
import eu.aniketos.mtm.model.mtm_bpmn2.StartEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.SubChoreography;
import eu.aniketos.mtm.model.mtm_bpmn2.SubConversation;
import eu.aniketos.mtm.model.mtm_bpmn2.SubProcess;
import eu.aniketos.mtm.model.mtm_bpmn2.Task;
import eu.aniketos.mtm.model.mtm_bpmn2.TerminateEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.TextAnnotation;
import eu.aniketos.mtm.model.mtm_bpmn2.ThrowEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.TimerEventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.Transaction;
import eu.aniketos.mtm.model.mtm_bpmn2.UserTask;

import eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage;

import eu.aniketos.mtm.model.mtm_bpmndi.impl.BpmnDiPackageImpl;

import eu.aniketos.mtm.model.mtm_dc.DcPackage;

import eu.aniketos.mtm.model.mtm_dc.impl.DcPackageImpl;

import eu.aniketos.mtm.model.mtm_di.DiPackage;

import eu.aniketos.mtm.model.mtm_di.impl.DiPackageImpl;

import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;

import eu.aniketos.mtm.model.mtm_securebpmn2.impl.Securebpmn2PackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bpmn2PackageImpl extends EPackageImpl implements Bpmn2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adHocSubProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass auditingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundaryEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessRuleTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callChoreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callConversationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cancelEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choreographyActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choreographyTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collaborationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compensateEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexBehaviorDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conversationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationPropertyBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationPropertyRetrievalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass correlationSubscriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataInputAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataObjectReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataOutputAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStoreReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass escalationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass escalationEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventBasedGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exclusiveGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionAttributeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionAttributeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowElementsContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalBusinessRuleTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalChoreographyTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalConversationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalManualTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalScriptTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalUserTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanPerformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implicitThrowEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inclusiveGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputOutputBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputOutputSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateCatchEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateThrowEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemAwareElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopCharacteristicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manualTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageFlowAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monitoringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiInstanceLoopCharacteristicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelGatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantMultiplicityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass performerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass potentialOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renderingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceAssignmentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scriptTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardLoopCharacteristicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subChoreographyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subConversationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminateEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timerEventDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass candidateUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass candidateGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mailTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataGridRowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataGridFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activitiListenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ioParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alfrescoUserTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alfrescoStartEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alfrescoScriptTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alfrescoScriptBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alfrescoMailTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum adHocOrderingEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum associationDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum choreographyLoopTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventBasedGatewayTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum gatewayDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum itemKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiInstanceBehaviorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationshipDirectionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Bpmn2PackageImpl() {
		super(eNS_URI, Bpmn2Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Bpmn2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Bpmn2Package init() {
		if (isInited) return (Bpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI);

		// Obtain or create and register package
		Bpmn2PackageImpl theBpmn2Package = (Bpmn2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Bpmn2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Bpmn2PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Securebpmn2PackageImpl theSecurebpmn2Package = (Securebpmn2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI) instanceof Securebpmn2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI) : Securebpmn2Package.eINSTANCE);
		BpmnDiPackageImpl theBpmnDiPackage = (BpmnDiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) instanceof BpmnDiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) : BpmnDiPackage.eINSTANCE);
		AniketosPackageImpl theAniketosPackage = (AniketosPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI) instanceof AniketosPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI) : AniketosPackage.eINSTANCE);
		DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) : DiPackage.eINSTANCE);
		DcPackageImpl theDcPackage = (DcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) instanceof DcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) : DcPackage.eINSTANCE);

		// Create package meta-data objects
		theBpmn2Package.createPackageContents();
		theSecurebpmn2Package.createPackageContents();
		theBpmnDiPackage.createPackageContents();
		theAniketosPackage.createPackageContents();
		theDiPackage.createPackageContents();
		theDcPackage.createPackageContents();

		// Initialize created meta-data
		theBpmn2Package.initializePackageContents();
		theSecurebpmn2Package.initializePackageContents();
		theBpmnDiPackage.initializePackageContents();
		theAniketosPackage.initializePackageContents();
		theDiPackage.initializePackageContents();
		theDcPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBpmn2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Bpmn2Package.eNS_URI, theBpmn2Package);
		return theBpmn2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Activity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AdHocSubProcess() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FlowElement() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Artifact() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Assignment() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Association() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Auditing() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BaseElement() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BaseElementWithMixedContent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BoundaryEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BusinessRuleTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CallableElement() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CallActivity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CallChoreography() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CallConversation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConversationNode() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CancelEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_RootElement() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CatchEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Category() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CategoryValue() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Choreography() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Collaboration() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ChoreographyActivity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ChoreographyTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CompensateEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ComplexBehaviorDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ComplexGateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConditionalEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Conversation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConversationAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ConversationLink() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CorrelationKey() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CorrelationProperty() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CorrelationPropertyBinding() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CorrelationPropertyRetrievalExpression() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_CorrelationSubscription() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataInput() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataInputAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataObject() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataObjectReference() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataOutput() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataOutputAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataState() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataStore() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_DataStoreReference() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(50);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Definitions() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(51);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Documentation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(52);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EndEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(53);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EndPoint() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(54);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Error() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(55);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ErrorEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(56);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Escalation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(57);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EscalationEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(58);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Event() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(59);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_EventBasedGateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(60);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ExclusiveGateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(61);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Expression() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(62);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Extension() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(63);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ExtensionElements() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(64);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FlowNode() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(65);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_FormalExpression() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(66);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Gateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(67);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalBusinessRuleTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(68);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalChoreographyTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(69);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalConversation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(70);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalManualTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(71);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalScriptTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(72);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(73);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_GlobalUserTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(74);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Group() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(75);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HumanPerformer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(76);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Performer() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(77);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceRole() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(78);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ImplicitThrowEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(79);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Import() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(80);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InclusiveGateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(81);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_InputSet() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(82);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Interface() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(83);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_IntermediateCatchEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(84);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_IntermediateThrowEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(85);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_IoBinding() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(86);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_IoSpecification() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(87);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ItemDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(88);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Lane() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(89);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LaneSet() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(90);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LinkEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(91);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LoopCharacteristics() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(92);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ManualTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(93);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Message() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(94);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MessageEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(95);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MessageFlow() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MessageFlowAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(97);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Monitoring() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(98);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_MultiInstanceLoopCharacteristics() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(99);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Operation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(100);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_OutputSet() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(101);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ParallelGateway() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(102);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Participant() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(103);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ParticipantAssociation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(104);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ParticipantMultiplicity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(105);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PartnerEntity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(106);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PartnerRole() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(107);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PotentialOwner() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(108);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Process() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(109);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Property() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(110);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ReceiveTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(111);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Relationship() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(112);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Rendering() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(113);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Resource() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(114);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceAssignmentExpression() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(115);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceParameter() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(116);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceParameterBinding() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(117);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Script() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(118);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ScriptTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(119);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SendTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(120);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SequenceFlow() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(121);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ServiceTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(122);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Signal() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(123);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SignalEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(124);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_StandardLoopCharacteristics() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(125);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_StartEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(126);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubChoreography() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(127);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubConversation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(128);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_SubProcess() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(129);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Task() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(130);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TerminateEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(131);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Text() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(132);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TextAnnotation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(133);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ThrowEvent() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(134);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TimerEventDefinition() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(135);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Transaction() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(136);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_UserTask() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(137);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_IoSpecification() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_BoundaryEventRefs() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Properties() {
		return (EReference)activityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_DataInputAssociations() {
		return (EReference)activityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_DataOutputAssociations() {
		return (EReference)activityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Resources() {
		return (EReference)activityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_LoopCharacteristics() {
		return (EReference)activityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_CompletionQuantity() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Default() {
		return (EReference)activityEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_IsForCompensation() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_StartQuantity() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_ActivitiListeners() {
		return (EReference)activityEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_Asynchronous() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_ActivityActions() {
		return (EReference)activityEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_ActivityAuthorizationConstraints() {
		return (EReference)activityEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdHocSubProcess() {
		return adHocSubProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdHocSubProcess_CompletionCondition() {
		return (EReference)adHocSubProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdHocSubProcess_CancelRemainingInstances() {
		return (EAttribute)adHocSubProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdHocSubProcess_Ordering() {
		return (EAttribute)adHocSubProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifact() {
		return artifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_From() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_To() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_AssociationDirection() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_SourceRef() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_TargetRef() {
		return (EReference)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuditing() {
		return auditingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseElement() {
		return baseElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseElement_ExtensionValues() {
		return (EReference)baseElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseElement_Documentation() {
		return (EReference)baseElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseElement_ExtensionDefinitions() {
		return (EReference)baseElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseElement_Id() {
		return (EAttribute)baseElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundaryEvent() {
		return boundaryEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundaryEvent_AttachedToRef() {
		return (EReference)boundaryEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundaryEvent_CancelActivity() {
		return (EAttribute)boundaryEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessRuleTask() {
		return businessRuleTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRuleTask_Implementation() {
		return (EAttribute)businessRuleTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRuleTask_RuleNames() {
		return (EAttribute)businessRuleTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRuleTask_InputVariables() {
		return (EAttribute)businessRuleTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRuleTask_ResultVariableName() {
		return (EAttribute)businessRuleTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessRuleTask_Exclude() {
		return (EAttribute)businessRuleTaskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallActivity() {
		return callActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallActivity_CalledElementRef() {
		return (EReference)callActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallActivity_CalledElement() {
		return (EAttribute)callActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallActivity_InParameters() {
		return (EReference)callActivityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallActivity_OutParameters() {
		return (EReference)callActivityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallChoreography() {
		return callChoreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallChoreography_ParticipantAssociations() {
		return (EReference)callChoreographyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallChoreography_CalledChoreographyRef() {
		return (EReference)callChoreographyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallConversation() {
		return callConversationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallConversation_ParticipantAssociations() {
		return (EReference)callConversationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallConversation_CalledCollaborationRef() {
		return (EReference)callConversationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallableElement() {
		return callableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallableElement_SupportedInterfaceRefs() {
		return (EReference)callableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallableElement_IoSpecification() {
		return (EReference)callableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallableElement_IoBinding() {
		return (EReference)callableElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallableElement_Name() {
		return (EAttribute)callableElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCancelEventDefinition() {
		return cancelEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatchEvent() {
		return catchEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchEvent_DataOutputs() {
		return (EReference)catchEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchEvent_DataOutputAssociation() {
		return (EReference)catchEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchEvent_OutputSet() {
		return (EReference)catchEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchEvent_EventDefinitions() {
		return (EReference)catchEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchEvent_EventDefinitionRefs() {
		return (EReference)catchEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatchEvent_ParallelMultiple() {
		return (EAttribute)catchEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategory_CategoryValue() {
		return (EReference)categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategory_Name() {
		return (EAttribute)categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategoryValue() {
		return categoryValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCategoryValue_Value() {
		return (EAttribute)categoryValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategoryValue_CategorizedFlowElements() {
		return (EReference)categoryValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoreography() {
		return choreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoreographyActivity() {
		return choreographyActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreographyActivity_ParticipantRefs() {
		return (EReference)choreographyActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreographyActivity_CorrelationKeys() {
		return (EReference)choreographyActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreographyActivity_InitiatingParticipantRef() {
		return (EReference)choreographyActivityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoreographyActivity_LoopType() {
		return (EAttribute)choreographyActivityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoreographyTask() {
		return choreographyTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoreographyTask_MessageFlowRef() {
		return (EReference)choreographyTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollaboration() {
		return collaborationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_Participants() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_MessageFlows() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_Artifacts() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_Conversations() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_ConversationAssociations() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_ParticipantAssociations() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_MessageFlowAssociations() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_CorrelationKeys() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_ChoreographyRef() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollaboration_ConversationLinks() {
		return (EReference)collaborationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollaboration_IsClosed() {
		return (EAttribute)collaborationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollaboration_Name() {
		return (EAttribute)collaborationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompensateEventDefinition() {
		return compensateEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompensateEventDefinition_ActivityRef() {
		return (EReference)compensateEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompensateEventDefinition_WaitForCompletion() {
		return (EAttribute)compensateEventDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexBehaviorDefinition() {
		return complexBehaviorDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexBehaviorDefinition_Condition() {
		return (EReference)complexBehaviorDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexBehaviorDefinition_Event() {
		return (EReference)complexBehaviorDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexGateway() {
		return complexGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexGateway_ActivationCondition() {
		return (EReference)complexGatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexGateway_Default() {
		return (EReference)complexGatewayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalEventDefinition() {
		return conditionalEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalEventDefinition_Condition() {
		return (EReference)conditionalEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConversation() {
		return conversationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConversationAssociation() {
		return conversationAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationAssociation_InnerConversationNodeRef() {
		return (EReference)conversationAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationAssociation_OuterConversationNodeRef() {
		return (EReference)conversationAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConversationLink() {
		return conversationLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConversationLink_Name() {
		return (EAttribute)conversationLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationLink_SourceRef() {
		return (EReference)conversationLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationLink_TargetRef() {
		return (EReference)conversationLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConversationNode() {
		return conversationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationNode_ParticipantRefs() {
		return (EReference)conversationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationNode_MessageFlowRefs() {
		return (EReference)conversationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConversationNode_CorrelationKeys() {
		return (EReference)conversationNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConversationNode_Name() {
		return (EAttribute)conversationNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationKey() {
		return correlationKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationKey_CorrelationPropertyRef() {
		return (EReference)correlationKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCorrelationKey_Name() {
		return (EAttribute)correlationKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationProperty() {
		return correlationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationProperty_CorrelationPropertyRetrievalExpression() {
		return (EReference)correlationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCorrelationProperty_Name() {
		return (EAttribute)correlationPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationProperty_Type() {
		return (EReference)correlationPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationPropertyBinding() {
		return correlationPropertyBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationPropertyBinding_DataPath() {
		return (EReference)correlationPropertyBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationPropertyBinding_CorrelationPropertyRef() {
		return (EReference)correlationPropertyBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationPropertyRetrievalExpression() {
		return correlationPropertyRetrievalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationPropertyRetrievalExpression_MessagePath() {
		return (EReference)correlationPropertyRetrievalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationPropertyRetrievalExpression_MessageRef() {
		return (EReference)correlationPropertyRetrievalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCorrelationSubscription() {
		return correlationSubscriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationSubscription_CorrelationPropertyBinding() {
		return (EReference)correlationSubscriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCorrelationSubscription_CorrelationKeyRef() {
		return (EReference)correlationSubscriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataAssociation() {
		return dataAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataAssociation_SourceRef() {
		return (EReference)dataAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataAssociation_TargetRef() {
		return (EReference)dataAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataAssociation_Transformation() {
		return (EReference)dataAssociationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataAssociation_Assignment() {
		return (EReference)dataAssociationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataInput() {
		return dataInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataInput_InputSetWithOptional() {
		return (EReference)dataInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataInput_InputSetWithWhileExecuting() {
		return (EReference)dataInputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataInput_InputSetRefs() {
		return (EReference)dataInputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataInput_IsCollection() {
		return (EAttribute)dataInputEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataInput_Name() {
		return (EAttribute)dataInputEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataInputAssociation() {
		return dataInputAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObject() {
		return dataObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_IsCollection() {
		return (EAttribute)dataObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObjectReference() {
		return dataObjectReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataObjectReference_DataObjectRef() {
		return (EReference)dataObjectReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataOutput() {
		return dataOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataOutput_OutputSetWithOptional() {
		return (EReference)dataOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataOutput_OutputSetWithWhileExecuting() {
		return (EReference)dataOutputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataOutput_OutputSetRefs() {
		return (EReference)dataOutputEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataOutput_IsCollection() {
		return (EAttribute)dataOutputEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataOutput_Name() {
		return (EAttribute)dataOutputEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataOutputAssociation() {
		return dataOutputAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataState() {
		return dataStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataState_Name() {
		return (EAttribute)dataStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataStore() {
		return dataStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataStore_Capacity() {
		return (EAttribute)dataStoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataStore_IsUnlimited() {
		return (EAttribute)dataStoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataStore_Name() {
		return (EAttribute)dataStoreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataStoreReference() {
		return dataStoreReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataStoreReference_DataStoreRef() {
		return (EReference)dataStoreReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinitions() {
		return definitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Imports() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Extensions() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_RootElements() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Diagrams() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Relationships() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_Exporter() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_ExporterVersion() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_ExpressionLanguage() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_Name() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_TargetNamespace() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_TypeLanguage() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentation() {
		return documentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_Text() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentation_TextFormat() {
		return (EAttribute)documentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndEvent() {
		return endEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPoint() {
		return endPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getError() {
		return errorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getError_ErrorCode() {
		return (EAttribute)errorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getError_Name() {
		return (EAttribute)errorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getError_StructureRef() {
		return (EReference)errorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorEventDefinition() {
		return errorEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getErrorEventDefinition_ErrorRef() {
		return (EReference)errorEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorEventDefinition_ErrorCode() {
		return (EAttribute)errorEventDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEscalation() {
		return escalationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEscalation_EscalationCode() {
		return (EAttribute)escalationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEscalation_Name() {
		return (EAttribute)escalationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEscalation_StructureRef() {
		return (EReference)escalationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEscalationEventDefinition() {
		return escalationEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEscalationEventDefinition_EscalationRef() {
		return (EReference)escalationEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Properties() {
		return (EReference)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventBasedGateway() {
		return eventBasedGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventBasedGateway_EventGatewayType() {
		return (EAttribute)eventBasedGatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventBasedGateway_Instantiate() {
		return (EAttribute)eventBasedGatewayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventDefinition() {
		return eventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExclusiveGateway() {
		return exclusiveGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExclusiveGateway_Default() {
		return (EReference)exclusiveGatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtension() {
		return extensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_Definition() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtension_MustUnderstand() {
		return (EAttribute)extensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionAttributeDefinition() {
		return extensionAttributeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionAttributeDefinition_Name() {
		return (EAttribute)extensionAttributeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionAttributeDefinition_Type() {
		return (EAttribute)extensionAttributeDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionAttributeDefinition_IsReference() {
		return (EAttribute)extensionAttributeDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionAttributeDefinition_ExtensionDefinition() {
		return (EReference)extensionAttributeDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionAttributeValue() {
		return extensionAttributeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionAttributeValue_ValueRef() {
		return (EReference)extensionAttributeValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionAttributeValue_Value() {
		return (EReference)extensionAttributeValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionAttributeValue_ExtensionAttributeDefinition() {
		return (EReference)extensionAttributeValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionDefinition() {
		return extensionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionDefinition_Name() {
		return (EAttribute)extensionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionDefinition_ExtensionAttributeDefinitions() {
		return (EReference)extensionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowElement() {
		return flowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowElement_Auditing() {
		return (EReference)flowElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowElement_Monitoring() {
		return (EReference)flowElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowElement_CategoryValueRef() {
		return (EReference)flowElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowElement_Name() {
		return (EAttribute)flowElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowElementsContainer() {
		return flowElementsContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowElementsContainer_LaneSets() {
		return (EReference)flowElementsContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowElementsContainer_FlowElements() {
		return (EReference)flowElementsContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowNode() {
		return flowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_Incoming() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_Lanes() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_Outgoing() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_IncomingSecurityFlow() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowNode_OutgoingSecurityFlow() {
		return (EReference)flowNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormalExpression() {
		return formalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormalExpression_EvaluatesToTypeRef() {
		return (EReference)formalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormalExpression_Language() {
		return (EAttribute)formalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormalExpression_Body() {
		return (EAttribute)formalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGateway() {
		return gatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGateway_GatewayDirection() {
		return (EAttribute)gatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalBusinessRuleTask() {
		return globalBusinessRuleTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalBusinessRuleTask_Implementation() {
		return (EAttribute)globalBusinessRuleTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalChoreographyTask() {
		return globalChoreographyTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalChoreographyTask_InitiatingParticipantRef() {
		return (EReference)globalChoreographyTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalConversation() {
		return globalConversationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalManualTask() {
		return globalManualTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalScriptTask() {
		return globalScriptTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalScriptTask_Script() {
		return (EAttribute)globalScriptTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalScriptTask_ScriptLanguage() {
		return (EAttribute)globalScriptTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalTask() {
		return globalTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalTask_Resources() {
		return (EReference)globalTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalUserTask() {
		return globalUserTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalUserTask_Renderings() {
		return (EReference)globalUserTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalUserTask_Implementation() {
		return (EAttribute)globalUserTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_CategoryValueRef() {
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHumanPerformer() {
		return humanPerformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplicitThrowEvent() {
		return implicitThrowEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_ImportType() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Location() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Namespace() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInclusiveGateway() {
		return inclusiveGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclusiveGateway_Default() {
		return (EReference)inclusiveGatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputOutputBinding() {
		return inputOutputBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputBinding_InputDataRef() {
		return (EReference)inputOutputBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputBinding_OperationRef() {
		return (EReference)inputOutputBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputBinding_OutputDataRef() {
		return (EReference)inputOutputBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputOutputSpecification() {
		return inputOutputSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputSpecification_DataInputs() {
		return (EReference)inputOutputSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputSpecification_DataOutputs() {
		return (EReference)inputOutputSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputSpecification_InputSets() {
		return (EReference)inputOutputSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputOutputSpecification_OutputSets() {
		return (EReference)inputOutputSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputSet() {
		return inputSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputSet_DataInputRefs() {
		return (EReference)inputSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputSet_OptionalInputRefs() {
		return (EReference)inputSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputSet_WhileExecutingInputRefs() {
		return (EReference)inputSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputSet_OutputSetRefs() {
		return (EReference)inputSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputSet_Name() {
		return (EAttribute)inputSetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteractionNode() {
		return interactionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionNode_IncomingConversationLinks() {
		return (EReference)interactionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionNode_OutgoingConversationLinks() {
		return (EReference)interactionNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Operations() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_ImplementationRef() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Name() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateCatchEvent() {
		return intermediateCatchEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateThrowEvent() {
		return intermediateThrowEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemAwareElement() {
		return itemAwareElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemAwareElement_DataState() {
		return (EReference)itemAwareElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemAwareElement_ItemSubjectRef() {
		return (EReference)itemAwareElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemAwareElement_ItemAwareElementActions() {
		return (EReference)itemAwareElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemDefinition() {
		return itemDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItemDefinition_IsCollection() {
		return (EAttribute)itemDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemDefinition_Import() {
		return (EReference)itemDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItemDefinition_ItemKind() {
		return (EAttribute)itemDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemDefinition_StructureRef() {
		return (EReference)itemDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLane() {
		return laneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_PartitionElement() {
		return (EReference)laneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_FlowNodeRefs() {
		return (EReference)laneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_ChildLaneSet() {
		return (EReference)laneEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLane_Name() {
		return (EAttribute)laneEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_PartitionElementRef() {
		return (EReference)laneEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaneSet() {
		return laneSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaneSet_Lanes() {
		return (EReference)laneSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaneSet_Name() {
		return (EAttribute)laneSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkEventDefinition() {
		return linkEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEventDefinition_Source() {
		return (EReference)linkEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkEventDefinition_Target() {
		return (EReference)linkEventDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkEventDefinition_Name() {
		return (EAttribute)linkEventDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopCharacteristics() {
		return loopCharacteristicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManualTask() {
		return manualTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessage_ItemRef() {
		return (EReference)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessage_Name() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageEventDefinition() {
		return messageEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEventDefinition_OperationRef() {
		return (EReference)messageEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageEventDefinition_MessageRef() {
		return (EReference)messageEventDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageFlow() {
		return messageFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlow_MessageRef() {
		return (EReference)messageFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageFlow_Name() {
		return (EAttribute)messageFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlow_SourceRef() {
		return (EReference)messageFlowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlow_TargetRef() {
		return (EReference)messageFlowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageFlowAssociation() {
		return messageFlowAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlowAssociation_InnerMessageFlowRef() {
		return (EReference)messageFlowAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlowAssociation_OuterMessageFlowRef() {
		return (EReference)messageFlowAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonitoring() {
		return monitoringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiInstanceLoopCharacteristics() {
		return multiInstanceLoopCharacteristicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_LoopDataInputRef() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_LoopDataOutputRef() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_OutputDataItem() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_Behavior() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_IsSequential() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiInstanceLoopCharacteristics_OneBehaviorEventRef() {
		return (EReference)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_LoopCardinality() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_InputDataItem() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_CompletionCondition() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiInstanceLoopCharacteristics_ElementVariable() {
		return (EAttribute)multiInstanceLoopCharacteristicsEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_InMessageRef() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_OutMessageRef() {
		return (EReference)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_ErrorRefs() {
		return (EReference)operationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_ImplementationRef() {
		return (EReference)operationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_Name() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputSet() {
		return outputSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputSet_DataOutputRefs() {
		return (EReference)outputSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputSet_OptionalOutputRefs() {
		return (EReference)outputSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputSet_WhileExecutingOutputRefs() {
		return (EReference)outputSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputSet_InputSetRefs() {
		return (EReference)outputSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutputSet_Name() {
		return (EAttribute)outputSetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelGateway() {
		return parallelGatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipant() {
		return participantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_InterfaceRefs() {
		return (EReference)participantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_EndPointRefs() {
		return (EReference)participantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_ParticipantMultiplicity() {
		return (EReference)participantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipant_Name() {
		return (EAttribute)participantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_ProcessRef() {
		return (EReference)participantEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipantAssociation() {
		return participantAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipantAssociation_InnerParticipantRef() {
		return (EReference)participantAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipantAssociation_OuterParticipantRef() {
		return (EReference)participantAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipantMultiplicity() {
		return participantMultiplicityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipantMultiplicity_Maximum() {
		return (EAttribute)participantMultiplicityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipantMultiplicity_Minimum() {
		return (EAttribute)participantMultiplicityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerEntity() {
		return partnerEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerEntity_ParticipantRef() {
		return (EReference)partnerEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerEntity_Name() {
		return (EAttribute)partnerEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerRole() {
		return partnerRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerRole_ParticipantRef() {
		return (EReference)partnerRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerRole_Name() {
		return (EAttribute)partnerRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerformer() {
		return performerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPotentialOwner() {
		return potentialOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Auditing() {
		return (EReference)processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Monitoring() {
		return (EReference)processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Properties() {
		return (EReference)processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Artifacts() {
		return (EReference)processEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Resources() {
		return (EReference)processEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_CorrelationSubscriptions() {
		return (EReference)processEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_Supports() {
		return (EReference)processEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_DefinitionalCollaborationRef() {
		return (EReference)processEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_IsClosed() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_IsExecutable() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_ProcessType() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_Filename() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_ExecutionListeners() {
		return (EReference)processEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_Namespace() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_ProcessActions() {
		return (EReference)processEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceiveTask() {
		return receiveTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReceiveTask_Implementation() {
		return (EAttribute)receiveTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReceiveTask_Instantiate() {
		return (EAttribute)receiveTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveTask_MessageRef() {
		return (EReference)receiveTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReceiveTask_OperationRef() {
		return (EReference)receiveTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Sources() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_Targets() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Direction() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Type() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRendering() {
		return renderingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_ResourceParameters() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Name() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceAssignmentExpression() {
		return resourceAssignmentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceAssignmentExpression_Expression() {
		return (EReference)resourceAssignmentExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceParameter() {
		return resourceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceParameter_IsRequired() {
		return (EAttribute)resourceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceParameter_Name() {
		return (EAttribute)resourceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameter_Type() {
		return (EReference)resourceParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceParameterBinding() {
		return resourceParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameterBinding_Expression() {
		return (EReference)resourceParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameterBinding_ParameterRef() {
		return (EReference)resourceParameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceRole() {
		return resourceRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRole_ResourceRef() {
		return (EReference)resourceRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRole_ResourceParameterBindings() {
		return (EReference)resourceRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceRole_ResourceAssignmentExpression() {
		return (EReference)resourceRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceRole_Name() {
		return (EAttribute)resourceRoleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootElement() {
		return rootElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScriptTask() {
		return scriptTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptTask_Script() {
		return (EAttribute)scriptTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScriptTask_ScriptFormat() {
		return (EAttribute)scriptTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSendTask() {
		return sendTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSendTask_Implementation() {
		return (EAttribute)sendTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendTask_MessageRef() {
		return (EReference)sendTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSendTask_OperationRef() {
		return (EReference)sendTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceFlow() {
		return sequenceFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_ConditionExpression() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceFlow_IsImmediate() {
		return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_SourceRef() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_TargetRef() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_ExecutionListeners() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceTask() {
		return serviceTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTask_Implementation() {
		return (EAttribute)serviceTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTask_OperationRef() {
		return (EReference)serviceTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTask_CustomProperties() {
		return (EReference)serviceTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTask_ImplementationType() {
		return (EAttribute)serviceTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTask_FieldExtensions() {
		return (EReference)serviceTaskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceTask_ResultVariableName() {
		return (EAttribute)serviceTaskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceTask_SecurityExtensions() {
		return (EReference)serviceTaskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignal() {
		return signalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignal_Name() {
		return (EAttribute)signalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignal_StructureRef() {
		return (EReference)signalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignalEventDefinition() {
		return signalEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignalEventDefinition_SignalRef() {
		return (EReference)signalEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardLoopCharacteristics() {
		return standardLoopCharacteristicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardLoopCharacteristics_LoopCondition() {
		return (EReference)standardLoopCharacteristicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardLoopCharacteristics_LoopMaximum() {
		return (EReference)standardLoopCharacteristicsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardLoopCharacteristics_TestBefore() {
		return (EAttribute)standardLoopCharacteristicsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartEvent() {
		return startEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartEvent_IsInterrupting() {
		return (EAttribute)startEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartEvent_FormKey() {
		return (EAttribute)startEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartEvent_FormProperties() {
		return (EReference)startEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartEvent_Initiator() {
		return (EAttribute)startEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubChoreography() {
		return subChoreographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubChoreography_Artifacts() {
		return (EReference)subChoreographyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubConversation() {
		return subConversationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubConversation_ConversationNodes() {
		return (EReference)subConversationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubProcess() {
		return subProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubProcess_Artifacts() {
		return (EReference)subProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubProcess_TriggeredByEvent() {
		return (EAttribute)subProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminateEventDefinition() {
		return terminateEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextAnnotation() {
		return textAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextAnnotation_Text() {
		return (EAttribute)textAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextAnnotation_TextFormat() {
		return (EAttribute)textAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrowEvent() {
		return throwEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowEvent_DataInputs() {
		return (EReference)throwEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowEvent_DataInputAssociation() {
		return (EReference)throwEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowEvent_InputSet() {
		return (EReference)throwEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowEvent_EventDefinitions() {
		return (EReference)throwEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowEvent_EventDefinitionRefs() {
		return (EReference)throwEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimerEventDefinition() {
		return timerEventDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimerEventDefinition_TimeDate() {
		return (EReference)timerEventDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimerEventDefinition_TimeDuration() {
		return (EReference)timerEventDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimerEventDefinition_TimeCycle() {
		return (EReference)timerEventDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransaction() {
		return transactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransaction_Protocol() {
		return (EAttribute)transactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransaction_Method() {
		return (EAttribute)transactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserTask() {
		return userTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserTask_Renderings() {
		return (EReference)userTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserTask_Implementation() {
		return (EAttribute)userTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserTask_Assignee() {
		return (EAttribute)userTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserTask_CandidateUsers() {
		return (EReference)userTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserTask_CandidateGroups() {
		return (EReference)userTaskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserTask_FormKey() {
		return (EAttribute)userTaskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserTask_FormProperties() {
		return (EReference)userTaskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserTask_Priority() {
		return (EAttribute)userTaskEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserTask_DueDate() {
		return (EAttribute)userTaskEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCandidateUser() {
		return candidateUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCandidateUser_User() {
		return (EAttribute)candidateUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCandidateGroup() {
		return candidateGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCandidateGroup_Group() {
		return (EAttribute)candidateGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomProperty() {
		return customPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomProperty_Name() {
		return (EAttribute)customPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomProperty_SimpleValue() {
		return (EAttribute)customPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomProperty_ComplexValue() {
		return (EReference)customPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMailTask() {
		return mailTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_To() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_From() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_Subject() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_Cc() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_Bcc() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_Html() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMailTask_Text() {
		return (EAttribute)mailTaskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldExtension() {
		return fieldExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldExtension_Fieldname() {
		return (EAttribute)fieldExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldExtension_Expression() {
		return (EAttribute)fieldExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexDataType() {
		return complexDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataGrid() {
		return dataGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataGrid_Row() {
		return (EReference)dataGridEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataGridRow() {
		return dataGridRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataGridRow_Index() {
		return (EAttribute)dataGridRowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataGridRow_Field() {
		return (EReference)dataGridRowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataGridField() {
		return dataGridFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataGridField_Name() {
		return (EAttribute)dataGridFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataGridField_SimpleValue() {
		return (EAttribute)dataGridFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivitiListener() {
		return activitiListenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivitiListener_ImplementationType() {
		return (EAttribute)activitiListenerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivitiListener_Implementation() {
		return (EAttribute)activitiListenerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivitiListener_Event() {
		return (EAttribute)activitiListenerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivitiListener_FieldExtensions() {
		return (EReference)activitiListenerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivitiListener_RunAs() {
		return (EAttribute)activitiListenerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivitiListener_ScriptProcessor() {
		return (EAttribute)activitiListenerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormProperty() {
		return formPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Name() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Type() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Value() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Readable() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Writeable() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormProperty_Required() {
		return (EAttribute)formPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormProperty_FormValues() {
		return (EReference)formPropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIOParameter() {
		return ioParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOParameter_Source() {
		return (EAttribute)ioParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIOParameter_Target() {
		return (EAttribute)ioParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlfrescoUserTask() {
		return alfrescoUserTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlfrescoStartEvent() {
		return alfrescoStartEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlfrescoScriptTask() {
		return alfrescoScriptTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoScriptTask_Script() {
		return (EAttribute)alfrescoScriptTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlfrescoScriptBase() {
		return alfrescoScriptBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoScriptBase_RunAs() {
		return (EAttribute)alfrescoScriptBaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoScriptBase_ScriptProcessor() {
		return (EAttribute)alfrescoScriptBaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlfrescoMailTask() {
		return alfrescoMailTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoMailTask_ToMany() {
		return (EAttribute)alfrescoMailTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoMailTask_Template() {
		return (EAttribute)alfrescoMailTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAlfrescoMailTask_TemplateModel() {
		return (EAttribute)alfrescoMailTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormValue() {
		return formValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormValue_ValueId() {
		return (EAttribute)formValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormValue_ValueName() {
		return (EAttribute)formValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdHocOrdering() {
		return adHocOrderingEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssociationDirection() {
		return associationDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChoreographyLoopType() {
		return choreographyLoopTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventBasedGatewayType() {
		return eventBasedGatewayTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGatewayDirection() {
		return gatewayDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getItemKind() {
		return itemKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiInstanceBehavior() {
		return multiInstanceBehaviorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessType() {
		return processTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationshipDirection() {
		return relationshipDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bpmn2Factory getBpmn2Factory() {
		return (Bpmn2Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ACTIVITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__AD_HOC_SUB_PROCESS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FLOW_ELEMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ARTIFACT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ASSIGNMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__AUDITING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BASE_ELEMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BASE_ELEMENT_WITH_MIXED_CONTENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BOUNDARY_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BUSINESS_RULE_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CALLABLE_ELEMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CALL_ACTIVITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CALL_CHOREOGRAPHY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CALL_CONVERSATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERSATION_NODE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CANCEL_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ROOT_ELEMENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CATCH_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CATEGORY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CATEGORY_VALUE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CHOREOGRAPHY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COLLABORATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CHOREOGRAPHY_ACTIVITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CHOREOGRAPHY_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPENSATE_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPLEX_BEHAVIOR_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPLEX_GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONDITIONAL_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERSATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERSATION_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONVERSATION_LINK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CORRELATION_KEY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CORRELATION_PROPERTY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CORRELATION_PROPERTY_BINDING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CORRELATION_SUBSCRIPTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_INPUT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_INPUT_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_OBJECT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_OBJECT_REFERENCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_OUTPUT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_OUTPUT_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_STATE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_STORE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DATA_STORE_REFERENCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEFINITIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DOCUMENTATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__END_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__END_POINT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ERROR);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ERROR_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ESCALATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ESCALATION_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EVENT_BASED_GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXCLUSIVE_GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXPRESSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXTENSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXTENSION_ELEMENTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FLOW_NODE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FORMAL_EXPRESSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_BUSINESS_RULE_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_CHOREOGRAPHY_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_CONVERSATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_MANUAL_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_SCRIPT_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GLOBAL_USER_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GROUP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HUMAN_PERFORMER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PERFORMER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_ROLE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IMPLICIT_THROW_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IMPORT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INCLUSIVE_GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INPUT_SET);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INTERFACE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INTERMEDIATE_CATCH_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INTERMEDIATE_THROW_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IO_BINDING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IO_SPECIFICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ITEM_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LANE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LANE_SET);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LINK_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LOOP_CHARACTERISTICS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MANUAL_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE_FLOW);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MESSAGE_FLOW_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MONITORING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MULTI_INSTANCE_LOOP_CHARACTERISTICS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OPERATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OUTPUT_SET);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARALLEL_GATEWAY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARTICIPANT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARTICIPANT_ASSOCIATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARTICIPANT_MULTIPLICITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARTNER_ENTITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARTNER_ROLE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__POTENTIAL_OWNER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROCESS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RECEIVE_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RELATIONSHIP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RENDERING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_ASSIGNMENT_EXPRESSION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_PARAMETER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_PARAMETER_BINDING);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SCRIPT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SCRIPT_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SEND_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SEQUENCE_FLOW);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SERVICE_TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIGNAL);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SIGNAL_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__STANDARD_LOOP_CHARACTERISTICS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__START_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_CHOREOGRAPHY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_CONVERSATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SUB_PROCESS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TERMINATE_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TEXT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TEXT_ANNOTATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__THROW_EVENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TIMER_EVENT_DEFINITION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TRANSACTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__USER_TASK);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__IO_SPECIFICATION);
		createEReference(activityEClass, ACTIVITY__BOUNDARY_EVENT_REFS);
		createEReference(activityEClass, ACTIVITY__PROPERTIES);
		createEReference(activityEClass, ACTIVITY__DATA_INPUT_ASSOCIATIONS);
		createEReference(activityEClass, ACTIVITY__DATA_OUTPUT_ASSOCIATIONS);
		createEReference(activityEClass, ACTIVITY__RESOURCES);
		createEReference(activityEClass, ACTIVITY__LOOP_CHARACTERISTICS);
		createEAttribute(activityEClass, ACTIVITY__COMPLETION_QUANTITY);
		createEReference(activityEClass, ACTIVITY__DEFAULT);
		createEAttribute(activityEClass, ACTIVITY__IS_FOR_COMPENSATION);
		createEAttribute(activityEClass, ACTIVITY__START_QUANTITY);
		createEReference(activityEClass, ACTIVITY__ACTIVITI_LISTENERS);
		createEAttribute(activityEClass, ACTIVITY__ASYNCHRONOUS);
		createEReference(activityEClass, ACTIVITY__ACTIVITY_ACTIONS);
		createEReference(activityEClass, ACTIVITY__ACTIVITY_AUTHORIZATION_CONSTRAINTS);

		adHocSubProcessEClass = createEClass(AD_HOC_SUB_PROCESS);
		createEReference(adHocSubProcessEClass, AD_HOC_SUB_PROCESS__COMPLETION_CONDITION);
		createEAttribute(adHocSubProcessEClass, AD_HOC_SUB_PROCESS__CANCEL_REMAINING_INSTANCES);
		createEAttribute(adHocSubProcessEClass, AD_HOC_SUB_PROCESS__ORDERING);

		artifactEClass = createEClass(ARTIFACT);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__FROM);
		createEReference(assignmentEClass, ASSIGNMENT__TO);

		associationEClass = createEClass(ASSOCIATION);
		createEAttribute(associationEClass, ASSOCIATION__ASSOCIATION_DIRECTION);
		createEReference(associationEClass, ASSOCIATION__SOURCE_REF);
		createEReference(associationEClass, ASSOCIATION__TARGET_REF);

		auditingEClass = createEClass(AUDITING);

		baseElementEClass = createEClass(BASE_ELEMENT);
		createEReference(baseElementEClass, BASE_ELEMENT__EXTENSION_VALUES);
		createEReference(baseElementEClass, BASE_ELEMENT__DOCUMENTATION);
		createEReference(baseElementEClass, BASE_ELEMENT__EXTENSION_DEFINITIONS);
		createEAttribute(baseElementEClass, BASE_ELEMENT__ID);

		boundaryEventEClass = createEClass(BOUNDARY_EVENT);
		createEReference(boundaryEventEClass, BOUNDARY_EVENT__ATTACHED_TO_REF);
		createEAttribute(boundaryEventEClass, BOUNDARY_EVENT__CANCEL_ACTIVITY);

		businessRuleTaskEClass = createEClass(BUSINESS_RULE_TASK);
		createEAttribute(businessRuleTaskEClass, BUSINESS_RULE_TASK__IMPLEMENTATION);
		createEAttribute(businessRuleTaskEClass, BUSINESS_RULE_TASK__RULE_NAMES);
		createEAttribute(businessRuleTaskEClass, BUSINESS_RULE_TASK__INPUT_VARIABLES);
		createEAttribute(businessRuleTaskEClass, BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME);
		createEAttribute(businessRuleTaskEClass, BUSINESS_RULE_TASK__EXCLUDE);

		callActivityEClass = createEClass(CALL_ACTIVITY);
		createEReference(callActivityEClass, CALL_ACTIVITY__CALLED_ELEMENT_REF);
		createEAttribute(callActivityEClass, CALL_ACTIVITY__CALLED_ELEMENT);
		createEReference(callActivityEClass, CALL_ACTIVITY__IN_PARAMETERS);
		createEReference(callActivityEClass, CALL_ACTIVITY__OUT_PARAMETERS);

		callChoreographyEClass = createEClass(CALL_CHOREOGRAPHY);
		createEReference(callChoreographyEClass, CALL_CHOREOGRAPHY__PARTICIPANT_ASSOCIATIONS);
		createEReference(callChoreographyEClass, CALL_CHOREOGRAPHY__CALLED_CHOREOGRAPHY_REF);

		callConversationEClass = createEClass(CALL_CONVERSATION);
		createEReference(callConversationEClass, CALL_CONVERSATION__PARTICIPANT_ASSOCIATIONS);
		createEReference(callConversationEClass, CALL_CONVERSATION__CALLED_COLLABORATION_REF);

		callableElementEClass = createEClass(CALLABLE_ELEMENT);
		createEReference(callableElementEClass, CALLABLE_ELEMENT__SUPPORTED_INTERFACE_REFS);
		createEReference(callableElementEClass, CALLABLE_ELEMENT__IO_SPECIFICATION);
		createEReference(callableElementEClass, CALLABLE_ELEMENT__IO_BINDING);
		createEAttribute(callableElementEClass, CALLABLE_ELEMENT__NAME);

		cancelEventDefinitionEClass = createEClass(CANCEL_EVENT_DEFINITION);

		catchEventEClass = createEClass(CATCH_EVENT);
		createEReference(catchEventEClass, CATCH_EVENT__DATA_OUTPUTS);
		createEReference(catchEventEClass, CATCH_EVENT__DATA_OUTPUT_ASSOCIATION);
		createEReference(catchEventEClass, CATCH_EVENT__OUTPUT_SET);
		createEReference(catchEventEClass, CATCH_EVENT__EVENT_DEFINITIONS);
		createEReference(catchEventEClass, CATCH_EVENT__EVENT_DEFINITION_REFS);
		createEAttribute(catchEventEClass, CATCH_EVENT__PARALLEL_MULTIPLE);

		categoryEClass = createEClass(CATEGORY);
		createEReference(categoryEClass, CATEGORY__CATEGORY_VALUE);
		createEAttribute(categoryEClass, CATEGORY__NAME);

		categoryValueEClass = createEClass(CATEGORY_VALUE);
		createEAttribute(categoryValueEClass, CATEGORY_VALUE__VALUE);
		createEReference(categoryValueEClass, CATEGORY_VALUE__CATEGORIZED_FLOW_ELEMENTS);

		choreographyEClass = createEClass(CHOREOGRAPHY);

		choreographyActivityEClass = createEClass(CHOREOGRAPHY_ACTIVITY);
		createEReference(choreographyActivityEClass, CHOREOGRAPHY_ACTIVITY__PARTICIPANT_REFS);
		createEReference(choreographyActivityEClass, CHOREOGRAPHY_ACTIVITY__CORRELATION_KEYS);
		createEReference(choreographyActivityEClass, CHOREOGRAPHY_ACTIVITY__INITIATING_PARTICIPANT_REF);
		createEAttribute(choreographyActivityEClass, CHOREOGRAPHY_ACTIVITY__LOOP_TYPE);

		choreographyTaskEClass = createEClass(CHOREOGRAPHY_TASK);
		createEReference(choreographyTaskEClass, CHOREOGRAPHY_TASK__MESSAGE_FLOW_REF);

		collaborationEClass = createEClass(COLLABORATION);
		createEReference(collaborationEClass, COLLABORATION__PARTICIPANTS);
		createEReference(collaborationEClass, COLLABORATION__MESSAGE_FLOWS);
		createEReference(collaborationEClass, COLLABORATION__ARTIFACTS);
		createEReference(collaborationEClass, COLLABORATION__CONVERSATIONS);
		createEReference(collaborationEClass, COLLABORATION__CONVERSATION_ASSOCIATIONS);
		createEReference(collaborationEClass, COLLABORATION__PARTICIPANT_ASSOCIATIONS);
		createEReference(collaborationEClass, COLLABORATION__MESSAGE_FLOW_ASSOCIATIONS);
		createEReference(collaborationEClass, COLLABORATION__CORRELATION_KEYS);
		createEReference(collaborationEClass, COLLABORATION__CHOREOGRAPHY_REF);
		createEReference(collaborationEClass, COLLABORATION__CONVERSATION_LINKS);
		createEAttribute(collaborationEClass, COLLABORATION__IS_CLOSED);
		createEAttribute(collaborationEClass, COLLABORATION__NAME);

		compensateEventDefinitionEClass = createEClass(COMPENSATE_EVENT_DEFINITION);
		createEReference(compensateEventDefinitionEClass, COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF);
		createEAttribute(compensateEventDefinitionEClass, COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION);

		complexBehaviorDefinitionEClass = createEClass(COMPLEX_BEHAVIOR_DEFINITION);
		createEReference(complexBehaviorDefinitionEClass, COMPLEX_BEHAVIOR_DEFINITION__CONDITION);
		createEReference(complexBehaviorDefinitionEClass, COMPLEX_BEHAVIOR_DEFINITION__EVENT);

		complexGatewayEClass = createEClass(COMPLEX_GATEWAY);
		createEReference(complexGatewayEClass, COMPLEX_GATEWAY__ACTIVATION_CONDITION);
		createEReference(complexGatewayEClass, COMPLEX_GATEWAY__DEFAULT);

		conditionalEventDefinitionEClass = createEClass(CONDITIONAL_EVENT_DEFINITION);
		createEReference(conditionalEventDefinitionEClass, CONDITIONAL_EVENT_DEFINITION__CONDITION);

		conversationEClass = createEClass(CONVERSATION);

		conversationAssociationEClass = createEClass(CONVERSATION_ASSOCIATION);
		createEReference(conversationAssociationEClass, CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF);
		createEReference(conversationAssociationEClass, CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF);

		conversationLinkEClass = createEClass(CONVERSATION_LINK);
		createEAttribute(conversationLinkEClass, CONVERSATION_LINK__NAME);
		createEReference(conversationLinkEClass, CONVERSATION_LINK__SOURCE_REF);
		createEReference(conversationLinkEClass, CONVERSATION_LINK__TARGET_REF);

		conversationNodeEClass = createEClass(CONVERSATION_NODE);
		createEReference(conversationNodeEClass, CONVERSATION_NODE__PARTICIPANT_REFS);
		createEReference(conversationNodeEClass, CONVERSATION_NODE__MESSAGE_FLOW_REFS);
		createEReference(conversationNodeEClass, CONVERSATION_NODE__CORRELATION_KEYS);
		createEAttribute(conversationNodeEClass, CONVERSATION_NODE__NAME);

		correlationKeyEClass = createEClass(CORRELATION_KEY);
		createEReference(correlationKeyEClass, CORRELATION_KEY__CORRELATION_PROPERTY_REF);
		createEAttribute(correlationKeyEClass, CORRELATION_KEY__NAME);

		correlationPropertyEClass = createEClass(CORRELATION_PROPERTY);
		createEReference(correlationPropertyEClass, CORRELATION_PROPERTY__CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION);
		createEAttribute(correlationPropertyEClass, CORRELATION_PROPERTY__NAME);
		createEReference(correlationPropertyEClass, CORRELATION_PROPERTY__TYPE);

		correlationPropertyBindingEClass = createEClass(CORRELATION_PROPERTY_BINDING);
		createEReference(correlationPropertyBindingEClass, CORRELATION_PROPERTY_BINDING__DATA_PATH);
		createEReference(correlationPropertyBindingEClass, CORRELATION_PROPERTY_BINDING__CORRELATION_PROPERTY_REF);

		correlationPropertyRetrievalExpressionEClass = createEClass(CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION);
		createEReference(correlationPropertyRetrievalExpressionEClass, CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH);
		createEReference(correlationPropertyRetrievalExpressionEClass, CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF);

		correlationSubscriptionEClass = createEClass(CORRELATION_SUBSCRIPTION);
		createEReference(correlationSubscriptionEClass, CORRELATION_SUBSCRIPTION__CORRELATION_PROPERTY_BINDING);
		createEReference(correlationSubscriptionEClass, CORRELATION_SUBSCRIPTION__CORRELATION_KEY_REF);

		dataAssociationEClass = createEClass(DATA_ASSOCIATION);
		createEReference(dataAssociationEClass, DATA_ASSOCIATION__SOURCE_REF);
		createEReference(dataAssociationEClass, DATA_ASSOCIATION__TARGET_REF);
		createEReference(dataAssociationEClass, DATA_ASSOCIATION__TRANSFORMATION);
		createEReference(dataAssociationEClass, DATA_ASSOCIATION__ASSIGNMENT);

		dataInputEClass = createEClass(DATA_INPUT);
		createEReference(dataInputEClass, DATA_INPUT__INPUT_SET_WITH_OPTIONAL);
		createEReference(dataInputEClass, DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING);
		createEReference(dataInputEClass, DATA_INPUT__INPUT_SET_REFS);
		createEAttribute(dataInputEClass, DATA_INPUT__IS_COLLECTION);
		createEAttribute(dataInputEClass, DATA_INPUT__NAME);

		dataInputAssociationEClass = createEClass(DATA_INPUT_ASSOCIATION);

		dataObjectEClass = createEClass(DATA_OBJECT);
		createEAttribute(dataObjectEClass, DATA_OBJECT__IS_COLLECTION);

		dataObjectReferenceEClass = createEClass(DATA_OBJECT_REFERENCE);
		createEReference(dataObjectReferenceEClass, DATA_OBJECT_REFERENCE__DATA_OBJECT_REF);

		dataOutputEClass = createEClass(DATA_OUTPUT);
		createEReference(dataOutputEClass, DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL);
		createEReference(dataOutputEClass, DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING);
		createEReference(dataOutputEClass, DATA_OUTPUT__OUTPUT_SET_REFS);
		createEAttribute(dataOutputEClass, DATA_OUTPUT__IS_COLLECTION);
		createEAttribute(dataOutputEClass, DATA_OUTPUT__NAME);

		dataOutputAssociationEClass = createEClass(DATA_OUTPUT_ASSOCIATION);

		dataStateEClass = createEClass(DATA_STATE);
		createEAttribute(dataStateEClass, DATA_STATE__NAME);

		dataStoreEClass = createEClass(DATA_STORE);
		createEAttribute(dataStoreEClass, DATA_STORE__CAPACITY);
		createEAttribute(dataStoreEClass, DATA_STORE__IS_UNLIMITED);
		createEAttribute(dataStoreEClass, DATA_STORE__NAME);

		dataStoreReferenceEClass = createEClass(DATA_STORE_REFERENCE);
		createEReference(dataStoreReferenceEClass, DATA_STORE_REFERENCE__DATA_STORE_REF);

		definitionsEClass = createEClass(DEFINITIONS);
		createEReference(definitionsEClass, DEFINITIONS__IMPORTS);
		createEReference(definitionsEClass, DEFINITIONS__EXTENSIONS);
		createEReference(definitionsEClass, DEFINITIONS__ROOT_ELEMENTS);
		createEReference(definitionsEClass, DEFINITIONS__DIAGRAMS);
		createEReference(definitionsEClass, DEFINITIONS__RELATIONSHIPS);
		createEAttribute(definitionsEClass, DEFINITIONS__EXPORTER);
		createEAttribute(definitionsEClass, DEFINITIONS__EXPORTER_VERSION);
		createEAttribute(definitionsEClass, DEFINITIONS__EXPRESSION_LANGUAGE);
		createEAttribute(definitionsEClass, DEFINITIONS__NAME);
		createEAttribute(definitionsEClass, DEFINITIONS__TARGET_NAMESPACE);
		createEAttribute(definitionsEClass, DEFINITIONS__TYPE_LANGUAGE);

		documentationEClass = createEClass(DOCUMENTATION);
		createEAttribute(documentationEClass, DOCUMENTATION__TEXT);
		createEAttribute(documentationEClass, DOCUMENTATION__TEXT_FORMAT);

		endEventEClass = createEClass(END_EVENT);

		endPointEClass = createEClass(END_POINT);

		errorEClass = createEClass(ERROR);
		createEAttribute(errorEClass, ERROR__ERROR_CODE);
		createEAttribute(errorEClass, ERROR__NAME);
		createEReference(errorEClass, ERROR__STRUCTURE_REF);

		errorEventDefinitionEClass = createEClass(ERROR_EVENT_DEFINITION);
		createEReference(errorEventDefinitionEClass, ERROR_EVENT_DEFINITION__ERROR_REF);
		createEAttribute(errorEventDefinitionEClass, ERROR_EVENT_DEFINITION__ERROR_CODE);

		escalationEClass = createEClass(ESCALATION);
		createEAttribute(escalationEClass, ESCALATION__ESCALATION_CODE);
		createEAttribute(escalationEClass, ESCALATION__NAME);
		createEReference(escalationEClass, ESCALATION__STRUCTURE_REF);

		escalationEventDefinitionEClass = createEClass(ESCALATION_EVENT_DEFINITION);
		createEReference(escalationEventDefinitionEClass, ESCALATION_EVENT_DEFINITION__ESCALATION_REF);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__PROPERTIES);

		eventBasedGatewayEClass = createEClass(EVENT_BASED_GATEWAY);
		createEAttribute(eventBasedGatewayEClass, EVENT_BASED_GATEWAY__EVENT_GATEWAY_TYPE);
		createEAttribute(eventBasedGatewayEClass, EVENT_BASED_GATEWAY__INSTANTIATE);

		eventDefinitionEClass = createEClass(EVENT_DEFINITION);

		exclusiveGatewayEClass = createEClass(EXCLUSIVE_GATEWAY);
		createEReference(exclusiveGatewayEClass, EXCLUSIVE_GATEWAY__DEFAULT);

		expressionEClass = createEClass(EXPRESSION);

		extensionEClass = createEClass(EXTENSION);
		createEReference(extensionEClass, EXTENSION__DEFINITION);
		createEAttribute(extensionEClass, EXTENSION__MUST_UNDERSTAND);

		extensionAttributeDefinitionEClass = createEClass(EXTENSION_ATTRIBUTE_DEFINITION);
		createEAttribute(extensionAttributeDefinitionEClass, EXTENSION_ATTRIBUTE_DEFINITION__NAME);
		createEAttribute(extensionAttributeDefinitionEClass, EXTENSION_ATTRIBUTE_DEFINITION__TYPE);
		createEAttribute(extensionAttributeDefinitionEClass, EXTENSION_ATTRIBUTE_DEFINITION__IS_REFERENCE);
		createEReference(extensionAttributeDefinitionEClass, EXTENSION_ATTRIBUTE_DEFINITION__EXTENSION_DEFINITION);

		extensionAttributeValueEClass = createEClass(EXTENSION_ATTRIBUTE_VALUE);
		createEReference(extensionAttributeValueEClass, EXTENSION_ATTRIBUTE_VALUE__VALUE_REF);
		createEReference(extensionAttributeValueEClass, EXTENSION_ATTRIBUTE_VALUE__VALUE);
		createEReference(extensionAttributeValueEClass, EXTENSION_ATTRIBUTE_VALUE__EXTENSION_ATTRIBUTE_DEFINITION);

		extensionDefinitionEClass = createEClass(EXTENSION_DEFINITION);
		createEAttribute(extensionDefinitionEClass, EXTENSION_DEFINITION__NAME);
		createEReference(extensionDefinitionEClass, EXTENSION_DEFINITION__EXTENSION_ATTRIBUTE_DEFINITIONS);

		flowElementEClass = createEClass(FLOW_ELEMENT);
		createEReference(flowElementEClass, FLOW_ELEMENT__AUDITING);
		createEReference(flowElementEClass, FLOW_ELEMENT__MONITORING);
		createEReference(flowElementEClass, FLOW_ELEMENT__CATEGORY_VALUE_REF);
		createEAttribute(flowElementEClass, FLOW_ELEMENT__NAME);

		flowElementsContainerEClass = createEClass(FLOW_ELEMENTS_CONTAINER);
		createEReference(flowElementsContainerEClass, FLOW_ELEMENTS_CONTAINER__LANE_SETS);
		createEReference(flowElementsContainerEClass, FLOW_ELEMENTS_CONTAINER__FLOW_ELEMENTS);

		flowNodeEClass = createEClass(FLOW_NODE);
		createEReference(flowNodeEClass, FLOW_NODE__INCOMING);
		createEReference(flowNodeEClass, FLOW_NODE__LANES);
		createEReference(flowNodeEClass, FLOW_NODE__OUTGOING);
		createEReference(flowNodeEClass, FLOW_NODE__INCOMING_SECURITY_FLOW);
		createEReference(flowNodeEClass, FLOW_NODE__OUTGOING_SECURITY_FLOW);

		formalExpressionEClass = createEClass(FORMAL_EXPRESSION);
		createEReference(formalExpressionEClass, FORMAL_EXPRESSION__EVALUATES_TO_TYPE_REF);
		createEAttribute(formalExpressionEClass, FORMAL_EXPRESSION__LANGUAGE);
		createEAttribute(formalExpressionEClass, FORMAL_EXPRESSION__BODY);

		gatewayEClass = createEClass(GATEWAY);
		createEAttribute(gatewayEClass, GATEWAY__GATEWAY_DIRECTION);

		globalBusinessRuleTaskEClass = createEClass(GLOBAL_BUSINESS_RULE_TASK);
		createEAttribute(globalBusinessRuleTaskEClass, GLOBAL_BUSINESS_RULE_TASK__IMPLEMENTATION);

		globalChoreographyTaskEClass = createEClass(GLOBAL_CHOREOGRAPHY_TASK);
		createEReference(globalChoreographyTaskEClass, GLOBAL_CHOREOGRAPHY_TASK__INITIATING_PARTICIPANT_REF);

		globalConversationEClass = createEClass(GLOBAL_CONVERSATION);

		globalManualTaskEClass = createEClass(GLOBAL_MANUAL_TASK);

		globalScriptTaskEClass = createEClass(GLOBAL_SCRIPT_TASK);
		createEAttribute(globalScriptTaskEClass, GLOBAL_SCRIPT_TASK__SCRIPT);
		createEAttribute(globalScriptTaskEClass, GLOBAL_SCRIPT_TASK__SCRIPT_LANGUAGE);

		globalTaskEClass = createEClass(GLOBAL_TASK);
		createEReference(globalTaskEClass, GLOBAL_TASK__RESOURCES);

		globalUserTaskEClass = createEClass(GLOBAL_USER_TASK);
		createEReference(globalUserTaskEClass, GLOBAL_USER_TASK__RENDERINGS);
		createEAttribute(globalUserTaskEClass, GLOBAL_USER_TASK__IMPLEMENTATION);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__CATEGORY_VALUE_REF);

		humanPerformerEClass = createEClass(HUMAN_PERFORMER);

		implicitThrowEventEClass = createEClass(IMPLICIT_THROW_EVENT);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__IMPORT_TYPE);
		createEAttribute(importEClass, IMPORT__LOCATION);
		createEAttribute(importEClass, IMPORT__NAMESPACE);

		inclusiveGatewayEClass = createEClass(INCLUSIVE_GATEWAY);
		createEReference(inclusiveGatewayEClass, INCLUSIVE_GATEWAY__DEFAULT);

		inputOutputBindingEClass = createEClass(INPUT_OUTPUT_BINDING);
		createEReference(inputOutputBindingEClass, INPUT_OUTPUT_BINDING__INPUT_DATA_REF);
		createEReference(inputOutputBindingEClass, INPUT_OUTPUT_BINDING__OPERATION_REF);
		createEReference(inputOutputBindingEClass, INPUT_OUTPUT_BINDING__OUTPUT_DATA_REF);

		inputOutputSpecificationEClass = createEClass(INPUT_OUTPUT_SPECIFICATION);
		createEReference(inputOutputSpecificationEClass, INPUT_OUTPUT_SPECIFICATION__DATA_INPUTS);
		createEReference(inputOutputSpecificationEClass, INPUT_OUTPUT_SPECIFICATION__DATA_OUTPUTS);
		createEReference(inputOutputSpecificationEClass, INPUT_OUTPUT_SPECIFICATION__INPUT_SETS);
		createEReference(inputOutputSpecificationEClass, INPUT_OUTPUT_SPECIFICATION__OUTPUT_SETS);

		inputSetEClass = createEClass(INPUT_SET);
		createEReference(inputSetEClass, INPUT_SET__DATA_INPUT_REFS);
		createEReference(inputSetEClass, INPUT_SET__OPTIONAL_INPUT_REFS);
		createEReference(inputSetEClass, INPUT_SET__WHILE_EXECUTING_INPUT_REFS);
		createEReference(inputSetEClass, INPUT_SET__OUTPUT_SET_REFS);
		createEAttribute(inputSetEClass, INPUT_SET__NAME);

		interactionNodeEClass = createEClass(INTERACTION_NODE);
		createEReference(interactionNodeEClass, INTERACTION_NODE__INCOMING_CONVERSATION_LINKS);
		createEReference(interactionNodeEClass, INTERACTION_NODE__OUTGOING_CONVERSATION_LINKS);

		interfaceEClass = createEClass(INTERFACE);
		createEReference(interfaceEClass, INTERFACE__OPERATIONS);
		createEReference(interfaceEClass, INTERFACE__IMPLEMENTATION_REF);
		createEAttribute(interfaceEClass, INTERFACE__NAME);

		intermediateCatchEventEClass = createEClass(INTERMEDIATE_CATCH_EVENT);

		intermediateThrowEventEClass = createEClass(INTERMEDIATE_THROW_EVENT);

		itemAwareElementEClass = createEClass(ITEM_AWARE_ELEMENT);
		createEReference(itemAwareElementEClass, ITEM_AWARE_ELEMENT__DATA_STATE);
		createEReference(itemAwareElementEClass, ITEM_AWARE_ELEMENT__ITEM_SUBJECT_REF);
		createEReference(itemAwareElementEClass, ITEM_AWARE_ELEMENT__ITEM_AWARE_ELEMENT_ACTIONS);

		itemDefinitionEClass = createEClass(ITEM_DEFINITION);
		createEAttribute(itemDefinitionEClass, ITEM_DEFINITION__IS_COLLECTION);
		createEReference(itemDefinitionEClass, ITEM_DEFINITION__IMPORT);
		createEAttribute(itemDefinitionEClass, ITEM_DEFINITION__ITEM_KIND);
		createEReference(itemDefinitionEClass, ITEM_DEFINITION__STRUCTURE_REF);

		laneEClass = createEClass(LANE);
		createEReference(laneEClass, LANE__PARTITION_ELEMENT);
		createEReference(laneEClass, LANE__FLOW_NODE_REFS);
		createEReference(laneEClass, LANE__CHILD_LANE_SET);
		createEAttribute(laneEClass, LANE__NAME);
		createEReference(laneEClass, LANE__PARTITION_ELEMENT_REF);

		laneSetEClass = createEClass(LANE_SET);
		createEReference(laneSetEClass, LANE_SET__LANES);
		createEAttribute(laneSetEClass, LANE_SET__NAME);

		linkEventDefinitionEClass = createEClass(LINK_EVENT_DEFINITION);
		createEReference(linkEventDefinitionEClass, LINK_EVENT_DEFINITION__SOURCE);
		createEReference(linkEventDefinitionEClass, LINK_EVENT_DEFINITION__TARGET);
		createEAttribute(linkEventDefinitionEClass, LINK_EVENT_DEFINITION__NAME);

		loopCharacteristicsEClass = createEClass(LOOP_CHARACTERISTICS);

		manualTaskEClass = createEClass(MANUAL_TASK);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__ITEM_REF);
		createEAttribute(messageEClass, MESSAGE__NAME);

		messageEventDefinitionEClass = createEClass(MESSAGE_EVENT_DEFINITION);
		createEReference(messageEventDefinitionEClass, MESSAGE_EVENT_DEFINITION__OPERATION_REF);
		createEReference(messageEventDefinitionEClass, MESSAGE_EVENT_DEFINITION__MESSAGE_REF);

		messageFlowEClass = createEClass(MESSAGE_FLOW);
		createEReference(messageFlowEClass, MESSAGE_FLOW__MESSAGE_REF);
		createEAttribute(messageFlowEClass, MESSAGE_FLOW__NAME);
		createEReference(messageFlowEClass, MESSAGE_FLOW__SOURCE_REF);
		createEReference(messageFlowEClass, MESSAGE_FLOW__TARGET_REF);

		messageFlowAssociationEClass = createEClass(MESSAGE_FLOW_ASSOCIATION);
		createEReference(messageFlowAssociationEClass, MESSAGE_FLOW_ASSOCIATION__INNER_MESSAGE_FLOW_REF);
		createEReference(messageFlowAssociationEClass, MESSAGE_FLOW_ASSOCIATION__OUTER_MESSAGE_FLOW_REF);

		monitoringEClass = createEClass(MONITORING);

		multiInstanceLoopCharacteristicsEClass = createEClass(MULTI_INSTANCE_LOOP_CHARACTERISTICS);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_INPUT_REF);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_DATA_OUTPUT_REF);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__OUTPUT_DATA_ITEM);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLEX_BEHAVIOR_DEFINITION);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__BEHAVIOR);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__IS_SEQUENTIAL);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__NONE_BEHAVIOR_EVENT_REF);
		createEReference(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__ONE_BEHAVIOR_EVENT_REF);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__LOOP_CARDINALITY);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__INPUT_DATA_ITEM);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__COMPLETION_CONDITION);
		createEAttribute(multiInstanceLoopCharacteristicsEClass, MULTI_INSTANCE_LOOP_CHARACTERISTICS__ELEMENT_VARIABLE);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__IN_MESSAGE_REF);
		createEReference(operationEClass, OPERATION__OUT_MESSAGE_REF);
		createEReference(operationEClass, OPERATION__ERROR_REFS);
		createEReference(operationEClass, OPERATION__IMPLEMENTATION_REF);
		createEAttribute(operationEClass, OPERATION__NAME);

		outputSetEClass = createEClass(OUTPUT_SET);
		createEReference(outputSetEClass, OUTPUT_SET__DATA_OUTPUT_REFS);
		createEReference(outputSetEClass, OUTPUT_SET__OPTIONAL_OUTPUT_REFS);
		createEReference(outputSetEClass, OUTPUT_SET__WHILE_EXECUTING_OUTPUT_REFS);
		createEReference(outputSetEClass, OUTPUT_SET__INPUT_SET_REFS);
		createEAttribute(outputSetEClass, OUTPUT_SET__NAME);

		parallelGatewayEClass = createEClass(PARALLEL_GATEWAY);

		participantEClass = createEClass(PARTICIPANT);
		createEReference(participantEClass, PARTICIPANT__INTERFACE_REFS);
		createEReference(participantEClass, PARTICIPANT__END_POINT_REFS);
		createEReference(participantEClass, PARTICIPANT__PARTICIPANT_MULTIPLICITY);
		createEAttribute(participantEClass, PARTICIPANT__NAME);
		createEReference(participantEClass, PARTICIPANT__PROCESS_REF);

		participantAssociationEClass = createEClass(PARTICIPANT_ASSOCIATION);
		createEReference(participantAssociationEClass, PARTICIPANT_ASSOCIATION__INNER_PARTICIPANT_REF);
		createEReference(participantAssociationEClass, PARTICIPANT_ASSOCIATION__OUTER_PARTICIPANT_REF);

		participantMultiplicityEClass = createEClass(PARTICIPANT_MULTIPLICITY);
		createEAttribute(participantMultiplicityEClass, PARTICIPANT_MULTIPLICITY__MAXIMUM);
		createEAttribute(participantMultiplicityEClass, PARTICIPANT_MULTIPLICITY__MINIMUM);

		partnerEntityEClass = createEClass(PARTNER_ENTITY);
		createEReference(partnerEntityEClass, PARTNER_ENTITY__PARTICIPANT_REF);
		createEAttribute(partnerEntityEClass, PARTNER_ENTITY__NAME);

		partnerRoleEClass = createEClass(PARTNER_ROLE);
		createEReference(partnerRoleEClass, PARTNER_ROLE__PARTICIPANT_REF);
		createEAttribute(partnerRoleEClass, PARTNER_ROLE__NAME);

		performerEClass = createEClass(PERFORMER);

		potentialOwnerEClass = createEClass(POTENTIAL_OWNER);

		processEClass = createEClass(PROCESS);
		createEReference(processEClass, PROCESS__AUDITING);
		createEReference(processEClass, PROCESS__MONITORING);
		createEReference(processEClass, PROCESS__PROPERTIES);
		createEReference(processEClass, PROCESS__ARTIFACTS);
		createEReference(processEClass, PROCESS__RESOURCES);
		createEReference(processEClass, PROCESS__CORRELATION_SUBSCRIPTIONS);
		createEReference(processEClass, PROCESS__SUPPORTS);
		createEReference(processEClass, PROCESS__DEFINITIONAL_COLLABORATION_REF);
		createEAttribute(processEClass, PROCESS__IS_CLOSED);
		createEAttribute(processEClass, PROCESS__IS_EXECUTABLE);
		createEAttribute(processEClass, PROCESS__PROCESS_TYPE);
		createEAttribute(processEClass, PROCESS__FILENAME);
		createEReference(processEClass, PROCESS__EXECUTION_LISTENERS);
		createEAttribute(processEClass, PROCESS__NAMESPACE);
		createEReference(processEClass, PROCESS__PROCESS_ACTIONS);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);

		receiveTaskEClass = createEClass(RECEIVE_TASK);
		createEAttribute(receiveTaskEClass, RECEIVE_TASK__IMPLEMENTATION);
		createEAttribute(receiveTaskEClass, RECEIVE_TASK__INSTANTIATE);
		createEReference(receiveTaskEClass, RECEIVE_TASK__MESSAGE_REF);
		createEReference(receiveTaskEClass, RECEIVE_TASK__OPERATION_REF);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEReference(relationshipEClass, RELATIONSHIP__SOURCES);
		createEReference(relationshipEClass, RELATIONSHIP__TARGETS);
		createEAttribute(relationshipEClass, RELATIONSHIP__DIRECTION);
		createEAttribute(relationshipEClass, RELATIONSHIP__TYPE);

		renderingEClass = createEClass(RENDERING);

		resourceEClass = createEClass(RESOURCE);
		createEReference(resourceEClass, RESOURCE__RESOURCE_PARAMETERS);
		createEAttribute(resourceEClass, RESOURCE__NAME);

		resourceAssignmentExpressionEClass = createEClass(RESOURCE_ASSIGNMENT_EXPRESSION);
		createEReference(resourceAssignmentExpressionEClass, RESOURCE_ASSIGNMENT_EXPRESSION__EXPRESSION);

		resourceParameterEClass = createEClass(RESOURCE_PARAMETER);
		createEAttribute(resourceParameterEClass, RESOURCE_PARAMETER__IS_REQUIRED);
		createEAttribute(resourceParameterEClass, RESOURCE_PARAMETER__NAME);
		createEReference(resourceParameterEClass, RESOURCE_PARAMETER__TYPE);

		resourceParameterBindingEClass = createEClass(RESOURCE_PARAMETER_BINDING);
		createEReference(resourceParameterBindingEClass, RESOURCE_PARAMETER_BINDING__EXPRESSION);
		createEReference(resourceParameterBindingEClass, RESOURCE_PARAMETER_BINDING__PARAMETER_REF);

		resourceRoleEClass = createEClass(RESOURCE_ROLE);
		createEReference(resourceRoleEClass, RESOURCE_ROLE__RESOURCE_REF);
		createEReference(resourceRoleEClass, RESOURCE_ROLE__RESOURCE_PARAMETER_BINDINGS);
		createEReference(resourceRoleEClass, RESOURCE_ROLE__RESOURCE_ASSIGNMENT_EXPRESSION);
		createEAttribute(resourceRoleEClass, RESOURCE_ROLE__NAME);

		rootElementEClass = createEClass(ROOT_ELEMENT);

		scriptTaskEClass = createEClass(SCRIPT_TASK);
		createEAttribute(scriptTaskEClass, SCRIPT_TASK__SCRIPT);
		createEAttribute(scriptTaskEClass, SCRIPT_TASK__SCRIPT_FORMAT);

		sendTaskEClass = createEClass(SEND_TASK);
		createEAttribute(sendTaskEClass, SEND_TASK__IMPLEMENTATION);
		createEReference(sendTaskEClass, SEND_TASK__MESSAGE_REF);
		createEReference(sendTaskEClass, SEND_TASK__OPERATION_REF);

		sequenceFlowEClass = createEClass(SEQUENCE_FLOW);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__CONDITION_EXPRESSION);
		createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__IS_IMMEDIATE);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__SOURCE_REF);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__TARGET_REF);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__EXECUTION_LISTENERS);

		serviceTaskEClass = createEClass(SERVICE_TASK);
		createEAttribute(serviceTaskEClass, SERVICE_TASK__IMPLEMENTATION);
		createEReference(serviceTaskEClass, SERVICE_TASK__OPERATION_REF);
		createEReference(serviceTaskEClass, SERVICE_TASK__CUSTOM_PROPERTIES);
		createEAttribute(serviceTaskEClass, SERVICE_TASK__IMPLEMENTATION_TYPE);
		createEReference(serviceTaskEClass, SERVICE_TASK__FIELD_EXTENSIONS);
		createEAttribute(serviceTaskEClass, SERVICE_TASK__RESULT_VARIABLE_NAME);
		createEReference(serviceTaskEClass, SERVICE_TASK__SECURITY_EXTENSIONS);

		signalEClass = createEClass(SIGNAL);
		createEAttribute(signalEClass, SIGNAL__NAME);
		createEReference(signalEClass, SIGNAL__STRUCTURE_REF);

		signalEventDefinitionEClass = createEClass(SIGNAL_EVENT_DEFINITION);
		createEReference(signalEventDefinitionEClass, SIGNAL_EVENT_DEFINITION__SIGNAL_REF);

		standardLoopCharacteristicsEClass = createEClass(STANDARD_LOOP_CHARACTERISTICS);
		createEReference(standardLoopCharacteristicsEClass, STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION);
		createEReference(standardLoopCharacteristicsEClass, STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM);
		createEAttribute(standardLoopCharacteristicsEClass, STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE);

		startEventEClass = createEClass(START_EVENT);
		createEAttribute(startEventEClass, START_EVENT__IS_INTERRUPTING);
		createEAttribute(startEventEClass, START_EVENT__FORM_KEY);
		createEReference(startEventEClass, START_EVENT__FORM_PROPERTIES);
		createEAttribute(startEventEClass, START_EVENT__INITIATOR);

		subChoreographyEClass = createEClass(SUB_CHOREOGRAPHY);
		createEReference(subChoreographyEClass, SUB_CHOREOGRAPHY__ARTIFACTS);

		subConversationEClass = createEClass(SUB_CONVERSATION);
		createEReference(subConversationEClass, SUB_CONVERSATION__CONVERSATION_NODES);

		subProcessEClass = createEClass(SUB_PROCESS);
		createEReference(subProcessEClass, SUB_PROCESS__ARTIFACTS);
		createEAttribute(subProcessEClass, SUB_PROCESS__TRIGGERED_BY_EVENT);

		taskEClass = createEClass(TASK);

		terminateEventDefinitionEClass = createEClass(TERMINATE_EVENT_DEFINITION);

		textAnnotationEClass = createEClass(TEXT_ANNOTATION);
		createEAttribute(textAnnotationEClass, TEXT_ANNOTATION__TEXT);
		createEAttribute(textAnnotationEClass, TEXT_ANNOTATION__TEXT_FORMAT);

		throwEventEClass = createEClass(THROW_EVENT);
		createEReference(throwEventEClass, THROW_EVENT__DATA_INPUTS);
		createEReference(throwEventEClass, THROW_EVENT__DATA_INPUT_ASSOCIATION);
		createEReference(throwEventEClass, THROW_EVENT__INPUT_SET);
		createEReference(throwEventEClass, THROW_EVENT__EVENT_DEFINITIONS);
		createEReference(throwEventEClass, THROW_EVENT__EVENT_DEFINITION_REFS);

		timerEventDefinitionEClass = createEClass(TIMER_EVENT_DEFINITION);
		createEReference(timerEventDefinitionEClass, TIMER_EVENT_DEFINITION__TIME_DATE);
		createEReference(timerEventDefinitionEClass, TIMER_EVENT_DEFINITION__TIME_DURATION);
		createEReference(timerEventDefinitionEClass, TIMER_EVENT_DEFINITION__TIME_CYCLE);

		transactionEClass = createEClass(TRANSACTION);
		createEAttribute(transactionEClass, TRANSACTION__PROTOCOL);
		createEAttribute(transactionEClass, TRANSACTION__METHOD);

		userTaskEClass = createEClass(USER_TASK);
		createEReference(userTaskEClass, USER_TASK__RENDERINGS);
		createEAttribute(userTaskEClass, USER_TASK__IMPLEMENTATION);
		createEAttribute(userTaskEClass, USER_TASK__ASSIGNEE);
		createEReference(userTaskEClass, USER_TASK__CANDIDATE_USERS);
		createEReference(userTaskEClass, USER_TASK__CANDIDATE_GROUPS);
		createEAttribute(userTaskEClass, USER_TASK__FORM_KEY);
		createEReference(userTaskEClass, USER_TASK__FORM_PROPERTIES);
		createEAttribute(userTaskEClass, USER_TASK__PRIORITY);
		createEAttribute(userTaskEClass, USER_TASK__DUE_DATE);

		candidateUserEClass = createEClass(CANDIDATE_USER);
		createEAttribute(candidateUserEClass, CANDIDATE_USER__USER);

		candidateGroupEClass = createEClass(CANDIDATE_GROUP);
		createEAttribute(candidateGroupEClass, CANDIDATE_GROUP__GROUP);

		customPropertyEClass = createEClass(CUSTOM_PROPERTY);
		createEAttribute(customPropertyEClass, CUSTOM_PROPERTY__NAME);
		createEAttribute(customPropertyEClass, CUSTOM_PROPERTY__SIMPLE_VALUE);
		createEReference(customPropertyEClass, CUSTOM_PROPERTY__COMPLEX_VALUE);

		mailTaskEClass = createEClass(MAIL_TASK);
		createEAttribute(mailTaskEClass, MAIL_TASK__TO);
		createEAttribute(mailTaskEClass, MAIL_TASK__FROM);
		createEAttribute(mailTaskEClass, MAIL_TASK__SUBJECT);
		createEAttribute(mailTaskEClass, MAIL_TASK__CC);
		createEAttribute(mailTaskEClass, MAIL_TASK__BCC);
		createEAttribute(mailTaskEClass, MAIL_TASK__HTML);
		createEAttribute(mailTaskEClass, MAIL_TASK__TEXT);

		fieldExtensionEClass = createEClass(FIELD_EXTENSION);
		createEAttribute(fieldExtensionEClass, FIELD_EXTENSION__FIELDNAME);
		createEAttribute(fieldExtensionEClass, FIELD_EXTENSION__EXPRESSION);

		complexDataTypeEClass = createEClass(COMPLEX_DATA_TYPE);

		dataGridEClass = createEClass(DATA_GRID);
		createEReference(dataGridEClass, DATA_GRID__ROW);

		dataGridRowEClass = createEClass(DATA_GRID_ROW);
		createEAttribute(dataGridRowEClass, DATA_GRID_ROW__INDEX);
		createEReference(dataGridRowEClass, DATA_GRID_ROW__FIELD);

		dataGridFieldEClass = createEClass(DATA_GRID_FIELD);
		createEAttribute(dataGridFieldEClass, DATA_GRID_FIELD__NAME);
		createEAttribute(dataGridFieldEClass, DATA_GRID_FIELD__SIMPLE_VALUE);

		activitiListenerEClass = createEClass(ACTIVITI_LISTENER);
		createEAttribute(activitiListenerEClass, ACTIVITI_LISTENER__IMPLEMENTATION_TYPE);
		createEAttribute(activitiListenerEClass, ACTIVITI_LISTENER__IMPLEMENTATION);
		createEAttribute(activitiListenerEClass, ACTIVITI_LISTENER__EVENT);
		createEReference(activitiListenerEClass, ACTIVITI_LISTENER__FIELD_EXTENSIONS);
		createEAttribute(activitiListenerEClass, ACTIVITI_LISTENER__RUN_AS);
		createEAttribute(activitiListenerEClass, ACTIVITI_LISTENER__SCRIPT_PROCESSOR);

		formPropertyEClass = createEClass(FORM_PROPERTY);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__NAME);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__TYPE);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__VALUE);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__READABLE);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__WRITEABLE);
		createEAttribute(formPropertyEClass, FORM_PROPERTY__REQUIRED);
		createEReference(formPropertyEClass, FORM_PROPERTY__FORM_VALUES);

		ioParameterEClass = createEClass(IO_PARAMETER);
		createEAttribute(ioParameterEClass, IO_PARAMETER__SOURCE);
		createEAttribute(ioParameterEClass, IO_PARAMETER__TARGET);

		alfrescoUserTaskEClass = createEClass(ALFRESCO_USER_TASK);

		alfrescoStartEventEClass = createEClass(ALFRESCO_START_EVENT);

		alfrescoScriptTaskEClass = createEClass(ALFRESCO_SCRIPT_TASK);
		createEAttribute(alfrescoScriptTaskEClass, ALFRESCO_SCRIPT_TASK__SCRIPT);

		alfrescoScriptBaseEClass = createEClass(ALFRESCO_SCRIPT_BASE);
		createEAttribute(alfrescoScriptBaseEClass, ALFRESCO_SCRIPT_BASE__RUN_AS);
		createEAttribute(alfrescoScriptBaseEClass, ALFRESCO_SCRIPT_BASE__SCRIPT_PROCESSOR);

		alfrescoMailTaskEClass = createEClass(ALFRESCO_MAIL_TASK);
		createEAttribute(alfrescoMailTaskEClass, ALFRESCO_MAIL_TASK__TO_MANY);
		createEAttribute(alfrescoMailTaskEClass, ALFRESCO_MAIL_TASK__TEMPLATE);
		createEAttribute(alfrescoMailTaskEClass, ALFRESCO_MAIL_TASK__TEMPLATE_MODEL);

		formValueEClass = createEClass(FORM_VALUE);
		createEAttribute(formValueEClass, FORM_VALUE__VALUE_ID);
		createEAttribute(formValueEClass, FORM_VALUE__VALUE_NAME);

		// Create enums
		adHocOrderingEEnum = createEEnum(AD_HOC_ORDERING);
		associationDirectionEEnum = createEEnum(ASSOCIATION_DIRECTION);
		choreographyLoopTypeEEnum = createEEnum(CHOREOGRAPHY_LOOP_TYPE);
		eventBasedGatewayTypeEEnum = createEEnum(EVENT_BASED_GATEWAY_TYPE);
		gatewayDirectionEEnum = createEEnum(GATEWAY_DIRECTION);
		itemKindEEnum = createEEnum(ITEM_KIND);
		multiInstanceBehaviorEEnum = createEEnum(MULTI_INSTANCE_BEHAVIOR);
		processTypeEEnum = createEEnum(PROCESS_TYPE);
		relationshipDirectionEEnum = createEEnum(RELATIONSHIP_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Securebpmn2Package theSecurebpmn2Package = (Securebpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI);
		BpmnDiPackage theBpmnDiPackage = (BpmnDiPackage)EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI);
		AniketosPackage theAniketosPackage = (AniketosPackage)EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		activityEClass.getESuperTypes().add(this.getFlowNode());
		adHocSubProcessEClass.getESuperTypes().add(this.getSubProcess());
		artifactEClass.getESuperTypes().add(this.getBaseElement());
		assignmentEClass.getESuperTypes().add(this.getBaseElement());
		associationEClass.getESuperTypes().add(this.getArtifact());
		auditingEClass.getESuperTypes().add(this.getBaseElement());
		boundaryEventEClass.getESuperTypes().add(this.getCatchEvent());
		businessRuleTaskEClass.getESuperTypes().add(this.getTask());
		callActivityEClass.getESuperTypes().add(this.getActivity());
		callChoreographyEClass.getESuperTypes().add(this.getChoreographyActivity());
		callConversationEClass.getESuperTypes().add(this.getConversationNode());
		callableElementEClass.getESuperTypes().add(this.getRootElement());
		cancelEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		catchEventEClass.getESuperTypes().add(this.getEvent());
		categoryEClass.getESuperTypes().add(this.getRootElement());
		categoryValueEClass.getESuperTypes().add(this.getBaseElement());
		choreographyEClass.getESuperTypes().add(this.getCollaboration());
		choreographyEClass.getESuperTypes().add(this.getFlowElementsContainer());
		choreographyActivityEClass.getESuperTypes().add(this.getFlowNode());
		choreographyTaskEClass.getESuperTypes().add(this.getChoreographyActivity());
		collaborationEClass.getESuperTypes().add(this.getRootElement());
		compensateEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		complexBehaviorDefinitionEClass.getESuperTypes().add(this.getBaseElement());
		complexGatewayEClass.getESuperTypes().add(this.getGateway());
		conditionalEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		conversationEClass.getESuperTypes().add(this.getConversationNode());
		conversationAssociationEClass.getESuperTypes().add(this.getBaseElement());
		conversationLinkEClass.getESuperTypes().add(this.getBaseElement());
		conversationNodeEClass.getESuperTypes().add(this.getBaseElement());
		conversationNodeEClass.getESuperTypes().add(this.getInteractionNode());
		correlationKeyEClass.getESuperTypes().add(this.getBaseElement());
		correlationPropertyEClass.getESuperTypes().add(this.getRootElement());
		correlationPropertyBindingEClass.getESuperTypes().add(this.getBaseElement());
		correlationPropertyRetrievalExpressionEClass.getESuperTypes().add(this.getBaseElement());
		correlationSubscriptionEClass.getESuperTypes().add(this.getBaseElement());
		dataAssociationEClass.getESuperTypes().add(this.getBaseElement());
		dataInputEClass.getESuperTypes().add(this.getItemAwareElement());
		dataInputAssociationEClass.getESuperTypes().add(this.getDataAssociation());
		dataObjectEClass.getESuperTypes().add(this.getFlowElement());
		dataObjectEClass.getESuperTypes().add(this.getItemAwareElement());
		dataObjectReferenceEClass.getESuperTypes().add(this.getFlowElement());
		dataObjectReferenceEClass.getESuperTypes().add(this.getItemAwareElement());
		dataOutputEClass.getESuperTypes().add(this.getItemAwareElement());
		dataOutputAssociationEClass.getESuperTypes().add(this.getDataAssociation());
		dataStateEClass.getESuperTypes().add(this.getBaseElement());
		dataStoreEClass.getESuperTypes().add(this.getItemAwareElement());
		dataStoreEClass.getESuperTypes().add(this.getRootElement());
		dataStoreReferenceEClass.getESuperTypes().add(this.getFlowElement());
		dataStoreReferenceEClass.getESuperTypes().add(this.getItemAwareElement());
		definitionsEClass.getESuperTypes().add(this.getBaseElement());
		documentationEClass.getESuperTypes().add(this.getBaseElement());
		endEventEClass.getESuperTypes().add(this.getThrowEvent());
		endPointEClass.getESuperTypes().add(this.getRootElement());
		errorEClass.getESuperTypes().add(this.getRootElement());
		errorEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		escalationEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		eventEClass.getESuperTypes().add(this.getFlowNode());
		eventEClass.getESuperTypes().add(this.getInteractionNode());
		eventBasedGatewayEClass.getESuperTypes().add(this.getGateway());
		eventDefinitionEClass.getESuperTypes().add(this.getRootElement());
		exclusiveGatewayEClass.getESuperTypes().add(this.getGateway());
		expressionEClass.getESuperTypes().add(this.getBaseElement());
		flowElementEClass.getESuperTypes().add(this.getBaseElement());
		flowElementsContainerEClass.getESuperTypes().add(this.getBaseElement());
		flowNodeEClass.getESuperTypes().add(this.getFlowElement());
		formalExpressionEClass.getESuperTypes().add(this.getExpression());
		gatewayEClass.getESuperTypes().add(this.getFlowNode());
		globalBusinessRuleTaskEClass.getESuperTypes().add(this.getGlobalTask());
		globalChoreographyTaskEClass.getESuperTypes().add(this.getChoreography());
		globalConversationEClass.getESuperTypes().add(this.getCollaboration());
		globalManualTaskEClass.getESuperTypes().add(this.getGlobalTask());
		globalScriptTaskEClass.getESuperTypes().add(this.getGlobalTask());
		globalTaskEClass.getESuperTypes().add(this.getCallableElement());
		globalUserTaskEClass.getESuperTypes().add(this.getGlobalTask());
		groupEClass.getESuperTypes().add(this.getArtifact());
		humanPerformerEClass.getESuperTypes().add(this.getPerformer());
		implicitThrowEventEClass.getESuperTypes().add(this.getThrowEvent());
		inclusiveGatewayEClass.getESuperTypes().add(this.getGateway());
		inputOutputSpecificationEClass.getESuperTypes().add(this.getBaseElement());
		inputSetEClass.getESuperTypes().add(this.getBaseElement());
		interfaceEClass.getESuperTypes().add(this.getRootElement());
		intermediateCatchEventEClass.getESuperTypes().add(this.getCatchEvent());
		intermediateThrowEventEClass.getESuperTypes().add(this.getThrowEvent());
		itemAwareElementEClass.getESuperTypes().add(this.getBaseElement());
		itemDefinitionEClass.getESuperTypes().add(this.getRootElement());
		laneEClass.getESuperTypes().add(this.getBaseElement());
		laneSetEClass.getESuperTypes().add(this.getBaseElement());
		linkEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		loopCharacteristicsEClass.getESuperTypes().add(this.getBaseElement());
		manualTaskEClass.getESuperTypes().add(this.getTask());
		messageEClass.getESuperTypes().add(this.getRootElement());
		messageEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		messageFlowEClass.getESuperTypes().add(this.getBaseElement());
		messageFlowAssociationEClass.getESuperTypes().add(this.getBaseElement());
		monitoringEClass.getESuperTypes().add(this.getBaseElement());
		multiInstanceLoopCharacteristicsEClass.getESuperTypes().add(this.getLoopCharacteristics());
		operationEClass.getESuperTypes().add(this.getBaseElement());
		outputSetEClass.getESuperTypes().add(this.getBaseElement());
		parallelGatewayEClass.getESuperTypes().add(this.getGateway());
		participantEClass.getESuperTypes().add(this.getBaseElement());
		participantEClass.getESuperTypes().add(this.getInteractionNode());
		participantAssociationEClass.getESuperTypes().add(this.getBaseElement());
		partnerEntityEClass.getESuperTypes().add(this.getRootElement());
		partnerRoleEClass.getESuperTypes().add(this.getRootElement());
		performerEClass.getESuperTypes().add(this.getResourceRole());
		potentialOwnerEClass.getESuperTypes().add(this.getHumanPerformer());
		processEClass.getESuperTypes().add(this.getCallableElement());
		processEClass.getESuperTypes().add(this.getFlowElementsContainer());
		propertyEClass.getESuperTypes().add(this.getItemAwareElement());
		receiveTaskEClass.getESuperTypes().add(this.getTask());
		relationshipEClass.getESuperTypes().add(this.getBaseElement());
		renderingEClass.getESuperTypes().add(this.getBaseElement());
		resourceEClass.getESuperTypes().add(this.getRootElement());
		resourceParameterEClass.getESuperTypes().add(this.getBaseElement());
		resourceRoleEClass.getESuperTypes().add(this.getBaseElement());
		rootElementEClass.getESuperTypes().add(this.getBaseElement());
		scriptTaskEClass.getESuperTypes().add(this.getTask());
		sendTaskEClass.getESuperTypes().add(this.getTask());
		sequenceFlowEClass.getESuperTypes().add(this.getFlowElement());
		serviceTaskEClass.getESuperTypes().add(this.getTask());
		signalEClass.getESuperTypes().add(this.getRootElement());
		signalEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		standardLoopCharacteristicsEClass.getESuperTypes().add(this.getLoopCharacteristics());
		startEventEClass.getESuperTypes().add(this.getCatchEvent());
		subChoreographyEClass.getESuperTypes().add(this.getChoreographyActivity());
		subChoreographyEClass.getESuperTypes().add(this.getFlowElementsContainer());
		subConversationEClass.getESuperTypes().add(this.getConversationNode());
		subProcessEClass.getESuperTypes().add(this.getActivity());
		subProcessEClass.getESuperTypes().add(this.getFlowElementsContainer());
		taskEClass.getESuperTypes().add(this.getActivity());
		taskEClass.getESuperTypes().add(this.getInteractionNode());
		terminateEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		textAnnotationEClass.getESuperTypes().add(this.getArtifact());
		throwEventEClass.getESuperTypes().add(this.getEvent());
		timerEventDefinitionEClass.getESuperTypes().add(this.getEventDefinition());
		transactionEClass.getESuperTypes().add(this.getSubProcess());
		userTaskEClass.getESuperTypes().add(this.getTask());
		candidateUserEClass.getESuperTypes().add(this.getBaseElement());
		candidateGroupEClass.getESuperTypes().add(this.getBaseElement());
		customPropertyEClass.getESuperTypes().add(this.getBaseElement());
		mailTaskEClass.getESuperTypes().add(this.getTask());
		fieldExtensionEClass.getESuperTypes().add(this.getBaseElement());
		complexDataTypeEClass.getESuperTypes().add(this.getBaseElement());
		dataGridEClass.getESuperTypes().add(this.getComplexDataType());
		dataGridRowEClass.getESuperTypes().add(this.getBaseElement());
		dataGridFieldEClass.getESuperTypes().add(this.getBaseElement());
		activitiListenerEClass.getESuperTypes().add(this.getBaseElement());
		formPropertyEClass.getESuperTypes().add(this.getBaseElement());
		ioParameterEClass.getESuperTypes().add(this.getBaseElement());
		alfrescoUserTaskEClass.getESuperTypes().add(this.getUserTask());
		alfrescoUserTaskEClass.getESuperTypes().add(this.getAlfrescoScriptBase());
		alfrescoStartEventEClass.getESuperTypes().add(this.getStartEvent());
		alfrescoStartEventEClass.getESuperTypes().add(this.getAlfrescoScriptBase());
		alfrescoScriptTaskEClass.getESuperTypes().add(this.getTask());
		alfrescoScriptTaskEClass.getESuperTypes().add(this.getAlfrescoScriptBase());
		alfrescoScriptBaseEClass.getESuperTypes().add(this.getBaseElement());
		alfrescoMailTaskEClass.getESuperTypes().add(this.getMailTask());
		formValueEClass.getESuperTypes().add(this.getBaseElement());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Activity(), this.getActivity(), null, "activity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AdHocSubProcess(), this.getAdHocSubProcess(), null, "adHocSubProcess", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FlowElement(), this.getFlowElement(), null, "flowElement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Artifact(), this.getArtifact(), null, "artifact", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Assignment(), this.getAssignment(), null, "assignment", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Association(), this.getAssociation(), null, "association", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Auditing(), this.getAuditing(), null, "auditing", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BaseElement(), this.getBaseElement(), null, "baseElement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BaseElementWithMixedContent(), ecorePackage.getEObject(), null, "baseElementWithMixedContent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BoundaryEvent(), this.getBoundaryEvent(), null, "boundaryEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BusinessRuleTask(), this.getBusinessRuleTask(), null, "businessRuleTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CallableElement(), this.getCallableElement(), null, "callableElement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CallActivity(), this.getCallActivity(), null, "callActivity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CallChoreography(), this.getCallChoreography(), null, "callChoreography", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CallConversation(), this.getCallConversation(), null, "callConversation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConversationNode(), this.getConversationNode(), null, "conversationNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CancelEventDefinition(), this.getCancelEventDefinition(), null, "cancelEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EventDefinition(), this.getEventDefinition(), null, "eventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_RootElement(), this.getRootElement(), null, "rootElement", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CatchEvent(), this.getCatchEvent(), null, "catchEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Category(), this.getCategory(), null, "category", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CategoryValue(), this.getCategoryValue(), null, "categoryValue", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Choreography(), this.getChoreography(), null, "choreography", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Collaboration(), this.getCollaboration(), null, "collaboration", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ChoreographyActivity(), this.getChoreographyActivity(), null, "choreographyActivity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ChoreographyTask(), this.getChoreographyTask(), null, "choreographyTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CompensateEventDefinition(), this.getCompensateEventDefinition(), null, "compensateEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ComplexBehaviorDefinition(), this.getComplexBehaviorDefinition(), null, "complexBehaviorDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ComplexGateway(), this.getComplexGateway(), null, "complexGateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConditionalEventDefinition(), this.getConditionalEventDefinition(), null, "conditionalEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Conversation(), this.getConversation(), null, "conversation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConversationAssociation(), this.getConversationAssociation(), null, "conversationAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConversationLink(), this.getConversationLink(), null, "conversationLink", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CorrelationKey(), this.getCorrelationKey(), null, "correlationKey", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CorrelationProperty(), this.getCorrelationProperty(), null, "correlationProperty", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CorrelationPropertyBinding(), this.getCorrelationPropertyBinding(), null, "correlationPropertyBinding", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CorrelationPropertyRetrievalExpression(), this.getCorrelationPropertyRetrievalExpression(), null, "correlationPropertyRetrievalExpression", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_CorrelationSubscription(), this.getCorrelationSubscription(), null, "correlationSubscription", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataAssociation(), this.getDataAssociation(), null, "dataAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataInput(), this.getDataInput(), null, "dataInput", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataInputAssociation(), this.getDataInputAssociation(), null, "dataInputAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataObject(), this.getDataObject(), null, "dataObject", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataObjectReference(), this.getDataObjectReference(), null, "dataObjectReference", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataOutput(), this.getDataOutput(), null, "dataOutput", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataOutputAssociation(), this.getDataOutputAssociation(), null, "dataOutputAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataState(), this.getDataState(), null, "dataState", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataStore(), this.getDataStore(), null, "dataStore", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_DataStoreReference(), this.getDataStoreReference(), null, "dataStoreReference", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Definitions(), this.getDefinitions(), null, "definitions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Documentation(), this.getDocumentation(), null, "documentation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EndEvent(), this.getEndEvent(), null, "endEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EndPoint(), this.getEndPoint(), null, "endPoint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Error(), this.getError(), null, "error", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ErrorEventDefinition(), this.getErrorEventDefinition(), null, "errorEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Escalation(), this.getEscalation(), null, "escalation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EscalationEventDefinition(), this.getEscalationEventDefinition(), null, "escalationEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Event(), this.getEvent(), null, "event", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_EventBasedGateway(), this.getEventBasedGateway(), null, "eventBasedGateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ExclusiveGateway(), this.getExclusiveGateway(), null, "exclusiveGateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Expression(), this.getExpression(), null, "expression", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Extension(), this.getExtension(), null, "extension", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ExtensionElements(), ecorePackage.getEObject(), null, "extensionElements", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FlowNode(), this.getFlowNode(), null, "flowNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_FormalExpression(), this.getFormalExpression(), null, "formalExpression", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Gateway(), this.getGateway(), null, "gateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalBusinessRuleTask(), this.getGlobalBusinessRuleTask(), null, "globalBusinessRuleTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalChoreographyTask(), this.getGlobalChoreographyTask(), null, "globalChoreographyTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalConversation(), this.getGlobalConversation(), null, "globalConversation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalManualTask(), this.getGlobalManualTask(), null, "globalManualTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalScriptTask(), this.getGlobalScriptTask(), null, "globalScriptTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalTask(), this.getGlobalTask(), null, "globalTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_GlobalUserTask(), this.getGlobalUserTask(), null, "globalUserTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Group(), this.getGroup(), null, "group", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HumanPerformer(), this.getHumanPerformer(), null, "humanPerformer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Performer(), this.getPerformer(), null, "performer", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceRole(), this.getResourceRole(), null, "resourceRole", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ImplicitThrowEvent(), this.getImplicitThrowEvent(), null, "implicitThrowEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Import(), this.getImport(), null, "import", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InclusiveGateway(), this.getInclusiveGateway(), null, "inclusiveGateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_InputSet(), this.getInputSet(), null, "inputSet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Interface(), this.getInterface(), null, "interface", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_IntermediateCatchEvent(), this.getIntermediateCatchEvent(), null, "intermediateCatchEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_IntermediateThrowEvent(), this.getIntermediateThrowEvent(), null, "intermediateThrowEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_IoBinding(), this.getInputOutputBinding(), null, "ioBinding", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_IoSpecification(), this.getInputOutputSpecification(), null, "ioSpecification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ItemDefinition(), this.getItemDefinition(), null, "itemDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Lane(), this.getLane(), null, "lane", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LaneSet(), this.getLaneSet(), null, "laneSet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LinkEventDefinition(), this.getLinkEventDefinition(), null, "linkEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LoopCharacteristics(), this.getLoopCharacteristics(), null, "loopCharacteristics", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ManualTask(), this.getManualTask(), null, "manualTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Message(), this.getMessage(), null, "message", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MessageEventDefinition(), this.getMessageEventDefinition(), null, "messageEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MessageFlow(), this.getMessageFlow(), null, "messageFlow", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MessageFlowAssociation(), this.getMessageFlowAssociation(), null, "messageFlowAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Monitoring(), this.getMonitoring(), null, "monitoring", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_MultiInstanceLoopCharacteristics(), this.getMultiInstanceLoopCharacteristics(), null, "multiInstanceLoopCharacteristics", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Operation(), this.getOperation(), null, "operation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_OutputSet(), this.getOutputSet(), null, "outputSet", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ParallelGateway(), this.getParallelGateway(), null, "parallelGateway", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Participant(), this.getParticipant(), null, "participant", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ParticipantAssociation(), this.getParticipantAssociation(), null, "participantAssociation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ParticipantMultiplicity(), this.getParticipantMultiplicity(), null, "participantMultiplicity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_PartnerEntity(), this.getPartnerEntity(), null, "partnerEntity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_PartnerRole(), this.getPartnerRole(), null, "partnerRole", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_PotentialOwner(), this.getPotentialOwner(), null, "potentialOwner", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Process(), this.getProcess(), null, "process", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Property(), this.getProperty(), null, "property", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ReceiveTask(), this.getReceiveTask(), null, "receiveTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Relationship(), this.getRelationship(), null, "relationship", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Rendering(), this.getRendering(), null, "rendering", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Resource(), this.getResource(), null, "resource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceAssignmentExpression(), this.getResourceAssignmentExpression(), null, "resourceAssignmentExpression", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceParameter(), this.getResourceParameter(), null, "resourceParameter", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceParameterBinding(), this.getResourceParameterBinding(), null, "resourceParameterBinding", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Script(), ecorePackage.getEObject(), null, "script", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ScriptTask(), this.getScriptTask(), null, "scriptTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SendTask(), this.getSendTask(), null, "sendTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SequenceFlow(), this.getSequenceFlow(), null, "sequenceFlow", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ServiceTask(), this.getServiceTask(), null, "serviceTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Signal(), this.getSignal(), null, "signal", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SignalEventDefinition(), this.getSignalEventDefinition(), null, "signalEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_StandardLoopCharacteristics(), this.getStandardLoopCharacteristics(), null, "standardLoopCharacteristics", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_StartEvent(), this.getStartEvent(), null, "startEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubChoreography(), this.getSubChoreography(), null, "subChoreography", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubConversation(), this.getSubConversation(), null, "subConversation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SubProcess(), this.getSubProcess(), null, "subProcess", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Task(), this.getTask(), null, "task", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TerminateEventDefinition(), this.getTerminateEventDefinition(), null, "terminateEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Text(), ecorePackage.getEObject(), null, "text", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TextAnnotation(), this.getTextAnnotation(), null, "textAnnotation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ThrowEvent(), this.getThrowEvent(), null, "throwEvent", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TimerEventDefinition(), this.getTimerEventDefinition(), null, "timerEventDefinition", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Transaction(), this.getTransaction(), null, "transaction", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_UserTask(), this.getUserTask(), null, "userTask", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(activityEClass, Activity.class, "Activity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_IoSpecification(), this.getInputOutputSpecification(), null, "ioSpecification", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_BoundaryEventRefs(), this.getBoundaryEvent(), this.getBoundaryEvent_AttachedToRef(), "boundaryEventRefs", null, 0, -1, Activity.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_Properties(), this.getProperty(), null, "properties", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_DataInputAssociations(), this.getDataInputAssociation(), null, "dataInputAssociations", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_DataOutputAssociations(), this.getDataOutputAssociation(), null, "dataOutputAssociations", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_Resources(), this.getResourceRole(), null, "resources", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_LoopCharacteristics(), this.getLoopCharacteristics(), null, "loopCharacteristics", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActivity_CompletionQuantity(), ecorePackage.getEInt(), "completionQuantity", "1", 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_Default(), this.getSequenceFlow(), null, "default", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActivity_IsForCompensation(), ecorePackage.getEBoolean(), "isForCompensation", "false", 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActivity_StartQuantity(), ecorePackage.getEInt(), "startQuantity", "1", 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_ActivitiListeners(), this.getActivitiListener(), null, "activitiListeners", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivity_Asynchronous(), ecorePackage.getEBoolean(), "asynchronous", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_ActivityActions(), theSecurebpmn2Package.getActivityAction(), theSecurebpmn2Package.getActivityAction_Activity(), "activityActions", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_ActivityAuthorizationConstraints(), theSecurebpmn2Package.getActivityAuthorizationConstraint(), theSecurebpmn2Package.getActivityAuthorizationConstraint_Activities(), "activityAuthorizationConstraints", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adHocSubProcessEClass, AdHocSubProcess.class, "AdHocSubProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdHocSubProcess_CompletionCondition(), this.getExpression(), null, "completionCondition", null, 1, 1, AdHocSubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdHocSubProcess_CancelRemainingInstances(), ecorePackage.getEBoolean(), "cancelRemainingInstances", "true", 1, 1, AdHocSubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdHocSubProcess_Ordering(), this.getAdHocOrdering(), "ordering", null, 1, 1, AdHocSubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(artifactEClass, Artifact.class, "Artifact", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_From(), this.getExpression(), null, "from", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssignment_To(), this.getExpression(), null, "to", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociation_AssociationDirection(), this.getAssociationDirection(), "associationDirection", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssociation_SourceRef(), this.getBaseElement(), null, "sourceRef", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssociation_TargetRef(), this.getBaseElement(), null, "targetRef", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(auditingEClass, Auditing.class, "Auditing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseElementEClass, BaseElement.class, "BaseElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBaseElement_ExtensionValues(), this.getExtensionAttributeValue(), null, "extensionValues", null, 0, -1, BaseElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getBaseElement_Documentation(), this.getDocumentation(), null, "documentation", null, 0, -1, BaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBaseElement_ExtensionDefinitions(), this.getExtensionDefinition(), null, "extensionDefinitions", null, 0, -1, BaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBaseElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, BaseElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(boundaryEventEClass, BoundaryEvent.class, "BoundaryEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoundaryEvent_AttachedToRef(), this.getActivity(), this.getActivity_BoundaryEventRefs(), "attachedToRef", null, 1, 1, BoundaryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBoundaryEvent_CancelActivity(), ecorePackage.getEBoolean(), "cancelActivity", "true", 1, 1, BoundaryEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(businessRuleTaskEClass, BusinessRuleTask.class, "BusinessRuleTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBusinessRuleTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, BusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBusinessRuleTask_RuleNames(), ecorePackage.getEString(), "ruleNames", null, 0, -1, BusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessRuleTask_InputVariables(), ecorePackage.getEString(), "inputVariables", null, 0, -1, BusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessRuleTask_ResultVariableName(), ecorePackage.getEString(), "resultVariableName", null, 0, 1, BusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessRuleTask_Exclude(), ecorePackage.getEBoolean(), "exclude", null, 0, 1, BusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callActivityEClass, CallActivity.class, "CallActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallActivity_CalledElementRef(), this.getCallableElement(), null, "calledElementRef", null, 0, 1, CallActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCallActivity_CalledElement(), ecorePackage.getEString(), "calledElement", null, 0, 1, CallActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallActivity_InParameters(), this.getIOParameter(), null, "inParameters", null, 0, -1, CallActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallActivity_OutParameters(), this.getIOParameter(), null, "outParameters", null, 0, -1, CallActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callChoreographyEClass, CallChoreography.class, "CallChoreography", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallChoreography_ParticipantAssociations(), this.getParticipantAssociation(), null, "participantAssociations", null, 0, -1, CallChoreography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallChoreography_CalledChoreographyRef(), this.getChoreography(), null, "calledChoreographyRef", null, 0, 1, CallChoreography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(callConversationEClass, CallConversation.class, "CallConversation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallConversation_ParticipantAssociations(), this.getParticipantAssociation(), null, "participantAssociations", null, 0, -1, CallConversation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallConversation_CalledCollaborationRef(), this.getCollaboration(), null, "calledCollaborationRef", null, 0, 1, CallConversation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(callableElementEClass, CallableElement.class, "CallableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallableElement_SupportedInterfaceRefs(), this.getInterface(), null, "supportedInterfaceRefs", null, 0, -1, CallableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallableElement_IoSpecification(), this.getInputOutputSpecification(), null, "ioSpecification", null, 0, 1, CallableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCallableElement_IoBinding(), this.getInputOutputBinding(), null, "ioBinding", null, 0, -1, CallableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCallableElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, CallableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cancelEventDefinitionEClass, CancelEventDefinition.class, "CancelEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(catchEventEClass, CatchEvent.class, "CatchEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatchEvent_DataOutputs(), this.getDataOutput(), null, "dataOutputs", null, 0, -1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCatchEvent_DataOutputAssociation(), this.getDataOutputAssociation(), null, "dataOutputAssociation", null, 0, -1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCatchEvent_OutputSet(), this.getOutputSet(), null, "outputSet", null, 0, 1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCatchEvent_EventDefinitions(), this.getEventDefinition(), null, "eventDefinitions", null, 0, -1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCatchEvent_EventDefinitionRefs(), this.getEventDefinition(), null, "eventDefinitionRefs", null, 0, -1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCatchEvent_ParallelMultiple(), ecorePackage.getEBoolean(), "parallelMultiple", null, 1, 1, CatchEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategory_CategoryValue(), this.getCategoryValue(), null, "categoryValue", null, 0, -1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 1, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categoryValueEClass, CategoryValue.class, "CategoryValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategoryValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, CategoryValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCategoryValue_CategorizedFlowElements(), this.getFlowElement(), this.getFlowElement_CategoryValueRef(), "categorizedFlowElements", null, 0, -1, CategoryValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(choreographyEClass, Choreography.class, "Choreography", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choreographyActivityEClass, ChoreographyActivity.class, "ChoreographyActivity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoreographyActivity_ParticipantRefs(), this.getParticipant(), null, "participantRefs", null, 2, -1, ChoreographyActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoreographyActivity_CorrelationKeys(), this.getCorrelationKey(), null, "correlationKeys", null, 0, -1, ChoreographyActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getChoreographyActivity_InitiatingParticipantRef(), this.getParticipant(), null, "initiatingParticipantRef", null, 1, 1, ChoreographyActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChoreographyActivity_LoopType(), this.getChoreographyLoopType(), "loopType", "None", 1, 1, ChoreographyActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(choreographyTaskEClass, ChoreographyTask.class, "ChoreographyTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoreographyTask_MessageFlowRef(), this.getMessageFlow(), null, "messageFlowRef", null, 1, 2, ChoreographyTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collaborationEClass, Collaboration.class, "Collaboration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollaboration_Participants(), this.getParticipant(), null, "participants", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_MessageFlows(), this.getMessageFlow(), null, "messageFlows", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_Artifacts(), this.getArtifact(), null, "artifacts", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_Conversations(), this.getConversationNode(), null, "conversations", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_ConversationAssociations(), this.getConversationAssociation(), null, "conversationAssociations", null, 1, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_ParticipantAssociations(), this.getParticipantAssociation(), null, "participantAssociations", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_MessageFlowAssociations(), this.getMessageFlowAssociation(), null, "messageFlowAssociations", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_CorrelationKeys(), this.getCorrelationKey(), null, "correlationKeys", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_ChoreographyRef(), this.getChoreography(), null, "choreographyRef", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollaboration_ConversationLinks(), this.getConversationLink(), null, "conversationLinks", null, 0, -1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCollaboration_IsClosed(), ecorePackage.getEBoolean(), "isClosed", null, 1, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCollaboration_Name(), ecorePackage.getEString(), "name", null, 1, 1, Collaboration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compensateEventDefinitionEClass, CompensateEventDefinition.class, "CompensateEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompensateEventDefinition_ActivityRef(), this.getActivity(), null, "activityRef", null, 0, 1, CompensateEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompensateEventDefinition_WaitForCompletion(), ecorePackage.getEBoolean(), "waitForCompletion", null, 1, 1, CompensateEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(complexBehaviorDefinitionEClass, ComplexBehaviorDefinition.class, "ComplexBehaviorDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexBehaviorDefinition_Condition(), this.getFormalExpression(), null, "condition", null, 1, 1, ComplexBehaviorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComplexBehaviorDefinition_Event(), this.getImplicitThrowEvent(), null, "event", null, 0, 1, ComplexBehaviorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(complexGatewayEClass, ComplexGateway.class, "ComplexGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexGateway_ActivationCondition(), this.getExpression(), null, "activationCondition", null, 0, 1, ComplexGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComplexGateway_Default(), this.getSequenceFlow(), null, "default", null, 0, 1, ComplexGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(conditionalEventDefinitionEClass, ConditionalEventDefinition.class, "ConditionalEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalEventDefinition_Condition(), this.getExpression(), null, "condition", null, 1, 1, ConditionalEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(conversationEClass, Conversation.class, "Conversation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conversationAssociationEClass, ConversationAssociation.class, "ConversationAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConversationAssociation_InnerConversationNodeRef(), this.getConversationNode(), null, "innerConversationNodeRef", null, 1, 1, ConversationAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConversationAssociation_OuterConversationNodeRef(), this.getConversationNode(), null, "outerConversationNodeRef", null, 1, 1, ConversationAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(conversationLinkEClass, ConversationLink.class, "ConversationLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConversationLink_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConversationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConversationLink_SourceRef(), this.getInteractionNode(), this.getInteractionNode_OutgoingConversationLinks(), "sourceRef", null, 1, 1, ConversationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConversationLink_TargetRef(), this.getInteractionNode(), this.getInteractionNode_IncomingConversationLinks(), "targetRef", null, 1, 1, ConversationLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(conversationNodeEClass, ConversationNode.class, "ConversationNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConversationNode_ParticipantRefs(), this.getParticipant(), null, "participantRefs", null, 2, -1, ConversationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConversationNode_MessageFlowRefs(), this.getMessageFlow(), null, "messageFlowRefs", null, 0, -1, ConversationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConversationNode_CorrelationKeys(), this.getCorrelationKey(), null, "correlationKeys", null, 0, -1, ConversationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConversationNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConversationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(correlationKeyEClass, CorrelationKey.class, "CorrelationKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrelationKey_CorrelationPropertyRef(), this.getCorrelationProperty(), null, "correlationPropertyRef", null, 0, -1, CorrelationKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCorrelationKey_Name(), ecorePackage.getEString(), "name", null, 1, 1, CorrelationKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(correlationPropertyEClass, CorrelationProperty.class, "CorrelationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrelationProperty_CorrelationPropertyRetrievalExpression(), this.getCorrelationPropertyRetrievalExpression(), null, "correlationPropertyRetrievalExpression", null, 1, -1, CorrelationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCorrelationProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, CorrelationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCorrelationProperty_Type(), this.getItemDefinition(), null, "type", null, 0, 1, CorrelationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(correlationPropertyBindingEClass, CorrelationPropertyBinding.class, "CorrelationPropertyBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrelationPropertyBinding_DataPath(), this.getFormalExpression(), null, "dataPath", null, 1, 1, CorrelationPropertyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCorrelationPropertyBinding_CorrelationPropertyRef(), this.getCorrelationProperty(), null, "correlationPropertyRef", null, 1, 1, CorrelationPropertyBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(correlationPropertyRetrievalExpressionEClass, CorrelationPropertyRetrievalExpression.class, "CorrelationPropertyRetrievalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrelationPropertyRetrievalExpression_MessagePath(), this.getFormalExpression(), null, "messagePath", null, 1, 1, CorrelationPropertyRetrievalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCorrelationPropertyRetrievalExpression_MessageRef(), this.getMessage(), null, "messageRef", null, 1, 1, CorrelationPropertyRetrievalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(correlationSubscriptionEClass, CorrelationSubscription.class, "CorrelationSubscription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCorrelationSubscription_CorrelationPropertyBinding(), this.getCorrelationPropertyBinding(), null, "correlationPropertyBinding", null, 0, -1, CorrelationSubscription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCorrelationSubscription_CorrelationKeyRef(), this.getCorrelationKey(), null, "correlationKeyRef", null, 1, 1, CorrelationSubscription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataAssociationEClass, DataAssociation.class, "DataAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataAssociation_SourceRef(), this.getItemAwareElement(), null, "sourceRef", null, 0, -1, DataAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataAssociation_TargetRef(), this.getItemAwareElement(), null, "targetRef", null, 1, 1, DataAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataAssociation_Transformation(), this.getFormalExpression(), null, "transformation", null, 0, 1, DataAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataAssociation_Assignment(), this.getAssignment(), null, "assignment", null, 0, -1, DataAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataInputEClass, DataInput.class, "DataInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataInput_InputSetWithOptional(), this.getInputSet(), this.getInputSet_OptionalInputRefs(), "inputSetWithOptional", null, 0, -1, DataInput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getDataInput_InputSetWithWhileExecuting(), this.getInputSet(), this.getInputSet_WhileExecutingInputRefs(), "inputSetWithWhileExecuting", null, 0, -1, DataInput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getDataInput_InputSetRefs(), this.getInputSet(), this.getInputSet_DataInputRefs(), "inputSetRefs", null, 1, -1, DataInput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataInput_IsCollection(), ecorePackage.getEBoolean(), "isCollection", "false", 1, 1, DataInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataInput_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataInputAssociationEClass, DataInputAssociation.class, "DataInputAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataObjectEClass, DataObject.class, "DataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataObject_IsCollection(), ecorePackage.getEBoolean(), "isCollection", "false", 1, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataObjectReferenceEClass, DataObjectReference.class, "DataObjectReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataObjectReference_DataObjectRef(), this.getDataObject(), null, "dataObjectRef", null, 1, 1, DataObjectReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataOutputEClass, DataOutput.class, "DataOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataOutput_OutputSetWithOptional(), this.getOutputSet(), this.getOutputSet_OptionalOutputRefs(), "outputSetWithOptional", null, 0, -1, DataOutput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getDataOutput_OutputSetWithWhileExecuting(), this.getOutputSet(), this.getOutputSet_WhileExecutingOutputRefs(), "outputSetWithWhileExecuting", null, 0, -1, DataOutput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getDataOutput_OutputSetRefs(), this.getOutputSet(), this.getOutputSet_DataOutputRefs(), "outputSetRefs", null, 1, -1, DataOutput.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataOutput_IsCollection(), ecorePackage.getEBoolean(), "isCollection", "false", 1, 1, DataOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataOutput_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataOutputAssociationEClass, DataOutputAssociation.class, "DataOutputAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataStateEClass, DataState.class, "DataState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataState_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataStoreEClass, DataStore.class, "DataStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataStore_Capacity(), ecorePackage.getEInt(), "capacity", null, 1, 1, DataStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataStore_IsUnlimited(), ecorePackage.getEBoolean(), "isUnlimited", "true", 1, 1, DataStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataStore_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataStore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataStoreReferenceEClass, DataStoreReference.class, "DataStoreReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStoreReference_DataStoreRef(), this.getDataStore(), null, "dataStoreRef", null, 0, 1, DataStoreReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(definitionsEClass, Definitions.class, "Definitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinitions_Imports(), this.getImport(), null, "imports", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDefinitions_Extensions(), this.getExtension(), null, "extensions", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDefinitions_RootElements(), this.getRootElement(), null, "rootElements", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDefinitions_Diagrams(), theBpmnDiPackage.getBPMNDiagram(), null, "diagrams", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDefinitions_Relationships(), this.getRelationship(), null, "relationships", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_Exporter(), ecorePackage.getEString(), "exporter", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_ExporterVersion(), ecorePackage.getEString(), "exporterVersion", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_ExpressionLanguage(), ecorePackage.getEString(), "expressionLanguage", "http://www.w3.org/1999/XPath", 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_Name(), ecorePackage.getEString(), "name", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_TargetNamespace(), ecorePackage.getEString(), "targetNamespace", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDefinitions_TypeLanguage(), ecorePackage.getEString(), "typeLanguage", "http://www.w3.org/2001/XMLSchema", 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(documentationEClass, Documentation.class, "Documentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentation_Text(), ecorePackage.getEString(), "text", null, 1, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDocumentation_TextFormat(), ecorePackage.getEString(), "textFormat", "text/plain", 1, 1, Documentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(endEventEClass, EndEvent.class, "EndEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorEClass, eu.aniketos.mtm.model.mtm_bpmn2.Error.class, "Error", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getError_ErrorCode(), ecorePackage.getEString(), "errorCode", null, 1, 1, eu.aniketos.mtm.model.mtm_bpmn2.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getError_Name(), ecorePackage.getEString(), "name", null, 1, 1, eu.aniketos.mtm.model.mtm_bpmn2.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getError_StructureRef(), this.getItemDefinition(), null, "structureRef", null, 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Error.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(errorEventDefinitionEClass, ErrorEventDefinition.class, "ErrorEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorEventDefinition_ErrorRef(), this.getError(), null, "errorRef", null, 0, 1, ErrorEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getErrorEventDefinition_ErrorCode(), ecorePackage.getEString(), "errorCode", null, 0, 1, ErrorEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(escalationEClass, Escalation.class, "Escalation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEscalation_EscalationCode(), ecorePackage.getEString(), "escalationCode", null, 1, 1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEscalation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEscalation_StructureRef(), this.getItemDefinition(), null, "structureRef", null, 0, 1, Escalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(escalationEventDefinitionEClass, EscalationEventDefinition.class, "EscalationEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEscalationEventDefinition_EscalationRef(), this.getEscalation(), null, "escalationRef", null, 0, 1, EscalationEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_Properties(), this.getProperty(), null, "properties", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eventBasedGatewayEClass, EventBasedGateway.class, "EventBasedGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventBasedGateway_EventGatewayType(), this.getEventBasedGatewayType(), "eventGatewayType", null, 1, 1, EventBasedGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEventBasedGateway_Instantiate(), ecorePackage.getEBoolean(), "instantiate", "false", 1, 1, EventBasedGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eventDefinitionEClass, EventDefinition.class, "EventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exclusiveGatewayEClass, ExclusiveGateway.class, "ExclusiveGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExclusiveGateway_Default(), this.getSequenceFlow(), null, "default", null, 0, 1, ExclusiveGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtension_Definition(), this.getExtensionDefinition(), null, "definition", null, 1, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtension_MustUnderstand(), ecorePackage.getEBoolean(), "mustUnderstand", "false", 1, 1, Extension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extensionAttributeDefinitionEClass, ExtensionAttributeDefinition.class, "ExtensionAttributeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensionAttributeDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtensionAttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionAttributeDefinition_Type(), ecorePackage.getEString(), "type", null, 1, 1, ExtensionAttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionAttributeDefinition_IsReference(), ecorePackage.getEBoolean(), "isReference", "false", 1, 1, ExtensionAttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionAttributeDefinition_ExtensionDefinition(), this.getExtensionDefinition(), this.getExtensionDefinition_ExtensionAttributeDefinitions(), "extensionDefinition", null, 1, 1, ExtensionAttributeDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(extensionAttributeValueEClass, ExtensionAttributeValue.class, "ExtensionAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionAttributeValue_ValueRef(), ecorePackage.getEObject(), null, "valueRef", null, 0, 1, ExtensionAttributeValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionAttributeValue_Value(), ecorePackage.getEObject(), null, "value", null, 0, 1, ExtensionAttributeValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionAttributeValue_ExtensionAttributeDefinition(), this.getExtensionAttributeDefinition(), null, "extensionAttributeDefinition", null, 1, 1, ExtensionAttributeValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(extensionDefinitionEClass, ExtensionDefinition.class, "ExtensionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensionDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtensionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionDefinition_ExtensionAttributeDefinitions(), this.getExtensionAttributeDefinition(), this.getExtensionAttributeDefinition_ExtensionDefinition(), "extensionAttributeDefinitions", null, 0, -1, ExtensionDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(flowElementEClass, FlowElement.class, "FlowElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowElement_Auditing(), this.getAuditing(), null, "auditing", null, 0, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFlowElement_Monitoring(), this.getMonitoring(), null, "monitoring", null, 0, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFlowElement_CategoryValueRef(), this.getCategoryValue(), this.getCategoryValue_CategorizedFlowElements(), "categoryValueRef", null, 0, -1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFlowElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, FlowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(flowElementsContainerEClass, FlowElementsContainer.class, "FlowElementsContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowElementsContainer_LaneSets(), this.getLaneSet(), null, "laneSets", null, 0, -1, FlowElementsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFlowElementsContainer_FlowElements(), this.getFlowElement(), null, "flowElements", null, 0, -1, FlowElementsContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(flowNodeEClass, FlowNode.class, "FlowNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowNode_Incoming(), this.getSequenceFlow(), this.getSequenceFlow_TargetRef(), "incoming", null, 0, -1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFlowNode_Lanes(), this.getLane(), this.getLane_FlowNodeRefs(), "lanes", null, 0, -1, FlowNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFlowNode_Outgoing(), this.getSequenceFlow(), this.getSequenceFlow_SourceRef(), "outgoing", null, 0, -1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowNode_IncomingSecurityFlow(), theSecurebpmn2Package.getSecurityFlow(), theSecurebpmn2Package.getSecurityFlow_TargetRefNode(), "incomingSecurityFlow", null, 0, -1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowNode_OutgoingSecurityFlow(), theSecurebpmn2Package.getSecurityFlow(), theSecurebpmn2Package.getSecurityFlow_SourceRefNode(), "outgoingSecurityFlow", null, 0, -1, FlowNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formalExpressionEClass, FormalExpression.class, "FormalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormalExpression_EvaluatesToTypeRef(), this.getItemDefinition(), null, "evaluatesToTypeRef", null, 1, 1, FormalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFormalExpression_Language(), ecorePackage.getEString(), "language", null, 1, 1, FormalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFormalExpression_Body(), ecorePackage.getEString(), "body", null, 0, 1, FormalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gatewayEClass, Gateway.class, "Gateway", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGateway_GatewayDirection(), this.getGatewayDirection(), "gatewayDirection", "unspecified", 1, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(globalBusinessRuleTaskEClass, GlobalBusinessRuleTask.class, "GlobalBusinessRuleTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGlobalBusinessRuleTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, GlobalBusinessRuleTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(globalChoreographyTaskEClass, GlobalChoreographyTask.class, "GlobalChoreographyTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalChoreographyTask_InitiatingParticipantRef(), this.getParticipant(), null, "initiatingParticipantRef", null, 1, 1, GlobalChoreographyTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(globalConversationEClass, GlobalConversation.class, "GlobalConversation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalManualTaskEClass, GlobalManualTask.class, "GlobalManualTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalScriptTaskEClass, GlobalScriptTask.class, "GlobalScriptTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGlobalScriptTask_Script(), ecorePackage.getEString(), "script", null, 1, 1, GlobalScriptTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGlobalScriptTask_ScriptLanguage(), ecorePackage.getEString(), "scriptLanguage", null, 1, 1, GlobalScriptTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(globalTaskEClass, GlobalTask.class, "GlobalTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalTask_Resources(), this.getResourceRole(), null, "resources", null, 0, -1, GlobalTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(globalUserTaskEClass, GlobalUserTask.class, "GlobalUserTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalUserTask_Renderings(), this.getRendering(), null, "renderings", null, 0, -1, GlobalUserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGlobalUserTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, GlobalUserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_CategoryValueRef(), this.getCategoryValue(), null, "categoryValueRef", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(humanPerformerEClass, HumanPerformer.class, "HumanPerformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(implicitThrowEventEClass, ImplicitThrowEvent.class, "ImplicitThrowEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_ImportType(), ecorePackage.getEString(), "importType", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImport_Location(), ecorePackage.getEString(), "location", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImport_Namespace(), ecorePackage.getEString(), "namespace", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inclusiveGatewayEClass, InclusiveGateway.class, "InclusiveGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInclusiveGateway_Default(), this.getSequenceFlow(), null, "default", null, 0, 1, InclusiveGateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputOutputBindingEClass, InputOutputBinding.class, "InputOutputBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputOutputBinding_InputDataRef(), this.getInputSet(), null, "inputDataRef", null, 1, 1, InputOutputBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputOutputBinding_OperationRef(), this.getOperation(), null, "operationRef", null, 1, 1, InputOutputBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputOutputBinding_OutputDataRef(), this.getOutputSet(), null, "outputDataRef", null, 1, 1, InputOutputBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputOutputSpecificationEClass, InputOutputSpecification.class, "InputOutputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputOutputSpecification_DataInputs(), this.getDataInput(), null, "dataInputs", null, 0, -1, InputOutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputOutputSpecification_DataOutputs(), this.getDataOutput(), null, "dataOutputs", null, 0, -1, InputOutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputOutputSpecification_InputSets(), this.getInputSet(), null, "inputSets", null, 1, -1, InputOutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputOutputSpecification_OutputSets(), this.getOutputSet(), null, "outputSets", null, 1, -1, InputOutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputSetEClass, InputSet.class, "InputSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputSet_DataInputRefs(), this.getDataInput(), this.getDataInput_InputSetRefs(), "dataInputRefs", null, 0, -1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputSet_OptionalInputRefs(), this.getDataInput(), this.getDataInput_InputSetWithOptional(), "optionalInputRefs", null, 0, -1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputSet_WhileExecutingInputRefs(), this.getDataInput(), this.getDataInput_InputSetWithWhileExecuting(), "whileExecutingInputRefs", null, 0, -1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInputSet_OutputSetRefs(), this.getOutputSet(), this.getOutputSet_InputSetRefs(), "outputSetRefs", null, 0, -1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInputSet_Name(), ecorePackage.getEString(), "name", null, 1, 1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interactionNodeEClass, InteractionNode.class, "InteractionNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInteractionNode_IncomingConversationLinks(), this.getConversationLink(), this.getConversationLink_TargetRef(), "incomingConversationLinks", null, 0, -1, InteractionNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getInteractionNode_OutgoingConversationLinks(), this.getConversationLink(), this.getConversationLink_SourceRef(), "outgoingConversationLinks", null, 0, -1, InteractionNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterface_Operations(), this.getOperation(), null, "operations", null, 1, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterface_ImplementationRef(), ecorePackage.getEObject(), null, "implementationRef", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInterface_Name(), ecorePackage.getEString(), "name", null, 1, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intermediateCatchEventEClass, IntermediateCatchEvent.class, "IntermediateCatchEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediateThrowEventEClass, IntermediateThrowEvent.class, "IntermediateThrowEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(itemAwareElementEClass, ItemAwareElement.class, "ItemAwareElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getItemAwareElement_DataState(), this.getDataState(), null, "dataState", null, 0, 1, ItemAwareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItemAwareElement_ItemSubjectRef(), this.getItemDefinition(), null, "itemSubjectRef", null, 0, 1, ItemAwareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItemAwareElement_ItemAwareElementActions(), theSecurebpmn2Package.getItemAwareElementAction(), theSecurebpmn2Package.getItemAwareElementAction_ItemAwareElement(), "itemAwareElementActions", null, 0, -1, ItemAwareElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemDefinitionEClass, ItemDefinition.class, "ItemDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItemDefinition_IsCollection(), ecorePackage.getEBoolean(), "isCollection", "false", 1, 1, ItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItemDefinition_Import(), this.getImport(), null, "import", null, 0, 1, ItemDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getItemDefinition_ItemKind(), this.getItemKind(), "itemKind", null, 1, 1, ItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getItemDefinition_StructureRef(), ecorePackage.getEObject(), null, "structureRef", null, 1, 1, ItemDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLane_PartitionElement(), this.getBaseElement(), null, "partitionElement", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLane_FlowNodeRefs(), this.getFlowNode(), this.getFlowNode_Lanes(), "flowNodeRefs", null, 0, -1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLane_ChildLaneSet(), this.getLaneSet(), null, "childLaneSet", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLane_Name(), ecorePackage.getEString(), "name", null, 1, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLane_PartitionElementRef(), this.getBaseElement(), null, "partitionElementRef", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(laneSetEClass, LaneSet.class, "LaneSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLaneSet_Lanes(), this.getLane(), null, "lanes", null, 0, -1, LaneSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLaneSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, LaneSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(linkEventDefinitionEClass, LinkEventDefinition.class, "LinkEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkEventDefinition_Source(), this.getLinkEventDefinition(), this.getLinkEventDefinition_Target(), "source", null, 0, -1, LinkEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLinkEventDefinition_Target(), this.getLinkEventDefinition(), this.getLinkEventDefinition_Source(), "target", null, 0, 1, LinkEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLinkEventDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, LinkEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loopCharacteristicsEClass, LoopCharacteristics.class, "LoopCharacteristics", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(manualTaskEClass, ManualTask.class, "ManualTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_ItemRef(), this.getItemDefinition(), null, "itemRef", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMessage_Name(), ecorePackage.getEString(), "name", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(messageEventDefinitionEClass, MessageEventDefinition.class, "MessageEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageEventDefinition_OperationRef(), this.getOperation(), null, "operationRef", null, 0, 1, MessageEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageEventDefinition_MessageRef(), this.getMessage(), null, "messageRef", null, 0, 1, MessageEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(messageFlowEClass, MessageFlow.class, "MessageFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageFlow_MessageRef(), this.getMessage(), null, "messageRef", null, 0, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMessageFlow_Name(), ecorePackage.getEString(), "name", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageFlow_SourceRef(), this.getInteractionNode(), null, "sourceRef", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageFlow_TargetRef(), this.getInteractionNode(), null, "targetRef", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(messageFlowAssociationEClass, MessageFlowAssociation.class, "MessageFlowAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageFlowAssociation_InnerMessageFlowRef(), this.getMessageFlow(), null, "innerMessageFlowRef", null, 1, 1, MessageFlowAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMessageFlowAssociation_OuterMessageFlowRef(), this.getMessageFlow(), null, "outerMessageFlowRef", null, 1, 1, MessageFlowAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(monitoringEClass, Monitoring.class, "Monitoring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiInstanceLoopCharacteristicsEClass, MultiInstanceLoopCharacteristics.class, "MultiInstanceLoopCharacteristics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiInstanceLoopCharacteristics_LoopDataInputRef(), this.getItemAwareElement(), null, "loopDataInputRef", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiInstanceLoopCharacteristics_LoopDataOutputRef(), this.getItemAwareElement(), null, "loopDataOutputRef", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiInstanceLoopCharacteristics_OutputDataItem(), this.getDataOutput(), null, "outputDataItem", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition(), this.getComplexBehaviorDefinition(), null, "complexBehaviorDefinition", null, 0, -1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_Behavior(), this.getMultiInstanceBehavior(), "behavior", "All", 1, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_IsSequential(), ecorePackage.getEBoolean(), "isSequential", "false", 1, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef(), this.getEventDefinition(), null, "noneBehaviorEventRef", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiInstanceLoopCharacteristics_OneBehaviorEventRef(), this.getEventDefinition(), null, "oneBehaviorEventRef", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_LoopCardinality(), ecorePackage.getEString(), "loopCardinality", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_InputDataItem(), ecorePackage.getEString(), "inputDataItem", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_CompletionCondition(), ecorePackage.getEString(), "completionCondition", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiInstanceLoopCharacteristics_ElementVariable(), ecorePackage.getEString(), "elementVariable", null, 0, 1, MultiInstanceLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_InMessageRef(), this.getMessage(), null, "inMessageRef", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_OutMessageRef(), this.getMessage(), null, "outMessageRef", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_ErrorRefs(), this.getError(), null, "errorRefs", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_ImplementationRef(), ecorePackage.getEObject(), null, "implementationRef", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputSetEClass, OutputSet.class, "OutputSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputSet_DataOutputRefs(), this.getDataOutput(), this.getDataOutput_OutputSetRefs(), "dataOutputRefs", null, 0, -1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputSet_OptionalOutputRefs(), this.getDataOutput(), this.getDataOutput_OutputSetWithOptional(), "optionalOutputRefs", null, 0, -1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputSet_WhileExecutingOutputRefs(), this.getDataOutput(), this.getDataOutput_OutputSetWithWhileExecuting(), "whileExecutingOutputRefs", null, 0, -1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputSet_InputSetRefs(), this.getInputSet(), this.getInputSet_OutputSetRefs(), "inputSetRefs", null, 0, -1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOutputSet_Name(), ecorePackage.getEString(), "name", null, 1, 1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parallelGatewayEClass, ParallelGateway.class, "ParallelGateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(participantEClass, Participant.class, "Participant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParticipant_InterfaceRefs(), this.getInterface(), null, "interfaceRefs", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParticipant_EndPointRefs(), this.getEndPoint(), null, "endPointRefs", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParticipant_ParticipantMultiplicity(), this.getParticipantMultiplicity(), null, "participantMultiplicity", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParticipant_Name(), ecorePackage.getEString(), "name", null, 1, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParticipant_ProcessRef(), this.getProcess(), null, "processRef", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(participantAssociationEClass, ParticipantAssociation.class, "ParticipantAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParticipantAssociation_InnerParticipantRef(), this.getParticipant(), null, "innerParticipantRef", null, 1, 1, ParticipantAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParticipantAssociation_OuterParticipantRef(), this.getParticipant(), null, "outerParticipantRef", null, 1, 1, ParticipantAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(participantMultiplicityEClass, ParticipantMultiplicity.class, "ParticipantMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParticipantMultiplicity_Maximum(), ecorePackage.getEInt(), "maximum", "1", 0, 1, ParticipantMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getParticipantMultiplicity_Minimum(), ecorePackage.getEInt(), "minimum", "0", 1, 1, ParticipantMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(partnerEntityEClass, PartnerEntity.class, "PartnerEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartnerEntity_ParticipantRef(), this.getParticipant(), null, "participantRef", null, 0, -1, PartnerEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPartnerEntity_Name(), ecorePackage.getEString(), "name", null, 1, 1, PartnerEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(partnerRoleEClass, PartnerRole.class, "PartnerRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartnerRole_ParticipantRef(), this.getParticipant(), null, "participantRef", null, 0, -1, PartnerRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPartnerRole_Name(), ecorePackage.getEString(), "name", null, 1, 1, PartnerRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(performerEClass, Performer.class, "Performer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(potentialOwnerEClass, PotentialOwner.class, "PotentialOwner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processEClass, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, "Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcess_Auditing(), this.getAuditing(), null, "auditing", null, 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_Monitoring(), this.getMonitoring(), null, "monitoring", null, 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_Properties(), this.getProperty(), null, "properties", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_Artifacts(), this.getArtifact(), null, "artifacts", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_Resources(), this.getResourceRole(), null, "resources", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_CorrelationSubscriptions(), this.getCorrelationSubscription(), null, "correlationSubscriptions", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_Supports(), this.getProcess(), null, "supports", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProcess_DefinitionalCollaborationRef(), this.getCollaboration(), null, "definitionalCollaborationRef", null, 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcess_IsClosed(), ecorePackage.getEBoolean(), "isClosed", null, 1, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcess_IsExecutable(), ecorePackage.getEBoolean(), "isExecutable", null, 1, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcess_ProcessType(), this.getProcessType(), "processType", null, 1, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProcess_Filename(), ecorePackage.getEString(), "filename", "", 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_ExecutionListeners(), this.getActivitiListener(), null, "executionListeners", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcess_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcess_ProcessActions(), theSecurebpmn2Package.getProcessAction(), theSecurebpmn2Package.getProcessAction_Process(), "processActions", null, 0, -1, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(receiveTaskEClass, ReceiveTask.class, "ReceiveTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReceiveTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, ReceiveTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReceiveTask_Instantiate(), ecorePackage.getEBoolean(), "instantiate", "false", 1, 1, ReceiveTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReceiveTask_MessageRef(), this.getMessage(), null, "messageRef", null, 0, 1, ReceiveTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReceiveTask_OperationRef(), this.getOperation(), null, "operationRef", null, 0, 1, ReceiveTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationship_Sources(), ecorePackage.getEObject(), null, "sources", null, 1, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRelationship_Targets(), ecorePackage.getEObject(), null, "targets", null, 1, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRelationship_Direction(), this.getRelationshipDirection(), "direction", null, 1, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRelationship_Type(), ecorePackage.getEString(), "type", null, 1, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(renderingEClass, Rendering.class, "Rendering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResource_ResourceParameters(), this.getResourceParameter(), null, "resourceParameters", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getResource_Name(), ecorePackage.getEString(), "name", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceAssignmentExpressionEClass, ResourceAssignmentExpression.class, "ResourceAssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceAssignmentExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, ResourceAssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceParameterEClass, ResourceParameter.class, "ResourceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceParameter_IsRequired(), ecorePackage.getEBoolean(), "isRequired", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getResourceParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceParameter_Type(), this.getItemDefinition(), null, "type", null, 0, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceParameterBindingEClass, ResourceParameterBinding.class, "ResourceParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceParameterBinding_Expression(), this.getExpression(), null, "expression", null, 1, 1, ResourceParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceParameterBinding_ParameterRef(), this.getResourceParameter(), null, "parameterRef", null, 1, 1, ResourceParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceRoleEClass, ResourceRole.class, "ResourceRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceRole_ResourceRef(), this.getResource(), null, "resourceRef", null, 0, 1, ResourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRole_ResourceParameterBindings(), this.getResourceParameterBinding(), null, "resourceParameterBindings", null, 0, -1, ResourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceRole_ResourceAssignmentExpression(), this.getResourceAssignmentExpression(), null, "resourceAssignmentExpression", null, 0, 1, ResourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getResourceRole_Name(), ecorePackage.getEString(), "name", null, 1, 1, ResourceRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rootElementEClass, RootElement.class, "RootElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptTaskEClass, ScriptTask.class, "ScriptTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptTask_Script(), ecorePackage.getEString(), "script", null, 1, 1, ScriptTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getScriptTask_ScriptFormat(), ecorePackage.getEString(), "scriptFormat", null, 1, 1, ScriptTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sendTaskEClass, SendTask.class, "SendTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSendTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, SendTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSendTask_MessageRef(), this.getMessage(), null, "messageRef", null, 0, 1, SendTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSendTask_OperationRef(), this.getOperation(), null, "operationRef", null, 0, 1, SendTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sequenceFlowEClass, SequenceFlow.class, "SequenceFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceFlow_ConditionExpression(), this.getFormalExpression(), null, "conditionExpression", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSequenceFlow_IsImmediate(), ecorePackage.getEBoolean(), "isImmediate", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequenceFlow_SourceRef(), this.getFlowNode(), this.getFlowNode_Outgoing(), "sourceRef", null, 1, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequenceFlow_TargetRef(), this.getFlowNode(), this.getFlowNode_Incoming(), "targetRef", null, 1, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequenceFlow_ExecutionListeners(), this.getActivitiListener(), null, "executionListeners", null, 0, -1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceTaskEClass, ServiceTask.class, "ServiceTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceTask_OperationRef(), this.getOperation(), null, "operationRef", null, 0, 1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceTask_CustomProperties(), this.getCustomProperty(), null, "customProperties", null, 0, -1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceTask_ImplementationType(), ecorePackage.getEString(), "implementationType", null, 0, 1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTask_FieldExtensions(), this.getFieldExtension(), null, "fieldExtensions", null, 0, -1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceTask_ResultVariableName(), ecorePackage.getEString(), "resultVariableName", null, 0, 1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceTask_SecurityExtensions(), theAniketosPackage.getSecurityExtension(), null, "SecurityExtensions", null, 0, 1, ServiceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signalEClass, Signal.class, "Signal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignal_Name(), ecorePackage.getEString(), "name", null, 1, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSignal_StructureRef(), this.getItemDefinition(), null, "structureRef", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(signalEventDefinitionEClass, SignalEventDefinition.class, "SignalEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSignalEventDefinition_SignalRef(), this.getSignal(), null, "signalRef", null, 0, 1, SignalEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(standardLoopCharacteristicsEClass, StandardLoopCharacteristics.class, "StandardLoopCharacteristics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStandardLoopCharacteristics_LoopCondition(), this.getExpression(), null, "loopCondition", null, 0, 1, StandardLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStandardLoopCharacteristics_LoopMaximum(), this.getExpression(), null, "loopMaximum", null, 0, 1, StandardLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStandardLoopCharacteristics_TestBefore(), ecorePackage.getEBoolean(), "testBefore", "false", 1, 1, StandardLoopCharacteristics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(startEventEClass, StartEvent.class, "StartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartEvent_IsInterrupting(), ecorePackage.getEBoolean(), "isInterrupting", "true", 1, 1, StartEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStartEvent_FormKey(), ecorePackage.getEString(), "formKey", null, 0, 1, StartEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartEvent_FormProperties(), this.getFormProperty(), null, "formProperties", null, 0, -1, StartEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStartEvent_Initiator(), ecorePackage.getEString(), "initiator", null, 0, 1, StartEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subChoreographyEClass, SubChoreography.class, "SubChoreography", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubChoreography_Artifacts(), this.getArtifact(), null, "artifacts", null, 0, -1, SubChoreography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subConversationEClass, SubConversation.class, "SubConversation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubConversation_ConversationNodes(), this.getConversationNode(), null, "conversationNodes", null, 0, -1, SubConversation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subProcessEClass, SubProcess.class, "SubProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubProcess_Artifacts(), this.getArtifact(), null, "artifacts", null, 0, -1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSubProcess_TriggeredByEvent(), ecorePackage.getEBoolean(), "triggeredByEvent", "false", 1, 1, SubProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(terminateEventDefinitionEClass, TerminateEventDefinition.class, "TerminateEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textAnnotationEClass, TextAnnotation.class, "TextAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextAnnotation_Text(), ecorePackage.getEString(), "text", null, 1, 1, TextAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTextAnnotation_TextFormat(), ecorePackage.getEString(), "textFormat", "text/plain", 1, 1, TextAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(throwEventEClass, ThrowEvent.class, "ThrowEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThrowEvent_DataInputs(), this.getDataInput(), null, "dataInputs", null, 0, -1, ThrowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getThrowEvent_DataInputAssociation(), this.getDataInputAssociation(), null, "dataInputAssociation", null, 0, -1, ThrowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getThrowEvent_InputSet(), this.getInputSet(), null, "inputSet", null, 0, 1, ThrowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getThrowEvent_EventDefinitions(), this.getEventDefinition(), null, "eventDefinitions", null, 0, -1, ThrowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getThrowEvent_EventDefinitionRefs(), this.getEventDefinition(), null, "eventDefinitionRefs", null, 0, -1, ThrowEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(timerEventDefinitionEClass, TimerEventDefinition.class, "TimerEventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimerEventDefinition_TimeDate(), this.getExpression(), null, "timeDate", null, 0, 1, TimerEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimerEventDefinition_TimeDuration(), this.getExpression(), null, "timeDuration", null, 0, 1, TimerEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimerEventDefinition_TimeCycle(), this.getExpression(), null, "timeCycle", null, 0, 1, TimerEventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(transactionEClass, Transaction.class, "Transaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransaction_Protocol(), ecorePackage.getEString(), "protocol", null, 0, 1, Transaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTransaction_Method(), ecorePackage.getEString(), "method", null, 1, 1, Transaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(userTaskEClass, UserTask.class, "UserTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserTask_Renderings(), this.getRendering(), null, "renderings", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUserTask_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUserTask_Assignee(), ecorePackage.getEString(), "assignee", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserTask_CandidateUsers(), this.getCandidateUser(), null, "candidateUsers", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserTask_CandidateGroups(), this.getCandidateGroup(), null, "candidateGroups", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserTask_FormKey(), ecorePackage.getEString(), "formKey", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserTask_FormProperties(), this.getFormProperty(), null, "formProperties", null, 0, -1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserTask_Priority(), ecorePackage.getEIntegerObject(), "priority", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserTask_DueDate(), ecorePackage.getEString(), "dueDate", null, 0, 1, UserTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(candidateUserEClass, CandidateUser.class, "CandidateUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCandidateUser_User(), ecorePackage.getEString(), "user", null, 0, 1, CandidateUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(candidateGroupEClass, CandidateGroup.class, "CandidateGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCandidateGroup_Group(), ecorePackage.getEString(), "group", null, 0, 1, CandidateGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customPropertyEClass, CustomProperty.class, "CustomProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, CustomProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomProperty_SimpleValue(), ecorePackage.getEString(), "simpleValue", null, 0, 1, CustomProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomProperty_ComplexValue(), this.getComplexDataType(), null, "complexValue", null, 0, 1, CustomProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mailTaskEClass, MailTask.class, "MailTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMailTask_To(), ecorePackage.getEString(), "to", null, 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_From(), ecorePackage.getEString(), "from", "", 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_Subject(), ecorePackage.getEString(), "subject", null, 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_Cc(), ecorePackage.getEString(), "cc", null, 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_Bcc(), ecorePackage.getEString(), "bcc", "", 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_Html(), ecorePackage.getEString(), "html", null, 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMailTask_Text(), ecorePackage.getEString(), "text", null, 0, 1, MailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldExtensionEClass, FieldExtension.class, "FieldExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldExtension_Fieldname(), ecorePackage.getEString(), "fieldname", null, 0, 1, FieldExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFieldExtension_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, FieldExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexDataTypeEClass, ComplexDataType.class, "ComplexDataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataGridEClass, DataGrid.class, "DataGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataGrid_Row(), this.getDataGridRow(), null, "row", null, 0, -1, DataGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataGridRowEClass, DataGridRow.class, "DataGridRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataGridRow_Index(), ecorePackage.getEInt(), "index", null, 1, 1, DataGridRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataGridRow_Field(), this.getDataGridField(), null, "field", null, 0, -1, DataGridRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataGridFieldEClass, DataGridField.class, "DataGridField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataGridField_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataGridField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataGridField_SimpleValue(), ecorePackage.getEString(), "simpleValue", null, 1, 1, DataGridField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activitiListenerEClass, ActivitiListener.class, "ActivitiListener", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivitiListener_ImplementationType(), ecorePackage.getEString(), "implementationType", null, 0, 1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivitiListener_Implementation(), ecorePackage.getEString(), "implementation", null, 0, 1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivitiListener_Event(), ecorePackage.getEString(), "event", null, 0, 1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivitiListener_FieldExtensions(), this.getFieldExtension(), null, "fieldExtensions", null, 0, -1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivitiListener_RunAs(), ecorePackage.getEString(), "runAs", null, 0, 1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivitiListener_ScriptProcessor(), ecorePackage.getEString(), "scriptProcessor", null, 0, 1, ActivitiListener.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formPropertyEClass, FormProperty.class, "FormProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Type(), ecorePackage.getEString(), "type", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Readable(), theXMLTypePackage.getBooleanObject(), "readable", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Writeable(), ecorePackage.getEBooleanObject(), "writeable", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormProperty_Required(), ecorePackage.getEBooleanObject(), "required", null, 0, 1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormProperty_FormValues(), this.getFormValue(), null, "formValues", null, 0, -1, FormProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ioParameterEClass, IOParameter.class, "IOParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIOParameter_Source(), ecorePackage.getEString(), "source", null, 0, 1, IOParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIOParameter_Target(), ecorePackage.getEString(), "target", null, 0, 1, IOParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alfrescoUserTaskEClass, AlfrescoUserTask.class, "AlfrescoUserTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alfrescoStartEventEClass, AlfrescoStartEvent.class, "AlfrescoStartEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alfrescoScriptTaskEClass, AlfrescoScriptTask.class, "AlfrescoScriptTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlfrescoScriptTask_Script(), ecorePackage.getEString(), "script", null, 0, 1, AlfrescoScriptTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alfrescoScriptBaseEClass, AlfrescoScriptBase.class, "AlfrescoScriptBase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlfrescoScriptBase_RunAs(), ecorePackage.getEString(), "runAs", null, 0, 1, AlfrescoScriptBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlfrescoScriptBase_ScriptProcessor(), ecorePackage.getEString(), "scriptProcessor", null, 0, 1, AlfrescoScriptBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alfrescoMailTaskEClass, AlfrescoMailTask.class, "AlfrescoMailTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlfrescoMailTask_ToMany(), ecorePackage.getEString(), "toMany", null, 0, 1, AlfrescoMailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlfrescoMailTask_Template(), ecorePackage.getEString(), "template", null, 0, 1, AlfrescoMailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlfrescoMailTask_TemplateModel(), ecorePackage.getEString(), "templateModel", null, 0, 1, AlfrescoMailTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formValueEClass, FormValue.class, "FormValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormValue_ValueId(), ecorePackage.getEString(), "valueId", null, 0, 1, FormValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFormValue_ValueName(), ecorePackage.getEString(), "valueName", null, 0, 1, FormValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(adHocOrderingEEnum, AdHocOrdering.class, "AdHocOrdering");
		addEEnumLiteral(adHocOrderingEEnum, AdHocOrdering.PARALLEL);
		addEEnumLiteral(adHocOrderingEEnum, AdHocOrdering.SEQUENTIAL);

		initEEnum(associationDirectionEEnum, AssociationDirection.class, "AssociationDirection");
		addEEnumLiteral(associationDirectionEEnum, AssociationDirection.NONE);
		addEEnumLiteral(associationDirectionEEnum, AssociationDirection.ONE);
		addEEnumLiteral(associationDirectionEEnum, AssociationDirection.BOTH);

		initEEnum(choreographyLoopTypeEEnum, ChoreographyLoopType.class, "ChoreographyLoopType");
		addEEnumLiteral(choreographyLoopTypeEEnum, ChoreographyLoopType.NONE);
		addEEnumLiteral(choreographyLoopTypeEEnum, ChoreographyLoopType.STANDARD);
		addEEnumLiteral(choreographyLoopTypeEEnum, ChoreographyLoopType.MULTI_INSTANCE_SEQUENTIAL);
		addEEnumLiteral(choreographyLoopTypeEEnum, ChoreographyLoopType.MULTI_INSTANCE_PARALLEL);

		initEEnum(eventBasedGatewayTypeEEnum, EventBasedGatewayType.class, "EventBasedGatewayType");
		addEEnumLiteral(eventBasedGatewayTypeEEnum, EventBasedGatewayType.PARALLEL);
		addEEnumLiteral(eventBasedGatewayTypeEEnum, EventBasedGatewayType.EXCLUSIVE);

		initEEnum(gatewayDirectionEEnum, GatewayDirection.class, "GatewayDirection");
		addEEnumLiteral(gatewayDirectionEEnum, GatewayDirection.UNSPECIFIED);
		addEEnumLiteral(gatewayDirectionEEnum, GatewayDirection.CONVERGING);
		addEEnumLiteral(gatewayDirectionEEnum, GatewayDirection.DIVERGING);
		addEEnumLiteral(gatewayDirectionEEnum, GatewayDirection.MIXED);

		initEEnum(itemKindEEnum, ItemKind.class, "ItemKind");
		addEEnumLiteral(itemKindEEnum, ItemKind.PHYSICAL);
		addEEnumLiteral(itemKindEEnum, ItemKind.INFORMATION);

		initEEnum(multiInstanceBehaviorEEnum, MultiInstanceBehavior.class, "MultiInstanceBehavior");
		addEEnumLiteral(multiInstanceBehaviorEEnum, MultiInstanceBehavior.NONE);
		addEEnumLiteral(multiInstanceBehaviorEEnum, MultiInstanceBehavior.ONE);
		addEEnumLiteral(multiInstanceBehaviorEEnum, MultiInstanceBehavior.ALL);
		addEEnumLiteral(multiInstanceBehaviorEEnum, MultiInstanceBehavior.COMPLEX);

		initEEnum(processTypeEEnum, ProcessType.class, "ProcessType");
		addEEnumLiteral(processTypeEEnum, ProcessType.NONE);
		addEEnumLiteral(processTypeEEnum, ProcessType.PUBLIC);
		addEEnumLiteral(processTypeEEnum, ProcessType.PRIVATE);

		initEEnum(relationshipDirectionEEnum, RelationshipDirection.class, "RelationshipDirection");
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.NONE);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.FORWARD);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.BACKWARD);
		addEEnumLiteral(relationshipDirectionEEnum, RelationshipDirection.BOTH);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Activity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "activity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_AdHocSubProcess(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "adHocSubProcess",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_FlowElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flowElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Artifact(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "artifact",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Assignment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assignment",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Association(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "association",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getDocumentRoot_Auditing(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "auditing",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_BaseElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "baseElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_BaseElementWithMixedContent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "baseElementWithMixedContent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_BoundaryEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "boundaryEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_BusinessRuleTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "businessRuleTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CallableElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callableElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CallActivity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callActivity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CallChoreography(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callChoreography",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CallConversation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callConversation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#conversationNode"
		   });		
		addAnnotation
		  (getDocumentRoot_ConversationNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationNode",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CancelEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "cancelEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_EventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_RootElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rootElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CatchEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "catchEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Category(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "category",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CategoryValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "categoryValue",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Choreography(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "choreography",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#collaboration"
		   });		
		addAnnotation
		  (getDocumentRoot_Collaboration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "collaboration",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ChoreographyActivity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "choreographyActivity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ChoreographyTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "choreographyTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CompensateEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "compensateEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_ComplexBehaviorDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "complexBehaviorDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ComplexGateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "complexGateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ConditionalEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conditionalEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_Conversation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#conversationNode"
		   });		
		addAnnotation
		  (getDocumentRoot_ConversationAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ConversationLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationLink",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CorrelationKey(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationKey",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CorrelationProperty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationProperty",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_CorrelationPropertyBinding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationPropertyBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CorrelationPropertyRetrievalExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationPropertyRetrievalExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_CorrelationSubscription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationSubscription",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataInput(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataInputAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataObject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataObject",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_DataObjectReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataObjectReference",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_DataOutput(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataOutputAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataState(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataState",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_DataStore(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataStore",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_DataStoreReference(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataStoreReference",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Definitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "definitions",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_EndEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "endEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_EndPoint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "endPoint",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Error(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "error",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ErrorEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "errorEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_Escalation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "escalation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_EscalationEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "escalationEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_Event(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "event",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_EventBasedGateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventBasedGateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ExclusiveGateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "exclusiveGateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extension",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ExtensionElements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extensionElements",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_FlowNode(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flowNode",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_FormalExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "formalExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#expression"
		   });		
		addAnnotation
		  (getDocumentRoot_Gateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "gateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalBusinessRuleTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalBusinessRuleTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalChoreographyTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalChoreographyTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#choreography"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalConversation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalConversation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#collaboration"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalManualTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalManualTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalScriptTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalScriptTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_GlobalUserTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalUserTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Group(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "group",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getDocumentRoot_HumanPerformer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "humanPerformer",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#performer"
		   });		
		addAnnotation
		  (getDocumentRoot_Performer(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "performer",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#resourceRole"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceRole",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ImplicitThrowEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "implicitThrowEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Import(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_InclusiveGateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inclusiveGateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_InputSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interface",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_IntermediateCatchEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "intermediateCatchEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_IntermediateThrowEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "intermediateThrowEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_IoBinding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ioBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_IoSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ioSpecification",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ItemDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "itemDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Lane(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "lane",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_LaneSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "laneSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_LinkEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "linkEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_LoopCharacteristics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "loopCharacteristics",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ManualTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "manualTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Message(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "message",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_MessageEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_MessageFlow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlow",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_MessageFlowAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlowAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Monitoring(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "monitoring",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_MultiInstanceLoopCharacteristics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "multiInstanceLoopCharacteristics",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#loopCharacteristics"
		   });		
		addAnnotation
		  (getDocumentRoot_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_OutputSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ParallelGateway(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parallelGateway",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Participant(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participant",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ParticipantAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ParticipantMultiplicity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantMultiplicity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_PartnerEntity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partnerEntity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_PartnerRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partnerRole",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_PotentialOwner(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "potentialOwner",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#performer"
		   });		
		addAnnotation
		  (getDocumentRoot_Process(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "process",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ReceiveTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receiveTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Relationship(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "relationship",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Rendering(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rendering",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceAssignmentExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceAssignmentExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceParameter",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_ResourceParameterBinding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceParameterBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_Script(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "script",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ScriptTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scriptTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_SendTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sendTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_SequenceFlow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequenceFlow",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_ServiceTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "serviceTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Signal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "signal",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDocumentRoot_SignalEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "signalEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_StandardLoopCharacteristics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "standardLoopCharacteristics",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#loopCharacteristics"
		   });		
		addAnnotation
		  (getDocumentRoot_StartEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "startEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_SubChoreography(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "subChoreography",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_SubConversation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "subConversation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#conversationNode"
		   });		
		addAnnotation
		  (getDocumentRoot_SubProcess(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "subProcess",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_Task(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "task",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_TerminateEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminateEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_Text(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "text",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_TextAnnotation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "textAnnotation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getDocumentRoot_ThrowEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throwEvent",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDocumentRoot_TimerEventDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "timerEventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getDocumentRoot_Transaction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transaction",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (getDocumentRoot_UserTask(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "userTask",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "affiliation", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (activityEClass, 
		   source, 
		   new String[] {
			 "name", "tActivity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActivity_IoSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ioSpecification",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getActivity_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getActivity_DataInputAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getActivity_DataOutputAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getActivity_Resources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceRole",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#resourceRole"
		   });		
		addAnnotation
		  (getActivity_LoopCharacteristics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "loopCharacteristics",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#loopCharacteristics"
		   });		
		addAnnotation
		  (getActivity_CompletionQuantity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "completionQuantity"
		   });		
		addAnnotation
		  (getActivity_Default(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default"
		   });		
		addAnnotation
		  (getActivity_IsForCompensation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isForCompensation"
		   });		
		addAnnotation
		  (getActivity_StartQuantity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "startQuantity"
		   });		
		addAnnotation
		  (adHocSubProcessEClass, 
		   source, 
		   new String[] {
			 "name", "tAdHocSubProcess",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAdHocSubProcess_CompletionCondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "completionCondition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getAdHocSubProcess_CancelRemainingInstances(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cancelRemainingInstances"
		   });		
		addAnnotation
		  (getAdHocSubProcess_Ordering(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ordering"
		   });		
		addAnnotation
		  (artifactEClass, 
		   source, 
		   new String[] {
			 "name", "tArtifact",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (assignmentEClass, 
		   source, 
		   new String[] {
			 "name", "tAssignment",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAssignment_From(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "from",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getAssignment_To(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "to",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (associationEClass, 
		   source, 
		   new String[] {
			 "name", "tAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAssociation_AssociationDirection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "associationDirection"
		   });		
		addAnnotation
		  (getAssociation_SourceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceRef"
		   });		
		addAnnotation
		  (getAssociation_TargetRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetRef"
		   });		
		addAnnotation
		  (auditingEClass, 
		   source, 
		   new String[] {
			 "name", "tAuditing",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (baseElementEClass, 
		   source, 
		   new String[] {
			 "name", "tBaseElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBaseElement_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getBaseElement_ExtensionDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extensionElements",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getBaseElement_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });		
		addAnnotation
		  (boundaryEventEClass, 
		   source, 
		   new String[] {
			 "name", "tBoundaryEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBoundaryEvent_AttachedToRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "attachedToRef"
		   });		
		addAnnotation
		  (getBoundaryEvent_CancelActivity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "cancelActivity"
		   });		
		addAnnotation
		  (businessRuleTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tBusinessRuleTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBusinessRuleTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (callActivityEClass, 
		   source, 
		   new String[] {
			 "name", "tCallActivity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCallActivity_CalledElementRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "calledElement"
		   });		
		addAnnotation
		  (callChoreographyEClass, 
		   source, 
		   new String[] {
			 "name", "tCallChoreography",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCallChoreography_ParticipantAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCallChoreography_CalledChoreographyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "calledChoreographyRef"
		   });		
		addAnnotation
		  (callConversationEClass, 
		   source, 
		   new String[] {
			 "name", "tCallConversation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCallConversation_ParticipantAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCallConversation_CalledCollaborationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "calledCollaborationRef"
		   });		
		addAnnotation
		  (callableElementEClass, 
		   source, 
		   new String[] {
			 "name", "tCallableElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCallableElement_SupportedInterfaceRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "supportedInterfaceRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCallableElement_IoSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ioSpecification",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCallableElement_IoBinding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ioBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCallableElement_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (cancelEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tCancelEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (catchEventEClass, 
		   source, 
		   new String[] {
			 "name", "tCatchEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCatchEvent_DataOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCatchEvent_DataOutputAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCatchEvent_OutputSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCatchEvent_EventDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getCatchEvent_EventDefinitionRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventDefinitionRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCatchEvent_ParallelMultiple(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parallelMultiple"
		   });		
		addAnnotation
		  (categoryEClass, 
		   source, 
		   new String[] {
			 "name", "tCategory",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCategory_CategoryValue(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "categoryValue",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCategory_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (categoryValueEClass, 
		   source, 
		   new String[] {
			 "name", "tCategoryValue",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCategoryValue_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });		
		addAnnotation
		  (choreographyEClass, 
		   source, 
		   new String[] {
			 "name", "tChoreography",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (choreographyActivityEClass, 
		   source, 
		   new String[] {
			 "name", "tChoreographyActivity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getChoreographyActivity_ParticipantRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getChoreographyActivity_CorrelationKeys(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationKey",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getChoreographyActivity_InitiatingParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "initiatingParticipantRef"
		   });		
		addAnnotation
		  (getChoreographyActivity_LoopType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "loopType"
		   });		
		addAnnotation
		  (choreographyTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tChoreographyTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getChoreographyTask_MessageFlowRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlowRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (collaborationEClass, 
		   source, 
		   new String[] {
			 "name", "tCollaboration",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCollaboration_Participants(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participant",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_MessageFlows(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlow",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_Artifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "artifact",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getCollaboration_Conversations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationNode",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#conversationNode"
		   });		
		addAnnotation
		  (getCollaboration_ConversationAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_ParticipantAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_MessageFlowAssociations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlowAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_CorrelationKeys(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationKey",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_ChoreographyRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "choreographyRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_ConversationLinks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationLink",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCollaboration_IsClosed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isClosed"
		   });		
		addAnnotation
		  (getCollaboration_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (compensateEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tCompensateEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCompensateEventDefinition_ActivityRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "activityRef"
		   });		
		addAnnotation
		  (getCompensateEventDefinition_WaitForCompletion(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "waitForCompletion"
		   });		
		addAnnotation
		  (complexBehaviorDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tComplexBehaviorDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComplexBehaviorDefinition_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "condition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getComplexBehaviorDefinition_Event(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "event",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (complexGatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tComplexGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComplexGateway_ActivationCondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "activationCondition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getComplexGateway_Default(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default"
		   });		
		addAnnotation
		  (conditionalEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tConditionalEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getConditionalEventDefinition_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "condition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (conversationEClass, 
		   source, 
		   new String[] {
			 "name", "tConversation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (conversationAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tConversationAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getConversationAssociation_InnerConversationNodeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "innerConversationNodeRef"
		   });		
		addAnnotation
		  (getConversationAssociation_OuterConversationNodeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "outerConversationNodeRef"
		   });		
		addAnnotation
		  (conversationLinkEClass, 
		   source, 
		   new String[] {
			 "name", "tConversationLink",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getConversationLink_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getConversationLink_SourceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceRef"
		   });		
		addAnnotation
		  (getConversationLink_TargetRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetRef"
		   });		
		addAnnotation
		  (conversationNodeEClass, 
		   source, 
		   new String[] {
			 "name", "tConversationNode",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getConversationNode_ParticipantRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getConversationNode_MessageFlowRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messageFlowRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getConversationNode_CorrelationKeys(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationKey",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getConversationNode_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (correlationKeyEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationKey",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCorrelationKey_CorrelationPropertyRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationPropertyRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCorrelationKey_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (correlationPropertyEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationProperty",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCorrelationProperty_CorrelationPropertyRetrievalExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationPropertyRetrievalExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCorrelationProperty_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getCorrelationProperty_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (correlationPropertyBindingEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationPropertyBinding",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCorrelationPropertyBinding_DataPath(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataPath",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCorrelationPropertyBinding_CorrelationPropertyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "correlationPropertyRef"
		   });		
		addAnnotation
		  (correlationPropertyRetrievalExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationPropertyRetrievalExpression",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCorrelationPropertyRetrievalExpression_MessagePath(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "messagePath",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCorrelationPropertyRetrievalExpression_MessageRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageRef"
		   });		
		addAnnotation
		  (correlationSubscriptionEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationSubscription",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCorrelationSubscription_CorrelationPropertyBinding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationPropertyBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getCorrelationSubscription_CorrelationKeyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "correlationKeyRef"
		   });		
		addAnnotation
		  (dataAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tDataAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataAssociation_SourceRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sourceRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDataAssociation_TargetRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "targetRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDataAssociation_Transformation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transformation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDataAssociation_Assignment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assignment",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (dataInputEClass, 
		   source, 
		   new String[] {
			 "name", "tDataInput",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataInput_IsCollection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isCollection"
		   });		
		addAnnotation
		  (getDataInput_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (dataInputAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tDataInputAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (dataObjectEClass, 
		   source, 
		   new String[] {
			 "name", "tDataObject",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataObject_IsCollection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isCollection"
		   });		
		addAnnotation
		  (dataObjectReferenceEClass, 
		   source, 
		   new String[] {
			 "name", "tDataObjectReference",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataObjectReference_DataObjectRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dataObjectRef"
		   });		
		addAnnotation
		  (dataOutputEClass, 
		   source, 
		   new String[] {
			 "name", "tDataOutput",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataOutput_IsCollection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isCollection"
		   });		
		addAnnotation
		  (getDataOutput_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (dataOutputAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tDataOutputAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (dataStateEClass, 
		   source, 
		   new String[] {
			 "name", "tDataState",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataState_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (dataStoreEClass, 
		   source, 
		   new String[] {
			 "name", "tDataStore",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataStore_Capacity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "capacity"
		   });		
		addAnnotation
		  (getDataStore_IsUnlimited(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isUnlimited"
		   });		
		addAnnotation
		  (getDataStore_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (dataStoreReferenceEClass, 
		   source, 
		   new String[] {
			 "name", "tDataStoreReference",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDataStoreReference_DataStoreRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "dataStoreRef"
		   });		
		addAnnotation
		  (definitionsEClass, 
		   source, 
		   new String[] {
			 "name", "tDefinitions",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDefinitions_Imports(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDefinitions_Extensions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extension",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDefinitions_RootElements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rootElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#rootElement"
		   });		
		addAnnotation
		  (getDefinitions_Diagrams(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BPMNDiagram",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/DI"
		   });		
		addAnnotation
		  (getDefinitions_Relationships(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "relationship",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getDefinitions_Exporter(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "exporter"
		   });		
		addAnnotation
		  (getDefinitions_ExporterVersion(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "exporterVersion"
		   });		
		addAnnotation
		  (getDefinitions_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getDefinitions_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getDefinitions_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });		
		addAnnotation
		  (getDefinitions_TypeLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "typeLanguage"
		   });		
		addAnnotation
		  (documentationEClass, 
		   source, 
		   new String[] {
			 "name", "tDocumentation",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentation_TextFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "textFormat"
		   });		
		addAnnotation
		  (endEventEClass, 
		   source, 
		   new String[] {
			 "name", "tEndEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (endPointEClass, 
		   source, 
		   new String[] {
			 "name", "tEndPoint",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (errorEClass, 
		   source, 
		   new String[] {
			 "name", "tError",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getError_ErrorCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "errorCode"
		   });		
		addAnnotation
		  (getError_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getError_StructureRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "structureRef"
		   });		
		addAnnotation
		  (errorEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tErrorEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getErrorEventDefinition_ErrorRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "errorRef"
		   });		
		addAnnotation
		  (escalationEClass, 
		   source, 
		   new String[] {
			 "name", "tEscalation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEscalation_EscalationCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "escalationCode"
		   });		
		addAnnotation
		  (getEscalation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getEscalation_StructureRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "structureRef"
		   });		
		addAnnotation
		  (escalationEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tEscalationEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEscalationEventDefinition_EscalationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "escalationRef"
		   });		
		addAnnotation
		  (eventEClass, 
		   source, 
		   new String[] {
			 "name", "tEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEvent_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (eventBasedGatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tEventBasedGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEventBasedGateway_EventGatewayType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "eventGatewayType"
		   });		
		addAnnotation
		  (getEventBasedGateway_Instantiate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "instantiate"
		   });		
		addAnnotation
		  (eventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tEventDefinition",
			 "kind", "elementOnly",
			 "abstract", "true"
		   });		
		addAnnotation
		  (exclusiveGatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tExclusiveGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExclusiveGateway_Default(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default"
		   });		
		addAnnotation
		  (expressionEClass, 
		   source, 
		   new String[] {
			 "name", "tExpression",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (extensionEClass, 
		   source, 
		   new String[] {
			 "name", "tExtension",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExtension_Definition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "definition"
		   });		
		addAnnotation
		  (getExtension_MustUnderstand(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mustUnderstand"
		   });		
		addAnnotation
		  (flowElementEClass, 
		   source, 
		   new String[] {
			 "name", "tFlowElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFlowElement_Auditing(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "auditing",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getFlowElement_Monitoring(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "monitoring",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getFlowElement_CategoryValueRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "categoryValueRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getFlowElement_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getFlowElementsContainer_LaneSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "laneSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getFlowElementsContainer_FlowElements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flowElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#flowElement"
		   });		
		addAnnotation
		  (flowNodeEClass, 
		   source, 
		   new String[] {
			 "name", "tFlowNode",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFlowNode_Incoming(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "incoming",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getFlowNode_Outgoing(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outgoing",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (formalExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "tFormalExpression",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getFormalExpression_EvaluatesToTypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "evaluatesToTypeRef"
		   });		
		addAnnotation
		  (getFormalExpression_Language(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "language"
		   });		
		addAnnotation
		  (gatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGateway_GatewayDirection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "gatewayDirection"
		   });		
		addAnnotation
		  (globalBusinessRuleTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalBusinessRuleTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGlobalBusinessRuleTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (globalChoreographyTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalChoreographyTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGlobalChoreographyTask_InitiatingParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "initiatingParticipantRef"
		   });		
		addAnnotation
		  (globalConversationEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalConversation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (globalManualTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalManualTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (globalScriptTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalScriptTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGlobalScriptTask_Script(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "script",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getGlobalScriptTask_ScriptLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "scriptLanguage"
		   });		
		addAnnotation
		  (globalTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGlobalTask_Resources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceRole",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#resourceRole"
		   });		
		addAnnotation
		  (globalUserTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tGlobalUserTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGlobalUserTask_Renderings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rendering",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getGlobalUserTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (groupEClass, 
		   source, 
		   new String[] {
			 "name", "tGroup",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGroup_CategoryValueRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "categoryValueRef"
		   });		
		addAnnotation
		  (humanPerformerEClass, 
		   source, 
		   new String[] {
			 "name", "tHumanPerformer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (implicitThrowEventEClass, 
		   source, 
		   new String[] {
			 "name", "tImplicitThrowEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (importEClass, 
		   source, 
		   new String[] {
			 "name", "tImport",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getImport_ImportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importType"
		   });		
		addAnnotation
		  (getImport_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getImport_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });		
		addAnnotation
		  (inclusiveGatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tInclusiveGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInclusiveGateway_Default(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default"
		   });		
		addAnnotation
		  (inputOutputBindingEClass, 
		   source, 
		   new String[] {
			 "name", "tInputOutputBinding",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInputOutputBinding_InputDataRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "inputDataRef"
		   });		
		addAnnotation
		  (getInputOutputBinding_OperationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationRef"
		   });		
		addAnnotation
		  (getInputOutputBinding_OutputDataRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "outputDataRef"
		   });		
		addAnnotation
		  (inputOutputSpecificationEClass, 
		   source, 
		   new String[] {
			 "name", "tInputOutputSpecification",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInputOutputSpecification_DataInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputOutputSpecification_DataOutputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputOutputSpecification_InputSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputOutputSpecification_OutputSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (inputSetEClass, 
		   source, 
		   new String[] {
			 "name", "tInputSet",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInputSet_DataInputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputSet_OptionalInputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "optionalInputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputSet_WhileExecutingInputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "whileExecutingInputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputSet_OutputSetRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outputSetRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInputSet_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (interfaceEClass, 
		   source, 
		   new String[] {
			 "name", "tInterface",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInterface_Operations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getInterface_ImplementationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementationRef"
		   });		
		addAnnotation
		  (getInterface_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (intermediateCatchEventEClass, 
		   source, 
		   new String[] {
			 "name", "tIntermediateCatchEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (intermediateThrowEventEClass, 
		   source, 
		   new String[] {
			 "name", "tIntermediateThrowEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getItemAwareElement_DataState(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataState",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getItemAwareElement_ItemSubjectRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "itemSubjectRef"
		   });		
		addAnnotation
		  (itemDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tItemDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getItemDefinition_IsCollection(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isCollection"
		   });		
		addAnnotation
		  (getItemDefinition_ItemKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "itemKind"
		   });		
		addAnnotation
		  (getItemDefinition_StructureRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "structureRef"
		   });		
		addAnnotation
		  (laneEClass, 
		   source, 
		   new String[] {
			 "name", "tLane",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLane_PartitionElement(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partitionElement",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLane_FlowNodeRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flowNodeRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLane_ChildLaneSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "childLaneSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLane_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getLane_PartitionElementRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partitionElementRef"
		   });		
		addAnnotation
		  (laneSetEClass, 
		   source, 
		   new String[] {
			 "name", "tLaneSet",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLaneSet_Lanes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "lane",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLaneSet_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (linkEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tLinkEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLinkEventDefinition_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLinkEventDefinition_Target(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "target",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getLinkEventDefinition_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (loopCharacteristicsEClass, 
		   source, 
		   new String[] {
			 "name", "tLoopCharacteristics",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (manualTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tManualTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (messageEClass, 
		   source, 
		   new String[] {
			 "name", "tMessage",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMessage_ItemRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "itemRef"
		   });		
		addAnnotation
		  (getMessage_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (messageEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tMessageEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMessageEventDefinition_OperationRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operationRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getMessageEventDefinition_MessageRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageRef"
		   });		
		addAnnotation
		  (messageFlowEClass, 
		   source, 
		   new String[] {
			 "name", "tMessageFlow",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMessageFlow_MessageRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageRef"
		   });		
		addAnnotation
		  (getMessageFlow_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getMessageFlow_SourceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceRef"
		   });		
		addAnnotation
		  (getMessageFlow_TargetRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetRef"
		   });		
		addAnnotation
		  (messageFlowAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tMessageFlowAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMessageFlowAssociation_InnerMessageFlowRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "innerMessageFlowRef"
		   });		
		addAnnotation
		  (getMessageFlowAssociation_OuterMessageFlowRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "outerMessageFlowRef"
		   });		
		addAnnotation
		  (monitoringEClass, 
		   source, 
		   new String[] {
			 "name", "tMonitoring",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (multiInstanceLoopCharacteristicsEClass, 
		   source, 
		   new String[] {
			 "name", "tMultiInstanceLoopCharacteristics",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_LoopDataInputRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "loopDataInputRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_LoopDataOutputRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "loopDataOutputRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_OutputDataItem(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outputDataItem",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "complexBehaviorDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_Behavior(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "behavior"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_IsSequential(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isSequential"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "noneBehaviorEventRef"
		   });		
		addAnnotation
		  (getMultiInstanceLoopCharacteristics_OneBehaviorEventRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "oneBehaviorEventRef"
		   });		
		addAnnotation
		  (operationEClass, 
		   source, 
		   new String[] {
			 "name", "tOperation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOperation_InMessageRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inMessageRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOperation_OutMessageRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outMessageRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOperation_ErrorRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "errorRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOperation_ImplementationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementationRef"
		   });		
		addAnnotation
		  (getOperation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (outputSetEClass, 
		   source, 
		   new String[] {
			 "name", "tOutputSet",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOutputSet_DataOutputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataOutputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOutputSet_OptionalOutputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "optionalOutputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOutputSet_WhileExecutingOutputRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "whileExecutingOutputRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOutputSet_InputSetRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inputSetRefs",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getOutputSet_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (parallelGatewayEClass, 
		   source, 
		   new String[] {
			 "name", "tParallelGateway",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (participantEClass, 
		   source, 
		   new String[] {
			 "name", "tParticipant",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getParticipant_InterfaceRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interfaceRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getParticipant_EndPointRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "endPointRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getParticipant_ParticipantMultiplicity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantMultiplicity",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getParticipant_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getParticipant_ProcessRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "processRef"
		   });		
		addAnnotation
		  (participantAssociationEClass, 
		   source, 
		   new String[] {
			 "name", "tParticipantAssociation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getParticipantAssociation_InnerParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "innerParticipantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getParticipantAssociation_OuterParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outerParticipantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (participantMultiplicityEClass, 
		   source, 
		   new String[] {
			 "name", "tParticipantMultiplicity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getParticipantMultiplicity_Maximum(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "maximum"
		   });		
		addAnnotation
		  (getParticipantMultiplicity_Minimum(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minimum"
		   });		
		addAnnotation
		  (partnerEntityEClass, 
		   source, 
		   new String[] {
			 "name", "tPartnerEntity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPartnerEntity_ParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getPartnerEntity_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (partnerRoleEClass, 
		   source, 
		   new String[] {
			 "name", "tPartnerRole",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPartnerRole_ParticipantRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participantRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getPartnerRole_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (performerEClass, 
		   source, 
		   new String[] {
			 "name", "tPerformer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (potentialOwnerEClass, 
		   source, 
		   new String[] {
			 "name", "tPotentialOwner",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (processEClass, 
		   source, 
		   new String[] {
			 "name", "tProcess",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProcess_Auditing(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "auditing",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getProcess_Monitoring(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "monitoring",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getProcess_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getProcess_Artifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "artifact",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getProcess_Resources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceRole",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#resourceRole"
		   });		
		addAnnotation
		  (getProcess_CorrelationSubscriptions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationSubscription",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getProcess_Supports(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "supports",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getProcess_DefinitionalCollaborationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "definitionalCollaborationRef"
		   });		
		addAnnotation
		  (getProcess_IsClosed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isClosed"
		   });		
		addAnnotation
		  (getProcess_IsExecutable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isExecutable"
		   });		
		addAnnotation
		  (getProcess_ProcessType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "processType"
		   });		
		addAnnotation
		  (propertyEClass, 
		   source, 
		   new String[] {
			 "name", "tProperty",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProperty_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (receiveTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tReceiveTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getReceiveTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (getReceiveTask_Instantiate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "instantiate"
		   });		
		addAnnotation
		  (getReceiveTask_MessageRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageRef"
		   });		
		addAnnotation
		  (getReceiveTask_OperationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationRef"
		   });		
		addAnnotation
		  (relationshipEClass, 
		   source, 
		   new String[] {
			 "name", "tRelationship",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRelationship_Sources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getRelationship_Targets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "target",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getRelationship_Direction(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "direction"
		   });		
		addAnnotation
		  (getRelationship_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (renderingEClass, 
		   source, 
		   new String[] {
			 "name", "tRendering",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (resourceEClass, 
		   source, 
		   new String[] {
			 "name", "tResource",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResource_ResourceParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceParameter",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getResource_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (resourceAssignmentExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "tResourceAssignmentExpression",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResourceAssignmentExpression_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#expression"
		   });		
		addAnnotation
		  (resourceParameterEClass, 
		   source, 
		   new String[] {
			 "name", "tResourceParameter",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResourceParameter_IsRequired(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isRequired"
		   });		
		addAnnotation
		  (getResourceParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getResourceParameter_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (resourceParameterBindingEClass, 
		   source, 
		   new String[] {
			 "name", "tResourceParameterBinding",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResourceParameterBinding_Expression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "expression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#expression"
		   });		
		addAnnotation
		  (getResourceParameterBinding_ParameterRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parameterRef"
		   });		
		addAnnotation
		  (resourceRoleEClass, 
		   source, 
		   new String[] {
			 "name", "tResourceRole",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getResourceRole_ResourceRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getResourceRole_ResourceParameterBindings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceParameterBinding",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getResourceRole_ResourceAssignmentExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resourceAssignmentExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getResourceRole_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (rootElementEClass, 
		   source, 
		   new String[] {
			 "name", "tRootElement",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (scriptTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tScriptTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getScriptTask_Script(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "script",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getScriptTask_ScriptFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "scriptFormat"
		   });		
		addAnnotation
		  (sendTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tSendTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSendTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (getSendTask_MessageRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageRef"
		   });		
		addAnnotation
		  (getSendTask_OperationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationRef"
		   });		
		addAnnotation
		  (sequenceFlowEClass, 
		   source, 
		   new String[] {
			 "name", "tSequenceFlow",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSequenceFlow_ConditionExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conditionExpression",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getSequenceFlow_IsImmediate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isImmediate"
		   });		
		addAnnotation
		  (getSequenceFlow_SourceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceRef"
		   });		
		addAnnotation
		  (getSequenceFlow_TargetRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetRef"
		   });		
		addAnnotation
		  (serviceTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tServiceTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getServiceTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });		
		addAnnotation
		  (getServiceTask_OperationRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operationRef"
		   });		
		addAnnotation
		  (signalEClass, 
		   source, 
		   new String[] {
			 "name", "tSignal",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSignal_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getSignal_StructureRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "structureRef"
		   });		
		addAnnotation
		  (signalEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tSignalEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSignalEventDefinition_SignalRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "signalRef"
		   });		
		addAnnotation
		  (standardLoopCharacteristicsEClass, 
		   source, 
		   new String[] {
			 "name", "tStandardLoopCharacteristics",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStandardLoopCharacteristics_LoopCondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "loopCondition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getStandardLoopCharacteristics_LoopMaximum(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "loopMaximum"
		   });		
		addAnnotation
		  (getStandardLoopCharacteristics_TestBefore(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "testBefore"
		   });		
		addAnnotation
		  (startEventEClass, 
		   source, 
		   new String[] {
			 "name", "tStartEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getStartEvent_IsInterrupting(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "isInterrupting"
		   });		
		addAnnotation
		  (subChoreographyEClass, 
		   source, 
		   new String[] {
			 "name", "tSubChoreography",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSubChoreography_Artifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "artifact",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (subConversationEClass, 
		   source, 
		   new String[] {
			 "name", "tSubConversation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSubConversation_ConversationNodes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "conversationNode",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#conversationNode"
		   });		
		addAnnotation
		  (subProcessEClass, 
		   source, 
		   new String[] {
			 "name", "tSubProcess",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSubProcess_Artifacts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "artifact",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#artifact"
		   });		
		addAnnotation
		  (getSubProcess_TriggeredByEvent(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "triggeredByEvent"
		   });		
		addAnnotation
		  (taskEClass, 
		   source, 
		   new String[] {
			 "name", "tTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (terminateEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tTerminateEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (textAnnotationEClass, 
		   source, 
		   new String[] {
			 "name", "tTextAnnotation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTextAnnotation_Text(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "text",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getTextAnnotation_TextFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "textFormat"
		   });		
		addAnnotation
		  (throwEventEClass, 
		   source, 
		   new String[] {
			 "name", "tThrowEvent",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getThrowEvent_DataInputs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInput",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getThrowEvent_DataInputAssociation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dataInputAssociation",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getThrowEvent_InputSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "inputSet",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getThrowEvent_EventDefinitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventDefinition",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL",
			 "group", "http://www.omg.org/spec/BPMN/20100524/MODEL#eventDefinition"
		   });		
		addAnnotation
		  (getThrowEvent_EventDefinitionRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventDefinitionRef",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (timerEventDefinitionEClass, 
		   source, 
		   new String[] {
			 "name", "tTimerEventDefinition",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTimerEventDefinition_TimeDate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "timeDate",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getTimerEventDefinition_TimeDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "timeDuration",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getTimerEventDefinition_TimeCycle(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "timeCycle",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (transactionEClass, 
		   source, 
		   new String[] {
			 "name", "tTransaction",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTransaction_Method(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "method"
		   });		
		addAnnotation
		  (userTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tUserTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getUserTask_Renderings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rendering",
			 "namespace", "http://www.omg.org/spec/BPMN/20100524/MODEL"
		   });		
		addAnnotation
		  (getUserTask_Implementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "implementation"
		   });
	}

} //Bpmn2PackageImpl
