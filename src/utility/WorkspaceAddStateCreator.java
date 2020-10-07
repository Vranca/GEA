package utility;

import models.WorkspaceAddState;
import models.WorkspaceModel;
import models.WorkspaceState;

public class WorkspaceAddStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) {
		return new WorkspaceAddState(model);
	}

}
