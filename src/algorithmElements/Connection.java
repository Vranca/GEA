/***********************************************************************
 * Module:  Connection.java
 * Author:  User
 * Purpose: Defines the Class Connection
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.*;

public class Connection implements AlgorithmElement
{
	private AlgorithmElement finalElement = null;
	private AlgorithmElement startingElement = null;
	private java.util.List<Point> points = null;
	private Point previewPoint = null;
	private ConnectionState state = null;
	private java.util.List<Shape> line = null;
	private int id;
   
	public Connection()
	{
		points = new Vector<Point>();
		line = new Vector<Shape>();
	}
	
   
	public final AlgorithmElement getStartingElement() {
		return startingElement;
	}


	public final void setStartingElement(AlgorithmElement startingElement) {
		this.startingElement = startingElement;
		previewPoint = startingElement.getPosition();
	}


	public final AlgorithmElement getFinalElement() {
		return finalElement;
	}


	public final AlgorithmElement setFinalElement(AlgorithmElement finalElement) {
		double horizontalOffset;
		double verticalOffset;
		
		if(points.isEmpty())
		{
			return null;
		}
		else 
		{
			horizontalOffset = Math.abs(points.get(points.size() - 1).getX() - finalElement.getPosition().getX());
			verticalOffset 	= Math.abs(points.get(points.size() - 1).getY() - finalElement.getPosition().getY());
			   
			if( horizontalOffset <= verticalOffset )
				points.get(points.size() - 1).setLocation(finalElement.getPosition().getX(), points.get(points.size() - 1).getY());
			else 
				points.get(points.size() - 1).setLocation(points.get(points.size() - 1).getX(), finalElement.getPosition().getY());
			
			if(finalElement.contains(points.get(points.size() - 1)))
				return null;
			
			
			this.finalElement = finalElement;
		}
		return finalElement;
	}


	@Override
	public Point getPosition() {
		Point minPoint = getMinimumPoint();
		Point maxPoint = getMaximumPoint();
		Point position = new Point((int)((maxPoint.getX() + minPoint.getX()) / 2), (int)((maxPoint.getY() + minPoint.getY()) / 2));
		
		return position;
	}

	@Override
	public void draw(Graphics2D g2d)
	{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		 
		state.draw(this, g2d);
	}
	
	@Override
	public void setPosition(Point position) 
	{
		Point oldPosition = getPosition();
		int xDifference = (int)position.getX() - (int)oldPosition.getX();
		int yDifference = (int)position.getY() - (int)oldPosition.getY();
		
		for(Point p : points)
		{
			p.setLocation(p.getX() + xDifference, p.getY() + yDifference);
		}
	}

	@Override
	public Boolean contains(Point point)
	{
		Rectangle selectRect = new Rectangle((int)point.getX() - 1, (int)point.getY() - 1, 3, 3);
		line = state.createLinesShape(this);
		for(Shape singleLine : line)
		{
			if(singleLine.intersects(selectRect))
			{
				return true;
			}
		}
		return false;
	}
	

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getSize() 
	{
		Point minPoint = getMinimumPoint();
		Point maxPoint = getMaximumPoint();
		Dimension size = new Dimension((int)(maxPoint.getX() - minPoint.getX()), (int)(maxPoint.getY() - minPoint.getY()));
		
		return size;
	}

	@Override
	public AlgorithmElement copyWithoutLocation() 
	{
		Connection connection = new Connection();
		connection.setStartingElement(startingElement.copy());
		java.util.List<Point> points = new Vector<Point>();
		for(int i = 0; i < this.points.size(); i++)
		{
			points.add(new Point(this.points.get(i)));
		}
		connection.setPoints(points);
		
		connection.setFinalElement(finalElement.copy());
		
		connection.setState(new FinishedState());
		
		return connection;
	}

	@Override
	public String getElementType() {
		return "Connection";
	}

	@Override
	public Rectangle getBounds() {
		Point minPoint = getMinimumPoint();
		Point maxPoint = getMaximumPoint();
		Rectangle bounds = new Rectangle((int)minPoint.getX(), (int)minPoint.getY(), (int)(maxPoint.getX() - minPoint.getX()), (int)(maxPoint.getY() - minPoint.getY()));
				
		return bounds;
	}

	public Point getMinimumPoint() {
		Point minimumPoint = new Point(state.getStartingPoint(this));
		
		for(Point p : points)
		{
			if(p.getX() < minimumPoint.getX())
				minimumPoint.setLocation(p.getX(), minimumPoint.getY());
			if(p.getY() < minimumPoint.getY())
				minimumPoint.setLocation(minimumPoint.getX(), p.getY());
		}
		if(state.getFinalPoint(this).getX() < minimumPoint.getX())
			minimumPoint.setLocation(state.getFinalPoint(this).getX(), minimumPoint.getY());
		if(state.getFinalPoint(this).getY() < minimumPoint.getY())
			minimumPoint.setLocation(minimumPoint.getX(), state.getFinalPoint(this).getY());
		
		return minimumPoint;
	}
	
	public Point getMaximumPoint() {
		// TODO Auto-generated method stub
		Point maximumPoint = new Point(state.getStartingPoint(this));
		
		for(Point p : points)
		{
			if(p.getX() > maximumPoint.getX())
				maximumPoint.setLocation(p.getX(), maximumPoint.getY());
			if(p.getY() > maximumPoint.getY())
				maximumPoint.setLocation(maximumPoint.getX(), p.getY());
		}
		if(state.getFinalPoint(this).getX() > maximumPoint.getX())
			maximumPoint.setLocation(state.getFinalPoint(this).getX(), maximumPoint.getY());
		if(state.getFinalPoint(this).getY() > maximumPoint.getY())
			maximumPoint.setLocation(maximumPoint.getX(), state.getFinalPoint(this).getY());
		
		return maximumPoint;
	}
	
	public void forceSetFinalElement(AlgorithmElement finalElement)
	{
		this.finalElement = finalElement;
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setID(int ID) {
		// TODO Auto-generated method stub
		this.id = ID;
	}

	/** @pdGenerated default getter */
	   public java.util.List<Point> getPoints() {
	      if (points == null)
	         points = new java.util.Vector<Point>();
	      return points;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator<Point> getIteratorPoints() {
	      if (points == null)
	         points = new java.util.Vector<Point>();
	      return points.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newPoints */
	   public void setPoints(java.util.List<Point> newPoints) {
	      removeAllPoints();
	      for (java.util.Iterator<Point> iter = newPoints.iterator(); iter.hasNext();)
	         addPoints((Point)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newPoint */
	   public void addPoints(Point newPoint) {
	      if (newPoint == null)
	         return;
	      if (this.points == null)
	         this.points = new java.util.Vector<Point>();
	      if (!this.points.contains(newPoint))
	      {
	    	  newPoint = allignPoint(newPoint);
	    	  this.points.add(newPoint);
	      }
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldPoint */
	   public void removePoints(Point oldPoint) {
	      if (oldPoint == null)
	         return;
	      if (this.points != null)
	         if (this.points.contains(oldPoint))
	            this.points.remove(oldPoint);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllPoints() {
	      if (points != null)
	         points.clear();
	   }
	   
	   public Point getLastPoint()
	   {
		   if (points == null)
			   points = new java.util.Vector<Point>();
		   return points.get(points.size() - 1);
	   }

	   private Point allignPoint(Point newPoint)
	   {
		   double horizontalOffset;
		   double verticalOffset;
		   Point previousPoint = null;
		   
		   if(points.isEmpty() || points == null)
		   {
			   previousPoint = startingElement.getPosition();
		   }
		   else 
		   {
			   previousPoint = getLastPoint();
		   }
		   
		   horizontalOffset = Math.abs(previousPoint.getX() - newPoint.getX());
		   verticalOffset 	= Math.abs(previousPoint.getY() - newPoint.getY());
		   
		   if( horizontalOffset <= verticalOffset )
			   newPoint.setLocation(previousPoint.getX(), newPoint.getY());
		   else 
			   newPoint.setLocation(newPoint.getX(), previousPoint.getY());
		   
		   return newPoint;
	   }

	   public void allignFirstPoint() 
	   {
		   double horizontalOffset;
		   double verticalOffset;
		   Point firstPoint = points.get(0);
		   Point startingPoint = startingElement.getPosition();
		   
		   
		   horizontalOffset = Math.abs(startingPoint.getX() - firstPoint.getX());
		   verticalOffset 	= Math.abs(startingPoint.getY() - firstPoint.getY());
		   
		   if( horizontalOffset <= verticalOffset )
			   firstPoint.setLocation(startingPoint.getX(), firstPoint.getY());
		   else 
			   firstPoint.setLocation(firstPoint.getX(), startingPoint.getY());
	   }

	   @Override
	   public void setPosition(int x, int y) {
		   // TODO Auto-generated method stub
		
	   }


	public Point getPreviewPoint() {
		return previewPoint;
	}


	public void setPreviewPoint(Point previewPoint) {
		allignPreviewPoint(previewPoint);
		this.previewPoint = previewPoint;
	}
	
	private Point allignPreviewPoint(Point previewPoint)
	   {
		   Point previousPoint = null;
		   Point secondLastPoint = null;
		   
		   if(points.isEmpty() || points == null)
		   {
			   allignPoint(previewPoint);
			   return previewPoint;
		   }
		   else if( points.size() == 1)
		   {
			   previousPoint = getLastPoint();
			   secondLastPoint = startingElement.getPosition();
		   }
		   else 
		   {
			   previousPoint = getLastPoint();
			   secondLastPoint = points.get(points.size() - 2);
		   }
		   
		   if( previousPoint.getX() == secondLastPoint.getX())
		   {
			   previousPoint.setLocation(previousPoint.getX(), previewPoint.getY());
		   }
		   else
		   {
			   previousPoint.setLocation(previewPoint.getX(), previousPoint.getY());
		   }
		   
		   allignPoint(previewPoint);
		   return previewPoint;
	   }
	
	public final ConnectionState getState() {
		return state;
	}


	public final void setState(ConnectionState state) {
		this.state = state;
	}


	@Override
	public Boolean intersects(Rectangle shape) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean intersects(AlgorithmElement element)
	{
		Line2D segment = new Line2D.Double();
		Boolean intersects = false;
		
		if(points.isEmpty())
		{
			segment = getSegment(state.getStartingPoint(this), state.getFinalPoint(this));
			intersects = segment.intersects(element.getBounds());
		}
		else 
		{
			segment = getSegment(state.getStartingPoint(this), points.get(0));
			intersects = segment.intersects(element.getBounds());
			for(int i = 0; i < points.size() - 1; i++)
			{
				segment = getSegment(points.get(i), points.get(i + 1));
				intersects = intersects | segment.intersects(element.getBounds());
			}
			segment = getSegment(getLastPoint(), state.getFinalPoint(this));
			intersects = intersects | segment.intersects(element.getBounds());
		}
		
		return intersects;
	}
	
	
	private Line2D getSegment(Point point1, Point point2)
	{
		Line2D segment = null;
		Point p1 = new Point(point1);
		Point p2 = new Point(point2);
		
		if(p1.getX() < p2.getX())
		{
			p1.setLocation(p1.getX() + 5, p1.getY());
			p2.setLocation(p2.getX() - 5, p2.getY());
		}
		else if (p1.getX() > p2.getX())
		{
			p1.setLocation(p1.getX() - 5, p1.getY());
			p2.setLocation(p2.getX() + 5, p2.getY());
		}
		
		if(p1.getY() < p2.getY())
		{
			p1.setLocation(p1.getX(), p1.getY() + 5);
			p2.setLocation(p2.getX(), p2.getY() - 5);
		}
		else if (p1.getY() > p2.getY())
		{
			p1.setLocation(p1.getX(), p1.getY() - 5);
			p2.setLocation(p2.getX(), p2.getY() + 5);
		}
		
		segment = new Line2D.Double(p1, p2);
		
		return segment;
	}


	@Override
	public AlgorithmElement copy() 
	{
		return copyWithoutLocation();
	}
}
