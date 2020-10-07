package utility;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.DefaultMetalTheme;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import controllers.WorkspaceController;
import json.JSONProject;
import json.JSONProjectReader;
import models.ApplicationModel;
import models.EditingState;
import models.OpenWorkspacesModel;
import models.Project;
import models.ProjectBrowserModel;
import models.ReadyState;
import models.SelectionState;
import models.SettingsModel;
import models.ToolboxModel;
import models.WorkspaceModel;
import views.ApplicationView;
import views.ProjectBrowserView;
import views.WorkspaceTabbedView;
import views.WorkspaceView;

public class ModelMediator
{
	private ApplicationModel applicationModel = null;
	private ProjectBrowserModel projectBrowserModel = null;
	private ToolboxModel toolboxModel = null;
	private ApplicationView applicationView = null;
	private OpenWorkspacesModel workspaceModel = null;
	private SettingsModel settingsModel=null;

	public SettingsModel getSettingsModel() {
		return settingsModel;
	}

	public void setSettingsModel(SettingsModel settingsModel) {
		this.settingsModel = settingsModel;
	}

	public ModelMediator(ApplicationModel applicationModel, ProjectBrowserModel projectBrowserModel,ToolboxModel toolboxModel,ApplicationView applicationView)
	{
		this.applicationModel = applicationModel;
		this.projectBrowserModel = projectBrowserModel;
		this.toolboxModel = toolboxModel;
		this.applicationView = applicationView;
	}

	public ApplicationView getApplicationView() {
		return applicationView;
	}

	public void setApplicationView(ApplicationView applicationView) {
		this.applicationView = applicationView;
	}

	public ModelMediator()
	{
		workspaceModel = new OpenWorkspacesModel();
	}

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}

	public ProjectBrowserModel getProjectBrowserModel() {
		return projectBrowserModel;
	}

	public void setProjectBrowserModel(ProjectBrowserModel projectBrowserModel) {
		this.projectBrowserModel = projectBrowserModel;
	}

	public ToolboxModel getToolboxModel() {
		return toolboxModel;
	}

	public void setToolboxModel(ToolboxModel toolboxModel) {
		this.toolboxModel = toolboxModel;
	}
	
	public void createProject()
	{	
		String projectName  = null;
		
		Boolean projectAdded = true;
		do
		{
			projectAdded = true;
			
			projectName = JOptionPane.showInputDialog(Localization.getInstance().getResources().getString("newprojectactionlistener.selectprojectname"));
				
			if( (projectName != null) && (projectName.length() > 0) )
			{
				ProjectBrowserView projectBrowserView = null;		
				projectBrowserView = applicationModel.getState().getProjectBrowserView(applicationView);
				setProjectBrowserModel(projectBrowserView.getModel());
				projectBrowserModel.setModelMediator(this);
							
				projectAdded = projectBrowserModel.addProject(projectName);
				
			}	
		} while (!projectAdded && ((projectName != null) && (projectName.length() > 0)));
}
	public void openProject()
	{
			Gson gson = new Gson();
	        File selectedFile = null;
	    	JFileChooser jfc = new JFileChooser();
	    	jfc.setFileFilter(new FileNameExtensionFilter("GEA Projects","gea"));
	    	JSONProject jsonProject = null;
	    	JSONProjectReader projectReader = new JSONProjectReader();
	    	Project project = null;
	    	WorkspaceTabbedView workspaceTabbedView = applicationView.getWorkspaceTabbedView();
	    	
			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				 selectedFile = jfc.getSelectedFile();
					
				try
				{
					FileReader reader = new FileReader(selectedFile);
					jsonProject = gson.fromJson(reader, JSONProject.class);
					reader.close();
					projectReader.setJsonProject(jsonProject);
					projectReader.getWorkspaces();
					projectReader.createWorkspaceModels();
					project = projectReader.createPoject();
					ProjectBrowserView projectBrowserView = applicationModel.getState().getProjectBrowserView(applicationView);
					setProjectBrowserModel(projectBrowserView.getModel());
					if(!projectBrowserModel.projectExists(project.getName()))
					{
						projectBrowserModel.setModelMediator(this);
						projectBrowserModel.addOpenProjects(project);
						ToolboxModel toolboxModel = applicationModel.getState().getToolboxView(applicationView).getModel();
		
						for(WorkspaceModel workspaceModel : project.getAlgorithms())
						{
							WorkspaceView workspaceView = new WorkspaceView(workspaceModel);
							new WorkspaceController(workspaceModel, workspaceView);
							workspaceTabbedView.addWorkspaceToTabbedPane(workspaceView, workspaceModel.getName());
							workspaceModel.setModelMediator(this);
					    	
							toolboxModel.addOpenWorkspaceModels(workspaceModel);
							toolboxModel.setModelMediator(this);
							setToolboxModel(toolboxModel);
							
							workspaceModel.addSubscribers(applicationView.getToolboxView().getModel());
							workspaceModel.addSubscribers(applicationView.getToolbarView());
							
							if(workspaceTabbedView.getTabCount() == 1)
							{
								workspaceModel.setIsSelected(true);
							}
						}
				}
				else
				{
					JOptionPane.showMessageDialog(null, Localization.getInstance().getResources().getString("newprojectactionlistener.namealreadyexists"), Localization.getInstance().getResources().getString("newprojectactionlistener.nameerror"), JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e)
			{
				
			}
			catch (JsonSyntaxException  e) {
				JOptionPane.showMessageDialog(null, "File is not supported!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
			applicationModel.updateTheme(applicationView);
			
	}
	public void createAlgorithm()
	{
		String workspaceName;
		Boolean algorithmExists = false;
		WorkspaceTabbedView workspaceTabbedView = applicationView.getWorkspaceTabbedView();
		
		if ( projectBrowserModel.getSelectedNode() == null )
		{
			JOptionPane.showMessageDialog(applicationView, Localization.getInstance().getResources().getString("newalgorithmactionlistener.selectandopenwarning"), Localization.getInstance().getResources().getString("newalgorithmactionlistener.error"), JOptionPane.WARNING_MESSAGE);
		}
		else 
		{
			
			String projectName = projectBrowserModel.getSelectedProjectNode().toString();
			
			
			do
			{
				workspaceName = JOptionPane.showInputDialog(Localization.getInstance().getResources().getString("newalgorithmactionlistener.enterdocname"));
				algorithmExists = projectBrowserModel.algorithmExists(workspaceName);
				if(!algorithmExists)
				{
					if ( (workspaceName != null) && (workspaceName.length() > 0) )
					{
						WorkspaceModel workspaceModel = new WorkspaceModel(workspaceName);
						workspaceModel.setBackgroundColor(applicationModel.getConfig().getJavaWorkspaceColor());
						workspaceModel.setGridSize(applicationModel.getConfig().getGridSpacing());
						workspaceModel.setShowGrid(applicationModel.getConfig().isShowGrid());
						workspaceModel.setWorkspaceSize(new Dimension(applicationModel.getConfig().getWorkspaceWidth(), applicationModel.getConfig().getWorkspaceHeight()));
						
						WorkspaceView workspaceView = new WorkspaceView(workspaceModel);
						new WorkspaceController(workspaceModel, workspaceView);
						
						workspaceModel.setModelMediator(this);
						addWorkspaceModel(workspaceModel);
						
						workspaceTabbedView.addWorkspaceToTabbedPane(workspaceView, workspaceName);
						
						projectBrowserModel.addAlgorithmToProject(workspaceModel, projectName);
					
						ToolboxModel toolboxModel = applicationModel.getState().getToolboxView(applicationView).getModel();
						
						toolboxModel.addOpenWorkspaceModels(workspaceModel);
						toolboxModel.setModelMediator(this);
						setToolboxModel(toolboxModel);
						
						workspaceModel.addSubscribers(applicationView.getToolboxView().getModel());
						workspaceModel.addSubscribers(applicationView.getToolbarView());
						
						if(workspaceTabbedView.getTabCount() == 1)
						{
							workspaceModel.setIsSelected(true);
						}
					
						applicationModel.updateTheme(applicationView);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, Localization.getInstance().getResources().getString("newprojectactionlistener.namealreadyexists"), Localization.getInstance().getResources().getString("newprojectactionlistener.nameerror"), JOptionPane.ERROR_MESSAGE);
				

				}
			}while(algorithmExists);
		}
		
		
	}
	
	public void clearSelection()
	{
		applicationView.getProjectBrowserView().getTree().clearSelection();
		projectBrowserModel.resetSelectedNode();
		applicationModel.setState(new EditingState());
	}
	
	public void setSelection()
	{
		applicationModel.setState(new SelectionState());
	}

	public final OpenWorkspacesModel getWorkspaceModel() {
		return workspaceModel;
	}

	public final void setWorkspaceModel(OpenWorkspacesModel workspaceModel) {
		this.workspaceModel = workspaceModel;
	}
	
	public final void addWorkspaceModel(WorkspaceModel workspaceModel)
	{
		this.workspaceModel.addOpenWorkspaceModels(workspaceModel);
	}

	public void setTheme(DefaultMetalTheme theme)
	{
		applicationModel.setTheme(theme);
		applicationModel.updateTheme(applicationView);
	}
	
	public DefaultMetalTheme getTheme()
	{
		return (DefaultMetalTheme) applicationModel.getTheme();
	}
	
	public ApplicationModel setApplicationLayout()
	{
		return getApplicationModel();
	}
	
	public void setDefaultWorkspaceBackground(Color color)
	{
		applicationModel.getConfig().setWorkspaceColor(color);
		applicationModel.saveConfig();
	}
	
	public void setDefulatWorkspaceSize(Dimension dimension)
	{
		applicationModel.getConfig().setWorkspaceWidth(dimension.width);
		applicationModel.getConfig().setWorkspaceHeight(dimension.height);
		applicationModel.saveConfig();
	}
	
	public void setDefaulWorkspaceGridlinesSpacing(int gridlinesSpacing)
	{
		applicationModel.getConfig().setGridSpacing(gridlinesSpacing);
		applicationModel.saveConfig();
	}
	
	public void setDefulatWorkspaceShowGrid(boolean showGrid)
	{
		applicationModel.getConfig().setShowGrid(showGrid);
		applicationModel.saveConfig();
	}
	public void setDefaultLayout(int prjPosition, int workspacePosition,int toolboxPosition)
	{
		applicationModel.setProjectBrowserPosition(prjPosition);
		applicationModel.setWorkspacePosition(workspacePosition);
		applicationModel.setToolboxPosition(toolboxPosition);
		applicationModel.getConfig().updateConfig(applicationModel);
		applicationModel.saveConfig();
	}
	
	public void updateState()
	{
		projectBrowserModel.resetSelectedNode();
		if(projectBrowserModel.getOpenProjects().isEmpty() && applicationView.getToolboxView() != null)
		{
			applicationModel.setState(new EditingState());
		}
		else if(projectBrowserModel.getOpenProjects().isEmpty())
		{
			applicationModel.setState(new ReadyState());
		}
	}
	
	public void saveAs(File file)
	{
		BufferedImage imagebuf=null;
	    WorkspaceView view = applicationView.getWorkspaceTabbedView().getActiveWorkspace();
	    
	    try {
	        imagebuf = new Robot().createScreenCapture(view.getBounds());
	    } catch (AWTException e1) {
	        e1.printStackTrace();
	    }  
	     Graphics2D graphics2D = imagebuf.createGraphics();
	     view.paint(graphics2D);
	     try {
	        ImageIO.write(imagebuf,"png", file);
	    } catch (Exception e) {
	        System.out.println("error");
	    }
	}
	
}
