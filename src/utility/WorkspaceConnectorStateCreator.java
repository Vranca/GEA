package utility;

import models.WorkspaceConnectorState;
import models.WorkspaceModel;
import models.WorkspaceState;

public class WorkspaceConnectorStateCreator implements WorkspaceStateCreator
{

	@Override
	public WorkspaceState create(WorkspaceModel model) {
		// TODO Auto-generated method stub
		return new WorkspaceConnectorState(model);
	}

}
