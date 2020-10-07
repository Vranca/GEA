/***********************************************************************
 * Module:  AlgorithmElement.java
 * Author:  User
 * Purpose: Defines the Interface AlgorithmElement
 ***********************************************************************/

package algorithmElements;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public interface AlgorithmElement 
{
	void setPosition(Point position);
	void setPosition(int x, int y);
	Point getPosition();
	Boolean contains(Point point);
	void draw(Graphics2D g2d);
	String getText();
	Dimension getSize();
	AlgorithmElement copyWithoutLocation();
	AlgorithmElement copy();
	String getElementType();
	Rectangle getBounds();
	int getID();
	void setID(int ID);
	Boolean intersects(Rectangle shape);
	Boolean intersects(AlgorithmElement element);
}