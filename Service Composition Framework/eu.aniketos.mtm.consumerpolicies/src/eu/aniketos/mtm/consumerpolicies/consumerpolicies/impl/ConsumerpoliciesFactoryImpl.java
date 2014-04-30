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

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConsumerpoliciesFactoryImpl extends EFactoryImpl implements ConsumerpoliciesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConsumerpoliciesFactory init() {
		try {
			ConsumerpoliciesFactory theConsumerpoliciesFactory = (ConsumerpoliciesFactory)EPackage.Registry.INSTANCE.getEFactory("http://eu.aniketos.mtm/consumerpolicies"); 
			if (theConsumerpoliciesFactory != null) {
				return theConsumerpoliciesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConsumerpoliciesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerpoliciesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ConsumerpoliciesPackage.TRUSTWORTHINESS: return createTrustworthiness();
			case ConsumerpoliciesPackage.AVAILABILITY: return createAvailability();
			case ConsumerpoliciesPackage.INTEGRITY: return createIntegrity();
			case ConsumerpoliciesPackage.NO_DELEGATION: return createNoDelegation();
			case ConsumerpoliciesPackage.NO_REPUDIATION: return createNoRepudiation();
			case ConsumerpoliciesPackage.BINDING_OF_DUTY: return createBindingOfDuty();
			case ConsumerpoliciesPackage.SEPARATION_OF_DUTY: return createSeparationOfDuty();
			case ConsumerpoliciesPackage.CONFIDENTIALITY: return createConfidentiality();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trustworthiness createTrustworthiness() {
		TrustworthinessImpl trustworthiness = new TrustworthinessImpl();
		return trustworthiness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Availability createAvailability() {
		AvailabilityImpl availability = new AvailabilityImpl();
		return availability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integrity createIntegrity() {
		IntegrityImpl integrity = new IntegrityImpl();
		return integrity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoDelegation createNoDelegation() {
		NoDelegationImpl noDelegation = new NoDelegationImpl();
		return noDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoRepudiation createNoRepudiation() {
		NoRepudiationImpl noRepudiation = new NoRepudiationImpl();
		return noRepudiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingOfDuty createBindingOfDuty() {
		BindingOfDutyImpl bindingOfDuty = new BindingOfDutyImpl();
		return bindingOfDuty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparationOfDuty createSeparationOfDuty() {
		SeparationOfDutyImpl separationOfDuty = new SeparationOfDutyImpl();
		return separationOfDuty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Confidentiality createConfidentiality() {
		ConfidentialityImpl confidentiality = new ConfidentialityImpl();
		return confidentiality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsumerpoliciesPackage getConsumerpoliciesPackage() {
		return (ConsumerpoliciesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConsumerpoliciesPackage getPackage() {
		return ConsumerpoliciesPackage.eINSTANCE;
	}

} //ConsumerpoliciesFactoryImpl
