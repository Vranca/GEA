package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.WorkspaceModel;

public class SelectActionListener implements ActionListener
{
	WorkspaceModel workspaceModel = null;
	
	public SelectActionListener(WorkspaceModel workspaceModel)
	{
		this.workspaceModel = workspaceModel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		workspaceModel.selectAll();
		workspaceModel.notifySubscribers();

	}

}
