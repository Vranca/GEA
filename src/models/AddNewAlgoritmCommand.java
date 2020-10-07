package models;

public class AddNewAlgoritmCommand implements Command
{

	Receiver receiver = null;
	
	public AddNewAlgoritmCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		
		receiver.executeAddNewAlgorithm();
	}


	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}


}
