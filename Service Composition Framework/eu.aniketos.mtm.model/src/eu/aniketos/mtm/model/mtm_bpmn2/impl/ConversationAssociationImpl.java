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
import eu.aniketos.mtm.model.mtm_bpmn2.ConversationAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.ConversationNode;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversation Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ConversationAssociationImpl#getInnerConversationNodeRef <em>Inner Conversation Node Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ConversationAssociationImpl#getOuterConversationNodeRef <em>Outer Conversation Node Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConversationAssociationImpl extends BaseElementImpl implements ConversationAssociation {
	/**
	 * The cached value of the '{@link #getInnerConversationNodeRef() <em>Inner Conversation Node Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerConversationNodeRef()
	 * @generated
	 * @ordered
	 */
	protected ConversationNode innerConversationNodeRef;

	/**
	 * The cached value of the '{@link #getOuterConversationNodeRef() <em>Outer Conversation Node Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterConversationNodeRef()
	 * @generated
	 * @ordered
	 */
	protected ConversationNode outerConversationNodeRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConversationAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.CONVERSATION_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationNode getInnerConversationNodeRef() {
		if (innerConversationNodeRef != null && innerConversationNodeRef.eIsProxy()) {
			InternalEObject oldInnerConversationNodeRef = (InternalEObject)innerConversationNodeRef;
			innerConversationNodeRef = (ConversationNode)eResolveProxy(oldInnerConversationNodeRef);
			if (innerConversationNodeRef != oldInnerConversationNodeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF, oldInnerConversationNodeRef, innerConversationNodeRef));
			}
		}
		return innerConversationNodeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationNode basicGetInnerConversationNodeRef() {
		return innerConversationNodeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerConversationNodeRef(ConversationNode newInnerConversationNodeRef) {
		ConversationNode oldInnerConversationNodeRef = innerConversationNodeRef;
		innerConversationNodeRef = newInnerConversationNodeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF, oldInnerConversationNodeRef, innerConversationNodeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationNode getOuterConversationNodeRef() {
		if (outerConversationNodeRef != null && outerConversationNodeRef.eIsProxy()) {
			InternalEObject oldOuterConversationNodeRef = (InternalEObject)outerConversationNodeRef;
			outerConversationNodeRef = (ConversationNode)eResolveProxy(oldOuterConversationNodeRef);
			if (outerConversationNodeRef != oldOuterConversationNodeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF, oldOuterConversationNodeRef, outerConversationNodeRef));
			}
		}
		return outerConversationNodeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConversationNode basicGetOuterConversationNodeRef() {
		return outerConversationNodeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterConversationNodeRef(ConversationNode newOuterConversationNodeRef) {
		ConversationNode oldOuterConversationNodeRef = outerConversationNodeRef;
		outerConversationNodeRef = newOuterConversationNodeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF, oldOuterConversationNodeRef, outerConversationNodeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF:
				if (resolve) return getInnerConversationNodeRef();
				return basicGetInnerConversationNodeRef();
			case Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF:
				if (resolve) return getOuterConversationNodeRef();
				return basicGetOuterConversationNodeRef();
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
			case Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF:
				setInnerConversationNodeRef((ConversationNode)newValue);
				return;
			case Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF:
				setOuterConversationNodeRef((ConversationNode)newValue);
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
			case Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF:
				setInnerConversationNodeRef((ConversationNode)null);
				return;
			case Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF:
				setOuterConversationNodeRef((ConversationNode)null);
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
			case Bpmn2Package.CONVERSATION_ASSOCIATION__INNER_CONVERSATION_NODE_REF:
				return innerConversationNodeRef != null;
			case Bpmn2Package.CONVERSATION_ASSOCIATION__OUTER_CONVERSATION_NODE_REF:
				return outerConversationNodeRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ConversationAssociationImpl
