package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.WorkspaceDefaultPropertiesView;

public class WorkspaceDefulatPropertiesShowGridListener implements ActionListener
{

	SettingsModel settingsModel=null;
	WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView=null;
	public WorkspaceDefulatPropertiesShowGridListener(SettingsModel settingsModel,WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView)
	{
		this.settingsModel=settingsModel;	
		this.workspaceDefaultPropertiesView=workspaceDefaultPropertiesView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		settingsModel.invertShowGrid();
	}

}
