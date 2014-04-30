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
package eu.aniketos.scf.implementation;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import eu.aniketos.scf.implementation.client.TomcatClient;
import eu.aniketos.scf.implementation.util.FileOperations;
import eu.aniketos.scf.implementation.util.War;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class CompositeServiceFactory {
	
	final private static Logger log = Logger.getLogger(CompositeServiceFactory.class);

	public static boolean createServiceInstance(String compositionPlanId, String compositionPlanName, String activitiEngineAddress, String usernameActivitiEngine, String passwordActivitiEngine){
		
		new java.io.File(compositionPlanName + "/").mkdir();
		new java.io.File(compositionPlanName + "/WEB-INF").mkdir();
		new java.io.File(compositionPlanName + "/WEB-INF/classes").mkdir();
		new java.io.File(compositionPlanName + "/WEB-INF/lib").mkdir();
		
		java.io.File serviceInterface  = new java.io.File(compositionPlanName + "/" + compositionPlanName + ".java");
		java.io.File serviceImplementation  = new java.io.File(compositionPlanName + "/" + compositionPlanName + "Impl.java");
		
		try 
		{
			FileWriter serviceInterfaceFW = new FileWriter(serviceInterface);
			
			serviceInterfaceFW.write(
				"package eu.aniketos.compositeService;\n" +
				"import javax.jws.WebService;\n" +
				"@WebService\n" +
				"public interface " + compositionPlanName + "{\n" +
				"void start" + compositionPlanName +"();\n" + "}\n"
		    ); 
			serviceInterfaceFW.close();
		    
		    FileWriter serviceImplementationFW = new FileWriter(serviceImplementation);
		    serviceImplementationFW.write(
				"package eu.aniketos.compositeService;\n" +
				"import javax.jws.WebService;\n" +
				"import java.net.URL;\n" +
				"import org.apache.http.HttpHost;\n" +
				"import org.apache.http.HttpResponse;\n" +
				"import org.apache.http.auth.AuthScope;\n" +
				"import org.apache.http.auth.UsernamePasswordCredentials;\n" +
				"import org.apache.http.client.AuthCache;\n" +
				"import org.apache.http.client.ClientProtocolException;\n" +
				"import org.apache.http.client.methods.HttpPost;\n" +
				"import org.apache.http.client.protocol.ClientContext;\n" +
				"import org.apache.http.entity.mime.MultipartEntity;\n" +
				"import org.apache.http.entity.mime.content.FileBody;\n" +
				"import org.apache.http.entity.mime.content.StringBody;\n" +
				"import org.apache.http.impl.auth.BasicScheme;\n" +
				"import org.apache.http.impl.client.BasicAuthCache;\n" +
				"import org.apache.http.impl.client.DefaultHttpClient;\n" +
				"import org.apache.http.protocol.BasicHttpContext;\n" +
				"import org.apache.http.entity.StringEntity;\n" +
				"import java.io.IOException;\n" +
				"import java.io.IOException;\n" +
				"@WebService(endpointInterface = \"eu.aniketos.compositeService." + compositionPlanName + "\")\n" +
				"public class " + compositionPlanName + "Impl implements " + compositionPlanName + " {\n" +
				"public void start" + compositionPlanName +"() {\n" +
				"DefaultHttpClient httpclient = new DefaultHttpClient();\n" +
				"try {\n" +
				"URL url = new URL(\"" + activitiEngineAddress + "\");\n" +
				"String scheme = url.getProtocol();\n" +
				"String hostName = url.getHost();\n" +
				"int port = url.getPort();\n" +
		        "HttpHost targetHost = new HttpHost(hostName, port, scheme);\n" +
		        "httpclient.getCredentialsProvider().setCredentials(\n" +
		        "new AuthScope(targetHost.getHostName(), targetHost.getPort()),new UsernamePasswordCredentials(\"" + usernameActivitiEngine + "\", \"" + passwordActivitiEngine + "\"));\n" +
		        "AuthCache authCache = new BasicAuthCache();\n" +
		        "BasicScheme basicAuth = new BasicScheme();\n" +
		        "authCache.put(targetHost, basicAuth);\n" +
		        "BasicHttpContext localcontext = new BasicHttpContext();\n" +
		        "localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);\n" +
		        "HttpPost httpPost = new HttpPost(\"" + activitiEngineAddress + "/activiti-rest/service/process-instance\");\n" +
		        "StringEntity input = new StringEntity(\"{\\\"processDefinitionId\\\":\\\"" + compositionPlanId + "\\\"}\");\n" +
				"input.setContentType(\"application/json\");\n" +
				"httpPost.setEntity(input);\n" + 
				"HttpResponse response = httpclient.execute(httpPost, localcontext);\n" +
				"} catch (ClientProtocolException e) {\n" +
				"e.printStackTrace();\n" +
				"} catch (IOException e) {\n" +
				"e.printStackTrace();\n" +
				"} finally {\n" +
				"try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}\n" +
        		"}\n" +
				"}\n" +
				"}"
		    );
		    serviceImplementationFW.close();
		    
		    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

		    fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new java.io.File(compositionPlanName + "/WEB-INF/classes")));
		    
		    URL urlHttpclient = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("lib/httpclient-4.2.jar")));
		    URL urlHttpcore = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("lib/httpcore-4.2.jar")));
		    URL urlHttpmime = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("lib/httpmime-4.2.jar")));
		    
		    fileManager.setLocation(StandardLocation.CLASS_PATH, Arrays.asList(new java.io.File(urlHttpmime.getPath()), new java.io.File(urlHttpclient.getPath()), new java.io.File(urlHttpcore.getPath()), new java.io.File(compositionPlanName + "/WEB-INF/classes")));
		    // Compile the interface java file of the composition instance
		    compiler.getTask(null, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Arrays.asList(serviceInterface))).call();
		    
		    // Compile the implementation java file of the composition instance
		    compiler.getTask(null, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Arrays.asList(serviceImplementation))).call();
		    fileManager.close();
		    
		    serviceInterface.delete();
		    serviceImplementation.delete();
		 
		    log.debug("Service Instance created");
		 
		    return true;
		} 
		catch (IOException IOE) 
		{
			log.error("IOException",IOE);
			return false;
		} 
		
	}

	public static boolean createWar(String compositionPlanName){

		try {
			URL urlWebXml = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("resources/web.xml")));
			java.io.File webXmlResources = new java.io.File(urlWebXml.getPath());
			java.io.File webXmlWar = new java.io.File(compositionPlanName + "/WEB-INF/web.xml");

			URL urlSunXml = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("resources/sun-jaxws.xml")));
			java.io.File sunXmlResources = new java.io.File(urlSunXml.getPath());
			java.io.File sunXmlWar = new java.io.File(compositionPlanName + "/WEB-INF/sun-jaxws.xml");


			FileOperations.copyFile(webXmlResources, webXmlWar);
			FileOperations.copyFile(sunXmlResources, sunXmlWar);

			modifySunXmlFile(compositionPlanName);

			//copy lib directory
			java.io.File dirTarget = new java.io.File(compositionPlanName + "/WEB-INF/lib");
			URL url = org.eclipse.core.runtime.FileLocator.toFileURL((Activator.getContext().getBundle().getEntry("resources/lib/")));

			java.io.File dirSource = new java.io.File(url.getPath());
			FileOperations.copyDirectory(dirSource, dirTarget);

			War.warFolder(compositionPlanName + "/WEB-INF/", compositionPlanName + ".war");

			log.debug("WAR file created");
			return true;
			
		} catch (Exception E) {
			log.error("Exception",E);
			log.debug("WAR file not created");
			return false;
		}	
	}

	private static void modifySunXmlFile(String compositionPlanName) throws JDOMException, IOException{	
		// Istantiating a not validating XML parser 
		SAXBuilder builder = new SAXBuilder(false);

		// creating a DOM structure into the memory starting from the XML file

		Document document = builder.build(new java.io.File(compositionPlanName + "/WEB-INF/sun-jaxws.xml"));

		Element root = document.getRootElement();
		Namespace ns = root.getNamespace("http://java.sun.com/xml/ns/jax-ws/ri/runtime");

		Element endpoint = root.getChild("endpoint",ns);
		endpoint.setAttribute("implementation", "eu.aniketos.compositeService." + compositionPlanName + "Impl");
		endpoint.setAttribute("name", compositionPlanName);

		XMLOutputter outputter = new XMLOutputter(); 
		outputter.setFormat(Format.getPrettyFormat());
		FileOutputStream fos = new FileOutputStream(compositionPlanName + "/WEB-INF/sun-jaxws.xml");
		outputter.output(document, fos); 
		fos.close();
		
		log.debug("File sun-jaxws.xml modified");
	}
	
	public static boolean deployWarTomcat(String compositionPlanName, String tomcatAddress, String usernameTomcat, String passwordTomcat){
	
		String response = TomcatClient.deployWar(compositionPlanName, tomcatAddress, usernameTomcat, passwordTomcat);
		if(response.contains("OK")){
			log.debug("WAR file deployed");
			return true;
		} else {
			log.debug("WAR file not deployed");
			return false;
		}
		
		
	}

}
