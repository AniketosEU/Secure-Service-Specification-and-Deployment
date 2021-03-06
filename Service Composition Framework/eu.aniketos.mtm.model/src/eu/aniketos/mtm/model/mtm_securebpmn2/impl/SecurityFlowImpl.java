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
package eu.aniketos.mtm.model.mtm_securebpmn2.impl;

import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;
import eu.aniketos.mtm.model.mtm_bpmn2.FlowNode;

import eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowElementImpl;

import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;
import eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl#getSourceRefNode <em>Source Ref Node</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.SecurityFlowImpl#getTargetRefNode <em>Target Ref Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecurityFlowImpl extends FlowElementImpl implements SecurityFlow {
	/**
	 * The cached value of the '{@link #getSourceRefNode() <em>Source Ref Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRefNode()
	 * @generated
	 * @ordered
	 */
	protected FlowNode sourceRefNode;

	/**
	 * The cached value of the '{@link #getTargetRefNode() <em>Target Ref Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetRefNode()
	 * @generated
	 * @ordered
	 */
	protected FlowNode targetRefNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecurityFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.SECURITY_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getSourceRefNode() {
		return sourceRefNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceRefNode(FlowNode newSourceRefNode, NotificationChain msgs) {
		FlowNode oldSourceRefNode = sourceRefNode;
		sourceRefNode = newSourceRefNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE, oldSourceRefNode, newSourceRefNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRefNode(FlowNode newSourceRefNode) {
		if (newSourceRefNode != sourceRefNode) {
			NotificationChain msgs = null;
			if (sourceRefNode != null)
				msgs = ((InternalEObject)sourceRefNode).eInverseRemove(this, Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW, FlowNode.class, msgs);
			if (newSourceRefNode != null)
				msgs = ((InternalEObject)newSourceRefNode).eInverseAdd(this, Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW, FlowNode.class, msgs);
			msgs = basicSetSourceRefNode(newSourceRefNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE, newSourceRefNode, newSourceRefNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowNode getTargetRefNode() {
		return targetRefNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetRefNode(FlowNode newTargetRefNode, NotificationChain msgs) {
		FlowNode oldTargetRefNode = targetRefNode;
		targetRefNode = newTargetRefNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE, oldTargetRefNode, newTargetRefNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetRefNode(FlowNode newTargetRefNode) {
		if (newTargetRefNode != targetRefNode) {
			NotificationChain msgs = null;
			if (targetRefNode != null)
				msgs = ((InternalEObject)targetRefNode).eInverseRemove(this, Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW, FlowNode.class, msgs);
			if (newTargetRefNode != null)
				msgs = ((InternalEObject)newTargetRefNode).eInverseAdd(this, Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW, FlowNode.class, msgs);
			msgs = basicSetTargetRefNode(newTargetRefNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE, newTargetRefNode, newTargetRefNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				if (sourceRefNode != null)
					msgs = ((InternalEObject)sourceRefNode).eInverseRemove(this, Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW, FlowNode.class, msgs);
				return basicSetSourceRefNode((FlowNode)otherEnd, msgs);
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				if (targetRefNode != null)
					msgs = ((InternalEObject)targetRefNode).eInverseRemove(this, Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW, FlowNode.class, msgs);
				return basicSetTargetRefNode((FlowNode)otherEnd, msgs);
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
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				return basicSetSourceRefNode(null, msgs);
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				return basicSetTargetRefNode(null, msgs);
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
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				return getSourceRefNode();
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				return getTargetRefNode();
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
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				setSourceRefNode((FlowNode)newValue);
				return;
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				setTargetRefNode((FlowNode)newValue);
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
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				setSourceRefNode((FlowNode)null);
				return;
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				setTargetRefNode((FlowNode)null);
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
			case Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE:
				return sourceRefNode != null;
			case Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE:
				return targetRefNode != null;
		}
		return super.eIsSet(featureID);
	}

} //SecurityFlowImpl
