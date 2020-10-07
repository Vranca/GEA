package models;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import algorithmElements.ConnectingState;
import algorithmElements.Connection;
import algorithmElements.FinishedState;
import algorithmElements.StartingState;
import utility.Localization;

public class WorkspaceConnectorState implements WorkspaceState
{
	WorkspaceModel model = null;
	Point position = null;
	Connection connector = null;
	
	public WorkspaceConnectorState(WorkspaceModel model)
	{
		this.model = model;
		model.resetNewAlgorithmElement();
		//position = new Point();
	}
	public WorkspaceConnectorState()
	{
		position = new Point();
	}
	@Override
	public void leftButtonPressedAction(MouseEvent e)
	{
		if(model.getNewAlgorithmElement() == null)
		{
			position = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
			if(model.getElementAt(position) != null)
			{
				connector = new Connection();
				connector.setStartingElement(model.getElementAt(position));
				connector.setState(new StartingState());
				model.setNewAlgorithmElement(connector);
			}
		}
		else
		{
			position = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
			if(model.getElementAt(position) != null)
			{
				
				if(connector.setFinalElement(model.getElementAt(position)) != null)
				{
					connector.setState(new FinishedState());
					AddLineCommand command = new AddLineCommand(model, connector);
					command.execute();
				}
				else {
					JOptionPane.showMessageDialog(null, Localization.getInstance().getResources().getString("workspaceconnectorstate.notaligned"), Localization.getInstance().getResources().getString("workspaceconnectorstate.error"), JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				connector.addPoints(position);
				connector.setState(new ConnectingState());
				model.notifySubscribers();
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
		if(model.getNewAlgorithmElement() != null)
		{
			position = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
			
			
			connector.setPreviewPoint(position);
			model.notifySubscribers();	
		}
	}

	@Override
	public void mouseDraggedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void setModel(WorkspaceModel model) {
		this.model = model;
	}

}
