/***********************************************************************
 * Module:  IdleState.java
 * Author:  User
 * Purpose: Defines the Class IdleState
 ***********************************************************************/

package models;

import controllers.ProjectBrowserController;
import utility.Localization;
import views.ApplicationView;
import views.MenuBarView;
import views.ProjectBrowserView;
import views.ToolbarView;
import views.ToolboxView;

public class IdleState implements ApplicationState, ToolbarState, MenuBarState
{
	
   public IdleState() 
   {
	   
   }
   
   @Override
   public Boolean isIdle() 
   {
      return true;
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
	   return false;
   }

@Override
public void enableButtons(ToolbarView toolbar) 
{
	// TODO Auto-generated method stub
	toolbar.enableNewDocument(false);
	toolbar.enableNewProject(true);
	toolbar.enableOpen(true);
	toolbar.enableSave(false);
	toolbar.enableSaveAll(false);
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
	view.enableItemNewAlgorithm(false);
	view.enableItemClose(false);
	view.enableItemCloseAll(false);
	view.enableItemSave(false);
	view.enableItemSaveAs(false);
	view.enableItemSaveAll(false);
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
	return Localization.getInstance().getResources().getString("idlestate");
}

@Override
public ProjectBrowserView getProjectBrowserView(ApplicationView applicationView)
{
	ApplicationModel applicationModel=applicationView.getModel();
	ProjectBrowserModel projectBrowserModel = new ProjectBrowserModel(applicationModel.getTheme());
	ProjectBrowserView projectBrowserView = new ProjectBrowserView(projectBrowserModel);
	applicationView.addProjectBrowser(projectBrowserView);
	new ProjectBrowserController(projectBrowserModel,projectBrowserView);
	
	applicationModel.updateTheme(applicationView);	
	applicationModel.setState(new ReadyState());

	return projectBrowserView;
}

@Override
public ToolboxView getToolboxView(ApplicationView applicationView) {
	// TODO Auto-generated method stub
	return null;
}

}