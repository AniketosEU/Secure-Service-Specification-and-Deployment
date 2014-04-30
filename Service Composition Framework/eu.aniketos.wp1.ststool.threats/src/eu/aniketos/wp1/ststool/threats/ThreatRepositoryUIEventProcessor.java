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
/*
* ThreatUIEventProcessor.java
* 
* Contains code from eu.aniketos.wp4.components.threatrepository.client authored by SEARCH
*/
package eu.aniketos.wp1.ststool.threats;

import java.io.StringWriter;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import eu.aniketos.threatrepository.ThreatRepositoryService;
import eu.aniketos.threatrepository.ThreatType;
import eu.aniketos.threatrepository.schema.download.Threat;

public class ThreatRepositoryUIEventProcessor {

	/** The Threat Repository service instance. */
	private ThreatRepositoryService repository; 
	
	
	
	/**
	 * Creates the connector with a reference to the Threat Repository Service
	 * @param context OSGI Bundle context from the Activator
	 */
	public ThreatRepositoryUIEventProcessor() {
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceReference serviceReference = context.getServiceReference(ThreatRepositoryService.class.getName());
		
		if (serviceReference != null)
			repository = (ThreatRepositoryService) context.getService(serviceReference);
		else
			repository = null;
	}
	


	/** 
	 * This function processes UI events for searching for threats by name.
	 * 
	 * @param searchtext The search string the threat's name needs to contain
	 * @return The result of the transaction: either an error message, or the XML contents of the threats that contain the search text.
	 */
	public ArrayList<Threat> processGetThreatsEvent(String searchtext) {
		ArrayList<Threat> result = new ArrayList<Threat>();
		List<Threat> threats = repository.getThreats(searchtext, null, ThreatType.threat);

		for (Threat threat : threats) {
			try {
				StringWriter sw = new StringWriter();
				JAXBContext jc = JAXBContext
						.newInstance(Threat.class);
				Marshaller m = jc.createMarshaller();
				m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
						"http://www.aniketos.eu DownloadThreat.xsd");
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
				m.marshal(threat, sw);
				result.add(threat);
				
			} catch (javax.xml.bind.JAXBException ex) {
				// Add error threat to list? Or just discard?
			}
			
		}
		return result;
	}


	/** This function processes UI events for searching for threats by name.
	 * 
	 * @param searchtext The search string the threat's name needs to contain
	 * @return The result of the transaction: The XML contents of the threats that contain the search text.
	 * @throws Exception If the Threat Repository service has not been initialized.
	 */
	public ArrayList<Threat> processSearchThreatEvent(String searchtext) throws Exception {
		if (repository == null)
			throw new Exception("Threat Repository service has not been initialized.");
		
		List<Threat> res = repository.getThreats(searchtext, null, ThreatType.threat);
		if (null == res)
			throw new ConnectException("No response received from Threat Repository");
		
		ArrayList<Threat> marshalled = new ArrayList<Threat>();

		for (Threat threat : res) {
			try { 
				marshalXmlThreat(threat);
				marshalled.add(threat);
				
			} catch (JAXBException ex) {
				// Do not add the threat to the final results
				// TODO Do some logging/error messaging..?
			}
		}
		return marshalled;
	}

	
	/** This function processes UI events for searching for getting all threats available for STS abstraction level.
	 * 
	 * @return The result of the transaction: The XML contents of the threats.
	 * @throws Exception If the Threat Repository service has not been initialized.
	 */
	public ArrayList<Threat> processGetAllThreatsEvent() throws Exception {
		return processSearchThreatEvent(null);
	}
	

	/** 
	 * This function processes UI events for downloading a threat by UUID.
	 * 
	 * @param uuid The UUID of the threat to download
	 * @return The result of the transaction: either an error message, or the XML contents of the threat.
	 * @throws Exception If the Threat Repository service has not been initialized.
	 */
	public String processDownloadThreatEvent(String uuid) throws Exception {
		if (repository == null)
			throw new Exception("Threat Repository service has not been initialized.");
		
		Threat t = null;
		List<Threat> res = repository.getThreats(null, uuid, null);
		if (null != res)
			if (res.size()>0)
				t = res.get(0); // Only one hit since we are downloading via UUID
			else 
				return ("Resource doesn't exist.\n");
		else
			return ("Resource doesn't exist.\n");
		try {
			StringWriter sw = new StringWriter();
			JAXBContext jc = JAXBContext
					.newInstance(Threat.class);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
					"http://www.aniketos.eu DownloadThreat.xsd");
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(t, sw);
			return 	"Download result:\n-------------------------------------------\n" + sw.toString();
		} catch (javax.xml.bind.JAXBException ex) {
			return ("JAXB Marshalling error\n");
		}
	}
	
	
	private Threat marshalXmlThreat(Threat threat) throws JAXBException {
		StringWriter sw = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(Threat.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.aniketos.eu DownloadThreat.xsd");
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.marshal(threat, sw);
		return threat;
	}

}
