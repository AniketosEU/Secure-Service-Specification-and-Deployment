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
 * IdentityRepositoryServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package eu.aniketos.mtm.idm.client.implementation;

public interface IdentityRepositoryServicePortType extends java.rmi.Remote {
    public eu.aniketos.mtm.idm.client.implementation.EntityId isAuthenticatedEntity(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean createGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean registerEntity(java.lang.String arg0, java.lang.String arg1, eu.aniketos.mtm.idm.client.implementation.EntityId arg2) throws java.rmi.RemoteException;
    public eu.aniketos.mtm.idm.client.implementation.EntityId authenticateEntity(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String getGroupsOfMember(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String getGroupsList(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean unregisterEntity(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean deleteGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean updateEntity(java.lang.String arg0, java.lang.String arg1, eu.aniketos.mtm.idm.client.implementation.EntityId arg2) throws java.rmi.RemoteException;
    public java.lang.String getMembersOfGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
