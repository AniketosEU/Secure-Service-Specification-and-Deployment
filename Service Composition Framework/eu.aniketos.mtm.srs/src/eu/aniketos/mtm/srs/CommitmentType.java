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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commitment Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.CommitmentType#getDebtor <em>Debtor</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.CommitmentType#getCreditor <em>Creditor</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.CommitmentType#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.CommitmentType#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.CommitmentType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType()
 * @model extendedMetaData="name='commitmentType' kind='elementOnly'"
 * @generated
 */
public interface CommitmentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Debtor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Debtor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debtor</em>' containment reference.
	 * @see #setDebtor(ActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType_Debtor()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='debtor' namespace='##targetNamespace'"
	 * @generated
	 */
	ActorType getDebtor();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.CommitmentType#getDebtor <em>Debtor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debtor</em>' containment reference.
	 * @see #getDebtor()
	 * @generated
	 */
	void setDebtor(ActorType value);

	/**
	 * Returns the value of the '<em><b>Creditor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creditor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creditor</em>' containment reference.
	 * @see #setCreditor(ActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType_Creditor()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='creditor' namespace='##targetNamespace'"
	 * @generated
	 */
	ActorType getCreditor();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.CommitmentType#getCreditor <em>Creditor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creditor</em>' containment reference.
	 * @see #getCreditor()
	 * @generated
	 */
	void setCreditor(ActorType value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' containment reference.
	 * @see #setPrecondition(PreType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType_Precondition()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='precondition' namespace='##targetNamespace'"
	 * @generated
	 */
	PreType getPrecondition();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.CommitmentType#getPrecondition <em>Precondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' containment reference.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(PreType value);

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' containment reference.
	 * @see #setPostcondition(PostType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType_Postcondition()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='postcondition' namespace='##targetNamespace'"
	 * @generated
	 */
	PostType getPostcondition();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.CommitmentType#getPostcondition <em>Postcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcondition</em>' containment reference.
	 * @see #getPostcondition()
	 * @generated
	 */
	void setPostcondition(PostType value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getCommitmentType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.CommitmentType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // CommitmentType
