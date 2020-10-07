package models;

import java.util.Vector;

import algorithmElements.AlgorithmElement;

public class SelectCommand implements Command
{
	private Receiver receiver = null;
	private java.util.List<AlgorithmElement> selectedElements = null;
	
	public SelectCommand(Receiver receiver)
	{
		this.receiver = receiver;;
	}

	@Override
	public void execute()
	{
		receiver.executeSelect(this);
	}

	@Override
	public void unexecute() 
	{
		receiver.unexecuteSelecet();
	}

	public final java.util.List<AlgorithmElement> getSelectedElements() {
		return selectedElements;
	}

	public final void setSelectedElements(java.util.List<AlgorithmElement> selectedElement) {
		this.selectedElements = selectedElement;
	}
	
	public final void addSelectedElements(AlgorithmElement selectedElement) 
	{
		if(selectedElement == null)
			return;
		if(selectedElements == null)
			selectedElements = new Vector<AlgorithmElement>();
		if(!this.selectedElements.contains(selectedElement))
			selectedElements.add(selectedElement);
	}
	
}
