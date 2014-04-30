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

import eu.aniketos.mtm.model.mtm_bpmn2.Activity;
import eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boundary Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BoundaryEventImpl#getAttachedToRef <em>Attached To Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.BoundaryEventImpl#isCancelActivity <em>Cancel Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundaryEventImpl extends CatchEventImpl implements BoundaryEvent {
	/**
	 * The cached value of the '{@link #getAttachedToRef() <em>Attached To Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachedToRef()
	 * @generated
	 * @ordered
	 */
	protected Activity attachedToRef;

	/**
	 * The default value of the '{@link #isCancelActivity() <em>Cancel Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCancelActivity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CANCEL_ACTIVITY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCancelActivity() <em>Cancel Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCancelActivity()
	 * @generated
	 * @ordered
	 */
	protected boolean cancelActivity = CANCEL_ACTIVITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundaryEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.BOUNDARY_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getAttachedToRef() {
		return attachedToRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttachedToRef(Activity newAttachedToRef, NotificationChain msgs) {
		Activity oldAttachedToRef = attachedToRef;
		attachedToRef = newAttachedToRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF, oldAttachedToRef, newAttachedToRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttachedToRef(Activity newAttachedToRef) {
		if (newAttachedToRef != attachedToRef) {
			NotificationChain msgs = null;
			if (attachedToRef != null)
				msgs = ((InternalEObject)attachedToRef).eInverseRemove(this, Bpmn2Package.ACTIVITY__BOUNDARY_EVENT_REFS, Activity.class, msgs);
			if (newAttachedToRef != null)
				msgs = ((InternalEObject)newAttachedToRef).eInverseAdd(this, Bpmn2Package.ACTIVITY__BOUNDARY_EVENT_REFS, Activity.class, msgs);
			msgs = basicSetAttachedToRef(newAttachedToRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF, newAttachedToRef, newAttachedToRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCancelActivity() {
		return cancelActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCancelActivity(boolean newCancelActivity) {
		boolean oldCancelActivity = cancelActivity;
		cancelActivity = newCancelActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY, oldCancelActivity, cancelActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				if (attachedToRef != null)
					msgs = ((InternalEObject)attachedToRef).eInverseRemove(this, Bpmn2Package.ACTIVITY__BOUNDARY_EVENT_REFS, Activity.class, msgs);
				return basicSetAttachedToRef((Activity)otherEnd, msgs);
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
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				return basicSetAttachedToRef(null, msgs);
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
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				return getAttachedToRef();
			case Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				return isCancelActivity();
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
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				setAttachedToRef((Activity)newValue);
				return;
			case Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				setCancelActivity((Boolean)newValue);
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
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				setAttachedToRef((Activity)null);
				return;
			case Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				setCancelActivity(CANCEL_ACTIVITY_EDEFAULT);
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
			case Bpmn2Package.BOUNDARY_EVENT__ATTACHED_TO_REF:
				return attachedToRef != null;
			case Bpmn2Package.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				return cancelActivity != CANCEL_ACTIVITY_EDEFAULT;
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
		result.append(" (cancelActivity: ");
		result.append(cancelActivity);
		result.append(')');
		return result.toString();
	}

} //BoundaryEventImpl
