package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ToolboxModel;
import models.WorkspaceModel;
import models.WorkspaceState;
import utility.WorkspaceStateFactory;

public class ToolboxStateChangeListener implements ActionListener
{
	ToolboxModel model = null;
	WorkspaceModel workspaceModel = null;
	
	public ToolboxStateChangeListener(ToolboxModel model)
	{
		this.model = model;
	}
	
	public ToolboxStateChangeListener(WorkspaceModel model)
	{
		this.workspaceModel = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(model != null)
			workspaceModel = model.getSelectedModel();
				
		WorkspaceState workspaceState = WorkspaceStateFactory.createWorkpaceState(e.getActionCommand(), workspaceModel);
		workspaceModel.setState(workspaceState);
	}

}
