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

import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.activiti.designer.util.property.ActivitiPropertySection;
import org.eclipse.aniketos.ThreatEvent;
import org.eclipse.bpmn2.BoundaryEvent;
import org.eclipse.bpmn2.EndEvent;
import org.eclipse.bpmn2.ErrorEventDefinition;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class PropertyBoundaryErrorSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

	private Text errorCodeText;
	
	private Composite composite;
	private TabbedPropertySheetWidgetFactory factory;
	
	private CLabel elementLabel;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		
		factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		
		FormData data;
		
		errorCodeText = factory.createText(composite, ""); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 120);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		errorCodeText.setLayoutData(data);
		errorCodeText.addFocusListener(listener);

		elementLabel = factory.createCLabel(composite, "Error code:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(errorCodeText, -HSPACE);
		data.top = new FormAttachment(errorCodeText, 0, SWT.TOP);
		elementLabel.setLayoutData(data);

	}
	
	public void updateControls() {

		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo == null)
				return;

			if(bo instanceof ThreatEvent) {
				
				elementLabel.setText("Threat Id:");
				
			} else {
				elementLabel.setText("Error code:");
			}
		}
		
	}

	@Override
	public void refresh() {
		updateControls();
	  errorCodeText.removeFocusListener(listener);

	  PictogramElement pe = getSelectedPictogramElement();
	  if (pe != null) {
		  Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		  if (bo == null)
			  return;

		  String errorCode = null;
		  if(bo instanceof BoundaryEvent) {
			  BoundaryEvent boundaryEvent = (BoundaryEvent) bo;
			  if(boundaryEvent.getEventDefinitions().get(0) != null) {
				  ErrorEventDefinition errorDefinition = (ErrorEventDefinition) boundaryEvent.getEventDefinitions().get(0);
				  if(errorDefinition.getErrorCode() != null) {
					  errorCode = errorDefinition.getErrorCode();
				  }
			  }
		  } else if(bo instanceof EndEvent) {
			  EndEvent endEvent = (EndEvent) bo;
			  if(endEvent.getEventDefinitions().get(0) != null) {
				  ErrorEventDefinition errorDefinition = (ErrorEventDefinition) endEvent.getEventDefinitions().get(0);
				  if(errorDefinition.getErrorCode() != null) {
					  errorCode = errorDefinition.getErrorCode();
				  }
			  }
			}
			errorCodeText.setText(errorCode == null ? "" : errorCode);
		}
		errorCodeText.addFocusListener(listener);
	}

	private FocusListener listener = new FocusListener() {

		public void focusGained(final FocusEvent e) {
		}

		public void focusLost(final FocusEvent e) {
			PictogramElement pe = getSelectedPictogramElement();
			if (pe != null) {
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
				if (bo instanceof BoundaryEvent || bo instanceof EndEvent) {
					DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
					@SuppressWarnings("restriction")
					TransactionalEditingDomain editingDomain = diagramEditor.getEditingDomain();
					ActivitiUiUtil.runModelChange(new Runnable() {
						public void run() {
							Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
							if (bo == null) {
								return;
							}
							String errorCode = errorCodeText.getText();
							if(bo instanceof BoundaryEvent) {
  							BoundaryEvent boundaryEvent = (BoundaryEvent) bo;
  						  ErrorEventDefinition errorDefinition = (ErrorEventDefinition) boundaryEvent.getEventDefinitions().get(0);
  						  errorDefinition.setErrorCode(errorCode);
							} else if(bo instanceof EndEvent) {
							  EndEvent endEvent = (EndEvent) bo;
							  ErrorEventDefinition errorDefinition = (ErrorEventDefinition) endEvent.getEventDefinitions().get(0);
                errorDefinition.setErrorCode(errorCode);
							}
						}
					}, editingDomain, "Model Update");
				}

			}
		}
	};
}
