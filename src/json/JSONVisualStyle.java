package json;
import java.awt.Color;

import algorithmElements.FlatVisualStyle;
import algorithmElements.SymbolVisualStyle;

public class JSONVisualStyle {
	
	private JSONColor backColor = null;
	private JSONColor textColor = null;
	private JSONColor borderColor = null;
	private String type = null;
	private int width;
	private int height;
	private int borderThickness;
	
	public JSONVisualStyle(SymbolVisualStyle visualStyle) 
	{
		this.backColor = new JSONColor(visualStyle.getBackgroundColor());
		this.textColor = new JSONColor(visualStyle.getTextColor());
		this.borderColor = new JSONColor(visualStyle.getBorderColor());
		if(visualStyle instanceof FlatVisualStyle)
			this.type = "Flat";
		this.width = visualStyle.getWidth();
		this.borderThickness = visualStyle.getBorderThickness();
		this.height = visualStyle.getHeight();
		
	}
	public JSONColor getBackColor() {
		return backColor;
	}
	public void setBackColor(JSONColor backColor) {
		this.backColor = backColor;
	}
	public JSONColor getTextColor() {
		return textColor;
	}
	public void setTextColor(JSONColor textColor) {
		this.textColor = textColor;
	}
	public JSONColor getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(JSONColor borderColor) {
		this.borderColor = borderColor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getBorderThickness() {
		return borderThickness;
	}
	public void setBorderThickness(int borderThickness) {
		this.borderThickness = borderThickness;
	}
	public SymbolVisualStyle createVisualStyle()
	{
		Color backColor = new Color(this.backColor.getR(),this.backColor.getG(),this.backColor.getB());
		Color borderColor = new Color(this.borderColor.getR(),this.borderColor.getG(),this.borderColor.getB());
		Color textColor = new Color(this.textColor.getR(), this.textColor.getG(), this.textColor.getB());
		
		FlatVisualStyle visualStyle = new FlatVisualStyle(backColor, borderColor, textColor, this.width, height, borderThickness);
		return visualStyle;
	}
	
	
	
}
