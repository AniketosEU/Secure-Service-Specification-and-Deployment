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
package org.eclipse.dd.di;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Participant Band Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.dd.di.DiPackage#getParticipantBandKind()
 * @model
 * @generated
 */
public enum ParticipantBandKind implements Enumerator {
	/**
	 * The '<em><b>Top initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_INITIATING(0, "top_initiating", "top_initiating"),

	/**
	 * The '<em><b>Middle initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIDDLE_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	MIDDLE_INITIATING(1, "middle_initiating", "middle_initiating"),

	/**
	 * The '<em><b>Bottom initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_INITIATING(2, "bottom_initiating", "bottom_initiating"),

	/**
	 * The '<em><b>Top non initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOP_NON_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_NON_INITIATING(3, "top_non_initiating", "top_non_initiating"),

	/**
	 * The '<em><b>Middle non initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIDDLE_NON_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	MIDDLE_NON_INITIATING(4, "middle_non_initiating", "middle_non_initiating"),

	/**
	 * The '<em><b>Bottom non initiating</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_NON_INITIATING_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_NON_INITIATING(5, "bottom_non_initiating", "bottom_non_initiating");

	/**
	 * The '<em><b>Top initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_INITIATING
	 * @model name="top_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int TOP_INITIATING_VALUE = 0;

	/**
	 * The '<em><b>Middle initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Middle initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIDDLE_INITIATING
	 * @model name="middle_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int MIDDLE_INITIATING_VALUE = 1;

	/**
	 * The '<em><b>Bottom initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_INITIATING
	 * @model name="bottom_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_INITIATING_VALUE = 2;

	/**
	 * The '<em><b>Top non initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Top non initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_NON_INITIATING
	 * @model name="top_non_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int TOP_NON_INITIATING_VALUE = 3;

	/**
	 * The '<em><b>Middle non initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Middle non initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIDDLE_NON_INITIATING
	 * @model name="middle_non_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int MIDDLE_NON_INITIATING_VALUE = 4;

	/**
	 * The '<em><b>Bottom non initiating</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bottom non initiating</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_NON_INITIATING
	 * @model name="bottom_non_initiating"
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_NON_INITIATING_VALUE = 5;

	/**
	 * An array of all the '<em><b>Participant Band Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ParticipantBandKind[] VALUES_ARRAY =
		new ParticipantBandKind[] {
			TOP_INITIATING,
			MIDDLE_INITIATING,
			BOTTOM_INITIATING,
			TOP_NON_INITIATING,
			MIDDLE_NON_INITIATING,
			BOTTOM_NON_INITIATING,
		};

	/**
	 * A public read-only list of all the '<em><b>Participant Band Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ParticipantBandKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Participant Band Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParticipantBandKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParticipantBandKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Participant Band Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParticipantBandKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParticipantBandKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Participant Band Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParticipantBandKind get(int value) {
		switch (value) {
			case TOP_INITIATING_VALUE: return TOP_INITIATING;
			case MIDDLE_INITIATING_VALUE: return MIDDLE_INITIATING;
			case BOTTOM_INITIATING_VALUE: return BOTTOM_INITIATING;
			case TOP_NON_INITIATING_VALUE: return TOP_NON_INITIATING;
			case MIDDLE_NON_INITIATING_VALUE: return MIDDLE_NON_INITIATING;
			case BOTTOM_NON_INITIATING_VALUE: return BOTTOM_NON_INITIATING;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ParticipantBandKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ParticipantBandKind
