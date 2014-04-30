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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.sre.ArrayOfICompositionPlan;
import eu.aniketos.sre.ArrayOfString;
import eu.aniketos.sre.DeployResult;
import eu.aniketos.sre.DeploymentDetails;
import eu.aniketos.sre.IRuntimeRemote;
import eu.aniketos.sre.IRuntimeRemotePortType;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class SREClient {
	
	final private static Logger log = Logger.getLogger(SREClient.class);

	public static DeployResult deploy(List<ICompositionPlan> compositionPlans, String name, String operationName, String[] tags, IConsumerPolicy consumerPolicy, IAgreementTemplate agreementTemplate, String rule, String sreAddress, String proxyHost, String proxyPort, String proxyUsername, String proxyPassword){
		
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
		
		QName serviceName = new QName("http://remote.serviceruntime.aniketos.eu/", "IRuntimeRemote");
		URL url = null;
		
		DeployResult result = null;
		try {
			URL baseUrl;
			baseUrl = IRuntimeRemote.class.getResource(".");
			url = new URL(baseUrl,sreAddress);

			IRuntimeRemote sreService = new IRuntimeRemote(url, serviceName);
			IRuntimeRemotePortType sre = sreService.getIRuntimeRemotePort();

			eu.aniketos.sre.ObjectFactory o = new eu.aniketos.sre.ObjectFactory();
			
			ArrayOfICompositionPlan arrayCompositionPlan = o.createArrayOfICompositionPlan();
			List<eu.aniketos.sre.ICompositionPlan> listCompositionPlans = arrayCompositionPlan.getICompositionPlan();
			log.info("Deploying "+compositionPlans.size()+" composition plans");
			int j =0;
			for(ICompositionPlan compositionPlan : compositionPlans){
				log.debug("CompositionPlan "+ j +": "+compositionPlan.getBPMNXML());
				eu.aniketos.sre.ICompositionPlan comp = o.createICompositionPlan();
				JAXBElement<String> c = o.createICompositionPlanBPMNXML(compositionPlan.getBPMNXML());
				comp.setBPMNXML(c);
				JAXBElement<String> id = o.createICompositionPlanCompositionPlanID("compositionPlanId");
				comp.setCompositionPlanID(id);
				
				listCompositionPlans.add(comp);
			}

			String[] consumerPolicies = consumerPolicy.getXmlContents();
			eu.aniketos.sre.IConsumerPolicy policy = o.createIConsumerPolicy();
			ArrayOfString arrayPolicies = o.createArrayOfString();
			List<String> listPolicies = arrayPolicies.getString();
			for(int i = 0; i<consumerPolicies.length; i++){
				listPolicies.add(consumerPolicies[i]);
			}
			policy.setXmlContents(o.createIConsumerPolicyXmlContents(arrayPolicies));

			String templateXML = agreementTemplate.getXML();
			
			DeploymentDetails deploymentDetails = o.createDeploymentDetails();
			deploymentDetails.setServiceName(o.createDeploymentDetailsServiceName(name));
			deploymentDetails.setOperationName(o.createDeploymentDetailsOperationName(operationName));
			ArrayOfString array = o.createArrayOfString();
			List<String> list = array.getString();
			for(int i =0; i<tags.length; i++){
				list.add(tags[i]);
			}
			deploymentDetails.setTags(o.createDeploymentDetailsTags(array));
			
			result = sre.deploy(arrayCompositionPlan, templateXML, policy, rule, deploymentDetails);

		} catch (MalformedURLException ex) {
			log.error("Exception "+ex);
			return null;
		}
		catch(javax.xml.ws.WebServiceException ex) {
			log.error("Exception "+ex);
			result = new DeployResult();
			eu.aniketos.sre.ObjectFactory o = new eu.aniketos.sre.ObjectFactory();
			result.setErrorMessage(o.createDeployResultErrorMessage(ex.toString()));
			result.setOk(false);
			return result;
		}
		
		return result;
		
	}
	

}
