package models;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import actionListeners.AddElementButtonListener;
import actionListeners.OptionsClickActionListener;
import actionListeners.SelectActionListener;
import actionListeners.ToolbarCommandsListener;
import actionListeners.ToolboxStateChangeListener;
import actionListeners.ToolboxWorkspacePropertiesListener;
import algorithmElements.AlgorithmElement;
import views.WorkspaceContextView;

public class WorkspaceSelectState implements WorkspaceState
{
	WorkspaceModel model = null;
	Point position = null;
	Rectangle selectionArea = null;
	Point selectionStartPoint = null;
	Point selectionEndingPoint = null;
	
	public WorkspaceSelectState(WorkspaceModel model)
	{
		this.model = model;
		selectionStartPoint = new Point(-1,-1);
		selectionEndingPoint = new Point(-1,-1);
	}
	public WorkspaceSelectState()
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
		selectionStartPoint = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
		
		AlgorithmElement element = model.getElementAt(position);
		if(element != null)
		{
			SelectCommand command = new SelectCommand(model);
			command.addSelectedElements(element);
			command.execute();
		}
		else 
		{
			model.clearSelection();
		}
	}

	@Override
	public void leftButtonReleasedAction(MouseEvent e) 
	{
		if(model.getSelectedElements().isEmpty() && selectionStartPoint.x != -1)
		{
			selectionEndingPoint = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
			model.setSelectionArea(new Rectangle(getMinimumPoint(), new Dimension((int)getMaximumPoint().getX() - (int)getMinimumPoint().getX(), (int)getMaximumPoint().getY() - (int)getMinimumPoint().getY())));
			java.util.List<AlgorithmElement> selectedElements = model.getGroupSelection();
			if(!selectedElements.isEmpty())
			{
				SelectCommand command = new SelectCommand(model);
				command.setSelectedElements(selectedElements);
				command.execute();
			}
			else 
			{
				model.clearSelection();
			}
			
		}
		model.resetSelectionArea();
	}

	@Override
	public void doubleClickAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightButtonPressedAction(MouseEvent e) 
	{
		if(model.getElementAt(e.getPoint()) == null)
		{
			model.clearSelection();
			model.getSelectedElements().clear();
		}
		WorkspaceContextView contextView = new WorkspaceContextView();
		contextView.show(e.getComponent(), e.getX(), e.getY());
		contextView.registerAddCommandListeners(new AddElementButtonListener(model));
		contextView.registerToolbarCommandsListener(new ToolbarCommandsListener(model));
		contextView.registerWorkspaceProperties(new ToolboxWorkspacePropertiesListener(model));
		contextView.registerOptionsClickActionListener(new OptionsClickActionListener(model));
		contextView.registerSelectActionListener(new SelectActionListener(model));
		contextView.registerConnectionListener(new ToolboxStateChangeListener(model));
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
		model.clearSelection();
		selectionEndingPoint = new Point((int)(e.getX() / model.getZoomScale()), (int)(e.getY() / model.getZoomScale()));
		model.setSelectionArea(new Rectangle(getMinimumPoint(), new Dimension((int)getMaximumPoint().getX() - (int)getMinimumPoint().getX(), (int)getMaximumPoint().getY() - (int)getMinimumPoint().getY())));
	}
	
	private Point getMinimumPoint()
	{
		Point minimumPoint = new Point(selectionStartPoint);
		
		if(minimumPoint.getX() > selectionEndingPoint.getX())
			minimumPoint.setLocation(selectionEndingPoint.getX(), minimumPoint.getY());
		if(minimumPoint.getY() > selectionEndingPoint.getY())
			minimumPoint.setLocation(minimumPoint.getX(), selectionEndingPoint.getY());
		
		return minimumPoint;
	}
	
	private Point getMaximumPoint()
	{
		Point maximumPoint = null;
		if(selectionStartPoint != null)
		{
			maximumPoint = new Point(selectionStartPoint);
		}
		else {
			maximumPoint = new Point(0,0);
		}
		if(maximumPoint.getX() < selectionEndingPoint.getX())
			maximumPoint.setLocation(selectionEndingPoint.getX(), maximumPoint.getY());
		if(maximumPoint.getY() < selectionEndingPoint.getY())
			maximumPoint.setLocation(maximumPoint.getX(), selectionEndingPoint.getY());
		
		return maximumPoint;
	}
}
