package eu.aniketos.serviceruntime.remote.activiti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import eu.aniketos.serviceruntime.remote.activiti.models.DeploymentData;
import eu.aniketos.serviceruntime.remote.activiti.models.DeploymentResponse;
import eu.aniketos.serviceruntime.remote.activiti.models.DeploymentsPage;
import eu.aniketos.serviceruntime.remote.activiti.models.LoginInfo;
import eu.aniketos.serviceruntime.remote.activiti.models.ProcessDefinitionData;
import eu.aniketos.serviceruntime.remote.activiti.models.ProcessDefinitionsPage;
import eu.aniketos.serviceruntime.remote.activiti.models.Result;
import java.util.HashMap;
import java.util.Map;

public class ActivitiClient {
	
	/**
	 * Logger
	 */
	final private static Logger logger = LoggerFactory.getLogger(ActivitiClient.class);	
	
	private Client client;
	
	private String activitiHost = "http://localhost:8080/";
	
	public ActivitiClient(String host, String username, String password) {
		if (host != null && !host.endsWith("/")) {
			host += "/";
		}
		this.activitiHost = host;
		
		DefaultClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	    client = Client.create(clientConfig);	
				
		//client = Client.create();
		//client.addFilter(new LoggingFilter());
		client.addFilter(new HTTPBasicAuthFilter(username, password));
	}	
	
	public void login(String username, String password) {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/login");
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.userId = username;
		loginInfo.password = password;
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, loginInfo);		     		     
		    System.out.println(response.toString());
		    
		    MultivaluedMap<String, String> headers = response.getHeaders();
		    
		     for(String key: headers.keySet()) {
		    	 System.out.println(key + ": " + headers.get(key));
		     }
		     
		     List<NewCookie> cookies = response.getCookies();
		     for(NewCookie cookie: cookies) {
		    	 System.out.println(cookie.getName() + ": " + cookie.getValue());
		     }
		     
		     System.out.println(response.getEntity(String.class));
		    
		} catch (UniformInterfaceException ue) {
			System.out.println(ue.getMessage());
		}
	}
	
	public Map<String,String> getDeployments() {
        //TODO: This only returns the first page of deployments
        Map<String, String> deploymentsMap = new HashMap<String, String>();        
        
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/deployments");
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);		     		     
		    if (response != null) {			    
			    DeploymentsPage deploymentsPage = response.getEntity(DeploymentsPage.class);
			    if (deploymentsPage != null) {
				    for(int i=0; i<deploymentsPage.size; i++) {
				    	DeploymentData deployment = deploymentsPage.data[i];
                        deploymentsMap.put(deployment.id, deployment.name);
				    }
			    }
		    }
		    else {
		    	logger.error("Response is null");
		    }
		} catch (UniformInterfaceException ue) {
			logger.error(ue.getMessage());
		}
        return deploymentsMap;
	}
   
	public void getProcessDefinitions() {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/process-definitions?sort=deploymentId&order=desc");
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);		     		     
		    if (response != null) {			    
			    ProcessDefinitionsPage definitionsPage = response.getEntity(ProcessDefinitionsPage.class);
			    if (definitionsPage != null) {
				    for(int i=0; i<definitionsPage.size; i++) {
				    	ProcessDefinitionData definition = definitionsPage.data[i];
				    	logger.debug("{} {} {} {}", definition.name, definition.id,
                                                    definition.key, definition.deploymentId);
				    }
			    }
		    }
		    else {
		    	logger.error("Response is null");
		    }
		} catch (UniformInterfaceException ue) {
			logger.error(ue.getMessage());
		}
	}
    
    public ProcessDefinitionData getProcessDefinitionByName(String name) {
        int start = 0;
        int size = 20;
        ProcessDefinitionData definition = null;
        while(true) {
            String url = activitiHost + "activiti-rest/service/process-definitions?size=" +
                    size + "&start=" + start;
            
            //logger.debug(url);
            
            WebResource webResource = client
                    .resource(url);
            ClientResponse response;
            try {
                response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);		     		     
                if (response != null) {			    
                    ProcessDefinitionsPage definitionsPage = response.getEntity(ProcessDefinitionsPage.class);
                    if (definitionsPage != null) {
                        for(int i=0; i<definitionsPage.size; i++) {
                            ProcessDefinitionData def = definitionsPage.data[i];
                            if (name.equals(def.name)) {
                                if (definition == null || definition.version < def.version) {
                                    definition = def;
                                }
                            }
                        }
                        start += size;
                        if (start >= definitionsPage.total) {
                            break;
                        }
                    }
                }
                else {
                    logger.error("Response is null");
                    break;
                }
            } catch (UniformInterfaceException ue) {
                logger.error(ue.getMessage());
                break;
            }
        }
        return definition;
    }
    
	@SuppressWarnings("unused")
	private void printResponse(ClientResponse response) throws IOException {
		InputStream is = response.getEntityInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}			    
		is.close();
	}
	
	public void getDeploymentResource(String deploymentId, String resource) {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/deployment/" +
		        		deploymentId + "/resource/" + resource);
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);		     		     
		    System.out.println(response.toString());
		    
		    System.out.println(response.getEntity(String.class));
		} catch (UniformInterfaceException ue) {
			System.out.print(ue.getMessage());
		}		
	}
	
	
	private String bpmn = 
			
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:activiti=\"http://activiti.org/bpmn\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:omgdc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:omgdi=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" expressionLanguage=\"http://www.w3.org/1999/XPath\" targetNamespace=\"http://www.activiti.org/test\" typeLanguage=\"http://www.w3.org/2001/XMLSchema\">" + 
			"  <process id=\"compositionPlan2\" name=\"compositionPlan2\">" + 
			"    <documentation>Place documentation for the 'MapService' process here.</documentation>" + 
			"    <startEvent id=\"startevent1\" name=\"Start\">" + 
			"      <extensionElements>" + 
			"        <activiti:formProperty id=\"var0\" name=\"Insert a street\" />" + 
			"      </extensionElements>" + 
			"    </startEvent>" + 
			"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask1\" name=\"Service Task\">" + 
			"      <extensionElements>" + 
			"        <activiti:field name=\"type\">" + 
			"          <activiti:string>Geocode</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"input\">" + 
			"          <activiti:expression>${var0}</activiti:expression>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"inputType\">" + 
			"          <activiti:string>string</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"outputType\">" + 
			"          <activiti:string>string</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"resultVariable\">" + 
			"          <activiti:string>var1</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"operation\">" + 
			"          <activiti:string>getCoordinates</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"id\">" + 
			"          <activiti:string>http://localhost:63093/googlegeocoding?wsdl</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"location\">" + 
			"          <activiti:string>http://localhost:63093/googlegeocoding?wsdl</activiti:string>" + 
			"        </activiti:field>" + 
			"      </extensionElements>" + 
			"    </serviceTask>" + 
			"    <serviceTask activiti:class=\"org.aniketos.runtime.AniketosClientDelegation\" id=\"servicetask2\" name=\"Service Task\">" + 
			"      <extensionElements>" + 
			"        <activiti:field name=\"type\">" + 
			"          <activiti:string>Maps</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"input\">" + 
			"          <activiti:expression>${var1}</activiti:expression>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"inputType\">" + 
			"          <activiti:string>string</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"outputType\">" + 
			"          <activiti:string>void</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"resultVariable\">" + 
			"          <activiti:string>var2</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"operation\">" + 
			"          <activiti:string>showOnMap</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"id\">" + 
			"          <activiti:string>00003</activiti:string>" + 
			"        </activiti:field>" + 
			"        <activiti:field name=\"location\">" + 
			"          <activiti:string>http://localhost:63086/googlemaps?wsdl</activiti:string>" + 
			"        </activiti:field>" + 
			"      </extensionElements>" + 
			"    </serviceTask>" + 
			"    <endEvent id=\"endevent1\" name=\"End\" />" + 
			"    <sequenceFlow id=\"flow1\" name=\"\" sourceRef=\"startevent1\" targetRef=\"servicetask1\" />" + 
			"    <sequenceFlow id=\"flow2\" name=\"\" sourceRef=\"servicetask1\" targetRef=\"servicetask2\" />" + 
			"    <sequenceFlow id=\"flow3\" name=\"\" sourceRef=\"servicetask2\" targetRef=\"endevent1\" />" + 
			"  </process>" + 
			"  <bpmndi:BPMNDiagram id=\"BPMNDiagram_MapService\">" + 
			"    <bpmndi:BPMNPlane bpmnElement=\"compositionPlan2\" id=\"BPMNPlane_MapService\">" + 
			"      <bpmndi:BPMNShape bpmnElement=\"startevent1\" id=\"BPMNShape_startevent1\">" + 
			"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"150\" y=\"180\" />" + 
			"      </bpmndi:BPMNShape>" + 
			"      <bpmndi:BPMNShape bpmnElement=\"servicetask1\" id=\"BPMNShape_servicetask1\">" + 
			"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"240\" y=\"170\" />" + 
			"      </bpmndi:BPMNShape>" + 
			"      <bpmndi:BPMNShape bpmnElement=\"servicetask2\" id=\"BPMNShape_servicetask2\">" + 
			"        <omgdc:Bounds height=\"55\" width=\"105\" x=\"400\" y=\"170\" />" + 
			"      </bpmndi:BPMNShape>" + 
			"      <bpmndi:BPMNShape bpmnElement=\"endevent1\" id=\"BPMNShape_endevent1\">" + 
			"        <omgdc:Bounds height=\"35\" width=\"35\" x=\"560\" y=\"180\" />" + 
			"      </bpmndi:BPMNShape>" + 
			"      <bpmndi:BPMNEdge bpmnElement=\"flow1\" id=\"BPMNEdge_flow1\">" + 
			"        <omgdi:waypoint x=\"185\" y=\"197\" />" + 
			"        <omgdi:waypoint x=\"240\" y=\"197\" />" + 
			"      </bpmndi:BPMNEdge>" + 
			"      <bpmndi:BPMNEdge bpmnElement=\"flow2\" id=\"BPMNEdge_flow2\">" + 
			"        <omgdi:waypoint x=\"345\" y=\"197\" />" + 
			"        <omgdi:waypoint x=\"400\" y=\"197\" />" + 
			"      </bpmndi:BPMNEdge>" + 
			"      <bpmndi:BPMNEdge bpmnElement=\"flow3\" id=\"BPMNEdge_flow3\">" + 
			"        <omgdi:waypoint x=\"505\" y=\"197\" />" + 
			"        <omgdi:waypoint x=\"560\" y=\"197\" />" + 
			"      </bpmndi:BPMNEdge>" + 
			"    </bpmndi:BPMNPlane>" + 
			"  </bpmndi:BPMNDiagram>" + 
			"</definitions>";			
	
	
	public String getBpmn() {
		return bpmn;
	}
	
	private File getTempFile(String filename, String content) {
		File temp = null;
		try {
			temp = File.createTempFile(filename,".bpmn20.xml");			
			temp.deleteOnExit();			
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(content);
    	    bw.close();			
		} catch (IOException e) {
			System.err.println("Failed to create temporary file: " + e.getMessage());
			System.err.println("Java temp dir: " + System.getProperty("java.io.tmpdir"));
			e.printStackTrace();
		}
		return temp;
	}
	
	public String upload(String processName, String bpmn) {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/deployment");
		DeploymentResponse response;
		try {
			FormDataMultiPart multiPart = new FormDataMultiPart();
			File fileToUpload = getTempFile(processName, bpmn);
			
			FileDataBodyPart fileBodyPart = new FileDataBodyPart("deployment", fileToUpload,
			           MediaType.APPLICATION_OCTET_STREAM_TYPE);			
			multiPart.bodyPart(fileBodyPart);		
			
		    response = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
		    		.post(DeploymentResponse.class, multiPart);
		    logger.debug("Uploaded bmpn. Response: {},{},{},{}",
                    response.name, response.id, response.deploymentTime, response.category);
            
		    return response.id;
		} catch (UniformInterfaceException ue) {
			ue.printStackTrace();
		}  catch (Exception e) {			
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/*public void deleteDeployment(String deploymentId) {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/deployment/" +
		        		deploymentId);
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);		     		     
		    System.out.println(response.toString());
		    
		    System.out.println(response.getEntity(String.class));
		} catch (UniformInterfaceException ue) {
			System.out.print(ue.getMessage());
		}
	}*/
    
    public boolean deleteDeployment(String deploymentId) {
		WebResource webResource = client
		        .resource(activitiHost + "activiti-rest/service/deployment/" + deploymentId + "?cascade=cascade");
		ClientResponse response;
		try {
		    response = webResource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);		     		     
		    if (response != null) {			    
			    Result result = response.getEntity(Result.class);
                if (result != null) {
                    return result.success;
                }
		    }
		    else {
		    	logger.error("Response is null");
		    }
		} catch (UniformInterfaceException ue) {
			logger.error(ue.getMessage());
        }
        return false;
    }
        
}
