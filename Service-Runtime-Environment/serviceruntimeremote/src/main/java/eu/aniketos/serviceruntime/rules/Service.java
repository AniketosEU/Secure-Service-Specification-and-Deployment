package eu.aniketos.serviceruntime.rules;

/**
 * Encapsulates a service that is associated with a rule
 * @author Kostas Giannakakis
 *
 */
public class Service {
	private String taskId;
	
	private String taskName;
	
	private String serviceId;

	/**
	 * 
	 * @return the task id
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id
	 * @param taskId The task id
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * 
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name
	 * @param taskName the task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 
	 * @return the service id
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * Sets the service id
	 * @param serviceId The service id
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	@Override
	public String toString() {
		return String.format(
		"\tserviceId:%s\n\ttaskName:%s\n\ttaskId:%s",
		serviceId, taskName, taskId);
	}	
}
