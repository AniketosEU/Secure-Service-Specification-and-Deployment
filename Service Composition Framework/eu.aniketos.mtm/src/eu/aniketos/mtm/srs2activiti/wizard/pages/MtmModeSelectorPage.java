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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MtmModeSelectorPage extends CustomPage {
	public static final int SELECTION_SKELETON = 0;
	public static final int SELECTION_MAPPING = 1;
	
	private Button skeletonButton;
	private Button mappingButton;
	
	private String msg = "Select the transformation mode. ";
	private String msgWarning = "Select the transformation mode. The functionality that helps completing an existing BPMN from a SRS is not available yet.";
	
	public MtmModeSelectorPage() {
		super("MtmModeSelectorPage");
		setTitle("Transformation Mode");
		setDescription(msg);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite =  new Composite(parent, SWT.FILL);
		GridLayout gl = new GridLayout();
		gl.numColumns = 1;
		composite.setLayout(gl);
		
		skeletonButton = new Button (composite, SWT.RADIO);
		skeletonButton.setText("Create BPMN Skeleton from SRS");
		
		mappingButton = new Button (composite, SWT.RADIO);
		mappingButton.setText("Complete existing BPMN from SRS");
		
		skeletonButton.setSelection(true);
		
		addListeners();
	    setControl(composite);
		setPageComplete(isReady());
		
	}
	
	@Override
	protected void pageComplete() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean canFlipToNextPage() {
		return isReady();
	}
	
	private boolean isReady() {
		if(skeletonButton.getSelection() || mappingButton.getSelection()) {
			return true;
		}		
		return false;
	}
	
	public int getSelection() {
		if(skeletonButton.getSelection()) {
			return SELECTION_SKELETON;
		}
		if(mappingButton.getSelection()) {
			return SELECTION_MAPPING;
		}
		return -1;
	}
	
	private void addListeners() {
		mappingButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setMessage(msgWarning, WARNING);
				super.widgetSelected(e);
			}
		});
		skeletonButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setMessage(msg);
				super.widgetSelected(e);
			}
		});
	}

}
