package utility;

import java.awt.Color;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class DarkMetalTheme extends DefaultMetalTheme
{
	public String getName() { return "Dark Metal"; }
	
	// dark shades
	private final ColorUIResource primary1 		= new ColorUIResource(Color.LIGHT_GRAY);
	private final ColorUIResource primary2 		= new ColorUIResource(Color.GRAY);
	private final ColorUIResource primary3 		= new ColorUIResource(Color.DARK_GRAY); 

	private final ColorUIResource secondary1 	= new ColorUIResource(Color.LIGHT_GRAY);
	private final ColorUIResource secondary2 	= new ColorUIResource(Color.GRAY);
	private final ColorUIResource secondary3 	= new ColorUIResource(Color.DARK_GRAY);
	
	private final ColorUIResource black         = new ColorUIResource(Color.WHITE);
	private final ColorUIResource white         = new ColorUIResource(Color.GRAY);
	
	private final ColorUIResource controlTextColor     = new ColorUIResource(Color.WHITE);

	// the functions overridden from the base class => DefaultMetalTheme
		
	protected ColorUIResource getPrimary1() { return primary1; }  
	protected ColorUIResource getPrimary2() { return primary2; } 
	protected ColorUIResource getPrimary3() { return primary3; } 


	protected ColorUIResource getSecondary1() { return secondary1; }
	protected ColorUIResource getSecondary2() { return secondary2; }
	protected ColorUIResource getSecondary3() { return secondary3; }
	
	public ColorUIResource getControlTextColor() {return controlTextColor; }
	
	public ColorUIResource getBlack() { return black; }
	public ColorUIResource getWhite() { return white; }
}
