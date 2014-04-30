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

import org.eclipse.aniketos.AniketosPackage;

import org.eclipse.aniketos.impl.AniketosPackageImpl;

import org.eclipse.bpmn2.Bpmn2Package;

import org.eclipse.bpmn2.di.BpmnDiPackage;

import org.eclipse.bpmn2.di.impl.BpmnDiPackageImpl;

import org.eclipse.bpmn2.impl.Bpmn2PackageImpl;

import org.eclipse.dd.dc.DcPackage;

import org.eclipse.dd.dc.impl.DcPackageImpl;

import org.eclipse.dd.di.DiPackage;

import org.eclipse.dd.di.impl.DiPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.securebpmn2.Action;
import org.eclipse.securebpmn2.ActivityAction;
import org.eclipse.securebpmn2.ActivityAuthorizationConstraint;
import org.eclipse.securebpmn2.AtomicActivityAction;
import org.eclipse.securebpmn2.AtomicItemAwareElementAction;
import org.eclipse.securebpmn2.AtomicProcessAction;
import org.eclipse.securebpmn2.AuthorizationConstraint;
import org.eclipse.securebpmn2.BindingOfDuty;
import org.eclipse.securebpmn2.CompositeActivityAction;
import org.eclipse.securebpmn2.CompositeItemAwareElementAction;
import org.eclipse.securebpmn2.CompositeProcessAction;
import org.eclipse.securebpmn2.Delegation;
import org.eclipse.securebpmn2.Delegator;
import org.eclipse.securebpmn2.Group;
import org.eclipse.securebpmn2.ItemAwareElementAction;
import org.eclipse.securebpmn2.NeedToKnow;
import org.eclipse.securebpmn2.Permission;
import org.eclipse.securebpmn2.ProcessAction;
import org.eclipse.securebpmn2.Role;
import org.eclipse.securebpmn2.Securebpmn2Factory;
import org.eclipse.securebpmn2.Securebpmn2Package;
import org.eclipse.securebpmn2.SecurityFlow;
import org.eclipse.securebpmn2.SecurityFlowNode;
import org.eclipse.securebpmn2.SeparationOfDuty;
import org.eclipse.securebpmn2.SimpleDelegation;
import org.eclipse.securebpmn2.Subject;
import org.eclipse.securebpmn2.TransferDelegation;
import org.eclipse.securebpmn2.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Securebpmn2PackageImpl extends EPackageImpl implements Securebpmn2Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityFlowNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

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
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicActivityActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeActivityActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass needToKnowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass separationOfDutyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingOfDutyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authorizationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityAuthorizationConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicProcessActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeProcessActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemAwareElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicItemAwareElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeItemAwareElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleDelegationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transferDelegationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatorEClass = null;

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
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Securebpmn2PackageImpl() {
		super(eNS_URI, Securebpmn2Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Securebpmn2Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Securebpmn2Package init() {
		if (isInited) return (Securebpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI);

		// Obtain or create and register package
		Securebpmn2PackageImpl theSecurebpmn2Package = (Securebpmn2PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Securebpmn2PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Securebpmn2PackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Bpmn2PackageImpl theBpmn2Package = (Bpmn2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI) instanceof Bpmn2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI) : Bpmn2Package.eINSTANCE);
		DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) : DiPackage.eINSTANCE);
		AniketosPackageImpl theAniketosPackage = (AniketosPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI) instanceof AniketosPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI) : AniketosPackage.eINSTANCE);
		BpmnDiPackageImpl theBpmnDiPackage = (BpmnDiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) instanceof BpmnDiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) : BpmnDiPackage.eINSTANCE);
		DcPackageImpl theDcPackage = (DcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) instanceof DcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) : DcPackage.eINSTANCE);

		// Load packages
		theBpmn2Package.loadPackage();

		// Create package meta-data objects
		theSecurebpmn2Package.createPackageContents();
		theDiPackage.createPackageContents();
		theAniketosPackage.createPackageContents();
		theBpmnDiPackage.createPackageContents();
		theDcPackage.createPackageContents();

		// Initialize created meta-data
		theSecurebpmn2Package.initializePackageContents();
		theDiPackage.initializePackageContents();
		theAniketosPackage.initializePackageContents();
		theBpmnDiPackage.initializePackageContents();
		theDcPackage.initializePackageContents();

		// Fix loaded packages
		theBpmn2Package.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theSecurebpmn2Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Securebpmn2Package.eNS_URI, theSecurebpmn2Package);
		return theSecurebpmn2Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityFlowNode() {
		return securityFlowNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityFlow() {
		return securityFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityFlow_SourceRefNode() {
		return (EReference)securityFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityFlow_TargetRefNode() {
		return (EReference)securityFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_RoleName() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_ParentRoles() {
		return (EReference)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Subjects() {
		return (EReference)roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_ChildRoles() {
		return (EReference)roleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Permissions() {
		return (EReference)roleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubject() {
		return subjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubject_Roles() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubject_Groups() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubject_ReceivedDelegations() {
		return (EReference)subjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserName() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getGroup_GroupName() {
		return (EAttribute)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Subjects() {
		return (EReference)groupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_ActionName() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Permissions() {
		return (EReference)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityAction() {
		return activityActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityAction_CompositeActivityActions() {
		return (EReference)activityActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityAction_Activity() {
		return (EReference)activityActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicActivityAction() {
		return atomicActivityActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeActivityAction() {
		return compositeActivityActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeActivityAction_ActivityActions() {
		return (EReference)compositeActivityActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPermission() {
		return permissionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Roles() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Actions() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_AuthorizationConstraints() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermission_PName() {
		return (EAttribute)permissionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPermission_Delegations() {
		return (EReference)permissionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNeedToKnow() {
		return needToKnowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeparationOfDuty() {
		return separationOfDutyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeparationOfDuty_MinimumUsers() {
		return (EAttribute)separationOfDutyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeparationOfDuty_MaxUserActionsPermitted() {
		return (EAttribute)separationOfDutyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingOfDuty() {
		return bindingOfDutyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingOfDuty_MaxUsers() {
		return (EAttribute)bindingOfDutyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingOfDuty_SameUserActionCount() {
		return (EAttribute)bindingOfDutyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthorizationConstraint() {
		return authorizationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthorizationConstraint_ConstraintName() {
		return (EAttribute)authorizationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthorizationConstraint_Expression() {
		return (EAttribute)authorizationConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthorizationConstraint_Permissions() {
		return (EReference)authorizationConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthorizationConstraint_DynamicEnforcement() {
		return (EAttribute)authorizationConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityAuthorizationConstraint() {
		return activityAuthorizationConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityAuthorizationConstraint_Activities() {
		return (EReference)activityAuthorizationConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessAction() {
		return processActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessAction_CompositeProcessActions() {
		return (EReference)processActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessAction_Process() {
		return (EReference)processActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicProcessAction() {
		return atomicProcessActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeProcessAction() {
		return compositeProcessActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeProcessAction_ProcessActions() {
		return (EReference)compositeProcessActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemAwareElementAction() {
		return itemAwareElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemAwareElementAction_CompositeItemAwareElementActions() {
		return (EReference)itemAwareElementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemAwareElementAction_ItemAwareElement() {
		return (EReference)itemAwareElementActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicItemAwareElementAction() {
		return atomicItemAwareElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeItemAwareElementAction() {
		return compositeItemAwareElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeItemAwareElementAction_ItemAwareElementActions() {
		return (EReference)compositeItemAwareElementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegation() {
		return delegationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegation_Delegator() {
		return (EReference)delegationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegation_Delegatee() {
		return (EReference)delegationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelegation_Negotiable() {
		return (EAttribute)delegationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegation_Permissions() {
		return (EReference)delegationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelegation_DelegatablePermissions() {
		return (EAttribute)delegationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleDelegation() {
		return simpleDelegationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransferDelegation() {
		return transferDelegationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegator() {
		return delegatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegator_ParentDelegators() {
		return (EReference)delegatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegator_ChildDelegators() {
		return (EReference)delegatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelegator_MaxDelegationDepth() {
		return (EAttribute)delegatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelegator_ExecutedDelegations() {
		return (EReference)delegatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Securebpmn2Factory getSecurebpmn2Factory() {
		return (Securebpmn2Factory)getEFactoryInstance();
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
		securityFlowNodeEClass = createEClass(SECURITY_FLOW_NODE);

		securityFlowEClass = createEClass(SECURITY_FLOW);
		createEReference(securityFlowEClass, SECURITY_FLOW__SOURCE_REF_NODE);
		createEReference(securityFlowEClass, SECURITY_FLOW__TARGET_REF_NODE);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__ROLE_NAME);
		createEReference(roleEClass, ROLE__PARENT_ROLES);
		createEReference(roleEClass, ROLE__SUBJECTS);
		createEReference(roleEClass, ROLE__CHILD_ROLES);
		createEReference(roleEClass, ROLE__PERMISSIONS);

		subjectEClass = createEClass(SUBJECT);
		createEReference(subjectEClass, SUBJECT__ROLES);
		createEReference(subjectEClass, SUBJECT__GROUPS);
		createEReference(subjectEClass, SUBJECT__RECEIVED_DELEGATIONS);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__USER_NAME);

		groupEClass = createEClass(GROUP);
		createEAttribute(groupEClass, GROUP__GROUP_NAME);
		createEReference(groupEClass, GROUP__SUBJECTS);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__ACTION_NAME);
		createEReference(actionEClass, ACTION__PERMISSIONS);

		activityActionEClass = createEClass(ACTIVITY_ACTION);
		createEReference(activityActionEClass, ACTIVITY_ACTION__COMPOSITE_ACTIVITY_ACTIONS);
		createEReference(activityActionEClass, ACTIVITY_ACTION__ACTIVITY);

		atomicActivityActionEClass = createEClass(ATOMIC_ACTIVITY_ACTION);

		compositeActivityActionEClass = createEClass(COMPOSITE_ACTIVITY_ACTION);
		createEReference(compositeActivityActionEClass, COMPOSITE_ACTIVITY_ACTION__ACTIVITY_ACTIONS);

		permissionEClass = createEClass(PERMISSION);
		createEReference(permissionEClass, PERMISSION__ROLES);
		createEReference(permissionEClass, PERMISSION__ACTIONS);
		createEReference(permissionEClass, PERMISSION__AUTHORIZATION_CONSTRAINTS);
		createEAttribute(permissionEClass, PERMISSION__PNAME);
		createEReference(permissionEClass, PERMISSION__DELEGATIONS);

		needToKnowEClass = createEClass(NEED_TO_KNOW);

		separationOfDutyEClass = createEClass(SEPARATION_OF_DUTY);
		createEAttribute(separationOfDutyEClass, SEPARATION_OF_DUTY__MINIMUM_USERS);
		createEAttribute(separationOfDutyEClass, SEPARATION_OF_DUTY__MAX_USER_ACTIONS_PERMITTED);

		bindingOfDutyEClass = createEClass(BINDING_OF_DUTY);
		createEAttribute(bindingOfDutyEClass, BINDING_OF_DUTY__MAX_USERS);
		createEAttribute(bindingOfDutyEClass, BINDING_OF_DUTY__SAME_USER_ACTION_COUNT);

		authorizationConstraintEClass = createEClass(AUTHORIZATION_CONSTRAINT);
		createEAttribute(authorizationConstraintEClass, AUTHORIZATION_CONSTRAINT__CONSTRAINT_NAME);
		createEAttribute(authorizationConstraintEClass, AUTHORIZATION_CONSTRAINT__EXPRESSION);
		createEReference(authorizationConstraintEClass, AUTHORIZATION_CONSTRAINT__PERMISSIONS);
		createEAttribute(authorizationConstraintEClass, AUTHORIZATION_CONSTRAINT__DYNAMIC_ENFORCEMENT);

		activityAuthorizationConstraintEClass = createEClass(ACTIVITY_AUTHORIZATION_CONSTRAINT);
		createEReference(activityAuthorizationConstraintEClass, ACTIVITY_AUTHORIZATION_CONSTRAINT__ACTIVITIES);

		processActionEClass = createEClass(PROCESS_ACTION);
		createEReference(processActionEClass, PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS);
		createEReference(processActionEClass, PROCESS_ACTION__PROCESS);

		atomicProcessActionEClass = createEClass(ATOMIC_PROCESS_ACTION);

		compositeProcessActionEClass = createEClass(COMPOSITE_PROCESS_ACTION);
		createEReference(compositeProcessActionEClass, COMPOSITE_PROCESS_ACTION__PROCESS_ACTIONS);

		itemAwareElementActionEClass = createEClass(ITEM_AWARE_ELEMENT_ACTION);
		createEReference(itemAwareElementActionEClass, ITEM_AWARE_ELEMENT_ACTION__COMPOSITE_ITEM_AWARE_ELEMENT_ACTIONS);
		createEReference(itemAwareElementActionEClass, ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT);

		atomicItemAwareElementActionEClass = createEClass(ATOMIC_ITEM_AWARE_ELEMENT_ACTION);

		compositeItemAwareElementActionEClass = createEClass(COMPOSITE_ITEM_AWARE_ELEMENT_ACTION);
		createEReference(compositeItemAwareElementActionEClass, COMPOSITE_ITEM_AWARE_ELEMENT_ACTION__ITEM_AWARE_ELEMENT_ACTIONS);

		delegationEClass = createEClass(DELEGATION);
		createEReference(delegationEClass, DELEGATION__DELEGATOR);
		createEReference(delegationEClass, DELEGATION__DELEGATEE);
		createEAttribute(delegationEClass, DELEGATION__NEGOTIABLE);
		createEReference(delegationEClass, DELEGATION__PERMISSIONS);
		createEAttribute(delegationEClass, DELEGATION__DELEGATABLE_PERMISSIONS);

		simpleDelegationEClass = createEClass(SIMPLE_DELEGATION);

		transferDelegationEClass = createEClass(TRANSFER_DELEGATION);

		delegatorEClass = createEClass(DELEGATOR);
		createEReference(delegatorEClass, DELEGATOR__PARENT_DELEGATORS);
		createEReference(delegatorEClass, DELEGATOR__CHILD_DELEGATORS);
		createEAttribute(delegatorEClass, DELEGATOR__MAX_DELEGATION_DEPTH);
		createEReference(delegatorEClass, DELEGATOR__EXECUTED_DELEGATIONS);
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
		Bpmn2Package theBpmn2Package = (Bpmn2Package)EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		securityFlowNodeEClass.getESuperTypes().add(theBpmn2Package.getFlowNode());
		securityFlowEClass.getESuperTypes().add(theBpmn2Package.getFlowElement());
		roleEClass.getESuperTypes().add(this.getSecurityFlowNode());
		subjectEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		userEClass.getESuperTypes().add(this.getSubject());
		groupEClass.getESuperTypes().add(this.getSubject());
		actionEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		activityActionEClass.getESuperTypes().add(this.getAction());
		atomicActivityActionEClass.getESuperTypes().add(this.getActivityAction());
		compositeActivityActionEClass.getESuperTypes().add(this.getActivityAction());
		permissionEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		needToKnowEClass.getESuperTypes().add(this.getPermission());
		separationOfDutyEClass.getESuperTypes().add(this.getAuthorizationConstraint());
		bindingOfDutyEClass.getESuperTypes().add(this.getAuthorizationConstraint());
		authorizationConstraintEClass.getESuperTypes().add(this.getSecurityFlowNode());
		activityAuthorizationConstraintEClass.getESuperTypes().add(this.getAuthorizationConstraint());
		processActionEClass.getESuperTypes().add(this.getAction());
		atomicProcessActionEClass.getESuperTypes().add(this.getProcessAction());
		compositeProcessActionEClass.getESuperTypes().add(this.getProcessAction());
		itemAwareElementActionEClass.getESuperTypes().add(this.getAction());
		atomicItemAwareElementActionEClass.getESuperTypes().add(this.getItemAwareElementAction());
		compositeItemAwareElementActionEClass.getESuperTypes().add(this.getItemAwareElementAction());
		delegationEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		simpleDelegationEClass.getESuperTypes().add(this.getDelegation());
		transferDelegationEClass.getESuperTypes().add(this.getDelegation());
		delegatorEClass.getESuperTypes().add(this.getUser());

		// Initialize classes and features; add operations and parameters
		initEClass(securityFlowNodeEClass, SecurityFlowNode.class, "SecurityFlowNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(securityFlowEClass, SecurityFlow.class, "SecurityFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecurityFlow_SourceRefNode(), theBpmn2Package.getFlowNode(), theBpmn2Package.getFlowNode_OutgoingSecurityFlow(), "sourceRefNode", null, 1, 1, SecurityFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSecurityFlow_TargetRefNode(), theBpmn2Package.getFlowNode(), theBpmn2Package.getFlowNode_IncomingSecurityFlow(), "targetRefNode", null, 1, 1, SecurityFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_RoleName(), ecorePackage.getEString(), "roleName", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_ParentRoles(), this.getRole(), this.getRole_ChildRoles(), "parentRoles", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Subjects(), this.getSubject(), this.getSubject_Roles(), "subjects", null, 0, -1, Role.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_ChildRoles(), this.getRole(), this.getRole_ParentRoles(), "childRoles", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Permissions(), this.getPermission(), this.getPermission_Roles(), "permissions", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subjectEClass, Subject.class, "Subject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubject_Roles(), this.getRole(), this.getRole_Subjects(), "roles", null, 0, -1, Subject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubject_Groups(), this.getGroup(), this.getGroup_Subjects(), "groups", null, 0, -1, Subject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubject_ReceivedDelegations(), this.getDelegation(), null, "receivedDelegations", null, 0, -1, Subject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_UserName(), ecorePackage.getEString(), "userName", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGroup_GroupName(), ecorePackage.getEString(), "groupName", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroup_Subjects(), this.getSubject(), this.getSubject_Groups(), "subjects", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_ActionName(), ecorePackage.getEString(), "actionName", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAction_Permissions(), this.getPermission(), this.getPermission_Actions(), "permissions", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityActionEClass, ActivityAction.class, "ActivityAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityAction_CompositeActivityActions(), this.getCompositeActivityAction(), this.getCompositeActivityAction_ActivityActions(), "compositeActivityActions", null, 0, -1, ActivityAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityAction_Activity(), theBpmn2Package.getActivity(), theBpmn2Package.getActivity_ActivityActions(), "activity", null, 1, 1, ActivityAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicActivityActionEClass, AtomicActivityAction.class, "AtomicActivityAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeActivityActionEClass, CompositeActivityAction.class, "CompositeActivityAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeActivityAction_ActivityActions(), this.getActivityAction(), this.getActivityAction_CompositeActivityActions(), "activityActions", null, 0, -1, CompositeActivityAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionEClass, Permission.class, "Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPermission_Roles(), this.getRole(), this.getRole_Permissions(), "roles", null, 1, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPermission_Actions(), this.getAction(), this.getAction_Permissions(), "actions", null, 1, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPermission_AuthorizationConstraints(), this.getAuthorizationConstraint(), this.getAuthorizationConstraint_Permissions(), "authorizationConstraints", null, 0, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermission_PName(), ecorePackage.getEString(), "pName", null, 0, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPermission_Delegations(), this.getDelegation(), this.getDelegation_Permissions(), "delegations", null, 0, -1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(needToKnowEClass, NeedToKnow.class, "NeedToKnow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(separationOfDutyEClass, SeparationOfDuty.class, "SeparationOfDuty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeparationOfDuty_MinimumUsers(), ecorePackage.getEIntegerObject(), "minimumUsers", null, 0, 1, SeparationOfDuty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeparationOfDuty_MaxUserActionsPermitted(), ecorePackage.getEIntegerObject(), "maxUserActionsPermitted", null, 0, 1, SeparationOfDuty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingOfDutyEClass, BindingOfDuty.class, "BindingOfDuty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingOfDuty_MaxUsers(), ecorePackage.getEIntegerObject(), "maxUsers", null, 0, 1, BindingOfDuty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingOfDuty_SameUserActionCount(), ecorePackage.getEIntegerObject(), "sameUserActionCount", null, 0, 1, BindingOfDuty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(authorizationConstraintEClass, AuthorizationConstraint.class, "AuthorizationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAuthorizationConstraint_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, AuthorizationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthorizationConstraint_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, AuthorizationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthorizationConstraint_Permissions(), this.getPermission(), this.getPermission_AuthorizationConstraints(), "permissions", null, 1, -1, AuthorizationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthorizationConstraint_DynamicEnforcement(), ecorePackage.getEBoolean(), "dynamicEnforcement", null, 0, 1, AuthorizationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityAuthorizationConstraintEClass, ActivityAuthorizationConstraint.class, "ActivityAuthorizationConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivityAuthorizationConstraint_Activities(), theBpmn2Package.getActivity(), theBpmn2Package.getActivity_ActivityAuthorizationConstraints(), "activities", null, 1, -1, ActivityAuthorizationConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processActionEClass, ProcessAction.class, "ProcessAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessAction_CompositeProcessActions(), this.getCompositeProcessAction(), this.getCompositeProcessAction_ProcessActions(), "compositeProcessActions", null, 0, -1, ProcessAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessAction_Process(), theBpmn2Package.getProcess(), theBpmn2Package.getProcess_ProcessActions(), "process", null, 1, 1, ProcessAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicProcessActionEClass, AtomicProcessAction.class, "AtomicProcessAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeProcessActionEClass, CompositeProcessAction.class, "CompositeProcessAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeProcessAction_ProcessActions(), this.getProcessAction(), this.getProcessAction_CompositeProcessActions(), "processActions", null, 0, -1, CompositeProcessAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemAwareElementActionEClass, ItemAwareElementAction.class, "ItemAwareElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getItemAwareElementAction_CompositeItemAwareElementActions(), this.getCompositeItemAwareElementAction(), this.getCompositeItemAwareElementAction_ItemAwareElementActions(), "compositeItemAwareElementActions", null, 0, -1, ItemAwareElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getItemAwareElementAction_ItemAwareElement(), theBpmn2Package.getItemAwareElement(), theBpmn2Package.getItemAwareElement_ItemAwareElementActions(), "itemAwareElement", null, 1, 1, ItemAwareElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicItemAwareElementActionEClass, AtomicItemAwareElementAction.class, "AtomicItemAwareElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeItemAwareElementActionEClass, CompositeItemAwareElementAction.class, "CompositeItemAwareElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeItemAwareElementAction_ItemAwareElementActions(), this.getItemAwareElementAction(), this.getItemAwareElementAction_CompositeItemAwareElementActions(), "itemAwareElementActions", null, 0, -1, CompositeItemAwareElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(delegationEClass, Delegation.class, "Delegation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelegation_Delegator(), this.getDelegator(), null, "delegator", null, 1, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelegation_Delegatee(), this.getSubject(), null, "delegatee", null, 1, 1, Delegation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelegation_Negotiable(), ecorePackage.getEBoolean(), "negotiable", null, 0, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelegation_Permissions(), this.getPermission(), this.getPermission_Delegations(), "permissions", null, 1, -1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getPermission());
		g1.getETypeArguments().add(g2);
		initEAttribute(getDelegation_DelegatablePermissions(), g1, "delegatablePermissions", null, 0, 1, Delegation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleDelegationEClass, SimpleDelegation.class, "SimpleDelegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transferDelegationEClass, TransferDelegation.class, "TransferDelegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(delegatorEClass, Delegator.class, "Delegator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelegator_ParentDelegators(), this.getDelegator(), this.getDelegator_ChildDelegators(), "parentDelegators", null, 0, -1, Delegator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelegator_ChildDelegators(), this.getDelegator(), this.getDelegator_ParentDelegators(), "childDelegators", null, 0, -1, Delegator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelegator_MaxDelegationDepth(), ecorePackage.getEInt(), "maxDelegationDepth", null, 0, 1, Delegator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelegator_ExecutedDelegations(), this.getDelegation(), null, "executedDelegations", null, 0, -1, Delegator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (getSecurityFlow_SourceRefNode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "sourceRef"
		   });		
		addAnnotation
		  (getSecurityFlow_TargetRefNode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetRef"
		   });
	}

} //Securebpmn2PackageImpl
