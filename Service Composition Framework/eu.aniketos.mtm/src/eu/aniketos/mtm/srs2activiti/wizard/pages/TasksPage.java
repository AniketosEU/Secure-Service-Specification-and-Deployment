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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.ActivityVar;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.ConfidentialityType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingFactory;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.ParticipantType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.RelatesToType;
import eu.aniketos.mtm.mapping.RepresentsType;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.mapping.TypeType2;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.mapping.VarType;
import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.TrustworthinessType;
import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;

/**
 * 
 * Page used to establish the correspondences between SRS goals and BPMN tasks
 * (n:1 relationship).
 * 
 * 
 * @author Eider Iturbe <eider.iturbe@tecnalia.com>
 * 
 */
public class TasksPage extends CustomPage {

	private static final String PREFIX = "task_";

	private static final String TABITEM_TITLE_MAIN_FEATURES = "Main features";
	private static final String TABITEM_TITLE_SEC_REQ = "Security requirements";
	
	private static final String SERVICE_TASK_TYPE = "serviceTask";
	private static final String USER_TASK_TYPE = "userTask";
	
	private static final String VBLE_TYPE_INPUT = "Input";
	private static final String VBLE_TYPE_OUTPUT = "Output";
	
	private static final String WIDGET_DATA_VARIABLE = "variable";
	private static final String WIDGET_DATA_PERFORMER = "performer";

	private static final String INTEGRITY_VARIABLE_ID = "integrityVariableId";
	private static final String INTEGRITY_TASK_IDS = "integrityTaskIds";
	
	private String[] confAlgorithms = {"low", "medium", "strong"};

	private static final int TEXT_WIDTH_200 = 200;
	private static final int CHECK_WIDTH = 200;

	private boolean canFinish = false;
	
	// Input SRS goals
	private Map<String, List<GoalType>> goalMap;

	// Output Activity Beans
	private ArrayList<ActivityBean> activityBeanList;
	
	// Mapping between goals and tasks <goalName, taskId>
	private Map<String, String> mappingGoalTask;

	// List of variable IDs
	private ArrayList<String> variableIdList;
	// List of variable names
	private ArrayList<String> variableNameList;
	
	// List of performer beans
	private List<PerformerBean> performerList;

	// Controls
	private Composite gridMainComposite;
	private Combo taskListCombo;	
	private List<Composite> groups; 
	private Group serviceGroup;
	private Group humanGroup;
	private List<Combo> variableComboList;
	private List<Combo> confAlgComboList;

	private int selectionIndex;

	private Color whiteColor;
	private Color greyColor;

	public TasksPage(SecReqSpeType srs) {
		super("TasksPage");
		setTitle("Tasks mapping");
		setDescription("Map SRS Goals to BPMN Tasks. Please, select the task to configure from the combo list. Configure also the security requirements in the 'Security requirements' tab.");

		goalMap = SrsManager.getInstance().extractRelatedGoals(srs);
		mappingGoalTask = new HashMap<String, String>();

		variableIdList = new ArrayList<String>();
		variableNameList = new ArrayList<String>();
		
		performerList = new ArrayList<TasksPage.PerformerBean>();

		groups = new ArrayList<Composite>();
		variableComboList = new ArrayList<Combo>();
		confAlgComboList = new ArrayList<Combo>();
	}

	public boolean isCanFinish() {
		return canFinish;
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}
	
	@Override
	public boolean canFinish() {
		if(isCanFinish()){
			return isReady();
		}
		else{
			return isCanFinish();
		}
	}

	@Override
	public void createControl(Composite parent) {
		gridMainComposite = new Composite(parent, SWT.NONE);
		gridMainComposite.setLayout(new GridLayout(1, false));

		whiteColor = getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE);
		greyColor = getShell().getDisplay().getSystemColor(SWT.COLOR_GRAY);

		setControl(gridMainComposite);
	}

	/**
	 * Updates the checkboxes of variables/participants for every task if they
	 * have been changed in previous screens.
	 */
	@Override
	public void onAppear() {
		super.onAppear();
		initVariableLists();
		initPerformerLists();
		if(activityBeanList == null){
			initActivityTypeList();
			createMainControls(gridMainComposite);
		}
		else{
			initActivityTypeList();
			updateMainControls();
		}
		
		setPageComplete(isReady());
		updateDisplay();
		refreshLayout();
		
	}

	@Override
	protected void pageComplete() {
		updateModel();
	}

	/**
	 * Checks whether the form is correctly full-filled.
	 * 
	 * @return True when correctly full-filled, false when a Text control is
	 *         empty or duplicated.
	 */
	private boolean isReady() {
		for (ActivityBean activityBean : activityBeanList) {
			if (activityBean.getName().isEmpty()) {
				setErrorMessage("There are empty fields.");
				return false;
			}
		}
		boolean repeated = isTaskNameRepeated();
		if (repeated) {
			setErrorMessage("Task names cannot be repeated.");
		} else {
			setErrorMessage(null);
		}
		return !repeated;
	}

	/**
	 * Refresh the page to show the last changes.
	 */
	private void refreshLayout() {
		Shell shell = getShell();
		shell.layout(true, true);
	}

	private void updateDisplay() {
		getShell().getDisplay().update();
	}

	/**
	 * Creates the main control skeleton for the goal/task correspondence.
	 * 
	 * @param composite
	 *            The parent composite
	 */
	private void createMainControls(Composite composite) {		
		if (activityBeanList.size() == 0) {
			// No goals found
			Label emptyLabel = new Label(composite, SWT.NULL);
			emptyLabel.setText("No SRS Goal found");
			emptyLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			return;
		}

		// Add task List widget
		taskListCombo = new Combo(composite, SWT.DROP_DOWN | SWT.SINGLE | SWT.READ_ONLY);
		taskListCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		updateTaskListCombo();
		taskListCombo.select(0);
		taskListCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				Combo combo = (Combo) e.widget;
				int index = combo.getSelectionIndex();
				selectionIndex = index;
				// clear the error messages
				setErrorMessage(null);
				// show the correspondent tabfolder
				showTabFolder(index);
				refreshLayout();
			}
		});		
		
		Label separator = new Label(composite, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
		GridData sepLabelData = new GridData(GridData.FILL_HORIZONTAL);
		sepLabelData.heightHint = 10;
		separator.setLayoutData(sepLabelData);
		
		showTabFolder(0);
	}
	
	private void updateMainControls(){
		if(activityBeanList.size() > 0){
			updateTaskListCombo();
			taskListCombo.select(0);
			showTabFolder(0);
		}		
	}

	private void showTabFolder(int index) {
		// Remove the last tabFolder
		if (gridMainComposite.getChildren().length > 1
				&& gridMainComposite.getChildren().length == 3) {
			gridMainComposite.getChildren()[2].dispose();
		}
		// Create a new tabFolder to add to gridMainComposite
		if (gridMainComposite.getChildren().length == 2) {
			Composite tabFolderComposite = new Composite(gridMainComposite,
					SWT.NONE);
			tabFolderComposite.setLayout(new GridLayout(1, false));
			tabFolderComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

			TabFolder tabFolder = new TabFolder(tabFolderComposite, SWT.NONE);
			tabFolder.setLayout(new FillLayout());
			tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

			tabFolder.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					TabItem tabItem = (TabItem) e.item;
					if (tabItem.getText().equals(TABITEM_TITLE_SEC_REQ)) {
						// Recalculate security requirements tab and dispose the old one
						checkSecReq(selectionIndex);
						// Check trustworthiness size
						checkTrustworthinessSize();
						TabFolder tabFolder = tabItem.getParent();
						TabItem newTabItem = addSecReqTab(tabFolder, selectionIndex);
						tabFolder.setSelection(newTabItem);
						tabItem.dispose();
					}
					else if(tabItem.getText().equals(TABITEM_TITLE_MAIN_FEATURES)){
						// Check Performers size
						checkPerformersSize();
					}
					updateDisplay();
				}
			});

			// Check Performers size
			checkPerformersSize();
			
			// Main features Tab
			addMainFeaturesTab(tabFolder, index);

			// Security Requirements Tab
			addSecReqTab(tabFolder, index);			
			
		}
	}

	private void addMainFeaturesTab(TabFolder tabFolder, int index) {
		ActivityBean activityBean = activityBeanList.get(index);

		// Main features Tab
		TabItem tbtmMainFeatures = new TabItem(tabFolder, SWT.NONE);
		tbtmMainFeatures.setText(TABITEM_TITLE_MAIN_FEATURES);

		// Main features Scrolled composite
		ScrolledComposite scMainFeatures = new ScrolledComposite(tabFolder,
				SWT.H_SCROLL | SWT.V_SCROLL);
		scMainFeatures.setExpandHorizontal(true);
		scMainFeatures.setExpandVertical(true);
		
		tbtmMainFeatures.setControl(scMainFeatures);

		// Main features composite
		Composite mainFeaturesTabComposite = new Composite(scMainFeatures,
				SWT.NONE);
		mainFeaturesTabComposite.setLayout(new GridLayout(2, false));

		// Name
		Label lblName = new Label(mainFeaturesTabComposite, SWT.NONE);
		lblName.setText("Name");

		Text txtName = new Text(mainFeaturesTabComposite, SWT.BORDER);
		txtName.setText(activityBean.getName());
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		txtName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text text = (Text) e.widget;
				updateTaskName(selectionIndex, text.getText());
				// update tasks combo
				updateTaskListCombo();
				setPageComplete(isReady());
				refreshLayout();
			}
		});

		// Type
		addTypeSelector(mainFeaturesTabComposite, index);

		// Variables
		addVariableSelector(mainFeaturesTabComposite, index);

		// Performers
		addPerformerSelector(mainFeaturesTabComposite, index);

		scMainFeatures.setMinHeight(mainFeaturesTabComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		// Scroll mainFeaturesTabComposite item
		scMainFeatures.setContent(mainFeaturesTabComposite);
	}

	private TabItem addSecReqTab(TabFolder tabFolder, int index) {
		// Security Requirements Tab
		TabItem tbtmSecurityRequirements = new TabItem(tabFolder, SWT.NONE);
		tbtmSecurityRequirements.setText(TABITEM_TITLE_SEC_REQ);

		addSecReqComposite(tbtmSecurityRequirements, index);
		return tbtmSecurityRequirements;
	}

	private void addSecReqComposite(TabItem parentTabItem, int index) {

		// Sec Req Scrolled composite
		ScrolledComposite scSecurityRequirements = new ScrolledComposite(parentTabItem.getParent(), SWT.H_SCROLL | SWT.V_SCROLL);
		scSecurityRequirements.setExpandHorizontal(true);
		scSecurityRequirements.setExpandVertical(true);
		scSecurityRequirements.setLayout(new FillLayout());

		parentTabItem.setControl(scSecurityRequirements);

		// Sec Req composite
		Composite secReqTabComposite = new Composite(scSecurityRequirements, SWT.NONE);
		secReqTabComposite.setLayout(new GridLayout(1, false));

		// Scroll secReqTabComposite item
		scSecurityRequirements.setContent(secReqTabComposite);
		
		// Sec properties only for service tasks
		if(activityBeanList.get(index).getType().equals(USER_TASK_TYPE)){
			ActivityBean activityBean = activityBeanList.get(index);		
			boolean trustFound = false;
			boolean integrityFound = false;
			boolean confFound = false;
			if(activityBean.getTrustworthiness().size() > 0 && activityBean.getTrustworthiness().get(0) != null){
				trustFound = true;
			}
			if(activityBean.getIntegrityList().size() > 0){
				integrityFound = true;
			}
			if(activityBean.getInputConfidentiality() != null || activityBean.getOutputConfidentiality() != null){
				confFound = true;
			}
			
			Group group = new Group(secReqTabComposite, SWT.SHADOW_IN);
			group.setLayout(new GridLayout());
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			if(trustFound || integrityFound || confFound){
				group.setText("Warning");
			}
			else{
				group.setText("Information");
			}
			
			
			Label label1 = new Label(group, SWT.WRAP);
			label1.setText("User tasks cannot have trustworthiness property, integrity security nor confidentiality property associated.");	
				
			if(trustFound || integrityFound){
				Label label2 = new Label(group, SWT.WRAP);
				String secReq = "";
				if(trustFound){
					secReq = "trustworthiness";
				}
				if(integrityFound){
					secReq = secReq.equals("") ? "integrity" : secReq + ", integrity";
				}
				if(confFound){
					secReq = secReq.equals("") ? "confidentiality" : secReq + ", confidentiality";
				}
				String text = "The goal associated to this task has security requirements ("+ secReq +") defined in the SRS. If you want to transform this security requirement, select \"Service task\" type for this task.";			
				label2.setText(text);	
			}
			
		}
		else{
			ExpandBar seqReqExpandBar = new ExpandBar(secReqTabComposite,SWT.V_SCROLL);
			seqReqExpandBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			seqReqExpandBar.setBackground(whiteColor);

			// Trustworthiness
			ExpandItem xpndtmTrustworthiness = new ExpandItem(seqReqExpandBar, SWT.NONE, 0);
			xpndtmTrustworthiness.setText("Trustworthiness");

			// Trustworthiness form
			Composite trustworthinessComposite = new Composite(seqReqExpandBar, SWT.NONE);
			addTrustworthinessPropertyForm(trustworthinessComposite, index);
			xpndtmTrustworthiness.setControl(trustworthinessComposite);
			xpndtmTrustworthiness.setHeight(trustworthinessComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);

			// Integrity
			ExpandItem xpndtmIntegrity = new ExpandItem(seqReqExpandBar, SWT.NONE, 1);
			xpndtmIntegrity.setText("Integrity");

			// Integrity form
			Composite integrityComposite = new Composite(seqReqExpandBar, SWT.NONE);
			addIntegrityPropertyForm(integrityComposite, index);
			xpndtmIntegrity.setControl(integrityComposite);
			xpndtmIntegrity.setHeight(integrityComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
			
			// Confidentiality
			ExpandItem xpndtmConfidentiality = new ExpandItem(seqReqExpandBar, SWT.NONE, 2);
			xpndtmConfidentiality.setText("Confidentiality");

			// Integrity form
			Composite confidentialityComposite = new Composite(seqReqExpandBar, SWT.NONE);
			addConfidentialityPropertyForm(confidentialityComposite, index);
			xpndtmConfidentiality.setControl(confidentialityComposite);
			xpndtmConfidentiality.setHeight(confidentialityComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		}

	}

	/**
	 * Adds a user or service round button selector to one task's form.
	 * 
	 * @param composite
	 *            The parent composite.
	 * @param index
	 *            The index of the corresponding task.
	 */
	private void addTypeSelector(Composite composite, int index) {
		Label lblType = new Label(composite, SWT.NONE);
		lblType.setText("Type");

		Composite taskTypeComposite = new Composite(composite, SWT.NONE);
		taskTypeComposite.setLayout(new GridLayout(1, false));

		Button btnServiceTask = new Button(taskTypeComposite, SWT.RADIO);
		btnServiceTask.setText("Service Task");
		btnServiceTask.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				Button button = (Button) e.widget;
				if(button.getSelection()){
					updateTaskType(selectionIndex, SERVICE_TASK_TYPE);
					// clear user performers
					clearSelectionGroupChildren(humanGroup);
					// update performers data
					clearPerformers(selectionIndex);
					enableGroup(serviceGroup, true);
					enableGroup(humanGroup, false);
				}				
			}
		});

		Button btnUserTask = new Button(taskTypeComposite, SWT.RADIO);
		btnUserTask.setText("User Task");
		btnUserTask.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button button = (Button) e.widget;
				if(button.getSelection()){
					updateTaskType(selectionIndex, USER_TASK_TYPE);
					// clear service performers
					clearSelectionGroupChildren(serviceGroup);
					// update performers data
					clearPerformers(selectionIndex);
					enableGroup(serviceGroup, false);
					enableGroup(humanGroup, true);
				}				
			}
		});

		// Set type
		ActivityBean activityBean = activityBeanList.get(index);
		if (activityBean.getType().equals(USER_TASK_TYPE)) {
			btnUserTask.setSelection(true);
		} else {
			btnServiceTask.setSelection(true);
		}
	}

	/**
	 * Adds a variable checkbox selector to a task's form.
	 * 
	 * @param composite
	 *            The parent composite.
	 * @param index
	 *            The index of the corresponding task.
	 */
	private void addVariableSelector(Composite composite, int index) {
		Label lblVariables = new Label(composite, SWT.NONE);
		lblVariables.setText("Variables");

		Composite variablesComposite = new Composite(composite, SWT.NONE);
		variablesComposite.setLayout(new GridLayout(1, true));
		
		setVariableButtons(variablesComposite, activityBeanList.get(index));
	}

	/**
	 * Adds a participant checkbox selector to one task's form.
	 * 
	 * @param composite
	 *            The parent composite.
	 * @param index
	 *            The index of the corresponding goal.
	 */
	private void addPerformerSelector(Composite composite, int index) {
		Label lblPerformers = new Label(composite, SWT.NONE);
		lblPerformers.setText("Performers");

		Composite performersComposite = new Composite(composite, SWT.NONE);
		performersComposite.setLayout(new GridLayout(1, false));
		performersComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		ArrayList<Button> buttonList = new ArrayList<Button>(performerList.size());
		setPerformerButtons(performersComposite, buttonList, activityBeanList.get(index));
	}

	private void addTrustworthinessPropertyForm(Composite composite, int index) {
		String trustlevel = "";
		ActivityBean activityBean = activityBeanList.get(index);

		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 20;
		gridLayout.marginBottom = gridLayout.marginTop = 10;
		gridLayout.marginLeft = gridLayout.marginRight = 10;
		composite.setLayout(gridLayout);
		composite.setBackground(whiteColor);

		if (activityBean.getTrustworthiness() == null || activityBean.getTrustworthiness().size() == 0) {
			Label info = new Label(composite, SWT.NULL);
			info.setBackground(whiteColor);
			info.setForeground(greyColor);
			info.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
			info.setText("There is no trustworthiness requirement associated to this task. If a trustworthiness requirement is desired, it can be added in the following form.");
		} else {
			if(activityBean.getTrustworthiness().size() == 1){
				trustlevel = activityBean.getTrustworthiness().get(0).toString();
			}			
		}

		Label trustworthinessLabel = new Label(composite, SWT.INHERIT_DEFAULT);
		trustworthinessLabel.setAlignment(SWT.LEFT);
		trustworthinessLabel.setBackground(whiteColor);
		trustworthinessLabel.setText("Trustworthiness level");

		Text trustValueText = new Text(composite, SWT.BORDER);
		trustValueText.setText(trustlevel);
		trustValueText.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		trustValueText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text text = (Text) e.widget;
				// TODO check trustworthiness is float < 1
				updateTrustworthiness(selectionIndex, text.getText());
			}
		});
	}

	private void addIntegrityPropertyForm(Composite composite, int index) {
		ActivityBean activityBean = activityBeanList.get(index);
		MappingManager mappingManager = MappingManager.getInstance();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 20;
		gridLayout.marginBottom = gridLayout.marginTop = 10;
		gridLayout.marginLeft = gridLayout.marginRight = 10;
		composite.setLayout(gridLayout);
		composite.setBackground(whiteColor);

		if (activityBean.getIntegrityList() == null
				|| activityBean.getIntegrityList().size() == 0) {
			Label info = new Label(composite, SWT.NULL);
			info.setBackground(whiteColor);
			info.setForeground(greyColor);
			info.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true,
					false, 1, 1));
			info.setText("There is no integrity requirement associated to this task.");
		} else {
			// For each integrity property add a form
			for (IntegrityBean integrityBean : activityBean.getIntegrityList()) {
				Group group = new Group(composite, SWT.SHADOW_IN);
				group.setLayout(new FillLayout());
				group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
				group.setBackground(whiteColor);

				VarType varType = mappingManager.getVarById(mapping, integrityBean.getVariableId());
				group.setText("Variable '" + varType.getValue() + "'");

				// Integrity Composite: with 4 cells for: 1) source service
				// task, 2) 'with' destination service task,
				// 3) 'type' and 4) 'algorithm'
				Composite integrityComposite = new Composite(group, SWT.NONE);
				integrityComposite.setLayout(new GridLayout(2, true));
				integrityComposite.setBackground(whiteColor);

				// Integrity Destination Composite (Destination Service Task)
				Text sourceText = addKeyValueGridComposite(integrityComposite, "Source service task",
						activityBean.getName(), TEXT_WIDTH_200, false);
				
				// Integrity Source Composite (Source Service Task)
				// find all service tasks available
				ArrayList<String> serviceTaskNames = findAllServiceTaskNames();
				ArrayList<String> serviceTaskIds = findAllServiceTaskIds();
				serviceTaskNames.remove(activityBean.getName());
				serviceTaskIds.remove(activityBean.getId());
				String destinationServiceTask = "";
				if (integrityBean.getWithServiceId() != null) {
					ActivityBean destActivityBean = findActivityById(integrityBean.getWithServiceId());
					destinationServiceTask = destActivityBean.getName();
				}
				Combo destCombo = addKeyValueGridComboComposite(integrityComposite, "Destination service task",
						destinationServiceTask, TEXT_WIDTH_200, true, serviceTaskNames);
				destCombo.setData(INTEGRITY_VARIABLE_ID, integrityBean.getVariableId());
				destCombo.setData(INTEGRITY_TASK_IDS, serviceTaskIds);
				destCombo.addModifyListener(new ModifyListener() {

					@Override
					public void modifyText(ModifyEvent e) {
						Combo combo = (Combo) e.widget;
						String variableId = (String) combo.getData(INTEGRITY_VARIABLE_ID);
						// change finding source service task ID
						ArrayList<String> serviceTaskIds = (ArrayList<String>) combo.getData(INTEGRITY_TASK_IDS);
						String serviceTaskId = serviceTaskIds.get(combo.getSelectionIndex());
						updateIntegrity(selectionIndex, variableId,	serviceTaskId, null, null);
					}
				});

				// Integrity Type Composite
				String type = "";
				if (integrityBean.getType() != null) {
					type = integrityBean.getType();
				}
				Text typeText = addKeyValueGridComposite(integrityComposite, "Type", type, TEXT_WIDTH_200, true);
				typeText.setData(INTEGRITY_VARIABLE_ID, integrityBean.getVariableId());
				typeText.addModifyListener(new ModifyListener() {

					@Override
					public void modifyText(ModifyEvent e) {
						Text text = (Text) e.widget;
						String variableId = (String) text.getData(INTEGRITY_VARIABLE_ID);
						updateIntegrity(selectionIndex, variableId, null, text.getText(), null);
					}
				});

				// Integrity Algorithm Composite
				String algorithm = "";
				if (integrityBean.getAlgorithm() != null) {
					algorithm = integrityBean.getAlgorithm();
				}
				Text algorithmText = addKeyValueGridComposite(integrityComposite, "Algorithm", algorithm,
						TEXT_WIDTH_200, true);
				algorithmText.setData(INTEGRITY_VARIABLE_ID, integrityBean.getVariableId());
				algorithmText.addModifyListener(new ModifyListener() {

					@Override
					public void modifyText(ModifyEvent e) {
						Text text = (Text) e.widget;
						String variableId = (String) text.getData(INTEGRITY_VARIABLE_ID);
						updateIntegrity(selectionIndex, variableId, null, null,	text.getText());
					}
				});

				group.pack();
			}
		}

	}
	
	private void addConfidentialityPropertyForm(Composite composite, int index) {
		ActivityBean activityBean = activityBeanList.get(index);
		MappingManager mappingManager = MappingManager.getInstance();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 20;
		gridLayout.marginBottom = gridLayout.marginTop = 10;
		gridLayout.marginLeft = gridLayout.marginRight = 10;
		composite.setLayout(gridLayout);
		composite.setBackground(whiteColor);
		
		// Input
		String ivText = "";
		for (VariableBean vbBean : activityBean.getVariableBeans()) {
			if(vbBean.getType().equals(VBLE_TYPE_INPUT)){
				VarType varType = mappingManager.getVarById(mapping, vbBean.getId());
				if(ivText.equals("")){
					ivText = varType.getValue();
				}
				else{
					ivText = ivText + ", " + varType.getValue();
				}
			}			
		}
		
		Button iButton = new Button(composite, SWT.CHECK);
		iButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		iButton.setText(ivText.equals("") ? "Input" : "Input (Variables: " + ivText + ")");
		iButton.setData("Input");
		iButton.setBackground(whiteColor);
		SelectionListener confSelectionListener = new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.widget;
				String type = (String) b.getData();
				if(b.getSelection()){
					updateConfidentiality(selectionIndex, type, getConfAlgByType(type));
				}
				else{
					removeConfidentiality(selectionIndex, type);
				}
			}			
		};
		iButton.addSelectionListener(confSelectionListener);
		iButton.setSelection(activityBean.getInputConfidentiality() != null ? true : false);

		// iAlg Label
		Label iAlgLabel = new Label(composite, SWT.NULL);
		iAlgLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		iAlgLabel.setText("Algorithm");
		iAlgLabel.setBackground(whiteColor);
		
		// iAlg Combo
		Combo iCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		iCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		iCombo.setItems(confAlgorithms);
		iCombo.setBackground(whiteColor);
		iCombo.setData("Input");
		SelectionListener confAlgComboChangeListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo combo = (Combo) e.widget;
				String type = (String) combo.getData();
				updateConfidentialityAlg(selectionIndex, type, combo.getText());
			}
		};
		iCombo.addSelectionListener(confAlgComboChangeListener);
		iCombo.setText(activityBean.getInputConfidentiality() != null ? activityBean.getInputConfidentiality().getAlgorithm() : confAlgorithms[0]);
		
		// Output
		String ovText = "";
		for (VariableBean vbBean : activityBean.getVariableBeans()) {
			if(vbBean.getType().equals(VBLE_TYPE_OUTPUT)){
				VarType varType = mappingManager.getVarById(mapping, vbBean.getId());
				if(ovText.equals("")){
					ovText = varType.getValue();
				}
				else{
					ovText = ovText + ", " + varType.getValue();
				}
			}
			
		}
		
		Button oButton = new Button(composite, SWT.CHECK);
		oButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		oButton.setText(ovText.equals("") ? "Output" : "Output (Variables: " + ovText + ")");
		oButton.setData("Output");
		oButton.setBackground(whiteColor);
		oButton.addSelectionListener(confSelectionListener);
		oButton.setSelection(activityBean.getOutputConfidentiality() != null ? true : false);
		
		// oAlg Label
		Label oAlgLabel = new Label(composite, SWT.NULL);
		oAlgLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		oAlgLabel.setText("Algorithm");
		oAlgLabel.setBackground(whiteColor);

		// oAlg Combo
		Combo oCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		oCombo.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		oCombo.setItems(confAlgorithms);
		oCombo.setBackground(whiteColor);
		oCombo.setData("Output");
		oCombo.addSelectionListener(confAlgComboChangeListener);
		oCombo.setText(activityBean.getOutputConfidentiality() != null ? activityBean.getOutputConfidentiality().getAlgorithm() : confAlgorithms[0]);
		
		confAlgComboList.clear();
		confAlgComboList.add(iCombo);
		confAlgComboList.add(oCombo);
	}
	
	private String getConfAlgByType(String type){
		for (Combo combo : confAlgComboList) {
			String t = (String) combo.getData();
			if(t.equals(type)){
				return combo.getText();
			}
		}
		return null;
	}

	private Text addKeyValueGridComposite(Composite composite, String keyText,
			String defaultValueText, int widthvalueText,
			boolean valueTextEnabled) {
		Composite subcomposite = new Composite(composite, SWT.NULL);
		subcomposite.setLayout(new GridLayout(2, true));
		subcomposite
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		subcomposite.setBackground(whiteColor);
		// Key Label
		Label keyLabel = new Label(subcomposite, SWT.NULL);
		keyLabel.setAlignment(SWT.LEFT);
		keyLabel.setText(keyText);
		keyLabel.setBackground(whiteColor);
		// Value Text
		GridData gdParam = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		gdParam.widthHint = widthvalueText;
		Text valueText = new Text(subcomposite, SWT.BORDER);
		valueText.setLayoutData(gdParam);
		valueText.setEnabled(valueTextEnabled);
		valueText.setText(defaultValueText);
		valueText.setBackground(whiteColor);

		return valueText;
	}

	private Combo addKeyValueGridComboComposite(Composite composite,
			String keyText, String defaultValueText, int widthvalueText,
			boolean valueTextEnabled, ArrayList<String> valueList) {
		Composite subcomposite = new Composite(composite, SWT.NONE);
		subcomposite.setLayout(new GridLayout(2, true));
		subcomposite
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		subcomposite.setBackground(whiteColor);
		// Key Label
		Label keyLabel = new Label(subcomposite, SWT.NULL);
		keyLabel.setAlignment(SWT.LEFT);
		keyLabel.setText(keyText);
		keyLabel.setBackground(whiteColor);
		// Value Combo
		Combo valueCombo = new Combo(subcomposite, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gdParam = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		gdParam.widthHint = widthvalueText;
		valueCombo.setLayoutData(gdParam);
		valueCombo.setEnabled(valueTextEnabled);
		String[] valueArr = new String[valueList.size()];
		valueArr = valueList.toArray(valueArr);
		valueCombo.setItems(valueArr);
		valueCombo.setText(defaultValueText);
		valueCombo.setBackground(whiteColor);

		return valueCombo;
	}

	/**
	 * Updates variable checkboxes.
	 * 
	 * @param composite
	 *            The parent composite.
	 * @param variableButtonList
	 *            The checkbox list to update (presumably belonging to
	 *            variableList).
	 * @param activityType
	 *            The task associated to the variables
	 */
	private void setVariableButtons(Composite composite, ActivityBean activityBean) {
		variableComboList.clear();
		List<Button> variableButtonList = new ArrayList<Button>();
		
		GridData gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		gd.widthHint = CHECK_WIDTH;
		
		Composite variableComposite = new Composite(composite, SWT.NONE);
		variableComposite.setLayout(new GridLayout(2, false));
		variableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		String[] variableTypesArr = new String[]{VBLE_TYPE_INPUT, VBLE_TYPE_OUTPUT};
		
		// Create the new checkboxes according to the variables
		int size = Math.min(variableIdList.size(), variableNameList.size());
		for (int i = 0; i < size; i++) {
			final String variableId = variableIdList.get(i);
			String variableName = variableNameList.get(i);
			Button button = new Button(variableComposite, SWT.CHECK);
			button.setLayoutData(gd);
			button.setText(variableName);
			button.setToolTipText(variableName);
			button.setData(WIDGET_DATA_VARIABLE, variableId);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Button button = (Button) e.widget;
					String variableId = (String) button.getData(WIDGET_DATA_VARIABLE);
					String type = getTypeByVariableId(variableId);
					if(button.getSelection() && type.equals(VBLE_TYPE_OUTPUT)){						
						// If it is a service task, only one output variable can be possible
						boolean found = false;
						ActivityBean activityBean = activityBeanList.get(selectionIndex);
						if(activityBean.getType().equals(SERVICE_TASK_TYPE) && type.equals(VBLE_TYPE_OUTPUT)){
							// Look for other output variable				
							for (VariableBean variableBean : activityBean.getVariableBeans()) {
								if(variableBean.getType().equals(VBLE_TYPE_OUTPUT)){
									found = true;
									break;
								}
							}
						}
						if(!found){
							// Update the variables
							updateVariables(selectionIndex, variableId,	type, !button.getSelection());
						}
						else{
							// Warning : Only one output variable can be selected for service tasks
							setErrorMessage(getDescription() + "\nOnly one output variable can be selected for service tasks");
							button.setSelection(false);
						}
					}
					else{
						updateVariables(selectionIndex, variableId,	type, !button.getSelection());
					}
					
					
				}
			});
			variableButtonList.add(button);
			
			Combo combo = new Combo(variableComposite, SWT.DROP_DOWN | SWT.SINGLE | SWT.READ_ONLY);
			combo.setItems(variableTypesArr);
			combo.setData(WIDGET_DATA_VARIABLE, variableId);
			if(activityBean.getType().equals(SERVICE_TASK_TYPE)){
				combo.select(0);
			}
			else{
				combo.select(1);
			}
			
			combo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Combo combo = (Combo) e.widget;
					String variableId = (String) combo.getData(WIDGET_DATA_VARIABLE);
					String type = combo.getText();
					ActivityBean activityBean = activityBeanList.get(selectionIndex);
					VariableBean selectedVariableBean = getVariableBeanById(activityBean.getVariableBeans(), variableId);
					if(selectedVariableBean != null){
						// If it is a service task, only one output variable can be possible
						boolean found = false;
						if(activityBean.getType().equals(SERVICE_TASK_TYPE) && type.equals(VBLE_TYPE_OUTPUT)){
							// Look for other output variable				
							for (VariableBean variableBean : activityBean.getVariableBeans()) {
								if(variableBean.getType().equals(VBLE_TYPE_OUTPUT)){
									found = true;
									break;
								}
							}
						}
						if(!found){
							// Update the type of the variable
							updateVariableType(selectionIndex, variableId, type);
						}
						else{
							// Warning : Only one output variable can be selected for service tasks
							setErrorMessage(getDescription() + "\nOnly one output variable can be selected for service tasks");
							combo.select(0);
						}
					}					
					
				}				
			});
			variableComboList.add(combo);			
		}

		// Check the default variables according to authorization preconditions
		// for this goal
		updateDefaultVariableButtonState(variableButtonList, variableComboList, activityBean);
	}
	
	private String getTypeByVariableId(String id){
		for (Combo combo : variableComboList) {
			String variableId = (String) combo.getData(WIDGET_DATA_VARIABLE);
			if(variableId.equals(id)){
				return combo.getText();
			}
		}
		return null;
	}

	/**
	 * Checks the variables that should be selected by default, according to the
	 * goal's authorization preconditions.
	 * 
	 * @param buttonList
	 *            The checkbox list to check.
	 * @param activityType
	 *            The task associated to the variables
	 */
	private void updateDefaultVariableButtonState(List<Button> buttonList, List<Combo> comboList,
			ActivityBean activityBean) {
		for (VariableBean variableBean : activityBean.getVariableBeans()) {
			for (Button button : buttonList) {
				if (button.getData(WIDGET_DATA_VARIABLE).equals(variableBean.getId())) {
					button.setSelection(true);
					break;
				}
			}
			for (Combo combo : comboList) {
				if(combo.getData(WIDGET_DATA_VARIABLE).equals(variableBean.getId())){
					if(variableBean.getType().equals(VBLE_TYPE_INPUT)){
						combo.select(0);
					}
					else{
						combo.select(1);
					}					
				}
			}
		}
	}

	/**
	 * Updates participant radio buttons.
	 * 
	 * @param composite The parent composite.
	 * @param buttonList The button list to update (presumably belonging to
	 *            performerList).
	 * @param activityType The task associated to the performers
	 */
	private void setPerformerButtons(Composite composite,
			ArrayList<Button> buttonList, ActivityBean activityBean) {

		// Create the new buttons according to the participants
		List<PerformerBean> servicePerformers = getPerformerBeanService();
		List<PerformerBean> humanPerformers = getPerformerBeanHuman();
		Composite performersComposite = new Composite(composite, SWT.NONE);
		performersComposite.setLayout(new GridLayout(2, false));			
		performersComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		serviceGroup = createPerformerGroup(performersComposite, servicePerformers, buttonList, "Service Providers");
		humanGroup = createPerformerGroup(performersComposite, humanPerformers, buttonList, "Human Performers");
		groups.clear();
		groups.add(serviceGroup);
		groups.add(humanGroup);
		if (activityBean.getType().equals(USER_TASK_TYPE)) {
			enableGroup(serviceGroup, false);
			enableGroup(humanGroup, true);
		} else {
			enableGroup(serviceGroup, true);
			enableGroup(humanGroup, false);
		}
		
		// Check the default participants according to delegation preconditions
		// for this goal
		updateDefaultPerformerButtonState(buttonList, activityBean);
	}

	private Group createPerformerGroup (Composite composite, List<PerformerBean> performers,
			ArrayList<Button> buttonList, String groupName){
		Group group = new Group(composite, SWT.SHADOW_IN);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group.setText(groupName);
		for (PerformerBean performerBean : performers) {
			Button button = createPerformerButton(group, performerBean.getId(), 
					performerBean.getRole(), performerBean.getName());
			if(buttonList != null){
				buttonList.add(button);
			}			
		}
		group.pack();
		return group;
	}
	
	private Button createPerformerButton (Composite composite, String id, String role, String name){
		Button button = new Button(composite, SWT.RADIO);
		button.setLayoutData(new GridData(SWT.FILL,  SWT.BEGINNING, true, false));
		String text = "Role: " + role;
		if(name != null){
			text = "Name: " + name + " / " + text;
		}
		button.setText(text);
		button.setData(WIDGET_DATA_PERFORMER, id);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button button = (Button) e.widget;
				if(button.getSelection()){
					clearPerformers(selectionIndex);
					button.setSelection(true);
					String performerId = (String) button.getData(WIDGET_DATA_PERFORMER);
					updatePerformers(selectionIndex, performerId, !button.getSelection());
				}				
			}
		});
		return button;
	}
	
	private void clearSelectionGroupChildren(Composite composite){
		for (Control control : composite.getChildren()) {
			if(control instanceof Button){
				Button button = (Button) control;
				button.setSelection(false);
			}
		}
	}
	
	private void clearPerformers (int selectionIndex){
		ActivityBean activityBean = activityBeanList.get(selectionIndex);
		activityBean.getPerformerBeans().clear();
		for (Composite composite : groups) {
			for (Control control : composite.getChildren()) {
				if(control instanceof Button){
					Button button = (Button) control;
					button.setSelection(false);
				}
			}
		}
	}
	
	private void enableGroup (Group group, boolean enabled){
		for (int i = 0; i < group.getChildren().length; i++) {
			Control control = group.getChildren()[i];
			control.setEnabled(enabled);			
		}
		group.setEnabled(enabled);
	}
	
	/**
	 * Checks the participants that should be selected by default, according to
	 * the goal's delegation preconditions.
	 * 
	 * @param buttonList
	 *            The button list to check.
	 * @param activityBean
	 *            The activity bean
	 */
	private void updateDefaultPerformerButtonState(ArrayList<Button> buttonList, ActivityBean activityBean) {
		for (PerformerBean performerBean : activityBean.performerBeans) {
			for (Button button : buttonList) {
				if (button.getData(WIDGET_DATA_PERFORMER).equals(performerBean.getId())) {
					button.setSelection(true);
					break;
				}
			}
		}
	}

	private void updateTaskListCombo() {
		int selectedIndex = taskListCombo.getSelectionIndex();
		String[] activityArr = new String[activityBeanList.size()];
		for (int i = 0; i < activityBeanList.size(); i++) {
			ActivityBean activityBean = activityBeanList.get(i);
			activityArr[i] = activityBean.getName();
		}
		taskListCombo.setItems(activityArr);
		if (selectedIndex >= 0) {
			taskListCombo.select(selectedIndex);
		}
	}

	/**
	 * Re/initializes the lists of variable ID's and names from the existing
	 * mapping model.
	 * 
	 * @return True if the lists have changed after the call, false otherwise.
	 */
	private boolean initVariableLists() {
		ArrayList<String> oldVariableIdList = variableIdList;
		ArrayList<String> oldVariableNameList = variableNameList;

		variableIdList = new ArrayList<String>();
		variableNameList = new ArrayList<String>();

		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		EList<RepresentsType> repList = mapping.getRepresents();
		for (RepresentsType rep : repList) {
			VarType var = rep.getVariable();
			variableIdList.add(var.getId());
			variableNameList.add(var.getValue());
		}

		int size = Math.min(variableIdList.size(), variableNameList.size());
		int oldSize = Math.min(oldVariableIdList.size(),
				oldVariableNameList.size());
		if (size != oldSize) {
			return true;
		} else {
			for (int i = 0; i < size; i++) {
				if (!variableIdList.get(i).equals(oldVariableIdList.get(i))
						|| !variableNameList.get(i).equals(
								oldVariableNameList.get(i))) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Re/initializes the list of performers from the existing mapping model.
	 */
	private void initPerformerLists(){
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		performerList.clear();
		// Get mapped roles
		for (PlaysType playsType : mapping.getPlays()) {
			if(!findPerformerBeanRole(playsType.getBPPart().getValue())){
				PerformerBean performerBean = new PerformerBean();
				performerBean.setId(playsType.getBPPart().getId());
				performerBean.setType(playsType.getBPPart().getType().getName());
				performerBean.setRole(playsType.getBPPart().getValue());
				performerList.add(performerBean);
			}			
		}
		// Get mapped agents
		for (IsaType isaType : mapping.getIsA()) {			
			BPPType bppType = isaType.getBPPart().get(0);
			BPRType bprType = isaType.getBPRole().get(0);
			if(!findPerformerBeanValue(bppType.getValue(), bprType.getValue())){
				PerformerBean performerBean = new PerformerBean();
				performerBean.setId(bppType.getId());
				performerBean.setType(bppType.getType().getName());
				performerBean.setName(bppType.getValue());				
				performerBean.setRole(bprType.getValue());
				performerList.add(performerBean);
			}
		}		
	}
		

	private void initActivityTypeList() {
		// Check if already exists information loaded
		if(activityBeanList == null || activityBeanList.size() == 0){
			activityBeanList = new ArrayList<ActivityBean>();
			// Init activityBean list			
			for (String goalName : goalMap.keySet()) {
				ActivityBean activityBean = new ActivityBean(goalName.replaceAll(" ", "_"));

				// find and set default performers
				initDefaultPerformers(goalName, activityBean);
				
				// set service task by default
				boolean humanFound = false;
				for (PerformerBean performerBean : activityBean.getPerformerBeans()) {
					if(performerBean.getType().equals(TypeType.HUMAN.getName())){
						humanFound = true;
					}
				}
				if(humanFound){
					activityBean.setType(USER_TASK_TYPE);
				}
				else{
					activityBean.setType(SERVICE_TASK_TYPE);
				}		
				
				// find and set default variables
				initDefaultVariables(goalName, activityBean);

				// find and set Trustworthiness property
				initDefaultTrustworthinessProperty(goalName, activityBean);

				// find and set Integrity property
				initDefaultIntegrityProperty(activityBean);
				
				// find and set confidentiality
				initDefaultConfidentiality(activityBean);

				activityBeanList.add(activityBean);
				activityBean.setId(PREFIX + activityBeanList.indexOf(activityBean));
				mappingGoalTask.put(activityBean.getId(), goalName);
			}
		}		
	}


	private void initDefaultVariables(String goalName, ActivityBean activityBean) {
		SrsManager srsManager = SrsManager.getInstance();
		MappingManager mappingManager = MappingManager.getInstance();

		SecReqSpeType srs = ((Srs2ActivitiWizard) getWizard()).getSrs();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		List<GoalType> goalList = goalMap.get(goalName);
		for (GoalType goalType : goalList) {
			ArrayList<DocType> docList = srsManager.getAuthDocuments(srs, goalType.getId());
			for (DocType doc : docList) {
				VarType var = mappingManager.getVar(mapping, doc.getId().toString());
				if (var != null) {
					VariableBean variableBean = getVariableBeanById(activityBean.getVariableBeans(), var.getId());
					if(variableBean == null){
						if(activityBean.getType().equals(SERVICE_TASK_TYPE)){
							variableBean = new VariableBean(var.getId(), var.getValue(), VBLE_TYPE_INPUT);
							activityBean.getVariableBeans().add(variableBean);
						}
						else{
							variableBean = new VariableBean(var.getId(), var.getValue(), VBLE_TYPE_OUTPUT);
							activityBean.getVariableBeans().add(variableBean);
						}						
					}				
				}
			}
		}		
	}

	private void initDefaultPerformers(String goalName, ActivityBean activityBean) {
		SrsManager srsManager = SrsManager.getInstance();
		MappingManager mappingManager = MappingManager.getInstance();

		SecReqSpeType srs = ((Srs2ActivitiWizard) getWizard()).getSrs();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		List<ActorType> actorList = srsManager.getDelActorsByName(srs, goalName);
		for (ActorType actor : actorList) {
			ArrayList<ParticipantType> partList = mappingManager
					.getParticipants(mapping, srsManager.getActorId(actor)
							.toString());
			// Manage multiple performers for the same task
			for (ParticipantType participantType : partList) {
				if(participantType instanceof BPPType){
					String partId = mappingManager.getParticipantId(participantType);
					if(!containsPerformerById(activityBean, partId)){
						activityBean.getPerformerBeans().add(getPerformerBeanById(partId));
					}
				}				
			}
		}
			

	}

	private void initDefaultTrustworthinessProperty(String goalName,
			ActivityBean activityBean) {
		SrsManager srsManager = SrsManager.getInstance();
		SecReqSpeType srs = ((Srs2ActivitiWizard) getWizard()).getSrs();
		
		List<GoalType> goalList = goalMap.get(goalName);
		for (GoalType goalType : goalList) {
			// Extract the possible trustworthiness commitment
			TrustworthinessType trustworthinessType = srsManager.extractCommitmentTrust(srs, goalType.getId());

			if (trustworthinessType != null) {
				Float trustworthinessFloat = new Float(trustworthinessType.getMinLevel());
				if(!activityBean.getTrustworthiness().contains(trustworthinessFloat)){
					activityBean.getTrustworthiness().add(trustworthinessFloat);
				}
			}
		}
	}

	private void initDefaultIntegrityProperty(ActivityBean activityBean) {
		checkIntegrity(activityBean);
	}
	
	private void initDefaultConfidentiality(ActivityBean activityBean) {
		checkConfidentiality(activityBean);
	}

	private void updateTaskName(int index, String name) {
		ActivityBean activityBean = activityBeanList.get(index);
		activityBean.setName(name);
	}

	private void updateTaskType(int index, String type) {
		ActivityBean activityBean = activityBeanList.get(index);
		activityBean.setType(type);
	}

	private void updateVariables(int index, String variableId, String type, boolean remove) {
		ActivityBean activityBean = activityBeanList.get(index);
		VariableBean variableBean = getVariableBeanById(activityBean.getVariableBeans(), variableId);
		// Remove the variable from the task
		if (remove) {			
			if(variableBean != null){
				activityBean.getVariableBeans().remove(variableBean);
			}
		}
		// Add the variable to the task
		else {
			if(variableBean == null){
				variableBean = new VariableBean(variableId, null, type);			
				activityBean.getVariableBeans().add(variableBean);
			}
		}
	}
	
	private void updateVariableType (int index, String variableId, String type){
		ActivityBean activityBean = activityBeanList.get(index);
		VariableBean variableBean = getVariableBeanById(activityBean.getVariableBeans(), variableId);
		if(variableBean != null){
			variableBean.setType(type);
		}			
	}
	
	private VariableBean getVariableBeanById (List<VariableBean> variableBeans, String id){
		for (VariableBean variableBean : variableBeans) {
			if(variableBean.getId().equals(id)){
				return variableBean;
			}
		}
		return null;
	}

	private ActivityBean updatePerformers(int index, String performerId, boolean remove) {
		ActivityBean activityBean = activityBeanList.get(index);
		// Remove the performer from the task
		PerformerBean performerBean = getPerformerBeanById(performerId);
		if (remove) {
			if(containsPerformerById(activityBean, performerId)){
				activityBean.getPerformerBeans().remove(performerBean);
			}
		}
		// Add the performer to the task
		else {
			if(!containsPerformerById(activityBean, performerId)){
				activityBean.getPerformerBeans().add(performerBean);
			}
		}
		return activityBean;
	}

	private void updateTrustworthiness(int index, String trustLevel) {
		ActivityBean activityBean = activityBeanList.get(index);
		activityBean.getTrustworthiness().clear();
		activityBean.getTrustworthiness().add(new Float(trustLevel));
	}
	
	private void updateConfidentiality (int index, String type, String alg){
		ActivityBean activityBean = activityBeanList.get(index);
		if(type.equals("Input")){
			if(activityBean.getInputConfidentiality() != null){
				activityBean.getInputConfidentiality().setAlgorithm(alg);
			}
			else{
				activityBean.setInputConfidentiality(new ConfidentialityBean(alg));
			}
		}
		else if(type.equals("Output")){
			if(activityBean.getOutputConfidentiality() != null){
				activityBean.getOutputConfidentiality().setAlgorithm(alg);
			}
			else{
				activityBean.setOutputConfidentiality(new ConfidentialityBean(alg));
			}
		}
	}
	
	private void updateConfidentialityAlg (int index, String type, String alg){
		ActivityBean activityBean = activityBeanList.get(index);
		if(type.equals("Input") && activityBean.getInputConfidentiality() != null){
			activityBean.getInputConfidentiality().setAlgorithm(alg);
		}
		else if(type.equals("Output") && activityBean.getOutputConfidentiality() != null){
			activityBean.getOutputConfidentiality().setAlgorithm(alg);
		}		
	}
	
	private void removeConfidentiality (int index, String type){
		ActivityBean activityBean = activityBeanList.get(index);
		if(type.equals("Input")){
			activityBean.setInputConfidentiality(null);
		}
		else{
			activityBean.setOutputConfidentiality(null);
		}
	}

	private void updateIntegrity(int index, String variableId, String withTask,
			String type, String algorithm) {
		ActivityBean activityBean = activityBeanList.get(index);
		for (IntegrityBean integrityBean : activityBean.getIntegrityList()) {
			if (integrityBean.getVariableId().equals(variableId)) {
				if (withTask != null) {
					integrityBean.setWithServiceId(withTask);
				}
				if (type != null) {
					integrityBean.setType(type);
				}
				if (algorithm != null) {
					integrityBean.setAlgorithm(algorithm);
				}
				break;
			}
		}
	}

	private void checkSecReq(int index) {
		ActivityBean activityBean = activityBeanList.get(index);
		if(activityBean.getType().equals(SERVICE_TASK_TYPE)){
			checkIntegrity(activityBean);
			checkConfidentiality(activityBean);
		}		
	}

	private void checkIntegrity(ActivityBean activityBean) {
		SrsManager srsManager = SrsManager.getInstance();
		MappingManager mappingManager = MappingManager.getInstance();

		SecReqSpeType srs = ((Srs2ActivitiWizard) getWizard()).getSrs();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		// Create history of integrity list
		List<IntegrityBean> oldIntegrityList = cloneIntegrityBeanList(activityBean.getIntegrityList());
		activityBean.getIntegrityList().clear();

		// Check integrity
		if (activityBean.getType().equals(SERVICE_TASK_TYPE)) {
			for (VariableBean variableBean : activityBean.getVariableBeans()) {
				if(variableBean.getType().equals(VBLE_TYPE_OUTPUT)){
					List<eu.aniketos.mtm.mapping.DocType> docList = mappingManager.getDocsByVariableId(mapping, variableBean.getId());
					if(docList != null && docList.size() > 0){
						for (eu.aniketos.mtm.mapping.DocType docType : docList) {
							ArrayList<CommitmentType> commitments = srsManager
									.extractCommitmentIntegrityByDoc(srs, docType.getId());
							// Check if the performer selected for the task is the
							// performer associated to the actor source involved in
							// any Integrity commitment
							if(commitments != null && commitments.size() > 0){
								if (activityBean.getPerformerBeans() != null
										&& activityBean.getPerformerBeans().size() > 0) {
									boolean performerChecked = false;
									for (CommitmentType commitmentType : commitments) {
										if (performerChecked) {
											break;
										}
										ActorType actorType = commitmentType.getPrecondition().getProvision().getSource();
										ArrayList<ParticipantType> participantTypes = mappingManager.getParticipants(mapping, srsManager
														.getActorId(actorType).toString());
										for (ParticipantType participantType : participantTypes) {
											for (PerformerBean performerBean : activityBean.performerBeans) {
												if (mappingManager.getParticipantId(participantType).equals(performerBean.getId())) {
													performerChecked = true;
												}
											}
										}
									}
									// Add integrity to task
									if (performerChecked) {
										IntegrityBean integrityBean = new IntegrityBean(variableBean.getId(), null, null, null);
										activityBean.getIntegrityList().add(integrityBean);
									}
								}
							}
						}
					}
				}
			}
		}

		// Check integrity list history --> if exists any integrity list before,
		// copy the attributes
		for (IntegrityBean oldIntegrityBean : oldIntegrityList) {
			for (IntegrityBean integrityBean : activityBean.getIntegrityList()) {
				if (oldIntegrityBean.getVariableId().equals(integrityBean.getVariableId())) {
					integrityBean.setWithServiceId(oldIntegrityBean.getWithServiceId());
					integrityBean.setType(oldIntegrityBean.getType());
					integrityBean.setAlgorithm(oldIntegrityBean.getAlgorithm());
					break;
				}
			}
		}
	}
	
	private void checkConfidentiality(ActivityBean activityBean) {
		SrsManager srsManager = SrsManager.getInstance();
		MappingManager mappingManager = MappingManager.getInstance();

		SecReqSpeType srs = ((Srs2ActivitiWizard) getWizard()).getSrs();
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();

		// Check confidentiality
		if (activityBean.getType().equals(SERVICE_TASK_TYPE)) {
			for (VariableBean variableBean : activityBean.getVariableBeans()) {
				List<eu.aniketos.mtm.mapping.DocType> docList = mappingManager.getDocsByVariableId(mapping, variableBean.getId());
				if(docList != null && docList.size() > 0){
					for (eu.aniketos.mtm.mapping.DocType docType : docList) {
						ArrayList<CommitmentType> commitments = srsManager.extractCommitmentConfidentialityByDoc(srs, docType.getId());								
						// Check if the performer selected for the task is the performer associated to the actor source involved in any confidentiality commitment
						if(commitments != null && commitments.size() > 0){
							if (activityBean.getPerformerBeans() != null && activityBean.getPerformerBeans().size() > 0) {
								boolean performerChecked = false;
								for (CommitmentType commitmentType : commitments) {
									if (performerChecked) {
										break;
									}
									if(variableBean.getType().equals(VBLE_TYPE_OUTPUT)){
										ActorType actorType = commitmentType.getPrecondition().getProvision().getSource();
										ArrayList<ParticipantType> participantTypes = mappingManager.getParticipants(mapping, srsManager.getActorId(actorType).toString());
										for (ParticipantType participantType : participantTypes) {
											for (PerformerBean performerBean : activityBean.performerBeans) {
												if (mappingManager.getParticipantId(participantType).equals(performerBean.getId())) {
													performerChecked = true;
												}
											}
										}
									}
									else{
										ActorType actorType = commitmentType.getPrecondition().getProvision().getDestination();
										ArrayList<ParticipantType> participantTypes = mappingManager.getParticipants(mapping, srsManager.getActorId(actorType).toString());
										for (ParticipantType participantType : participantTypes) {
											for (PerformerBean performerBean : activityBean.performerBeans) {
												if (mappingManager.getParticipantId(participantType).equals(performerBean.getId())) {
													performerChecked = true;
												}
											}
										}
									}

								}
								// Add confidentiality to task
								if (performerChecked) {
									if(variableBean.getType().equals(VBLE_TYPE_OUTPUT) && activityBean.getOutputConfidentiality() == null){
										activityBean.setOutputConfidentiality(new ConfidentialityBean(confAlgorithms[0]));
									}	
									else if(variableBean.getType().equals(VBLE_TYPE_INPUT) && activityBean.getInputConfidentiality() == null){
										activityBean.setInputConfidentiality(new ConfidentialityBean(confAlgorithms[0]));
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void checkPerformersSize (){
		ActivityBean activityBean = activityBeanList.get(selectionIndex);
		if(activityBean.getPerformerBeans().size() > 1){
			PerformerDialog dialog = new PerformerDialog(getShell(), activityBean.getName(), activityBean.performerBeans);
			dialog.setHelpAvailable(false);
			dialog.setBlockOnOpen(true);
			if(dialog.open() == Window.OK){
				activityBean.getPerformerBeans().clear();
				activityBean = updatePerformers(selectionIndex, dialog.getSelectedPerformerId(), false);
				// update task type depending on the performer type
				boolean humanFound = false;
				for (PerformerBean performerBean : activityBean.getPerformerBeans()) {
					if(performerBean.getType().equals(TypeType.HUMAN.getName())){
						humanFound = true;
					}
				}
				if(humanFound){
					activityBean.setType(USER_TASK_TYPE);
				}
				else{
					activityBean.setType(SERVICE_TASK_TYPE);
				}		
			}
			
		}		
	}
	
	private void checkTrustworthinessSize(){
		ActivityBean activityBean = activityBeanList.get(selectionIndex);
		if(activityBean.getType().equals(SERVICE_TASK_TYPE) && activityBean.getTrustworthiness().size() > 1){
			TrustworthinessDialog dialog = new TrustworthinessDialog(getShell(), activityBean.getName(), activityBean.getTrustworthiness());
			dialog.setHelpAvailable(false);
			dialog.setBlockOnOpen(true);
			if(dialog.open() == Window.OK){
				activityBean.getTrustworthiness().clear();
				updateTrustworthiness(selectionIndex, dialog.getTrustworthinessLevel());
			}
		}
	}	

	private void updateModel() {
		// Recalculate integrity for all tasks
		for (int i = 0; i < activityBeanList.size(); i++) {
			checkSecReq(i);
		}

		// Save ActivityBeans into mapping model
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		MappingManager manager = MappingManager.getInstance();
		// Clear the existing relatesTo relationships
		manager.resetRelatesToList(mapping);

		for (ActivityBean activityBean : activityBeanList) {
			// The relationship goal-task is changed to N-1
			// Create the goal mapping list
			List<eu.aniketos.mtm.mapping.GoalType> mappingGoalList = new ArrayList<eu.aniketos.mtm.mapping.GoalType>();
			List<GoalType> goalList = goalMap.get(mappingGoalTask.get(activityBean.getId()));
			for (GoalType goalType : goalList) {
				eu.aniketos.mtm.mapping.GoalType mappingGoal = manager.createGoal(
						goalType.getId(), goalType.getValue().trim());
				mappingGoalList.add(mappingGoal);
			}

			ActivityType activityType = manager.createActivity(activityBean.getId(), activityBean.getName());

			// Set the task type as user/service
			if (activityBean.getType().equals(SERVICE_TASK_TYPE)) {
				activityType.setUsertype(UsertypeType.SERVICE_TASK);
			} else if (activityBean.getType().equals(USER_TASK_TYPE)) {
				activityType.setUsertype(UsertypeType.USER_TASK);
			}

			// Associate the variables to the task
			// check&add confidentiality
			String iConfidentiality = (activityBean.getInputConfidentiality() != null && activityBean.getInputConfidentiality().getAlgorithm() != null)? activityBean.getInputConfidentiality().getAlgorithm() : null;
			String oConfidentiality = (activityBean.getOutputConfidentiality() != null && activityBean.getOutputConfidentiality().getAlgorithm() != null)? activityBean.getOutputConfidentiality().getAlgorithm() : null;
			for (VariableBean variableBean : activityBean.getVariableBeans()) {
				if(variableBean.getType().equals(VBLE_TYPE_INPUT)){
					manager.addActivityVariable(activityType, variableBean.getId(), TypeType2.INPUT, iConfidentiality);
				}
				else if(variableBean.getType().equals(VBLE_TYPE_OUTPUT)){
					manager.addActivityVariable(activityType, variableBean.getId(), TypeType2.OUTPUT, oConfidentiality);
				}
				
			}

			// Associate the participants to the task
			for (PerformerBean performerBean : activityBean.performerBeans) {				
				manager.addActivityParticipant(activityType, performerBean.getId());
			}

			if (activityBean.getType().equals(SERVICE_TASK_TYPE)) {
				// Associate trustworthiness property to the task
				if (activityBean.getTrustworthiness() != null && activityBean.getTrustworthiness().size() == 1) {
					manager.addActivityTrustworthinessProperty(activityType,activityBean.getTrustworthiness().get(0).toString());
				}
			}
			
			

			// Create and add the relatesTo relationship
			RelatesToType rt = manager.createRelatesTo(mappingGoalList,activityType);
			manager.addRelatesTo(mapping, rt);
		}

		// Associate integrity properties to the task
		for (int i = 0; i < activityBeanList.size(); i++) {
			ActivityBean activityBean = activityBeanList.get(i);
			if (activityBean.getType().equals(SERVICE_TASK_TYPE)) {
				for (IntegrityBean integrityBean : activityBean.integrityList) {
					ActivityType sourceActivity = manager.findActivityById(mapping,activityBean.getId());
					ActivityType destinationActivity = manager.findActivityById(mapping,integrityBean.getWithServiceId());
					if(sourceActivity !=null && destinationActivity != null && integrityBean.getVariableId() !=null
							&& integrityBean.getType() != null && integrityBean.getAlgorithm() != null){
						manager.addActivityIntegrityProperty(sourceActivity,
								integrityBean.getVariableId(), destinationActivity.getId(),
								integrityBean.getType(), integrityBean.getAlgorithm());
						boolean foundVarinDestination = false;
						for (ActivityVar activityVar : destinationActivity.getVariable()) {
							if(activityVar.getId().equals(integrityBean.getVariableId()) && activityVar.getType().equals(TypeType2.INPUT)){
								foundVarinDestination = true;
								break;
							}
						}
						if(!foundVarinDestination){
							// Add Integrity Var in Destination task as input variable
							ActivityBean destBean = findActivityById(destinationActivity.getId());
							boolean setiConf = false;
							if(destBean.getInputConfidentiality() == null){
								setiConf = true;
								VariableBean variableBean = getVariableBeanById(destBean.getVariableBeans(), integrityBean.getVariableId());
								if(variableBean == null){
									destBean.getVariableBeans().add(new VariableBean(integrityBean.getVariableId(), null, VBLE_TYPE_INPUT));
								}
								checkConfidentiality(destBean);
							}
							
							String iConfidentiality = (destBean.getInputConfidentiality() != null && destBean.getInputConfidentiality().getAlgorithm() != null)? destBean.getInputConfidentiality().getAlgorithm() : null;
							manager.addActivityVariable(destinationActivity, integrityBean.getVariableId(), TypeType2.INPUT, iConfidentiality);
							if(iConfidentiality != null && setiConf){
								for (ActivityVar activityVar : destinationActivity.getVariable()) {
									ConfidentialityType ct = MappingFactory.eINSTANCE.createConfidentialityType();
									ct.setAlgorithm(iConfidentiality);
									activityVar.setConfidentiality(ct);
								}
							}							
						}
					}	
				}
			}
		}

	}

	private ArrayList<String> findAllServiceTaskNames() {
		ArrayList<String> serviceTaskNames = new ArrayList<String>();
		for (ActivityBean activityBean : activityBeanList) {
			if(activityBean.getType().equals(SERVICE_TASK_TYPE)){
				serviceTaskNames.add(activityBean.getName());
			}			
		}
		return serviceTaskNames;
	}
	
	private ArrayList<String> findAllServiceTaskIds() {
		ArrayList<String> serviceTaskIds = new ArrayList<String>();
		for (ActivityBean activityBean : activityBeanList) {
			if(activityBean.getType().equals(SERVICE_TASK_TYPE)){
				serviceTaskIds.add(activityBean.getId());
			}			
		}
		return serviceTaskIds;
	}
	
	private ActivityBean findActivityById (String id){
		for (ActivityBean activityBean : activityBeanList) {
			if(activityBean.getId().equals(id)){
				return activityBean;
			}
		}
		return null;
	}

	private boolean isTaskNameRepeated() {
		for (ActivityBean activityBean : activityBeanList) {
			for (ActivityBean activityBean2 : activityBeanList) {
				if (!activityBean2.getId().equals(activityBean.getId())
						&& activityBean2.getName().equals(
								activityBean.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	private List<IntegrityBean> cloneIntegrityBeanList(
			List<IntegrityBean> integrityBeanList) {
		List<IntegrityBean> newIntegrityList = new ArrayList<IntegrityBean>();
		for (IntegrityBean integrityBean : integrityBeanList) {
			IntegrityBean integrityBean2 = new IntegrityBean(
					integrityBean.getVariableId(),
					integrityBean.getWithServiceId(), integrityBean.getType(),
					integrityBean.getAlgorithm());
			newIntegrityList.add(integrityBean2);
		}
		return newIntegrityList;
	}
	
	private boolean findPerformerBeanValue(String value, String role){
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getRole().equals(role) && performerBean.getName() != null 
					&& performerBean.getName().equals(value) ){
				return true;
			}
		}
		return false;
	}
	
	private boolean findPerformerBeanRole (String role){
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getRole().equals(role) && performerBean.getName() == null){
				return true;
			}
		}
		return false;
	}
	
	private List<PerformerBean> getPerformerBeanService (){
		List<PerformerBean> performers = new ArrayList<TasksPage.PerformerBean>();
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getType().equals(TypeType.SERVICE.getName())){
				performers.add(performerBean);
			}
		}
		return performers;
	}
	
	private List<PerformerBean> getPerformerBeanHuman (){
		List<PerformerBean> performers = new ArrayList<TasksPage.PerformerBean>();
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getType().equals(TypeType.HUMAN.getName())){
				performers.add(performerBean);
			}
		}
		return performers;
	}
	
	private boolean containsPerformerById (ActivityBean activityBean, String id){		
		for (PerformerBean performerBean : activityBean.getPerformerBeans()) {
			if(performerBean.getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	
	private PerformerBean getPerformerBeanById (String id){
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getId().equals(id)){
				return performerBean;
			}
		}
		return null;
	}

	protected class ActivityBean {
		private String id;
		private String name;
		private String type;
		private List<VariableBean> variableBeans;
		private List<PerformerBean> performerBeans;
		private List<Float> trustworthiness;
		private List<IntegrityBean> integrityList;
		private ConfidentialityBean inputConfidentiality;
		private ConfidentialityBean outputConfidentiality;

		public ActivityBean() {
			this.variableBeans = new ArrayList<TasksPage.VariableBean>();
			this.performerBeans = new ArrayList<TasksPage.PerformerBean>();
			this.trustworthiness = new ArrayList<Float>();
			this.integrityList = new ArrayList<IntegrityBean>();
		}

		public ActivityBean(String name) {
			this.variableBeans = new ArrayList<TasksPage.VariableBean>();
			this.performerBeans = new ArrayList<TasksPage.PerformerBean>();
			this.trustworthiness = new ArrayList<Float>();
			this.integrityList = new ArrayList<IntegrityBean>();
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public List<VariableBean> getVariableBeans() {
			return variableBeans;
		}

		public void setVariableBeans(List<VariableBean> variableBeans) {
			this.variableBeans = variableBeans;
		}
		
		public List<PerformerBean> getPerformerBeans() {
			return performerBeans;
		}

		public void setPerformerBeans(List<PerformerBean> performerBeans) {
			this.performerBeans = performerBeans;
		}

		public List<Float> getTrustworthiness() {
			return trustworthiness;
		}

		public void setTrustworthiness(List<Float> trustworthiness) {
			this.trustworthiness = trustworthiness;
		}

		public List<IntegrityBean> getIntegrityList() {
			return integrityList;
		}

		public void setIntegrityList(List<IntegrityBean> integrityList) {
			this.integrityList = integrityList;
		}

		public ConfidentialityBean getInputConfidentiality() {
			return inputConfidentiality;
		}

		public void setInputConfidentiality(ConfidentialityBean inputConfidentiality) {
			this.inputConfidentiality = inputConfidentiality;
		}

		public ConfidentialityBean getOutputConfidentiality() {
			return outputConfidentiality;
		}

		public void setOutputConfidentiality(ConfidentialityBean outputConfidentiality) {
			this.outputConfidentiality = outputConfidentiality;
		}

	}	
	
	protected class VariableBean{		
		String id;
		String name;
		String type;
		
		public VariableBean() {
		}

		public VariableBean(String id, String name, String type) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}
	
	protected class ConfidentialityBean{
		private String algorithm;
		
		public ConfidentialityBean() {	}

		public ConfidentialityBean(String algorithm) {
			super();
			this.algorithm = algorithm;
		}

		public String getAlgorithm() {
			return algorithm;
		}

		public void setAlgorithm(String algorithm) {
			this.algorithm = algorithm;
		}
	
	}
	
	protected class PerformerBean{
		private String id;
		private String type;
		private String role;
		private String name;
		
		public PerformerBean() {}

		public PerformerBean(String id, String type) {
			super();
			this.id = id;
			this.type = type;
		}

		public PerformerBean(String id, String type, String role, String name) {
			super();
			this.id = id;
			this.type = type;
			this.role = role;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

	protected class IntegrityBean {
		private String variableId;
		private String withServiceId;
		private String type;
		private String algorithm;

		public IntegrityBean() {
		}

		public IntegrityBean(String variableId, String withServiceId,
				String type, String algorithm) {
			super();
			this.variableId = variableId;
			this.withServiceId = withServiceId;
			this.type = type;
			this.algorithm = algorithm;
		}

		public String getVariableId() {
			return variableId;
		}

		public void setVariableId(String variableId) {
			this.variableId = variableId;
		}

		public String getWithServiceId() {
			return withServiceId;
		}

		public void setWithServiceId(String withServiceId) {
			this.withServiceId = withServiceId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getAlgorithm() {
			return algorithm;
		}

		public void setAlgorithm(String algorithm) {
			this.algorithm = algorithm;
		}

	}

	protected class PerformerDialog extends TitleAreaDialog {

		private String taskName;
		private List<PerformerBean> possiblePerformersList;
		private String selectedPerformerId;
		
		private List<Composite> groups; 
		
		protected PerformerDialog(Shell parentShell, String taskName, List<PerformerBean> possiblePerformersList) {
			super(parentShell);
			this.taskName = taskName;
			this.possiblePerformersList = possiblePerformersList;
			this.groups = new ArrayList<Composite>();
		}
		
		@Override
		public void create() {
			super.create();
			setTitle("Multiple performer identified");
			setMessage(
					"The MTM has identified multiple possible performers for the task '"
							+ taskName
							+ ". Please, select the correct performer for the task.",
					WARNING);
		}
		
		
		@Override
		protected Control createDialogArea(Composite parent) {
			parent.setLayout(new GridLayout(1, false));
			
			List<PerformerBean> servicePerformers = getPerformerBeanService();
			List<PerformerBean> humanPerformers = getPerformerBeanHuman();
			
			if(servicePerformers.size() > 0){
				Group serviceGroup = createGroupButton(parent, servicePerformers, "Service Providers");
				this.groups.add(serviceGroup);
			}
			if(humanPerformers.size() > 0){
				Group humanGroup = createGroupButton(parent, humanPerformers, "Human Performers");
				this.groups.add(humanGroup);
			}
			
			Label infoLabel = new Label(parent, SWT.NONE);
			infoLabel.setText("* Performers identified by the MTM");
			return parent;
		}
		
		/**
		 * Adds buttons to this dialog's button bar. 
		 * <p>
		 * This dialog implementation adds standard ok button using the 
		 * <code>createButton</code> framework method.
		 * </p>
		 * 
		 * @param parent
		 *            the button bar composite
		 */
		protected void createButtonsForButtonBar(Composite parent) {
			// create OK and Cancel buttons by default
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
					true);
		}

		public String getSelectedPerformerId() {
			return selectedPerformerId;
		}	
		
		private Group createGroupButton (Composite composite, List<PerformerBean> performers, String textGroup){
			Group group = new Group(composite, SWT.SHADOW_IN);
			group.setLayout(new GridLayout());
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			group.setText(textGroup);
			
			boolean selected = false;
			
			for (PerformerBean performerBean : performers) {
				Button button = new Button(group, SWT.RADIO);
				button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
				String text = "Role: " + performerBean.getRole();
				if(performerBean.getName() != null){
					text = "Name: " + performerBean.getName() + " / " + text;
				}
				if(possiblePerformersList.contains(performerBean)){
					text = text + "*";
					if(!selected){
						button.setSelection(true);
						selected = true;
						selectedPerformerId = performerBean.getId();
					}		
				}
				button.setText(text);
				button.setData(WIDGET_DATA_PERFORMER, performerBean.getId());
				button.addSelectionListener(new SelectionAdapter() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						for (Composite composite : groups) {
							for (Control control : composite.getChildren()) {
								if(control instanceof Button){
									Button button = (Button) control;
									button.setSelection(false);
								}
							}
						}
		
						Button button = (Button) e.widget;
						button.setSelection(true);
						selectedPerformerId = (String) button.getData(WIDGET_DATA_PERFORMER);
					}
					
				});
			}
			group.pack();
			return group;
		}
	
	}
	
	protected class TrustworthinessDialog extends TitleAreaDialog {

		private String taskName;
		private List<Float> possibleTrustList;
		private String trustworthinessLevel;
		
		protected TrustworthinessDialog(Shell parentShell, String taskName, List<Float> possibleTrustList) {
			super(parentShell);
			this.taskName = taskName;
			this.possibleTrustList = possibleTrustList;
		}
		
		@Override
		public void create() {
			super.create();
			setTitle("Multiple trustworthiness requirements identified");
			setMessage(
					"The MTM has identified multiple trustworthiness requirements for the task '"
							+ taskName
							+ "'. Please, select the correct trustworthiness level for the task.",
					WARNING);
		}
		
		
		@Override
		protected Control createDialogArea(Composite parent) {
			parent.setLayout(new GridLayout(1, false));
			
			boolean selected = false;
			for (Float possibleTrustLevel : possibleTrustList) {
				Button button = new Button(parent, SWT.RADIO);
				button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));				
				button.setText(possibleTrustLevel.toString());
				if(!selected){
					button.setSelection(true);
					trustworthinessLevel = button.getText();
					selected = true;
				}
				button.addSelectionListener(new SelectionAdapter() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button button = (Button) e.widget;
						trustworthinessLevel = button.getText();
					}
					
				});
			}	
			
			return parent;
		}
		
		/**
		 * Adds buttons to this dialog's button bar. 
		 * <p>
		 * This dialog implementation adds standard ok button using the 
		 * <code>createButton</code> framework method.
		 * </p>
		 * 
		 * @param parent
		 *            the button bar composite
		 */
		protected void createButtonsForButtonBar(Composite parent) {
			// create OK and Cancel buttons by default
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
					true);
		}

		public String getTrustworthinessLevel() {
			return trustworthinessLevel;
		}
	
	
	}
	
}
