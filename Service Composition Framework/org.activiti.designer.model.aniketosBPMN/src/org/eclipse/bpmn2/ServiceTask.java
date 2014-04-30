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
package org.eclipse.bpmn2;

import java.util.List;

import org.eclipse.aniketos.SecurityExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getOperationRef <em>Operation Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getCustomProperties <em>Custom Properties</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getImplementationType <em>Implementation Type</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getFieldExtensions <em>Field Extensions</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getResultVariableName <em>Result Variable Name</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.ServiceTask#getSecurityExtensions <em>Security Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask()
 * @model extendedMetaData="name='tServiceTask' kind='elementOnly'"
 * @generated
 */
public interface ServiceTask extends Task {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' attribute.
	 * @see #setImplementation(String)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_Implementation()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='implementation'"
	 * @generated
	 */
	String getImplementation();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ServiceTask#getImplementation <em>Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' attribute.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Ref</em>' reference.
	 * @see #setOperationRef(Operation)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_OperationRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='operationRef'"
	 * @generated
	 */
	Operation getOperationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ServiceTask#getOperationRef <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Ref</em>' reference.
	 * @see #getOperationRef()
	 * @generated
	 */
	void setOperationRef(Operation value);

	/**
	 * Returns the value of the '<em><b>Custom Properties</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.CustomProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Properties</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_CustomProperties()
	 * @model
	 * @generated
	 */
	List<CustomProperty> getCustomProperties();

	/**
	 * Returns the value of the '<em><b>Implementation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Type</em>' attribute.
	 * @see #setImplementationType(String)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_ImplementationType()
	 * @model
	 * @generated
	 */
	String getImplementationType();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ServiceTask#getImplementationType <em>Implementation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Type</em>' attribute.
	 * @see #getImplementationType()
	 * @generated
	 */
	void setImplementationType(String value);

	/**
	 * Returns the value of the '<em><b>Field Extensions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.bpmn2.FieldExtension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Extensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Extensions</em>' reference list.
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_FieldExtensions()
	 * @model
	 * @generated
	 */
	List<FieldExtension> getFieldExtensions();

	/**
	 * Returns the value of the '<em><b>Result Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Variable Name</em>' attribute.
	 * @see #setResultVariableName(String)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_ResultVariableName()
	 * @model
	 * @generated
	 */
	String getResultVariableName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ServiceTask#getResultVariableName <em>Result Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Variable Name</em>' attribute.
	 * @see #getResultVariableName()
	 * @generated
	 */
	void setResultVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Security Extensions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Extensions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Extensions</em>' reference.
	 * @see #setSecurityExtensions(SecurityExtension)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getServiceTask_SecurityExtensions()
	 * @model
	 * @generated
	 */
	SecurityExtension getSecurityExtensions();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.ServiceTask#getSecurityExtensions <em>Security Extensions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Extensions</em>' reference.
	 * @see #getSecurityExtensions()
	 * @generated
	 */
	void setSecurityExtensions(SecurityExtension value);

} // ServiceTask
