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
package eu.aniketos.mtm.model.mtm_bpmndi.impl;

import eu.aniketos.mtm.model.mtm_bpmndi.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BpmnDiFactoryImpl extends EFactoryImpl implements BpmnDiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BpmnDiFactory init() {
		try {
			BpmnDiFactory theBpmnDiFactory = (BpmnDiFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.omg.org/spec/BPMN/20100524/DI"); 
			if (theBpmnDiFactory != null) {
				return theBpmnDiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BpmnDiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnDiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BpmnDiPackage.BPMN_DIAGRAM: return createBPMNDiagram();
			case BpmnDiPackage.BPMN_EDGE: return createBPMNEdge();
			case BpmnDiPackage.BPMN_LABEL: return createBPMNLabel();
			case BpmnDiPackage.BPMN_LABEL_STYLE: return createBPMNLabelStyle();
			case BpmnDiPackage.BPMN_PLANE: return createBPMNPlane();
			case BpmnDiPackage.BPMN_SHAPE: return createBPMNShape();
			case BpmnDiPackage.DOCUMENT_ROOT: return createDocumentRoot();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BpmnDiPackage.MESSAGE_VISIBLE_KIND:
				return createMessageVisibleKindFromString(eDataType, initialValue);
			case BpmnDiPackage.PARTICIPANT_BAND_KIND:
				return createParticipantBandKindFromString(eDataType, initialValue);
			case BpmnDiPackage.MESSAGE_VISIBLE_KIND_OBJECT:
				return createMessageVisibleKindObjectFromString(eDataType, initialValue);
			case BpmnDiPackage.PARTICIPANT_BAND_KIND_OBJECT:
				return createParticipantBandKindObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BpmnDiPackage.MESSAGE_VISIBLE_KIND:
				return convertMessageVisibleKindToString(eDataType, instanceValue);
			case BpmnDiPackage.PARTICIPANT_BAND_KIND:
				return convertParticipantBandKindToString(eDataType, instanceValue);
			case BpmnDiPackage.MESSAGE_VISIBLE_KIND_OBJECT:
				return convertMessageVisibleKindObjectToString(eDataType, instanceValue);
			case BpmnDiPackage.PARTICIPANT_BAND_KIND_OBJECT:
				return convertParticipantBandKindObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNDiagram createBPMNDiagram() {
		BPMNDiagramImpl bpmnDiagram = new BPMNDiagramImpl();
		return bpmnDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNEdge createBPMNEdge() {
		BPMNEdgeImpl bpmnEdge = new BPMNEdgeImpl();
		return bpmnEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabel createBPMNLabel() {
		BPMNLabelImpl bpmnLabel = new BPMNLabelImpl();
		return bpmnLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNLabelStyle createBPMNLabelStyle() {
		BPMNLabelStyleImpl bpmnLabelStyle = new BPMNLabelStyleImpl();
		return bpmnLabelStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNPlane createBPMNPlane() {
		BPMNPlaneImpl bpmnPlane = new BPMNPlaneImpl();
		return bpmnPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNShape createBPMNShape() {
		BPMNShapeImpl bpmnShape = new BPMNShapeImpl();
		return bpmnShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageVisibleKind createMessageVisibleKindFromString(EDataType eDataType, String initialValue) {
		MessageVisibleKind result = MessageVisibleKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageVisibleKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantBandKind createParticipantBandKindFromString(EDataType eDataType, String initialValue) {
		ParticipantBandKind result = ParticipantBandKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParticipantBandKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageVisibleKind createMessageVisibleKindObjectFromString(EDataType eDataType, String initialValue) {
		return createMessageVisibleKindFromString(BpmnDiPackage.Literals.MESSAGE_VISIBLE_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMessageVisibleKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertMessageVisibleKindToString(BpmnDiPackage.Literals.MESSAGE_VISIBLE_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantBandKind createParticipantBandKindObjectFromString(EDataType eDataType, String initialValue) {
		return createParticipantBandKindFromString(BpmnDiPackage.Literals.PARTICIPANT_BAND_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParticipantBandKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertParticipantBandKindToString(BpmnDiPackage.Literals.PARTICIPANT_BAND_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnDiPackage getBpmnDiPackage() {
		return (BpmnDiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BpmnDiPackage getPackage() {
		return BpmnDiPackage.eINSTANCE;
	}

} //BpmnDiFactoryImpl
