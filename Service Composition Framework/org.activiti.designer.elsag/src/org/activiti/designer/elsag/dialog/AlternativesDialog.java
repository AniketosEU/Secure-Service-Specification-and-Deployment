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
package org.activiti.designer.elsag.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import org.activiti.designer.elsag.data.Process;

import org.activiti.designer.elsag.gui.property.PropertyAniketosDeploySection;
import org.activiti.designer.elsag.xml.XMLParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.mihalis.opal.dynamictablecolumns.DynamicTable;
import org.mihalis.opal.dynamictablecolumns.DynamicTableColumn;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class AlternativesDialog {
	
	private Display display;
	
	private static Shell shell;

	final private static Logger log = Logger.getLogger(AlternativesDialog.class);

	public void createContents() {
		shell = new Shell(display, SWT.CLOSE | SWT.APPLICATION_MODAL);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setSize(500, 500);
		shell.setText("Select the BPMN alternatives");
		
		final Composite composite = new Composite(shell, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		
		final DynamicTable processesList = new DynamicTable(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan= 1;
		processesList.setLayoutData(gridData);
		processesList.setHeaderVisible(true);
		processesList.setLinesVisible(true);
		DynamicTableColumn tblcId = new DynamicTableColumn(processesList, SWT.NONE);
		tblcId.setText("processId");
		tblcId.setWidth("150px");
		DynamicTableColumn tblcProject = new DynamicTableColumn(processesList, SWT.NONE);
		tblcProject.setText("Project");
		tblcProject.setWidth("100px");
		DynamicTableColumn tblcPath = new DynamicTableColumn(processesList, SWT.NONE);
		tblcPath.setText("Path");
		tblcPath.setWidth("100px");
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		java.util.List<Process> processIds = new Vector<Process>();
		int cont = 0;
		for(int i=0; i<projects.length; i++){
			File project = projects[i].getLocation().toFile();
			java.util.List<File> files = (java.util.List<File>) FileUtils.listFiles(project, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
			for (File file : files) {
				if(FilenameUtils.getExtension(file.getName()).equals("xml")){
					try {
						String processId = XMLParser.getProcessId(XMLParser.convertXMLFileToString(file.getAbsolutePath()));
						if(processId != null){
							TableItem tbli = new TableItem(processesList, SWT.NONE);
        					tbli.setText(0, processId);
        					tbli.setText(1, projects[i].getName());
        					tbli.setText(2, file.getAbsolutePath());
							processIds.add(cont, new Process(processId,file.getAbsolutePath()));
						}

					} catch (IOException e1) {
						log.error(e1);
					}
				}	
			}
		}
		
		Button addButton = new Button(composite, SWT.BUTTON1);
		addButton.setText("Add");
		gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan= 1;
		addButton.setLayoutData(gridData);
		
		
		addButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = processesList.getSelection();
				java.util.List<Process> processes = new Vector<Process>();
				if(item.length==0){
					showErrorMessage("Select at least one process");
				} else {
					for(int i=0; i<item.length; i++){
						String processId = item[i].getText(0);
						String path = item[i].getText(2);
						Process process = new Process(processId, path);
						
						processes.add(process);
					}
					PropertyAniketosDeploySection.addProcessesToList(processes);
					shell.close();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 500) / 2;
		final int y = (screenSize.height - 500) / 2;
		shell.setLocation(x, y);
		shell.open();
	}
	
	private static void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Rule editor",message);
			}
		});

	}
	
}

