package utility;

import models.Command;
import models.Receiver;

public interface CommandCreator
{
	Command create(Receiver receiver);
}
