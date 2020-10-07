package models;

import java.awt.Dimension;
import java.awt.Graphics2D;

public class VisibleGridlines implements Gridlines
{
	 Dimension gridSize=null;
	 int gridStep;
	
	public VisibleGridlines( Dimension gridSize, int gridStep)
	{
		this.gridSize=gridSize;
		this.gridStep=gridStep;		
	}
	@Override
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < gridSize.getHeight(); i +=gridStep)
			g2d.drawLine(0, i, (int)gridSize.getWidth(), i);
		for(int i = 0; i < gridSize.getWidth(); i += gridStep)
			g2d.drawLine(i, 0, i, gridStep);
	}

}
