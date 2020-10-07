package models;

public class ResetZoomCommand implements Command
{
	private Receiver receiver = null;
	
	public ResetZoomCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.executeResetZoom();
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
