package utility;

import models.Command;
import models.Receiver;
import models.ResetZoomCommand;

public class ResetZoomCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver)
	{
		return new ResetZoomCommand(receiver);
	}

}
