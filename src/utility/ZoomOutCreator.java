package utility;

import models.Command;
import models.Receiver;
import models.ZoomOutCommand;

public class ZoomOutCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) 
	{
		return new ZoomOutCommand(receiver);
	}

}
