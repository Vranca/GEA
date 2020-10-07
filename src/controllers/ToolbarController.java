package controllers;

import actionListeners.NewProjectActionListener;
import actionListeners.OpenProjectActionListener;
import actionListeners.ToolbarCommandsListener;
import models.ToolbarModel;
import views.ApplicationView;
import views.ToolbarView;

public class ToolbarController
{
	ToolbarModel toolbarModel = null;
	ToolbarView toolbarView   = null;
	
	public ToolbarController(ToolbarModel model, ToolbarView view)
	{
		toolbarModel = model;
		toolbarView = view;
		toolbarModel.subscribe(toolbarView);
		
		toolbarView.registerOpenProjectListener(new OpenProjectActionListener((ApplicationView)toolbarView.getTopLevelAncestor()));
		toolbarView.registerNewProjectListener(new NewProjectActionListener((ApplicationView)toolbarView.getTopLevelAncestor()));
		toolbarView.registerToolbarCommandsListener(new ToolbarCommandsListener((ApplicationView)toolbarView.getTopLevelAncestor()));
	}
	

}
