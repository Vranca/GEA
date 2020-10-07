package utility;

import models.WorkspaceModel;
import models.WorkspacePasteState;
import models.WorkspaceState;

public class WorkspacePasteStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) 
	{
		return new WorkspacePasteState(model);
	}

}
