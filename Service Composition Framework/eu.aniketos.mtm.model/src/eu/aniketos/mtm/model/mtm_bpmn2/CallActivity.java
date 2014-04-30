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
package eu.aniketos.mtm.model.mtm_bpmn2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getCalledElementRef <em>Called Element Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getCalledElement <em>Called Element</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getInParameters <em>In Parameters</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getOutParameters <em>Out Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCallActivity()
 * @model extendedMetaData="name='tCallActivity' kind='elementOnly'"
 * @generated
 */
public interface CallActivity extends Activity {
	/**
	 * Returns the value of the '<em><b>Called Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Element Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Element Ref</em>' reference.
	 * @see #setCalledElementRef(CallableElement)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCallActivity_CalledElementRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='calledElement'"
	 * @generated
	 */
	CallableElement getCalledElementRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getCalledElementRef <em>Called Element Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Element Ref</em>' reference.
	 * @see #getCalledElementRef()
	 * @generated
	 */
	void setCalledElementRef(CallableElement value);

	/**
	 * Returns the value of the '<em><b>Called Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Element</em>' attribute.
	 * @see #setCalledElement(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCallActivity_CalledElement()
	 * @model
	 * @generated
	 */
	String getCalledElement();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.CallActivity#getCalledElement <em>Called Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Element</em>' attribute.
	 * @see #getCalledElement()
	 * @generated
	 */
	void setCalledElement(String value);

	/**
	 * Returns the value of the '<em><b>In Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.IOParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Parameters</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCallActivity_InParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<IOParameter> getInParameters();

	/**
	 * Returns the value of the '<em><b>Out Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.IOParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Parameters</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getCallActivity_OutParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<IOParameter> getOutParameters();

} // CallActivity
