package utility;

import models.Command;
import models.DeleteCommand;
import models.Receiver;

public class DeleteCreateor implements CommandCreator
{
	@Override
	public Command create(Receiver receiver) {
		return new DeleteCommand(receiver);
	}

}
