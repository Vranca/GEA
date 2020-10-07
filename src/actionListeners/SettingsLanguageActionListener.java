package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.SettingsView;

public class SettingsLanguageActionListener implements ActionListener
{
	SettingsView settingsView=null;
	public SettingsLanguageActionListener(SettingsView settingsView)
	{
		this.settingsView=settingsView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=(String)settingsView.getLanguageList().getSelectedItem();
		switch (s)
		{
		case "English":
			settingsView.getButtonApplyLanguage().setActionCommand("enUS");
			break;
		case "Srpski latinica":
			settingsView.getButtonApplyLanguage().setActionCommand("srBA");
			break;
		case "Srpski ćirilica":
			settingsView.getButtonApplyLanguage().setActionCommand("srRS");
			break;
		}

	}

}
