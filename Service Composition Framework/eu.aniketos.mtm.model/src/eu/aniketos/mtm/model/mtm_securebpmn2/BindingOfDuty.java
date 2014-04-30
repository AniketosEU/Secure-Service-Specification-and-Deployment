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
package eu.aniketos.mtm.model.mtm_securebpmn2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Of Duty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getMaxUsers <em>Max Users</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getSameUserActionCount <em>Same User Action Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getBindingOfDuty()
 * @model
 * @generated
 */
public interface BindingOfDuty extends AuthorizationConstraint {
	/**
	 * Returns the value of the '<em><b>Max Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Users</em>' attribute.
	 * @see #setMaxUsers(Integer)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getBindingOfDuty_MaxUsers()
	 * @model
	 * @generated
	 */
	Integer getMaxUsers();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getMaxUsers <em>Max Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Users</em>' attribute.
	 * @see #getMaxUsers()
	 * @generated
	 */
	void setMaxUsers(Integer value);

	/**
	 * Returns the value of the '<em><b>Same User Action Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Same User Action Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Same User Action Count</em>' attribute.
	 * @see #setSameUserActionCount(Integer)
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getBindingOfDuty_SameUserActionCount()
	 * @model
	 * @generated
	 */
	Integer getSameUserActionCount();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_securebpmn2.BindingOfDuty#getSameUserActionCount <em>Same User Action Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Same User Action Count</em>' attribute.
	 * @see #getSameUserActionCount()
	 * @generated
	 */
	void setSameUserActionCount(Integer value);

} // BindingOfDuty
