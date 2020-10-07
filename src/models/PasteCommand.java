/***********************************************************************
 * Module:  PasteCommand.java
 * Author:  User
 * Purpose: Defines the Class PasteCommand
 ***********************************************************************/

package models;


import java.awt.Point;
import java.util.*;

import algorithmElements.AlgorithmElement;
import utility.Clipboard;

public class PasteCommand implements Command {
   private Receiver receiver = null;
   private java.util.List<AlgorithmElement> pastedElement = null;
   private Point position = null;
   private java.util.List<Point> relativePositions = null;

/** @param receiver */
   public PasteCommand(Receiver receiver) {
      this.receiver = receiver;
      pastedElement = Clipboard.getClipboard().getElementCopies();
      relativePositions = getRelativePoints();
   }
   
   public PasteCommand(Receiver receiver,Point position) {
	      this.receiver = receiver;
	      this.position = position;
	      pastedElement = Clipboard.getClipboard().getElementCopies();
   }
   
   public Point getPosition() {
	return position;
   }

   public void setPosition(Point position) {
	this.position = position;
	}

	public void unexecute() {
      receiver.unexecutePaste(this);
   }
   
   public void execute() {
      receiver.executePaste(this);
   }
   public java.util.List<AlgorithmElement> getPastedElement() {
	return pastedElement;
   }

   public void setPastedElement(java.util.List<AlgorithmElement> pastedElement) {
	this.pastedElement = pastedElement;
   }

   public java.util.List<AlgorithmElement> getCopies()
   {
	   java.util.List<AlgorithmElement> copies = new Vector<AlgorithmElement>();
		for(AlgorithmElement element : pastedElement)
		{
			copies.add(element.copyWithoutLocation());
		}
		return copies;
   }
   
   private Point getCentralPoint()
   {
	   Point centralPoint = new Point();
	   
	   java.util.List<Double> xPoints = new Vector<Double>();
	   java.util.List<Double> yPoints = new Vector<Double>();
	   
	   for(AlgorithmElement element : Clipboard.getClipboard().getElements())
	   {
		   xPoints.add(element.getPosition().getX());
		   yPoints.add(element.getPosition().getY());
	   }
	   
	   double xValue = 0;
	   double yValue = 0;
	   
	   for(int i = 0; i < xPoints.size(); i++)
	   {
		   xValue += xPoints.get(i).doubleValue();
		   yValue += yPoints.get(i).doubleValue();
	   }
	   
	   xValue = xValue / xPoints.size();
	   yValue = yValue / yPoints.size();
	   centralPoint.setLocation(xValue, yValue);
	   
	   return centralPoint;
   }
   
   private java.util.List<Point> getRelativePoints()
   {
	   java.util.List<Point> relativePoints = new Vector<Point>();
	   Point centralPoint = getCentralPoint();
	   java.util.List<AlgorithmElement> element = Clipboard.getClipboard().getElements();
	   for(int i = 0; i < element.size(); i++)
	   {
		   relativePoints.add(new Point((int)(element.get(i).getPosition().getX() - centralPoint.getX()), (int)(element.get(i).getPosition().getY() - centralPoint.getY())));
		   pastedElement.get(i).setPosition(relativePoints.get(i));
	   }
	   	   
	   return relativePoints;
   }

public final java.util.List<Point> getRelativePositions() {
	return relativePositions;
}

public final void setRelativePositions(java.util.List<Point> relativePositions) {
	this.relativePositions = relativePositions;
}
   
}