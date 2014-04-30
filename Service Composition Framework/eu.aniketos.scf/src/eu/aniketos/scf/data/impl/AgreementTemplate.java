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
package eu.aniketos.scf.data.impl;

import java.util.ArrayList;
import java.util.List;


import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IAgreementTemplate;

/**
 * This class implements the interfaces of IAgreementTemplate and also contains extra methods that used in Work Package 3. 
 * 
 * @author Bo Zhou, LJMU
 * 
 */

public class AgreementTemplate implements IAgreementTemplate{
	/**
	 * The XML content of an agreement template.
	 */
	private String xmlContent;
	/**
	 * The agreement template ID.
	 */
	private String agreementTemplateID;
	/**
	 * A Map that contains all properties. The property value can be retrieved given its ID.
	 */
	private List<ISecurityProperty> properties;
	//There will be a certificate object here in the future.
	
	/** Set the XML content. It is an easy way to modify the agreement template
	 *
	 * @param xmlContent The content of an agreement template in XML format.
	 * 
	 */
	public void setXML (String xmlContent)
	{
		this.xmlContent = xmlContent;
	}
	
	/** Get the XML content of agreement template. It temporarily used to replace method toString().
	 *
	 * @return The content of an agreement template in XML format.
	 * 
	 */
	public String getXML()
	{
		// TODO Auto-generated method stub
		return xmlContent;
	}
	
	/** Constructor.
	 *
	 * @param agreementTemplateID The ID of the agreement template.
	 * 
	 */
	public AgreementTemplate(String agreementTemplateID){		
		this.agreementTemplateID = agreementTemplateID;
		properties = new ArrayList<ISecurityProperty>();
	}
	
	/** Get an agreement template ID.
	 *
	 * @return The ID of the agreement template.
	 * 
	 */
	public String getAgreementTemplateID() {
		return agreementTemplateID;
	}
	
	/** Get all properties in an agreement template.
	 *
	 * @return All properties of the agreement template. 
	 * It's saved in a map from where value can be retrieved given the property ID.
	 * 
	 */
	public List<ISecurityProperty> getProperties() {
		return properties;
	}
	
	/** Get the value of a property given its ID.
	 *
	 * @param propertyID The ID of a property.
	 * @return The value of the property that specified with ID.
	 * 
	 */
	public ISecurityProperty getProperty(String propertyID) {
		
		for(ISecurityProperty property : properties){
			if (property.getPropertyID().equals(propertyID))
			{
				return property;
			}
		}
		return null;
	
	}
	
	/** Set the agreement template ID.
	 *
	 * @param agreementTemplateID The ID of the agreement template.
	 * 
	 */
	public void setAgreementTemplateID(String agreementTemplateID) {
		this.agreementTemplateID = agreementTemplateID;
	}

	/** Set properties in the agreement template.
	 *
	 * @param properties The properties of the agreement template. 
	 * It's in a form of map from where value can be retrieved given the property ID.
	 * 
	 */
	public void setProperties(List<ISecurityProperty> properties) {
		this.properties = properties;
	}

	/** Add a new property in an agreement template.
	 *
	 * @param property The property that to be added. 
	 * It contains both ID and value. 
	 * 
	 */
	public void addProperty(ISecurityProperty property) {
		properties.add(property);
	}

	/** Remove a property from an agreement template.
	 *
	 * @param propertyID The ID that is used to find the property in the properties Map. 
	 * 
	 */
	public void removeProperty(String propertyID) {
		properties.remove(propertyID);
	}

	/** Output the content of the AgreementTemplate.
	 *
	 * @return A String that contains all the properties in the agreement template. This is currently not used.
	 * 			A simplified solution of getXML() is temporarily in use. 
	 * 
	 */
	public String toString(){
		String temp = "AgreementTemplateID: "+agreementTemplateID+"\n";
		for(ISecurityProperty property : properties){
			temp = temp + property.toString()+"\n";
		}
		return temp;
	}


	public void setSecurityProperties(List<ISecurityProperty> securityProperties) {
		properties = securityProperties;
		
	}

	@Override
	public String[] getXmlContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setXmlContents(String[] arg0) {
		// TODO Auto-generated method stub
		
	}


}
