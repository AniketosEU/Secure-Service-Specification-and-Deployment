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
import eu.aniketos.mtm.model.mtm_bpmn2.FlowNode;
import eu.aniketos.mtm.model.mtm_bpmn2.Lane;
import eu.aniketos.mtm.model.mtm_bpmn2.SequenceFlow;

import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;
import eu.aniketos.mtm.model.mtm_securebpmn2.SecurityFlow;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowNodeImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowNodeImpl#getLanes <em>Lanes</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowNodeImpl#getIncomingSecurityFlow <em>Incoming Security Flow</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.FlowNodeImpl#getOutgoingSecurityFlow <em>Outgoing Security Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FlowNodeImpl extends FlowElementImpl implements FlowNode {
	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceFlow> incoming;

	/**
	 * The cached value of the '{@link #getLanes() <em>Lanes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanes()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> lanes;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceFlow> outgoing;

	/**
	 * The cached value of the '{@link #getIncomingSecurityFlow() <em>Incoming Security Flow</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingSecurityFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityFlow> incomingSecurityFlow;

	/**
	 * The cached value of the '{@link #getOutgoingSecurityFlow() <em>Outgoing Security Flow</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingSecurityFlow()
	 * @generated
	 * @ordered
	 */
	protected EList<SecurityFlow> outgoingSecurityFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.FLOW_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceFlow> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseEList<SequenceFlow>(SequenceFlow.class, this, Bpmn2Package.FLOW_NODE__INCOMING, Bpmn2Package.SEQUENCE_FLOW__TARGET_REF);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lane> getLanes() {
		if (lanes == null) {
			lanes = new EObjectWithInverseResolvingEList.ManyInverse<Lane>(Lane.class, this, Bpmn2Package.FLOW_NODE__LANES, Bpmn2Package.LANE__FLOW_NODE_REFS);
		}
		return lanes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceFlow> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseEList<SequenceFlow>(SequenceFlow.class, this, Bpmn2Package.FLOW_NODE__OUTGOING, Bpmn2Package.SEQUENCE_FLOW__SOURCE_REF);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityFlow> getIncomingSecurityFlow() {
		if (incomingSecurityFlow == null) {
			incomingSecurityFlow = new EObjectWithInverseResolvingEList<SecurityFlow>(SecurityFlow.class, this, Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW, Securebpmn2Package.SECURITY_FLOW__TARGET_REF_NODE);
		}
		return incomingSecurityFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecurityFlow> getOutgoingSecurityFlow() {
		if (outgoingSecurityFlow == null) {
			outgoingSecurityFlow = new EObjectWithInverseResolvingEList<SecurityFlow>(SecurityFlow.class, this, Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW, Securebpmn2Package.SECURITY_FLOW__SOURCE_REF_NODE);
		}
		return outgoingSecurityFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.FLOW_NODE__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__LANES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLanes()).basicAdd(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingSecurityFlow()).basicAdd(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingSecurityFlow()).basicAdd(otherEnd, msgs);
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
			case Bpmn2Package.FLOW_NODE__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__LANES:
				return ((InternalEList<?>)getLanes()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				return ((InternalEList<?>)getIncomingSecurityFlow()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				return ((InternalEList<?>)getOutgoingSecurityFlow()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.FLOW_NODE__INCOMING:
				return getIncoming();
			case Bpmn2Package.FLOW_NODE__LANES:
				return getLanes();
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				return getOutgoing();
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				return getIncomingSecurityFlow();
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				return getOutgoingSecurityFlow();
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
			case Bpmn2Package.FLOW_NODE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends SequenceFlow>)newValue);
				return;
			case Bpmn2Package.FLOW_NODE__LANES:
				getLanes().clear();
				getLanes().addAll((Collection<? extends Lane>)newValue);
				return;
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends SequenceFlow>)newValue);
				return;
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				getIncomingSecurityFlow().clear();
				getIncomingSecurityFlow().addAll((Collection<? extends SecurityFlow>)newValue);
				return;
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				getOutgoingSecurityFlow().clear();
				getOutgoingSecurityFlow().addAll((Collection<? extends SecurityFlow>)newValue);
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
			case Bpmn2Package.FLOW_NODE__INCOMING:
				getIncoming().clear();
				return;
			case Bpmn2Package.FLOW_NODE__LANES:
				getLanes().clear();
				return;
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				getOutgoing().clear();
				return;
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				getIncomingSecurityFlow().clear();
				return;
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				getOutgoingSecurityFlow().clear();
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
			case Bpmn2Package.FLOW_NODE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case Bpmn2Package.FLOW_NODE__LANES:
				return lanes != null && !lanes.isEmpty();
			case Bpmn2Package.FLOW_NODE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case Bpmn2Package.FLOW_NODE__INCOMING_SECURITY_FLOW:
				return incomingSecurityFlow != null && !incomingSecurityFlow.isEmpty();
			case Bpmn2Package.FLOW_NODE__OUTGOING_SECURITY_FLOW:
				return outgoingSecurityFlow != null && !outgoingSecurityFlow.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowNodeImpl
