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

import java.util.Collection;
import java.util.List;

import org.eclipse.bpmn2.ActivitiListener;
import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.FlowNode;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.SequenceFlow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.SequenceFlowImpl#getConditionExpression <em>Condition Expression</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.SequenceFlowImpl#isIsImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.SequenceFlowImpl#getSourceRef <em>Source Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.SequenceFlowImpl#getTargetRef <em>Target Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.SequenceFlowImpl#getExecutionListeners <em>Execution Listeners</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceFlowImpl extends FlowElementImpl implements SequenceFlow {
	/**
	 * The cached value of the '{@link #getConditionExpression() <em>Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionExpression()
	 * @generated
	 * @ordered
	 */
	protected FormalExpression conditionExpression;

	/**
	 * The default value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsImmediate() <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean isImmediate = IS_IMMEDIATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceRef() <em>Source Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRef()
	 * @generated
	 * @ordered
	 */
	protected FlowNode sourceRef;

	/**
	 * The cached value of the '{@link #getTargetRef() <em>Target Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRef()
	 * @generated
	 * @ordered
	 */
	protected FlowNode targetRef;

	/**
	 * The cached value of the '{@link #getExecutionListeners() <em>Execution Listeners</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionListeners()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivitiListener> executionListeners;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getSequenceFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression getConditionExpression() {
		return conditionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditionExpression(FormalExpression newConditionExpression, NotificationChain msgs) {
		FormalExpression oldConditionExpression = conditionExpression;
		conditionExpression = newConditionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION, oldConditionExpression, newConditionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionExpression(FormalExpression newConditionExpression) {
		if (newConditionExpression != conditionExpression) {
			NotificationChain msgs = null;
			if (conditionExpression != null)
				msgs = ((InternalEObject)conditionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION, null, msgs);
			if (newConditionExpression != null)
				msgs = ((InternalEObject)newConditionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION, null, msgs);
			msgs = basicSetConditionExpression(newConditionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION, newConditionExpression, newConditionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsImmediate() {
		return isImmediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsImmediate(boolean newIsImmediate) {
		boolean oldIsImmediate = isImmediate;
		isImmediate = newIsImmediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__IS_IMMEDIATE, oldIsImmediate, isImmediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getSourceRef() {
		return sourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceRef(FlowNode newSourceRef, NotificationChain msgs) {
		FlowNode oldSourceRef = sourceRef;
		sourceRef = newSourceRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF, oldSourceRef, newSourceRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRef(FlowNode newSourceRef) {
		if (newSourceRef != sourceRef) {
			NotificationChain msgs = null;
			if (sourceRef != null)
				msgs = ((InternalEObject)sourceRef).eInverseRemove(this, Bpmn2Package.FLOW_NODE__OUTGOING, FlowNode.class, msgs);
			if (newSourceRef != null)
				msgs = ((InternalEObject)newSourceRef).eInverseAdd(this, Bpmn2Package.FLOW_NODE__OUTGOING, FlowNode.class, msgs);
			msgs = basicSetSourceRef(newSourceRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF, newSourceRef, newSourceRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getTargetRef() {
		return targetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetRef(FlowNode newTargetRef, NotificationChain msgs) {
		FlowNode oldTargetRef = targetRef;
		targetRef = newTargetRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__TARGET_REF, oldTargetRef, newTargetRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRef(FlowNode newTargetRef) {
		if (newTargetRef != targetRef) {
			NotificationChain msgs = null;
			if (targetRef != null)
				msgs = ((InternalEObject)targetRef).eInverseRemove(this, Bpmn2Package.FLOW_NODE__INCOMING, FlowNode.class, msgs);
			if (newTargetRef != null)
				msgs = ((InternalEObject)newTargetRef).eInverseAdd(this, Bpmn2Package.FLOW_NODE__INCOMING, FlowNode.class, msgs);
			msgs = basicSetTargetRef(newTargetRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.SEQUENCE_FLOW__TARGET_REF, newTargetRef, newTargetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<ActivitiListener> getExecutionListeners() {
		if (executionListeners == null) {
			executionListeners = new EObjectContainmentEList<ActivitiListener>(ActivitiListener.class, this, Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS);
		}
		return executionListeners;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				if (sourceRef != null)
					msgs = ((InternalEObject)sourceRef).eInverseRemove(this, Bpmn2Package.FLOW_NODE__OUTGOING, FlowNode.class, msgs);
				return basicSetSourceRef((FlowNode)otherEnd, msgs);
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				if (targetRef != null)
					msgs = ((InternalEObject)targetRef).eInverseRemove(this, Bpmn2Package.FLOW_NODE__INCOMING, FlowNode.class, msgs);
				return basicSetTargetRef((FlowNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				return basicSetConditionExpression(null, msgs);
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				return basicSetSourceRef(null, msgs);
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				return basicSetTargetRef(null, msgs);
			case Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS:
				return ((InternalEList<?>)getExecutionListeners()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				return getConditionExpression();
			case Bpmn2Package.SEQUENCE_FLOW__IS_IMMEDIATE:
				return isIsImmediate();
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				return getSourceRef();
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				return getTargetRef();
			case Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS:
				return getExecutionListeners();
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
			case Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				setConditionExpression((FormalExpression)newValue);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__IS_IMMEDIATE:
				setIsImmediate((Boolean)newValue);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				setSourceRef((FlowNode)newValue);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				setTargetRef((FlowNode)newValue);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS:
				getExecutionListeners().clear();
				getExecutionListeners().addAll((Collection<? extends ActivitiListener>)newValue);
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
			case Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				setConditionExpression((FormalExpression)null);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__IS_IMMEDIATE:
				setIsImmediate(IS_IMMEDIATE_EDEFAULT);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				setSourceRef((FlowNode)null);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				setTargetRef((FlowNode)null);
				return;
			case Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS:
				getExecutionListeners().clear();
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
			case Bpmn2Package.SEQUENCE_FLOW__CONDITION_EXPRESSION:
				return conditionExpression != null;
			case Bpmn2Package.SEQUENCE_FLOW__IS_IMMEDIATE:
				return isImmediate != IS_IMMEDIATE_EDEFAULT;
			case Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF:
				return sourceRef != null;
			case Bpmn2Package.SEQUENCE_FLOW__TARGET_REF:
				return targetRef != null;
			case Bpmn2Package.SEQUENCE_FLOW__EXECUTION_LISTENERS:
				return executionListeners != null && !executionListeners.isEmpty();
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
		result.append(" (isImmediate: ");
		result.append(isImmediate);
		result.append(')');
		return result.toString();
	}

} //SequenceFlowImpl
