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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.data.Data;
import org.apache.log4j.Logger;
import org.eclipse.emf.validation.internal.util.Log;

import eu.aniketos.wp5.components.idm.EntityId;
import eu.aniketos.wp5.components.idm.IdentityRepositoryService;
import eu.aniketos.wp5.components.idm.IdentityRepositoryServicePortType;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class IdMClient {
	
	final private static Logger log = Logger.getLogger(IdMClient.class);
	
	public static int authenticate(String username, String password){
		
		Properties prop = Activator.getConfigProperties();
		
		log.info("Connecting to the IdM");
		
		QName serviceName = new QName("http://idm.components.wp5.aniketos.eu/", "IdentityRepositoryService");
		URL url = null;
		EntityId entity = null;
        try {
            URL baseUrl;
            baseUrl = eu.aniketos.wp5.components.idm.IdentityRepositoryService.class.getResource(".");
            url = new URL(baseUrl, prop.getProperty("IdentityManagementServiceAddress"));
        
        
		IdentityRepositoryService identityRepositoryService = new IdentityRepositoryService (url, serviceName);
		IdentityRepositoryServicePortType identityRepository = identityRepositoryService.getIdentityRepositoryServicePort();
		
		entity = identityRepository.authenticateEntity(username, password);
        } catch (MalformedURLException ex) {
        	log.error(ex);
        } catch(javax.xml.ws.WebServiceException ex) {
        	log.error(ex);
			return Data.AUTHERROR;
		}

		boolean result = entity.isResult();
		
		log.info("Result is: "+result);
		
		if(result)
			return Data.AUTHTRUE;
		else
			return Data.AUTHFALSE;

	}

}
