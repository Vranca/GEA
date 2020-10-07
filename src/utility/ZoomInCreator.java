package utility;

import models.Command;
import models.Receiver;
import models.ZoomInCommand;

public class ZoomInCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) 
	{
		return new ZoomInCommand(receiver);
	}

}
