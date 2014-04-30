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

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import eu.aniketos.marketplace.ArrayOfServiceDescriptor;
import eu.aniketos.marketplace.ArrayOfString;
import eu.aniketos.marketplace.IMarketplace;
import eu.aniketos.marketplace.IMarketplacePortType;
import eu.aniketos.marketplace.MarketplaceSearchParams;
import eu.aniketos.marketplace.ObjectFactory;
import eu.aniketos.scf.ServiceQuery;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class MarketplaceClient {
	
	private static final Logger logger = Logger.getLogger(MarketplaceClient.class);
	
	public static ArrayOfServiceDescriptor discoverServices(ServiceQuery serviceQuery, String addressMarketplace, String proxyHost, String proxyPort, String proxyUsername, String proxyPassword){

		if(!proxyHost.equals("noproxy") && !proxyPort.equals("noproxy")){
			System.setProperty("http.proxyHost", proxyHost);
			System.setProperty("http.proxyPort", proxyPort);
		} else {
			System.setProperty("http.proxyHost", "");
			System.setProperty("http.proxyPort", "");
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
		} else {
			System.setProperty("http.proxyUser", "");
			System.setProperty("http.proxyPassword", "");
		}

		QName serviceName = new QName("http://marketplace.aniketos.eu/", "IMarketplace");
		URL url = null;
		try {
			URL baseUrl;
            baseUrl = eu.aniketos.marketplace.IMarketplace.class.getResource(".");
            url = new URL(baseUrl, addressMarketplace);
        } catch (MalformedURLException ex) {
        	logger.error(ex);
        }
		
		//Integration with Aniketos Marketplace
		logger.info("Invoking the Aniketos Marketplace");
		
		IMarketplace marketplaceService = new IMarketplace(url,serviceName);
		IMarketplacePortType marketplace = marketplaceService.getIMarketplacePort();
		
		ObjectFactory o = new ObjectFactory();
		
//		String username = "";
//		String password = "";
//		
//		String authToken = marketplace.getAuthToken(username, password);
		
		MarketplaceSearchParams searchParams = new MarketplaceSearchParams();
		
		ArrayOfString paramArrayOfString = o.createArrayOfString();
		String types = serviceQuery.getType();
		List<String> list = paramArrayOfString.getString();
		
		StringTokenizer st = new StringTokenizer(types);
		while(st.hasMoreTokens()){
			list.add(st.nextToken());
		}
		JAXBElement<ArrayOfString> array = o.createMarketplaceSearchParamsTags(paramArrayOfString);
		searchParams.setTags(array);
		
		ArrayOfServiceDescriptor serviceDescriptors = marketplace.discoverService(null, searchParams);
		
		logger.info("Aniketos Marketplace Invoked!");
		logger.info("Discovered "+serviceDescriptors.getServiceDescriptor().size() + " services");
		
		return serviceDescriptors;
		
	}

}
