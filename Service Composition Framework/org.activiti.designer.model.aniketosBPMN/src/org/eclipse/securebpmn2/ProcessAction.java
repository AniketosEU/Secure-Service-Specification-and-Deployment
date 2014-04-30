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
package org.eclipse.securebpmn2;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.ProcessAction#getCompositeProcessActions <em>Composite Process Actions</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.ProcessAction#getProcess <em>Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.securebpmn2.Securebpmn2Package#getProcessAction()
 * @model
 * @generated
 */
public interface ProcessAction extends Action {
	/**
	 * Returns the value of the '<em><b>Composite Process Actions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.securebpmn2.CompositeProcessAction}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.securebpmn2.CompositeProcessAction#getProcessActions <em>Process Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Process Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Process Actions</em>' reference list.
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getProcessAction_CompositeProcessActions()
	 * @see org.eclipse.securebpmn2.CompositeProcessAction#getProcessActions
	 * @model opposite="processActions"
	 * @generated
	 */
	List<CompositeProcessAction> getCompositeProcessActions();

	/**
	 * Returns the value of the '<em><b>Process</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.bpmn2.Process#getProcessActions <em>Process Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' container reference.
	 * @see #setProcess(org.eclipse.bpmn2.Process)
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getProcessAction_Process()
	 * @see org.eclipse.bpmn2.Process#getProcessActions
	 * @model opposite="processActions" required="true" transient="false"
	 * @generated
	 */
	org.eclipse.bpmn2.Process getProcess();

	/**
	 * Sets the value of the '{@link org.eclipse.securebpmn2.ProcessAction#getProcess <em>Process</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' container reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(org.eclipse.bpmn2.Process value);

} // ProcessAction
