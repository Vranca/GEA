package models;

import java.awt.event.MouseEvent;

public interface WorkspaceState 
{
	void leftButtonPressedAction(MouseEvent e);
	void leftButtonReleasedAction(MouseEvent e);
	void doubleClickAction(MouseEvent e);
	void rightButtonPressedAction(MouseEvent e);
	void rightButtonReleasedAction(MouseEvent e);
	void middleButtonPressedAction(MouseEvent e);
	void middleButtonReleasedAction(MouseEvent e);
	void mouseMovedAction(MouseEvent e);
	void mouseDraggedAction(MouseEvent e);
	}
