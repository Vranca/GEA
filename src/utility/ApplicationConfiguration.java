package utility;

import java.awt.Color;

import json.JSONColor;
import models.ApplicationModel;

public class ApplicationConfiguration
{
	String theme;
	int width;
	int height;
	String language;
	String country;
	int projectBrowserPosition;
	int workspacePosition;
	int toolboxPosition;
	int workspaceWidth;
	int workspaceHeight;
	boolean showGrid;
	int gridSpacing;
	JSONColor workspaceColor = null;
	
	public ApplicationConfiguration(String theme, int width, int height, String language, String country, int projectBrowserPosition, int workspacePosition, int toolboxPosition, int workspaceWidth, int workspaceHeight, boolean showGrid, int gridSpacing, Color workspaceColor)
	{
		this.theme = theme;
		this.width = width;
		this.height = height;
		this.language = language;
		this.country = country;
		this.projectBrowserPosition = projectBrowserPosition;
		this.workspacePosition = workspacePosition;     
		this.toolboxPosition = toolboxPosition;   
		this.workspaceWidth = workspaceWidth;
		this.workspaceHeight = workspaceHeight;
		this.showGrid = showGrid;
		this.gridSpacing = gridSpacing;
		this.workspaceColor = new JSONColor(workspaceColor);
	}
	
	public void updateConfig(ApplicationModel applicationModel)
	{
		if(applicationModel.getTheme() instanceof DarkMetalTheme)
			theme = "dark";
		else if(applicationModel.getTheme() instanceof LightMetalTheme)
			theme = "light";
		
		this.width = applicationModel.getDefaultWidth();                        
		this.height = applicationModel.getDefaultHeight();                      
		this.language = applicationModel.getLocalization().getLocale().getLanguage();                  
		this.country = applicationModel.getLocalization().getLocale().getCountry();                    
		this.projectBrowserPosition = applicationModel.getProjectBrowserPosition();
		this.workspacePosition = applicationModel.getWorkspacePosition();
		this.toolboxPosition = applicationModel.getToolboxPosition();    
	}

	public final String getTheme() 
	{
		return theme;
	}

	public final void setTheme(String theme)
	{
		this.theme = theme;
	}

	public final int getWidth() {
		return width;
	}

	public final void setWidth(int width)
	{
		this.width = width;
	}

	public final int getHeight() 
	{
		return height;
	}

	public final void setHeight(int height)
	{
		this.height = height;
	}

	public final String getLanguage() {
		return language;
	}

	public final void setLanguage(String language) {
		this.language = language;
	}

	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	public final int getProjectBrowserPosition() {
		return projectBrowserPosition;
	}

	public final void setProjectBrowserPosition(int projectBrowserPosition) {
		this.projectBrowserPosition = projectBrowserPosition;
	}

	public final int getWorkspacePosition() {
		return workspacePosition;
	}

	public final void setWorkspacePosition(int workspacePosition) {
		this.workspacePosition = workspacePosition;
	}

	public final int getToolboxPosition() {
		return toolboxPosition;
	}

	public final void setToolboxPosition(int toolboxPosition) {
		this.toolboxPosition = toolboxPosition;
	}

	public final int getWorkspaceWidth() {
		return workspaceWidth;
	}

	public final void setWorkspaceWidth(int workspaceWidth) {
		this.workspaceWidth = workspaceWidth;
	}

	public final int getWorkspaceHeight() {
		return workspaceHeight;
	}

	public final void setWorkspaceHeight(int workspaceHeight) {
		this.workspaceHeight = workspaceHeight;
	}

	public final boolean isShowGrid() {
		return showGrid;
	}

	public final void setShowGrid(boolean showGrid) {
		this.showGrid = showGrid;
	}

	public final int getGridSpacing() {
		return gridSpacing;
	}

	public final void setGridSpacing(int gridSpacing) {
		this.gridSpacing = gridSpacing;
	}

	public final JSONColor getWorkspaceColor()
	{
		return workspaceColor;
	}
	
	public Color getJavaWorkspaceColor() {
		return new Color(workspaceColor.getR(),workspaceColor.getG(), workspaceColor.getB());
	}

	public final void setWorkspaceColor(Color workspaceColor) {
		this.workspaceColor = new JSONColor(workspaceColor);
	}

	
}
