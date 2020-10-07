package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.WorkspaceDefaultPropertiesView;

public class WorkspaceDefualtGridlinesSpacingActionListener implements ActionListener
{

	SettingsModel settingsModel=null;
	WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView=null;
	public WorkspaceDefualtGridlinesSpacingActionListener(SettingsModel settingsModel,WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView)
	{
		this.settingsModel=settingsModel;
		this.workspaceDefaultPropertiesView=workspaceDefaultPropertiesView;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int spacing = Integer.parseInt(workspaceDefaultPropertiesView.getTextGridlinesSpacing().getText());
		
		settingsModel.setWorkspaceGridlines(spacing);

	}

}
