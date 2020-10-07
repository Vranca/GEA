package models;

public class ZoomInCommand implements Command
{
	Receiver receiver = null;
	
	public ZoomInCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void execute() 
	{
		receiver.executeZoomIn();
	}

	@Override
	public void unexecute() 
	{
		receiver.executeZoomOut();
	}

}
