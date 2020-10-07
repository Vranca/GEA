/***********************************************************************
 * Module:  ReadyState.java
 * Author:  User
 * Purpose: Defines the Class ReadyState
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

public class ReadyState implements ApplicationState, ToolbarState, MenuBarState
{
	
   public ReadyState() 
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
      return true;
   }
   
   @Override
   public Boolean isEditing() 
   {
      return false;
   }

   @Override
   public Boolean isSelection() 
   {
	   return false;
   }

@Override
	public void enableButtons(ToolbarView toolbar) {
	toolbar.enableNewDocument(true);
	toolbar.enableNewProject(true);
	toolbar.enableOpen(true);
	toolbar.enableSave(true);
	toolbar.enableSaveAll(true);
	toolbar.enableDelete(false);
	toolbar.enableCut(false);
	toolbar.enableCopy(false);
	toolbar.enablePaste(false);
	toolbar.enableZoomIn(false);
	toolbar.enableZoomOut(false);
	toolbar.enableZoom(false);
	toolbar.enableUndo(false);
	toolbar.enableRedo(false);
	
}

@Override
	public void enableMenuItems(MenuBarView view) {
	// TODO Auto-generated method stub
	view.enableItemNewAlgorithm(true);
	view.enableItemClose(false);
	view.enableItemCloseAll(false);
	view.enableItemSave(true);
	view.enableItemSaveAs(true);
	view.enableItemSaveAll(true);
	view.enableItemUndo(false);
	view.enableItemRedo(false);
	view.enableItemPaste(false);
	view.enableItemCopy(false);
	view.enableItemCut(false);
	view.enableItemDelete(false);
	view.enableItemSelect(false);
	view.enableItemSelectAll(false);
	view.enableAlgorithmOptions(false);
	view.enableObjectOptions(false);
	view.enableItemShowGuidelines(false);
	view.enableItemZoomIn(false);
	view.enableItemZoomOut(false);
	view.enableItemDefaultZoom(false);
	
}

@Override
	public String toString()
{
	return Localization.getInstance().getResources().getString("readystate");
}

@Override
	public ProjectBrowserView getProjectBrowserView(ApplicationView applicationView) 
{
		return applicationView.getProjectBrowserView();
}

@Override
	public ToolboxView getToolboxView(ApplicationView applicationView) 
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

}