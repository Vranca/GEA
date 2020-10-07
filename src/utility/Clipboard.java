package utility;

import java.util.Vector;

import algorithmElements.AlgorithmElement;
import models.Project;
import models.WorkspaceModel;

public class Clipboard
{
	private Project project = null;
	private WorkspaceModel workspaceModel = null;
	private java.util.List<AlgorithmElement> elements = null;
	private static Clipboard instance = null;
	
	private Clipboard()
	{
		
	}
	
	public static Clipboard getClipboard()
	{
		if(instance == null)
		{
			instance = new Clipboard();
		}
		return instance;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public WorkspaceModel getWorkspaceModel() {
		return workspaceModel;
	}

	public void setWorkspaceModel(WorkspaceModel workspaceModel) {
		this.workspaceModel = workspaceModel;
	}

	public java.util.List<AlgorithmElement> getElements() {
		return elements;
	}

	public void setElements(java.util.List<AlgorithmElement> element) {
		this.elements = element;
	}
	
	public void setClipboardElements(java.util.List<AlgorithmElement> elements)
	{
		java.util.List<AlgorithmElement> copies = new Vector<AlgorithmElement>();
		
		for(int i = 0; i < elements.size(); i++)
		{
			copies.add(elements.get(i).copy());
		}
		
		this.elements = copies;
	}
	
	public Boolean isEmpty()
	{
		if(project != null || workspaceModel != null || elements != null)
			return false;
		return true;
	}
	
	public java.util.List<AlgorithmElement> getElementCopies()
	{
		java.util.List<AlgorithmElement> copies = new Vector<AlgorithmElement>();
		for(int i = 0; i < elements.size(); i++)
		{
			copies.add(elements.get(i).copyWithoutLocation());
		}
		return copies;
	}
}
