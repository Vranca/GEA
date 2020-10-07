package utility;

import models.AddNewAlgoritmCommand;
import models.Command;
import models.Receiver;

public class AddNewAlgorithmCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		// TODO Auto-generated method stub
		return new AddNewAlgoritmCommand(receiver);
	}

}
