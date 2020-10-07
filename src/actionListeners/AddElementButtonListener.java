package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algorithmElements.AlgorithmElement;
import models.ToolboxModel;
import models.WorkspaceAddState;
import models.WorkspaceModel;
import utility.ElementFactory;

public class AddElementButtonListener implements ActionListener
{
	ToolboxModel toolboxModel = null;
	WorkspaceModel workspaceModel = null;
	
	public AddElementButtonListener(ToolboxModel toolboxModel)
	{
		this.toolboxModel = toolboxModel;
	}
	public AddElementButtonListener(WorkspaceModel workspaceModel)
	{
		this.workspaceModel = workspaceModel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(toolboxModel != null)
			 workspaceModel = toolboxModel.getSelectedModel();
		
		workspaceModel.clearSelection();
		AlgorithmElement element = ElementFactory.createElement(e.getActionCommand(), workspaceModel.getDefaultVisualStyle());
		workspaceModel.setNewAlgorithmElement(element);
		workspaceModel.setState(new WorkspaceAddState(workspaceModel));
	}

}
