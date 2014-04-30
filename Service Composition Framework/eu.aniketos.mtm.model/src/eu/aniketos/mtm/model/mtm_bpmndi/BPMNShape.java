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
package eu.aniketos.mtm.model.mtm_bpmndi;

import eu.aniketos.mtm.model.mtm_di.LabeledShape;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBPMNLabel <em>BPMN Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBpmnElement <em>Bpmn Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded <em>Is Expanded</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal <em>Is Horizontal</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible <em>Is Message Visible</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind <em>Participant Band Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape()
 * @model extendedMetaData="name='BPMNShape' kind='elementOnly'"
 * @generated
 */
public interface BPMNShape extends LabeledShape {
	/**
	 * Returns the value of the '<em><b>BPMN Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BPMN Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BPMN Label</em>' containment reference.
	 * @see #setBPMNLabel(BPMNLabel)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_BPMNLabel()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BPMNLabel' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNLabel getBPMNLabel();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBPMNLabel <em>BPMN Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BPMN Label</em>' containment reference.
	 * @see #getBPMNLabel()
	 * @generated
	 */
	void setBPMNLabel(BPMNLabel value);

	/**
	 * Returns the value of the '<em><b>Bpmn Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bpmn Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bpmn Element</em>' attribute.
	 * @see #setBpmnElement(QName)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_BpmnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='bpmnElement'"
	 * @generated
	 */
	QName getBpmnElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getBpmnElement <em>Bpmn Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bpmn Element</em>' attribute.
	 * @see #getBpmnElement()
	 * @generated
	 */
	void setBpmnElement(QName value);

	/**
	 * Returns the value of the '<em><b>Choreography Activity Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choreography Activity Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choreography Activity Shape</em>' attribute.
	 * @see #setChoreographyActivityShape(QName)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_ChoreographyActivityShape()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='choreographyActivityShape'"
	 * @generated
	 */
	QName getChoreographyActivityShape();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getChoreographyActivityShape <em>Choreography Activity Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choreography Activity Shape</em>' attribute.
	 * @see #getChoreographyActivityShape()
	 * @generated
	 */
	void setChoreographyActivityShape(QName value);

	/**
	 * Returns the value of the '<em><b>Is Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Expanded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Expanded</em>' attribute.
	 * @see #isSetIsExpanded()
	 * @see #unsetIsExpanded()
	 * @see #setIsExpanded(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_IsExpanded()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isExpanded'"
	 * @generated
	 */
	boolean isIsExpanded();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded <em>Is Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Expanded</em>' attribute.
	 * @see #isSetIsExpanded()
	 * @see #unsetIsExpanded()
	 * @see #isIsExpanded()
	 * @generated
	 */
	void setIsExpanded(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded <em>Is Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsExpanded()
	 * @see #isIsExpanded()
	 * @see #setIsExpanded(boolean)
	 * @generated
	 */
	void unsetIsExpanded();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsExpanded <em>Is Expanded</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Expanded</em>' attribute is set.
	 * @see #unsetIsExpanded()
	 * @see #isIsExpanded()
	 * @see #setIsExpanded(boolean)
	 * @generated
	 */
	boolean isSetIsExpanded();

	/**
	 * Returns the value of the '<em><b>Is Horizontal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Horizontal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Horizontal</em>' attribute.
	 * @see #isSetIsHorizontal()
	 * @see #unsetIsHorizontal()
	 * @see #setIsHorizontal(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_IsHorizontal()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isHorizontal'"
	 * @generated
	 */
	boolean isIsHorizontal();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Horizontal</em>' attribute.
	 * @see #isSetIsHorizontal()
	 * @see #unsetIsHorizontal()
	 * @see #isIsHorizontal()
	 * @generated
	 */
	void setIsHorizontal(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsHorizontal()
	 * @see #isIsHorizontal()
	 * @see #setIsHorizontal(boolean)
	 * @generated
	 */
	void unsetIsHorizontal();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsHorizontal <em>Is Horizontal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Horizontal</em>' attribute is set.
	 * @see #unsetIsHorizontal()
	 * @see #isIsHorizontal()
	 * @see #setIsHorizontal(boolean)
	 * @generated
	 */
	boolean isSetIsHorizontal();

	/**
	 * Returns the value of the '<em><b>Is Marker Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Marker Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Marker Visible</em>' attribute.
	 * @see #isSetIsMarkerVisible()
	 * @see #unsetIsMarkerVisible()
	 * @see #setIsMarkerVisible(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_IsMarkerVisible()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isMarkerVisible'"
	 * @generated
	 */
	boolean isIsMarkerVisible();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Marker Visible</em>' attribute.
	 * @see #isSetIsMarkerVisible()
	 * @see #unsetIsMarkerVisible()
	 * @see #isIsMarkerVisible()
	 * @generated
	 */
	void setIsMarkerVisible(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsMarkerVisible()
	 * @see #isIsMarkerVisible()
	 * @see #setIsMarkerVisible(boolean)
	 * @generated
	 */
	void unsetIsMarkerVisible();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMarkerVisible <em>Is Marker Visible</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Marker Visible</em>' attribute is set.
	 * @see #unsetIsMarkerVisible()
	 * @see #isIsMarkerVisible()
	 * @see #setIsMarkerVisible(boolean)
	 * @generated
	 */
	boolean isSetIsMarkerVisible();

	/**
	 * Returns the value of the '<em><b>Is Message Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Message Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Message Visible</em>' attribute.
	 * @see #isSetIsMessageVisible()
	 * @see #unsetIsMessageVisible()
	 * @see #setIsMessageVisible(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_IsMessageVisible()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isMessageVisible'"
	 * @generated
	 */
	boolean isIsMessageVisible();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Message Visible</em>' attribute.
	 * @see #isSetIsMessageVisible()
	 * @see #unsetIsMessageVisible()
	 * @see #isIsMessageVisible()
	 * @generated
	 */
	void setIsMessageVisible(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsMessageVisible()
	 * @see #isIsMessageVisible()
	 * @see #setIsMessageVisible(boolean)
	 * @generated
	 */
	void unsetIsMessageVisible();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#isIsMessageVisible <em>Is Message Visible</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Message Visible</em>' attribute is set.
	 * @see #unsetIsMessageVisible()
	 * @see #isIsMessageVisible()
	 * @see #setIsMessageVisible(boolean)
	 * @generated
	 */
	boolean isSetIsMessageVisible();

	/**
	 * Returns the value of the '<em><b>Participant Band Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant Band Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant Band Kind</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @see #isSetParticipantBandKind()
	 * @see #unsetParticipantBandKind()
	 * @see #setParticipantBandKind(ParticipantBandKind)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNShape_ParticipantBandKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='participantBandKind'"
	 * @generated
	 */
	ParticipantBandKind getParticipantBandKind();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant Band Kind</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.ParticipantBandKind
	 * @see #isSetParticipantBandKind()
	 * @see #unsetParticipantBandKind()
	 * @see #getParticipantBandKind()
	 * @generated
	 */
	void setParticipantBandKind(ParticipantBandKind value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParticipantBandKind()
	 * @see #getParticipantBandKind()
	 * @see #setParticipantBandKind(ParticipantBandKind)
	 * @generated
	 */
	void unsetParticipantBandKind();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNShape#getParticipantBandKind <em>Participant Band Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Participant Band Kind</em>' attribute is set.
	 * @see #unsetParticipantBandKind()
	 * @see #getParticipantBandKind()
	 * @see #setParticipantBandKind(ParticipantBandKind)
	 * @generated
	 */
	boolean isSetParticipantBandKind();

} // BPMNShape
