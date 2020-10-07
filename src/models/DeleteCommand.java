package models;

import algorithmElements.AlgorithmElement;

public class DeleteCommand implements Command
{
	private Receiver receiver = null;
	private java.util.List<AlgorithmElement> deletedElements = null;
	private java.util.List<Project> projects = null;
	private java.util.List<WorkspaceModel> workspaceModels = null;
	
	public DeleteCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void execute() 
	{ 	
		receiver.executeDelete(this);
	}

	@Override
	public void unexecute() 
	{
		receiver.unexecuteDelete(this);
	}

	public final java.util.List<AlgorithmElement> getDeletedElements() {
		return deletedElements;
	}

	public final void setDeletedElements(java.util.List<AlgorithmElement> deletedElement) {
		this.deletedElements = deletedElement;
	}

	public final java.util.List<Project> getProject() {
		return projects;
	}

	public final void setProject(java.util.List<Project> project) {
		this.projects = project;
	}

	public final java.util.List<WorkspaceModel> getWorkspaceModel() {
		return workspaceModels;
	}

	public final void setWorkspaceModel(java.util.List<WorkspaceModel> workspaceModel) {
		this.workspaceModels = workspaceModel;
	}

}
