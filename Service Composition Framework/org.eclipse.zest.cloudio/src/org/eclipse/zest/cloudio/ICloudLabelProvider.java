/*******************************************************************************
* Copyright (c) 2011 Stephan Schwiebert. All rights reserved. This program and
* the accompanying materials are made available under the terms of the Eclipse
* Public License v1.0 which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* <p/>
* Contributors: Stephan Schwiebert - initial API and implementation
*******************************************************************************/
package org.eclipse.zest.cloudio;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;

/**
 * Defines the label of an element within the cloud. Besides of the
 * string-label, each element can be assigned a unique weight (used
 * to calculate the font size of the rendered element), color, 
 * font and angle.  
 * @author sschwieb
 *
 */
public interface ICloudLabelProvider extends IBaseLabelProvider {

	/**
	 * The label of the given element, which must not
	 * be <code>null</code>.
	 * @param element
	 * @return
	 */
	public String getLabel(Object element);
	
	/**
	 * The weight of the given element, which must be between
	 * 0 and 1 (inclusive).
	 * @param element
	 * @return
	 */
	public double getWeight(Object element);
	
	/**
	 * The {@link Color} of the given element, which must not
	 * be <code>null</code>.
	 * @param element
	 * @return
	 */
	public Color getColor(Object element);
	
	/**
	 * The {@link FontData}-array which defines the font
	 * of the given element. Each element must be provided
	 * with a unique array. Must not return <code>null</code>.
	 * @param element
	 * @return
	 */
	public FontData[] getFontData(Object element);

	/**
	 * The angle of the element, which must be between -90 and 90, inclusive.
	 * @param element
	 * @return
	 */
	public float getAngle(Object element);

	/**
	 * Return the tool tip of the element, or <code>null</code>, if none.
	 * @param data
	 * @return
	 */
	public String getToolTip(Object element);
	
}
