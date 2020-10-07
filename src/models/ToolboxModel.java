/***********************************************************************
 * Module:  ToolboxModel.java
 * Author:  User
 * Purpose: Defines the Class ToolboxModel
 ***********************************************************************/

package models;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalTheme;

import algorithmElements.AlgorithmElement;
import algorithmElements.FlatVisualStyle;
import algorithmElements.Symbol;
import algorithmElements.TextLabel;
import utility.Localization;
import utility.ModelMediator;
import views.Subscriber;

public class ToolboxModel extends AbstractSubject implements Subscriber 
{
   private MetalTheme theme = null;
   private java.util.List<Command> commands = null;
   private OpenWorkspacesModel openWorkspaceModels = null;
   private AlgorithmElement previewElement = null;
   private Localization localization = null; 
   private ModelMediator modelMediator = null;
   
   /** @pdGenerated default getter */
   public java.util.List<Command> getCommands() {
      if (commands == null)
         commands = new java.util.Vector<Command>();
      return commands;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Command> getIteratorCommands() {
      if (commands == null)
         commands = new java.util.Vector<Command>();
      return commands.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCommands */
   public void setCommands(java.util.List<Command> newCommands) {
      removeAllCommands();
      for (java.util.Iterator<Command> iter = newCommands.iterator(); iter.hasNext();)
         addCommands((Command)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCommand */
   public void addCommands(Command newCommand) {
      if (newCommand == null)
         return;
      if (this.commands == null)
         this.commands = new java.util.Vector<Command>();
      if (!this.commands.contains(newCommand))
         this.commands.add(newCommand);
   }
   
   /** @pdGenerated default remove
     * @param oldCommand */
   public void removeCommands(Command oldCommand) {
      if (oldCommand == null)
         return;
      if (this.commands != null)
         if (this.commands.contains(oldCommand))
            this.commands.remove(oldCommand);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCommands() {
      if (commands != null)
         commands.clear();
   }
   
   public OpenWorkspacesModel getOpenWorkspacesModel()
   {
	   return openWorkspaceModels;
   }
   
   public void setOpenWorkspacesModel(OpenWorkspacesModel openWorkspaceModels)
   {
	   this.openWorkspaceModels = openWorkspaceModels;
   }
   
   /** @pdGenerated default getter */
   public java.util.List<WorkspaceModel> getOpenWorkspaceModels() {
      return openWorkspaceModels.getOpenWorkspaceModels();
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<WorkspaceModel> getIteratorOpenWorkspaceModels() {
      return openWorkspaceModels.getIteratorOpenWorkspaceModels();
   }
   
   /** @pdGenerated default setter
     * @param newOpenWorkspaceModels */
   public void setOpenWorkspaceModels(java.util.List<WorkspaceModel> newOpenWorkspaceModels) {
      openWorkspaceModels.setOpenWorkspaceModels(newOpenWorkspaceModels);
      notifySubscribers();
   }
   
   /** @pdGenerated default add
     * @param newWorkspaceModel */
   public void addOpenWorkspaceModels(WorkspaceModel newWorkspaceModel) {
      openWorkspaceModels.addOpenWorkspaceModels(newWorkspaceModel);
      if(openWorkspaceModels.getOpenWorkspaceModels().size() == 1)
    	 newWorkspaceModel.setIsSelected(true);
      notifySubscribers();
   }
   
   /** @pdGenerated default remove
     * @param oldWorkspaceModel */
   public void removeOpenWorkspaceModels(WorkspaceModel oldWorkspaceModel) {
      openWorkspaceModels.removeOpenWorkspaceModels(oldWorkspaceModel);
      notifySubscribers();
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOpenWorkspaceModels() {
      openWorkspaceModels.removeAllOpenWorkspaceModels();
      notifySubscribers();
   }
   
   public WorkspaceModel getWorkspaceModelAt(int index)
   {
	   return openWorkspaceModels.getWorkspaceModelAt(index);
   }
   public WorkspaceModel getSelectedModel()
   {
	   return openWorkspaceModels.getSelectedModel();
   }
   
   public WorkspaceModel getWorkspace(String workspaceName)
   {
	   return openWorkspaceModels.getWorkspace(workspaceName);
   }
   
   public ToolboxModel() 
   {
	   openWorkspaceModels = new OpenWorkspacesModel();
	   commands = new Vector<Command>();
	   localization = Localization.getInstance();
   }
   
   public ToolboxModel(MetalTheme theme)
   {
	   this.theme = theme;
	   openWorkspaceModels = new OpenWorkspacesModel();
	   commands = new Vector<Command>();
	   localization = Localization.getInstance();
   }

   public final AlgorithmElement getPreviewElement() {
	return previewElement;
}

	public final void setPreviewElement(AlgorithmElement previewElement,Point point)
	{
		if(previewElement instanceof Symbol)
		{
			this.previewElement = previewElement.copyWithoutLocation();
			this.previewElement.setPosition(point);
		}
	}
	
	public final void setPreviewElement(AlgorithmElement previewElement)
	{
		if(previewElement instanceof Symbol || previewElement instanceof TextLabel)
		{
			this.previewElement = previewElement.copyWithoutLocation();
		}
	}
	
	public final void clearPreview()
	{
		previewElement = null;
		notifySubscribers();
	}
	
	public final MetalTheme getTheme() {
		   return theme;
	   }
	
	   public final void setTheme(MetalTheme theme) {
		   this.theme = theme;
	   }
	
	@Override
	public void update() 
	{
		if(getSelectedModel() != null)
		{
			if(getSelectedModel().getSelectedAlgorithmElements().size() == 1)
				setPreviewElement(getSelectedModel().getSelectedAlgorithmElements().get(0));
			else {
				clearPreview();
			}
			notifySubscribers();
		}
		
	}
	
	public String getLocalString(String key)
	{
		return localization.getResources().getString(key);
	}
	
	public ModelMediator getModelMediator() {
		return modelMediator;
	}
	
	public void setModelMediator(ModelMediator modelMediator) {
		this.modelMediator = modelMediator;
	}
	
	
	public void applyPreviewElement()
	{
		if(previewElement instanceof Symbol)
		{
			Symbol previewElement=(Symbol) this.getPreviewElement();
			Symbol element=(Symbol) this.getSelectedModel().getSelectedAlgorithmElements().get(0);
			element.setText(previewElement.getText());
			element.setFontSize(previewElement.getFontSize());
			element.setVisualStyle(new FlatVisualStyle(previewElement.getVisualStyle()));
		}

		this.getSelectedModel().notifySubscribers();
		notifySubscribers();
	}

	public void updatePreview(int fontSize, Color backColor, Color borderColor, int borderThickness, int elementHeight,
			Color foreColor, int elementWidth, String text) {
		try 
		{
			if(previewElement instanceof Symbol)
			{
			 Symbol previewSymbol = (Symbol) previewElement;
			 
			 previewSymbol.setFontSize(fontSize);
			 previewSymbol.getVisualStyle().setBackgroundColor(backColor);
			 previewSymbol.getVisualStyle().setBorderColor(borderColor);
			 previewSymbol.getVisualStyle().setBorderThickness(borderThickness);
			 previewSymbol.getVisualStyle().setHeight(elementHeight);
			 previewSymbol.getVisualStyle().setTextColor(foreColor);
			 previewSymbol.getVisualStyle().setWidth(elementWidth);
			 previewSymbol.setText(text);
			}
			 
			 notifySubscribers();
		}
		catch(Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, "Element can't be showed!");
		}
		
	}
	
	public void resetPreview()
	{
		Symbol previewElement=(Symbol) this.getPreviewElement();
		Symbol element=(Symbol) this.getSelectedModel().getSelectedAlgorithmElements().get(0);
		previewElement.setText(element.getText());
		previewElement.setFontSize(element.getFontSize());
		previewElement.setVisualStyle(new FlatVisualStyle(element.getVisualStyle()));
		notifySubscribers();
	}
	
	public void setDefaultStyle()
	{
		WorkspaceModel selectedModel = getSelectedModel();
		Symbol preview = (Symbol) previewElement;
		selectedModel.setDefaultVisualStyle(new FlatVisualStyle(preview.getVisualStyle()));
	}
}