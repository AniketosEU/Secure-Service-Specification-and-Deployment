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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import eu.aniketos.mtm.Activator;
import eu.aniketos.mtm.idm.client.IdMClient;
import eu.aniketos.mtm.idm.client.implementation.IdMClientImplementation;
import eu.aniketos.mtm.mapping.BPPType;
import eu.aniketos.mtm.mapping.BPRType;
import eu.aniketos.mtm.mapping.IsaType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.SRAType;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.srs.AgentType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;

/**
 * 
 * Page used to establish the correspondences between SRS agents and BPMN participants (1:n relationship).
 *
 */
public class NewPerformersPage extends CustomPage {
	
	private static final String PREFIX_AGENT = "agent_";
	private static final String PREFIX_ROLE = "role_";
	public static final String PERFORMERTYPE_SERVICE = "Service Provider";
	public static final String PERFORMERTYPE_HUMAN = "Human Performer";

	// Input SRS agents
	private ArrayList<AgentType> agentList;
	
	// List of composites, every of which contain all the participants that match an agent
	private ArrayList<Composite> activitiCompositeMainList;
	
	// List of types
	private ArrayList<ArrayList<Combo>> performerTypeList;
	
	// List of roles
	private ArrayList<ArrayList<Combo>> performerRoleList;
	
	// List of participant names
	private ArrayList<ArrayList<Combo>> performerValueList;

	// List of buttons for removing a participant
	private ArrayList<ArrayList<Button>> removeButtonList;

	// List of buttons for adding a new participant to an agent
	private ArrayList<Button> addButtonList;
	
	// Main scrollable composite
	private ScrolledComposite scrollComposite;
	
	private IdMClient idMClient;
	private String[] humanRoles = {};
	private String[] serviceRoles = {};
	private String[] roleTypes = {PERFORMERTYPE_SERVICE, PERFORMERTYPE_HUMAN};

	/**
	 * Constructor.
	 * @param srs The SecReqSpeType root SRS element to be transformed.
	 */
	public NewPerformersPage(SecReqSpeType srs) {
		super("NewPerformersPage");
		setTitle("Performers mapping");
		setDescription("Map SRS Agents to BPMN Performers");
		
		agentList = SrsManager.getInstance().extractAgentList(srs);
		int sizeList = agentList.size();

		activitiCompositeMainList = new ArrayList<Composite>(sizeList);
		
		performerTypeList = new ArrayList<ArrayList<Combo>>(sizeList);
		performerRoleList = new ArrayList<ArrayList<Combo>>(sizeList);
		performerValueList = new ArrayList<ArrayList<Combo>>(sizeList);

		removeButtonList = new ArrayList<ArrayList<Button>>(sizeList);

		addButtonList = new ArrayList<Button>(sizeList);
		
		// Get MTM preference for IDM
		String pathIdM = Activator.getDefault().getPreferenceStore().getString("IdM_file_path");
		idMClient = new IdMClientImplementation(pathIdM);
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

		// Main control skeleton for the agent/participant correspondence
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
	 * Creates the main control skeleton for the agent/participant correspondence.
	 * @param composite The parent composite
	 */
	private void createMainControls(Composite composite) {
		if(isEmpty()) {
			// No agents found
			Label emptyLabel = new Label(composite, SWT.NULL);
			emptyLabel.setText("No SRS Agents found");
			return;
		}
		
		GridData gd;
		
		// Column titles
		Label agentsLabel = new Label(composite, SWT.NULL);
		agentsLabel.setText("SRS Agents");
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		Label activitiLabel = new Label(composite, SWT.NULL);
		activitiLabel.setText("ACTIVITI Performers");
		activitiLabel.setLayoutData(gd);
		
		performerTypeList.clear();
		performerRoleList.clear();
		performerValueList.clear();

		// For every agent...
		for (int i = 0; i < agentList.size(); i++) {
			// Fill agent description labels
			AgentType agent = agentList.get(i);
			String agentValue = agent.getValue().trim();
			String agentString = agentValue;
			Label agentIdLabel = new Label(composite, SWT.NULL);
			agentIdLabel.setText(agentString);

			Composite compositeActiviti = new Composite(composite, SWT.BORDER);
			compositeActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			compositeActiviti.setLayout(new GridLayout(1, false));

			Composite compositeMainActiviti = new Composite(compositeActiviti, SWT.NULL);
			compositeMainActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			compositeMainActiviti.setLayout(new GridLayout(1, false));
			activitiCompositeMainList.add(compositeMainActiviti);

			// Add the first participant controls for this agent
			addPerformerRecord(agentValue, i);

			// Button for adding a new participant
			Button addButton = new Button(compositeActiviti, SWT.NONE);
			addButton.setText("Add new");
			addButtonList.add(addButton);
		}
		onAppear();
	}

	/**
	 * Adds the controls needed for one new participant.
	 * @param performerValue The suggested name of the participant.
	 * @param index The index of the corresponding agent.
	 */
	private void addPerformerRecord(String performerValue, int index) {
		if (index >= agentList.size()) {
			return;
		}
		// Get a reference to the composite that contain all the participants that match an agent
		Composite composite = activitiCompositeMainList.get(index);

		Composite compositeSingleActiviti = new Composite(composite, SWT.NULL);
		compositeSingleActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		compositeSingleActiviti.setLayout( new GridLayout(4, false));

		Composite typeComboComposite = new Composite(compositeSingleActiviti, SWT.NULL);
		typeComboComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		typeComboComposite.setLayout(new GridLayout(2, false));
		
		// Participant type
		Label typeLabel = new Label(typeComboComposite, SWT.NULL);
		typeLabel.setText("Performer type");
		Combo typeCombo = new Combo(typeComboComposite, SWT.BORDER | SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		typeCombo.setItems(this.roleTypes);
		typeCombo.setData(index+"");
		typeCombo.select(0);
		typeCombo.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateRoleCombo (e.widget);
			}
		});
		
		
		Composite roleComboComposite = new Composite(compositeSingleActiviti, SWT.NULL);		
		roleComboComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		roleComboComposite.setLayout(new GridLayout(2, false));
		
		// Performer role
		Label performerRoleLabel = new Label(roleComboComposite, SWT.NULL);
		performerRoleLabel.setText("Role name");
		Combo roleCombo = new Combo(roleComboComposite, SWT.BORDER | SWT.READ_ONLY);
		roleCombo.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false));
		roleCombo.setData(index+"");
		roleCombo.setItems(serviceRoles);
		roleCombo.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateAgentCombo (e.widget);
			}
		});
		
		Composite agentComboComposite = new Composite(compositeSingleActiviti, SWT.NULL);		
		agentComboComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		agentComboComposite.setLayout(new GridLayout(2, false));
		
		// Performer agent value
		Label performerValueLabel = new Label(agentComboComposite, SWT.NULL);
		performerValueLabel.setText("Agent name");
		Combo agentCombo = new Combo(agentComboComposite, SWT.BORDER | SWT.READ_ONLY);
		agentCombo.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false));
		agentCombo.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(isReady());
			}
		});
		
		// Add the participant combos to performerTypeList, performerRoleList and performerValueList
		ArrayList<Combo> performerTypeSubList = null;
		ArrayList<Combo> performerRoleSubList = null;
		ArrayList<Combo> performerValueSubList = null;
		if (index >= performerValueList.size()) {
			// First participant for an agent
			performerTypeSubList = new ArrayList<Combo>(1);
			performerRoleSubList = new ArrayList<Combo>(1);
			performerValueSubList = new ArrayList<Combo>(1);
			performerTypeList.add(performerTypeSubList);
			performerRoleList.add(performerRoleSubList);
			performerValueList.add(performerValueSubList);
		} else {
			performerTypeSubList = performerTypeList.get(index);
			performerRoleSubList = performerRoleList.get(index);
			performerValueSubList = performerValueList.get(index);
		}
		performerTypeSubList.add(typeCombo);
		performerRoleSubList.add(roleCombo);
		performerValueSubList.add(agentCombo);
		
		// Create a button to remove this participant row
		Button removeButton = new Button(compositeSingleActiviti, SWT.NONE);
		removeButton.setText("Remove");
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				int index = -1;
				int subIndex = -1;
				for(int i = 0; i < removeButtonList.size(); i++) {
					ArrayList<Button> buttonList = removeButtonList.get(i);
					subIndex = buttonList.indexOf(e.widget);
					if(subIndex >= 0) {
						index = i;
						break;
					}
				}
				if(index >= 0) {
					removePerformerRecord(index, subIndex);
				}
			}
		});
		// Add the remove button to removeButtonList
		ArrayList<Button> removeSubList = null;
		if (index >= removeButtonList.size()) {
			// First participant for an agent
			removeSubList = new ArrayList<Button>(1);
			removeButtonList.add(removeSubList);
		} else {
			removeSubList = removeButtonList.get(index);
		}
		removeSubList.add(removeButton);
		
		// Enable the remove buttons only where there is more than one participant for an agent
		updateRemoveButtons(index);

		// Refresh the screen
		refresh();
		// Declare the page as complete when the form is full-filled
		setPageComplete(isReady());
	}

	private void updateRoleCombo(Widget widget) {
		if(widget instanceof Combo){
			Combo typeCombo = (Combo) widget;
			String index = (String) typeCombo.getData();
			int i = new Integer(index).intValue();
			ArrayList<Combo> performerTypeSubList = performerTypeList.get(i);
			int subindex = performerTypeSubList.indexOf(typeCombo);
			if(subindex >= 0) {
				Combo performerRoleCombo = performerRoleList.get(i).get(subindex);
				performerRoleCombo.clearSelection();
				String selectedType = typeCombo.getText();
				if(selectedType.equals(PERFORMERTYPE_SERVICE)){					
					performerRoleCombo.setItems(serviceRoles);
				}
				else if (selectedType.equals(PERFORMERTYPE_HUMAN)){
					performerRoleCombo.setItems(humanRoles);
				}
			}		
		}		
	}
	
	private void updateAgentCombo (Widget widget){
		if(widget instanceof Combo){
			Combo roleCombo = (Combo) widget;
			String index = (String) roleCombo.getData();
			int i = new Integer(index).intValue();
			ArrayList<Combo> performerRoleSubList = performerRoleList.get(i);
			int subindex = performerRoleSubList.indexOf(roleCombo);
			if(subindex >= 0) {
				Combo performerTypeCombo = performerTypeList.get(i).get(subindex);
				String selectedType = performerTypeCombo.getText();
				Combo performerAgentCombo = performerValueList.get(i).get(subindex);
				performerAgentCombo.clearSelection();
				String selectedRole = roleCombo.getText();
				String agents = null;
				if(selectedType.equals(PERFORMERTYPE_SERVICE)){
					agents = idMClient.getMembersOfServiceGroup(selectedRole);
				}
				else if(selectedType.equals(PERFORMERTYPE_HUMAN)){
					agents = idMClient.getMembersOfHumanGroup(selectedRole);
				}
				performerAgentCombo.setItems(splitSringToList(agents));
			}
		}
	}
	
	/**
	 * Removes one participant's controls.
	 * @param index The index of the agent it belongs to.
	 * @param subIndex The index of the participant for this agent.
	 */
	private void removePerformerRecord(int index, int subIndex) {
		if (index >= agentList.size()) {
			return;
		}
		
		// Remove the references to the controls from the member lists
		performerValueList.get(index).remove(subIndex);
		performerTypeList.get(index).remove(subIndex);
		performerRoleList.get(index).remove(subIndex);

		removeButtonList.get(index).remove(subIndex);
		
		// Remove the parent composite from the page
		Composite mainComposite = activitiCompositeMainList.get(index);
		Composite composite = (Composite)mainComposite.getChildren()[subIndex];
		composite.dispose();
		
		// Enable the remove buttons only where there is more than one participant for an agent
		updateRemoveButtons(index);
		
		// Refresh the screen
		refresh();
		// Declare the page as complete when the form is full-filled
		setPageComplete(isReady());
	}
	
	@Override
	public void onAppear() {
		super.onAppear();
		refreshList();
		updateControls();		
		setPageComplete(isReady());
	}
	
	public void refreshList (){
		String humanList = idMClient.getGroupsListOfHuman();
		humanRoles = splitSringToList(humanList);
		
		String serviceList = idMClient.getGroupsListOfService();
		serviceRoles = splitSringToList(serviceList);
	}
	
	private String[] splitSringToList(String s){
		String[] array = s.split(",");
		return array;
	}
	
	private void updateControls(){	
		for (ArrayList<Combo> comboList : performerValueList) {
			int index = performerValueList.indexOf(comboList);
			for (Combo combo : comboList) {
				int subindex = comboList.indexOf(combo);
				int selectionIndex = combo.getSelectionIndex();
				Combo typeCombo = this.performerTypeList.get(index).get(subindex);
				Combo roleCombo = performerRoleList.get(index).get(subindex);
				String selectedType = null;
				if(selectionIndex != -1){
					selectedType = typeCombo.getText();
					String selectedRole = roleCombo.getText();
					selectionIndex = findRoleIndex(selectedRole, selectedType);
					if(selectedType.equals(PERFORMERTYPE_SERVICE)){
						roleCombo.setItems(serviceRoles);
					}
					else if(selectedType.equals(PERFORMERTYPE_HUMAN)){
						roleCombo.setItems(humanRoles);
					}
				}	
				else{
					roleCombo.setItems(serviceRoles);
				}				
				roleCombo.select(selectionIndex);
			}
		}
	}
	
	private int findRoleIndex(String role, String type){
		if(type.equals(PERFORMERTYPE_SERVICE)){
			for (int i = 0; i < serviceRoles.length; i++) {
				String serviceRole = serviceRoles[i];
				if(serviceRole.equals(role)){
					return i;
				}
			}
		}
		else if (type.equals(PERFORMERTYPE_HUMAN)){
			for (int i = 0; i < humanRoles.length; i++) {
				String humanRole = humanRoles[i];
				if(humanRole.equals(role)){
					return i;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Refresh the page to show the last changes.
	 */
	private void refresh() {
		Shell shell = getShell();
		shell.layout(true, true);
		updateScroll();
	}
	
	/**
	 * Adds listeners to controls.
	 */
	private void addListeners() {
		addAgentListeners();
	}
	
	/**
	 * Adds the suitable listener to every Add button.
	 */
	private void addAgentListeners() {
		for (int i = 0; i < addButtonList.size(); i++) {
			Button addButton = addButtonList.get(i);
			addButton.addSelectionListener(new AddSelectionAdapter(i));
		}
	}
	
	/**
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return agentList.size() == 0;
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
		for (ArrayList<Combo> array : performerValueList) {
			for (Combo combo : array) {
				if (!isComboNonEmpty(combo)) {
					setErrorMessage("There are empty fields.");
					return false;
				}
				else{
					setErrorMessage(null);
				}
			}
		}
		return true;
	}
	
	/**
	 * Updates the enabled/disabled state of all Remove buttons.
	 */
	private void updateAllRemoveButtons() {
		for(int i = 0; i < removeButtonList.size(); i++) {
			updateRemoveButtons(i);
		}
	}
	
	/**
	 * Sets Remove buttons enabled only when there is more than one participant for one agent.
	 * @param index The index of the agent.
	 */
	private void updateRemoveButtons(int index) {
		ArrayList<Button> buttonList = removeButtonList.get(index);
		boolean enabled = false;
		if(buttonList.size() > 1) {
			enabled = true;
		}
		for(Button button : buttonList) {
			button.setEnabled(enabled);
		}
	}
	
	/**
	 * Updates the main scrollbar.
	 */
	private void updateScroll() {
		Rectangle r = scrollComposite.getClientArea();
		scrollComposite.setMinSize(scrollComposite.getChildren()[0].computeSize(r.width, SWT.DEFAULT));
	}
	
	/**
	 * Updates the mapping model based on the page form.
	 */
	private void updateModel() {
		int size = agentList.size();
		if(size > 0) {
			MappingType mapping = ((Srs2ActivitiWizard)getWizard()).getMapping();
			MappingManager manager = MappingManager.getInstance();
			// Clear the existing is-a relationships
			manager.resetIsAList(mapping);
						
			// For every agent...
			for (int i = 0; i < size; i++) {
				AgentType agent = agentList.get(i);
				// Create the agent mapping element
				SRAType sra = manager.createSRAgent(agent.getId().toString(), agent.getValue().trim());
				
				ArrayList<Combo> performerValueSublist = performerValueList.get(i);
				int subSize = performerValueSublist.size();
				// For every participant binded to this agent...
				for (int j = 0; j < subSize; j++) {
					Combo valueCombo = performerValueSublist.get(j);
					// Get role type
					Combo typeCombo = performerTypeList.get(i).get(j);	
					TypeType roleType = null;
					if(typeCombo.getText().equals(PERFORMERTYPE_SERVICE)){
						roleType = TypeType.SERVICE;
					}
					else if (typeCombo.getText().equals(PERFORMERTYPE_HUMAN)){
						roleType = TypeType.HUMAN;
					}
					// Get role
					Combo roleCombo = performerRoleList.get(i).get(j);	
					
					BPPType bpp = null;
					BPRType bprType = null;
					IsaType isaType = findRoleAGent(roleType, roleCombo.getText().trim(), valueCombo.getText().trim());
					if(isaType == null){
						// Create the participant mapping element
						String agentId = PREFIX_AGENT + agent.getId() + "_" + j;
						bpp = manager.createBPPart(agentId, valueCombo.getText().trim(), roleType);
						String roleId = PREFIX_ROLE + agent.getId() + "_" + j;
						bprType = manager.createBPRole(roleId, roleCombo.getText().trim(), roleType);
					}
					else{
						// Clone the existing one
						bpp = manager.createBPPart(isaType.getBPPart().get(0).getId(), valueCombo.getText().trim(), roleType);
						bprType = manager.createBPRole(isaType.getBPRole().get(0).getId(), roleCombo.getText().trim(), roleType);
					}			
					
					// Create and add the is-a relationship
					IsaType isa = manager.createIsA(sra, bpp, bprType);
					manager.addIsA(mapping, isa);
				}
			}
		}
	}

	private IsaType findRoleAGent(TypeType roleType, String role, String agent) {
		MappingType mapping = ((Srs2ActivitiWizard)getWizard()).getMapping();
		for (IsaType isaType : mapping.getIsA()) {
			BPPType bppType = isaType.getBPPart().get(0);
			if(bppType.getType().equals(roleType) && bppType.getValue().equals(agent)){
				BPRType bprType = isaType.getBPRole().get(0);
				if(bprType.getType().equals(roleType) && bprType.getValue().equals(role)){
					return isaType;
				}
			}
		}
		return null;		
	}

	/**
	 * 
	 * Adapter for Add button.
	 * 
	 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
	 *
	 */
	class AddSelectionAdapter extends SelectionAdapter {
		int index;

		/**
		 * Constructor.
		 * @param index The index of the agent.
		 */
		public AddSelectionAdapter(int index) {
			this.index = index;
		}

		/**
		 * Adds the controls necessary for the new participant.
		 * Controls are empty by default.
		 */
		@Override
		public void widgetSelected(final SelectionEvent e) {
			AgentType agent = agentList.get(index);
			String agentValue = agent.getValue().trim();
			addPerformerRecord(agentValue, index);
		}
	}

}
