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
package eu.aniketos.mtm.srs2activiti.wizard;

import java.util.Vector;

import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.Activator;
import eu.aniketos.mtm.idm.client.IdMClient;
import eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation;
import eu.aniketos.mtm.srs2activiti.wizard.resources.BodSodCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.BodSodCorrection.BodSodKind;
import eu.aniketos.mtm.srs2activiti.wizard.resources.ConfidentialityCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.IntegrityCorrection;
import eu.aniketos.mtm.srs2activiti.wizard.resources.SecurityCorrection;
import eu.aniketos.mtm.utils.ModelingUtils;

/**
 * MTM mapping security errors correction wizard, which configures the corrections needed after the mapping between the high-level
 * security requirements in the SRS and the low-level security requirements in the Activiti BPMN
 * file.
 * 
 * @author Tecnalia
 *
 */
public class ConfigureCorrectionsWizard extends Wizard {

	private Vector<SecurityCorrection> corrections;
	
	public ConfigureCorrectionsWizard(Vector<SecurityCorrection> corrections) {
		this.corrections = corrections;
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public void addPages() {
		for (SecurityCorrection c : corrections) {
			if (c instanceof BodSodCorrection) {
				addPage(new ConfigureBodSodPage("Configure BoD/SoD Corrections"));
				break;
			}
		}
		
		for (SecurityCorrection c : corrections) {
			if (c instanceof IntegrityCorrection) {
				addPage(new ConfigureIntegrityPage("Configure Integrity"));
				break;
			}
		}
		
		for (SecurityCorrection c : corrections) {
			if (c instanceof ConfidentialityCorrection) {
				addPage(new ConfigureConfidentialityPage("Configure Confidentiality"));
				break;
			}
		}
	}
	
	
	public Vector<SecurityCorrection> getCorrections() {
		return corrections;
	}


	private class ConfigureBodSodPage extends WizardPage {

		private Composite configComposite;
		
		protected ConfigureBodSodPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(6, true);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Configure BoD/SoD Corrections");
			setDescription("Configure how the MTM shall correct the Activiti model with regard to Binding of Duty and Separation of Duty requirements.");
			
			Label leftLabel = new Label(topPanel, SWT.NONE);
			GridData leftData = new GridData(GridData.FILL_HORIZONTAL);
			leftData.horizontalSpan = 3;
			leftLabel.setLayoutData(leftData);
			leftLabel.setText("BoD / SoD Corrections:");
			
			Label rightLabel = new Label(topPanel, SWT.NONE);
			GridData rightData = new GridData(GridData.FILL_HORIZONTAL);
			rightData.horizontalSpan = 3;
			rightLabel.setLayoutData(rightData);
			rightLabel.setText("Permissions per Task:");
			
			ListViewer correctionList = new ListViewer(topPanel, SWT.SINGLE);
			GridData correctionListData = new GridData(GridData.FILL_BOTH);
			correctionListData.horizontalSpan = 3;
			correctionList.getList().setLayoutData(correctionListData);
			
			correctionList.setLabelProvider(new LabelProvider() {

				@Override
				public String getText(Object element) {
					if (element instanceof BodSodCorrection) {
						String text = ((BodSodCorrection)element).getKind() == BodSodKind.BOD ? "[BoD] " : "[SoD] ";
						text += ((BodSodCorrection)element).getTask1().getName() + " - " + ((BodSodCorrection)element).getTask2().getName();
						return text;
					}
					else {
						return "Unkown object type: " + element.toString();
					}
				}
				
			});
			
			correctionList.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					Object o = ((StructuredSelection)event.getSelection()).getFirstElement();
					if (o instanceof BodSodCorrection) {
						rebuildComposite((BodSodCorrection)o);
					}
				}
			});
			
			for (SecurityCorrection c : corrections) {
				if (c instanceof BodSodCorrection) {
					correctionList.add(c);
				}
			}
			
			configComposite = new Composite(topPanel, SWT.NONE);
			GridData configCompositeData = new GridData(GridData.FILL_BOTH);
			configCompositeData.horizontalSpan = 3;
			configComposite.setLayoutData(configCompositeData);
			GridLayout configLayout = new GridLayout(3, true);
			configComposite.setLayout(configLayout);
			
			// Set the selection
			//correctionList.getList().select(0);

			// Set the control
			setControl(topPanel);

			// Set page completion...
			checkCompleteness();
		}
		
		private void checkCompleteness() {
			boolean complete = true;
			for (SecurityCorrection sc : corrections) {
				if (sc instanceof BodSodCorrection) {
					BodSodCorrection bsc = (BodSodCorrection) sc;
					if (bsc.getRole1() == null || bsc.getAction1() == null || bsc.getRole2() == null || bsc.getAction2() == null) {
						complete = false;
					}
				}
			}
			setPageComplete(complete);
		}
		
		private void rebuildComposite(BodSodCorrection bsc) {
			// Remove old controls
			for (Control c : configComposite.getChildren()) {
				c.dispose();
			}
			
			// Load IDM client
			IdMClient idm = new IdMClientImplementation(Activator.getDefault().getPreferenceStore().getString("IdM_file_path"));
			
			// Construct controls
			// Task 1
			Label title1Label = new Label(configComposite, SWT.NONE);
			GridData title1LabelData = new GridData(GridData.FILL_HORIZONTAL);
			title1LabelData.horizontalSpan = 3;
			title1Label.setLayoutData(title1LabelData);
			title1Label.setText("Task 1: " + bsc.getTask1().getName() + " (" + (bsc.getTask1() instanceof ServiceTask ? "Service Task" : "User Task") + ")");
			
			Label role1Label = new Label(configComposite, SWT.NONE);
			GridData role1LabelData = new GridData(GridData.FILL_HORIZONTAL);
			role1LabelData.horizontalSpan = 1;
			role1Label.setLayoutData(role1LabelData);
			role1Label.setText("Role:");
			
			Combo role1Combo = new Combo(configComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
			GridData role1ComboData = new GridData(GridData.FILL_HORIZONTAL);
			role1ComboData.horizontalSpan = 2;
			role1Combo.setLayoutData(role1ComboData);
			
			
			String roles = bsc.getTask1() instanceof ServiceTask ? idm.getGroupsListOfService() : idm.getGroupsListOfHuman();
			for (String role : roles.split(",")) {
				role1Combo.add(role);
			}
			
			role1Combo.addSelectionListener(new RoleSelectionListener(bsc, 1));
			ModelingUtils mu = ModelingUtils.configure(null, null, bsc.getTask1().eResource());
			String performerRole1 = null;
			if(bsc.getRole1() == null){				
				if(bsc.getTask1() instanceof ServiceTask){
					FieldExtension fe = mu.getRoleForTask((ServiceTask) bsc.getTask1());
					if(fe != null){
						performerRole1 = fe.getExpression();
					}					
				}
				else{
					if(((UserTask)bsc.getTask1()).getCandidateGroups() != null && ((UserTask)bsc.getTask1()).getCandidateGroups().size() > 0){
						performerRole1 = ((UserTask)bsc.getTask1()).getCandidateGroups().get(0).getGroup();
					}					
				}					
			}
			if(performerRole1 != null && role1Combo.indexOf(performerRole1) != -1){
				role1Combo.select(role1Combo.indexOf(performerRole1));
				role1Combo.setEnabled(false);
			}
			else{
				role1Combo.select(bsc.getRole1() == null ? 0 : role1Combo.indexOf(bsc.getRole1()));
			}
			
			Label action1Label = new Label(configComposite, SWT.NONE);
			GridData action1LabelData = new GridData(GridData.FILL_HORIZONTAL);
			action1LabelData.horizontalSpan = 1;
			action1Label.setLayoutData(action1LabelData);
			action1Label.setText("Action:");
			
			Combo action1Combo = new Combo(configComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
			GridData action1ComboData = new GridData(GridData.FILL_HORIZONTAL);
			action1ComboData.horizontalSpan = 2;
			action1Combo.setLayoutData(action1ComboData);
			
			action1Combo.setItems(new String[] {"FullAccess", "Claim", "Assign", "Complete"});
			
			action1Combo.addSelectionListener(new ActionSelectionListener(bsc, 1));
			action1Combo.select(bsc.getAction1() == null ? 0 : action1Combo.indexOf(bsc.getAction1()));
			
			if (bsc.getTask1() instanceof ServiceTask) {
				action1Combo.setEnabled(false);
			}
			
			// Task2
			
			Label title2Label = new Label(configComposite, SWT.NONE);
			GridData title2LabelData = new GridData(GridData.FILL_HORIZONTAL);
			title2LabelData.horizontalSpan = 3;
			title2Label.setLayoutData(title2LabelData);
			title2Label.setText("Task 2: " + bsc.getTask2().getName() + " (" + (bsc.getTask2() instanceof ServiceTask ? "Service Task" : "User Task") + ")");
			
			Label role2Label = new Label(configComposite, SWT.NONE);
			GridData role2LabelData = new GridData(GridData.FILL_HORIZONTAL);
			role2LabelData.horizontalSpan = 1;
			role2Label.setLayoutData(role2LabelData);
			role2Label.setText("Role:");
			
			Combo role2Combo = new Combo(configComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
			GridData role2ComboData = new GridData(GridData.FILL_HORIZONTAL);
			role2ComboData.horizontalSpan = 2;
			role2Combo.setLayoutData(role2ComboData);
			
			
			roles = bsc.getTask2() instanceof ServiceTask ? idm.getGroupsListOfService() : idm.getGroupsListOfHuman();
			for (String role : roles.split(",")) {
				role2Combo.add(role);
			}
			
			role2Combo.addSelectionListener(new RoleSelectionListener(bsc, 2));
			String performerRole2 = null;
			if(bsc.getRole2() == null){				
				if(bsc.getTask2() instanceof ServiceTask){
					FieldExtension fe = mu.getRoleForTask((ServiceTask) bsc.getTask2());
					if(fe != null){
						performerRole2 = fe.getExpression();
					}	
				}
				else{
					if(((UserTask)bsc.getTask2()).getCandidateGroups() != null && ((UserTask)bsc.getTask2()).getCandidateGroups().size() > 0){
						performerRole2 = ((UserTask)bsc.getTask2()).getCandidateGroups().get(0).getGroup();
					}					
				}					
			}
			if(performerRole2 != null && role2Combo.indexOf(performerRole2) != -1){
				role2Combo.select(role2Combo.indexOf(performerRole2));
				role2Combo.setEnabled(false);
			}
			else{
				role2Combo.select(bsc.getRole2() == null ? 0 : role2Combo.indexOf(bsc.getRole2()));
			}
			
			Label action2Label = new Label(configComposite, SWT.NONE);
			GridData action2LabelData = new GridData(GridData.FILL_HORIZONTAL);
			action2LabelData.horizontalSpan = 1;
			action2Label.setLayoutData(action2LabelData);
			action2Label.setText("Action:");
			
			Combo action2Combo = new Combo(configComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
			GridData action2ComboData = new GridData(GridData.FILL_HORIZONTAL);
			action2ComboData.horizontalSpan = 2;
			action2Combo.setLayoutData(action2ComboData);
			
			action2Combo.setItems(new String[] {"FullAccess", "Claim", "Assign", "Complete"});
			
			action2Combo.addSelectionListener(new ActionSelectionListener(bsc, 2));
			action2Combo.select(bsc.getAction2() == null ? 0 : action2Combo.indexOf(bsc.getAction2()));
			
			if (bsc.getTask2() instanceof ServiceTask) {
				action2Combo.setEnabled(false);
			}
			
			// Add the default values
			bsc.setTask1Role(role1Combo.getItem(role1Combo.getSelectionIndex()));
			bsc.setTask2Role(role2Combo.getItem(role2Combo.getSelectionIndex()));
			bsc.setTask1Action(action1Combo.getItem(action1Combo.getSelectionIndex()));
			bsc.setTask2Action(action2Combo.getItem(action2Combo.getSelectionIndex()));
			
			
			// Layout again
			configComposite.layout();
			
			// Check completeness
			checkCompleteness();
		}
		
	}
	
	private class ConfigureIntegrityPage extends WizardPage {

		protected ConfigureIntegrityPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(6, true);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Configure Integrity Corrections");
			setDescription("Configure how the MTM shall correct the Activiti model with regard to Integrity requirements.");

			for (SecurityCorrection sc : corrections) {
				if (sc instanceof IntegrityCorrection) {
					IntegrityCorrection ic = (IntegrityCorrection)sc;
					if(ic.getTask() instanceof ServiceTask){
						Label titleLabel = new Label(topPanel, SWT.NONE);
						GridData titleLabelData = new GridData(GridData.FILL_HORIZONTAL);
						titleLabelData.horizontalSpan = 6;
						titleLabel.setLayoutData(titleLabelData);
						titleLabel.setText("Integrity requirement for task " + ((IntegrityCorrection)sc).getTask().getName() + 
								" (related to variable " +
								((IntegrityCorrection)sc).getVar() + "):");					
						Label destLabel = new Label(topPanel, SWT.NONE);
						GridData destLabelData = new GridData(GridData.FILL_HORIZONTAL);
						destLabelData.horizontalSpan = 2;
						destLabel.setLayoutData(destLabelData);
						destLabel.setText("Destination task:");
						
						Label typeLabel = new Label(topPanel, SWT.NONE);
						GridData typeLabelData = new GridData(GridData.FILL_HORIZONTAL);
						typeLabelData.horizontalSpan = 2;
						typeLabel.setLayoutData(typeLabelData);
						typeLabel.setText("Integrity Type:");
						
						Label algLabel = new Label(topPanel, SWT.NONE);
						GridData algLabelData = new GridData(GridData.FILL_HORIZONTAL);
						algLabelData.horizontalSpan = 2;
						algLabel.setLayoutData(algLabelData);
						algLabel.setText("Algorithm:");
						
						ComboViewer destCombo = new ComboViewer(topPanel, SWT.DROP_DOWN);
						GridData destComboData = new GridData(GridData.FILL_HORIZONTAL);
						destComboData.horizontalSpan = 2;
						destCombo.getCombo().setLayoutData(destComboData);
						
						destCombo.setLabelProvider(new LabelProvider() {

							@Override
							public String getText(Object element) {
								if (element instanceof Task) {
									Task t = (Task) element;
									return t.getId() + "-" + t.getName();
								}
								else {
									return "Unknown element: " + element;
								}
							}
							
						});
						
						// Fill in the data
						TreeIterator<EObject> i = ic.getTask().eResource().getAllContents();
						while (i.hasNext()) {
							EObject o = i.next();
							if (o instanceof ServiceTask && !o.equals(ic.getTask())) {
								destCombo.add(o);
							}
						}
						
						destCombo.addSelectionChangedListener(new OriginListener(ic));
						
						Text typeText = new Text(topPanel, SWT.SINGLE | SWT.BORDER);
						GridData typeTextData = new GridData(GridData.FILL_HORIZONTAL);
						typeTextData.horizontalSpan = 2;
						typeText.setLayoutData(typeTextData);
						typeText.addModifyListener(new TypeModifyListener((IntegrityCorrection) sc));
						
						Text algText = new Text(topPanel, SWT.SINGLE | SWT.BORDER);
						GridData algTextData = new GridData(GridData.FILL_HORIZONTAL);
						algTextData.horizontalSpan = 2;
						algText.setLayoutData(algTextData);
						algText.addModifyListener(new AlgorithmModifyListener((IntegrityCorrection) sc));
						
					}
					else{
						Label titleLabel = new Label(topPanel, SWT.NONE);
						GridData titleLabelData = new GridData(GridData.FILL_HORIZONTAL);
						titleLabelData.horizontalSpan = 6;
						titleLabel.setLayoutData(titleLabelData);
						titleLabel.setText("Integrity requirement for user task " + ((IntegrityCorrection)sc).getTask().getName() + 
								" (related to variable " + ((IntegrityCorrection)sc).getVar() + ") cannot be modelled because user tasks cannot have integrity property associated.");					
					}
				}
			}
			
			// Set the control
			setControl(topPanel);

			// Set page completion...
			checkCompleteness();
		}
		
		private void checkCompleteness() {
			boolean complete = true;
			for (SecurityCorrection sc : corrections) {
				if (sc instanceof IntegrityCorrection) {
					IntegrityCorrection ic = (IntegrityCorrection) sc;
					if (ic.getTask() instanceof ServiceTask && (ic.getDestinationTask() == null || ic.getType() == null || ic.getType().equals("") || ic.getAlgorithm() == null || ic.getAlgorithm().equals(""))) {
						complete = false;
					}
				}
			}
			setPageComplete(complete);
		}
		
	}
	
	private class ConfigureConfidentialityPage extends WizardPage {
		
		private String[] confAlgorithms = {"low", "medium", "strong"};

		protected ConfigureConfidentialityPage(String pageName) {
			super(pageName);
		}

		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			topPanel.setLayout(layout);
			
			// Set the title & description
			setTitle("Configure Confidentiality Corrections");
			setDescription("Configure how the MTM shall correct the Activiti model with regard to Confidentiality requirements.");

			for (SecurityCorrection sc : corrections) {
				if (sc instanceof ConfidentialityCorrection) {
					ConfidentialityCorrection cc = (ConfidentialityCorrection)sc;
					if(cc.getTask() instanceof ServiceTask){
						Label titleLabel = new Label(topPanel, SWT.NONE);
						GridData titleLabelData = new GridData(GridData.FILL_HORIZONTAL);
						titleLabelData.horizontalSpan = 2;
						titleLabel.setLayoutData(titleLabelData);
						titleLabel.setText("Confidentiality requirement for task " + ((ConfidentialityCorrection)sc).getTask().getName() + 
								" (related to " + ((ConfidentialityCorrection)sc).getType() +" variable " +
								((ConfidentialityCorrection)sc).getVar() + "):");		
						
						Label algLabel = new Label(topPanel, SWT.NONE);
						GridData algLabelData = new GridData(GridData.FILL_HORIZONTAL);
						algLabelData.horizontalSpan = 1;
						algLabel.setLayoutData(algLabelData);
						algLabel.setText("Algorithm:");
						
						ComboViewer destCombo = new ComboViewer(topPanel, SWT.DROP_DOWN);
						GridData destComboData = new GridData(GridData.FILL_HORIZONTAL);
						destComboData.horizontalSpan = 1;
						destCombo.getCombo().setLayoutData(destComboData);						
						destCombo.add(confAlgorithms);
						destCombo.addSelectionChangedListener(new ConfAlgorithmListener(cc));
					}
					else{
						Label titleLabel = new Label(topPanel, SWT.NONE);
						GridData titleLabelData = new GridData(GridData.FILL_HORIZONTAL);
						titleLabelData.horizontalSpan = 2;
						titleLabel.setLayoutData(titleLabelData);
						titleLabel.setText("Confidentiality requirement for user task " + ((ConfidentialityCorrection)sc).getTask().getName() + 
								" (related to variable " + ((ConfidentialityCorrection)sc).getVar() + ") cannot be modelled because user tasks cannot have Confidentiality property associated.");					
					}
					Label separator = new Label(topPanel, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
					GridData sepLabelData = new GridData(GridData.FILL_HORIZONTAL);
					sepLabelData.horizontalSpan = 2;
					separator.setLayoutData(sepLabelData);
				}
			}
			
			// Set the control
			setControl(topPanel);

			// Set page completion...
			checkCompleteness();
		}
		
		private void checkCompleteness() {
			boolean complete = true;
			for (SecurityCorrection sc : corrections) {
				if (sc instanceof ConfidentialityCorrection) {
					ConfidentialityCorrection cc = (ConfidentialityCorrection) sc;
					if (cc.getTask() == null || (cc.getTask() instanceof ServiceTask && (cc.getType() == null || cc.getType().equals("") || cc.getAlgorithm() == null || cc.getAlgorithm().equals("")))) {
						complete = false;
					}
				}
			}
			setPageComplete(complete);
		}
		
	}
	
	private class RoleSelectionListener implements SelectionListener {

		private BodSodCorrection bsc;
		private int index;
		
		public RoleSelectionListener(BodSodCorrection bsc, int index) {
			this.bsc = bsc;
			this.index = index;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			String role = ((Combo)e.widget).getItem(((Combo)e.widget).getSelectionIndex());
			if (index == 1) {
				bsc.setTask1Role(role);
			}
			else {
				bsc.setTask2Role(role);
			}
			((ConfigureBodSodPage)getPage("Configure BoD/SoD Corrections")).checkCompleteness();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
		
	}
	
	private class ActionSelectionListener implements SelectionListener {
		private BodSodCorrection bsc;
		private int index;
		
		public ActionSelectionListener(BodSodCorrection bsc, int index) {
			this.bsc = bsc;
			this.index = index;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			String action = ((Combo)e.widget).getItem(((Combo)e.widget).getSelectionIndex());
			if (index == 1) {
				bsc.setTask1Action(action);
			}
			else {
				bsc.setTask2Action(action);
			}
			((ConfigureBodSodPage)getPage("Configure BoD/SoD Corrections")).checkCompleteness();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	
	}
	
	private class OriginListener implements ISelectionChangedListener {

		IntegrityCorrection ic;
		
		public OriginListener(IntegrityCorrection ic) {
			this.ic = ic;
		}

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			Object sel = ((StructuredSelection)event.getSelection()).getFirstElement();
			if (sel instanceof ServiceTask) {
				ic.setDestinationTask((ServiceTask) sel);
			}
			else {
				ic.setDestinationTask(null);
			}
			((ConfigureIntegrityPage)getPage("Configure Integrity")).checkCompleteness();
		}
		
		
	}
	
	private class TypeModifyListener implements ModifyListener {

		IntegrityCorrection ic;
		
		public TypeModifyListener(IntegrityCorrection ic) {
			this.ic = ic;
		}
		
		@Override
		public void modifyText(ModifyEvent e) {
			String type = ((Text)e.widget).getText();
			ic.setType(type);
			((ConfigureIntegrityPage)getPage("Configure Integrity")).checkCompleteness();
		}
		
	}
	
	private class AlgorithmModifyListener implements ModifyListener {

		IntegrityCorrection ic;
		
		public AlgorithmModifyListener(IntegrityCorrection ic) {
			this.ic = ic;
		}
		
		@Override
		public void modifyText(ModifyEvent e) {
			String algorithm = ((Text)e.widget).getText();
			ic.setAlgorithm(algorithm);
			((ConfigureIntegrityPage)getPage("Configure Integrity")).checkCompleteness();
		}
		
	}
	
	
	private class ConfAlgorithmListener implements ISelectionChangedListener {

		ConfidentialityCorrection cc;
		
		public ConfAlgorithmListener(ConfidentialityCorrection cc) {
			this.cc = cc;
		}

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			Object sel = ((StructuredSelection)event.getSelection()).getFirstElement();
			if (sel instanceof String) {
				cc.setAlgorithm((String) sel);
			}
			
			((ConfigureConfidentialityPage)getPage("Configure Confidentiality")).checkCompleteness();
		}		
	}	
	

}
