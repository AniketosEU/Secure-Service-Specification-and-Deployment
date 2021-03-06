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
package eu.aniketos.mtm.srs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>KB Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.KBType#getPartOf <em>Part Of</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.KBType#getTangibleBy <em>Tangible By</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.KBType#getOwns <em>Owns</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.KBType#getFullyAuthorized <em>Fully Authorized</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getKBType()
 * @model extendedMetaData="name='KBType' kind='elementOnly'"
 * @generated
 */
public interface KBType extends EObject {
	/**
	 * Returns the value of the '<em><b>Part Of</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.srs.PartOfType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of</em>' containment reference list.
	 * @see eu.aniketos.mtm.srs.SrsPackage#getKBType_PartOf()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='partOf' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PartOfType> getPartOf();

	/**
	 * Returns the value of the '<em><b>Tangible By</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.srs.TangibleByType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tangible By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tangible By</em>' containment reference list.
	 * @see eu.aniketos.mtm.srs.SrsPackage#getKBType_TangibleBy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='tangibleBy' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TangibleByType> getTangibleBy();

	/**
	 * Returns the value of the '<em><b>Owns</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.srs.OwnsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns</em>' containment reference list.
	 * @see eu.aniketos.mtm.srs.SrsPackage#getKBType_Owns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='owns' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OwnsType> getOwns();

	/**
	 * Returns the value of the '<em><b>Fully Authorized</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.srs.OwnsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fully Authorized</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fully Authorized</em>' containment reference list.
	 * @see eu.aniketos.mtm.srs.SrsPackage#getKBType_FullyAuthorized()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fullyAuthorized' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OwnsType> getFullyAuthorized();

} // KBType
