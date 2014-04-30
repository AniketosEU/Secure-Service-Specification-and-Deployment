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

import org.activiti.designer.elsag.Activator;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class LoginDialog {

	private static Text txt_Password;
	private static Text txt_Username;
	private Display display;
	private boolean auth;
	
	private CLabel clbl_Error;

	public LoginDialog(Display display) {
		this.display = display;
		auth = false;
	}

	public boolean createContents() {
		
		final Shell shell = new Shell(display, SWT.ON_TOP | SWT.CLOSE);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setText("Login");
		
		final Composite composite = new Composite(shell, SWT.NONE);
		final FormLayout formLayout= new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		composite.setLayout(formLayout);
		
		final Image img = Activator.getImageDescriptor("img_login.png").createImage();
		composite.setBackgroundImage(img);

		//Label for the username
		final CLabel clbl_Username = new CLabel(composite, SWT.NONE);
		final FormData formData_1 = new FormData();
		formData_1.left = new FormAttachment(35,0);
		formData_1.top = new FormAttachment(0,30);
		clbl_Username.setLayoutData(formData_1);
		clbl_Username.setText("Username");
		clbl_Username.setBackgroundImage(img);

		//Textfield for the username
		txt_Username = new Text(composite, SWT.BORDER);
		final FormData formData_2 = new FormData();
		formData_2.left = new FormAttachment(clbl_Username,10);
		formData_2.top = new FormAttachment(0,30);
		txt_Username.setLayoutData(formData_2);
		txt_Username.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
//				int key = e.keyCode;
//				if (key == SWT.ERROR_CANNOT_SET_TEXT ) {
//					String username = txt_Username.getText();
//					String password = txt_Password.getText();
//
//					if(!username.equals("") && !password.equals("")){
//
//						int result = IdMClient.authenticate(username, password);
//						//						if(result = (Boolean) null){
//						//							JOptionPane.showMessageDialog(null, "Unable to connect to the IDM Service", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
//						//							System.out.println("Unable to connect to the IDM Service");
//						//						}
//						System.out.println(result);
//						if(result == Data.AUTHTRUE){
//							shell.close();
//							auth = true;
//						} else if(result == Data.AUTHFALSE) {
//							clbl_Error.setText("User not registered");
//							clbl_Error.setVisible(true);
//							auth = false;
//						} else if(result == Data.AUTHERROR) {
//							clbl_Error.setText("Unable to connect to the IDM service");
//							clbl_Error.setVisible(true);
//							auth = false;
//						}
//
//					} else if(username.equals("")){
//						clbl_Error.setText("Insert a username");
//						clbl_Error.setVisible(true);
//					} else if(password.equals("")){
//						clbl_Error.setText("Insert a password");
//						clbl_Error.setVisible(true);
//					}
//				}
//				
//				//Just close the shell
//				auth = true;
//				shell.close();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		//Label for the password
		final CLabel clbl_Password = new CLabel(composite, SWT.NONE);
		final FormData formData_3 = new FormData();
		formData_3.top = new FormAttachment(clbl_Username,10);
		formData_3.left = new FormAttachment(35,0);
		clbl_Password.setLayoutData(formData_3);
		clbl_Password.setText("Password");
		clbl_Password.setBackgroundImage(img);

		//Textfield for the password
		txt_Password = new Text(composite, SWT.BORDER);
		final FormData formData_4 = new FormData();
		formData_4.left = new FormAttachment(clbl_Password,10);
		formData_4.top = new FormAttachment(txt_Username,10);
		txt_Password.setLayoutData(formData_4);
		txt_Password.setEchoChar('*');
		txt_Password.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
//				int key = e.keyCode;
//				if (key == SWT.ERROR_CANNOT_SET_TEXT ) {
//					String username = txt_Username.getText();
//					String password = txt_Password.getText();
//
//					if(!username.equals("") && !password.equals("")){
//
//						int result = IdMClient.authenticate(username, password);
//						//						if(result = (Boolean) null){
//						//							JOptionPane.showMessageDialog(null, "Unable to connect to the IDM Service", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
//						//							System.out.println("Unable to connect to the IDM Service");
//						//						}
//						System.out.println(result);
//						if(result == Data.AUTHTRUE){
//							shell.close();
//							auth = true;
//						} else if(result == Data.AUTHFALSE) {
//							clbl_Error.setText("User not registered");
//							clbl_Error.setVisible(true);
//							auth = false;
//						} else if(result == Data.AUTHERROR) {
//							clbl_Error.setText("Unable to connect to the IDM service");
//							clbl_Error.setVisible(true);
//							auth = false;
//						}
//
//						//Just close the shell
//						//						shell.close();
//					} else if(username.equals("")){
//						clbl_Error.setText("Insert a username");
//						clbl_Error.setVisible(true);
//					} else if(password.equals("")){
//						clbl_Error.setText("Insert a password");
//						clbl_Error.setVisible(true);
//					}
//				}
//				
//				//Just close the shell
//				auth = true;
//				shell.close();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		final Button btn_login = new Button(composite, SWT.FLAT);
		final FormData formData = new FormData();
//		formData.bottom = new FormAttachment(0, 28);
		formData.top = new FormAttachment(txt_Password, 10);
		formData.right = new FormAttachment(50,20);
		formData.left = new FormAttachment(50,-20);
		if(SystemUtils.IS_OS_UNIX){
			formData.right = new FormAttachment(50,30);
			formData.left = new FormAttachment(50,-30);
		}
		btn_login.setLayoutData(formData);
		btn_login.setText("Login");

		//Adding CLOSE action to this button.
		btn_login.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event e) {
				
				//Integration with IDM				
//				String username = txt_Username.getText();
//				String password = txt_Password.getText();
//				
//				if(!username.equals("") && !password.equals("")){
//
//					int result = IdMClient.authenticate(username, password);
//					//						if(result = (Boolean) null){
//					//							JOptionPane.showMessageDialog(null, "Unable to connect to the IDM Service", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
//					//							System.out.println("Unable to connect to the IDM Service");
//					//						}
//					System.out.println(result);
//					if(result == Data.AUTHTRUE){
//						shell.close();
//						auth = true;
//					} else if(result == Data.AUTHFALSE) {
//						clbl_Error.setText("Username and/or password not valid");
//						clbl_Error.setVisible(true);
//						auth = false;
//					} else if(result == Data.AUTHERROR) {
//						clbl_Error.setText("Unable to connect to the IDM service");
//						clbl_Error.setVisible(true);
//						auth = false;
//					}
//
//				} else if(username.equals("")){
//					clbl_Error.setText("Insert a username");
//					clbl_Error.setVisible(true);
//				} else if(password.equals("")){
//					clbl_Error.setText("Insert a password");
//					clbl_Error.setVisible(true);
//				}
				
				//Just close the shell
				auth = true;
				shell.close();
			}
		});
		
		clbl_Error = new CLabel(composite, SWT.CENTER);
		final FormData formData_5 = new FormData();
		formData_5.top = new FormAttachment(btn_login,10);
		formData_5.right = new FormAttachment(50,120);
		formData_5.left = new FormAttachment(50,-120);
		clbl_Error.setLayoutData(formData_5);
		clbl_Error.setVisible(false);
		clbl_Error.setBackgroundImage(img);
		
		final Button btn_settings = new Button(composite, SWT.FLAT);
		final FormData formData_6 = new FormData();
		formData_6.top = new FormAttachment(clbl_Error, 10);
		
		formData_6.left = new FormAttachment(0,10);
		btn_settings.setLayoutData(formData_6);
		btn_settings.setText("Settings");
		
		btn_settings.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event e) {
				SettingsDialog dialog = new SettingsDialog(display);
				dialog.createContents();
			}
		});


		shell.setSize(388, 220);
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 388) / 2;
		final int y = (screenSize.height - 220) / 2;
		shell.setLocation(x, y);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();
		return auth;
	}

}
