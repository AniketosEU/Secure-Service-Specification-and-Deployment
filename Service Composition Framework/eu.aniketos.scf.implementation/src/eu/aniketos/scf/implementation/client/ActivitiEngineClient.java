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
package eu.aniketos.scf.implementation.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ListIterator;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;


import com.google.gson.Gson;

import eu.aniketos.scf.data.impl.Data;
import eu.aniketos.scf.data.impl.Deployments;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class ActivitiEngineClient {
	
	public static String uploadCompositionPlanToTheActivitiEngine(String compositionPlanPath, String address, String ActivitiEngineUsername, String ActivitiEnginePassword) throws ClientProtocolException, IOException{
		
		String activitiEngineAddress = address;
		URL url = new URL(activitiEngineAddress);
		
		String scheme = url.getProtocol();
		String hostName = url.getHost();
		int port = url.getPort();
	
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpHost targetHost = new HttpHost(hostName, port, scheme);
        
        try {
        	
        	httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                    new UsernamePasswordCredentials(ActivitiEngineUsername, ActivitiEnginePassword));

            // Create AuthCache instance
            AuthCache authCache = new BasicAuthCache();
            // Generate BASIC scheme object and add it to the local
            // auth cache
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(targetHost, basicAuth);

            // Add AuthCache to the execution context
            BasicHttpContext localcontext = new BasicHttpContext();
            localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        	URL url1 = new URL(activitiEngineAddress);
        	String address1 = url1.getProtocol()+"://"+url1.getHost()+":"+url1.getPort();
            HttpPost httppost = new HttpPost(address1+"/activiti-rest/service/deployment");

            FileBody bin = new FileBody(new File(compositionPlanPath));
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("success", new StringBody("success", Charset.forName("UTF-8")));
            reqEntity.addPart("failure", new StringBody("failure", Charset.forName("UTF-8")));
            reqEntity.addPart("deployment", bin);

            httppost.setEntity(reqEntity);

            System.out.println("Executing request " + httppost.getRequestLine());
            HttpResponse response = httpclient.execute(httppost,localcontext);

            System.out.println("Response status: "+response.getStatusLine());
            
            return response.getStatusLine().toString();
            
        } finally {
            try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}
        }
	}

	public static String getActivitiCompositionPlanId(String compositionPlanName, String activitiEngineAddress, String usernameActivitiEngine, String passwordActivitiEngine) throws ClientProtocolException, IOException{

		DefaultHttpClient httpclient = new DefaultHttpClient();
		String compositionPlanId = null;
		URL url = new URL(activitiEngineAddress);
		String scheme = url.getProtocol();
		String hostName = url.getHost();
		int port = url.getPort();
		HttpHost targetHost = new HttpHost(hostName, port, scheme);
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),new UsernamePasswordCredentials(usernameActivitiEngine, passwordActivitiEngine));
		AuthCache authCache = new BasicAuthCache();
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);
		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);

		HttpGet httpget = new HttpGet(activitiEngineAddress + "/activiti-rest/service/process-definitions?start=0");
		HttpResponse responseg = httpclient.execute(httpget,localcontext);
		if (responseg.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ responseg.getStatusLine().getStatusCode());
		}
		BufferedReader brr = new BufferedReader(
				new InputStreamReader((responseg.getEntity().getContent())));

		String output1 = brr.readLine();
		Gson gson = new Gson();
		Deployments deployments = gson.fromJson(output1, Deployments.class);
		List<Data> listDeployments = deployments.getData();
		ListIterator<Data> iterator = listDeployments.listIterator();
		int version = 0;
		while(iterator.hasNext()){
			Data compositionPlan = iterator.next();
			if(compositionPlan.getName().equals(compositionPlanName)){
				if(compositionPlan.getVersion() > version){
					compositionPlanId = compositionPlan.getId();
				}	
			}
		}

		httpclient.getConnectionManager().shutdown();


		return compositionPlanId;
	}
}
	
