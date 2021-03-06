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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Form Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.FormValue#getValueId <em>Value Id</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.FormValue#getValueName <em>Value Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getFormValue()
 * @model
 * @generated
 */
public interface FormValue extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Value Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Id</em>' attribute.
	 * @see #setValueId(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getFormValue_ValueId()
	 * @model
	 * @generated
	 */
	String getValueId();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.FormValue#getValueId <em>Value Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Id</em>' attribute.
	 * @see #getValueId()
	 * @generated
	 */
	void setValueId(String value);

	/**
	 * Returns the value of the '<em><b>Value Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Name</em>' attribute.
	 * @see #setValueName(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getFormValue_ValueName()
	 * @model
	 * @generated
	 */
	String getValueName();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.FormValue#getValueName <em>Value Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Name</em>' attribute.
	 * @see #getValueName()
	 * @generated
	 */
	void setValueName(String value);

} // FormValue
