package utility;

import java.util.HashMap;

import models.WorkspaceModel;
import models.WorkspaceState;

public abstract class WorkspaceStateFactory 
{
	private static java.util.HashMap<String, WorkspaceStateCreator> workspaceStateCreatorMap = createMap();
	
	public static WorkspaceState createWorkpaceState(String command, WorkspaceModel model)
	{
		WorkspaceStateCreator workspaceState = workspaceStateCreatorMap.get(command);
		return workspaceState.create(model);
	}
	
	private static HashMap<String, WorkspaceStateCreator> createMap()
	{
		java.util.HashMap<String, WorkspaceStateCreator> map = new HashMap<>();
		map.put("Selection", new WorkspaceSelectStateCreator());
		map.put("Move", new WorkspaceMoveStateCreator());
		map.put("Add", new WorkspaceAddStateCreator());
		map.put("Connector", new WorkspaceConnectorStateCreator());
		map.put("Paste", new WorkspacePasteStateCreator());
		map.put("Zoom", new WorkspaceZoomStateCreator());
		
		return map;
	}
}
