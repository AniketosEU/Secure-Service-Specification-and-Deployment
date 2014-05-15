package eu.aniketos.serviceruntime.data.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result implements Serializable {
	
	@Id
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "instanceId")
	private String instanceId;

	@Column(name = "variableName")
	private String variableName;
    
	@Column(name = "variableResult")
	private String variableResult; 

    public Long getId() {
        return id;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getVariableResult() {
        return variableResult;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public void setVariableResult(String variableResult) {
        this.variableResult = variableResult;
    }
}
