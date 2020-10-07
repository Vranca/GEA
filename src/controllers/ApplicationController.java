package controllers;

import models.ApplicationModel;
import views.ApplicationView;

public class ApplicationController
{
	ApplicationView applicationView = null;
	ApplicationModel applicationModel = null;
	
	public ApplicationController(ApplicationModel model, ApplicationView view)
	{
		this.applicationModel = model;
		this.applicationView = view;
		applicationModel.subscribe(applicationView);
		applicationModel.getLocalization().addSubscribers(applicationView);
		applicationModel.getModelMediator().setApplicationView(applicationView);
		
		new MenuBarController(applicationModel.getMenuBarModel(), applicationView.getMenuBarView());
		new ToolbarController(applicationModel.getToolbarModel(), applicationView.getToolbarView());
		new StatusBarController(applicationModel.getStatusBarModel(), applicationView.getStatusBarView());
	}

}
