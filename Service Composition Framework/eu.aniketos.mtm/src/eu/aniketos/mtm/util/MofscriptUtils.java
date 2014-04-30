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
package eu.aniketos.mtm.util;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;


/**
 * 
 * Static methods implementing functionalities called from inside mofscript.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class MofscriptUtils {
	/**
	 * Creates a QName object from a string.
	 * @param element Input string.
	 * @return The new QName object.
	 */
	public static QName buildQName(String element) {
		QName qName = null;
		try {
			qName = new QName(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qName;
	}
	
	public static Float int2float(Integer integer) {
		return new Float(integer);
	}

	/**
	 * Creates a FeatureMap.Entry should represent a variable that will be wrapped in a BPMN user task.
	 * Currently not working when called from mofscript, due to reflection issues.
	 * @param id The variable id.
	 * @param name The variable name.
	 * @return The new FeatureMap.Entry representing the variable.
	 */
	/*
	public static FeatureMap.Entry buildEntry(String id, String name) {
		FeatureMap.Entry entry = null;

		try {
			FormPropertyType fpt = ActivitiFactory.eINSTANCE.createFormPropertyType();
			fpt.setId(id);
			fpt.setName(name);
			fpt.setType("out");
			entry = FeatureMapUtil.createEntry(ActivitiPackage.Literals.DOCUMENT_ROOT__FORM_PROPERTY, fpt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entry;
	}
	*/
}
