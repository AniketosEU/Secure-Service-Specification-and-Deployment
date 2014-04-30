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
 * A representation of the model object '<em><b>Multi Instance Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopDataInputRef <em>Loop Data Input Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopDataOutputRef <em>Loop Data Output Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getOutputDataItem <em>Output Data Item</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getComplexBehaviorDefinition <em>Complex Behavior Definition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#isIsSequential <em>Is Sequential</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopCardinality <em>Loop Cardinality</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getInputDataItem <em>Input Data Item</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getCompletionCondition <em>Completion Condition</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getElementVariable <em>Element Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics()
 * @model extendedMetaData="name='tMultiInstanceLoopCharacteristics' kind='elementOnly'"
 * @generated
 */
public interface MultiInstanceLoopCharacteristics extends LoopCharacteristics {
	/**
	 * Returns the value of the '<em><b>Loop Data Input Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Data Input Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Data Input Ref</em>' reference.
	 * @see #setLoopDataInputRef(ItemAwareElement)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_LoopDataInputRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='loopDataInputRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	ItemAwareElement getLoopDataInputRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopDataInputRef <em>Loop Data Input Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Data Input Ref</em>' reference.
	 * @see #getLoopDataInputRef()
	 * @generated
	 */
	void setLoopDataInputRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Loop Data Output Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Data Output Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Data Output Ref</em>' reference.
	 * @see #setLoopDataOutputRef(ItemAwareElement)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_LoopDataOutputRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='element' name='loopDataOutputRef' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	ItemAwareElement getLoopDataOutputRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopDataOutputRef <em>Loop Data Output Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Data Output Ref</em>' reference.
	 * @see #getLoopDataOutputRef()
	 * @generated
	 */
	void setLoopDataOutputRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Output Data Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data Item</em>' containment reference.
	 * @see #setOutputDataItem(DataOutput)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_OutputDataItem()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='outputDataItem' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	DataOutput getOutputDataItem();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getOutputDataItem <em>Output Data Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Data Item</em>' containment reference.
	 * @see #getOutputDataItem()
	 * @generated
	 */
	void setOutputDataItem(DataOutput value);

	/**
	 * Returns the value of the '<em><b>Complex Behavior Definition</b></em>' containment reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_bpmn2.ComplexBehaviorDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex Behavior Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Behavior Definition</em>' containment reference list.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition()
	 * @model containment="true" ordered="false"
	 *        extendedMetaData="kind='element' name='complexBehaviorDefinition' namespace='http://www.omg.org/spec/BPMN/20100524/MODEL'"
	 * @generated
	 */
	EList<ComplexBehaviorDefinition> getComplexBehaviorDefinition();

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' attribute.
	 * The default value is <code>"All"</code>.
	 * The literals are from the enumeration {@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceBehavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceBehavior
	 * @see #setBehavior(MultiInstanceBehavior)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_Behavior()
	 * @model default="All" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='behavior'"
	 * @generated
	 */
	MultiInstanceBehavior getBehavior();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getBehavior <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' attribute.
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceBehavior
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(MultiInstanceBehavior value);

	/**
	 * Returns the value of the '<em><b>Is Sequential</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sequential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sequential</em>' attribute.
	 * @see #setIsSequential(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_IsSequential()
	 * @model default="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='isSequential'"
	 * @generated
	 */
	boolean isIsSequential();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#isIsSequential <em>Is Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sequential</em>' attribute.
	 * @see #isIsSequential()
	 * @generated
	 */
	void setIsSequential(boolean value);

	/**
	 * Returns the value of the '<em><b>None Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>None Behavior Event Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>None Behavior Event Ref</em>' reference.
	 * @see #setNoneBehaviorEventRef(EventDefinition)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='noneBehaviorEventRef'"
	 * @generated
	 */
	EventDefinition getNoneBehaviorEventRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>None Behavior Event Ref</em>' reference.
	 * @see #getNoneBehaviorEventRef()
	 * @generated
	 */
	void setNoneBehaviorEventRef(EventDefinition value);

	/**
	 * Returns the value of the '<em><b>One Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Behavior Event Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Behavior Event Ref</em>' reference.
	 * @see #setOneBehaviorEventRef(EventDefinition)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_OneBehaviorEventRef()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='oneBehaviorEventRef'"
	 * @generated
	 */
	EventDefinition getOneBehaviorEventRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Behavior Event Ref</em>' reference.
	 * @see #getOneBehaviorEventRef()
	 * @generated
	 */
	void setOneBehaviorEventRef(EventDefinition value);

	/**
	 * Returns the value of the '<em><b>Loop Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Cardinality</em>' attribute.
	 * @see #setLoopCardinality(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_LoopCardinality()
	 * @model
	 * @generated
	 */
	String getLoopCardinality();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getLoopCardinality <em>Loop Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Cardinality</em>' attribute.
	 * @see #getLoopCardinality()
	 * @generated
	 */
	void setLoopCardinality(String value);

	/**
	 * Returns the value of the '<em><b>Input Data Item</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data Item</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data Item</em>' attribute.
	 * @see #setInputDataItem(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_InputDataItem()
	 * @model
	 * @generated
	 */
	String getInputDataItem();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getInputDataItem <em>Input Data Item</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Data Item</em>' attribute.
	 * @see #getInputDataItem()
	 * @generated
	 */
	void setInputDataItem(String value);

	/**
	 * Returns the value of the '<em><b>Completion Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Condition</em>' attribute.
	 * @see #setCompletionCondition(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_CompletionCondition()
	 * @model
	 * @generated
	 */
	String getCompletionCondition();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getCompletionCondition <em>Completion Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Condition</em>' attribute.
	 * @see #getCompletionCondition()
	 * @generated
	 */
	void setCompletionCondition(String value);

	/**
	 * Returns the value of the '<em><b>Element Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Variable</em>' attribute.
	 * @see #setElementVariable(String)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getMultiInstanceLoopCharacteristics_ElementVariable()
	 * @model
	 * @generated
	 */
	String getElementVariable();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.MultiInstanceLoopCharacteristics#getElementVariable <em>Element Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Variable</em>' attribute.
	 * @see #getElementVariable()
	 * @generated
	 */
	void setElementVariable(String value);

} // MultiInstanceLoopCharacteristics
