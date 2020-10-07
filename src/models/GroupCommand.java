package models;

import algorithmElements.GroupedElement;

public class GroupCommand implements Command
{
	private Receiver receiver = null;
	private GroupedElement groupedElement = null;
	
	public GroupCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		receiver.executeGroup(this);
	}

	@Override
	public void unexecute() 
	{
		receiver.unexecuteGroup(this);
	}

	public final GroupedElement getGroupedElement() {
		return groupedElement;
	}

	public final void setGroupedElement(GroupedElement groupedElement) {
		this.groupedElement = groupedElement;
	}

}
