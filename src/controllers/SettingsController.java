package controllers;

import actionListeners.LanguageActionListener;
import actionListeners.ResetPreviewActionListener;
import actionListeners.SetDefaultWorkspaceActionListener;
import actionListeners.SettingsApplyThemeActionListener;
import actionListeners.SettingsCloseActionListener;
import actionListeners.SettingsLanguageActionListener;
import actionListeners.SettingsLayoutActionListener;
import actionListeners.SettingsTreeActionListener;
import actionListeners.WorkspaceDefaultBackColorActionListener;
import actionListeners.WorkspaceDefaultSizeActionListener;
import actionListeners.WorkspaceDefualtGridlinesSpacingActionListener;
import actionListeners.WorkspaceDefulatPropertiesShowGridListener;
import models.SettingsModel;
import views.SettingsView;

public class SettingsController
{
	SettingsView settingsView=null;
	SettingsModel settingsModel=null;
	
	public SettingsController(SettingsView settingsView,SettingsModel settingsModel)
	{
		this.settingsView=settingsView;
		this.settingsModel=settingsModel;
		registerActionListeners();
	}
	private void registerActionListeners()
	{
		settingsModel.subscribe(settingsView);
		settingsView.registerSettingsTreeActionListener(new SettingsTreeActionListener(settingsModel, settingsView));
		settingsView.registerWorkspaceShowGridListener(new WorkspaceDefulatPropertiesShowGridListener(settingsModel,settingsView.getWorkspacePropertiesView()));
		settingsView.registerWorkspaceDefaultBackColorActionListener(new WorkspaceDefaultBackColorActionListener(settingsModel,settingsView.getWorkspacePropertiesView()));
		settingsView.registerWorkspaceDefaultGridlinesSpacingActionListener(new WorkspaceDefualtGridlinesSpacingActionListener(settingsModel, settingsView.getWorkspacePropertiesView()));
		settingsView.registerWorkspaceDefaultSizeActionListener(new WorkspaceDefaultSizeActionListener(settingsModel, settingsView.getWorkspacePropertiesView()));
		settingsView.registerSettingsLanguageActionListener(new SettingsLanguageActionListener(settingsView));
		settingsView.registerApplyLanguageActionListener(new LanguageActionListener());
		settingsView.registerSettingsCloseActionListener(new SettingsCloseActionListener(settingsView));
		settingsView.registerSettingsApplyThemeActionListener(new SettingsApplyThemeActionListener(settingsModel, settingsView));
		settingsView.registerSettingsLayoutActionListener(new SettingsLayoutActionListener(settingsView,settingsModel));
		settingsView.registerSetDefualtWorkspaceActionListener(new SetDefaultWorkspaceActionListener(settingsModel, settingsView));
		settingsView.registerResetPreviewActionListener(new ResetPreviewActionListener(settingsModel,settingsView.getWorkspacePropertiesView()));
		
		settingsModel.getWorkspacePreviewModel().addSubscribers(settingsView.getWorkspacePropertiesView().getPanelWorkspace());
		settingsModel.getWorkspacePreviewModel().addSubscribers(settingsView.getWorkspacePropertiesView());
	}
}

