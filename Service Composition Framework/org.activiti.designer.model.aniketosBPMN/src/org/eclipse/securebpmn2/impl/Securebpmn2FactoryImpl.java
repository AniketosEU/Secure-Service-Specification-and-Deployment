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
package org.eclipse.securebpmn2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.securebpmn2.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Securebpmn2FactoryImpl extends EFactoryImpl implements Securebpmn2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Securebpmn2Factory init() {
		try {
			Securebpmn2Factory theSecurebpmn2Factory = (Securebpmn2Factory)EPackage.Registry.INSTANCE.getEFactory("http://securebpmn"); 
			if (theSecurebpmn2Factory != null) {
				return theSecurebpmn2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Securebpmn2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Securebpmn2FactoryImpl() {
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
			case Securebpmn2Package.SECURITY_FLOW_NODE: return createSecurityFlowNode();
			case Securebpmn2Package.SECURITY_FLOW: return createSecurityFlow();
			case Securebpmn2Package.ROLE: return createRole();
			case Securebpmn2Package.USER: return createUser();
			case Securebpmn2Package.GROUP: return createGroup();
			case Securebpmn2Package.ACTIVITY_ACTION: return createActivityAction();
			case Securebpmn2Package.ATOMIC_ACTIVITY_ACTION: return createAtomicActivityAction();
			case Securebpmn2Package.COMPOSITE_ACTIVITY_ACTION: return createCompositeActivityAction();
			case Securebpmn2Package.PERMISSION: return createPermission();
			case Securebpmn2Package.NEED_TO_KNOW: return createNeedToKnow();
			case Securebpmn2Package.SEPARATION_OF_DUTY: return createSeparationOfDuty();
			case Securebpmn2Package.BINDING_OF_DUTY: return createBindingOfDuty();
			case Securebpmn2Package.AUTHORIZATION_CONSTRAINT: return createAuthorizationConstraint();
			case Securebpmn2Package.ACTIVITY_AUTHORIZATION_CONSTRAINT: return createActivityAuthorizationConstraint();
			case Securebpmn2Package.PROCESS_ACTION: return createProcessAction();
			case Securebpmn2Package.ATOMIC_PROCESS_ACTION: return createAtomicProcessAction();
			case Securebpmn2Package.COMPOSITE_PROCESS_ACTION: return createCompositeProcessAction();
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION: return createItemAwareElementAction();
			case Securebpmn2Package.ATOMIC_ITEM_AWARE_ELEMENT_ACTION: return createAtomicItemAwareElementAction();
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION: return createCompositeItemAwareElementAction();
			case Securebpmn2Package.SIMPLE_DELEGATION: return createSimpleDelegation();
			case Securebpmn2Package.TRANSFER_DELEGATION: return createTransferDelegation();
			case Securebpmn2Package.DELEGATOR: return createDelegator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityFlowNode createSecurityFlowNode() {
		SecurityFlowNodeImpl securityFlowNode = new SecurityFlowNodeImpl();
		return securityFlowNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurityFlow createSecurityFlow() {
		SecurityFlowImpl securityFlow = new SecurityFlowImpl();
		return securityFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityAction createActivityAction() {
		ActivityActionImpl activityAction = new ActivityActionImpl();
		return activityAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicActivityAction createAtomicActivityAction() {
		AtomicActivityActionImpl atomicActivityAction = new AtomicActivityActionImpl();
		return atomicActivityAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeActivityAction createCompositeActivityAction() {
		CompositeActivityActionImpl compositeActivityAction = new CompositeActivityActionImpl();
		return compositeActivityAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Permission createPermission() {
		PermissionImpl permission = new PermissionImpl();
		return permission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NeedToKnow createNeedToKnow() {
		NeedToKnowImpl needToKnow = new NeedToKnowImpl();
		return needToKnow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparationOfDuty createSeparationOfDuty() {
		SeparationOfDutyImpl separationOfDuty = new SeparationOfDutyImpl();
		return separationOfDuty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingOfDuty createBindingOfDuty() {
		BindingOfDutyImpl bindingOfDuty = new BindingOfDutyImpl();
		return bindingOfDuty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorizationConstraint createAuthorizationConstraint() {
		AuthorizationConstraintImpl authorizationConstraint = new AuthorizationConstraintImpl();
		return authorizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityAuthorizationConstraint createActivityAuthorizationConstraint() {
		ActivityAuthorizationConstraintImpl activityAuthorizationConstraint = new ActivityAuthorizationConstraintImpl();
		return activityAuthorizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessAction createProcessAction() {
		ProcessActionImpl processAction = new ProcessActionImpl();
		return processAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicProcessAction createAtomicProcessAction() {
		AtomicProcessActionImpl atomicProcessAction = new AtomicProcessActionImpl();
		return atomicProcessAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeProcessAction createCompositeProcessAction() {
		CompositeProcessActionImpl compositeProcessAction = new CompositeProcessActionImpl();
		return compositeProcessAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemAwareElementAction createItemAwareElementAction() {
		ItemAwareElementActionImpl itemAwareElementAction = new ItemAwareElementActionImpl();
		return itemAwareElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicItemAwareElementAction createAtomicItemAwareElementAction() {
		AtomicItemAwareElementActionImpl atomicItemAwareElementAction = new AtomicItemAwareElementActionImpl();
		return atomicItemAwareElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeItemAwareElementAction createCompositeItemAwareElementAction() {
		CompositeItemAwareElementActionImpl compositeItemAwareElementAction = new CompositeItemAwareElementActionImpl();
		return compositeItemAwareElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleDelegation createSimpleDelegation() {
		SimpleDelegationImpl simpleDelegation = new SimpleDelegationImpl();
		return simpleDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransferDelegation createTransferDelegation() {
		TransferDelegationImpl transferDelegation = new TransferDelegationImpl();
		return transferDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delegator createDelegator() {
		DelegatorImpl delegator = new DelegatorImpl();
		return delegator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Securebpmn2Package getSecurebpmn2Package() {
		return (Securebpmn2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Securebpmn2Package getPackage() {
		return Securebpmn2Package.eINSTANCE;
	}

} //Securebpmn2FactoryImpl
