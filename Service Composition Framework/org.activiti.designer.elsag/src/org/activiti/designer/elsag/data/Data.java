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
package org.activiti.designer.elsag.data;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import eu.aniketos.scf.data.impl.Service;

/**
 * Class containing the static objects used to dynamically store the generated fields.
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class Data {
	
	public static final int AUTHTRUE = 0;
	public static final int AUTHFALSE = 1;
	public static final int AUTHERROR = 2;
	
	public static List<String> compositionPlans;

	/**
	 * Hashtable with key the processId and value an hashTable (key=taskId, value=set of discovered services)
	 */
	public static Hashtable<String,Hashtable<String,Set<Service>>> hashTableLocationsProcess;
	
	/**
	 *  Hashtable with key the processId and value an hashTable (key=taskId, value=typeValue)
	 */
	public static Hashtable<String,Hashtable<String,String>> hashTableFieldProcess;
	
	/**
	 * Hashtable with key the processId and value and hashTable (key=taskId, value=hashTable(key=operationName+inputType+"O"+outputType, value=set of discovered services) 
	 */
	public static Hashtable<String,Hashtable<String,Hashtable<String,Set<Service>>>> hashTableTaskOperationsProcess;

	/**
	 * Hashtable with key the processId and value and hashTable (key=taskId, value=hashTable(key=operationName, value=input types)) 
	 */
	public static Hashtable<String,Hashtable<String,Hashtable<String,List<List<String>>>>> hashTableTaskOperationInputTypeProcess;
	
	/**
	 * Hashtable with key the processId and value and hashTable (key=taskId, value=hashTable(key=operationName, value=output types)) 
	 */
	public static Hashtable<String,Hashtable<String,Hashtable<String,List<String>>>> hashTableTaskOperationOutputTypeProcess;

	/**
	 * Hashtable with key the processId and value and hashTable (key=taskId, value=list of discovered services)
	 */
	public static Hashtable<String,Hashtable<String,List<ServiceDiscovered>>> hashTableTaskOperationProcess;


	/**
	 * Constructor to initialize all the static global variables
	 */
	public Data(){
		compositionPlans = new Vector<String>();
		hashTableFieldProcess = new Hashtable<String,Hashtable<String,String>>();
		hashTableLocationsProcess = new Hashtable<String,Hashtable<String,Set<Service>>>();
		hashTableTaskOperationsProcess = new Hashtable<String,Hashtable<String,Hashtable<String,Set<Service>>>>();
		hashTableTaskOperationInputTypeProcess = new Hashtable<String,Hashtable<String,Hashtable<String,List<List<String>>>>>();
		hashTableTaskOperationOutputTypeProcess = new Hashtable<String,Hashtable<String,Hashtable<String,List<String>>>>();
		hashTableTaskOperationProcess = new Hashtable<String,Hashtable<String,List<ServiceDiscovered>>>();
	}
	


}
