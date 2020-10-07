package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Command;
import models.Receiver;
import models.WorkspaceModel;
import utility.CommandFactory;
import views.ApplicationView;

public class ToolbarCommandsListener implements ActionListener
{
	Receiver receiver = null;
	ApplicationView appView = null;
	
	public ToolbarCommandsListener(ApplicationView appView)
	{
		this.appView = appView;
	}
	public ToolbarCommandsListener(WorkspaceModel workspaceModel)
	{
		this.receiver = workspaceModel;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		if(appView != null)
			receiver = appView.getModel().getReceiver(appView);
	
		if(receiver!=null)
		{
			Command command = CommandFactory.createCommand(e.getActionCommand(), receiver);
			command.execute();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Option is not available!","ERROR",JOptionPane.ERROR_MESSAGE);
		}

	}

	
	
	
}
