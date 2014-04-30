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
package eu.aniketos.mtm.bpmnimport;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import eu.aniketos.mtm.mapping.MappingType;

public class ImportBpmnElementsCommand extends RecordingCommand {

	private TransactionalEditingDomain editingDomain;
	private String diagramName;
	private String bpmnFileName;
	private Resource createdResource;
	private Diagram diagram;
	private IContainer targetFolder;
	private MappingType mapping;

	public ImportBpmnElementsCommand(TransactionalEditingDomain editingDomain, 
	        String diagramName, String bpmnFileName, IContainer targetFolder, MappingType mapping) {
		super(editingDomain);
		this.editingDomain = editingDomain;
		this.diagramName = diagramName;
		this.bpmnFileName = bpmnFileName;
		this.targetFolder = targetFolder;
		this.mapping = mapping;
	}

	@Override
	protected void doExecute() {
	  // Create the diagram and its file
    diagram = Graphiti.getPeCreateService().createDiagram("BPMNdiagram", diagramName, true); //$NON-NLS-1$
    IFile diagramFile = targetFolder.getFile(new Path(diagramName + ".activiti")); //$NON-NLS-1$
    URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
    createdResource = editingDomain.getResourceSet().createResource(uri);
    createdResource.getContents().add(diagram);
    
	  IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
        "org.activiti.designer.diagram.ActivitiBPMNDiagramTypeProvider"); //$NON-NLS-1$
    IFeatureProvider featureProvider = dtp.getFeatureProvider();
    BpmnFileReader bpmnFileReader = new BpmnFileReader(bpmnFileName, diagram, featureProvider, mapping);
//    bpmnFileReader.openStream();
    bpmnFileReader.readBpmn();
	}

	/**
	 * @return the createdResource
	 */
	public Resource getCreatedResource() {
		return createdResource;
	}
	
	public Diagram getDiagram() {
	  return diagram;
	}
}
