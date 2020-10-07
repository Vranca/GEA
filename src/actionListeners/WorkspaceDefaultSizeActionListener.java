package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.SettingsModel;
import views.WorkspaceDefaultPropertiesView;

public class WorkspaceDefaultSizeActionListener implements ActionListener
{
	SettingsModel settingsModel=null;
	WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView=null;
	public WorkspaceDefaultSizeActionListener(SettingsModel settingsModel,WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView)
	{
		this.settingsModel=settingsModel;
		this.workspaceDefaultPropertiesView=workspaceDefaultPropertiesView;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int height=Integer.parseInt(workspaceDefaultPropertiesView.getTextHeightSize().getText());
		int width=Integer.parseInt(workspaceDefaultPropertiesView.getTextWidhtSize().getText());
		
		settingsModel.setWorkspaceSize(width, height);

	}

}
