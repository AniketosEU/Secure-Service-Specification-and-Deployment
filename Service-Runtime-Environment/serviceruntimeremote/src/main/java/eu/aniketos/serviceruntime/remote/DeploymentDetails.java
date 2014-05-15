package eu.aniketos.serviceruntime.remote;

/**
 * Wraps the details of a deployment.
 * @author Kostas Giannakakis
 */
public class DeploymentDetails {
    private String operationName;
    
    private String [] tags;
    
    private String serviceName;

    /**
     * Gets the composite service operation name
     * @return the composite service operation name
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Sets the composite service operation name
     * @param operationName the composite service operation name
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * Gets the tags associated with the service
     * @return the tags associated with the service
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * Sets the tags associated with the service
     * @param tags the tags associated with the service
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Gets the service name assigned by the user
     * @return the service name assigned by the user
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the service name assigned by the user
     * @param serviceName the service name assigned by the user
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
