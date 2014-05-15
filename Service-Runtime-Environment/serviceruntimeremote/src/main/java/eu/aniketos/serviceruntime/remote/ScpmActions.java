package eu.aniketos.serviceruntime.remote;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.data.impl.AgreementTemplate;
import eu.aniketos.data.impl.ConsumerPolicy;
import eu.aniketos.scpm.ICompositionPlanner;
import eu.aniketos.serviceruntime.bpmn.BpmnUtils;
import eu.aniketos.serviceruntime.data.entities.Service;
import eu.aniketos.serviceruntime.data.entities.ServiceTask;
import eu.aniketos.serviceruntime.remote.activiti.models.ProcessDefinitionData;
import eu.aniketos.serviceruntime.scpm.ScpmClientCompositionPlan;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScpmActions {

	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(ScpmActions.class);    
    
    private ICompositionPlanner scpmClient;
    
    public ScpmActions(ICompositionPlanner scpmClient) {
        this.scpmClient = scpmClient;
    }
    
    private static Map<String, Long> recompositionTimesMap = new HashMap<String, Long>();
    
    public boolean doRecomposition(RuntimeRemoteImpl remote, ServiceTask serviceTask) {
        if (scpmClient == null) {
            logger.warn("SCPM is null!");
            return false;
        }
        
        String compositeService = serviceTask.getCompositeServiceName();
        String serviceTaskToReplace = serviceTask.getTaskId();
        
        if (recompositionTimesMap.containsKey(compositeService)) {
            long time = recompositionTimesMap.get(compositeService);
            long now = System.currentTimeMillis();
            
            if (now - time < 60*1000) {
                logger.debug("Already performed recomposition for {}", compositeService);
                return false;
            }
        }
        
        logger.debug("Doing recomposition for {} to replace {}", 
                     compositeService, serviceTaskToReplace);
        recompositionTimesMap.put(compositeService, System.currentTimeMillis());
        
        // Initialize composition plan
        ScpmClientCompositionPlan compositionPlan = new ScpmClientCompositionPlan();
        compositionPlan.setBPMNXML(serviceTask.getBpmn());
        compositionPlan.setCompositionPlanID(compositeService);
        compositionPlan.setActivitiFile("");
        // Initialize agreement template
        // TODO: using hard-coded valuse for now
        IAgreementTemplate agreementTemplate = new AgreementTemplate("testingID");
        //TODO: at the moment use both ways to initialise agreement template and consumer policy
        agreementTemplate.setXML(exampleAT);
        String[] xmlContents = new String[1];
        xmlContents[0] = exampleAT;
        agreementTemplate.setXmlContents(xmlContents);
        IConsumerPolicy consumerPolicy = getExampleConsumerPolicy();
        ICompositionPlan newCompositionPlan = 
                scpmClient.recomposition(compositionPlan, serviceTaskToReplace, 
                agreementTemplate, consumerPolicy);
        
        //scpmClient.orderSecureCompositions(null, null, null, null)
        //scpmClient.reconfiguration(compositionPlan, agreementTemplate, consumerPolicy);
        
        if (newCompositionPlan == null) {
            logger.error("Failed to perform recomposition!");
            return false;
        }
        newCompositionPlan.setCompositionPlanID(compositeService);
        
        logger.debug("Old BPMN:\r {}", serviceTask.getBpmn());
        
        String newBpmn = newCompositionPlan.getBPMNXML();
        
        logger.debug("New XML:");
        logger.debug(newBpmn);
        
        newBpmn = BpmnUtils.removeDuplicateProvider(newBpmn);

        //logger.debug("----------Corrected XML: -------------");
        //logger.debug(newBpmn);        
        
        newCompositionPlan.setBPMNXML(newBpmn);
        
        Map<String, String> serviceTaskIdsMap;
        try {
            serviceTaskIdsMap =        
                  BpmnUtils.getServiceTasks(newBpmn);
        } catch (Exception ex) {
            logger.warn("Can't parse BPMN file: {}", ex.getMessage());
            return false;
        }        
        
        Service service = remote.dataAdapter.getServiceByName(compositeService);
        
        String oldDeploymentId = null;
        
        if (service != null) {
            oldDeploymentId = service.getDeploymentId();
        }
        String newDeploymentId = remote.deployComposition(newCompositionPlan, exampleAT, 
                                                   getExampleConsumerPolicy());
               
        if (newDeploymentId != null) {
            
            if (oldDeploymentId != null) {
                boolean result = remote.activitiClient.deleteDeployment(oldDeploymentId);
                logger.debug("Deleted old deployment {}: {}", oldDeploymentId, result);
            }
            else {
                logger.warn("Couldn't locate the old deployment to delete it!");
            }
            
            int deletedServiceTasks = remote.dataAdapter.deleteServiceTasks(compositeService);
            logger.debug("Deleted {} old service tasks!", deletedServiceTasks);
            
            remote.storeServiceTasks(serviceTaskIdsMap, newBpmn, compositeService);
            
            // Subscribe to notifications
            /*if (notification != null) {
                logger.debug("Start new subscriptions...");
                List<String> subscribedServices = new ArrayList<String>();
                for(String serviceTaskId: serviceTaskIdsMap.keySet()) {
                    String atomicService = serviceTaskIdsMap.get(serviceTaskId);                    
                    if (subscribedServices.contains(atomicService)) {
                        continue;
                    }                        
                    // TODO: use correct rules here. Only subscribe to the replaced service task
                    notification.subscribe(atomicService, null);
                    subscribedServices.add(atomicService);
                }
            }                
            else {
                logger.error("Notification component not found!");
            }*/              
            
            ProcessDefinitionData definition = 
                    remote.activitiClient.getProcessDefinitionByName(compositeService);
            
            if (definition != null) {
                String processId = definition.id;
                remote.dataAdapter.updateService(compositeService, processId, newDeploymentId);
                logger.debug("New process definition: {}", processId);
                return true;
            }
            else {
                logger.error("No process definition found for {}", compositeService);
            }
        }
        else {
            logger.error("Failed to re-deploy composition {}" , compositeService);
        }
        return false;
    }         
    
    public boolean doRecompositionMock(RuntimeRemoteImpl remote, ServiceTask serviceTask) {
        String compositeService = serviceTask.getCompositeServiceName();
        String serviceTaskToReplace = serviceTask.getTaskId();
        String atomicServiceUrl = serviceTask.getAtomicServiceUrl();
        String newAtomicServiceUrl;
        
        if (atomicServiceUrl.equals("http://demo-aniketoswp6.rhcloud.com/bingmap/service?wsdl")) {
            newAtomicServiceUrl = "http://demo-aniketoswp6.rhcloud.com/googlemap/service?wsdl";
        }
        else if (atomicServiceUrl.equals("http://demo-aniketoswp6.rhcloud.com/googlemap/service?wsdl")) {
            newAtomicServiceUrl = "http://demo-aniketoswp6.rhcloud.com/bingmap/service?wsdl";
        }  
        else if (atomicServiceUrl.equals("http://services-aniketoswp7.rhcloud.com/poiMap/service?wsdl")) {
            newAtomicServiceUrl = "http://services-aniketoswp7.rhcloud.com/poiAltMap/service?wsdl";
        }
        else if (atomicServiceUrl.equals("http://services-aniketoswp7.rhcloud.com/poiAltMap/service?wsdl")) {
            newAtomicServiceUrl = "http://services-aniketoswp7.rhcloud.com/poiMap/service?wsdl";
        }          
        else {
            return false;
        }
        
        if (recompositionTimesMap.containsKey(compositeService)) {
            long time = recompositionTimesMap.get(compositeService);
            long now = System.currentTimeMillis();
            
            if (now - time < 60*1000) {
                logger.debug("Already performed recomposition for {}", compositeService);
                return false;
            }
        }
        
        logger.debug("Doing recomposition for {} to replace {}", 
                     compositeService, serviceTaskToReplace);
        recompositionTimesMap.put(compositeService, System.currentTimeMillis());
        
        System.out.println(Pattern.quote(atomicServiceUrl));
        System.out.println(newAtomicServiceUrl);
        String newBpmn = serviceTask.getBpmn()
                .replaceAll(Pattern.quote(atomicServiceUrl), newAtomicServiceUrl);
        
        // Initialize composition plan
        ICompositionPlan newCompositionPlan = new ScpmClientCompositionPlan();
        newCompositionPlan.setActivitiFile("");
        newCompositionPlan.setBPMNXML(newBpmn);
        newCompositionPlan.setCompositionPlanID(compositeService);
        
        logger.debug("Old BPMN:\r {}", serviceTask.getBpmn());                
        logger.debug("New BPMN:");
        logger.debug(newBpmn);

        Map<String, String> serviceTaskIdsMap;
        try {
            serviceTaskIdsMap =        
                  BpmnUtils.getServiceTasks(newBpmn);
        } catch (Exception ex) {
            logger.warn("Can't parse BPMN file: {}", ex.getMessage());
            return false;
        }        
        
        Service service = remote.dataAdapter.getServiceByName(compositeService);
        
        String oldDeploymentId = null;
        
        if (service != null) {
            oldDeploymentId = service.getDeploymentId();
        }
        String newDeploymentId = remote.deployComposition(newCompositionPlan, exampleAT, 
                                                   getExampleConsumerPolicy());
               
        if (newDeploymentId != null) {
            
            if (oldDeploymentId != null) {
                boolean result = remote.activitiClient.deleteDeployment(oldDeploymentId);
                logger.debug("Deleted old deployment {}: {}", oldDeploymentId, result);
            }
            else {
                logger.warn("Couldn't locate the old deployment to delete it!");
            }
            
            int deletedServiceTasks = remote.dataAdapter.deleteServiceTasks(compositeService);
            logger.debug("Deleted {} old service tasks!", deletedServiceTasks);
            
            remote.storeServiceTasks(serviceTaskIdsMap, newBpmn, compositeService);
            
            // Subscribe to notifications
            /*if (notification != null) {
                logger.debug("Start new subscriptions...");
                List<String> subscribedServices = new ArrayList<String>();
                for(String serviceTaskId: serviceTaskIdsMap.keySet()) {
                    String atomicService = serviceTaskIdsMap.get(serviceTaskId);                    
                    if (subscribedServices.contains(atomicService)) {
                        continue;
                    }                        
                    // TODO: use correct rules here. Only subscribe to the replaced service task
                    notification.subscribe(atomicService, null);
                    subscribedServices.add(atomicService);
                }
            }                
            else {
                logger.error("Notification component not found!");
            }*/              
            
            ProcessDefinitionData definition = 
                    remote.activitiClient.getProcessDefinitionByName(compositeService);
            
            if (definition != null) {
                String processId = definition.id;
                remote.dataAdapter.updateService(compositeService, processId, newDeploymentId);
                logger.debug("New process definition: {}", processId);
                return true;
            }
            else {
                logger.error("No process definition found for {}", compositeService);
            }
        }
        else {
            logger.error("Failed to re-deploy composition {}" , compositeService);
        }
        return false;
    }             
    
    public boolean doReconfigurationMock(RuntimeRemoteImpl remote, String compositeService, String bpmn) {        
        if (!compositeService.equals("http://hestia.atc.gr/an_00253_bookingHotelCloser/service?wsdl")) {
            return false;
        }
        
        logger.debug("Doing reconfiguration for {}", compositeService);

        String oldBpmn = bpmn;
        String newBpmn;
        String compositeServiceName = "an_00253_bookingHotelCloser";
        
        if (oldBpmn.contains(ScpmActions.caseStudyABmpn1Description)) {
            newBpmn = caseStudyABmpn2;
        }
        else if (oldBpmn.contains(ScpmActions.caseStudyABmpn2Description)) {
            newBpmn = caseStudyABmpn1;
        }    
        else {
            return false;
        }
        
        // Initialize composition plan
        ICompositionPlan newCompositionPlan = new ScpmClientCompositionPlan();
        newCompositionPlan.setActivitiFile("");
        newCompositionPlan.setBPMNXML(newBpmn);
        newCompositionPlan.setCompositionPlanID(compositeServiceName);
        
        logger.debug("Old BPMN:\r {}", oldBpmn);                
        logger.debug("New BPMN:");
        logger.debug(newBpmn);

        Map<String, String> serviceTaskIdsMap;
        try {
            serviceTaskIdsMap =        
                  BpmnUtils.getServiceTasks(newBpmn);
        } catch (Exception ex) {
            logger.warn("Can't parse BPMN file: {}", ex.getMessage());
            return false;
        }        
        
        Service service = remote.dataAdapter.getServiceByName(compositeServiceName);
        
        String oldDeploymentId = null;
        
        if (service != null) {
            oldDeploymentId = service.getDeploymentId();
        }
        String newDeploymentId = remote.deployComposition(newCompositionPlan, exampleAT, 
                                                   getExampleConsumerPolicy());
               
        if (newDeploymentId != null) {
            
            if (oldDeploymentId != null) {
                boolean result = remote.activitiClient.deleteDeployment(oldDeploymentId);
                logger.debug("Deleted old deployment {}: {}", oldDeploymentId, result);
            }
            else {
                logger.warn("Couldn't locate the old deployment to delete it!");
            }
            
            int deletedServiceTasks = remote.dataAdapter.deleteServiceTasks(compositeServiceName);
            logger.debug("Deleted {} old service tasks!", deletedServiceTasks);
            
            remote.storeServiceTasks(serviceTaskIdsMap, newBpmn, compositeServiceName);
            
            // Subscribe to notifications
            /*if (notification != null) {
                logger.debug("Start new subscriptions...");
                List<String> subscribedServices = new ArrayList<String>();
                for(String serviceTaskId: serviceTaskIdsMap.keySet()) {
                    String atomicService = serviceTaskIdsMap.get(serviceTaskId);                    
                    if (subscribedServices.contains(atomicService)) {
                        continue;
                    }                        
                    // TODO: use correct rules here. Only subscribe to the replaced service task
                    notification.subscribe(atomicService, null);
                    subscribedServices.add(atomicService);
                }
            }                
            else {
                logger.error("Notification component not found!");
            }*/              
            
            ProcessDefinitionData definition = 
                    remote.activitiClient.getProcessDefinitionByName(compositeServiceName);
            
            if (definition != null) {
                String processId = definition.id;
                remote.dataAdapter.updateService(compositeServiceName, processId, newDeploymentId);
                logger.debug("New process definition: {}", processId);
                
                remote.marketplace.updateBpmnDiagram(null, compositeService, newBpmn);
                return true;
            }
            else {
                logger.error("No process definition found for {}", compositeServiceName);
            }
        }
        else {
            logger.error("Failed to re-deploy composition {}" , compositeServiceName);
        }
        return false;
    }                 
    
    private String exampleAT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<specification id=\"eu.aniketos.conspec.policy.example\" \n" +
"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
"  xsi:noNamespaceSchemaLocation=\"xsd_aniketos.xsd\">\n" +
"  <maxint>50</maxint>\n" +
"  <maxlen>3</maxlen>\n" +
"  <scope>session</scope>\n" +
"  <securitystate>\n" +
"    <declaration>\n" +
"      <type>int</type>\n" +
"      <identifier>buffer_size</identifier>\n" +
"      <value>\n" +
"        <iconst>500</iconst>\n" +
"      </value>\n" +
"    </declaration>\n" +
"    <declaration>\n" +
"      <type>string</type>\n" +
"      <identifier>last</identifier>\n" +
"      <value>\n" +
"        <sconst>mystr</sconst>\n" +
"      </value>\n" +
"    </declaration>\n" +
"  </securitystate>\n" +
"  <rule>\n" +
"    <before>\n" +
"      <identifier>java.io.OutputStream.write</identifier>\n" +
"      <parameter>\n" +
"        <type>string</type>\n" +
"        <identifier>b</identifier>\n" +
"      </parameter>\n" +
"      <parameter>\n" +
"        <type>int</type>\n" +
"        <identifier>len</identifier>\n" +
"      </parameter>\n" +
" <parameter>\n" +
"        <type>int</type>\n" +
"        <identifier>off</identifier>\n" +
"      </parameter>\n" +
"    </before>\n" +
"    <perform>\n" +
"      <reaction>\n" +
"        <guard>\n" +
"          <morethan>\n" +
"            <iconst>20</iconst>\n" +
"            <i_identifier>buffer_size</i_identifier>\n" +
"          </morethan>\n" +
"        </guard>\n" +
"        <update>\n" +
"          <assign>\n" +
"            <identifier>buffer_size</identifier>\n" +
"            <value>\n" +
"                                             <sum>\n" +
"                <i_identifier>buffer_size</i_identifier>\n" +
"                <i_identifier>len</i_identifier>\n" +
"              </sum>\n" +
"                   </value>\n" +
"          </assign>\n" +
"        </update>\n" +
"      </reaction>\n" +
"    </perform>\n" +
"  </rule>\n" +
"</specification>";
    
    private String exampleCP = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<specification id=\"eu.aniketos.conspec.policy.example\" \n" +
"  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
"  xsi:noNamespaceSchemaLocation=\"xsd_aniketos.xsd\">\n" +
"  <maxint>50</maxint>\n" +
"  <maxlen>3</maxlen>\n" +
"  <scope>session</scope>\n" +
"  <securitystate>\n" +
"    <declaration>\n" +
"      <type>int</type>\n" +
"      <identifier>buffer_size</identifier>\n" +
"      <value>\n" +
"        <iconst>500</iconst>\n" +
"      </value>\n" +
"    </declaration>\n" +
"    <declaration>\n" +
"      <type>string</type>\n" +
"      <identifier>last</identifier>\n" +
"      <value>\n" +
"        <sconst>mystr</sconst>\n" +
"      </value>\n" +
"    </declaration>\n" +
"  </securitystate>\n" +
"  <rule>\n" +
"    <before>\n" +
"      <identifier>java.io.OutputStream.write</identifier>\n" +
"      <parameter>\n" +
"        <type>string</type>\n" +
"        <identifier>b</identifier>\n" +
"      </parameter>\n" +
"      <parameter>\n" +
"        <type>int</type>\n" +
"        <identifier>off</identifier>\n" +
"      </parameter>\n" +
"      <parameter>\n" +
"        <type>int</type>\n" +
"        <identifier>len</identifier>\n" +
"      </parameter>\n" +
"    </before>\n" +
"    <perform>\n" +
"      <reaction>\n" +
"        <guard>\n" +
"          <morethan>\n" +
"            <iconst>20</iconst>\n" +
"            <i_identifier>buffer_size</i_identifier>\n" +
"          </morethan>\n" +
"        </guard>\n" +
"        <update>\n" +
"          <assign>\n" +
"            <identifier>buffer_size</identifier>\n" +
"            <value>\n" +
"              <sum>\n" +
"                <i_identifier>buffer_size</i_identifier>\n" +
"                <i_identifier>len</i_identifier>\n" +
"              </sum>\n" +
"            </value>\n" +
"          </assign>\n" +
"        </update>\n" +
"      </reaction>\n" +
"    </perform>\n" +
"  </rule>\n" +
"</specification>";

    private IConsumerPolicy getExampleConsumerPolicy() {
        IConsumerPolicy cp1 = new ConsumerPolicy();
        cp1.setXML(exampleCP);
        String[] xmlContents = new String[1];
        xmlContents[0] = exampleCP;
        cp1.setXmlContents(xmlContents);
        return cp1;
    }   
    
    public static String caseStudyABmpn1Description = "Place documentation for the 'BookingDemo' process here.";
    
    public static String caseStudyABmpn1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\">\n" +
"  <process id=\"an_00253_bookingHotelCloser\" name=\"an_00253_bookingHotelCloser\">\n" +
"    <documentation>Place documentation for the 'BookingDemo' process here.</documentation>\n" +
"    <startEvent id=\"startevent1\" name=\"Start\">\n" +
"      <extensionElements>\n" +
"        <activiti:formProperty id=\"HotelId\" name=\"HotelId\"/>\n" +
"        <activiti:formProperty id=\"dateCheckIn\" name=\"dateCheckIn\"/>\n" +
"        <activiti:formProperty id=\"dateCheckOut\" name=\"dateCheckOut\"/>\n" +
"        <activiti:formProperty id=\"Name\" name=\"Name\"/>\n" +
"        <activiti:formProperty id=\"LastName\" name=\"LastName\"/>\n" +
"        <activiti:formProperty id=\"Email\" name=\"Email\"/>\n" +
"        <activiti:formProperty id=\"roomPreferences\" name=\"roomPreferences\"/>\n" +
"        <activiti:formProperty id=\"NumberOfAdults\" name=\"NumberOfAdults\"/>\n" +
"        <activiti:formProperty id=\"NumberOfChildren\" name=\"NumberOfChildren\"/>\n" +
"        <activiti:formProperty id=\"CreditCard\" name=\"CreditCard\"/>\n" +
"        <activiti:formProperty id=\"ExpiryMonth\" name=\"ExpiryMonth\"/>\n" +
"        <activiti:formProperty id=\"ExpiryYear\" name=\"ExpiryYear\"/>\n" +
"        <activiti:formProperty id=\"phoneNumber\" name=\"phoneNumber\"/>\n" +
"      </extensionElements>\n" +
"    </startEvent>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask1\" name=\"Book the hotel\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>BookHotel</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>hotelId (type: string), dateCheckIn (type: string), dateCheckOut (type: string), name (type: string), lastName (type: string), creditCardData (type: string), creditCardExpireMonth (type: string), creditCardExpireYear (type: string), roomType (type: string), adults (type: string), children (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>bookHotel</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${HotelId}~${dateCheckIn}~${dateCheckOut}~${Name}~${LastName}~${CreditCard}~${ExpiryMonth}~${ExpiryYear}~${roomPreferences}~${NumberOfAdults}~${NumberOfChildren}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>bookId</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelbooking/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelbooking/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <exclusiveGateway id=\"exclusivegateway1\" name=\"Exclusive Gateway\"/>\n" +
"    <parallelGateway id=\"parallelgateway1\" name=\"Parallel Gateway\"/>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask2\" name=\"Get Hotel Coordinates\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>GetHotelCoordinates</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>hotelId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>return (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>getHotelCoordinates</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${HotelId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>hotelCoordinates</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelinfo/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelinfo/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask3\" name=\"PointOfInterest\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>getPOIs</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>arg0 (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>return (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>getPOIsJSON</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${hotelCoordinates}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>pois</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/poi/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/poi/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask4\" name=\"Map\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>getMap</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>POIs (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>return (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>getMap</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${pois}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>map</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/bingmap/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/bingmap/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask5\" name=\"CreatePageInfo\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>createBookingWebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>hotelId (type: string), bookId (type: string), POI (type: string), map (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>return (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>createWebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${HotelId}~${bookId}~${pois}~${map}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/webpage/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/webpage/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>WebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask6\" name=\"Send booking info via email\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>sendMail</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>email (type: string), hotelId (type: string), dateCheckIn (type: string), dateCheckOut (type: string), name (type: string), lastName (type: string), roomType (type: string), adults (type: string), children (type: string), bookingId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>sendMail</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${Email}~${HotelId}~${dateCheckIn}~${dateCheckOut}~${Name}~${LastName}~${roomPreferences}~${NumberOfAdults}~${NumberOfChildren}~${bookId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/mail/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/mail/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask7\" name=\"Send booking info via SMS\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>sendSMS</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>number (type: string), hotelId (type: string), bookingId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>sendSMS</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${phoneNumber}~${HotelId}~${bookId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/smsService/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/smsService/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <parallelGateway id=\"parallelgateway2\" name=\"Parallel Gateway\"/>\n" +
"    <endEvent id=\"endevent1\" name=\"End\"/>\n" +
"    <endEvent id=\"endevent2\" name=\"End\"/>\n" +
"    <sequenceFlow id=\"flow1\" name=\"\" sourceRef=\"startevent1\" targetRef=\"servicetask1\"/>\n" +
"    <sequenceFlow id=\"flow2\" name=\"\" sourceRef=\"servicetask1\" targetRef=\"exclusivegateway1\"/>\n" +
"    <sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"exclusivegateway1\" targetRef=\"parallelgateway1\">\n" +
"      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${bookId != null}]]></conditionExpression>\n" +
"    </sequenceFlow>\n" +
"    <sequenceFlow id=\"flow4\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask2\"/>\n" +
"    <sequenceFlow id=\"flow5\" name=\"\" sourceRef=\"servicetask2\" targetRef=\"servicetask3\"/>\n" +
"    <sequenceFlow id=\"flow6\" name=\"\" sourceRef=\"servicetask3\" targetRef=\"servicetask4\"/>\n" +
"    <sequenceFlow id=\"flow7\" name=\"\" sourceRef=\"servicetask4\" targetRef=\"servicetask5\"/>\n" +
"    <sequenceFlow id=\"flow8\" name=\"\" sourceRef=\"servicetask5\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow9\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask6\"/>\n" +
"    <sequenceFlow id=\"flow10\" name=\"\" sourceRef=\"servicetask6\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow11\" name=\"\" sourceRef=\"parallelgateway2\" targetRef=\"endevent1\"/>\n" +
"    <sequenceFlow id=\"flow12\" name=\"\" sourceRef=\"exclusivegateway1\" targetRef=\"endevent2\">\n" +
"      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${bookId == null}]]></conditionExpression>\n" +
"    </sequenceFlow>\n" +
"    <sequenceFlow id=\"flow13\" name=\"\" sourceRef=\"servicetask7\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow14\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask7\"/>\n" +
"  </process>\n" +
"  <bpmndi:BPMNDiagram id=\"BPMNDiagram_an_00253_bookingHotelCloser\">\n" +
"    <bpmndi:BPMNPlane bpmnElement=\"an_00253_bookingHotelCloser\" id=\"BPMNPlane_an_00253_bookingHotelCloser\">\n" +
"      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"30\" y=\"200\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask1\" id=\"BPMNShape_servicetask1\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"105\" y=\"190\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"exclusivegateway1\" id=\"BPMNShape_exclusivegateway1\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"250\" y=\"197\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"parallelgateway1\" id=\"BPMNShape_parallelgateway1\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"330\" y=\"137\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask2\" id=\"BPMNShape_servicetask2\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"77\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask3\" id=\"BPMNShape_servicetask3\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"555\" y=\"77\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask4\" id=\"BPMNShape_servicetask4\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"700\" y=\"77\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask5\" id=\"BPMNShape_servicetask5\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"845\" y=\"77\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask6\" id=\"BPMNShape_servicetask6\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"137\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask7\" id=\"BPMNShape_servicetask7\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"197\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"parallelgateway2\" id=\"BPMNShape_parallelgateway2\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"990\" y=\"137\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"1070\" y=\"140\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"endevent2\" id=\"BPMNShape_endevent2\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"330\" y=\"257\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">\n" +
"        <omgdi:waypoint x=\"65\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"105\" y=\"217\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow2\" id=\"BPMNEdge_flow2\">\n" +
"        <omgdi:waypoint x=\"210\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"250\" y=\"217\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n" +
"        <omgdi:waypoint x=\"290\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"177\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n" +
"        <omgdi:waypoint x=\"350\" y=\"137\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"104\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"555\" y=\"104\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n" +
"        <omgdi:waypoint x=\"660\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"700\" y=\"104\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow7\" id=\"BPMNEdge_flow7\">\n" +
"        <omgdi:waypoint x=\"805\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"845\" y=\"104\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow8\" id=\"BPMNEdge_flow8\">\n" +
"        <omgdi:waypoint x=\"950\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"1010\" y=\"104\"/>\n" +
"        <omgdi:waypoint x=\"1010\" y=\"137\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow9\" id=\"BPMNEdge_flow9\">\n" +
"        <omgdi:waypoint x=\"370\" y=\"157\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"164\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow10\" id=\"BPMNEdge_flow10\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"164\"/>\n" +
"        <omgdi:waypoint x=\"990\" y=\"157\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow11\" id=\"BPMNEdge_flow11\">\n" +
"        <omgdi:waypoint x=\"1030\" y=\"157\"/>\n" +
"        <omgdi:waypoint x=\"1070\" y=\"157\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow12\" id=\"BPMNEdge_flow12\">\n" +
"        <omgdi:waypoint x=\"270\" y=\"237\"/>\n" +
"        <omgdi:waypoint x=\"270\" y=\"274\"/>\n" +
"        <omgdi:waypoint x=\"330\" y=\"274\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow13\" id=\"BPMNEdge_flow13\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"1010\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"1010\" y=\"177\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow14\" id=\"BPMNEdge_flow14\">\n" +
"        <omgdi:waypoint x=\"350\" y=\"177\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"224\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"    </bpmndi:BPMNPlane>\n" +
"  </bpmndi:BPMNDiagram>\n" +
"</definitions>";
    
    public static String caseStudyABmpn2Description = "Place documentation for the 'BookingDemoAlternative' process here.";
    
    public static String caseStudyABmpn2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\">\n" +
"  <process id=\"an_00253_bookingHotelCloser\" name=\"an_00253_bookingHotelCloser\">\n" +
"    <documentation>Place documentation for the 'BookingDemoAlternative' process here.</documentation>\n" +
"    <startEvent id=\"startevent1\" name=\"Start\">\n" +
"      <extensionElements>\n" +
"        <activiti:formProperty id=\"HotelId\" name=\"HotelId\"/>\n" +
"        <activiti:formProperty id=\"dateCheckIn\" name=\"dateCheckIn\"/>\n" +
"        <activiti:formProperty id=\"dateCheckOut\" name=\"dateCheckOut\"/>\n" +
"        <activiti:formProperty id=\"Name\" name=\"Name\"/>\n" +
"        <activiti:formProperty id=\"LastName\" name=\"LastName\"/>\n" +
"        <activiti:formProperty id=\"Email\" name=\"Email\"/>\n" +
"        <activiti:formProperty id=\"roomPreferences\" name=\"roomPreferences\"/>\n" +
"        <activiti:formProperty id=\"NumberOfAdults\" name=\"NumberOfAdults\"/>\n" +
"        <activiti:formProperty id=\"NumberOfChildren\" name=\"NumberOfChildren\"/>\n" +
"        <activiti:formProperty id=\"CreditCard\" name=\"CreditCard\"/>\n" +
"        <activiti:formProperty id=\"ExpiryMonth\" name=\"ExpiryMonth\"/>\n" +
"        <activiti:formProperty id=\"ExpiryYear\" name=\"ExpiryYear\"/>\n" +
"        <activiti:formProperty id=\"phoneNumber\" name=\"phoneNumber\"/>\n" +
"      </extensionElements>\n" +
"    </startEvent>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask1\" name=\"Book the hotel\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>BookHotel</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>hotelId (type: string), dateCheckIn (type: string), dateCheckOut (type: string), name (type: string), lastName (type: string), creditCardData (type: string), creditCardExpireMonth (type: string), creditCardExpireYear (type: string), roomType (type: string), adults (type: string), children (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>bookHotel</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${HotelId}~${dateCheckIn}~${dateCheckOut}~${Name}~${LastName}~${CreditCard}~${ExpiryMonth}~${ExpiryYear}~${roomPreferences}~${NumberOfAdults}~${NumberOfChildren}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>bookingId</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelbooking/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/hotelbooking/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <exclusiveGateway id=\"exclusivegateway1\" name=\"Exclusive Gateway\"/>\n" +
"    <endEvent id=\"endevent1\" name=\"End\"/>\n" +
"    <parallelGateway id=\"parallelgateway1\" name=\"Parallel Gateway\"/>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask3\" name=\"Send booking info via email\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>sendMail</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>email (type: string), hotelId (type: string), dateCheckIn (type: string), dateCheckOut (type: string), name (type: string), lastName (type: string), roomType (type: string), adults (type: string), children (type: string), bookingId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>sendMail</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${Email}~${HotelId}~${dateCheckIn}~${dateCheckOut}~${Name}~${LastName}~${roomPreferences}~${NumberOfAdults}~${NumberOfChildren}~${bookingId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/mail/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/mail/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask4\" name=\"CreatePageInfo\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>createSimpleBookingWebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>return (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>hotelId (type: string), bookId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>createSimpleWebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${HotelId}~${bookingId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"resultVariable\">\n" +
"          <activiti:string>WebPage</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/webpage/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/webpage/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask2\" name=\"Send booking info via SMS\">\n" +
"      <extensionElements>\n" +
"        <activiti:field name=\"type\">\n" +
"          <activiti:string>sendSMS</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"inputType\">\n" +
"          <activiti:string>number (type: string), hotelId (type: string), bookingId (type: string)</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"outputType\">\n" +
"          <activiti:string>void</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"operation\">\n" +
"          <activiti:string>sendSMS</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"input\">\n" +
"          <activiti:expression>${phoneNumber}~${HotelId}~${bookingId}</activiti:expression>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"id\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/smsService/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"location\">\n" +
"          <activiti:string>http://demo-aniketoswp6.rhcloud.com/smsService/service?wsdl</activiti:string>\n" +
"        </activiti:field>\n" +
"        <activiti:field name=\"serviceProvider\">\n" +
"          <activiti:string>selex</activiti:string>\n" +
"        </activiti:field>\n" +
"      </extensionElements>\n" +
"    </serviceTask>\n" +
"    <parallelGateway id=\"parallelgateway2\" name=\"Parallel Gateway\"/>\n" +
"    <endEvent id=\"endevent2\" name=\"End\"/>\n" +
"    <sequenceFlow id=\"flow1\" name=\"\" sourceRef=\"startevent1\" targetRef=\"servicetask1\"/>\n" +
"    <sequenceFlow id=\"flow2\" name=\"\" sourceRef=\"servicetask1\" targetRef=\"exclusivegateway1\"/>\n" +
"    <sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"exclusivegateway1\" targetRef=\"endevent1\">\n" +
"      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${bookingId == null}]]></conditionExpression>\n" +
"    </sequenceFlow>\n" +
"    <sequenceFlow id=\"flow4\" name=\"\" sourceRef=\"exclusivegateway1\" targetRef=\"parallelgateway1\">\n" +
"      <conditionExpression xsi:type=\"tFormalExpression\"><![CDATA[${bookingId != null}]]></conditionExpression>\n" +
"    </sequenceFlow>\n" +
"    <sequenceFlow id=\"flow5\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask3\"/>\n" +
"    <sequenceFlow id=\"flow6\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask4\"/>\n" +
"    <sequenceFlow id=\"flow7\" name=\"\" sourceRef=\"parallelgateway1\" targetRef=\"servicetask2\"/>\n" +
"    <sequenceFlow id=\"flow8\" name=\"\" sourceRef=\"servicetask2\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow9\" name=\"\" sourceRef=\"servicetask3\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow10\" name=\"\" sourceRef=\"servicetask4\" targetRef=\"parallelgateway2\"/>\n" +
"    <sequenceFlow id=\"flow11\" name=\"\" sourceRef=\"parallelgateway2\" targetRef=\"endevent2\"/>\n" +
"  </process>\n" +
"  <bpmndi:BPMNDiagram id=\"BPMNDiagram_an_00253_bookingHotelCloser\">\n" +
"    <bpmndi:BPMNPlane bpmnElement=\"an_00253_bookingHotelCloser\" id=\"BPMNPlane_an_00253_bookingHotelCloser\">\n" +
"      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"30\" y=\"200\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask1\" id=\"BPMNShape_servicetask1\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"105\" y=\"190\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"exclusivegateway1\" id=\"BPMNShape_exclusivegateway1\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"250\" y=\"197\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"330\" y=\"137\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"parallelgateway1\" id=\"BPMNShape_parallelgateway1\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"330\" y=\"257\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask3\" id=\"BPMNShape_servicetask3\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"197\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask4\" id=\"BPMNShape_servicetask4\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"257\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"servicetask2\" id=\"BPMNShape_servicetask2\">\n" +
"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"410\" y=\"317\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"parallelgateway2\" id=\"BPMNShape_parallelgateway2\">\n" +
"        <omgdc:Bounds height=\"40\" width=\"40\" x=\"555\" y=\"257\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNShape bpmnElement=\"endevent2\" id=\"BPMNShape_endevent2\">\n" +
"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"635\" y=\"260\"/>\n" +
"      </bpmndi:BPMNShape>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">\n" +
"        <omgdi:waypoint x=\"65\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"105\" y=\"217\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow2\" id=\"BPMNEdge_flow2\">\n" +
"        <omgdi:waypoint x=\"210\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"250\" y=\"217\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">\n" +
"        <omgdi:waypoint x=\"270\" y=\"197\"/>\n" +
"        <omgdi:waypoint x=\"270\" y=\"154\"/>\n" +
"        <omgdi:waypoint x=\"330\" y=\"154\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow4\" id=\"BPMNEdge_flow4\">\n" +
"        <omgdi:waypoint x=\"290\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"217\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"257\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow5\" id=\"BPMNEdge_flow5\">\n" +
"        <omgdi:waypoint x=\"350\" y=\"257\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"224\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow6\" id=\"BPMNEdge_flow6\">\n" +
"        <omgdi:waypoint x=\"370\" y=\"277\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"284\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow7\" id=\"BPMNEdge_flow7\">\n" +
"        <omgdi:waypoint x=\"350\" y=\"297\"/>\n" +
"        <omgdi:waypoint x=\"350\" y=\"344\"/>\n" +
"        <omgdi:waypoint x=\"410\" y=\"344\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow8\" id=\"BPMNEdge_flow8\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"344\"/>\n" +
"        <omgdi:waypoint x=\"575\" y=\"344\"/>\n" +
"        <omgdi:waypoint x=\"575\" y=\"297\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow9\" id=\"BPMNEdge_flow9\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"575\" y=\"224\"/>\n" +
"        <omgdi:waypoint x=\"575\" y=\"257\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow10\" id=\"BPMNEdge_flow10\">\n" +
"        <omgdi:waypoint x=\"515\" y=\"284\"/>\n" +
"        <omgdi:waypoint x=\"555\" y=\"277\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"      <bpmndi:BPMNEdge bpmnElement=\"flow11\" id=\"BPMNEdge_flow11\">\n" +
"        <omgdi:waypoint x=\"595\" y=\"277\"/>\n" +
"        <omgdi:waypoint x=\"635\" y=\"277\"/>\n" +
"      </bpmndi:BPMNEdge>\n" +
"    </bpmndi:BPMNPlane>\n" +
"  </bpmndi:BPMNDiagram>\n" +
"</definitions>";
    
    
    
    
}
