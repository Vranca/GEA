/***********************************************************************
 * Module:  ApplicationState.java
 * Author:  User
 * Purpose: Defines the Interface ApplicationState
 ***********************************************************************/

package models;

import views.ApplicationView;
import views.ProjectBrowserView;
import views.ToolboxView;

public interface ApplicationState 
{
   Boolean isIdle();
   Boolean isReady();
   Boolean isEditing();
   Boolean isSelection();
   ProjectBrowserView getProjectBrowserView(ApplicationView applicationView);
   ToolboxView getToolboxView(ApplicationView applicationView);
}