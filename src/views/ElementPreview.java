package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import models.ToolboxModel;
import models.WorkspaceModel;

public class ElementPreview extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	ToolboxModel model = null;
	WorkspaceModel workspaceModel = null;
	
	public ElementPreview(ToolboxModel model)
	{
		this.model = model;
	}
	
	public ElementPreview(WorkspaceModel workspaceModel)
	{
		this.workspaceModel = workspaceModel;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		if(model != null)	
			workspaceModel = model.getSelectedModel();
		setBackground(workspaceModel.getBackgroundColor());
		
		if(model != null)
		{
			if(model.getPreviewElement() != null)
			{
				model.getPreviewElement().setPosition(getWidth()/2, getHeight()/2);
				model.getPreviewElement().draw(g2d);			
			}
		}
		else
		{
			workspaceModel.getAlgorithmElements().get(0).setPosition(getWidth()/2, getHeight()/2);
			workspaceModel.getAlgorithmElements().get(0).draw(g2d);
		}
	}


}
