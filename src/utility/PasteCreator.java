package utility;

import models.Command;
import models.PasteCommand;
import models.Receiver;

public class PasteCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new PasteCommand(receiver);
	}

}
