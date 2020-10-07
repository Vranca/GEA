package controllers;

import actionListeners.TabChangeListener;
import models.ToolboxModel;
import views.WorkspaceTabbedView;

public class TabbedWorkspaceController
{
	private ToolboxModel model = null;
	private WorkspaceTabbedView view = null;
	
	public TabbedWorkspaceController(ToolboxModel model, WorkspaceTabbedView view)
	{
		
		this.model = model;
		this.view = view;
		//view.getOpenWorkspacesModel().addSubscribers(view);
		view.registerChangeListener(new TabChangeListener(this.model,this.view));
		
	}
	
	
	
	
	
}
