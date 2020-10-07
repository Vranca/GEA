package models;


public class AddNewProjectCommand implements Command
{
	
	Receiver receiver=null;
    ProjectBrowserModel pm=null;

	public AddNewProjectCommand(Receiver receiver)
	{
		this.receiver=receiver;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.executeAddProject();
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
