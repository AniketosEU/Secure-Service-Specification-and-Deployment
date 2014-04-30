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
 * A representation of the model object '<em><b>Del Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.DelType#getSource <em>Source</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.DelType#getDestination <em>Destination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.DelType#getGoalSet <em>Goal Set</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.DelType#getTransferable <em>Transferable</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.srs.SrsPackage#getDelType()
 * @model extendedMetaData="name='delType' kind='elementOnly'"
 * @generated
 */
public interface DelType extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(ActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getDelType_Source()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='source' namespace='##targetNamespace'"
	 * @generated
	 */
	ActorType getSource();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.DelType#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ActorType value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(ActorType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getDelType_Destination()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='destination' namespace='##targetNamespace'"
	 * @generated
	 */
	ActorType getDestination();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.DelType#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ActorType value);

	/**
	 * Returns the value of the '<em><b>Goal Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal Set</em>' containment reference.
	 * @see #setGoalSet(GoalSetType)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getDelType_GoalSet()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='goalSet' namespace='##targetNamespace'"
	 * @generated
	 */
	GoalSetType getGoalSet();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.DelType#getGoalSet <em>Goal Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal Set</em>' containment reference.
	 * @see #getGoalSet()
	 * @generated
	 */
	void setGoalSet(GoalSetType value);

	/**
	 * Returns the value of the '<em><b>Transferable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transferable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transferable</em>' attribute.
	 * @see #setTransferable(String)
	 * @see eu.aniketos.mtm.srs.SrsPackage#getDelType_Transferable()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='transferable' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTransferable();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.srs.DelType#getTransferable <em>Transferable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transferable</em>' attribute.
	 * @see #getTransferable()
	 * @generated
	 */
	void setTransferable(String value);

} // DelType
