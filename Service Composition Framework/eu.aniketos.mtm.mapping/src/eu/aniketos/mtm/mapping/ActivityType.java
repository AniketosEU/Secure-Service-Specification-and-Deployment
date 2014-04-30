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
package eu.aniketos.mtm.mapping;

import java.math.BigInteger;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getValue <em>Value</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getVariable <em>Variable</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getParticipant <em>Participant</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness <em>Trustworthiness</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getThreat <em>Threat</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getId <em>Id</em>}</li>
 *   <li>{@link eu.aniketos.mtm.mapping.ActivityType#getUsertype <em>Usertype</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType()
 * @model extendedMetaData="name='activityType' kind='mixed'"
 * @generated
 */
public interface ActivityType extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.ActivityVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Variable()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='variable' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ActivityVar> getVariable();

	/**
	 * Returns the value of the '<em><b>Participant</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant</em>' attribute list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Participant()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='participant' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getParticipant();

	/**
	 * Returns the value of the '<em><b>Trustworthiness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trustworthiness</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trustworthiness</em>' attribute.
	 * @see #isSetTrustworthiness()
	 * @see #unsetTrustworthiness()
	 * @see #setTrustworthiness(float)
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Trustworthiness()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='trustworthiness' namespace='##targetNamespace'"
	 * @generated
	 */
	float getTrustworthiness();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness <em>Trustworthiness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trustworthiness</em>' attribute.
	 * @see #isSetTrustworthiness()
	 * @see #unsetTrustworthiness()
	 * @see #getTrustworthiness()
	 * @generated
	 */
	void setTrustworthiness(float value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness <em>Trustworthiness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTrustworthiness()
	 * @see #getTrustworthiness()
	 * @see #setTrustworthiness(float)
	 * @generated
	 */
	void unsetTrustworthiness();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getTrustworthiness <em>Trustworthiness</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Trustworthiness</em>' attribute is set.
	 * @see #unsetTrustworthiness()
	 * @see #getTrustworthiness()
	 * @see #setTrustworthiness(float)
	 * @generated
	 */
	boolean isSetTrustworthiness();

	/**
	 * Returns the value of the '<em><b>Integrity</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.IntegrityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integrity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integrity</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Integrity()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='integrity' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<IntegrityType> getIntegrity();

	/**
	 * Returns the value of the '<em><b>Permission</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.mapping.PermissionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission</em>' containment reference list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Permission()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='permission' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PermissionType> getPermission();

	/**
	 * Returns the value of the '<em><b>Threat</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threat</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threat</em>' attribute list.
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Threat()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='threat' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getThreat();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id' namespace='##targetNamespace'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Usertype</b></em>' attribute.
	 * The default value is <code>"UserTask"</code>.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.mapping.UsertypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usertype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usertype</em>' attribute.
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @see #isSetUsertype()
	 * @see #unsetUsertype()
	 * @see #setUsertype(UsertypeType)
	 * @see eu.aniketos.mtm.mapping.MappingPackage#getActivityType_Usertype()
	 * @model default="UserTask" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='usertype' namespace='##targetNamespace'"
	 * @generated
	 */
	UsertypeType getUsertype();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getUsertype <em>Usertype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usertype</em>' attribute.
	 * @see eu.aniketos.mtm.mapping.UsertypeType
	 * @see #isSetUsertype()
	 * @see #unsetUsertype()
	 * @see #getUsertype()
	 * @generated
	 */
	void setUsertype(UsertypeType value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getUsertype <em>Usertype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUsertype()
	 * @see #getUsertype()
	 * @see #setUsertype(UsertypeType)
	 * @generated
	 */
	void unsetUsertype();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.mapping.ActivityType#getUsertype <em>Usertype</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Usertype</em>' attribute is set.
	 * @see #unsetUsertype()
	 * @see #getUsertype()
	 * @see #setUsertype(UsertypeType)
	 * @generated
	 */
	boolean isSetUsertype();

} // ActivityType
