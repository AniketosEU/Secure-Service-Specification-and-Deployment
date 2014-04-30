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
import eu.aniketos.mtm.model.mtm_bpmn2.Expression;
import eu.aniketos.mtm.model.mtm_bpmn2.StandardLoopCharacteristics;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.StandardLoopCharacteristicsImpl#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.StandardLoopCharacteristicsImpl#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.StandardLoopCharacteristicsImpl#isTestBefore <em>Test Before</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardLoopCharacteristicsImpl extends LoopCharacteristicsImpl implements StandardLoopCharacteristics {
	/**
	 * The cached value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression loopCondition;

	/**
	 * The cached value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopMaximum()
	 * @generated
	 * @ordered
	 */
	protected Expression loopMaximum;

	/**
	 * The default value of the '{@link #isTestBefore() <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTestBefore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEST_BEFORE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTestBefore() <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTestBefore()
	 * @generated
	 * @ordered
	 */
	protected boolean testBefore = TEST_BEFORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardLoopCharacteristicsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.STANDARD_LOOP_CHARACTERISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLoopCondition() {
		return loopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopCondition(Expression newLoopCondition, NotificationChain msgs) {
		Expression oldLoopCondition = loopCondition;
		loopCondition = newLoopCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION, oldLoopCondition, newLoopCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCondition(Expression newLoopCondition) {
		if (newLoopCondition != loopCondition) {
			NotificationChain msgs = null;
			if (loopCondition != null)
				msgs = ((InternalEObject)loopCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION, null, msgs);
			if (newLoopCondition != null)
				msgs = ((InternalEObject)newLoopCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION, null, msgs);
			msgs = basicSetLoopCondition(newLoopCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION, newLoopCondition, newLoopCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLoopMaximum() {
		return loopMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopMaximum(Expression newLoopMaximum, NotificationChain msgs) {
		Expression oldLoopMaximum = loopMaximum;
		loopMaximum = newLoopMaximum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM, oldLoopMaximum, newLoopMaximum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopMaximum(Expression newLoopMaximum) {
		if (newLoopMaximum != loopMaximum) {
			NotificationChain msgs = null;
			if (loopMaximum != null)
				msgs = ((InternalEObject)loopMaximum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM, null, msgs);
			if (newLoopMaximum != null)
				msgs = ((InternalEObject)newLoopMaximum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM, null, msgs);
			msgs = basicSetLoopMaximum(newLoopMaximum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM, newLoopMaximum, newLoopMaximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTestBefore() {
		return testBefore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestBefore(boolean newTestBefore) {
		boolean oldTestBefore = testBefore;
		testBefore = newTestBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE, oldTestBefore, testBefore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION:
				return basicSetLoopCondition(null, msgs);
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM:
				return basicSetLoopMaximum(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION:
				return getLoopCondition();
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM:
				return getLoopMaximum();
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE:
				return isTestBefore();
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
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION:
				setLoopCondition((Expression)newValue);
				return;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM:
				setLoopMaximum((Expression)newValue);
				return;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE:
				setTestBefore((Boolean)newValue);
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
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION:
				setLoopCondition((Expression)null);
				return;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM:
				setLoopMaximum((Expression)null);
				return;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE:
				setTestBefore(TEST_BEFORE_EDEFAULT);
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
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_CONDITION:
				return loopCondition != null;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__LOOP_MAXIMUM:
				return loopMaximum != null;
			case Bpmn2Package.STANDARD_LOOP_CHARACTERISTICS__TEST_BEFORE:
				return testBefore != TEST_BEFORE_EDEFAULT;
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
		result.append(" (testBefore: ");
		result.append(testBefore);
		result.append(')');
		return result.toString();
	}

} //StandardLoopCharacteristicsImpl
