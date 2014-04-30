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
package org.activiti.designer.elsag;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
class PluginLogListener implements ILogListener {

	private ILog log;
	private Logger logger;

	PluginLogListener(ILog log,Logger logger) {
		this.log = log;
		this.logger = logger;
		log.addLogListener(this);
	}

	void dispose() {
		if (this.log != null) {
			this.log.removeLogListener(this);
			this.log = null;
			this.logger = null;
		} 
	}

	public void logging(IStatus status, String plugin) {
		if (null == this.logger || null == status) 
			return;

		int severity = status.getSeverity();
		Level level = Level.DEBUG;  
		if (severity == Status.ERROR)
			level = Level.ERROR;
		else
			if (severity == Status.WARNING)
				level = Level.WARN;
			else
				if (severity == Status.INFO)
					level = Level.INFO;
				else
					if (severity == Status.CANCEL)
						level = Level.FATAL;

		plugin = formatText(plugin);
		String statusPlugin = formatText(status.getPlugin());
		String statusMessage = formatText(status.getMessage());
		StringBuffer message = new StringBuffer();
		if (plugin != null) {
			message.append(plugin);
			message.append(" - ");
		}    
		if (statusPlugin != null && 
				(plugin == null || !statusPlugin.equals(plugin))) {
			message.append(statusPlugin);
			message.append(" - ");
		}	
		message.append(status.getCode());
		if (statusMessage != null) {
			message.append(" - ");
			message.append(statusMessage);
		} 		
		this.logger.log(level,message.toString(),status.getException());	
	}

	static private String formatText(String text) {
		if (text != null) {
			text = text.trim();
			if (text.length() == 0) return null;
		} 
		return text;
	}
}

