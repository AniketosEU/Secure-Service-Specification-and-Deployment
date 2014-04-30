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

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scpm.client.ICompositionPlanner;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class Activator implements BundleActivator {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Activator.class);

	private static BundleContext context;
	
	private static Activator plugin;
	
	private static URL urlWSDLTRRM;
	
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		plugin = this;
		
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("dev", "scf");
		
		ServiceCompositionFrameworkInterface scf = new ServiceCompositionFramework();
		
		bundleContext.registerService(ServiceCompositionFrameworkInterface.class.getName(), scf, props);
		
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("ServiceCompositionFramework bundle registered");
		}
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ICompositionPlanner getCompositionPlanner(){

		ServiceReference ref = context.getServiceReference(ICompositionPlanner.class.getName());
		ICompositionPlanner scf = (ICompositionPlanner) context.getService(ref);
		return scf;
	}
	
	public static URL getWSDLTRRM(){

		try {
			urlWSDLTRRM = org.eclipse.core.runtime.FileLocator.toFileURL((context.getBundle().getEntry("resources/TRRM_WSDL.wsdl")));
		} catch (IOException e) {
			logger.debug(e);
		}
		return urlWSDLTRRM;
	}

}
