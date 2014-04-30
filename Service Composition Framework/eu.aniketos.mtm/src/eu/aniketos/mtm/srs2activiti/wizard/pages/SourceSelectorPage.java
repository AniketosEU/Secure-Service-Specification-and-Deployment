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
package eu.aniketos.mtm.srs2activiti.wizard.pages;

import java.io.File;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.utils.Utils;

public class SourceSelectorPage extends CustomPage {
	private static final String[] FILTERS_SRS = {"*.xml", "*.srs"};
	private static final String[] FILTERS_BPMN = {"*.activiti"};
	private static final String[] FILTERS_MAPPING = {"*.mapping"};
	
	private Text srsText;
	private Button srsButton;

	private Text bpmnText;
	private Button bpmnButton;

	private Text mappingText;
	private Button mappingButton;
	
	private FileDialog srsDialog = null;
	private FileDialog bpmnDialog = null;
	private FileDialog mappingDialog = null;
	
	private String basePath = null;
	
	public SourceSelectorPage() {
		super("SourceSelectorPage");
		setTitle("Source models selection");
		setDescription("Select the source models");
	}
	
	public SourceSelectorPage(String basePath) {
		this();
		
		this.basePath = basePath;
	}
	
	@Override
	public void createControl(Composite parent) {
		GridData gd;
		
		Composite composite =  new Composite(parent, SWT.FILL);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		composite.setLayout(gl);
		
		final int textWidth = 600;
		
		gd = new GridData();
		gd.horizontalSpan = 2;
		Label srsLabel = new Label(composite, SWT.FILL);
		srsLabel.setText("SRS model");
		srsLabel.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.widthHint = textWidth;
		srsText = new Text(composite, SWT.BORDER);
		srsText.setEditable(false);
		srsText.setLayoutData(gd);
		srsText.setText("");

        srsButton = new Button(composite, SWT.PUSH);
        srsButton.setText("Browse...");

		gd = new GridData();
		gd.horizontalSpan = 2;
		Label bpmnLabel = new Label(composite, SWT.FILL);
		bpmnLabel.setText("BPMN Activiti model");
		bpmnLabel.setLayoutData(gd);
        
        gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.widthHint = textWidth;
		bpmnText = new Text(composite, SWT.BORDER);
		bpmnText.setEditable(false);
		bpmnText.setLayoutData(gd);
		bpmnText.setText("");

		bpmnButton = new Button(composite, SWT.PUSH);
		bpmnButton.setText("Browse...");
		
		gd = new GridData();
		gd.horizontalSpan = 2;
		Label mappingLabel = new Label(composite, SWT.FILL);
		mappingLabel.setText("Mapping model (optional)");
		mappingLabel.setLayoutData(gd);
		
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.widthHint = textWidth;
		mappingText = new Text(composite, SWT.BORDER);
		mappingText.setEditable(false);
		mappingText.setLayoutData(gd);
		mappingText.setText("");

		mappingButton = new Button(composite, SWT.PUSH);
		mappingButton.setText("Browse...");
		
		if(basePath != null && basePath.length() > 0) {
			updateFileInputs(basePath);
		}
	    
	    addListeners();
	    setControl(composite);
		setPageComplete(isReady());
	}
	
	private void addListeners() {
        srsButton.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(final SelectionEvent e) {
        		browseSrs();
            }
        });
        bpmnButton.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(final SelectionEvent e) {
        		browseBpmn();
            }
        });
        mappingButton.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(final SelectionEvent e) {
        		browseMapping();
            }
        });
	}
	
	private void updateFileInputs(String file) {
		fillSrsPath(file);
		fillBpmnPath(file);
    	fillMappingPath(file);
	}
	
	private void browseSrs() {
		if(srsDialog == null) {
			srsDialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
		    srsDialog.setFilterExtensions(FILTERS_SRS);
		    srsDialog.setFileName(srsText.getText());
		}
        String file = srsDialog.open();
        if (file != null) {
        	srsText.setText(file);
        	fillBpmnPath(file);
        	fillMappingPath(file);
            setPageComplete(isReady());
        }
    }
	
	private void browseBpmn() {
		if(bpmnDialog == null) {
			bpmnDialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
			bpmnDialog.setFilterExtensions(FILTERS_BPMN);
			bpmnDialog.setFileName(bpmnText.getText());
		}
        String file = bpmnDialog.open();
        if (file != null) {
        	bpmnText.setText(file);
        	fillSrsPath(file);
        	fillMappingPath(file);
            setPageComplete(isReady());
        }
    }
	
	private void browseMapping() {
		if(mappingDialog == null) {
			mappingDialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
			mappingDialog.setFilterExtensions(FILTERS_MAPPING);
			mappingDialog.setFileName(mappingText.getText());
		}
        String file = mappingDialog.open();
        if (file != null) {
        	mappingText.setText(file);
        	fillSrsPath(file);
        	fillBpmnPath(file);
            setPageComplete(isReady());
        }
    }
	
	private void fillSrsPath(String originPath) {
		final String SRS_EXTENSION = "xml";
		String currentText = srsText.getText();
		if(currentText == null || currentText.length() == 0) {
			String targetPath = Utils.replaceExtension(originPath, SRS_EXTENSION);
			File file = new File(targetPath);
			if(file != null && file.exists()) {
				srsText.setText(targetPath);
			}
		}
	}
	
	private void fillMappingPath(String originPath) {
		final String MAPPING_EXTENSION = "mapping";
		String currentText = mappingText.getText();
		if(currentText == null || currentText.length() == 0) {
			String targetPath = Utils.replaceExtension(originPath, MAPPING_EXTENSION);
			File file = new File(targetPath);
			if(file != null && file.exists()) {
				mappingText.setText(targetPath);
			}
		}
	}
	
	private void fillBpmnPath(String originPath) {
		final String BPMN_EXTENSION = "activiti";
		String currentText = bpmnText.getText();
		if(currentText == null || currentText.length() == 0) {
			String targetPath = Utils.replaceExtension(originPath, BPMN_EXTENSION);
			File file = new File(targetPath);
			if(file != null && file.exists()) {
				bpmnText.setText(targetPath);
			}
		}
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return isReady();
	}
	
	private boolean isReady() {
		if(!isTextNonEmpty(srsText) || !isTextNonEmpty(bpmnText)) {
			return false;
		}
		else{
			setMessage("The functionality that helps completing an existing BPMN from a SRS is not available yet.", DialogPage.WARNING);
		}
		// TODO change when the wizard for completing an existing BPMN from SRS exists -- > return true
		return false; 
	}

	@Override
	protected void pageComplete() {
		// TODO Auto-generated method stub

	}
	
	public String getSrsFile() {
		return srsText.getText();
	}
	
	public String getBpmnFile() {
		return bpmnText.getText();
	}
	
	public String getMappingFile() {
		return mappingText.getText();
	}

}
