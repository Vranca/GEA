/***********************************************************************
 * Module:  VisualStyle.java
 * Author:  User
 * Purpose: Defines the Class VisualStyle
 ***********************************************************************/

package algorithmElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;

public class FlatVisualStyle implements SymbolVisualStyle 
{
   private Color backgroundColor;
   private Color borderColor;
   private Color textColor;
   private int width;
   private int height;
   private int borderThickness;
   
   public Color getBackgroundColor()
   {
      return backgroundColor;
   }
   
   /** @param newBackgroundColor */
   public void setBackgroundColor(Color newBackgroundColor)
   {
      backgroundColor = newBackgroundColor;
   }
   
   public Color getBorderColor() {
      return borderColor;
   }
   
   /** @param newBorderColor */
   public void setBorderColor(Color newBorderColor) 
   {
      borderColor = newBorderColor;
   }
   
   
   public int getWidth() 
   {
	   return width;
   }

   public void setWidth(int newWidth)
   {
	   width = newWidth;
   }

 
   public FlatVisualStyle() 
   {
      this.backgroundColor = Color.white;
      this.borderColor = Color.black;
      this.textColor = Color.BLACK;
      this.width = 75;
      this.height = 50;
      this.borderThickness = 2;
   }
   
   public FlatVisualStyle(SymbolVisualStyle visualStyle) 
   {
      this.backgroundColor = visualStyle.getBackgroundColor();
      this.borderColor = visualStyle.getBorderColor();
      this.textColor = visualStyle.getTextColor();
      this.width = visualStyle.getWidth();
      this.height = visualStyle.getHeight();
      this.borderThickness = visualStyle.getBorderThickness();
   }
   
   public FlatVisualStyle(Color backgroundColor, Color borderColor)
   {
      this.backgroundColor = backgroundColor;
      this.borderColor = borderColor;
      this.textColor = Color.BLACK;
      this.width = 75;
      this.height = 50;
      this.borderThickness = 2;
   }
   
   /** @param backgroundColor 
    * @param borderColor */
   public FlatVisualStyle(Color backgroundColor, Color borderColor, int width,int height)
   {
      this.backgroundColor = backgroundColor;
      this.borderColor = borderColor;
      this.textColor = Color.BLACK;
      this.width = width;
      this.height = height;
      this.borderThickness = 2;
   }
   
   public FlatVisualStyle(Color backgroundColor, Color borderColor, int width,int height, int borderThickness)
   {
      this.backgroundColor = backgroundColor;
      this.borderColor = borderColor;
      this.textColor = Color.BLACK;
      this.width = width;
      this.height = height;
      this.borderThickness = borderThickness;
   }
   
   public FlatVisualStyle(Color backgroundColor, Color borderColor, Color textColor,  int width,int height, int borderThickness)
   {
      this.backgroundColor = backgroundColor;
      this.borderColor = borderColor;
      this.textColor = textColor;
      this.width = width;
      this.height = height;
      this.borderThickness = borderThickness;
   }


   public int getHeight()
   {
	   return height;
   }

   public void setHeight(int newHeight) 
   {
	   height = newHeight;
   }

   public Dimension getSize() 
   {
	   return new Dimension(width,height);
   }

   @Override
   public Color getTextColor() 
   {
	   return this.textColor;
   }
   public void setTextColor(Color newTextColor) 
   {
	   textColor = newTextColor;
   }

   @Override
   public final int getBorderThickness() 
   {
	   return borderThickness;
   }

   public final void setBorderThickness(int newBorderThickness) 
   {
	   borderThickness = newBorderThickness;
   }

	@Override
	public void fill(Graphics2D g2d, Shape shape)
	{
		g2d.setColor(backgroundColor);
		g2d.fill(shape);
	}

}