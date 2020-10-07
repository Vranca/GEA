/***********************************************************************
 * Module:  Annotation.java
 * Author:  User
 * Purpose: Defines the Class Annotation
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class Annotation extends Symbol 
{

	public Annotation(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		elementType = "Annotation";
		shape = new Rectangle(X - getWidth() / 2, X - getHeight() / 2, getWidth(), getHeight());
	}
	
	public Annotation(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		elementType = "Annotation";
		shape = new Rectangle(getPosX() - getWidth() / 2, getPosY() - getHeight() / 2, getWidth(), getHeight());
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		
		updateTextLayout(text, g2d);
		updateShape();
		g2d.setColor(getBorderColor());
		g2d.setStroke(new BasicStroke(getBorderThickness() + 1));
		g2d.drawRect(getPosX() - getWidth() / 2 + 35,
					 getPosY() - getHeight() / 2, 
					 getWidth() - 35 - 2, 
					 getHeight() 
					);
		g2d.setStroke(new BasicStroke(getBorderThickness()));
		g2d.drawLine(getPosX() - getWidth() / 2, 
					 getPosY() + getHeight() / 2, 
					 getPosX() - getWidth() / 2 + 35, 
					 getPosY()
					 );
		
		fill(g2d);
		
		g2d.setColor(getVisualStyle().getTextColor());
		
		float textOffsetX = this.getWidth()/2 - 40;
		float textOffsetY = (float)textLayout.getBounds().getHeight()/2;
		
		textLayout.draw(g2d, position.x - textOffsetX, position.y + textOffsetY);
	}

	private void fill(Graphics2D g2d)
	{
		g2d.setColor(getBackgroundColor());
		g2d.fillRect(getPosX() - getWidth() / 2 + 35 + 1, 
					 getPosY() + 1 - getHeight() / 2,
					 getWidth() - 35 + getBorderThickness(), 
					 getHeight() - 1
					 );
	}
	
	@Override
	protected void updateElementBounds(Rectangle2D bounds)
	{
		if( this.getWidth() - 40 < (bounds.getWidth()) )
			this.visualStyle.setWidth( ((int)bounds.getWidth() + 40) );
		if( this.getHeight() < (bounds.getHeight() - 10) )
			this.visualStyle.setHeight(((int)bounds.getHeight() + 5));
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new Annotation(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}

	@Override
	protected void updateShape() {
		// TODO Auto-generated method stub
		shape = new Rectangle(getPosX() - getWidth() / 2, getPosY() - getHeight() / 2, getWidth(), getHeight());
	}
	
	


}