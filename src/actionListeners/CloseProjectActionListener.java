package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Project;
import models.ProjectBrowserModel;
import models.WorkspaceModel;
import views.ApplicationView;
import views.ProjectBrowserView;

public class CloseProjectActionListener implements ActionListener
{
	ApplicationView applicationView = null;
	public CloseProjectActionListener(ApplicationView applicationView)
	{
		this.applicationView = applicationView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProjectBrowserView projectBrowserView = applicationView.getProjectBrowserView();
		ProjectBrowserModel projectBrowserModel = projectBrowserView.getModel();
		Project project = projectBrowserModel.getProjectFromOpenProjects(projectBrowserModel.getSelectedNode().getParent().toString());
		if(project == null)
		{
			project = projectBrowserModel.getProjectFromOpenProjects(projectBrowserModel.getSelectedProjectNode().toString());
			for(WorkspaceModel workspaceModel : project.getAlgorithms())
			{
				workspaceModel.setIsOpen(false);
				workspaceModel.notifySubscribers();
				applicationView.getToolboxView().getModel().removeOpenWorkspaceModels(workspaceModel);
	    		workspaceModel.removeAllSubscribers();
			}
		}
		else
		{
			WorkspaceModel workspaceModel = project.getAgorithm(projectBrowserModel.getSelectedNode().toString());
			workspaceModel.setIsOpen(false);
            applicationView.getToolboxView().getModel().removeOpenWorkspaceModels(workspaceModel);
            workspaceModel.notifySubscribers();
    		workspaceModel.removeAllSubscribers();
		}
		
	}

}
