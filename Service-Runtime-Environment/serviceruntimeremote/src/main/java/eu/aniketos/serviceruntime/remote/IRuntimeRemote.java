package eu.aniketos.serviceruntime.remote;

import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;

/**
 * Interface that provides methods for communicating with an Activiti Runtime Instance
 * @author Kostas Giannakakis
 *
 */
public interface IRuntimeRemote {

    
	/**
	 * Deploys a composite service. A web service is deployed in Tomcat and a process is
	 * uploaded in Activiti
	 * @param compositionPlans The composition plans of the service. The first is the
     * default one. Others are alternatives
	 * @param agreementTemplate The agreement template serialized
	 * @param consumerPolicy The consumer policy serialized
     * @param rules The rules associated with the service in XML format
     * @param deployDetails The deployment details
	 * @return the result of the operation
	 */
	DeployResult deploy(ICompositionPlan [] compositionPlans, 
			String agreementTemplate, IConsumerPolicy consumerPolicy,
            String rules, DeploymentDetails deployDetails);      
}
