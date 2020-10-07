package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import algorithmElements.Symbol;
import algorithmElements.Terminal;
import algorithmElements.FlatVisualStyle;

public class IsElementAreaTest
{

	@Test
	public void testIsElementArea() {
		Symbol symbol = new Terminal(20, 20, new FlatVisualStyle(Color.WHITE, Color.BLACK, 150, 50));
		Boolean isInSymbolArea1 = symbol.contains(new Point(30,30));
		Boolean isInSymbolArea2 = symbol.contains(new Point(10,30));
		Boolean isInSymbolArea3 = symbol.contains(new Point(170,70));
		Boolean isInSymbolArea4 = symbol.contains(new Point(120,80));
		
		assertTrue(isInSymbolArea1);
		assertTrue(isInSymbolArea2);
		assertFalse(isInSymbolArea3);
		assertFalse(isInSymbolArea4);
	}

}
