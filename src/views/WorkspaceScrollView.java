package views;

import javax.swing.JScrollPane;

public class WorkspaceScrollView extends JScrollPane
{
	private static final long serialVersionUID = 1L;
	private WorkspaceView workspaceView = null;
	
	public WorkspaceScrollView(WorkspaceView workspaceView)
	{
		super(workspaceView);
		this.workspaceView = workspaceView;
		this.setWheelScrollingEnabled(true);
	}
	public WorkspaceView getWorkspaceView() {
		return workspaceView;
	}
	
	public String getName()
	{
		return workspaceView.getModel().getName();
	}
}
