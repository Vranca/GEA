package json;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import models.Project;
import models.WorkspaceModel;
import utility.ElementFactory;

public class JSONProjectReader
{
	private JSONProject jsonProject = null;
	private List<JSONWorkspace> jsonWorkspaces = new ArrayList<JSONWorkspace>();
	
	private Project project = null;
	private List<WorkspaceModel> workspaceModels = new ArrayList<WorkspaceModel>();
	
	public JSONProjectReader()
	{
		
	}

	public JSONProject getJsonProject() {
		return jsonProject;
	}

	public void setJsonProject(JSONProject jsonProject) {
		this.jsonProject = jsonProject;
	}
	
	public void getWorkspaces()
	{
		for(JSONWorkspace workspace : jsonProject.getWorkspaces())
		{
			jsonWorkspaces.add(workspace);
		}
	}
	public void createWorkspaceModels()
	{
		for(JSONWorkspace workspace : jsonWorkspaces)
		{
			WorkspaceModel workspaceModel = new WorkspaceModel();
			workspaceModel.setBackgroundColor(new Color(workspace.getBackColor().getR(),workspace.getBackColor().getG(),workspace.getBackColor().getB()));
			workspaceModel.setShowGrid(workspace.getGrid().getShowGrid());
			workspaceModel.setGridSize(workspace.getGrid().getGridSpacing());
			workspaceModel.setName(workspace.getName());
			workspace.setDefaultVisualStyle(workspace.getDefaultVisualStyle());
			workspace.setWidth(workspace.getWidth());
			workspace.setHeight(workspace.getHeight());
			if(workspace.getSymbols().size() > 0)
				for(int i = 0; i< workspace.getSymbols().size(); i++)
				{
					workspaceModel.createElementFromJSON(ElementFactory.createElementFromJson(workspace.getSymbols().get(i)));
				}
			if(workspace.getGroupedElements().size() > 0)
				for(int i = 0; i <workspace.getGroupedElements().size() ; i++)
				{
					workspaceModel.createElementFromJSON(ElementFactory.createGroupedElementFromJson(workspace.getGroupedElements().get(i)));
				}
			if(workspace.getConnections().size() > 0)
				for(int i = 0; i <workspace.getConnections().size() ; i++)
				{
					workspaceModel.setNewAlgorithmElement((ElementFactory.createConnectionFromJson(workspace.getConnections().get(i),workspaceModel.getAlgorithmElements())));
					workspaceModel.addNewConnection();
				}
			
			workspaceModels.add(workspaceModel);
		}
	}
	public Project createPoject()
	{
		project = new Project(jsonProject.getName());
		project.setAlgorithms(workspaceModels);
		return project;
	}


	
	
}
