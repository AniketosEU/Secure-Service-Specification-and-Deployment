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

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.aniketos.mtm.mapping.ActivityType;
import eu.aniketos.mtm.mapping.MappingType;
import eu.aniketos.mtm.srs.ActorType;
import eu.aniketos.mtm.srs.DelType;
import eu.aniketos.mtm.srs.DocType;
import eu.aniketos.mtm.srs.GoalType;
import eu.aniketos.mtm.srs.SecReqSpeType;
import eu.aniketos.mtm.srs.ThreatType;
import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;
import eu.aniketos.mtm.util.MappingManager;
import eu.aniketos.mtm.util.SrsManager;
import eu.aniketos.mtm.utils.Utils;

public class ThreatPage extends CustomPage {
	
	private boolean canFinish = false;
	
	private Composite topPanel;
	private ListViewer threatListViewer;
	private ListViewer activityListViewer;
	
	private List<ThreatType> threats;
	private List<ActivityBean> activityBeans;
	
		
	public ThreatPage(SecReqSpeType srs) {
		super("ThreatPage");
		
		// Set the title & description
		setTitle("Threats mapping");
		setDescription("Configure the threats to be attached to one or more service tasks.");
		
		if(srs.getThreatList() != null && srs.getThreatList().getThreat() != null){
			threats = srs.getThreatList().getThreat();
		}
		else{
			threats = new ArrayList<ThreatType>();
		}
		
		activityBeans = new ArrayList<ThreatPage.ActivityBean>();
		
	}

	public List<ThreatType> getThreats() {
		return threats;
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

		// List of Threats
		threatListViewer = new ListViewer(topPanel, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		threatListViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		threatListViewer.setLabelProvider(new ThreatLabelProvider());
		threatListViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ThreatType threat = (ThreatType) ((StructuredSelection)event.getSelection()).getFirstElement();
				List<ActivityType> threatenedActivities = MappingManager.getInstance().getActivitiesRelatedToThreat(((Srs2ActivitiWizard)getWizard()).getMapping(), threat);
				createFormControl(threat, threatenedActivities);
			}
		});	

		// Set the control
		setControl(topPanel);

		// Set page completion
		setPageComplete(true);
	}

	public void createFormControl (ThreatType threat, List<ActivityType> threatenedActivities){
		// Dispose old children
		if (topPanel.getChildren().length > 1
				&& topPanel.getChildren().length == 2) {
			topPanel.getChildren()[1].dispose();
		}
		
		Composite formComposite = new Composite(topPanel, SWT.BORDER);
		formComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		formComposite.setLayout(new GridLayout(2, false));
		
		Label label = new Label(formComposite, SWT.NONE);
		label.setText(threat.getName());
		FontData[] fD = label.getFont().getFontData();
		fD[0].setStyle(SWT.BOLD);
		label.setFont(new Font(getShell().getDisplay(),fD[0]));
		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		
		if(threat.getRepositoryID() != null && !threat.getRepositoryID().equals("")){
			Link link = new Link(formComposite, SWT.NONE);
			link.setText("<a href=\"https://svrs.shields-project.eu/ANIKETOS/resourceView.jsp?version=1&id=" + threat.getRepositoryID() + "\">More threat info</a>");
			link.setLayoutData(new GridData(SWT.RIGHT, SWT.BEGINNING, true, false, 1, 1));
			link.addSelectionListener(new SelectionAdapter(){
		        @Override
		        public void widgetSelected(SelectionEvent e) {
		               try {
		                //  Open default external browser 
		                PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new java.net.URL(e.text));
		              } 
		             catch (PartInitException ex) {
		                 ex.printStackTrace();
		            } 
		            catch (MalformedURLException ex) {
		                ex.printStackTrace();
		            }
		        }
		    });
		}
		
		String sDesc = "";
		if(threat.getGoal() != null && threat.getGoal().size() >= 0){
			List<String> notRepeatedGoals = new ArrayList<String>();
			for (GoalType g : threat.getGoal()) {
				if(!notRepeatedGoals.contains(g.getValue())){
					notRepeatedGoals.add(g.getValue());
				}
			}
			boolean first = true;
			for (String	gName : notRepeatedGoals) {
				if(first){
					sDesc += "Goal(s) threatened: " + gName;
				}
				else{
					sDesc += ", " + gName;
				}
			}
		}
		if(threat.getActor() != null && threat.getActor().size() >= 0){
			if(!sDesc.equals("")){
				sDesc += "\n";
			}			
			boolean first = true;
			for (ActorType a : threat.getActor()) {
				if(first){
					sDesc += "Actor(s) threatened: " + SrsManager.getInstance().getActorValue(a);
					first = false;
				}
				else{
					sDesc += ", " + SrsManager.getInstance().getActorValue(a);
				}
			}
		}
		if(threat.getDelegation() != null && threat.getDelegation().size() >= 0){
			if(!sDesc.equals("")){
				sDesc += "\n";
			}
			boolean first = true;
			for (DelType d : threat.getDelegation()) {
				String gText = "";
				boolean gFirst = true;
				for (GoalType g : d.getGoalSet().getGoal()) {
					if(gFirst){
						gText += g.getValue();
						gFirst = false;
					}					
					else{
						gText += ", " + g.getValue();
					}
				}
				if(first){
					sDesc += "Delegation(s) threatened: " + gText + "(" + SrsManager.getInstance().getActorValue(d.getSource()) + "->" + SrsManager.getInstance().getActorValue(d.getDestination()) + ")";
					first = false;
				}
				else{
					sDesc += ", " + gText + "(" + d.getSource() + "->" + d.getDestination() + ")";
				}
			}
		}
		if(threat.getDocument() != null && threat.getDocument().size() >= 0){
			if(!sDesc.equals("")){
				sDesc += "\n";
			}
			List<String> notRepeatedDocs = new ArrayList<String>();
			for (DocType d : threat.getDocument()) {
				if(!notRepeatedDocs.contains(d.getValue())){
					notRepeatedDocs.add(d.getValue());
				}
			}
			boolean first = true;
			for (String dName : notRepeatedDocs) {
				if(first){
					sDesc += "Document(s) threatened: " + dName;
					first = false;
				}
				else{
					sDesc += ", " + dName;
				}
			}
		}	
		
		Label lDescription = new Label(formComposite, SWT.NONE);
		lDescription.setText(sDesc);
		lDescription.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
		
		final Group group = new Group(formComposite, SWT.SHADOW_IN);
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		group.setText("Threatened BPMN service tasks");
		
		// List of Service Tasks
		activityListViewer = new ListViewer(group, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		activityListViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		activityListViewer.setLabelProvider(new ServiceActivityLabelProvider());

		// add items		
		for (ActivityType activityType : threatenedActivities) {
			activityListViewer.add(activityType);
			// add threat to activity bean
			ActivityBean activityBean = getActivityBeanById(activityType.getId());
			if(activityBean == null){
				activityBean = new ActivityBean(activityType.getId());
				activityBean.getThreats().add(threat);
				activityBeans.add(activityBean);
			}
			else{
				if(!activityBean.getThreats().contains(threat)){
					activityBean.getThreats().add(threat);
				}	
			}				
		}

		Composite buttonComposite = new Composite(group, SWT.NONE);
		buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		buttonComposite.setLayout(new GridLayout(1, false));
		
		Button bAdd = new Button(buttonComposite, SWT.PUSH);
		bAdd.setText("Add");
		bAdd.setData(threat);
		bAdd.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		bAdd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ThreatType threat = (ThreatType) e.widget.getData();
				List<ActivityType> actList = new ArrayList<ActivityType>();
				for (int i = 0; i < activityListViewer.getList().getItemCount(); i++) {
					actList.add((ActivityType) activityListViewer.getElementAt(i));					
				}
				List<ActivityType> selected = new ArrayList<ActivityType>();
				AddActivityToThreatDialog dialog = new AddActivityToThreatDialog(getShell(), threat.getName(), actList);
				dialog.setHelpAvailable(false);
				dialog.setBlockOnOpen(true);
				if(dialog.open() == Window.OK){
					selected = dialog.getSelectedActivityTypes();
				}
				dialog.close();
				for (ActivityType activityType : selected) {
					actList.add(activityType);
				}
				createFormControl(threat, actList);
			}
		});
		
		Button bRemove = new Button(buttonComposite, SWT.PUSH);
		bRemove.setText("Remove");
		bRemove.setData(threat);
		bRemove.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		bRemove.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ThreatType threat = (ThreatType) e.widget.getData();
				List<ActivityType> actList = ((StructuredSelection)activityListViewer.getSelection()).toList();
				// Remove from viewer and remove threat from the activity bean
				for (ActivityType activityType : actList) {
					activityListViewer.remove(activityType);
					ActivityBean activityBean = getActivityBeanById(activityType.getId());
					if(activityBean != null && activityBean.getThreats().contains(threat)){
						activityBean.getThreats().remove(threat);
					}
				}
			}
		});
		
		// Set page completion
		setPageComplete(true);
		refreshLayout();
	}
	
	@Override
	protected void pageComplete() {
		updateModel();
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
	
	/**
	 * Refresh the page to show the last changes.
	 */
	private void refreshLayout() {
		getShell().layout(true, true);
	}
	
	public void refreshList (){
		threatListViewer.getList().removeAll();
		activityBeans.clear();
			
		for (ThreatType t : threats) {
			threatListViewer.add(t);
			List<ActivityType> threatenedActivities = MappingManager.getInstance().getActivitiesRelatedToThreat(((Srs2ActivitiWizard)getWizard()).getMapping(), t);
			for (ActivityType activityType : threatenedActivities) {
				ActivityBean activityBean = getActivityBeanById(activityType.getId());
				if(activityBean == null){
					activityBean = new ActivityBean(activityType.getId());
				}	
				if(!activityBean.getThreats().contains(t)){
					activityBean.getThreats().add(t);
				}
				activityBeans.add(activityBean);
			}
		}				
	}
	
	private void updateModel() {
		MappingType mapping = ((Srs2ActivitiWizard) getWizard()).getMapping();
		mapping.getThreats().clear();
		
		List<ThreatType> threatsMapped = new ArrayList<ThreatType>();
		
		// Relate threat to task
		for (ActivityBean ab : activityBeans) {
			List<String> bpThreatIds = new ArrayList<String>();
			if(ab.getThreats().size() > 0){
				for (ThreatType	t : ab.getThreats()) {
					// Create ThreatsMapping
					eu.aniketos.mtm.mapping.ThreatType srThreat = MappingManager.getInstance().createThreatType(t.getId(), t.getRepositoryID(), t.getName());
					eu.aniketos.mtm.mapping.ThreatType bpThreat = MappingManager.getInstance().createThreatType(Utils.generateUniqueID(), t.getRepositoryID(), t.getName());
					mapping.getThreats().add(MappingManager.getInstance().createThreatsMappingType(srThreat, bpThreat));
					// Add threat to task					
					bpThreatIds.add(bpThreat.getId());	
					if(!threatsMapped.contains(t)){
						threatsMapped.add(t);
					}
				}
				ActivityType at = MappingManager.getInstance().findActivityById(mapping, ab.getId());
				if(at != null){
					at.getThreat().clear();
					at.getThreat().addAll(bpThreatIds);
				}				
			}
		}
		
		// Check the threats not related to any task
		for (ThreatType threatType : threats) {
			if(!threatsMapped.contains(threatType)){
				eu.aniketos.mtm.mapping.ThreatType srThreat = MappingManager.getInstance().createThreatType(threatType.getId(), threatType.getRepositoryID(), threatType.getName());
				eu.aniketos.mtm.mapping.ThreatType bpThreat = MappingManager.getInstance().createThreatType(Utils.generateUniqueID(), threatType.getRepositoryID(), threatType.getName());
				mapping.getThreats().add(MappingManager.getInstance().createThreatsMappingType(srThreat, bpThreat));
			}
		}
	
	}
	
	private ActivityBean getActivityBeanById (String id){
		for (ActivityBean aBean : activityBeans) {
			if(aBean.getId().equals(id)){
				return aBean;
			}
		}
		return null;
	}
	
	private class ThreatLabelProvider extends LabelProvider {
		
		public String getText(Object element) {
			if (element instanceof ThreatType) {
				return getTextRepresentation((ThreatType) element);
			}
			else {
				return "Unsupported object";
			}
		}
		
		private String getTextRepresentation(ThreatType t) {
			String text = t.getName();
			return text;			
		}

	}
	
	private class ServiceActivityLabelProvider extends LabelProvider {
		
		public String getText(Object element) {
			if (element instanceof ActivityType) {
				return getTextRepresentation((ActivityType) element);
			}
			else {
				return "Unsupported object";
			}
		}
		
		private String getTextRepresentation(ActivityType a) {
			String text = a.getValue();
			return text;			
		}

	}
	
	private class AddActivityToThreatDialog extends TitleAreaDialog {

		private List<ActivityType> selected = new ArrayList<ActivityType>();
		private List<ActivityType> existing = new ArrayList<ActivityType>();
		private String threat;
		
		public AddActivityToThreatDialog(Shell parentShell, String threat, List<ActivityType> existing) {
			super(parentShell);
			this.threat = threat;
			this.existing = existing;
		}
		
		@Override
		public void create() {
			super.create();
			setTitle("Task selection");
			setMessage(
					"Select the service tasks you want to be related to the threat '"
							+ threat
							+ "'.",
					INFORMATION);
		}
		
		@Override
		protected Control createDialogArea(Composite parent) {
			parent.setLayout(new GridLayout(1, false));
			// List of Service Tasks
			activityListViewer = new ListViewer(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
			activityListViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			activityListViewer.setLabelProvider(new ServiceActivityLabelProvider());
			
			// add items
			List<ActivityType> activities = MappingManager.getInstance().getServiceTypeActivities(((Srs2ActivitiWizard)getWizard()).getMapping());
			activities.removeAll(existing);
			for (ActivityType activityType : activities) {
				activityListViewer.add(activityType);
			}
			
			activityListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					selected = ((StructuredSelection)event.getSelection()).toList();
				}				
			});
			
			return parent;
		}
		
		public List<ActivityType> getSelectedActivityTypes (){
			return selected;
		}
	}
	
	private class ActivityBean {
		private String id;
		private List<ThreatType> threats = new ArrayList<ThreatType>();
		
		public ActivityBean(String id) {
			super();
			this.id = id;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<ThreatType> getThreats() {
			return threats;
		}

		public void setThreats(List<ThreatType> threats) {
			this.threats = threats;
		}	
		
	}
	
}


