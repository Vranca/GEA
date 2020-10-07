package utility;



import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import algorithmElements.AlgorithmElement;
import algorithmElements.Connection;
import algorithmElements.FinishedState;
import algorithmElements.GroupedElement;
import algorithmElements.Symbol;
import algorithmElements.SymbolVisualStyle;
import json.JSONConnection;
import json.JSONGroupedElement;
import json.JSONSymbol;

public abstract class ElementFactory
{
	private static java.util.HashMap<String, ElementCreator> elementCreatorMap = createMap();
	
	public static AlgorithmElement createElement(String elementType)
	{
		ElementCreator elementCreator = elementCreatorMap.get(elementType);
		return elementCreator.create();
	}
	
	public static AlgorithmElement createElement(String elementType, SymbolVisualStyle defaultVisualStyle)
	{
		ElementCreator elementCreator = elementCreatorMap.get(elementType);
		return elementCreator.create(defaultVisualStyle);
	}
	public static Connection createConnectionFromJson(JSONConnection jsonConnection,List<AlgorithmElement> elementList)
	{
		Connection newConnection = new Connection();
		AlgorithmElement finalElement = null;
		AlgorithmElement startingElement = null;
		
	
		
		for(AlgorithmElement element : elementList)
		{
			if(element.getPosition().getX() == jsonConnection.getStartSymbol().getPoint().getxPosition() && element.getPosition().getY() == jsonConnection.getStartSymbol().getPoint().getyPosition())
			{
				startingElement = element;
			}
			if(element.getPosition().getX() == jsonConnection.getFinalSymbol().getPoint().getxPosition() && element.getPosition().getY() == jsonConnection.getFinalSymbol().getPoint().getyPosition())
			{
				finalElement = element;
			}
		}
		
		newConnection.forceSetFinalElement(finalElement);
		newConnection.setStartingElement(startingElement);
		newConnection.setID(jsonConnection.getID());
		List<Point> points = new Vector<Point>();
		
		for(int i = 0; i < jsonConnection.getPoints().size(); i++ )
		{
			points.add(new Point(jsonConnection.getPoints().get(i).getxPosition(),jsonConnection.getPoints().get(i).getyPosition()));
		}
		newConnection.setPoints(points);
		newConnection.setState(new FinishedState());
	//	createdElement.setVisualStyle(jsonSymbol.getVisualStyle());
		return newConnection;
	}
	
	public static GroupedElement createGroupedElementFromJson(JSONGroupedElement jsonGroupedElement)
	{
		List<AlgorithmElement> elements = new Vector<AlgorithmElement>();
		
		GroupedElement createdElement = new GroupedElement();
		createdElement.setID(jsonGroupedElement.getID());
		for(int i = 0; i < jsonGroupedElement.getSymbols().size();i++)
		{
			elements.add(createElementFromJson(jsonGroupedElement.getSymbols().get(i)));
		}
		for(int i = 0; i < jsonGroupedElement.getConnections().size();i++)
		{
			elements.add(createConnectionFromJson(jsonGroupedElement.getConnections().get(i),elements));
		}
		createdElement.setAlgorithmElement(elements);
	//	createdElement.setVisualStyle(jsonSymbol.getVisualStyle());
		return createdElement;
	}
	
	public static AlgorithmElement createElementFromJson(JSONSymbol jsonSymbol)
	{
		ElementCreator elementCreator = elementCreatorMap.get(jsonSymbol.getType());
		Symbol createdElement = (Symbol) elementCreator.create();
		createdElement.setID(jsonSymbol.getId());
		createdElement.setText(jsonSymbol.getText());
		createdElement.setFontSize(jsonSymbol.getFontSize());
		createdElement.setPosition(jsonSymbol.getPoint().getxPosition(),jsonSymbol.getPoint().getyPosition());
		createdElement.setVisualStyle(jsonSymbol.getVisualStyle().createVisualStyle());
		return createdElement;
	}
	
	private static HashMap<String, ElementCreator> createMap()
	{
		java.util.HashMap<String, ElementCreator> map = new HashMap<>();
		map.put("Terminal", new TerminalCreator());
		map.put("Annotation", new AnnotationCreator());
		map.put("Process", new ProcessCreator());
		map.put("Decision", new DecisionCreator());
		map.put("InputOutput", new InputOutputCreator());
		map.put("PredefinedProcess", new PredefinedProcessCreator());
		map.put("OffPageConnector", new OffPageConnectorCreator());
		map.put("OnPageConnector", new OnPageConnectorCreator());
		map.put("Label", new LabelCreator());
		
		return map;
	}
}
