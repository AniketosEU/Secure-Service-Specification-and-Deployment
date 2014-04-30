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
package org.activiti.designer.elsag.wsdl;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class WsdlParser {
	
	private static String XSD_NAMESPACE = "http://www.w3.org/2001/XMLSchema";
	
	private static WsdlParser instance;
	
	private Hashtable<QName,String> mappingXsdJava;
	
	final private static Logger log = Logger.getLogger(WsdlParser.class);
	
	private WsdlParser(){
		
		mappingXsdJava = new Hashtable<QName,String>();
		mappingXsdJava.put(new QName(XSD_NAMESPACE,"string"),"java.lang.String");
	}
	
	public static WsdlParser getInstance(){
		
		if(instance == null){
			instance = new WsdlParser();
		}
		
		return instance;
			
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getOperations(String filePath) throws WSDLException{

		List<String> listOperations = new Vector<String>();
		
		WSDLFactory factory = WSDLFactory.newInstance();
		WSDLReader reader = factory.newWSDLReader();

		Definition def = reader.readWSDL(null, filePath);

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
					if (!operation.isUndefined()) {
						listOperations.add(operation.getName());
					}
				}
			}
		}


		return listOperations;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getInputTypesInDefinitions(String filePath, String operation){
		log.debug("Trying to search the input types in the definitions tag");
		List<String> typesList = new Vector<String>();
		
		try {

			WSDLFactory factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();

			Definition def = reader.readWSDL(null, filePath);

			Map services = def.getServices();

			Iterator<Service> serviceIterator = services.values().iterator();

			while(serviceIterator.hasNext()){
				Service service = serviceIterator.next();

				Iterator<Port> portIterator = service.getPorts().values().iterator();

				while(portIterator.hasNext()){
					Port port = portIterator.next();

					Binding binding = port.getBinding();
					PortType portType = binding.getPortType();

					Operation oper = portType.getOperation(operation, null, null);
					

					List inputParts = oper.getInput().getMessage().getOrderedParts(null);
					Iterator<Part> partIterator = inputParts.iterator();
					while(partIterator.hasNext()){
						Part part = partIterator.next();
						if(part.getTypeName()!=null){
							String inputType = part.getTypeName().getLocalPart();
							String t = part.getName() + " (type: " + inputType +")";
							typesList.add(t);
							log.debug("Added as input: "+t);
						} else {
							String t = "void" + " (type: void)";
							typesList.add(t);
							log.debug("Added as input: "+t);
						}
					}
				}
			}
			
		} catch (WSDLException e) {
			e.printStackTrace();
		}

		return typesList;


	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getInputTypes(String filePath, String operation){

		List<String> typesList = new Vector<String>();

		WSDLReader reader;
		Definition definition;
		try {
			reader = WSDLFactory.newInstance().newWSDLReader();
			definition = reader.readWSDL(filePath);

			Types types = definition.getTypes();
			if(types != null){

				List<ExtensibilityElement> list = types.getExtensibilityElements();

				if(list.size() > 0){
					Schema schema = null;
					for(ExtensibilityElement ee : list){
						if(ee instanceof Schema){
							schema = (Schema)ee;
							Element element = schema.getElement();
							NodeList childNodes = element.getChildNodes();

							for(int i=0; i<childNodes.getLength(); i++){
								Node n = childNodes.item(i);
								if(n.getNodeName().equals("xsd:complexType") || n.getNodeName().equals("xs:complexType") || n.getNodeName().equals("complexType")){
									NamedNodeMap attributes = n.getAttributes();
									Node attributeName = attributes.getNamedItem("name");
									if(attributeName.getTextContent().equals(operation)){
										NodeList sequenceNodes = n.getChildNodes();
										for(int k=0; k<sequenceNodes.getLength(); k++){
											Node sequenceNode = sequenceNodes.item(k);
											if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
												NodeList elements = sequenceNode.getChildNodes();
												for(int j=0; j<elements.getLength(); j++){
													Node elementType = elements.item(j);
													if(elementType.getNodeName().equals("xsd:element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String type = attributeType.getTextContent();
														String t = type.substring(4);
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														t = name + " (type: " + t +")";
														typesList.add(t);
														log.debug("Added as input: "+t);
													} else if(elementType.getNodeName().equals("xs:element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String type = attributeType.getTextContent();
														String t = type.substring(3);
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														t = name + " (type: " + t +")";
														typesList.add(t);
														log.debug("Added as input: "+t);
													} else if(elementType.getNodeName().equals("element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String type = attributeType.getTextContent();
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														type = name + " (type: " + type +")";
														typesList.add(type);
														log.debug("Added as input: "+type);
													}
												}
											}
										}
									}
								} else if(n.getNodeName().equals("xsd:element") || n.getNodeName().equals("xs:element") || n.getNodeName().equals("element")){
									NamedNodeMap attributes = n.getAttributes();
									Node attributeName = attributes.getNamedItem("name");
									if(attributeName.getTextContent().equals(operation+"Element")){
										NodeList complexList = n.getChildNodes();
										for(int l=0; l<complexList.getLength(); l++){
											Node complexNode = complexList.item(l);
											NodeList sequenceNodes = complexNode.getChildNodes();
											for(int k=0; k<sequenceNodes.getLength(); k++){
												Node sequenceNode = sequenceNodes.item(k);
												if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
													NodeList elements = sequenceNode.getChildNodes();
													for(int j=0; j<elements.getLength(); j++){
														Node elementType = elements.item(j);
														if(elementType.getNodeName().equals("xsd:element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															String type = attributeType.getTextContent();
															String t = type.substring(4);
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															t = name + " (type: " + t +")";
															typesList.add(t);
															log.debug("Added as input: "+t);
														} else if(elementType.getNodeName().equals("xs:element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															String type = attributeType.getTextContent();
															String t = type.substring(3);
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															t = name + " (type: " + t +")";
															typesList.add(t);
															log.debug("Added as input: "+t);
														} else if(elementType.getNodeName().equals("element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															String type = attributeType.getTextContent();
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															type = name + " (type: " + type +")";
															typesList.add(type);
															log.debug("Added as input: "+type);
														}
													}
												}
											}
										}
									}
								} else if(n.getNodeName().equals("xsd:import") || n.getNodeName().equals("xs:import")) {
									NamedNodeMap attributes = n.getAttributes();
									Node attributeSchemaLocation = attributes.getNamedItem("schemaLocation");
									String schemaLocation = attributeSchemaLocation.getTextContent();
									typesList = getInputTypesSchema(schemaLocation, operation);
								}
							}
						}
					}
				}
			} else {
				Map services = definition.getServices();

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
							Operation op = opIterator.next();
							if (!op.isUndefined() && op.getName().equals(operation)) {
								List<String> order = op.getParameterOrdering();
								if(order!=null){
									for(String name : order){
										Part part = op.getInput().getMessage().getPart(name);
										String type = part.getTypeName().getLocalPart();
										String t = name + " (type: " + type +")";
										typesList.add(t);
										log.debug("Added as input: "+t);
									}
								} else {
									Map parts = op.getInput().getMessage().getParts();
									Set keys = parts.keySet();
									Iterator it = keys.iterator();
									while(it.hasNext()){
										Object key = it.next();
										Part part = (Part) parts.get(key);
										String name = part.getName();
										String type = part.getTypeName().getLocalPart();
										String t = name + " (type: " + type +")";
										typesList.add(t);
										log.debug("Added as input: "+t);
									}
								}
							}
						}
					}
				}
			}

		} catch (WSDLException e) {
			log.debug(e);
		}
		if(typesList.isEmpty()){
			List<String> inputTypes = getInputTypesInDefinitions(filePath, operation);
			return inputTypes;
		}
		
		return typesList;

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getOutputTypes(String filePath, String operation){

		String type = "";

		WSDLReader reader;
		try {
			reader = WSDLFactory.newInstance().newWSDLReader();
			Definition definition = reader.readWSDL(filePath);

			Types types = definition.getTypes();

			if(types != null){

				List<ExtensibilityElement> list = types.getExtensibilityElements();
				if(list.size() > 0){
					Schema schema = null;

					for(ExtensibilityElement ee : list){
						if(ee instanceof Schema){
							schema = (Schema)ee;
							Element element = schema.getElement();
							NodeList childNodes = element.getChildNodes();

							for(int i=0; i<childNodes.getLength(); i++){
								Node n = childNodes.item(i);
								if(n.getNodeName().equals("xs:complexType") || n.getNodeName().equals("xsd:complexType") || n.getNodeName().equals("complexType")){
									NamedNodeMap attributes = n.getAttributes();
									Node attributeName = attributes.getNamedItem("name");
									if(attributeName.getTextContent().equals(operation+"Response")){
										NodeList sequenceNodes = n.getChildNodes();
										for(int k=0; k<sequenceNodes.getLength(); k++){
											Node sequenceNode = sequenceNodes.item(k);
											if(sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("xsd:sequence")  || sequenceNode.getNodeName().equals("sequence")){
												NodeList elements = sequenceNode.getChildNodes();
												for(int j=0; j<elements.getLength(); j++){
													Node elementType = elements.item(j);
													if(elementType.getNodeName().equals("xs:element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String t = attributeType.getTextContent();
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														type = name + " (type: " + t.substring(3) +")";
													} else if(elementType.getNodeName().equals("xsd:element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String t = attributeType.getTextContent();
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														type = name + " (type: " + t.substring(4) +")";
													}  else if(elementType.getNodeName().equals("element")){
														NamedNodeMap attributesT = elementType.getAttributes();
														Node attributeType = attributesT.getNamedItem("type");
														String t = attributeType.getTextContent();
														Node attributeN = attributesT.getNamedItem("name");
														String name = attributeN.getTextContent();
														type = name + " (type: " + t +")";
													}
												}
											}
										}
									}
								} else if(n.getNodeName().equals("xsd:element") || n.getNodeName().equals("xs:element") || n.getNodeName().equals("element")){
									NamedNodeMap attributes = n.getAttributes();
									Node attributeName = attributes.getNamedItem("name");
									if(attributeName.getTextContent().equals(operation+"ResponseElement")){
										NodeList complexList = n.getChildNodes();
										for(int l=0; l<complexList.getLength(); l++){
											Node complexNode = complexList.item(l);
											NodeList sequenceNodes = complexNode.getChildNodes();
											for(int k=0; k<sequenceNodes.getLength(); k++){
												Node sequenceNode = sequenceNodes.item(k);
												if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
													NodeList elements = sequenceNode.getChildNodes();
													for(int j=0; j<elements.getLength(); j++){
														Node elementType = elements.item(j);
														if(elementType.getNodeName().equals("xsd:element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															String t = attributeType.getTextContent();
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															type = name + " (type: " + t.substring(4) +")";
														} else if(elementType.getNodeName().equals("xs:element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															String t = attributeType.getTextContent();
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															type = name + " (type: " + t.substring(3) +")";
														} else if(elementType.getNodeName().equals("element")){
															NamedNodeMap attributesT = elementType.getAttributes();
															Node attributeType = attributesT.getNamedItem("type");
															Node attributeN = attributesT.getNamedItem("name");
															String name = attributeN.getTextContent();
															type = name + " (type: " + attributeType.getTextContent() +")";
														}
													}
												}
											}
										}
									}
								} else if(n.getNodeName().equals("xsd:import") || n.getNodeName().equals("xs:import")) {
									NamedNodeMap attributes = n.getAttributes();
									Node attributeSchemaLocation = attributes.getNamedItem("schemaLocation");
									String schemaLocation = attributeSchemaLocation.getTextContent();
									type = getOutputTypeSchema(schemaLocation, operation);
								}
							}
						}
					}
				}
			} else {
				Map services = definition.getServices();
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
							Operation op = opIterator.next();
							if (!op.isUndefined() && (op.getName()+"Response").equals(operation+"Response")) {
								Map parts = op.getOutput().getMessage().getParts();
								Set keys = parts.keySet();
								Iterator it = keys.iterator();
								while(it.hasNext()){
									Object key = it.next();
									Part part = (Part) parts.get(key);
									String name = part.getName();
									String t = part.getTypeName().getLocalPart();
									type = name + " (type: " + t +")";
								}
							}
						}
					}
				}
			}


		} catch (WSDLException e) {
			log.debug(e);
		}
		return type;

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,List<String>> getOperationsData(String filePath){
		
		Map<String,List<String>> hashOperations = new Hashtable<String,List<String>>();

		try {

			WSDLFactory factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();

			Definition def = reader.readWSDL(null, filePath);

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
			log.debug(e);
		}
		
		return hashOperations;
	}
	
	public List<String> getInputNames(String filePath, String operation){
		
		List<String> namesList = new Vector<String>();
		
		WSDLReader reader;
		try {
			reader = WSDLFactory.newInstance().newWSDLReader();
			Definition definition = reader.readWSDL(filePath);
			
			Types types = definition.getTypes();

			@SuppressWarnings("unchecked")
			List<ExtensibilityElement> list = types.getExtensibilityElements();
			
			Schema schema = null;
			
			for(ExtensibilityElement ee : list){
				if(ee instanceof Schema){
					schema = (Schema)ee;
					Element element = schema.getElement();
					NodeList childNodes = element.getChildNodes();
					
					for(int i=0; i<childNodes.getLength(); i++){
						Node n = childNodes.item(i);
						if(n.getNodeName().equals("xsd:complexType") || n.getNodeName().equals("xs:complexType")){
							NamedNodeMap attributes = n.getAttributes();
							Node attributeName = attributes.getNamedItem("name");
							if(attributeName.getTextContent().equals(operation)){
								NodeList sequenceNodes = n.getChildNodes();
								for(int k=0; k<sequenceNodes.getLength(); k++){
									Node sequenceNode = sequenceNodes.item(k);
									if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence")){
										NodeList elements = sequenceNode.getChildNodes();
										for(int j=0; j<elements.getLength(); j++){
											Node elementType = elements.item(j);
											if(elementType.getNodeName().equals("xsd:element")){
												NamedNodeMap attributesT = elementType.getAttributes();
												Node attributeType = attributesT.getNamedItem("name");
												String name = attributeType.getTextContent();
												
												namesList.add(name);
											} else if(elementType.getNodeName().equals("xs:element")){
												NamedNodeMap attributesT = elementType.getAttributes();
												Node attributeType = attributesT.getNamedItem("name");
												String name = attributeType.getTextContent();
												namesList.add(name);
											}
										}
									}
								}
							}
						} else if(n.getNodeName().equals("xsd:element") || n.getNodeName().equals("xs:element") || n.getNodeName().equals("element")){
							NamedNodeMap attributes = n.getAttributes();
							Node attributeName = attributes.getNamedItem("name");
							if(attributeName.getTextContent().equals(operation+"Element")){
								NodeList complexList = n.getChildNodes();
								for(int l=0; l<complexList.getLength(); l++){
									Node complexNode = complexList.item(l);
									NodeList sequenceNodes = complexNode.getChildNodes();
									for(int k=0; k<sequenceNodes.getLength(); k++){
										Node sequenceNode = sequenceNodes.item(k);
										if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
											NodeList elements = sequenceNode.getChildNodes();
											for(int j=0; j<elements.getLength(); j++){
												Node elementType = elements.item(j);
												if(elementType.getNodeName().equals("xsd:element")){
													NamedNodeMap attributesT = elementType.getAttributes();
													Node attributeType = attributesT.getNamedItem("name");
													String name = attributeType.getTextContent();
													namesList.add(name);
												} else if(elementType.getNodeName().equals("xs:element")){
													NamedNodeMap attributesT = elementType.getAttributes();
													Node attributeType = attributesT.getNamedItem("name");
													String name = attributeType.getTextContent();
													namesList.add(name);
												} else if(elementType.getNodeName().equals("element")){
													NamedNodeMap attributesT = elementType.getAttributes();
													Node attributeType = attributesT.getNamedItem("name");
													String name = attributeType.getTextContent();
													namesList.add(name);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			
		} catch (WSDLException e) {
			log.debug(e);
		}
		return namesList;

	}
	
	private List<String> getInputTypesSchema(String location, String operation){
		List<String> typesList = new Vector<String>();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(location);

			Element element = doc.getDocumentElement();
			NodeList childNodes = element.getChildNodes();

			for(int i=0; i<childNodes.getLength(); i++){
				Node n = childNodes.item(i);
				if(n.getNodeName().equals("xsd:complexType") || n.getNodeName().equals("xs:complexType")  || n.getNodeName().equals("complexType")){
					NamedNodeMap attributes = n.getAttributes();
					Node attributeName = attributes.getNamedItem("name");
					if(attributeName.getTextContent().equals(operation)){
						NodeList sequenceNodes = n.getChildNodes();
						for(int k=0; k<sequenceNodes.getLength(); k++){
							Node sequenceNode = sequenceNodes.item(k);
							if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
								NodeList elements = sequenceNode.getChildNodes();
								for(int j=0; j<elements.getLength(); j++){
									Node elementType = elements.item(j);
									if(elementType.getNodeName().equals("xsd:element")){
										NamedNodeMap attributesT = elementType.getAttributes();
										Node attributeType = attributesT.getNamedItem("type");
										String type = attributeType.getTextContent();
										String t = type.substring(4);
										Node attributeN = attributesT.getNamedItem("name");
										String name = attributeN.getTextContent();
										t = name + " (type: " + t +")";
										typesList.add(t);
										log.debug("Added as input: "+t);
									} else if(elementType.getNodeName().equals("xs:element")){
										NamedNodeMap attributesT = elementType.getAttributes();
										Node attributeType = attributesT.getNamedItem("type");
										String type = attributeType.getTextContent();
										String t = type.substring(3);
										Node attributeN = attributesT.getNamedItem("name");
										String name = attributeN.getTextContent();
										t = name + " (type: " + t +")";
										typesList.add(t);
										log.debug("Added as input: "+t);
									} else if(elementType.getNodeName().equals("element")){
										NamedNodeMap attributesT = elementType.getAttributes();
										Node attributeType = attributesT.getNamedItem("type");
										String type = attributeType.getTextContent();
										Node attributeN = attributesT.getNamedItem("name");
										String name = attributeN.getTextContent();
										type = name + " (type: " + type +")";
										typesList.add(type);
										log.debug("Added as input: "+type);
									}
								}
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			log.debug(e);
		} catch (SAXException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}

		return typesList;
	}
	
	private String getOutputTypeSchema(String location, String operation){
		String type = "";

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(location);

			Element element = doc.getDocumentElement();
			NodeList childNodes = element.getChildNodes();

			for(int i=0; i<childNodes.getLength(); i++){
				Node n = childNodes.item(i);
				if(n.getNodeName().equals("xs:complexType") || n.getNodeName().equals("xsd:complexType")){
					NamedNodeMap attributes = n.getAttributes();
					Node attributeName = attributes.getNamedItem("name");
					if(attributeName.getTextContent().equals(operation+"Response")){
						NodeList sequenceNodes = n.getChildNodes();
						for(int k=0; k<sequenceNodes.getLength(); k++){
							Node sequenceNode = sequenceNodes.item(k);
							if(sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("xsd:sequence")){
								NodeList elements = sequenceNode.getChildNodes();
								for(int j=0; j<elements.getLength(); j++){
									Node elementType = elements.item(j);
									if(elementType.getNodeName().equals("xs:element")){
										NamedNodeMap attributesT = elementType.getAttributes();
										Node attributeType = attributesT.getNamedItem("type");
										String t = attributeType.getTextContent();
										Node attributeN = attributesT.getNamedItem("name");
										String name = attributeN.getTextContent();
										type = name + " (type: " + t.substring(3) +")";
									} else if(elementType.getNodeName().equals("xsd:element")){
										NamedNodeMap attributesT = elementType.getAttributes();
										Node attributeType = attributesT.getNamedItem("type");
										String t = attributeType.getTextContent();
										Node attributeN = attributesT.getNamedItem("name");
										String name = attributeN.getTextContent();
										type = name + " (type: " + t.substring(4) +")";
									}
								}
							}
						}
					}
				} else if(n.getNodeName().equals("xsd:element") || n.getNodeName().equals("xs:element") || n.getNodeName().equals("element")){
					NamedNodeMap attributes = n.getAttributes();
					Node attributeName = attributes.getNamedItem("name");
					if(attributeName.getTextContent().equals(operation+"ResponseElement")){
						NodeList complexList = n.getChildNodes();
						for(int l=0; l<complexList.getLength(); l++){
							Node complexNode = complexList.item(l);
							NodeList sequenceNodes = complexNode.getChildNodes();
							for(int k=0; k<sequenceNodes.getLength(); k++){
								Node sequenceNode = sequenceNodes.item(k);
								if(sequenceNode.getNodeName().equals("xsd:sequence") || sequenceNode.getNodeName().equals("xs:sequence") || sequenceNode.getNodeName().equals("sequence")){
									NodeList elements = sequenceNode.getChildNodes();
									for(int j=0; j<elements.getLength(); j++){
										Node elementType = elements.item(j);
										if(elementType.getNodeName().equals("xsd:element")){
											NamedNodeMap attributesT = elementType.getAttributes();
											Node attributeType = attributesT.getNamedItem("type");
											String t = attributeType.getTextContent();
											Node attributeN = attributesT.getNamedItem("name");
											String name = attributeN.getTextContent();
											type = name + " (type: " + t.substring(4) +")";
										} else if(elementType.getNodeName().equals("xs:element")){
											NamedNodeMap attributesT = elementType.getAttributes();
											Node attributeType = attributesT.getNamedItem("type");
											String t = attributeType.getTextContent();
											Node attributeN = attributesT.getNamedItem("name");
											String name = attributeN.getTextContent();
											type = name + " (type: " + t.substring(3) +")";
										} else if(elementType.getNodeName().equals("element")){
											NamedNodeMap attributesT = elementType.getAttributes();
											Node attributeType = attributesT.getNamedItem("type");
											Node attributeN = attributesT.getNamedItem("name");
											String name = attributeN.getTextContent();
											type = name + " (type: " + attributeType.getTextContent() +")";
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			log.debug(e);
		} catch (SAXException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}

		return type;
	}

}
