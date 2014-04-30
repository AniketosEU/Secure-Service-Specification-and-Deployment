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
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.activiti.designer.elsag.data.ProcessVariable;
import org.activiti.designer.elsag.gui.property.PropertyAniketosServiceTaskSection;
import org.apache.log4j.Logger;
import org.eclipse.bpmn2.FieldExtension;
import org.eclipse.bpmn2.FormProperty;
import org.eclipse.bpmn2.ServiceTask;
import org.eclipse.bpmn2.StartEvent;
import org.eclipse.bpmn2.UserTask;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;


/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class InputSelectionDialog {

	private Display display;

	private List<FieldExtension> listFieldExtension;
	private Text inputText;
	private String input;
	private PropertyAniketosServiceTaskSection section;
	public static List<Value> inputValues;
	private int fieldNumber;
	
	@SuppressWarnings("unused")
	final private static Logger log = Logger.getLogger(InputSelectionDialog.class);

	public InputSelectionDialog(Display display, List<FieldExtension> list, Text inputText, PropertyAniketosServiceTaskSection section) {
		this.display = display;
		this.listFieldExtension = list;
		this.inputText = inputText;
		this.input = "";
		this.section = section;
		inputValues = new Vector<Value>();
	}

	public void createContents() {

		final Shell shell = new Shell(display, SWT.CLOSE | SWT.RESIZE | SWT. APPLICATION_MODAL);
		
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 1;
		shell.setLayout(fillLayout);
		shell.setText("Specify input");
		
		ScrolledComposite scrolledComp = new ScrolledComposite(shell, SWT.H_SCROLL | SWT.V_SCROLL);

		final Composite composite = new Composite(scrolledComp, SWT.NONE);
		final FormLayout formLayout= new FormLayout();
		formLayout.marginHeight = 5;
		formLayout.marginWidth = 5;
		composite.setLayout(formLayout);
		
		scrolledComp.setContent(composite);

		String iType = "";
		int i = 1;
		
		Control previousAnchor = null;

		for(FieldExtension field : listFieldExtension){
			if(field.getFieldname().equals("operation")){
				String operation = field.getExpression();

				final CLabel clbl_Operation = new CLabel(composite, SWT.NONE);
				final FormData formData_1 = new FormData();
				formData_1.left = new FormAttachment(50,-90);
				formData_1.right = new FormAttachment(50,90);
				formData_1.top = new FormAttachment(0,30);
				clbl_Operation.setLayoutData(formData_1);
				clbl_Operation.setText("Operation: "+operation);
				
				
				Label shadow_sep_h = new Label(composite, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
				final FormData formData_2 = new FormData();
				formData_2.top = new FormAttachment(clbl_Operation,10);
				formData_2.left = new FormAttachment(0,0);
				formData_2.right = new FormAttachment(100,0);
				shadow_sep_h.setLayoutData(formData_2);
				
				previousAnchor = shadow_sep_h;

			}
		}
		
		
		for(FieldExtension field1 : listFieldExtension){
			if(field1.getFieldname().equals("inputType")){
				iType = field1.getExpression();

				StringTokenizer tokens = new StringTokenizer(iType);
				String name = "";

				while(tokens.hasMoreTokens()){
					String token = tokens.nextToken();
					String typeToken = "";
					
					if(token.equals("(type:")){
						typeToken = tokens.nextToken();
						if(typeToken.endsWith(",")){
							typeToken = typeToken.substring(0, typeToken.length()-1);
						}
						final CLabel clbl_Parameter = new CLabel(composite, SWT.NONE);
						final FormData formData_2 = new FormData();
						formData_2.left = new FormAttachment(0,10);
						formData_2.top = new FormAttachment(previousAnchor,10);
						clbl_Parameter.setLayoutData(formData_2);
						clbl_Parameter.setText("Parameter "+i);
						i++;

						final Text valueText = new Text(composite, SWT.BORDER);
						final CCombo comboVariables = new CCombo(composite, SWT.BORDER);

						final Button radioButton1 = new Button(composite, SWT.RADIO);
						radioButton1.setText("Process variable");
						final FormData data2 = new FormData();
						data2.left = new FormAttachment(0, 10);
						data2.right = new FormAttachment(0, 120);
						data2.top = new FormAttachment(clbl_Parameter, 10);
						radioButton1.setLayoutData(data2);
						radioButton1.addSelectionListener(new SelectionListener(){

							@Override
							public void widgetSelected(SelectionEvent e) {
								valueText.setEnabled(false);
								valueText.setEditable(false);
								comboVariables.setEnabled(true);
								comboVariables.setEditable(true);
							}

							@Override
							public void widgetDefaultSelected(SelectionEvent e) {


							}

						});

						final Button radioButton2 = new Button(composite, SWT.RADIO);
						radioButton2.setText("Value");
						final FormData data3 = new FormData();
						data3.left = new FormAttachment(0, 10);
						data3.right = new FormAttachment(0, 100);
						data3.top = new FormAttachment(radioButton1, 20);
						radioButton2.setLayoutData(data3);
						radioButton2.addSelectionListener(new SelectionListener(){

							@Override
							public void widgetSelected(SelectionEvent e) {
								valueText.setEnabled(true);
								valueText.setEditable(true);
								comboVariables.setEnabled(false);
								comboVariables.setEditable(false);
							}

							@Override
							public void widgetDefaultSelected(SelectionEvent e) {

							}

						});


						final FormData data = new FormData();
						data.left = new FormAttachment(radioButton2, 30);
						data.right = new FormAttachment(0, 300);
						data.top = new FormAttachment(clbl_Parameter, 10);
						comboVariables.setLayoutData(data);
						comboVariables.setEnabled(false);
						comboVariables.setEditable(false);

						List<String> tasksDiscovered = new Vector<String>();
						List<ProcessVariable> variables = new Vector<ProcessVariable>();
						EList<PictogramLink> list = section.returnDiagram().getPictogramLinks();
						for(PictogramLink link : list){
							EList<EObject> elist = link.getBusinessObjects();
							for(EObject ob : elist){
								if(ob instanceof ServiceTask){
									ServiceTask task = (ServiceTask) ob;
									if(!tasksDiscovered.contains(task.getId())){
										tasksDiscovered.add(task.getId());
										List<FieldExtension> listFields = task.getFieldExtensions();
										String value = "";
										String type = "";
										for(FieldExtension field : listFields){
											if(field.getFieldname().equals("resultVariable")){
												value = field.getExpression();
											} else if(field.getFieldname().equals("outputType")){
												type= field.getExpression();
											}
										}
										if(!value.equals("") && !type.equals("")){
											ProcessVariable processVariable = new ProcessVariable(task.getId(), task.getName(), value, type);
											variables.add(processVariable);
										}
									}
								} else if(ob instanceof StartEvent){
									StartEvent event = (StartEvent) ob;
									if(!tasksDiscovered.contains(event.getId())){
										tasksDiscovered.add(event.getId());
										List<FormProperty> formPropertyList = event.getFormProperties();
										for(FormProperty prop : formPropertyList){
											ProcessVariable processVariable = new ProcessVariable(event.getId(), event.getName(), prop.getId(), prop.getType());
											variables.add(processVariable);
										}
									}
								} else if(ob instanceof UserTask){
									UserTask task = (UserTask) ob;
									if(!tasksDiscovered.contains(task.getId())){
										tasksDiscovered.add(task.getId());
										List<FormProperty> formPropertyList = task.getFormProperties();
										for(FormProperty prop : formPropertyList){
											ProcessVariable processVariable = new ProcessVariable(task.getId(), task.getName(), prop.getId(), prop.getType());
											variables.add(processVariable);
										}
									}
								}

							}
						}
						String[] vars = new String[variables.size()];
						int cont=0;
						for(ProcessVariable var : variables){
							vars[cont] = var.getValue() + " - (Type: "+var.getType()+", Returned by: " + var.getTaskName() + ")";
							cont++;
						}
						
						comboVariables.setItems(vars);
						comboVariables.addSelectionListener(new ComboBoxListener(fieldNumber, comboVariables));

						final FormData data4 = new FormData();
						data4.left = new FormAttachment(radioButton2, 30);
						data4.right = new FormAttachment(0, 300);
						data4.top = new FormAttachment(comboVariables, 20);
						valueText.setLayoutData(data4);
						valueText.setEnabled(false);
						valueText.setEditable(false);
						valueText.addKeyListener(new ValueTextListener(fieldNumber,valueText));
						
						fieldNumber++;
						
						final CLabel clbl_InputName = new CLabel(composite, SWT.NONE);
						final FormData formData_3 = new FormData();
						formData_3.left = new FormAttachment(comboVariables,30);
						formData_3.top = new FormAttachment(clbl_Parameter,30);
						clbl_InputName.setLayoutData(formData_3);
						clbl_InputName.setText("Name: "+name);

						final CLabel clbl_InputType = new CLabel(composite, SWT.NONE);
						final FormData formData_1 = new FormData();
						formData_1.left = new FormAttachment(clbl_InputName,30);
						formData_1.top = new FormAttachment(clbl_Parameter,30);
						clbl_InputType.setLayoutData(formData_1);
						clbl_InputType.setText("Type: "+typeToken.substring(0,token.length()));

						Label shadow_sep_h = new Label(composite, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
						final FormData formData_6 = new FormData();
						formData_6.top = new FormAttachment(valueText,10);
						formData_6.left = new FormAttachment(0,0);
						formData_6.right = new FormAttachment(100,0);
						shadow_sep_h.setLayoutData(formData_6);

						previousAnchor = shadow_sep_h;
						name = "";
					} else {
						if(name.equals(""))
							name = token;
						else
							name = name + " " + token;
					}
				}
			}
		}
		
		final Button okButton = new Button(composite, SWT.BUTTON1);
		okButton.setText("Save");
		final FormData data2 = new FormData();
	    data2.left = new FormAttachment(50, -30);
	    data2.right = new FormAttachment(50, 30);
	    data2.top = new FormAttachment(previousAnchor, 30);
	    okButton.setLayoutData(data2);
	    okButton.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {				
				for(Value value : inputValues){
					if(value!=null){
						if(value.getType().equals("Variable")){
							String variableValue = value.getValue();
							String variable = variableValue.substring(0, variableValue.indexOf(" -"));
							input = input + "${" + variable + "}~";
						} else if(value.getType().equals("Value")){
							String plainValue = value.getValue();
							if(plainValue == null){
								showErrorMessage("Please define all the missing values");
								return;
							} else {
								input = input + plainValue + "~";
							}
						}
					} else {
						showErrorMessage("Please define all the missing values");
					}
				}
				if(!input.equals("")){
					input = input.substring(0, input.length()-1);
					inputText.setText(input);
					section.saveExtension("input", input);
				} else {
					showErrorMessage("Please define an input for each parameter");
					return;
				}
				
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
				
			}
	    	
	    });  
	    
		scrolledComp.setMinSize(560, fieldNumber*250);
		
		scrolledComp.setExpandHorizontal(true);
	    scrolledComp.setExpandVertical(true);
	    
	    int height = fieldNumber*300;
	    if(height >= 600 && height < 700)
	    	height = 600;
	    if(height >= 700)
	    	height = 700;
		shell.setSize(600, height);
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - 600) / 2;
		final int y = (screenSize.height - height) / 2;
		shell.setLocation(x, y);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		shell.dispose();
	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(display.getActiveShell(), "Error",message);
			}
		});

	}
	
	class ComboBoxListener extends SelectionAdapter{
		int fieldNumber;
		CCombo comboVariables;
		
		public ComboBoxListener(int fieldNumber, CCombo comboVariables){
			this.fieldNumber = fieldNumber;
			this.comboVariables = comboVariables;
		}
		
		public void widgetSelected(SelectionEvent e) {
			Value value = new Value("Variable",comboVariables.getText());
			if(fieldNumber > inputValues.size()-1){
				inputValues.add(value);
			} else {
				inputValues.set(fieldNumber, value);
			}

		}
		
	}
	
	class ValueTextListener extends KeyAdapter{
		int fieldNumber;
		Text valueText;
		
		public ValueTextListener(int fieldNumber, Text valueText){
			this.fieldNumber = fieldNumber;
			this.valueText = valueText;
		}
		
		public void keyReleased(KeyEvent e) {
			if(!valueText.getText().equals("")){
				Value value = new Value("Value", valueText.getText());
				if(fieldNumber > inputValues.size()-1){
					inputValues.add(value);
				} else {
					inputValues.set(fieldNumber, value);
				}
			} else {
				Value value = new Value("Value", null);
				if(fieldNumber > inputValues.size()-1){
					inputValues.add(value);
				} else {
					inputValues.set(fieldNumber, value);
				}
			}
		}
		
	}
	
	class Value{
		private String type;
		private String value;
		private int index;
		
		public Value(String type, String value, int index) {
			super();
			this.type = type;
			this.value = value;
			this.index = index;
		}

		public Value(String type, String value) {
			super();
			this.type = type;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
		
	}
	

}

