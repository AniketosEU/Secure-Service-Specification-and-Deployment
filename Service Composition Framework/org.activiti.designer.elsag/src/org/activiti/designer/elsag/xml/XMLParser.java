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
package org.activiti.designer.elsag.xml;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class XMLParser {
	
	final private static Logger log = Logger.getLogger(XMLParser.class);


	public static List<String> getServicesList(String file){
		log.debug("Getting services list");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(file.getBytes("UTF-8"));
			doc = (Document) builder.build(is);
			
		} catch (UnsupportedEncodingException e) {
			log.debug(e);
		} catch (JDOMException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		
		Element definitions = doc.getRootElement();
		
		Namespace n = definitions.getNamespace();
		Element process = definitions.getChild("process", n);
		
		@SuppressWarnings("unchecked")
		List<Element> list = process.getChildren("serviceTask", n);
		
		List<String> serviceList = new Vector<String>();
		
		for(Element serviceTask : list){
			serviceList.add(serviceTask.getAttribute("id").getValue());
		}
		
		return serviceList;
	}
	
	public static String getOperation(String file, String taskId){
		log.debug("Getting operation");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(file.getBytes("UTF-8"));
			doc = (Document) builder.build(is);
			
		} catch (UnsupportedEncodingException e) {
			log.debug(e);
		} catch (JDOMException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		
		Element definitions = doc.getRootElement();
		
		Namespace n = definitions.getNamespace();
		Element process = definitions.getChild("process", n);

		@SuppressWarnings("unchecked")
		List<Element> listServiceTask = process.getChildren("serviceTask", n);

		String result = "";

		for(Element serviceTask: listServiceTask){
			if(serviceTask.getAttribute("id").getValue().equals(taskId)){
				Element extensionElements = serviceTask.getChild("extensionElements", n);
				
				Namespace ns = Namespace.getNamespace("activiti", "http://activiti.org/bpmn");
				@SuppressWarnings("unchecked")
				List<Element> fields = extensionElements.getChildren("field",ns);
				for(Element field : fields){
					if(field.getAttribute("name").getValue().equals("operation")){
						result = field.getChild("string",ns).getText();
					}
				}
			}

		}
		return result;
	}

	public static void addIntegrityPropertyToBPMN(String file, String taskId, String type, String with, String algorithm){
		log.debug("Adding integrity property to the BPMN");
		
		String serviceSpecification = "";
		try{
			serviceSpecification = convertXMLFileToString(file);
		}catch(IOException e){
			e.printStackTrace();
		}

		SAXBuilder builder = new SAXBuilder();
		
		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(serviceSpecification.getBytes("UTF-8"));
			doc = (Document) builder.build(is);
			
		} catch (UnsupportedEncodingException e) {
			log.debug(e);
		} catch (JDOMException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		
		Element definitions = doc.getRootElement();
		List<?> namespaces = definitions.getAdditionalNamespaces();
		Namespace ns = Namespace.getNamespace("aniketos", "http://aniketos.eu");
		if(!namespaces.contains(ns)){
			definitions.addNamespaceDeclaration(ns);
		}
		Namespace n = definitions.getNamespace();
		Element process = definitions.getChild("process", n);

		@SuppressWarnings("unchecked")
		List<Element> listServiceTask = process.getChildren("serviceTask", n);
		
		for(Element serviceTask: listServiceTask){
			if(serviceTask.getAttribute("id").getValue().equals(taskId)){
				Element extensionElements = serviceTask.getChild("extensionElements", n);
				if(extensionElements == null){
					extensionElements = new Element("extensionElements", n);
					serviceTask.addContent(extensionElements);
				}
				Element security = extensionElements.getChild("security", ns);
				if(security == null){
					security = new Element("security", ns);
					extensionElements.addContent(security);
					Element integrity = new Element("integrity", ns);
					integrity.setAttribute("type", type);
					integrity.setAttribute("with", with);
					integrity.setAttribute("algorithm", algorithm);
					security.addContent(integrity);
				} else {
					Element integrity = security.getChild("integrity", ns);
					if(integrity == null){
						integrity = new Element("integrity", ns);
						integrity.setAttribute("type", type);
						integrity.setAttribute("with", with);
						integrity.setAttribute("algorithm", algorithm);
						security.addContent(integrity);
					} else {
						integrity.setAttribute("type", type);
						integrity.setAttribute("with", with);
						integrity.setAttribute("algorithm", algorithm);
					}
				}
				
			}
		}
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(doc, new FileWriter(file));
		} catch (IOException e) {
			log.debug(e);
		}
	}
	
	public static String[] getIntegrityInfo(String file, String taskId){
		log.debug("Getting integrity info");
		
		String serviceSpecification = "";
		try{
			serviceSpecification = convertXMLFileToString(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(serviceSpecification.getBytes("UTF-8"));
			doc = (Document) builder.build(is);
			
		} catch (UnsupportedEncodingException e) {
			log.debug(e);
		} catch (JDOMException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		
		Element definitions = doc.getRootElement();
		Namespace ns = Namespace.getNamespace("aniketos", "http://aniketos.eu");
		Namespace n = definitions.getNamespace();
		Element process = definitions.getChild("process", n);

		@SuppressWarnings("unchecked")
		List<Element> listServiceTask = process.getChildren("serviceTask", n);
		String[] info = new String[3];
		for(Element serviceTask: listServiceTask){
			if(serviceTask.getAttribute("id").getValue().equals(taskId)){
				Element extensionElements = serviceTask.getChild("extensionElements", n);
				if(extensionElements != null){
					Element security = extensionElements.getChild("security", ns);
					if(security == null)
						return null;
					Element integrity = security.getChild("integrity", ns);
					if(integrity == null)
						return null;
					
					@SuppressWarnings("unused")
					Attribute type = integrity.getAttribute("type");
					@SuppressWarnings("unused")
					Attribute with = integrity.getAttribute("with");
					@SuppressWarnings("unused")
					Attribute algorithm = integrity.getAttribute("algorithm");;
					info[0] = integrity.getAttributeValue("type");
					info[1] = integrity.getAttributeValue("with");
					info[2] = integrity.getAttributeValue("algorithm");
				} else {
					return null;
				}
			}
		}
		return info;
		
		
	}
	
	public static String convertXMLFileToString(String fileName) throws IOException {
		log.debug("Converting the XML file "+ fileName +" to string");
		try{
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			InputStream inputStream = new FileInputStream(new File(fileName));
			org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
			StringWriter stw = new StringWriter();
			Transformer serializer = TransformerFactory.newInstance().newTransformer();
			serializer.transform(new DOMSource(doc), new StreamResult(stw));
			return stw.toString();
		} catch (SAXException e) {
			log.debug(e);
		} catch (ParserConfigurationException e) {
			log.debug(e);
		} catch (TransformerConfigurationException e) {
			log.debug(e);
		} catch (TransformerFactoryConfigurationError e) {
			log.debug(e);
		} catch (TransformerException e) {
			log.debug(e);
		}
		return null;
	}
	
	public static String getProcessId(String file){
		log.debug("Getting the process id");
		
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(file.getBytes("UTF-8"));
			doc = (Document) builder.build(is);
			
		} catch (UnsupportedEncodingException e) {
			log.debug(e);
		} catch (JDOMException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		
		Element definitions = doc.getRootElement();
		
		Namespace n = definitions.getNamespace();
		String compositionPlanId = null;
		if(definitions.getChild("process", n)!=null){
			Element process = definitions.getChild("process", n);
			compositionPlanId = process.getAttribute("id").getValue();
		}
		
		return compositionPlanId;
	}

}
