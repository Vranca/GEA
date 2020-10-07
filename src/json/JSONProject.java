package json;

import java.util.ArrayList;
import java.util.List;
import models.Project;
import models.WorkspaceModel;

public class JSONProject
{
	private List<JSONWorkspace> workspacesList = new ArrayList<JSONWorkspace>();
	private String name = null;
	
	public JSONProject(Project project)
	{
		for (WorkspaceModel workspaceModel : project.getAlgorithms())
		{
			workspacesList.add(new JSONWorkspace(workspaceModel));
		}
		this.name = project.getName();
	}

	public List<JSONWorkspace> getWorkspaces() {
		return workspacesList;
	}

	public void setWorkspaces(List<JSONWorkspace> workspaces) {
		this.workspacesList = workspaces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
