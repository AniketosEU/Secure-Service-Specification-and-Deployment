package eu.aniketos.data.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.data.ISecurityProperty;

public class ConsumerPolicy implements IConsumerPolicy {

	private String xmlContent;
	private String[] xmlContents;
	Map<String, ISecurityProperty> properties;
	
	public String[] getXmlContents() {
		return xmlContents;
	}

	public void setXmlContents(String[] xmlContents) {
		this.xmlContents = xmlContents;
	}	

	public ConsumerPolicy() {
		properties = new HashMap<String, ISecurityProperty>();
	}

	public void setXML(String xmlContent) {
		this.xmlContent = xmlContent;
	}

	public String getXML() {
		return xmlContent;
	}

	public void addProperty(ISecurityProperty arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<ISecurityProperty> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public ISecurityProperty getProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeProperty(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setProperties(Map<String, ISecurityProperty> arg0) {
		// TODO Auto-generated method stub
		
	}

}
