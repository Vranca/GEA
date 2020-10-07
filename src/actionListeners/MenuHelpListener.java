package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AboutView;
import views.HelpContentsView;

public class MenuHelpListener implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Help":
			new HelpContentsView();
			break;
		case "About":
			new AboutView();
			break;
		default:
			break;
		}
	}

}
