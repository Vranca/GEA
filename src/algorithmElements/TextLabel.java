package algorithmElements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;

public class TextLabel extends Symbol
{
	
	public TextLabel(int X, int Y, SymbolVisualStyle visualStyle)
	{
		super(X, Y, visualStyle);
		text = new String("Label");
		elementType = "Label";
		font = new Font("TimesRoman", Font.BOLD, fontSize);
		shape = new Rectangle();
	}
	
	public TextLabel(SymbolVisualStyle visualStyle)
	{
		super(visualStyle);
		text = new String("Label");
		elementType = "Label";
		position = new Point();
		font = new Font("TimesRoman", Font.BOLD, fontSize);
		shape = new Rectangle();
	}


	@Override
	public Boolean contains(Point point) {
		return getBounds().contains(point);
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(visualStyle.getTextColor());
		
		textLayout = new TextLayout(text, g2d.getFont(), g2d.getFontRenderContext());
		updateShape();
		
		textLayout.draw(g2d, position.x - (float)textLayout.getBounds().getWidth()/2, position.y + (float)textLayout.getBounds().getHeight()/2);
	}

	@Override
	public Dimension getSize() {
		Dimension size = new Dimension((int)textLayout.getBounds().getWidth(), (int)textLayout.getBounds().getHeight());
		return size;
	}

	@Override
	public AlgorithmElement copyWithoutLocation() 
	{
		TextLabel copy = new TextLabel(new FlatVisualStyle(visualStyle));
		
		copy.setID(ID);
		copy.setFont(font);
		copy.setText(text);
		copy.setTextLayout(textLayout);

		return copy;
	}

	@Override
	public AlgorithmElement copy()
	{
		TextLabel copy = new TextLabel(new FlatVisualStyle(visualStyle));
		
		copy.setPosition(position);
		copy.setID(ID);
		copy.setFont(font);
		copy.setText(text);
		copy.setTextLayout(textLayout);

		return copy;
	}

	@Override
	public Rectangle getBounds() 
	{
		Rectangle bounds = new Rectangle(position.x - (int)(shape.getBounds().getWidth()/2), position.y - (int)(shape.getBounds().getHeight()/2), (int)shape.getBounds().getWidth(), (int)shape.getBounds().getHeight());
		return bounds;
	}

	@Override
	public Boolean intersects(Rectangle shape) {
		return this.shape.intersects(shape);
	}

	@Override
	public Boolean intersects(AlgorithmElement element) {
		return shape.intersects(element.getBounds());
	}

	public final TextLayout getTextLayout() {
		return textLayout;
	}

	public final void setTextLayout(TextLayout textLayout) {
		this.textLayout = textLayout;
	}

	public final Font getFont() {
		return font;
	}

	public final void setFont(Font font) {
		this.font = font;
	}

	@Override
	protected void updateShape() {
		// TODO Auto-generated method stub
		if(textLayout != null)
			shape = textLayout.getBounds();
	}
	
}
