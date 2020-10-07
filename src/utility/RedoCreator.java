package utility;

import models.Command;
import models.Receiver;
import models.RedoCommand;

public class RedoCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new RedoCommand(receiver);
	}

}
