package eu.aniketos.data.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import eu.aniketos.data.ISecurityProperty;
import eu.aniketos.data.IAgreementTemplate;

public class AgreementTemplate implements IAgreementTemplate {

	private String agreementTemplateID;
	private Map<String, ISecurityProperty> properties;
	private String xmlContent;
	private String[] xmlContents;

	public AgreementTemplate(String agreementTemplateID) {
		this.agreementTemplateID = agreementTemplateID;
		properties = new HashMap<String, ISecurityProperty>();
	}

	public String[] getXmlContents() {
		return xmlContents;
	}

	public void setXmlContents(String[] xmlContents) {
		this.xmlContents = xmlContents;
	}	
	
	public String getAgreementTemplateID() {
		return agreementTemplateID;
	}

	@SuppressWarnings("unchecked")
	public List<ISecurityProperty> getProperties() {
		return (List<ISecurityProperty>) properties;
	}

	public ISecurityProperty getProperty(String propertyID) {
		return properties.get(propertyID);
	}

	public void setAgreementTemplateID(String agreementTemplateID) {
		this.agreementTemplateID = agreementTemplateID;
	}

	public void setProperties(Map<String, ISecurityProperty> properties) {
		this.properties = properties;
	}

	public void addProperty(ISecurityProperty property) {
		properties.put(property.getPropertyID(), property);
	}

	public void removeProperty(String propertyID) {
		properties.remove(propertyID);
	}

	public String toString() {
		String temp = "AgreementTemplateID: " + agreementTemplateID + "\n";
		for (String propertyID : properties.keySet()) {
			temp = temp + properties.get(propertyID).toString() + "\n";
		}
		return temp;
	}

	public void setXML(String xmlContent) {
		this.xmlContent = xmlContent;
	}

	public String getXML() {
		return xmlContent;
	}

	public Set<ISecurityProperty> getSecurityProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, ISecurityProperty> getSecurityPropertyMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServiceProviderID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSecurityProperties(Set<ISecurityProperty> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setSecurityPropertyMap(Map<String, ISecurityProperty> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setServiceProviderID(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setSecurityProperties(List<ISecurityProperty> securityProperties) {
		// TODO Auto-generated method stub
		
	}
	
}
