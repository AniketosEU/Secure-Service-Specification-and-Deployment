package eu.aniketos.serviceruntime.remote.activiti.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kostas Giannakakis
 */
@XmlRootElement
public class ProcessDefinitionData {
	public String category;
	public String deploymentId;
	public String diagramResourceName;
	public boolean graphicNotationDefined;
    public String id;
    public String key;
    public String name;
    public String resourceName;
    public int version;
    public Object startFormResourceKey;
}
