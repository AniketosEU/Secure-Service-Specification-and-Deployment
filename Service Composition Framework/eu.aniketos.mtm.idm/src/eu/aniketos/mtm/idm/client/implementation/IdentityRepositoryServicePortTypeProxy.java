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
package eu.aniketos.mtm.idm.client.implementation;

public class IdentityRepositoryServicePortTypeProxy implements eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType {
  private String _endpoint = null;
  private eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType identityRepositoryServicePortType = null;
  
  public IdentityRepositoryServicePortTypeProxy() {
    _initIdentityRepositoryServicePortTypeProxy();
  }
  
  public IdentityRepositoryServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initIdentityRepositoryServicePortTypeProxy();
  }
  
  private void _initIdentityRepositoryServicePortTypeProxy() {
    try {
      identityRepositoryServicePortType = (new eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServiceLocator()).getIdentityRepositoryServicePort();
      if (identityRepositoryServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)identityRepositoryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)identityRepositoryServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (identityRepositoryServicePortType != null)
      ((javax.xml.rpc.Stub)identityRepositoryServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public eu.aniketos.mtm.idm.client.implementation.IdentityRepositoryServicePortType getIdentityRepositoryServicePortType() {
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType;
  }
  
  public eu.aniketos.mtm.idm.client.implementation.EntityId isAuthenticatedEntity(java.lang.String arg0) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.isAuthenticatedEntity(arg0);
  }
  
  public boolean createGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.createGroup(arg0, arg1);
  }
  
  public boolean registerEntity(java.lang.String arg0, java.lang.String arg1, eu.aniketos.mtm.idm.client.implementation.EntityId arg2) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.registerEntity(arg0, arg1, arg2);
  }
  
  public eu.aniketos.mtm.idm.client.implementation.EntityId authenticateEntity(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.authenticateEntity(arg0, arg1);
  }
  
  public java.lang.String getGroupsOfMember(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.getGroupsOfMember(arg0, arg1);
  }
  
  public java.lang.String getGroupsList(java.lang.String arg0) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.getGroupsList(arg0);
  }
  
  public boolean unregisterEntity(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.unregisterEntity(arg0, arg1);
  }
  
  public boolean deleteGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.deleteGroup(arg0, arg1);
  }
  
  public boolean updateEntity(java.lang.String arg0, java.lang.String arg1, eu.aniketos.mtm.idm.client.implementation.EntityId arg2) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.updateEntity(arg0, arg1, arg2);
  }
  
  public java.lang.String getMembersOfGroup(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (identityRepositoryServicePortType == null)
      _initIdentityRepositoryServicePortTypeProxy();
    return identityRepositoryServicePortType.getMembersOfGroup(arg0, arg1);
  }
  
  
}
