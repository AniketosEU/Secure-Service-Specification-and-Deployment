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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.xml.XMLParser;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.data.impl.CompositionPlan;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class SRCMDialog {
	
	private Diagram diagram;
	private Display display;
	
	final private static Logger log = Logger.getLogger(SRCMDialog.class);
	
	public SRCMDialog(Display display, Diagram diagram) {
		this.display = display;
		this.diagram = diagram;
	}

	public void createContents() {
		
		final Properties prop = Activator.getConfigProperties();
		
		final Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setText("Check SRS Compliance");

		final Composite composite = new Composite(shell, SWT.NONE);
		final FormLayout formLayout= new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		composite.setLayout(formLayout);

		FormData data;
		
		final Text srsPathText = new Text(composite, SWT.BORDER);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(70, 0);
	    data.top = new FormAttachment(0, 20);
	    srsPathText.setLayoutData(data);

	    Button srsButton = new Button(composite, SWT.BUTTON1);
	    srsButton.setText("Select SRS file");
	    data = new FormData();
	    data.left = new FormAttachment(srsPathText, 10);
//	    data1.right = new FormAttachment(50, 30);
	    data.top = new FormAttachment(0, 20);
	    srsButton.setLayoutData(data);
	    srsButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		FileDialog dialog = new FileDialog(shell, SWT.NULL);
	    		String[] extension = new String[2];
	    		extension[0] = "*.xml";
	    		extension[1] = "*.srs";
	    		dialog.setFilterExtensions(extension);
	    		String path = dialog.open();
	    		if (path != null) {

	    			File file = new File(path);
	    			if (file.isFile())
	    				displayFiles(new String[] { file.toString()});
	    			else
	    				displayFiles(file.list());

	    		}
	    	}
	    	
	    	private void displayFiles(String[] files) {
	    		for (int i = 0; files != null && i < files.length; i++) {
	    			srsPathText.setText(files[i]);
	    			srsPathText.setEditable(true);
	    		}
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    final Text mappingPathText = new Text(composite, SWT.BORDER);
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.right = new FormAttachment(70, 0);
	    data.top = new FormAttachment(srsPathText, 20);
	    mappingPathText.setLayoutData(data);

	    Button mappingButton = new Button(composite, SWT.BUTTON1);
	    mappingButton.setText("Select mapping file");
	    data = new FormData();
	    data.left = new FormAttachment(mappingPathText, 10);
	    data.top = new FormAttachment(srsPathText, 20);
	    mappingButton.setLayoutData(data);
	    mappingButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		
	    		FileDialog dialog = new FileDialog(shell, SWT.NULL);
	    		String[] extension = new String[1];
	    		extension[0] = "*.mapping";
	    		dialog.setFilterExtensions(extension);
	    		String path = dialog.open();
	    		if (path != null) {

	    			File file = new File(path);
	    			if (file.isFile())
	    				displayFiles(new String[] { file.toString()});
	    			else
	    				displayFiles(file.list());

	    		}
	    	}
	    	
	    	private void displayFiles(String[] files) {
	    		for (int i = 0; files != null && i < files.length; i++) {
	    			mappingPathText.setText(files[i]);
	    			mappingPathText.setEditable(true);
	    		}
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    Button checkButton = new Button(composite, SWT.BUTTON1);
	    checkButton.setText("Check");
	    data = new FormData();
	    data.left = new FormAttachment(50, -55);
	    data.right = new FormAttachment(50, 55);
	    data.top = new FormAttachment(mappingPathText, 20);
	    checkButton.setLayoutData(data);
	    checkButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		final String srsPath = srsPathText.getText();
	    		String s = "";
				try {
					s = XMLParser.convertXMLFileToString(srsPath);
				} catch (IOException e1) {
					log.error(e1);
				}
				final String srs = s;
	    		final String mappingPath = mappingPathText.getText();
	    		String m = "";
	    		try {
					m = XMLParser.convertXMLFileToString(mappingPath);
				} catch (IOException e1) {
					log.error(e1);
				}
	    		final String mapping = m;
	    		Job job = new Job("Checking the SRS compliance") {
	    			protected IStatus run(IProgressMonitor monitor) {

	    				URI uri = diagram.eResource().getURI();
	    				URI bpmnUri = uri.trimFragment();
	    				bpmnUri = bpmnUri.trimFileExtension();
	    				bpmnUri = bpmnUri.appendFileExtension("srcm");
	    				
	    				URI activitiUri = uri.trimFragment();
	    				activitiUri = activitiUri.trimFileExtension();
	    				activitiUri = activitiUri.appendFileExtension("activiti");
	    				
	    				String activitiPlatformString = activitiUri.toPlatformString(true);
	    				IResource fileActivitiResource = ResourcesPlugin.getWorkspace().getRoot().findMember(activitiPlatformString);

	    				String platformString = bpmnUri.toPlatformString(true);
	    				final IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
	    				if(fileResource != null){
	    					String serviceSpecification = "";
	    					String activitiFileString = "";
	    					try{
	    						serviceSpecification = XMLParser.convertXMLFileToString(fileResource.getLocation().toString());
	    						activitiFileString = XMLParser.convertXMLFileToString(fileActivitiResource.getLocation().toString());
	    					} catch (IOException e) {
	    						return Status.CANCEL_STATUS;
	    					}

	    					ICompositionPlan compositionPlan = new CompositionPlan(serviceSpecification);
	    					compositionPlan.setActivitiFile(activitiFileString);
	    					ServiceCompositionFrameworkInterface scf = org.activiti.designer.elsag.Activator.getDefault().getServiceCompositionFramework();
	    					scf.setProxy(prop.getProperty("proxyHost"), prop.getProperty("proxyPort"), prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));
	    					String status = scf.checkBPMNSpecificationWithSRCM(compositionPlan, srs, mapping, prop.getProperty("SRCMAddress"));
	    					List<String> satisfiedRequirements = null;
	    					if(status!=null){
	    						if(status.contains("ERROR")){
		    						Display.getDefault().asyncExec(new Runnable() {
		    							public void run() {
		    								shell.close();
		    							}
		    						});
		    						log.error("Status contains ERROR message");
		    						showErrorMessage(status);
		    						return Status.CANCEL_STATUS;
	    						} else {
	    							satisfiedRequirements = getSatisifiedRequirements(status);
	    						}
	    					} else {
	    						Display.getDefault().asyncExec(new Runnable() {
	    							public void run() {
	    								shell.close();
	    							}
	    						});
	    						log.error("SRCM not found");
	    						showErrorMessage("SRCM not found!");
	    						return Status.CANCEL_STATUS;
	    					}
	    					if(satisfiedRequirements.size()>0){

	    						Display.getDefault().asyncExec(new Runnable() {
	    							public void run() {
	    								shell.close();
	    							}
	    						});
	    						log.info("SRCM has returned the satisfied requirements");
	    						showOkMessage(satisfiedRequirements);
	    						return Status.OK_STATUS;
	    					} else {
	    						Display.getDefault().asyncExec(new Runnable() {
	    							public void run() {
	    								shell.close();
	    							}
	    						});
	    						log.error("The BPMN specification is not compliant with the SRS file");
	    						showErrorMessage("The BPMN specification is not compliant with the SRS file");
	    						return Status.CANCEL_STATUS;
	    					}
	    				}
	    				return Status.CANCEL_STATUS;
	    			}
	    		};
	    		job.setUser(true);
	    		job.schedule();
	    	}


	    	@Override
	    	public void widgetDefaultSelected(SelectionEvent e) {

	    	}

	    });
	    
	    shell.setSize(500, 200);
	    final Toolkit toolkit = Toolkit.getDefaultToolkit();
	    final Dimension screenSize = toolkit.getScreenSize();
	    final int x = (screenSize.width - 500) / 2;
	    final int y = (screenSize.height - 200) / 2;
	    shell.setLocation(x, y);
	    shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch())
	    		display.sleep();
	    }

	    shell.dispose();
	}

	private void showOkMessage(final List<String> satisfiedRequirements) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				String title = "Response from SRCM:\n";
				String message = "";
				for(String req : satisfiedRequirements){
					message = message + req +  "\n";
				}
				message = title + message;
				MessageDialog.openInformation(display.getActiveShell(), "SRCM Result",
						message);
			}
		});

	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), "SRCM Result",message);
			}
		});

	}
	
	private List<String> getSatisifiedRequirements(String status){

		SAXBuilder builder = new SAXBuilder();

		Document doc = null;

		try {
			InputStream is = new ByteArrayInputStream(status.getBytes("UTF-8"));
			doc = (Document) builder.build(is);

		} catch (UnsupportedEncodingException e) {
			log.error(e);
		} catch (JDOMException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		List<String> requirements = new Vector<String>();
		Element output = doc.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> children = output.getChildren();

		for(Element child : children){
			if(child.getName().equals("sat")){
				@SuppressWarnings("unchecked")
				List<Element> commitments = child.getChildren("commitment");
				for(Element commitment : commitments){
					String req = commitment.getAttributeValue("type");
					String target = commitment.getChildText("target");
					requirements.add(req + " satisfied for target " + target);
				}
			} else if(child.getName().equals("unsat")){
				@SuppressWarnings("unchecked")
				List<Element> commitments = child.getChildren("commitment");
				for(Element commitment : commitments){
					String req = commitment.getAttributeValue("type");
					String target = commitment.getChildText("target");
					requirements.add(req + " not satisfied for target " + target);
				}
			} else if(child.getName().equals("undec")){

			}
		}
		return requirements;
	}

}

