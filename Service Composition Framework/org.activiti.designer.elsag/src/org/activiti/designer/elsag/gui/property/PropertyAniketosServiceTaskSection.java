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
package org.activiti.designer.elsag.gui.property;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import org.activiti.designer.elsag.data.ServiceDiscovered;
import org.activiti.designer.elsag.dialog.CloudDialog;
import org.activiti.designer.elsag.gui.selectionAdapter.AddIntegritySelectionAdapter;
import org.activiti.designer.elsag.gui.selectionAdapter.DiscoverSelectionAdapter;
import org.activiti.designer.elsag.gui.selectionAdapter.InputSelectionAdapter;
import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.apache.log4j.Logger;
import org.eclipse.aniketos.AniketosFactory;
import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.SecurityExtension;
import org.eclipse.aniketos.Trustworthiness;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.aniketos.scf.data.impl.Service;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyAniketosServiceTaskSection extends ActivitiPropertySection implements ITabbedPropertyConstants{

	final private static Logger log = Logger.getLogger(PropertyAniketosServiceTaskSection.class);
	private final static String CLASS_TYPE = "classType";
	
	public Text typeText;
	private Text inputText;
	private Text resultText;
	private static Text typeIntegrityText;
	private static Text algIntegrityText;
	private static Text trustText;
	private Text locationText;
	private Text requestedServiceProviderText;
	private Text requestedServiceRoleText;
	private CLabel integrityLabel;
	public Composite composite;
	private String processId;
	private String taskId;
	private Button inputButton;
	private Button confidentialityButton;
	private Button confidentialityResultButton;
	private CCombo confidentialityResultAlgList;
	private Button discoveryButton;
	private Button addIntegrityButton;
	private Button removeIntegrityButton;
	private Button removeTrustButton;
	private Button addTrustButton;
	private Group trustGroup;
	private CLabel trustLabel;
	private Diagram diagram;
	private CCombo confidentialityAlgList;
	private static CCombo comboIntegrity;
	public static org.eclipse.swt.widgets.List operationNameList;
	public static org.eclipse.swt.widgets.List operationInputList;
	public static org.eclipse.swt.widgets.List operationOuputList;
	public static CLabel operationOutputLabel;
	public static CLabel operationInputLabel;
	public static CLabel operationOutLabel;
	private CLabel locationLabel;
	private Slider sliderTrustworthiness;
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;

			ServiceTask serviceTask = (ServiceTask) bo;
			taskId = serviceTask.getId();
		}
		
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		CLabel typeVariableLabel = factory.createCLabel(composite, "Operation type:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(0, VSPACE);
	    typeVariableLabel.setLayoutData(data);
	    typeVariableLabel.setToolTipText("Insert the operation type. The Marketplace returns the list of services providing an operation with that type");

		typeText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 250;
	    data.top = new FormAttachment(0, VSPACE);
	    typeText.setLayoutData(data);
	    typeText.addFocusListener(listener);
	    typeText.addKeyListener(keyListener);
	    
	    Button cloudButton = factory.createButton(composite, "Type Cloud", SWT.BUTTON1);
	    data = new FormData();
	    data.width = 100;
	    data.left = new FormAttachment(typeText, 10);
	    cloudButton.setLayoutData(data);
	    cloudButton.addSelectionListener(cloudListener);
	    
	    CLabel requestedServiceProviderLabel = factory.createCLabel(composite, "Requested Provider:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(typeText, VSPACE);
	    requestedServiceProviderLabel.setLayoutData(data);
	    requestedServiceProviderLabel.setToolTipText("Requested Provider");
		
	    requestedServiceProviderText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 250;
	    data.top = new FormAttachment(typeText, VSPACE);
	    requestedServiceProviderText.setLayoutData(data);
	    requestedServiceProviderText.addFocusListener(listener);
	    
	    CLabel requestedServiceRoleLabel = factory.createCLabel(composite, "Requested Provider Role:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(requestedServiceProviderLabel, VSPACE);
	    requestedServiceRoleLabel.setLayoutData(data);
	    requestedServiceRoleLabel.setToolTipText("Requested Provider Role");
	    
	    requestedServiceRoleText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 250;
	    data.top = new FormAttachment(requestedServiceProviderLabel, VSPACE);
	    requestedServiceRoleText.setLayoutData(data);
	    requestedServiceRoleText.addFocusListener(listener);
	    
	    IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = workbenchWindow.getActivePage();
	    
	    discoveryButton = factory.createButton(composite, "", SWT.BUTTON1);
        discoveryButton.setText("Discover service candidates");
        discoveryButton.addSelectionListener(new DiscoverSelectionAdapter(composite.getShell(), page));
        data = new FormData();
        data.top = new FormAttachment(requestedServiceRoleText, 10);
        data.left = new FormAttachment(0, 20);
        discoveryButton.setLayoutData(data);
        
        Composite operationComposite = new Composite(composite, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(discoveryButton, VSPACE);
        data.left = new FormAttachment(0, 0);
        GridLayout gridLayout = new GridLayout(6, false);
        operationComposite.setLayout(gridLayout);
        operationComposite.setLayoutData(data);
        operationComposite.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        
        CLabel operationNameLabel = factory.createCLabel(operationComposite, "Operation:");
        GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gridData.horizontalSpan= 1;
		operationNameLabel.setLayoutData(gridData);

        operationNameList = factory.createList(operationComposite, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
        gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		gridData.widthHint=150;
		gridData.heightHint=150;
		operationNameList.setLayoutData(gridData);
		operationNameList.addSelectionListener(new OperationNameListener(composite));
		operationNameList.addFocusListener(listener);
	    
	    operationInputLabel = factory.createCLabel(operationComposite, "Input param:");
        gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		operationInputLabel.setLayoutData(gridData);
        
        operationInputList = factory.createList(operationComposite, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
	    gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		gridData.widthHint=150;
		gridData.heightHint=150;
		operationInputList.setLayoutData(gridData);
	    
	    operationOutLabel = factory.createCLabel(operationComposite, "Output param:");
	    gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		operationOutLabel.setLayoutData(gridData);
	    
		operationOutputLabel = factory.createCLabel(operationComposite,"");
	    gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.horizontalSpan= 1;
		gridData.widthHint=200;
		operationOutputLabel.setLayoutData(gridData);
	    
		CLabel inputVariableLabel = factory.createCLabel(composite, "Input:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(operationComposite, VSPACE);
	    inputVariableLabel.setLayoutData(data);
	    inputVariableLabel.setToolTipText("Specify the input of the web service");
	    
	    inputText = factory.createText(composite, "", SWT.H_SCROLL);
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 205;
	    data.top = new FormAttachment(operationComposite, VSPACE);
	    inputText.setLayoutData(data);
	    inputText.addFocusListener(listener);
	    inputText.setEditable(false);
	    
	    inputButton = factory.createButton(composite, "", SWT.BUTTON1);
	    inputButton.setText("Specify input");
        data = new FormData();
        data.top = new FormAttachment(operationComposite, VSPACE);
        data.left = new FormAttachment(inputText, HSPACE);
        inputButton.setLayoutData(data);
        inputButton.setEnabled(true);
        inputButton.addSelectionListener(new InputSelectionAdapter(composite.getShell(), inputText, this, operationNameList));
	    
	    confidentialityButton = factory.createButton(composite, "", SWT.CHECK);
	    confidentialityButton.setText("Confidentiality");
        data = new FormData();
        data.top = new FormAttachment(operationComposite, VSPACE+2);
        data.left = new FormAttachment(inputButton, HSPACE);
        confidentialityButton.setLayoutData(data);
        confidentialityButton.setEnabled(true);
        confidentialityButton.setToolTipText("Select if you desire encryption of input data");
        confidentialityButton.addSelectionListener(addConfidentialityListener);
        
		CLabel confidentialityAlgLabel = factory.createCLabel(composite, "Algorithm:");
	    data = new FormData();
	    data.left = new FormAttachment(confidentialityButton, HSPACE);
	    data.top = new FormAttachment(operationComposite, VSPACE);
	    confidentialityAlgLabel.setLayoutData(data);
	    
	    confidentialityAlgList = factory.createCCombo(composite, SWT.NONE);
	    data = new FormData();
	    data.left = new FormAttachment(confidentialityAlgLabel, HSPACE);
	    data.top = new FormAttachment(operationComposite, VSPACE);
	    confidentialityAlgList.setLayoutData(data);
	    confidentialityAlgList.addFocusListener(listener);
	    confidentialityAlgList.setEditable(false);
	    
	    CLabel resultVariableLabel = factory.createCLabel(composite, "Result Variable:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(inputText, VSPACE);
	    resultVariableLabel.setLayoutData(data);
	    resultVariableLabel.setToolTipText("Specify the variable name in which the result returned by the web service will be stored");
        
	    resultText = factory.createText(composite, "");
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 300;
	    data.top = new FormAttachment(inputText, VSPACE);
	    resultText.setLayoutData(data);
	    resultText.addFocusListener(listener);
	    
	    confidentialityResultButton = factory.createButton(composite, "", SWT.CHECK);
	    confidentialityResultButton.setText("Confidentiality");
        data = new FormData();
        data.top = new FormAttachment(inputText, VSPACE+2);
        data.left = new FormAttachment(resultText, HSPACE);
        confidentialityResultButton.setLayoutData(data);
        confidentialityResultButton.setEnabled(true);
        confidentialityResultButton.setToolTipText("Select if you desire encryption of output data");
        confidentialityResultButton.addSelectionListener(addConfidentialityResultListener);
        
        CLabel confidentialityResultAlgLabel = factory.createCLabel(composite, "Algorithm:");
	    data = new FormData();
	    data.left = new FormAttachment(confidentialityResultButton, HSPACE);
	    data.top = new FormAttachment(inputText, VSPACE);
	    confidentialityResultAlgLabel.setLayoutData(data);
	    
	    confidentialityResultAlgList = factory.createCCombo(composite, SWT.NONE);
	    data = new FormData();
	    data.left = new FormAttachment(confidentialityResultAlgLabel, HSPACE);
	    data.top = new FormAttachment(inputText, VSPACE);
	    confidentialityResultAlgList.setLayoutData(data);
	    confidentialityResultAlgList.addFocusListener(listener);
	    confidentialityResultAlgList.setEditable(false);
	    
	    locationLabel = factory.createCLabel(composite, "Location:");
	    data = new FormData();
	    data.left = new FormAttachment(0, 0);
	    data.top = new FormAttachment(resultVariableLabel, VSPACE);
	    locationLabel.setLayoutData(data);
	    locationLabel.setVisible(false);
	    
	    locationText = factory.createText(composite, "", SWT.READ_ONLY);
	    data = new FormData();
	    data.left = new FormAttachment(0, 160);
	    data.width = 300;
	    data.top = new FormAttachment(resultVariableLabel, VSPACE);
	    locationText.setLayoutData(data);
	    locationText.addFocusListener(listener);
	    locationText.setVisible(false);
	    
        Group integrityGroup = factory.createGroup(composite, "Integrity");
        data = new FormData();
        data.top = new FormAttachment(locationLabel, 20);
        data.left = new FormAttachment(0, 20);
        integrityGroup.setLayoutData(data);
        
        FormLayout layout= new FormLayout ();
        integrityGroup.setLayout(layout);
        
        addIntegrityButton = factory.createButton(integrityGroup, "", SWT.BUTTON1);
	    addIntegrityButton.setText("Add new integrity requirement");
	    addIntegrityButton.addSelectionListener(new AddIntegritySelectionAdapter(composite.getShell(), this));
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(0, 20);
        addIntegrityButton.setLayoutData(data);
        
        integrityLabel = factory.createCLabel(integrityGroup, "servicetask needs an integrity check with ");
	    data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.width = 250;
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    integrityLabel.setLayoutData(data);
        
	    comboIntegrity = factory.createCCombo(integrityGroup, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
	    comboIntegrity.setEditable(false);
	    comboIntegrity.setText("no service");
	    data = new FormData();
	    data.left = new FormAttachment(integrityLabel,0);
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    comboIntegrity.setLayoutData(data);
	    comboIntegrity.addModifyListener(modifyListener);
	    comboIntegrity.addSelectionListener(selectionIntegrityListener);
	    comboIntegrity.setEditable(false);
	    
	    CLabel integrityTypeLabel = factory.createCLabel(integrityGroup, " requires an integrity check with Type: ");
	    data = new FormData();
	    data.left = new FormAttachment(comboIntegrity, 0);
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    integrityTypeLabel.setLayoutData(data);
	    
	    typeIntegrityText = factory.createText(integrityGroup, "");
	    data = new FormData();
	    data.left = new FormAttachment(integrityTypeLabel, 0);
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    typeIntegrityText.setLayoutData(data);
	    typeIntegrityText.setEnabled(false);

	    CLabel integrityAlgLabel = factory.createCLabel(integrityGroup, "Algorithm: ");
	    data = new FormData();
	    data.left = new FormAttachment(typeIntegrityText, 0);
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    integrityAlgLabel.setLayoutData(data);
	    
	    
	    algIntegrityText = factory.createText(integrityGroup, "");
	    data = new FormData();
	    data.left = new FormAttachment(integrityAlgLabel, 0);
	    data.top = new FormAttachment(addIntegrityButton, 10);
	    algIntegrityText.setLayoutData(data);
	    algIntegrityText.setEnabled(false);
	    
        removeIntegrityButton = factory.createButton(integrityGroup, "", SWT.BUTTON1);
        removeIntegrityButton.setText("Remove");
        removeIntegrityButton.addSelectionListener(removeListener);
        data = new FormData();
        data.top = new FormAttachment(addIntegrityButton, 10);
        data.left = new FormAttachment(algIntegrityText, 20);
        data.bottom = new FormAttachment(100, -20);
        removeIntegrityButton.setLayoutData(data);
        removeIntegrityButton.setEnabled(false);
        
        trustGroup = factory.createGroup(composite, "Trustworthiness");
        data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(integrityGroup, 20);
	    data.right = new FormAttachment(100, -20);
	    trustGroup.setLayoutData(data);
	    
	    FormLayout layout2 = new FormLayout ();
        trustGroup.setLayout(layout2);
 
	    sliderTrustworthiness = new Slider(trustGroup, SWT.HORIZONTAL);
		sliderTrustworthiness.setMaximum(101);
		sliderTrustworthiness.setMinimum(0);
		sliderTrustworthiness.setIncrement(1);
		sliderTrustworthiness.setPageIncrement(1);
		sliderTrustworthiness.setThumb(1);
		data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(0, 20);
	    sliderTrustworthiness.setLayoutData(data);
	    sliderTrustworthiness.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int value = sliderTrustworthiness.getSelection();
				trustText.setText(new Double(roundTwoDecimals(value / 100.0)).toString());
				
			}
			
			double roundTwoDecimals(double d) {
				DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
				symbols.setDecimalSeparator('.');
				DecimalFormat twoDForm = new DecimalFormat("#.##", symbols);
				return Double.valueOf(twoDForm.format(d));
			}
		});
	    
        trustText = factory.createText(trustGroup, "", SWT.BORDER_SOLID);
	    data = new FormData();
	    data.left = new FormAttachment(sliderTrustworthiness, 20);
	    data.top = new FormAttachment(0, 20);
	    trustText.setLayoutData(data);

	    addTrustButton = factory.createButton(trustGroup, "", SWT.BUTTON1);
	    addTrustButton.setText("Add");
        data = new FormData();
        data.top = new FormAttachment(0, 20);
        data.left = new FormAttachment(trustText, 30);
        addTrustButton.setLayoutData(data);
        addTrustButton.setEnabled(true);
        addTrustButton.addSelectionListener(addTrustListener);
        
        trustLabel = factory.createCLabel(trustGroup, "Requirement not added");
	    data = new FormData();
	    data.left = new FormAttachment(0, 20);
	    data.top = new FormAttachment(sliderTrustworthiness, 10);
	    data.width = 220;
	    trustLabel.setLayoutData(data);
	    
	    removeTrustButton = factory.createButton(trustGroup, "", SWT.BUTTON1);
	    removeTrustButton.setText("Remove");
	    removeTrustButton.addSelectionListener(removeTrustListener);
        data = new FormData();
        data.top = new FormAttachment(sliderTrustworthiness, 10);
        data.left = new FormAttachment(trustLabel, 20);
        data.bottom = new FormAttachment(100, -20);
        removeTrustButton.setLayoutData(data);
        removeTrustButton.setEnabled(true);
	    
	    trustGroup.pack();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		diagram = getDiagram();
		DiscoverSelectionAdapter.setDiagram(diagram);

		EList<EObject> list = getDiagram().eResource().getContents();
		processId = "";
		for(EObject ob : list){
			if(ob instanceof org.eclipse.bpmn2.Process){
				org.eclipse.bpmn2.Process process = (org.eclipse.bpmn2.Process) ob;
				processId = process.getId();
				DiscoverSelectionAdapter.setProcessId(processId);
				OperationNameListener.setProcessId(processId);
			}
		}

		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;

			ServiceTask serviceTask = (ServiceTask) bo;
			taskId = serviceTask.getId();
		
			DiscoverSelectionAdapter.setTaskId(taskId);
			OperationNameListener.setTaskId(taskId);
			OperationNameListener.setTask(serviceTask);
			integrityLabel.setText("Data transmission between " + serviceTask.getId()+" and");
		}
		
		Hashtable<String,String> hashTableField = org.activiti.designer.elsag.data.Data.hashTableFieldProcess.get(processId);
		if(hashTableField == null){
			hashTableField = new Hashtable<String,String>();
			org.activiti.designer.elsag.data.Data.hashTableFieldProcess.put(processId, hashTableField);
		}
		
		Hashtable<String,Set<Service>> hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
		if(hashTableLocations == null){
			hashTableLocations = new Hashtable<String,Set<Service>>();
		}
		Set<Service> setOld = hashTableLocations.get(taskId);
		if(setOld != null){
			hashTableLocations.put(taskId, setOld);
			org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId, hashTableLocations);
		} else {
			hashTableLocations.put(taskId, new HashSet<Service>());
			org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.put(processId, hashTableLocations);
		}
		
		Hashtable<String,Hashtable<String,List<List<String>>>> hashTableTaskOperationInputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.get(processId);
		if(hashTableTaskOperationInputType == null){
			hashTableTaskOperationInputType = new Hashtable<String,Hashtable<String,List<List<String>>>>();
		}
		Hashtable<String,List<List<String>>> hashTableInputTypeOld = hashTableTaskOperationInputType.get(taskId);
		if(hashTableInputTypeOld != null){
			hashTableTaskOperationInputType.put(taskId, hashTableInputTypeOld);
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);
		} else {
			hashTableTaskOperationInputType.put(taskId, new Hashtable<String,List<List<String>>>());
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationInputTypeProcess.put(processId, hashTableTaskOperationInputType);
		}
		
		Hashtable<String,Hashtable<String,List<String>>> hashTableTaskOperationOutputType = org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.get(processId);
		if(hashTableTaskOperationOutputType == null){
			hashTableTaskOperationOutputType = new Hashtable<String,Hashtable<String,List<String>>>();
		}
		Hashtable<String, List<String>> hashTableOperationOutputTypeOld = hashTableTaskOperationOutputType.get(taskId);
		if(hashTableOperationOutputTypeOld != null){
			hashTableTaskOperationOutputType.put(taskId, hashTableOperationOutputTypeOld);
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.put(processId, hashTableTaskOperationOutputType);
		} else {
			hashTableTaskOperationOutputType.put(taskId, new Hashtable<String, List<String>>());
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationOutputTypeProcess.put(processId, hashTableTaskOperationOutputType);
		}
		
		Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);
		if(hashTableTaskOperations == null){
			hashTableTaskOperations = new Hashtable<String,Hashtable<String,Set<Service>>>();
		}
		Hashtable<String,Set<Service>> hashTableOld = hashTableTaskOperations.get(taskId);
		if(hashTableOld != null){
			hashTableTaskOperations.put(taskId, hashTableOld);
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
		} else {
			hashTableTaskOperations.put(taskId, new Hashtable<String,Set<Service>>());
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.put(processId, hashTableTaskOperations);
		}
		
		Hashtable<String,List<ServiceDiscovered>> hashTableTaskServiceDiscovered = org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.get(processId);
		if(hashTableTaskServiceDiscovered == null){
			hashTableTaskServiceDiscovered = new Hashtable<String,List<ServiceDiscovered>>();
		}
		List<ServiceDiscovered> listOld = hashTableTaskServiceDiscovered.get(taskId);
		if(listOld != null){
			hashTableTaskServiceDiscovered.put(taskId, listOld);
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.put(processId, hashTableTaskServiceDiscovered);
		} else {
			hashTableTaskServiceDiscovered.put(taskId, new Vector<ServiceDiscovered>());
			org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.put(processId, hashTableTaskServiceDiscovered);
		}
		
		String[] items = new String[3];
		items[0] = "low";
		items[1] = "medium";
		items[2] = "strong";
		confidentialityAlgList.setItems(items);
		confidentialityAlgList.select(0);
		
		confidentialityResultAlgList.setItems(items);
		confidentialityResultAlgList.select(0);
		
	}
	
	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			typeText.setText("");
			resultText.setText("");
			resultText.setText("");
			inputText.setText("");
			addTrustButton.setText("Add");
			addTrustButton.pack();
			requestedServiceProviderText.setText("");
			requestedServiceRoleText.setText("");
			if (sliderTrustworthiness != null && !sliderTrustworthiness.isDisposed()) {
				sliderTrustworthiness.setSelection(50);
			}
			typeText.removeFocusListener(listener);
			resultText.removeFocusListener(listener);
			inputText.removeFocusListener(listener);
			requestedServiceProviderText.removeFocusListener(listener);
			requestedServiceRoleText.removeFocusListener(listener);

			if (comboIntegrity != null && !comboIntegrity.isDisposed()) {
				comboIntegrity.removeFocusListener(listener);
				comboIntegrity.setText("");
			}
			if (operationNameList != null && !operationNameList.isDisposed()) {
				operationNameList.removeAll();
			}
			if (operationInputList != null && !operationInputList.isDisposed()) {
				operationInputList.removeAll();
			}
			if (confidentialityButton != null && !confidentialityButton.isDisposed()) {
				confidentialityButton.setSelection(false);
			}
			if (confidentialityResultButton != null && !confidentialityResultButton.isDisposed()) {
				confidentialityResultButton.setSelection(false);
			}
			
			
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;
			
			ServiceTask serviceTask = (ServiceTask) bo;
		
			Hashtable<String, List<ServiceDiscovered>> hashTableTaskServiceDiscovered = org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.get(processId);
			List<ServiceDiscovered> listServiceDiscovered = hashTableTaskServiceDiscovered.get(taskId);
			
			for(ServiceDiscovered service : listServiceDiscovered){
				if (operationNameList != null && !operationNameList.isDisposed()) {
					operationNameList.add(service.getName(), service.getId());
				}
			}
			
			List<FieldExtension> list = serviceTask.getFieldExtensions();
			
			InputSelectionAdapter.setListFieldExtension(list);
			
			String operationField = "";
			String iType = "";
			@SuppressWarnings("unused")
			String oType = "void";
			
			List<String> typesInputField = new Vector<String>();
			
			
			for(FieldExtension field : list){
				if(field.getFieldname().equals("type")){
					typeText.setText(field.getExpression());
				} else if(field.getFieldname().equals("operation")){
					operationField = field.getExpression();
				} else if(field.getFieldname().equals("input")){
					String input = field.getExpression();
					inputText.setText(input);
				} else if(field.getFieldname().equals("resultVariable")){
					resultText.setText(field.getExpression());
				} else if(field.getFieldname().equals("inputType")){
					iType = field.getExpression();
					StringTokenizer tokenizer = new StringTokenizer(iType,",");
					while(tokenizer.hasMoreTokens()){
						String token = tokenizer.nextToken();
						if(token.startsWith(" ")){
							token = token.substring(1, token.length());
						}
						String inputTypeInService = token.substring(token.indexOf("(type:")+7, token.length()-1);
						typesInputField.add(inputTypeInService);
					}
					
				} else if(field.getFieldname().equals("outputType")){
					oType = field.getExpression();
				} else if(field.getFieldname().equals("RequestedServiceProvider")){
					requestedServiceProviderText.setText(field.getExpression());
				} else if(field.getFieldname().equals("RequestedServiceProviderRole")){
					requestedServiceRoleText.setText(field.getExpression());
				} else if(field.getFieldname().equals("location")){
					locationText.setVisible(true);
					locationLabel.setVisible(true);
					locationText.setText(field.getExpression());
				}
			}
			
			if (operationOutputLabel != null && !operationOutputLabel.isDisposed()) {
				operationOutputLabel.setVisible(false);
			}
			if (operationOutLabel != null && !operationOutLabel.isDisposed()) {
				operationOutLabel.setVisible(false);
			}
			if (operationInputLabel != null && !operationInputLabel.isDisposed()) {
				operationInputLabel.setVisible(false);
			}
			if (operationInputList != null && !operationInputList.isDisposed()) {
				operationInputList.setVisible(false);
			}
			
			if(operationNameList != null && !operationNameList.isDisposed()){
				if(operationNameList.getItemCount() == 0){
					if(!(operationField.equals("") || operationField.equals(null))){
						operationNameList.add(operationField);
						operationNameList.select(0);
						selectOperationInList(serviceTask);
					}
				} else {
					for(ServiceDiscovered service : listServiceDiscovered){
						List<String> typesInputService = new Vector<String>();
						List<String> inputList = service.getInput();
						for(String input : inputList){
							String inputTypeInService = input.substring(input.indexOf("(type:")+7, input.length()-1);
							typesInputService.add(inputTypeInService);
						}
						boolean equal = true;
						if(service.getName().equals(operationField) && typesInputService.size() == typesInputField.size()){
							for(String typeInService : typesInputService){
								for(String typeInField : typesInputField){
									if(!typeInService.equals(typeInField)){
										equal = false;
										break;
									}
								}
							}
							if(equal){
								operationNameList.select(service.getId());
								selectOperationInList(serviceTask);
							}
						}
					}
				}
			}

			
			if(!typeText.getText().equals("")){
				discoveryButton.setEnabled(true);
			} else {
				discoveryButton.setEnabled(false);
			}
			
			SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
			if(securityExtension!=null){
				List<Integrity> listIntegrity = securityExtension.getIntegrityReq();
				String[] items = new String[listIntegrity.size()];
				int i = 0;
				for(Integrity integrity : listIntegrity){
					if(integrity != null){
						String with = integrity.getWith();
						items[i] = with;
						i++;
					}
				}
				Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
				if(trustworthiness != null){
					trustLabel.setText("Current value: " + trustworthiness.getValue());
					removeTrustButton.setEnabled(true);
					addTrustButton.setText("Update");
					addTrustButton.pack();
				} else {
					trustLabel.setText("Trustworthiness requirement not added");
					removeTrustButton.setEnabled(false);
				}
				if (comboIntegrity != null && !comboIntegrity.isDisposed() && listIntegrity.size()==0) {
					comboIntegrity.removeAll();
					comboIntegrity.setText("no service");
				} else if (comboIntegrity != null && !comboIntegrity.isDisposed()) {
					comboIntegrity.setItems(items);
				}
				List<Confidentiality> listConfidentiality = securityExtension.getConfidentialityReq();
				for(Confidentiality confidentiality : listConfidentiality){
					if(confidentiality != null){
						String typeConf = confidentiality.getType();
						String alg = confidentiality.getAlgorithm();
						if(typeConf.equals("input")){
							confidentialityButton.setSelection(true);
							if(alg.equals("Basic128Sha256Rsa15")){
								confidentialityAlgList.select(0);
							} else if (alg.equals("Basic192Sha256Rsa15")){
								confidentialityAlgList.select(1);
							} else if (alg.equals("Basic256Sha256Rsa15")){
								confidentialityAlgList.select(2);
							}
							confidentialityAlgList.setEnabled(false);
						} else if(typeConf.equals("output")){
							confidentialityResultButton.setSelection(true);
							if(alg.equals("Basic128Sha256Rsa15")){
								confidentialityResultAlgList.select(0);
							} else if (alg.equals("Basic192Sha256Rsa15")){
								confidentialityResultAlgList.select(1);
							} else if (alg.equals("Basic256Sha256Rsa15")){
								confidentialityResultAlgList.select(2);
							}
							confidentialityResultAlgList.setEnabled(false);
						}
						
					}
				}
			} else {
				if (comboIntegrity != null && !comboIntegrity.isDisposed()) {
					comboIntegrity.removeAll();
					comboIntegrity.setText("no service");
				}
				trustLabel.setText("Trustworthiness requirement not added");
				removeTrustButton.setEnabled(false);
			}
			
			if (operationNameList != null && !operationNameList.isDisposed() && operationNameList.getSelectionCount() == 0) {
				removeIntegrityButton.setEnabled(false);
			} else if (operationNameList != null && !operationNameList.isDisposed()){
				removeIntegrityButton.setEnabled(true);
			}
			
			if (comboIntegrity != null && !comboIntegrity.isDisposed()) {
				if(comboIntegrity.getItemCount()>0){
					comboIntegrity.setEnabled(true);
				} else {
					comboIntegrity.setEnabled(false);
				}
			}
			
			if(getListOfServiceTasks().size()>1){
				addIntegrityButton.setEnabled(true);
			} else {
				addIntegrityButton.setEnabled(false);
			}
			
			AddIntegritySelectionAdapter.setServiceTasksList(getListOfServiceTasks());
			AddIntegritySelectionAdapter.setTaskId(taskId);
			
			typeText.addFocusListener(listener);
			resultText.addFocusListener(listener);
			inputText.addFocusListener(listener);
			requestedServiceProviderText.addFocusListener(listener);
			requestedServiceRoleText.addFocusListener(listener);

			if (comboIntegrity != null && !comboIntegrity.isDisposed()) {
				comboIntegrity.addFocusListener(listener);
			}
	
		}
	}
	
	private FocusListener listener = new FocusListener() {

		public void focusGained(final FocusEvent e) {
		}

		public void focusLost(final FocusEvent e) {
			PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
				if (bo instanceof ServiceTask) {
					DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
					@SuppressWarnings("restriction")
					TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
					ActivitiUiUtil.runModelChange(new Runnable() {
						public void run() {
							Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
							if (bo == null) {
								return;
							}
							ServiceTask serviceTask = (ServiceTask)  bo;
							saveExtension("type", typeText.getText());
							
							String requestedServiceProvider = requestedServiceProviderText.getText();
							if(!requestedServiceProvider.equals(""))
								saveExtension("RequestedServiceProvider", requestedServiceProvider);
							
							String serviceProviderRole = requestedServiceRoleText.getText();
							if(!serviceProviderRole.equals(""))
								saveExtension("RequestedServiceProviderRole", serviceProviderRole);
							
							Hashtable<String,String> hashTableField = org.activiti.designer.elsag.data.Data.hashTableFieldProcess.get(processId);
							hashTableField.put(serviceTask.getId(), typeText.getText());
							org.activiti.designer.elsag.data.Data.hashTableFieldProcess.put(processId,hashTableField);
							
							String[] inputs = operationInputList.getItems();
							if (operationInputList != null && !operationInputList.isDisposed()) {
								
							}
							String inputType = "";
							for(int i =0; i<inputs.length; i++){
								String input = inputs[i];
								if(inputType.equals(""))
									inputType = input + ",";
								else
									inputType = inputType + " " + input + ",";
							}
							
							String outputType = operationOutputLabel.getText();
							
							if(!inputType.equals("")){
								inputType = inputType.substring(0, inputType.length()-1);
							}
							
							if(operationNameList.getSelectionCount() > 0){
								saveExtension("operation", operationNameList.getSelection()[0]);
							}
							if(!inputText.getText().equals("")){
								String input = inputText.getText();
								saveExtension("input", input);
							}
							else
								removeExtension("input");
							saveExtension("inputType", inputType);
							saveExtension("outputType", outputType);
							if(!resultText.getText().equals(""))
								saveExtension("resultVariable", resultText.getText());
							else
								removeExtension("resultVariable");
							
							saveImplementationType(CLASS_TYPE);
						}
					}, editingDomain, "Model Update");
				}
			}
		
		}
	};
	
	private ModifyListener modifyListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			comboIntegrity.setEnabled(true);
		}
		
	};
	
	private SelectionListener removeListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			String serviceId = comboIntegrity.getText();
			removeIntegrityExtension(serviceId);
			typeIntegrityText.setText("");
			algIntegrityText.setText("");
			comboIntegrity.setText("");
			comboIntegrity.remove(serviceId);
			if(comboIntegrity.getItemCount()==0){
				comboIntegrity.setText("no service");
				comboIntegrity.setEnabled(false);
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	private SelectionListener cloudListener = new SelectionListener(){

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			CloudDialog cloudDialog = new CloudDialog(composite.getDisplay(), typeText, discoveryButton, processId, taskId);
			cloudDialog.createContents();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
	
	private SelectionListener selectionIntegrityListener = new SelectionListener() {


		@Override
		public void widgetSelected(SelectionEvent e) {
			
			PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
				if (bo instanceof ServiceTask) {
					ServiceTask task = (ServiceTask) bo;
					SecurityExtension securityExtension = task.getSecurityExtensions();
					if(securityExtension!=null){
						List<Integrity> listIntegrity = securityExtension.getIntegrityReq();
						String algorithm = "";
						String type = "";
						for(Integrity integrity : listIntegrity){
							if(integrity.getWith().equals(comboIntegrity.getText())){
								algorithm = integrity.getAlgorithm();
								type = integrity.getType();
								typeIntegrityText.setText(type);
								algIntegrityText.setText(algorithm);
								break;
							}
						}
						
					}
				}
				removeIntegrityButton.setEnabled(true);

			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
	};
	
	private SelectionListener addTrustListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			
			int selection = sliderTrustworthiness.getSelection();
			String value = new Double(roundTwoDecimals(selection / 100.0)).toString();
			if(!value.equals("")){
				saveTrustworthinessExtension(value);
				trustLabel.setText("Current value: "+value);
				removeTrustButton.setEnabled(true);
			}else
				log.debug("null value");
			
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
		
		double roundTwoDecimals(double d) {
			DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
			symbols.setDecimalSeparator('.');
			DecimalFormat twoDForm = new DecimalFormat("#.##", symbols);
			return Double.valueOf(twoDForm.format(d));
		}
	};
	
	private SelectionListener removeTrustListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			removeTrustworthinessExtension();
			trustLabel.setText("Trustworthiness requirement not added");
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
	};
	
	private SelectionListener addConfidentialityListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if(confidentialityButton.getSelection()) {
				int index = confidentialityAlgList.getSelectionIndex();
				String typeConf = confidentialityAlgList.getItem(index);
				if(typeConf.equals("low")){
					confidentialityAlgList.setEnabled(false);
					saveConfidentialityExtension("input", "Basic128Sha256Rsa15");
				} else if(typeConf.equals("medium")){
					confidentialityAlgList.setEnabled(false);
					saveConfidentialityExtension("input", "Basic192Sha256Rsa15");
				} else if(typeConf.equals("strong")){
					confidentialityAlgList.setEnabled(false);
					saveConfidentialityExtension("input", "Basic256Sha256Rsa15");
				}
			} else {
				confidentialityAlgList.setEnabled(true);
				removeConfidentialityExtension("input");
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
	};
	
	private SelectionListener addConfidentialityResultListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if(confidentialityResultButton.getSelection()) {
				int index = confidentialityResultAlgList.getSelectionIndex();
				String typeConf = confidentialityResultAlgList.getItem(index);
				if(typeConf.equals("low")){
					confidentialityResultAlgList.setEnabled(false);
					saveConfidentialityExtension("output", "Basic128Sha256Rsa15");
				} else if(typeConf.equals("medium")){
					confidentialityResultAlgList.setEnabled(false);
					saveConfidentialityExtension("output", "Basic192Sha256Rsa15");
				} else if(typeConf.equals("strong")){
					confidentialityResultAlgList.setEnabled(false);
					saveConfidentialityExtension("output", "Basic256Sha256Rsa15");
				}
			} else {
				confidentialityResultAlgList.setEnabled(true);
				removeConfidentialityExtension("output");
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
	};
	
	private KeyListener keyListener = new KeyListener() {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if((typeText.getText().equals(""))){
				discoveryButton.setEnabled(false);
			}else {
				discoveryButton.setEnabled(true);
			}
		}

	};
	
	private void saveImplementationType(final String type) {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						serviceTask.setImplementationType(type);
						serviceTask.setImplementation("org.aniketos.runtime.AniketosClientDelegation");
					}
				}, editingDomain, "Model Update");
			}

		}
	}
	
	public void saveExtension(final String fieldName, final String expression){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						
						FieldExtension fieldExtension = fieldExtensionExists(serviceTask, fieldName);
						if(fieldExtension != null) {
							fieldExtension.setExpression(expression);
						} else {
							
							FieldExtension newFieldExtension = Bpmn2Factory.eINSTANCE.createFieldExtension();
							newFieldExtension.setFieldname(fieldName);
							newFieldExtension.setExpression(expression);
							getDiagram().eResource().getContents().add(newFieldExtension);
							serviceTask.getFieldExtensions().add(newFieldExtension);
						}
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void removeExtension(final String fieldName){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						
						FieldExtension fieldExtension = fieldExtensionExists(serviceTask, fieldName);
						getDiagram().eResource().getContents().remove(fieldExtension);
						serviceTask.getFieldExtensions().remove(fieldExtension);
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	private FieldExtension fieldExtensionExists(ServiceTask serviceTask, String fieldName) {
		if(serviceTask.getFieldExtensions() == null) return null;
		for(FieldExtension fieldExtension : serviceTask.getFieldExtensions()) {
			if(fieldName.equalsIgnoreCase(fieldExtension.getFieldname())) {
				return fieldExtension;
			}
		}
		return null;
	}
	
	public static void addOperationNameToList(final String operationName, final int index){
		Display.getDefault().syncExec(new Runnable() {
		    public void run(){
		    	if (operationNameList != null && !operationNameList.isDisposed()) {
		    		operationNameList.add(operationName, index);
		    	}
		      }
		    });
	}
	
	public static void cleanOperationNameList(){
		
		Display.getDefault().syncExec(new Runnable() {
		    public void run(){
		    	if (operationNameList != null && !operationNameList.isDisposed()) {
		    		operationNameList.removeAll();
		    		
		    		operationOutputLabel.setVisible(false);
					operationOutLabel.setVisible(false);
					operationInputLabel.setVisible(false);
					operationInputList.setVisible(false);
		    	}
		      }
		    });
	}
	
	public static void setComboIntegrity(final String[] labels){
		
		Display.getDefault().syncExec(new Runnable() {
		    public void run(){
		    	comboIntegrity.setItems(labels);
		      }
		    });
	}
	
	public static void setTypeIntegrityText(final String type){
		
		Display.getDefault().syncExec(new Runnable() {
		    public void run(){
		    	typeIntegrityText.setText(type);
		      }
		    });
	}
	
	public static void setAlgIntegrityText(final String algorithm){
		
		Display.getDefault().syncExec(new Runnable() {
		    public void run(){
		    	algIntegrityText.setText(algorithm);
		      }
		    });
	}
	
	public static String[] getComboIntegrity(){
		final String[] l = comboIntegrity.getItems();
		return l;
	}

	public String getProcessId(){
		return processId;
	}
	
	public String getTaskId(){
		return taskId;
	}
	
	public Diagram returnDiagram(){
		return diagram;
	}
	
	public List<String> getListOfTasksName(){

		List<String> tasksDiscovered = new Vector<String>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getName())){
						tasksDiscovered.add(task.getName());
					}
				}
			}
		}

		return tasksDiscovered;

	}

	public List<String> getListOfTasksId(){

		List<String> tasksDiscovered = new Vector<String>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
		for(PictogramLink link : list){
			EList<EObject> elist = link.getBusinessObjects();
			for(EObject ob : elist){
				if(ob instanceof ServiceTask){
					ServiceTask task = (ServiceTask) ob;
					if(!tasksDiscovered.contains(task.getId())){
						tasksDiscovered.add(task.getId());
					}
				}
			}
		}

		return tasksDiscovered;
	}
	
	public java.util.List<ServiceTask> getListOfServiceTasks(){

		java.util.List<String> tasksDiscovered = new Vector<String>();
		java.util.List<ServiceTask> servicetasksList = new Vector<ServiceTask>();
		EList<PictogramLink> list = getDiagram().getPictogramLinks();
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

	public void saveIntegrityExtension(final String type, final String with, final String algorithm){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						Integrity integrity = AniketosFactory.eINSTANCE.createIntegrity();
						integrity.setType(type);
						integrity.setWith(with);
						integrity.setAlgorithm(algorithm);
						List<Integrity> listInt = securityExtension.getIntegrityReq();
						listInt.add(integrity);
						serviceTask.setSecurityExtensions(securityExtension);
						getDiagram().eResource().getContents().add(integrity);

						log.debug("Integrity requirement added");
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void removeIntegrityExtension(final String serviceTaskId){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						boolean contains = false;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension == null) return;
						List<Integrity> list = securityExtension.getIntegrityReq();
						int i = 0;
						for(Integrity integrity : list) {
							if(integrity.getWith().equalsIgnoreCase(serviceTaskId)) {
								contains = true;
								getDiagram().eResource().getContents().remove(integrity);
								break;
							}
							i++;
						}
						if(contains){
							list.remove(i);
							if(checkSecurityExtensions(securityExtension)){
								serviceTask.setSecurityExtensions(null);
								getDiagram().eResource().getContents().remove(securityExtension);
							}
						}

						log.debug("integrity removed");
					}
				}, editingDomain, "Model Update");
			}
		}
	}

	public void saveSecurityExtension(){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						SecurityExtension securityExtension = AniketosFactory.eINSTANCE.createSecurityExtension();
						serviceTask.setSecurityExtensions(securityExtension);
						getDiagram().eResource().getContents().add(securityExtension);
						log.debug("Security extension added");
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void removeTrustworthinessExtension(){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension == null) return;
						Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
						securityExtension.setTrustworthinessValue(null);
						getDiagram().eResource().getContents().remove(trustworthiness);
						
						if(checkSecurityExtensions(securityExtension)){
							serviceTask.setSecurityExtensions(null);
							getDiagram().eResource().getContents().remove(securityExtension);
						}

						log.debug("Trustwothiness removed");
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void saveTrustworthinessExtension(final String value){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension!=null){
							if(securityExtension.getTrustworthinessValue()!=null){
								Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
								trustworthiness.setValue(value);
								log.debug("Trustworthiness Extension replaced");
							} else {
								Trustworthiness trustworthiness = AniketosFactory.eINSTANCE.createTrustworthiness();
								trustworthiness.setValue(value);
								securityExtension.setTrustworthinessValue(trustworthiness);
								getDiagram().eResource().getContents().add(trustworthiness);
								serviceTask.setSecurityExtensions(securityExtension);
								log.debug("Trustworthiness Extension added");
							}
						} else {
							log.debug("Inserting Trustworthiness "+value);
							securityExtension = AniketosFactory.eINSTANCE.createSecurityExtension();
							Trustworthiness trustworthiness = AniketosFactory.eINSTANCE.createTrustworthiness();
							trustworthiness.setValue(value);
							getDiagram().eResource().getContents().add(trustworthiness);
							securityExtension.setTrustworthinessValue(trustworthiness);
							serviceTask.setSecurityExtensions(securityExtension);
							getDiagram().eResource().getContents().add(securityExtension);
							log.debug("Trustworthiness Extension added");
						}
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void saveConfidentialityExtension(final String type, final String algorithm){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension!=null){
							boolean contains = false;
							List<Confidentiality> listConfidentiality = securityExtension.getConfidentialityReq();
							for(Confidentiality confidentility : listConfidentiality){
								if(confidentility.getType().equals(type)){
									contains = true;
									break;
								}
							}
							if(contains){
								for(Confidentiality confidentility : listConfidentiality){
									if(confidentility.getType().equals(type)){
										confidentility.setAlgorithm(algorithm);
										log.debug("Confidentiality Extension replaced");
									}
								}
							} else {
								Confidentiality confidentility = AniketosFactory.eINSTANCE.createConfidentiality();
								confidentility.setType(type);
								confidentility.setAlgorithm(algorithm);
								listConfidentiality.add(confidentility);
								getDiagram().eResource().getContents().add(confidentility);
								log.debug("Confidentiality Extension added");
							}
						} else {
							securityExtension = AniketosFactory.eINSTANCE.createSecurityExtension();
							List<Confidentiality> listConfidentiality = securityExtension.getConfidentialityReq();
							Confidentiality confidentility = AniketosFactory.eINSTANCE.createConfidentiality();
							confidentility.setType(type);
							confidentility.setAlgorithm(algorithm);
							listConfidentiality.add(confidentility);
							getDiagram().eResource().getContents().add(confidentility);
							serviceTask.setSecurityExtensions(securityExtension);
							getDiagram().eResource().getContents().add(securityExtension);
							log.debug("Confidentiality Extension added");
						}
					}
				}, editingDomain, "Model Update");
			}
		}
	}
	
	public void removeConfidentialityExtension(final String type){
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof ServiceTask) {
				DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
				@SuppressWarnings("restriction")
				TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
				ActivitiUiUtil.runModelChange(new Runnable() {
					public void run() {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
						if (bo == null) {
							return;
						}
						ServiceTask serviceTask = (ServiceTask)  bo;
						boolean contains = false;
						SecurityExtension securityExtension = serviceTask.getSecurityExtensions();
						if(securityExtension == null) return;
						List<Confidentiality> list = securityExtension.getConfidentialityReq();
						int i = 0;
						for(Confidentiality confidentiality : list) {
							if(confidentiality.getType().equals(type)){
								getDiagram().eResource().getContents().remove(confidentiality);
								contains = true;
								break;
							}
							i++;
						}
						if(contains){
							list.remove(i);
							if(checkSecurityExtensions(securityExtension)){
								serviceTask.setSecurityExtensions(null);
								getDiagram().eResource().getContents().remove(securityExtension);
							}
						}

						log.debug("Confidentiality removed");
					}
				}, editingDomain, "Model Update");
			}
		}
	}

	public SecurityExtension getSecurityExtension(){
		SecurityExtension securityExtension = null;
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			ServiceTask serviceTask = (ServiceTask) bo;
			securityExtension = serviceTask.getSecurityExtensions();
		}
		return securityExtension;
	}
	
	public boolean checkSecurityExtensions(SecurityExtension securityExtension){
		List<Integrity> list = securityExtension.getIntegrityReq();
		Trustworthiness trustworthiness = securityExtension.getTrustworthinessValue();
		List<Confidentiality> confidentility = securityExtension.getConfidentialityReq();
		if(list.size()==0 && trustworthiness == null && confidentility.size()==0){
			return true;
		} else {
			return false;
		}
		
	}
	
	private void selectOperationInList(ServiceTask serviceTask){
		if (operationInputList != null && !operationInputList.isDisposed()) {
			operationInputList.removeAll();
		}
		
		
		
		Hashtable<String, List<ServiceDiscovered>> hashTableTaskServiceDiscovered = org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.get(processId);
		List<ServiceDiscovered> listServiceDiscovered = hashTableTaskServiceDiscovered.get(taskId);
		int index = operationNameList.getSelectionIndex();
		
		for(ServiceDiscovered service : listServiceDiscovered){
			if(service.getId() == index){
				List<String> inputList = service.getInput();
				for(String input : inputList){
					operationInputList.add(input);
				}
				operationOutputLabel.setText(service.getOutput());
			}
		}
		
		List<FieldExtension> list = serviceTask.getFieldExtensions();
		
		InputSelectionAdapter.setListFieldExtension(list);
		
		String iType = "";
		String oType = "void";
		
		for(FieldExtension field : list){
			if(field.getFieldname().equals("inputType")){
				iType = field.getExpression();
				StringTokenizer tokenizer = new StringTokenizer(iType,",");
				while(tokenizer.hasMoreTokens()){
					String token = tokenizer.nextToken();
					if(token.startsWith(" ")){
						token = token.substring(1, token.length());
					}
					if(listServiceDiscovered.size() == 0)
						operationInputList.add(token);
				}
				
			} else if(field.getFieldname().equals("outputType")){
				oType = field.getExpression();
				if(listServiceDiscovered.size() == 0)
					operationOutputLabel.setText(oType);
			}
		}
		
		operationOutputLabel.setVisible(true);
		operationOutLabel.setVisible(true);
		operationInputLabel.setVisible(true);
		operationInputList.setVisible(true);
	}

}

class OperationNameListener extends SelectionAdapter {

	private static String taskId;
	private static String processId;
	private static ServiceTask serviceTask;
	private List<ServiceDiscovered> listServiceDiscovered;
	private Composite composite;
	
	public OperationNameListener(Composite composite){
		this.composite = composite;
	}

	public void widgetSelected(SelectionEvent e) {
		if (PropertyAniketosServiceTaskSection.operationInputList != null && !PropertyAniketosServiceTaskSection.operationInputList.isDisposed()) {
			PropertyAniketosServiceTaskSection.operationInputList.removeAll();
		}
		
		Hashtable<String, List<ServiceDiscovered>> hashTableTaskServiceDiscovered = org.activiti.designer.elsag.data.Data.hashTableTaskOperationProcess.get(processId);
		listServiceDiscovered = hashTableTaskServiceDiscovered.get(taskId);
		int index = PropertyAniketosServiceTaskSection.operationNameList.getSelectionIndex();
		
		for(ServiceDiscovered service : listServiceDiscovered){
			if(service.getId() == index){
				List<String> inputList = service.getInput();
				for(String input : inputList){
					PropertyAniketosServiceTaskSection.operationInputList.add(input);
				}
				PropertyAniketosServiceTaskSection.operationOutputLabel.setText(service.getOutput());
			}
		}
		
		List<FieldExtension> list = serviceTask.getFieldExtensions();
		
		InputSelectionAdapter.setListFieldExtension(list);
		
		String iType = "";
		String oType = "void";
		
		for(FieldExtension field : list){
			if(field.getFieldname().equals("inputType")){
				iType = field.getExpression();
				StringTokenizer tokenizer = new StringTokenizer(iType,",");
				while(tokenizer.hasMoreTokens()){
					String token = tokenizer.nextToken();
					if(token.startsWith(" ")){
						token = token.substring(1, token.length());
					}
					if(listServiceDiscovered.size() == 0)
						PropertyAniketosServiceTaskSection.operationInputList.add(token);
				}
				
			} else if(field.getFieldname().equals("outputType")){
				oType = field.getExpression();
				if(listServiceDiscovered.size() == 0)
					PropertyAniketosServiceTaskSection.operationOutputLabel.setText(oType);
			}
		}
		
		PropertyAniketosServiceTaskSection.operationOutputLabel.setVisible(true);
		PropertyAniketosServiceTaskSection.operationOutLabel.setVisible(true);
		PropertyAniketosServiceTaskSection.operationInputLabel.setVisible(true);
		PropertyAniketosServiceTaskSection.operationInputList.setVisible(true);

		String outputType = "";
		String operation = PropertyAniketosServiceTaskSection.operationNameList.getSelection()[0];
		String[] inputs = PropertyAniketosServiceTaskSection.operationInputList.getItems();
		String inputType = "";
		for(int i =0; i<inputs.length; i++){
			String input = inputs[i];
			inputType = inputType + input;
		}
		
		outputType = PropertyAniketosServiceTaskSection.operationOutputLabel.getText();

		String offset = inputType+"O"+outputType;
		
		Hashtable<String,Hashtable<String,Set<Service>>> hashTableTaskOperations = org.activiti.designer.elsag.data.Data.hashTableTaskOperationsProcess.get(processId);

		Hashtable<String, Set<Service>> hashOperation = hashTableTaskOperations.get(taskId);
		Set<Service> services = hashOperation.get(operation+offset);
		if(services!=null)
			showMessage(services.size());
	}
	
	public static void setTaskId(String id){
		taskId = id;
	}
	
	public static void setProcessId(String pid){
		processId = pid;
	}
	
	public static void setTask(ServiceTask task){
		serviceTask = task;
	}
	
	private void showMessage(final int size) {
		Hashtable<String,Set<Service>> hashTableLocations = org.activiti.designer.elsag.data.Data.hashTableLocationsProcess.get(processId);
		final Set<Service> set = hashTableLocations.get(taskId);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if(size == 1 && listServiceDiscovered.size() == 1){
					MessageDialog.openInformation(composite.getShell(), "Service selection",
							size + " of the "+ set.size() +" discovered service provides this operation");
				} else if (size == 1 && set.size() > 1){
					MessageDialog.openInformation(composite.getShell(), "Service selection",
							size + " of the "+ set.size() +" discovered services provides this operation");
				} else if (size > 1 && listServiceDiscovered.size() == 1){
					MessageDialog.openInformation(composite.getShell(), "Service selection",
							size + " of the "+ set.size() +" discovered service provide this operation");
				} else {
					MessageDialog.openInformation(composite.getShell(), "Service selection",
							size + " of the "+ set.size() +" discovered services provide this operation");
				}
			}
		});

	}

	
	
}
