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
/*
* Activator.java
*/
package eu.aniketos.wp1.ststool.threats;

import java.io.InputStream;
import java.net.URL;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.aniketos.wp1.ststool.threats"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		
	}

	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		Bundle bundle = context.getBundle();
		
		try {
			
			// TODO This code block should install the attached bundles ONLY when run for the first time!

			URL jarUrl = bundle.getEntry("lib/threatrepository-interface-0.1-SNAPSHOT.jar");
			InputStream input = jarUrl.openStream();
			Bundle interfaces = context.installBundle(jarUrl.getPath(), input);
			interfaces.start();
			input.close();
			
			jarUrl = bundle.getEntry("lib/threatrepository-impl-1.0-SNAPSHOT-uber.jar");
			input = jarUrl.openStream();
			Bundle impl = context.installBundle(jarUrl.getPath(), input);
			impl.start();
			input.close();

//			System.out.println(interfaces.getSymbolicName() + ": " + getBundleState(interfaces.getState()));
//			System.out.println(impl.getSymbolicName() + ": " + getBundleState(impl.getState()));
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		super.start(context);
		plugin = this;
	}
	
	
	private String getBundleState(int stateInput) {
		String state;
		switch (stateInput) {
			case Bundle.ACTIVE : state = "ACTIVE"; break;
			case Bundle.INSTALLED : state = "INSTALLED"; break;
			case Bundle.RESOLVED : state = "RESOLVED"; break;
			case Bundle.STARTING : state = "STARTING"; break;
			case Bundle.STOPPING : state = "STOPPING"; break;
			case Bundle.UNINSTALLED : state = "UNINSTALLED"; break;
			default: state = "UNKNOWN";
		}
		return state;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		
		plugin = null;
		super.stop(context);		
	}
	
	

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		
		return plugin;
	}
}
