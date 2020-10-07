/***********************************************************************
 * Module:  SymbolVisualStyle.java
 * Author:  User
 * Purpose: Defines the Interface SymbolVisualStyle
 ***********************************************************************/

package algorithmElements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;

public interface SymbolVisualStyle 
{
   Dimension getSize();
   Color getBackgroundColor();
   void setBackgroundColor(Color newBackgroundColor);
   Color getBorderColor();
   void setBorderColor(Color newBorderColor);
   Color getTextColor();
   void setTextColor(Color newTextColor);
   int getWidth();
   void setWidth(int newWidth);
   int getHeight();
   void setHeight(int newHeight);
   int getBorderThickness();
   void setBorderThickness(int newBorderThickness);
   void fill(Graphics2D g2d, Shape shape);
}