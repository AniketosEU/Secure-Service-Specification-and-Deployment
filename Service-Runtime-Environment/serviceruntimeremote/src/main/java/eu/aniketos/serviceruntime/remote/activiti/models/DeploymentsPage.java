package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeploymentsPage {
	public DeploymentData [] data;
	public int size;
	public int total;
	public int start;
	public String order;
	public String sort;
}
