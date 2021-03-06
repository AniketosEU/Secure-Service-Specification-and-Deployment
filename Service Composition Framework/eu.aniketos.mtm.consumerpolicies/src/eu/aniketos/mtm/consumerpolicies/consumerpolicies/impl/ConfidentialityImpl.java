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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Confidentiality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl#getInputSuite <em>Input Suite</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.ConfidentialityImpl#getOutputSuite <em>Output Suite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfidentialityImpl extends GuardedTaskPolicyImpl implements Confidentiality {
	/**
	 * The default value of the '{@link #getInputSuite() <em>Input Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSuite()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_SUITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputSuite() <em>Input Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSuite()
	 * @generated
	 * @ordered
	 */
	protected String inputSuite = INPUT_SUITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputSuite() <em>Output Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSuite()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_SUITE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputSuite() <em>Output Suite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSuite()
	 * @generated
	 * @ordered
	 */
	protected String outputSuite = OUTPUT_SUITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfidentialityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConsumerpoliciesPackage.Literals.CONFIDENTIALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputSuite() {
		return inputSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSuite(String newInputSuite) {
		String oldInputSuite = inputSuite;
		inputSuite = newInputSuite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.CONFIDENTIALITY__INPUT_SUITE, oldInputSuite, inputSuite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputSuite() {
		return outputSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputSuite(String newOutputSuite) {
		String oldOutputSuite = outputSuite;
		outputSuite = newOutputSuite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.CONFIDENTIALITY__OUTPUT_SUITE, oldOutputSuite, outputSuite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConsumerpoliciesPackage.CONFIDENTIALITY__INPUT_SUITE:
				return getInputSuite();
			case ConsumerpoliciesPackage.CONFIDENTIALITY__OUTPUT_SUITE:
				return getOutputSuite();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConsumerpoliciesPackage.CONFIDENTIALITY__INPUT_SUITE:
				setInputSuite((String)newValue);
				return;
			case ConsumerpoliciesPackage.CONFIDENTIALITY__OUTPUT_SUITE:
				setOutputSuite((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConsumerpoliciesPackage.CONFIDENTIALITY__INPUT_SUITE:
				setInputSuite(INPUT_SUITE_EDEFAULT);
				return;
			case ConsumerpoliciesPackage.CONFIDENTIALITY__OUTPUT_SUITE:
				setOutputSuite(OUTPUT_SUITE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConsumerpoliciesPackage.CONFIDENTIALITY__INPUT_SUITE:
				return INPUT_SUITE_EDEFAULT == null ? inputSuite != null : !INPUT_SUITE_EDEFAULT.equals(inputSuite);
			case ConsumerpoliciesPackage.CONFIDENTIALITY__OUTPUT_SUITE:
				return OUTPUT_SUITE_EDEFAULT == null ? outputSuite != null : !OUTPUT_SUITE_EDEFAULT.equals(outputSuite);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inputSuite: ");
		result.append(inputSuite);
		result.append(", outputSuite: ");
		result.append(outputSuite);
		result.append(')');
		return result.toString();
	}

} //ConfidentialityImpl
