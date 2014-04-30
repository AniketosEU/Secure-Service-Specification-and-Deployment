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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.client.MarketplaceClient;
import org.activiti.designer.elsag.tagCloud.Type;
import org.activiti.designer.elsag.tagCloud.TypeLabelProvider;
import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.zest.cloudio.ICloudLabelProvider;
import org.eclipse.zest.cloudio.TagCloud;
import org.eclipse.zest.cloudio.TagCloudViewer;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class CloudDialog {
	
	private Display display;
	private Text typeText;
	private Button discoveryButton;
	private String processId;
	private String taskId;
	
	final private static Logger log = Logger.getLogger(CloudDialog.class);

	public CloudDialog(Display display, Text typeText, Button discoveryButton, String processId, String taskId) {
		this.display = display;
		this.typeText = typeText;
		this.discoveryButton = discoveryButton;
		this.processId = processId;
		this.taskId = taskId;
	}

	public void createContents() {
		final Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE | SWT.APPLICATION_MODAL);
		final TagCloud cloud = new TagCloud(shell, SWT.NONE);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setSize(500, 600);
		shell.setText("Type cloud");

		final TagCloudViewer viewer = new TagCloudViewer(cloud);
		
		final TypeLabelProvider labelProvider = new TypeLabelProvider();
		labelProvider.setScale(TypeLabelProvider.Scaling.LINEAR);
		RGB color = new RGB(0,149,182);
		List<RGB> listColor = new ArrayList<RGB>();
		listColor.add(color);
		FontData fontdata = new FontData("Helvetica", 18, SWT.NORMAL);
		List<FontData> listFont = new ArrayList<FontData>();
		listFont.add(fontdata);
		labelProvider.setColors(listColor);
		labelProvider.setFonts(listFont);
		viewer.setLabelProvider(labelProvider);

		// A simple content provider for a list of elements 
		viewer.setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public void inputChanged(Viewer v, Object oldInput, Object newInput) {
				List<?> list = (List<?>) newInput;
				if(list == null || list.size() == 0) return;
				labelProvider.setMaxOccurrences(((Type)list.get(0)).getOccurrences());
				int minIndex = Math.min(list.size()-1, viewer.getMaxWords());
				labelProvider.setMinOccurrences(((Type)list.get(minIndex)).getOccurrences());
			}
			
			@Override
			public void dispose() {

			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<?>)inputElement).toArray();
			}
		});

		Properties prop = Activator.getConfigProperties();
		
		ArrayList<Type> types = MarketplaceClient.getTags(prop.getProperty("MarketplaceAddress"), prop.getProperty("proxyHost"), prop.getProperty("proxyPort"), prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));
		if(types!=null){

			viewer.getCloud().setMaxFontSize(100);
			viewer.getCloud().setMinFontSize(15);
			viewer.setInput(types);

			viewer.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {

					IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
					Type type = (Type) selection.getFirstElement();
					typeText.setText(type.getString());
					Hashtable<String,String> hashTableField = org.activiti.designer.elsag.data.Data.hashTableFieldProcess.get(processId);
					hashTableField.put(taskId, typeText.getText());
					org.activiti.designer.elsag.data.Data.hashTableFieldProcess.put(processId,hashTableField);
					discoveryButton.setEnabled(true);
					
					shell.close();

				}
			});

			cloud.setBounds(0,0, shell.getBounds().width, shell.getBounds().height);

			final Toolkit toolkit = Toolkit.getDefaultToolkit();
			final Dimension screenSize = toolkit.getScreenSize();
			final int x = (screenSize.width - 500) / 2;
			final int y = (screenSize.height - 600) / 2;
			shell.setLocation(x, y);
			shell.open();
		} else {
			showErrorMessage();
			shell.dispose();
		}
	}


	static class CustomLabelProvider extends BaseLabelProvider implements ICloudLabelProvider {


		private Font font;


		public CustomLabelProvider(Font font) {
			this.font = font;
		}


		@Override
		public String getLabel(Object element) {
			return element.toString();
		}


		@Override
		public double getWeight(Object element) {
			return Math.random();
		}


		@Override
		public Color getColor(Object element) {
			return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
		}


		@Override
		public FontData[] getFontData(Object element) {
			return font.getFontData();
		}


		@Override
		public float getAngle(Object element) {
			return (float) (0);
		}


		@Override
		public String getToolTip(Object element) {
			return element.toString();
		}
	}
	
	private void showErrorMessage() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				log.debug("Unable to connect to the Marketplace");
				MessageDialog.openError(display.getActiveShell(), "Marketplace",
						"Unable to connect to the Marketplace");
			}
		});

	}


}



