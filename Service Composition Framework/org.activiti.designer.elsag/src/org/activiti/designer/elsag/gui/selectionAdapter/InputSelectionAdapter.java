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
package org.activiti.designer.elsag.gui.selectionAdapter;

import java.util.List;

import org.activiti.designer.elsag.dialog.InputSelectionDialog;
import org.activiti.designer.elsag.gui.property.PropertyAniketosServiceTaskSection;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class InputSelectionAdapter extends SelectionAdapter{
	private final Shell shell;
	private static List<FieldExtension> listFieldExtension;
	private Text inputText;
	private PropertyAniketosServiceTaskSection section;
	private org.eclipse.swt.widgets.List operationNameList;
	
	public InputSelectionAdapter(Shell shell, Text inputText, PropertyAniketosServiceTaskSection section, org.eclipse.swt.widgets.List operationNameList) {
		this.shell = shell;
		this.inputText = inputText;
		this.section = section;
		this.operationNameList = operationNameList;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		if((operationNameList.getSelectionCount() > 0)){
			InputSelectionDialog dialog = new InputSelectionDialog(shell.getDisplay(),listFieldExtension, inputText, section);
			dialog.createContents();
		} else {
			MessageDialog.openError(shell, "Specify input","You need to select an operation before specifying an input");
		}
	}

	public static void setListFieldExtension(List<FieldExtension> list){
		listFieldExtension = list;
	}

}
