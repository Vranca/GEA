package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ApplicationModel;
import utility.ModelMediator;
import views.ApplicationView;

public class OpenProjectActionListener implements ActionListener
{
	ModelMediator modelMediator = null;

	public  OpenProjectActionListener(ApplicationView applicationView)
	{
		ApplicationModel applicationModel = applicationView.getModel();
		modelMediator = applicationModel.getModelMediator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		modelMediator.openProject();
	}

}
