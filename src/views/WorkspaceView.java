/***********************************************************************
 * Module:  WorkspaceView.java
 * Author:  User
 * Purpose: Defines the Class WorkspaceView
 ***********************************************************************/

package views;

import models.WorkspaceModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import actionListeners.WorkspaceMouseListener;
import algorithmElements.AlgorithmElement;
import algorithmElements.SelectDecorator;

public class WorkspaceView extends JPanel implements Subscriber 
{
	private static final long serialVersionUID = 1L;
	private WorkspaceModel model = null;

	public WorkspaceView(WorkspaceModel model)
	{
		super();
		this.model = model;
		setBackground(Color.black);
		setPreferredSize(this.model.getScaledSize());
		setBorder(BorderFactory.createLoweredBevelBorder());
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		setBackground(Color.black);
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.scale(model.getZoomScale(), model.getZoomScale());
		
		g2d.setColor(model.getBackgroundColor());
		g2d.fillRect(0, 0, (int)model.getWorkspaceSize().getWidth(), (int)model.getWorkspaceSize().getHeight());
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(1));
		if( model.getShowGrid() && model.getShowGrid() != null)
		{
			for(int i = 0; i < model.getWorkspaceSize().getHeight(); i += model.getGridSize())
				g2d.drawLine(0, i, (int)model.getWorkspaceSize().getWidth(), i);
			for(int i = 0; i < model.getWorkspaceSize().getWidth(); i += model.getGridSize())
				g2d.drawLine(i, 0, i, (int)model.getWorkspaceSize().getHeight());
		}
		
		for(AlgorithmElement elementModel : model.getAlgorithmElements())
		{
			elementModel.draw(g2d);
		}
		if( model.getNewAlgorithmElement() != null )
			model.getNewAlgorithmElement().draw(g2d);
		if( model.getSelectedElement() != null )
		{
			model.drawSelection(g2d);
		}
		if(!model.getSelectedElements().isEmpty())
			for(SelectDecorator sd : model.getSelectedElements())
				sd.draw(g2d);
		
		if(model.getSelectionArea() != null)
			model.drawSelectionArea(g2d);
		
		
		g2d.dispose();
	}
	
	public WorkspaceModel getModel() {
		return model;
	}

	public final void setModel(WorkspaceModel model) {
		this.model = model;
	}

	public void update() {
		setBackground(model.getBackgroundColor());
		setPreferredSize(model.getScaledSize());
		repaint();
		revalidate();
   }
	
	public void addWorkspaceMouseListener(WorkspaceMouseListener listener)
	{
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

}