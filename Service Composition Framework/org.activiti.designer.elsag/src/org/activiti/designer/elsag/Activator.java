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
package org.activiti.designer.elsag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.activiti.designer.elsag.data.Data;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import eu.aniketos.scf.ServiceCompositionFrameworkInterface;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class Activator extends AbstractUIPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.activiti.designer.elsag"; //$NON-NLS-1$
	private static BundleContext context;

	private static Activator plugin;
	private static URL urlProperties;
	private static URL urlConsumerPolicy;
	public static Hashtable<String,Hashtable<String,Set<String>>> hashTableLocationsProcess;
	public static Hashtable<String,Hashtable<String,String>> hashTableFieldProcess;

	public static Hashtable<String,Hashtable<String,Set<String>>> hashTableOperationProcess;

	final private static Logger log = Logger.getLogger(Activator.class);

	final private List<PluginLogListener> pluginLogHooks = new ArrayList<PluginLogListener>();

	public static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		plugin = this;

		new Data();
		URL confURL = context.getBundle().getEntry("log4j.properties");
		PropertyConfigurator.configure( FileLocator.toFileURL(confURL).getFile());
		log.info("Logging using log4j and configuration " + FileLocator.toFileURL(confURL).getFile());
		hookPluginLoggers(context);

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;

		plugin = null;
	}

	public static Activator getDefault() {
		return plugin;
	}

	public ServiceCompositionFrameworkInterface getServiceCompositionFramework(){

		@SuppressWarnings("rawtypes")
		ServiceReference ref = context.getServiceReference(ServiceCompositionFrameworkInterface.class.getName());
		@SuppressWarnings("unchecked")
		ServiceCompositionFrameworkInterface scf = (ServiceCompositionFrameworkInterface) context.getService(ref);
		return scf;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static Properties getConfigProperties(){

		try {
			urlProperties = org.eclipse.core.runtime.FileLocator.toFileURL((context.getBundle().getEntry("/config.properties")));
		} catch (IOException e) {
			log.error(e);
		}
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(urlProperties.getPath()));
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return prop;
	}

	public static Properties setConfigProperties(Properties prop){

		try {
			prop.store(new FileOutputStream(urlProperties.getPath()), null);
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return prop;
	}

	private void hookPluginLoggers(final BundleContext context) {
		for (Bundle bundle : context.getBundles()){
			ILog pluginLogger = Platform.getLog(bundle);
			pluginLogHooks.add(new PluginLogListener(pluginLogger,
					Logger.getLogger(bundle.getSymbolicName())));
			log.trace("Added logging hook for bundle: " + bundle.getSymbolicName());
		}
	}

}
