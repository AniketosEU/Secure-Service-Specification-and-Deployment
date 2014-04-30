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
package eu.aniketos.scf.implementation;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.marketplace.ArrayOfServiceDescriptor;
import eu.aniketos.marketplace.ServiceDescriptor;
import eu.aniketos.marketplace.ServiceOperation;
import eu.aniketos.scf.*;
import eu.aniketos.scf.data.impl.AgreementTemplate;
import eu.aniketos.scf.data.impl.Service;
import eu.aniketos.scf.implementation.client.MarketplaceClient;
import eu.aniketos.scf.implementation.client.SRCMClient;
import eu.aniketos.scf.implementation.client.SREClient;
import eu.aniketos.scf.implementation.client.TRRMClient;
import eu.aniketos.scf.implementation.util.BPMNParser;
import eu.aniketos.sre.DeployResult;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class ServiceCompositionFramework implements ServiceCompositionFrameworkInterface {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ServiceCompositionFramework.class);

	private String proxyHost;
	private String proxyPort;
	private String proxyUsername;
	private String proxyPassword;
	
	private static final int NTHREDS = 1;

	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#discoverServices(eu.aniketos.scf.ServiceQuery, java.lang.String)
	 */
	public Set<Service> discoverServices(ServiceQuery serviceQuery, String addressMarketplace) {

		if (logger.isDebugEnabled()) {
			logger.debug("Discovering services"); //$NON-NLS-1$
		}

		Set<Service> servicesDiscovered = new HashSet<Service>();
	
		ArrayOfServiceDescriptor serviceDescriptors = MarketplaceClient.discoverServices(serviceQuery, addressMarketplace, proxyHost, proxyPort, proxyUsername, proxyPassword);
		
		List<ServiceDescriptor> listServiceDescriptors = serviceDescriptors.getServiceDescriptor();
		
		for(ServiceDescriptor serviceDescriptor : listServiceDescriptors){
			String location = serviceDescriptor.getBinding().getValue();
			String serviceId = serviceDescriptor.getId().getValue();
			String provider = serviceDescriptor.getProviderName().getValue().toLowerCase();
			List<ServiceOperation> operations = serviceDescriptor.getOperations().getValue().getServiceOperation();
			if(location!=null){
				Service service = new Service(serviceId, location, provider, operations);
				servicesDiscovered.add(service);
			}
		}

		return servicesDiscovered;
		
	}

	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#createCompositionPlans(eu.aniketos.data.ICompositionPlan, java.util.Map)
	 */
	public List<ICompositionPlan> createCompositionPlans(ICompositionPlan serviceSpecification,
			Map<String, Set<Service>> mapTaskServices) {
		
		//Creation of several composition plans combining the service locations

		if (logger.isDebugEnabled()) {
			logger.info("Creating composition Plans for process " +serviceSpecification.getCompositionPlanID()); //$NON-NLS-1$
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		Future<List<ICompositionPlan>> future = executor.submit(new CreateCompositionPlansThread(serviceSpecification, mapTaskServices));
		
		List<ICompositionPlan> listCompositionPlan = new LinkedList<ICompositionPlan>();
		try {
			listCompositionPlan = future.get();
		} catch (InterruptedException e) {
			logger.error(e);
		} catch (ExecutionException e) {
			logger.error(e);
		}
	
		logger.info("Created "+listCompositionPlan.size()+" Composition Plans");

		return listCompositionPlan;


	}

	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#getAgreementTemplates(eu.aniketos.data.ICompositionPlan)
	 */
	public List<IAgreementTemplate> getAgreementTemplates(ICompositionPlan compositionPlan){
		
		logger.info("Taking the Aggrement Templates for "+ compositionPlan.getCompositionPlanID());
		
		List<String> servicesList = BPMNParser.getServicesList(compositionPlan.getBPMNXML());
		
		List<IAgreementTemplate> listAgreementTemplates = new Vector<IAgreementTemplate>();
		
		for(String serviceId : servicesList){
			logger.debug("Taking from the Marketplace the Agreement Template of the service with id "+serviceId);
		
			String agreementTemplateId = "agreementTemplateId"; //Connection with the marketplace to obtain the agreementTemplate
			AgreementTemplate agreementTemplate = new AgreementTemplate(agreementTemplateId);
			agreementTemplate.setXML("XMLContent");
			
			listAgreementTemplates.add(agreementTemplate);
		}
		
		return listAgreementTemplates;
	}
	
	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#checkBPMNSpecificationWithSRCM(eu.aniketos.data.ICompositionPlan, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String checkBPMNSpecificationWithSRCM(
			ICompositionPlan serviceSpecification, String srs, String mapping, String srcmAddress) {

		String status = SRCMClient.getComplianceStatus(srs, mapping, serviceSpecification.getBPMNXML(), serviceSpecification.getActivitiFile(), srcmAddress, proxyHost, proxyPort, proxyUsername, proxyPassword);
		return status;
	}
	
	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#requestCountermeasuresFromTRRM(java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> requestCountermeasuresFromTRRM(
			String threatId, String trrmAddress) {
		
		List<String> countermeasures = TRRMClient.requestCountermeasures(threatId, trrmAddress, proxyHost, proxyPort, proxyUsername, proxyPassword);
		
		return countermeasures;
	}

	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#setProxy(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void setProxy(String proxyHost, String proxyPort, String proxyUsername, String proxyPassword) {
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
		this.proxyUsername = proxyUsername;
		this.proxyPassword = proxyPassword;
		
	}

	/* (non-Javadoc)
	 * @see eu.aniketos.scf.ServiceCompositionFrameworkInterface#deployService(java.util.List, java.lang.String, java.lang.String, java.lang.String[], eu.aniketos.data.IConsumerPolicy, eu.aniketos.data.IAgreementTemplate, java.lang.String, java.lang.String)
	 */
	@Override
	public DeployResult deployService(List<ICompositionPlan> compositionPlans,
			String serviceName, String operationName, String[] tags,
			IConsumerPolicy consumerPolicy,
			IAgreementTemplate agreementTemplate, String rules,
			String sreAddress) {
		
		return SREClient.deploy(compositionPlans, serviceName, operationName, tags, consumerPolicy, agreementTemplate, rules, sreAddress, proxyHost, proxyPort, proxyUsername, proxyPassword);
	}
	
	
	//Deprecated
//	public boolean deployService(ICompositionPlan compositionPlan, String applicationServerAddress, String activitiEngineAddress, String usernameActivitiEngine, String passwordActivitiEngine, String usernameTomcat, String passwordTomcat){
//		
//		//Internal creation of the WAR file and deploy on Tomcat
//		
//		//create and deploy the service in the marketplace
//		Document newDocument = BPMNParser.getDocument(compositionPlan.getBPMNXML());
//		String compositionPlanName = BPMNParser.getProcessId(newDocument);
//		String compositionPlanId = "";
//		try {
//			compositionPlanId = ActivitiEngineClient.getActivitiCompositionPlanId(compositionPlanName, activitiEngineAddress, usernameActivitiEngine, passwordActivitiEngine);
//		} catch(java.net.ConnectException ex){
//			return false;
//		} catch (ClientProtocolException e) {
//			return false;
//		} catch (IOException e) {
//			return false;
//		}
//		if(compositionPlanId != null){
//			CompositeServiceFactory.createServiceInstance(compositionPlanId, compositionPlanName, activitiEngineAddress, usernameActivitiEngine, passwordActivitiEngine);
//			if(CompositeServiceFactory.createWar(compositionPlanName)){
//				if(CompositeServiceFactory.deployWarTomcat(compositionPlanName, applicationServerAddress, usernameTomcat, passwordTomcat)){
//					File f = new File(compositionPlanName+".war");
//					File fDir = new File(compositionPlanName+"/");
//					f.delete();
//					FileOperations.deleteDirectory(fDir);
//					return true;
//				} else {
//					File f = new File(compositionPlanName+".war");
//					File fDir = new File(compositionPlanName+"/");
//					f.delete();
//					FileOperations.deleteDirectory(fDir);
//					return false;
//				}
//			} else {
//				File fDir = new File(compositionPlanName+"/");
//				FileOperations.deleteDirectory(fDir);
//			}
//		}
//		
//		return false;
//	}
	
	//Deprecated
//	public boolean uploadCompositionPlan(String compositionPlanPath, String activitiEngineAddress, String ActivitiEngineUsername, String ActivitiEnginePassword){
//		
//		boolean result = false;
//		try {
//			 String response = ActivitiEngineClient.uploadCompositionPlanToTheActivitiEngine(compositionPlanPath, activitiEngineAddress, ActivitiEngineUsername, ActivitiEnginePassword);
//			 if(response.contains("200")){
//				 result = true;
//			 }
//		} catch (ClientProtocolException e) {
//			return false;
//		} catch (IOException e) {
//			return false;
//		}
//		
//		return result;
//		
//	}

}
