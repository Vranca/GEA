package utility;

import models.Command;
import models.CopyCommand;
import models.Receiver;

public class CopyCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new CopyCommand(receiver);
	}

}
