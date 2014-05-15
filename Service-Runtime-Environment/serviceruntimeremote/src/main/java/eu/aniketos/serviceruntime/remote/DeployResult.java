package eu.aniketos.serviceruntime.remote;

/**
 * Class that encapsulates the result of a deployment
 * @author Kostas Giannakakis
 *
 */
public class DeployResult {

	/** The address of the deployed service */
	private String serviceAddress;
	
	/** An error message. If there is no error, it is null */
	private String errorMessage;
	
	/** The result of the deployment */
	private boolean ok;

	/**
	 * Gets the address of the deployed service
	 * @return the  address of the deployed service
	 */
	public String getServiceAddress() {
		return serviceAddress;
	}

	/**
	 * Sets the address of the deployed service
	 * @param serviceAddress The  address of the deployed service
	 */
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	/**
	 * Gets the error message
	 * @return The error message, if there is any, null otherwise
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message
	 * @param errorMessage The error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the result of the deployment
	 * @return true if the deployment is successful, false otherwise
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * Sets the result of the deployment
	 * @param ok The result of the deployment
	 */
	public void setOk(boolean ok) {
		this.ok = ok;
	}

	
}
