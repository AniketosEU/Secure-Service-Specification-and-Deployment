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
package org.activiti.designer.elsag.dialog;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.activiti.designer.elsag.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mihalis.opal.preferenceWindow.PWTab;
import org.mihalis.opal.preferenceWindow.PreferenceWindow;
import org.mihalis.opal.preferenceWindow.widgets.PWStringText;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class NewSettingsDialog {
	
	private Properties prop;
	private Display display;

	public NewSettingsDialog(Display display) {
		this.display = display;
		prop = Activator.getConfigProperties();
	}
	
	public void createContents() {
		final Shell shell = new Shell(display, SWT.CLOSE | SWT.ON_TOP | SWT.RESIZE);
		shell.setText("Settings");
        shell.setLayout(new FillLayout(SWT.VERTICAL));
        
        final Map<String, Object> data = new HashMap<String, Object>();
        
        final PreferenceWindow window = PreferenceWindow.create(shell, data);
        
        final PWTab documentTab = window.addTab(new Image(Display.getCurrent(), NewSettingsDialog.class.getClassLoader().getResourceAsStream("icons/aniketos.png")), "Modules URL");
        documentTab.add(new PWStringText("Marketplace", prop.getProperty("MarketplaceAddress")).setAlignment(GridData.FILL));
        documentTab.add(new PWStringText("Marketplace", prop.getProperty("MarketplaceAddress")).setAlignment(GridData.FILL));
        
        window.open();
        
        
        
        
//        shell.pack();
//        shell.open();
//        SWTGraphicUtil.centerShell(shell);
       
	}

}
