/***********************************************************************
 * Module:  CopyCommand.java
 * Author:  User
 * Purpose: Defines the Class CopyCommand
 ***********************************************************************/

package models;

public class CopyCommand implements Command 
{
   private Receiver receiver = null;

   /** @param receiver */
   public CopyCommand(Receiver receiver) 
   {
      this.receiver = receiver;
   }
   
   public void unexecute()
   {
	   
   }
   
   public void execute() {	   
	   receiver.executeCopy();	
   }

}