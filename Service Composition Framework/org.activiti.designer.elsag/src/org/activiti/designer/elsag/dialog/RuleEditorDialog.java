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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import org.activiti.designer.elsag.gui.property.PropertyAniketosRuleSection;
import org.apache.log4j.Logger;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.Trustworthiness;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.mihalis.opal.checkBoxGroup.CheckBoxGroup;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class RuleEditorDialog {

	private Diagram diagram;
	private Display display;

	private CCombo serviceCombo;
	private CCombo eventCombo;
	private CCombo taskCombo;
	private CCombo valueCombo;
	private CCombo descriptionCombo;
	private Text threatText;
	private Text valueText;
	private Text processText;
	private List list;
	private Label taskLabel;
	private Label threatLabel;
	private Label descriptionLabel;
	private CheckBoxGroup changeRuntimeGroup;
	private CheckBoxGroup launchProcessGroup;
	private Button recButton;
	private Button recompositionButton;
	private Button reconfigurationButton;
	private Button checkButton;
	private Button stopButton;
	private Button anywhereButton;
	private Button constrainedButton;
	private Button createButton;
	private String ruleIdToEdit;
	
private static final String FILENAME_PATTERN = "$originalNameWithoutExtension";
	
	private static final String DATE_TIME_PATTERN = "yyyy-MM-dd-HH-mm-ss";
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_TIME_PATTERN);

	private static final String REGEX_DATE_TIME = "\\" + "$dateTime" + "";
	private static final String REGEX_FILENAME = "\\" + "$originalFile" + "";
	private static final String REGEX_FILENAME_WITHOUT_EXTENSION = "\\" + "$originalNameWithoutExtension" + "";
	private static final String REGEX_EXTENSION = "\\" + "$originalExtension" + "";

	final private static Logger log = Logger.getLogger(RuleEditorDialog.class);
	
	public RuleEditorDialog(Display display, Diagram diagram) {
		this.display = display;
		this.diagram = diagram;
	}

	public void createContents(String ruleId) {

		final Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setText("Rule editor");
		
		ruleIdToEdit = ruleId;

		final Composite composite = new Composite(shell, SWT.NONE);

		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);

		Composite compositeLeft = new Composite(composite, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeLeft.setLayoutData(gridData);
		compositeLeft.setLayout(new GridLayout(2, false));

		Composite compositeEvent = new Composite(compositeLeft, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeEvent.setLayoutData(gridData);
		compositeEvent.setLayout(new GridLayout(1, false));

		Label eventLabel = new Label(compositeEvent, SWT.NONE);
		eventLabel.setText("Event");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		eventLabel.setLayoutData(gridData);

		eventCombo = new CCombo(compositeEvent,SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		eventCombo.setLayoutData(gridData);
		eventCombo.addSelectionListener(eventSelectionListener);

		Composite compositeSelect = new Composite(compositeLeft, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeSelect.setLayoutData(gridData);
		compositeSelect.setLayout(new GridLayout(1, false));

		Label selectLabel = new Label(compositeSelect, SWT.NONE);
		selectLabel .setText("Select service task");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		selectLabel.setLayoutData(gridData);

		serviceCombo = new CCombo(compositeSelect,SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		serviceCombo.setLayoutData(gridData);
		serviceCombo.addSelectionListener(serviceSelectionListener);
		serviceCombo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		Composite compositeDescription = new Composite(compositeLeft, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		compositeDescription.setLayoutData(gridData);
		compositeDescription.setLayout(new GridLayout(1, false));

		descriptionLabel = new Label(compositeDescription, SWT.NONE);
		descriptionLabel.setText("Description");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		descriptionLabel.setLayoutData(gridData);

		descriptionCombo = new CCombo(compositeDescription,SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		descriptionCombo.setLayoutData(gridData);

		Composite compositeValue = new Composite(compositeLeft, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		compositeValue.setLayoutData(gridData);
		compositeValue.setLayout(new GridLayout(2, false));

		Label valueLabel = new Label(compositeValue, SWT.NONE);
		valueLabel.setText("Value");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		valueLabel.setLayoutData(gridData);

		valueCombo = new CCombo(compositeValue,SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		valueCombo.setLayoutData(gridData);
		String[] values = new String[5];
		values[0] = "<";
		values[1] = "<=";
		values[2] = "=";
		values[3] = ">=";
		values[4] = ">";
		valueCombo.setItems(values);
		valueCombo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		valueText = new Text(compositeValue,SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		valueText.setLayoutData(gridData);

		Composite compositeThreadId = new Composite(compositeLeft, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		compositeThreadId.setLayoutData(gridData);
		compositeThreadId.setLayout(new GridLayout(1, false));

		threatLabel = new Label(compositeThreadId, SWT.NONE);
		threatLabel.setText("Threat ID");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		threatLabel.setLayoutData(gridData);

		threatText = new Text(compositeThreadId,SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		threatText.setLayoutData(gridData);

		Composite compositeCenter = new Composite(composite, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeCenter.setLayoutData(gridData);
		compositeCenter.setLayout(new GridLayout(2, false));

		Label scopeLabel = new Label(compositeCenter, SWT.NONE);
		FontData[] fD1 = scopeLabel.getFont().getFontData();
		fD1[0].setHeight(13);
		scopeLabel.setFont(new Font(composite.getDisplay(),fD1[0]));
		scopeLabel.setText("Scope");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		scopeLabel.setLayoutData(gridData);

		Label separationLabel = new Label(compositeCenter, SWT.SEPARATOR | SWT.HORIZONTAL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		separationLabel.setLayoutData(gridData);

		Label voidLabel = new Label(compositeCenter, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		voidLabel.setText("");
		gridData.horizontalSpan= 2;
		voidLabel.setLayoutData(gridData);

		anywhereButton = new Button(compositeCenter, SWT.RADIO);
		anywhereButton.setText("Anywhere in the process");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		anywhereButton.setLayoutData(gridData);
		anywhereButton.addSelectionListener(anywhereButtonListener);
		anywhereButton.setSelection(true);

		constrainedButton = new Button(compositeCenter, SWT.RADIO);
		constrainedButton.setText("Constrained to:");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		constrainedButton.setLayoutData(gridData);
		constrainedButton.addSelectionListener(constrainedButtonListener);

		list = new List(compositeCenter,SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		list.setLayoutData(gridData);
		String[] items = new String[3];
		items[0] = "Before";
		items[1] = "After";
		items[2] = "During";
		list.setItems(items);
		list.setEnabled(false);
		list.setSelection(0);

		Composite compositeTask = new Composite(compositeCenter, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeTask.setLayoutData(gridData);
		compositeTask.setLayout(new GridLayout(1, false));

		taskLabel = new Label(compositeTask, SWT.NONE);
		taskLabel.setText("Specify Task:");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		taskLabel.setLayoutData(gridData);
		taskLabel.setEnabled(false);

		taskCombo = new CCombo(compositeTask,SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		taskCombo.setLayoutData(gridData);
		taskCombo.setEnabled(false);
		taskCombo.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));

		Composite compositeRight = new Composite(composite, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		compositeRight.setLayoutData(gridData);
		compositeRight.setLayout(new GridLayout(2, false));

		Label actionLabel = new Label(compositeRight, SWT.NONE);
		FontData[] fD2 = actionLabel.getFont().getFontData();
		fD2[0].setHeight(13);
		actionLabel.setFont(new Font(composite.getDisplay(),fD2[0]));
		actionLabel.setText("Action");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		actionLabel.setLayoutData(gridData);

		Label separationLabel2 = new Label(compositeRight, SWT.SEPARATOR | SWT.HORIZONTAL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		separationLabel2.setLayoutData(gridData);

		changeRuntimeGroup = new CheckBoxGroup(compositeRight, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		changeRuntimeGroup.setLayoutData(gridData);
		changeRuntimeGroup.setLayout(new GridLayout(2, false));
		changeRuntimeGroup.setText("Change Runtime");

		Composite compositeTry = changeRuntimeGroup.getContent();

		recButton = new Button(compositeTry, SWT.RADIO);
		recButton.setText("Try recomposition and reconfiguration");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		recButton.setLayoutData(gridData);
		recButton.setSelection(true);

		recompositionButton = new Button(compositeTry, SWT.RADIO);
		recompositionButton.setText("Try recomposition");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		recompositionButton.setLayoutData(gridData);
		
		reconfigurationButton = new Button(compositeTry, SWT.RADIO);
		reconfigurationButton.setText("Try reconfiguration");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		reconfigurationButton.setLayoutData(gridData);

		Label voidLabel1 = new Label(compositeTry, SWT.NONE);
		voidLabel1.setText("    ");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		voidLabel1.setLayoutData(gridData);

		checkButton = new Button(compositeTry, SWT.CHECK);
		checkButton.setText("Allow service to be stopped in case recomposition and reconfiguration fails");
		gridData = new GridData(SWT.END, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		checkButton.setLayoutData(gridData);

		stopButton = new Button(compositeTry, SWT.RADIO);
		stopButton.setText("Stop service");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		stopButton.setLayoutData(gridData);

		launchProcessGroup = new CheckBoxGroup(compositeRight, SWT.NONE);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 2;
		launchProcessGroup.setLayoutData(gridData);
		launchProcessGroup.setLayout(new GridLayout(2, false));
		launchProcessGroup.setText("Launch Process");

		Composite compositeProcess = launchProcessGroup.getContent();

		Label processLabel = new Label(compositeProcess, SWT.NONE);
		processLabel.setText("ProcessId:  ");
		gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		processLabel.setLayoutData(gridData);

		processText = new Text(compositeProcess,SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		processText.setLayoutData(gridData);

		createButton = new Button(composite, SWT.PUSH);
		createButton.setText("Create Rule");
		gridData = new GridData(SWT.CENTER, SWT.FILL, true, false);
		gridData.horizontalSpan= 3;
		createButton.setLayoutData(gridData);
		createButton.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				String ruleId = new Integer(createRuleId()).toString();
				String serviceId = "";
				String event = eventCombo.getText();
				if(event.equals("")){
					showErrorMessage("Select an event");
					return;
				}
				if(serviceCombo.getText().equals("No threats defined") || serviceCombo.getText().equals("No service tasks") || serviceCombo.getText().equals("")){
					showErrorMessage("Select a valid serviceTask");
					return;
				}
				String taskId = serviceCombo.getText().substring(0, serviceCombo.getText().indexOf("-")-1);
				String taskName = serviceCombo.getText().substring(serviceCombo.getText().indexOf("-")+2, serviceCombo.getText().length());
				String value = valueText.getText();
				String comparison = valueCombo.getText();
				if(value.equals("") || comparison.equals("")){
					showErrorMessage("Define a value");
					return;
				}
				String threatId = threatText.getText();
				String description = "";
				if(event.equals("Threat level change")) {
					description = descriptionCombo.getText();
					if(threatId.equals("")){
						showErrorMessage("Define a threatId");
						return;
					}
					if(description.equals("")){
						showErrorMessage("Select a description");
						return;
					}
				}
				if(constrainedButton.getSelection()){
					String[] selectionList = list.getSelection();
					String selectionScope = selectionList[0];
					String taskIdScope = taskCombo.getText().substring(0, taskCombo.getText().indexOf("-")-1);
					if(taskIdScope.equals("")){
						showErrorMessage("Select a valid scope");
						return;
					}
					String processId = processText.getText();
					if(changeRuntimeGroup.isActivated() && launchProcessGroup.isActivated()){
						if(processId.equals("")){
							showErrorMessage("Insert a valid processId");
							return;
						}
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, true, false, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, true, false, false, false, false, true, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, true, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, true, false, false, false, true, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, true, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, true, false, false, true, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, false, true, true, true, processId);
						}
					} else if(changeRuntimeGroup.isActivated() && !launchProcessGroup.isActivated()){
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, true, false, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, true, false, false, false, false, false, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, true, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, true, false, false, false, false, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, true, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, true, false, false, false, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, true, false, false, true, false, true, false, processId);
						}
					} else if(!changeRuntimeGroup.isActivated() && launchProcessGroup.isActivated()){
						if(processId.equals("")){
							showErrorMessage("Insert a valid processId");
							return;
						}
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, true, false, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, true, false, false, false, false, true, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, true, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, true, false, false, false, true, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, false, false, true, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, false, true, true, processId);
						}
					} else if(!changeRuntimeGroup.isActivated() && !launchProcessGroup.isActivated()){
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, true, false, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, true, false, false, false, false, false, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, true, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, true, false, false, false, false, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, false, false, false, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, true, selectionScope, taskIdScope, false, false, false, true, false, true, false, processId);
						}
					}
					
				} else {
					String processId = processText.getText();
					if(changeRuntimeGroup.isActivated() && launchProcessGroup.isActivated()){
						if(processId.equals("")){
							showErrorMessage("Insert a valid processId");
							return;
						}
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, true, false, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, true, false, false, false, false, true, processId);
							} 
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, true, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, true, false, false, false, true, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, false, false, true, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, false, true, true, processId);
						}
					} else if(changeRuntimeGroup.isActivated() && !launchProcessGroup.isActivated()){
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, true, false, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, true, false, false, false, false, false, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, true, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, true, false, false, false, false, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, false, false, false, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, true, false, false, true, false, true, false, processId);
						}
					} else if(!changeRuntimeGroup.isActivated() && launchProcessGroup.isActivated()){
						if(processId.equals("")){
							showErrorMessage("Insert a valid processId");
							return;
						}
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, true, false, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, true, false, false, false, false, true, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, true, false, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, true, false, false, false, true, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, true, false, true, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, false, false, true, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, false, true, true, processId);
						}
					} else if(!changeRuntimeGroup.isActivated() && !launchProcessGroup.isActivated()){
						if(recButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, true, false, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, true, false, false, false, false, false, processId);
							}
						} else if(recompositionButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, true, false, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, true, false, false, false, false, processId);
							}
						} else if(reconfigurationButton.getSelection()){
							if(checkButton.getSelection()){
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, true, false, false, processId);
							} else {
								saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, false, false, false, processId);
							}
						} else if(stopButton.getSelection()){
							saveRule(ruleId, taskId, taskName, serviceId, event, description, comparison, value, threatId, false, null, null, false, false, false, true, false, true, false, processId);
						}
					}
				}
				
				PropertyAniketosRuleSection.updateControls();
				shell.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}

		});
		
		java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
		String[] items2 = new String[serviceTasksList.size()];
		for(int i=0; i<serviceTasksList.size(); i++){
			String taskId = serviceTasksList.get(i).getId();
			String taskName = serviceTasksList.get(i).getName();
			items2[i]= taskId + " - " + taskName;
		}
		taskCombo.setItems(items2);

		String[] events = new String[4];
		events[0] = "ThreatLevelChange";
		events[1] = "Trust level change";
		events[2] = "Contract violation";
		events[3] = "Security property change";
		eventCombo.setItems(events);
		eventCombo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		String[] descriptions = new String[1];
		descriptions[0] = "Malicious service";
		descriptionCombo.setItems(descriptions);
		
		if(ruleId != null){
			createButton.setText("Ok");
			loadRule(ruleId);
		}

		shell.setSize(1100, 350);
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 1100) / 2;
		final int y = (screenSize.height - 350) / 2;
		shell.setLocation(x, y);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();

	}
	
	private SelectionListener eventSelectionListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			updateFields();

		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	
	private SelectionListener serviceSelectionListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			if(eventCombo.getText().equals("Threat level change")){
				String taskId = serviceCombo.getText().substring(0, serviceCombo.getText().indexOf("-")-1);
				java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
				for(ServiceTask serviceTask : serviceTasksList){
					if(serviceTask.getId().equals(taskId)){
						java.util.List<BoundaryEvent> boundaryEvents = serviceTask.getBoundaryEventRefs();
						for(BoundaryEvent event : boundaryEvents){
							if(event.getEventDefinitions().get(0) != null) {
								ErrorEventDefinition errorDefinition = (ErrorEventDefinition) event.getEventDefinitions().get(0);
								if(errorDefinition.getErrorCode() != null) {
									threatText.setText(errorDefinition.getErrorCode());
								} else {
									threatText.setText("Threat not defined");
								}
							}
						}
					}
				}
			} else if(eventCombo.getText().equals("Trust level change")){ 
				descriptionCombo.setText("");
				
				String taskId = serviceCombo.getText().substring(0, serviceCombo.getText().indexOf("-")-1);
				java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
				for(ServiceTask serviceTask : serviceTasksList){
					if(serviceTask.getId().equals(taskId)){
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension !=null){
							Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
							if(trustworthiness != null){
								valueText.setText(trustworthiness.getValue());
								valueCombo.setText("<");
							}
						}
					}
				}
				
			} else if(eventCombo.getText().equals("Contract violation")){
				descriptionCombo.setText("");
			} else if(eventCombo.getText().equals("Security property change")){
				descriptionCombo.setText("");
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	private SelectionListener constrainedButtonListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			list.setEnabled(true);
			taskLabel.setEnabled(true);
			taskCombo.setEnabled(true);
			taskCombo.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	private SelectionListener anywhereButtonListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			list.setEnabled(false);
			taskLabel.setEnabled(false);
			taskCombo.setEnabled(false);
			taskCombo.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	public java.util.List<ServiceTask> getListOfServiceTasks(){

		java.util.List<String> tasksDiscovered = new Vector<String>();
		java.util.List<ServiceTask> servicetasksList = new Vector<ServiceTask>();
		EList<PictogramLink> list = diagram.getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
						servicetasksList.add(task);
					}
				}
			}
		}

		return servicetasksList;
	}
	
	public String getTaskName(String serviceId){

		java.util.List<String> tasksDiscovered = new Vector<String>();
		String taskName = "";
		EList<PictogramLink> list = diagram.getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
						if(task.getId().equals(serviceId)){
							taskName = task.getName();
							break;
						}
					}
				}
			}
		}

		return taskName;
	}

	public void saveRule(String ruleId, String taskId,String taskName, String serviceId,
			String event, String description, String comparison, String value,
			String threatId, boolean scope, String selectionScope, String taskIdScope,
			boolean runtime, boolean recompositionAndReconfiguration, boolean recomposition,
			boolean reconfiguration, boolean stop, boolean stopService, boolean launchProcess, String processId){
		
		if(!fileExists(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule"))){
	
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();

			final IFile file = workspace.getRoot().getFile(new Path(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true)));
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			final byte[] bytes = baos.toByteArray();
			final ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			
			try {
				file.create(bais, true, null);
				Document doc = new Document();
				Element rules = new Element("rules");

				doc.setRootElement(rules);

				Element rule = new Element("rule");
				rule.setAttribute("id", ruleId);
				
				Element service = new Element("service");
				service.setAttribute("taskId", taskId);
				service.setAttribute("taskName", taskName);
				service.setText(serviceId);
				
				Element type = new Element("type");
				type.setText(event);
				
				rule.addContent(service);
				rule.addContent(type);
				if(!description.equals("")){
					Element descriptionE = new Element("description");
					descriptionE.setText(description);
					rule.addContent(descriptionE);
				}
				
				Element valueE = new Element("value");
				valueE.setAttribute("comparison", comparison);
				valueE.setText(value);
				
				rule.addContent(valueE);
				
				if(!threatId.equals("")){
					Element threatIdE = new Element("threatId");
					threatIdE.setText(threatId);
					rule.addContent(threatIdE);
				}
				
				if(scope){
					Element scopeE = new Element("scope");

					if(selectionScope.equals("Before")){
						Element before = new Element("before");
						before.setAttribute("taskId", taskIdScope);
						scopeE.addContent(before);
					} else if(selectionScope.equals("After")){
						Element after = new Element("after");
						after.setAttribute("taskId", taskIdScope);
						scopeE.addContent(after);
					} else if(selectionScope.equals("During")){
						Element during = new Element("during");
						during.setAttribute("taskId", taskIdScope);
						scopeE.addContent(during);
					}
					
					rule.addContent(scopeE);
				}
				
				Element action = new Element("action");
				if(runtime){
					Element changeRuntime = new Element("changeRuntime");
					if(recompositionAndReconfiguration){
						Element recompositionAndReconfigurationE = new Element("recompositionAndReconfiguration");
						if(stop){
							recompositionAndReconfigurationE.setAttribute("allowStop", "1");
						} else {
							recompositionAndReconfigurationE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(recompositionAndReconfigurationE);
					} else if(recomposition){
						Element recompositionE = new Element("recomposition");
						if(stop){
							recompositionE.setAttribute("allowStop", "1");
						} else {
							recompositionE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(recompositionE);
					} else if(reconfiguration){
						Element reconfigurationE = new Element("reconfiguration");
						if(stop){
							reconfigurationE.setAttribute("allowStop", "1");
						} else {
							reconfigurationE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(reconfigurationE);
					} else if(stopService){
						Element stopServiceE = new Element("stopService");
						changeRuntime.addContent(stopServiceE);
					}
					action.addContent(changeRuntime);
				}
				if(launchProcess){
					Element launchProcessE = new Element("launchProcess");
					launchProcessE.setAttribute("id", processId);
					action.addContent(launchProcessE);
				}
				rule.addContent(action);
				rules.addContent(rule);

				XMLOutputter xmlOutput = new XMLOutputter();
				xmlOutput.setFormat(Format.getPrettyFormat());

				IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));

				xmlOutput.output(doc, new FileWriter(fileResource.getLocation().toString()));
			} catch (IOException e) {
				log.error(e);
			} catch (CoreException e1) {
				log.error(e1);
			}

		} else {
			
			SAXBuilder builder = new SAXBuilder();

			IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
			File xmlFile = new File(fileResource.getLocation().toString());
			try {
				Document doc = (Document) builder.build(xmlFile);

				Element rules = doc.getRootElement();
				
				@SuppressWarnings("unchecked")
				java.util.List<Element> rulesList = rules.getChildren("rule");
				
				Element rule = new Element("rule");
				
				for(Element r : rulesList){
					String idString = r.getAttribute("id").getValue();
					if(idString.equals(ruleIdToEdit)){
						rules.removeContent(r);
						rule.setAttribute("id", ruleIdToEdit);
						break;
					}
				}
				
				if(rule.getAttributeValue("id") == null)
					rule.setAttribute("id", ruleId);

				Element service = new Element("service");
				service.setAttribute("taskId", taskId);
				service.setAttribute("taskName", taskName);
				service.setText(serviceId);

				Element type = new Element("type");
				type.setText(event);

				rule.addContent(service);
				rule.addContent(type);
				if(!description.equals("")){
					Element descriptionE = new Element("description");
					descriptionE.setText(description);
					rule.addContent(descriptionE);
				}

				Element valueE = new Element("value");
				valueE.setAttribute("comparison", comparison);
				valueE.setText(value);

				rule.addContent(valueE);

				if(!threatId.equals("")){
					Element threatIdE = new Element("threatId");
					threatIdE.setText(threatId);
					rule.addContent(threatIdE);
				}

				if(scope){
					Element scopeE = new Element("scope");

					if(selectionScope.equals("Before")){
						Element before = new Element("before");
						before.setAttribute("taskId", taskIdScope);
						scopeE.addContent(before);
					} else if(selectionScope.equals("After")){
						Element after = new Element("after");
						after.setAttribute("taskId", taskIdScope);
						scopeE.addContent(after);
					} else if(selectionScope.equals("During")){
						Element during = new Element("during");
						during.setAttribute("taskId", taskIdScope);
						scopeE.addContent(during);
					}
					rule.addContent(scopeE);
				}

				Element action = new Element("action");
				if(runtime){
					Element changeRuntime = new Element("changeRuntime");
					if(recompositionAndReconfiguration){
						Element recompositionAndReconfigurationE = new Element("recompositionAndReconfiguration");
						if(stop){
							recompositionAndReconfigurationE.setAttribute("allowStop", "1");
						} else {
							recompositionAndReconfigurationE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(recompositionAndReconfigurationE);
					} else if(recomposition){
						Element recompositionE = new Element("recomposition");
						if(stop){
							recompositionE.setAttribute("allowStop", "1");
						} else {
							recompositionE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(recompositionE);
					} else if(reconfiguration){
						Element reconfigurationE = new Element("reconfiguration");
						if(stop){
							reconfigurationE.setAttribute("allowStop", "1");
						} else {
							reconfigurationE.setAttribute("allowStop", "0");
						}
						changeRuntime.addContent(reconfigurationE);
					} else if(stopService){
						Element stopServiceE = new Element("stopService");
						changeRuntime.addContent(stopServiceE);
					}
					action.addContent(changeRuntime);
				}
				if(launchProcess){
					Element launchProcessE = new Element("launchProcess");
					launchProcessE.setAttribute("id", processId);
					action.addContent(launchProcessE);
				}
				rule.addContent(action);
				rules.addContent(rule);

				XMLOutputter xmlOutput = new XMLOutputter();
				xmlOutput.setFormat(Format.getPrettyFormat());

				xmlOutput.output(doc, new FileWriter(fileResource.getLocation().toString()));

			} catch (IOException e) {
				log.error(e);
			} catch (JDOMException e) {
				log.error(e);
			}
		}
	}
	
	protected URI getRelativeURIForDiagram(final Diagram diagram, final String relativePath) {
		final URI originalURI = getResourceForDiagram(diagram).getURI();

		String finalSegment = relativePath;
		final URI parentURI = originalURI.trimSegments(1);

		// Parse any replacement variables in the filename
		final Calendar now = Calendar.getInstance();

		finalSegment = finalSegment.replaceAll(REGEX_DATE_TIME, SDF.format(now.getTime()));
		finalSegment = finalSegment.replaceAll(REGEX_EXTENSION, originalURI.fileExtension());
		finalSegment = finalSegment.replaceAll(REGEX_FILENAME, originalURI.lastSegment());
		finalSegment = finalSegment.replaceAll(REGEX_FILENAME_WITHOUT_EXTENSION, originalURI.trimFileExtension().lastSegment());

		return parentURI.appendSegment(finalSegment);
	}

	protected Resource getResourceForDiagram(final Diagram diagram) {
//		URI uri = diagram.eResource().getURI();
//		URI bpmnUri = uri.trimFragment();
//		bpmnUri = bpmnUri.trimFileExtension();
//		bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");
//		String platformString = bpmnUri.toPlatformString(true);
//		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
//		IFolder folderDiagrams = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf(".")));
		return diagram.eResource();
	}
	
//	protected URI getURIForDiagram(final Diagram diagram) {
//		URI uri = diagram.eResource().getURI();
//		uri.
//		URI bpmnUri = uri.trimFragment();
//		bpmnUri = bpmnUri.trimFileExtension();
//		bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");
//		String platformString = bpmnUri.toPlatformString(true);
//		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
//		IFolder folderDiagrams = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf(".")));
//		return folderDiagrams.;
//	}
	
	
	protected void saveResource(final URI uri, final InputStream content, final IProgressMonitor monitor) {

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();

		final IFile file = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));

		try {
			if (file.exists()) {
				// delete first
				monitor.beginTask("update content", 10);
				file.setContents(content, true, true, monitor);
			} else {
				monitor.beginTask("create", 10);
				file.create(content, true, monitor);
			}
			file.refreshLocal(IResource.DEPTH_INFINITE, null);
			monitor.worked(10);
		} catch (CoreException e) {
			log.error(e);
		}
	}
	
	private boolean fileExists(final URI uri){

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IFile file = workspace.getRoot().getFile(new Path(uri.toPlatformString(true)));

		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), "Creating composition plans",message);
			}
		});

	}
	
	private int createRuleId(){
		
		int ruleId = 0;
		if(!fileExists(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule"))){
			return ruleId;
		}
		SAXBuilder builder = new SAXBuilder();
	
		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
		File xmlFile = new File(fileResource.getLocation().toString());

		try {
			Document doc = (Document) builder.build(xmlFile);
			Element rules = doc.getRootElement();
			
			@SuppressWarnings("unchecked")
			java.util.List<Element> rulesList = rules.getChildren("rule");
			
			for(Element rule : rulesList){
				String idString = rule.getAttribute("id").getValue();
				int id = new Integer(idString).intValue();
				if(ruleId < id)
					ruleId = id;
			}
			ruleId++;
			
		} catch (JDOMException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		return ruleId;
	}

	public void loadRule(String ruleId){
		SAXBuilder builder = new SAXBuilder();

		IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(getRelativeURIForDiagram(diagram, FILENAME_PATTERN + ".rule").toPlatformString(true));
		File xmlFile = new File(fileResource.getLocation().toString());
		try {
			Document doc = (Document) builder.build(xmlFile);

			Element rules = doc.getRootElement();
			
			@SuppressWarnings("unchecked")
			java.util.List<Element> rulesList = rules.getChildren("rule");
			for(Element rule : rulesList){
				if(rule.getAttributeValue("id").equals(ruleId)){
					Element service = rule.getChild("service");
					final String taskIdRule = service.getAttributeValue("taskId");
					String taskNameRule = service.getAttributeValue("taskName");

					
					Element typeE = rule.getChild("type");
					String type = typeE.getText();
					
					if(!type.equals("Threat level change")){
						java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
						String[] items2 = new String[serviceTasksList.size()];
						for(int i=0; i<serviceTasksList.size(); i++){
							String taskId = serviceTasksList.get(i).getId();
							String taskName = serviceTasksList.get(i).getName();
							items2[i]= taskId + " - " + taskName;
						}
						serviceCombo.setItems(items2);
						descriptionCombo.setEnabled(false);
						descriptionCombo.setText("");
						threatText.setEnabled(false);
						threatText.setText("");
						
					} else {
						java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
						Vector<String> vector = new Vector<String>();
						for(int i=0; i<serviceTasksList.size(); i++){
							java.util.List<BoundaryEvent> boundaryEvents = serviceTasksList.get(i).getBoundaryEventRefs();
							for(BoundaryEvent event : boundaryEvents){
								if(event.getEventDefinitions().get(0) != null) {
									ErrorEventDefinition errorDefinition = (ErrorEventDefinition) event.getEventDefinitions().get(0);
									if(errorDefinition.getErrorCode() != null) {
										String taskId = serviceTasksList.get(i).getId();
										String taskName = serviceTasksList.get(i).getName();
										vector.add(taskId + " - " + taskName);
									}
								}
							}
						}

						if(vector.size()>0){
							String[] items = new String[vector.size()];
							serviceCombo.setItems(vector.toArray(items));
						}
						descriptionCombo.setEnabled(true);
						threatText.setEnabled(true);
					}
					
					serviceCombo.setText(taskIdRule + " - " + taskNameRule);
					eventCombo.setText(type);
					String description = rule.getChildText("description");
					if(description!=null)
						descriptionCombo.setText(description);
					String value = rule.getChildText("value");
					valueText.setText(value);
					String comparison = rule.getChild("value").getAttribute("comparison").getValue();
					valueCombo.setText(comparison);
					String threatId = rule.getChildText("threatId");
					if(threatId!=null)
						threatText.setText(threatId);
					Element scopeE = rule.getChild("scope");
					String scopeTaskId = "";
					String scopeType = "";
					String scopeTaskName = "";
					if(scopeE!=null){
						@SuppressWarnings("unchecked")
						java.util.List<Element> scopeList = scopeE.getChildren();
						for(Element childScope : scopeList){
							scopeType = childScope.getName();
							if(scopeType.equals("before")){
								list.setSelection(0);
							}
							else if(scopeType.equals("after")){
								list.setSelection(1);
							}
							else if(scopeType.equals("during")){
								list.setSelection(2);
							}
							scopeTaskId = childScope.getAttributeValue("taskId");
							scopeTaskName = getTaskName(scopeTaskId);
							taskCombo.setText(scopeTaskId + " - " + scopeTaskName);
							constrainedButton.setSelection(true);
							anywhereButton.setSelection(false);
							list.setEnabled(true);
							taskLabel.setEnabled(true);
							taskCombo.setEnabled(true);
						}
					} else {
						anywhereButton.setSelection(true);
						constrainedButton.setSelection(false);
						list.setEnabled(false);
						taskLabel.setEnabled(false);
						taskCombo.setEnabled(false);
					}
					Element actionE = rule.getChild("action");
					@SuppressWarnings("unchecked")
					java.util.List<Element> actionList = actionE.getChildren();
					for(Element childAction : actionList){
						if(childAction.getName().equals("changeRuntime")){
							@SuppressWarnings("unchecked")
							java.util.List<Element> list = childAction.getChildren();
							for(Element actionTypeE : list){
								String action = actionTypeE.getName();
								if(action.equals("recompositionAndReconfiguration")){
									recButton.setSelection(true);
									recompositionButton.setSelection(false);
									reconfigurationButton.setSelection(false);
									stopButton.setSelection(false);
									String stop = actionTypeE.getAttributeValue("allowStop");
									if(stop.equals("1"))
										checkButton.setSelection(true);
								} else if(action.equals("recomposition")){
									recButton.setSelection(false);
									recompositionButton.setSelection(false);
									stopButton.setSelection(false);
									recompositionButton.setSelection(true);
									String stop = actionTypeE.getAttributeValue("allowStop");
									if(stop.equals("1"))
										checkButton.setSelection(true);
								} else if(action.equals("reconfiguration")){
									recButton.setSelection(false);
									recompositionButton.setSelection(false);
									stopButton.setSelection(false);
									reconfigurationButton.setSelection(true);
									String stop = actionTypeE.getAttributeValue("allowStop");
									if(stop.equals("1"))
										checkButton.setSelection(true);
								} else if(action.equals("stopService")){
									recButton.setSelection(false);
									recompositionButton.setSelection(false);
									reconfigurationButton.setSelection(false);
									stopButton.setSelection(true);
								}
							}
						} else {
							processText.setText(childAction.getAttributeValue("id"));
						}
					}
					
					if(!processText.getText().equals("")){
						launchProcessGroup.activate();
					} else if(processText.getText().equals("")){
						launchProcessGroup.deactivate();
					}
					if(recButton.getSelection() || recompositionButton.getSelection() || reconfigurationButton.getSelection() || stopButton.getSelection()){
						changeRuntimeGroup.activate();
					} else if(!recButton.getSelection() || !recompositionButton.getSelection() || !reconfigurationButton.getSelection() || !stopButton.getSelection()){
						changeRuntimeGroup.deactivate();
					}
					
				}
			}
		
			
			
		} catch (IOException e) {
			log.error(e);
		} catch (JDOMException e) {
			log.error(e);
		}
		
	}
	
	private void updateFields(){
		if(eventCombo.getText().equals("Threat level change")){
			threatText.setEnabled(true);
			threatLabel.setEnabled(true);
			descriptionCombo.setEnabled(true);
			descriptionLabel.setEnabled(true);
			java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
			Vector<String> vector = new Vector<String>();
			for(int i=0; i<serviceTasksList.size(); i++){
				java.util.List<BoundaryEvent> boundaryEvents = serviceTasksList.get(i).getBoundaryEventRefs();
				for(BoundaryEvent event : boundaryEvents){
					if(event.getEventDefinitions().get(0) != null) {
						ErrorEventDefinition errorDefinition = (ErrorEventDefinition) event.getEventDefinitions().get(0);
						if(errorDefinition.getErrorCode() != null) {
							String taskId = serviceTasksList.get(i).getId();
							String taskName = serviceTasksList.get(i).getName();
							vector.add(taskId + " - " + taskName);
						}
					}
				}
			}

			if(vector.size()>0){
				String[] items = new String[vector.size()];
				serviceCombo.setItems(vector.toArray(items));
			} else {
				String[] items = new String[0];
				serviceCombo.setItems(vector.toArray(items));
				serviceCombo.setText("No threats defined");
			}
		} else if(eventCombo.getText().equals("Trust level change")){
			threatText.setEnabled(false);
			threatLabel.setEnabled(false);
			descriptionCombo.setEnabled(false);
			descriptionLabel.setEnabled(false);
			java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
			Vector<String> vector = new Vector<String>();
			for(int i=0; i<serviceTasksList.size(); i++){
				String taskId = serviceTasksList.get(i).getId();
				String taskName = serviceTasksList.get(i).getName();
				vector.add(taskId + " - " + taskName);
			}
			
			if(vector.size()>0){
				String[] items = new String[vector.size()];
				serviceCombo.setItems(vector.toArray(items));
			} else {
				serviceCombo.setText("No service tasks");
			}
		} else if(eventCombo.getText().equals("Contract violation")){
			threatText.setEnabled(false);
			threatLabel.setEnabled(false);
			descriptionCombo.setEnabled(false);
			descriptionLabel.setEnabled(false);
			java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
			Vector<String> vector = new Vector<String>();
			for(int i=0; i<serviceTasksList.size(); i++){
				String taskId = serviceTasksList.get(i).getId();
				String taskName = serviceTasksList.get(i).getName();
				vector.add(taskId + " - " + taskName);
			}
			
			if(vector.size()>0){
				String[] items = new String[vector.size()];
				serviceCombo.setItems(vector.toArray(items));
			} else {
				serviceCombo.setText("No service tasks");
			}
		} else if(eventCombo.getText().equals("Security property change")){
			threatText.setEnabled(false);
			threatLabel.setEnabled(false);
			descriptionCombo.setEnabled(false);
			descriptionLabel.setEnabled(false);
			java.util.List<ServiceTask> serviceTasksList = getListOfServiceTasks();
			Vector<String> vector = new Vector<String>();
			for(int i=0; i<serviceTasksList.size(); i++){
				String taskId = serviceTasksList.get(i).getId();
				String taskName = serviceTasksList.get(i).getName();
				vector.add(taskId + " - " + taskName);
			}
			
			if(vector.size()>0){
				String[] items = new String[vector.size()];
				serviceCombo.setItems(vector.toArray(items));
			} else {
				serviceCombo.setText("No service tasks");
			}
		}
	}

}

