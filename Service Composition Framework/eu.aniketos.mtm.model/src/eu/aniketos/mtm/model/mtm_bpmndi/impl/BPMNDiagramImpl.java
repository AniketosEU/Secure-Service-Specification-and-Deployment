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

import eu.aniketos.mtm.model.mtm_bpmndi.BPMNDiagram;
import eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle;
import eu.aniketos.mtm.model.mtm_bpmndi.BPMNPlane;
import eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage;

import eu.aniketos.mtm.model.mtm_di.impl.DiagramImpl;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>BPMN Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl#getBPMNPlane <em>BPMN Plane</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.impl.BPMNDiagramImpl#getBPMNLabelStyle <em>BPMN Label Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BPMNDiagramImpl extends DiagramImpl implements BPMNDiagram {
	/**
	 * The cached value of the '{@link #getBPMNPlane() <em>BPMN Plane</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPMNPlane()
	 * @generated
	 * @ordered
	 */
	protected BPMNPlane bPMNPlane;

	/**
	 * The cached value of the '{@link #getBPMNLabelStyle() <em>BPMN Label Style</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBPMNLabelStyle()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNLabelStyle> bPMNLabelStyle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPMNDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BpmnDiPackage.Literals.BPMN_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNPlane getBPMNPlane() {
		return bPMNPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBPMNPlane(BPMNPlane newBPMNPlane, NotificationChain msgs) {
		BPMNPlane oldBPMNPlane = bPMNPlane;
		bPMNPlane = newBPMNPlane;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE, oldBPMNPlane, newBPMNPlane);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBPMNPlane(BPMNPlane newBPMNPlane) {
		if (newBPMNPlane != bPMNPlane) {
			NotificationChain msgs = null;
			if (bPMNPlane != null)
				msgs = ((InternalEObject)bPMNPlane).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE, null, msgs);
			if (newBPMNPlane != null)
				msgs = ((InternalEObject)newBPMNPlane).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE, null, msgs);
			msgs = basicSetBPMNPlane(newBPMNPlane, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE, newBPMNPlane, newBPMNPlane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNLabelStyle> getBPMNLabelStyle() {
		if (bPMNLabelStyle == null) {
			bPMNLabelStyle = new EObjectContainmentEList<BPMNLabelStyle>(BPMNLabelStyle.class, this, BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE);
		}
		return bPMNLabelStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE:
				return basicSetBPMNPlane(null, msgs);
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE:
				return ((InternalEList<?>)getBPMNLabelStyle()).basicRemove(otherEnd, msgs);
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
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE:
				return getBPMNPlane();
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE:
				return getBPMNLabelStyle();
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
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE:
				setBPMNPlane((BPMNPlane)newValue);
				return;
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE:
				getBPMNLabelStyle().clear();
				getBPMNLabelStyle().addAll((Collection<? extends BPMNLabelStyle>)newValue);
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
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE:
				setBPMNPlane((BPMNPlane)null);
				return;
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE:
				getBPMNLabelStyle().clear();
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
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_PLANE:
				return bPMNPlane != null;
			case BpmnDiPackage.BPMN_DIAGRAM__BPMN_LABEL_STYLE:
				return bPMNLabelStyle != null && !bPMNLabelStyle.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BPMNDiagramImpl
