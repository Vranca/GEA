package actionListeners;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import models.WorkspaceModel;
import views.WorkspaceView;

public class WorkspaceMouseListener implements MouseInputListener
{
	WorkspaceModel model = null;
	WorkspaceView view = null;
	
	public WorkspaceMouseListener(WorkspaceModel model, WorkspaceView view)
	{
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			if(e.getClickCount() == 2)
			{
				model.getState().doubleClickAction(e);
			}
			else 
			{
				model.getState().leftButtonPressedAction(e);
			}
		}		
		else if(SwingUtilities.isRightMouseButton(e))
			model.getState().rightButtonPressedAction(e);
		else {
			model.getState().middleButtonPressedAction(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(SwingUtilities.isLeftMouseButton(e))
		{
			model.getState().leftButtonReleasedAction(e);
		}
		else if(SwingUtilities.isRightMouseButton(e)) 
		{
			model.getState().rightButtonReleasedAction(e);
		}
		else
		{
			model.getState().middleButtonReleasedAction(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		model.getState().mouseDraggedAction(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		model.getState().mouseMovedAction(e);
	}
}
