/***********************************************************************
 * Module:  UndoCommand.java
 * Author:  User
 * Purpose: Defines the Class UndoCommand
 ***********************************************************************/

package models;

public class UndoCommand implements Command 
{
   private Receiver receiver = null;
    
   /** @param receiver */
   public UndoCommand(Receiver receiver) {
      this.receiver = receiver;
      
   }
   
   public void unexecute() {
	   
   }
   
   public void execute() {
      receiver.executeUndo();
   }

}