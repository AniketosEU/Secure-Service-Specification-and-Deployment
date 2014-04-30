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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Separation Of Duty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.securebpmn2.SeparationOfDuty#getMinimumUsers <em>Minimum Users</em>}</li>
 *   <li>{@link org.eclipse.securebpmn2.SeparationOfDuty#getMaxUserActionsPermitted <em>Max User Actions Permitted</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSeparationOfDuty()
 * @model
 * @generated
 */
public interface SeparationOfDuty extends AuthorizationConstraint {
	/**
	 * Returns the value of the '<em><b>Minimum Users</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Users</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Users</em>' attribute.
	 * @see #setMinimumUsers(Integer)
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSeparationOfDuty_MinimumUsers()
	 * @model
	 * @generated
	 */
	Integer getMinimumUsers();

	/**
	 * Sets the value of the '{@link org.eclipse.securebpmn2.SeparationOfDuty#getMinimumUsers <em>Minimum Users</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Users</em>' attribute.
	 * @see #getMinimumUsers()
	 * @generated
	 */
	void setMinimumUsers(Integer value);

	/**
	 * Returns the value of the '<em><b>Max User Actions Permitted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max User Actions Permitted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max User Actions Permitted</em>' attribute.
	 * @see #setMaxUserActionsPermitted(Integer)
	 * @see org.eclipse.securebpmn2.Securebpmn2Package#getSeparationOfDuty_MaxUserActionsPermitted()
	 * @model
	 * @generated
	 */
	Integer getMaxUserActionsPermitted();

	/**
	 * Sets the value of the '{@link org.eclipse.securebpmn2.SeparationOfDuty#getMaxUserActionsPermitted <em>Max User Actions Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max User Actions Permitted</em>' attribute.
	 * @see #getMaxUserActionsPermitted()
	 * @generated
	 */
	void setMaxUserActionsPermitted(Integer value);

} // SeparationOfDuty
