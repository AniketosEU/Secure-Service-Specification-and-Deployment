package org.activiti.designer.eclipse.ui.wizard.diagram;

import org.activiti.designer.eclipse.common.ActivitiBPMNDiagramConstants;
import org.activiti.designer.eclipse.common.ActivitiPlugin;
import org.activiti.designer.eclipse.common.PluginImage;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class CreateDefaultActivitiDiagramNameWizardPage extends WizardNewFileCreationPage {

  public static final String PAGE_NAME = "createDefaultActivitiDiagramNameWizardPage";

  private static final String DEFAULT_DIAGRAM_NAME = "MyProcess";

  public CreateDefaultActivitiDiagramNameWizardPage(IStructuredSelection selection) {
    super(PAGE_NAME, selection);
    super.setFileName(DEFAULT_DIAGRAM_NAME);
    setTitle("New Secure Composite Service");
    setImageDescriptor(ActivitiPlugin.getImageDescriptor(PluginImage.ANIKETOS_LOGO_64x64));
    setDescription("Create a new secure composite service");
    setFileExtension(StringUtils.substringAfter(ActivitiBPMNDiagramConstants.DIAGRAM_EXTENSION, "."));

    // Set selection to the default folder if the project itself was selected
    final IProject project = getProjectFromSelection(selection);
    if (project != null) {
    	if(getDiagramName().contains(".")){
    		final IFolder folder = project.getFolder(ActivitiBPMNDiagramConstants.DIAGRAM_FOLDER+getDiagramName().substring(0, getDiagramName().indexOf(".")));
    	      if (folder != null && folder.exists()) {
    	        selection.toList().set(0, folder);
    	      }
    	} else {
    		final IFolder folder = project.getFolder(ActivitiBPMNDiagramConstants.DIAGRAM_FOLDER);
  	      if (folder != null && folder.exists()) {
  	        selection.toList().set(0, folder);
  	      }
    	}
      
    }
  }
  private IProject getProjectFromSelection(final IStructuredSelection selection) {
    IProject result = null;
    if (selection.size() == 1) {
      final Object firstSelectionElement = selection.getFirstElement();
      if (firstSelectionElement instanceof IFolder) {
          final IFolder folder = (IFolder) firstSelectionElement;
          result = folder.getProject();
        }
      if (firstSelectionElement instanceof IProject) {
        final IProject javaProject = (IProject) firstSelectionElement;
        result = javaProject.getProject();
      }
      if (firstSelectionElement instanceof IFile) {
        final IFile javaProject = (IFile) firstSelectionElement;
        result = javaProject.getProject();
      }
    }
    return result;
  }
  @Override
  public boolean isPageComplete() {
    return getWizard().canFinish();
  }

  @Override
  protected IStatus validateLinkedResource() {
    boolean valid = getWizard().canFinish();
    if (!valid) {
      final String errorMessage = String.format("A file with the name '%s' already exists in the project. Choose a different name for the diagram.",
              getDiagramName());
      this.setErrorMessage(errorMessage);
      return new Status(IStatus.ERROR, ActivitiPlugin.PLUGIN_ID, errorMessage);
    }
    return super.validateLinkedResource();
  }

  public String getDiagramName() {
    if (StringUtils.isNotBlank(super.getFileName())) {
      return super.getFileName();
    }
    return null;
  }

}
