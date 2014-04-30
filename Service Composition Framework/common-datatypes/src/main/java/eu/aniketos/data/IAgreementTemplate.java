package eu.aniketos.data;

import java.util.List;

/**
 * 
 * IAgreementTemplate - an interface specifying a Agreement Template - that is a
 * proposed contract (set of properties) offered by a service.
 * 
 * @author David Lamb, LJMU
 * @revised by Bo Zhou LJMU Aug 2011
 * @revised by Bernard Butler & Barry Mulcahy TSSG Aug 2011
 * @revise by Bo Zhou LJMU Feb 2013
 */
public interface IAgreementTemplate extends ISecurityDescriptor {
	String getAgreementTemplateID();

	void setAgreementTemplateID(String agreementTemplateID);

	void setSecurityProperties(List<ISecurityProperty> securityProperties);

	void setXML(String xmlContent);

	String getXML();

	String[] getXmlContents();

	void setXmlContents(String[] xmlContents);

}
