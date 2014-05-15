package eu.aniketos.serviceruntime.data.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceTasks")
public class ServiceTask implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;	
	
	@Column(name = "atomicServiceUrl")    
	private String atomicServiceUrl;  
    
	@Column(name = "taskId")
	private String taskId;
    
	@Column(name = "bpmn")
	private String bpmn;
    
	@Column(name = "compositeServiceName")
	private String compositeServiceName;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtomicServiceUrl() {
        return atomicServiceUrl;
    }

    public void setAtomicServiceUrl(String atomicServiceUrl) {
        this.atomicServiceUrl = atomicServiceUrl;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getBpmn() {
        return bpmn;
    }

    public void setBpmn(String bpmn) {
        this.bpmn = bpmn;
    }

    public String getCompositeServiceName() {
        return compositeServiceName;
    }

    public void setCompositeServiceName(String compositeServiceName) {
        this.compositeServiceName = compositeServiceName;
    }

}
