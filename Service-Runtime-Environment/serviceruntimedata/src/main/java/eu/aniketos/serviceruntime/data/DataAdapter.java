package eu.aniketos.serviceruntime.data;

import eu.aniketos.serviceruntime.data.entities.Result;
import eu.aniketos.serviceruntime.data.entities.Service;
import eu.aniketos.serviceruntime.data.entities.ServiceTask;
import java.util.List;

public interface DataAdapter {

    List<Result> getResults(String instanceId);
    
    String addService(String serviceName, String processId);
    
    void updateService(String service, String processId, String deploymentId);
    
    Service getServiceByName(String serviceName);
    
    String getProcessId(String service);
    
    long addServiceTask(String atomicServiceUrl, String taskId, 
                        String bpmn, String compositeServiceName);
    
    List<ServiceTask> getServiceTasksByAtomicService(String atomicServiceUrl);
    
    int deleteServiceTasks(String compositeServiceName);
    
    ServiceTask getServiceTask(String compositeServiceName, String taskId);
}