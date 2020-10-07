package utility;

import models.AddNewProjectCommand;
import models.Command;
import models.Receiver;

public class NewProjectCreator implements CommandCreator
{

	@Override
	public Command create(Receiver receiver) {
		// TODO Auto-generated method stub
		return new AddNewProjectCommand(receiver);
	}

}
