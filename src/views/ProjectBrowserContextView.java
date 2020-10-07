package views;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import actionListeners.CloseAllProjectsListener;
import actionListeners.CloseProjectActionListener;
import actionListeners.NewProjectActionListener;
import actionListeners.OpenProjectActionListener;
import actionListeners.ToolbarCommandsListener;
import utility.Localization;

public class ProjectBrowserContextView extends JPopupMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem menuAddNewProject = null;
	private JMenuItem menuOpenProject = null;
	private JMenuItem menuCloseProject = null;
	private JMenuItem menuCloseAllProjects = null;
	
	private JMenuItem menuAddNewAlgorithm = null;
	private JMenuItem menuCloseAlgorithm = null;
	
	public ProjectBrowserContextView()
	{
		super();
		
		menuAddNewProject = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.addnewproject"));
		menuOpenProject = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.openproject"));
		menuCloseProject = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.closeproject"));
		menuCloseAllProjects = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.closeallprojects"));
		
		menuAddNewAlgorithm = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.addnewalgorithm"));
		menuAddNewAlgorithm.setActionCommand("NewAlgorithm");
		menuCloseAlgorithm = new JMenuItem(Localization.getInstance().getResources().getString("projectbrowsercontextview.closealgorithm"));
		
		add(menuAddNewProject);
		add(menuOpenProject);
		add(menuCloseProject);
		add(menuCloseAllProjects);
		addSeparator();
		add(menuAddNewAlgorithm);
		add(menuCloseAlgorithm);
	}
	public void registerOpenProjectListener(OpenProjectActionListener listener)
	{
		menuOpenProject.addActionListener(listener);
	}
	
	public void registerNewAlgoritamLCommandListener(ToolbarCommandsListener listener)
	{
		menuAddNewAlgorithm.addActionListener(listener);
	}
	
	public void registerNewProjectActionListener(NewProjectActionListener listener)
	{
		menuAddNewProject.addActionListener(listener);
	}
	public void registerCloseActionListener(CloseProjectActionListener listener)
	{
		menuCloseAlgorithm.addActionListener(listener);
		menuCloseProject.addActionListener(listener);
	}
	public void registerCloseAllProjectsListener(CloseAllProjectsListener listener)
	{
		menuCloseAllProjects.addActionListener(listener);
	}

	
}
