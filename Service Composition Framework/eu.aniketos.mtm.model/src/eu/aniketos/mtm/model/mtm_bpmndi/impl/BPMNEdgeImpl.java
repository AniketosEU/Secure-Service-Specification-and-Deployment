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
package eu.aniketos.mtm.model.mtm_bpmndi.impl;

import eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge;
import eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabel;
import eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage;
import eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind;

import eu.aniketos.mtm.model.mtm_di.impl.LabeledEdgeImpl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl#getBPMNLabel <em>BPMN Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl#getBpmnElement <em>Bpmn Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl#getMessageVisibleKind <em>Message Visible Kind</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNEdgeImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BPMNEdgeImpl extends LabeledEdgeImpl implements BPMNEdge {
	/**
	 * The cached value of the '{@link #getBPMNLabel() <em>BPMN Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPMNLabel()
	 * @generated
	 * @ordered
	 */
	protected BPMNLabel bPMNLabel;

	/**
	 * The default value of the '{@link #getBpmnElement() <em>Bpmn Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBpmnElement()
	 * @generated
	 * @ordered
	 */
	protected static final QName BPMN_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBpmnElement() <em>Bpmn Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBpmnElement()
	 * @generated
	 * @ordered
	 */
	protected QName bpmnElement = BPMN_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageVisibleKind() <em>Message Visible Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageVisibleKind()
	 * @generated
	 * @ordered
	 */
	protected static final MessageVisibleKind MESSAGE_VISIBLE_KIND_EDEFAULT = MessageVisibleKind.INITIATING;

	/**
	 * The cached value of the '{@link #getMessageVisibleKind() <em>Message Visible Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageVisibleKind()
	 * @generated
	 * @ordered
	 */
	protected MessageVisibleKind messageVisibleKind = MESSAGE_VISIBLE_KIND_EDEFAULT;

	/**
	 * This is true if the Message Visible Kind attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean messageVisibleKindESet;

	/**
	 * The default value of the '{@link #getSourceElement() <em>Source Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected static final QName SOURCE_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected QName sourceElement = SOURCE_ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetElement() <em>Target Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElement()
	 * @generated
	 * @ordered
	 */
	protected static final QName TARGET_ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElement()
	 * @generated
	 * @ordered
	 */
	protected QName targetElement = TARGET_ELEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BpmnDiPackage.Literals.BPMN_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabel getBPMNLabel() {
		return bPMNLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNLabel(BPMNLabel newBPMNLabel, NotificationChain msgs) {
		BPMNLabel oldBPMNLabel = bPMNLabel;
		bPMNLabel = newBPMNLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__BPMN_LABEL, oldBPMNLabel, newBPMNLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNLabel(BPMNLabel newBPMNLabel) {
		if (newBPMNLabel != bPMNLabel) {
			NotificationChain msgs = null;
			if (bPMNLabel != null)
				msgs = ((InternalEObject)bPMNLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BpmnDiPackage.BPMN_EDGE__BPMN_LABEL, null, msgs);
			if (newBPMNLabel != null)
				msgs = ((InternalEObject)newBPMNLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BpmnDiPackage.BPMN_EDGE__BPMN_LABEL, null, msgs);
			msgs = basicSetBPMNLabel(newBPMNLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__BPMN_LABEL, newBPMNLabel, newBPMNLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getBpmnElement() {
		return bpmnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBpmnElement(QName newBpmnElement) {
		QName oldBpmnElement = bpmnElement;
		bpmnElement = newBpmnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__BPMN_ELEMENT, oldBpmnElement, bpmnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageVisibleKind getMessageVisibleKind() {
		return messageVisibleKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageVisibleKind(MessageVisibleKind newMessageVisibleKind) {
		MessageVisibleKind oldMessageVisibleKind = messageVisibleKind;
		messageVisibleKind = newMessageVisibleKind == null ? MESSAGE_VISIBLE_KIND_EDEFAULT : newMessageVisibleKind;
		boolean oldMessageVisibleKindESet = messageVisibleKindESet;
		messageVisibleKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND, oldMessageVisibleKind, messageVisibleKind, !oldMessageVisibleKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMessageVisibleKind() {
		MessageVisibleKind oldMessageVisibleKind = messageVisibleKind;
		boolean oldMessageVisibleKindESet = messageVisibleKindESet;
		messageVisibleKind = MESSAGE_VISIBLE_KIND_EDEFAULT;
		messageVisibleKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND, oldMessageVisibleKind, MESSAGE_VISIBLE_KIND_EDEFAULT, oldMessageVisibleKindESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMessageVisibleKind() {
		return messageVisibleKindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(QName newSourceElement) {
		QName oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__SOURCE_ELEMENT, oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getTargetElement() {
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetElement(QName newTargetElement) {
		QName oldTargetElement = targetElement;
		targetElement = newTargetElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_EDGE__TARGET_ELEMENT, oldTargetElement, targetElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BpmnDiPackage.BPMN_EDGE__BPMN_LABEL:
				return basicSetBPMNLabel(null, msgs);
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
			case BpmnDiPackage.BPMN_EDGE__BPMN_LABEL:
				return getBPMNLabel();
			case BpmnDiPackage.BPMN_EDGE__BPMN_ELEMENT:
				return getBpmnElement();
			case BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND:
				return getMessageVisibleKind();
			case BpmnDiPackage.BPMN_EDGE__SOURCE_ELEMENT:
				return getSourceElement();
			case BpmnDiPackage.BPMN_EDGE__TARGET_ELEMENT:
				return getTargetElement();
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
			case BpmnDiPackage.BPMN_EDGE__BPMN_LABEL:
				setBPMNLabel((BPMNLabel)newValue);
				return;
			case BpmnDiPackage.BPMN_EDGE__BPMN_ELEMENT:
				setBpmnElement((QName)newValue);
				return;
			case BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND:
				setMessageVisibleKind((MessageVisibleKind)newValue);
				return;
			case BpmnDiPackage.BPMN_EDGE__SOURCE_ELEMENT:
				setSourceElement((QName)newValue);
				return;
			case BpmnDiPackage.BPMN_EDGE__TARGET_ELEMENT:
				setTargetElement((QName)newValue);
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
			case BpmnDiPackage.BPMN_EDGE__BPMN_LABEL:
				setBPMNLabel((BPMNLabel)null);
				return;
			case BpmnDiPackage.BPMN_EDGE__BPMN_ELEMENT:
				setBpmnElement(BPMN_ELEMENT_EDEFAULT);
				return;
			case BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND:
				unsetMessageVisibleKind();
				return;
			case BpmnDiPackage.BPMN_EDGE__SOURCE_ELEMENT:
				setSourceElement(SOURCE_ELEMENT_EDEFAULT);
				return;
			case BpmnDiPackage.BPMN_EDGE__TARGET_ELEMENT:
				setTargetElement(TARGET_ELEMENT_EDEFAULT);
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
			case BpmnDiPackage.BPMN_EDGE__BPMN_LABEL:
				return bPMNLabel != null;
			case BpmnDiPackage.BPMN_EDGE__BPMN_ELEMENT:
				return BPMN_ELEMENT_EDEFAULT == null ? bpmnElement != null : !BPMN_ELEMENT_EDEFAULT.equals(bpmnElement);
			case BpmnDiPackage.BPMN_EDGE__MESSAGE_VISIBLE_KIND:
				return isSetMessageVisibleKind();
			case BpmnDiPackage.BPMN_EDGE__SOURCE_ELEMENT:
				return SOURCE_ELEMENT_EDEFAULT == null ? sourceElement != null : !SOURCE_ELEMENT_EDEFAULT.equals(sourceElement);
			case BpmnDiPackage.BPMN_EDGE__TARGET_ELEMENT:
				return TARGET_ELEMENT_EDEFAULT == null ? targetElement != null : !TARGET_ELEMENT_EDEFAULT.equals(targetElement);
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
		result.append(" (bpmnElement: ");
		result.append(bpmnElement);
		result.append(", messageVisibleKind: ");
		if (messageVisibleKindESet) result.append(messageVisibleKind); else result.append("<unset>");
		result.append(", sourceElement: ");
		result.append(sourceElement);
		result.append(", targetElement: ");
		result.append(targetElement);
		result.append(')');
		return result.toString();
	}

} //BPMNEdgeImpl
