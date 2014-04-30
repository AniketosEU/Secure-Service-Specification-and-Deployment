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

package org.activiti.designer.util;

import java.util.List;

import org.activiti.designer.util.eclipse.ActivitiUiUtil;
import org.eclipse.bpmn2.ActivitiListener;
import org.eclipse.bpmn2.Activity;
import org.eclipse.bpmn2.SequenceFlow;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;


/**
 * @author Tijs Rademakers
 */
public class BpmnBOUtil {
  
  public static Object getExecutionListenerBO(PictogramElement pe, Diagram diagram) {
    Object bo = null;
    if(pe instanceof Diagram) {
      bo = ActivitiUiUtil.getProcessObject(diagram);
    } else {
      bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
    }
    return bo;
  }

  public static List<ActivitiListener> getListeners(Object bo) {
    List<ActivitiListener> listenerList = null;
    if(bo instanceof Activity) {
      listenerList = ((Activity) bo).getActivitiListeners();
    } else if(bo instanceof SequenceFlow) {
      listenerList = ((SequenceFlow) bo).getExecutionListeners();
    } else if(bo instanceof org.eclipse.bpmn2.Process) {
      listenerList = ((org.eclipse.bpmn2.Process) bo).getExecutionListeners();
    }
    return listenerList;
  }
  
  public static void addListener(Object bo, ActivitiListener listener) {
    if(bo instanceof Activity) {
      ((Activity) bo).getActivitiListeners().add(listener);
    } else if(bo instanceof SequenceFlow) {
      ((SequenceFlow) bo).getExecutionListeners().add(listener);
    } else if(bo instanceof org.eclipse.bpmn2.Process) {
      ((org.eclipse.bpmn2.Process) bo).getExecutionListeners().add(listener);
    }
  }
  
  public static void setListener(Object bo, ActivitiListener listener, int index) {
    if(bo instanceof Activity) {
      ((Activity) bo).getActivitiListeners().set(index, listener);
    } else if(bo instanceof SequenceFlow) {
      ((SequenceFlow) bo).getExecutionListeners().set(index, listener);
    } else if(bo instanceof org.eclipse.bpmn2.Process) {
      ((org.eclipse.bpmn2.Process) bo).getExecutionListeners().set(index, listener);
    }
  }
  
  public static void removeListener(Object bo, ActivitiListener listener) {
    if(bo instanceof Activity) {
      ((Activity) bo).getActivitiListeners().remove(listener);
    } else if(bo instanceof SequenceFlow) {
      ((SequenceFlow) bo).getExecutionListeners().remove(listener);
    } else if(bo instanceof org.eclipse.bpmn2.Process) {
      ((org.eclipse.bpmn2.Process) bo).getExecutionListeners().remove(listener);
    }
  }

}
