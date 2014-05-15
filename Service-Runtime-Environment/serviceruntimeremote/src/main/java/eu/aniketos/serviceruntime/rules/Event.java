package eu.aniketos.serviceruntime.rules;

/**
 * Encapsulates an Event that triggers an action defined by a rule
 * @author Kostas Giannakakis
 */
public class Event {
 
    private String type;

    private String threatId;
    
    private String value;

    private String description;
    
    private String comparison;
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the threatId
     */
    public String getThreatId() {
        return threatId;
    }

    /**
     * @param threatId the threatId to set
     */
    public void setThreatId(String threatId) {
        this.threatId = threatId;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

	/**
	 * 
	 * @return the description of the event
	 */
    public String getDescription() {
		return description;
	}

    /**
     * Sets the description of the event
     * @param description The description of the event
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return the comparison operator
	 */
	public String getComparison() {
		return comparison;
	}

	/**
	 * Sets the comparison operator (", <, >, <=, >=)
	 * @param comparison the comparison operator
	 */
	public void setComparison(String comparison) {
		this.comparison = comparison;
	}
    
	@Override
	public String toString() {
		return String.format(
		"\ttype:%s\n\tthreatId:%s\n\tdescription:%s\n\tvalue:%s%s",
		type, threatId, description, comparison, value);
	}
	
}
