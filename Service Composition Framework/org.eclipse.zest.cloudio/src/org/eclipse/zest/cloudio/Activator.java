/*******************************************************************************
* Copyright (c) 2011 Stephan Schwiebert. All rights reserved. This program and
* the accompanying materials are made available under the terms of the Eclipse
* Public License v1.0 which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* <p/>
* Contributors: Stephan Schwiebert - initial API and implementation
*******************************************************************************/
package org.eclipse.zest.cloudio;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * 
 * @author sschwieb
 *
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.schwiebert.eclipsetagcloud"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	

	public static final String ADD = "add.gif";
	
	public static final String REMOVE = "remove.gif";

	public static final String TOGGLE_COLORS = "toggle_colors.gif";

	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ImageLoader il = new ImageLoader();
		loadImage(il, ADD);
		loadImage(il, REMOVE);
		loadImage(il, TOGGLE_COLORS);
	}
	
	private void loadImage(ImageLoader il, String fileName) throws IOException {
		InputStream stream = getBundle().getResource("img/"+fileName).openStream();
		ImageData[] data = il.load(stream);
		Image image = new Image(Display.getDefault(), data[0]);
		getImageRegistry().put(fileName, image);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
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
