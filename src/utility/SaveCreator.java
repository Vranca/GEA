package utility;

import models.Command;
import models.Receiver;
import models.SaveCommand;

public class SaveCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		return new SaveCommand(receiver);
	}

}
