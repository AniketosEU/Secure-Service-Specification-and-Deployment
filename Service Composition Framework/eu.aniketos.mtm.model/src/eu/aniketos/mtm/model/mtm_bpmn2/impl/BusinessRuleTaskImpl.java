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
package eu.aniketos.mtm.model.mtm_bpmn2.impl;

import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;
import eu.aniketos.mtm.model.mtm_bpmn2.BusinessRuleTask;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Rule Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BusinessRuleTaskImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BusinessRuleTaskImpl#getRuleNames <em>Rule Names</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BusinessRuleTaskImpl#getInputVariables <em>Input Variables</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BusinessRuleTaskImpl#getResultVariableName <em>Result Variable Name</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BusinessRuleTaskImpl#isExclude <em>Exclude</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessRuleTaskImpl extends TaskImpl implements BusinessRuleTask {
	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected String implementation = IMPLEMENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRuleNames() <em>Rule Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ruleNames;

	/**
	 * The cached value of the '{@link #getInputVariables() <em>Input Variables</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<String> inputVariables;

	/**
	 * The default value of the '{@link #getResultVariableName() <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultVariableName() <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariableName()
	 * @generated
	 * @ordered
	 */
	protected String resultVariableName = RESULT_VARIABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isExclude() <em>Exclude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclude()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXCLUDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExclude() <em>Exclude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExclude()
	 * @generated
	 * @ordered
	 */
	protected boolean exclude = EXCLUDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessRuleTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.BUSINESS_RULE_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(String newImplementation) {
		String oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.BUSINESS_RULE_TASK__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRuleNames() {
		if (ruleNames == null) {
			ruleNames = new EDataTypeUniqueEList<String>(String.class, this, Bpmn2Package.BUSINESS_RULE_TASK__RULE_NAMES);
		}
		return ruleNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getInputVariables() {
		if (inputVariables == null) {
			inputVariables = new EDataTypeUniqueEList<String>(String.class, this, Bpmn2Package.BUSINESS_RULE_TASK__INPUT_VARIABLES);
		}
		return inputVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultVariableName() {
		return resultVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVariableName(String newResultVariableName) {
		String oldResultVariableName = resultVariableName;
		resultVariableName = newResultVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME, oldResultVariableName, resultVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExclude() {
		return exclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExclude(boolean newExclude) {
		boolean oldExclude = exclude;
		exclude = newExclude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.BUSINESS_RULE_TASK__EXCLUDE, oldExclude, exclude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.BUSINESS_RULE_TASK__IMPLEMENTATION:
				return getImplementation();
			case Bpmn2Package.BUSINESS_RULE_TASK__RULE_NAMES:
				return getRuleNames();
			case Bpmn2Package.BUSINESS_RULE_TASK__INPUT_VARIABLES:
				return getInputVariables();
			case Bpmn2Package.BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME:
				return getResultVariableName();
			case Bpmn2Package.BUSINESS_RULE_TASK__EXCLUDE:
				return isExclude();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Bpmn2Package.BUSINESS_RULE_TASK__IMPLEMENTATION:
				setImplementation((String)newValue);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__RULE_NAMES:
				getRuleNames().clear();
				getRuleNames().addAll((Collection<? extends String>)newValue);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__INPUT_VARIABLES:
				getInputVariables().clear();
				getInputVariables().addAll((Collection<? extends String>)newValue);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME:
				setResultVariableName((String)newValue);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__EXCLUDE:
				setExclude((Boolean)newValue);
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
			case Bpmn2Package.BUSINESS_RULE_TASK__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__RULE_NAMES:
				getRuleNames().clear();
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__INPUT_VARIABLES:
				getInputVariables().clear();
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME:
				setResultVariableName(RESULT_VARIABLE_NAME_EDEFAULT);
				return;
			case Bpmn2Package.BUSINESS_RULE_TASK__EXCLUDE:
				setExclude(EXCLUDE_EDEFAULT);
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
			case Bpmn2Package.BUSINESS_RULE_TASK__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case Bpmn2Package.BUSINESS_RULE_TASK__RULE_NAMES:
				return ruleNames != null && !ruleNames.isEmpty();
			case Bpmn2Package.BUSINESS_RULE_TASK__INPUT_VARIABLES:
				return inputVariables != null && !inputVariables.isEmpty();
			case Bpmn2Package.BUSINESS_RULE_TASK__RESULT_VARIABLE_NAME:
				return RESULT_VARIABLE_NAME_EDEFAULT == null ? resultVariableName != null : !RESULT_VARIABLE_NAME_EDEFAULT.equals(resultVariableName);
			case Bpmn2Package.BUSINESS_RULE_TASK__EXCLUDE:
				return exclude != EXCLUDE_EDEFAULT;
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
		result.append(" (implementation: ");
		result.append(implementation);
		result.append(", ruleNames: ");
		result.append(ruleNames);
		result.append(", inputVariables: ");
		result.append(inputVariables);
		result.append(", resultVariableName: ");
		result.append(resultVariableName);
		result.append(", exclude: ");
		result.append(exclude);
		result.append(')');
		return result.toString();
	}

} //BusinessRuleTaskImpl
