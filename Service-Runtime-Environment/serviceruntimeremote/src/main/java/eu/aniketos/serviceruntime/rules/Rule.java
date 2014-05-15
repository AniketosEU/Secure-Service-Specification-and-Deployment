package eu.aniketos.serviceruntime.rules;

/**
 *
 * @author Kostas Giannakakis
 */
public class Rule {

	private String id;
	
	private Service service;	
	
    private Event event;
    
    private Scope scope;
    
    private Action action;

    public Rule() {
    	event = new Event();
    }
    
    
    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the scope
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return the rule service
     */
	public Service getService() {
		return service;
	}

	/**
	 * Sets the rule service
	 * @param service The rule service
	 */
	public void setService(Service service) {
		this.service = service;
	}      
 
	@Override
	public String toString() {
		return String.format(
				"id:%s\nservice:\n%s\nevent:\n%s\nscope:\n%s\naction:\n%s",
				id, service, event, scope, action);
	}	
    
}
