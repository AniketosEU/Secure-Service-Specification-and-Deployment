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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getRelatesTo <em>Relates To</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getRepresents <em>Represents</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getIsA <em>Is A</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getPlays <em>Plays</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getSoDBoDProperties <em>So DBo DProperties</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.MappingType#getThreats <em>Threats</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType()
 * @model extendedMetaData="name='mapping_._type' kind='elementOnly'"
 * @generated
 */
public interface MappingType extends EObject {
	/**
	 * Returns the value of the '<em><b>Relates To</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.RelatesToType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relates To</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relates To</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_RelatesTo()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='relatesTo' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RelatesToType> getRelatesTo();

	/**
	 * Returns the value of the '<em><b>Represents</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.RepresentsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represents</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_Represents()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='represents' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<RepresentsType> getRepresents();

	/**
	 * Returns the value of the '<em><b>Is A</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.IsaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is A</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_IsA()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='is-a' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IsaType> getIsA();

	/**
	 * Returns the value of the '<em><b>Plays</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.PlaysType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plays</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plays</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_Plays()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='plays' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PlaysType> getPlays();

	/**
	 * Returns the value of the '<em><b>So DBo DProperties</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.SoDBoDType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>So DBo DProperties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>So DBo DProperties</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_SoDBoDProperties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='soDBoDProperties' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SoDBoDType> getSoDBoDProperties();

	/**
	 * Returns the value of the '<em><b>Threats</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.ThreatsMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threats</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threats</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getMappingType_Threats()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='threats' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ThreatsMapping> getThreats();

} // MappingType
