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
package eu.aniketos.mtm.srs2activiti.wizard.resources;

import org.eclipse.bpmn2.Task;

public class BodSodCorrection extends SecurityCorrection {
	
	private Task t1, t2;
	private BodSodKind kind;
	private String role1, role2, action1, action2;
	
	public BodSodCorrection(Task t1, Task t2, BodSodKind kind) {
		this.t1 = t1;
		this.t2 = t2;
		this.kind = kind;
	}
	
	public enum BodSodKind {
		BOD,
		SOD
	}

	public Task getTask1() {
		return t1;
	}

	public Task getTask2() {
		return t2;
	}

	public BodSodKind getKind() {
		return kind;
	}

	public void setTask1Role(String role) {
		this.role1 = role;
	}

	public void setTask2Role(String role) {
		this.role2 = role;
	}

	public void setTask1Action(String action) {
		this.action1 = action;
	}

	public void setTask2Action(String action) {
		this.action2 = action;
	}

	public String getRole1() {
		return role1;
	}

	public String getRole2() {
		return role2;
	}

	public String getAction1() {
		return action1;
	}

	public String getAction2() {
		return action2;
	}
	
	
}
