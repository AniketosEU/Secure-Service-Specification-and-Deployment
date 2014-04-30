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
package org.eclipse.bpmn2.di;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getOwningDiagram <em>Owning Diagram</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getOwningElement <em>Owning Element</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getOwnedElement <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.di.DiagramElement#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement()
 * @model abstract="true"
 *        extendedMetaData="name='DiagramElement' kind='elementOnly'"
 * @generated
 */
public interface DiagramElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Owning Diagram</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.di.Diagram#getRootElement <em>Root Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Diagram</em>' reference.
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_OwningDiagram()
	 * @see org.eclipse.bpmn2.di.Diagram#getRootElement
	 * @model opposite="rootElement" resolveProxies="false" transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	Diagram getOwningDiagram();

	/**
	 * Returns the value of the '<em><b>Owning Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.di.DiagramElement#getOwnedElement <em>Owned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Element</em>' reference.
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_OwningElement()
	 * @see org.eclipse.bpmn2.di.DiagramElement#getOwnedElement
	 * @model opposite="ownedElement" resolveProxies="false" transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	DiagramElement getOwningElement();

	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.di.DiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.di.DiagramElement#getOwningElement <em>Owning Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Element</em>' reference list.
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_OwnedElement()
	 * @see org.eclipse.bpmn2.di.DiagramElement#getOwningElement
	 * @model opposite="owningElement" resolveProxies="false" transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	List<DiagramElement> getOwnedElement();

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_ModelElement()
	 * @model transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	Object getModelElement();

	/**
	 * Returns the value of the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' reference.
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_Style()
	 * @model transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	Style getStyle();

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
	 * @see org.eclipse.bpmn2.di.BpmnDiPackage#getDiagramElement_Id()
	 * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.di.DiagramElement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // DiagramElement
