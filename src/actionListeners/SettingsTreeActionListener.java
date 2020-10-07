package actionListeners;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import models.SettingsModel;
import views.SettingsView;

public class SettingsTreeActionListener implements TreeSelectionListener
{

	SettingsModel settingsModel=null;
	SettingsView settingsView=null;
	public SettingsTreeActionListener(SettingsModel settingsModel,SettingsView settingsView)
	{
		this.settingsModel=settingsModel;
		this.settingsView=settingsView;
	}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		settingsView.displayCards();
	}

}
