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
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.mapping.PlaysType;
import eu.aniketos.mtm.mapping.SRRType;
import eu.aniketos.mtm.mapping.TypeType;
import eu.aniketos.mtm.srs.RoleType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;

/**
 * 
 * Page used to establish the correspondences between SRS roles and BPMN participants (1:n relationship).
 *
 */
public class NewPerformersRolePage extends CustomPage {
	
	private static final String PREFIX = "role_";
	public static final String PERFORMERTYPE_SERVICE = "Service Provider";
	public static final String PERFORMERTYPE_HUMAN = "Human Performer";

	// Input SRS roles
	private ArrayList<RoleType> roleList;
	
	// List of composites, every of which contain all the participants that match a role
	private ArrayList<Composite> activitiCompositeMainList;

	// List of types
	private ArrayList<ArrayList<Combo>> performerTypeList;
	
	// List of participant names
	private ArrayList<ArrayList<Combo>> performerValueList;

	// List of buttons for removing a participant
	private ArrayList<ArrayList<Button>> removeButtonList;

	// List of buttons for adding a new participant to a role
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
	public NewPerformersRolePage(SecReqSpeType srs) {
		super("NewPerformersRolePage");
		setTitle("Performers mapping");
		setDescription("Map SRS Roles to BPMN Performers");
		
		roleList = SrsManager.getInstance().extractRoleList(srs);
		int sizeList = roleList.size();

		activitiCompositeMainList = new ArrayList<Composite>(sizeList);
		
		performerTypeList = new ArrayList<ArrayList<Combo>>(sizeList);
		
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

		// Main control skeleton for the role/participant correspondence
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
	 * Creates the main control skeleton for the role/participant correspondence.
	 * @param composite The parent composite
	 */
	private void createMainControls(Composite composite) {
		if(roleList.size() == 0) {
			// No roles found
			Label emptyLabel = new Label(composite, SWT.NULL);
			emptyLabel.setText("No SRS Roles found");
			return;
		}
		
		GridData gd;
		
		// Column titles
		Label rolesLabel = new Label(composite, SWT.NULL);
		rolesLabel.setText("SRS Roles");
		gd = new GridData();
		gd.horizontalAlignment = SWT.FILL;
		Label activitiLabel = new Label(composite, SWT.NULL);
		activitiLabel.setText("ACTIVITI Performers");
		activitiLabel.setLayoutData(gd);
		
		performerValueList.clear();
		performerTypeList.clear();
				
		// For every role...
		for (int i = 0; i < roleList.size(); i++) {
			// Fill role description labels
			RoleType role = roleList.get(i);
			String roleValue = role.getValue().trim();
			String roleString = roleValue;
			Label roleIdLabel = new Label(composite, SWT.NULL);
			roleIdLabel.setText(roleString);

			Composite compositeActiviti = new Composite(composite, SWT.BORDER);
			compositeActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			compositeActiviti.setLayout(new GridLayout(1, false));

			Composite compositeMainActiviti = new Composite(compositeActiviti,SWT.NULL);
			compositeMainActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			compositeMainActiviti.setLayout(new GridLayout(1, false));
			activitiCompositeMainList.add(compositeMainActiviti);

			// Add the first participant controls for this role
			addPerformerRecord(i);

			// Button for adding a new participant
			Button addButton = new Button(compositeActiviti, SWT.NONE);
			addButton.setText("Add new");
			addButtonList.add(addButton);
		}
	}

	/**
	 * Adds the controls needed for one new participant.
	 * @param performerValue The suggested name of the participant.
	 * @param index The index of the corresponding role.
	 */
	private void addPerformerRecord(int index) {
		if (index >= roleList.size()) {
			return;
		}
		// Get a reference to the composite that contain all the participants that match a role
		Composite composite = activitiCompositeMainList.get(index);

		Composite compositeSingleActiviti = new Composite(composite, SWT.NULL);
		compositeSingleActiviti.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		compositeSingleActiviti.setLayout( new GridLayout(3, false));

		Composite typeComboComposite = new Composite(compositeSingleActiviti, SWT.NULL);
		typeComboComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		typeComboComposite.setLayout(new GridLayout(2, false));

		// Performer type
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
		Label performerValueLabel = new Label(roleComboComposite, SWT.NULL);
		performerValueLabel.setText("Role name");
		Combo combo = new Combo(roleComboComposite, SWT.BORDER | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, false));
		combo.setItems(serviceRoles);
		combo.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setPageComplete(isReady());
			}
		});
		
		// Add the participant value text control to performerValueList
		ArrayList<Combo> performerValueSubList = null;
		ArrayList<Combo> performerTypeSubList = null;
		if (index >= performerValueList.size()) {
			// First participant for a role
			performerValueSubList = new ArrayList<Combo>(1);
			performerTypeSubList = new ArrayList<Combo>(1);
			performerValueList.add(performerValueSubList);
			performerTypeList.add(performerTypeSubList);
		} else {
			performerValueSubList = performerValueList.get(index);
			performerTypeSubList = performerTypeList.get(index);
		}
		performerValueSubList.add(combo);
		performerTypeSubList.add(typeCombo);
		
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
			// First participant for a role
			removeSubList = new ArrayList<Button>(1);
			removeButtonList.add(removeSubList);
		} else {
			removeSubList = removeButtonList.get(index);
		}
		removeSubList.add(removeButton);
		
		// Enable the remove buttons only where there is more than one participant for a role
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
				Combo performerRoleCombo = performerValueList.get(i).get(subindex);
				performerRoleCombo.clearSelection();
				String selectedRole = typeCombo.getText();
				if(selectedRole.equals(PERFORMERTYPE_SERVICE)){					
					performerRoleCombo.setItems(serviceRoles);
				}
				else if (selectedRole.equals(PERFORMERTYPE_HUMAN)){
					performerRoleCombo.setItems(humanRoles);
				}
			}		
		}
		
	}
	
	/**
	 * Removes one participant's controls.
	 * @param index The index of the roles it belongs to.
	 * @param subIndex The index of the participant for this role.
	 */
	private void removePerformerRecord(int index, int subIndex) {
		if (index >= roleList.size()) {
			return;
		}
		
		// Remove the references to the controls from the member lists
		performerValueList.get(index).remove(subIndex);
		removeButtonList.get(index).remove(subIndex);
		performerTypeList.get(index).remove(subIndex);
		
		// Remove the parent composite from the page
		Composite mainComposite = activitiCompositeMainList.get(index);
		Composite composite = (Composite)mainComposite.getChildren()[subIndex];
		composite.dispose();
		
		// Enable the remove buttons only where there is more than one participant for a role
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
				String selectedType = null;
				if(selectionIndex != -1){
					Combo typeCombo = this.performerTypeList.get(index).get(subindex);
					selectedType = typeCombo.getText();
					String selectedRole = combo.getItem(selectionIndex);
					selectionIndex = findRoleIndex(selectedRole, selectedType);
					if(selectedType.equals(PERFORMERTYPE_SERVICE)){
						combo.setItems(serviceRoles);
					}
					else if(selectedType.equals(PERFORMERTYPE_HUMAN)){
						combo.setItems(humanRoles);
					}
				}	
				else{
					combo.setItems(serviceRoles);
				}				
				combo.select(selectionIndex);
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
		addRoleListeners();
	}
	
	/**
	 * Adds the suitable listener to every Add button.
	 */
	private void addRoleListeners() {
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
		return roleList.size() == 0;
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
	 * Sets Remove buttons enabled only when there is more than one participant for one role.
	 * @param index The index of the role.
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
		int size = roleList.size();
		if(size > 0) {
			MappingType mapping = ((Srs2ActivitiWizard)getWizard()).getMapping();
			MappingManager manager = MappingManager.getInstance();
			// Clear the existing plays relationships
			manager.resetPlaysList(mapping);
			List<BPPType> bppList = new ArrayList<BPPType>();
			// For every role...
			for (int i = 0; i < size; i++) {
				RoleType role = roleList.get(i);
				// Create the role mapping element
				SRRType srr = manager.createSRRole(role.getId().toString(), role.getValue().trim());
				
				ArrayList<Combo> performerValueSublist = performerValueList.get(i);
				int subSize = performerValueSublist.size();
				
				// For every participant binded to this role...
				for (int j = 0; j < subSize; j++) {
					Combo valueCombo = performerValueSublist.get(j);
					// Get role type
					Combo typeCombo = performerTypeList.get(i).get(j);					
					// Create the participant mapping element
					String performerId = PREFIX + role.getId() + "_" + j;	
					TypeType roleType = null;
					if(typeCombo.getText().equals(PERFORMERTYPE_SERVICE)){
						roleType = TypeType.SERVICE;
					}
					else if (typeCombo.getText().equals(PERFORMERTYPE_HUMAN)){
						roleType = TypeType.HUMAN;
					}
					BPPType bpp = null;
					for (BPPType bppType : bppList) {
						if(bppType.getType().equals(roleType) && bppType.getValue().equals(valueCombo.getText().trim())){
							// Clone Bpp
							bpp = manager.createBPPart(bppType.getId(),valueCombo.getText().trim(), roleType);
						}
					}
					if(bpp == null){
						bpp = manager.createBPPart(performerId,valueCombo.getText().trim(), roleType);
						bppList.add(bpp);
					}					
					
					// Create and add the plays relationship
					PlaysType plays = manager.createPlays(srr, bpp);
					manager.addPlays(mapping, plays);
				}
			}
		}
	}

	/**
	 * 
	 * Adapter for Add button.
	 *
	 */
	class AddSelectionAdapter extends SelectionAdapter {
		int index;
		
		/**
		 * Constructor.
		 * @param index The index of the role.
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
			addPerformerRecord(index);
		}
	}
	
}
