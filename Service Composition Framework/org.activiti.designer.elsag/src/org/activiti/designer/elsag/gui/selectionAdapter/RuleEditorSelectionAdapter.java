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

import org.activiti.designer.elsag.dialog.RuleEditorDialog;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.mihalis.opal.dynamictablecolumns.DynamicTable;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class RuleEditorSelectionAdapter extends SelectionAdapter{
	private DynamicTable tblDyn;
	
	private final Shell shell;
	private static Diagram diagram;

	public RuleEditorSelectionAdapter(Shell shell, DynamicTable tblDyn) {
		this.tblDyn = tblDyn;
		this.shell = shell;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		TableItem[] item = tblDyn.getSelection();
		if(item.length==0){
			showErrorMessage("Select a rule to edit");
		} else {
			String ruleId = item[0].getText();

			RuleEditorDialog dialog = new RuleEditorDialog(shell.getDisplay(), diagram);
			dialog.createContents(ruleId);
		}
	}
	
	public static void setDiagram(Diagram d){
		diagram = d;
	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Rule editor",message);
			}
		});

	}
	
}

