package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ApplicationModel;
import utility.ModelMediator;
import views.ApplicationView;

public class NewProjectActionListener implements ActionListener
{
	ModelMediator modelMediator = null;

	public NewProjectActionListener(ApplicationView applicationView)
	{
		ApplicationModel applicationModel = applicationView.getModel();
		modelMediator = applicationModel.getModelMediator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		modelMediator.createProject();
	}
}
