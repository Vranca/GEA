/***********************************************************************
 * Module:  CutCommand.java
 * Author:  User
 * Purpose: Defines the Class CutCommand
 ***********************************************************************/

package models;

import algorithmElements.AlgorithmElement;

public class CutCommand implements Command {
   private Receiver receiver = null;
   private java.util.List<AlgorithmElement> cutElement = null;
   


/** @param receiver */
   public CutCommand(Receiver receiver) {
     	this.receiver = receiver;
   }
   
   public void unexecute() {
	   receiver.unexecuteCut(this);
   }
   
   public void execute() {
     receiver.executeCut(this);
   }
   
   public java.util.List<AlgorithmElement> getCutElement() {
	return cutElement;
   }

   public void setCutElement(java.util.List<AlgorithmElement> cutElement) {
	this.cutElement = cutElement;
   }

}