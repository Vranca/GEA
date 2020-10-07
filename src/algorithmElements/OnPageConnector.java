/***********************************************************************
 * Module:  OnPageConnector.java
 * Author:  User
 * Purpose: Defines the Class OnPageConnector
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

public class OnPageConnector extends Symbol {

	public OnPageConnector(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		this.visualStyle.setWidth(visualStyle.getHeight());
		elementType = "OnPageConnector";
		shape = new Ellipse2D.Double(getPosX() - getWidth()/2, getPosY() - getWidth()/2, getWidth(), getWidth());
	}

	public OnPageConnector(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		this.visualStyle.setWidth(visualStyle.getHeight());
		elementType = "OnPageConnector";
		shape = new Ellipse2D.Double();
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
		
		float textOffsetX = (float)textLayout.getBounds().getWidth() + 5;
		float textOffsetY = (float)textLayout.getBounds().getHeight();

		this.textLayout.draw(g2d, position.x - textOffsetX, position.y + textOffsetY);
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new OnPageConnector(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}

	@Override
	protected void updateShape() 
	{
		shape = new Ellipse2D.Double(getPosX() - getWidth()/2, getPosY() - getWidth()/2, getWidth(), getWidth());
	}

}