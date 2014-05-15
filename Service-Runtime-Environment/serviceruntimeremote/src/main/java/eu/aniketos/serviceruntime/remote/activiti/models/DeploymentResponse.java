package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeploymentResponse {
    public String id;
    public String name;
    public String deploymentTime;
    public String category;
}
