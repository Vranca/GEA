package controllers;


import actionListeners.ProjectBrowserClickListener;
import actionListeners.ProjectBrowserRenameListener;
import models.ProjectBrowserModel;
import views.ProjectBrowserView;

public class ProjectBrowserController
{
	ProjectBrowserModel model= null;
	ProjectBrowserView view = null;
	
	public ProjectBrowserController(ProjectBrowserModel model,ProjectBrowserView view)
	{
		this.model = model;
		this.view = view;
		view.getModel().subscribe(view);
		view.registerTreeModelListener(new ProjectBrowserRenameListener(view));
		view.registerTreeSelectionListener(new ProjectBrowserClickListener(view));

		
	}
	
	
}
