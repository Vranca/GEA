package algorithmElements;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.Vector;

public class FinishedState extends ConnectionState
{

	@Override
	void draw(Connection c, Graphics2D g2d)
	{
		if(!c.getPoints().isEmpty())
			c.allignFirstPoint();
		c.setFinalElement(c.getFinalElement());
		
		g2d.drawLine((int)getStartingPoint(c).getX(), (int)getStartingPoint(c).getY(), (int)c.getPoints().get(0).getX(), (int)c.getPoints().get(0).getY());
		for(int i = 1; i < c.getPoints().size(); i++)
		{
			g2d.drawLine((int)c.getPoints().get(i - 1).getX(), (int)c.getPoints().get(i - 1).getY(), (int)c.getPoints().get(i).getX(), (int)c.getPoints().get(i).getY());
		}
		
		g2d.drawLine((int)c.getLastPoint().getX(), (int)c.getLastPoint().getY(), (int)getFinalPoint(c).getX(), (int)getFinalPoint(c).getY());
		
		drawArrow(c, g2d);
	}
	
	private void drawArrow(Connection c, Graphics2D g2d)
	{
		Point arrowHead = getFinalPoint(c);
		g2d.fillPolygon(getArrow(c, arrowHead));		
	}
	
	private Polygon getArrow(Connection c, Point arrowhead)
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		
		if ( c.getLastPoint().getX() == c.getFinalElement().getPosition().getX() )
		{
			if( c.getLastPoint().getY() < c.getFinalElement().getPosition().getY() )
			{
				// Draw Arrow directed from top to bottom 
				xPoints[0] = (int)arrowhead.getX();
				xPoints[1] = (int)arrowhead.getX() - 10;
				xPoints[2] = (int)arrowhead.getX() + 10;
				
				yPoints[0] = (int)arrowhead.getY();
				yPoints[1] = (int)arrowhead.getY() - 20;
				yPoints[2] = (int)arrowhead.getY() - 20;
			}
			else 
			{
				// Draw Arrow directed from bottom to top
				xPoints[0] = (int)arrowhead.getX();
				xPoints[1] = (int)arrowhead.getX() - 10;
				xPoints[2] = (int)arrowhead.getX() + 10;
				
				yPoints[0] = (int)arrowhead.getY();
				yPoints[1] = (int)arrowhead.getY() + 20;
				yPoints[2] = (int)arrowhead.getY() + 20;
			}
			
		}
		else
		{
			if ( c.getLastPoint().getX() < c.getFinalElement().getPosition().getX() )
			{
				// Draw Arrow directed from left to right
				xPoints[0] = (int)arrowhead.getX();
				xPoints[1] = (int)arrowhead.getX() - 20;
				xPoints[2] = (int)arrowhead.getX() - 20;
				
				yPoints[0] = (int)arrowhead.getY();
				yPoints[1] = (int)arrowhead.getY() - 10;
				yPoints[2] = (int)arrowhead.getY() + 10;
			}
			else
			{
				// Draw Arrow directed from right to left
				xPoints[0] = (int)arrowhead.getX();
				xPoints[1] = (int)arrowhead.getX() + 20;
				xPoints[2] = (int)arrowhead.getX() + 20;
				
				yPoints[0] = (int)arrowhead.getY();
				yPoints[1] = (int)arrowhead.getY() - 10;
				yPoints[2] = (int)arrowhead.getY() + 10;
			}
		}
		
		return new Polygon(xPoints, yPoints, 3);
	}

	public java.util.List<Shape> createLinesShape(Connection c)
	{
		java.util.List<Shape> lines = new Vector<Shape>();
		if(c.getPoints().isEmpty())
		{
			lines.add(new Line2D.Double(getStartingPoint(c), getFinalPoint(c)));
		}
		else 
		{
			lines.add(new Line2D.Double(getStartingPoint(c), c.getPoints().get(0)));
			for(int i = 0; i < c.getPoints().size() - 1; i++)
			{
				lines.add(new Line2D.Double(c.getPoints().get(i), c.getPoints().get(i + 1)));
			}
			lines.add(new Line2D.Double(c.getLastPoint(), getFinalPoint(c)));
		}
		return lines;
	}
}
