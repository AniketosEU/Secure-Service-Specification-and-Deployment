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
package org.activiti.designer.eclipse.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;

/**
 * The Eclipse Perspective to be showed at the SCF startup
 * @author Francesco Malmignati, Selex ES S.p.A.
 *
 */
public class SCFPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		
		layout.setFixed(true);
		defineActions(layout);
		defineLayout(layout);
		
	}
	
	private void defineActions(IPageLayout layout) {
		// Add "new wizards".
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$

		layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
	}

	/**
	 * Defines the initial layout for a page.
	 * 
	 * @param layout
	 *            The layout we are filling
	 */
	private void defineLayout(IPageLayout layout) {
		// Editors are placed for free.
		String editorArea = layout.getEditorArea();

		// Top left.
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, (float) 0.26, editorArea);//$NON-NLS-1$
		topLeft.addView("org.eclipse.jdt.ui.PackageExplorer");
		IViewLayout vLayout4 = layout.getViewLayout("org.eclipse.jdt.ui.PackageExplorer");
		vLayout4.setCloseable(false);

		// Bottom left.
		IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, (float) 0.50,//$NON-NLS-1$
				"topLeft");//$NON-NLS-1$
		bottomLeft.addView("eu.aniketos.scpm.userinterface.mainView");
		IViewLayout vLayout = layout.getViewLayout("eu.aniketos.scpm.userinterface.mainView");
		vLayout.setCloseable(false);
		bottomLeft.addView(IPageLayout.ID_OUTLINE);
		IViewLayout vLayout2 = layout.getViewLayout(IPageLayout.ID_OUTLINE);
		vLayout2.setCloseable(false);
		bottomLeft.addView("org.eclipse.graphiti.ui.internal.editor.thumbnailview");
		IViewLayout vLayout3 = layout.getViewLayout("org.eclipse.graphiti.ui.internal.editor.thumbnailview");
		vLayout3.setCloseable(false);

		// Bottom right.
		IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, (float) 0.66,//$NON-NLS-1$
				editorArea);
		bottomRight.addView(IPageLayout.ID_PROP_SHEET);
		IViewLayout vLayout6 = layout.getViewLayout(IPageLayout.ID_PROP_SHEET);
		vLayout6.setCloseable(false);
		bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
		IViewLayout vLayout7 = layout.getViewLayout(IPageLayout.ID_PROBLEM_VIEW);
		vLayout7.setCloseable(false);
	}

}
