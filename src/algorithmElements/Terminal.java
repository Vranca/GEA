/***********************************************************************
 * Module:  Terminal.java
 * Author:  User
 * Purpose: Defines the Class Terminal
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class Terminal extends Symbol 
{

	public Terminal(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		elementType = "Terminal";
		shape = new RoundRectangle2D.Double(getPosX() - getWidth() / 2,
				 getPosY() - getHeight() / 2, 
				 getWidth(), 
				 getHeight(), 
				 getHeight(), 
				 getHeight()
				);
	}
	
	public Terminal(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		elementType = "Terminal";
		shape = new RoundRectangle2D.Double(getPosX() - getWidth() / 2,
				 getPosY() - getHeight() / 2, 
				 getWidth(), 
				 getHeight(), 
				 getHeight(), 
				 getHeight()
				);
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
	

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new Terminal(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}
	
	@Override
	protected void updateShape() {
		// TODO Auto-generated method stub
		shape = new RoundRectangle2D.Double(getPosX() - getWidth() / 2,
				 getPosY() - getHeight() / 2, 
				 getWidth(), 
				 getHeight(), 
				 getHeight(), 
				 getHeight()
				);
	}
}