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

import eu.aniketos.mtm.model.mtm_securebpmn2.CompositeProcessAction;
import eu.aniketos.mtm.model.mtm_securebpmn2.ProcessAction;
import eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl#getCompositeProcessActions <em>Composite Process Actions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.impl.ProcessActionImpl#getProcess <em>Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessActionImpl extends ActionImpl implements ProcessAction {
	/**
	 * The cached value of the '{@link #getCompositeProcessActions() <em>Composite Process Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeProcessActions()
	 * @generated
	 * @ordered
	 */
	protected EList<CompositeProcessAction> compositeProcessActions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Securebpmn2Package.Literals.PROCESS_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompositeProcessAction> getCompositeProcessActions() {
		if (compositeProcessActions == null) {
			compositeProcessActions = new EObjectWithInverseResolvingEList.ManyInverse<CompositeProcessAction>(CompositeProcessAction.class, this, Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS, Securebpmn2Package.COMPOSITE_PROCESS_ACTION__PROCESS_ACTIONS);
		}
		return compositeProcessActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public eu.aniketos.mtm.model.mtm_bpmn2.Process getProcess() {
		if (eContainerFeatureID() != Securebpmn2Package.PROCESS_ACTION__PROCESS) return null;
		return (eu.aniketos.mtm.model.mtm_bpmn2.Process)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcess(eu.aniketos.mtm.model.mtm_bpmn2.Process newProcess, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProcess, Securebpmn2Package.PROCESS_ACTION__PROCESS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcess(eu.aniketos.mtm.model.mtm_bpmn2.Process newProcess) {
		if (newProcess != eInternalContainer() || (eContainerFeatureID() != Securebpmn2Package.PROCESS_ACTION__PROCESS && newProcess != null)) {
			if (EcoreUtil.isAncestor(this, newProcess))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProcess != null)
				msgs = ((InternalEObject)newProcess).eInverseAdd(this, Bpmn2Package.PROCESS__PROCESS_ACTIONS, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, msgs);
			msgs = basicSetProcess(newProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Securebpmn2Package.PROCESS_ACTION__PROCESS, newProcess, newProcess));
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
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCompositeProcessActions()).basicAdd(otherEnd, msgs);
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProcess((eu.aniketos.mtm.model.mtm_bpmn2.Process)otherEnd, msgs);
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
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				return ((InternalEList<?>)getCompositeProcessActions()).basicRemove(otherEnd, msgs);
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				return basicSetProcess(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				return eInternalContainer().eInverseRemove(this, Bpmn2Package.PROCESS__PROCESS_ACTIONS, eu.aniketos.mtm.model.mtm_bpmn2.Process.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				return getCompositeProcessActions();
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				return getProcess();
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
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				getCompositeProcessActions().clear();
				getCompositeProcessActions().addAll((Collection<? extends CompositeProcessAction>)newValue);
				return;
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				setProcess((eu.aniketos.mtm.model.mtm_bpmn2.Process)newValue);
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
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				getCompositeProcessActions().clear();
				return;
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				setProcess((eu.aniketos.mtm.model.mtm_bpmn2.Process)null);
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
			case Securebpmn2Package.PROCESS_ACTION__COMPOSITE_PROCESS_ACTIONS:
				return compositeProcessActions != null && !compositeProcessActions.isEmpty();
			case Securebpmn2Package.PROCESS_ACTION__PROCESS:
				return getProcess() != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessActionImpl
