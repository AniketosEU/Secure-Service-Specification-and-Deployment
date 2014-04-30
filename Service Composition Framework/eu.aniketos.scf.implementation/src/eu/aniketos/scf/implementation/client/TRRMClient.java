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
package eu.aniketos.scf.implementation.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import eu.aniketos.trrm.ArrayOfCountermeasure;
import eu.aniketos.trrm.Countermeasure;
import eu.aniketos.trrm.IThreatResponseRecomm;
import eu.aniketos.trrm.IThreatResponseRecommPortType;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class TRRMClient {
	
	final private static Logger log = Logger.getLogger(TRRMClient.class);
	
	public static List<String> requestCountermeasures(String threatId, String trrmAddress, String proxyHost, String proxyPort, String proxyUsername, String proxyPassword){
		log.info("Taking Countermeasures from TRRM for threat: "+threatId);
		if(!proxyHost.equals("noproxy") && !proxyPort.equals("noproxy")){
			System.setProperty("http.proxyHost", proxyHost);
			System.setProperty("http.proxyPort", proxyPort);
		} else {
			System.setProperty("http.proxyHost", "");
			System.setProperty("http.proxyPort", "");
		}
		if(!proxyUsername.equals("noproxy") && !proxyPassword.equals("noproxy")) {
			System.setProperty("http.proxyUser", proxyUsername);
			System.setProperty("http.proxyPassword", proxyPassword);
		} else {
			System.setProperty("http.proxyUser", "");
			System.setProperty("http.proxyPassword", "");
		}
		
		QName serviceName = new QName("http://trrm.components.wp4.aniketos.eu/", "IThreatResponseRecomm");
		URL url = null;
		IThreatResponseRecommPortType trrm = null;
		try {
			URL baseUrl;
			baseUrl = IThreatResponseRecomm.class.getResource(".");
			url = new URL(baseUrl, trrmAddress);

//			URL url = Activator.getWSDLTRRM();
		
		IThreatResponseRecomm trrmService = new IThreatResponseRecomm(url,serviceName);
		trrm = trrmService.getIThreatResponseRecommPort();
		}
		catch (javax.xml.ws.WebServiceException e) {
			log.error(e);
			return null;
		} catch (MalformedURLException e) {
			log.error(e);
			return null;
		}
		
		List<String> countermeasures = new Vector<String>();
		ArrayOfCountermeasure countermeasuresArray = trrm.requestContermeasuresTRRM(threatId);
		List<Countermeasure> countermesuresList = countermeasuresArray.getCountermeasure();
		for(Countermeasure countermeasure : countermesuresList){
			String countId = countermeasure.getMetadata().getValue().getCounterId().getValue();
			String description = countermeasure.getMetadata().getValue().getDescription().getValue();
			String value = "Id: "+ countId + " - " + description;
			countermeasures.add(value);
		}

		return countermeasures;

	}

}
