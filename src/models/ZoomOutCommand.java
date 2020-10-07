package models;

public class ZoomOutCommand implements Command
{
	private Receiver receiver = null;

	public ZoomOutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.executeZoomOut();
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub
		receiver.executeZoomIn();
	}

}
