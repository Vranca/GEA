/***********************************************************************
 * Module:  ReadyState.java
 * Author:  User
 * Purpose: Defines the Class SelectionState
 ***********************************************************************/

package models;

import controllers.TabbedWorkspaceController;
import controllers.ToolboxController;
import utility.Localization;
import views.ApplicationView;
import views.MenuBarView;
import views.ProjectBrowserView;
import views.ToolbarView;
import views.ToolboxView;
import views.WorkspaceTabbedView;

public class SelectionState implements ApplicationState, ToolbarState, MenuBarState
{
	
   public SelectionState() 
   {
	   
   }
   
   @Override
   public Boolean isIdle() 
   {
      return false;
   }
   
   @Override
   public Boolean isReady() 
   {
      return false;
   }
   
   @Override
   public Boolean isEditing() 
   {
      return false;
   }

   @Override
   public Boolean isSelection() 
   {
	   return true;
   }

@Override
public void enableButtons(ToolbarView toolbar)
{
	toolbar.enableDelete(true);
	toolbar.enableCut(true);
	toolbar.enableCopy(true);	
}

@Override
public void enableMenuItems(MenuBarView view) 
{
	view.enableItemPaste(true);
	view.enableItemCopy(true);
	view.enableItemCut(true);
	view.enableItemDelete(true);
	view.enableObjectOptions(true);
}

@Override
public String toString()
{
	return Localization.getInstance().getResources().getString("selection.selected");
}

@Override
public ProjectBrowserView getProjectBrowserView(ApplicationView applicationView) {
	return applicationView.getProjectBrowserView();

}

@Override
public ToolboxView getToolboxView(ApplicationView applicationView) {
	// TODO Auto-generated method stub
	if(applicationView.getToolboxView() == null)
	{
		ApplicationModel applicationModel = applicationView.getModel();
		WorkspaceTabbedView workspaceTabbedView = applicationView.getWorkspaceTabbedView();
		
		OpenWorkspacesModel openWorkspacesModel = new OpenWorkspacesModel();
		
		ToolboxModel toolboxModel = new ToolboxModel(applicationModel.getTheme());
		ToolboxView toolboxView = new ToolboxView(toolboxModel);
		applicationView.addToolbox(toolboxView);
		new ToolboxController(toolboxModel, toolboxView);
		
		toolboxModel.setOpenWorkspacesModel(openWorkspacesModel);
			
		applicationView.getToolbarView().getModel().setToolboxModel(toolboxModel);

		new TabbedWorkspaceController(toolboxModel, workspaceTabbedView);
		
		applicationModel.setState(new EditingState());
		return applicationView.getToolboxView();
	}
	else
		return applicationView.getToolboxView();
}

}