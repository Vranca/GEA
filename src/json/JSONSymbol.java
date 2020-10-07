package json;

import algorithmElements.Symbol;

public class JSONSymbol {
	
	JSONPoint point = null;
	JSONVisualStyle visualStyle = null;
	String text = null;
	String type = null;
	int fontSize;
	int id;
	
	
	public JSONSymbol(Symbol element) {
		this.point = new JSONPoint(element.getPosition());
		this.visualStyle = new JSONVisualStyle(element.getVisualStyle());
		this.text = element.getText();
		this.type = element.getElementType();
		this.fontSize = element.getFontSize();
		this.id = element.getID();
	}
	public JSONVisualStyle getVisualStyle() {
		return visualStyle;
	}


	public void setVisualStyle(JSONVisualStyle visualStyle) {
		this.visualStyle = visualStyle;
	}

	public JSONPoint getPoint() {
		return point;
	}


	public void setPoint(JSONPoint point) {
		this.point = point;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getFontSize() {
		return fontSize;
	}


	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
