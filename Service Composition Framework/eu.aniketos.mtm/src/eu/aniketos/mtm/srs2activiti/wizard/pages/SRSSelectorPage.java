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

public class SRSSelectorPage extends CustomPage {

	private static final String[] FILTERS_SRS = {"*.xml", "*.srs"};
	private Text srsText;
	private Button srsButton;
	
	private FileDialog srsDialog = null;
	
	public SRSSelectorPage() {
		super("SRSSelectorPage");
		setTitle("SRS selection");
		setDescription("Select the SRS (Security Requirement Specification).");
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
        
        addListeners();
        setControl(composite);
		setPageComplete(isReady());

	}
	
	@Override
	protected void pageComplete() {	
		
	}
	
	private void addListeners() {
		srsButton.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(final SelectionEvent e) {
        		browseSrs();
            }
        });
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
        	setPageComplete(isReady());
        }
    }
	
	private boolean isReady() {
		if(!isTextNonEmpty(srsText)) {
			return false;
		}
		else{
			setMessage("Please click the Finish button to start a new wizard that will guide you in the BPMN generation from the SRS you have selected.", DialogPage.INFORMATION);
			return true;
		}		
	}
	
	public String getSrsFile() {
		return srsText.getText();
	}
	
	/**
	 * It controls whether "Next" button is disabled or not.
	 */
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}
	
	/**
	 * "Finish" button enabled when the form is full-filled.
	 */
	@Override
	public boolean canFinish() {
		return isPageComplete();
	}

}
