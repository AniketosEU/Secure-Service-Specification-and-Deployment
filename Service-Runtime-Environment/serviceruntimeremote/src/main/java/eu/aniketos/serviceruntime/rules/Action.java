package eu.aniketos.serviceruntime.rules;

/**
 *
 * @author Kostas Giannakakis
 */
public class Action {

    private String launchProcessId;
    
    private ActionType actionType;
    
    private boolean stop;

    /**
     * @return the launchProcessId
     */
    public String getLaunchProcessId() {
        return launchProcessId;
    }

    /**
     * @param launchProcessId the launchProcessId to set
     */
    public void setLaunchProcessId(String launchProcessId) {
        this.launchProcessId = launchProcessId;
    }

    /**
     * @return the actionType
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    /**
     * @return the stop
     */
    public boolean isStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
	@Override
	public String toString() {
		return String.format(
		"\tactionType:%s\n\tstop:%s\n\tlaunchProcessId:%s",
		actionType, stop, launchProcessId);
	}	    
        
}
