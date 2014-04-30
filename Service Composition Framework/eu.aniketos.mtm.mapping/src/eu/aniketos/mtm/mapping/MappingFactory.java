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
package eu.aniketos.mtm.mapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.aniketos.mtm.mapping.MappingPackage
 * @generated
 */
public interface MappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingFactory eINSTANCE = eu.aniketos.mtm.mapping.impl.MappingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Activity Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Type</em>'.
	 * @generated
	 */
	ActivityType createActivityType();

	/**
	 * Returns a new object of class '<em>Activity Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Var</em>'.
	 * @generated
	 */
	ActivityVar createActivityVar();

	/**
	 * Returns a new object of class '<em>Actor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actor Type</em>'.
	 * @generated
	 */
	ActorType createActorType();

	/**
	 * Returns a new object of class '<em>BPP Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BPP Type</em>'.
	 * @generated
	 */
	BPPType createBPPType();

	/**
	 * Returns a new object of class '<em>BPR Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>BPR Type</em>'.
	 * @generated
	 */
	BPRType createBPRType();

	/**
	 * Returns a new object of class '<em>Confidentiality Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Confidentiality Type</em>'.
	 * @generated
	 */
	ConfidentialityType createConfidentialityType();

	/**
	 * Returns a new object of class '<em>Doc Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Doc Type</em>'.
	 * @generated
	 */
	DocType createDocType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Goal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Goal Type</em>'.
	 * @generated
	 */
	GoalType createGoalType();

	/**
	 * Returns a new object of class '<em>Integrity Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integrity Type</em>'.
	 * @generated
	 */
	IntegrityType createIntegrityType();

	/**
	 * Returns a new object of class '<em>Isa Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Isa Type</em>'.
	 * @generated
	 */
	IsaType createIsaType();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	MappingType createMappingType();

	/**
	 * Returns a new object of class '<em>Participant Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Participant Type</em>'.
	 * @generated
	 */
	ParticipantType createParticipantType();

	/**
	 * Returns a new object of class '<em>Permission Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Permission Type</em>'.
	 * @generated
	 */
	PermissionType createPermissionType();

	/**
	 * Returns a new object of class '<em>Plays Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plays Type</em>'.
	 * @generated
	 */
	PlaysType createPlaysType();

	/**
	 * Returns a new object of class '<em>Relates To Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relates To Type</em>'.
	 * @generated
	 */
	RelatesToType createRelatesToType();

	/**
	 * Returns a new object of class '<em>Represents Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Represents Type</em>'.
	 * @generated
	 */
	RepresentsType createRepresentsType();

	/**
	 * Returns a new object of class '<em>So DBo DType</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>So DBo DType</em>'.
	 * @generated
	 */
	SoDBoDType createSoDBoDType();

	/**
	 * Returns a new object of class '<em>SRA Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SRA Type</em>'.
	 * @generated
	 */
	SRAType createSRAType();

	/**
	 * Returns a new object of class '<em>SRR Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SRR Type</em>'.
	 * @generated
	 */
	SRRType createSRRType();

	/**
	 * Returns a new object of class '<em>Threats Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threats Mapping</em>'.
	 * @generated
	 */
	ThreatsMapping createThreatsMapping();

	/**
	 * Returns a new object of class '<em>Threat Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threat Type</em>'.
	 * @generated
	 */
	ThreatType createThreatType();

	/**
	 * Returns a new object of class '<em>Var Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Type</em>'.
	 * @generated
	 */
	VarType createVarType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MappingPackage getMappingPackage();

} //MappingFactory
