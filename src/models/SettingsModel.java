package models;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.plaf.metal.DefaultMetalTheme;
import utility.DarkMetalTheme;
import utility.LightMetalTheme;
import utility.ModelMediator;


public class SettingsModel extends AbstractSubject
{
	private ModelMediator modelMediator=null;
	private DefaultMetalTheme theme = null; 
	private WorkspaceModel workspacePreviewModel=null;
	private WorkspaceModel workspaceDefaultModel=null;
	
	
	public WorkspaceModel getWorkspacePreviewModel() 
	{
		return workspacePreviewModel;
	}
	
	public void setWorkspacePreviewModel(WorkspaceModel workspacePreviewModel) 
	{
		this.workspacePreviewModel = workspacePreviewModel;
	}
	
	public ModelMediator getModelMediator() 
	{
		return modelMediator;
	}
	
	public void setModelMediator(ModelMediator modelMediator)
	{
		this.modelMediator = modelMediator;
	}
	public SettingsModel( ModelMediator modelMediatorl)
	{
		this.modelMediator = modelMediatorl;
		modelMediatorl.setSettingsModel(this);
		workspacePreviewModel = WorkspaceModel.getPreviewModel();
		workspaceDefaultModel = new WorkspaceModel();
		
		workspaceDefaultModel.setBackgroundColor(modelMediatorl.getApplicationModel().getConfig().getJavaWorkspaceColor());
		workspaceDefaultModel.setShowGrid(modelMediatorl.getApplicationModel().getConfig().isShowGrid());
		workspaceDefaultModel.setGridSize(modelMediatorl.getApplicationModel().getConfig().getGridSpacing());
		workspaceDefaultModel.setWorkspaceSize(new Dimension(modelMediatorl.getApplicationModel().getConfig().getWorkspaceWidth(), modelMediatorl.getApplicationModel().getConfig().getWorkspaceHeight()));
		
		workspacePreviewModel.setBackgroundColor(workspaceDefaultModel.getBackgroundColor());
		workspacePreviewModel.setShowGrid(workspaceDefaultModel.getShowGrid());
		workspacePreviewModel.setGridSize(workspaceDefaultModel.getGridSize());
	}
	
	public void setDarkTheme()
	{
			theme=new DarkMetalTheme();
			modelMediator.setTheme(theme);
			notifySubscribers();

	}
	
	public void setLightTheme()
	{
		theme=new LightMetalTheme();
		modelMediator.setTheme(theme);
		notifySubscribers();
	}
	
	public void setTheme(String themeName)
	{
		if(themeName.equals("Dark Theme"))
		 {
			this.setDarkTheme();
		 }
		else if(themeName.equals("Light Theme"))
		 {
			this.setLightTheme();
		 }
	}
	
	public void setLayout(int projectBrowserPosition,int positionWorkspace,int positionToolbox)
	{
		modelMediator.setDefaultLayout(projectBrowserPosition, positionWorkspace, positionToolbox);
		notifySubscribers();
	}
	
	public void reset()
	{		
		workspacePreviewModel.setGridSize(workspaceDefaultModel.getGridSize());
		workspacePreviewModel.setBackgroundColor(workspaceDefaultModel.getBackgroundColor());
		workspacePreviewModel.setShowGrid(workspaceDefaultModel.getShowGrid());
		workspacePreviewModel.notifySubscribers();	
	}
	public void applyDefulatWorksapceProperties()
	{
		workspaceDefaultModel.setBackgroundColor(workspacePreviewModel.getBackgroundColor());
		workspaceDefaultModel.setGridSize(workspacePreviewModel.getGridSize());
		workspaceDefaultModel.setShowGrid(workspacePreviewModel.getShowGrid());
		workspaceDefaultModel.setWorkspaceSize(workspacePreviewModel.getWorkspaceSize());
		workspaceDefaultModel.notifySubscribers();
	}
	public void setWorkspaceProperties()
	{
		modelMediator.setDefaultWorkspaceBackground(workspaceDefaultModel.getBackgroundColor());
		modelMediator.setDefaulWorkspaceGridlinesSpacing(workspaceDefaultModel.getGridSize());
		modelMediator.setDefulatWorkspaceShowGrid(workspaceDefaultModel.getShowGrid());
		modelMediator.setDefulatWorkspaceSize(workspaceDefaultModel.getWorkspaceSize());
		notifySubscribers();
	}
	public void setWorkspaceBackgroundColor(Color backgroundColor)
    {
		workspacePreviewModel.setBackgroundColor(backgroundColor);
		workspacePreviewModel.notifySubscribers();
	}
	public void setWorkspaceSize(int width, int height)
	{
		workspacePreviewModel.setWorkspaceSize(new Dimension(width,height));
		workspacePreviewModel.notifySubscribers();
	}
	public void setWorkspaceGridlines(int gridSpacing)
    {
		workspacePreviewModel.setGridSize(gridSpacing);
		workspacePreviewModel.notifySubscribers();
	}
	
	public void invertShowGrid()
	{
		workspacePreviewModel.setShowGrid(!workspacePreviewModel.getShowGrid());
		
		notifySubscribers();
	}

	public final WorkspaceModel getWorkspaceDefaultModel() {
		return workspaceDefaultModel;
	}

	public final void setWorkspaceDefaultModel(WorkspaceModel workspaceDefaultModel) {
		this.workspaceDefaultModel = workspaceDefaultModel;
	}
}
