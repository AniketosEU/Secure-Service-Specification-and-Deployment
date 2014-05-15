package eu.aniketos.serviceruntime.bpmn;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 * Provides tools for parsing bpmn
 * @author Kostas Giannakakis
 */
public class BpmnUtils {
    
	/** Logger */
	//private static Logger logger = LoggerFactory.getLogger(BpmnUtils.class);    
    
    /**
     * Parses the BPMN and return a map from service task ids to service locations
     * @param bpmn The BPMN to parse
     * @return A map from service task ids to service locations
     * @throws Exception in case of malformed XML
     */
    public static Map<String, String> getServiceTasks(String bpmn) throws Exception  {
    	Map<String, String> serviceTasksMap = new HashMap<String, String>();
    	
    	XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = 
                inputFactory.createXMLStreamReader(new StringReader(bpmn));
        
        //logger.debug(bpmn);
        
        String serviceTaskId = null;
        boolean isLocationContent = false;
        boolean readLocation = false;
        
        while (reader.hasNext()) {
            int event = reader.next();
            
            switch(event){
                case XMLStreamConstants.START_DOCUMENT:
                    break;                
                case XMLStreamConstants.START_ELEMENT:
                	String localName = reader.getLocalName();
                	if (localName.equals("serviceTask")) {
                		serviceTaskId = reader.getAttributeValue(null, "id");
                        //logger.debug("Found service task id: {}", serviceTaskId);
                	}
                	else if (localName.equals("field")) {
                		String name = reader.getAttributeValue(null, "name");
                		isLocationContent = "location".equals(name); 
                	}
                	else if (isLocationContent && localName.equals("string")) {
                		readLocation = true;
                		isLocationContent = false;
                	}                	
                	break;
                case XMLStreamConstants.CHARACTERS:
                	if (readLocation && serviceTaskId != null) {
                		String location = reader.getText().trim();
                		serviceTasksMap.put(serviceTaskId, location);
                		serviceTaskId = null;
                		readLocation = false;
                	}
                    break;
                case XMLStreamConstants.END_ELEMENT:
                	break;
            }
        }
                
        return serviceTasksMap;        
    }
        
	public static String removeDuplicateProvider(String xml) {
				
		String [] lines = xml.replace("\r", "").split("\n"); 
		String newXml = "";
		
		int lineCount = 0;
		int providerLineCount = 01;
		boolean isServiceProviderElement = false;
		boolean isDuplicateEntry = false;
		for(String line: lines) {
			if (line.trim().startsWith("<activiti:field name=\"serviceProvider\">")) {
				isServiceProviderElement = true;
				if (lineCount - providerLineCount < 4) {
					isDuplicateEntry = true;
				}
				providerLineCount = lineCount;
			}
			else if (isServiceProviderElement && line.trim().startsWith("</activiti:field>")) {
				isServiceProviderElement = false;
				if (isDuplicateEntry) {
					lineCount++;
					isDuplicateEntry = false;
					continue;
				}				
			} 
			
			lineCount++;
			if (!isDuplicateEntry) {
				newXml += line + "\n";
			}
		}
		
		
		return newXml;
	}
}
