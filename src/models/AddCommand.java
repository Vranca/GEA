/***********************************************************************
 * Module:  AddCommand.java
 * Author:  User
 * Purpose: Defines the Class AddCommand
 ***********************************************************************/

package models;

import algorithmElements.AlgorithmElement;

public class AddCommand implements Command 
{
   private Receiver     receiver     = null;
   private AlgorithmElement elementModel = null;
   
   /** @param receiver */
   public AddCommand(Receiver receiver, AlgorithmElement elementModel) 
   {
	   this.receiver     = receiver;
	   this.elementModel = elementModel;
   }
   
   public void execute() 
   {
	   receiver.executeAdd(this);
	   //receiver.addExecutedCommand(this);
   }
   
   public void unexecute()
   {
      receiver.unexecuteAdd(this);
      //receiver.addUnexecutedCommand(this);
   }

public final Receiver getReceiver() {
	return receiver;
}

public final void setReceiver(Receiver receiver) {
	this.receiver = receiver;
}

public final AlgorithmElement getElementModel() {
	return elementModel;
}

public final void setElementModel(AlgorithmElement elementModel) {
	this.elementModel = elementModel;
}

}