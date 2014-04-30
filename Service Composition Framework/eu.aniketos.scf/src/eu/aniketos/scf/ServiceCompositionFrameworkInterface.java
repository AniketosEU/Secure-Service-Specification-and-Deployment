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
package eu.aniketos.scf;

import java.util.List;
import java.util.Map;
import java.util.Set;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.scf.data.impl.Service;
import eu.aniketos.sre.DeployResult;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public interface ServiceCompositionFrameworkInterface {

	
	/**
	 * @param serviceQuery The query of the service
	 * @return A set of services comply with the service query
	 */
	public Set<Service> discoverServices(ServiceQuery serviceQuery, String addressMarketplace);
	
	/**
	 * @param serviceSpecification The BPMN service specification
	 * @param servicesLocations A Map containing the serviceTask id as key and a set of services as value
	 * @return The list containing all the created composition plans
	 */
	public List<ICompositionPlan> createCompositionPlans(ICompositionPlan serviceSpecification, Map<String,Set<Service>> mapTaskServices);

	/**
	 * @param compositionPlan The compositionPlan related to the desired agreement template
	 * @return A List of Agreement Template
	 */
	public List<IAgreementTemplate> getAgreementTemplates(ICompositionPlan compositionPlan);
	
	/**
	 * @param serviceSpecification The composition plan to be checked
	 * @param srs The SRS file extracted from the STS tool
	 * @param mapping The mapping file needed to check the security compliance
	 * @param srcmAddress The address of the SRCM component
	 * @return An XML file containing the satisified/unsatisified security requirements
	 */
	public String checkBPMNSpecificationWithSRCM(ICompositionPlan serviceSpecification, String srs, String mapping, String srcmAddress);
	
	/**
	 * @param threatId The id of the Threat
	 * @param addressTRRM The address of the TRRM component
	 * @return A list of countermeasures for the specified Threat
	 */
	public List<String> requestCountermeasuresFromTRRM(String threatId, String addressTRRM);
	
	/**
	 * @param compositionPlans The composition plan to be deployed
	 * @param serviceName The service name of the deployed composite service
	 * @param operationName The name of the operation provided by the deployed composite service
	 * @param tags The tag field used by the SRE to announce the composite service into the Marketplace
	 * @param consumerPolicy The consumer policy file (XML conspec file) of the composite service
	 * @param agreementTemplate The agreement template file (XML conspec file) of the composite service
	 * @param rules The XML file containing the rules of the composite service to be managed at runtime by the SRE
	 * @param sreAddress The address of the SRE component
	 * @return
	 */
	public DeployResult deployService(List<ICompositionPlan> compositionPlans, String serviceName, String operationName, String[] tags, IConsumerPolicy consumerPolicy, IAgreementTemplate agreementTemplate, String rules, String sreAddress);
	
	/**
	 * @param proxyHost The host of the Proxy
	 * @param proxyPort The port of the Proxy
	 * @param proxyUsername The username of the Proxy
	 * @param proxyPassword The password of the Proxy
	 */
	public void setProxy(String proxyHost, String proxyPort, String proxyUsername, String proxyPassword);
}
