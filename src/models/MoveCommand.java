/***********************************************************************
 * Module:  MoveCommand.java
 * Author:  User
 * Purpose: Defines the Class MoveCommand
 ***********************************************************************/

package models;

import java.awt.Point;
import algorithmElements.AlgorithmElement;

public class MoveCommand implements Command {
   private Receiver receiver = null;
   private AlgorithmElement elementModel = null;
   private Point oldPosition = null;
   private Point newPosition = null;
   
   public MoveCommand()
   {

   }
   
   /** @param receiver */
   public MoveCommand(Receiver receiver, AlgorithmElement elementModel) {
	   this.receiver = receiver;
	   this.elementModel = elementModel;
	   oldPosition = elementModel.getPosition();
   }
   
   public void execute() {
	   receiver.executeMove(this);
	   //receiver.addExecutedCommand(this);
   }
   
   public void unexecute() {
	   receiver.unexecuteMove(this);
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

public final Point getOldPosition() {
	return oldPosition;
}

public final void setOldPosition(Point oldPosition) {
	this.oldPosition = oldPosition;
}

public final Point getNewPosition() {
	return newPosition;
}

public final void setNewPosition(Point newPosition) {
	this.newPosition = newPosition;
}

}