/***********************************************************************
 * Module:  InputOutput.java
 * Author:  User
 * Purpose: Defines the Class InputOutput
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class InputOutput extends Symbol {

	public InputOutput(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		elementType = "InputOutput";
		shape = getPolygon();
	}
	
	public InputOutput(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		elementType = "InputOutput";
		shape = new Polygon();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		
		updateTextLayout(text, g2d);
		updateShape();
		visualStyle.fill(g2d, shape);

		g2d.setColor(getBorderColor());
		g2d.setStroke(new BasicStroke(getBorderThickness()));
		g2d.draw(shape);
		
		g2d.setColor(getVisualStyle().getTextColor());
		
		float textOffsetX = (float)textLayout.getBounds().getWidth()/2 + 5;
		float textOffsetY = (float)textLayout.getBounds().getHeight()/2;

		this.textLayout.draw(g2d, position.x - textOffsetX, position.y + textOffsetY);
	}

	private Polygon getPolygon()
	{
		int[] xCoordinates = {getPosX() - getWidth()/2, getPosX() - getWidth()/2 + 20, getPosX() + getWidth()/2, getPosX() + getWidth()/2 - 20};
		int[] yCoordinates = {getPosY() + getHeight()/2, getPosY() - getHeight()/2, getPosY() - getHeight()/2, getPosY() + getHeight()/2};
		
		return new Polygon(xCoordinates,yCoordinates,4);
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new InputOutput(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}
	
	@Override
	protected void updateElementBounds(Rectangle2D bounds)
	{
		if( this.getWidth() < (bounds.getWidth() + 40 ) )
			this.visualStyle.setWidth(((int)bounds.getWidth() + 40));
		if( getHeight() < (bounds.getHeight() ) )
			this.visualStyle.setHeight(((int)bounds.getHeight() + 5));
	}

	@Override
	protected void updateShape()
	{
		shape = getPolygon();
	}
}