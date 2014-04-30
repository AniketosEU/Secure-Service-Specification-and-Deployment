package org.activiti.designer.export.bpmn20.export;

import java.util.List;

import javax.xml.stream.XMLStreamWriter;

import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.Trustworthiness;

public class SecurityExtensionExport {

	public static void writeSecurityExtensions(XMLStreamWriter xtw, SecurityExtension securityExtension, boolean writeExtensionsElement) throws Exception {
		if (securityExtension != null) {

			if (writeExtensionsElement)
				xtw.writeStartElement("extensionElements");

			if(securityExtension != null){
				xtw.writeStartElement("aniketos", "security", "http://aniketos.eu");
				if (securityExtension.getIntegrityReq()!=null) {
					List<Integrity> listIntegrity = securityExtension.getIntegrityReq();
					for(Integrity integrity : listIntegrity){
						xtw.writeStartElement("aniketos", "integrity", "http://aniketos.eu");
						if(integrity.getType()!=null)
							xtw.writeAttribute("type", integrity.getType());
						if(integrity.getWith()!=null)
							xtw.writeAttribute("with", integrity.getWith());
						if(integrity.getAlgorithm()!=null)
							xtw.writeAttribute("algorithm", integrity.getAlgorithm());
						xtw.writeEndElement();
					}
				}
				if(securityExtension.getTrustworthinessValue()!=null){
					Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
					xtw.writeStartElement("aniketos", "trustworthiness", "http://aniketos.eu");
					if(trustworthiness.getValue()!=null)
						xtw.writeAttribute("value", trustworthiness.getValue());
					xtw.writeEndElement();
				}
				if (securityExtension.getConfidentialityReq()!=null) {
					List<Confidentiality> listConfidentiality = securityExtension.getConfidentialityReq();
					for(Confidentiality confidentiality : listConfidentiality){
						xtw.writeStartElement("aniketos", "confidentiality", "http://aniketos.eu");
						if(confidentiality.getType()!=null)
							xtw.writeAttribute("type", confidentiality.getType());
						if(confidentiality.getAlgorithm()!=null)
							xtw.writeAttribute("algorithm", confidentiality.getAlgorithm());
						xtw.writeEndElement();
					}
				}
				xtw.writeEndElement();
			}
			

			if (writeExtensionsElement)
				xtw.writeEndElement();
		}
	}
}
