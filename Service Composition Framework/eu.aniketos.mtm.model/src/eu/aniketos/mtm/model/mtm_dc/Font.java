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
package eu.aniketos.mtm.model.mtm_dc;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsBold <em>Is Bold</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsItalic <em>Is Italic</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsUnderline <em>Is Underline</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#getName <em>Name</em>}</li>
 *   <li>{@link eu.aniketos.mtm.model.mtm_dc.Font#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont()
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
	 * @see #isSetIsBold()
	 * @see #unsetIsBold()
	 * @see #setIsBold(boolean)
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_IsBold()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isBold'"
	 * @generated
	 */
	boolean isIsBold();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsBold <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bold</em>' attribute.
	 * @see #isSetIsBold()
	 * @see #unsetIsBold()
	 * @see #isIsBold()
	 * @generated
	 */
	void setIsBold(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsBold <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsBold()
	 * @see #isIsBold()
	 * @see #setIsBold(boolean)
	 * @generated
	 */
	void unsetIsBold();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsBold <em>Is Bold</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Bold</em>' attribute is set.
	 * @see #unsetIsBold()
	 * @see #isIsBold()
	 * @see #setIsBold(boolean)
	 * @generated
	 */
	boolean isSetIsBold();

	/**
	 * Returns the value of the '<em><b>Is Italic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Italic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Italic</em>' attribute.
	 * @see #isSetIsItalic()
	 * @see #unsetIsItalic()
	 * @see #setIsItalic(boolean)
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_IsItalic()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isItalic'"
	 * @generated
	 */
	boolean isIsItalic();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsItalic <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Italic</em>' attribute.
	 * @see #isSetIsItalic()
	 * @see #unsetIsItalic()
	 * @see #isIsItalic()
	 * @generated
	 */
	void setIsItalic(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsItalic <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsItalic()
	 * @see #isIsItalic()
	 * @see #setIsItalic(boolean)
	 * @generated
	 */
	void unsetIsItalic();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsItalic <em>Is Italic</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Italic</em>' attribute is set.
	 * @see #unsetIsItalic()
	 * @see #isIsItalic()
	 * @see #setIsItalic(boolean)
	 * @generated
	 */
	boolean isSetIsItalic();

	/**
	 * Returns the value of the '<em><b>Is Strike Through</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strike Through</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strike Through</em>' attribute.
	 * @see #isSetIsStrikeThrough()
	 * @see #unsetIsStrikeThrough()
	 * @see #setIsStrikeThrough(boolean)
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_IsStrikeThrough()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isStrikeThrough'"
	 * @generated
	 */
	boolean isIsStrikeThrough();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strike Through</em>' attribute.
	 * @see #isSetIsStrikeThrough()
	 * @see #unsetIsStrikeThrough()
	 * @see #isIsStrikeThrough()
	 * @generated
	 */
	void setIsStrikeThrough(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsStrikeThrough()
	 * @see #isIsStrikeThrough()
	 * @see #setIsStrikeThrough(boolean)
	 * @generated
	 */
	void unsetIsStrikeThrough();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsStrikeThrough <em>Is Strike Through</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Strike Through</em>' attribute is set.
	 * @see #unsetIsStrikeThrough()
	 * @see #isIsStrikeThrough()
	 * @see #setIsStrikeThrough(boolean)
	 * @generated
	 */
	boolean isSetIsStrikeThrough();

	/**
	 * Returns the value of the '<em><b>Is Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Underline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Underline</em>' attribute.
	 * @see #isSetIsUnderline()
	 * @see #unsetIsUnderline()
	 * @see #setIsUnderline(boolean)
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_IsUnderline()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isUnderline'"
	 * @generated
	 */
	boolean isIsUnderline();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsUnderline <em>Is Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Underline</em>' attribute.
	 * @see #isSetIsUnderline()
	 * @see #unsetIsUnderline()
	 * @see #isIsUnderline()
	 * @generated
	 */
	void setIsUnderline(boolean value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsUnderline <em>Is Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsUnderline()
	 * @see #isIsUnderline()
	 * @see #setIsUnderline(boolean)
	 * @generated
	 */
	void unsetIsUnderline();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#isIsUnderline <em>Is Underline</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Underline</em>' attribute is set.
	 * @see #unsetIsUnderline()
	 * @see #isIsUnderline()
	 * @see #setIsUnderline(boolean)
	 * @generated
	 */
	boolean isSetIsUnderline();

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
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#getName <em>Name</em>}' attribute.
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
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #setSize(double)
	 * @see eu.aniketos.mtm.model.mtm_dc.DcPackage#getFont_Size()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='size'"
	 * @generated
	 */
	double getSize();

	/**
	 * Sets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #isSetSize()
	 * @see #unsetSize()
	 * @see #getSize()
	 * @generated
	 */
	void setSize(double value);

	/**
	 * Unsets the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSize()
	 * @see #getSize()
	 * @see #setSize(double)
	 * @generated
	 */
	void unsetSize();

	/**
	 * Returns whether the value of the '{@link eu.aniketos.mtm.model.mtm_dc.Font#getSize <em>Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Size</em>' attribute is set.
	 * @see #unsetSize()
	 * @see #getSize()
	 * @see #setSize(double)
	 * @generated
	 */
	boolean isSetSize();

} // Font
