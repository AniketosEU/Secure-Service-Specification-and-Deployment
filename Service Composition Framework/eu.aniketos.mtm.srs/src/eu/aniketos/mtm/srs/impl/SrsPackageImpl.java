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

import eu.aniketos.mtm.srs.ActorSetTypeMin2;
import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.AgentType;
import eu.aniketos.mtm.srs.AuthType;
import eu.aniketos.mtm.srs.AuthType1;
import eu.aniketos.mtm.srs.AvailabilityType;
import eu.aniketos.mtm.srs.BoDSoDActorType;
import eu.aniketos.mtm.srs.BoDSoDGoalType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.ConfidentialityType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.DocumentRoot;
import eu.aniketos.mtm.srs.GoalSetType;
import eu.aniketos.mtm.srs.GoalSetTypeMin2;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.InfoDocType;
import eu.aniketos.mtm.srs.InfoSetType;
import eu.aniketos.mtm.srs.InfoType;
import eu.aniketos.mtm.srs.IntegrityType;
import eu.aniketos.mtm.srs.KBType;
import eu.aniketos.mtm.srs.MultiplicityType;
import eu.aniketos.mtm.srs.NDType;
import eu.aniketos.mtm.srs.NRType;
import eu.aniketos.mtm.srs.NTKType;
import eu.aniketos.mtm.srs.OperationSetType;
import eu.aniketos.mtm.srs.OperationType;
import eu.aniketos.mtm.srs.OwnsType;
import eu.aniketos.mtm.srs.PartOfType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.PreType;
import eu.aniketos.mtm.srs.ProvType;
import eu.aniketos.mtm.srs.RedType;
import eu.aniketos.mtm.srs.RoleType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.SrsFactory;
import eu.aniketos.mtm.srs.SrsPackage;
import eu.aniketos.mtm.srs.TangibleByType;
import eu.aniketos.mtm.srs.ThreatListType;
import eu.aniketos.mtm.srs.ThreatType;
import eu.aniketos.mtm.srs.TrustworthinessType;
import eu.aniketos.mtm.srs.TypeType;
import eu.aniketos.mtm.srs.TypeType1;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class SrsPackageImpl extends EPackageImpl implements SrsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorSetTypeMin2EClass = null;

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
	private EClass agentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authType1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availabilityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boDSoDActorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boDSoDGoalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commitmentTypeEClass = null;

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
	private EClass delTypeEClass = null;

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
	private EClass goalSetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalSetTypeMin2EClass = null;

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
	private EClass infoDocTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infoSetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infoTypeEClass = null;

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
	private EClass kbTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ndTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nrTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ntkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationSetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ownsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partOfTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass provTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass secReqSpeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tangibleByTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threatListTypeEClass = null;

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
	private EClass trustworthinessTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplicityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operationTypeEEnum = null;

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
	private EDataType multiplicityTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType operationTypeObjectEDataType = null;

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
	 * @see eu.aniketos.mtm.srs.SrsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SrsPackageImpl() {
		super(eNS_URI, SrsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SrsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SrsPackage init() {
		if (isInited) return (SrsPackage)EPackage.Registry.INSTANCE.getEPackage(SrsPackage.eNS_URI);

		// Obtain or create and register package
		SrsPackageImpl theSrsPackage = (SrsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SrsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SrsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSrsPackage.createPackageContents();

		// Initialize created meta-data
		theSrsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSrsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SrsPackage.eNS_URI, theSrsPackage);
		return theSrsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActorSetTypeMin2() {
		return actorSetTypeMin2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorSetTypeMin2_Role() {
		return (EReference)actorSetTypeMin2EClass.getEStructuralFeatures().get(0);
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
	public EReference getActorType_Agent() {
		return (EReference)actorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActorType_Role() {
		return (EReference)actorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgentType() {
		return agentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentType_Value() {
		return (EAttribute)agentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentType_Id() {
		return (EAttribute)agentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthType() {
		return authTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType_InfoSet() {
		return (EReference)authTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthType1() {
		return authType1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType1_Source() {
		return (EReference)authType1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType1_Destination() {
		return (EReference)authType1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType1_InfoSet() {
		return (EReference)authType1EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType1_ScopeSet() {
		return (EReference)authType1EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthType1_OperationSet() {
		return (EReference)authType1EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAuthType1_Transferable() {
		return (EAttribute)authType1EClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvailabilityType() {
		return availabilityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvailabilityType_Goal() {
		return (EReference)availabilityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvailabilityType_Document() {
		return (EReference)availabilityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAvailabilityType_MinLevel() {
		return (EAttribute)availabilityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoDSoDActorType() {
		return boDSoDActorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoDSoDActorType_ActorSet() {
		return (EReference)boDSoDActorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoDSoDGoalType() {
		return boDSoDGoalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoDSoDGoalType_GoalSet() {
		return (EReference)boDSoDGoalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommitmentType() {
		return commitmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommitmentType_Debtor() {
		return (EReference)commitmentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommitmentType_Creditor() {
		return (EReference)commitmentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommitmentType_Precondition() {
		return (EReference)commitmentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommitmentType_Postcondition() {
		return (EReference)commitmentTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitmentType_Id() {
		return (EAttribute)commitmentTypeEClass.getEStructuralFeatures().get(4);
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
	public EReference getConfidentialityType_Document() {
		return (EReference)confidentialityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelType() {
		return delTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelType_Source() {
		return (EReference)delTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelType_Destination() {
		return (EReference)delTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelType_GoalSet() {
		return (EReference)delTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDelType_Transferable() {
		return (EAttribute)delTypeEClass.getEStructuralFeatures().get(3);
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
	public EReference getDocumentRoot_SecReqSpe() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalSetType() {
		return goalSetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoalSetType_Goal() {
		return (EReference)goalSetTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalSetTypeMin2() {
		return goalSetTypeMin2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoalSetTypeMin2_Goal() {
		return (EReference)goalSetTypeMin2EClass.getEStructuralFeatures().get(0);
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
	public EClass getInfoDocType() {
		return infoDocTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfoDocType_Document() {
		return (EReference)infoDocTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfoDocType_Information() {
		return (EReference)infoDocTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfoSetType() {
		return infoSetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfoSetType_Information() {
		return (EReference)infoSetTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfoType() {
		return infoTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfoType_Value() {
		return (EAttribute)infoTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfoType_Id() {
		return (EAttribute)infoTypeEClass.getEStructuralFeatures().get(1);
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
	public EReference getIntegrityType_Document() {
		return (EReference)integrityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKBType() {
		return kbTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKBType_PartOf() {
		return (EReference)kbTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKBType_TangibleBy() {
		return (EReference)kbTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKBType_Owns() {
		return (EReference)kbTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKBType_FullyAuthorized() {
		return (EReference)kbTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNDType() {
		return ndTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNDType_GoalSet() {
		return (EReference)ndTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNRType() {
		return nrTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNRType_GoalSet() {
		return (EReference)nrTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNRType_Type() {
		return (EAttribute)nrTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNTKType() {
		return ntkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTKType_GoalSet() {
		return (EReference)ntkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationSetType() {
		return operationSetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationSetType_Operation() {
		return (EAttribute)operationSetTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOwnsType() {
		return ownsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOwnsType_Actor() {
		return (EReference)ownsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOwnsType_Information() {
		return (EReference)ownsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartOfType() {
		return partOfTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartOfType_Container() {
		return (EReference)partOfTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartOfType_Content() {
		return (EReference)partOfTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostType() {
		return postTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonDelegation() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonRepudiation() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_Redundancy() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NeedToKnow() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonDisclosure() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonModification() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonUsage() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NonProduction() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_PlayBoth() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NotPlayBoth() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_AchieveInCombination() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_NotAchieveInCombination() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_Integrity() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_Availability() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_Confidentiality() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostType_Delegation() {
		return (EReference)postTypeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreType() {
		return preTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreType_Delegation() {
		return (EReference)preTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreType_Authorization() {
		return (EReference)preTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreType_Provision() {
		return (EReference)preTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreType_Trustworthiness() {
		return (EReference)preTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvType() {
		return provTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvType_Source() {
		return (EReference)provTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvType_Destination() {
		return (EReference)provTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvType_Document() {
		return (EReference)provTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedType() {
		return redTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRedType_GoalSet() {
		return (EReference)redTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedType_Multiplicity() {
		return (EAttribute)redTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRedType_Type() {
		return (EAttribute)redTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleType() {
		return roleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleType_Value() {
		return (EAttribute)roleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRoleType_Id() {
		return (EAttribute)roleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecReqSpeType() {
		return secReqSpeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecReqSpeType_Commitment() {
		return (EReference)secReqSpeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecReqSpeType_KnowledgeBase() {
		return (EReference)secReqSpeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecReqSpeType_ThreatList() {
		return (EReference)secReqSpeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTangibleByType() {
		return tangibleByTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTangibleByType_Information() {
		return (EReference)tangibleByTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTangibleByType_Document() {
		return (EReference)tangibleByTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreatListType() {
		return threatListTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatListType_Threat() {
		return (EReference)threatListTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getThreatType_Actor() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatType_Document() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatType_Goal() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThreatType_Delegation() {
		return (EReference)threatTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_Id() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_Name() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThreatType_RepositoryID() {
		return (EAttribute)threatTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrustworthinessType() {
		return trustworthinessTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustworthinessType_Destination() {
		return (EReference)trustworthinessTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrustworthinessType_Goal() {
		return (EReference)trustworthinessTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTrustworthinessType_MinLevel() {
		return (EAttribute)trustworthinessTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplicityType() {
		return multiplicityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperationType() {
		return operationTypeEEnum;
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
	public EDataType getMultiplicityTypeObject() {
		return multiplicityTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOperationTypeObject() {
		return operationTypeObjectEDataType;
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
	public SrsFactory getSrsFactory() {
		return (SrsFactory)getEFactoryInstance();
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
		actorSetTypeMin2EClass = createEClass(ACTOR_SET_TYPE_MIN2);
		createEReference(actorSetTypeMin2EClass, ACTOR_SET_TYPE_MIN2__ROLE);

		actorTypeEClass = createEClass(ACTOR_TYPE);
		createEReference(actorTypeEClass, ACTOR_TYPE__AGENT);
		createEReference(actorTypeEClass, ACTOR_TYPE__ROLE);

		agentTypeEClass = createEClass(AGENT_TYPE);
		createEAttribute(agentTypeEClass, AGENT_TYPE__VALUE);
		createEAttribute(agentTypeEClass, AGENT_TYPE__ID);

		authTypeEClass = createEClass(AUTH_TYPE);
		createEReference(authTypeEClass, AUTH_TYPE__INFO_SET);

		authType1EClass = createEClass(AUTH_TYPE1);
		createEReference(authType1EClass, AUTH_TYPE1__SOURCE);
		createEReference(authType1EClass, AUTH_TYPE1__DESTINATION);
		createEReference(authType1EClass, AUTH_TYPE1__INFO_SET);
		createEReference(authType1EClass, AUTH_TYPE1__SCOPE_SET);
		createEReference(authType1EClass, AUTH_TYPE1__OPERATION_SET);
		createEAttribute(authType1EClass, AUTH_TYPE1__TRANSFERABLE);

		availabilityTypeEClass = createEClass(AVAILABILITY_TYPE);
		createEReference(availabilityTypeEClass, AVAILABILITY_TYPE__GOAL);
		createEReference(availabilityTypeEClass, AVAILABILITY_TYPE__DOCUMENT);
		createEAttribute(availabilityTypeEClass, AVAILABILITY_TYPE__MIN_LEVEL);

		boDSoDActorTypeEClass = createEClass(BO_DSO_DACTOR_TYPE);
		createEReference(boDSoDActorTypeEClass, BO_DSO_DACTOR_TYPE__ACTOR_SET);

		boDSoDGoalTypeEClass = createEClass(BO_DSO_DGOAL_TYPE);
		createEReference(boDSoDGoalTypeEClass, BO_DSO_DGOAL_TYPE__GOAL_SET);

		commitmentTypeEClass = createEClass(COMMITMENT_TYPE);
		createEReference(commitmentTypeEClass, COMMITMENT_TYPE__DEBTOR);
		createEReference(commitmentTypeEClass, COMMITMENT_TYPE__CREDITOR);
		createEReference(commitmentTypeEClass, COMMITMENT_TYPE__PRECONDITION);
		createEReference(commitmentTypeEClass, COMMITMENT_TYPE__POSTCONDITION);
		createEAttribute(commitmentTypeEClass, COMMITMENT_TYPE__ID);

		confidentialityTypeEClass = createEClass(CONFIDENTIALITY_TYPE);
		createEReference(confidentialityTypeEClass, CONFIDENTIALITY_TYPE__DOCUMENT);

		delTypeEClass = createEClass(DEL_TYPE);
		createEReference(delTypeEClass, DEL_TYPE__SOURCE);
		createEReference(delTypeEClass, DEL_TYPE__DESTINATION);
		createEReference(delTypeEClass, DEL_TYPE__GOAL_SET);
		createEAttribute(delTypeEClass, DEL_TYPE__TRANSFERABLE);

		docTypeEClass = createEClass(DOC_TYPE);
		createEAttribute(docTypeEClass, DOC_TYPE__VALUE);
		createEAttribute(docTypeEClass, DOC_TYPE__ID);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SEC_REQ_SPE);

		goalSetTypeEClass = createEClass(GOAL_SET_TYPE);
		createEReference(goalSetTypeEClass, GOAL_SET_TYPE__GOAL);

		goalSetTypeMin2EClass = createEClass(GOAL_SET_TYPE_MIN2);
		createEReference(goalSetTypeMin2EClass, GOAL_SET_TYPE_MIN2__GOAL);

		goalTypeEClass = createEClass(GOAL_TYPE);
		createEAttribute(goalTypeEClass, GOAL_TYPE__VALUE);
		createEAttribute(goalTypeEClass, GOAL_TYPE__ID);

		infoDocTypeEClass = createEClass(INFO_DOC_TYPE);
		createEReference(infoDocTypeEClass, INFO_DOC_TYPE__DOCUMENT);
		createEReference(infoDocTypeEClass, INFO_DOC_TYPE__INFORMATION);

		infoSetTypeEClass = createEClass(INFO_SET_TYPE);
		createEReference(infoSetTypeEClass, INFO_SET_TYPE__INFORMATION);

		infoTypeEClass = createEClass(INFO_TYPE);
		createEAttribute(infoTypeEClass, INFO_TYPE__VALUE);
		createEAttribute(infoTypeEClass, INFO_TYPE__ID);

		integrityTypeEClass = createEClass(INTEGRITY_TYPE);
		createEReference(integrityTypeEClass, INTEGRITY_TYPE__DOCUMENT);

		kbTypeEClass = createEClass(KB_TYPE);
		createEReference(kbTypeEClass, KB_TYPE__PART_OF);
		createEReference(kbTypeEClass, KB_TYPE__TANGIBLE_BY);
		createEReference(kbTypeEClass, KB_TYPE__OWNS);
		createEReference(kbTypeEClass, KB_TYPE__FULLY_AUTHORIZED);

		ndTypeEClass = createEClass(ND_TYPE);
		createEReference(ndTypeEClass, ND_TYPE__GOAL_SET);

		nrTypeEClass = createEClass(NR_TYPE);
		createEReference(nrTypeEClass, NR_TYPE__GOAL_SET);
		createEAttribute(nrTypeEClass, NR_TYPE__TYPE);

		ntkTypeEClass = createEClass(NTK_TYPE);
		createEReference(ntkTypeEClass, NTK_TYPE__GOAL_SET);

		operationSetTypeEClass = createEClass(OPERATION_SET_TYPE);
		createEAttribute(operationSetTypeEClass, OPERATION_SET_TYPE__OPERATION);

		ownsTypeEClass = createEClass(OWNS_TYPE);
		createEReference(ownsTypeEClass, OWNS_TYPE__ACTOR);
		createEReference(ownsTypeEClass, OWNS_TYPE__INFORMATION);

		partOfTypeEClass = createEClass(PART_OF_TYPE);
		createEReference(partOfTypeEClass, PART_OF_TYPE__CONTAINER);
		createEReference(partOfTypeEClass, PART_OF_TYPE__CONTENT);

		postTypeEClass = createEClass(POST_TYPE);
		createEReference(postTypeEClass, POST_TYPE__NON_DELEGATION);
		createEReference(postTypeEClass, POST_TYPE__NON_REPUDIATION);
		createEReference(postTypeEClass, POST_TYPE__REDUNDANCY);
		createEReference(postTypeEClass, POST_TYPE__NEED_TO_KNOW);
		createEReference(postTypeEClass, POST_TYPE__NON_DISCLOSURE);
		createEReference(postTypeEClass, POST_TYPE__NON_MODIFICATION);
		createEReference(postTypeEClass, POST_TYPE__NON_USAGE);
		createEReference(postTypeEClass, POST_TYPE__NON_PRODUCTION);
		createEReference(postTypeEClass, POST_TYPE__PLAY_BOTH);
		createEReference(postTypeEClass, POST_TYPE__NOT_PLAY_BOTH);
		createEReference(postTypeEClass, POST_TYPE__ACHIEVE_IN_COMBINATION);
		createEReference(postTypeEClass, POST_TYPE__NOT_ACHIEVE_IN_COMBINATION);
		createEReference(postTypeEClass, POST_TYPE__INTEGRITY);
		createEReference(postTypeEClass, POST_TYPE__AVAILABILITY);
		createEReference(postTypeEClass, POST_TYPE__CONFIDENTIALITY);
		createEReference(postTypeEClass, POST_TYPE__DELEGATION);

		preTypeEClass = createEClass(PRE_TYPE);
		createEReference(preTypeEClass, PRE_TYPE__DELEGATION);
		createEReference(preTypeEClass, PRE_TYPE__AUTHORIZATION);
		createEReference(preTypeEClass, PRE_TYPE__PROVISION);
		createEReference(preTypeEClass, PRE_TYPE__TRUSTWORTHINESS);

		provTypeEClass = createEClass(PROV_TYPE);
		createEReference(provTypeEClass, PROV_TYPE__SOURCE);
		createEReference(provTypeEClass, PROV_TYPE__DESTINATION);
		createEReference(provTypeEClass, PROV_TYPE__DOCUMENT);

		redTypeEClass = createEClass(RED_TYPE);
		createEReference(redTypeEClass, RED_TYPE__GOAL_SET);
		createEAttribute(redTypeEClass, RED_TYPE__MULTIPLICITY);
		createEAttribute(redTypeEClass, RED_TYPE__TYPE);

		roleTypeEClass = createEClass(ROLE_TYPE);
		createEAttribute(roleTypeEClass, ROLE_TYPE__VALUE);
		createEAttribute(roleTypeEClass, ROLE_TYPE__ID);

		secReqSpeTypeEClass = createEClass(SEC_REQ_SPE_TYPE);
		createEReference(secReqSpeTypeEClass, SEC_REQ_SPE_TYPE__COMMITMENT);
		createEReference(secReqSpeTypeEClass, SEC_REQ_SPE_TYPE__KNOWLEDGE_BASE);
		createEReference(secReqSpeTypeEClass, SEC_REQ_SPE_TYPE__THREAT_LIST);

		tangibleByTypeEClass = createEClass(TANGIBLE_BY_TYPE);
		createEReference(tangibleByTypeEClass, TANGIBLE_BY_TYPE__INFORMATION);
		createEReference(tangibleByTypeEClass, TANGIBLE_BY_TYPE__DOCUMENT);

		threatListTypeEClass = createEClass(THREAT_LIST_TYPE);
		createEReference(threatListTypeEClass, THREAT_LIST_TYPE__THREAT);

		threatTypeEClass = createEClass(THREAT_TYPE);
		createEReference(threatTypeEClass, THREAT_TYPE__ACTOR);
		createEReference(threatTypeEClass, THREAT_TYPE__DOCUMENT);
		createEReference(threatTypeEClass, THREAT_TYPE__GOAL);
		createEReference(threatTypeEClass, THREAT_TYPE__DELEGATION);
		createEAttribute(threatTypeEClass, THREAT_TYPE__ID);
		createEAttribute(threatTypeEClass, THREAT_TYPE__NAME);
		createEAttribute(threatTypeEClass, THREAT_TYPE__REPOSITORY_ID);

		trustworthinessTypeEClass = createEClass(TRUSTWORTHINESS_TYPE);
		createEReference(trustworthinessTypeEClass, TRUSTWORTHINESS_TYPE__DESTINATION);
		createEReference(trustworthinessTypeEClass, TRUSTWORTHINESS_TYPE__GOAL);
		createEAttribute(trustworthinessTypeEClass, TRUSTWORTHINESS_TYPE__MIN_LEVEL);

		// Create enums
		multiplicityTypeEEnum = createEEnum(MULTIPLICITY_TYPE);
		operationTypeEEnum = createEEnum(OPERATION_TYPE);
		typeTypeEEnum = createEEnum(TYPE_TYPE);
		typeType1EEnum = createEEnum(TYPE_TYPE1);

		// Create data types
		multiplicityTypeObjectEDataType = createEDataType(MULTIPLICITY_TYPE_OBJECT);
		operationTypeObjectEDataType = createEDataType(OPERATION_TYPE_OBJECT);
		typeTypeObjectEDataType = createEDataType(TYPE_TYPE_OBJECT);
		typeTypeObject1EDataType = createEDataType(TYPE_TYPE_OBJECT1);
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

		// Initialize classes and features; add operations and parameters
		initEClass(actorSetTypeMin2EClass, ActorSetTypeMin2.class, "ActorSetTypeMin2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorSetTypeMin2_Role(), this.getRoleType(), null, "role", null, 2, -1, ActorSetTypeMin2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorTypeEClass, ActorType.class, "ActorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActorType_Agent(), this.getAgentType(), null, "agent", null, 0, 1, ActorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActorType_Role(), this.getRoleType(), null, "role", null, 0, 1, ActorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentTypeEClass, AgentType.class, "AgentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAgentType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, AgentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, AgentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(authTypeEClass, AuthType.class, "AuthType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAuthType_InfoSet(), this.getInfoSetType(), null, "infoSet", null, 1, 1, AuthType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(authType1EClass, AuthType1.class, "AuthType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAuthType1_Source(), this.getActorType(), null, "source", null, 1, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthType1_Destination(), this.getActorType(), null, "destination", null, 1, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthType1_InfoSet(), this.getInfoSetType(), null, "infoSet", null, 1, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthType1_ScopeSet(), this.getGoalSetType(), null, "scopeSet", null, 0, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAuthType1_OperationSet(), this.getOperationSetType(), null, "operationSet", null, 1, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAuthType1_Transferable(), theXMLTypePackage.getString(), "transferable", null, 1, 1, AuthType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(availabilityTypeEClass, AvailabilityType.class, "AvailabilityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAvailabilityType_Goal(), this.getGoalType(), null, "goal", null, 0, 1, AvailabilityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAvailabilityType_Document(), this.getDocType(), null, "document", null, 0, 1, AvailabilityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvailabilityType_MinLevel(), theXMLTypePackage.getString(), "minLevel", null, 1, 1, AvailabilityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boDSoDActorTypeEClass, BoDSoDActorType.class, "BoDSoDActorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoDSoDActorType_ActorSet(), this.getActorSetTypeMin2(), null, "actorSet", null, 1, 1, BoDSoDActorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boDSoDGoalTypeEClass, BoDSoDGoalType.class, "BoDSoDGoalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoDSoDGoalType_GoalSet(), this.getGoalSetTypeMin2(), null, "goalSet", null, 1, 1, BoDSoDGoalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commitmentTypeEClass, CommitmentType.class, "CommitmentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommitmentType_Debtor(), this.getActorType(), null, "debtor", null, 1, 1, CommitmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommitmentType_Creditor(), this.getActorType(), null, "creditor", null, 1, 1, CommitmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommitmentType_Precondition(), this.getPreType(), null, "precondition", null, 0, 1, CommitmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommitmentType_Postcondition(), this.getPostType(), null, "postcondition", null, 1, 1, CommitmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommitmentType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, CommitmentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(confidentialityTypeEClass, ConfidentialityType.class, "ConfidentialityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfidentialityType_Document(), this.getDocType(), null, "document", null, 1, 1, ConfidentialityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(delTypeEClass, DelType.class, "DelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelType_Source(), this.getActorType(), null, "source", null, 1, 1, DelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelType_Destination(), this.getActorType(), null, "destination", null, 1, 1, DelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelType_GoalSet(), this.getGoalSetType(), null, "goalSet", null, 1, 1, DelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDelType_Transferable(), theXMLTypePackage.getString(), "transferable", null, 1, 1, DelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(docTypeEClass, DocType.class, "DocType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SecReqSpe(), this.getSecReqSpeType(), null, "secReqSpe", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(goalSetTypeEClass, GoalSetType.class, "GoalSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoalSetType_Goal(), this.getGoalType(), null, "goal", null, 1, -1, GoalSetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalSetTypeMin2EClass, GoalSetTypeMin2.class, "GoalSetTypeMin2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoalSetTypeMin2_Goal(), this.getGoalType(), null, "goal", null, 2, -1, GoalSetTypeMin2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalTypeEClass, GoalType.class, "GoalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoalType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, GoalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, GoalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(infoDocTypeEClass, InfoDocType.class, "InfoDocType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInfoDocType_Document(), this.getDocType(), null, "document", null, 0, 1, InfoDocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInfoDocType_Information(), this.getInfoType(), null, "information", null, 0, 1, InfoDocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(infoSetTypeEClass, InfoSetType.class, "InfoSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInfoSetType_Information(), this.getInfoType(), null, "information", null, 1, -1, InfoSetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(infoTypeEClass, InfoType.class, "InfoType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInfoType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, InfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInfoType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, InfoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integrityTypeEClass, IntegrityType.class, "IntegrityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegrityType_Document(), this.getDocType(), null, "document", null, 1, 1, IntegrityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(kbTypeEClass, KBType.class, "KBType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKBType_PartOf(), this.getPartOfType(), null, "partOf", null, 0, -1, KBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKBType_TangibleBy(), this.getTangibleByType(), null, "tangibleBy", null, 0, -1, KBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKBType_Owns(), this.getOwnsType(), null, "owns", null, 0, -1, KBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKBType_FullyAuthorized(), this.getOwnsType(), null, "fullyAuthorized", null, 0, -1, KBType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ndTypeEClass, NDType.class, "NDType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNDType_GoalSet(), this.getGoalSetType(), null, "goalSet", null, 1, 1, NDType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nrTypeEClass, NRType.class, "NRType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNRType_GoalSet(), this.getGoalSetType(), null, "goalSet", null, 1, 1, NRType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNRType_Type(), this.getTypeType1(), "type", null, 1, 1, NRType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ntkTypeEClass, NTKType.class, "NTKType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNTKType_GoalSet(), this.getGoalSetType(), null, "goalSet", null, 1, 1, NTKType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationSetTypeEClass, OperationSetType.class, "OperationSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationSetType_Operation(), this.getOperationType(), "operation", null, 0, 4, OperationSetType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ownsTypeEClass, OwnsType.class, "OwnsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOwnsType_Actor(), this.getActorType(), null, "actor", null, 1, 1, OwnsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOwnsType_Information(), this.getInfoType(), null, "information", null, 1, 1, OwnsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partOfTypeEClass, PartOfType.class, "PartOfType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartOfType_Container(), this.getInfoDocType(), null, "container", null, 1, 1, PartOfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartOfType_Content(), this.getInfoDocType(), null, "content", null, 1, 1, PartOfType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postTypeEClass, PostType.class, "PostType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPostType_NonDelegation(), this.getNDType(), null, "nonDelegation", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NonRepudiation(), this.getNRType(), null, "nonRepudiation", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_Redundancy(), this.getRedType(), null, "redundancy", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NeedToKnow(), this.getNTKType(), null, "needToKnow", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NonDisclosure(), this.getAuthType(), null, "nonDisclosure", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NonModification(), this.getAuthType(), null, "nonModification", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NonUsage(), this.getAuthType(), null, "nonUsage", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NonProduction(), this.getAuthType(), null, "nonProduction", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_PlayBoth(), this.getBoDSoDActorType(), null, "playBoth", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NotPlayBoth(), this.getBoDSoDActorType(), null, "notPlayBoth", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_AchieveInCombination(), this.getBoDSoDGoalType(), null, "achieveInCombination", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_NotAchieveInCombination(), this.getBoDSoDGoalType(), null, "notAchieveInCombination", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_Integrity(), this.getIntegrityType(), null, "integrity", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_Availability(), this.getAvailabilityType(), null, "availability", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_Confidentiality(), this.getConfidentialityType(), null, "confidentiality", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPostType_Delegation(), this.getDelType(), null, "delegation", null, 0, 1, PostType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(preTypeEClass, PreType.class, "PreType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreType_Delegation(), this.getDelType(), null, "delegation", null, 0, 1, PreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreType_Authorization(), this.getAuthType1(), null, "authorization", null, 0, 1, PreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreType_Provision(), this.getProvType(), null, "provision", null, 0, 1, PreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreType_Trustworthiness(), this.getTrustworthinessType(), null, "trustworthiness", null, 0, 1, PreType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(provTypeEClass, ProvType.class, "ProvType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvType_Source(), this.getActorType(), null, "source", null, 1, 1, ProvType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProvType_Destination(), this.getActorType(), null, "destination", null, 1, 1, ProvType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProvType_Document(), this.getDocType(), null, "document", null, 1, 1, ProvType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(redTypeEClass, RedType.class, "RedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRedType_GoalSet(), this.getGoalSetType(), null, "goalSet", null, 1, 1, RedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedType_Multiplicity(), this.getMultiplicityType(), "multiplicity", null, 1, 1, RedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRedType_Type(), this.getTypeType(), "type", null, 1, 1, RedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleTypeEClass, RoleType.class, "RoleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRoleType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, RoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRoleType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, RoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(secReqSpeTypeEClass, SecReqSpeType.class, "SecReqSpeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSecReqSpeType_Commitment(), this.getCommitmentType(), null, "commitment", null, 0, -1, SecReqSpeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecReqSpeType_KnowledgeBase(), this.getKBType(), null, "knowledgeBase", null, 1, 1, SecReqSpeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecReqSpeType_ThreatList(), this.getThreatListType(), null, "threatList", null, 0, 1, SecReqSpeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tangibleByTypeEClass, TangibleByType.class, "TangibleByType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTangibleByType_Information(), this.getInfoType(), null, "information", null, 1, 1, TangibleByType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTangibleByType_Document(), this.getDocType(), null, "document", null, 1, 1, TangibleByType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatListTypeEClass, ThreatListType.class, "ThreatListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatListType_Threat(), this.getThreatType(), null, "threat", null, 1, -1, ThreatListType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threatTypeEClass, ThreatType.class, "ThreatType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThreatType_Actor(), this.getActorType(), null, "actor", null, 0, -1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatType_Document(), this.getDocType(), null, "document", null, 0, -1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatType_Goal(), this.getGoalType(), null, "goal", null, 0, -1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThreatType_Delegation(), this.getDelType(), null, "delegation", null, 0, -1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThreatType_RepositoryID(), theXMLTypePackage.getString(), "repositoryID", null, 0, 1, ThreatType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trustworthinessTypeEClass, TrustworthinessType.class, "TrustworthinessType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrustworthinessType_Destination(), this.getActorType(), null, "destination", null, 1, 1, TrustworthinessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrustworthinessType_Goal(), this.getGoalType(), null, "goal", null, 1, 1, TrustworthinessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTrustworthinessType_MinLevel(), theXMLTypePackage.getString(), "minLevel", null, 1, 1, TrustworthinessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(multiplicityTypeEEnum, MultiplicityType.class, "MultiplicityType");
		addEEnumLiteral(multiplicityTypeEEnum, MultiplicityType.SINGLE_ACTOR);
		addEEnumLiteral(multiplicityTypeEEnum, MultiplicityType.MULTI_ACTOR);

		initEEnum(operationTypeEEnum, OperationType.class, "OperationType");
		addEEnumLiteral(operationTypeEEnum, OperationType.USE);
		addEEnumLiteral(operationTypeEEnum, OperationType.MODIFY);
		addEEnumLiteral(operationTypeEEnum, OperationType.PRODUCE);
		addEEnumLiteral(operationTypeEEnum, OperationType.DISTRIBUTE);

		initEEnum(typeTypeEEnum, TypeType.class, "TypeType");
		addEEnumLiteral(typeTypeEEnum, TypeType.FALLBACK);
		addEEnumLiteral(typeTypeEEnum, TypeType.TRUE);

		initEEnum(typeType1EEnum, TypeType1.class, "TypeType1");
		addEEnumLiteral(typeType1EEnum, TypeType1.DELEGATION);
		addEEnumLiteral(typeType1EEnum, TypeType1.ACCEPTANCE);

		// Initialize data types
		initEDataType(multiplicityTypeObjectEDataType, MultiplicityType.class, "MultiplicityTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(operationTypeObjectEDataType, OperationType.class, "OperationTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObjectEDataType, TypeType.class, "TypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObject1EDataType, TypeType1.class, "TypeTypeObject1", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
		  (actorSetTypeMin2EClass, 
		   source, 
		   new String[] {
			 "name", "actorSetType_min2",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActorSetTypeMin2_Role(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "role",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (actorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "actorType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getActorType_Agent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "agent",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getActorType_Role(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "role",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (agentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "agentType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getAgentType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getAgentType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (authTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AuthType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAuthType_InfoSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "infoSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (authType1EClass, 
		   source, 
		   new String[] {
			 "name", "authType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAuthType1_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAuthType1_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAuthType1_InfoSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "infoSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAuthType1_ScopeSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scopeSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAuthType1_OperationSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operationSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAuthType1_Transferable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transferable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (availabilityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "availabilityType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAvailabilityType_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAvailabilityType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAvailabilityType_MinLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minLevel",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (boDSoDActorTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BoD_SoD_actor_Type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBoDSoDActorType_ActorSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actorSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (boDSoDGoalTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BoD_SoD_goal_Type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBoDSoDGoalType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (commitmentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "commitmentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCommitmentType_Debtor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "debtor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCommitmentType_Creditor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "creditor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCommitmentType_Precondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "precondition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCommitmentType_Postcondition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "postcondition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getCommitmentType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (confidentialityTypeEClass, 
		   source, 
		   new String[] {
			 "name", "confidentialityType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getConfidentialityType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (delTypeEClass, 
		   source, 
		   new String[] {
			 "name", "delType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDelType_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDelType_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDelType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDelType_Transferable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "transferable",
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
		  (getDocumentRoot_SecReqSpe(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "secReqSpe",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (goalSetTypeEClass, 
		   source, 
		   new String[] {
			 "name", "goalSetType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGoalSetType_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (goalSetTypeMin2EClass, 
		   source, 
		   new String[] {
			 "name", "goalSetType_min2",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getGoalSetTypeMin2_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
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
		  (infoDocTypeEClass, 
		   source, 
		   new String[] {
			 "name", "info_docType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInfoDocType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getInfoDocType_Information(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "information",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (infoSetTypeEClass, 
		   source, 
		   new String[] {
			 "name", "infoSetType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInfoSetType_Information(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "information",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (infoTypeEClass, 
		   source, 
		   new String[] {
			 "name", "infoType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getInfoType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getInfoType_Id(), 
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
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getIntegrityType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (kbTypeEClass, 
		   source, 
		   new String[] {
			 "name", "KBType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getKBType_PartOf(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partOf",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getKBType_TangibleBy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tangibleBy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getKBType_Owns(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "owns",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getKBType_FullyAuthorized(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fullyAuthorized",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (multiplicityTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "multiplicity_._type"
		   });		
		addAnnotation
		  (multiplicityTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "multiplicity_._type:Object",
			 "baseType", "multiplicity_._type"
		   });		
		addAnnotation
		  (ndTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NDType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getNDType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (nrTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NRType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getNRType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getNRType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ntkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NTKType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getNTKType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (operationSetTypeEClass, 
		   source, 
		   new String[] {
			 "name", "operationSetType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOperationSetType_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (operationTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "operationType"
		   });		
		addAnnotation
		  (operationTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "operationType:Object",
			 "baseType", "operationType"
		   });		
		addAnnotation
		  (ownsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ownsType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOwnsType_Actor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOwnsType_Information(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "information",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (partOfTypeEClass, 
		   source, 
		   new String[] {
			 "name", "partOfType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPartOfType_Container(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "container",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPartOfType_Content(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "content",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (postTypeEClass, 
		   source, 
		   new String[] {
			 "name", "postType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPostType_NonDelegation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-delegation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NonRepudiation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-repudiation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_Redundancy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "redundancy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NeedToKnow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "needToKnow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NonDisclosure(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-disclosure",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NonModification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-modification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NonUsage(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-usage",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NonProduction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "non-production",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_PlayBoth(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "play-both",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NotPlayBoth(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "not-play-both",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_AchieveInCombination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "achieve-in-combination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_NotAchieveInCombination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "not-achieve-in-combination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_Integrity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "integrity",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_Availability(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "availability",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_Confidentiality(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "confidentiality",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPostType_Delegation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delegation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (preTypeEClass, 
		   source, 
		   new String[] {
			 "name", "preType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPreType_Delegation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delegation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPreType_Authorization(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "authorization",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPreType_Provision(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "provision",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPreType_Trustworthiness(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "trustworthiness",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (provTypeEClass, 
		   source, 
		   new String[] {
			 "name", "provType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProvType_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProvType_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProvType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (redTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RedType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRedType_GoalSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goalSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRedType_Multiplicity(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "multiplicity",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRedType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (roleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "roleType",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getRoleType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });		
		addAnnotation
		  (getRoleType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (secReqSpeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "secReqSpe_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getSecReqSpeType_Commitment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "commitment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSecReqSpeType_KnowledgeBase(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "knowledgeBase",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getSecReqSpeType_ThreatList(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "threatList",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tangibleByTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tangibleByType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTangibleByType_Information(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "information",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTangibleByType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (threatListTypeEClass, 
		   source, 
		   new String[] {
			 "name", "threatListType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getThreatListType_Threat(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "threat",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (threatTypeEClass, 
		   source, 
		   new String[] {
			 "name", "threatType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getThreatType_Actor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "actor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatType_Document(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "document",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatType_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getThreatType_Delegation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delegation",
			 "namespace", "##targetNamespace"
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
		  (trustworthinessTypeEClass, 
		   source, 
		   new String[] {
			 "name", "trustworthinessType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTrustworthinessType_Destination(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "destination",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTrustworthinessType_Goal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "goal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTrustworthinessType_MinLevel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "minLevel",
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
	}

} //SrsPackageImpl
