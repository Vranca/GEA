package algorithmElements;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

public abstract class ConnectionState
{
	abstract void draw(Connection c, Graphics2D g2d);
	abstract java.util.List<Shape> createLinesShape(Connection c);
	
	protected Point getStartingPoint(Connection c)
	{
		Point firstPoint = null;
		Point startingPoint = new Point();
		double posX;
		double posY;
		
		if(c.getPoints().isEmpty())
			firstPoint = c.getPreviewPoint();
		else
			firstPoint = c.getPoints().get(0);
		
		if( firstPoint.getX() == c.getStartingElement().getPosition().getX())
		{
			posX = firstPoint.getX();
			if(firstPoint.getY() <= c.getStartingElement().getPosition().getY())
			{			
				posY = c.getStartingElement().getPosition().getY() - c.getStartingElement().getSize().getHeight() / 2;
			}
			else
			{
				posY = c.getStartingElement().getPosition().getY() + c.getStartingElement().getSize().getHeight() / 2;
			}
		}
		else
		{
			posY = firstPoint.getY();
			if(firstPoint.getX() <= c.getStartingElement().getPosition().getX())
			{
				posX = c.getStartingElement().getPosition().getX() - c.getStartingElement().getSize().getWidth() / 2;
			}
			else
			{
				posX = c.getStartingElement().getPosition().getX() + c.getStartingElement().getSize().getWidth() / 2;
			}
		}
		startingPoint.setLocation(posX, posY);
		
		return startingPoint;
	}

	protected Point getFinalPoint(Connection c)
	{
		Point previousPoint = null;
		Point finalPoint = new Point();
		double posX;
		double posY;
		
		if(c.getPoints().isEmpty())
			previousPoint = c.getStartingElement().getPosition();
		else
			previousPoint = c.getLastPoint();
		
		if( previousPoint.getX() == c.getFinalElement().getPosition().getX())
		{
			posX = previousPoint.getX();
			if(previousPoint.getY() <= c.getFinalElement().getPosition().getY())
			{			
				posY = c.getFinalElement().getPosition().getY() - c.getFinalElement().getSize().getHeight() / 2;
			}
			else
			{
				posY = c.getFinalElement().getPosition().getY() + c.getFinalElement().getSize().getHeight() / 2;
			}
		}
		else
		{
			posY = previousPoint.getY();
			if(previousPoint.getX() <= c.getFinalElement().getPosition().getX())
			{
				posX = c.getFinalElement().getPosition().getX() - c.getFinalElement().getSize().getWidth() / 2;
			}
			else
			{
				posX = c.getFinalElement().getPosition().getX() + c.getFinalElement().getSize().getWidth() / 2;
			}
		}
		finalPoint.setLocation(posX, posY);
		
		return finalPoint;
	}

}
