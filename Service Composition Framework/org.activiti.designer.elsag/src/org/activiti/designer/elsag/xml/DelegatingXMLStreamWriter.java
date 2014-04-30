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

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


/**
* Delegating {@link XMLStreamWriter}.
*
* @author Kohsuke Kawaguchi
*/
abstract class DelegatingXMLStreamWriter implements XMLStreamWriter {
  
   private final XMLStreamWriter writer;

   public DelegatingXMLStreamWriter(XMLStreamWriter writer) {
       this.writer = writer;
   }

   public void writeStartElement(String localName) throws XMLStreamException {
       writer.writeStartElement(localName);
   }

   public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
       writer.writeStartElement(namespaceURI, localName);
   }

   public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
       writer.writeStartElement(prefix, localName, namespaceURI);
   }

   public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
       writer.writeEmptyElement(namespaceURI, localName);
   }

   public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
       writer.writeEmptyElement(prefix, localName, namespaceURI);
   }

   public void writeEmptyElement(String localName) throws XMLStreamException {
       writer.writeEmptyElement(localName);
   }

   public void writeEndElement() throws XMLStreamException {
       writer.writeEndElement();
   }

   public void writeEndDocument() throws XMLStreamException {
       writer.writeEndDocument();
   }

   public void close() throws XMLStreamException {
       writer.close();
   }

   public void flush() throws XMLStreamException {
       writer.flush();
   }

   public void writeAttribute(String localName, String value) throws XMLStreamException {
       writer.writeAttribute(localName, value);
   }

   public void writeAttribute(String prefix, String namespaceURI, String localName, String value) throws XMLStreamException {
       writer.writeAttribute(prefix, namespaceURI, localName, value);
   }

   public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
       writer.writeAttribute(namespaceURI, localName, value);
   }

   public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
       writer.writeNamespace(prefix, namespaceURI);
   }

   public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
       writer.writeDefaultNamespace(namespaceURI);
   }

   public void writeComment(String data) throws XMLStreamException {
       writer.writeComment(data);
   }

   public void writeProcessingInstruction(String target) throws XMLStreamException {
       writer.writeProcessingInstruction(target);
   }

   public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
       writer.writeProcessingInstruction(target, data);
   }

   public void writeCData(String data) throws XMLStreamException {
       writer.writeCData(data);
   }

   public void writeDTD(String dtd) throws XMLStreamException {
       writer.writeDTD(dtd);
   }

   public void writeEntityRef(String name) throws XMLStreamException {
       writer.writeEntityRef(name);
   }

   public void writeStartDocument() throws XMLStreamException {
       writer.writeStartDocument();
   }

   public void writeStartDocument(String version) throws XMLStreamException {
       writer.writeStartDocument(version);
   }

   public void writeStartDocument(String encoding, String version) throws XMLStreamException {
       writer.writeStartDocument(encoding, version);
   }

   public void writeCharacters(String text) throws XMLStreamException {
       writer.writeCharacters(text);
   }

   public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
       writer.writeCharacters(text, start, len);
   }

   public String getPrefix(String uri) throws XMLStreamException {
       return writer.getPrefix(uri);
   }

   public void setPrefix(String prefix, String uri) throws XMLStreamException {
       writer.setPrefix(prefix, uri);
   }

   public void setDefaultNamespace(String uri) throws XMLStreamException {
       writer.setDefaultNamespace(uri);
   }

   public void setNamespaceContext(NamespaceContext context) throws XMLStreamException {
       writer.setNamespaceContext(context);
   }

   public NamespaceContext getNamespaceContext() {
       return writer.getNamespaceContext();
   }

   public Object getProperty(String name) throws IllegalArgumentException {
       return writer.getProperty(name);
   }
}
