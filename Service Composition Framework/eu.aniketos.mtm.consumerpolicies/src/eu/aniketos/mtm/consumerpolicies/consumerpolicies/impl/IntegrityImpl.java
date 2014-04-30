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
package eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesPackage;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integrity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl#getGuardedSender <em>Guarded Sender</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl#getProcessingService <em>Processing Service</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl#getGeneratingService <em>Generating Service</em>}</li>
 *   <li>{@link eu.aniketos.mtm.consumerpolicies.consumerpolicies.impl.IntegrityImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegrityImpl extends PolicyImpl implements Integrity {
	/**
	 * The default value of the '{@link #getGuardedSender() <em>Guarded Sender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardedSender()
	 * @generated
	 * @ordered
	 */
	protected static final String GUARDED_SENDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuardedSender() <em>Guarded Sender</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardedSender()
	 * @generated
	 * @ordered
	 */
	protected String guardedSender = GUARDED_SENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessingService() <em>Processing Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingService()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESSING_SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessingService() <em>Processing Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingService()
	 * @generated
	 * @ordered
	 */
	protected String processingService = PROCESSING_SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeneratingService() <em>Generating Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratingService()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATING_SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratingService() <em>Generating Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratingService()
	 * @generated
	 * @ordered
	 */
	protected String generatingService = GENERATING_SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected String algorithm = ALGORITHM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegrityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConsumerpoliciesPackage.Literals.INTEGRITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuardedSender() {
		return guardedSender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardedSender(String newGuardedSender) {
		String oldGuardedSender = guardedSender;
		guardedSender = newGuardedSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.INTEGRITY__GUARDED_SENDER, oldGuardedSender, guardedSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessingService() {
		return processingService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingService(String newProcessingService) {
		String oldProcessingService = processingService;
		processingService = newProcessingService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.INTEGRITY__PROCESSING_SERVICE, oldProcessingService, processingService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeneratingService() {
		return generatingService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratingService(String newGeneratingService) {
		String oldGeneratingService = generatingService;
		generatingService = newGeneratingService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.INTEGRITY__GENERATING_SERVICE, oldGeneratingService, generatingService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithm(String newAlgorithm) {
		String oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConsumerpoliciesPackage.INTEGRITY__ALGORITHM, oldAlgorithm, algorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConsumerpoliciesPackage.INTEGRITY__GUARDED_SENDER:
				return getGuardedSender();
			case ConsumerpoliciesPackage.INTEGRITY__PROCESSING_SERVICE:
				return getProcessingService();
			case ConsumerpoliciesPackage.INTEGRITY__GENERATING_SERVICE:
				return getGeneratingService();
			case ConsumerpoliciesPackage.INTEGRITY__ALGORITHM:
				return getAlgorithm();
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
			case ConsumerpoliciesPackage.INTEGRITY__GUARDED_SENDER:
				setGuardedSender((String)newValue);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__PROCESSING_SERVICE:
				setProcessingService((String)newValue);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__GENERATING_SERVICE:
				setGeneratingService((String)newValue);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__ALGORITHM:
				setAlgorithm((String)newValue);
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
			case ConsumerpoliciesPackage.INTEGRITY__GUARDED_SENDER:
				setGuardedSender(GUARDED_SENDER_EDEFAULT);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__PROCESSING_SERVICE:
				setProcessingService(PROCESSING_SERVICE_EDEFAULT);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__GENERATING_SERVICE:
				setGeneratingService(GENERATING_SERVICE_EDEFAULT);
				return;
			case ConsumerpoliciesPackage.INTEGRITY__ALGORITHM:
				setAlgorithm(ALGORITHM_EDEFAULT);
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
			case ConsumerpoliciesPackage.INTEGRITY__GUARDED_SENDER:
				return GUARDED_SENDER_EDEFAULT == null ? guardedSender != null : !GUARDED_SENDER_EDEFAULT.equals(guardedSender);
			case ConsumerpoliciesPackage.INTEGRITY__PROCESSING_SERVICE:
				return PROCESSING_SERVICE_EDEFAULT == null ? processingService != null : !PROCESSING_SERVICE_EDEFAULT.equals(processingService);
			case ConsumerpoliciesPackage.INTEGRITY__GENERATING_SERVICE:
				return GENERATING_SERVICE_EDEFAULT == null ? generatingService != null : !GENERATING_SERVICE_EDEFAULT.equals(generatingService);
			case ConsumerpoliciesPackage.INTEGRITY__ALGORITHM:
				return ALGORITHM_EDEFAULT == null ? algorithm != null : !ALGORITHM_EDEFAULT.equals(algorithm);
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
		result.append(" (guardedSender: ");
		result.append(guardedSender);
		result.append(", processingService: ");
		result.append(processingService);
		result.append(", generatingService: ");
		result.append(generatingService);
		result.append(", algorithm: ");
		result.append(algorithm);
		result.append(')');
		return result.toString();
	}

} //IntegrityImpl
