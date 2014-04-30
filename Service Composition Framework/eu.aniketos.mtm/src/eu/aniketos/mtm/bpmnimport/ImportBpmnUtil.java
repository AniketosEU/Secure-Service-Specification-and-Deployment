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
/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.aniketos.mtm.bpmnimport;

import java.io.IOException;

import org.activiti.designer.eclipse.common.ActivitiPlugin;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;

import eu.aniketos.mtm.mapping.MappingType;


/**
 * @author Tijs Rademakers
 */
public class ImportBpmnUtil {
  
  public static ImportBpmnElementsCommand createDiagram(String processName, String bpmnFile, 
          IProject project, IContainer targetFolder, MappingType mapping) {
    
    // Get the default resource set to hold the new resource
    ResourceSet resourceSet = new ResourceSetImpl();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resourceSet);
    if (editingDomain == null) {
      // Not yet existing, create one
      editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
    }
    
    // Create the data within a command and save (must not happen inside
    // the command since finishing the command will trigger setting the 
    // modification flag on the resource which will be used by the save
    // operation to determine which resources need to be saved)
    ImportBpmnElementsCommand operation = new ImportBpmnElementsCommand( 
            editingDomain, processName, bpmnFile, targetFolder, mapping);
    editingDomain.getCommandStack().execute(operation);
    try {
      operation.getCreatedResource().save(null);
    } catch (IOException e) {
      IStatus status = new Status(IStatus.ERROR, ActivitiPlugin.getID(), e.getMessage(), e); //$NON-NLS-1$
      ErrorDialog.openError(Display.getCurrent().getActiveShell(), "Error Occured", e.getMessage(), status);
    }

    // Dispose the editing domain to eliminate memory leak
    editingDomain.dispose();
    return operation;
  }

}
