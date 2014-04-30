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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.activiti.designer.elsag.gui.selectionAdapter.ThreatsSelectionAdapter;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.apache.log4j.Logger;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.EndEvent;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.bpmn2.EventDefinition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.internal.parts.ContainerShapeEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
@SuppressWarnings("restriction")
public class ThreatEventPropertySection extends ActivitiPropertySection {

	public final static String SVRS_WEB_URL = "https://svrs.shields-project.eu/ANIKETOS/";

	final private static Logger log = Logger.getLogger(PropertyAniketosRuleSection.class);

	private static Composite container;

	private static Composite controlsContainer;
	private static String eventId;


	public ThreatEventPropertySection() {
		controlsContainer = null;
		eventId = null;
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		container = new Composite(parent, SWT.NULL);
		container.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		container.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) { }

		});

		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 15;
		gridLayout.numColumns = 1;
		container.setLayout(gridLayout);

		updateControls();
	}


	public static void updateControls() {
		if (controlsContainer != null)
			controlsContainer.dispose();

		GridData horizontalFillLayout = new GridData();
		horizontalFillLayout.horizontalAlignment = SWT.FILL;
		horizontalFillLayout.grabExcessHorizontalSpace = true;
		horizontalFillLayout.verticalAlignment = SWT.FILL;
		horizontalFillLayout.grabExcessVerticalSpace = true;

		controlsContainer = new Composite(container, SWT.NONE);
		controlsContainer.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		controlsContainer.setLayout(new FormLayout());
		controlsContainer.setLayoutData(horizontalFillLayout);

		Label headingLabel = new Label(controlsContainer, SWT.NONE);
		headingLabel.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		FormData headingLabelLayout = new FormData();
		headingLabelLayout.right = new FormAttachment(60, 0);
		headingLabelLayout.left = new FormAttachment(0, 10);
		headingLabel.setLayoutData(headingLabelLayout);
		headingLabel.setText("Threat Repository");

		FontData[] fD = headingLabel.getFont().getFontData();
		fD[0].setStyle(SWT.BOLD);
		fD[0].setHeight(18);
		Font font = new Font(container.getDisplay(), fD[0]);
		headingLabel.setFont(font);

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = window.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		final ContainerShapeEditPart selectElement = ((ContainerShapeEditPart) structuredSelection.getFirstElement());
		EObject ob = (EObject) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(selectElement.getPictogramElement());


		if (ob instanceof EndEvent) {
			EndEvent endEvent = (EndEvent) ob;
			List<EventDefinition> list = endEvent.getEventDefinitions();
			ErrorEventDefinition errorDefinition = (ErrorEventDefinition) list.get(0);
			eventId = errorDefinition.getErrorCode();
		} else if (ob instanceof BoundaryEvent) {
			BoundaryEvent boundaryEvent = (BoundaryEvent) ob;
			ErrorEventDefinition errorDefinition = (ErrorEventDefinition) boundaryEvent.getEventDefinitions().get(0);
			eventId = errorDefinition.getErrorCode();
		}
		if (eventId != null && !eventId.equals("")) {
			Label instructionLabel = new Label(controlsContainer, SWT.NONE);
			instructionLabel.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			FormData instructionLabelLayout = new FormData();
			instructionLabelLayout.top = new FormAttachment(headingLabel, 18);
			instructionLabelLayout.left = new FormAttachment(0, 10);
			instructionLabelLayout.right = new FormAttachment(60, 0);
			instructionLabel.setLayoutData(instructionLabelLayout);
			instructionLabel.setText("Click to view additional information in web browser (free registration/login required):"); //  (for testing username: aniketos / password: aniketos)

			final String url = SVRS_WEB_URL + "resourceView.jsp?version=1&id=" + eventId;
			Link browserLink = new Link(controlsContainer, SWT.NONE);
			browserLink.setText("<A href=\"" + url + "\">" + url + "</A>");

			FormData browserLinkLayout = new FormData();
			browserLinkLayout.top = new FormAttachment(instructionLabel, 6);
			browserLinkLayout.left = new FormAttachment(0, 10);
			browserLinkLayout.right = new FormAttachment(60, 0);
			browserLink.setLayoutData(browserLinkLayout);
			browserLink.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			browserLink.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					try {
						// Open default external browser
						PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(new URL(url));
					} catch (PartInitException ex) {
						log.error(ex);
					} catch (MalformedURLException ex) {
						log.error(ex);
					}
				}
			});

			Button wizardButton = new Button(controlsContainer, SWT.PUSH);
			FormData wizardLayout = new FormData();
			wizardLayout.top = new FormAttachment(browserLink, 20);
			wizardLayout.left = new FormAttachment(0, 10);
			wizardLayout.right = new FormAttachment(15, 0);
			wizardButton.setLayoutData(wizardLayout);
			wizardButton.setText("Change threat definition");
			wizardButton.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					invokeThreatRepositoryWizard();
				}
			});

			Button checkThreatsButton = new Button(controlsContainer, SWT.PUSH);
			checkThreatsButton.setText("Ask for countermeasures");
			FormData data = new FormData();
			data.left = new FormAttachment(0, 10);
			data.top = new FormAttachment(wizardButton, 30);
			checkThreatsButton.setLayoutData(data);
			checkThreatsButton.addSelectionListener(new ThreatsSelectionAdapter(eventId));
		}

		else {
			Label instructionLabel = new Label(controlsContainer, SWT.NONE);
			instructionLabel.setBackground(container.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			FormData instructionLabelLayout = new FormData();
			instructionLabelLayout.top = new FormAttachment(headingLabel, 20);
			instructionLabelLayout.left = new FormAttachment(0, 10);
			instructionLabelLayout.right = new FormAttachment(60, 0);
			instructionLabel.setLayoutData(instructionLabelLayout);
			instructionLabel.setText("Click to browse a list of common threats:");

			Button wizardButton = new Button(controlsContainer, SWT.PUSH);
			FormData wizardButtonLayout = new FormData();
			wizardButtonLayout.top = new FormAttachment(instructionLabel, 10);
			wizardButtonLayout.left = new FormAttachment(0, 10);
			wizardButtonLayout.right = new FormAttachment(15, 0);
			wizardButton.setLayoutData(wizardButtonLayout);
			wizardButton.setText("Import threat definition");
			wizardButton.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					invokeThreatRepositoryWizard();
				}
			});

		}

		container.layout();
	}


	private static void invokeThreatRepositoryWizard() {
		IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);

		try {
			handlerService.executeCommand("addthreats", null);
		} catch (Exception ex) {
			// Give message about missing plug-in
			MessageDialog.openError(container.getShell(), "Required component missing", "The Threat Repository plug-in could not be initialized: " + ex.getMessage());
			log.error(ex);
		}
	}


	/**
	 * @generated NOT
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
	}

	@Override
	public void refresh(){
		updateControls();
	}
}
