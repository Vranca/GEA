/***********************************************************************
 * Module:  OffPageConnector.java
 * Author:  User
 * Purpose: Defines the Class OffPageConnector
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

public class OffPageConnector extends Symbol {

	public OffPageConnector(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		elementType = "OffPageConnector";
		shape = getPolygon();
	}

	public OffPageConnector(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		elementType = "OffPageConnector";
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
		int[] xCoordinates = {getPosX() - getWidth()/2, getPosX() - getWidth()/2, getPosX(), getPosX() + getWidth()/2, getPosX() + getWidth()/2};
		int[] yCoordinates = {getPosY() - getHeight()/2, getPosY() + getHeight()/2 - getHeight()/3, getPosY() + getHeight()/2, getPosY() + getHeight()/2 - getHeight()/3, getPosY() - getHeight()/2};
		
		return new Polygon(xCoordinates,yCoordinates,5);
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new OffPageConnector(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}

	@Override
	protected void updateShape()
	{
		shape = getPolygon();
	}
	
}