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
 * A representation of the model object '<em><b>Confidentiality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getInputSuite <em>Input Suite</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getOutputSuite <em>Output Suite</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getConfidentiality()
 * @model
 * @generated
 */
public interface Confidentiality extends GuardedTaskPolicy {
	/**
	 * Returns the value of the '<em><b>Input Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Suite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Suite</em>' attribute.
	 * @see #setInputSuite(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getConfidentiality_InputSuite()
	 * @model required="true"
	 * @generated
	 */
	String getInputSuite();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getInputSuite <em>Input Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Suite</em>' attribute.
	 * @see #getInputSuite()
	 * @generated
	 */
	void setInputSuite(String value);

	/**
	 * Returns the value of the '<em><b>Output Suite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Suite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Suite</em>' attribute.
	 * @see #setOutputSuite(String)
	 * @see eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage#getConfidentiality_OutputSuite()
	 * @model required="true"
	 * @generated
	 */
	String getOutputSuite();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality#getOutputSuite <em>Output Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Suite</em>' attribute.
	 * @see #getOutputSuite()
	 * @generated
	 */
	void setOutputSuite(String value);

} // Confidentiality
