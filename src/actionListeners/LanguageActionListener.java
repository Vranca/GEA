package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utility.Localization;

public class LanguageActionListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String lang = e.getActionCommand();
		Localization.getInstance().setLocalization(lang.substring(0, 2), lang.substring(2, 4));
	}

}
