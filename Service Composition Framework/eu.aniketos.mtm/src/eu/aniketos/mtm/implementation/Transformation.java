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
package eu.aniketos.mtm.implementation;

import java.util.Vector;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import es.esi.gemde.modeltransformator.ModelTransformatorPlugin;
import eu.aniketos.mtm.ITransformation;
import eu.aniketos.mtm.bpmnimport.ImportBpmnUtil;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.transform.Mapping2BpmnTransformer;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.utils.ModelingUtils;
import eu.aniketos.mtm.utils.Utils;

/**
 * It implements the methods of the Model Transformation Module (MTM) interface. It translates 
 * the Security Requirements Specification (SRS) model derived from the Socio-technical 
 * Security Modelling Tool into a format that can be exploited by the other Aniketos 
 * platform components. The output formats generated are the following ones: BPMN activiti model, 
 * the mapping model between the SRS and the BPMN activiti, and  the consumer policies written 
 * in conspec format.
 * 
 * @author Tecnalia
 *
 */
public class Transformation implements ITransformation {

	public final static String BPMN_EXTENSION = "activiti";
	public final static String MAPPING_EXTENSION = "mapping";
	public final static String MTM_BPMN_EXTENSION = "bpmn";
	
	private final String MOFSCRIPT_NAME = "MOFScript";
	
	@Override
	public boolean transform(MappingType mappingModel, String path) {
		Mapping2BpmnTransformer m2b = new Mapping2BpmnTransformer();
		if(mappingModel != null){
			String activitiCompletePath = getActivitiPathSuggestion(path);
			String bpmnCompletePath = Utils.replaceExtension(activitiCompletePath, MTM_BPMN_EXTENSION);
			String parentPath =  Utils.getPath(bpmnCompletePath);		
			m2b.transform(MappingManager.getInstance().getRootObject(mappingModel), parentPath, Utils.getFileName(bpmnCompletePath));
			// save mapping after activiti file creation
			saveMappingModel(mappingModel, getMappingPathSuggestion(bpmnCompletePath));
			
			try {
				IFile diagramFile = Utils.getIFile(bpmnCompletePath);
				String processName = Utils.getFileNameWithoutExt(bpmnCompletePath);
				ImportBpmnUtil.createDiagram(processName, bpmnCompletePath, null, diagramFile.getParent(), mappingModel);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			Utils.refreshPath(path);
			Utils.openFile(activitiCompletePath);
			// remove .bpmn
			try {
				Utils.getIFile(bpmnCompletePath).delete(true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return true;
		}
		else{
			return false;
		}		
	}

	@Override
	public boolean generateConsumerPolicy(Policy policy, String path) {		
		ModelingUtils utils = ModelingUtils.configure(null, null, null);
		if (policy == null) {
			return false;
		}
		else{
			String transformationName = utils.getTransformationFromPolicy(policy);
			if (transformationName == null) {
				return false;
			}
			else{
				// Generate Conspec file
				Vector<EObject> inputs = new Vector<EObject>();
				inputs.add(policy);
				try {
					ModelTransformatorPlugin.getService().executeTransformation(inputs, transformationName, MOFSCRIPT_NAME, path);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}				
		}	
	}

	/**
	 * Suggests the same path and file name of the input for the BPMN activiti file, but changing the file extension.
	 * @param originPath The input file name (with path).
	 * @return The suggested file name (with path).
	 */
	private String getActivitiPathSuggestion(String originPath) {
		return Utils.replaceExtension(originPath, BPMN_EXTENSION);
	}
	
	/**
	 * Suggests the same path and file name of the input for the mapping file, but changing the file extension.
	 * @param originPath The input file name (with path).
	 * @return The suggested file name (with path).
	 */
	private String getMappingPathSuggestion(String originPath) {
		return Utils.replaceExtension(originPath, MAPPING_EXTENSION);
	}
	
	/**
	 * Saves the involved mapping model in the specified file (overwrites it if existing).
	 * @param path The target file path.
	 * @return True when correctly saved, else false.
	 */
	private boolean saveMappingModel(MappingType mappingModel, String path) {
		try {
			MappingManager.getInstance().saveMappingType(mappingModel, path);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
