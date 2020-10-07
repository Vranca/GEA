package actionListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import controllers.WorkspaceController;
import models.EditingState;
import models.Project;
import models.ReadyState;
import models.SelectionState;
import models.WorkspaceModel;
import views.ApplicationView;
import views.ProjectBrowserContextView;
import views.ProjectBrowserView;
import views.WorkspaceView;

public class ProjectBrowserClickListener implements MouseListener
{
	ProjectBrowserView view = null;
	ApplicationView appView = null;
	WorkspaceModel algorithm = null;
	TreePath path = null;
	
	public ProjectBrowserClickListener(ProjectBrowserView view)
	{
		this.view = view;
		this.appView = (ApplicationView) this.view.getTopLevelAncestor();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
		if(SwingUtilities.isLeftMouseButton(e))
		{
			path = view.getTree().getPathForLocation(e.getX(), e.getY());
			if(path!=null)
			{
				view.getModel().setSelectedNode((DefaultMutableTreeNode) path.getLastPathComponent());
				
				 if (e.getClickCount() == 2)
				 {		 

						 Project project = (view.getModel().getProjectFromOpenProjects(((DefaultMutableTreeNode) path.getLastPathComponent()).getParent().toString()));
						
						 if(project != null)
						 {
							 algorithm = project.getAgorithm(path.getLastPathComponent().toString());
							 if(appView.getToolboxView().getModel().getWorkspace(algorithm.getName()) == null)
							 {
								 appView.getToolboxView().getModel().addOpenWorkspaceModels(algorithm);
								 algorithm.addSubscribers(appView.getToolboxView().getModel());
								 algorithm.addSubscribers(appView.getToolbarView());
								 algorithm.addSubscribers(appView.getWorkspaceTabbedView());
								 WorkspaceView workspaceView = new WorkspaceView(algorithm);
								 algorithm.setIsOpen(true);
								 appView.getWorkspaceTabbedView().addWorkspaceToTabbedPane(workspaceView, algorithm.getName());
								 new WorkspaceController(algorithm, workspaceView);
								 appView.getModel().setState(new EditingState());
								 algorithm.notifySubscribers();
							 }
						 }	
					 
				}
				 else {
					appView.getModel().setState(new SelectionState());
				}
			}
			else
			{
				view.getModel().resetSelectedNode();
				view.getTree().clearSelection();
				if(appView.getToolboxView() == null)
					appView.getModel().setState(new ReadyState());
				else {
					appView.getModel().setState(new EditingState());
				}
			}
			
	    }	 
		if(SwingUtilities.isRightMouseButton(e))
		{
			ProjectBrowserContextView projectBrowserContextView = new ProjectBrowserContextView();
			projectBrowserContextView.show(e.getComponent(), e.getX(), e.getY());
			projectBrowserContextView.registerCloseActionListener(new CloseProjectActionListener(appView));
			projectBrowserContextView.registerNewAlgoritamLCommandListener(new ToolbarCommandsListener(appView));
			projectBrowserContextView.registerNewProjectActionListener(new NewProjectActionListener(appView));
			projectBrowserContextView.registerOpenProjectListener(new OpenProjectActionListener(appView));
			projectBrowserContextView.registerCloseAllProjectsListener(new CloseAllProjectsListener(appView));
		
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
