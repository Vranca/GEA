package models;

import algorithmElements.AlgorithmElement;

public class AddLineCommand implements Command
{
	Receiver receiver = null;
	AlgorithmElement connection = null;
	
	public AddLineCommand(Receiver receiver, AlgorithmElement connection) 
	{
		this.receiver = receiver;
		this.connection = connection;
	}

	@Override
	public void execute()
	{
		receiver.executeAddLine(this);
	}

	@Override
	public void unexecute() 
	{
		receiver.unexecuteAddLine(this);
	}

	public final AlgorithmElement getConnection() {
		return connection;
	}

	public final void setConnection(AlgorithmElement connection) {
		this.connection = connection;
	}


}
