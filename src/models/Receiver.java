/***********************************************************************
 * Module:  Receiver.java
 * Author:  User
 * Purpose: Defines the Interface Receiver
 ***********************************************************************/

package models;

public interface Receiver 
{
	void addExecutedCommand(Command command);
   	void addUnexecutedCommand(Command command);
	
   	void executeSave();
   	void executeCopy();
   	void executeCut(CutCommand command);
   	void executePaste(PasteCommand command);
   	void executeUndo();
   	void executeRedo();
   	void executeAdd(AddCommand command);
   	void executeAddLine(AddLineCommand command);
   	void executeMove(MoveCommand command);
   	void executeSelect(SelectCommand command);
   	void executeDelete(DeleteCommand command);
   	void executeGroup(GroupCommand command);
   
   	void executeAddNewAlgorithm();
   
   	void unexecutePaste(PasteCommand command);
   	void unexecuteAdd(AddCommand command);
   	void unexecuteAddLine(AddLineCommand command);
   	void unexecuteSelecet();
   	void unexecuteMove(MoveCommand command);
   	void unexecuteDelete(DeleteCommand command);
	void executeAddProject();
	void executeResetZoom();
	void executeZoomOut();
	void executeZoomIn();
	void unexecuteCut(CutCommand command);
	void unexecuteGroup(GroupCommand command);
}