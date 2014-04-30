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
package org.activiti.designer.elsag.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.activiti.designer.elsag.Activator;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class ActivitiEngineClient {
	
	public static String uploadDeployment(String filePath) throws ClientProtocolException, IOException{
		
		Properties prop = Activator.getConfigProperties();
		
//		ResourceBundle config = ResourceBundle.getBundle("config");

		String activitiEngineAddress = prop.getProperty("ActivitiEngineAddress");
		URL url = new URL(activitiEngineAddress);
		
		String scheme = url.getProtocol();
		String hostName = url.getHost();
		int port = url.getPort();
	
		DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpHost targetHost = new HttpHost(hostName, port, scheme);
        
        try {
        	
        	httpclient.getCredentialsProvider().setCredentials(
                    new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                    new UsernamePasswordCredentials(prop.getProperty("ActivitiEngineUsername"), prop.getProperty("ActivitiEnginePassword")));

            // Create AuthCache instance
            AuthCache authCache = new BasicAuthCache();
            // Generate BASIC scheme object and add it to the local
            // auth cache
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(targetHost, basicAuth);

            // Add AuthCache to the execution context
            BasicHttpContext localcontext = new BasicHttpContext();
            localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        	
            HttpPost httppost = new HttpPost(activitiEngineAddress+"/activiti-rest/service/deployment");

            FileBody bin = new FileBody(new File(filePath));
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

}
