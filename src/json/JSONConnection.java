package json;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import algorithmElements.Connection;
import algorithmElements.Symbol;

public class JSONConnection {
	
	private JSONSymbol startSymbol = null;
	private JSONSymbol finalSymbol = null;
	private List<JSONPoint> jsonPointsList = new ArrayList<JSONPoint>();
	private String type = null;
	private int ID;
	
	
	
	public JSONConnection(Connection connection) {
		this.startSymbol = new JSONSymbol((Symbol) connection.getStartingElement());
		this.finalSymbol = new JSONSymbol((Symbol) connection.getFinalElement());
		setArray(connection.getPoints());
		this.type = connection.getElementType();
		this.ID = connection.getID();
	}
	public void setArray(List<Point> pointsList )
	{
		for (Point point : pointsList)
		{
			jsonPointsList.add(new JSONPoint(point));
		}
	}
	public JSONSymbol getStartSymbol() {
		return startSymbol;
	}

	public void setStartSymbol(JSONSymbol startSymbol) {
		this.startSymbol = startSymbol;
	}

	public JSONSymbol getFinalSymbol() {
		return finalSymbol;
	}

	public void setFinalSymbol(JSONSymbol finalSymbol) {
		this.finalSymbol = finalSymbol;
	}

	public List<JSONPoint> getPoints() {
		return jsonPointsList;
	}

	public void setPoints(List<JSONPoint> points) {
		this.jsonPointsList = points;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	
}
