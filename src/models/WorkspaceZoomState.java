package models;

import java.awt.event.MouseEvent;

public class WorkspaceZoomState implements WorkspaceState
{
	private WorkspaceModel model = null;
	
	public WorkspaceZoomState(WorkspaceModel model)
	{
		this.model = model;
	}

	@Override
	public void leftButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		model.executeZoomIn();
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
		model.executeZoomOut();
	}

	@Override
	public void rightButtonReleasedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void middleButtonPressedAction(MouseEvent e) {
		// TODO Auto-generated method stub
		model.executeResetZoom();
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
	public void mouseDraggedAction(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
