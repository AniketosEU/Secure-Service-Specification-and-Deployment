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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.AllowedRolePolicy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Availability;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesFactory;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.GuardedTaskPolicy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.LevelPolicy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.MultipleGuardedTaskPolicy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoDelegation;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.NoRepudiation;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConsumerpoliciesPackageImpl extends EPackageImpl implements ConsumerpoliciesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass policyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardedTaskPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleGuardedTaskPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allowedRolePolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass levelPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trustworthinessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noDelegationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noRepudiationEClass = null;

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
	private EClass separationOfDutyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass confidentialityEClass = null;

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
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConsumerpoliciesPackageImpl() {
		super(eNS_URI, ConsumerpoliciesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConsumerpoliciesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConsumerpoliciesPackage init() {
		if (isInited) return (ConsumerpoliciesPackage)EPackage.Registry.INSTANCE.getEPackage(ConsumerpoliciesPackage.eNS_URI);

		// Obtain or create and register package
		ConsumerpoliciesPackageImpl theConsumerpoliciesPackage = (ConsumerpoliciesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConsumerpoliciesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConsumerpoliciesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theConsumerpoliciesPackage.createPackageContents();

		// Initialize created meta-data
		theConsumerpoliciesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConsumerpoliciesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConsumerpoliciesPackage.eNS_URI, theConsumerpoliciesPackage);
		return theConsumerpoliciesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolicy() {
		return policyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPolicy_ID() {
		return (EAttribute)policyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuardedTaskPolicy() {
		return guardedTaskPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuardedTaskPolicy_GuardedTask() {
		return (EAttribute)guardedTaskPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultipleGuardedTaskPolicy() {
		return multipleGuardedTaskPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultipleGuardedTaskPolicy_GuardedTasks() {
		return (EAttribute)multipleGuardedTaskPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllowedRolePolicy() {
		return allowedRolePolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAllowedRolePolicy_AllowedRole() {
		return (EAttribute)allowedRolePolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLevelPolicy() {
		return levelPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLevelPolicy_MinLevel() {
		return (EAttribute)levelPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustworthiness() {
		return trustworthinessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvailability() {
		return availabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegrity() {
		return integrityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_GuardedSender() {
		return (EAttribute)integrityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_ProcessingService() {
		return (EAttribute)integrityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_GeneratingService() {
		return (EAttribute)integrityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_Algorithm() {
		return (EAttribute)integrityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoDelegation() {
		return noDelegationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoRepudiation() {
		return noRepudiationEClass;
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
	public EClass getSeparationOfDuty() {
		return separationOfDutyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfidentiality() {
		return confidentialityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentiality_InputSuite() {
		return (EAttribute)confidentialityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentiality_OutputSuite() {
		return (EAttribute)confidentialityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerpoliciesFactory getConsumerpoliciesFactory() {
		return (ConsumerpoliciesFactory)getEFactoryInstance();
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
		policyEClass = createEClass(POLICY);
		createEAttribute(policyEClass, POLICY__ID);

		guardedTaskPolicyEClass = createEClass(GUARDED_TASK_POLICY);
		createEAttribute(guardedTaskPolicyEClass, GUARDED_TASK_POLICY__GUARDED_TASK);

		multipleGuardedTaskPolicyEClass = createEClass(MULTIPLE_GUARDED_TASK_POLICY);
		createEAttribute(multipleGuardedTaskPolicyEClass, MULTIPLE_GUARDED_TASK_POLICY__GUARDED_TASKS);

		allowedRolePolicyEClass = createEClass(ALLOWED_ROLE_POLICY);
		createEAttribute(allowedRolePolicyEClass, ALLOWED_ROLE_POLICY__ALLOWED_ROLE);

		levelPolicyEClass = createEClass(LEVEL_POLICY);
		createEAttribute(levelPolicyEClass, LEVEL_POLICY__MIN_LEVEL);

		trustworthinessEClass = createEClass(TRUSTWORTHINESS);

		availabilityEClass = createEClass(AVAILABILITY);

		integrityEClass = createEClass(INTEGRITY);
		createEAttribute(integrityEClass, INTEGRITY__GUARDED_SENDER);
		createEAttribute(integrityEClass, INTEGRITY__PROCESSING_SERVICE);
		createEAttribute(integrityEClass, INTEGRITY__GENERATING_SERVICE);
		createEAttribute(integrityEClass, INTEGRITY__ALGORITHM);

		noDelegationEClass = createEClass(NO_DELEGATION);

		noRepudiationEClass = createEClass(NO_REPUDIATION);

		bindingOfDutyEClass = createEClass(BINDING_OF_DUTY);

		separationOfDutyEClass = createEClass(SEPARATION_OF_DUTY);

		confidentialityEClass = createEClass(CONFIDENTIALITY);
		createEAttribute(confidentialityEClass, CONFIDENTIALITY__INPUT_SUITE);
		createEAttribute(confidentialityEClass, CONFIDENTIALITY__OUTPUT_SUITE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		guardedTaskPolicyEClass.getESuperTypes().add(this.getPolicy());
		multipleGuardedTaskPolicyEClass.getESuperTypes().add(this.getPolicy());
		allowedRolePolicyEClass.getESuperTypes().add(this.getPolicy());
		levelPolicyEClass.getESuperTypes().add(this.getPolicy());
		trustworthinessEClass.getESuperTypes().add(this.getLevelPolicy());
		trustworthinessEClass.getESuperTypes().add(this.getGuardedTaskPolicy());
		availabilityEClass.getESuperTypes().add(this.getLevelPolicy());
		integrityEClass.getESuperTypes().add(this.getPolicy());
		noDelegationEClass.getESuperTypes().add(this.getGuardedTaskPolicy());
		noDelegationEClass.getESuperTypes().add(this.getAllowedRolePolicy());
		noRepudiationEClass.getESuperTypes().add(this.getGuardedTaskPolicy());
		bindingOfDutyEClass.getESuperTypes().add(this.getMultipleGuardedTaskPolicy());
		separationOfDutyEClass.getESuperTypes().add(this.getMultipleGuardedTaskPolicy());
		confidentialityEClass.getESuperTypes().add(this.getGuardedTaskPolicy());

		// Initialize classes and features; add operations and parameters
		initEClass(policyEClass, Policy.class, "Policy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPolicy_ID(), ecorePackage.getEString(), "ID", null, 1, 1, Policy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardedTaskPolicyEClass, GuardedTaskPolicy.class, "GuardedTaskPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGuardedTaskPolicy_GuardedTask(), ecorePackage.getEString(), "guardedTask", null, 1, 1, GuardedTaskPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleGuardedTaskPolicyEClass, MultipleGuardedTaskPolicy.class, "MultipleGuardedTaskPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultipleGuardedTaskPolicy_GuardedTasks(), ecorePackage.getEString(), "guardedTasks", null, 2, -1, MultipleGuardedTaskPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allowedRolePolicyEClass, AllowedRolePolicy.class, "AllowedRolePolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAllowedRolePolicy_AllowedRole(), ecorePackage.getEString(), "allowedRole", null, 1, 1, AllowedRolePolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(levelPolicyEClass, LevelPolicy.class, "LevelPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLevelPolicy_MinLevel(), ecorePackage.getEFloatObject(), "minLevel", null, 1, 1, LevelPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustworthinessEClass, Trustworthiness.class, "Trustworthiness", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(availabilityEClass, Availability.class, "Availability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integrityEClass, Integrity.class, "Integrity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegrity_GuardedSender(), ecorePackage.getEString(), "guardedSender", null, 1, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_ProcessingService(), ecorePackage.getEString(), "processingService", null, 1, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_GeneratingService(), ecorePackage.getEString(), "generatingService", null, 1, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_Algorithm(), ecorePackage.getEString(), "algorithm", null, 1, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noDelegationEClass, NoDelegation.class, "NoDelegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(noRepudiationEClass, NoRepudiation.class, "NoRepudiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bindingOfDutyEClass, BindingOfDuty.class, "BindingOfDuty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(separationOfDutyEClass, SeparationOfDuty.class, "SeparationOfDuty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(confidentialityEClass, Confidentiality.class, "Confidentiality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfidentiality_InputSuite(), ecorePackage.getEString(), "inputSuite", null, 1, 1, Confidentiality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfidentiality_OutputSuite(), ecorePackage.getEString(), "outputSuite", null, 1, 1, Confidentiality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// emf.gen
		createEmfAnnotations();
	}

	/**
	 * Initializes the annotations for <b>emf.gen</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmfAnnotations() {
		String source = "emf.gen";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "basePackage", "eu.aniketos.mtm.consumerpolicies"
		   });
	}

} //ConsumerpoliciesPackageImpl
