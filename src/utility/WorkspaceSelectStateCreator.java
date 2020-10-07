package utility;

import models.WorkspaceModel;
import models.WorkspaceSelectState;
import models.WorkspaceState;

public class WorkspaceSelectStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) {
		return new WorkspaceSelectState(model);
	}

}
