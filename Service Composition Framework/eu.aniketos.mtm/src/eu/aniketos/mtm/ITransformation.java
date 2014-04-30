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
package eu.aniketos.mtm;

import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.mapping.MappingType;

/**
 * It is the Model Transformation Module (MTM) interface to translate the Security 
 * Requirements Specification (SRS) model derived from the Socio-technical Security Modelling
 * Tool into a format that can be exploited by the other Aniketos platform components. The output
 * formats generated are the following ones: BPMN activiti model, the mapping model between 
 * the SRS and the BPMN activiti, and the consumer policies written in conspec format.
 * 
 * @author Eider Iturbe, Tecnalia
 *
 */
public interface ITransformation {

	/**
	 * It transforms the SRS model into a BPMN Activiti model using the mapping model created with the help of the user as input.
	 * @param mappingModel The mapping model to be transformed
	 * @param path The path where the SRS model is stored
	 * @return True when correctly transformed, else false
	 */
	public boolean transform (MappingType mappingModel, String path);
	
	/**
	 * It generates the consumer policy in conspec format.
	 * @param policy The security policy to be translated to the conspec format consumer policy
	 * @param path The path where the consumer policy is generated
	 * @return True when correctly generated, else false
	 */
	public boolean generateConsumerPolicy (Policy policy, String path);
	
}
