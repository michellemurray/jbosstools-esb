/******************************************************************************* 
 * Copyright (c) 2008 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.tools.esb.project.ui.wizards.export;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jst.j2ee.datamodel.properties.IJ2EEComponentExportDataModelProperties;
import org.eclipse.jst.j2ee.internal.plugin.J2EEUIMessages;
import org.eclipse.jst.j2ee.internal.wizard.J2EEModuleExportPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.jboss.tools.esb.project.ui.ESBSharedImages;
import org.jboss.tools.esb.project.ui.messages.JBossESBUIMessages;

public class ESBComponentExportPage extends J2EEModuleExportPage {
	public ESBComponentExportPage(IDataModel model, String pageName, IStructuredSelection selection) {
		super(model, pageName, selection);
		setTitle(JBossESBUIMessages.ESBExportWizard_Title);
		setDescription(JBossESBUIMessages.ESBExportWizard_Description);
		setImageDescriptor(ESBSharedImages.getImageDescriptor(ESBSharedImages.WIZARD_NEW_PROJECT));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jst.j2ee.internal.internal.internal.ui.wizard.J2EEImportPage#getProjectImportLabel()
	 */
	protected String getComponentLabel() {
		return JBossESBUIMessages.ESBExportWizard_ESBProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jst.j2ee.internal.internal.internal.ui.wizard.J2EEImportPage#getFilterExpression()
	 */
	protected String[] getFilterExpression() {
		return new String[]{"*.esb"}; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jst.j2ee.internal.internal.internal.ui.wizard.J2EEExportPage#isMetaTypeSupported(java.lang.Object)
	 */
	protected boolean isMetaTypeSupported(Object o) {
		return true; 
	}

	protected String getCompnentID() {
		return "JST_JBOSS_ESB"; //$NON-NLS-1$
	}
}
