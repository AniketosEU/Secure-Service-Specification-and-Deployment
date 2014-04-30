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
package org.eclipse.dd.dc;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.dd.dc.Font#isIsBold <em>Is Bold</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.Font#isIsItalic <em>Is Italic</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.Font#isIsUnderline <em>Is Underline</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.Font#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.Font#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.dd.dc.DcPackage#getFont()
 * @model extendedMetaData="name='Font' kind='empty'"
 * @generated
 */
public interface Font extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Bold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Bold</em>' attribute.
	 * @see #setIsBold(boolean)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_IsBold()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='isBold'"
	 * @generated
	 */
	boolean isIsBold();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#isIsBold <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bold</em>' attribute.
	 * @see #isIsBold()
	 * @generated
	 */
	void setIsBold(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Italic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Italic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Italic</em>' attribute.
	 * @see #setIsItalic(boolean)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_IsItalic()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='isItalic'"
	 * @generated
	 */
	boolean isIsItalic();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#isIsItalic <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Italic</em>' attribute.
	 * @see #isIsItalic()
	 * @generated
	 */
	void setIsItalic(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Strike Through</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strike Through</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strike Through</em>' attribute.
	 * @see #setIsStrikeThrough(boolean)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_IsStrikeThrough()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='isStrikeThrough'"
	 * @generated
	 */
	boolean isIsStrikeThrough();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strike Through</em>' attribute.
	 * @see #isIsStrikeThrough()
	 * @generated
	 */
	void setIsStrikeThrough(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Underline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Underline</em>' attribute.
	 * @see #setIsUnderline(boolean)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_IsUnderline()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='isUnderline'"
	 * @generated
	 */
	boolean isIsUnderline();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#isIsUnderline <em>Is Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Underline</em>' attribute.
	 * @see #isIsUnderline()
	 * @generated
	 */
	void setIsUnderline(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_Name()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(float)
	 * @see org.eclipse.dd.dc.DcPackage#getFont_Size()
	 * @model ordered="false"
	 *        extendedMetaData="kind='attribute' name='size'"
	 * @generated
	 */
	float getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.dd.dc.Font#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(float value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * size >=  0
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean non_negative_size(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Font
