package utility;



import models.WorkspaceModel;
import models.WorkspaceState;

public interface WorkspaceStateCreator
{
	WorkspaceState create(WorkspaceModel model);
}
