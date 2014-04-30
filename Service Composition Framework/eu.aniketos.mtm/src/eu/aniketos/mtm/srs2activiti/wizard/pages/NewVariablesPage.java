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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.VarType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;

/**
 * 
 * Page used to establish the correspondences between SRS documents and BPMN variables (1:1 relationship).
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public class NewVariablesPage extends CustomPage implements Listener {
	private static final String PREFIX = "variable_";
	
	// Input documents
	private Map<String, List<DocType>> documentMap;
	
	// List of variable values
	private ArrayList<Text> variableValueList;
	
	// Main scrollable composite
	private ScrolledComposite scrollComposite;
	
	/**
	 * Constructor.
	 * @param srs The SecReqSpeType root SRS element to be transformed.
	 */
	public NewVariablesPage(SecReqSpeType srs) {
		super("NewVariablesPage");
		setTitle("Variables mapping");
		setDescription("Map SRS Documents to BPMN Variables");

		documentMap = SrsManager.getInstance().extractRelatedDocuments(srs);
		int sizeList = documentMap.size();
		variableValueList = new ArrayList<Text>(sizeList);
	}

	/**
	 * 
	 */
	@Override
	public void createControl(Composite parent) {
		scrollComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		
		Composite composite =  new Composite(scrollComposite, SWT.FILL);
		GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		composite.setLayout(gl);

		// Main control skeleton for the document/variable correspondence
		createMainControls(composite);

		// Scrollable parent composite
		scrollComposite.setContent(composite);
		scrollComposite.setExpandVertical(true);
		scrollComposite.setExpandHorizontal(true);
		scrollComposite.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				updateScroll();
			}
		});
		
		addListeners();
		setControl(scrollComposite);
		setPageComplete(isReady());
		
	}
	/**
	 * Creates the main control skeleton for the document/variable correspondence.
	 * @param composite The parent composite
	 */
	private void createMainControls(Composite composite) {	
		variableValueList.clear();
		
		if(documentMap.size() == 0) {
			// No documents found
			Label emptyLabel = new Label(composite, SWT.NULL);
			emptyLabel.setText("No valid SRS Documents found");
			return;
		}
		
		GridData gd;
		
		// Column titles
		Label documentsLabel = new Label(composite, SWT.NULL);
		documentsLabel.setText("SRS Documents");
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		Label activitiLabel = new Label(composite, SWT.NULL);
		activitiLabel.setText("ACTIVITI Variables");
		activitiLabel.setLayoutData(gd);
		
		GridLayout glRight = new GridLayout();
		glRight.numColumns = 2;
		
		final int textWidth = 300;
		
		// For every document...
		for(String docName : documentMap.keySet()) {
			// Fill document description labels
			String documentValue = docName.trim();
			String documentString = documentValue;
			Label documentIdLabel = new Label(composite, SWT.NULL);
			documentIdLabel.setText(documentString);

			gd = new GridData();
			gd.horizontalAlignment = SWT.FILL;
			Composite activitiComposite =  new Composite(composite, SWT.NULL);
			activitiComposite.setLayout(glRight);
			activitiComposite.setLayoutData(gd);
			
			// Add the variable controls for this document
			Label variableValueLabel = new Label(activitiComposite, SWT.NULL);
			variableValueLabel.setText("Name:");
			gd = new GridData();
			gd.horizontalAlignment = SWT.FILL;
			gd.widthHint = textWidth;
			Text variableValueText = new Text(activitiComposite, SWT.BORDER);
			variableValueText.setText(documentValue.replaceAll(" ", "_"));
			variableValueText.setLayoutData(gd);
			
			variableValueList.add(variableValueText);
		}
	}
	
	/**
	 * Adds listeners to controls.
	 */
	private void addListeners() {
		addDocumentListeners();
	}
	
	/**
	 * Adds listeners to check when Text controls are changed.
	 */
	private void addDocumentListeners() {
		for(Text text : variableValueList) {
			text.addListener(SWT.CHANGED, this);
		}
	}

	/**
	 * Checks whether the form is full-filled when writing on a text control.
	 */
	@Override
	public void handleEvent(Event event) {
		if(event.type == SWT.CHANGED) {
			setPageComplete(isReady());
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return documentMap.size() == 0;
	}

	/**
	 * Updates the mapping model.
	 */
	@Override
	protected void pageComplete() {
		updateModel();
	}
	
	/**
	 * 
	 */
	@Override
	public boolean canFlipToNextPage() {
		return isPageComplete();
	}
	
	/**
	 * Finish button disabled.
	 */
	@Override
	public boolean canFinish() {
		return false;
	}
	
	/**
	 * Checks whether the form is full-filled.
	 * @return True when full-filled, false when a Text control is empty.
	 */
	private boolean isReady() {
		return isDocumentsReady();
	}
	
	/**
	 * Checks whether the variable Text controls are full-filled.
	 * @return True when full-filled, false when a Text control is empty.
	 */
	private boolean isDocumentsReady() {
		for(Text text : variableValueList) {
			if(!isTextNonEmpty(text)) {
				setErrorMessage("There are empty fields.");
				return false;
			}
		}

		boolean unrepeated = isUnrepeated1D(variableValueList);
		if(!unrepeated) {
			setErrorMessage("Variable names cannot be repeated.");
		} else {
			setErrorMessage(null);
		}
		return unrepeated;
	}
	
	/**
	 * Updates the mapping model based on the page form.
	 */
	private void updateModel() {
		int size = documentMap.size();
		if(size > 0) {
			MappingType mapping = ((Srs2ActivitiWizard)getWizard()).getMapping();
			MappingManager manager = MappingManager.getInstance();
			// Clear the existing represents relationships
			manager.resetRepresentsList(mapping);
			// For every document...
			int i = 0;
			for (String docName : documentMap.keySet()) {
				List<eu.aniketos.mtm.mapping.DocType> mappedDocList = new ArrayList<eu.aniketos.mtm.mapping.DocType>();
				for (DocType docType : documentMap.get(docName)) {
					// Create the document mapping element
					eu.aniketos.mtm.mapping.DocType document = manager.createDocument(docType.getId(), docType.getValue().trim());
					mappedDocList.add(document);
				}
				Text valueText = variableValueList.get(i);
				// Create the variable mapping element
				String variableId = PREFIX + i+1;
				VarType var = manager.createVariable(variableId, valueText.getText().trim(), 0);
				// Create and add the represents relationship
				RepresentsType represents = manager.createRepresents(mappedDocList, var);
				manager.addRepresents(mapping, represents);
				i++;
			}
		}
	}
	
	/**
	 * Updates the main scrollbar.
	 */
	private void updateScroll() {
		Rectangle r = scrollComposite.getClientArea();
		scrollComposite.setMinSize(scrollComposite.getChildren()[0].computeSize(r.width, SWT.DEFAULT));
	}

}
