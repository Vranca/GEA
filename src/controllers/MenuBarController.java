package controllers;

import actionListeners.CloseAllProjectsListener;
import actionListeners.CloseProjectActionListener;
import actionListeners.LanguageActionListener;
import actionListeners.MenuHelpListener;
import actionListeners.NewProjectActionListener;
import actionListeners.OpenProjectActionListener;
import actionListeners.OptionsClickActionListener;
import actionListeners.SaveAsListener;
import actionListeners.ToolbarCommandsListener;
import actionListeners.ToolboxWorkspacePropertiesListener;
import models.MenuBarModel;
import views.ApplicationView;
import views.MenuBarView;

public class MenuBarController
{
	MenuBarModel menuBarModel = null;
	MenuBarView menuBarView   = null;
	
	public MenuBarController(MenuBarModel model, MenuBarView view)
	{
		this.menuBarModel = model;
		this.menuBarView = view;
		menuBarModel.subscribe(menuBarView);
		
		NewProjectActionListener newProjectListener = new NewProjectActionListener(((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerNewProjectlistener(newProjectListener);		
		menuBarView.registerOptionsListener(new OptionsClickActionListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerOpenProjectListener(new OpenProjectActionListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerLanguageListener(new LanguageActionListener());
		menuBarView.registerMenuBarCommandsListener(new ToolbarCommandsListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerCloseProjectListener(new CloseProjectActionListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerCloseAllProjectsListener(new CloseAllProjectsListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerHelpListener(new MenuHelpListener());
		menuBarView.registerShowGridlinesActionListener(new ToolboxWorkspacePropertiesListener((ApplicationView)menuBarView.getTopLevelAncestor()));
		menuBarView.registerSaveAsListener(new SaveAsListener((ApplicationView)menuBarView.getTopLevelAncestor()));
	}
}
