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
 * A representation of the model object '<em><b>Isa Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.IsaType#getBPRole <em>BP Role</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.IsaType#getBPPart <em>BP Part</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.IsaType#getSRRole <em>SR Role</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.IsaType#getSRAgent <em>SR Agent</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.mapping.MappingPackage#getIsaType()
 * @model extendedMetaData="name='isaType' kind='elementOnly'"
 * @generated
 */
public interface IsaType extends EObject {
	/**
	 * Returns the value of the '<em><b>BP Role</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.BPRType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BP Role</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BP Role</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getIsaType_BPRole()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BPRole' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BPRType> getBPRole();

	/**
	 * Returns the value of the '<em><b>BP Part</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.BPPType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BP Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BP Part</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getIsaType_BPPart()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BPPart' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BPPType> getBPPart();

	/**
	 * Returns the value of the '<em><b>SR Role</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.SRRType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SR Role</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SR Role</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getIsaType_SRRole()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SRRole' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SRRType> getSRRole();

	/**
	 * Returns the value of the '<em><b>SR Agent</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.SRAType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SR Agent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SR Agent</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getIsaType_SRAgent()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='SRAgent' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SRAType> getSRAgent();

} // IsaType
