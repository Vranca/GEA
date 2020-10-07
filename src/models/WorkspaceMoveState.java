package models;

import java.awt.Point;
import java.awt.event.MouseEvent;

import algorithmElements.AlgorithmElement;

public class WorkspaceMoveState implements WorkspaceState
{
	WorkspaceModel model = null;
	MoveCommand command = null;
	Point position = null;

	public WorkspaceMoveState(WorkspaceModel model)
	{
		this.model = model;
		position = new Point();
	}
	public WorkspaceMoveState()
	{
		position = new Point();
	}
	
	public void setModel(WorkspaceModel model) {
		this.model = model;
	}
	@Override
	public void leftButtonPressedAction(MouseEvent e) {
		position = new Point();
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		
		AlgorithmElement movingElement = model.getElementAt(position);
		if(movingElement != null)
		{
			model.setMovingElement(movingElement);
			command = new MoveCommand(model, movingElement);
		}
		else
		{
			model.clearSelection();
			model.resetMovingElement();
			model.setState(new WorkspaceSelectState(model));
		}
	}

	@Override
	public void leftButtonReleasedAction(MouseEvent e)
	{			
		if(command != null)
		{
			position = new Point();
			position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
			model.setMovingElementPosition(position);
			command.setNewPosition(model.getMovingElement().getPosition());
			command.execute();
		}
		command = null;
	}

	@Override
	public void doubleClickAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
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

	}

	@Override
	public void mouseDraggedAction(MouseEvent e)
	{
		position = new Point();
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		model.setMovingElementPosition(position);
	}

}
