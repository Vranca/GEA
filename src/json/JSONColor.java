package json;
import java.awt.Color;

public class JSONColor {

	int r;
	int g;
	int b;
	
	
	public JSONColor(Color color) {
		this.r =color.getRed();
		this.g = color.getGreen();
		this.b = color.getBlue();
	}
	
	
	
	
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}


	
	
}
