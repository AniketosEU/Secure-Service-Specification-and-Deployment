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
import eu.aniketos.mtm.model.mtm_bpmn2.DataInput;
import eu.aniketos.mtm.model.mtm_bpmn2.DataInputAssociation;
import eu.aniketos.mtm.model.mtm_bpmn2.EventDefinition;
import eu.aniketos.mtm.model.mtm_bpmn2.InputSet;
import eu.aniketos.mtm.model.mtm_bpmn2.ThrowEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throw Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ThrowEventImpl#getDataInputs <em>Data Inputs</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ThrowEventImpl#getDataInputAssociation <em>Data Input Association</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ThrowEventImpl#getInputSet <em>Input Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ThrowEventImpl#getEventDefinitions <em>Event Definitions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ThrowEventImpl#getEventDefinitionRefs <em>Event Definition Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ThrowEventImpl extends EventImpl implements ThrowEvent {
	/**
	 * The cached value of the '{@link #getDataInputs() <em>Data Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInput> dataInputs;

	/**
	 * The cached value of the '{@link #getDataInputAssociation() <em>Data Input Association</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInputAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList<DataInputAssociation> dataInputAssociation;

	/**
	 * The cached value of the '{@link #getInputSet() <em>Input Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSet()
	 * @generated
	 * @ordered
	 */
	protected InputSet inputSet;

	/**
	 * The cached value of the '{@link #getEventDefinitions() <em>Event Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDefinition> eventDefinitions;

	/**
	 * The cached value of the '{@link #getEventDefinitionRefs() <em>Event Definition Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventDefinitionRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDefinition> eventDefinitionRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.THROW_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInput> getDataInputs() {
		if (dataInputs == null) {
			dataInputs = new EObjectContainmentEList<DataInput>(DataInput.class, this, Bpmn2Package.THROW_EVENT__DATA_INPUTS);
		}
		return dataInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataInputAssociation> getDataInputAssociation() {
		if (dataInputAssociation == null) {
			dataInputAssociation = new EObjectContainmentEList<DataInputAssociation>(DataInputAssociation.class, this, Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION);
		}
		return dataInputAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSet getInputSet() {
		return inputSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputSet(InputSet newInputSet, NotificationChain msgs) {
		InputSet oldInputSet = inputSet;
		inputSet = newInputSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bpmn2Package.THROW_EVENT__INPUT_SET, oldInputSet, newInputSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSet(InputSet newInputSet) {
		if (newInputSet != inputSet) {
			NotificationChain msgs = null;
			if (inputSet != null)
				msgs = ((InternalEObject)inputSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.THROW_EVENT__INPUT_SET, null, msgs);
			if (newInputSet != null)
				msgs = ((InternalEObject)newInputSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bpmn2Package.THROW_EVENT__INPUT_SET, null, msgs);
			msgs = basicSetInputSet(newInputSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.THROW_EVENT__INPUT_SET, newInputSet, newInputSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDefinition> getEventDefinitions() {
		if (eventDefinitions == null) {
			eventDefinitions = new EObjectContainmentEList<EventDefinition>(EventDefinition.class, this, Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS);
		}
		return eventDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDefinition> getEventDefinitionRefs() {
		if (eventDefinitionRefs == null) {
			eventDefinitionRefs = new EObjectResolvingEList<EventDefinition>(EventDefinition.class, this, Bpmn2Package.THROW_EVENT__EVENT_DEFINITION_REFS);
		}
		return eventDefinitionRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.THROW_EVENT__DATA_INPUTS:
				return ((InternalEList<?>)getDataInputs()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				return ((InternalEList<?>)getDataInputAssociation()).basicRemove(otherEnd, msgs);
			case Bpmn2Package.THROW_EVENT__INPUT_SET:
				return basicSetInputSet(null, msgs);
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS:
				return ((InternalEList<?>)getEventDefinitions()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.THROW_EVENT__DATA_INPUTS:
				return getDataInputs();
			case Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				return getDataInputAssociation();
			case Bpmn2Package.THROW_EVENT__INPUT_SET:
				return getInputSet();
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS:
				return getEventDefinitions();
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITION_REFS:
				return getEventDefinitionRefs();
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
			case Bpmn2Package.THROW_EVENT__DATA_INPUTS:
				getDataInputs().clear();
				getDataInputs().addAll((Collection<? extends DataInput>)newValue);
				return;
			case Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				getDataInputAssociation().clear();
				getDataInputAssociation().addAll((Collection<? extends DataInputAssociation>)newValue);
				return;
			case Bpmn2Package.THROW_EVENT__INPUT_SET:
				setInputSet((InputSet)newValue);
				return;
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS:
				getEventDefinitions().clear();
				getEventDefinitions().addAll((Collection<? extends EventDefinition>)newValue);
				return;
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITION_REFS:
				getEventDefinitionRefs().clear();
				getEventDefinitionRefs().addAll((Collection<? extends EventDefinition>)newValue);
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
			case Bpmn2Package.THROW_EVENT__DATA_INPUTS:
				getDataInputs().clear();
				return;
			case Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				getDataInputAssociation().clear();
				return;
			case Bpmn2Package.THROW_EVENT__INPUT_SET:
				setInputSet((InputSet)null);
				return;
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS:
				getEventDefinitions().clear();
				return;
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITION_REFS:
				getEventDefinitionRefs().clear();
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
			case Bpmn2Package.THROW_EVENT__DATA_INPUTS:
				return dataInputs != null && !dataInputs.isEmpty();
			case Bpmn2Package.THROW_EVENT__DATA_INPUT_ASSOCIATION:
				return dataInputAssociation != null && !dataInputAssociation.isEmpty();
			case Bpmn2Package.THROW_EVENT__INPUT_SET:
				return inputSet != null;
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITIONS:
				return eventDefinitions != null && !eventDefinitions.isEmpty();
			case Bpmn2Package.THROW_EVENT__EVENT_DEFINITION_REFS:
				return eventDefinitionRefs != null && !eventDefinitionRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ThrowEventImpl
