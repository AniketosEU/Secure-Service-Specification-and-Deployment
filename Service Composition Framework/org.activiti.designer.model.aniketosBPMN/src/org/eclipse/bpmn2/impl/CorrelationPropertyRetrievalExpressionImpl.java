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
import org.eclipse.bpmn2.CorrelationPropertyRetrievalExpression;
import org.eclipse.bpmn2.FormalExpression;
import org.eclipse.bpmn2.Message;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Correlation Property Retrieval Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.CorrelationPropertyRetrievalExpressionImpl#getMessagePath <em>Message Path</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.CorrelationPropertyRetrievalExpressionImpl#getMessageRef <em>Message Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CorrelationPropertyRetrievalExpressionImpl extends BaseElementImpl implements CorrelationPropertyRetrievalExpression {
	/**
	 * The cached value of the '{@link #getMessagePath() <em>Message Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagePath()
	 * @generated
	 * @ordered
	 */
	protected FormalExpression messagePath;

	/**
	 * The cached value of the '{@link #getMessageRef() <em>Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageRef()
	 * @generated
	 * @ordered
	 */
	protected Message messageRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CorrelationPropertyRetrievalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getCorrelationPropertyRetrievalExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalExpression getMessagePath() {
		return messagePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMessagePath(FormalExpression newMessagePath, NotificationChain msgs) {
		FormalExpression oldMessagePath = messagePath;
		messagePath = newMessagePath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, oldMessagePath, newMessagePath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessagePath(FormalExpression newMessagePath) {
		if (newMessagePath != messagePath) {
			NotificationChain msgs = null;
			if (messagePath != null)
				msgs = ((InternalEObject)messagePath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, null, msgs);
			if (newMessagePath != null)
				msgs = ((InternalEObject)newMessagePath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, null, msgs);
			msgs = basicSetMessagePath(newMessagePath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH, newMessagePath, newMessagePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessageRef() {
		if (messageRef != null && messageRef.eIsProxy()) {
			InternalEObject oldMessageRef = (InternalEObject)messageRef;
			messageRef = (Message)eResolveProxy(oldMessageRef);
			if (messageRef != oldMessageRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF, oldMessageRef, messageRef));
			}
		}
		return messageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessageRef() {
		return messageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageRef(Message newMessageRef) {
		Message oldMessageRef = messageRef;
		messageRef = newMessageRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF, oldMessageRef, messageRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				return basicSetMessagePath(null, msgs);
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
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				return getMessagePath();
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				if (resolve) return getMessageRef();
				return basicGetMessageRef();
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
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				setMessagePath((FormalExpression)newValue);
				return;
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				setMessageRef((Message)newValue);
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
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				setMessagePath((FormalExpression)null);
				return;
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				setMessageRef((Message)null);
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
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_PATH:
				return messagePath != null;
			case Bpmn2Package.CORRELATION_PROPERTY_RETRIEVAL_EXPRESSION__MESSAGE_REF:
				return messageRef != null;
		}
		return super.eIsSet(featureID);
	}

} //CorrelationPropertyRetrievalExpressionImpl
