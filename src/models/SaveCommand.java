/***********************************************************************
 * Module:  SaveCommand.java
 * Author:  User
 * Purpose: Defines the Class SaveCommand
 ***********************************************************************/

package models;

public class SaveCommand implements Command 
{
   private Receiver receiver = null;
   
   /** @param receiver */
   public SaveCommand(Receiver receiver) 
   {
	   this.receiver = receiver;
   }
   
   public void unexecute() 
   {
	// Do nothing
   }
   
   public void execute() 
   {
	   receiver.executeSave();
   }

}