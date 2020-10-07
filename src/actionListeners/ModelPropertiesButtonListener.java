package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.WorkspaceModel;
import views.WorkspacePropertiesView;

public class ModelPropertiesButtonListener implements ActionListener
{
	WorkspacePropertiesView view = null;
	WorkspaceModel model = null;
	
	public ModelPropertiesButtonListener(WorkspacePropertiesView view, WorkspaceModel selectedModel)
	{
		this.view = view;
		this.model = selectedModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
		case "Apply":
			model.setBackgroundColor(view.getPreviewModel().getBackgroundColor());
			model.setGridSize(view.getPreviewModel().getGridSize());
			model.setShowGrid(view.getPreviewModel().getShowGrid());
			break;
		case "Reset":
			view.resetProperties(model);
			break;
		default:
			break;
		}
	}

}
