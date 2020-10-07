package json;

import java.util.ArrayList;
import java.util.List;
import algorithmElements.Connection;
import algorithmElements.GroupedElement;
import algorithmElements.Symbol;

public class JSONGroupedElement {

	
	private int ID;
	private String type;
	private List<JSONConnection> connectionsList = new ArrayList<JSONConnection>();
	private List<JSONSymbol> symbolsList = new ArrayList<JSONSymbol>();
	
	public JSONGroupedElement(GroupedElement groupedElement) {
		for(int i = 0; i< groupedElement.getAlgorithmElement().size(); i++)
		{
			if(groupedElement.getAlgorithmElement().get(i) instanceof Connection)
			{
				connectionsList.add(new JSONConnection((Connection) groupedElement.getAlgorithmElement().get(i)));
			}
			else
			{
				symbolsList.add(new JSONSymbol((Symbol) groupedElement.getAlgorithmElement().get(i)));
			}
		}
		this.type = groupedElement.getElementType();
		
		this.ID = groupedElement.getID();
	}
	
	public List<JSONSymbol> getSymbols() {
		return symbolsList;
	}

	public void setSymbols(List<JSONSymbol> symbols) {
		this.symbolsList = symbols;
	}

	public List<JSONConnection> getConnections() {
		return connectionsList;
	}

	public void setConnections(List<JSONConnection> connections) {
		this.connectionsList = connections;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}


}
