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

import eu.aniketos.mtm.model.mtm_bpmn2.ActivitiListener;
import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;

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
 * An implementation of the model object '<em><b>Activiti Listener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getFieldExtensions <em>Field Extensions</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getRunAs <em>Run As</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.impl.ActivitiListenerImpl#getScriptProcessor <em>Script Processor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivitiListenerImpl extends BaseElementImpl implements ActivitiListener {
	/**
	 * The default value of the '{@link #getImplementationType() <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationType()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationType() <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationType()
	 * @generated
	 * @ordered
	 */
	protected String implementationType = IMPLEMENTATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected String implementation = IMPLEMENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected String event = EVENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFieldExtensions() <em>Field Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<FieldExtension> fieldExtensions;

	/**
	 * The default value of the '{@link #getRunAs() <em>Run As</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunAs()
	 * @generated
	 * @ordered
	 */
	protected static final String RUN_AS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRunAs() <em>Run As</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunAs()
	 * @generated
	 * @ordered
	 */
	protected String runAs = RUN_AS_EDEFAULT;

	/**
	 * The default value of the '{@link #getScriptProcessor() <em>Script Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptProcessor()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_PROCESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScriptProcessor() <em>Script Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptProcessor()
	 * @generated
	 * @ordered
	 */
	protected String scriptProcessor = SCRIPT_PROCESSOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivitiListenerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.Literals.ACTIVITI_LISTENER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationType() {
		return implementationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationType(String newImplementationType) {
		String oldImplementationType = implementationType;
		implementationType = newImplementationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION_TYPE, oldImplementationType, implementationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(String newImplementation) {
		String oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(String newEvent) {
		String oldEvent = event;
		event = newEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ACTIVITI_LISTENER__EVENT, oldEvent, event));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FieldExtension> getFieldExtensions() {
		if (fieldExtensions == null) {
			fieldExtensions = new EObjectContainmentEList<FieldExtension>(FieldExtension.class, this, Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS);
		}
		return fieldExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRunAs() {
		return runAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunAs(String newRunAs) {
		String oldRunAs = runAs;
		runAs = newRunAs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ACTIVITI_LISTENER__RUN_AS, oldRunAs, runAs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScriptProcessor() {
		return scriptProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScriptProcessor(String newScriptProcessor) {
		String oldScriptProcessor = scriptProcessor;
		scriptProcessor = newScriptProcessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ACTIVITI_LISTENER__SCRIPT_PROCESSOR, oldScriptProcessor, scriptProcessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS:
				return ((InternalEList<?>)getFieldExtensions()).basicRemove(otherEnd, msgs);
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
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION_TYPE:
				return getImplementationType();
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION:
				return getImplementation();
			case Bpmn2Package.ACTIVITI_LISTENER__EVENT:
				return getEvent();
			case Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS:
				return getFieldExtensions();
			case Bpmn2Package.ACTIVITI_LISTENER__RUN_AS:
				return getRunAs();
			case Bpmn2Package.ACTIVITI_LISTENER__SCRIPT_PROCESSOR:
				return getScriptProcessor();
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
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION_TYPE:
				setImplementationType((String)newValue);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION:
				setImplementation((String)newValue);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__EVENT:
				setEvent((String)newValue);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS:
				getFieldExtensions().clear();
				getFieldExtensions().addAll((Collection<? extends FieldExtension>)newValue);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__RUN_AS:
				setRunAs((String)newValue);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__SCRIPT_PROCESSOR:
				setScriptProcessor((String)newValue);
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
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION_TYPE:
				setImplementationType(IMPLEMENTATION_TYPE_EDEFAULT);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION:
				setImplementation(IMPLEMENTATION_EDEFAULT);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__EVENT:
				setEvent(EVENT_EDEFAULT);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS:
				getFieldExtensions().clear();
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__RUN_AS:
				setRunAs(RUN_AS_EDEFAULT);
				return;
			case Bpmn2Package.ACTIVITI_LISTENER__SCRIPT_PROCESSOR:
				setScriptProcessor(SCRIPT_PROCESSOR_EDEFAULT);
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
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION_TYPE:
				return IMPLEMENTATION_TYPE_EDEFAULT == null ? implementationType != null : !IMPLEMENTATION_TYPE_EDEFAULT.equals(implementationType);
			case Bpmn2Package.ACTIVITI_LISTENER__IMPLEMENTATION:
				return IMPLEMENTATION_EDEFAULT == null ? implementation != null : !IMPLEMENTATION_EDEFAULT.equals(implementation);
			case Bpmn2Package.ACTIVITI_LISTENER__EVENT:
				return EVENT_EDEFAULT == null ? event != null : !EVENT_EDEFAULT.equals(event);
			case Bpmn2Package.ACTIVITI_LISTENER__FIELD_EXTENSIONS:
				return fieldExtensions != null && !fieldExtensions.isEmpty();
			case Bpmn2Package.ACTIVITI_LISTENER__RUN_AS:
				return RUN_AS_EDEFAULT == null ? runAs != null : !RUN_AS_EDEFAULT.equals(runAs);
			case Bpmn2Package.ACTIVITI_LISTENER__SCRIPT_PROCESSOR:
				return SCRIPT_PROCESSOR_EDEFAULT == null ? scriptProcessor != null : !SCRIPT_PROCESSOR_EDEFAULT.equals(scriptProcessor);
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
		result.append(" (implementationType: ");
		result.append(implementationType);
		result.append(", implementation: ");
		result.append(implementation);
		result.append(", event: ");
		result.append(event);
		result.append(", runAs: ");
		result.append(runAs);
		result.append(", scriptProcessor: ");
		result.append(scriptProcessor);
		result.append(')');
		return result.toString();
	}

} //ActivitiListenerImpl
