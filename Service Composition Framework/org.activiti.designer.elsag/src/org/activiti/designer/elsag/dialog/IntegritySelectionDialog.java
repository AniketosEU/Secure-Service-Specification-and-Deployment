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
import java.util.List;

import org.activiti.designer.elsag.gui.property.PropertyAniketosServiceTaskSection;
import org.apache.log4j.Logger;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class IntegritySelectionDialog {
	
	final private static Logger log = Logger.getLogger(IntegritySelectionDialog.class);

	private Display display;
	private PropertyAniketosServiceTaskSection section;
	private java.util.List<ServiceTask> serviceTasks;
	private String taskId;

	public IntegritySelectionDialog(Display display, PropertyAniketosServiceTaskSection section, java.util.List<ServiceTask> serviceTasks, String taskId) {
		this.display = display;
		this.section = section;
		this.serviceTasks = serviceTasks;
		this.taskId = taskId;
	}

	public void createContents() {

		final Shell shell = new Shell(display, SWT.APPLICATION_MODAL | SWT.CLOSE | SWT.RESIZE);
		shell.setText("Add Integrity Requirement");
		GridLayout layout = new GridLayout(4,false);
		shell.setLayout(layout);

		final Composite compositeService = new Composite(shell, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
		compositeService.setLayoutData(gridData);
		compositeService.setLayout(new GridLayout(2, false));

		CLabel integrityLabel = new CLabel(compositeService, SWT.NONE);
		integrityLabel.setText("Integrity check with ");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        gridData.widthHint = 140;
	    integrityLabel.setLayoutData(gridData);
	    
	    final CCombo comboIntegrity = new CCombo(compositeService, SWT.BORDER);
	    comboIntegrity.setEnabled(true);
	    List<ServiceTask> servicetasks = serviceTasks;
	    String[] items = new String[servicetasks.size()-1];
	    int c = 0;
		for(int i=0; i<servicetasks.size(); i++){
			if(!taskId.equals(servicetasks.get(i).getId())){
				String taskId = servicetasks.get(i).getId();
				String taskName = servicetasks.get(i).getName();
				items[c]= taskId + " - " + taskName;
				c++;
			}
		}
		
		comboIntegrity.setItems(items);
		
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        comboIntegrity.setLayoutData(gridData);
	    comboIntegrity.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
				
			}
	    	
	    });
	    
		final Composite compositeType = new Composite(shell, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        compositeType.setLayoutData(gridData);
        compositeType.setLayout(new GridLayout(2, false));
	    
	    CLabel integrityTypeLabel = new CLabel(compositeType, SWT.NONE);
		integrityTypeLabel.setText("Type:");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
	    integrityTypeLabel.setLayoutData(gridData);
	    
	    final Text typeIntegrityText = new Text(compositeType, SWT.BORDER);
	    gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
	    typeIntegrityText.setLayoutData(gridData);
	    
		final Composite compositeAlg = new Composite(shell, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        compositeAlg.setLayoutData(gridData);
        compositeAlg.setLayout(new GridLayout(2, false));
	    
	    CLabel integrityAlgLabel = new CLabel(compositeAlg, SWT.NONE);
		integrityAlgLabel.setText("Algorithm:");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        gridData.widthHint = 80;
	    integrityAlgLabel.setLayoutData(gridData);
	    
	    final CCombo algIntegrityCombo = new CCombo(compositeAlg, SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
	    algIntegrityCombo.setLayoutData(gridData);
	    String[] algorithms = new String[2];
	    algorithms[0] = "Sha1";
	    algorithms[1] = "Sha256";
	    algIntegrityCombo.setItems(algorithms);

	    final Button okButton = new Button(shell, SWT.BUTTON1);
	    okButton.setText("Add");
	    gridData = new GridData(SWT.CENTER, SWT.FILL, true, false);
        gridData.horizontalSpan= 1;
        gridData.widthHint = 50;
	    okButton.setLayoutData(gridData);
	    okButton.addSelectionListener(new SelectionListener(){

	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    		String with = comboIntegrity.getText();

	    		SecurityExtension securityExtension = section.getSecurityExtension();
	    		if(securityExtension != null){
	    			List<Integrity> listIntegrity = securityExtension.getIntegrityReq();
	    			if(listIntegrity != null){
	    				if(listIntegrity.size()>0){
	    					boolean added = false;
	    					Integrity[] integrityReq = (Integrity[]) listIntegrity.toArray();
	    					for(int i = 0; i<integrityReq.length; i++){
	    						String w = integrityReq[i].getWith();
	    						if(w.equals(with)){
	    							added = true;
	    							log.debug(with +" already added");
	    							break;
	    						} else {
	    							added = false;
	    							log.debug(with +" to be added");
	    						}
	    					}
	    					if(!added && !comboIntegrity.getText().equals("")){
	    						String[] items = new String[listIntegrity.size()+1];
	    						Integrity[] integrityArray = (Integrity[]) listIntegrity.toArray();
	    						for(int j=0; j<integrityArray.length; j++){
	    							String wi = integrityArray[j].getWith();
	    							items[j] = wi;
	    						}
	    						items[listIntegrity.size()]= comboIntegrity.getText();
	    						PropertyAniketosServiceTaskSection.setComboIntegrity(items);
	    						section.saveIntegrityExtension(typeIntegrityText.getText(),with,algIntegrityCombo.getText());
	    					} else if(comboIntegrity.getText().equals("")){
	    						log.debug("insert valid != null");
	    					}
	    				} else {
	    					String[] items = new String[1];
	    					items[0]= comboIntegrity.getText();
	    					PropertyAniketosServiceTaskSection.setComboIntegrity(items);
	    					section.saveIntegrityExtension(typeIntegrityText.getText(),with,algIntegrityCombo.getText());
	    				}
	    			} else {
	    				String[] items = new String[1];
	    				items[0]= comboIntegrity.getText();
	    				PropertyAniketosServiceTaskSection.setComboIntegrity(items);
	    				section.saveIntegrityExtension(typeIntegrityText.getText(),with,algIntegrityCombo.getText());
	    			}
	    		} else {
	    			section.saveSecurityExtension();
	    			String[] items = new String[1];
    				items[0]= comboIntegrity.getText();
    				PropertyAniketosServiceTaskSection.setComboIntegrity(items);
    				section.saveIntegrityExtension(typeIntegrityText.getText(),with,algIntegrityCombo.getText());
	    		}

	    		shell.close();
	    	}

	    		@Override
	    		public void widgetDefaultSelected(SelectionEvent e) {

	    		}

	    	});

	    shell.setSize(800, 100);
	    final Toolkit toolkit = Toolkit.getDefaultToolkit();
	    final Dimension screenSize = toolkit.getScreenSize();
	    final int x = (screenSize.width - 800) / 2;
	    final int y = (screenSize.height - 100) / 2;
	    shell.setLocation(x, y);
	    shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch())
	    		display.sleep();
	    }

	    shell.dispose();
	}



}

