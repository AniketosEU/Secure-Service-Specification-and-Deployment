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
package eu.aniketos.scf.data.impl;

import java.util.List;

import eu.aniketos.marketplace.ServiceOperation;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class Service {
	
	private String serviceId;
	
	private String location;
	
	private String provider;
	
	private List<ServiceOperation> operations;
	
	public Service(String serviceId, String location, String provider, List<ServiceOperation> operations) {
		this.serviceId = serviceId;
		this.location = location;
		this.provider = provider;
		this.operations = operations;
	}

	public Service(String serviceId, String location){
		this.serviceId = serviceId;
		this.location = location;
	}
	
	public Service(){
	}

	public String getServiceId(){
		return serviceId;
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setServiceId(String serviceId){
		this.serviceId = serviceId;
	}
	
	public void setLocation(String locations){
		this.location = locations;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public List<ServiceOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<ServiceOperation> operations) {
		this.operations = operations;
	}

}
