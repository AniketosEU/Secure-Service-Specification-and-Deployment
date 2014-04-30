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
package org.eclipse.dd.di.impl;

import org.eclipse.bpmn2.BaseElement;

import org.eclipse.bpmn2.di.impl.LabeledShapeImpl;

import org.eclipse.dd.di.BPMNLabel;
import org.eclipse.dd.di.BPMNShape;
import org.eclipse.dd.di.DiPackage;
import org.eclipse.dd.di.ParticipantBandKind;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BPMN Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#getBpmnElement <em>Bpmn Element</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#getChoreographyActivityShape <em>Choreography Activity Shape</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#isIsExpanded <em>Is Expanded</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#isIsHorizontal <em>Is Horizontal</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#isIsMarkerVisible <em>Is Marker Visible</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#isIsMessageVisible <em>Is Message Visible</em>}</li>
 *   <li>{@link org.eclipse.dd.di.impl.BPMNShapeImpl#getParticipantBandKind <em>Participant Band Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BPMNShapeImpl extends LabeledShapeImpl implements BPMNShape {
	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected BPMNLabel label;

	/**
	 * The cached value of the '{@link #getBpmnElement() <em>Bpmn Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBpmnElement()
	 * @generated
	 * @ordered
	 */
	protected BaseElement bpmnElement;

	/**
	 * The cached value of the '{@link #getChoreographyActivityShape() <em>Choreography Activity Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoreographyActivityShape()
	 * @generated
	 * @ordered
	 */
	protected BPMNShape choreographyActivityShape;

	/**
	 * The default value of the '{@link #isIsExpanded() <em>Is Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExpanded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_EXPANDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsExpanded() <em>Is Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExpanded()
	 * @generated
	 * @ordered
	 */
	protected boolean isExpanded = IS_EXPANDED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsHorizontal() <em>Is Horizontal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsHorizontal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_HORIZONTAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsHorizontal() <em>Is Horizontal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsHorizontal()
	 * @generated
	 * @ordered
	 */
	protected boolean isHorizontal = IS_HORIZONTAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMarkerVisible() <em>Is Marker Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMarkerVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MARKER_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMarkerVisible() <em>Is Marker Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMarkerVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean isMarkerVisible = IS_MARKER_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsMessageVisible() <em>Is Message Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMessageVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MESSAGE_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMessageVisible() <em>Is Message Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMessageVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean isMessageVisible = IS_MESSAGE_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParticipantBandKind() <em>Participant Band Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantBandKind()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipantBandKind PARTICIPANT_BAND_KIND_EDEFAULT = ParticipantBandKind.TOP_INITIATING;

	/**
	 * The cached value of the '{@link #getParticipantBandKind() <em>Participant Band Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantBandKind()
	 * @generated
	 * @ordered
	 */
	protected ParticipantBandKind participantBandKind = PARTICIPANT_BAND_KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNShapeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.BPMN_SHAPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabel getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLabel(BPMNLabel newLabel, NotificationChain msgs) {
		BPMNLabel oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__LABEL, oldLabel, newLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(BPMNLabel newLabel) {
		if (newLabel != label) {
			NotificationChain msgs = null;
			if (label != null)
				msgs = ((InternalEObject)label).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiPackage.BPMN_SHAPE__LABEL, null, msgs);
			if (newLabel != null)
				msgs = ((InternalEObject)newLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiPackage.BPMN_SHAPE__LABEL, null, msgs);
			msgs = basicSetLabel(newLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__LABEL, newLabel, newLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseElement getBpmnElement() {
		if (bpmnElement != null && bpmnElement.eIsProxy()) {
			InternalEObject oldBpmnElement = (InternalEObject)bpmnElement;
			bpmnElement = (BaseElement)eResolveProxy(oldBpmnElement);
			if (bpmnElement != oldBpmnElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiPackage.BPMN_SHAPE__BPMN_ELEMENT, oldBpmnElement, bpmnElement));
			}
		}
		return bpmnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseElement basicGetBpmnElement() {
		return bpmnElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBpmnElement(BaseElement newBpmnElement) {
		BaseElement oldBpmnElement = bpmnElement;
		bpmnElement = newBpmnElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__BPMN_ELEMENT, oldBpmnElement, bpmnElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNShape getChoreographyActivityShape() {
		if (choreographyActivityShape != null && choreographyActivityShape.eIsProxy()) {
			InternalEObject oldChoreographyActivityShape = (InternalEObject)choreographyActivityShape;
			choreographyActivityShape = (BPMNShape)eResolveProxy(oldChoreographyActivityShape);
			if (choreographyActivityShape != oldChoreographyActivityShape) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE, oldChoreographyActivityShape, choreographyActivityShape));
			}
		}
		return choreographyActivityShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNShape basicGetChoreographyActivityShape() {
		return choreographyActivityShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChoreographyActivityShape(BPMNShape newChoreographyActivityShape) {
		BPMNShape oldChoreographyActivityShape = choreographyActivityShape;
		choreographyActivityShape = newChoreographyActivityShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE, oldChoreographyActivityShape, choreographyActivityShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsExpanded() {
		return isExpanded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsExpanded(boolean newIsExpanded) {
		boolean oldIsExpanded = isExpanded;
		isExpanded = newIsExpanded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__IS_EXPANDED, oldIsExpanded, isExpanded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsHorizontal() {
		return isHorizontal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsHorizontal(boolean newIsHorizontal) {
		boolean oldIsHorizontal = isHorizontal;
		isHorizontal = newIsHorizontal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__IS_HORIZONTAL, oldIsHorizontal, isHorizontal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMarkerVisible() {
		return isMarkerVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMarkerVisible(boolean newIsMarkerVisible) {
		boolean oldIsMarkerVisible = isMarkerVisible;
		isMarkerVisible = newIsMarkerVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__IS_MARKER_VISIBLE, oldIsMarkerVisible, isMarkerVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMessageVisible() {
		return isMessageVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMessageVisible(boolean newIsMessageVisible) {
		boolean oldIsMessageVisible = isMessageVisible;
		isMessageVisible = newIsMessageVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__IS_MESSAGE_VISIBLE, oldIsMessageVisible, isMessageVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantBandKind getParticipantBandKind() {
		return participantBandKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipantBandKind(ParticipantBandKind newParticipantBandKind) {
		ParticipantBandKind oldParticipantBandKind = participantBandKind;
		participantBandKind = newParticipantBandKind == null ? PARTICIPANT_BAND_KIND_EDEFAULT : newParticipantBandKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.BPMN_SHAPE__PARTICIPANT_BAND_KIND, oldParticipantBandKind, participantBandKind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiPackage.BPMN_SHAPE__LABEL:
				return basicSetLabel(null, msgs);
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
			case DiPackage.BPMN_SHAPE__LABEL:
				return getLabel();
			case DiPackage.BPMN_SHAPE__BPMN_ELEMENT:
				if (resolve) return getBpmnElement();
				return basicGetBpmnElement();
			case DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE:
				if (resolve) return getChoreographyActivityShape();
				return basicGetChoreographyActivityShape();
			case DiPackage.BPMN_SHAPE__IS_EXPANDED:
				return isIsExpanded();
			case DiPackage.BPMN_SHAPE__IS_HORIZONTAL:
				return isIsHorizontal();
			case DiPackage.BPMN_SHAPE__IS_MARKER_VISIBLE:
				return isIsMarkerVisible();
			case DiPackage.BPMN_SHAPE__IS_MESSAGE_VISIBLE:
				return isIsMessageVisible();
			case DiPackage.BPMN_SHAPE__PARTICIPANT_BAND_KIND:
				return getParticipantBandKind();
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
			case DiPackage.BPMN_SHAPE__LABEL:
				setLabel((BPMNLabel)newValue);
				return;
			case DiPackage.BPMN_SHAPE__BPMN_ELEMENT:
				setBpmnElement((BaseElement)newValue);
				return;
			case DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE:
				setChoreographyActivityShape((BPMNShape)newValue);
				return;
			case DiPackage.BPMN_SHAPE__IS_EXPANDED:
				setIsExpanded((Boolean)newValue);
				return;
			case DiPackage.BPMN_SHAPE__IS_HORIZONTAL:
				setIsHorizontal((Boolean)newValue);
				return;
			case DiPackage.BPMN_SHAPE__IS_MARKER_VISIBLE:
				setIsMarkerVisible((Boolean)newValue);
				return;
			case DiPackage.BPMN_SHAPE__IS_MESSAGE_VISIBLE:
				setIsMessageVisible((Boolean)newValue);
				return;
			case DiPackage.BPMN_SHAPE__PARTICIPANT_BAND_KIND:
				setParticipantBandKind((ParticipantBandKind)newValue);
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
			case DiPackage.BPMN_SHAPE__LABEL:
				setLabel((BPMNLabel)null);
				return;
			case DiPackage.BPMN_SHAPE__BPMN_ELEMENT:
				setBpmnElement((BaseElement)null);
				return;
			case DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE:
				setChoreographyActivityShape((BPMNShape)null);
				return;
			case DiPackage.BPMN_SHAPE__IS_EXPANDED:
				setIsExpanded(IS_EXPANDED_EDEFAULT);
				return;
			case DiPackage.BPMN_SHAPE__IS_HORIZONTAL:
				setIsHorizontal(IS_HORIZONTAL_EDEFAULT);
				return;
			case DiPackage.BPMN_SHAPE__IS_MARKER_VISIBLE:
				setIsMarkerVisible(IS_MARKER_VISIBLE_EDEFAULT);
				return;
			case DiPackage.BPMN_SHAPE__IS_MESSAGE_VISIBLE:
				setIsMessageVisible(IS_MESSAGE_VISIBLE_EDEFAULT);
				return;
			case DiPackage.BPMN_SHAPE__PARTICIPANT_BAND_KIND:
				setParticipantBandKind(PARTICIPANT_BAND_KIND_EDEFAULT);
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
			case DiPackage.BPMN_SHAPE__LABEL:
				return label != null;
			case DiPackage.BPMN_SHAPE__BPMN_ELEMENT:
				return bpmnElement != null;
			case DiPackage.BPMN_SHAPE__CHOREOGRAPHY_ACTIVITY_SHAPE:
				return choreographyActivityShape != null;
			case DiPackage.BPMN_SHAPE__IS_EXPANDED:
				return isExpanded != IS_EXPANDED_EDEFAULT;
			case DiPackage.BPMN_SHAPE__IS_HORIZONTAL:
				return isHorizontal != IS_HORIZONTAL_EDEFAULT;
			case DiPackage.BPMN_SHAPE__IS_MARKER_VISIBLE:
				return isMarkerVisible != IS_MARKER_VISIBLE_EDEFAULT;
			case DiPackage.BPMN_SHAPE__IS_MESSAGE_VISIBLE:
				return isMessageVisible != IS_MESSAGE_VISIBLE_EDEFAULT;
			case DiPackage.BPMN_SHAPE__PARTICIPANT_BAND_KIND:
				return participantBandKind != PARTICIPANT_BAND_KIND_EDEFAULT;
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
		result.append(" (isExpanded: ");
		result.append(isExpanded);
		result.append(", isHorizontal: ");
		result.append(isHorizontal);
		result.append(", isMarkerVisible: ");
		result.append(isMarkerVisible);
		result.append(", isMessageVisible: ");
		result.append(isMessageVisible);
		result.append(", participantBandKind: ");
		result.append(participantBandKind);
		result.append(')');
		return result.toString();
	}

} //BPMNShapeImpl
