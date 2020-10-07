package actionListeners;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

import models.Project;
import models.WorkspaceModel;
import views.ApplicationView;
import views.ProjectBrowserView;

public class ProjectBrowserRenameListener implements TreeModelListener
{
	ProjectBrowserView projectBrowserView = null;
	ApplicationView appView = null;
	WorkspaceModel algorithm = null;
	
	public ProjectBrowserRenameListener(ProjectBrowserView projectBrowserView)
	{
		this.projectBrowserView = projectBrowserView;
		this.appView = (ApplicationView) projectBrowserView.getTopLevelAncestor();
	}

	
	public void treeNodesChanged(TreeModelEvent e) {
		int index = e.getChildIndices()[0];
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());
		String newName = ((DefaultMutableTreeNode)(node.getChildAt(index))).toString();
		Project project = projectBrowserView.getModel().getProjectFromOpenProjects(node.toString());
		if(project!=null)
		{
			algorithm = project.getAlgorithms().get(index);
			String oldName = algorithm.getName();
			algorithm.setName(newName);
			for(int i = 0 ; i < appView.getWorkspaceTabbedView().getTabCount(); i++)
			{
				if(appView.getWorkspaceTabbedView().getTitleAt(i).equals(oldName))
				{
					appView.getWorkspaceTabbedView().setTitleAt(i, newName);
				}
			}
		}
		else
		{
			project = projectBrowserView.getModel().getOpenProjects().get(index);
			project.setName(newName);
		}
	}

	@Override
	public void treeNodesInserted(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeStructureChanged(TreeModelEvent e) {
		// TODO Auto-generated method stub

	}

}
