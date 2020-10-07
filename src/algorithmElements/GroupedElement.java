/***********************************************************************
 * Module:  GroupedElement.java
 * Author:  User
 * Purpose: Defines the Class GroupedElement
 ***********************************************************************/

package algorithmElements;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.*;

public class GroupedElement implements AlgorithmElement 
{
   private java.util.List<AlgorithmElement> algorithmElements;
   private int ID;
   private Rectangle shape = null;
   private Point position = null;
   
   public GroupedElement()
   {
	   algorithmElements = new Vector<AlgorithmElement>();
	   position = new Point();
   }
   
   /** @pdGenerated default getter */
   public java.util.List<AlgorithmElement> getAlgorithmElement() {
      if (algorithmElements == null)
         algorithmElements = new java.util.Vector<AlgorithmElement>();
      return algorithmElements;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<AlgorithmElement> getIteratorAlgorithmElement() {
      if (algorithmElements == null)
         algorithmElements = new java.util.Vector<AlgorithmElement>();
      return algorithmElements.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAlgorithmElement */
   public void setAlgorithmElement(java.util.List<AlgorithmElement> newAlgorithmElement) {
      removeAllAlgorithmElement();
      for (java.util.Iterator<AlgorithmElement> iter = newAlgorithmElement.iterator(); iter.hasNext();)
         addAlgorithmElement((AlgorithmElement)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAlgorithmElement */
   public void addAlgorithmElement(AlgorithmElement newAlgorithmElement) {
      if (newAlgorithmElement == null)
         return;
      if (this.algorithmElements == null)
         this.algorithmElements = new java.util.Vector<AlgorithmElement>();
      if (!this.algorithmElements.contains(newAlgorithmElement))
      {
         this.algorithmElements.add(newAlgorithmElement);
         updateShape();
      }
   }
   
   /** @pdGenerated default remove
     * @param oldAlgorithmElement */
   public void removeAlgorithmElement(AlgorithmElement oldAlgorithmElement) {
      if (oldAlgorithmElement == null)
         return;
      if (this.algorithmElements != null)
         if (this.algorithmElements.contains(oldAlgorithmElement))
            this.algorithmElements.remove(oldAlgorithmElement);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAlgorithmElement() {
      if (algorithmElements != null)
         algorithmElements.clear();
   }

   @Override
   public Point getPosition()
   {
	   	Point minPoint = getMinimumPoint();
		Point maxPoint = getMaximumPoint();
		Point position = new Point((int)((maxPoint.getX() + minPoint.getX()) / 2), (int)((maxPoint.getY() + minPoint.getY()) / 2));
		
		return position;
   }

   @Override
   public void draw(Graphics2D g2d) 
   {
	   for(AlgorithmElement element : algorithmElements)
	   {
		   element.draw(g2d);
	   }
   }

@Override
public void setPosition(Point position) 
{
	Point offset = getPosition();
	this.position.setLocation(offset);
	offset.setLocation(position.getX() - offset.getX(), position.getY() - offset.getY());
	
	for(AlgorithmElement element : algorithmElements)
	{
		if(element instanceof Symbol)
		{
			element.setPosition((int)(element.getPosition().getX() + offset.getX()), (int)(element.getPosition().getY() + offset.getY()));
		}
		else if(element instanceof Connection)
		{
			Connection c = (Connection) element;
			for(int i = 0; i < c.getPoints().size(); i++)
			{
				c.getPoints().get(i).setLocation((int)(c.getPoints().get(i).getX() + offset.getX()), (int)(c.getPoints().get(i).getY() + offset.getY()));
			}
		}
		else 
		{
			element.setPosition(position);
		}
	}
	updateShape();
}

@Override
public Boolean contains(Point point)
{
	return shape.contains(point);
}

@Override
public String getText() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Dimension getSize() 
{	
	return shape.getSize();
}

@Override
public AlgorithmElement copyWithoutLocation() 
{
	GroupedElement copy = new GroupedElement();
	for(AlgorithmElement element : algorithmElements)
	{
		copy.addAlgorithmElement(element.copy());
	}
	copy.setID(ID);
	copy.setShape(shape);
	return copy;
}

@Override
public String getElementType() 
{
	return "Group";
}

@Override
public Rectangle getBounds() 
{			
	return shape;
}

@Override
public int getID()
{
	return this.ID;
}

@Override
public void setID(int ID)
{
	this.ID = ID;
}

@Override
public void setPosition(int x, int y) 
{
	Point offset = getPosition();
	offset.setLocation(x - offset.getX(), y - offset.getY());
	
	for(AlgorithmElement element : algorithmElements)
	{
		if(element instanceof Symbol)
		{
			element.setPosition((int)(element.getPosition().getX() + offset.getX()), (int)(element.getPosition().getY() + offset.getY()));
		}
		else if(element instanceof Connection)
		{
			Connection c = (Connection) element;
			for(int i = 0; i < c.getPoints().size(); i++)
			{
				c.getPoints().get(i).setLocation((int)(c.getPoints().get(i).getX() + offset.getX()), (int)(c.getPoints().get(i).getY() + offset.getY()));
			}
		}
		else 
		{
			element.setPosition(x,y);
		}
	}

	updateShape();
}

@Override
public Boolean intersects(Rectangle shape) 
{
	return this.shape.intersects(shape);
}

@Override
public Boolean intersects(AlgorithmElement element) 
{
	return shape.intersects(element.getBounds());
}

private Point getMinimumPoint() {
	Point minimumPoint = new Point(algorithmElements.get(0).getPosition());
	
	for(AlgorithmElement element : algorithmElements)
	{
		if(element instanceof Symbol)
		{
			if(element.getPosition().getX() - element.getSize().getWidth()/2 < minimumPoint.getX())
				minimumPoint.setLocation(element.getPosition().getX()- element.getSize().getWidth()/2, minimumPoint.getY());
			if(element.getPosition().getX() + element.getSize().getWidth()/2 < minimumPoint.getX())
				minimumPoint.setLocation(element.getPosition().getX() + element.getSize().getWidth()/2, minimumPoint.getY());
			
			if(element.getPosition().getY() - element.getSize().getHeight()/2 < minimumPoint.getY())
				minimumPoint.setLocation(minimumPoint.getX(), element.getPosition().getY() - element.getSize().getHeight()/2);
			if(element.getPosition().getY() + element.getSize().getHeight()/2 < minimumPoint.getY())
				minimumPoint.setLocation(minimumPoint.getX(), element.getPosition().getY() + element.getSize().getHeight()/2);
		}
		else if (element instanceof Connection) 
		{
			Connection c = (Connection) element;
			if(c.getMinimumPoint().getX() < minimumPoint.getX())
				minimumPoint.setLocation(c.getMinimumPoint().getX(), minimumPoint.getY());
			if(c.getMinimumPoint().getY() < minimumPoint.getY())
				minimumPoint.setLocation(minimumPoint.getX(), c.getMinimumPoint().getY());
		}
	}
	
	return minimumPoint;
}

private Point getMaximumPoint()
{
	Point maximumPoint = new Point(algorithmElements.get(0).getPosition());
	
	for(AlgorithmElement element : algorithmElements)
	{
		if(element instanceof Symbol)
		{
			if(element.getPosition().getX() - element.getSize().getWidth()/2 > maximumPoint.getX())
				maximumPoint.setLocation(element.getPosition().getX()- element.getSize().getWidth()/2, maximumPoint.getY());
			if(element.getPosition().getX() + element.getSize().getWidth()/2 > maximumPoint.getX())
				maximumPoint.setLocation(element.getPosition().getX() + element.getSize().getWidth()/2, maximumPoint.getY());
			
			if(element.getPosition().getY() - element.getSize().getHeight()/2 > maximumPoint.getY())
				maximumPoint.setLocation(maximumPoint.getX(), element.getPosition().getY() - element.getSize().getHeight()/2);
			if(element.getPosition().getY() + element.getSize().getHeight()/2 > maximumPoint.getY())
				maximumPoint.setLocation(maximumPoint.getX(), element.getPosition().getY() + element.getSize().getHeight()/2);
		}
		else if (element instanceof Connection) 
		{
			Connection c = (Connection) element;
			if(c.getMaximumPoint().getX() > maximumPoint.getX())
				maximumPoint.setLocation(c.getMaximumPoint().getX(), maximumPoint.getY());
			if(c.getMaximumPoint().getY() > maximumPoint.getY())
				maximumPoint.setLocation(maximumPoint.getX(), c.getMaximumPoint().getY());
		}
	}
	
	return maximumPoint;
}

	public Boolean isEmpty()
	{
		return algorithmElements.isEmpty();
	}

	@Override
	public AlgorithmElement copy() {
		GroupedElement copy = new GroupedElement();
		for(AlgorithmElement element : algorithmElements)
		{
			copy.addAlgorithmElement(element.copy());
		}
		copy.setID(ID);
		copy.setPosition(getPosition());
		copy.setShape(shape);
		return copy;
	}
	
	private void updateShape()
	{
		Point minPoint = getMinimumPoint();
		Point maxPoint = getMaximumPoint();
		Rectangle shape = new Rectangle((int)minPoint.getX(), (int)minPoint.getY(), (int)(maxPoint.getX() - minPoint.getX()), (int)(maxPoint.getY() - minPoint.getY()));
		
		this.shape = shape;
	}
	
	public void setShape(Rectangle newShape)
	{
		this.shape = newShape;
	}

}