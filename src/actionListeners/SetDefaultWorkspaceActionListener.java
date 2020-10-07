package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.SettingsView;

public class SetDefaultWorkspaceActionListener implements ActionListener
{

	SettingsModel settingsModel=null;
	SettingsView settingsView=null;
	public SetDefaultWorkspaceActionListener(SettingsModel settingsModel,SettingsView settingsView)
	{
		this.settingsModel=settingsModel;
		this.settingsView=settingsView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		settingsModel.applyDefulatWorksapceProperties();
		settingsModel.setWorkspaceProperties();
		settingsView.dispose();
	}

}
