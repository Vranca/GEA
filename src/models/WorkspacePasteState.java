package models;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

import algorithmElements.AlgorithmElement;
import algorithmElements.GroupedElement;

public class WorkspacePasteState implements WorkspaceState
{
	WorkspaceModel model = null;
	Point position = null;
	
	public WorkspacePasteState(WorkspaceModel model)
	{
		this.model = model;
		position = new Point();
	}

	@Override
	public void leftButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		model.getNewAlgorithmElement().setPosition(position);
		
		PasteCommand pasteCommand = (PasteCommand) model.getUndoStack().peek();
		java.util.List<AlgorithmElement> pastedElements = pasteCommand.getPastedElement();
		if(pastedElements.size() > 1)
		{
			int oldSize = model.getAlgorithmElements().size();
			AddCommand command = new AddCommand(model, model.getNewAlgorithmElement());
			command.execute();
			int newSize = model.getAlgorithmElements().size();
			
			if(newSize > oldSize)
			{
				pasteCommand.setPosition(position);
				model.getUndoStack().pop();
				java.util.List<AlgorithmElement> list = new Vector<AlgorithmElement>();
				list.add(model.getNewAlgorithmElement());
				model.setSelectedElements(list);
				model.executeGroup(null);
				model.clearSelection();
				model.resetNewAlgorithmElement();
				model.setState(new WorkspaceSelectState(model));
			}
		}
		else 
		{		
			int oldSize = model.getAlgorithmElements().size();
			AddCommand command = new AddCommand(model, model.getNewAlgorithmElement());
			command.execute();
			GroupedElement element = (GroupedElement) model.getNewAlgorithmElement();
			element.setShape(pasteCommand.getPastedElement().get(0).getBounds());
			
			int newSize = model.getAlgorithmElements().size();
			if(newSize > oldSize)
			{
				pasteCommand.setPosition(position);
				model.getUndoStack().pop();
				java.util.List<AlgorithmElement> list = new Vector<AlgorithmElement>();
				list.add(model.getNewAlgorithmElement());
				model.setSelectedElements(list);
				model.executeGroup(null);				
				model.clearSelection();
				model.resetNewAlgorithmElement();
				model.setState(new WorkspaceSelectState(model));
			}
		}
	}

	@Override
	public void leftButtonReleasedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doubleClickAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		model.clearSelection();
		model.resetNewAlgorithmElement();
		model.setState(new WorkspaceSelectState(model));
	}

	@Override
	public void rightButtonReleasedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleButtonReleasedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMovedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		
		model.setNewAlgorithmElementPosition(position);
	}

	@Override
	public void mouseDraggedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
