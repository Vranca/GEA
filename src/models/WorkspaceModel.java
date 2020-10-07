/***********************************************************************
 * Module:  WorkspaceModel.java
 * Author:  User
 * Purpose: Defines the Class WorkspaceModel
 ***********************************************************************/

package models;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Stack;
import java.util.Vector;

import algorithmElements.AlgorithmElement;
import algorithmElements.SelectDecorator;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.Terminal;
import utility.Clipboard;
import utility.ModelMediator;
import algorithmElements.FlatVisualStyle;
import algorithmElements.GroupedElement;

public class WorkspaceModel extends AbstractSubject implements Receiver 
{
	private java.util.List<AlgorithmElement> algorithmElements = null;
	private AlgorithmElement newAlgorithmElement = null;
	private AlgorithmElement movingElement = null;
	private SelectDecorator selectedElement = null;
	private java.util.List<SelectDecorator> selectedElements = null;
	private Rectangle selectionArea = null;
	
	private Color backgroundColor = null;
	private String name = null;
	private SymbolVisualStyle defaultVisualStyle = null;
	private Boolean showGrid = false;
	private int gridSize;
	private Boolean isSelected =false;
	private Boolean isOpen = false;
	private Dimension workspaceSize = null;
	private double zoomScale = 1;
	private Clipboard clipboard = null;
	
	private java.util.Stack<Command> undoStack = null;
	private java.util.Stack<Command> redoStack = null;
	
	private ModelMediator modelMediator = null;
		
	private WorkspaceState state = null;
   
	public WorkspaceModel()
	{
		algorithmElements = new java.util.Vector<AlgorithmElement>();
		backgroundColor = Color.WHITE;
		name = "Algorithm";
		selectedElement = new SelectDecorator();
		selectedElements = new Vector<SelectDecorator>();
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
		state = new WorkspaceSelectState(this);
		workspaceSize = new Dimension(1000, 1000);
		clipboard = Clipboard.getClipboard();
	   
		//*************************************************
		//TEST
		//*************************************************
		defaultVisualStyle = new FlatVisualStyle(backgroundColor, Color.BLACK);

		showGrid = true;
		gridSize = 20;
		//*************************************************
	}
	
	public WorkspaceModel(String workspaceName)
	{
		algorithmElements = new java.util.Vector<AlgorithmElement>();
		backgroundColor = Color.WHITE;
		name = workspaceName;
		selectedElement = new SelectDecorator();
		selectedElements = new Vector<SelectDecorator>();
		undoStack = new Stack<Command>();
		redoStack = new Stack<Command>();
		state = new WorkspaceSelectState(this);
		workspaceSize = new Dimension(1000, 1000);
		clipboard = Clipboard.getClipboard();
	   
		//*************************************************
		//TEST
		//*************************************************
		defaultVisualStyle = new FlatVisualStyle(backgroundColor, Color.BLACK);
		
		showGrid = true;
		gridSize = 15;
		//*************************************************
	}
	
	public static WorkspaceModel getPreviewModel()
	{
		WorkspaceModel previewModel = new WorkspaceModel("preview");
		previewModel.setWorkspaceSize(new Dimension(300, 120));
		AlgorithmElement previewElement = new Terminal(150, 60, new FlatVisualStyle());
		previewModel.getAlgorithmElements().add(previewElement);
		
		return previewModel;
	}
   
	/** @pdGenerated default getter */
	public java.util.List<AlgorithmElement> getAlgorithmElements() {
		if (algorithmElements == null)
			algorithmElements = new java.util.Vector<AlgorithmElement>();
		return algorithmElements;
	}
   
	/** @pdGenerated default iterator getter */
	public java.util.Iterator<AlgorithmElement> getIteratorAlgorithmElements() {
		if (algorithmElements == null)
			algorithmElements = new java.util.Vector<AlgorithmElement>();
		return algorithmElements.iterator();
	}
   
	/** @pdGenerated default setter
	 * @param newAlgorithmElements */
	public void setAlgorithmElements(java.util.List<AlgorithmElement> newAlgorithmElements) {
		removeAllAlgorithmElements();
		for (java.util.Iterator<AlgorithmElement> iter = newAlgorithmElements.iterator(); iter.hasNext();)
			addAlgorithmElements((AlgorithmElement)iter.next());
	}
   
	public final Color getBackgroundColor() {
		return backgroundColor;
	}

	public final void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		notifySubscribers();
	}

	/** @pdGenerated default add
	 * @param newElementModel */
	
	public void addAlgorithmElements(AlgorithmElement newAlgorithmElement) {
		if (newAlgorithmElement == null)
			return;
		if (this.algorithmElements == null)
			this.algorithmElements = new java.util.Vector<AlgorithmElement>();
		if (!this.algorithmElements.contains(newAlgorithmElement))
		{
			int id = getId();
			this.algorithmElements.add(newAlgorithmElement);
			this.algorithmElements.get(algorithmElements.size() - 1).setID(id);
			updateWorkspaceSize();
		}
	}
	
	public void addSelectedElements(AlgorithmElement newSelectedElement) {
		if (selectedElements == null)
			return;
		SelectDecorator selectedElement = new SelectDecorator(newSelectedElement);
		if (this.selectedElements == null)
			this.selectedElements = new java.util.Vector<SelectDecorator>();
		if (!this.selectedElements.contains(selectedElement))
		{
			this.selectedElements.add(selectedElement);
		}
	}
	
	public int getId()
	{
		int id = 1;	
			for(int i = 0 ; i < algorithmElements.size(); i++)
			{
				if(algorithmElements.get(i).getID() == id )
				{
					id++;
				}
				else
				{
					break;
				}
			}	
		return id;
	}
   
	/** @pdGenerated default remove
	 * @param oldElementModel */
	public void removeAlgorithmElements(AlgorithmElement oldAlgorithmElement) {
		if (oldAlgorithmElement == null)
			return;
		if (this.algorithmElements != null)
			if (this.algorithmElements.contains(oldAlgorithmElement))
				this.algorithmElements.remove(oldAlgorithmElement);
	}
	
	public void removeAlgorithmElements(java.util.List<AlgorithmElement> elements)
	{
		for (AlgorithmElement algorithmElement : elements)
		{
			removeAlgorithmElements(algorithmElement);
		}
	}
	
	public void removeSelectedElements(AlgorithmElement oldSelectedElement) {
		if (oldSelectedElement == null)
			return;
		SelectDecorator selectedElement = new SelectDecorator(oldSelectedElement);
		if (this.algorithmElements != null)
			if (this.algorithmElements.contains(selectedElement))
				this.algorithmElements.remove(selectedElement);
	}
   
	/** @pdGenerated default removeAll */
	public void removeAllAlgorithmElements() {
		if (algorithmElements != null)
			algorithmElements.clear();
	}
	
	public void addPendingElement()
	{
		Boolean intersects = false;
		for(AlgorithmElement element : algorithmElements)
		{
			intersects = element.intersects(newAlgorithmElement) || intersects;
		}
		if( !intersects &&( newAlgorithmElement.getPosition().getX() < workspaceSize.getWidth() && newAlgorithmElement.getPosition().getY() < workspaceSize.getHeight()))
		{
			addAlgorithmElements(newAlgorithmElement);
			notifySubscribers();
		}
	}
	
	public void addNewConnection()
	{
		addAlgorithmElements(newAlgorithmElement);
		resetNewAlgorithmElement();
		notifySubscribers();
	}
   
	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final SymbolVisualStyle getDefaultVisualStyle() {
		return defaultVisualStyle;
	}

	public final void setDefaultVisualStyle(SymbolVisualStyle defaultVisualStyle) {
		this.defaultVisualStyle = defaultVisualStyle;
		notifySubscribers();
	}
	
	public final AlgorithmElement getNewAlgorithmElement() {
		return newAlgorithmElement;
	}

	public final void setNewAlgorithmElement(AlgorithmElement newAlgorithmElement) {
		this.newAlgorithmElement = newAlgorithmElement;
		notifySubscribers();
	}
	
	public final void resetNewAlgorithmElement()
	{
		newAlgorithmElement = null;
		notifySubscribers();
	}

	public final Boolean getShowGrid() {
		return showGrid;
	}

	public final void setShowGrid(Boolean showGrid) {
		this.showGrid = showGrid;
		notifySubscribers();
	}

	public final int getGridSize() {
		return gridSize;
	}

	public final void setGridSize(int gridSize) {
		this.gridSize = gridSize;
		notifySubscribers();
	}
	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	public final WorkspaceState getState() {
		return state;
	}

	public final void setState(WorkspaceState state) {
		this.state = state;
	}

	public void executeCopy() 
	{
		this.clipboard.setClipboardElements(getSelectedAlgorithmElements());
		notifySubscribers();
	}
   
	public void executeSave() 
	{
       
		
      
	}
   
	public void executeCut(CutCommand command) 
	{
		this.clipboard.setClipboardElements(getSelectedAlgorithmElements());
		if(command.getCutElement() == null)
			command.setCutElement(getSelectedAlgorithmElements());
		removeAlgorithmElements(getSelectedAlgorithmElements());
		clearSelection();
		resetNewAlgorithmElement();
		undoStack.push(command);
		
		
		notifySubscribers();
	}
   
	public void executePaste(PasteCommand command)
	{
		undoStack.push(command);
		this.clearSelection();
		GroupedElement pastedElement = new GroupedElement();
		for(AlgorithmElement element : command.getPastedElement())
		{
			pastedElement.addAlgorithmElement(element);
		}
		this.setNewAlgorithmElement(pastedElement);
		if(command.getPosition() != null)
		{
			newAlgorithmElement.setPosition(command.getPosition());
			addPendingElement();
			if(command.getPastedElement().size() == 1)
			{
				GroupedElement element = (GroupedElement) this.getNewAlgorithmElement();
				element.setShape(command.getPastedElement().get(0).getBounds());
			}

			java.util.List<AlgorithmElement> list = new Vector<AlgorithmElement>();
			list.add(getNewAlgorithmElement());
			this.setSelectedElements(list);
			this.executeGroup(null);
			this.clearSelection();
			
			
			this.resetNewAlgorithmElement();
			
			resetNewAlgorithmElement();
			this.setState(new WorkspaceSelectState(this));
		}
		else
			this.setState(new WorkspacePasteState(this));
	}

   	public void executeUndo() 
	{
      // TODO: implement
		Command lastCommand = undoStack.pop();
		lastCommand.unexecute();
		redoStack.push(lastCommand);
		resetNewAlgorithmElement();
		notifySubscribers();
	}
   
	public void executeRedo() 
	{
      // TODO: implement
		Command lastCommand = redoStack.pop();
		lastCommand.execute();
		//undoStack.push(lastCommand);
		resetNewAlgorithmElement();
		notifySubscribers();
	}
   
	public void executeAdd(AddCommand command) 
	{
		int oldSize = algorithmElements.size();
		undoStack.push(command);
		newAlgorithmElement = command.getElementModel();
		addPendingElement();
		int newSize = algorithmElements.size();
		if(oldSize == newSize)
			undoStack.pop();
		clearSelection();
		notifySubscribers();
	}
   
	public void executeMove(MoveCommand command) 
	{
		undoStack.push(command);
		movingElement = command.getElementModel();
		setMovingElementPosition(command.getNewPosition());
		finishMovement();
		updateWorkspaceSize();
		notifySubscribers();
	}
	
	public void executeSelect(SelectCommand command)
	{
		setSelectedElements(command.getSelectedElements());
		notifySubscribers();
	}

	@Override
	public void unexecutePaste(PasteCommand command) 
	{
		removeAlgorithmElements(command.getPastedElement());
		
		clearSelection();
		notifySubscribers();
	}
	public boolean isUndoStackEmpty()
	{
		return undoStack.isEmpty();
	}
	public boolean isRedoStackEmpty()
	{
		return redoStack.isEmpty();
	}
	@Override
	public void unexecuteAdd(AddCommand command) 
	{
		removeAlgorithmElements(command.getElementModel());
		if(!selectedElements.isEmpty())
			if(command.getElementModel() == selectedElements.get(0))
				clearSelection();
		notifySubscribers();
	}

	@Override
	public void unexecuteMove(MoveCommand command)
	{
		movingElement = command.getElementModel();
		movingElement.setPosition(command.getOldPosition());
		resetMovingElement();
		notifySubscribers();
	}

	public AlgorithmElement getSelectedElement()
	{
		return selectedElement.getAlgorithmElement();
	}

	public void setSelectedElement(AlgorithmElement selectedElement) 
	{
		clearSelection();
		this.selectedElement.setAlgorithmElement(selectedElement);
		modelMediator.setSelection();
		notifySubscribers();
	}
	
	public void clearSelection()
	{
		this.selectedElement.setAlgorithmElement(null);
		selectedElements.clear();
		modelMediator.clearSelection();
		notifySubscribers();
	}
	
	public Boolean elementIsSelected()
	{
		if ( selectedElement.getAlgorithmElement() != null )
			return true;
		return false;
	}
	
	public final AlgorithmElement getMovingElement() {
		return movingElement;
	}

	public final void setMovingElement(AlgorithmElement movingElement) {
		this.movingElement = movingElement;
	}
	
	public void finishMovement()
	{
		resetMovingElement();
	}
	
	public void resetMovingElement()
	{
		movingElement = null;
	}

	public void drawSelection(Graphics2D g2d)
	{
		selectedElement.draw(g2d);
	}

	@Override
	public void executeDelete(DeleteCommand command) 
	{
		if(command.getDeletedElements() == null)
			command.setDeletedElements(getSelectedAlgorithmElements());
		for(AlgorithmElement element : command.getDeletedElements())
			algorithmElements.remove(element);
		clearSelection();
		undoStack.push(command);
		notifySubscribers();
	}

	@Override
	public void unexecuteDelete(DeleteCommand command) {
		for(AlgorithmElement element : command.getDeletedElements())
			addAlgorithmElements(element);
		notifySubscribers();
	}

	@Override
	public void unexecuteSelecet() {
		clearSelection();
	}
	
	public Boolean movePossible(AlgorithmElement movingElement)
	{
		Boolean intersects = false;

		for (AlgorithmElement element : algorithmElements)
		{
			if(element.getID() != movingElement.getID())
				intersects = intersects || element.intersects(movingElement);
		}
				
		return !intersects;
	}

	@Override
	public void executeAddLine(AddLineCommand command)
	{
		undoStack.push(command);
		setNewAlgorithmElement(command.getConnection());
		addNewConnection();
	}

	@Override
	public void unexecuteAddLine(AddLineCommand command) 
	{
		removeAlgorithmElements(command.getConnection());
		if(command.getConnection() == selectedElement.getAlgorithmElement())
			clearSelection();
		notifySubscribers();
	}

	public void setNewAlgorithmElementPosition(Point p)
	{
		if(newAlgorithmElement != null)
		{
			newAlgorithmElement.setPosition(p);
			notifySubscribers();
		}
	}
	
	public void setMovingElementPosition(Point p)
	{
		if(movingElement != null)
		{
			AlgorithmElement movingElementCopy = null;
			if(movingElement instanceof GroupedElement)
			{
				movingElementCopy = (GroupedElement) movingElement.copy();
			}
			else 
			{
				movingElementCopy = movingElement.copyWithoutLocation();
			}
			movingElementCopy.setPosition(p);
			if(movePossible(movingElementCopy))
			{
				movingElement.setPosition(p);
				updateWorkspaceSize();
			}
			notifySubscribers();
		}
	}

	public AlgorithmElement getElementAt(Point p)
	{
		for(AlgorithmElement element : algorithmElements)
		{
			if( element.contains(p) )
				return element;
		}
		
		return null;
	}
	
	public void addExecutedCommand(Command command)
	{
		undoStack.push(command);
	}
	
	public void addUnexecutedCommand(Command command)
	{
		redoStack.push(command);
	}

	public final Dimension getWorkspaceSize() {
		return workspaceSize;
	}

	public final void setWorkspaceSize(Dimension workspaceSize) {
		this.workspaceSize = workspaceSize;
	}

	private Boolean topContainsElement()
	{
		Boolean contains = false;
		Rectangle topRect = new Rectangle(0, 0, (int)workspaceSize.getWidth(), 50);
		
		for(AlgorithmElement element : algorithmElements)
		{
			if(topRect.intersects(element.getBounds()))
			{
				contains = true;
				break;
			}
		}
		
		return contains;
	}
	
	private Boolean bottomContainsElement()
	{
		Boolean contains = false;
		Rectangle bottomRect = new Rectangle(0, (int)workspaceSize.getHeight() - 50, (int)workspaceSize.getWidth(), 50);
		
		for(AlgorithmElement element : algorithmElements)
		{
			if(bottomRect.intersects(element.getBounds()))
			{
				contains = true;
				break;
			}
		}
		
		return contains;
	}
	
	private Boolean leftContainsElement()
	{
		Boolean contains = false;
		Rectangle leftRect = new Rectangle(0, 0, 50, (int)workspaceSize.getHeight());
		
		for(AlgorithmElement element : algorithmElements)
		{
			if(leftRect.intersects(element.getBounds()))
			{
				contains = true;
				break;
			}
		}
		
		return contains;
	}
	
	private Boolean rightContainsElement()
	{
		Boolean contains = false;
		Rectangle rightRect = new Rectangle((int)workspaceSize.getWidth() - 50, 0, 50, (int)workspaceSize.getHeight());
		
		for(AlgorithmElement element : algorithmElements)
		{
			if(rightRect.intersects(element.getBounds()))
			{
				contains = true;
				break;
			}
		}
		
		return contains;
	}
	
	public void updateWorkspaceSize()
	{	
		if(movingElement == null)
		{
			if(topContainsElement())
			{
				workspaceSize.setSize(workspaceSize.getWidth(), workspaceSize.getHeight() + 200);
				for(AlgorithmElement element: algorithmElements)
				{
					element.setPosition(new Point((int)element.getPosition().getX(), (int)element.getPosition().getY() + 200));
				}
			}
			if (bottomContainsElement()) 
			{
				workspaceSize.setSize(workspaceSize.getWidth(), workspaceSize.getHeight() + 200);
			}
			if (leftContainsElement())
			{
				workspaceSize.setSize(workspaceSize.getWidth() + 200, workspaceSize.getHeight());
				for(AlgorithmElement element: algorithmElements)
				{
					element.setPosition(new Point((int)element.getPosition().getX() + 200, (int)element.getPosition().getY()));
				}
			}
			if (rightContainsElement())
			{
				workspaceSize.setSize(workspaceSize.getWidth() + 200, workspaceSize.getHeight());
			}
			notifySubscribers();
		}
	}

	@Override
	public void executeAddProject() {
		// TODO Auto-generated method stub
		
	}

	public final double getZoomScale() {
		return zoomScale;
	}
	
	public final void increaseZoom()
	{
		if(zoomScale < 1)
			zoomScale *= 2;
		else if(zoomScale < 3)
			zoomScale += 0.5f;
		
	}
	
	public final void decreaseZoom()
	{
		if(zoomScale > 1)
			zoomScale -= 0.5f;
		else if(zoomScale > 0.25f)
			zoomScale /= 2;
	}

	@Override
	public void executeZoomIn() 
	{
		increaseZoom();
		notifySubscribers();
	}

	@Override
	public void executeZoomOut() 
	{
		decreaseZoom();
		notifySubscribers();
	}

	@Override
	public void executeResetZoom()
	{
		zoomScale = 1;
		notifySubscribers();
	}

	@Override
	public void executeAddNewAlgorithm() {
		// TODO Auto-generated method stub
		
	}

	public final Boolean getIsOpen() {
		return isOpen;
	}

	public final void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Dimension getScaledSize()
	{
		return new Dimension((int)(workspaceSize.getWidth() * zoomScale), (int)(workspaceSize.getHeight() * zoomScale));
	}

	public final ModelMediator getModelMediator() {
		return modelMediator;
	}

	public final void setModelMediator(ModelMediator modelMediator) {
		this.modelMediator = modelMediator;
	}

	@Override
	public void unexecuteCut(CutCommand command) {
		for(AlgorithmElement element : command.getCutElement())
		{
			this.newAlgorithmElement = element;
			addPendingElement();
		}
		notifySubscribers();
	}
	
	public void executeGroup(GroupCommand command)
	{
		GroupedElement group = new GroupedElement();
		if(getSelectedAlgorithmElements().size() > 1)
		{
			for(AlgorithmElement element : getSelectedAlgorithmElements())
			{
				group.addAlgorithmElement(element);
				removeAlgorithmElements(element);
			}
			newAlgorithmElement = group;
			addPendingElement();
		}
		else if(getSelectedAlgorithmElements().size() == 1)
		{
			group = (GroupedElement) getSelectedAlgorithmElements().get(0);
			removeAlgorithmElements(group);
			for(AlgorithmElement element : group.getAlgorithmElement())
			{
				newAlgorithmElement = element;
				addPendingElement();
			}
		}
		clearSelection();
	}

	@Override
	public void unexecuteGroup(GroupCommand command) {
		// TODO Auto-generated method stub
		
	}

	public final Rectangle getSelectionArea() {
		return selectionArea;
	}

	public final void setSelectionArea(Rectangle selectionArea) {
		this.selectionArea = selectionArea;
		notifySubscribers();
	}
	
	public final void resetSelectionArea()
	{
		selectionArea = new Rectangle();
	}
	
	public java.util.List<AlgorithmElement> getGroupSelection()
	{
		java.util.List<AlgorithmElement> selectedElements = new Vector<AlgorithmElement>();

		for(AlgorithmElement element : algorithmElements)
		{
			if(selectionArea.contains(element.getBounds()))
			{
				selectedElements.add(element);
			}
		}
		
		return selectedElements;
	}
	
	public void drawSelectionArea(Graphics2D g2d)
	{
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLUE);
		g2d.draw(selectionArea);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
		g2d.fill(selectionArea);
	}

	public final java.util.List<SelectDecorator> getSelectedElements() {
		return selectedElements;
	}
	
	public final void setSelectedElements(java.util.List<AlgorithmElement> selectedElements) {
		if(algorithmElements == null)
			return;
		this.selectedElements.clear();
		for(AlgorithmElement element : selectedElements)
		{
			addSelectedElements(element);
		}
		modelMediator.setSelection();
		notifySubscribers();
	}
	
	public final java.util.List<AlgorithmElement> getSelectedAlgorithmElements()
	{
		java.util.List<AlgorithmElement> elements = new Vector<AlgorithmElement>();
		
		for(SelectDecorator sd : selectedElements)
		{
			elements.add(sd.getAlgorithmElement());
		}
		
		return elements;
	}
	public void createElementFromJSON(AlgorithmElement element)
	{
		newAlgorithmElement = element;
		addPendingElement();
		notifySubscribers();
	}

	public final java.util.Stack<Command> getUndoStack() {
		return undoStack;
	}
	
	public void selectAll()
	{
		setSelectedElements(algorithmElements);
	}
}