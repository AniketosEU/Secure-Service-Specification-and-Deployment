package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kostas Giannakakis
 */

@XmlRootElement
public class ProcessDefinitionsPage {
	public ProcessDefinitionData [] data;
	public int size;
	public int total;
	public int start;
	public String order;
	public String sort;
}
