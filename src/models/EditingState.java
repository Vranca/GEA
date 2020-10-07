/***********************************************************************
 * Module:  EditingState.java
 * Author:  User
 * Purpose: Defines the Class EditingState
 ***********************************************************************/

package models;

import utility.Localization;
import views.ApplicationView;
import views.MenuBarView;
import views.ProjectBrowserView;
import views.ToolbarView;
import views.ToolboxView;

public class EditingState implements ApplicationState, ToolbarState, MenuBarState 
{
	
   public EditingState() 
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
      return true;
   }

   @Override
   public Boolean isSelection() 
   {
	   return false;
}

@Override
	public void enableButtons(ToolbarView toolbar) 
	{
		toolbar.enableNewDocument(true);
		toolbar.enableNewProject(true);
		toolbar.enableOpen(true);
		toolbar.enableSave(true);
		toolbar.enableSaveAll(true);
		toolbar.enableDelete(false);
		toolbar.enableCut(false);
		toolbar.enableCopy(false);
		toolbar.enablePaste(false);
		toolbar.enableZoomIn(true);
		toolbar.enableZoomOut(true);
		toolbar.enableZoom(true);
		toolbar.enableUndo(false);
		toolbar.enableRedo(false);	
	}

	@Override
	public void enableMenuItems(MenuBarView view) {
		view.enableItemNewAlgorithm(true);
		view.enableItemClose(true);
		view.enableItemCloseAll(true);
		view.enableItemSave(true);
		view.enableItemSaveAs(true);
		view.enableItemSaveAll(true);
		view.enableItemUndo(true);
		view.enableItemRedo(true);
		view.enableItemPaste(false);
		view.enableItemCopy(false);
		view.enableItemCut(false);
		view.enableItemDelete(false);
		view.enableItemSelect(false);
		view.enableItemSelectAll(true);
		view.enableAlgorithmOptions(true);
		view.enableObjectOptions(false);
		view.enableItemShowGuidelines(true);
		view.enableItemZoomIn(true);
		view.enableItemZoomOut(true);
		view.enableItemDefaultZoom(true);
		
	}

@Override
public String toString()
{
	return Localization.getInstance().getResources().getString("editingstate");
}

@Override
public ProjectBrowserView getProjectBrowserView(ApplicationView applicationView) {
	return applicationView.getProjectBrowserView();
}

@Override
public ToolboxView getToolboxView(ApplicationView applicationView) {
	
	return applicationView.getToolboxView();
}

}