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
 * A representation of the model object '<em><b>Standard Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpmn2.StandardLoopCharacteristics#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.StandardLoopCharacteristics#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link org.eclipse.bpmn2.StandardLoopCharacteristics#isTestBefore <em>Test Before</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpmn2.Bpmn2Package#getStandardLoopCharacteristics()
 * @model extendedMetaData="name='tStandardLoopCharacteristics' kind='elementOnly'"
 * @generated
 */
public interface StandardLoopCharacteristics extends LoopCharacteristics {
	/**
	 * Returns the value of the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Condition</em>' containment reference.
	 * @see #setLoopCondition(Expression)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getStandardLoopCharacteristics_LoopCondition()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='loopCondition' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	Expression getLoopCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.StandardLoopCharacteristics#getLoopCondition <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Condition</em>' containment reference.
	 * @see #getLoopCondition()
	 * @generated
	 */
	void setLoopCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Loop Maximum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Maximum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Maximum</em>' containment reference.
	 * @see #setLoopMaximum(Expression)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getStandardLoopCharacteristics_LoopMaximum()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='loopMaximum'"
	 * @generated
	 */
	Expression getLoopMaximum();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.StandardLoopCharacteristics#getLoopMaximum <em>Loop Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Maximum</em>' containment reference.
	 * @see #getLoopMaximum()
	 * @generated
	 */
	void setLoopMaximum(Expression value);

	/**
	 * Returns the value of the '<em><b>Test Before</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Before</em>' attribute.
	 * @see #setTestBefore(boolean)
	 * @see org.eclipse.bpmn2.Bpmn2Package#getStandardLoopCharacteristics_TestBefore()
	 * @model default="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='testBefore'"
	 * @generated
	 */
	boolean isTestBefore();

	/**
	 * Sets the value of the '{@link org.eclipse.bpmn2.StandardLoopCharacteristics#isTestBefore <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Before</em>' attribute.
	 * @see #isTestBefore()
	 * @generated
	 */
	void setTestBefore(boolean value);

} // StandardLoopCharacteristics
