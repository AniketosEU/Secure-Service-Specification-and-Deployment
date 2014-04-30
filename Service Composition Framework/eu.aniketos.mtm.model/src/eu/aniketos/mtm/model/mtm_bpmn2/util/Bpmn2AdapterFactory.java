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
package eu.aniketos.mtm.model.mtm_bpmn2.util;

import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Activity;
import eu.aniketos.mtm.model.mtm_bpmn2.AdHocSubProcess;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoMailTask;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptBase;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptTask;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoStartEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoUserTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Artifact;
import eu.aniketos.mtm.model.mtm_bpmn2.Assignment;
import eu.aniketos.mtm.model.mtm_bpmn2.Association;
import eu.aniketos.mtm.model.mtm_bpmn2.Auditing;
import eu.aniketos.mtm.model.mtm_bpmn2.BaseElement;
import eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent;
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
import eu.aniketos.mtm.model.mtm_bpmn2.Property;
import eu.aniketos.mtm.model.mtm_bpmn2.ReceiveTask;
import eu.aniketos.mtm.model.mtm_bpmn2.Relationship;
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package
 * @generated
 */
public class Bpmn2AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Bpmn2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bpmn2AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Bpmn2Package.eINSTANCE;
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
	protected Bpmn2Switch<Adapter> modelSwitch =
		new Bpmn2Switch<Adapter>() {
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@Override
			public Adapter caseAdHocSubProcess(AdHocSubProcess object) {
				return createAdHocSubProcessAdapter();
			}
			@Override
			public Adapter caseArtifact(Artifact object) {
				return createArtifactAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object) {
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseAuditing(Auditing object) {
				return createAuditingAdapter();
			}
			@Override
			public Adapter caseBaseElement(BaseElement object) {
				return createBaseElementAdapter();
			}
			@Override
			public Adapter caseBoundaryEvent(BoundaryEvent object) {
				return createBoundaryEventAdapter();
			}
			@Override
			public Adapter caseBusinessRuleTask(BusinessRuleTask object) {
				return createBusinessRuleTaskAdapter();
			}
			@Override
			public Adapter caseCallActivity(CallActivity object) {
				return createCallActivityAdapter();
			}
			@Override
			public Adapter caseCallChoreography(CallChoreography object) {
				return createCallChoreographyAdapter();
			}
			@Override
			public Adapter caseCallConversation(CallConversation object) {
				return createCallConversationAdapter();
			}
			@Override
			public Adapter caseCallableElement(CallableElement object) {
				return createCallableElementAdapter();
			}
			@Override
			public Adapter caseCancelEventDefinition(CancelEventDefinition object) {
				return createCancelEventDefinitionAdapter();
			}
			@Override
			public Adapter caseCatchEvent(CatchEvent object) {
				return createCatchEventAdapter();
			}
			@Override
			public Adapter caseCategory(Category object) {
				return createCategoryAdapter();
			}
			@Override
			public Adapter caseCategoryValue(CategoryValue object) {
				return createCategoryValueAdapter();
			}
			@Override
			public Adapter caseChoreography(Choreography object) {
				return createChoreographyAdapter();
			}
			@Override
			public Adapter caseChoreographyActivity(ChoreographyActivity object) {
				return createChoreographyActivityAdapter();
			}
			@Override
			public Adapter caseChoreographyTask(ChoreographyTask object) {
				return createChoreographyTaskAdapter();
			}
			@Override
			public Adapter caseCollaboration(Collaboration object) {
				return createCollaborationAdapter();
			}
			@Override
			public Adapter caseCompensateEventDefinition(CompensateEventDefinition object) {
				return createCompensateEventDefinitionAdapter();
			}
			@Override
			public Adapter caseComplexBehaviorDefinition(ComplexBehaviorDefinition object) {
				return createComplexBehaviorDefinitionAdapter();
			}
			@Override
			public Adapter caseComplexGateway(ComplexGateway object) {
				return createComplexGatewayAdapter();
			}
			@Override
			public Adapter caseConditionalEventDefinition(ConditionalEventDefinition object) {
				return createConditionalEventDefinitionAdapter();
			}
			@Override
			public Adapter caseConversation(Conversation object) {
				return createConversationAdapter();
			}
			@Override
			public Adapter caseConversationAssociation(ConversationAssociation object) {
				return createConversationAssociationAdapter();
			}
			@Override
			public Adapter caseConversationLink(ConversationLink object) {
				return createConversationLinkAdapter();
			}
			@Override
			public Adapter caseConversationNode(ConversationNode object) {
				return createConversationNodeAdapter();
			}
			@Override
			public Adapter caseCorrelationKey(CorrelationKey object) {
				return createCorrelationKeyAdapter();
			}
			@Override
			public Adapter caseCorrelationProperty(CorrelationProperty object) {
				return createCorrelationPropertyAdapter();
			}
			@Override
			public Adapter caseCorrelationPropertyBinding(CorrelationPropertyBinding object) {
				return createCorrelationPropertyBindingAdapter();
			}
			@Override
			public Adapter caseCorrelationPropertyRetrievalExpression(CorrelationPropertyRetrievalExpression object) {
				return createCorrelationPropertyRetrievalExpressionAdapter();
			}
			@Override
			public Adapter caseCorrelationSubscription(CorrelationSubscription object) {
				return createCorrelationSubscriptionAdapter();
			}
			@Override
			public Adapter caseDataAssociation(DataAssociation object) {
				return createDataAssociationAdapter();
			}
			@Override
			public Adapter caseDataInput(DataInput object) {
				return createDataInputAdapter();
			}
			@Override
			public Adapter caseDataInputAssociation(DataInputAssociation object) {
				return createDataInputAssociationAdapter();
			}
			@Override
			public Adapter caseDataObject(DataObject object) {
				return createDataObjectAdapter();
			}
			@Override
			public Adapter caseDataObjectReference(DataObjectReference object) {
				return createDataObjectReferenceAdapter();
			}
			@Override
			public Adapter caseDataOutput(DataOutput object) {
				return createDataOutputAdapter();
			}
			@Override
			public Adapter caseDataOutputAssociation(DataOutputAssociation object) {
				return createDataOutputAssociationAdapter();
			}
			@Override
			public Adapter caseDataState(DataState object) {
				return createDataStateAdapter();
			}
			@Override
			public Adapter caseDataStore(DataStore object) {
				return createDataStoreAdapter();
			}
			@Override
			public Adapter caseDataStoreReference(DataStoreReference object) {
				return createDataStoreReferenceAdapter();
			}
			@Override
			public Adapter caseDefinitions(Definitions object) {
				return createDefinitionsAdapter();
			}
			@Override
			public Adapter caseDocumentation(Documentation object) {
				return createDocumentationAdapter();
			}
			@Override
			public Adapter caseEndEvent(EndEvent object) {
				return createEndEventAdapter();
			}
			@Override
			public Adapter caseEndPoint(EndPoint object) {
				return createEndPointAdapter();
			}
			@Override
			public Adapter caseError(eu.aniketos.mtm.model.mtm_bpmn2.Error object) {
				return createErrorAdapter();
			}
			@Override
			public Adapter caseErrorEventDefinition(ErrorEventDefinition object) {
				return createErrorEventDefinitionAdapter();
			}
			@Override
			public Adapter caseEscalation(Escalation object) {
				return createEscalationAdapter();
			}
			@Override
			public Adapter caseEscalationEventDefinition(EscalationEventDefinition object) {
				return createEscalationEventDefinitionAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseEventBasedGateway(EventBasedGateway object) {
				return createEventBasedGatewayAdapter();
			}
			@Override
			public Adapter caseEventDefinition(EventDefinition object) {
				return createEventDefinitionAdapter();
			}
			@Override
			public Adapter caseExclusiveGateway(ExclusiveGateway object) {
				return createExclusiveGatewayAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseExtension(Extension object) {
				return createExtensionAdapter();
			}
			@Override
			public Adapter caseExtensionAttributeDefinition(ExtensionAttributeDefinition object) {
				return createExtensionAttributeDefinitionAdapter();
			}
			@Override
			public Adapter caseExtensionAttributeValue(ExtensionAttributeValue object) {
				return createExtensionAttributeValueAdapter();
			}
			@Override
			public Adapter caseExtensionDefinition(ExtensionDefinition object) {
				return createExtensionDefinitionAdapter();
			}
			@Override
			public Adapter caseFlowElement(FlowElement object) {
				return createFlowElementAdapter();
			}
			@Override
			public Adapter caseFlowElementsContainer(FlowElementsContainer object) {
				return createFlowElementsContainerAdapter();
			}
			@Override
			public Adapter caseFlowNode(FlowNode object) {
				return createFlowNodeAdapter();
			}
			@Override
			public Adapter caseFormalExpression(FormalExpression object) {
				return createFormalExpressionAdapter();
			}
			@Override
			public Adapter caseGateway(Gateway object) {
				return createGatewayAdapter();
			}
			@Override
			public Adapter caseGlobalBusinessRuleTask(GlobalBusinessRuleTask object) {
				return createGlobalBusinessRuleTaskAdapter();
			}
			@Override
			public Adapter caseGlobalChoreographyTask(GlobalChoreographyTask object) {
				return createGlobalChoreographyTaskAdapter();
			}
			@Override
			public Adapter caseGlobalConversation(GlobalConversation object) {
				return createGlobalConversationAdapter();
			}
			@Override
			public Adapter caseGlobalManualTask(GlobalManualTask object) {
				return createGlobalManualTaskAdapter();
			}
			@Override
			public Adapter caseGlobalScriptTask(GlobalScriptTask object) {
				return createGlobalScriptTaskAdapter();
			}
			@Override
			public Adapter caseGlobalTask(GlobalTask object) {
				return createGlobalTaskAdapter();
			}
			@Override
			public Adapter caseGlobalUserTask(GlobalUserTask object) {
				return createGlobalUserTaskAdapter();
			}
			@Override
			public Adapter caseGroup(Group object) {
				return createGroupAdapter();
			}
			@Override
			public Adapter caseHumanPerformer(HumanPerformer object) {
				return createHumanPerformerAdapter();
			}
			@Override
			public Adapter caseImplicitThrowEvent(ImplicitThrowEvent object) {
				return createImplicitThrowEventAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseInclusiveGateway(InclusiveGateway object) {
				return createInclusiveGatewayAdapter();
			}
			@Override
			public Adapter caseInputOutputBinding(InputOutputBinding object) {
				return createInputOutputBindingAdapter();
			}
			@Override
			public Adapter caseInputOutputSpecification(InputOutputSpecification object) {
				return createInputOutputSpecificationAdapter();
			}
			@Override
			public Adapter caseInputSet(InputSet object) {
				return createInputSetAdapter();
			}
			@Override
			public Adapter caseInteractionNode(InteractionNode object) {
				return createInteractionNodeAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
			}
			@Override
			public Adapter caseIntermediateCatchEvent(IntermediateCatchEvent object) {
				return createIntermediateCatchEventAdapter();
			}
			@Override
			public Adapter caseIntermediateThrowEvent(IntermediateThrowEvent object) {
				return createIntermediateThrowEventAdapter();
			}
			@Override
			public Adapter caseItemAwareElement(ItemAwareElement object) {
				return createItemAwareElementAdapter();
			}
			@Override
			public Adapter caseItemDefinition(ItemDefinition object) {
				return createItemDefinitionAdapter();
			}
			@Override
			public Adapter caseLane(Lane object) {
				return createLaneAdapter();
			}
			@Override
			public Adapter caseLaneSet(LaneSet object) {
				return createLaneSetAdapter();
			}
			@Override
			public Adapter caseLinkEventDefinition(LinkEventDefinition object) {
				return createLinkEventDefinitionAdapter();
			}
			@Override
			public Adapter caseLoopCharacteristics(LoopCharacteristics object) {
				return createLoopCharacteristicsAdapter();
			}
			@Override
			public Adapter caseManualTask(ManualTask object) {
				return createManualTaskAdapter();
			}
			@Override
			public Adapter caseMessage(Message object) {
				return createMessageAdapter();
			}
			@Override
			public Adapter caseMessageEventDefinition(MessageEventDefinition object) {
				return createMessageEventDefinitionAdapter();
			}
			@Override
			public Adapter caseMessageFlow(MessageFlow object) {
				return createMessageFlowAdapter();
			}
			@Override
			public Adapter caseMessageFlowAssociation(MessageFlowAssociation object) {
				return createMessageFlowAssociationAdapter();
			}
			@Override
			public Adapter caseMonitoring(Monitoring object) {
				return createMonitoringAdapter();
			}
			@Override
			public Adapter caseMultiInstanceLoopCharacteristics(MultiInstanceLoopCharacteristics object) {
				return createMultiInstanceLoopCharacteristicsAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseOutputSet(OutputSet object) {
				return createOutputSetAdapter();
			}
			@Override
			public Adapter caseParallelGateway(ParallelGateway object) {
				return createParallelGatewayAdapter();
			}
			@Override
			public Adapter caseParticipant(Participant object) {
				return createParticipantAdapter();
			}
			@Override
			public Adapter caseParticipantAssociation(ParticipantAssociation object) {
				return createParticipantAssociationAdapter();
			}
			@Override
			public Adapter caseParticipantMultiplicity(ParticipantMultiplicity object) {
				return createParticipantMultiplicityAdapter();
			}
			@Override
			public Adapter casePartnerEntity(PartnerEntity object) {
				return createPartnerEntityAdapter();
			}
			@Override
			public Adapter casePartnerRole(PartnerRole object) {
				return createPartnerRoleAdapter();
			}
			@Override
			public Adapter casePerformer(Performer object) {
				return createPerformerAdapter();
			}
			@Override
			public Adapter casePotentialOwner(PotentialOwner object) {
				return createPotentialOwnerAdapter();
			}
			@Override
			public Adapter caseProcess(eu.aniketos.mtm.model.mtm_bpmn2.Process object) {
				return createProcessAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseReceiveTask(ReceiveTask object) {
				return createReceiveTaskAdapter();
			}
			@Override
			public Adapter caseRelationship(Relationship object) {
				return createRelationshipAdapter();
			}
			@Override
			public Adapter caseRendering(Rendering object) {
				return createRenderingAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseResourceAssignmentExpression(ResourceAssignmentExpression object) {
				return createResourceAssignmentExpressionAdapter();
			}
			@Override
			public Adapter caseResourceParameter(ResourceParameter object) {
				return createResourceParameterAdapter();
			}
			@Override
			public Adapter caseResourceParameterBinding(ResourceParameterBinding object) {
				return createResourceParameterBindingAdapter();
			}
			@Override
			public Adapter caseResourceRole(ResourceRole object) {
				return createResourceRoleAdapter();
			}
			@Override
			public Adapter caseRootElement(RootElement object) {
				return createRootElementAdapter();
			}
			@Override
			public Adapter caseScriptTask(ScriptTask object) {
				return createScriptTaskAdapter();
			}
			@Override
			public Adapter caseSendTask(SendTask object) {
				return createSendTaskAdapter();
			}
			@Override
			public Adapter caseSequenceFlow(SequenceFlow object) {
				return createSequenceFlowAdapter();
			}
			@Override
			public Adapter caseServiceTask(ServiceTask object) {
				return createServiceTaskAdapter();
			}
			@Override
			public Adapter caseSignal(Signal object) {
				return createSignalAdapter();
			}
			@Override
			public Adapter caseSignalEventDefinition(SignalEventDefinition object) {
				return createSignalEventDefinitionAdapter();
			}
			@Override
			public Adapter caseStandardLoopCharacteristics(StandardLoopCharacteristics object) {
				return createStandardLoopCharacteristicsAdapter();
			}
			@Override
			public Adapter caseStartEvent(StartEvent object) {
				return createStartEventAdapter();
			}
			@Override
			public Adapter caseSubChoreography(SubChoreography object) {
				return createSubChoreographyAdapter();
			}
			@Override
			public Adapter caseSubConversation(SubConversation object) {
				return createSubConversationAdapter();
			}
			@Override
			public Adapter caseSubProcess(SubProcess object) {
				return createSubProcessAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseTerminateEventDefinition(TerminateEventDefinition object) {
				return createTerminateEventDefinitionAdapter();
			}
			@Override
			public Adapter caseTextAnnotation(TextAnnotation object) {
				return createTextAnnotationAdapter();
			}
			@Override
			public Adapter caseThrowEvent(ThrowEvent object) {
				return createThrowEventAdapter();
			}
			@Override
			public Adapter caseTimerEventDefinition(TimerEventDefinition object) {
				return createTimerEventDefinitionAdapter();
			}
			@Override
			public Adapter caseTransaction(Transaction object) {
				return createTransactionAdapter();
			}
			@Override
			public Adapter caseUserTask(UserTask object) {
				return createUserTaskAdapter();
			}
			@Override
			public Adapter caseCandidateUser(CandidateUser object) {
				return createCandidateUserAdapter();
			}
			@Override
			public Adapter caseCandidateGroup(CandidateGroup object) {
				return createCandidateGroupAdapter();
			}
			@Override
			public Adapter caseCustomProperty(CustomProperty object) {
				return createCustomPropertyAdapter();
			}
			@Override
			public Adapter caseMailTask(MailTask object) {
				return createMailTaskAdapter();
			}
			@Override
			public Adapter caseFieldExtension(FieldExtension object) {
				return createFieldExtensionAdapter();
			}
			@Override
			public Adapter caseComplexDataType(ComplexDataType object) {
				return createComplexDataTypeAdapter();
			}
			@Override
			public Adapter caseDataGrid(DataGrid object) {
				return createDataGridAdapter();
			}
			@Override
			public Adapter caseDataGridRow(DataGridRow object) {
				return createDataGridRowAdapter();
			}
			@Override
			public Adapter caseDataGridField(DataGridField object) {
				return createDataGridFieldAdapter();
			}
			@Override
			public Adapter caseActivitiListener(ActivitiListener object) {
				return createActivitiListenerAdapter();
			}
			@Override
			public Adapter caseFormProperty(FormProperty object) {
				return createFormPropertyAdapter();
			}
			@Override
			public Adapter caseIOParameter(IOParameter object) {
				return createIOParameterAdapter();
			}
			@Override
			public Adapter caseAlfrescoUserTask(AlfrescoUserTask object) {
				return createAlfrescoUserTaskAdapter();
			}
			@Override
			public Adapter caseAlfrescoStartEvent(AlfrescoStartEvent object) {
				return createAlfrescoStartEventAdapter();
			}
			@Override
			public Adapter caseAlfrescoScriptTask(AlfrescoScriptTask object) {
				return createAlfrescoScriptTaskAdapter();
			}
			@Override
			public Adapter caseAlfrescoScriptBase(AlfrescoScriptBase object) {
				return createAlfrescoScriptBaseAdapter();
			}
			@Override
			public Adapter caseAlfrescoMailTask(AlfrescoMailTask object) {
				return createAlfrescoMailTaskAdapter();
			}
			@Override
			public Adapter caseFormValue(FormValue object) {
				return createFormValueAdapter();
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
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AdHocSubProcess <em>Ad Hoc Sub Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AdHocSubProcess
	 * @generated
	 */
	public Adapter createAdHocSubProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Artifact
	 * @generated
	 */
	public Adapter createArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Auditing <em>Auditing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Auditing
	 * @generated
	 */
	public Adapter createAuditingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.BaseElement <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.BaseElement
	 * @generated
	 */
	public Adapter createBaseElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent <em>Boundary Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent
	 * @generated
	 */
	public Adapter createBoundaryEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.BusinessRuleTask <em>Business Rule Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.BusinessRuleTask
	 * @generated
	 */
	public Adapter createBusinessRuleTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity <em>Call Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CallActivity
	 * @generated
	 */
	public Adapter createCallActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallChoreography <em>Call Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CallChoreography
	 * @generated
	 */
	public Adapter createCallChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallConversation <em>Call Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CallConversation
	 * @generated
	 */
	public Adapter createCallConversationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallableElement <em>Callable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CallableElement
	 * @generated
	 */
	public Adapter createCallableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CancelEventDefinition <em>Cancel Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CancelEventDefinition
	 * @generated
	 */
	public Adapter createCancelEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent <em>Catch Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CatchEvent
	 * @generated
	 */
	public Adapter createCatchEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CategoryValue
	 * @generated
	 */
	public Adapter createCategoryValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Choreography <em>Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Choreography
	 * @generated
	 */
	public Adapter createChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyActivity <em>Choreography Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyActivity
	 * @generated
	 */
	public Adapter createChoreographyActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyTask <em>Choreography Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ChoreographyTask
	 * @generated
	 */
	public Adapter createChoreographyTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Collaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Collaboration
	 * @generated
	 */
	public Adapter createCollaborationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CompensateEventDefinition <em>Compensate Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CompensateEventDefinition
	 * @generated
	 */
	public Adapter createCompensateEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ComplexBehaviorDefinition <em>Complex Behavior Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ComplexBehaviorDefinition
	 * @generated
	 */
	public Adapter createComplexBehaviorDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ComplexGateway <em>Complex Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ComplexGateway
	 * @generated
	 */
	public Adapter createComplexGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ConditionalEventDefinition <em>Conditional Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ConditionalEventDefinition
	 * @generated
	 */
	public Adapter createConditionalEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Conversation <em>Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Conversation
	 * @generated
	 */
	public Adapter createConversationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationAssociation <em>Conversation Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ConversationAssociation
	 * @generated
	 */
	public Adapter createConversationAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationLink <em>Conversation Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ConversationLink
	 * @generated
	 */
	public Adapter createConversationLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode <em>Conversation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode
	 * @generated
	 */
	public Adapter createConversationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationKey <em>Correlation Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CorrelationKey
	 * @generated
	 */
	public Adapter createCorrelationKeyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationProperty <em>Correlation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CorrelationProperty
	 * @generated
	 */
	public Adapter createCorrelationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyBinding <em>Correlation Property Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyBinding
	 * @generated
	 */
	public Adapter createCorrelationPropertyBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyRetrievalExpression <em>Correlation Property Retrieval Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CorrelationPropertyRetrievalExpression
	 * @generated
	 */
	public Adapter createCorrelationPropertyRetrievalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CorrelationSubscription <em>Correlation Subscription</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CorrelationSubscription
	 * @generated
	 */
	public Adapter createCorrelationSubscriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataAssociation <em>Data Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataAssociation
	 * @generated
	 */
	public Adapter createDataAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataInput <em>Data Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataInput
	 * @generated
	 */
	public Adapter createDataInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataInputAssociation <em>Data Input Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataInputAssociation
	 * @generated
	 */
	public Adapter createDataInputAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataObject
	 * @generated
	 */
	public Adapter createDataObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataObjectReference <em>Data Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataObjectReference
	 * @generated
	 */
	public Adapter createDataObjectReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataOutput <em>Data Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataOutput
	 * @generated
	 */
	public Adapter createDataOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataOutputAssociation <em>Data Output Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataOutputAssociation
	 * @generated
	 */
	public Adapter createDataOutputAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataState
	 * @generated
	 */
	public Adapter createDataStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataStore <em>Data Store</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataStore
	 * @generated
	 */
	public Adapter createDataStoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataStoreReference <em>Data Store Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataStoreReference
	 * @generated
	 */
	public Adapter createDataStoreReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Definitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Definitions
	 * @generated
	 */
	public Adapter createDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Documentation
	 * @generated
	 */
	public Adapter createDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.EndEvent <em>End Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.EndEvent
	 * @generated
	 */
	public Adapter createEndEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.EndPoint
	 * @generated
	 */
	public Adapter createEndPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Error <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Error
	 * @generated
	 */
	public Adapter createErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ErrorEventDefinition <em>Error Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ErrorEventDefinition
	 * @generated
	 */
	public Adapter createErrorEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Escalation <em>Escalation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Escalation
	 * @generated
	 */
	public Adapter createEscalationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.EscalationEventDefinition <em>Escalation Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.EscalationEventDefinition
	 * @generated
	 */
	public Adapter createEscalationEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.EventBasedGateway <em>Event Based Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.EventBasedGateway
	 * @generated
	 */
	public Adapter createEventBasedGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition <em>Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition
	 * @generated
	 */
	public Adapter createEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ExclusiveGateway <em>Exclusive Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ExclusiveGateway
	 * @generated
	 */
	public Adapter createExclusiveGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeDefinition <em>Extension Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeDefinition
	 * @generated
	 */
	public Adapter createExtensionAttributeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeValue <em>Extension Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ExtensionAttributeValue
	 * @generated
	 */
	public Adapter createExtensionAttributeValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ExtensionDefinition <em>Extension Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ExtensionDefinition
	 * @generated
	 */
	public Adapter createExtensionDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FlowElement <em>Flow Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FlowElement
	 * @generated
	 */
	public Adapter createFlowElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FlowElementsContainer <em>Flow Elements Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FlowElementsContainer
	 * @generated
	 */
	public Adapter createFlowElementsContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FlowNode <em>Flow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FlowNode
	 * @generated
	 */
	public Adapter createFlowNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FormalExpression <em>Formal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FormalExpression
	 * @generated
	 */
	public Adapter createFormalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Gateway
	 * @generated
	 */
	public Adapter createGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalBusinessRuleTask <em>Global Business Rule Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalBusinessRuleTask
	 * @generated
	 */
	public Adapter createGlobalBusinessRuleTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalChoreographyTask <em>Global Choreography Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalChoreographyTask
	 * @generated
	 */
	public Adapter createGlobalChoreographyTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalConversation <em>Global Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalConversation
	 * @generated
	 */
	public Adapter createGlobalConversationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalManualTask <em>Global Manual Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalManualTask
	 * @generated
	 */
	public Adapter createGlobalManualTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalScriptTask <em>Global Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalScriptTask
	 * @generated
	 */
	public Adapter createGlobalScriptTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalTask <em>Global Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalTask
	 * @generated
	 */
	public Adapter createGlobalTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.GlobalUserTask <em>Global User Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.GlobalUserTask
	 * @generated
	 */
	public Adapter createGlobalUserTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Group
	 * @generated
	 */
	public Adapter createGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.HumanPerformer <em>Human Performer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.HumanPerformer
	 * @generated
	 */
	public Adapter createHumanPerformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ImplicitThrowEvent <em>Implicit Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ImplicitThrowEvent
	 * @generated
	 */
	public Adapter createImplicitThrowEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.InclusiveGateway <em>Inclusive Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.InclusiveGateway
	 * @generated
	 */
	public Adapter createInclusiveGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.InputOutputBinding <em>Input Output Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.InputOutputBinding
	 * @generated
	 */
	public Adapter createInputOutputBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.InputOutputSpecification <em>Input Output Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.InputOutputSpecification
	 * @generated
	 */
	public Adapter createInputOutputSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.InputSet <em>Input Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.InputSet
	 * @generated
	 */
	public Adapter createInputSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.InteractionNode <em>Interaction Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.InteractionNode
	 * @generated
	 */
	public Adapter createInteractionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.IntermediateCatchEvent <em>Intermediate Catch Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.IntermediateCatchEvent
	 * @generated
	 */
	public Adapter createIntermediateCatchEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.IntermediateThrowEvent <em>Intermediate Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.IntermediateThrowEvent
	 * @generated
	 */
	public Adapter createIntermediateThrowEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ItemAwareElement <em>Item Aware Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ItemAwareElement
	 * @generated
	 */
	public Adapter createItemAwareElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ItemDefinition <em>Item Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ItemDefinition
	 * @generated
	 */
	public Adapter createItemDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Lane
	 * @generated
	 */
	public Adapter createLaneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.LaneSet <em>Lane Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.LaneSet
	 * @generated
	 */
	public Adapter createLaneSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.LinkEventDefinition <em>Link Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.LinkEventDefinition
	 * @generated
	 */
	public Adapter createLinkEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.LoopCharacteristics <em>Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.LoopCharacteristics
	 * @generated
	 */
	public Adapter createLoopCharacteristicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ManualTask <em>Manual Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ManualTask
	 * @generated
	 */
	public Adapter createManualTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Message
	 * @generated
	 */
	public Adapter createMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.MessageEventDefinition <em>Message Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MessageEventDefinition
	 * @generated
	 */
	public Adapter createMessageEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.MessageFlow <em>Message Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MessageFlow
	 * @generated
	 */
	public Adapter createMessageFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.MessageFlowAssociation <em>Message Flow Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MessageFlowAssociation
	 * @generated
	 */
	public Adapter createMessageFlowAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Monitoring <em>Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Monitoring
	 * @generated
	 */
	public Adapter createMonitoringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics <em>Multi Instance Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics
	 * @generated
	 */
	public Adapter createMultiInstanceLoopCharacteristicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.OutputSet <em>Output Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.OutputSet
	 * @generated
	 */
	public Adapter createOutputSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ParallelGateway <em>Parallel Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ParallelGateway
	 * @generated
	 */
	public Adapter createParallelGatewayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Participant
	 * @generated
	 */
	public Adapter createParticipantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ParticipantAssociation <em>Participant Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ParticipantAssociation
	 * @generated
	 */
	public Adapter createParticipantAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ParticipantMultiplicity <em>Participant Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ParticipantMultiplicity
	 * @generated
	 */
	public Adapter createParticipantMultiplicityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.PartnerEntity <em>Partner Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.PartnerEntity
	 * @generated
	 */
	public Adapter createPartnerEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.PartnerRole <em>Partner Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.PartnerRole
	 * @generated
	 */
	public Adapter createPartnerRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Performer <em>Performer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Performer
	 * @generated
	 */
	public Adapter createPerformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.PotentialOwner <em>Potential Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.PotentialOwner
	 * @generated
	 */
	public Adapter createPotentialOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ReceiveTask <em>Receive Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ReceiveTask
	 * @generated
	 */
	public Adapter createReceiveTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Rendering <em>Rendering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Rendering
	 * @generated
	 */
	public Adapter createRenderingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ResourceAssignmentExpression <em>Resource Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ResourceAssignmentExpression
	 * @generated
	 */
	public Adapter createResourceAssignmentExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameter <em>Resource Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameter
	 * @generated
	 */
	public Adapter createResourceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameterBinding <em>Resource Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ResourceParameterBinding
	 * @generated
	 */
	public Adapter createResourceParameterBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ResourceRole <em>Resource Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ResourceRole
	 * @generated
	 */
	public Adapter createResourceRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.RootElement <em>Root Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.RootElement
	 * @generated
	 */
	public Adapter createRootElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ScriptTask <em>Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ScriptTask
	 * @generated
	 */
	public Adapter createScriptTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SendTask <em>Send Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SendTask
	 * @generated
	 */
	public Adapter createSendTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SequenceFlow <em>Sequence Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SequenceFlow
	 * @generated
	 */
	public Adapter createSequenceFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask <em>Service Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask
	 * @generated
	 */
	public Adapter createServiceTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Signal
	 * @generated
	 */
	public Adapter createSignalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SignalEventDefinition <em>Signal Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SignalEventDefinition
	 * @generated
	 */
	public Adapter createSignalEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.StandardLoopCharacteristics <em>Standard Loop Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.StandardLoopCharacteristics
	 * @generated
	 */
	public Adapter createStandardLoopCharacteristicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.StartEvent <em>Start Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.StartEvent
	 * @generated
	 */
	public Adapter createStartEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SubChoreography <em>Sub Choreography</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SubChoreography
	 * @generated
	 */
	public Adapter createSubChoreographyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SubConversation <em>Sub Conversation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SubConversation
	 * @generated
	 */
	public Adapter createSubConversationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.SubProcess <em>Sub Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.SubProcess
	 * @generated
	 */
	public Adapter createSubProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.TerminateEventDefinition <em>Terminate Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.TerminateEventDefinition
	 * @generated
	 */
	public Adapter createTerminateEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.TextAnnotation <em>Text Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.TextAnnotation
	 * @generated
	 */
	public Adapter createTextAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ThrowEvent <em>Throw Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ThrowEvent
	 * @generated
	 */
	public Adapter createThrowEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.TimerEventDefinition <em>Timer Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.TimerEventDefinition
	 * @generated
	 */
	public Adapter createTimerEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.Transaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Transaction
	 * @generated
	 */
	public Adapter createTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.UserTask <em>User Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.UserTask
	 * @generated
	 */
	public Adapter createUserTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CandidateUser <em>Candidate User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CandidateUser
	 * @generated
	 */
	public Adapter createCandidateUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CandidateGroup <em>Candidate Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CandidateGroup
	 * @generated
	 */
	public Adapter createCandidateGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.CustomProperty <em>Custom Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.CustomProperty
	 * @generated
	 */
	public Adapter createCustomPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.MailTask <em>Mail Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MailTask
	 * @generated
	 */
	public Adapter createMailTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension <em>Field Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension
	 * @generated
	 */
	public Adapter createFieldExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ComplexDataType <em>Complex Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ComplexDataType
	 * @generated
	 */
	public Adapter createComplexDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataGrid <em>Data Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataGrid
	 * @generated
	 */
	public Adapter createDataGridAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataGridRow <em>Data Grid Row</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataGridRow
	 * @generated
	 */
	public Adapter createDataGridRowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.DataGridField <em>Data Grid Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.DataGridField
	 * @generated
	 */
	public Adapter createDataGridFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener <em>Activiti Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener
	 * @generated
	 */
	public Adapter createActivitiListenerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FormProperty <em>Form Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FormProperty
	 * @generated
	 */
	public Adapter createFormPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.IOParameter <em>IO Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.IOParameter
	 * @generated
	 */
	public Adapter createIOParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoUserTask <em>Alfresco User Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoUserTask
	 * @generated
	 */
	public Adapter createAlfrescoUserTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoStartEvent <em>Alfresco Start Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoStartEvent
	 * @generated
	 */
	public Adapter createAlfrescoStartEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptTask <em>Alfresco Script Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptTask
	 * @generated
	 */
	public Adapter createAlfrescoScriptTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptBase <em>Alfresco Script Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoScriptBase
	 * @generated
	 */
	public Adapter createAlfrescoScriptBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoMailTask <em>Alfresco Mail Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.AlfrescoMailTask
	 * @generated
	 */
	public Adapter createAlfrescoMailTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.aniketos.mtm.model.mtm_bpmn2.FormValue <em>Form Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.FormValue
	 * @generated
	 */
	public Adapter createFormValueAdapter() {
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

} //Bpmn2AdapterFactory
