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
package eu.aniketos.scf.implementation.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import org.apache.log4j.Logger;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class WsdlParser {
	
	private static final Logger logger = Logger.getLogger(WsdlParser.class);

	private static WsdlParser instance;
	
	private WSDLReader reader;
	
	private WsdlParser(){
		
		WSDLFactory factory;
		try {
			factory = WSDLFactory.newInstance();
			reader = factory.newWSDLReader();
		} catch (WSDLException e) {
			logger.error(e);
		}
		
	}
	
	public static WsdlParser getInstance(){
		
		if(instance == null){
			instance = new WsdlParser();
		}
		
		return instance;
			
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,List<String>> getOperationsData(String location){
		logger.debug("getting operations data for WSDL: "+location);
		Map<String,List<String>> hashOperations = new Hashtable<String,List<String>>();

		try {

			Definition def = reader.readWSDL(null, location);

			Map services = def.getServices();

			Iterator<Service> serviceIterator = services.values().iterator();

			while(serviceIterator.hasNext()){
				Service service = serviceIterator.next();

				Iterator<Port> portIterator = service.getPorts().values().iterator();

				while(portIterator.hasNext()){
					Port port = portIterator.next();

					Binding binding = port.getBinding();
					PortType portType = binding.getPortType();
					List<Operation> operations = portType.getOperations();
					Iterator<Operation> opIterator = operations.iterator();
					while (opIterator.hasNext()) {
						Operation operation = opIterator.next();
						List<String> listInputOutput = new Vector<String>();
						listInputOutput.add(operation.getInput().getName());
						listInputOutput.add(operation.getOutput().getName());
						if (!operation.isUndefined()) {
							hashOperations.put(operation.getName(),listInputOutput);
						}
					}
				}
			}


		} catch (WSDLException e) {
			e.printStackTrace();
		}

		return hashOperations;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getPortTypeName(String location){
		logger.debug("getting porty type name for WSDL: "+location);
		String portTypeName = "";
		
		try {
			Definition def = reader.readWSDL(null, location);
			

			Map services = def.getServices();

			Iterator<Service> serviceIterator = services.values().iterator();

			while(serviceIterator.hasNext()){
				Service service = serviceIterator.next();

				Iterator<Port> portIterator = service.getPorts().values().iterator();

				while(portIterator.hasNext()){
					Port port = portIterator.next();

					Binding binding = port.getBinding();
					PortType portType = binding.getPortType();
					portTypeName = portType.getQName().getLocalPart();
				}
			}
			
		} catch (WSDLException e) {
			logger.error(e);
		}
		
		return portTypeName;
	}
	

}
