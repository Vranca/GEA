package utility;

import java.util.HashMap;

import models.Command;
import models.Receiver;

public abstract class CommandFactory
{
	private static java.util.HashMap<String, CommandCreator> commandCreatorMap = createMap();
	
	public static Command createCommand(String command, Receiver receiver)
	{
		CommandCreator commandCreator = commandCreatorMap.get(command);
		return commandCreator.create(receiver);
	}

	private static HashMap<String, CommandCreator> createMap()
	{
		java.util.HashMap<String, CommandCreator> map = new HashMap<>();
		map.put("Delete", new DeleteCreateor());
		map.put("Paste", new PasteCreator());
		map.put("Save", new SaveCreator());
		map.put("Redo", new RedoCreator());
		map.put("Undo", new UndoCreator());
		map.put("Copy", new CopyCreator());
		map.put("Cut", new CutCreator());
		map.put("NewProject", new NewProjectCreator());
		map.put("ZoomIn", new ZoomInCreator());
		map.put("ZoomOut", new ZoomOutCreator());
		map.put("ResetZoom", new ResetZoomCreator());
		map.put("NewAlgorithm", new AddNewAlgorithmCreator());
		
		return map;
	}
}
