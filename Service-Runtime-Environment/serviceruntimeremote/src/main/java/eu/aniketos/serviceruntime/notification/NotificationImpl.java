package eu.aniketos.serviceruntime.notification;

import eu.aniketos.notification.client.EnvironmentClient;
import eu.aniketos.serviceruntime.eventlistener.IEventListener;
import eu.aniketos.serviceruntime.rules.Event;
import eu.aniketos.serviceruntime.rules.Rule;
import eu.aniketos.serviceruntime.rules.RulesParser;
import java.util.Dictionary;
import java.util.List;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the Notification interface
 * @author Kostas Giannakakis
 */
public class NotificationImpl implements INotification {
    
	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(NotificationImpl.class);
    
    /** The ActiveMQ broker url */
    private static String brokerUrl = "ssl://notification.aniketos.eu:61617";
    
    /** A reference to the client that is activated by this class **/
    private EnvironmentClient client;    

    
    /**
     * Activate method called by Declarative Services when the RemoteImpl is initialized
     * @param context The context of the service
     */
    public void activate(ComponentContext context) {
    	logger.debug("*** Activating NotificationImpl");
        
        //configure(context);
        
        System.out.println("Connection notification to " + brokerUrl);
        client = new EnvironmentClient(brokerUrl, null);
		
        // Dispatch separate thread to avoid blocking while connecting
        new Thread(client).start();        
    }
    
    /**
     * De-activate method called by Declarative Services when the service is de-activated
     * @param context The service context
     */
    protected void deactivate(ComponentContext context) {
    	logger.debug("*** Deactivating NotificationImpl");

    	if (client != null) {
            client.close();  
        }
    }    
    
    /**
     * Modified method called by Declarative Services when the service is modified
     * @param context The context of the service
     */
    protected void modified(ComponentContext context) {
    	logger.debug("*** Modifying NotificationImpl");

    	//configure(context); 
	}       
    
    /**
     * Configures the service
     * @param context The context provided by the container
     */
    private void configure(ComponentContext context) {
        @SuppressWarnings({ "rawtypes" })
    	Dictionary properties = context.getProperties();

		brokerUrl = properties.get("broker.url").toString();
    }
    
    /**
     * Sets the event listener
     * @param eventListener The listener to be informed on received messages
     */
    @Override
    public void setEventListener(IEventListener eventListener) {
        client.setEventListener(eventListener);
    }   
    
    /**
     * Subcribes to all service notifications
     * @param serviceId The serviceId to register
     */    
    @Override
    public void subscribe(String serviceId) {
        if (client != null) {
            logger.debug("Subscribing for service: {}", serviceId);
            client.registerForAlerts(serviceId);
        }
        else {
            logger.warn("Client is null, can't subsribe service");
        }
    }
    
    /**
     * Subcribes to service notifications based on the provided rules
     * @param serviceId The serviceId to register
     * @param rules The rules in XML format
     */
    @Override
    public void subscribe(String serviceId, String rulesXml) {
        if (client != null) {            
            if (rulesXml != null) {
                List<Rule> rules = null;
                try {
                    RulesParser parser = new RulesParser();
                    rules = parser.parse(rulesXml);
                    logger.debug("Parsed {} rules", rules.size());
                }
                catch (Exception ex) {
                    logger.error("Can't parse rules: " + ex.getMessage());
                }
                if (rules != null) {
                    for(Rule rule: rules) {
                        Event event = rule.getEvent();
                        String threatId = event.getThreatId();
                        String description = event.getDescription();
                        if (threatId != null && description != null) {
                            logger.debug("{} registering for {}, {}", serviceId, threatId, description);
                            client.registerForAlert(serviceId, threatId, description);
                        }
                        else if (threatId != null) {
                            logger.debug("{} registering for {}", serviceId, threatId);
                            client.registerForAlert(serviceId, threatId);
                        }
                        else {
                            logger.warn("Rule thread id is null");
                        }
                    }
                }
                else {
                    logger.debug("{} registering for all events", serviceId);
                    client.registerForAlerts(serviceId);
                }                 
            }
            else {
                logger.debug("{} registering for all events", serviceId);
                client.registerForAlerts(serviceId);
            }        
        }
        else {
            logger.error("Client is null, can't subsribe service");
        }        
    }
    
}
