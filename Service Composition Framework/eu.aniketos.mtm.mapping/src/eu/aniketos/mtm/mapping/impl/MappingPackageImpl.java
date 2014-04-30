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
package eu.aniketos.mtm.mapping.impl;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.ActorType;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.ConfidentialityType;
import eu.aniketos.mtm.mapping.DocType;
import eu.aniketos.mtm.mapping.DocumentRoot;
import eu.aniketos.mtm.mapping.GoalType;
import eu.aniketos.mtm.mapping.IntegrityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingFactory;
import eu.aniketos.mtm.mapping.MappingPackage;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.ParticipantType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.SRRType;
import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.ThreatType;
import eu.aniketos.mtm.mapping.ThreatsMapping;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.mapping.TypeType1;
import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.mapping.VarType;

import eu.aniketos.mtm.mapping.util.MappingValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityVarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bppTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bprTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass confidentialityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass docTypeEClass = null;

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
	private EClass goalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integrityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isaTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permissionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relatesToTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soDBoDTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sraTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass srrTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatsMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeType1EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeType2EEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum usertypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType commitmentIDTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType commitmentIDType1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeTypeObject1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeTypeObject2EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType usertypeTypeObjectEDataType = null;

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
	 * @see eu.aniketos.mtm.mapping.MappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MappingPackageImpl() {
		super(eNS_URI, MappingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MappingPackage init() {
		if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Obtain or create and register package
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MappingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMappingPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MappingValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
		return theMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityType() {
		return activityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Mixed() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Value() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityType_Variable() {
		return (EReference)activityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Participant() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Trustworthiness() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityType_Integrity() {
		return (EReference)activityTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityType_Permission() {
		return (EReference)activityTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Threat() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Id() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityType_Usertype() {
		return (EAttribute)activityTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityVar() {
		return activityVarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityVar_Mixed() {
		return (EAttribute)activityVarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityVar_Confidentiality() {
		return (EReference)activityVarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityVar_Id() {
		return (EAttribute)activityVarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityVar_Type() {
		return (EAttribute)activityVarEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorType() {
		return actorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorType_Value() {
		return (EAttribute)actorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActorType_Id() {
		return (EAttribute)actorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPPType() {
		return bppTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPPType_Id() {
		return (EAttribute)bppTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPRType() {
		return bprTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPRType_Id() {
		return (EAttribute)bprTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfidentialityType() {
		return confidentialityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentialityType_Value() {
		return (EAttribute)confidentialityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentialityType_Algorithm() {
		return (EAttribute)confidentialityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfidentialityType_CommitmentID() {
		return (EAttribute)confidentialityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocType() {
		return docTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Value() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Id() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(1);
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
	public EReference getDocumentRoot_Mapping() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalType() {
		return goalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoalType_Value() {
		return (EAttribute)goalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoalType_Id() {
		return (EAttribute)goalTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegrityType() {
		return integrityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrityType_Mixed() {
		return (EAttribute)integrityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrityType_With() {
		return (EAttribute)integrityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrityType_Type() {
		return (EAttribute)integrityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrityType_Algorithm() {
		return (EAttribute)integrityTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegrityType_Variable() {
		return (EAttribute)integrityTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsaType() {
		return isaTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsaType_BPRole() {
		return (EReference)isaTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsaType_BPPart() {
		return (EReference)isaTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsaType_SRRole() {
		return (EReference)isaTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIsaType_SRAgent() {
		return (EReference)isaTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingType() {
		return mappingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_RelatesTo() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_Represents() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_IsA() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_Plays() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_SoDBoDProperties() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_Threats() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipantType() {
		return participantTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipantType_Value() {
		return (EAttribute)participantTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipantType_Country() {
		return (EAttribute)participantTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipantType_Type() {
		return (EAttribute)participantTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPermissionType() {
		return permissionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionType_Mixed() {
		return (EAttribute)permissionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionType_Role() {
		return (EAttribute)permissionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionType_Action() {
		return (EAttribute)permissionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPermissionType_Id() {
		return (EAttribute)permissionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlaysType() {
		return playsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlaysType_BPPart() {
		return (EReference)playsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlaysType_SRRole() {
		return (EReference)playsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelatesToType() {
		return relatesToTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelatesToType_Activity() {
		return (EReference)relatesToTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelatesToType_Goal() {
		return (EReference)relatesToTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepresentsType() {
		return representsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentsType_Variable() {
		return (EReference)representsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentsType_Document() {
		return (EReference)representsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoDBoDType() {
		return soDBoDTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoDBoDType_Mixed() {
		return (EAttribute)soDBoDTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoDBoDType_Permission() {
		return (EAttribute)soDBoDTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoDBoDType_Id() {
		return (EAttribute)soDBoDTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoDBoDType_Type() {
		return (EAttribute)soDBoDTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSoDBoDType_CommitmentID() {
		return (EAttribute)soDBoDTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSRAType() {
		return sraTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSRRType() {
		return srrTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreatsMapping() {
		return threatsMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatsMapping_BPThreat() {
		return (EReference)threatsMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatsMapping_SRThreat() {
		return (EReference)threatsMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreatType() {
		return threatTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_Value() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_Id() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_Name() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_RepositoryID() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarType() {
		return varTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarType_Value() {
		return (EAttribute)varTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarType_Id() {
		return (EAttribute)varTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarType_Order() {
		return (EAttribute)varTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeType() {
		return typeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeType1() {
		return typeType1EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeType2() {
		return typeType2EEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUsertypeType() {
		return usertypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCommitmentIDType() {
		return commitmentIDTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCommitmentIDType1() {
		return commitmentIDType1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeTypeObject() {
		return typeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeTypeObject1() {
		return typeTypeObject1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeTypeObject2() {
		return typeTypeObject2EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUsertypeTypeObject() {
		return usertypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingFactory getMappingFactory() {
		return (MappingFactory)getEFactoryInstance();
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
		activityTypeEClass = createEClass(ACTIVITY_TYPE);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__MIXED);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__VALUE);
		createEReference(activityTypeEClass, ACTIVITY_TYPE__VARIABLE);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__PARTICIPANT);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__TRUSTWORTHINESS);
		createEReference(activityTypeEClass, ACTIVITY_TYPE__INTEGRITY);
		createEReference(activityTypeEClass, ACTIVITY_TYPE__PERMISSION);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__THREAT);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__ID);
		createEAttribute(activityTypeEClass, ACTIVITY_TYPE__USERTYPE);

		activityVarEClass = createEClass(ACTIVITY_VAR);
		createEAttribute(activityVarEClass, ACTIVITY_VAR__MIXED);
		createEReference(activityVarEClass, ACTIVITY_VAR__CONFIDENTIALITY);
		createEAttribute(activityVarEClass, ACTIVITY_VAR__ID);
		createEAttribute(activityVarEClass, ACTIVITY_VAR__TYPE);

		actorTypeEClass = createEClass(ACTOR_TYPE);
		createEAttribute(actorTypeEClass, ACTOR_TYPE__VALUE);
		createEAttribute(actorTypeEClass, ACTOR_TYPE__ID);

		bppTypeEClass = createEClass(BPP_TYPE);
		createEAttribute(bppTypeEClass, BPP_TYPE__ID);

		bprTypeEClass = createEClass(BPR_TYPE);
		createEAttribute(bprTypeEClass, BPR_TYPE__ID);

		confidentialityTypeEClass = createEClass(CONFIDENTIALITY_TYPE);
		createEAttribute(confidentialityTypeEClass, CONFIDENTIALITY_TYPE__VALUE);
		createEAttribute(confidentialityTypeEClass, CONFIDENTIALITY_TYPE__ALGORITHM);
		createEAttribute(confidentialityTypeEClass, CONFIDENTIALITY_TYPE__COMMITMENT_ID);

		docTypeEClass = createEClass(DOC_TYPE);
		createEAttribute(docTypeEClass, DOC_TYPE__VALUE);
		createEAttribute(docTypeEClass, DOC_TYPE__ID);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__MAPPING);

		goalTypeEClass = createEClass(GOAL_TYPE);
		createEAttribute(goalTypeEClass, GOAL_TYPE__VALUE);
		createEAttribute(goalTypeEClass, GOAL_TYPE__ID);

		integrityTypeEClass = createEClass(INTEGRITY_TYPE);
		createEAttribute(integrityTypeEClass, INTEGRITY_TYPE__MIXED);
		createEAttribute(integrityTypeEClass, INTEGRITY_TYPE__WITH);
		createEAttribute(integrityTypeEClass, INTEGRITY_TYPE__TYPE);
		createEAttribute(integrityTypeEClass, INTEGRITY_TYPE__ALGORITHM);
		createEAttribute(integrityTypeEClass, INTEGRITY_TYPE__VARIABLE);

		isaTypeEClass = createEClass(ISA_TYPE);
		createEReference(isaTypeEClass, ISA_TYPE__BP_ROLE);
		createEReference(isaTypeEClass, ISA_TYPE__BP_PART);
		createEReference(isaTypeEClass, ISA_TYPE__SR_ROLE);
		createEReference(isaTypeEClass, ISA_TYPE__SR_AGENT);

		mappingTypeEClass = createEClass(MAPPING_TYPE);
		createEReference(mappingTypeEClass, MAPPING_TYPE__RELATES_TO);
		createEReference(mappingTypeEClass, MAPPING_TYPE__REPRESENTS);
		createEReference(mappingTypeEClass, MAPPING_TYPE__IS_A);
		createEReference(mappingTypeEClass, MAPPING_TYPE__PLAYS);
		createEReference(mappingTypeEClass, MAPPING_TYPE__SO_DBO_DPROPERTIES);
		createEReference(mappingTypeEClass, MAPPING_TYPE__THREATS);

		participantTypeEClass = createEClass(PARTICIPANT_TYPE);
		createEAttribute(participantTypeEClass, PARTICIPANT_TYPE__VALUE);
		createEAttribute(participantTypeEClass, PARTICIPANT_TYPE__COUNTRY);
		createEAttribute(participantTypeEClass, PARTICIPANT_TYPE__TYPE);

		permissionTypeEClass = createEClass(PERMISSION_TYPE);
		createEAttribute(permissionTypeEClass, PERMISSION_TYPE__MIXED);
		createEAttribute(permissionTypeEClass, PERMISSION_TYPE__ROLE);
		createEAttribute(permissionTypeEClass, PERMISSION_TYPE__ACTION);
		createEAttribute(permissionTypeEClass, PERMISSION_TYPE__ID);

		playsTypeEClass = createEClass(PLAYS_TYPE);
		createEReference(playsTypeEClass, PLAYS_TYPE__BP_PART);
		createEReference(playsTypeEClass, PLAYS_TYPE__SR_ROLE);

		relatesToTypeEClass = createEClass(RELATES_TO_TYPE);
		createEReference(relatesToTypeEClass, RELATES_TO_TYPE__ACTIVITY);
		createEReference(relatesToTypeEClass, RELATES_TO_TYPE__GOAL);

		representsTypeEClass = createEClass(REPRESENTS_TYPE);
		createEReference(representsTypeEClass, REPRESENTS_TYPE__VARIABLE);
		createEReference(representsTypeEClass, REPRESENTS_TYPE__DOCUMENT);

		soDBoDTypeEClass = createEClass(SO_DBO_DTYPE);
		createEAttribute(soDBoDTypeEClass, SO_DBO_DTYPE__MIXED);
		createEAttribute(soDBoDTypeEClass, SO_DBO_DTYPE__PERMISSION);
		createEAttribute(soDBoDTypeEClass, SO_DBO_DTYPE__COMMITMENT_ID);
		createEAttribute(soDBoDTypeEClass, SO_DBO_DTYPE__ID);
		createEAttribute(soDBoDTypeEClass, SO_DBO_DTYPE__TYPE);

		sraTypeEClass = createEClass(SRA_TYPE);

		srrTypeEClass = createEClass(SRR_TYPE);

		threatsMappingEClass = createEClass(THREATS_MAPPING);
		createEReference(threatsMappingEClass, THREATS_MAPPING__BP_THREAT);
		createEReference(threatsMappingEClass, THREATS_MAPPING__SR_THREAT);

		threatTypeEClass = createEClass(THREAT_TYPE);
		createEAttribute(threatTypeEClass, THREAT_TYPE__VALUE);
		createEAttribute(threatTypeEClass, THREAT_TYPE__ID);
		createEAttribute(threatTypeEClass, THREAT_TYPE__NAME);
		createEAttribute(threatTypeEClass, THREAT_TYPE__REPOSITORY_ID);

		varTypeEClass = createEClass(VAR_TYPE);
		createEAttribute(varTypeEClass, VAR_TYPE__VALUE);
		createEAttribute(varTypeEClass, VAR_TYPE__ID);
		createEAttribute(varTypeEClass, VAR_TYPE__ORDER);

		// Create enums
		typeTypeEEnum = createEEnum(TYPE_TYPE);
		typeType1EEnum = createEEnum(TYPE_TYPE1);
		typeType2EEnum = createEEnum(TYPE_TYPE2);
		usertypeTypeEEnum = createEEnum(USERTYPE_TYPE);

		// Create data types
		commitmentIDTypeEDataType = createEDataType(COMMITMENT_ID_TYPE);
		commitmentIDType1EDataType = createEDataType(COMMITMENT_ID_TYPE1);
		typeTypeObjectEDataType = createEDataType(TYPE_TYPE_OBJECT);
		typeTypeObject1EDataType = createEDataType(TYPE_TYPE_OBJECT1);
		typeTypeObject2EDataType = createEDataType(TYPE_TYPE_OBJECT2);
		usertypeTypeObjectEDataType = createEDataType(USERTYPE_TYPE_OBJECT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bppTypeEClass.getESuperTypes().add(this.getParticipantType());
		bprTypeEClass.getESuperTypes().add(this.getParticipantType());
		sraTypeEClass.getESuperTypes().add(this.getActorType());
		srrTypeEClass.getESuperTypes().add(this.getActorType());

		// Initialize classes and features; add operations and parameters
		initEClass(activityTypeEClass, ActivityType.class, "ActivityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ActivityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getActivityType_Variable(), this.getActivityVar(), null, "variable", null, 0, -1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Participant(), theXMLTypePackage.getString(), "participant", null, 0, -1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Trustworthiness(), theXMLTypePackage.getFloat(), "trustworthiness", null, 0, 1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getActivityType_Integrity(), this.getIntegrityType(), null, "integrity", null, 0, -1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getActivityType_Permission(), this.getPermissionType(), null, "permission", null, 0, -1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Threat(), theXMLTypePackage.getString(), "threat", null, 0, -1, ActivityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ActivityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityType_Usertype(), this.getUsertypeType(), "usertype", "UserTask", 0, 1, ActivityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activityVarEClass, ActivityVar.class, "ActivityVar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityVar_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, ActivityVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivityVar_Confidentiality(), this.getConfidentialityType(), null, "confidentiality", null, 1, 1, ActivityVar.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityVar_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ActivityVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityVar_Type(), this.getTypeType2(), "type", null, 0, 1, ActivityVar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorTypeEClass, ActorType.class, "ActorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActorType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ActorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActorType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ActorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bppTypeEClass, BPPType.class, "BPPType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBPPType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, BPPType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bprTypeEClass, BPRType.class, "BPRType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBPRType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, BPRType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(confidentialityTypeEClass, ConfidentialityType.class, "ConfidentialityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfidentialityType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ConfidentialityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfidentialityType_Algorithm(), theXMLTypePackage.getString(), "algorithm", null, 0, 1, ConfidentialityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfidentialityType_CommitmentID(), this.getCommitmentIDType1(), "commitmentID", null, 0, 1, ConfidentialityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(docTypeEClass, DocType.class, "DocType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Mapping(), this.getMappingType(), null, "mapping", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(goalTypeEClass, GoalType.class, "GoalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoalType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, GoalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, GoalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integrityTypeEClass, IntegrityType.class, "IntegrityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegrityType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, IntegrityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrityType_With(), theXMLTypePackage.getString(), "with", null, 1, 1, IntegrityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrityType_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, IntegrityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrityType_Algorithm(), theXMLTypePackage.getString(), "algorithm", null, 1, 1, IntegrityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegrityType_Variable(), theXMLTypePackage.getString(), "variable", null, 1, 1, IntegrityType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(isaTypeEClass, IsaType.class, "IsaType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIsaType_BPRole(), this.getBPRType(), null, "bPRole", null, 0, -1, IsaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIsaType_BPPart(), this.getBPPType(), null, "bPPart", null, 0, -1, IsaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIsaType_SRRole(), this.getSRRType(), null, "sRRole", null, 0, -1, IsaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIsaType_SRAgent(), this.getSRAType(), null, "sRAgent", null, 0, -1, IsaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingTypeEClass, MappingType.class, "MappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingType_RelatesTo(), this.getRelatesToType(), null, "relatesTo", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_Represents(), this.getRepresentsType(), null, "represents", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_IsA(), this.getIsaType(), null, "isA", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_Plays(), this.getPlaysType(), null, "plays", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_SoDBoDProperties(), this.getSoDBoDType(), null, "soDBoDProperties", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingType_Threats(), this.getThreatsMapping(), null, "threats", null, 0, -1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(participantTypeEClass, ParticipantType.class, "ParticipantType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParticipantType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ParticipantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParticipantType_Country(), theXMLTypePackage.getString(), "country", null, 0, 1, ParticipantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParticipantType_Type(), this.getTypeType(), "type", "service", 0, 1, ParticipantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permissionTypeEClass, PermissionType.class, "PermissionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermissionType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, PermissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermissionType_Role(), theXMLTypePackage.getString(), "role", null, 1, 1, PermissionType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermissionType_Action(), theXMLTypePackage.getString(), "action", null, 1, 1, PermissionType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermissionType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, PermissionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playsTypeEClass, PlaysType.class, "PlaysType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaysType_BPPart(), this.getBPPType(), null, "bPPart", null, 1, 1, PlaysType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlaysType_SRRole(), this.getSRRType(), null, "sRRole", null, 1, 1, PlaysType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relatesToTypeEClass, RelatesToType.class, "RelatesToType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelatesToType_Activity(), this.getActivityType(), null, "activity", null, 1, 1, RelatesToType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelatesToType_Goal(), this.getGoalType(), null, "goal", null, 1, -1, RelatesToType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(representsTypeEClass, RepresentsType.class, "RepresentsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepresentsType_Variable(), this.getVarType(), null, "variable", null, 1, 1, RepresentsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepresentsType_Document(), this.getDocType(), null, "document", null, 1, -1, RepresentsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(soDBoDTypeEClass, SoDBoDType.class, "SoDBoDType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoDBoDType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, SoDBoDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoDBoDType_Permission(), theXMLTypePackage.getString(), "permission", null, 2, 2, SoDBoDType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoDBoDType_CommitmentID(), this.getCommitmentIDType(), "commitmentID", null, 0, 1, SoDBoDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoDBoDType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, SoDBoDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSoDBoDType_Type(), this.getTypeType1(), "type", "SoD", 0, 1, SoDBoDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sraTypeEClass, SRAType.class, "SRAType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(srrTypeEClass, SRRType.class, "SRRType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(threatsMappingEClass, ThreatsMapping.class, "ThreatsMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatsMapping_BPThreat(), this.getThreatType(), null, "bPThreat", null, 1, 1, ThreatsMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatsMapping_SRThreat(), this.getThreatType(), null, "sRThreat", null, 1, 1, ThreatsMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatTypeEClass, ThreatType.class, "ThreatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThreatType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_RepositoryID(), theXMLTypePackage.getString(), "repositoryID", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varTypeEClass, VarType.class, "VarType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVarType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, VarType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, VarType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarType_Order(), theXMLTypePackage.getInt(), "order", "0", 0, 1, VarType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(typeTypeEEnum, TypeType.class, "TypeType");
		addEEnumLiteral(typeTypeEEnum, TypeType.SERVICE);
		addEEnumLiteral(typeTypeEEnum, TypeType.HUMAN);

		initEEnum(typeType1EEnum, TypeType1.class, "TypeType1");
		addEEnumLiteral(typeType1EEnum, TypeType1.SO_D);
		addEEnumLiteral(typeType1EEnum, TypeType1.BO_D);

		initEEnum(typeType2EEnum, TypeType2.class, "TypeType2");
		addEEnumLiteral(typeType2EEnum, TypeType2.INPUT);
		addEEnumLiteral(typeType2EEnum, TypeType2.OUTPUT);

		initEEnum(usertypeTypeEEnum, UsertypeType.class, "UsertypeType");
		addEEnumLiteral(usertypeTypeEEnum, UsertypeType.USER_TASK);
		addEEnumLiteral(usertypeTypeEEnum, UsertypeType.SERVICE_TASK);

		// Initialize data types
		initEDataType(commitmentIDTypeEDataType, String.class, "CommitmentIDType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(commitmentIDType1EDataType, String.class, "CommitmentIDType1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObjectEDataType, TypeType.class, "TypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObject1EDataType, TypeType1.class, "TypeTypeObject1", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObject2EDataType, TypeType2.class, "TypeTypeObject2", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(usertypeTypeObjectEDataType, UsertypeType.class, "UsertypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });		
		addAnnotation
		  (activityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "activityType",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getActivityType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getActivityType_Value(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Participant(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "participant",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Trustworthiness(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "trustworthiness",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Integrity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "integrity",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Permission(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "permission",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Threat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "threat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityType_Usertype(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "usertype",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (activityVarEClass, 
		   source, 
		   new String[] {
			 "name", "ActivityVar",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getActivityVar_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getActivityVar_Confidentiality(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "confidentiality",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityVar_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActivityVar_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (actorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "actorType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getActorType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getActorType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (bppTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BPPType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getBPPType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (bprTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BPRType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getBPRType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (commitmentIDTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "commitmentID_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "length", "1"
		   });		
		addAnnotation
		  (commitmentIDType1EDataType, 
		   source, 
		   new String[] {
			 "name", "commitmentID_._1_._type",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "length", "1"
		   });		
		addAnnotation
		  (confidentialityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "confidentialityType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getConfidentialityType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getConfidentialityType_Algorithm(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "algorithm",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getConfidentialityType_CommitmentID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "commitmentID",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (docTypeEClass, 
		   source, 
		   new String[] {
			 "name", "docType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getDocType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getDocType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
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
		  (getDocumentRoot_Mapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "mapping",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (goalTypeEClass, 
		   source, 
		   new String[] {
			 "name", "goalType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getGoalType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getGoalType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (integrityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "integrityType",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getIntegrityType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getIntegrityType_With(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "with",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIntegrityType_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIntegrityType_Algorithm(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "algorithm",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIntegrityType_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (isaTypeEClass, 
		   source, 
		   new String[] {
			 "name", "isaType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getIsaType_BPRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BPRole",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIsaType_BPPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BPPart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIsaType_SRRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SRRole",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getIsaType_SRAgent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SRAgent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (mappingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "mapping_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMappingType_RelatesTo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "relatesTo",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMappingType_Represents(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "represents",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMappingType_IsA(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "is-a",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMappingType_Plays(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "plays",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMappingType_SoDBoDProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "soDBoDProperties",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getMappingType_Threats(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "threats",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (participantTypeEClass, 
		   source, 
		   new String[] {
			 "name", "participantType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getParticipantType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getParticipantType_Country(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "country",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getParticipantType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (permissionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "permissionType",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getPermissionType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getPermissionType_Role(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "role",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPermissionType_Action(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "action",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPermissionType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (playsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "playsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPlaysType_BPPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BPPart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPlaysType_SRRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SRRole",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (relatesToTypeEClass, 
		   source, 
		   new String[] {
			 "name", "relatesToType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRelatesToType_Activity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "activity",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRelatesToType_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (representsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "representsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRepresentsType_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRepresentsType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (soDBoDTypeEClass, 
		   source, 
		   new String[] {
			 "name", "soDBoDType",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getSoDBoDType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getSoDBoDType_Permission(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "permission",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSoDBoDType_CommitmentID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "commitmentID",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSoDBoDType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSoDBoDType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (sraTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SRAType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (srrTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SRRType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (threatsMappingEClass, 
		   source, 
		   new String[] {
			 "name", "threatsMapping",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getThreatsMapping_BPThreat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BPThreat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatsMapping_SRThreat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SRThreat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (threatTypeEClass, 
		   source, 
		   new String[] {
			 "name", "threatType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getThreatType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getThreatType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatType_RepositoryID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "repositoryID",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (typeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "type_._type"
		   });		
		addAnnotation
		  (typeType1EEnum, 
		   source, 
		   new String[] {
			 "name", "type_._1_._type"
		   });		
		addAnnotation
		  (typeType2EEnum, 
		   source, 
		   new String[] {
			 "name", "type_._2_._type"
		   });		
		addAnnotation
		  (typeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "type_._type:Object",
			 "baseType", "type_._type"
		   });		
		addAnnotation
		  (typeTypeObject1EDataType, 
		   source, 
		   new String[] {
			 "name", "type_._1_._type:Object",
			 "baseType", "type_._1_._type"
		   });		
		addAnnotation
		  (typeTypeObject2EDataType, 
		   source, 
		   new String[] {
			 "name", "type_._2_._type:Object",
			 "baseType", "type_._2_._type"
		   });		
		addAnnotation
		  (usertypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "usertype_._type"
		   });		
		addAnnotation
		  (usertypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "usertype_._type:Object",
			 "baseType", "usertype_._type"
		   });		
		addAnnotation
		  (varTypeEClass, 
		   source, 
		   new String[] {
			 "name", "varType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getVarType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getVarType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getVarType_Order(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "order",
			 "namespace", "##targetNamespace"
		   });
	}

} //MappingPackageImpl
