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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import org.activiti.designer.elsag.Activator;
import org.activiti.designer.elsag.xml.XMLParser;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.mihalis.opal.dynamictablecolumns.DynamicTable;

import eu.aniketos.data.IAgreementTemplate;
import eu.aniketos.data.ICompositionPlan;
import eu.aniketos.data.IConsumerPolicy;
import eu.aniketos.scf.ServiceCompositionFrameworkInterface;
import eu.aniketos.scf.data.impl.AgreementTemplate;
import eu.aniketos.scf.data.impl.CompositionPlan;
import eu.aniketos.scf.data.impl.ConsumerPolicy;
import eu.aniketos.scpm.userinterface.views.ScpmUI;
import eu.aniketos.sre.DeployResult;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class DeploySelectionAdapter extends SelectionAdapter {
	private final Shell shell;
	private static Diagram diagram;
	private Text serviceNameText;
	private Text operationNameText;
	private Text tagsText;
	private DynamicTable alternativeList;
	
	final private static Logger log = Logger.getLogger(DeploySelectionAdapter.class);
	
	public DeploySelectionAdapter(Shell shell, Text serviceNameText, Text operationNameText, Text tagsText, DynamicTable alternativeList){
		this.shell = shell;
		this.serviceNameText = serviceNameText;
		this.operationNameText = operationNameText;
		this.tagsText = tagsText;
		this.alternativeList = alternativeList;
	}
	
	public void widgetSelected(SelectionEvent e) {
		final String serviceName = getServiceName();
		final String operationName = getOperationName();
		
		if(serviceName.equals("") || operationName.equals("") || tagsText.getText().equals("")){
			showErrorMessage("You have to define a service name, an operation and one or more service type");
			return;
		}
		
		final String[] tags = getTags(tagsText);
		Job job = new Job("Deploying as web service") {

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Deploying as web service", 100);
				URI uri = diagram.eResource().getURI();
				URI bpmnUri = uri.trimFragment();
				bpmnUri = bpmnUri.trimFileExtension();
				bpmnUri = bpmnUri.appendFileExtension("bpmn20.xml");

				URI rulesUri = uri.trimFragment();
				rulesUri = rulesUri.trimFileExtension();
				rulesUri = rulesUri.appendFileExtension("rule");

				String rulesPlatformString = rulesUri.toPlatformString(true);
				IResource fileRulesResource = ResourcesPlugin.getWorkspace().getRoot().findMember(rulesPlatformString);
				String platformString = bpmnUri.toPlatformString(true);
				IResource fileResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);

				if(fileResource != null){
					ServiceCompositionFrameworkInterface scf = org.activiti.designer.elsag.Activator.getDefault().getServiceCompositionFramework();
					String serviceSpecification = "";
					String ruleFileString = "";
					String[] consumerPolicies = new String[0];
					String agreementTemplateString = null;
					List<ICompositionPlan> compositionPlans = new Vector<ICompositionPlan>();
					try{
						serviceSpecification = XMLParser.convertXMLFileToString(fileResource.getLocation().toString());
						if(fileRulesResource!=null){
							ruleFileString = XMLParser.convertXMLFileToString(fileRulesResource.getLocation().toString());
						}
						List<String> listAlternatives = getAlternatives(alternativeList);

						ICompositionPlan compositionPlan = new CompositionPlan(serviceSpecification);
						compositionPlans.add(compositionPlan);
						
						for(String alternative : listAlternatives){
							compositionPlans.add(new CompositionPlan(alternative));
						}
						
						
						log.debug("Taking the Consumer Policies during deployment");
						IFolder folderConsumerPolicies = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf("Plan"))).getFolder("ConsumerPolicies");
						IResource[] files = folderConsumerPolicies.members();
						if(files.length == 0){
							showErrorMessage("No consumer policies have been found for this composite service");
							log.error("Composite service not deployed - No consumer policies have been found for this composite service");
							return Status.CANCEL_STATUS;
						}
						consumerPolicies = new String[files.length];
						
						for(int i=0; i<files.length; i++){
							String consumerPolicy = XMLParser.convertXMLFileToString(files[i].getLocation().toString());
							consumerPolicies[i] = consumerPolicy;
							log.debug("ConsumerPolicy found: "+consumerPolicy);
						}
						
						log.debug("Taking the Agreement Templates during deployment");
						IFolder folderAgreementTemplates = fileResource.getProject().getFolder("diagrams").getFolder(diagram.getName().substring(0,diagram.getName().indexOf("Plan"))).getFolder("AgreementTemplates");
						IResource[] filesAT = folderAgreementTemplates.members();
						if(filesAT.length == 0){
							showErrorMessage("No agreement templates have been found for this composite service");
							log.error("Composite service not deployed - No agreement templates have been found for this composite service");
							return Status.CANCEL_STATUS;
						}
						for(int i=0; i<filesAT.length; i++){
							agreementTemplateString = XMLParser.convertXMLFileToString(files[i].getLocation().toString());
							log.debug("AgreementTemplate found: "+ agreementTemplateString);
						}
						
					} catch(CoreException e){
						e.printStackTrace();
						showErrorMessage("Composite service not deployed\n" + e);
						return Status.CANCEL_STATUS;
					} catch (IOException e) {
						e.printStackTrace();
						showErrorMessage("Composite service not deployed\n" + e);
						return Status.CANCEL_STATUS;
					}
					
					final IConsumerPolicy consumerPolicy = new ConsumerPolicy();
					consumerPolicy.setXmlContents(consumerPolicies);

					final ScpmUI scpmUI = ScpmUI.getUI();
					Display.getDefault().syncExec(new Runnable() {
						public void run(){
							scpmUI.updateConsumerPolicy(consumerPolicy);
						}
					});

					final IAgreementTemplate agreementTemplate = new AgreementTemplate("id");
					agreementTemplate.setXML(agreementTemplateString);

					
					Properties prop = Activator.getConfigProperties();
					monitor.worked(50);
					scf.setProxy(prop.getProperty("proxyHost"), prop.getProperty("proxyPort"), prop.getProperty("proxyUsername"), prop.getProperty("proxyPassword"));

					DeployResult result = scf.deployService(compositionPlans, serviceName, operationName, tags, consumerPolicy, agreementTemplate, ruleFileString, prop.getProperty("SREAddress"));
					monitor.worked(50);
					if(result == null){
						showErrorMessage("SRE not found. Check the SCF settings");
						log.error("Composite service not deployed - SRE not found");
						return Status.CANCEL_STATUS;	
					} else if(result.isOk()){
						showOkMessage(result.getServiceAddress().getValue());
						log.info("Composite service successfully deployed - WSDL URL: "+result.getServiceAddress().getValue());
						return Status.OK_STATUS;
					} else {
						showErrorMessage(result.getErrorMessage().getValue());
						log.error("Composite service not deployed - "+ result.getErrorMessage().getValue());
						return Status.CANCEL_STATUS;
					}

				} else{
					showXmlErrorMessage();
					return Status.CANCEL_STATUS;
				}

		}
	};
	job.setUser(true);
	job.schedule();
}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {

	}

	private void showOkMessage(final String url) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				boolean result = MessageDialog.openQuestion(shell, "Deploy",
						"Composite service successfully deployed!\n" +
						"\n" +
						"WSDL URL: "+ url +
						"\n" +
						"\n" +
						"Do you want to see the WSDL on a browser?" +
						"\n" );
				if(result) {
					Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				        try {
				            desktop.browse(new URL(url).toURI());
				        } catch (Exception e) {
				        	log.error(e);
				        }
				    }
				}
			}
		});

	}
	
	private void showXmlErrorMessage() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Deploy",
						"Xml file not yet created. Set the type for each service task and then save the diagram");
			}
		});

	}
	
	private void showErrorMessage(final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(shell, "Deploy",
						"An error occured trying to deploy the composite service.\n" +
						message);
			}
			
		});

	}
	
	private String getServiceName() {
		return serviceNameText.getText();
	}
	
	private String getOperationName() {
		return operationNameText.getText();
	}
	
	private String[] getTags(Text tagsText) {
		StringTokenizer tokenizer = new StringTokenizer(tagsText.getText());
		Vector<String> tagsVector = new Vector<String>();
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			tagsVector.add(token);
		}
		String[] temp = new String[0];
		return tagsVector.toArray(temp);
		
	}
	
	public static void setDiagram(Diagram d){
		diagram = d;
	}
	
	public List<String> getAlternatives(final DynamicTable alternativeList){
		log.debug("Taking the composite service alternatives");
		final List<String> list = new Vector<String>();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				
				TableItem[] alternativesItems = alternativeList.getItems();
				for(int i=0; i<alternativesItems.length; i++){
					TableItem alternative = alternativesItems[i];
					String alternativePath = alternative.getText(1);
					try {
						String alternativeXML = XMLParser.convertXMLFileToString(alternativePath);
						list.add(alternativeXML);
					} catch (IOException e) {
						log.error(e.getMessage());
					}
				}
			}
		});
		return list;
		
	}


}
