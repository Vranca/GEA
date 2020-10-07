package controllers;

import actionListeners.WorkspaceMouseListener;
import models.WorkspaceModel;
import views.WorkspaceView;

public class WorkspaceController
{
	WorkspaceModel workspaceModel = null;
	WorkspaceView  workspaceView  = null;
	
	public WorkspaceController(WorkspaceModel model, WorkspaceView view)
	{
		workspaceModel = model;
		workspaceView = view;
		workspaceModel.subscribe(workspaceView);
		
		workspaceView.addWorkspaceMouseListener(new WorkspaceMouseListener(workspaceModel, workspaceView));
		//workspaceView.registerMouseListener(new WorkspaceClickListener(workspaceModel, workspaceView));
		//workspaceView.registerMouseMotionListener(new WorkspaceMotionListener(workspaceModel, workspaceView));
	}

}
