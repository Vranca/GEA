package algorithmElements;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;
import java.util.Vector;

public class StartingState extends ConnectionState
{

	@Override
	public void draw(Connection c, Graphics2D g2d) 
	{
		if(!c.getStartingElement().contains(c.getPreviewPoint()))
		{			
			g2d.drawLine((int)getStartingPoint(c).getX(), (int)getStartingPoint(c).getY(), (int)c.getPreviewPoint().getX(), (int)c.getPreviewPoint().getY());
		}
	}

	@Override
	public List<Shape> createLinesShape(Connection c) {
		// TODO Auto-generated method stub
		
		return new Vector<Shape>();
	}

}
