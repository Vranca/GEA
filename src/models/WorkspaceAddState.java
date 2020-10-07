package models;

import java.awt.Point;
import java.awt.event.MouseEvent;

import utility.ElementFactory;

public class WorkspaceAddState implements WorkspaceState
{
	WorkspaceModel model = null;
	Point position = null;
	
	public WorkspaceAddState(WorkspaceModel model)
	{
		this.model = model;
		position = new Point();
	}
	public WorkspaceAddState()
	{
		position = new Point();
	}
	@Override
	public void leftButtonPressedAction(MouseEvent e) 
	{
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		model.getNewAlgorithmElement().setPosition(position);

		AddCommand command = new AddCommand(model, model.getNewAlgorithmElement());
		command.execute();
		model.setNewAlgorithmElement(ElementFactory.createElement(model.getNewAlgorithmElement().getElementType(), model.getDefaultVisualStyle()));
		model.getNewAlgorithmElement().setPosition(position);
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
	public void rightButtonPressedAction(MouseEvent e) 
	{
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
	public void mouseMovedAction(MouseEvent e)
	{
		position.setLocation(e.getX() / model.getZoomScale(), e.getY() / model.getZoomScale());
		
		model.setNewAlgorithmElementPosition(position);
	}

	@Override
	public void mouseDraggedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setModel(WorkspaceModel model) {
		this.model = model;
	}

}
