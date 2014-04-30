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
package eu.aniketos.scf.implementation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.google.common.collect.Sets;

import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.scf.data.impl.CompositionPlan;
import eu.aniketos.scf.data.impl.Service;
import eu.aniketos.scf.implementation.util.BPMNParser;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class CreateCompositionPlansThread implements Callable<List<ICompositionPlan>>{

	private ICompositionPlan serviceSpecification;
	private Map<String, Set<Service>> mapTaskServices;
	
	private static final Logger logger = Logger.getLogger(CreateCompositionPlansThread.class);
	
	public CreateCompositionPlansThread(ICompositionPlan serviceSpecification,
			Map<String, Set<Service>> mapTaskServices){
		this.serviceSpecification = serviceSpecification;
		this.mapTaskServices = mapTaskServices;
	}
	
	@Override
	public List<ICompositionPlan> call() throws Exception {
		LinkedList<ICompositionPlan> listCompositionPlan;
		try{

			Set<String> taskIds = mapTaskServices.keySet();

			Object[] taskIdsArray = (Object[]) taskIds.toArray();

			listCompositionPlan = new LinkedList<ICompositionPlan>();

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());

			Iterator<String> itTaskIds = taskIds.iterator();

			List<Set<Service>> list = new LinkedList<Set<Service>>();
			while(itTaskIds.hasNext()){
				String taskId = itTaskIds.next();
				Set<Service> services = mapTaskServices.get(taskId);
				Set<String> locations = new HashSet<String>();
				for(Service service : services){
					locations.add(service.getLocation());
				}
				list.add(services);
			}

			Set<List<Service>> set = Sets.cartesianProduct(list);
			Object[] setArray = (Object[]) set.toArray();


			for(int j = 0; j<setArray.length; j++){
				Document newDocument = BPMNParser.getDocument(serviceSpecification.getBPMNXML());

				@SuppressWarnings("unchecked")
				List<Object> listS = (List<Object>) setArray[j];
				for(int i=taskIdsArray.length-1; i>=0; i--){
					String taskId = (String)taskIdsArray[i];
					Service service = (Service)listS.get(i);
					String location = service.getLocation();

					String serviceId = service.getServiceId();
					logger.debug("ServiceId: "+serviceId);

					String provider = service.getProvider();

					BPMNParser.addServiceId(newDocument, taskId, serviceId);
					BPMNParser.addLocationField(newDocument, taskId, location);
					BPMNParser.addProviderField(newDocument, taskId, provider);
				}
				int c = j+1;
				BPMNParser.addProcessId(newDocument, serviceSpecification.getCompositionPlanID()+"Plan"+c);
				logger.debug("Created compositon plan"+c);

				String specification = xmlOutput.outputString(newDocument);
				ICompositionPlan compositionPlan = new CompositionPlan(specification);
				compositionPlan.setCompositionPlanID(serviceSpecification.getCompositionPlanID()+"Plan"+c);

				//Interaction with the composition planner

				listCompositionPlan.add(compositionPlan);
				logger.debug("compositionPlan " + compositionPlan.getBPMNXML());

			}

			return listCompositionPlan;
			
		} finally {
			listCompositionPlan = null;
		}
	}
	
	

}
