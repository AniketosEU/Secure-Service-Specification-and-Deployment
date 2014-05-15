package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeploymentData {
	public String name;
	public String id;
	public String deploymentTime;
	public String category;
}
