package eu.aniketos.serviceruntime.eventlistener;

/**
 * Class that encapsulates a method sent from the Notification Module
 * @author Kostas Giannakakis
 */
public class AlertMessage {
    private String serviceId;
    
    private String alertType;
    
    private String value;
    
    private String description;
    
    private String threatId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThreatId() {
        return threatId;
    }

    public void setThreatId(String threatId) {
        this.threatId = threatId;
    }
    
    
}
