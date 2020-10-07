package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.SettingsView;

public class SettingsCloseActionListener implements ActionListener
{

	SettingsView settingsView=null;
	public SettingsCloseActionListener(SettingsView settingsView)
	{
		this.settingsView=settingsView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		settingsView.dispose();

	}

}
