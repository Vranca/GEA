package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import models.ToolboxModel;
import models.WorkspaceModel;
import views.ApplicationView;

public class ToolboxWorkspacePropertiesListener implements ActionListener
{
	ToolboxModel toolboxModel = null;
	WorkspaceModel workspaceModel = null;
	ApplicationView appView = null;
	
	public ToolboxWorkspacePropertiesListener(ToolboxModel toolboxModel)
	{
		this.toolboxModel = toolboxModel;
	}
	public ToolboxWorkspacePropertiesListener(WorkspaceModel workspaceModel)
	{
		this.workspaceModel = workspaceModel;
	}
	public ToolboxWorkspacePropertiesListener(ApplicationView appView)
	{
		this.appView = appView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(toolboxModel != null)
			workspaceModel = toolboxModel.getSelectedModel();
		else if(appView != null)
			workspaceModel = appView.getToolboxView().getModel().getSelectedModel();
		
		switch (e.getActionCommand())
		{
		case "Gridlines":
		{
			workspaceModel.setShowGrid(!workspaceModel.getShowGrid());
			break;
		}
		case "Group":
		{
			workspaceModel.executeGroup(null);
			break;
		}
		case "BackgroundColor":
		{
			JButton btnColor = (JButton) e.getSource();
			Color color=JColorChooser.showDialog(btnColor,toolboxModel.getLocalString("toolbox.selectcolor"),toolboxModel.getSelectedModel().getBackgroundColor());    
			btnColor.setBackground(color);
			toolboxModel.getSelectedModel().setBackgroundColor(color);
			toolboxModel.getSelectedModel().notifySubscribers();
		}
		default:
			break;
		}

	}

}
