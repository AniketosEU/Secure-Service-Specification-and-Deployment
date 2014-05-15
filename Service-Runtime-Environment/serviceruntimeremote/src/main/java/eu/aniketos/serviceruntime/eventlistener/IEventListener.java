package eu.aniketos.serviceruntime.eventlistener;

/**
 * Service Runtime Event Listener Interface. Provides methods to be executed, 
 * when an event occurs.
 * @author Kostas Giannakakis
 */
public interface IEventListener {
    
    void onServiceEvent(String atomicService, AlertMessage alertMessage);
    
}
