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
package org.eclipse.aniketos.impl;

import org.eclipse.aniketos.AniketosFactory;
import org.eclipse.aniketos.AniketosPackage;
import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.ThreatEvent;
import org.eclipse.aniketos.Trustworthiness;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.securebpmn2.Securebpmn2Package;

import org.eclipse.securebpmn2.impl.Securebpmn2PackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AniketosPackageImpl extends EPackageImpl implements AniketosPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securityExtensionEClass = null;

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
	private EClass trustworthinessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass confidentialityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatEventEClass = null;

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
	 * @see org.eclipse.aniketos.AniketosPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AniketosPackageImpl() {
		super(eNS_URI, AniketosFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AniketosPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AniketosPackage init() {
		if (isInited) return (AniketosPackage)EPackage.Registry.INSTANCE.getEPackage(AniketosPackage.eNS_URI);

		// Obtain or create and register package
		AniketosPackageImpl theAniketosPackage = (AniketosPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AniketosPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AniketosPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Bpmn2PackageImpl theBpmn2Package = (Bpmn2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI) instanceof Bpmn2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Bpmn2Package.eNS_URI) : Bpmn2Package.eINSTANCE);
		Securebpmn2PackageImpl theSecurebpmn2Package = (Securebpmn2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI) instanceof Securebpmn2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Securebpmn2Package.eNS_URI) : Securebpmn2Package.eINSTANCE);
		DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI) : DiPackage.eINSTANCE);
		BpmnDiPackageImpl theBpmnDiPackage = (BpmnDiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) instanceof BpmnDiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpmnDiPackage.eNS_URI) : BpmnDiPackage.eINSTANCE);
		DcPackageImpl theDcPackage = (DcPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) instanceof DcPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DcPackage.eNS_URI) : DcPackage.eINSTANCE);

		// Load packages
		theBpmn2Package.loadPackage();

		// Create package meta-data objects
		theAniketosPackage.createPackageContents();
		theSecurebpmn2Package.createPackageContents();
		theDiPackage.createPackageContents();
		theBpmnDiPackage.createPackageContents();
		theDcPackage.createPackageContents();

		// Initialize created meta-data
		theAniketosPackage.initializePackageContents();
		theSecurebpmn2Package.initializePackageContents();
		theDiPackage.initializePackageContents();
		theBpmnDiPackage.initializePackageContents();
		theDcPackage.initializePackageContents();

		// Fix loaded packages
		theBpmn2Package.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theAniketosPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AniketosPackage.eNS_URI, theAniketosPackage);
		return theAniketosPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurityExtension() {
		return securityExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityExtension_IntegrityReq() {
		return (EReference)securityExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityExtension_TrustworthinessValue() {
		return (EReference)securityExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecurityExtension_ConfidentialityReq() {
		return (EReference)securityExtensionEClass.getEStructuralFeatures().get(2);
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
	public EReference getIntegrity_SecurityRef() {
		return (EReference)integrityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_Type() {
		return (EAttribute)integrityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrity_With() {
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
	public EClass getTrustworthiness() {
		return trustworthinessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrustworthiness_Value() {
		return (EAttribute)trustworthinessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustworthiness_SecurityRef() {
		return (EReference)trustworthinessEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getConfidentiality_Type() {
		return (EAttribute)confidentialityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfidentiality_SecurityRef() {
		return (EReference)confidentialityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentiality_Algorithm() {
		return (EAttribute)confidentialityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreatEvent() {
		return threatEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AniketosFactory getAniketosFactory() {
		return (AniketosFactory)getEFactoryInstance();
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
		securityExtensionEClass = createEClass(SECURITY_EXTENSION);
		createEReference(securityExtensionEClass, SECURITY_EXTENSION__INTEGRITY_REQ);
		createEReference(securityExtensionEClass, SECURITY_EXTENSION__TRUSTWORTHINESS_VALUE);
		createEReference(securityExtensionEClass, SECURITY_EXTENSION__CONFIDENTIALITY_REQ);

		integrityEClass = createEClass(INTEGRITY);
		createEReference(integrityEClass, INTEGRITY__SECURITY_REF);
		createEAttribute(integrityEClass, INTEGRITY__TYPE);
		createEAttribute(integrityEClass, INTEGRITY__WITH);
		createEAttribute(integrityEClass, INTEGRITY__ALGORITHM);

		trustworthinessEClass = createEClass(TRUSTWORTHINESS);
		createEAttribute(trustworthinessEClass, TRUSTWORTHINESS__VALUE);
		createEReference(trustworthinessEClass, TRUSTWORTHINESS__SECURITY_REF);

		confidentialityEClass = createEClass(CONFIDENTIALITY);
		createEAttribute(confidentialityEClass, CONFIDENTIALITY__TYPE);
		createEReference(confidentialityEClass, CONFIDENTIALITY__SECURITY_REF);
		createEAttribute(confidentialityEClass, CONFIDENTIALITY__ALGORITHM);

		threatEventEClass = createEClass(THREAT_EVENT);
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
		securityExtensionEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		integrityEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		trustworthinessEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		confidentialityEClass.getESuperTypes().add(theBpmn2Package.getBaseElement());
		threatEventEClass.getESuperTypes().add(theBpmn2Package.getBoundaryEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(securityExtensionEClass, SecurityExtension.class, "SecurityExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecurityExtension_IntegrityReq(), this.getIntegrity(), null, "integrityReq", null, 0, -1, SecurityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityExtension_TrustworthinessValue(), this.getTrustworthiness(), null, "trustworthinessValue", null, 0, 1, SecurityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecurityExtension_ConfidentialityReq(), this.getConfidentiality(), null, "confidentialityReq", null, 0, 2, SecurityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integrityEClass, Integrity.class, "Integrity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegrity_SecurityRef(), this.getSecurityExtension(), null, "securityRef", null, 0, -1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_Type(), ecorePackage.getEString(), "type", null, 0, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_With(), ecorePackage.getEString(), "with", null, 0, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrity_Algorithm(), ecorePackage.getEString(), "algorithm", null, 0, 1, Integrity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustworthinessEClass, Trustworthiness.class, "Trustworthiness", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTrustworthiness_Value(), ecorePackage.getEString(), "Value", null, 0, 1, Trustworthiness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrustworthiness_SecurityRef(), this.getSecurityExtension(), null, "securityRef", null, 0, 1, Trustworthiness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(confidentialityEClass, Confidentiality.class, "Confidentiality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfidentiality_Type(), ecorePackage.getEString(), "type", null, 0, 1, Confidentiality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfidentiality_SecurityRef(), this.getSecurityExtension(), null, "securityRef", null, 0, -1, Confidentiality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfidentiality_Algorithm(), ecorePackage.getEString(), "algorithm", "", 0, 1, Confidentiality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatEventEClass, ThreatEvent.class, "ThreatEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AniketosPackageImpl
