package utility;

import java.awt.event.MouseListener;

import javax.swing.plaf.metal.MetalTabbedPaneUI;

import actionListeners.TabClickAdapter;
import views.WorkspaceTabbedView;

public class TabbedWorkspaceUI extends MetalTabbedPaneUI
{
	private WorkspaceTabbedView tabbedView = null;
	
	public TabbedWorkspaceUI(WorkspaceTabbedView tabbedView)
	{
		super();
		this.tabbedView = tabbedView;
	}
	
	@Override
	protected MouseListener createMouseListener()
	{
		return new TabClickAdapter(tabbedView);
	}
}
