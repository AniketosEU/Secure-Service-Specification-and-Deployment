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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integrity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGuardedSender <em>Guarded Sender</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getProcessingService <em>Processing Service</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGeneratingService <em>Generating Service</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getIntegrity()
 * @model
 * @generated
 */
public interface Integrity extends Policy {
	/**
	 * Returns the value of the '<em><b>Guarded Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guarded Sender</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guarded Sender</em>' attribute.
	 * @see #setGuardedSender(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getIntegrity_GuardedSender()
	 * @model required="true"
	 * @generated
	 */
	String getGuardedSender();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGuardedSender <em>Guarded Sender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guarded Sender</em>' attribute.
	 * @see #getGuardedSender()
	 * @generated
	 */
	void setGuardedSender(String value);

	/**
	 * Returns the value of the '<em><b>Processing Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Service</em>' attribute.
	 * @see #setProcessingService(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getIntegrity_ProcessingService()
	 * @model required="true"
	 * @generated
	 */
	String getProcessingService();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getProcessingService <em>Processing Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Service</em>' attribute.
	 * @see #getProcessingService()
	 * @generated
	 */
	void setProcessingService(String value);

	/**
	 * Returns the value of the '<em><b>Generating Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generating Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generating Service</em>' attribute.
	 * @see #setGeneratingService(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getIntegrity_GeneratingService()
	 * @model required="true"
	 * @generated
	 */
	String getGeneratingService();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getGeneratingService <em>Generating Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generating Service</em>' attribute.
	 * @see #getGeneratingService()
	 * @generated
	 */
	void setGeneratingService(String value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see #setAlgorithm(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getIntegrity_Algorithm()
	 * @model required="true"
	 * @generated
	 */
	String getAlgorithm();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(String value);

} // Integrity
