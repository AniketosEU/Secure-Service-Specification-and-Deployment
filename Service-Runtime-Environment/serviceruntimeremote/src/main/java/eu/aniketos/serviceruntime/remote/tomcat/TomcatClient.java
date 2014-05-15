package eu.aniketos.serviceruntime.remote.tomcat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that provides methods for communicating with a Tomcat Server
 * @author kGiannakakis
 *
 */
public class TomcatClient {
	
	/**
	 * Logger
	 */
	final private static Logger logger = LoggerFactory.getLogger(TomcatClient.class);
	
	/** Tomcat's URL */
	private String tomcatAddress;
	
	/** The username of the Tomcat user. The user must have the manager-script role */
	private String username;
	
	/** The password of the Tomcat user. The user must have the manager-script role */
	private String password;
	
	/** Tomcat's version. Should be 6 or 7 */
	private int tomcatVersion = 6;
		
	/**
	 * Sets the Tomcat version. Should be 6 or 7 
	 * @param tomcatVersion The Tomcat's version.
	 */
	public void setTomcatVersion(int tomcatVersion) {
		this.tomcatVersion = tomcatVersion;
	}

	/**
	 * Constructor
	 * @param tomcatAddress Tomcat's URL
	 * @param username The username of the Tomcat user. The user must have the manager-script role
	 * @param password The password of the Tomcat user
	 */
	public TomcatClient(String tomcatAddress, 
						String username, String password) {
		if (tomcatAddress != null && !tomcatAddress.endsWith("/")) {
			tomcatAddress += "/";
		}
		this.tomcatAddress = tomcatAddress;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Deploys a WAR in Tomcat
	 * @param webapp The name of the web application
	 * @param warFilePath The path of the WAR file to be deployed
	 * @return The first line of the response
	 */
	public String deployWar(String webapp, String warFilePath){
		DefaultHttpClient httpclient = new DefaultHttpClient();		
		try {
			URL url = new URL(tomcatAddress);
			String scheme = url.getProtocol();
			String hostName = url.getHost();
			int port = url.getPort();
			HttpHost targetHost = new HttpHost(hostName, port, scheme);
			httpclient.getCredentialsProvider().setCredentials(
					new AuthScope(targetHost.getHostName(), targetHost.getPort(), AuthScope.ANY_REALM),
					new UsernamePasswordCredentials(username, password));
			AuthCache authCache = new BasicAuthCache();
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(targetHost, basicAuth);
			BasicHttpContext localcontext = new BasicHttpContext();
			localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);

			String address = tomcatAddress;
			HttpPut httpPut = null;
			if (tomcatVersion == 6) {
				address += "manager/deploy?update=true&path=/" + webapp;
				httpPut = new HttpPut(address);
				FileEntity fileEntity = new FileEntity(new File(warFilePath));
				httpPut.setEntity(fileEntity);					
			}
			else if (tomcatVersion == 7) {
				address += "manager/text/deploy?update=true&path=/" + webapp;
				httpPut = new HttpPut(address);
				FileBody bin = new FileBody(new File(warFilePath));
				MultipartEntity reqEntity = new MultipartEntity();
				reqEntity.addPart("war", bin);
				httpPut.setEntity(reqEntity);			
			}
			else {
				return "";
			}			
			
			HttpResponse response = httpclient.execute(httpPut, localcontext);			
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));
			
			String output = "";
			String line = br.readLine();
			while(line != null) {
				logger.debug(line);
				output += line + "\n";
				line = br.readLine();
			}
			br.close();
			return output;

		} catch (ClientProtocolException e) {			
			logger.error("Error deploying war {}: {}", webapp, e.getMessage());
		} catch (IOException e) {
			logger.error("Error deploying war {}: {}", webapp, e.getMessage());
			e.printStackTrace();
		}
		
		return "";
	}

}
