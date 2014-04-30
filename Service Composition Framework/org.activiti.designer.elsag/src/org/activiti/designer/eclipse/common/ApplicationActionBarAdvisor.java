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
package org.activiti.designer.eclipse.common;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction exitAction;
	private IWorkbenchAction saveAction;
	private IWorkbenchAction saveAsAction;
	private IWorkbenchAction saveAllAction;
    private IWorkbenchAction aboutAction;
    private IWorkbenchAction newWindowAction;
    private IWorkbenchAction newAction;
    private IWorkbenchAction undoAction;
    private IWorkbenchAction redoAction;
    private IWorkbenchAction renameAction;
    private IWorkbenchAction importAction;
    private IWorkbenchAction exportAction;

    /**
     * @param configurer
     */
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        
        
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.application.ActionBarAdvisor#makeActions(org.eclipse.ui.IWorkbenchWindow)
     */
    protected void makeActions(IWorkbenchWindow window) {
    	exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
        
        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);
        
        newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
        register(newWindowAction);
        
        saveAction = ActionFactory.SAVE.create(window);
        register(saveAction);
        
        saveAsAction = ActionFactory.SAVE_AS.create(window);
        register(saveAsAction);
        
        saveAllAction = ActionFactory.SAVE_ALL.create(window);
        register(saveAllAction);
        
        newAction = ActionFactory.NEW.create(window);
        newAction.setText("Create");
        register(newAction);
        
        undoAction = ActionFactory.UNDO.create(window);
        register(undoAction);
        
        redoAction = ActionFactory.REDO.create(window);
        register(redoAction);
        
        renameAction = ActionFactory.RENAME.create(window);
        register(renameAction);
        
        importAction = ActionFactory.IMPORT.create(window);
        register(importAction);
        
        exportAction = ActionFactory.EXPORT.create(window);
        register(exportAction);

    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)
     */
    @SuppressWarnings("deprecation")
	protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager fileMenu = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
    	menuBar.add(fileMenu);
    	fileMenu.add(new GroupMarker(IWorkbenchActionConstants.SELECT_ALL));
    	fileMenu.add(new GroupMarker(IWorkbenchActionConstants.DELETE));
    	
    	MenuManager editMenu = new MenuManager("&Edit", IWorkbenchActionConstants.M_EDIT);
    	menuBar.add(editMenu);
    	editMenu.add(new GroupMarker(IWorkbenchActionConstants.SELECT_ALL));
    	editMenu.add(new GroupMarker(IWorkbenchActionConstants.DELETE));
    	
    	MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
    	menuBar.add(helpMenu);
    	helpMenu.add(new GroupMarker(IWorkbenchActionConstants.SELECT_ALL));
    	helpMenu.add(new GroupMarker(IWorkbenchActionConstants.DELETE));
    
    
        fileMenu.add(newAction);
        fileMenu.add(new Separator());
        fileMenu.add(saveAction);
        fileMenu.add(saveAsAction);
        fileMenu.add(saveAllAction);
        fileMenu.add(new Separator());
        fileMenu.add(renameAction);
        fileMenu.add(new Separator());
        fileMenu.add(importAction);
        fileMenu.add(exportAction);
        fileMenu.add(new Separator());
        fileMenu.add(exitAction);
        
        editMenu.add(undoAction);
        editMenu.add(redoAction);
        
        helpMenu.add(aboutAction);
       
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.application.ActionBarAdvisor#fillCoolBar(org.eclipse.jface.action.ICoolBarManager)
     */
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager toolbar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
        coolBar.add(new ToolBarContributionItem(toolbar, "main"));
        toolbar.add(newAction);
        toolbar.add(new Separator());
        toolbar.add(saveAction);
        toolbar.add(saveAllAction);
        toolbar.add(new Separator());
    }
    
}
