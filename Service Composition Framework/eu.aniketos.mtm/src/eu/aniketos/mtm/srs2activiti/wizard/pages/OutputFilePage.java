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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * Page for entering the output path.
 *
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class OutputFilePage extends CustomPage {
	
	private Text fileText;
	private Button fileButton;
	
	private String[] filterExtensions;
	private String suggestedPath;
	
	private FileDialog fileDialog = null;

	/**
	 * Constructor.
	 * @param filterExtensions Wildcards for the output name.
	 */
	public  OutputFilePage(String[] filterExtensions) {
		this(filterExtensions, "");
	}
	
	/**
	 * Constructor.
	 * @param filterExtensions Wildcards for the output name.
	 * @param outputPath Default file name (with path) for the output file.
	 */
	public  OutputFilePage(String[] filterExtensions, String outputPath) {
		super("OutputFilePage");
		setTitle("Output file");
		setDescription("Select output file");
	    
	    this.filterExtensions = filterExtensions;
	    this.suggestedPath = outputPath;
	}

	/**
	 * 
	 */
	@Override
	public void createControl(Composite parent) {
		GridData gd;
		
		Composite composite =  new Composite(parent, SWT.FILL);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		composite.setLayout(gl);
		
		final int textWidth = 600;
		
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.widthHint = textWidth;
		fileText = new Text(composite, SWT.BORDER);
		fileText.setEditable(false);
		fileText.setLayoutData(gd);
		fileText.setText(suggestedPath);

        fileButton = new Button(composite, SWT.PUSH);
        fileButton.setText("Browse...");
	    
	    addListeners();
	    setControl(composite);
		setPageComplete(isReady());
	}
	
	/**
	 * Adds a listener for the "Browse" button.
	 */
	private void addListeners() {
        fileButton.addSelectionListener(new SelectionAdapter() {
        	@Override
            public void widgetSelected(final SelectionEvent e) {
                browse();
            }
        });
	}

	/**
	 * 
	 */
	@Override
	protected void pageComplete() {
	}
	
	/**
	 * "Next" button disabled.
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
	
	/**
	 * Checks whether the form is full-filled.
	 * @return True when full-filled, false otherwise.
	 */
	private boolean isReady() {
		if(!isTextNonEmpty(fileText)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Opens a dialog for browsing the output file.
	 */
	private void browse() {
		if(fileDialog == null) {
			fileDialog = new FileDialog(getContainer().getShell(), SWT.SAVE);
		    fileDialog.setFilterExtensions(filterExtensions);
		    fileDialog.setFileName(fileText.getText());
		}
        String file = fileDialog.open();
        if (file != null) {
            fileText.setText(file);
            setPageComplete(isReady());
        }
    }
	
	/**
	 * Gets the entered output path.
	 * @return The output file name (with path).
	 */
	public String getFilePath() {
		return fileText.getText();
	}

}
