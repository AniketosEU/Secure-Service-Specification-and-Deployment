package eu.aniketos.serviceruntime.notification;

import eu.aniketos.serviceruntime.eventlistener.IEventListener;

/**
 * Interface for subscribing to notification services
 * @author Kostas Giannakakis
 */
public interface INotification {
    
    /**
     * Subcribes to all service notifications
     * @param serviceId The serviceId to register
     */
    void subscribe(String serviceId);
    
    /**
     * Subcribes to service notifications based on the provided rules
     * @param serviceId The serviceId to register
     * @param rules The rules in XML format
     */
    void subscribe( String serviceId, String rules);    
    
    /**
     * Sets the event listener
     * @param eventListener The listener to be informed on received messages
     */
    void setEventListener(IEventListener eventListener);
    
}
