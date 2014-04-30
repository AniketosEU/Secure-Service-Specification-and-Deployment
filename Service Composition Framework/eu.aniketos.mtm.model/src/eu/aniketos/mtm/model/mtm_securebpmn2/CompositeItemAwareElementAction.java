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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Item Aware Element Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_securebpmn2.CompositeItemAwareElementAction#getItemAwareElementActions <em>Item Aware Element Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getCompositeItemAwareElementAction()
 * @model
 * @generated
 */
public interface CompositeItemAwareElementAction extends ItemAwareElementAction {
	/**
	 * Returns the value of the '<em><b>Item Aware Element Actions</b></em>' reference list.
	 * The list contents are of type {@link eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction}.
	 * It is bidirectional and its opposite is '{@link eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getCompositeItemAwareElementActions <em>Composite Item Aware Element Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Aware Element Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Aware Element Actions</em>' reference list.
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.Securebpmn2Package#getCompositeItemAwareElementAction_ItemAwareElementActions()
	 * @see eu.aniketos.mtm.model.mtm_securebpmn2.ItemAwareElementAction#getCompositeItemAwareElementActions
	 * @model opposite="compositeItemAwareElementActions"
	 * @generated
	 */
	EList<ItemAwareElementAction> getItemAwareElementActions();

} // CompositeItemAwareElementAction
