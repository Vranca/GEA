package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Project;
import models.ProjectBrowserModel;
import models.WorkspaceModel;
import views.ApplicationView;
import views.ProjectBrowserView;

public class CloseAllProjectsListener implements ActionListener
{
	
	ApplicationView applicationView = null;
	
	public CloseAllProjectsListener(ApplicationView applicationView)
	{
		this.applicationView = applicationView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ProjectBrowserView projectBrowserView = applicationView.getProjectBrowserView();
		ProjectBrowserModel projectBrowserModel = projectBrowserView.getModel();
		for(Project project : projectBrowserModel.getOpenProjects())
		{
			for(WorkspaceModel workspaceModel : project.getAlgorithms())
			{
				workspaceModel.setIsOpen(false);
				workspaceModel.notifySubscribers();
				applicationView.getToolboxView().getModel().removeOpenWorkspaceModels(workspaceModel);
	    		workspaceModel.removeAllSubscribers();
			}
		}
	}

}
