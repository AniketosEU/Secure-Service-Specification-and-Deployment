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
package eu.aniketos.mtm.srs2activiti.wizard.pages;

import java.util.ArrayList;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import eu.aniketos.mtm.srs2activiti.wizard.Srs2ActivitiWizard;

/**
 * 
 * Extends WizardPage base functionality.
 * This extra functionality is used by {@link Srs2ActivitiWizard}.
 * 
 * @author Eneko Gomez <eneko.gomez@tecnalia.com>
 *
 */
public abstract class CustomPage extends WizardPage {
	/**
	 * Overrides parent constructor.
	 * Creates a new wizard page with the given name, and with no title or image.
	 * 
	 * @param pageName The name of the page.
	 */
	protected CustomPage(String pageName) {
		super(pageName);
	}
	
	/**
	 * Calls pageComplete method before returning the next page.
	 */
	@Override
	public IWizardPage getNextPage() {
		pageComplete();
		return getWizard().getNextPage(this);
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		IWizardPage page =  super.getPreviousPage();
		if(page instanceof CustomPage){
			((CustomPage)page).onAppear();
		}
		return page;
	}
	
	@Override
	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().displayHelp("eu.aniketos.mtm.wizardhelp");
	}
	
	/**
	 * Called when the Finish button is pressed.
	 * It calls pageComplete method before finishing the wizard.
	 */
	public void performFinish() {
		pageComplete();
	}
	
	/**
	 * Determines if the Finish button is enabled.
	 * The button is disabled by default. This method should be overriden to enable it.
	 * @return True if enabled, false otherwise.
	 */
	public boolean canFinish() {
		return false;
	}
	
	/**
	 * Determines if the current page is empty (if it lacks of interactive controls).
	 * Returns false by default, it should be overriden.
	 * @return  Tre if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * It should contain the operations needed by the page when coming from the previous page.
	 * It does nothing by default, but can be overriden.
	 */
	public void onAppear() {
	}
	
	/**
	 * Determines whether a Text control is empty or not.
	 * @param text The Text control to evaluate.
	 * @return True if empty, false otherwise.
	 */
	protected boolean isTextNonEmpty(Text text) {
		String str = text.getText();
		if ((str != null) && (str.trim().length() > 0)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines whether a Combo control is empty or not.
	 * @param text The Text control to evaluate.
	 * @return True if empty, false otherwise.
	 */
	protected boolean isComboNonEmpty(Combo combo) {
		String str = combo.getText();
		if ((str != null) && (str.trim().length() > 0)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if there are not repeated text elements in the unidimensional array list.
	 * @param aal Arraylist with the texts.
	 * @return True if there are not repeated elements, false otherwise.
	 */
	protected boolean isUnrepeated1D(ArrayList<Text> al) {
		for (int j = 0; j < al.size(); j++) {
			String text = al.get(j).getText().trim();
			for (int j2 = j + 1; j2 < al.size(); j2++) {
				String text2 = al.get(j2).getText().trim();
				if (text.equals(text2)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Determines if there are not repeated text elements in the bidimensional array list. 
	 * @param aal Arraylist with the texts.
	 * @return True if there are not repeated elements, false otherwise.
	 */
	protected boolean isUnrepeated2D(ArrayList<ArrayList<Text>> aal) {
		for(int i = 0; i < aal.size(); i++) {
			ArrayList<Text> al = aal.get(i);
			for(int j = 0; j < al.size(); j++) {
				String text = al.get(j).getText().trim();
				for(int i2 = i; i2 < aal.size(); i2++ ) {
					ArrayList<Text> al2 = aal.get(i2);
					int j2 = 0;
					if(i2 == i) {
						j2 = j + 1;
					}
					for(; j2 < al2.size(); j2++) {
						String text2 = al2.get(j2).getText().trim();
						if(text.equals(text2)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Determines if there are not repeated text elements in the bidimensional array list. 
	 * @param aal Arraylist with the combos.
	 * @return True if there are not repeated elements, false otherwise.
	 */
	protected boolean isUnrepeated2DCombo(ArrayList<ArrayList<Combo>> aal) {
		for(int i = 0; i < aal.size(); i++) {
			ArrayList<Combo> al = aal.get(i);
			for(int j = 0; j < al.size(); j++) {
				String text = al.get(j).getText().trim();
				for(int i2 = i; i2 < aal.size(); i2++ ) {
					ArrayList<Combo> al2 = aal.get(i2);
					int j2 = 0;
					if(i2 == i) {
						j2 = j + 1;
					}
					for(; j2 < al2.size(); j2++) {
						String text2 = al2.get(j2).getText().trim();
						if(text.equals(text2)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Method called when Next or Finish button are pressed.
	 * It should perform all operations needed before going to the next page or submiting the wizard.
	 */
	protected abstract void pageComplete();
}
