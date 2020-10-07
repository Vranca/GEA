package utility;

import models.WorkspaceModel;
import models.WorkspaceMoveState;
import models.WorkspaceState;

public class WorkspaceMoveStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) {
		return new WorkspaceMoveState(model);
	}

}
