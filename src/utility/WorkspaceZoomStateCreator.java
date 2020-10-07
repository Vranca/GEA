package utility;

import models.WorkspaceModel;
import models.WorkspaceState;
import models.WorkspaceZoomState;

public class WorkspaceZoomStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) {
		return new WorkspaceZoomState(model);
	}

}
