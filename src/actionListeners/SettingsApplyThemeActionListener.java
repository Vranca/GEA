package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.SettingsView;

public class SettingsApplyThemeActionListener implements ActionListener
{
	SettingsModel settingsModel = null;
	SettingsView settingsView = null;
	
	public SettingsApplyThemeActionListener(SettingsModel settingsModel, SettingsView settingsView)
	{
		this.settingsModel = settingsModel;
		this.settingsView = settingsView;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String selectedTheme = (String) settingsView.getThemeList().getSelectedItem();
		
		
		settingsModel.setTheme(selectedTheme);
	}

}
