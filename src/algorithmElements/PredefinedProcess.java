/***********************************************************************
 * Module:  PredefinedProcess.java
 * Author:  User
 * Purpose: Defines the Class PredefinedProcess
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public class PredefinedProcess extends Symbol {

	public PredefinedProcess(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		elementType = "PredefinedProcess";
		shape = new Rectangle(getPosX() - getWidth() / 2, getPosY() - getHeight() / 2, getWidth(), getHeight());
	}

	public PredefinedProcess(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		elementType = "PredefinedProcess";
		shape = new Rectangle();
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
		g2d.drawLine(getPosX() - getWidth() / 2 + 15, getPosY() - getHeight() / 2, getPosX() - getWidth() / 2 + 15, getPosY() + getHeight()/2);
		g2d.drawLine(getPosX() + getWidth() / 2 - 15, getPosY() - getHeight() / 2, getPosX() + getWidth() / 2 - 15, getPosY() + getHeight()/2);
		
		g2d.setColor(getVisualStyle().getTextColor());
		
		float textOffsetX = (float)textLayout.getBounds().getWidth()/2 + 5;
		float textOffsetY = (float)textLayout.getBounds().getHeight()/2;

		this.textLayout.draw(g2d, position.x - textOffsetX, position.y + textOffsetY);
		
	}

	@Override
	protected void updateElementBounds(Rectangle2D bounds)
	{
		if( this.getWidth() - 30 < (bounds.getWidth()) )
			this.visualStyle.setWidth(((int)bounds.getWidth() + 50));
		if( getHeight() < (bounds.getHeight() + 10) )
			this.visualStyle.setHeight(((int)bounds.getHeight() + 15));
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		Symbol copy = new PredefinedProcess(new FlatVisualStyle(visualStyle));
		copy.setText(new String(text));
		copy.setID(ID);
		return (AlgorithmElement)copy;
	}

	@Override
	protected void updateShape()
	{
		shape = new Rectangle(getPosX() - getWidth() / 2, getPosY() - getHeight() / 2, getWidth(), getHeight());
	}
}