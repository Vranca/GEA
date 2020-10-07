package actionListeners;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.ToolboxModel;
import models.WorkspaceModel;
import views.WorkspaceTabbedView;

public class TabChangeListener implements ChangeListener
{
	private ToolboxModel model = null;
	private WorkspaceTabbedView view = null;
	
	public TabChangeListener(ToolboxModel model, WorkspaceTabbedView view)
	{
		
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		for(WorkspaceModel workspaceModel :  model.getOpenWorkspaceModels())
		{
			workspaceModel.setIsSelected(false);
			workspaceModel.clearSelection();
			model.clearPreview();
		}
		if(view.getSelectedIndex() >= 0 && !model.getOpenWorkspaceModels().isEmpty())
			model.getWorkspaceModelAt(view.getSelectedIndex()).setIsSelected(true);
	}

}
