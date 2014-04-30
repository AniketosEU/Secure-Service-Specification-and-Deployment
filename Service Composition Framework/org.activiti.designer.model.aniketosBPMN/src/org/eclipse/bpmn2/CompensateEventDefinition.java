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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compensate Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.CompensateEventDefinition#getActivityRef <em>Activity Ref</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.CompensateEventDefinition#isWaitForCompletion <em>Wait For Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getCompensateEventDefinition()
 * @model extendedMetaData="name='tCompensateEventDefinition' kind='elementOnly'"
 * @generated
 */
public interface CompensateEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>Activity Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Ref</em>' reference.
	 * @see #setActivityRef(Activity)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getCompensateEventDefinition_ActivityRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='activityRef'"
	 * @generated
	 */
	Activity getActivityRef();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.CompensateEventDefinition#getActivityRef <em>Activity Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity Ref</em>' reference.
	 * @see #getActivityRef()
	 * @generated
	 */
	void setActivityRef(Activity value);

	/**
	 * Returns the value of the '<em><b>Wait For Completion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait For Completion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Completion</em>' attribute.
	 * @see #setWaitForCompletion(boolean)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getCompensateEventDefinition_WaitForCompletion()
	 * @model required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='waitForCompletion'"
	 * @generated
	 */
	boolean isWaitForCompletion();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.CompensateEventDefinition#isWaitForCompletion <em>Wait For Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait For Completion</em>' attribute.
	 * @see #isWaitForCompletion()
	 * @generated
	 */
	void setWaitForCompletion(boolean value);

} // CompensateEventDefinition
