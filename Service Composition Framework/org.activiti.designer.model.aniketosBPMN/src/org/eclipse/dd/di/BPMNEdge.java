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
package org.eclipse.dd.di;

import org.eclipse.bpmn2.BaseElement;

import org.eclipse.bpmn2.di.DiagramElement;
import org.eclipse.bpmn2.di.LabeledEdge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.dd.di.BPMNEdge#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.dd.di.BPMNEdge#getBpmnElement <em>Bpmn Element</em>}</li>
 *   <li>{@link org.eclipse.dd.di.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}</li>
 *   <li>{@link org.eclipse.dd.di.BPMNEdge#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link org.eclipse.dd.di.BPMNEdge#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge()
 * @model extendedMetaData="name='BPMNEdge' kind='elementOnly'"
 * @generated
 */
public interface BPMNEdge extends LabeledEdge {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' containment reference.
	 * @see #setLabel(BPMNLabel)
	 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge_Label()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='BPMNLabel' namespace='http://www.omg.org/spec/BPMN/20100524/DI'"
	 * @generated
	 */
	BPMNLabel getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.di.BPMNEdge#getLabel <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' containment reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(BPMNLabel value);

	/**
	 * Returns the value of the '<em><b>Bpmn Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bpmn Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bpmn Element</em>' reference.
	 * @see #setBpmnElement(BaseElement)
	 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge_BpmnElement()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='bpmnElement'"
	 * @generated
	 */
	BaseElement getBpmnElement();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.di.BPMNEdge#getBpmnElement <em>Bpmn Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bpmn Element</em>' reference.
	 * @see #getBpmnElement()
	 * @generated
	 */
	void setBpmnElement(BaseElement value);

	/**
	 * Returns the value of the '<em><b>Message Visible Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.dd.di.MessageVisibleKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Visible Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Visible Kind</em>' attribute.
	 * @see org.eclipse.dd.di.MessageVisibleKind
	 * @see #setMessageVisibleKind(MessageVisibleKind)
	 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge_MessageVisibleKind()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='messageVisibleKind'"
	 * @generated
	 */
	MessageVisibleKind getMessageVisibleKind();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.di.BPMNEdge#getMessageVisibleKind <em>Message Visible Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Visible Kind</em>' attribute.
	 * @see org.eclipse.dd.di.MessageVisibleKind
	 * @see #getMessageVisibleKind()
	 * @generated
	 */
	void setMessageVisibleKind(MessageVisibleKind value);

	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' reference.
	 * @see #setSourceElement(DiagramElement)
	 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge_SourceElement()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='sourceElement'"
	 * @generated
	 */
	DiagramElement getSourceElement();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.di.BPMNEdge#getSourceElement <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(DiagramElement value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' reference.
	 * @see #setTargetElement(DiagramElement)
	 * @see org.eclipse.dd.di.DiPackage#getBPMNEdge_TargetElement()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='targetElement'"
	 * @generated
	 */
	DiagramElement getTargetElement();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.di.BPMNEdge#getTargetElement <em>Target Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(DiagramElement value);

} // BPMNEdge
