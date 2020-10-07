/***********************************************************************
 * Module:  ApplicationView.java
 * Author:  User
 * Purpose: Defines the Class ApplicationView
 ***********************************************************************/

package views;

import models.ApplicationModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.javadocking.DockingManager;
import com.javadocking.dock.CompositeLineDock;
import com.javadocking.dock.Position;
import com.javadocking.dock.SingleDock;
import com.javadocking.dockable.DefaultDockable;
import com.javadocking.dockable.Dockable;
import com.javadocking.model.FloatDockModel;;

public class ApplicationView extends JFrame implements Subscriber 
{
	private static final long serialVersionUID = 1L;
	
	private ApplicationModel model = null;
	private MenuBarView menuBarView = null;
	private StatusBarView statusBarView = null;
	private ToolbarView toolbarView = null;
	private ToolboxView toolboxView = null;
	private ProjectBrowserView projectBrowserView = null;
	private WorkspaceTabbedView tabbedPane = null;
	
	private JPanel dockPanel = null;
	private FloatDockModel dockModel = null;
	private CompositeLineDock lineDock = null;
   
   /** @param model */
	public ApplicationView(ApplicationModel model) 
	{
		this.model = model;
		this.model.updateTheme(this);
		
		this.menuBarView = new MenuBarView(model.getMenuBarModel());
		this.toolbarView = new ToolbarView(model.getToolbarModel());
		this.statusBarView = new StatusBarView(model.getStatusBarModel());
		
		this.tabbedPane = new WorkspaceTabbedView();
		
		setTitle(model.getLocalString("application.settitle"));
		setIconImage(new ImageIcon("icons/gea.png").getImage());
		
		setLayout(new BorderLayout());
		setSize(model.getDefaultWidth(), model.getDefaultHeight());
		setMinimumSize(new Dimension(600, 400));
		setLocation(50, 50);
		
		setJMenuBar(menuBarView);		
		addToolbar(toolbarView);
		addStatusBar(statusBarView);
		
		dockPanel = new JPanel();
		dockPanel.setLayout(new BorderLayout());
		add(dockPanel,BorderLayout.CENTER);
		
		dockModel = new FloatDockModel();
		dockModel.addOwner("App", this);
		DockingManager.setDockModel(dockModel);
		
		lineDock = new CompositeLineDock();
		lineDock.setGrid(false);
		
		addTabbedPane(tabbedPane);
		
		dockPanel.add((Component)lineDock, BorderLayout.CENTER);
		dockModel.addRootDock("dock", lineDock, this);	
		
		//pack();
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addToolbar(ToolbarView toolbar)
	{
		add(toolbar,BorderLayout.NORTH);
	}
	
	public void addStatusBar(StatusBarView satusBar)
	{
		add(satusBar, BorderLayout.SOUTH);
	}
	
	public void addProjectBrowser(ProjectBrowserView projectBrowser)
	{

			this.projectBrowserView = projectBrowser;
			Dockable dockableProjectBrowser = new DefaultDockable(model.getLocalString("application.projectbrowser"), projectBrowserView);
			
			SingleDock singleDock = new SingleDock();
			singleDock.addDockable(dockableProjectBrowser, new Position(0));
			singleDock.setSize(200,800);
			singleDock.setPreferredSize(new Dimension(200, 800));
			singleDock.setMaximumSize(new Dimension(200,1000));

			lineDock.addChildDock(singleDock, new Position(model.getProjectBrowserPosition()));
			revalidate();
	}
	
	public void addTabbedPane(WorkspaceTabbedView tabbedPane)
	{
		Dockable dockableTabbedPane = new DefaultDockable("Workspace", tabbedPane);
		
		SingleDock singleDock = new SingleDock();
		singleDock.addDockable(dockableTabbedPane, new Position(0));
		
		lineDock.addChildDock(singleDock, new Position(model.getWorkspacePosition()));
		
		revalidate();
	}
	
	public final WorkspaceTabbedView getWorkspaceTabbedView() {
		return tabbedPane;
	}

	public void addToolbox(ToolboxView toolbox)
	{

		if(this.toolboxView == null)
		{
			this.toolboxView =toolbox;
			Dockable dockableToolbox = new DefaultDockable(model.getLocalString("application.toolbox"), toolbox);
			
			SingleDock singleDock = new SingleDock();
			singleDock.addDockable(dockableToolbox, new Position(0));
			singleDock.setSize(200,800);
			singleDock.setPreferredSize(new Dimension(200, 800));
			singleDock.setMaximumSize(new Dimension(250,1000));
			singleDock.setMinimumSize(new Dimension(200, 800));
			lineDock.addChildDock(singleDock, new Position(model.getToolboxPosition()));
		}
		
		revalidate();
	}
	public ProjectBrowserView getProjectBrowserView() {
		return projectBrowserView;
	}

	public void setProjectBrowserView(ProjectBrowserView projectBrowserView) {
		this.projectBrowserView = projectBrowserView;
	}

	public final MenuBarView getMenuBarView() 
	{
		return menuBarView;
	}

	public final StatusBarView getStatusBarView() {
		return statusBarView;
	}

	public final ToolbarView getToolbarView() {
		return toolbarView;
	}

	public final ToolboxView getToolboxView() {
		return toolboxView;
	}

	public  void update()
	{
		updateLanguage();
		//pack();
	}

	public final ApplicationModel getModel() {
		return model;
	}
	
	private void updateLanguage()
	{
		// UPDATE svih komponenti na osnovu lokalizacije iz modela
		//setTitle(model.getLocalization().getResources().getString("ApplicationTitle")); -- PRIMJER
	}
	

}