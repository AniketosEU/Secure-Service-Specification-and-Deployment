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
/**
 * IdentityRepositoryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eu.aniketos.mtm.idm.client.implementation;

public class IdentityRepositoryServiceLocator extends org.apache.axis.client.Service implements eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryService {

    public IdentityRepositoryServiceLocator() {
    }


    public IdentityRepositoryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IdentityRepositoryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IdentityRepositoryServicePort
    private java.lang.String IdentityRepositoryServicePort_address = "http://138.132.162.67:9091/identity";

    public java.lang.String getIdentityRepositoryServicePortAddress() {
        return IdentityRepositoryServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IdentityRepositoryServicePortWSDDServiceName = "IdentityRepositoryServicePort";

    public java.lang.String getIdentityRepositoryServicePortWSDDServiceName() {
        return IdentityRepositoryServicePortWSDDServiceName;
    }

    public void setIdentityRepositoryServicePortWSDDServiceName(java.lang.String name) {
        IdentityRepositoryServicePortWSDDServiceName = name;
    }

    public eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType getIdentityRepositoryServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IdentityRepositoryServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIdentityRepositoryServicePort(endpoint);
    }

    public eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType getIdentityRepositoryServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServiceSoapBindingStub _stub = new eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIdentityRepositoryServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIdentityRepositoryServicePortEndpointAddress(java.lang.String address) {
        IdentityRepositoryServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServiceSoapBindingStub _stub = new eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServiceSoapBindingStub(new java.net.URL(IdentityRepositoryServicePort_address), this);
                _stub.setPortName(getIdentityRepositoryServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IdentityRepositoryServicePort".equals(inputPortName)) {
            return getIdentityRepositoryServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://idm.aniketos.eu/", "IdentityRepositoryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://idm.aniketos.eu/", "IdentityRepositoryServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IdentityRepositoryServicePort".equals(portName)) {
            setIdentityRepositoryServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
