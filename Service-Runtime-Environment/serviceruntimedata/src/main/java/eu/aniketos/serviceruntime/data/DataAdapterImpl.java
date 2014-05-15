package eu.aniketos.serviceruntime.data;

import eu.aniketos.serviceruntime.data.entities.Result;
import eu.aniketos.serviceruntime.data.entities.Service;
import eu.aniketos.serviceruntime.data.entities.ServiceTask;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataAdapterImpl implements DataAdapter {

    private static Logger logger = LoggerFactory.getLogger(DataAdapterImpl.class);
    
    private EntityManager em;
    
    public void setEntityManager(EntityManager em) { 
        this.em = em;
    }

    @Override
    public List<Result> getResults(String instanceId) {
        Query q = em.createQuery("select r from Result r where r.instanceId=?1");
        q.setParameter(1, instanceId);
        
        return q.getResultList();
    }

    @Override
    public String addService(String serviceName, String processId) {
        Service service = new Service();
        service.setService(serviceName);
        service.setProcessId(processId);

        try {
            em.persist(service);
            em.flush();
            //em.clear();
        } catch (PersistenceException e) {
            logger.error("Error (1) persisting service: {}", e.getMessage());
            return null;
        }
        
        if (serviceName.length() > 0) {
            serviceName = String.format("an_%05d_%s", 
                                service.getId(), serviceName);
        }
        else {
            serviceName = String.format("an_%05d", service.getId());            
        }
        service.setService(serviceName);
        try {
            em.persist(service);
            em.flush();
            em.clear();
            
            return serviceName;
        } catch (PersistenceException e) {
            logger.error("Error (2) persisting service: {}", e.getMessage());
        }
        
        return null;
    }
    
    @Override
    public void updateService(String serviceName, String processId, String deploymentId) {
        Query q = em.createQuery("select s from Service s where s.service=?1");
        q.setParameter(1, serviceName);
        
        Service service;
        List<Service> services = q.getResultList();
        if (services != null && services.size() > 0) {
            service = services.get(0);
        }
        else {
            logger.debug("Service {} not found!", serviceName);
            return;
        }        
        service.setProcessId(processId);
        service.setDeploymentId(deploymentId);
        
        try {
            em.persist(service);
            em.flush();
            em.clear();
        } catch (PersistenceException e) {
            logger.error("Error persisting service: {}", e.getMessage());
        } 
    }
    
    @Override
    public Service getServiceByName(String serviceName) {
        Query q = em.createQuery("select s from Service s where s.service=?1");
        q.setParameter(1, serviceName);
        
        List<Service> services = q.getResultList();
        
        if (services != null && services.size() > 0) {
            return services.get(0);
        }
        return null;
    }    

    @Override
    public String getProcessId(String service) {
        Query q = em.createQuery("select s.processId from Service s where s.service=?1");
        q.setParameter(1, service);
        
        List<String> services = q.getResultList();
        
        if (services != null && services.size() > 0) {
            return services.get(0);
        }
        return null;
    }

    @Override
    public long addServiceTask(String atomicServiceUrl, String taskId, String bpmn, String compositeServiceName) {
        long serviceTaskId = -1;
        ServiceTask serviceTask = new ServiceTask();
        serviceTask.setAtomicServiceUrl(atomicServiceUrl);
        serviceTask.setTaskId(taskId);
        serviceTask.setCompositeServiceName(compositeServiceName);
        serviceTask.setBpmn(bpmn);

        try {            
            em.persist(serviceTask);
            em.flush();
            
            serviceTaskId = serviceTask.getId();
            
            em.clear();
        } catch (PersistenceException e) {
            logger.error("Error (1) persisting service task: {}", e.getMessage());
        }
        
        return serviceTaskId;
    }

    @Override
    public List<ServiceTask> getServiceTasksByAtomicService(String atomicServiceUrl) {
        Query q = em.createQuery("select st from ServiceTask st where st.atomicServiceUrl=?1");
        q.setParameter(1, atomicServiceUrl);
        
        return q.getResultList();
    }

    @Override
    public ServiceTask getServiceTask(String compositeServiceName, String taskId) {
        Query q = em.createQuery("select st from ServiceTask st where st.compositeServiceName=?1 and st.taskId=?2");
        q.setParameter(1, compositeServiceName);
        q.setParameter(2, taskId);
        
        List<ServiceTask> results = q.getResultList();
        if (results != null && results.size() > 0) {
            return results.get(0);
        }
        return null;
    }



    @Override
    public int deleteServiceTasks(String compositeServiceName) {
        Query q = em.createQuery("delete from ServiceTask st where st.compositeServiceName=?1");
        q.setParameter(1, compositeServiceName);
        
        int deletedCount = q.executeUpdate();         
        return deletedCount;
    }

}