package views;

import javax.swing.JTabbedPane;
import actionListeners.TabChangeListener;
import models.OpenWorkspacesModel;
import models.WorkspaceModel;
import utility.TabbedWorkspaceUI;

public class WorkspaceTabbedView extends JTabbedPane implements Subscriber
{
	private static final long serialVersionUID = 1L;
	private  TabbedWorkspaceUI ui = null;
	private OpenWorkspacesModel openWorkspacesModel = new OpenWorkspacesModel();

	private WorkspaceScrollView workspaceScrollView = null;
	
	public WorkspaceTabbedView()
	{
		super();
		ui = new TabbedWorkspaceUI(this);
	}
	public void addWorkspaceToTabbedPane(WorkspaceView workspaceView,String workspaceName)
	{
		workspaceScrollView = new WorkspaceScrollView(workspaceView);
		addTab(workspaceName, workspaceScrollView);
		openWorkspacesModel.addOpenWorkspaceModels(workspaceView.getModel());
		workspaceView.getModel().addSubscribers(this);
	}
	public final WorkspaceView getActiveWorkspace()
	{
		return (WorkspaceView) ((WorkspaceScrollView) getSelectedComponent()).getWorkspaceView();
	}
	public final WorkspaceView getLastWorkspace()
	{
		if(this.getTabCount() > 0)
			return (WorkspaceView) ((WorkspaceScrollView) getComponentAt(getTabCount() - 1)).getWorkspaceView();
		return null;
	}
	public WorkspaceScrollView getWorkspaceScrollView() {
		return workspaceScrollView;
	}
	public void registerChangeListener(TabChangeListener listener)
	{
		this.addChangeListener(listener);
	}

	@Override
	public void updateUI() {
		super.updateUI();
		setUI(ui);
	}
	
	
	public final OpenWorkspacesModel getOpenWorkspacesModel() {
		return openWorkspacesModel;
	}
	public final void setOpenWorkspacesModel(OpenWorkspacesModel model) {
		this.openWorkspacesModel = model;
	}
	@Override
	public void update() {
		
			for(WorkspaceModel workspaceModel :openWorkspacesModel.getOpenWorkspaceModels())
			{
				if(workspaceModel.getIsOpen() == false)
				{
					openWorkspacesModel.removeOpenWorkspaceModels(workspaceModel);
					for(int i = 0; i< getTabCount();i++)
					{
						if(getTitleAt(i) == workspaceModel.getName())
						{
							removeTabAt(i);
							break;
						}
					}
					//workspaceModel.removeAllSubscribers();
					break;
				}
			}
	}
}
