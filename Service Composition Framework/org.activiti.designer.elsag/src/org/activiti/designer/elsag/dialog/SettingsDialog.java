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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;

import org.activiti.designer.elsag.Activator;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mihalis.opal.checkBoxGroup.CheckBoxGroup;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class SettingsDialog {
	
	final private static Logger log = Logger.getLogger(SettingsDialog.class);
	
	private Display display;
	
//	private static Text txt_Address;
//	private static Text txt_UsernameActiviti;
//	private static Text txt_PasswordActiviti;
	private static Text txt_IdMAddress;
//	private static Text txt_TomcatAddress;
//	private static Text txt_TomcatUsername;
//	private static Text txt_TomcatPassword;
	private static Text txt_MarketplaceAddress;
	private static Text txt_TRRMAddress;
	private static Text txt_SCPMAddress;
	private static Text txt_SREAddress;
	private static Text txt_SRCMAddress;
	private Properties prop;

	public SettingsDialog(Display display) {
		this.display = display;
		prop = Activator.getConfigProperties();
	}

	public void createContents() {
		final Shell shell = new Shell(display, SWT.CLOSE | SWT.APPLICATION_MODAL);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setSize(500, 680);
		shell.setText("Settings");
		
		final Composite composite = new Composite(shell, SWT.NONE);
		final FormLayout formLayout= new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		composite.setLayout(formLayout);
		
//		final CLabel clbl_Address = new CLabel(composite, SWT.NONE);
//		clbl_Address.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_1 = new FormData();
//		formData_1.left = new FormAttachment(5,0);
//		formData_1.top = new FormAttachment(0,30);
//		clbl_Address.setLayoutData(formData_1);
//		clbl_Address.setText("Activiti Engine Address");
//
//		//Textfield for the username
//		txt_Address = new Text(composite, SWT.BORDER);
//		final FormData formData_2 = new FormData(300,20);
//		formData_2.left = new FormAttachment(0,160);
//		formData_2.top = new FormAttachment(0,30);
//		txt_Address.setLayoutData(formData_2);
//		String activitiEngineAddress = prop.getProperty("ActivitiEngineAddress");
//		txt_Address.setText(activitiEngineAddress);
//		txt_Address.setEditable(false);
//		
//		final CLabel clbl_UsernameActiviti = new CLabel(composite, SWT.NONE);
//		clbl_UsernameActiviti.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_3 = new FormData();
//		formData_3.left = new FormAttachment(5,0);
//		formData_3.top = new FormAttachment(txt_Address,20);
//		clbl_UsernameActiviti.setLayoutData(formData_3);
//		clbl_UsernameActiviti.setText("Activiti Engine Username");
//
//		//Textfield for the username
//		txt_UsernameActiviti = new Text(composite, SWT.BORDER);
//		final FormData formData_4 = new FormData(300,20);
//		formData_4.left = new FormAttachment(0,160);
//		formData_4.top = new FormAttachment(txt_Address,20);
//		txt_UsernameActiviti.setLayoutData(formData_4);
//		txt_UsernameActiviti.setText(prop.getProperty("ActivitiEngineUsername"));
//		txt_UsernameActiviti.setEditable(false);
//		
//		final CLabel clbl_PasswordActiviti = new CLabel(composite, SWT.NONE);
//		clbl_PasswordActiviti.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_5 = new FormData();
//		formData_5.left = new FormAttachment(5,0);
//		formData_5.top = new FormAttachment(txt_UsernameActiviti,20);
//		clbl_PasswordActiviti.setLayoutData(formData_5);
//		clbl_PasswordActiviti.setText("Activiti Engine Password");
//
//		//Textfield for the username
//		txt_PasswordActiviti = new Text(composite, SWT.BORDER);
//		final FormData formData_6 = new FormData(300,20);
//		formData_6.left = new FormAttachment(0,160);
//		formData_6.top = new FormAttachment(txt_UsernameActiviti,20);
//		txt_PasswordActiviti.setLayoutData(formData_6);
//		txt_PasswordActiviti.setText(prop.getProperty("ActivitiEnginePassword"));
//		txt_PasswordActiviti.setEditable(false);
//		
		final CLabel clbl_IdmAddress = new CLabel(composite, SWT.NONE);
		clbl_IdmAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_9 = new FormData();
		formData_9.left = new FormAttachment(5,0);
//		formData_9.top = new FormAttachment(txt_PasswordActiviti,20);
		formData_9.top = new FormAttachment(0,30);
		clbl_IdmAddress.setLayoutData(formData_9);
		clbl_IdmAddress.setText("IdM Service Address");

		txt_IdMAddress = new Text(composite, SWT.BORDER);
		final FormData formData_10 = new FormData(300,20);
		formData_10.left = new FormAttachment(0,160);
//		formData_10.top = new FormAttachment(txt_PasswordActiviti,20);
		formData_10.top = new FormAttachment(0,30);
		txt_IdMAddress.setLayoutData(formData_10);
		txt_IdMAddress.setText(prop.getProperty("IdentityManagementServiceAddress"));
		txt_IdMAddress.setEditable(false);
//		
//		final CLabel clbl_TomcatAddress = new CLabel(composite, SWT.NONE);
//		clbl_TomcatAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_11 = new FormData();
//		formData_11.left = new FormAttachment(5,0);
//		formData_11.top = new FormAttachment(txt_IdMAddress,20);
//		clbl_TomcatAddress.setLayoutData(formData_11);
//		clbl_TomcatAddress.setText("Tomcat Address");
//
//		//Textfield for the username
//		txt_TomcatAddress = new Text(composite, SWT.BORDER);
//		final FormData formData_12 = new FormData(300,20);
//		formData_12.left = new FormAttachment(0,160);
//		formData_12.top = new FormAttachment(txt_IdMAddress,20);
//		txt_TomcatAddress.setLayoutData(formData_12);
//		txt_TomcatAddress.setText(prop.getProperty("TomcatAddress"));
//		txt_TomcatAddress.setEditable(false);
//		
//		final CLabel clbl_TomcatUsername = new CLabel(composite, SWT.NONE);
//		clbl_TomcatUsername.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_13 = new FormData();
//		formData_13.left = new FormAttachment(5,0);
//		formData_13.top = new FormAttachment(txt_TomcatAddress,20);
//		clbl_TomcatUsername.setLayoutData(formData_13);
//		clbl_TomcatUsername.setText("Tomcat Username");
//
//		//Textfield for the username
//		txt_TomcatUsername = new Text(composite, SWT.BORDER);
//		final FormData formData_14 = new FormData(300,20);
//		formData_14.left = new FormAttachment(0,160);
//		formData_14.top = new FormAttachment(txt_TomcatAddress,20);
//		txt_TomcatUsername.setLayoutData(formData_14);
//		txt_TomcatUsername.setText(prop.getProperty("TomcatUsername"));
//		txt_TomcatUsername.setEditable(false);
//		
//		final CLabel clbl_TomcatPassword = new CLabel(composite, SWT.NONE);
//		clbl_TomcatPassword.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
//		final FormData formData_15 = new FormData();
//		formData_15.left = new FormAttachment(5,0);
//		formData_15.top = new FormAttachment(txt_TomcatUsername,20);
//		clbl_TomcatPassword.setLayoutData(formData_15);
//		clbl_TomcatPassword.setText("Tomcat Password");
//
//		//Textfield for the username
//		txt_TomcatPassword = new Text(composite, SWT.BORDER);
//		final FormData formData_16 = new FormData(300,20);
//		formData_16.left = new FormAttachment(0,160);
//		formData_16.top = new FormAttachment(txt_TomcatUsername,20);
//		txt_TomcatPassword.setLayoutData(formData_16);
//		txt_TomcatPassword.setText(prop.getProperty("TomcatPassword"));
//		txt_TomcatPassword.setEditable(false);
		
		final CLabel clbl_MarketplaceAddress = new CLabel(composite, SWT.NONE);
		clbl_MarketplaceAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_17 = new FormData();
		formData_17.left = new FormAttachment(5,0);
//		formData_17.top = new FormAttachment(txt_TomcatPassword,20);
		formData_17.top = new FormAttachment(txt_IdMAddress,20);
		clbl_MarketplaceAddress.setLayoutData(formData_17);
		clbl_MarketplaceAddress.setText("Marketplace Address");

		txt_MarketplaceAddress = new Text(composite, SWT.BORDER);
		final FormData formData_18 = new FormData(300,20);
		formData_18.left = new FormAttachment(0,160);
//		formData_18.top = new FormAttachment(txt_TomcatPassword,20);
		formData_18.top = new FormAttachment(txt_IdMAddress,20);
		txt_MarketplaceAddress.setLayoutData(formData_18);
		txt_MarketplaceAddress.setText(prop.getProperty("MarketplaceAddress"));
		txt_MarketplaceAddress.setEditable(false);
		
		final CLabel clbl_TRRMAddress = new CLabel(composite, SWT.NONE);
		clbl_TRRMAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_26 = new FormData();
		formData_26.left = new FormAttachment(5,0);
		formData_26.top = new FormAttachment(txt_MarketplaceAddress,20);
		clbl_TRRMAddress.setLayoutData(formData_26);
		clbl_TRRMAddress.setText("TRRM Address");

		txt_TRRMAddress = new Text(composite, SWT.BORDER);
		final FormData formData_27 = new FormData(300,20);
		formData_27.left = new FormAttachment(0,160);
		formData_27.top = new FormAttachment(txt_MarketplaceAddress,20);
		txt_TRRMAddress.setLayoutData(formData_27);
		txt_TRRMAddress.setText(prop.getProperty("TRRMAddress"));
		txt_TRRMAddress.setEditable(false);
		
		final CLabel clbl_SCPMAddress = new CLabel(composite, SWT.NONE);
		clbl_SCPMAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_19 = new FormData();
		formData_19.left = new FormAttachment(5,0);
		formData_19.top = new FormAttachment(txt_TRRMAddress,20);
		clbl_SCPMAddress.setLayoutData(formData_19);
		clbl_SCPMAddress.setText("SCPM Address");

		txt_SCPMAddress = new Text(composite, SWT.BORDER);
		final FormData formData_20 = new FormData(300,20);
		formData_20.left = new FormAttachment(0,160);
		formData_20.top = new FormAttachment(txt_TRRMAddress,20);
		txt_SCPMAddress.setLayoutData(formData_20);
		txt_SCPMAddress.setText(prop.getProperty("SCPMAddress"));
		txt_SCPMAddress.setEditable(false);
		
		final CLabel clbl_SREAddress = new CLabel(composite, SWT.NONE);
		clbl_SREAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_21 = new FormData();
		formData_21.left = new FormAttachment(5,0);
		formData_21.top = new FormAttachment(txt_SCPMAddress,20);
		clbl_SREAddress.setLayoutData(formData_21);
		clbl_SREAddress.setText("SRE Address");

		//Textfield for the username
		txt_SREAddress = new Text(composite, SWT.BORDER);
		final FormData formData_22 = new FormData(300,20);
		formData_22.left = new FormAttachment(0,160);
		formData_22.top = new FormAttachment(txt_SCPMAddress,20);
		txt_SREAddress.setLayoutData(formData_22);
		txt_SREAddress.setText(prop.getProperty("SREAddress"));
		txt_SREAddress.setEditable(false);
		
		final CLabel clbl_SRCMAddress = new CLabel(composite, SWT.NONE);
		clbl_SRCMAddress.setFont(new Font(display, "Tahoma", 8, SWT.NORMAL));
		final FormData formData_23 = new FormData();
		formData_23.left = new FormAttachment(5,0);
		formData_23.top = new FormAttachment(txt_SREAddress,20);
		clbl_SRCMAddress.setLayoutData(formData_23);
		clbl_SRCMAddress.setText("SRCM Address");

		txt_SRCMAddress = new Text(composite, SWT.BORDER);
		final FormData formData_24 = new FormData(300,20);
		formData_24.left = new FormAttachment(0,160);
		formData_24.top = new FormAttachment(txt_SREAddress,20);
		txt_SRCMAddress.setLayoutData(formData_24);
		txt_SRCMAddress.setText(prop.getProperty("SRCMAddress"));
		txt_SRCMAddress.setEditable(false);
		
		final CheckBoxGroup proxyGroup = new CheckBoxGroup(composite, SWT.NONE);
		final FormData formData_25 = new FormData();
		formData_25.left = new FormAttachment(50,-150);
		formData_25.right = new FormAttachment(50,150);
		formData_25.top = new FormAttachment(txt_SRCMAddress,20);
		proxyGroup.setLayoutData(formData_25);
        proxyGroup.setLayout(new GridLayout(2, false));
        proxyGroup.setText("Set Proxy");
        
        Composite compositeProxy = proxyGroup.getContent();
        
        Label hostLabel = new Label(compositeProxy, SWT.NONE);
        hostLabel.setText("Proxy Host: ");
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
        gridData.horizontalSpan= 1;
        hostLabel.setLayoutData(gridData);
        
        final Text hostText = new Text(compositeProxy,SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        hostText.setLayoutData(gridData);
        if(!prop.getProperty("proxyHost").equals("noproxy")){
        	hostText.setText(prop.getProperty("proxyHost"));
        	proxyGroup.activate();
        } else {
        	proxyGroup.deactivate();
        }
        
        Label portLabel = new Label(compositeProxy, SWT.NONE);
        portLabel.setText("Proxy Port: ");
        gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
        gridData.horizontalSpan= 1;
        portLabel.setLayoutData(gridData);
        
        final Text portText = new Text(compositeProxy,SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        portText.setLayoutData(gridData);
        if(!prop.getProperty("proxyPort").equals("noproxy")){
        	portText.setText(prop.getProperty("proxyPort"));
        	proxyGroup.activate();
        } else {
        	proxyGroup.deactivate();
        }
        
        Label usernameProxyLabel = new Label(compositeProxy, SWT.NONE);
        usernameProxyLabel.setText("Proxy Username: ");
        gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
        gridData.horizontalSpan= 1;
        usernameProxyLabel.setLayoutData(gridData);
        
        final Text usernameProxyText = new Text(compositeProxy,SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        usernameProxyText.setLayoutData(gridData);
        if(!prop.getProperty("proxyUsername").equals("noproxy")){
        	usernameProxyText.setText(prop.getProperty("proxyUsername"));
        	proxyGroup.activate();
        } else {
        	proxyGroup.deactivate();
        }
        
        Label proxyPasswordLabel = new Label(compositeProxy, SWT.NONE);
        proxyPasswordLabel.setText("Proxy Password: ");
        gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
        gridData.horizontalSpan= 1;
        proxyPasswordLabel.setLayoutData(gridData);
        
        final Text proxyPasswordText = new Text(compositeProxy,SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        proxyPasswordText.setLayoutData(gridData);
        proxyPasswordText.setEchoChar('*');
        if(!prop.getProperty("proxyPassword").equals("noproxy")){
        	proxyPasswordText.setText(prop.getProperty("proxyPassword"));
        	proxyGroup.activate();
        } else {
        	proxyGroup.deactivate();
        }
		
		final Button editButton = new Button(composite, SWT.NONE);
		final FormData formData_7 = new FormData(50,30);
		formData_7.left = new FormAttachment(50,-60);
		formData_7.top = new FormAttachment(proxyGroup,60);
		editButton.setLayoutData(formData_7);
		editButton.setText("Edit");
		editButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event e) {
//				txt_Address.setEditable(true);
//				txt_UsernameActiviti.setEditable(true);
//				txt_PasswordActiviti.setEditable(true);
				txt_IdMAddress.setEditable(true);
//				txt_TomcatAddress.setEditable(true);
//				txt_TomcatUsername.setEditable(true);
//				txt_TomcatPassword.setEditable(true);
				txt_MarketplaceAddress.setEditable(true);
				txt_TRRMAddress.setEditable(true);
				txt_SCPMAddress.setEditable(true);
				txt_SREAddress.setEditable(true);
				txt_SRCMAddress.setEditable(true);
			}
		});
		
		final Button okButton = new Button(composite, SWT.NONE);
		final FormData formData_8 = new FormData(50,30);
		formData_8.left = new FormAttachment(50,30);
		formData_8.top = new FormAttachment(proxyGroup,60);
		okButton.setLayoutData(formData_8);
		okButton.setText("Ok");
		okButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event e) {
				
				String proxyHost = "noproxy";
				String proxyPort = "noproxy";
				String proxyUsername = "noproxy";
				String proxyPassword = "noproxy";
				if(proxyGroup.isActivated()){
					proxyHost = hostText.getText();
					proxyPort = portText.getText();
					proxyPassword = proxyPasswordText.getText();
					proxyUsername = usernameProxyText.getText();
				}
				
//				String activitiEngineAddress = txt_Address.getText();
//				String usernameActiviti = txt_UsernameActiviti.getText();
//				String passwordActiviti = txt_PasswordActiviti.getText();
				String idmAddress = txt_IdMAddress.getText();
//				String tomcatAddress = txt_TomcatAddress.getText();
//				String usernameTomcat = txt_TomcatUsername.getText();
//				String passwordTomcat = txt_TomcatPassword.getText();
				String marketplaceAddress = txt_MarketplaceAddress.getText();
				String trrmAddress = txt_TRRMAddress.getText();
				String scpmAddress = txt_SCPMAddress.getText();
				String sreAddress = txt_SREAddress.getText();
				String srcmAddress = txt_SRCMAddress.getText();
//				prop.setProperty("ActivitiEngineAddress", activitiEngineAddress);
//				prop.setProperty("ActivitiEngineUsername", usernameActiviti);
//				prop.setProperty("ActivitiEnginePassword", passwordActiviti);
				prop.setProperty("IdentityManagementServiceAddress", idmAddress);
//				prop.setProperty("TomcatAddress", tomcatAddress);
//				prop.setProperty("TomcatUsername", usernameTomcat);
//				prop.setProperty("TomcatPassword", passwordTomcat);
				prop.setProperty("MarketplaceAddress", marketplaceAddress);
				prop.setProperty("TRRMAddress", trrmAddress);
				prop.setProperty("SCPMAddress", scpmAddress);
				prop.setProperty("SREAddress", sreAddress);
				prop.setProperty("SRCMAddress", srcmAddress);
				prop.setProperty("proxyHost", proxyHost);
				prop.setProperty("proxyPort", proxyPort);
				prop.setProperty("proxyUsername", proxyUsername);
				prop.setProperty("proxyPassword", proxyPassword);
				Activator.setConfigProperties(prop);
				
				Preferences preferences = InstanceScope.INSTANCE
						.getNode("eu.aniketos.scf.preferences");
				Preferences sub1 = preferences.node("scf");
				sub1.put("SCPMAddress", scpmAddress);
				sub1.put("proxyHost", proxyHost);
				sub1.put("proxyPort", proxyPort);
				sub1.put("proxyUsername", proxyUsername);
				sub1.put("proxyPassword", proxyPassword);
				try {
					// forces the application to save the preferences
					preferences.flush();
				} catch (BackingStoreException ex) {
					log.error(ex);
				}

				shell.close();
			}
		});

		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 500) / 2;
		final int y = (screenSize.height - 680) / 2;
		shell.setLocation(x, y);
		shell.open();
	}
}

