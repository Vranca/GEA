/***********************************************************************
 * Module:  RedoCommand.java
 * Author:  User
 * Purpose: Defines the Class RedoCommand
 ***********************************************************************/

package models;

public class RedoCommand implements Command 
{
   private Receiver receiver = null;
   
   /** @param receiver */
   public RedoCommand(Receiver receiver) {
      this.receiver = receiver;
   }
   
   public void unexecute() {
      // TODO: implement
   }
   
   public void execute() {
	   receiver.executeRedo();
   }

}