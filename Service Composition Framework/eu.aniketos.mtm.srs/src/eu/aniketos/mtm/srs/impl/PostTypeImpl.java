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
package eu.aniketos.mtm.srs.impl;

import eu.aniketos.mtm.srs.AuthType;
import eu.aniketos.mtm.srs.AvailabilityType;
import eu.aniketos.mtm.srs.BoDSoDActorType;
import eu.aniketos.mtm.srs.BoDSoDGoalType;
import eu.aniketos.mtm.srs.ConfidentialityType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.IntegrityType;
import eu.aniketos.mtm.srs.NDType;
import eu.aniketos.mtm.srs.NRType;
import eu.aniketos.mtm.srs.NTKType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.RedType;
import eu.aniketos.mtm.srs.SrsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Post Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonDelegation <em>Non Delegation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonRepudiation <em>Non Repudiation</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getRedundancy <em>Redundancy</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNeedToKnow <em>Need To Know</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonDisclosure <em>Non Disclosure</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonModification <em>Non Modification</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonUsage <em>Non Usage</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNonProduction <em>Non Production</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getPlayBoth <em>Play Both</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNotPlayBoth <em>Not Play Both</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getAchieveInCombination <em>Achieve In Combination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getNotAchieveInCombination <em>Not Achieve In Combination</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getIntegrity <em>Integrity</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getAvailability <em>Availability</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getConfidentiality <em>Confidentiality</em>}</li>
 *   <li>{@link eu.aniketos.mtm.srs.impl.PostTypeImpl#getDelegation <em>Delegation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PostTypeImpl extends EObjectImpl implements PostType {
	/**
	 * The cached value of the '{@link #getNonDelegation() <em>Non Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonDelegation()
	 * @generated
	 * @ordered
	 */
	protected NDType nonDelegation;

	/**
	 * The cached value of the '{@link #getNonRepudiation() <em>Non Repudiation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonRepudiation()
	 * @generated
	 * @ordered
	 */
	protected NRType nonRepudiation;

	/**
	 * The cached value of the '{@link #getRedundancy() <em>Redundancy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedundancy()
	 * @generated
	 * @ordered
	 */
	protected RedType redundancy;

	/**
	 * The cached value of the '{@link #getNeedToKnow() <em>Need To Know</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeedToKnow()
	 * @generated
	 * @ordered
	 */
	protected NTKType needToKnow;

	/**
	 * The cached value of the '{@link #getNonDisclosure() <em>Non Disclosure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonDisclosure()
	 * @generated
	 * @ordered
	 */
	protected AuthType nonDisclosure;

	/**
	 * The cached value of the '{@link #getNonModification() <em>Non Modification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonModification()
	 * @generated
	 * @ordered
	 */
	protected AuthType nonModification;

	/**
	 * The cached value of the '{@link #getNonUsage() <em>Non Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonUsage()
	 * @generated
	 * @ordered
	 */
	protected AuthType nonUsage;

	/**
	 * The cached value of the '{@link #getNonProduction() <em>Non Production</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonProduction()
	 * @generated
	 * @ordered
	 */
	protected AuthType nonProduction;

	/**
	 * The cached value of the '{@link #getPlayBoth() <em>Play Both</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayBoth()
	 * @generated
	 * @ordered
	 */
	protected BoDSoDActorType playBoth;

	/**
	 * The cached value of the '{@link #getNotPlayBoth() <em>Not Play Both</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotPlayBoth()
	 * @generated
	 * @ordered
	 */
	protected BoDSoDActorType notPlayBoth;

	/**
	 * The cached value of the '{@link #getAchieveInCombination() <em>Achieve In Combination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAchieveInCombination()
	 * @generated
	 * @ordered
	 */
	protected BoDSoDGoalType achieveInCombination;

	/**
	 * The cached value of the '{@link #getNotAchieveInCombination() <em>Not Achieve In Combination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotAchieveInCombination()
	 * @generated
	 * @ordered
	 */
	protected BoDSoDGoalType notAchieveInCombination;

	/**
	 * The cached value of the '{@link #getIntegrity() <em>Integrity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrity()
	 * @generated
	 * @ordered
	 */
	protected IntegrityType integrity;

	/**
	 * The cached value of the '{@link #getAvailability() <em>Availability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailability()
	 * @generated
	 * @ordered
	 */
	protected AvailabilityType availability;

	/**
	 * The cached value of the '{@link #getConfidentiality() <em>Confidentiality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentiality()
	 * @generated
	 * @ordered
	 */
	protected ConfidentialityType confidentiality;

	/**
	 * The cached value of the '{@link #getDelegation() <em>Delegation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegation()
	 * @generated
	 * @ordered
	 */
	protected DelType delegation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PostTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SrsPackage.Literals.POST_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NDType getNonDelegation() {
		return nonDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonDelegation(NDType newNonDelegation, NotificationChain msgs) {
		NDType oldNonDelegation = nonDelegation;
		nonDelegation = newNonDelegation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_DELEGATION, oldNonDelegation, newNonDelegation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonDelegation(NDType newNonDelegation) {
		if (newNonDelegation != nonDelegation) {
			NotificationChain msgs = null;
			if (nonDelegation != null)
				msgs = ((InternalEObject)nonDelegation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_DELEGATION, null, msgs);
			if (newNonDelegation != null)
				msgs = ((InternalEObject)newNonDelegation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_DELEGATION, null, msgs);
			msgs = basicSetNonDelegation(newNonDelegation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_DELEGATION, newNonDelegation, newNonDelegation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NRType getNonRepudiation() {
		return nonRepudiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonRepudiation(NRType newNonRepudiation, NotificationChain msgs) {
		NRType oldNonRepudiation = nonRepudiation;
		nonRepudiation = newNonRepudiation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_REPUDIATION, oldNonRepudiation, newNonRepudiation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonRepudiation(NRType newNonRepudiation) {
		if (newNonRepudiation != nonRepudiation) {
			NotificationChain msgs = null;
			if (nonRepudiation != null)
				msgs = ((InternalEObject)nonRepudiation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_REPUDIATION, null, msgs);
			if (newNonRepudiation != null)
				msgs = ((InternalEObject)newNonRepudiation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_REPUDIATION, null, msgs);
			msgs = basicSetNonRepudiation(newNonRepudiation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_REPUDIATION, newNonRepudiation, newNonRepudiation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedType getRedundancy() {
		return redundancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRedundancy(RedType newRedundancy, NotificationChain msgs) {
		RedType oldRedundancy = redundancy;
		redundancy = newRedundancy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__REDUNDANCY, oldRedundancy, newRedundancy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRedundancy(RedType newRedundancy) {
		if (newRedundancy != redundancy) {
			NotificationChain msgs = null;
			if (redundancy != null)
				msgs = ((InternalEObject)redundancy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__REDUNDANCY, null, msgs);
			if (newRedundancy != null)
				msgs = ((InternalEObject)newRedundancy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__REDUNDANCY, null, msgs);
			msgs = basicSetRedundancy(newRedundancy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__REDUNDANCY, newRedundancy, newRedundancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NTKType getNeedToKnow() {
		return needToKnow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNeedToKnow(NTKType newNeedToKnow, NotificationChain msgs) {
		NTKType oldNeedToKnow = needToKnow;
		needToKnow = newNeedToKnow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NEED_TO_KNOW, oldNeedToKnow, newNeedToKnow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedToKnow(NTKType newNeedToKnow) {
		if (newNeedToKnow != needToKnow) {
			NotificationChain msgs = null;
			if (needToKnow != null)
				msgs = ((InternalEObject)needToKnow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NEED_TO_KNOW, null, msgs);
			if (newNeedToKnow != null)
				msgs = ((InternalEObject)newNeedToKnow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NEED_TO_KNOW, null, msgs);
			msgs = basicSetNeedToKnow(newNeedToKnow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NEED_TO_KNOW, newNeedToKnow, newNeedToKnow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType getNonDisclosure() {
		return nonDisclosure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonDisclosure(AuthType newNonDisclosure, NotificationChain msgs) {
		AuthType oldNonDisclosure = nonDisclosure;
		nonDisclosure = newNonDisclosure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_DISCLOSURE, oldNonDisclosure, newNonDisclosure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonDisclosure(AuthType newNonDisclosure) {
		if (newNonDisclosure != nonDisclosure) {
			NotificationChain msgs = null;
			if (nonDisclosure != null)
				msgs = ((InternalEObject)nonDisclosure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_DISCLOSURE, null, msgs);
			if (newNonDisclosure != null)
				msgs = ((InternalEObject)newNonDisclosure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_DISCLOSURE, null, msgs);
			msgs = basicSetNonDisclosure(newNonDisclosure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_DISCLOSURE, newNonDisclosure, newNonDisclosure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType getNonModification() {
		return nonModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonModification(AuthType newNonModification, NotificationChain msgs) {
		AuthType oldNonModification = nonModification;
		nonModification = newNonModification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_MODIFICATION, oldNonModification, newNonModification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonModification(AuthType newNonModification) {
		if (newNonModification != nonModification) {
			NotificationChain msgs = null;
			if (nonModification != null)
				msgs = ((InternalEObject)nonModification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_MODIFICATION, null, msgs);
			if (newNonModification != null)
				msgs = ((InternalEObject)newNonModification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_MODIFICATION, null, msgs);
			msgs = basicSetNonModification(newNonModification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_MODIFICATION, newNonModification, newNonModification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType getNonUsage() {
		return nonUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonUsage(AuthType newNonUsage, NotificationChain msgs) {
		AuthType oldNonUsage = nonUsage;
		nonUsage = newNonUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_USAGE, oldNonUsage, newNonUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonUsage(AuthType newNonUsage) {
		if (newNonUsage != nonUsage) {
			NotificationChain msgs = null;
			if (nonUsage != null)
				msgs = ((InternalEObject)nonUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_USAGE, null, msgs);
			if (newNonUsage != null)
				msgs = ((InternalEObject)newNonUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_USAGE, null, msgs);
			msgs = basicSetNonUsage(newNonUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_USAGE, newNonUsage, newNonUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthType getNonProduction() {
		return nonProduction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNonProduction(AuthType newNonProduction, NotificationChain msgs) {
		AuthType oldNonProduction = nonProduction;
		nonProduction = newNonProduction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_PRODUCTION, oldNonProduction, newNonProduction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonProduction(AuthType newNonProduction) {
		if (newNonProduction != nonProduction) {
			NotificationChain msgs = null;
			if (nonProduction != null)
				msgs = ((InternalEObject)nonProduction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_PRODUCTION, null, msgs);
			if (newNonProduction != null)
				msgs = ((InternalEObject)newNonProduction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NON_PRODUCTION, null, msgs);
			msgs = basicSetNonProduction(newNonProduction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NON_PRODUCTION, newNonProduction, newNonProduction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDActorType getPlayBoth() {
		return playBoth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlayBoth(BoDSoDActorType newPlayBoth, NotificationChain msgs) {
		BoDSoDActorType oldPlayBoth = playBoth;
		playBoth = newPlayBoth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__PLAY_BOTH, oldPlayBoth, newPlayBoth);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayBoth(BoDSoDActorType newPlayBoth) {
		if (newPlayBoth != playBoth) {
			NotificationChain msgs = null;
			if (playBoth != null)
				msgs = ((InternalEObject)playBoth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__PLAY_BOTH, null, msgs);
			if (newPlayBoth != null)
				msgs = ((InternalEObject)newPlayBoth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__PLAY_BOTH, null, msgs);
			msgs = basicSetPlayBoth(newPlayBoth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__PLAY_BOTH, newPlayBoth, newPlayBoth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDActorType getNotPlayBoth() {
		return notPlayBoth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotPlayBoth(BoDSoDActorType newNotPlayBoth, NotificationChain msgs) {
		BoDSoDActorType oldNotPlayBoth = notPlayBoth;
		notPlayBoth = newNotPlayBoth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NOT_PLAY_BOTH, oldNotPlayBoth, newNotPlayBoth);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotPlayBoth(BoDSoDActorType newNotPlayBoth) {
		if (newNotPlayBoth != notPlayBoth) {
			NotificationChain msgs = null;
			if (notPlayBoth != null)
				msgs = ((InternalEObject)notPlayBoth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NOT_PLAY_BOTH, null, msgs);
			if (newNotPlayBoth != null)
				msgs = ((InternalEObject)newNotPlayBoth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NOT_PLAY_BOTH, null, msgs);
			msgs = basicSetNotPlayBoth(newNotPlayBoth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NOT_PLAY_BOTH, newNotPlayBoth, newNotPlayBoth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDGoalType getAchieveInCombination() {
		return achieveInCombination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAchieveInCombination(BoDSoDGoalType newAchieveInCombination, NotificationChain msgs) {
		BoDSoDGoalType oldAchieveInCombination = achieveInCombination;
		achieveInCombination = newAchieveInCombination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION, oldAchieveInCombination, newAchieveInCombination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAchieveInCombination(BoDSoDGoalType newAchieveInCombination) {
		if (newAchieveInCombination != achieveInCombination) {
			NotificationChain msgs = null;
			if (achieveInCombination != null)
				msgs = ((InternalEObject)achieveInCombination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION, null, msgs);
			if (newAchieveInCombination != null)
				msgs = ((InternalEObject)newAchieveInCombination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION, null, msgs);
			msgs = basicSetAchieveInCombination(newAchieveInCombination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION, newAchieveInCombination, newAchieveInCombination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoDSoDGoalType getNotAchieveInCombination() {
		return notAchieveInCombination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNotAchieveInCombination(BoDSoDGoalType newNotAchieveInCombination, NotificationChain msgs) {
		BoDSoDGoalType oldNotAchieveInCombination = notAchieveInCombination;
		notAchieveInCombination = newNotAchieveInCombination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION, oldNotAchieveInCombination, newNotAchieveInCombination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotAchieveInCombination(BoDSoDGoalType newNotAchieveInCombination) {
		if (newNotAchieveInCombination != notAchieveInCombination) {
			NotificationChain msgs = null;
			if (notAchieveInCombination != null)
				msgs = ((InternalEObject)notAchieveInCombination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION, null, msgs);
			if (newNotAchieveInCombination != null)
				msgs = ((InternalEObject)newNotAchieveInCombination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION, null, msgs);
			msgs = basicSetNotAchieveInCombination(newNotAchieveInCombination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION, newNotAchieveInCombination, newNotAchieveInCombination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityType getIntegrity() {
		return integrity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntegrity(IntegrityType newIntegrity, NotificationChain msgs) {
		IntegrityType oldIntegrity = integrity;
		integrity = newIntegrity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__INTEGRITY, oldIntegrity, newIntegrity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegrity(IntegrityType newIntegrity) {
		if (newIntegrity != integrity) {
			NotificationChain msgs = null;
			if (integrity != null)
				msgs = ((InternalEObject)integrity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__INTEGRITY, null, msgs);
			if (newIntegrity != null)
				msgs = ((InternalEObject)newIntegrity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__INTEGRITY, null, msgs);
			msgs = basicSetIntegrity(newIntegrity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__INTEGRITY, newIntegrity, newIntegrity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityType getAvailability() {
		return availability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAvailability(AvailabilityType newAvailability, NotificationChain msgs) {
		AvailabilityType oldAvailability = availability;
		availability = newAvailability;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__AVAILABILITY, oldAvailability, newAvailability);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailability(AvailabilityType newAvailability) {
		if (newAvailability != availability) {
			NotificationChain msgs = null;
			if (availability != null)
				msgs = ((InternalEObject)availability).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__AVAILABILITY, null, msgs);
			if (newAvailability != null)
				msgs = ((InternalEObject)newAvailability).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__AVAILABILITY, null, msgs);
			msgs = basicSetAvailability(newAvailability, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__AVAILABILITY, newAvailability, newAvailability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityType getConfidentiality() {
		return confidentiality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfidentiality(ConfidentialityType newConfidentiality, NotificationChain msgs) {
		ConfidentialityType oldConfidentiality = confidentiality;
		confidentiality = newConfidentiality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__CONFIDENTIALITY, oldConfidentiality, newConfidentiality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentiality(ConfidentialityType newConfidentiality) {
		if (newConfidentiality != confidentiality) {
			NotificationChain msgs = null;
			if (confidentiality != null)
				msgs = ((InternalEObject)confidentiality).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__CONFIDENTIALITY, null, msgs);
			if (newConfidentiality != null)
				msgs = ((InternalEObject)newConfidentiality).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__CONFIDENTIALITY, null, msgs);
			msgs = basicSetConfidentiality(newConfidentiality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__CONFIDENTIALITY, newConfidentiality, newConfidentiality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DelType getDelegation() {
		return delegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelegation(DelType newDelegation, NotificationChain msgs) {
		DelType oldDelegation = delegation;
		delegation = newDelegation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__DELEGATION, oldDelegation, newDelegation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegation(DelType newDelegation) {
		if (newDelegation != delegation) {
			NotificationChain msgs = null;
			if (delegation != null)
				msgs = ((InternalEObject)delegation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__DELEGATION, null, msgs);
			if (newDelegation != null)
				msgs = ((InternalEObject)newDelegation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SrsPackage.POST_TYPE__DELEGATION, null, msgs);
			msgs = basicSetDelegation(newDelegation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SrsPackage.POST_TYPE__DELEGATION, newDelegation, newDelegation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SrsPackage.POST_TYPE__NON_DELEGATION:
				return basicSetNonDelegation(null, msgs);
			case SrsPackage.POST_TYPE__NON_REPUDIATION:
				return basicSetNonRepudiation(null, msgs);
			case SrsPackage.POST_TYPE__REDUNDANCY:
				return basicSetRedundancy(null, msgs);
			case SrsPackage.POST_TYPE__NEED_TO_KNOW:
				return basicSetNeedToKnow(null, msgs);
			case SrsPackage.POST_TYPE__NON_DISCLOSURE:
				return basicSetNonDisclosure(null, msgs);
			case SrsPackage.POST_TYPE__NON_MODIFICATION:
				return basicSetNonModification(null, msgs);
			case SrsPackage.POST_TYPE__NON_USAGE:
				return basicSetNonUsage(null, msgs);
			case SrsPackage.POST_TYPE__NON_PRODUCTION:
				return basicSetNonProduction(null, msgs);
			case SrsPackage.POST_TYPE__PLAY_BOTH:
				return basicSetPlayBoth(null, msgs);
			case SrsPackage.POST_TYPE__NOT_PLAY_BOTH:
				return basicSetNotPlayBoth(null, msgs);
			case SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION:
				return basicSetAchieveInCombination(null, msgs);
			case SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION:
				return basicSetNotAchieveInCombination(null, msgs);
			case SrsPackage.POST_TYPE__INTEGRITY:
				return basicSetIntegrity(null, msgs);
			case SrsPackage.POST_TYPE__AVAILABILITY:
				return basicSetAvailability(null, msgs);
			case SrsPackage.POST_TYPE__CONFIDENTIALITY:
				return basicSetConfidentiality(null, msgs);
			case SrsPackage.POST_TYPE__DELEGATION:
				return basicSetDelegation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SrsPackage.POST_TYPE__NON_DELEGATION:
				return getNonDelegation();
			case SrsPackage.POST_TYPE__NON_REPUDIATION:
				return getNonRepudiation();
			case SrsPackage.POST_TYPE__REDUNDANCY:
				return getRedundancy();
			case SrsPackage.POST_TYPE__NEED_TO_KNOW:
				return getNeedToKnow();
			case SrsPackage.POST_TYPE__NON_DISCLOSURE:
				return getNonDisclosure();
			case SrsPackage.POST_TYPE__NON_MODIFICATION:
				return getNonModification();
			case SrsPackage.POST_TYPE__NON_USAGE:
				return getNonUsage();
			case SrsPackage.POST_TYPE__NON_PRODUCTION:
				return getNonProduction();
			case SrsPackage.POST_TYPE__PLAY_BOTH:
				return getPlayBoth();
			case SrsPackage.POST_TYPE__NOT_PLAY_BOTH:
				return getNotPlayBoth();
			case SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION:
				return getAchieveInCombination();
			case SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION:
				return getNotAchieveInCombination();
			case SrsPackage.POST_TYPE__INTEGRITY:
				return getIntegrity();
			case SrsPackage.POST_TYPE__AVAILABILITY:
				return getAvailability();
			case SrsPackage.POST_TYPE__CONFIDENTIALITY:
				return getConfidentiality();
			case SrsPackage.POST_TYPE__DELEGATION:
				return getDelegation();
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
			case SrsPackage.POST_TYPE__NON_DELEGATION:
				setNonDelegation((NDType)newValue);
				return;
			case SrsPackage.POST_TYPE__NON_REPUDIATION:
				setNonRepudiation((NRType)newValue);
				return;
			case SrsPackage.POST_TYPE__REDUNDANCY:
				setRedundancy((RedType)newValue);
				return;
			case SrsPackage.POST_TYPE__NEED_TO_KNOW:
				setNeedToKnow((NTKType)newValue);
				return;
			case SrsPackage.POST_TYPE__NON_DISCLOSURE:
				setNonDisclosure((AuthType)newValue);
				return;
			case SrsPackage.POST_TYPE__NON_MODIFICATION:
				setNonModification((AuthType)newValue);
				return;
			case SrsPackage.POST_TYPE__NON_USAGE:
				setNonUsage((AuthType)newValue);
				return;
			case SrsPackage.POST_TYPE__NON_PRODUCTION:
				setNonProduction((AuthType)newValue);
				return;
			case SrsPackage.POST_TYPE__PLAY_BOTH:
				setPlayBoth((BoDSoDActorType)newValue);
				return;
			case SrsPackage.POST_TYPE__NOT_PLAY_BOTH:
				setNotPlayBoth((BoDSoDActorType)newValue);
				return;
			case SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION:
				setAchieveInCombination((BoDSoDGoalType)newValue);
				return;
			case SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION:
				setNotAchieveInCombination((BoDSoDGoalType)newValue);
				return;
			case SrsPackage.POST_TYPE__INTEGRITY:
				setIntegrity((IntegrityType)newValue);
				return;
			case SrsPackage.POST_TYPE__AVAILABILITY:
				setAvailability((AvailabilityType)newValue);
				return;
			case SrsPackage.POST_TYPE__CONFIDENTIALITY:
				setConfidentiality((ConfidentialityType)newValue);
				return;
			case SrsPackage.POST_TYPE__DELEGATION:
				setDelegation((DelType)newValue);
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
			case SrsPackage.POST_TYPE__NON_DELEGATION:
				setNonDelegation((NDType)null);
				return;
			case SrsPackage.POST_TYPE__NON_REPUDIATION:
				setNonRepudiation((NRType)null);
				return;
			case SrsPackage.POST_TYPE__REDUNDANCY:
				setRedundancy((RedType)null);
				return;
			case SrsPackage.POST_TYPE__NEED_TO_KNOW:
				setNeedToKnow((NTKType)null);
				return;
			case SrsPackage.POST_TYPE__NON_DISCLOSURE:
				setNonDisclosure((AuthType)null);
				return;
			case SrsPackage.POST_TYPE__NON_MODIFICATION:
				setNonModification((AuthType)null);
				return;
			case SrsPackage.POST_TYPE__NON_USAGE:
				setNonUsage((AuthType)null);
				return;
			case SrsPackage.POST_TYPE__NON_PRODUCTION:
				setNonProduction((AuthType)null);
				return;
			case SrsPackage.POST_TYPE__PLAY_BOTH:
				setPlayBoth((BoDSoDActorType)null);
				return;
			case SrsPackage.POST_TYPE__NOT_PLAY_BOTH:
				setNotPlayBoth((BoDSoDActorType)null);
				return;
			case SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION:
				setAchieveInCombination((BoDSoDGoalType)null);
				return;
			case SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION:
				setNotAchieveInCombination((BoDSoDGoalType)null);
				return;
			case SrsPackage.POST_TYPE__INTEGRITY:
				setIntegrity((IntegrityType)null);
				return;
			case SrsPackage.POST_TYPE__AVAILABILITY:
				setAvailability((AvailabilityType)null);
				return;
			case SrsPackage.POST_TYPE__CONFIDENTIALITY:
				setConfidentiality((ConfidentialityType)null);
				return;
			case SrsPackage.POST_TYPE__DELEGATION:
				setDelegation((DelType)null);
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
			case SrsPackage.POST_TYPE__NON_DELEGATION:
				return nonDelegation != null;
			case SrsPackage.POST_TYPE__NON_REPUDIATION:
				return nonRepudiation != null;
			case SrsPackage.POST_TYPE__REDUNDANCY:
				return redundancy != null;
			case SrsPackage.POST_TYPE__NEED_TO_KNOW:
				return needToKnow != null;
			case SrsPackage.POST_TYPE__NON_DISCLOSURE:
				return nonDisclosure != null;
			case SrsPackage.POST_TYPE__NON_MODIFICATION:
				return nonModification != null;
			case SrsPackage.POST_TYPE__NON_USAGE:
				return nonUsage != null;
			case SrsPackage.POST_TYPE__NON_PRODUCTION:
				return nonProduction != null;
			case SrsPackage.POST_TYPE__PLAY_BOTH:
				return playBoth != null;
			case SrsPackage.POST_TYPE__NOT_PLAY_BOTH:
				return notPlayBoth != null;
			case SrsPackage.POST_TYPE__ACHIEVE_IN_COMBINATION:
				return achieveInCombination != null;
			case SrsPackage.POST_TYPE__NOT_ACHIEVE_IN_COMBINATION:
				return notAchieveInCombination != null;
			case SrsPackage.POST_TYPE__INTEGRITY:
				return integrity != null;
			case SrsPackage.POST_TYPE__AVAILABILITY:
				return availability != null;
			case SrsPackage.POST_TYPE__CONFIDENTIALITY:
				return confidentiality != null;
			case SrsPackage.POST_TYPE__DELEGATION:
				return delegation != null;
		}
		return super.eIsSet(featureID);
	}

} //PostTypeImpl
