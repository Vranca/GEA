package algorithmElements;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;
import java.util.Vector;

public class ConnectingState extends ConnectionState
{

	@Override
	void draw(Connection c, Graphics2D g2d) 
	{
		g2d.drawLine((int)getStartingPoint(c).getX(), (int)getStartingPoint(c).getY(), (int)c.getPoints().get(0).getX(), (int)c.getPoints().get(0).getY());
		for(int i = 1; i < c.getPoints().size(); i++)
		{
			g2d.drawLine((int)c.getPoints().get(i - 1).getX(), (int)c.getPoints().get(i - 1).getY(), (int)c.getPoints().get(i).getX(), (int)c.getPoints().get(i).getY());
		}
		
		g2d.drawLine((int)c.getLastPoint().getX(), (int)c.getLastPoint().getY(), (int)c.getPreviewPoint().getX(), (int)c.getPreviewPoint().getY());		
	}

	@Override
	List<Shape> createLinesShape(Connection c) {
		// TODO Auto-generated method stub
		return new Vector<Shape>();
	}

}
