package eu.aniketos.serviceruntime.scpm;

import eu.aniketos.data.ICompositionPlan;

/**
 *
 * @author Kostas Giannakakis
 */
public class ScpmClientCompositionPlan implements ICompositionPlan {

    private String compositionPlanID;
    
    private String BPMNXML;
    
    private String activitiFile;
    
    @Override
    public String getCompositionPlanID() {
        return compositionPlanID;
    }

    @Override
    public void setCompositionPlanID(String compositionPlanID) {
        this.compositionPlanID = compositionPlanID;
    }

    @Override
    public void setBPMNXML(String BPMNXML) {
        this.BPMNXML = BPMNXML;
    }

    @Override
    public String getBPMNXML() {
        return BPMNXML;
    }

    @Override
    public String getActivitiFile() {
        return activitiFile;
    }

    @Override
    public void setActivitiFile(String activitiFile) {
        this.activitiFile = activitiFile;
    }
    
}
