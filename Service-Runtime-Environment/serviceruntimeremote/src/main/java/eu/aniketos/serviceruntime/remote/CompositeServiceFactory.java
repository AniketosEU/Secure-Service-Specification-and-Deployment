package eu.aniketos.serviceruntime.remote;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.aniketos.serviceruntime.remote.tomcat.TomcatClient;
import eu.aniketos.serviceruntime.remote.tomcat.WarCreator;

/**
 * Factory of composite services
 * @author Kostas Giannakakis
 *
 */
public class CompositeServiceFactory {
	
	/** Logger */
	final private static Logger logger = LoggerFactory.getLogger(CompositeServiceFactory.class);

	/**
	 * Configuration parameters
	 * @author Kostas Giannakakis
	 *
	 */
	public static class Config {
		/** Directory, where compositions will be stored */
		public String compositionsDir;
		
		/** Address of Activiti */
		public String activitiAddress;
		
		/** Username of Activiti's user */
		public String activitiUsername;
		
		/** Password of Activiti's user */
		public String activitiPassword;
		
		/** Tomcat'a address */
		public String tomcatAddress;
		
		/** Tomcat's public address */
		public String tomcatPublicAddress;
		
		/** Username of Tomcat's user */
		public String tomcatUsername;
		
		/** Password of Tomcat's user */
		public String tomcatPassword;
		
		/** Tomcat's version */
		public int tomcatVersion = 6;
	}

	/** Directory where a composition is stored */
	private String compositionsDir;
	
	/** Address of Activiti */
	private String activitiAddress;
	
	/** Username of Activiti's user */
	private String activitiUsername;
	
	/** Password of Activiti's user */
	private String activitiPassword;

	/** Tomcat's client */
	private TomcatClient tomcatClient;
	
	/** Resources directory. It stores all files (jar, xml) that should be included in the WAR */
	private String resoursesDir;
	
	/** Configuration object */
	private Config config;
	
	/**
	 * Constructor
	 * @param config The configuration of the factory
	 */
	public CompositeServiceFactory(Config config) {
		this.config = config;
		compositionsDir = config.compositionsDir;
		activitiAddress = config.activitiAddress;
		activitiUsername = config.activitiUsername;
		activitiPassword = config.activitiPassword;
		
		tomcatClient = new TomcatClient(config.tomcatAddress, 
				config.tomcatUsername, config.tomcatPassword);
		tomcatClient.setTomcatVersion(config.tomcatVersion);
		
		File compositionsDirectory = new File(compositionsDir);
		compositionsDirectory.mkdir();
		
		resoursesDir = compositionsDir + "/resources";
		
		buildResourcesDir();
	}
	
	/**
	 * Creates resources directory (if it doesn't exist) and populates it with 
	 * files from the bundle
	 */
	private void buildResourcesDir() {
		File resDir = new File(resoursesDir);
		if (!resDir.exists()) {
			File libDir = new File(resoursesDir + "/lib");
			if (!libDir.mkdirs()) {
				logger.error("Couldn't create resources lib directory {}", libDir);
				return;
			}
			
			String [] resourceNames = {
					"sun-jaxws.xml", 
					"web.xml",
					"lib/commons-codec-1.6.jar",
					"lib/commons-logging-1.1.1.jar",
					"lib/FastInfoset.jar",
					"lib/fluent-hc-4.2.jar",
					"lib/gmbal-api-only.jar",
					"lib/ha-api.jar",
					"lib/httpclient-4.2.jar",
					"lib/httpclient-cache-4.2.jar",
					"lib/httpcore-4.2.jar",
					"lib/httpmime-4.2.jar",
					"lib/javax.annotation.jar",
					"lib/javax.mail_1.4.jar",
					"lib/jaxb-api.jar",
					"lib/jaxb-impl.jar",
					"lib/jaxb-xjc.jar",
					"lib/jaxws-api.jar",
					"lib/jaxws-rt.jar",
					"lib/jaxws-tools.jar",
					"lib/jsr181-api.jar",
					"lib/management-api.jar",
					"lib/mimepull.jar",
					"lib/policy.jar",
					"lib/saaj-api.jar",
					"lib/saaj-impl.jar",
					"lib/stax-ex.jar",
					"lib/stax2-api.jar",
					"lib/streambuffer.jar",
					"lib/woodstox-core-asl.jar",
                    "lib/datamanager-1.0-SNAPSHOT.jar"
			};
			
			byte [] buffer = new byte[16000]; 
			for(String resourceName: resourceNames) {
				InputStream is = getClass().getResourceAsStream("/resources/" + resourceName);
				OutputStream os = null;
				try {
					os = new FileOutputStream(resDir + "/" + resourceName);					
					int length = 0;					
					while ( (length = is.read(buffer)) > 0) {
						os.write(buffer, 0, length);
					}					
					logger.debug("Copied file {}", resourceName);
				} catch (FileNotFoundException e) {
					logger.error("Error creating file {}: {}", resourceName, e.getMessage());
				} catch (IOException e) {
					logger.error("Error writing to file {}: {}", resourceName, e.getMessage());
				}
				finally {
					try {
						if (is != null) {
							is.close();
						}
						if (os != null) {
							os.close();
						}	
					}
					catch (IOException ex) {
						
					}
				}
				
			}
		}
		else {
			logger.debug("Resources directory exists");
		}
	}
	
	/**
	 * Returns the composition directory
	 * @param compositionPlanName Name of the composition
	 * @return the composition directory
	 */
	private String getCompositionDir(String compositionPlanName) {
		return compositionsDir + "/"  + compositionPlanName;
	}
	
	/**
	 * Returns the path of the WAR file
	 * @param compositionPlanName Name of the composition
	 * @return the path of the WAR file
	 */
	private String getWarPath(String compositionPlanName) {
		return compositionsDir + "/" + compositionPlanName + ".war";
	}	
	
	/**
	 * Creates a service instance
	 * @param compositionPlanName The name of the composition
     * @param processId  The process id of the Activiti process
     * @param methodName The name of the method that invokes the composite service
	 * @return true, if the method succeeds
	 */
	public boolean createServiceInstance(String compositionPlanName,
                                         String processId,
                                         String methodName){
		
		String compositionDir = getCompositionDir(compositionPlanName); 
		
		new File(compositionDir + "/").mkdir();
		new File(compositionDir + "/WEB-INF").mkdir();
		new File(compositionDir + "/WEB-INF/classes").mkdir();
		new File(compositionDir + "/WEB-INF/lib").mkdir();
		
		File serviceInterface  = new File(compositionDir + "/" + compositionPlanName + ".java");
		File serviceImplementation  = new File(compositionDir + "/" + compositionPlanName + "Impl.java");
        
		try 
		{                        
            FileWriter serviceInterfaceFW = new FileWriter(serviceInterface);
			
			serviceInterfaceFW.write(
				"package eu.aniketos.compositeService;\n" +
				"import javax.jws.WebService;\n" +
				"@WebService\n" +
				"public interface " + compositionPlanName + "{\n" +
				"String [] " + methodName + " (String [] paramNames, String [] paramValues);\n" + "}\n"                    
		    ); 
			serviceInterfaceFW.close();
		    
		    FileWriter serviceImplementationFW = new FileWriter(serviceImplementation);
		    serviceImplementationFW.write(
				"package eu.aniketos.compositeService;\n" +
				"import javax.jws.WebService;\n" +
				"import java.net.URL;\n" +
				"import org.apache.http.HttpHost;\n" +
                "import org.apache.http.HttpEntity;\n" +
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
                "import org.apache.http.util.EntityUtils;\n" +
				"import org.apache.http.protocol.BasicHttpContext;\n" +
				"import org.apache.http.entity.StringEntity;\n" +
				"import java.io.IOException;\n" +
				"import java.util.regex.Matcher;\n" +
                "import java.util.regex.Pattern;\n\n" +
                "import eu.aniketos.serviceruntime.datamanager.DataManager;\n\n" +
				"@WebService(endpointInterface = \"eu.aniketos.compositeService." + compositionPlanName + "\")\n" +
				"public class " + compositionPlanName + "Impl implements " + compositionPlanName + " {\n" +
				"public String [] " + methodName + " (String [] paramNames, String [] paramValues) {\n" +
				"DefaultHttpClient httpclient = new DefaultHttpClient();\n" +
				"try {\n" +
				"URL url = new URL(\"" + activitiAddress + "\");\n" +
				"String scheme = url.getProtocol();\n" +
				"String hostName = url.getHost();\n" +
				"int port = url.getPort();\n" +
		        "HttpHost targetHost = new HttpHost(hostName, port, scheme);\n" +
		        "httpclient.getCredentialsProvider().setCredentials(\n" +
		        "new AuthScope(targetHost.getHostName(), targetHost.getPort()),new UsernamePasswordCredentials(\"" + activitiUsername + "\", \"" + activitiPassword + "\"));\n" +
		        "AuthCache authCache = new BasicAuthCache();\n" +
		        "BasicScheme basicAuth = new BasicScheme();\n" +
		        "authCache.put(targetHost, basicAuth);\n" +
		        "BasicHttpContext localcontext = new BasicHttpContext();\n" +
		        "localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);\n" +
		        "HttpPost httpPost = new HttpPost(\"" + activitiAddress + "/activiti-rest/service/process-instance\");\n" +
                    
                "String requestBody=\"\\\"processDefinitionId\\\":\\\"\" + DataManager.getProcessId(\"" + compositionPlanName + "\") + \"\\\"\";\n" +
                "if (paramNames != null && paramValues != null && paramNames.length == paramValues.length) {\n" +
                "for(int i=0;i<paramNames.length;i++) {\n" +
                "requestBody += \",\\\"\" + paramNames[i] + \"\\\":\\\"\" + paramValues[i] + \"\\\"\";\n" +
                "}\n}\n" +
                "System.out.println(\"{\" + requestBody  + \"}\");" +
		        "StringEntity input = new StringEntity(\"{\" + requestBody  + \"}\");\n" +
				"input.setContentType(\"application/json\");\n" +
				"httpPost.setEntity(input);\n" + 
				"HttpResponse httpResponse = httpclient.execute(httpPost, localcontext);\n" +
                "HttpEntity responseEntity = httpResponse.getEntity();\n" +
                "if(responseEntity!=null) {\n" +
                "   String response = EntityUtils.toString(responseEntity);\n" +
                "   System.out.println(\"******* \" + response);\n" +
                "   if (response != null) {\n" + 
                "       String instanceId = getId(response);\n" + 
                "       if (instanceId != null) {\n" + 
                "           System.out.println(\"Getting results for: \" + instanceId);\n" +
                "           return DataManager.getResults(instanceId);\n" +
                "       }\n" +
                "   }\n"+
                "}\n" +                
				"} catch (ClientProtocolException e) {\n" +
				"e.printStackTrace();\n" +
				"} catch (IOException e) {\n" +
				"e.printStackTrace();\n" +
				"} finally {\n" +
				"try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}\n" +
        		"}\n" +
                "return null;\n" +
				"}\n" +
                "   private Pattern idPattern = Pattern.compile(\"\\\"id\\\":\\\"(.+?)\\\"\");\n" +
                "	\n" +
                "	private String getId(String json) {\n" +
                "		json = json.replace('\\n', ' ');\n" +
                "		json = json.replace('\\r', ' ');\n" +
                "		\n" +
                "		Matcher matcher = idPattern.matcher(json);\n" +
                "	    if (matcher.find()) {\n" +
                "	    	return matcher.group(1);\n" +
                "	    }\n" +
                "		\n" +
                "		return null;\n" +
                "	}" +
				"}"
		    );            
            
		    serviceImplementationFW.close();
            
		    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                        
            if (compiler == null) {
                logger.error("Compiler is null!");
            }              
            
		    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

            if (fileManager == null) {
                logger.error("File manager is null!");
            }          
            
		    fileManager.setLocation(StandardLocation.CLASS_OUTPUT, 
		    		Arrays.asList(new File(compositionDir + "/WEB-INF/classes")));
		    
		    fileManager.setLocation(StandardLocation.CLASS_PATH, 
		    		Arrays.asList(new File(resoursesDir + "/lib/httpclient-4.2.jar"), 
		    					 new File(resoursesDir + "/lib/httpcore-4.2.jar"), 
		    					 new File(resoursesDir + "/lib/httpmime-4.2.jar"), 
                                 new File(resoursesDir + "/lib/datamanager-1.0-SNAPSHOT.jar"), 
		    					 new File(compositionDir + "/WEB-INF/classes")));
            
            logger.debug("Starting compilation...");
            
		    // Compile the interface java file of the composition instance
            String [] options = {"-source", "1.6", "-target", "1.6"};
		    compiler.getTask(null, fileManager, null,  
                    Arrays.asList(options), null,
		    		fileManager.getJavaFileObjectsFromFiles(Arrays.asList(serviceInterface))).call();
            
		    // Compile the DataManager java file of the composition instance
		    //compiler.getTask(null, fileManager, null, null, null, 
		    //		fileManager.getJavaFileObjectsFromFiles(Arrays.asList(dataManager))).call();            
		    
		    // Compile the implementation java file of the composition instance
		    compiler.getTask(null, fileManager, null,  
                    Arrays.asList(options), null,
		    		fileManager.getJavaFileObjectsFromFiles(Arrays.asList(serviceImplementation))).call();
		    fileManager.close();
		    
		    serviceInterface.delete();
		    serviceImplementation.delete();
		 
		    logger.debug("Service Instance created");
		 
		    return true;
		} 
		catch (IOException e) 
		{
			logger.error("IOException: {}", e.getMessage());
			return false;
		} 
		
	}
	
	/**
	 * Creates the WAR file of the service
	 * @param compositionPlanName The name of the composition
	 * @return true, if the WAR file is created
	 */
	public boolean createWar(String compositionPlanName){

		try {
			File webXmlResources = new File(resoursesDir, "web.xml");
			File webXmlWar = new File(getCompositionDir(compositionPlanName) + 
									  "/WEB-INF/web.xml");

			File sunXmlResources = new File(resoursesDir, "sun-jaxws.xml");
			File sunXmlWar = new File(getCompositionDir(compositionPlanName) + 
									  "/WEB-INF/sun-jaxws.xml");

			copyFile(webXmlResources, webXmlWar);
			copyFile(sunXmlResources, sunXmlWar);

			modifySunXmlFile(compositionPlanName);

			//copy lib directory
			File dirTarget = new File(getCompositionDir(compositionPlanName) + 
									"/WEB-INF/lib");

			File dirSource = new File(resoursesDir + "/lib/");
			copyDirectory(dirSource, dirTarget);

			WarCreator warCreator = new WarCreator();
			
			warCreator.create(getCompositionDir(compositionPlanName) + "/WEB-INF/", 
							  getWarPath(compositionPlanName));

			logger.debug("WAR file created");
			return true;
			
		} catch (Exception ex) {
			logger.error("Exception", ex);
			logger.error("WAR file not created");
			return false;
		}	
	}

	public static void copyFile(File source, File dest) throws IOException
	{
		File inputFile = source;
		File outputFile = dest;

		InputStream finput = new BufferedInputStream(new FileInputStream(inputFile));
		OutputStream foutput = new BufferedOutputStream(new FileOutputStream(outputFile));
		
		byte[] buffer = new byte[1024 * 500];
		int bytes_read = 0;
		
		while((bytes_read = finput.read(buffer)) > 0)
		foutput.write(buffer, 0, bytes_read);
		finput.close();
		foutput.close();
	}
	
	public static void copyDirectory(File source, File dest) throws IOException
	{
		File[] listFiles = source.listFiles();
		for(int i = 0; i < listFiles.length; i++)
		{
			File targetFile = new File(dest.getAbsolutePath()+"/"+listFiles[i].getName());
			copyFile(listFiles[i],targetFile);
		}
	}	
	
	/**
	 * Modifies SUN's XML file
	 * @param compositionPlanName The name of the composition
	 * @throws JDOMException
	 * @throws IOException
	 */
	private void modifySunXmlFile(String compositionPlanName) throws JDOMException, IOException{	
		// Istantiating a not validating XML parser 
		SAXBuilder builder = new SAXBuilder(false);

		// creating a DOM structure into the memory starting from the XML file

		Document document = builder.build(
				new File(getCompositionDir(compositionPlanName) + "/WEB-INF/sun-jaxws.xml"));

		Element root = document.getRootElement();
		Namespace ns = root.getNamespace("http://java.sun.com/xml/ns/jax-ws/ri/runtime");

		Element endpoint = root.getChild("endpoint",ns);
		endpoint.setAttribute("implementation", "eu.aniketos.compositeService." + 
						compositionPlanName + "Impl");
		endpoint.setAttribute("name", compositionPlanName);

		XMLOutputter outputter = new XMLOutputter(); 
		outputter.setFormat(Format.getPrettyFormat());
		FileOutputStream fos = new FileOutputStream(
				getCompositionDir(compositionPlanName) + "/WEB-INF/sun-jaxws.xml");
		outputter.output(document, fos); 
		fos.close();
		
		logger.debug("File sun-jaxws.xml modified");
	}
	
	/**
	 * Deploys the WAR in Tomcat
	 * @param compositionPlanName The name of the composition
	 * @return the endpoint of the deployed web service or null, if the deployment failed
	 */
	public String deployWarTomcat(String compositionPlanName){
		
		String response = tomcatClient.deployWar(compositionPlanName,
												 getWarPath(compositionPlanName));
		if(response.contains("OK")){
			logger.debug("WAR file deployed");
			
			String endpoint = config.tomcatPublicAddress +
					compositionPlanName +
					"/service?wsdl";
			
			return endpoint;
		} else {
			logger.debug("WAR file not deployed");
			return null;
		}
		
		
	}

}
