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
package org.eclipse.bpmn2.impl;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.Expression;
import org.eclipse.bpmn2.TimerEventDefinition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.TimerEventDefinitionImpl#getTimeDate <em>Time Date</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.TimerEventDefinitionImpl#getTimeDuration <em>Time Duration</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.TimerEventDefinitionImpl#getTimeCycle <em>Time Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimerEventDefinitionImpl extends EventDefinitionImpl implements TimerEventDefinition {
	/**
	 * The cached value of the '{@link #getTimeDate() <em>Time Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeDate()
	 * @generated
	 * @ordered
	 */
	protected Expression timeDate;

	/**
	 * The cached value of the '{@link #getTimeDuration() <em>Time Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeDuration()
	 * @generated
	 * @ordered
	 */
	protected Expression timeDuration;

	/**
	 * The cached value of the '{@link #getTimeCycle() <em>Time Cycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeCycle()
	 * @generated
	 * @ordered
	 */
	protected Expression timeCycle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerEventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getTimerEventDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTimeDate() {
		return timeDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeDate(Expression newTimeDate, NotificationChain msgs) {
		Expression oldTimeDate = timeDate;
		timeDate = newTimeDate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE, oldTimeDate, newTimeDate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeDate(Expression newTimeDate) {
		if (newTimeDate != timeDate) {
			NotificationChain msgs = null;
			if (timeDate != null)
				msgs = ((InternalEObject)timeDate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE, null, msgs);
			if (newTimeDate != null)
				msgs = ((InternalEObject)newTimeDate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE, null, msgs);
			msgs = basicSetTimeDate(newTimeDate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE, newTimeDate, newTimeDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTimeDuration() {
		return timeDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeDuration(Expression newTimeDuration, NotificationChain msgs) {
		Expression oldTimeDuration = timeDuration;
		timeDuration = newTimeDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION, oldTimeDuration, newTimeDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeDuration(Expression newTimeDuration) {
		if (newTimeDuration != timeDuration) {
			NotificationChain msgs = null;
			if (timeDuration != null)
				msgs = ((InternalEObject)timeDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION, null, msgs);
			if (newTimeDuration != null)
				msgs = ((InternalEObject)newTimeDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION, null, msgs);
			msgs = basicSetTimeDuration(newTimeDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION, newTimeDuration, newTimeDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTimeCycle() {
		return timeCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeCycle(Expression newTimeCycle, NotificationChain msgs) {
		Expression oldTimeCycle = timeCycle;
		timeCycle = newTimeCycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE, oldTimeCycle, newTimeCycle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeCycle(Expression newTimeCycle) {
		if (newTimeCycle != timeCycle) {
			NotificationChain msgs = null;
			if (timeCycle != null)
				msgs = ((InternalEObject)timeCycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE, null, msgs);
			if (newTimeCycle != null)
				msgs = ((InternalEObject)newTimeCycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE, null, msgs);
			msgs = basicSetTimeCycle(newTimeCycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE, newTimeCycle, newTimeCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE:
				return basicSetTimeDate(null, msgs);
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION:
				return basicSetTimeDuration(null, msgs);
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE:
				return basicSetTimeCycle(null, msgs);
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
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE:
				return getTimeDate();
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION:
				return getTimeDuration();
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE:
				return getTimeCycle();
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
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE:
				setTimeDate((Expression)newValue);
				return;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION:
				setTimeDuration((Expression)newValue);
				return;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE:
				setTimeCycle((Expression)newValue);
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
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE:
				setTimeDate((Expression)null);
				return;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION:
				setTimeDuration((Expression)null);
				return;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE:
				setTimeCycle((Expression)null);
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
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DATE:
				return timeDate != null;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_DURATION:
				return timeDuration != null;
			case Bpmn2Package.TIMER_EVENT_DEFINITION__TIME_CYCLE:
				return timeCycle != null;
		}
		return super.eIsSet(featureID);
	}

} //TimerEventDefinitionImpl
