/***********************************************************************
 * Module:  SelectDecorator.java
 * Author:  User
 * Purpose: Defines the Class SelectDecorator
 ***********************************************************************/

package algorithmElements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class SelectDecorator extends ElementDecorator
{
	
	public SelectDecorator()
	{
		super();
	}

	public SelectDecorator(AlgorithmElement element)
	{
		super();
		setAlgorithmElement(element);
	}
	
	@Override
	public void setPosition(Point position) 
	{
		algorithmElement.setPosition(position);	
	}

	@Override
	public Point getPosition() 
	{
		return algorithmElement.getPosition();
	}

	@Override
	public Boolean contains(Point point)
	{
		return algorithmElement.contains(point);
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("TimesRoman", Font.BOLD, 16));
		
		g2d.setColor(Color.BLACK);
		
		float[] dash = { 2f, 0f, 2f };

	    BasicStroke dashedStroke = new BasicStroke(2, 
	        BasicStroke.CAP_BUTT, 
	        BasicStroke.JOIN_ROUND, 
	        1.0f, 
	        dash,
	        2f);
	    g2d.setStroke(dashedStroke);
		
		g2d.draw(algorithmElement.getBounds());
		
		g2d.fillRect(algorithmElement.getPosition().x - (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y - (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x, algorithmElement.getPosition().y - (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x + (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y - (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x - (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y + (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x, algorithmElement.getPosition().y + (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x + (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y + (int)algorithmElement.getSize().getHeight() / 2 - 3, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x - (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y, 7, 7);
		g2d.fillRect(algorithmElement.getPosition().x + (int)algorithmElement.getSize().getWidth() / 2 - 3, algorithmElement.getPosition().y, 7, 7);
	}

	@Override
	public String getText() {
		return algorithmElement.getText();
	}
	
	@Override
	public Dimension getSize()
	{
		return algorithmElement.getSize();
	}

	@Override
	public AlgorithmElement copyWithoutLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementType() {
		return algorithmElement.getElementType();
	}

	@Override
	public Rectangle getBounds() {
		return algorithmElement.getBounds();
	}

	@Override
	public int getID() {
		return algorithmElement.getID();
	}

	@Override
	public void setID(int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean intersects(Rectangle shape)
	{
		return algorithmElement.intersects(shape);
	}

	@Override
	public Boolean intersects(AlgorithmElement element) {
		// TODO Auto-generated method stub
		return algorithmElement.intersects(element);
	}

	@Override
	public AlgorithmElement copy() {
		// TODO Auto-generated method stub
		return null;
	}
}