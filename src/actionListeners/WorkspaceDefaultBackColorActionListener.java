package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import models.SettingsModel;
import views.WorkspaceDefaultPropertiesView;

public class WorkspaceDefaultBackColorActionListener implements ActionListener
{
	SettingsModel settingsModel=null;
	WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView=null;
	public WorkspaceDefaultBackColorActionListener(SettingsModel settingsModel,WorkspaceDefaultPropertiesView workspaceDefaultPropertiesView)
	{
		this.settingsModel=settingsModel;
		this.workspaceDefaultPropertiesView=workspaceDefaultPropertiesView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color initialcolor=settingsModel.getWorkspacePreviewModel().getBackgroundColor();    
		Color color=JColorChooser.showDialog(workspaceDefaultPropertiesView.getButtonBackColor(),"ForeColor",initialcolor);   
		settingsModel.setWorkspaceBackgroundColor(color);

	}

}
