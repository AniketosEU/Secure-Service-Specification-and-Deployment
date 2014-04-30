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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PermissionType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.SoDBoDType;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.mapping.UsertypeType;
import eu.aniketos.mtm.srs.BoDSoDGoalType;
import eu.aniketos.mtm.srs.CommitmentType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.PostType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;
public class SoDBoDPage extends CustomPage {

	private boolean canFinish = false;
	
	private Composite topPanel;
	private ListViewer listViewer;
	
	// List of performer beans
	private List<PerformerBean> performerList;
	
	private List<CommitmentType> commitmentTypeList;
	private List<ActivityBean> activityBeans;
	private List<SoDBoDBean> soDBoDBeans;
	
	private SoDBoDBean selectedSoDBoDBean;
	
	
	public SoDBoDPage(SecReqSpeType srs) {
		super("SoDBoDPage");

		// Set the title & description
		setTitle("SoD / BoD mapping");
		setDescription("Configure SoD/BoD requirements");
				
		commitmentTypeList = SrsManager.getInstance().extractSoDBoDByGoalName(srs);
		activityBeans = new ArrayList<ActivityBean>();
		soDBoDBeans = new ArrayList<SoDBoDBean>();
		performerList = new ArrayList<PerformerBean>();
	}
	
	public boolean isCanFinish() {
		return canFinish;
	}

	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}
	
	@Override
	public boolean canFinish() {
		return isCanFinish();
	}

	@Override
	public void createControl(Composite parent) {		
		topPanel = new Composite(parent, SWT.NONE);
		topPanel.setLayout(new GridLayout(5, true));
		
		// Column 1 - List of SoD/BoD
		listViewer = new ListViewer(topPanel, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		listViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		listViewer.setLabelProvider(new SoDBoDLabelProvider());
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				selectedSoDBoDBean = (SoDBoDBean) ((StructuredSelection)event.getSelection()).getFirstElement();
				createFormControl(selectedSoDBoDBean);
			}
		});	
		
		// Set the control
		setControl(topPanel);
		
		// Set page completion
		setPageComplete(true);
	}
	
	public void createFormControl (SoDBoDBean soDBoDBean){
		// Dispose old children
		if (topPanel.getChildren().length > 1
				&& topPanel.getChildren().length == 2) {
			topPanel.getChildren()[1].dispose();
		}
		
		Composite formComposite = new Composite(topPanel, SWT.BORDER);
		formComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		formComposite.setLayout(new GridLayout(1, false));
		
		Label label = new Label(formComposite, SWT.BOLD);
		label.setText(soDBoDBean.getPropertyType().description);
		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		
		ActivityBean activityBean1 = null;
		ActivityBean activityBean2 = null;			
		for (String taskId : soDBoDBean.getPermissionMap().keySet()){
			if(activityBean1 == null){
				activityBean1 = findActivityBeanById(taskId);
			}
			else{
				activityBean2 = findActivityBeanById(taskId);
			}
		}
		
		// Set Task 1 Form
		createTaskPermissionForm(formComposite, activityBean1, soDBoDBean.getPermissionMap().get(activityBean1.getId()));		
		
		// Set Task 2 Form
		createTaskPermissionForm(formComposite, activityBean2, soDBoDBean.getPermissionMap().get(activityBean2.getId()));		
		
		// Set page completion
		setPageComplete(true);
		
		refreshLayout();
	}
	
	public void createTaskPermissionForm (Composite parent, ActivityBean activityBean, Action action){
		// Set Task Form
		Composite compositeTask = new Composite(parent, SWT.NONE);
		compositeTask.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		compositeTask.setLayout(new GridLayout(1, false));
		
		Group grouptask = new Group(compositeTask, SWT.SHADOW_ETCHED_IN);
		grouptask.setText("'" +activityBean.getName() + "' " + activityBean.getType());
		grouptask.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		grouptask.setLayout(new GridLayout(2, false));
		
		// Set Role Form
		Label lblRole = new Label(grouptask, NONE);
		lblRole.setText("Role");
		
		if(activityBean.getPerformer() != null && activityBean.isPerformerBeforeSelected()){
			// Create disabled Text
			Text text = new Text(grouptask, SWT.BORDER);
			text.setText(getPerformerBeanById(activityBean.getPerformer()).getDescription());
			text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
			text.setEnabled(false);
		}
		else{
			// Combo with performers list to select
			Combo combo = new Combo(grouptask, SWT.DROP_DOWN | SWT.READ_ONLY);
			combo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, true, 1, 1));
			combo.setItems(getPerformerArray(activityBean.getType()));
			combo.setData(activityBean.getId());
			if(activityBean.getPerformer() != null){
				combo.setText(getPerformerBeanById(activityBean.getPerformer()).getDescription());
			}
			combo.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					Combo combo = (Combo) e.widget;
					String selectedPerformerName = combo.getItem(combo.getSelectionIndex());
					// Get performer ID
					String selectedPerformerId = getPerformerIdByPerformerName(selectedPerformerName);					
					// Set performer ID in activityBean
					if(selectedPerformerId != null){
						String activityId = (String) combo.getData();
						ActivityBean activityBean = findActivityBeanById(activityId);
						if(activityBean != null){
							activityBean.setPerformer(selectedPerformerId);
						}
					}
				}
				
			});
		}
		
		// Set Action Form
		Label lblAction = new Label(grouptask, NONE);
		lblAction.setText("Action");
		
		// Service Task
		if(activityBean.getType().equals(UsertypeType.SERVICE_TASK.getName())){
			Text text = new Text(grouptask, SWT.BORDER);
			text.setText(action.getName());
			text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
			text.setEnabled(false);
		}
		// User task
		else{
			// Combo with action list to select
			Combo combo = new Combo(grouptask, SWT.DROP_DOWN | SWT.READ_ONLY);
			combo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, true, 1, 1));
			combo.setItems(getActionArray());
			combo.setText(action.getName());
			combo.setData(activityBean.getId());
			combo.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					Combo combo = (Combo) e.widget;
					// Get action
					String selectedActionName = combo.getItem(combo.getSelectionIndex());
					// Set action in activityBean
					String activityId = (String) combo.getData();
					ActivityBean activityBean = findActivityBeanById(activityId);
					Action selectedAction = getActionByName(selectedActionName);
					if(!activityBean.getPermissionActions().contains(selectedAction)){
						activityBean.getPermissionActions().add(selectedAction);
					}	
					// Set action in SodBod
					selectedSoDBoDBean.getPermissionMap().put(activityId, selectedAction);
				}
				
			});
		}
	}

	@Override
	public void onAppear() {
		super.onAppear();
		refreshList();
		// Dispose old form control
		if (topPanel.getChildren().length > 1
				&& topPanel.getChildren().length == 2) {
			topPanel.getChildren()[1].dispose();
		}
	}
	
	@Override
	protected void pageComplete() {
		updateModel();
	}
	
	/**
	 * Refresh the page to show the last changes.
	 */
	private void refreshLayout() {
		getShell().layout(true, true);
	}
	
	public void refreshList (){
		listViewer.getList().removeAll();
		activityBeans.clear();
		soDBoDBeans.clear();
		performerList.clear();
		
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		MappingManager mappingManager = MappingManager.getInstance();
		
		// load PerformerBean
		initPerformerLists();
		
		for (CommitmentType commitmentType : commitmentTypeList) {		
			BoDSoDGoalType boDSoDGoalType = null;			
			SoDBoDBean soDBoDBean = null;
			if(commitmentType.getPostcondition() != null){
				PostType postType = commitmentType.getPostcondition();
				// BoD
				if(postType.getAchieveInCombination() != null){
					boDSoDGoalType = postType.getAchieveInCombination();
					soDBoDBean = new SoDBoDBean(PropertyType.BoD, commitmentType.getId());
				}
				//SoD
				else if(postType.getNotAchieveInCombination() != null){
					boDSoDGoalType = postType.getNotAchieveInCombination();
					soDBoDBean = new SoDBoDBean(PropertyType.SoD, commitmentType.getId());
				}				
			}
			if(boDSoDGoalType != null){				
				for (GoalType goalType: boDSoDGoalType.getGoalSet().getGoal()) {	
					// Get/Initialize activity
					ActivityType activityType = mappingManager.getActivityByGoalId(mapping, goalType.getId());
					ActivityBean activityBean = findActivityBeanById(activityType.getId());
					if(activityBean == null){
						activityBean = new ActivityBean(activityType.getId(), activityType.getValue(), activityType.getUsertype().getName());
						if(activityType.getParticipant().size() == 1 && activityType.getParticipant().get(0)!= null){
							activityBean.setPerformer(activityType.getParticipant().get(0));
							activityBean.setPerformerBeforeSelected(true);
						}					
						
						// Initialize Permission
						activityBean.getPermissionActions().add(Action.FULL_ACCESS);
						activityBeans.add(activityBean);						
					}
					soDBoDBean.getPermissionMap().put(activityBean.getId(), Action.FULL_ACCESS);
				}
				soDBoDBeans.add(soDBoDBean);
				listViewer.add(soDBoDBean);
			}	
			
		}
		
	}

	
	public List<CommitmentType> getCommitmentTypeList() {
		return commitmentTypeList;
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
	
	private PerformerBean getPerformerBeanById (String id){
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getId().equals(id)){
				return performerBean;
			}
		}
		return null;
	}
	
	public void updateModel(){
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		MappingManager manager = MappingManager.getInstance();
		
		// Reset SoDBoD and Permissions
		manager.resetSoDBoDList(mapping);
		for (ActivityBean activityBean : activityBeans) {
			ActivityType activityType = manager.findActivityById(mapping, activityBean.getId());
			manager.resetActivityPermission(activityType);
		}
		
		// Save SoDBoDBeans into mapping model
		for (SoDBoDBean soDBoDBean : soDBoDBeans) {
			// Check if it is completed
			boolean isCompleted = true;
			for (String taskId : soDBoDBean.getPermissionMap().keySet()) {
				Action action = soDBoDBean.getPermissionMap().get(taskId);
				ActivityBean activityBean = findActivityBeanById(taskId);
				if(action == null || activityBean.getPerformer() == null){
					isCompleted = false;
				}
			}
			if(isCompleted){
				List<PermissionType> permissionTypes = new ArrayList<PermissionType>();
				// Create Permission in the 2 ActivityTypes
				for (String taskId : soDBoDBean.getPermissionMap().keySet()) {
					Action action = soDBoDBean.getPermissionMap().get(taskId);
					ActivityBean activityBean = findActivityBeanById(taskId);
										
					ActivityType activityType = manager.findActivityById(mapping, activityBean.getId());
					PermissionType permissionType = null;
					for (PermissionType existingPermissionType : activityType.getPermission()) {
						if(existingPermissionType.getRole().equals(activityBean.getPerformer())
								&& existingPermissionType.getAction().equals(action.getName())){
							permissionType = existingPermissionType;
						}
					}
					
					// Create Permission in the 2 ActivityTypes of the mapping if they don't exist
					if(permissionType == null){
						permissionType = manager.createPermission(activityBean.getPerformer(), action.getName());
						activityType.getPermission().add(permissionType);
					}
					permissionTypes.add(permissionType);					
				}				
				
				// Create SoDBoD in mapping
				SoDBoDType soDBoDType = manager.createSoDBoD(soDBoDBean.getPropertyType().getName(), soDBoDBean.getCommitmentID());
				for (PermissionType permissionType : permissionTypes) {
					soDBoDType.getPermission().add(permissionType.getId());
				}
				// Save SoDBoD in mapping
				mapping.getSoDBoDProperties().add(soDBoDType);
			}
		}		
		
	}
	
	private ActivityBean findActivityBeanById (String id){
		for (ActivityBean activityBean : activityBeans) {
			if(activityBean.getId().equals(id)){
				return activityBean;
			}
		}
		return null;
	}
	
	private String[] getPerformerArray (String type){
		List<String> performers = new ArrayList<String>();		
		for (PerformerBean	performerBean : performerList){
			if(type.equals(UsertypeType.SERVICE_TASK.getName())){
				if(performerBean.getType().equals(TypeType.SERVICE.getName())){
					performers.add(performerBean.getDescription());
				}
			}
			else if(type.equals(UsertypeType.USER_TASK.getName())){
				if(performerBean.getType().equals(TypeType.HUMAN.getName())){
					performers.add(performerBean.getDescription());
				}				
			}				
		}
		
		String[] performerArr = new String[performers.size()];
		int i = 0; 
		for (String performerDescription : performers) {
			performerArr[i++] = performerDescription;
		}
		return performerArr;
	}
	
	private String[] getActionArray (){
		Action[] actions = Action.values();
		String[] actionArr = new String[actions.length];
		for (int i = 0; i < actions.length; i++) {
			actionArr[i] = actions[i].getName();
		}
		return actionArr;
	}
	
	private String getPerformerIdByPerformerName (String name){
		for (PerformerBean performerBean : performerList) {
			if(performerBean.getDescription().equals(name)){
				return performerBean.getId();
			}
		}
	
		return null;
	}
	
	private Action getActionByName (String name){
		if(Action.FULL_ACCESS.getName().equals(name)){
			return Action.FULL_ACCESS;
		}
		else if (Action.COMPLETE.getName().equals(name)){
			return Action.COMPLETE;
		}
		else if (Action.CLAIM.getName().equals(name)){
			return Action.CLAIM;
		}
		else if (Action.DELEGATE.getName().equals(name)){
			return Action.DELEGATE;
		}
		
		return null;
	}
	
	private class SoDBoDLabelProvider extends LabelProvider {
		
		public String getText(Object element) {
			if (element instanceof SoDBoDBean) {
				return getTextRepresentation((SoDBoDBean) element);
			}
			else {
				return "Unsupported object";
			}
		}
		
		private String getTextRepresentation(SoDBoDBean soDBoDBean) {
			String text = "[" + soDBoDBean.getPropertyType().getName();
			text += "] ";
			
			boolean isFirst = true;
			for (String taskId : soDBoDBean.getPermissionMap().keySet()) {
				ActivityBean activityBean = findActivityBeanById(taskId);
				if(isFirst){
					text += activityBean.getName();
					isFirst = false;				
				}
				else{
					text += ", " + activityBean.getName();
				}
			}			
			
			return text;			
		}

	}
	
	//------------ MODEL ----------------------------------
	
	protected enum Action {
		FULL_ACCESS ("Full Access"), 
		COMPLETE ("Complete"), 
		DELEGATE ("Delegate"), 
		CLAIM ("Claim");
		
		private final String name;
		
		private Action(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}				
	};
	
	protected enum PropertyType {
		SoD ("SoD", "Separation of Duty"), 
		BoD ("BoD", "Binding of Duty");
		
		private final String name;
		private final String description;
		private PropertyType(String name, String description) {
			this.name = name;
			this.description = description;
		}
		
		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}			
	};
	
	protected class ActivityBean {			
		private String id;
		private String name;
		private String type;
		private String performer; // performer Id
		private boolean performerBeforeSelected;
		private List<Action> permissionActions = new ArrayList<Action>();
		
		public ActivityBean(String id, String name) {
			super();
			this.id = id;
			this.name = name;
			this.performerBeforeSelected = false;
		}
		
		public ActivityBean(String id, String name, String type) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.performerBeforeSelected = false;
		}

		public ActivityBean(String id, String name, String type,
				String performer) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.performer = performer;
			this.performerBeforeSelected = false;
		}

		public boolean isPerformerBeforeSelected() {
			return performerBeforeSelected;
		}

		public void setPerformerBeforeSelected(boolean performerBeforeSelected) {
			this.performerBeforeSelected = performerBeforeSelected;
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
		public String getPerformer() {
			return performer;
		}
		public void setPerformer(String performer) {
			this.performer = performer;
		}
		public List<Action> getPermissionActions() {
			return permissionActions;
		}

		public void setPermissionActions(List<Action> permissionActions) {
			this.permissionActions = permissionActions;
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
		
		public String getDescription (){
			String text = getRole();
			if(getName() != null){
				text = text + " (Performer Name: " + getName() + ")";
			}
			return text;
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
	
	protected class SoDBoDBean{
		private PropertyType propertyType;
		private Map<String, Action> permissionMap = new HashMap<String, Action>(); // <task Id, Action>
		private String commitmentID;

		public SoDBoDBean() {
		}
		
		public SoDBoDBean(PropertyType propertyType) {
			super();
			this.propertyType = propertyType;
		}
		
		public SoDBoDBean(PropertyType propertyType, String commitmentID) {
			super();
			this.propertyType = propertyType;
			this.commitmentID = commitmentID;
		}

		public PropertyType getPropertyType() {
			return propertyType;
		}

		public void setPropertyType(PropertyType propertyType) {
			this.propertyType = propertyType;
		}
		
		public Map<String, Action> getPermissionMap() {
			return permissionMap;
		}

		public void setPermissionMap(Map<String, Action> permissionMap) {
			this.permissionMap = permissionMap;
		}

		public String getCommitmentID() {
			return commitmentID;
		}

		public void setCommitmentID(String commitmentID) {
			this.commitmentID = commitmentID;
		}
		
	}

}
