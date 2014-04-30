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
package eu.aniketos.mtm.srs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Post Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonDelegation <em>Non Delegation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonRepudiation <em>Non Repudiation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getRedundancy <em>Redundancy</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNeedToKnow <em>Need To Know</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonDisclosure <em>Non Disclosure</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonModification <em>Non Modification</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonUsage <em>Non Usage</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNonProduction <em>Non Production</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getPlayBoth <em>Play Both</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNotPlayBoth <em>Not Play Both</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getAchieveInCombination <em>Achieve In Combination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getNotAchieveInCombination <em>Not Achieve In Combination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getAvailability <em>Availability</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.PostType#getDelegation <em>Delegation</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType()
 * @model extendedMetaData="name='postType' kind='elementOnly'"
 * @generated
 */
public interface PostType extends EObject {
	/**
	 * Returns the value of the '<em><b>Non Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Delegation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Delegation</em>' containment reference.
	 * @see #setNonDelegation(NDType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonDelegation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-delegation' namespace='##targetNamespace'"
	 * @generated
	 */
	NDType getNonDelegation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonDelegation <em>Non Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Delegation</em>' containment reference.
	 * @see #getNonDelegation()
	 * @generated
	 */
	void setNonDelegation(NDType value);

	/**
	 * Returns the value of the '<em><b>Non Repudiation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Repudiation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Repudiation</em>' containment reference.
	 * @see #setNonRepudiation(NRType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonRepudiation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-repudiation' namespace='##targetNamespace'"
	 * @generated
	 */
	NRType getNonRepudiation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonRepudiation <em>Non Repudiation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Repudiation</em>' containment reference.
	 * @see #getNonRepudiation()
	 * @generated
	 */
	void setNonRepudiation(NRType value);

	/**
	 * Returns the value of the '<em><b>Redundancy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redundancy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redundancy</em>' containment reference.
	 * @see #setRedundancy(RedType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_Redundancy()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='redundancy' namespace='##targetNamespace'"
	 * @generated
	 */
	RedType getRedundancy();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getRedundancy <em>Redundancy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Redundancy</em>' containment reference.
	 * @see #getRedundancy()
	 * @generated
	 */
	void setRedundancy(RedType value);

	/**
	 * Returns the value of the '<em><b>Need To Know</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need To Know</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need To Know</em>' containment reference.
	 * @see #setNeedToKnow(NTKType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NeedToKnow()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='needToKnow' namespace='##targetNamespace'"
	 * @generated
	 */
	NTKType getNeedToKnow();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNeedToKnow <em>Need To Know</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need To Know</em>' containment reference.
	 * @see #getNeedToKnow()
	 * @generated
	 */
	void setNeedToKnow(NTKType value);

	/**
	 * Returns the value of the '<em><b>Non Disclosure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Disclosure</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Disclosure</em>' containment reference.
	 * @see #setNonDisclosure(AuthType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonDisclosure()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-disclosure' namespace='##targetNamespace'"
	 * @generated
	 */
	AuthType getNonDisclosure();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonDisclosure <em>Non Disclosure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Disclosure</em>' containment reference.
	 * @see #getNonDisclosure()
	 * @generated
	 */
	void setNonDisclosure(AuthType value);

	/**
	 * Returns the value of the '<em><b>Non Modification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Modification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Modification</em>' containment reference.
	 * @see #setNonModification(AuthType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonModification()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-modification' namespace='##targetNamespace'"
	 * @generated
	 */
	AuthType getNonModification();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonModification <em>Non Modification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Modification</em>' containment reference.
	 * @see #getNonModification()
	 * @generated
	 */
	void setNonModification(AuthType value);

	/**
	 * Returns the value of the '<em><b>Non Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Usage</em>' containment reference.
	 * @see #setNonUsage(AuthType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonUsage()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-usage' namespace='##targetNamespace'"
	 * @generated
	 */
	AuthType getNonUsage();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonUsage <em>Non Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Usage</em>' containment reference.
	 * @see #getNonUsage()
	 * @generated
	 */
	void setNonUsage(AuthType value);

	/**
	 * Returns the value of the '<em><b>Non Production</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Production</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Production</em>' containment reference.
	 * @see #setNonProduction(AuthType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NonProduction()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='non-production' namespace='##targetNamespace'"
	 * @generated
	 */
	AuthType getNonProduction();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNonProduction <em>Non Production</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Production</em>' containment reference.
	 * @see #getNonProduction()
	 * @generated
	 */
	void setNonProduction(AuthType value);

	/**
	 * Returns the value of the '<em><b>Play Both</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Play Both</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Both</em>' containment reference.
	 * @see #setPlayBoth(BoDSoDActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_PlayBoth()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='play-both' namespace='##targetNamespace'"
	 * @generated
	 */
	BoDSoDActorType getPlayBoth();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getPlayBoth <em>Play Both</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play Both</em>' containment reference.
	 * @see #getPlayBoth()
	 * @generated
	 */
	void setPlayBoth(BoDSoDActorType value);

	/**
	 * Returns the value of the '<em><b>Not Play Both</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Play Both</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Play Both</em>' containment reference.
	 * @see #setNotPlayBoth(BoDSoDActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NotPlayBoth()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='not-play-both' namespace='##targetNamespace'"
	 * @generated
	 */
	BoDSoDActorType getNotPlayBoth();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNotPlayBoth <em>Not Play Both</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Play Both</em>' containment reference.
	 * @see #getNotPlayBoth()
	 * @generated
	 */
	void setNotPlayBoth(BoDSoDActorType value);

	/**
	 * Returns the value of the '<em><b>Achieve In Combination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Achieve In Combination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Achieve In Combination</em>' containment reference.
	 * @see #setAchieveInCombination(BoDSoDGoalType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_AchieveInCombination()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='achieve-in-combination' namespace='##targetNamespace'"
	 * @generated
	 */
	BoDSoDGoalType getAchieveInCombination();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getAchieveInCombination <em>Achieve In Combination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Achieve In Combination</em>' containment reference.
	 * @see #getAchieveInCombination()
	 * @generated
	 */
	void setAchieveInCombination(BoDSoDGoalType value);

	/**
	 * Returns the value of the '<em><b>Not Achieve In Combination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Achieve In Combination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Achieve In Combination</em>' containment reference.
	 * @see #setNotAchieveInCombination(BoDSoDGoalType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_NotAchieveInCombination()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='not-achieve-in-combination' namespace='##targetNamespace'"
	 * @generated
	 */
	BoDSoDGoalType getNotAchieveInCombination();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getNotAchieveInCombination <em>Not Achieve In Combination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Achieve In Combination</em>' containment reference.
	 * @see #getNotAchieveInCombination()
	 * @generated
	 */
	void setNotAchieveInCombination(BoDSoDGoalType value);

	/**
	 * Returns the value of the '<em><b>Integrity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integrity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integrity</em>' containment reference.
	 * @see #setIntegrity(IntegrityType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_Integrity()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='integrity' namespace='##targetNamespace'"
	 * @generated
	 */
	IntegrityType getIntegrity();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getIntegrity <em>Integrity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integrity</em>' containment reference.
	 * @see #getIntegrity()
	 * @generated
	 */
	void setIntegrity(IntegrityType value);

	/**
	 * Returns the value of the '<em><b>Availability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Availability</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Availability</em>' containment reference.
	 * @see #setAvailability(AvailabilityType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_Availability()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='availability' namespace='##targetNamespace'"
	 * @generated
	 */
	AvailabilityType getAvailability();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getAvailability <em>Availability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Availability</em>' containment reference.
	 * @see #getAvailability()
	 * @generated
	 */
	void setAvailability(AvailabilityType value);

	/**
	 * Returns the value of the '<em><b>Confidentiality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confidentiality</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidentiality</em>' containment reference.
	 * @see #setConfidentiality(ConfidentialityType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_Confidentiality()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='confidentiality' namespace='##targetNamespace'"
	 * @generated
	 */
	ConfidentialityType getConfidentiality();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getConfidentiality <em>Confidentiality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidentiality</em>' containment reference.
	 * @see #getConfidentiality()
	 * @generated
	 */
	void setConfidentiality(ConfidentialityType value);

	/**
	 * Returns the value of the '<em><b>Delegation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegation</em>' containment reference.
	 * @see #setDelegation(DelType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getPostType_Delegation()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='delegation' namespace='##targetNamespace'"
	 * @generated
	 */
	DelType getDelegation();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.PostType#getDelegation <em>Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegation</em>' containment reference.
	 * @see #getDelegation()
	 * @generated
	 */
	void setDelegation(DelType value);

} // PostType
