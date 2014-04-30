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
package eu.aniketos.mtm.util;

import java.io.IOException;

import eu.aniketos.mtm.model.mtm_bpmn2.Bpmn2Factory;
import eu.aniketos.mtm.model.mtm_bpmn2.Definitions;
import eu.aniketos.mtm.model.mtm_bpmn2.FieldExtension;
import eu.aniketos.mtm.model.mtm_bpmn2.Process;
import eu.aniketos.mtm.model.mtm_bpmn2.ServiceTask;
import org.eclipse.emf.common.util.EList;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.ParticipantType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.VarType;

public class ActivitiBpmnManager {
	
//	private String filename;
//	private MappingType mapping;
//
//	
//	public ActivitiBpmnManager (String filename, MappingType mapping){
//		this.filename = filename;
//		this.mapping = mapping;
//	}
//	
//	
//	public void setServiceTaskFieldExtensions (ServiceTask serviceTask){
//		// Get the singletons for working with mapping and BPMN models
//		BpmnManager bpmnManager = BpmnManager.getInstance();
//		MappingManager mappingManager = MappingManager.getInstance();
//		// Load the definitions root BPMN element from the specified path
//		Definitions definitions = null;
//		try {
//			definitions = bpmnManager.loadDefinitions(filename);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// Extracts the first (and presumibly only) process element from the definitions
//		Process process = bpmnManager.getProcess(definitions);
//					
//		if(process == null) {
//			return;
//		}
//
//		// Iterate through all relatesTo elements in mapping model to access to goal/task relationships
//		EList<RelatesToType> rtList = mapping.getRelatesTo();
//		for(RelatesToType rt : rtList) {
//			ActivityType activity = rt.getActivity();
//
//			if(activity.getId().equals(serviceTask.getId())){
//			
//				// Get the IDs of all the participants associated to the task from the mapping model
//				EList<String> participantIdList = activity.getParticipant();
//				for(String partId : participantIdList) {
//					// Extract the corresponding participant element from the mapping model
//					ParticipantType part = mappingManager.getParticipantById(mapping, partId);
//					// Associate the participant suitably to the (user/service) task in the BPMN model
//					addServiceProvider(serviceTask,  mappingManager.getParticipantId(part), part.getValue());
//				}
//
//				// Get the IDs of all the variables associated to the task from the mapping model
//				EList<String> varIdList = activity.getVariable();
//				for(String varId : varIdList) {
////					// Extract the corresponding variable element from the mapping model
//					VarType var = mappingManager.getVarById(mapping, varId);
////					// Associate the variable suitably to the (user/service) task in the BPMN model
//					addServiceTaskVar(serviceTask, var.getId(), var.getValue());
//				}
//			}
//		}
//
//	}
//	
//	public void addServiceProvider (ServiceTask sTask, String id, String name){
//		FieldExtension fieldExtension = Bpmn2Factory.eINSTANCE.createFieldExtension();
//		fieldExtension.setFieldname("Service Provider");
//		fieldExtension.setId(id);
//		fieldExtension.setExpression(name);
//		sTask.getFieldExtensions().add(fieldExtension);
//	}
//	
//	public void addServiceTaskVar (ServiceTask sTask, String id, String name){
//		FieldExtension fieldExtension = Bpmn2Factory.eINSTANCE.createFieldExtension();
//		fieldExtension.setFieldname("Input");
//		fieldExtension.setId(id);
//		fieldExtension.setExpression(name);
//		sTask.getFieldExtensions().add(fieldExtension);
//	}
}
