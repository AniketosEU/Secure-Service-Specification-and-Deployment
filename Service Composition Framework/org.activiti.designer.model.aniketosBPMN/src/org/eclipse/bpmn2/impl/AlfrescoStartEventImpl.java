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

import org.eclipse.bpmn2.AlfrescoScriptBase;
import org.eclipse.bpmn2.AlfrescoStartEvent;
import org.eclipse.bpmn2.Bpmn2Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alfresco Start Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.impl.AlfrescoStartEventImpl#getRunAs <em>Run As</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.impl.AlfrescoStartEventImpl#getScriptProcessor <em>Script Processor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlfrescoStartEventImpl extends StartEventImpl implements AlfrescoStartEvent {
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
	protected AlfrescoStartEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bpmn2Package.eINSTANCE.getAlfrescoStartEvent();
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
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS, oldRunAs, runAs));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR, oldScriptProcessor, scriptProcessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS:
				return getRunAs();
			case Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR:
				return getScriptProcessor();
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
			case Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS:
				setRunAs((String)newValue);
				return;
			case Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR:
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
			case Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS:
				setRunAs(RUN_AS_EDEFAULT);
				return;
			case Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR:
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
			case Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS:
				return RUN_AS_EDEFAULT == null ? runAs != null : !RUN_AS_EDEFAULT.equals(runAs);
			case Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AlfrescoScriptBase.class) {
			switch (derivedFeatureID) {
				case Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS: return Bpmn2Package.ALFRESCO_SCRIPT_BASE__RUN_AS;
				case Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR: return Bpmn2Package.ALFRESCO_SCRIPT_BASE__SCRIPT_PROCESSOR;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AlfrescoScriptBase.class) {
			switch (baseFeatureID) {
				case Bpmn2Package.ALFRESCO_SCRIPT_BASE__RUN_AS: return Bpmn2Package.ALFRESCO_START_EVENT__RUN_AS;
				case Bpmn2Package.ALFRESCO_SCRIPT_BASE__SCRIPT_PROCESSOR: return Bpmn2Package.ALFRESCO_START_EVENT__SCRIPT_PROCESSOR;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (runAs: ");
		result.append(runAs);
		result.append(", scriptProcessor: ");
		result.append(scriptProcessor);
		result.append(')');
		return result.toString();
	}

} //AlfrescoStartEventImpl
