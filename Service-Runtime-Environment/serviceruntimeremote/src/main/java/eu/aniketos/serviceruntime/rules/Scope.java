package eu.aniketos.serviceruntime.rules;

/**
 *
 * @author Kostas Giannakakis
 */
public class Scope {
    
    private String before;
    
    private String after;
    
    private String during;

    /**
     * @return the id of the before task
     */
    public String getBefore() {
        return before;
    }

    /**
     * @param before the id of the before task
     */
    public void setBefore(String before) {
        this.before = before;
    }

    /**
     * @return the id of the after task
     */
    public String getAfter() {
        return after;
    }

    /**
     * @param after the id of the after task
     */
    public void setAfter(String after) {
        this.after = after;
    }

    /**
     * @return the id of the during task
     */
    public String getDuring() {
        return during;
    }

    /**
     * @param during the id of the during task
     */
    public void setDuring(String during) {
        this.during = during;
    }
    
	@Override
	public String toString() {
		return String.format(
					"\tbefore:%s\n\tafter:%s\n\tduring:%s\n",
					before, after, during);
	}    
}
