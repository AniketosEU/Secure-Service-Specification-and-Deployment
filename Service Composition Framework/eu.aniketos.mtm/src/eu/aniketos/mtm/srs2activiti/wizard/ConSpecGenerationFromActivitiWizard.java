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

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.aniketos.Confidentiality;
import org.eclipse.aniketos.Integrity;
import org.eclipse.aniketos.Trustworthiness;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.Task;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.securebpmn2.BindingOfDuty;
import org.eclipse.securebpmn2.SeparationOfDuty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import es.esi.gemde.modeltransformator.ModelTransformatorPlugin;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.ConsumerpoliciesFactory;
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.utils.ModelingUtils;

/**
 * MTM Consumer Policy Generator wizard, which generates conspec format consumer policies 
 * from the security requirements defined in the Activiti BPMN file.
 * 
 * @author Tecnalia
 *
 */
public class ConSpecGenerationFromActivitiWizard extends Wizard {	
	
	private static final String[] FILTERS_ACTIVITI = {"*.activiti"};
	private final String MOFSCRIPT_NAME = "MOFScript";
	
	// Information to be filled
	private String activitiModelPath = null;
	private Resource activitiModel = null; // Stored as EMF Resource as there is no root element
	private String outputDir = "";
	private ArrayList<Policy> policyList = new ArrayList<Policy>();
	
	// Resource Set for handling models
	private ResourceSet rs = new ResourceSetImpl();

	@Override
	public void addPages() {
		super.addPages();
		addPage(new SelectModelsPageWizardPage("SelectModelsPage"));
		addPage(new SelectCommitmentsPageWizardPage("SelectCommitmentsPage"));
	}

	@Override
	public boolean performFinish() {
		ModelingUtils utils = ModelingUtils.configure(null, null, activitiModel);
		// Generate a individual ConSpec file for each policy		
		for (Policy p : policyList) {			
			String transformationName = utils.getTransformationFromPolicy(p);
			if (transformationName == null) {
				MessageDialog.openError(getShell(), "Cannot create the consumer policy", "The consumer policy" + p.getID() + " cannot be created.");
				return false;
			}
			
			// Generate Conspec file
			Vector<EObject> inputs = new Vector<EObject>();
			inputs.add(p);
			try {
				ModelTransformatorPlugin.getService().executeTransformation(inputs, transformationName, MOFSCRIPT_NAME, outputDir);
			} catch (Exception e) {
				MessageDialog.openError(getShell(), "Generation Error", "Transformation Engine raised an exception:\n" + e.getMessage());
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	private class SelectModelsPageWizardPage extends WizardPage {
		private Text elem7;
		private Button elem8;
		
		public SelectModelsPageWizardPage(String pageName) {
			super(pageName);
		}
		
		private void checkPageCompleted() {
			boolean isCompleted = activitiModel != null;
			if (isCompleted) {
				URI parentURI = activitiModel.getURI().trimSegments(1);
				parentURI = parentURI.appendSegment("ConsumerPolicies");
				outputDir = parentURI.toFileString();
				((SelectCommitmentsPageWizardPage)getPage("SelectCommitmentsPage")).refreshLists();
			}
			setPageComplete(isCompleted);
		}
		
		private boolean loadActiviti() {
			activitiModel = null;
			if (activitiModelPath == null || activitiModelPath.equals("")) {
				return false;
			}
			
			try {
				activitiModel = rs.getResource(URI.createFileURI(activitiModelPath), true);
				if (activitiModel == null) {
					return false;
				}
				TreeIterator<EObject> i = activitiModel.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof ServiceTask || o instanceof UserTask || o instanceof FieldExtension) {
						return true;
					}
				}
			}
			catch (Exception e) {
				return false;
			}
			
			return false;
		}

		/* 
		 * createControl() method
		 * (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(6, true);
			topPanel.setLayout(layout);
			
			Label elem6 = new Label(topPanel, SWT.NONE);
			GridData elem6Data = new GridData(GridData.FILL_HORIZONTAL);
			elem6Data.horizontalSpan = 1;
			elem6.setText("Activiti Model:");
			elem6.setLayoutData(elem6Data);

			elem7 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem7Data = new GridData(GridData.FILL_HORIZONTAL);
			elem7Data.horizontalSpan = 4;
			elem7.setText("");
			elem7.setLayoutData(elem7Data);
			elem7.setEnabled(false);

			elem8 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem8Data = new GridData(GridData.FILL_HORIZONTAL);
			elem8Data.horizontalSpan = 1;
			elem8.setText("Browse...");
			elem8.setLayoutData(elem8Data);
			elem8.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
					fd.setFilterExtensions(FILTERS_ACTIVITI);
					String file = fd.open();
					if (file != null) {
						activitiModelPath = file;
						if (loadActiviti()) {
							elem7.setText(file);
						}
						else {
							activitiModelPath = null;
							elem7.setText("");
							MessageDialog.openError(getShell(), "Invalid activiti file", "The provided activiti file couldn't be loaded. Please select a valid activiti model.");
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});

			// Set the title & description
			setTitle("Select input models");
			setDescription("Please select the Activiti model that will be used to generate the Consumer Policy files.");
			
			// Set the control
			setControl(topPanel);
			
			// Set page completion...
			setPageComplete(false);
		}
	}
	
	private class SelectCommitmentsPageWizardPage extends WizardPage {

		private Label elem0;
		private Label elem1;
		private ListViewer elem2;
		private ListViewer elem3;
		private Label elem4;
		private Text elem5;
		private Button elem6;
		private Button toRightButton;
		private Button toLeftButton;
		
		public SelectCommitmentsPageWizardPage(String pageName) {
			super(pageName);
		}
		
		
		public void checkPageCompleted() {
			File f = null;
			if (outputDir != null) {
				f = new File(outputDir);
				if(!f.exists()){
					boolean result = f.mkdir();
					if(result){
						System.out.println("ConsumerPolicies folder created");
					}
				}
			}
			policyList.clear();
			boolean isCompleted = elem3.getList().getItemCount() > 0 && f != null && f.exists() && f.isDirectory() && f.canWrite();
			if (isCompleted) {
				for (int i = 0; i < elem3.getList().getItemCount(); i++) {
					Object o = elem3.getElementAt(i);
					if (o instanceof Policy) {
						policyList.add((Policy) o);
					}
				}
			}
			setPageComplete(isCompleted);
		}

		/* 
		 * createControl() method
		 * (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		public void createControl(Composite parent) {
			Composite topPanel = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(5, true);
			topPanel.setLayout(layout);


			elem0 = new Label(topPanel, SWT.NONE);
			GridData elem0Data = new GridData(GridData.FILL_HORIZONTAL);
			elem0Data.horizontalSpan = 3;
			elem0.setText("Available Commitments List:");
			elem0.setLayoutData(elem0Data);

			elem1 = new Label(topPanel, SWT.NONE);
			GridData elem1Data = new GridData(GridData.FILL_HORIZONTAL);
			elem1Data.horizontalSpan = 2;
			elem1.setText("Consumer Policies to be generated:");
			elem1.setLayoutData(elem1Data);

			elem2 = new ListViewer(topPanel, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
			GridData elem2Data = new GridData(GridData.FILL_BOTH);
			elem2Data.horizontalSpan = 2;
			elem2Data.verticalSpan = 4;
			elem2.getList().setLayoutData(elem2Data);
			elem2.setLabelProvider(new PolicyLabelProvider());
			elem2.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					toRightButton.setEnabled(((StructuredSelection)elem2.getSelection()).size() > 0);
				}
			});
			
			
			Composite buttonRack = new Composite(topPanel, SWT.NONE);
			GridData buttonRackData = new GridData(GridData.FILL_BOTH);
			buttonRackData.horizontalSpan = 1;
			buttonRackData.verticalSpan = 4;
			buttonRack.setLayoutData(buttonRackData);
			
			GridLayout rackLayout = new GridLayout(1, true);
			buttonRack.setLayout(rackLayout);
			
			Label empty1 = new Label(buttonRack, SWT.NONE);
			GridData empty1Data = new GridData(GridData.FILL_BOTH);
			empty1Data.horizontalSpan = 1;
			empty1.setLayoutData(empty1Data);
			
			toRightButton = new Button(buttonRack, SWT.PUSH | SWT.CENTER);
			GridData toRightButtonData = new GridData(GridData.FILL_HORIZONTAL);
			toRightButtonData.horizontalSpan = 1;
			toRightButton.setText(">>");
			toRightButton.setEnabled(false);
			toRightButton.setLayoutData(toRightButtonData);
			toRightButton.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (((StructuredSelection)elem2.getSelection()).size() > 0) {
						ArrayList<Object> selected = new ArrayList<Object>();
						for (Object o : ((StructuredSelection)elem2.getSelection()).toArray()) {
							selected.add(o);
						}
						
						// Perform move
						elem2.remove(selected.toArray());
						elem3.add(selected.toArray());
						toRightButton.setEnabled(false);
						checkPageCompleted();
					}
					else {
						MessageDialog.openError(getShell(), "No items selected", "Cannot switch elements. No elements are selected.");
					}
				}
				
			});
			
			toLeftButton = new Button(buttonRack, SWT.PUSH | SWT.CENTER);
			GridData toLeftButtonData = new GridData(GridData.FILL_HORIZONTAL);
			toLeftButtonData.horizontalSpan = 1;
			toLeftButton.setText("<<");
			toLeftButton.setEnabled(false);
			toLeftButton.setLayoutData(toLeftButtonData);
			toLeftButton.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (((StructuredSelection)elem3.getSelection()).size() > 0) {
						ArrayList<Object> selected = new ArrayList<Object>();
						for (Object o : ((StructuredSelection)elem3.getSelection()).toArray()) {
							selected.add(o);
						}
						
						// Perform move
						elem3.remove(selected.toArray());
						elem2.add(selected.toArray());
						toLeftButton.setEnabled(false);
						checkPageCompleted();
					}
					else {
						MessageDialog.openError(getShell(), "No items selected", "Cannot switch elements. No elements are selected.");
					}
				}
				
			});
			
			
			Label empty2 = new Label(buttonRack, SWT.NONE);
			GridData empty2Data = new GridData(GridData.FILL_BOTH);
			empty2Data.horizontalSpan = 1;
			empty2.setLayoutData(empty2Data);
			

			elem3 = new ListViewer(topPanel, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
			GridData elem3Data = new GridData(GridData.FILL_BOTH);
			elem3Data.horizontalSpan = 2;
			elem3Data.verticalSpan = 4;
			elem3.getList().setLayoutData(elem3Data);
			elem3.setLabelProvider(new PolicyLabelProvider());
			elem3.addSelectionChangedListener(new ISelectionChangedListener() {
				
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					toLeftButton.setEnabled(((StructuredSelection)elem3.getSelection()).size() > 0);
				}
			});
			
			
			elem4 = new Label(topPanel, SWT.NONE);
			GridData elem4Data = new GridData(GridData.FILL_HORIZONTAL);
			elem4Data.horizontalSpan = 1;
			elem4.setText("Output Path:");
			elem4.setLayoutData(elem4Data);

			elem5 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem5Data = new GridData(GridData.FILL_HORIZONTAL);
			elem5Data.horizontalSpan = 3;
			elem5.setText("");
			elem5.setLayoutData(elem5Data);
			elem5.setEditable(false);
			

			elem6 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem6Data = new GridData(GridData.FILL_HORIZONTAL);
			elem6Data.horizontalSpan = 1;
			elem6.setText("Browse...");
			elem6.setLayoutData(elem6Data);
			elem6.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					DirectoryDialog dd = new DirectoryDialog(getShell());
					String dir = dd.open();
					if (dir != null) {
						File f = new File(dir);
						if (f.exists() && f.isDirectory() && f.canWrite()) {
							outputDir = dir;
							elem5.setText(outputDir);
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});

			// Set the title & description
			setTitle("Select the SRS Commitments to be transformed");
			setDescription("Select the SRS commitments that will be converted to Consumer Policy files (ConSpec format).\nSelect also the output path.");
			
			// Set the control
			setControl(topPanel);
			
			// Set page completion...
			setPageComplete(false);
		}
		
		
		public void refreshLists() {
					
			ModelingUtils utils = ModelingUtils.configure(null, null, activitiModel);
			
			elem5.setText(outputDir);
			
			elem2.getList().removeAll();
			elem3.getList().removeAll();
			
			int indexTrust = 1;
			int indexIntegrity = 1;
			int indexConfidentiality = 1;
			int indexBoD = 1;
			int indexSoD = 1;
			
			if (activitiModel != null) {
				TreeIterator<EObject> i = activitiModel.getAllContents();
				
				while (i.hasNext()) {
					EObject o = i.next();
					// Trustworthiness & Integrity & Confidentiality
					if (o instanceof ServiceTask) {
						ServiceTask st = (ServiceTask) o;
						if(st.getSecurityExtensions() != null){
							// Trustworthiness
							if(st.getSecurityExtensions().getTrustworthinessValue() != null){
								Trustworthiness tr = st.getSecurityExtensions().getTrustworthinessValue();
								eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness t = ConsumerpoliciesFactory.eINSTANCE.createTrustworthiness();
								t.setID(""+indexTrust++);
								t.setGuardedTask(st.getId());
								t.setMinLevel(Float.parseFloat(tr.getValue()));
								elem2.add(t);
							}
							// Integrity
							if(st.getSecurityExtensions().getIntegrityReq() != null){
								for (Integrity in : st.getSecurityExtensions().getIntegrityReq()) {
									eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity integrity = ConsumerpoliciesFactory.eINSTANCE.createIntegrity();
									integrity.setID(""+indexIntegrity++);
									integrity.setGeneratingService(st.getId());
									String targetTask = (in.getWith().split("-")[0]).replaceAll(" ", "");
									integrity.setProcessingService(utils.getTaskByID(targetTask).getId());
									integrity.setAlgorithm(in.getAlgorithm());
									FieldExtension role = utils.getRoleForTask(st);
									if (role != null) {
										integrity.setGuardedSender(role.getExpression());
									}
									elem2.add(integrity);
								}								
							}
							
							// Confidentiality
							if(st.getSecurityExtensions().getConfidentialityReq() != null){
								for (Confidentiality c : st.getSecurityExtensions().getConfidentialityReq()) {
									eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality conf = ConsumerpoliciesFactory.eINSTANCE.createConfidentiality();
									conf.setID(""+indexConfidentiality++);
									conf.setGuardedTask(st.getId());
									if(c.getType().equals("input")){
										conf.setInputSuite(c.getAlgorithm());
									}
									else if (c.getType().equals("output")){
										conf.setOutputSuite(c.getAlgorithm());
									}
									elem2.add(conf);
								}
							}							
						}
					}
					// BoD
					if(o instanceof BindingOfDuty){
						BindingOfDuty b = (BindingOfDuty) o;
												
						eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty bod = ConsumerpoliciesFactory.eINSTANCE.createBindingOfDuty();
						bod.setID(""+indexBoD++);
						
						Vector<Task> tasks = utils.getTaskRelatedToAuthorizationConstraint(b.getId());
						for (Task task : tasks) {
							bod.getGuardedTasks().add(task.getId());
						}
						elem2.add(bod);
					}
				
					// SoD
					if(o instanceof SeparationOfDuty){
						SeparationOfDuty s = (SeparationOfDuty) o;
												
						eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty sod = ConsumerpoliciesFactory.eINSTANCE.createSeparationOfDuty();
						sod.setID(""+indexSoD++);
						
						Vector<Task> tasks = utils.getTaskRelatedToAuthorizationConstraint(s.getId());
						for (Task task : tasks) {
							sod.getGuardedTasks().add(task.getId());
						}
						elem2.add(sod);
					}
				}
				
			}
		}
	}
	
	private class PolicyLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return null;
		}
		
		public String getText(Object element) {
			if (element instanceof Policy) {
				return getTextRepresentation((Policy) element);
			}
			else {
				return "Unsupported object";
			}
		}

		private String getTextRepresentation(Policy policy) {
			String ret = new String();
			
			if(policy instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness t = (eu.aniketos.mtm.consumerpolicies.consumerpolicies.Trustworthiness) policy;
				ret += "TRUST: ";
				ret += t.getGuardedTask();				
				ret += ", Min Lvl. = " + t.getMinLevel().toString();
				
				return ret;
			}
			else if(policy instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity i = (eu.aniketos.mtm.consumerpolicies.consumerpolicies.Integrity) policy;
				
				ret += "INTEG: ";
				ret += i.getGeneratingService() + " -> " + i.getProcessingService() + "(" + i.getAlgorithm() +")";
						
				return ret;
			}			
			else if(policy instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality c = (eu.aniketos.mtm.consumerpolicies.consumerpolicies.Confidentiality) policy;
				
				ret += "CONF: ";				
				ret += c.getGuardedTask() + "->";
				if(c.getInputSuite() != null){
					ret += "Input " + c.getInputSuite();
				}
				if(c.getOutputSuite() != null){
					if(c.getInputSuite() != null){
						ret += " / ";
					}
					ret += "Output " + c.getOutputSuite();
				}
				
				return ret;
			}			
			else if(policy instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty bod = (eu.aniketos.mtm.consumerpolicies.consumerpolicies.BindingOfDuty) policy;
				ret += "BoD: ";
				
				boolean first = true;
				
				for (String t : bod.getGuardedTasks()) {
					if (first) {
						first = false;
					}
					else {
						ret += " == ";
					}
		
					ret += t;
				}
				
				return ret;
			}			
			else if(policy instanceof eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty){
				eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty sod = (eu.aniketos.mtm.consumerpolicies.consumerpolicies.SeparationOfDuty) policy;
				ret += "SoD: ";
				
				boolean first = true;
				
				for (String t : sod.getGuardedTasks()) {
					if (first) {
						first = false;
					}
					else {
						ret += " != ";
					}
		
					ret += t;
				}
				
				return ret;
			}
			
			return "";
		}
	}


}
