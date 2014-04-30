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
package org.eclipse.dd.dc.impl;

import java.util.Map;

import org.eclipse.dd.dc.DcPackage;
import org.eclipse.dd.dc.Font;

import org.eclipse.dd.dc.util.DcValidator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#isIsBold <em>Is Bold</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#isIsItalic <em>Is Italic</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#isIsStrikeThrough <em>Is Strike Through</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#isIsUnderline <em>Is Underline</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.dd.dc.impl.FontImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FontImpl extends EObjectImpl implements Font {
	/**
	 * The default value of the '{@link #isIsBold() <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBold()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BOLD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBold() <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBold()
	 * @generated
	 * @ordered
	 */
	protected boolean isBold = IS_BOLD_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsItalic() <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsItalic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ITALIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsItalic() <em>Is Italic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsItalic()
	 * @generated
	 * @ordered
	 */
	protected boolean isItalic = IS_ITALIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsStrikeThrough() <em>Is Strike Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrikeThrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRIKE_THROUGH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStrikeThrough() <em>Is Strike Through</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStrikeThrough()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrikeThrough = IS_STRIKE_THROUGH_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUnderline() <em>Is Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnderline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNDERLINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUnderline() <em>Is Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnderline()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnderline = IS_UNDERLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final float SIZE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected float size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DcPackage.Literals.FONT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBold() {
		return isBold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBold(boolean newIsBold) {
		boolean oldIsBold = isBold;
		isBold = newIsBold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__IS_BOLD, oldIsBold, isBold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsItalic() {
		return isItalic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsItalic(boolean newIsItalic) {
		boolean oldIsItalic = isItalic;
		isItalic = newIsItalic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__IS_ITALIC, oldIsItalic, isItalic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStrikeThrough() {
		return isStrikeThrough;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrikeThrough(boolean newIsStrikeThrough) {
		boolean oldIsStrikeThrough = isStrikeThrough;
		isStrikeThrough = newIsStrikeThrough;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__IS_STRIKE_THROUGH, oldIsStrikeThrough, isStrikeThrough));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnderline() {
		return isUnderline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnderline(boolean newIsUnderline) {
		boolean oldIsUnderline = isUnderline;
		isUnderline = newIsUnderline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__IS_UNDERLINE, oldIsUnderline, isUnderline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(float newSize) {
		float oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DcPackage.FONT__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean non_negative_size(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 DcValidator.DIAGNOSTIC_SOURCE,
						 DcValidator.FONT__NON_NEGATIVE_SIZE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "non_negative_size", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DcPackage.FONT__IS_BOLD:
				return isIsBold();
			case DcPackage.FONT__IS_ITALIC:
				return isIsItalic();
			case DcPackage.FONT__IS_STRIKE_THROUGH:
				return isIsStrikeThrough();
			case DcPackage.FONT__IS_UNDERLINE:
				return isIsUnderline();
			case DcPackage.FONT__NAME:
				return getName();
			case DcPackage.FONT__SIZE:
				return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DcPackage.FONT__IS_BOLD:
				setIsBold((Boolean)newValue);
				return;
			case DcPackage.FONT__IS_ITALIC:
				setIsItalic((Boolean)newValue);
				return;
			case DcPackage.FONT__IS_STRIKE_THROUGH:
				setIsStrikeThrough((Boolean)newValue);
				return;
			case DcPackage.FONT__IS_UNDERLINE:
				setIsUnderline((Boolean)newValue);
				return;
			case DcPackage.FONT__NAME:
				setName((String)newValue);
				return;
			case DcPackage.FONT__SIZE:
				setSize((Float)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DcPackage.FONT__IS_BOLD:
				setIsBold(IS_BOLD_EDEFAULT);
				return;
			case DcPackage.FONT__IS_ITALIC:
				setIsItalic(IS_ITALIC_EDEFAULT);
				return;
			case DcPackage.FONT__IS_STRIKE_THROUGH:
				setIsStrikeThrough(IS_STRIKE_THROUGH_EDEFAULT);
				return;
			case DcPackage.FONT__IS_UNDERLINE:
				setIsUnderline(IS_UNDERLINE_EDEFAULT);
				return;
			case DcPackage.FONT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DcPackage.FONT__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DcPackage.FONT__IS_BOLD:
				return isBold != IS_BOLD_EDEFAULT;
			case DcPackage.FONT__IS_ITALIC:
				return isItalic != IS_ITALIC_EDEFAULT;
			case DcPackage.FONT__IS_STRIKE_THROUGH:
				return isStrikeThrough != IS_STRIKE_THROUGH_EDEFAULT;
			case DcPackage.FONT__IS_UNDERLINE:
				return isUnderline != IS_UNDERLINE_EDEFAULT;
			case DcPackage.FONT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DcPackage.FONT__SIZE:
				return size != SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isBold: ");
		result.append(isBold);
		result.append(", isItalic: ");
		result.append(isItalic);
		result.append(", isStrikeThrough: ");
		result.append(isStrikeThrough);
		result.append(", isUnderline: ");
		result.append(isUnderline);
		result.append(", name: ");
		result.append(name);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //FontImpl
