/***********************************************************************
 * Module:  Symbol.java
 * Author:  User
 * Purpose: Defines the Class Symbol
 ***********************************************************************/

package algorithmElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

public abstract class Symbol implements AlgorithmElement 
{
	protected Point             position    =	null;
	protected SymbolVisualStyle visualStyle =	null;
	protected String            text        =	null;
	protected TextLayout        textLayout  =	null;
	protected String			elementType	=	null;
	protected Shape				shape		=	null;
	protected int               fontSize;
	protected int ID;
	protected Font font = null;
	
	public Symbol(int X, int Y, SymbolVisualStyle visualStyle)
	{
		position = new Point(X, Y);
		this.visualStyle = visualStyle;
		fontSize = 16;
		text = " ";
		font = new Font("TimesRoman", Font.BOLD, fontSize);
	}
	
	public Symbol(SymbolVisualStyle visualStyle)
	{
		this.visualStyle = visualStyle;
		fontSize = 16;
		text = " ";
		position = new Point();
		font = new Font("TimesRoman", Font.BOLD, fontSize);
	}
	
	public void setPosition(Point position)
	{
		this.position = new Point(position);
		updateShape();
	}
	
	public final Point getPosition()
	{
		return position;
	}
	
	public final int getPosX() 
	{
		return position.x;
	}

	public final void setPosX(int posX)
	{
		position.x = posX;
	}

	public final int getPosY()
	{
		return position.y;
	}

	public final void setPosY(int posY)
	{
		position.y = posY;
	}

	public final void setVisualStyle(SymbolVisualStyle visualStyle)
	{
		this.visualStyle = visualStyle;
	}

	public final SymbolVisualStyle getVisualStyle()
	{
		return visualStyle;
	}
	
	public final Color getBackgroundColor()
	{
		return getVisualStyle().getBackgroundColor();
	}
	
	public final Color getBorderColor()
	{
		return getVisualStyle().getBorderColor();
	}
	
	public final int getBorderThickness()
	{
		return getVisualStyle().getBorderThickness();
	}
	
	public final int getWidth()
	{
		return getVisualStyle().getWidth();
	}
	
	public final int getHeight()
	{
		return getVisualStyle().getHeight();
	}	
	
	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text; 
	}

	protected void updateTextLayout(String text, Graphics2D g2d)
	{
		this.textLayout = new TextLayout(text, g2d.getFont(), g2d.getFontRenderContext());
		updateElementBounds(this.textLayout.getBounds());
	}
	
	protected void updateElementBounds(Rectangle2D bounds)
	{
		if( this.getWidth() < (bounds.getWidth() ) )
			this.visualStyle.setWidth(((int)bounds.getWidth() + 10));
		if( getHeight() < (bounds.getHeight() ) )
			this.visualStyle.setHeight(((int)bounds.getHeight() + 5));
	}
	
	@Override
	public Boolean contains(Point point)
	{
		int startX = position.x - getWidth()/2;
		int startY = position.y - getHeight()/2;
		
		if ( ( (point.x > startX) && (point.x < ( startX + getWidth() )) ) && ( (point.y > startY) && (point.y < ( startY + getHeight() )) ) ) 
				return true;
		
		return false;
	}
	
	@Override
	public Dimension getSize()
	{
		return visualStyle.getSize();
	}
	
	
	public final int getFontSize() {
		return fontSize;
	}

	public final void setFontSize(int fontSize) {
		this.fontSize = fontSize;
		font = new Font(font.getName(), font.getStyle(), fontSize);
	}

	public final String getElementType() {
		return elementType;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(position.x - getWidth()/2, position.y - getHeight()/2, getWidth(), getHeight());
	}

	public final int getID() {
		return ID;
	}

	public final void setID(int ID) {
		this.ID = ID;
	}
	
	public void setPosition(int x, int y)
	{
		position.setLocation(x, y);
		updateShape();
	}

	public Boolean intersects(Rectangle shape)
	{
		return this.shape.intersects(shape);
	}
	
	public Boolean intersects(AlgorithmElement element)
	{
		return shape.intersects(element.getBounds());
	}
	
	public AlgorithmElement copy()
	{
		AlgorithmElement copy = copyWithoutLocation();
		copy.setPosition(new Point(this.getPosition()));
		return copy;
	}
	
	public abstract void draw(Graphics2D g2d);
	protected abstract void updateShape();
}