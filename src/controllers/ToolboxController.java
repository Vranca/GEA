package controllers;

import actionListeners.AddElementButtonListener;
import actionListeners.StyleButtonActionListener;
import actionListeners.PreviewElementActionListener;
import actionListeners.ToolboxStateChangeListener;
import actionListeners.ToolboxWorkspacePropertiesListener;
import models.ToolboxModel;
import views.ToolboxView;

public class ToolboxController
{
	ToolboxModel toolboxModel = null;
	ToolboxView  toolboxView  = null;
	public ToolboxController(ToolboxModel model, ToolboxView view)
	{
		toolboxModel = model;
		toolboxView = view;
		toolboxModel.subscribe(toolboxView);
		toolboxView.registerPreviewElementListener(new PreviewElementActionListener(toolboxView,toolboxModel));
		toolboxView.registerStyleButtonListener(new StyleButtonActionListener(toolboxModel));
		toolboxView.registerAddCommandListeners(new AddElementButtonListener(toolboxModel));
		toolboxView.registerToolboxStateChangeListener(new ToolboxStateChangeListener(toolboxModel));
		toolboxView.registerToolboxWorkspacePropertiesListener(new ToolboxWorkspacePropertiesListener(toolboxModel));
	}
}
