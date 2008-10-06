package org.jboss.tools.esb.project.ui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.INewWizard;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.project.facet.core.IFacetedProjectTemplate;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.web.ui.internal.wizards.NewProjectDataModelFacetWizard;
import org.jboss.tools.common.model.ui.ModelUIImages;
import org.jboss.tools.esb.core.ESBProjectUtilities;
import org.jboss.tools.esb.project.ui.wizards.pages.ESBProjectFirstPage;

public class ESBProjectWizard extends NewProjectDataModelFacetWizard implements
		INewWizard {

	public ESBProjectWizard() {
		setWindowTitle("New ESB Project Wizard");
		setDefaultPageImageDescriptor(ModelUIImages.getImageDescriptor(ModelUIImages.WIZARD_NEW_PROJECT));
	}

	public ESBProjectWizard(IDataModel model) {
		super(model);
		setWindowTitle("New ESB Project Wizard");
		setDefaultPageImageDescriptor(ModelUIImages.getImageDescriptor(ModelUIImages.WIZARD_NEW_PROJECT));
		
	}

	@Override
	protected IDataModel createDataModel() {
		return DataModelFactory.createDataModel(new JBossESBFacetProjectCreationDataModelProvider());
	}

	@Override
	protected IWizardPage createFirstPage() {
		return new ESBProjectFirstPage(model, "first.page");
	}

	@Override
	protected ImageDescriptor getDefaultPageImageDescriptor() {
		return ModelUIImages.getImageDescriptor(ModelUIImages.WIZARD_NEW_PROJECT);
	}

	@Override
	protected IFacetedProjectTemplate getTemplate() {
		return ProjectFacetsManager.getTemplate(ESBProjectUtilities.ESB_PROJECT_FACET_TEMPLATE);
	}
	
	

}