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

import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.data.ISecurityProperty;

/**
 * This class implements the interfaces of IConsumerPolicy and also contains extra methods that used in Work Package 3. 
 * 
 * @author Bo Zhou, LJMU
 * @revised Bo Zhou LJMU Feb 2013
 */
public class ConsumerPolicy implements IConsumerPolicy{

	/**
	 * A List that contains all properties. .
	 */
	List<ISecurityProperty> properties;
	/**
	 * The XML content of a consumer policy. 
	 */
	private String xmlContent;
	
	private String[] consumerPolicies;
	
	/** 
	 * Constructor that initiates the property ID-value Map.
	 * 
	 */
	public ConsumerPolicy(){
		properties = new ArrayList<ISecurityProperty> ();
	}
	
	/** Set the XML content. It is an easy way to modify the consumer policy.
	 *
	 * @param xmlContent The content of a consumer policy in XML format.
	 * 
	 */
	public void setXML(String xmlContent)
	{
		this.xmlContent = xmlContent;
	}
	 
	/** Get the XML content of consumer policy. It temporarily used to replace method toString().
	 *
	 * @return The content of a consumer policy in XML format.
	 * 
	 */
	public String getXML()
	{

		return xmlContent;
	}
	
	/** Get all properties in the consumer policy.
	 *
	 * @return All properties of the consumer policy. 
	 * It's saved in a list.
	 * 
	 */
	public List<ISecurityProperty> getProperties() {
		return properties;
	}

	/** Get the value of a property given its ID
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

	

	/** Add a new property in a consumer policy.
	 *
	 * @param property The property that to be added. It contains both ID and value. 
	 * 
	 */
	public void addProperty(ISecurityProperty property) {
		properties.add(property);
	}

	/** Remove a property from a consumer policy.
	 *
	 * @param propertyID The ID that is used to find the property in the properties Map. 
	 * 
	 */
	public void removeProperty(String propertyID) {
		properties.remove(propertyID);
	}

	@Override
	public String[] getXmlContents() {
		return consumerPolicies;
	}

	@Override
	public void setXmlContents(String[] arg0) {
		this.consumerPolicies = arg0;
		
	}

}
