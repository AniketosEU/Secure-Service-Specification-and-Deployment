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

import eu.aniketos.mtm.model.mtm_di.LabeledEdge;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBPMNLabel <em>BPMN Label</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBpmnElement <em>Bpmn Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge()
 * @model extendedMetaData="name='BPMNEdge' kind='elementOnly'"
 * @generated
 */
public interface BPMNEdge extends LabeledEdge {
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
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge_BPMNLabel()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BPMNLabel' namespace='##targetNamespace'"
	 * @generated
	 */
	BPMNLabel getBPMNLabel();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBPMNLabel <em>BPMN Label</em>}' containment reference.
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
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge_BpmnElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='bpmnElement'"
	 * @generated
	 */
	QName getBpmnElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getBpmnElement <em>Bpmn Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bpmn Element</em>' attribute.
	 * @see #getBpmnElement()
	 * @generated
	 */
	void setBpmnElement(QName value);

	/**
	 * Returns the value of the '<em><b>Message Visible Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Visible Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Visible Kind</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @see #isSetMessageVisibleKind()
	 * @see #unsetMessageVisibleKind()
	 * @see #setMessageVisibleKind(MessageVisibleKind)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge_MessageVisibleKind()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='messageVisibleKind'"
	 * @generated
	 */
	MessageVisibleKind getMessageVisibleKind();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Visible Kind</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.MessageVisibleKind
	 * @see #isSetMessageVisibleKind()
	 * @see #unsetMessageVisibleKind()
	 * @see #getMessageVisibleKind()
	 * @generated
	 */
	void setMessageVisibleKind(MessageVisibleKind value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMessageVisibleKind()
	 * @see #getMessageVisibleKind()
	 * @see #setMessageVisibleKind(MessageVisibleKind)
	 * @generated
	 */
	void unsetMessageVisibleKind();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Message Visible Kind</em>' attribute is set.
	 * @see #unsetMessageVisibleKind()
	 * @see #getMessageVisibleKind()
	 * @see #setMessageVisibleKind(MessageVisibleKind)
	 * @generated
	 */
	boolean isSetMessageVisibleKind();

	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' attribute.
	 * @see #setSourceElement(QName)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge_SourceElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='sourceElement'"
	 * @generated
	 */
	QName getSourceElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getSourceElement <em>Source Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' attribute.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(QName value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' attribute.
	 * @see #setTargetElement(QName)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNEdge_TargetElement()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='targetElement'"
	 * @generated
	 */
	QName getTargetElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNEdge#getTargetElement <em>Target Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' attribute.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(QName value);

} // BPMNEdge
