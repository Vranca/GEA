package utility;

import models.Command;
import models.Receiver;
import models.UndoCommand;

public class UndoCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new UndoCommand(receiver);
	}

}
