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
package org.activiti.designer.eclipse.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.util.VersionStringComparator;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.osgi.framework.Bundle;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
@SuppressWarnings("restriction")
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "org.activiti.designer.eclipse.perspective.SCFPerspective";
	
	final private static Logger log = Logger.getLogger(ApplicationWorkbenchAdvisor.class);
	
    /* (non-Javadoc)
     * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
     */
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
	 */
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
	 */
	public void initialize(IWorkbenchConfigurer configurer) {
	     super.initialize(configurer);

	     configurer.setSaveAndRestore(false);
	     PlatformUI.getPreferenceStore().setValue(
	            IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, false);

	    IDE.registerAdapters();

	    final String ICONS_PATH = "icons/full/";

	    Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle,
	            IDE.SharedImages.IMG_OBJ_PROJECT, 
	            ICONS_PATH + "obj16/prj_obj.gif",
	            true);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle,
	            IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, 
	            ICONS_PATH + "obj16/cprj_obj.gif", 
	            true);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle, 
	            IDEInternalWorkbenchImages.IMG_ETOOL_PROBLEM_CATEGORY, 
	            ICONS_PATH + "eview16/problems_view.gif", 
	            true);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle, 
	            IDEInternalWorkbenchImages.IMG_ETOOL_PROBLEM_CATEGORY, 
	            ICONS_PATH + "eview16/problems_view_error.gif", 
	            true);


	    declareWorkbenchImage(
	            configurer, 
	            ideBundle, 
	            IDEInternalWorkbenchImages.IMG_ETOOL_PROBLEM_CATEGORY, 
	            ICONS_PATH + "eview16/problems_view_warning.gif", 
	            true);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle, 
	            IDEInternalWorkbenchImages.IMG_OBJS_ERROR_PATH, 
	            ICONS_PATH + "obj16/error_tsk.gif", 
	            true);

	    declareWorkbenchImage(
	            configurer, 
	            ideBundle, 
	            IDEInternalWorkbenchImages.IMG_OBJS_WARNING_PATH, 
	            ICONS_PATH + "obj16/warn_tsk.gif", 
	            true);
		
	    Properties prop = Activator.getConfigProperties();
	    
		String version = getLastVersion(prop.getProperty("proxyHost"), prop.getProperty("proxyPort"), prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));
		if(version == null)
			log.debug("Last online SCF version: not able to connect online");
		else 
			log.debug("Last online SCF version: " + version);
		String actualVersion = prop.getProperty("version");
		log.debug("Actual SCF version " + actualVersion);
		if(version!=null){
			if(VersionStringComparator.value(version) > VersionStringComparator.value(actualVersion)){
					MessageDialog.openInformation(null, "New version",
						"A new version is available in the eroom");
			}
		}

	}

	private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p, Bundle ideBundle, String symbolicName, String path, boolean shared)  
	{
		URL url = ideBundle.getEntry(path);
		ImageDescriptor desc = ImageDescriptor.createFromURL(url);
		configurer_p.declareImage(symbolicName, desc, shared);
	}

	private String getLastVersion(String proxyHost, String proxyPort, String proxyUsername, String proxyPassword){
		String version = "";
		
		try {
			
			if(!proxyHost.equals("noproxy") && !proxyPort.equals("noproxy")){
				System.setProperty("http.proxyHost", proxyHost);
				System.setProperty("http.proxyPort", proxyPort);
			} else {
				System.setProperty("http.proxyHost", "");
				System.setProperty("http.proxyPort", "");
			}
			if(!proxyUsername.equals("noproxy") && !proxyPassword.equals("noproxy")) {
				System.setProperty("http.proxyUser", proxyUsername);
				System.setProperty("http.proxyPassword", proxyPassword);
			} else {
				System.setProperty("http.proxyUser", "");
				System.setProperty("http.proxyPassword", "");
			}

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(
					"http://services-aniketoswp6.rhcloud.com/version.txt");
			HttpParams params = httpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 1000);
			HttpConnectionParams.setSoTimeout(params, 1000);
			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((response.getEntity().getContent())));

			String output;
			while ((output = br.readLine()) != null) {
				
				version = output.substring(output.lastIndexOf("=")+1, output.length());
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			return null;

		} catch (IOException e) {

			return null;
		}
		
		return version;
	}
	
}
