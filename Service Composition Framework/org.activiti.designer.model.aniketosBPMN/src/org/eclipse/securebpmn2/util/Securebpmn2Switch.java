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
package org.eclipse.securebpmn2.util;

import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.FlowNode;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.securebpmn2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.securebpmn2.Securebpmn2Package
 * @generated
 */
public class Securebpmn2Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Securebpmn2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Securebpmn2Switch() {
		if (modelPackage == null) {
			modelPackage = Securebpmn2Package.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Securebpmn2Package.SECURITY_FLOW_NODE: {
				SecurityFlowNode securityFlowNode = (SecurityFlowNode)theEObject;
				T result = caseSecurityFlowNode(securityFlowNode);
				if (result == null) result = caseFlowNode(securityFlowNode);
				if (result == null) result = caseFlowElement(securityFlowNode);
				if (result == null) result = caseBaseElement(securityFlowNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.SECURITY_FLOW: {
				SecurityFlow securityFlow = (SecurityFlow)theEObject;
				T result = caseSecurityFlow(securityFlow);
				if (result == null) result = caseFlowElement(securityFlow);
				if (result == null) result = caseBaseElement(securityFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ROLE: {
				Role role = (Role)theEObject;
				T result = caseRole(role);
				if (result == null) result = caseSecurityFlowNode(role);
				if (result == null) result = caseFlowNode(role);
				if (result == null) result = caseFlowElement(role);
				if (result == null) result = caseBaseElement(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.SUBJECT: {
				Subject subject = (Subject)theEObject;
				T result = caseSubject(subject);
				if (result == null) result = caseBaseElement(subject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = caseSubject(user);
				if (result == null) result = caseBaseElement(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = caseSubject(group);
				if (result == null) result = caseBaseElement(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseBaseElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ACTIVITY_ACTION: {
				ActivityAction activityAction = (ActivityAction)theEObject;
				T result = caseActivityAction(activityAction);
				if (result == null) result = caseAction(activityAction);
				if (result == null) result = caseBaseElement(activityAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ATOMIC_ACTIVITY_ACTION: {
				AtomicActivityAction atomicActivityAction = (AtomicActivityAction)theEObject;
				T result = caseAtomicActivityAction(atomicActivityAction);
				if (result == null) result = caseActivityAction(atomicActivityAction);
				if (result == null) result = caseAction(atomicActivityAction);
				if (result == null) result = caseBaseElement(atomicActivityAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.COMPOSITE_ACTIVITY_ACTION: {
				CompositeActivityAction compositeActivityAction = (CompositeActivityAction)theEObject;
				T result = caseCompositeActivityAction(compositeActivityAction);
				if (result == null) result = caseActivityAction(compositeActivityAction);
				if (result == null) result = caseAction(compositeActivityAction);
				if (result == null) result = caseBaseElement(compositeActivityAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.PERMISSION: {
				Permission permission = (Permission)theEObject;
				T result = casePermission(permission);
				if (result == null) result = caseBaseElement(permission);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.NEED_TO_KNOW: {
				NeedToKnow needToKnow = (NeedToKnow)theEObject;
				T result = caseNeedToKnow(needToKnow);
				if (result == null) result = casePermission(needToKnow);
				if (result == null) result = caseBaseElement(needToKnow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.SEPARATION_OF_DUTY: {
				SeparationOfDuty separationOfDuty = (SeparationOfDuty)theEObject;
				T result = caseSeparationOfDuty(separationOfDuty);
				if (result == null) result = caseAuthorizationConstraint(separationOfDuty);
				if (result == null) result = caseSecurityFlowNode(separationOfDuty);
				if (result == null) result = caseFlowNode(separationOfDuty);
				if (result == null) result = caseFlowElement(separationOfDuty);
				if (result == null) result = caseBaseElement(separationOfDuty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.BINDING_OF_DUTY: {
				BindingOfDuty bindingOfDuty = (BindingOfDuty)theEObject;
				T result = caseBindingOfDuty(bindingOfDuty);
				if (result == null) result = caseAuthorizationConstraint(bindingOfDuty);
				if (result == null) result = caseSecurityFlowNode(bindingOfDuty);
				if (result == null) result = caseFlowNode(bindingOfDuty);
				if (result == null) result = caseFlowElement(bindingOfDuty);
				if (result == null) result = caseBaseElement(bindingOfDuty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.AUTHORIZATION_CONSTRAINT: {
				AuthorizationConstraint authorizationConstraint = (AuthorizationConstraint)theEObject;
				T result = caseAuthorizationConstraint(authorizationConstraint);
				if (result == null) result = caseSecurityFlowNode(authorizationConstraint);
				if (result == null) result = caseFlowNode(authorizationConstraint);
				if (result == null) result = caseFlowElement(authorizationConstraint);
				if (result == null) result = caseBaseElement(authorizationConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ACTIVITY_AUTHORIZATION_CONSTRAINT: {
				ActivityAuthorizationConstraint activityAuthorizationConstraint = (ActivityAuthorizationConstraint)theEObject;
				T result = caseActivityAuthorizationConstraint(activityAuthorizationConstraint);
				if (result == null) result = caseAuthorizationConstraint(activityAuthorizationConstraint);
				if (result == null) result = caseSecurityFlowNode(activityAuthorizationConstraint);
				if (result == null) result = caseFlowNode(activityAuthorizationConstraint);
				if (result == null) result = caseFlowElement(activityAuthorizationConstraint);
				if (result == null) result = caseBaseElement(activityAuthorizationConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.PROCESS_ACTION: {
				ProcessAction processAction = (ProcessAction)theEObject;
				T result = caseProcessAction(processAction);
				if (result == null) result = caseAction(processAction);
				if (result == null) result = caseBaseElement(processAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ATOMIC_PROCESS_ACTION: {
				AtomicProcessAction atomicProcessAction = (AtomicProcessAction)theEObject;
				T result = caseAtomicProcessAction(atomicProcessAction);
				if (result == null) result = caseProcessAction(atomicProcessAction);
				if (result == null) result = caseAction(atomicProcessAction);
				if (result == null) result = caseBaseElement(atomicProcessAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.COMPOSITE_PROCESS_ACTION: {
				CompositeProcessAction compositeProcessAction = (CompositeProcessAction)theEObject;
				T result = caseCompositeProcessAction(compositeProcessAction);
				if (result == null) result = caseProcessAction(compositeProcessAction);
				if (result == null) result = caseAction(compositeProcessAction);
				if (result == null) result = caseBaseElement(compositeProcessAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ITEM_AWARE_ELEMENT_ACTION: {
				ItemAwareElementAction itemAwareElementAction = (ItemAwareElementAction)theEObject;
				T result = caseItemAwareElementAction(itemAwareElementAction);
				if (result == null) result = caseAction(itemAwareElementAction);
				if (result == null) result = caseBaseElement(itemAwareElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.ATOMIC_ITEM_AWARE_ELEMENT_ACTION: {
				AtomicItemAwareElementAction atomicItemAwareElementAction = (AtomicItemAwareElementAction)theEObject;
				T result = caseAtomicItemAwareElementAction(atomicItemAwareElementAction);
				if (result == null) result = caseItemAwareElementAction(atomicItemAwareElementAction);
				if (result == null) result = caseAction(atomicItemAwareElementAction);
				if (result == null) result = caseBaseElement(atomicItemAwareElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.COMPOSITE_ITEM_AWARE_ELEMENT_ACTION: {
				CompositeItemAwareElementAction compositeItemAwareElementAction = (CompositeItemAwareElementAction)theEObject;
				T result = caseCompositeItemAwareElementAction(compositeItemAwareElementAction);
				if (result == null) result = caseItemAwareElementAction(compositeItemAwareElementAction);
				if (result == null) result = caseAction(compositeItemAwareElementAction);
				if (result == null) result = caseBaseElement(compositeItemAwareElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.DELEGATION: {
				Delegation delegation = (Delegation)theEObject;
				T result = caseDelegation(delegation);
				if (result == null) result = caseBaseElement(delegation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.SIMPLE_DELEGATION: {
				SimpleDelegation simpleDelegation = (SimpleDelegation)theEObject;
				T result = caseSimpleDelegation(simpleDelegation);
				if (result == null) result = caseDelegation(simpleDelegation);
				if (result == null) result = caseBaseElement(simpleDelegation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.TRANSFER_DELEGATION: {
				TransferDelegation transferDelegation = (TransferDelegation)theEObject;
				T result = caseTransferDelegation(transferDelegation);
				if (result == null) result = caseDelegation(transferDelegation);
				if (result == null) result = caseBaseElement(transferDelegation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Securebpmn2Package.DELEGATOR: {
				Delegator delegator = (Delegator)theEObject;
				T result = caseDelegator(delegator);
				if (result == null) result = caseUser(delegator);
				if (result == null) result = caseSubject(delegator);
				if (result == null) result = caseBaseElement(delegator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Flow Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecurityFlowNode(SecurityFlowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Security Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSecurityFlow(SecurityFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubject(Subject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityAction(ActivityAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Activity Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicActivityAction(AtomicActivityAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Activity Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Activity Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeActivityAction(CompositeActivityAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Permission</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Permission</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePermission(Permission object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Need To Know</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Need To Know</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNeedToKnow(NeedToKnow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Separation Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Separation Of Duty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeparationOfDuty(SeparationOfDuty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding Of Duty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Of Duty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingOfDuty(BindingOfDuty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Authorization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Authorization Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthorizationConstraint(AuthorizationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Authorization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Authorization Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityAuthorizationConstraint(ActivityAuthorizationConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessAction(ProcessAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Process Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicProcessAction(AtomicProcessAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Process Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Process Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeProcessAction(CompositeProcessAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Aware Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemAwareElementAction(ItemAwareElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Item Aware Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicItemAwareElementAction(AtomicItemAwareElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Item Aware Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Item Aware Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeItemAwareElementAction(CompositeItemAwareElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegation(Delegation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Delegation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleDelegation(SimpleDelegation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transfer Delegation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transfer Delegation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransferDelegation(TransferDelegation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegator(Delegator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseElement(BaseElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowElement(FlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowNode(FlowNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Securebpmn2Switch
