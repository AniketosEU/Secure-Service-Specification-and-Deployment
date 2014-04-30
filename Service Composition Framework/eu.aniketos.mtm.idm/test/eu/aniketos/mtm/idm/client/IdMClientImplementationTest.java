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
 * 
 */
package eu.aniketos.mtm.idm.client;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation;
import eu.aniketos.mtm.idm.model.idm.DocumentRoot;
import eu.aniketos.mtm.idm.model.idm.IdmFactory;
import eu.aniketos.mtm.idm.model.idm.IdmType;
import eu.aniketos.mtm.idm.model.idm.Roles;
import eu.aniketos.mtm.idm.model.idm.TypeType;
import eu.aniketos.mtm.idm.model.idm.Users;

/**
 * @author Tecnalia
 *
 */
public class IdMClientImplementationTest {
	
	IdMClientImplementation idMClientImplementation;
	String group = "Manager";
	String member = "Yahoo";
	
	
	
	public IdMClientImplementationTest() {
//		idMClientImplementation = new IdMClientImplementation("");
	}

	/**
	 * Test method for {@link eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation#getGroupsList()}.
	 */
	@Test
	public final void testGetGroupsListOfHuman() {
		String groups = idMClientImplementation.getGroupsListOfHuman();
		System.out.println("Groups: "+groups);
	}
	
	/**
	 * Test method for {@link eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation#getGroupsList()}.
	 */
	@Test
	public final void testGetGroupsListOfService() {
		String groups = idMClientImplementation.getGroupsListOfService();
		System.out.println("Groups: "+groups);
	}

	/**
	 * Test method for {@link eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation#getMembersOfGroup(java.lang.String)}.
	 */
	@Test
	public final void testGetMembersOfGroup() {
		String members = idMClientImplementation.getMembersOfGroup(group, IdMClient.PERFORMERTYPE_HUMAN);
		System.out.println("Members: "+members);
	}

	/**
	 * Test method for {@link eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation#getGroupsOfMember(java.lang.String)}.
	 */
	@Test
	public final void testGetGroupsOfMember() {
		String groups = idMClientImplementation.getGroupsOfMember(member, IdMClient.PERFORMERTYPE_HUMAN);
		System.out.println("Groups: "+groups);
	}
	
	@Test
	public void testIdMGeneration(){
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI("C:\\tecnalia" + File.separator + "idm_test" + ".xml"), "idm");
		IdmType idmType = IdmFactory.eINSTANCE.createIdmType();
		
		Roles roles = IdmFactory.eINSTANCE.createRoles();
		roles.setType(TypeType.HUMAN);
		roles.getValue().add("Manager");
		roles.getValue().add("Supervisor");
		idmType.getRoles().add(roles);
		
		Users users = IdmFactory.eINSTANCE.createUsers();
		users.setRole("Manager");
		users.getValue().add("Mike");
		idmType.getUsers().add(users);

		// Add objects to the resource and save
		DocumentRoot root = IdmFactory.eINSTANCE.createDocumentRoot();
		root.setIdm(idmType);
		r.getContents().add(root);
		try {
			r.save(null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
