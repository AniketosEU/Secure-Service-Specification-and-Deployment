/*******************************************************************************
 * Copyright (c) 2012, Project: FP7-ICT-257930 Aniketos
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 *  -  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  -  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  -  Neither the name of institution nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package eu.aniketos.scf.data.impl;

import eu.aniketos.data.ICompositionPlan;

/**
 * A dummy implementation of Composition Plan that just wraps a BPMN XML String.
 * Located in the WP3 package as it is likely to be replaced or at best,
 * superseded.
 * 
 * @author David Lamb, Bo Zhou, LJMU
 */
public class CompositionPlan implements ICompositionPlan
{

	/**
	 * The XML content of a composition plan.
	 */
    private String bpmnXML;
    
    /**
	 * The composition plan ID.
	 */
    private String compositionPlanID;
    
    private String activitiFile;

    /** Constructor.
	 *
	 * @param bpmnXML The XML content to be saved in the composition plan.
	 * 
	 */
    public CompositionPlan(String bpmnXML)
    {
    	this.bpmnXML = bpmnXML;
    }

    /** Get the XML content of a composition plan. 
	 *
	 * @return The content of a composition plan in XML format.
	 * 
	 */
    @Override
    public String getBPMNXML()
    {
	
    	return bpmnXML;
    }

	/** Get a composition plan ID.
	 *
	 * @return The ID of the composition plan.
	 * 
	 */
    @Override
	public String getCompositionPlanID() {
		// TODO Auto-generated method stub
		return compositionPlanID;
	}

	/** Set the ID for a composition plan.
	 *
	 * @param compositionPlanID ID of the composition plan to be set.
	 * 
	 */
    @Override
	public void setCompositionPlanID(String compositionPlanID) {
		this.compositionPlanID = compositionPlanID;
		
	}

	@Override
	public String getActivitiFile() {
		return activitiFile;
	}

	@Override
	public void setActivitiFile(String activitiFile) {
		this.activitiFile = activitiFile;
		
	}

	@Override
	public void setBPMNXML(String xml) {
		this.bpmnXML = xml;
		
	}

}
