/***********************************************************************
 * Module:  ProjectBrowserModel.java
 * Author:  User
 * Purpose: Defines the Class ProjectBrowserModel
 ***********************************************************************/

package models;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.tree.DefaultMutableTreeNode;
import com.google.gson.Gson;

import json.JSONProject;
import utility.LightMetalTheme;
import utility.Localization;
import utility.ModelMediator;

public class ProjectBrowserModel extends AbstractSubject implements Receiver 
{
   private MetalTheme theme = null;
   private String position;
   private DefaultMutableTreeNode selectedNode = null;
   private ModelMediator modelMediator = null;
   private int GridlinesSpasing;
   private boolean ShowGrid;
   private Dimension WorkspaceSize=null;
   private Color WorkspaceBackgroung=null;
   private DefaultMutableTreeNode removedNode = null;
   public DefaultMutableTreeNode getRemovedNode() {
	return removedNode;
}

public void setRemovedNode(DefaultMutableTreeNode removedNode) {
	this.removedNode = removedNode;
}

public int getGridlinesSpasing() {
	return GridlinesSpasing;
}

public void setGridlinesSpasing(int gridlinesSpasing) {
	GridlinesSpasing = gridlinesSpasing;
}

public boolean isShowGrid() {
	return ShowGrid;
}

public void setShowGrid(boolean showGrid) {
	ShowGrid = showGrid;
}

public Dimension getWorkspaceSize() {
	return WorkspaceSize;
}

public void setWorkspaceSize(Dimension workspaceSize) {
	WorkspaceSize = workspaceSize;
}

public Color getWorkspaceBackgroung() {
	return WorkspaceBackgroung;
}

public void setWorkspaceBackgroung(Color workspaceBackgroung) {
	WorkspaceBackgroung = workspaceBackgroung;
}

   
   private java.util.List<Project> openProjects = null;
   
   private Localization localization = null;
   
   public ProjectBrowserModel() 
   {
	   theme = new LightMetalTheme();
	   position = BorderLayout.WEST;
	   openProjects = new Vector<Project>();
	   localization = Localization.getInstance();
   }
   
   public ProjectBrowserModel(MetalTheme theme) 
   {
	   this.theme = theme;
	   position = BorderLayout.WEST;
	   localization = Localization.getInstance();
   }
   
   public Boolean isProjectOpen(Project project)
   {
	   Boolean projectIsOpen = false;
	   
	   for ( Project p : openProjects )
		   if( p.getName().equals(project.getName()))
			   projectIsOpen = true;
	   
	   return projectIsOpen;
   }
   
   public ProjectBrowserModel(MetalTheme theme, String position) 
   {
	   this.theme = theme;
	   this.position = position;
	   localization = Localization.getInstance();
   }
   
   
   public void executeCopy() {
      // TODO: implement
   }
   
   public void executeSave() {
	   Project project =  getProjectFromOpenProjects(getSelectedProjectNode().toString());
	   JSONProject jsonProject = new JSONProject(project);
	   FileWriter writer;
		Gson gson = new Gson();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("GEA Projects","gea"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setSelectedFile(new File("Projekat"));
		
		int userSelection = fileChooser.showSaveDialog(null);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave =fileChooser.getSelectedFile();

		    try 
		    {	    	
				 writer = new FileWriter(new File(fileToSave.getAbsoluteFile() +".gea"));
				gson.toJson(jsonProject,writer);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

      
   }
   
   public void executeCut(CutCommand command) {
      // TODO: implement
   }
   
   public void executePaste(PasteCommand command) {
      // TODO: implement
   }
   
   public void executeUndo() {
      // TODO: implement
   }
   
   public void executeRedo() {
      // TODO: implement
   }
   
   public void executeAdd(AddCommand command) {
      // TODO: implement
   }
   
   public void executeMove(MoveCommand command) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Project> getOpenProjects() {
      if (openProjects == null)
         openProjects = new java.util.Vector<Project>();
      return openProjects;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Project> getIteratorOpenProjects() {
      if (openProjects == null)
         openProjects = new java.util.Vector<Project>();
      return openProjects.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOpenProjects */
   public void setOpenProjects(java.util.List<Project> newOpenProjects) {
      removeAllOpenProjects();
      for (java.util.Iterator<Project> iter = newOpenProjects.iterator(); iter.hasNext();)
         addOpenProjects((Project)iter.next());
      notifySubscribers();
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addOpenProjects(Project newProject) {
      if (newProject == null)
         return;
      if (this.openProjects == null)
         this.openProjects = new java.util.Vector<Project>();
      if (!this.openProjects.contains(newProject))
         this.openProjects.add(newProject);
      notifySubscribers();
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeOpenProjects(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.openProjects != null)
         if (this.openProjects.contains(oldProject))
            this.openProjects.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOpenProjects() {
      if (openProjects != null)
         openProjects.clear();
      notifySubscribers();
   }
   
   public void addAlgorithToProject(WorkspaceModel algorithm, Project project)
   {
	   for( Project p : openProjects )
	   {
		   if ( p.getName().equals(project.getName()) )
		   {
			   p.addAlgorithms(algorithm);
		   }
	   }
	   
	   notifySubscribers();
   }
   public void addAlgorithmToProject(WorkspaceModel algorithm, String projectName)
   {
	   for( Project p : openProjects )
	   {
		   if ( p.getName().equals(projectName) )
		   {
			   p.addAlgorithms(algorithm);
		   }
	   }
	   
	   notifySubscribers();
   }
   public Boolean projectExists(String projectName)
   {
	   Boolean projectExists = false;
	   
	   if ( openProjects != null)
		   for( Project project : openProjects )
		   {
			   if ( projectName.equals(project.getName()))
				   projectExists = true;
		   }
	   
	   return projectExists;
   }
   public Boolean algorithmExists(String algorithmName)
   {
	   Boolean algorithmExists = false;
	   
	   if ( openProjects != null)
		   for( Project project : getOpenProjects() )
		   {
			   for(WorkspaceModel workspaceModel : project.getAlgorithms())
			   {
				   if(algorithmName.equals(workspaceModel.getName()))
						   algorithmExists = true;
			   }
		   }
	   
	   return algorithmExists;
   }
   
   
   public Project getProjectFromOpenProjects(String projectName)
   {
	   for ( Project p : openProjects )
	   {
		   if(p.getName().equals(projectName))
			   return p;
	   }
	   
	   return null;
   }

   public final MetalTheme getTheme() {
	   return theme;
   }

   public final void setTheme(MetalTheme theme) {
	   this.theme = theme;
   }

   public final String getPosition() {
	   return position;
   }

   public final void setPosition(String position) {
	   this.position = position;
   }

@Override
public void unexecutePaste(PasteCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void unexecuteAdd(AddCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void unexecuteMove(MoveCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void executeDelete(DeleteCommand command) {

	
	Project project =  getProjectFromOpenProjects(selectedNode.getParent().toString());
	
	if(project == null)
	{
		
		removedNode = getSelectedNode();
		project = getProjectFromOpenProjects(getSelectedNode().toString());
		for(int i = 0; i < project.getAlgorithms().size(); i++)
		{
			project.getAlgorithms().get(i).setIsOpen(false);;
			project.getAlgorithms().get(i).notifySubscribers();
			
		}
		removeOpenProjects(project);
	}
	else if(project != null)
	{
		removedNode = getSelectedNode();
		WorkspaceModel workspaceModel = project.getAgorithm(getSelectedNode().toString());
		workspaceModel.setIsOpen(false);
		project.removeAlgorithms(workspaceModel);
		workspaceModel.notifySubscribers();
		
	}
	modelMediator.updateState();
	notifySubscribers();
	
	removedNode = null;
}

@Override
public void unexecuteDelete(DeleteCommand command) {
	// TODO Auto-generated method stub
	
}
@Override
public void unexecuteAddLine(AddLineCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void executeAddLine(AddLineCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void addExecutedCommand(Command command) {
	// TODO Auto-generated method stub
	
}

@Override
public void addUnexecutedCommand(Command command) {
	// TODO Auto-generated method stub
	
}

@Override
public void executeSelect(SelectCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void unexecuteSelecet() {
	// TODO Auto-generated method stub
	
}

public String getLocalString(String key)
{
	return localization.getResources().getString(key);
}
public void executeAddProject()
{
	String projectName;
	
	Boolean nameValid = true;
	do
	{
		nameValid = true;
		
		projectName = JOptionPane.showInputDialog(null);
		
		if( (projectName != null) && (projectName.length() > 0) )
		{				
			nameValid = !projectExists(projectName);		
			if ( nameValid )
			{
				addOpenProjects(new Project(projectName));					
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Name already exists", "Name error", JOptionPane.ERROR_MESSAGE);
			}
		
		}
	
	
	} while (!nameValid && ((projectName != null) && (projectName.length() > 0)));
}

@Override
public void executeZoomIn() {
	// TODO Auto-generated method stub
	
}

@Override
public void executeZoomOut() {
	// TODO Auto-generated method stub
	
}

@Override
public void executeResetZoom() {
	// TODO Auto-generated method stub
	
}

public DefaultMutableTreeNode getSelectedNode() {
	return selectedNode;
}

public void setSelectedNode(DefaultMutableTreeNode selectedNode) {
	this.selectedNode = selectedNode;
}

public void resetSelectedNode() {
	this.selectedNode = null;
}

@Override
public void executeAddNewAlgorithm()
{
	modelMediator.createAlgorithm();
}

public ModelMediator getModelMediator() {
	return modelMediator;
}

public void setModelMediator(ModelMediator modelMediator) {
	this.modelMediator = modelMediator;
}

public DefaultMutableTreeNode getSelectedProjectNode()
{
	if ( !selectedNode.getAllowsChildren() )
	{
		return  (DefaultMutableTreeNode) selectedNode.getParent();
	}
	return selectedNode;
}

public Boolean addProject(String projectName)
{
	 Boolean projectAdded = !projectExists(projectName);
	
	if ( projectAdded )
	{
		addOpenProjects(new Project(projectName));					
	}
	else 
	{
		JOptionPane.showMessageDialog(null, Localization.getInstance().getResources().getString("newprojectactionlistener.namealreadyexists"), Localization.getInstance().getResources().getString("newprojectactionlistener.nameerror"), JOptionPane.ERROR_MESSAGE);
	}
	return projectAdded;
}
	public void renameProject(String newProjectName)
	{
		Project project = getProjectFromOpenProjects(getSelectedNode().toString());
		project.setName(newProjectName);
		notifySubscribers();
	}

@Override
public void unexecuteCut(CutCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void executeGroup(GroupCommand command) {
	// TODO Auto-generated method stub
	
}

@Override
public void unexecuteGroup(GroupCommand command) {
	// TODO Auto-generated method stub
	
}

}