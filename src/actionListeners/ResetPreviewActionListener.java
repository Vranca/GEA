package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.WorkspaceDefaultPropertiesView;

public class ResetPreviewActionListener implements ActionListener
{

	SettingsModel settingsModel=null;
	WorkspaceDefaultPropertiesView workspaceDefulatPropertiesView=null;
	public ResetPreviewActionListener(SettingsModel settingsModel,WorkspaceDefaultPropertiesView workspaceDefulatPropertiesView)
	{
		this.settingsModel=settingsModel;
		this.workspaceDefulatPropertiesView=workspaceDefulatPropertiesView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		settingsModel.reset();

	}

}
