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

import eu.aniketos.mtm.model.mtm_dc.Font;

import eu.aniketos.mtm.model.mtm_di.Style;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Label Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle#getFont <em>Font</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNLabelStyle()
 * @model extendedMetaData="name='BPMNLabelStyle' kind='elementOnly'"
 * @generated
 */
public interface BPMNLabelStyle extends Style {
	/**
	 * Returns the value of the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' containment reference.
	 * @see #setFont(Font)
	 * @see eu.aniketos.mtm.model.mtm_bpmndi.BpmnDiPackage#getBPMNLabelStyle_Font()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Font' namespace='http://www.omg.org/spec/DD/20100524/DC'"
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmndi.BPMNLabelStyle#getFont <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' containment reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

} // BPMNLabelStyle
