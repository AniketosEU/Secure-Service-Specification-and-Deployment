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

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import eu.aniketos.mtm.idm.client.IdMClient;
import eu.aniketos.mtm.idm.model.idm.IdmType;
import eu.aniketos.mtm.idm.model.idm.Roles;
import eu.aniketos.mtm.idm.model.idm.TypeType;
import eu.aniketos.mtm.idm.model.idm.Users;

public class IdMClientImplementation implements IdMClient {

	// Resource Set for handling models
	private ResourceSet rs = new ResourceSetImpl();
	private IdmType idmType = null;
	private String path = null;
	boolean mock = false;
	private List<String> humanRoles = new ArrayList<String>();
	private List<String> serviceRoles = new ArrayList<String>();
	private Map<String, List<String>> membersMap = new HashMap<String, List<String>>();	
	
	private IdentityRepositoryServicePortType portType;

//	public IdMClientImplementation(boolean mock) {
//		this.mock = mock;
//		if(mock){
//			initializeData();
//		}
//		else{
//			IdentityRepositoryServiceLocator serviceLocator = new IdentityRepositoryServiceLocator();
//			try {
//				portType =  serviceLocator.getIdentityRepositoryServicePort();
//			} catch (ServiceException e) {
//				e.printStackTrace();
//			}
//		}	
//			
//	}
	
	public IdMClientImplementation(String path) {
		this.path = path;
		if(!path.equals("")){
			initializeData();
			mock = true;
		}
		else{
			IdentityRepositoryServiceLocator serviceLocator = new IdentityRepositoryServiceLocator();
			try {
				portType =  serviceLocator.getIdentityRepositoryServicePort();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}	
			
	}

	private void initializeData() {
		if(loadIdMModel()){
			for (Roles roles : idmType.getRoles()) {
				if(roles.getType().equals(TypeType.HUMAN)){
					for (String value : roles.getValue()) {
						humanRoles.add(value);
					}
				}
				if(roles.getType().equals(TypeType.SERVICES)){
					for (String value : roles.getValue()) {
						serviceRoles.add(value);
					}
				}
			}
			for (Users users : idmType.getUsers()) {
				String role = users.getRole();
				if(humanRoles.contains(role) || serviceRoles.contains(role)){
					List<String> values = new ArrayList<String>();
					for (String value : users.getValue()) {
						values.add(value);
					}
					membersMap.put(role, values);
				}
			}
		}
	}
	
	private boolean loadIdMModel() {
		if (this.path == null || path.equals("")) {
			return false;
		}
		try {
			Resource r = rs.getResource(URI.createFileURI(path), true);
			if (r == null) {
				return false;
			}
			TreeIterator<EObject> i = r.getAllContents();
			while (i.hasNext()) {
				EObject o = i.next();
				if (o instanceof IdmType) {
					idmType = (IdmType) o;
					break;
				}
			}
		}
		catch (Exception e) {
			return false;
		}
		
		return (idmType != null);
	}
	
//	private void initializeData() {
//		humanRoles = new ArrayList<String>(Arrays.asList("Manager", "Supervisor", "Clerk"));
//		serviceRoles = new ArrayList<String>(Arrays.asList("GeoLocatorService", "TravellerService", "MapService", "PaymentService"));
//		List<String> userlist1 = new ArrayList<String>(Arrays.asList("Mike", "Kate", "John", "Sarah"));
//		List<String> userlist2 = new ArrayList<String>(Arrays.asList("Sam", "Stefan", "Anna", "Jane"));
//		List<String> userlist3 = new ArrayList<String>(Arrays.asList("Adam", "Daniel", "Joan", "Karen", "Sam"));
//		membersMap.put(humanRoles.get(0), userlist1);
//		membersMap.put(humanRoles.get(1), userlist2);
//		membersMap.put(humanRoles.get(2), userlist3);		
//		
//		List<String> servicelist1 = new ArrayList<String>(Arrays.asList("IPGeo", "GeoLocatorService"));
//		List<String> servicelist2 = new ArrayList<String>(Arrays.asList("Amadeus", "Yahoo"));
//		List<String> servicelist3 = new ArrayList<String>(Arrays.asList("Google", "Bing", "Yahoo"));
//		List<String> servicelist4 = new ArrayList<String>(Arrays.asList("Google Wallet", "Paypal"));
//		membersMap.put(serviceRoles.get(0), servicelist1);
//		membersMap.put(serviceRoles.get(1), servicelist2);
//		membersMap.put(serviceRoles.get(2), servicelist3);	
//		membersMap.put(serviceRoles.get(3), servicelist4);			
//	}

	@Override
	public String getGroupsListOfHuman() {
		if(mock){
			return toString(humanRoles);
		}
		try {
			return portType.getGroupsList(PERFORMERTYPE_HUMAN);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getGroupsListOfService() {
		if(mock){
			return toString(serviceRoles);
		}
		try {
			return portType.getGroupsList(PERFORMERTYPE_SERVICE);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getMembersOfGroup(String group, String performertype) {
		if(mock){
			return toString(membersMap.get(group));
		}
		try {
			return portType.getMembersOfGroup(performertype, group);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getMembersOfHumanGroup(String group) {
		return getMembersOfGroup(group, PERFORMERTYPE_HUMAN);
	}

	@Override
	public String getMembersOfServiceGroup(String group) {
		return getMembersOfGroup(group, PERFORMERTYPE_SERVICE);
	}

	
	@Override
	public String getGroupsOfMember(String member, String performertype) {
		if(mock){
			return toString(findGroupsOfMember(member));
		}
		try {
			return portType.getGroupsOfMember(performertype, member);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String toString (List<String> list){
		String string = "";
		for (String e : list) {
			if(string.equals("")){
				string = e;
			}
			else{
				string = string + "," + e;
			}			
		}
		return string;
	}
	
	private List<String> findGroupsOfMember (String member){
		List<String> groups = new ArrayList<String>();
		for (String group : membersMap.keySet()) {
			List<String> list = membersMap.get(group);
			for (String memb : list) {
				if(memb.equals(member)){
					groups.add(group);
				}
			}
		}
		return groups;
	}

	
}
