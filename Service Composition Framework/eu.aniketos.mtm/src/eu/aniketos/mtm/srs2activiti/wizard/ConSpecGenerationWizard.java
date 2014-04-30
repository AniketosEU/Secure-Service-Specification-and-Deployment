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

import org.eclipse.aniketos.Integrity;
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
import eu.aniketos.mtm.consumerpolicies.consumerpolicies.Policy;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.PreType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.utils.ModelingUtils;

/**
 * MTM Consumer Policy Generator wizard, which generates conspec format consumer policies 
 * from the high-level security requirements defined in the SRS.
 * 
 * @author Tecnalia
 *
 */
public class ConSpecGenerationWizard extends Wizard {	
	
	private static final String[] FILTERS_SRS = {"*.xml", "*.srs"};
	private static final String[] FILTERS_ACTIVITI = {"*.activiti"};
	private static final String[] FILTERS_MAPPING = {"*.mapping"};
	private final String MOFSCRIPT_NAME = "MOFScript";
	
	// Information to be filled
	private String srsModelPath = null;
	private SecReqSpeType srsModel = null;
	private String mappingModelPath = null;
	private MappingType mappingModel = null;
	private String activitiModelPath = null;
	private Resource activitiModel = null; // Stored as EMF Resource as there is no root element
	private String outputDir = "";
	private ArrayList<CommitmentWrapper> transformationList = new ArrayList<CommitmentWrapper>();
	
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
		int indexTrust = 1;
		int indexIntegrity = 1;
		int indexConfidentiality = 1;
		int indexBoD = 1;
		int indexSoD = 1;
		int indexNoDel = 1;
		int indexNoRep = 1;
		
		// Transform each commitment to a individual ConSpec file
		ModelingUtils utils = ModelingUtils.configure(srsModel, mappingModel, activitiModel);
		for (CommitmentWrapper c : transformationList) {
			
			// Create the Policy model
			Policy p = utils.getPolicyFromCommitment(c);
			if (p == null) {
				MessageDialog.openError(getShell(), "Cannot Transform", "Commitment \"" + c.getCommitment().getId() + "\" couldn't be trasnformed into a valid consumer policy.\nPlease check its correctness.");
//				return false;
			}
			else{
				String transformationName = utils.getTransformationFromCommitment(c.getCommitment());
				if (transformationName == null) {
					MessageDialog.openError(getShell(), "Cannot Transform", "Commitment \"" + c.getCommitment().getId() + "\" is not transformable.");
//					return false;
				}
				else{
					if(transformationName.equals(ModelingUtils.POLICY_TRUSTWORTHINESS)){
						p.setID(""+indexTrust++);
					}
					else if(transformationName.equals(ModelingUtils.POLICY_BoD)){
						p.setID(""+indexBoD++);
					}
					else if(transformationName.equals(ModelingUtils.POLICY_SoD)){
						p.setID(""+indexSoD++);				
					}
					else if(transformationName.equals(ModelingUtils.POLICY_CONFIDENTIALITY)){
						p.setID(""+indexConfidentiality++);
					}
					else if(transformationName.equals(ModelingUtils.POLICY_INTEGRITY)){
						p.setID(""+indexIntegrity++);
					}
					else if(transformationName.equals(ModelingUtils.POLICY_NO_DELEGATION)){
						p.setID(""+indexNoDel++);
					}
					else if(transformationName.equals(ModelingUtils.POLICY_NO_REPUDIATION)){
						p.setID(""+indexNoRep++);
					}
					
					// Generate Conspec file
					Vector<EObject> inputs = new Vector<EObject>();
					inputs.add(p);
					try {
						ModelTransformatorPlugin.getService().executeTransformation(inputs, transformationName, MOFSCRIPT_NAME, outputDir);
					} catch (Exception e) {
						MessageDialog.openError(getShell(), "Generation Error", "Transformation Engine raised an exception:\n" + e.getMessage());
						e.printStackTrace();
//						return false;
					}
				}				
			}			
			
		}
		
		return true;
	}
	
	private class SelectModelsPageWizardPage extends WizardPage {

		private Text elem1;
		private Button elem2;
		private Text elem4;
		private Button elem5;
		private Text elem7;
		private Button elem8;
		
		public SelectModelsPageWizardPage(String pageName) {
			super(pageName);
		}
		
		private void checkPageCompleted() {
			boolean isCompleted = srsModel != null && mappingModel != null && activitiModel != null;
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
		
		private boolean loadMapping() {
			mappingModel = null;
			if (mappingModelPath == null || mappingModelPath.equals("")) {
				return false;
			}
			
			try {
				Resource r = rs.getResource(URI.createFileURI(mappingModelPath), true);
				if (r == null) {
					return false;
				}
				TreeIterator<EObject> i = r.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof MappingType) {
						mappingModel = (MappingType) o;
					}
				}
			}
			catch (Exception e) {
				return false;
			}
			
			return (mappingModel != null);
		}
		
		private boolean loadSRS() {
			srsModel = null;
			if (srsModelPath == null || srsModelPath.equals("")) {
				return false;
			}
			try {
				Resource r = rs.getResource(URI.createFileURI(srsModelPath), true);
				if (r == null) {
					return false;
				}
				TreeIterator<EObject> i = r.getAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof SecReqSpeType) {
						srsModel = (SecReqSpeType) o;
					}
				}
			}
			catch (Exception e) {
				return false;
			}
			
			return (srsModel != null);
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


			Label elem0 = new Label(topPanel, SWT.NONE);
			GridData elem0Data = new GridData(GridData.FILL_HORIZONTAL);
			elem0Data.horizontalSpan = 1;
			elem0.setText("SRS Model:");
			elem0.setLayoutData(elem0Data);

			elem1 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem1Data = new GridData(GridData.FILL_HORIZONTAL);
			elem1Data.horizontalSpan = 4;
			elem1.setText("");
			elem1.setLayoutData(elem1Data);
			elem1.setEnabled(false);

			elem2 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem2Data = new GridData(GridData.FILL_HORIZONTAL);
			elem2Data.horizontalSpan = 1;
			elem2.setText("Browse...");
			elem2.setLayoutData(elem2Data);
			elem2.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
					fd.setFilterExtensions(FILTERS_SRS);
					String file = fd.open();
					if (file != null) {
						srsModelPath = file;
						if (loadSRS()) {
							elem1.setText(file);
						}
						else {
							srsModelPath = null;
							elem1.setText("");
							MessageDialog.openError(getShell(), "Invalid SRS file", "The provided SRS file couldn't be loaded. Please select a valid SRS model.");
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});

			Label elem3 = new Label(topPanel, SWT.NONE);
			GridData elem3Data = new GridData(GridData.FILL_HORIZONTAL);
			elem3Data.horizontalSpan = 1;
			elem3.setText("Mapping Model:");
			elem3.setLayoutData(elem3Data);

			elem4 = new Text(topPanel, SWT.BORDER | SWT.LEFT);
			GridData elem4Data = new GridData(GridData.FILL_HORIZONTAL);
			elem4Data.horizontalSpan = 4;
			elem4.setText("");
			elem4.setLayoutData(elem4Data);
			elem4.setEnabled(false);


			elem5 = new Button(topPanel, SWT.PUSH | SWT.CENTER);
			GridData elem5Data = new GridData(GridData.FILL_HORIZONTAL);
			elem5Data.horizontalSpan = 1;
			elem5.setText("Browse...");
			elem5.setLayoutData(elem5Data);
			elem5.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
					fd.setFilterExtensions(FILTERS_MAPPING);
					String file = fd.open();
					if (file != null) {
						mappingModelPath = file;
						if (loadMapping()) {
							elem4.setText(file);
						}
						else {
							mappingModelPath = null;
							elem4.setText("");
							MessageDialog.openError(getShell(), "Invalid mapping file", "The provided mapping file couldn't be loaded. Please select a valid mapping model.");
						}
					}
					checkPageCompleted();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
			
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
			setDescription("Select the SRS, Mapping and Activiti models that will be used to generate the Consumer Policy files");
			
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
			transformationList.clear();
			boolean isCompleted = elem3.getList().getItemCount() > 0 && f != null && f.exists() && f.isDirectory() && f.canWrite();
			
			if (isCompleted) {
				for (int i = 0; i < elem3.getList().getItemCount(); i++) {
					Object o = elem3.getElementAt(i);
					if (o instanceof CommitmentWrapper) {
						transformationList.add((CommitmentWrapper) o);
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
			elem2.setLabelProvider(new CommitmentLabelProvider());
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
			elem3.setLabelProvider(new CommitmentLabelProvider());
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
			elem5.setText(outputDir);
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
			ModelingUtils mu = ModelingUtils.configure(srsModel, mappingModel, activitiModel);
			
			elem5.setText(outputDir);
			
			elem2.getList().removeAll();
			elem3.getList().removeAll();
			
			Vector<String> trustAddedTasks = new Vector<String>();
			
			if (srsModel != null && mappingModel != null && activitiModel != null) {
				for (CommitmentType c : srsModel.getCommitment()) {
					PreType pre = c.getPrecondition();
					PostType post = c.getPostcondition();
					boolean canTransform = false;
					
					if (pre != null) {
						if (pre.getTrustworthiness() != null) {
							// check that the sec reqs are also in the activiti model: set the value from the activiti model
							Task t = mu.getTaskFromGoal(pre.getTrustworthiness().getGoal());
							if(t instanceof ServiceTask && ((ServiceTask)t).getSecurityExtensions() != null && ((ServiceTask)t).getSecurityExtensions().getTrustworthinessValue() != null
									&& ((ServiceTask)t).getSecurityExtensions().getTrustworthinessValue().getValue() != null){
								if(!trustAddedTasks.contains(t.getId())){
									c.getPrecondition().getTrustworthiness().setMinLevel(((ServiceTask)t).getSecurityExtensions().getTrustworthinessValue().getValue());
									canTransform = true;
									trustAddedTasks.add(t.getId());
								}								
							}							
						}
					}
					
					if (post != null) {
						if (post.getAchieveInCombination() != null || 
//							post.getAvailability() != null ||  
							post.getNotAchieveInCombination() != null || 
//							post.getNotPlayBoth() != null || 
//							post.getPlayBoth() != null || 
//							post.getRedundancy() != null ||
							post.getNonDelegation() != null || 
							post.getNonRepudiation() != null) {
							canTransform = true;
						}
					}
					
					if (canTransform) {
						elem2.add(new CommitmentWrapper(c));
					}
					
					// Process Integrity and Confidentiality separately 
					ModelingUtils utils = ModelingUtils.configure(srsModel, mappingModel, activitiModel);
					if(post != null){
						if(post.getIntegrity() != null){
							ArrayList<FieldExtension> fes = utils.getVariableFromDocument(post.getIntegrity().getDocument());
							for (FieldExtension fe : fes) {
								try {
									ArrayList<ServiceTask> origins = utils.getTasksWithIntegrity();
									for (ServiceTask orig : origins) {
										if(orig.getFieldExtensions().contains(fe)){
											Task target = utils.getTaskByID(orig.getSecurityExtensions().getIntegrityReq().get(0).getWith());
											if (target != null && target instanceof ServiceTask) {
												elem2.add(new CommitmentWrapper(c, orig, fe));
											}
										}										
									}
								}
								catch (NullPointerException e) {
									// Just in case the model is not correct
									e.printStackTrace();
								}
							}
						}
						if(post.getConfidentiality() != null){
							ArrayList<FieldExtension> fes = utils.getVariableFromDocument(post.getConfidentiality().getDocument());
							for (FieldExtension fe : fes) {
								ArrayList<ServiceTask> tasks = utils.getTasksWithConfidentiality();
								for (ServiceTask st : tasks) {
									if(st.getFieldExtensions().contains(fe)){
										if(st.getSecurityExtensions() != null && st.getSecurityExtensions().getConfidentialityReq() != null &&
												st.getSecurityExtensions().getConfidentialityReq().size() > 0){
											elem2.add(new CommitmentWrapper(c, st, fe));								
										}
									}
								}								
							}
						}
					}
				}
			}
		}
	}
	
	private class CommitmentLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return null;
		}
		
		public String getText(Object element) {
			if (element instanceof CommitmentWrapper) {
				return getTextRepresentation((CommitmentWrapper) element);
			}
			else {
				return "Unsupported object";
			}
		}

		private String getTextRepresentation(CommitmentWrapper cw) {
			String ret = new String();
			CommitmentType c = cw.getCommitment();
			PreType pre = c.getPrecondition();
			PostType post = c.getPostcondition();
			ModelingUtils utils = ModelingUtils.configure(srsModel, mappingModel, activitiModel);
			
			ret += "[" + c.getId() + "]:";
			
			if (pre != null) {
				if (pre.getTrustworthiness() != null) {
					ret += "TRUST: ";
					Task bpmnTask = utils.getTaskFromGoal(pre.getTrustworthiness().getGoal());
					
					if (bpmnTask != null) {
						ret += bpmnTask.getName();
					}
					else {
						ret += "(Goal*) " + pre.getTrustworthiness().getGoal().getValue();
					}
					
					ret += ", Min Lvl. = " + pre.getTrustworthiness().getMinLevel();
					
					return ret;
				}
			}
			
			if (post != null) {
				if (post.getAchieveInCombination() != null) {
					ret += "BoD: ";
					boolean first = true;
					
					for (GoalType goal : post.getAchieveInCombination().getGoalSet().getGoal()) {
						if (first) {
							first = false;
						}
						else {
							ret += " == ";
						}
						Task bpmnTask = utils.getTaskFromGoal(goal);
						if (bpmnTask != null) {
							ret += bpmnTask.getName();
						}
						else {
							ret += "(Goal*) " + goal.getValue();
						}
					}
					
					return ret;
				}
//				else if(post.getAvailability() != null) {
//					 return "A" + post.getAvailability().getMinLevel();
//				}
				else if (post.getIntegrity() != null) {
					ret += "INTEG: ";
					
					FieldExtension fe = cw.getVar();
					ServiceTask st = cw.getServiceTask();
					Integrity integrity = utils.getIntegrity(st, fe);
					ServiceTask target = (ServiceTask) utils.getTaskByID(integrity.getWith());
					boolean first = true;
					if (target != null && target instanceof ServiceTask) {
						if (first) {
							first = false;
						}
						else {
							ret += ", ";
						}
						ret += st.getName() + " -> " + target.getName() + "(" + utils.getMappedVar(fe, post.getIntegrity().getDocument()) + ":"+ integrity.getAlgorithm() +")";
					}
					
					return ret;
				}
				else if (post.getNotAchieveInCombination() != null) {
					ret += "SoD: ";
					boolean first = true;
					
					for (GoalType goal : post.getNotAchieveInCombination().getGoalSet().getGoal()) {
						if (first) {
							first = false;
						}
						else {
							ret += " != ";
						}
						Task bpmnTask = utils.getTaskFromGoal(goal);
						if (bpmnTask != null) {
							ret += bpmnTask.getName();
						}
						else {
							ret += "(Goal*) " + goal.getValue();
						}
					}
					return ret;
				}
//				else if (post.getNotPlayBoth() != null) {
//					ret = "SoD[";
//					boolean first = true;
//					
//					for (RoleType r : post.getNotPlayBoth().getActorSet().getRole()) {
//						if (first) {
//							first = false;
//						}
//						else {
//							ret += ",";
//						}
//						ret += r.getValue();
//					}
//					
//					ret += "]";
//					
//					return ret;
//				}
//				else if (post.getPlayBoth() != null) {
//					ret = "BoD[";
//					boolean first = true;
//					
//					for (RoleType r : post.getNotPlayBoth().getActorSet().getRole()) {
//						if (first) {
//							first = false;
//						}
//						else {
//							ret += ",";
//						}
//						ret += r.getValue();
//					}
//					
//					ret += "]";
//					
//					return ret;
//				}
//				else if (post.getRedundancy() != null) {
//					return "R" + post.getRedundancy().getMultiplicity().getValue();
//				}
				else if (post.getNonDelegation() != null) {
					ret += "NO DEL: ";
					boolean first = true;
					
					for (GoalType goal : post.getNonDelegation().getGoalSet().getGoal()) {
						if (first) {
							first = false;
						}
						else {
							ret += ", ";
						}
						Task bpmnTask = utils.getTaskFromGoal(goal);
						if (bpmnTask != null) {
							ret += bpmnTask.getName();
						}
						else {
							ret += "(Goal*) " + goal.getValue();
						}
					}
					
					return ret;
				}
				else if (post.getNonRepudiation() != null) {
					ret += "NO REP: ";
					boolean first = true;
					
					for (GoalType goal : post.getNonRepudiation().getGoalSet().getGoal()) {
						if (first) {
							first = false;
						}
						else {
							ret += ", ";
						}
						Task bpmnTask = utils.getTaskFromGoal(goal);
						if (bpmnTask != null) {
							ret += bpmnTask.getName();
						}
						else {
							ret += "(Goal*) " + goal.getValue();
						}
					}
					
					return ret;
				}
				else if (post.getConfidentiality() != null) {
					ret += "CONF: ";
			
					FieldExtension fe = cw.getVar();
					ServiceTask st = cw.getServiceTask();					
					
					ret += st.getName() + "->";
					
					String input = null;
					String output = null;
					for (org.eclipse.aniketos.Confidentiality confidentiality : st.getSecurityExtensions().getConfidentialityReq()) {
						if(confidentiality.getType().equals(fe.getFieldname()) && confidentiality.getType().equals("input")){
							input = confidentiality.getAlgorithm();
						}
						else if (confidentiality.getType().equals("output") && fe.getFieldname().equals("resultVariable")){
							output = confidentiality.getAlgorithm();
						}
					}
					if(input != null){
						ret += "Input " + input;
					}
					if(output != null){
						if(input != null){
							ret += " / ";
						}
						ret += "Output " + output;
					}	
					
					return ret;
				}

			}
			
			return "";
		}
	}
	
	public class CommitmentWrapper{
		
		private CommitmentType commitment;
		private ServiceTask serviceTask;
		private FieldExtension var;
		
		public CommitmentWrapper(CommitmentType commitment) {
			this.commitment = commitment;
		}

		public CommitmentWrapper(CommitmentType commitment, ServiceTask serviceTask, FieldExtension var) {
			super();
			this.commitment = commitment;
			this.serviceTask = serviceTask;
			this.var = var;
		}

		public CommitmentType getCommitment() {
			return commitment;
		}

		public ServiceTask getServiceTask() {
			return serviceTask;
		}

		public FieldExtension getVar() {
			return var;
		}
		
	}

}
