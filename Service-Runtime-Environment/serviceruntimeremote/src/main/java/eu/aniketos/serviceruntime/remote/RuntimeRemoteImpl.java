package eu.aniketos.serviceruntime.remote;

import java.util.Dictionary;

import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.marketplace.IMarketplace;
import eu.aniketos.marketplace.MarketplaceAnnouncement;
import eu.aniketos.marketplace.MarketplaceSearchParams;
import eu.aniketos.marketplace.ServiceDescriptor;
import eu.aniketos.marketplace.ServiceOperation;
import eu.aniketos.scpm.ICompositionPlanner;
import eu.aniketos.serviceruntime.bpmn.BpmnUtils;
import eu.aniketos.serviceruntime.data.DataAdapter;
import eu.aniketos.serviceruntime.data.entities.ServiceTask;
import eu.aniketos.serviceruntime.eventlistener.AlertMessage;
import eu.aniketos.serviceruntime.eventlistener.IEventListener;
import eu.aniketos.serviceruntime.notification.NotificationImpl;
import eu.aniketos.serviceruntime.remote.CompositeServiceFactory.Config;
import eu.aniketos.serviceruntime.remote.activiti.ActivitiClient;
import eu.aniketos.serviceruntime.remote.activiti.models.ProcessDefinitionData;
import eu.aniketos.serviceruntime.rules.ActionType;
import eu.aniketos.serviceruntime.rules.Rule;
import eu.aniketos.serviceruntime.rules.RulesParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of an IRemoteImpl
 * @author Kostas Giannakakis
 *
 */
public class RuntimeRemoteImpl implements IRuntimeRemote, IEventListener {

	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(RuntimeRemoteImpl.class);
	
	/** Composite Service Factory configuration */
	private Config config;

	/** Composite Service Factory */
	private CompositeServiceFactory compositeServiceFactory;
	
	/** Activiti Client */
	ActivitiClient activitiClient;
	
	/** Marketplace service */
	public IMarketplace marketplace;
    
    /** Notification service */
    private NotificationImpl notification;
	
    /** DataAdapter service */
    DataAdapter dataAdapter;
    
    /** ScpmClient service */
    private ICompositionPlanner scpmClient;
    
    private ScpmActions scpmActions;
    
    /**
     * Activate method called by Declarative Services when the RemoteImpl is initialized
     * @param context The context of the service
     */
    protected void activate(ComponentContext context) {
    	logger.debug("*** Activating RemoteImpl");
    	
        notification = new NotificationImpl();
        notification.activate(context);
        notification.setEventListener(this);
        
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/bingmap/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/googlemap/service?wsdl", null); 
        
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/hotelbooking/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/hotelinfo/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/poi/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/webpage/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/mail/service?wsdl", null);
        notification.subscribe("http://demo-aniketoswp6.rhcloud.com/smsService/service?wsdl", null);
        
        notification.subscribe("http://hestia.atc.gr/an_00253_bookingHotelCloser/service?wsdl", null);        
        
        notification.subscribe("http://83.235.133.36/AniketosAlternateWS/MapsServiceSoapHttpPort?wsdl", null);
        notification.subscribe("http://83.235.133.36/AniketosWS/MapsServiceSoapHttpPort?wsdl", null);        
        
        notification.subscribe("http://services-aniketoswp7.rhcloud.com/poiMap/service?wsdl", null);
        notification.subscribe("http://services-aniketoswp7.rhcloud.com/poiAltMap/service?wsdl", null);        
        
    	configure(context);
    }

	/**
	 * Configures the Config structure from contect properties
	 * @param context The context of the service
	 */
    private void configure(ComponentContext context) {
		@SuppressWarnings({ "rawtypes" })
    	Dictionary properties = context.getProperties();

    	config = new Config();
		config.compositionsDir = properties.get("compositions.dir").toString();
		config.activitiAddress = properties.get("activiti.address").toString();
		config.activitiUsername = properties.get("activiti.username").toString();
		config.activitiPassword = properties.get("activiti.password").toString();
		config.tomcatAddress = properties.get("tomcat.address").toString();
		config.tomcatPublicAddress = properties.get("tomcat.publicAddress").toString();
		config.tomcatUsername = properties.get("tomcat.username").toString();
		config.tomcatPassword = properties.get("tomcat.password").toString();
		
		if (config.activitiAddress != null && !config.activitiAddress.endsWith("/")) {
			config.activitiAddress += "/";
		}
		if (config.tomcatAddress != null && !config.tomcatAddress.endsWith("/")) {
			config.tomcatAddress += "/";
		}			
		if (config.tomcatPublicAddress != null && !config.tomcatPublicAddress.endsWith("/")) {
			config.tomcatPublicAddress += "/";
		}			
				
		
		String tomcatVersionStr = properties.get("tomcat.version").toString();
		int tomcatVersion = 6;
		try {
			tomcatVersion = Integer.parseInt(tomcatVersionStr);
		}
		catch (NumberFormatException ex) {
			
		}
		
		logger.debug("Configured Composite Service Factory and Activiti Client {} {} {} {} {} {} {} {}",
				config.compositionsDir, config.activitiAddress, config.activitiUsername,
				config.activitiPassword,  config.tomcatAddress,
				config.tomcatUsername, config.tomcatPassword, config.tomcatVersion);
		
		config.tomcatVersion = tomcatVersion;
		
		compositeServiceFactory = new CompositeServiceFactory(config);
		
		activitiClient = new ActivitiClient(config.activitiAddress,
				   config.activitiUsername,
				   config.activitiPassword);	
        
        try {
            Map<String, String> deploymentsMap = activitiClient.getDeployments();
            for(String id: deploymentsMap.keySet()) {
                String name = deploymentsMap.get(id);
                logger.debug("{} {}", name, id);
                /*if (name.contains("compositionPlan1")) {
                    boolean result = activitiClient.deleteDeployment(id);
                    logger.debug("Deleted deployment {} {}: {}",
                            name, id, result);
                }*/
            }
        } catch(Exception ex) {
            logger.error("Error getting deployments: {}", ex.getMessage());
        }
        
        try {
            activitiClient.getProcessDefinitions();
            ProcessDefinitionData definition =
                    activitiClient.getProcessDefinitionByName("an_00082_bookingMail");
            if (definition != null) {
                logger.debug("Found {}, {}, {}", definition.id, definition.key, definition.version);
            }                        
        } catch(Exception ex) {
            logger.error("Error getting definitions: {}", ex.getMessage());
        }       
	}
	
    /**
     * De-activate method called by Declarative Services when the service is de-activated
     * @param context The service context
     */
    protected void deactivate(ComponentContext context) {
    	logger.debug("*** Deactivating RemoteImpl");

    }

    /**
     * Modified method called by Declarative Services when the service is modified
     * @param context The context of the service
     */
    protected void modified(ComponentContext context) {
    	logger.debug("*** Modifying RemoteImpl");

    	configure(context); 
	}    
    
    /**
     * Generates an id according to the Aniketos Composition Id convention
     * @param deployDetails The deployment details
     * @return The generated id
     */
    private String getAniketosCompositionId(DeploymentDetails deployDetails) {
        String serviceName = "";
        
        if (deployDetails != null && deployDetails.getServiceName() != null) {
            serviceName = deployDetails.getServiceName();
        }
        return dataAdapter.addService(serviceName, "");
    }
    
	/**
	 * Deploys a web service in Tomcat
	 * @param compositionName The name of the composition
     * @param processId  The process id of the Activiti process
     * @param methodName The name of the method that invokes the composite service
	 * @return the endpoint of the deployed web service or null, if the deployment failed
	 */	
	private String deployWar(String compositionName, String processId, String methodName) {
		String result = null;
        logger.debug("Deploying war for {},{}", compositionName, processId);
		try {
			compositeServiceFactory.createServiceInstance(compositionName, 
                                                          processId, methodName);
			compositeServiceFactory.createWar(compositionName);
			result = compositeServiceFactory.deployWarTomcat(compositionName);
		}
		catch (Exception ex) {
            //ex.printStackTrace();
			logger.error("Exception while deploying WAR: {}", ex.getMessage());			
		}
		return result;
	}
	
	private Pattern pattern = Pattern.compile("<process id=\"(.+)\" name=\"(.+)\">");
		
	private String updateBpmn(String bpmn, String processId) {		
		Matcher matcher = pattern.matcher(bpmn);
	    if (matcher.find()) {
	    	String oldProcessId = matcher.group(1);
	    	String oldName = matcher.group(2);    	
	    	String updated = bpmn.replaceAll(oldProcessId, processId);
            updated = updated.replaceAll(oldName, processId);
	    	return updated;
	    }		
		return bpmn;
	}
    
	/**
	 * Deploys a composition plan
	 * @param compositionPlan The composition plan
	 * @param agreementTemplate The agreement template serialized
	 * @param consumerPolicy The consumer policy serialized 
	 * @return the id of the deployment, if the deployment succeeds, null otherwise
	 */
	String deployComposition(ICompositionPlan compositionPlan,
			String agreementTemplate, IConsumerPolicy consumerPolicy) {
		String bpmn = compositionPlan.getBPMNXML();
		String processName = compositionPlan.getCompositionPlanID();
		
        logger.debug("Deploying process: {}", processName); 
        bpmn = updateBpmn(bpmn, processName);
        
        compositionPlan.setBPMNXML(bpmn);        
		//logger.debug(bpmn);
        
		if (activitiClient == null) {
			logger.error("Activiti client is null!");
			return null;
		}
		return activitiClient.upload(processName, bpmn);
	}
    
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
    @Override
	public DeployResult deploy(ICompositionPlan[] compositionPlans, 
			String agreementTemplate, IConsumerPolicy consumerPolicy,
            String rules, DeploymentDetails deployDetails) {        
		DeployResult result = new DeployResult();
		result.setOk(false);
		
        if (rules != null) {
            logger.debug(rules);
        }

        if (dataAdapter == null) {
            logger.info("Data Adapter is null!");
            result.setErrorMessage("Data Adapter is null");
            return result;            
        }
        
        
        if (compositionPlans == null || compositionPlans.length == 0) {
            logger.info("No composition plans provided!");
            result.setErrorMessage("No composition plans provided!");
            return result;
        }
        ICompositionPlan compositionPlan = compositionPlans[0];                
        
        Map<String, String> serviceTaskIdsMap = null;
        try {
            serviceTaskIdsMap =        
                  BpmnUtils.getServiceTasks(compositionPlan.getBPMNXML());
        } catch (Exception ex) {
            logger.warn("Can't parse BPMN file: {}", ex.getMessage());
        }
        
        if (serviceTaskIdsMap == null || serviceTaskIdsMap.isEmpty()) {
            result.setErrorMessage("BPMN file doesn't contain service locations!");
            return result;
        }
        
        String compositionId = getAniketosCompositionId(deployDetails);
        
        if (compositionId == null) {
            result.setErrorMessage("Failed to persist new service in database");
            return result;
        }
        
        compositionPlan.setCompositionPlanID(compositionId);
        
        String deploymentId = deployComposition(compositionPlan, agreementTemplate, 
                                                consumerPolicy);
        
		if (deploymentId != null) {
            
            ProcessDefinitionData definition = 
                    activitiClient.getProcessDefinitionByName(compositionId);
            
            String processId = compositionId;
            if (definition != null) {
                processId = definition.id;
                dataAdapter.updateService(compositionId, processId, deploymentId);
            }
            String methodName = "start";
            if (deployDetails != null && deployDetails.getOperationName() != null) {
                String m = deployDetails.getOperationName();
                if (m.matches("^[a-zA-Z_]{1}[a-zA-Z0-9_]*$")) {
                    methodName = m;
                }
            }
            
			String endpoint = deployWar(compositionId, processId, methodName);
			if (endpoint != null) {
				result.setOk(true);
				result.setServiceAddress(endpoint);
                
                // Store the service tasks ids in the database
                storeServiceTasks(serviceTaskIdsMap, 
                                 compositionPlan.getBPMNXML(), 
                                 compositionId);
                
                // Subscribe to notifications
                if (notification != null) {
                    logger.debug("Start subscriptions...");
                    List<String> subscribedServices = new ArrayList<String>();
                    for(String serviceTaskId: serviceTaskIdsMap.keySet()) {
                        String atomicService = serviceTaskIdsMap.get(serviceTaskId);                    
                        if (subscribedServices.contains(atomicService)) {
                            continue;
                        }                        
                        notification.subscribe(atomicService, rules);
                        subscribedServices.add(atomicService);
                    }
                }                
                else {
                    logger.error("Notification component not found!");
                }                
                
                // Announce service to the Marketplace
				if (marketplace != null) {
					MarketplaceAnnouncement marketplaceAnnouncement = 
							new MarketplaceAnnouncement();
					marketplaceAnnouncement.setCompositionPlans(compositionPlans);
					marketplaceAnnouncement.setSender("SCF");
                    marketplaceAnnouncement.setRules(rules);
					
					ServiceDescriptor serviceDescriptor = 
							new ServiceDescriptor();
					serviceDescriptor.setName(compositionId);
					serviceDescriptor.setBinding(endpoint);
					serviceDescriptor.setId(endpoint);
					serviceDescriptor.setDescription("Composite service");
                    if (deployDetails != null && deployDetails.getTags() != null) {
                        List<ServiceOperation> serviceOperations = new ArrayList<ServiceOperation>();
                        for(String tag: deployDetails.getTags()) {
                            ServiceOperation so = new ServiceOperation();
                            so.setTag(tag);
                            serviceOperations.add(so);
                        }
                        serviceDescriptor.setOperations(
                                serviceOperations.toArray(new ServiceOperation [0]));
                    }                    
					marketplaceAnnouncement.setServiceDescriptor(serviceDescriptor);
					marketplace.announceService(null, marketplaceAnnouncement);
				}	
			}
			else {
                logger.error("Endpoint is null!");
				// TODO: Undeploy process here
				result.setErrorMessage("Failed to deploy war");
			}
		}
		else {
			result.setErrorMessage("Failed to install process");
		}
        
		return result;
    }   
    
    void storeServiceTasks(Map<String, String> serviceTaskIdsMap, 
                    String bpmn, String compositeServiceName) {        
        try {
            for(String serviceTaskId: serviceTaskIdsMap.keySet()) {
                String location = serviceTaskIdsMap.get(serviceTaskId);
                logger.debug(serviceTaskId + " -> " + location);
                dataAdapter.addServiceTask(location, serviceTaskId,
                        bpmn, compositeServiceName);
            }
        }
        catch (Exception ex) {
            logger.warn("Couldn't persist service tasks: {}", ex.getMessage());
        }
    }         
    
    /**
     * Sets the Marketplace service.
     * @param service The Marketplace service
     */
    public synchronized void setMarketplaceService(IMarketplace service) {
        logger.debug("Marketplace Service was set!");
        this.marketplace = service;
        
        //TODO: Remove this
        /*try {
            testAlertRulematching();
        }
        catch (Throwable t) {
            t.printStackTrace();
        }*/
    }

    /**
     * Unsets the Marketplace service.
     * @param service The Marketplace service
     */
    public synchronized void unsetMarketplaceService(IMarketplace service) {
        logger.debug("Marketplace Service was unset.");
        if (this.marketplace == service) {
            this.marketplace = null;
        }
    }	
    
    /**
     * Sets the DataAdapter service.
     * @param service The DataAdapter service
     */
    public synchronized void setDataAdapter(DataAdapter service) {
        logger.debug("DataAdapter Service was set!");
        this.dataAdapter = service;
    }

    /**
     * Unsets the DataManager service.
     * @param service The DataManager service
     */
    public synchronized void unsetDataAdapter(DataAdapter service) {
        logger.debug("DataAdapter Service was unset.");
       if (this.dataAdapter == service) {
            this.dataAdapter = null;
        }
    }	
    
    /**
     * Sets the ScpmClient service.
     * @param service The ScpmClient service
     */
    public synchronized void setScpmClient(ICompositionPlanner service) {
        System.out.println("ScpmClient Service was set!");
        logger.debug("ScpmClient Service was set!");
        this.scpmClient = service;
        scpmActions = new ScpmActions(scpmClient);
        
        /*String atomicService = "http://83.235.133.36/AniketosWS/MapsServiceSoapHttpPort?wsdl";
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setServiceId(atomicService);
        alertMessage.setAlertType("ContextChange");
        alertMessage.setValue("5");
        logger.debug("Dummy alert sent");
        onServiceEvent(atomicService, alertMessage);*/
    }

    /**
     * Unsets the DataManager service.
     * @param service The DataManager service
     */
    public synchronized void unsetScpmClient(ICompositionPlanner service) {
        logger.debug("ScpmClient Service was unset.");
       if (this.scpmClient == service) {
            this.scpmClient = null;
            scpmActions = null;
        }
    }	    

    private void testAlertRulematching() {
        String rulesXml = marketplace.getRules("http://hestia.atc.gr/an_00157_HBS/service?wsdl");
/*<?xml version="1.0" encoding="UTF-8" standalone="no"?><rules>
  <rule id="0">
    <service taskId="servicetask9" taskName="Map"/>
    <type>Trust level change</type>
    <value comparison="&lt;">7</value>
    <action>
      <changeRuntime>
        <recomposition allowStop="0"/>
      </changeRuntime>
    </action>
  </rule>
</rules>*/
        
        List<Rule> rules = null;
        try {
            RulesParser rulesParser = new RulesParser();
            rules = rulesParser.parse(rulesXml);
        } catch (Exception ex) {
            System.out.println("Failed to parse rules:  " + ex.getMessage());
        }
            
        System.out.println("Parsed rules...");
        
        AlertMessage alertMessage = new AlertMessage();
        alertMessage.setAlertType("Trust level change");
        alertMessage.setValue("5.3");
        
        System.out.println("Alert1 matches rule: " + doesAlertMatchesRule(alertMessage, rules.get(0)));
        
        alertMessage.setValue("8");
        
        System.out.println("Alert1 matches rule: " + doesAlertMatchesRule(alertMessage, rules.get(0)));
    }
    
    private boolean doesAlertMatchesRule(AlertMessage alertMessage, Rule rule) {
        String type = rule.getEvent().getType();
        type = type.replaceAll("\\s","");
        
        logger.debug("Rule type: {}, Alert type {}", type, alertMessage.getAlertType());
        
        if (type.compareToIgnoreCase(alertMessage.getAlertType())!=0) {
            return false;
        }
        String threatId = alertMessage.getThreatId();
        String ruleThreatId = rule.getEvent().getThreatId();
        
        if (threatId == null || threatId.trim().length() == 0) {
            threatId = null;
        }
        
        if (ruleThreatId == null || ruleThreatId.trim().length() == 0) {
            ruleThreatId = null;
        }        
        
        if ((threatId != null && !threatId.equals(ruleThreatId)) ||
             (threatId == null && ruleThreatId != null)){
            logger.debug("Alert doesn't match rule (different threat ids {}, {})",
                         threatId, ruleThreatId);
            return false;
        }
                
        String value = alertMessage.getValue();
        String ruleValue = rule.getEvent().getValue();
        String comparison = rule.getEvent().getComparison();
        
        if (value == null && ruleValue == null) {
            logger.debug("Alert matches rules (both values null)");
            return true;
        }
        
        if (value == null || ruleValue == null) {
            logger.debug("Alert doesn't match rule (one value null)");
            return false;
        }        
        
        float dvalue;
        float drvalue;
        
        try {
            dvalue = Float.valueOf(value);
            drvalue = Float.valueOf(ruleValue);
        } catch (Exception ex) {
            logger.warn("Can't parse values {}, {}: {}", value, ruleValue, ex.getMessage());
            return false;
        }
        
        if ("=".equals(comparison)) {
            return value.equals(ruleValue);
        }
        if (">=".equals(comparison)) {
            return dvalue >= drvalue;
        }
        if ("<=".equals(comparison)) {
            return dvalue <= drvalue;
        }
        if (">".equals(comparison)) {
            return dvalue > drvalue;
        }        
        if ("<".equals(comparison)) {
            return dvalue < drvalue;
        }
        
        return false;
    }
    
    private void findService(String service, String bpmn) {
        logger.debug("Testing service: {}", service);
        if (bpmn != null) {
            logger.debug("S1 {}", bpmn.contains(ScpmActions.caseStudyABmpn1Description));
            logger.debug("S2 {}", bpmn.contains(ScpmActions.caseStudyABmpn2Description));
        }
    }
    
    @Override
    public void onServiceEvent(String atomicService, AlertMessage alertMessage) {        
        System.out.println("Received alert for: " + atomicService);
        
        if (scpmActions == null) {
            logger.warn("Scpm is null!");
        }
        
        try {
            logger.debug("Event received for service: {}" , atomicService);
            
            List<ServiceTask> serviceTasks = 
                    dataAdapter.getServiceTasksByAtomicService(atomicService);

            if (serviceTasks != null && !serviceTasks.isEmpty()) {            
                List<String> recompositionedServices = new ArrayList<String>();

                for(ServiceTask serviceTask: serviceTasks) {
                    String compositeService = serviceTask.getCompositeServiceName();                    
                    if (recompositionedServices.contains(compositeService)) {
                        continue;
                    }
                    String rulesXml = marketplace.getRulesByServiceName(compositeService); 

                    if (rulesXml != null && rulesXml.length() > 0) {
                        logger.debug("Parsing rules of {}", compositeService);
                        List<Rule> rules = null;
                        try {
                            RulesParser rulesParser = new RulesParser();
                            rules = rulesParser.parse(rulesXml);
                        } catch (Exception ex) {
                            logger.info("Failed to parse rules of {}: {} ", compositeService, ex.getMessage());
                        }                            
                        if (rules != null) {
                            for(Rule rule: rules) {
                                if (doesAlertMatchesRule(alertMessage, rule)) {
                                    logger.debug("Alert matches rule!");
                                    if (rule.getAction().getActionType() == ActionType.Recomposition ||
                                            rule.getAction().getActionType() == ActionType.RecompositionAndReconfiguration) {
                                        logger.debug("Trying recomposition");
                                        if (scpmActions != null && 
                                                scpmActions.doRecompositionMock(this, serviceTask)) {
                                            recompositionedServices.add(compositeService);
                                            break;
                                        }
                                    }
                                    else if (rule.getAction().getActionType() == ActionType.Reconfiguration) {
                                        logger.debug("Trying reconfiguration");
                                        MarketplaceSearchParams params = new MarketplaceSearchParams();
                                        params.setName(compositeService);
                                        List<ServiceDescriptor> services = marketplace.discoverService(null, params);
                                        if (services != null && services.size() == 1) {
                                            String compositeServiceUrl = services.get(0).getId();
                                            String bpmn = marketplace.getBpmnDiagram(compositeServiceUrl);
                                            scpmActions.doReconfigurationMock(this, compositeServiceUrl, bpmn);   
                                        }
                                        else {
                                            logger.debug("Didn't find service {}", compositeService);
                                        }
                                        break;
                                    }                                                                        
                                }
                            }
                        }
                    }
                    else {
                        logger.debug("Rules for {} are empty!", compositeService);
                    }                    
                }
            }
            else {
                logger.debug("Found no service tasks for service: {}", atomicService);
                String bpmn = marketplace.getBpmnDiagram(atomicService);
                boolean isCompositeService = bpmn != null && bpmn.length() > 10;                
                if (isCompositeService) {
                    logger.debug("{} is a composite service. Checking for reconfiguration - recomposition",
                                 atomicService);
                    findService(atomicService, bpmn);
                    String rulesXml = marketplace.getRules(atomicService); 
                    if (rulesXml != null && rulesXml.length() > 0) {
                        logger.debug("Parsing rules of {}", atomicService);
                        List<Rule> rules = null;
                        try {
                            RulesParser rulesParser = new RulesParser();
                            rules = rulesParser.parse(rulesXml);
                        } catch (Exception ex) {
                            logger.info("Failed to parse rules of {}: {} ", atomicService, ex.getMessage());
                        }                            
                        if (rules != null) {
                            for(Rule rule: rules) {
                                if (doesAlertMatchesRule(alertMessage, rule)) {
                                    logger.debug("Alert matches rule!");
                                    if (rule.getAction().getActionType() == ActionType.Reconfiguration) {
                                        logger.debug("Trying reconfiguration");
                                        if (scpmActions != null && 
                                                scpmActions.doReconfigurationMock(this, atomicService, bpmn)) {
                                            
                                        }
                                        break;
                                    }                                    
                                }
                            }
                        }
                    }
                    else {
                        logger.debug("Rules for {} are empty!", atomicService);
                    }  
                }
                else {
                    logger.debug("{} is not composite {}", atomicService, bpmn);                    
                }
            }
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
