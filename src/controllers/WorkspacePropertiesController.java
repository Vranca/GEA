package controllers;

import actionListeners.ModelPropertiesButtonListener;
import actionListeners.ModelPropertiesListener;
import models.WorkspaceModel;
import views.WorkspacePropertiesView;

public class WorkspacePropertiesController
{
	WorkspacePropertiesView view = null;
	WorkspaceModel model = null;
	
	public WorkspacePropertiesController(WorkspaceModel model, WorkspacePropertiesView view)
	{
		this.model = model;
		this.view = view;
		
		this.view.registeModelPropertiesListener(new ModelPropertiesListener(this.view));
		this.view.registerButtonListener(new ModelPropertiesButtonListener(this.view, this.model));
	}
}
