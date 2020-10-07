package json;

import java.awt.Point;

public class JSONPoint
{
	private int xPosition;
	private int yPosition;
	
	public JSONPoint(Point point)
	{
		this.xPosition = (int) point.getX();
		this.yPosition = (int) point.getY();
	}
	
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	
}
