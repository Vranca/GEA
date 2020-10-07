/***********************************************************************
 * Module:  ToolbarModel.java
 * Author:  User
 * Purpose: Defines the Class ToolbarModel
 ***********************************************************************/

package models;

import java.util.Iterator;

import javax.swing.plaf.metal.MetalTheme;

import utility.Localization;

public class ToolbarModel extends AbstractSubject 
{
   private java.util.List<Command> commands = null;
   private ToolbarState state = null;
   private MetalTheme theme = null;
   private Localization localization = null;
   private ToolboxModel toolboxModel = null;

/** @pdGenerated default getter */
   public java.util.List<Command> getCommands() 
   {
      if (commands == null)
         commands = new java.util.Vector<Command>();
      return commands;
   }
   
   /** @pdGenerated default iterator getter */
   public Iterator<Command> getIteratorCommands() 
   {
      if (commands == null)
         commands = new java.util.Vector<Command>();
      return commands.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCommands */
   public void setCommands(java.util.List<Command> newCommands) 
   {
      removeAllCommands();
      for (Iterator<Command> iter = newCommands.iterator(); iter.hasNext();)
         addCommands((Command)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCommand */
   public void addCommands(Command newCommand) 
   {
      if (newCommand == null)
         return;
      if (this.commands == null)
         this.commands = new java.util.Vector<Command>();
      if (!this.commands.contains(newCommand))
         this.commands.add(newCommand);
   }
   
   /** @pdGenerated default remove
     * @param oldCommand */
   public void removeCommands(Command oldCommand) 
   {
      if (oldCommand == null)
         return;
      if (this.commands != null)
         if (this.commands.contains(oldCommand))
            this.commands.remove(oldCommand);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCommands() 
   {
      if (commands != null)
         commands.clear();
   }
   
   /** @param theme */
   public ToolbarModel() 
   {
      // TODO: implement
	   localization = Localization.getInstance();
   }

	public final ToolbarState getState() {
		return state;
	}
	
	public final void setState(ToolbarState newState) {
		this.state = newState;
		notifySubscribers();
	}
	
	public final MetalTheme getTheme() {
		return theme;
	}
	
	public final void setTheme(MetalTheme newTheme) {
		this.theme = newTheme;
	}
	
	public String getLocalString(String key)
	{
		return localization.getResources().getString(key);
	}

	public ToolboxModel getToolboxModel() {
		return toolboxModel;
	}

	public void setToolboxModel(ToolboxModel toolboxModel) {
		this.toolboxModel = toolboxModel;
	}

}