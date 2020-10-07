package utility;

import models.Command;
import models.CutCommand;
import models.Receiver;

public class CutCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new CutCommand(receiver);
	}

}
