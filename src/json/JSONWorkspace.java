package json;


import java.util.ArrayList;
import java.util.List;
import algorithmElements.Connection;
import algorithmElements.GroupedElement;
import algorithmElements.Symbol;
import models.WorkspaceModel;

public class JSONWorkspace
{
	private JSONColor backColor = null;
	private JSONVisualStyle defaultVisualStyle;
	private int width;
	private int height;
	private JSONGrid grid= null;
	private String name = null;
	private List<JSONConnection> connectionsList = new ArrayList<JSONConnection>();
	private List<JSONSymbol> symbolsList = new ArrayList<JSONSymbol>();
	private List<JSONGroupedElement> groupedElementsList = new ArrayList<JSONGroupedElement>();
	
	
	
	public JSONWorkspace(WorkspaceModel model)
	{
		for(int i = 0; i< model.getAlgorithmElements().size(); i++)
		{
			if(model.getAlgorithmElements().get(i) instanceof Connection)
			{
				connectionsList.add(new JSONConnection((Connection) model.getAlgorithmElements().get(i)));
			}
			else if(model.getAlgorithmElements().get(i) instanceof GroupedElement)
			{
				groupedElementsList.add(new JSONGroupedElement((GroupedElement) model.getAlgorithmElements().get(i)));
			}
			else
			{
				symbolsList.add(new JSONSymbol((Symbol) model.getAlgorithmElements().get(i)));
			}
		}
		this.backColor = new JSONColor(model.getBackgroundColor());
		this.defaultVisualStyle = new JSONVisualStyle(model.getDefaultVisualStyle());
		this.grid = new JSONGrid();
		this.grid.setGridSpacing(model.getGridSize());
		this.grid.setShowGrid(model.getShowGrid());
		this.height = (int) model.getWorkspaceSize().getHeight();
		this.width = (int) model.getWorkspaceSize().getWidth();
		this.name = model.getName();
	}
	public List<JSONConnection> getConnections() {
		return connectionsList;
	}
	public void setConnections(List<JSONConnection> connections) {
		this.connectionsList = connections;
	}
	public List<JSONSymbol> getSymbols() {
		return symbolsList;
	}
	public void setSymbols(List<JSONSymbol> symbols) {
		this.symbolsList = symbols;
	}
	public List<JSONGroupedElement> getGroupedElements() {
		return groupedElementsList;
	}
	public void setGroupedElements(List<JSONGroupedElement> groupedElements) {
		this.groupedElementsList = groupedElements;
	}
	public JSONColor getBackColor() {
		return backColor;
	}
	public void setBackColor(JSONColor backColor) {
		this.backColor = backColor;
	}
	public JSONVisualStyle getDefaultVisualStyle() {
		return defaultVisualStyle;
	}
	public void setDefaultVisualStyle(JSONVisualStyle defaultVisualStyle) {
		this.defaultVisualStyle = defaultVisualStyle;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public JSONGrid getGrid() {
		return grid;
	}
	public void setGrid(JSONGrid grid) {
		this.grid = grid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
