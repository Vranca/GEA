package controllers;

import models.StatusBarModel;
import views.StatusBarView;

public class StatusBarController
{
	StatusBarModel model = null;
	StatusBarView view   = null;
	
	public StatusBarController(StatusBarModel model, StatusBarView view)
	{
		this.model = model;
		this.view = view;
		model.subscribe(view);
	}

}
