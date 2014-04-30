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
 * A representation of the model object '<em><b>Boundary Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent#getAttachedToRef <em>Attached To Ref</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent#isCancelActivity <em>Cancel Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getBoundaryEvent()
 * @model extendedMetaData="name='tBoundaryEvent' kind='elementOnly'"
 * @generated
 */
public interface BoundaryEvent extends CatchEvent {
	/**
	 * Returns the value of the '<em><b>Attached To Ref</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_bpmn2.Activity#getBoundaryEventRefs <em>Boundary Event Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached To Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached To Ref</em>' reference.
	 * @see #setAttachedToRef(Activity)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getBoundaryEvent_AttachedToRef()
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Activity#getBoundaryEventRefs
	 * @model opposite="boundaryEventRefs" resolveProxies="false" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='attachedToRef'"
	 * @generated
	 */
	Activity getAttachedToRef();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent#getAttachedToRef <em>Attached To Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attached To Ref</em>' reference.
	 * @see #getAttachedToRef()
	 * @generated
	 */
	void setAttachedToRef(Activity value);

	/**
	 * Returns the value of the '<em><b>Cancel Activity</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cancel Activity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cancel Activity</em>' attribute.
	 * @see #setCancelActivity(boolean)
	 * @see eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Package#getBoundaryEvent_CancelActivity()
	 * @model default="true" required="true" ordered="false"
	 *        extendedMetaData="kind='attribute' name='cancelActivity'"
	 * @generated
	 */
	boolean isCancelActivity();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_bpmn2.BoundaryEvent#isCancelActivity <em>Cancel Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cancel Activity</em>' attribute.
	 * @see #isCancelActivity()
	 * @generated
	 */
	void setCancelActivity(boolean value);

} // BoundaryEvent
