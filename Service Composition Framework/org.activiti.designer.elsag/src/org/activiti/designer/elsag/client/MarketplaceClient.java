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
package org.activiti.designer.elsag.client;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;

import org.activiti.designer.elsag.tagCloud.Type;
import org.apache.log4j.Logger;

import eu.aniketos.marketplace.ArrayOfTag;
import eu.aniketos.marketplace.IMarketplace;
import eu.aniketos.marketplace.IMarketplacePortType;
import eu.aniketos.marketplace.Tag;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class MarketplaceClient {
	
	final private static Logger log = Logger.getLogger(MarketplaceClient.class);
	
	public static ArrayList<Type> getTags(String addressMarketplace, String proxyHost, String proxyPort, String proxyUsername, String proxyPassword){
		log.info("Getting tags from the Marketplace");

		if(!proxyHost.equals("noproxy") && !proxyPort.equals("noproxy")){
			System.setProperty("http.proxyHost", proxyHost);
			System.setProperty("http.proxyPort", proxyPort);
			log.debug("Set proxy with host "+ proxyHost + " and port "+ proxyPort);
		} else {
			System.setProperty("http.proxyHost", "");
			System.setProperty("http.proxyPort", "");
			log.debug("Proxy not set");
		}
		if(!proxyUsername.equals("noproxy") && !proxyPassword.equals("noproxy")) {
			final String authUser = proxyUsername;
			final String authPassword = proxyPassword;
			Authenticator.setDefault(
			   new Authenticator() {
			      public PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication(
			               authUser, authPassword.toCharArray());
			      }
			   }
			);
			System.setProperty("http.proxyUser", authUser);
			System.setProperty("http.proxyPassword", authPassword);
			log.debug("Set proxy with username "+ authUser + " and password "+ authPassword);
		} else {
			System.setProperty("http.proxyUser", "");
			System.setProperty("http.proxyPassword", "");
			log.debug("Proxy not set");
		}
		
		QName serviceName = new QName("http://marketplace.aniketos.eu/", "IMarketplace");
		URL url = null;
		ArrayList<Type> types = new ArrayList<Type>();
		try {
			URL baseUrl;
			baseUrl = eu.aniketos.marketplace.IMarketplace.class.getResource(".");
			url = new URL(baseUrl, addressMarketplace);

			IMarketplace marketplaceService = new IMarketplace(url,serviceName);
			IMarketplacePortType marketplace = marketplaceService.getIMarketplacePort();
			
			ArrayOfTag arrayTags = marketplace.getTags(null);
			List<Tag> tags = arrayTags.getTag();
			for(Tag tag : tags){
				String value = tag.getTag().getValue();
				int occurences = tag.getOccurences();
				types.add(new Type(value, occurences));
			}
		} catch (MalformedURLException ex) {
			log.error(ex);
			return null;
		} catch (WebServiceException e){
			log.error(e);
			return null;
		}
		
		return types;
		
	}

}
