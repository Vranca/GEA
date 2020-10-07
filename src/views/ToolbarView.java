/***********************************************************************
 * Module:  ToolbarView.java
 * Author:  User
 * Purpose: Defines the Class ToolbarView
 ***********************************************************************/

package views;

import models.ToolbarModel;
import utility.Clipboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import actionListeners.NewProjectActionListener;
import actionListeners.OpenProjectActionListener;
import actionListeners.ToolbarCommandsListener;

public class ToolbarView extends JToolBar implements Subscriber 
{
	private static final long serialVersionUID = 1L;
	private ToolbarModel model = null;
	
	JButton btnNewProject = null;
	JButton btnNewDocument=null;
	JButton btnOpen=null;
	JButton btnSave=null;
	JButton btnSaveAll =null;
	JButton btnCopy=null;
	JButton btnCut=null;
	JButton btnPaste=null;
	JButton btnDelete=null;
	JButton btnZoomIn=null;
	JButton btnZoomOut=null;
	JButton btnZoom=null;
	JButton btnUndo =null;
	JButton btnRedo=null;
   
   /** @param model */
   public ToolbarView(ToolbarModel model)
   {   
	   this.model = model;
	   setPreferredSize(new Dimension(0,30));
	   setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	   setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));	
	   
	   btnNewDocument = new JButton();
	   btnNewDocument.setToolTipText(model.getLocalString("toolbar.newdocument"));
	   btnNewDocument.setIcon(new ImageIcon("icons/blue-document--plus.png"));
	   btnNewDocument.setBorder(new EmptyBorder(2,2,2,2));
	   btnNewDocument.setOpaque(false);

	   add(Box.createHorizontalStrut(2));
	   add(btnNewDocument);
	   add(Box.createHorizontalStrut(7));
		  
	   btnNewProject = new JButton();
	   btnNewProject.setToolTipText(model.getLocalString("toolbar.newproject"));
	   btnNewProject.setIcon(new ImageIcon("icons/application_add.png"));
	   btnNewProject.setActionCommand("NewProject");
	   btnNewProject.setBorder(new EmptyBorder(2,2,2,2));
	   btnNewProject.setOpaque(false);
	   add(btnNewProject);
	   
	   add(Box.createHorizontalStrut(7));
	   btnOpen= new JButton();
	   btnOpen.setToolTipText(model.getLocalString("toolbar.openproject"));
	   btnOpen.setIcon(new ImageIcon("icons/folder-open.png"));
	   btnOpen.setBorder(new EmptyBorder(2,2,2,2));
	   btnOpen.setOpaque(false);
	   add(btnOpen);
	   add(Box.createHorizontalStrut(7));
	   
	   btnSave= new JButton();
	   btnSave.setToolTipText(model.getLocalString("toolbar.save"));
	   btnSave.setIcon(new ImageIcon("icons/disk.png"));
	   btnSave.setBorder(new EmptyBorder(2,2,2,2));
	   btnSave.setOpaque(false);
	   btnSave.setActionCommand("Save");
	   add(btnSave);
	   add(Box.createHorizontalStrut(7));
	   
	   btnSaveAll = new JButton();
	   btnSaveAll.setToolTipText(model.getLocalString("toolbar.saveall"));
	   btnSaveAll.setIcon(new ImageIcon("icons/disks.png"));
	   btnSaveAll.setBorder(new EmptyBorder(2,2,2,2));
	   btnSaveAll.setOpaque(false);
	   add(btnSaveAll);
	   add(Box.createHorizontalStrut(7));
	   addSeparator();
	   
	   btnCopy = new JButton();
	   btnCopy.setToolTipText(model.getLocalString("toolbar.copy"));
	   btnCopy.setIcon(new ImageIcon("icons/document-copy.png"));
	   btnCopy.setBorder(new EmptyBorder(2,2,2,2));
	   btnCopy.setOpaque(false);
	   btnCopy.setActionCommand("Copy");
	   add(btnCopy);
	   add(Box.createHorizontalStrut(7));
	   
	   btnCut= new JButton();
	   btnCut.setToolTipText(model.getLocalString("toolbar.cut"));
	   btnCut.setIcon(new ImageIcon("icons/scissors.png"));
	   btnCut.setBorder(new EmptyBorder(2,2,2,2));
	   btnCut.setOpaque(false);
	   btnCut.setActionCommand("Cut");
	   add(btnCut);
	   add(Box.createHorizontalStrut(7));
	   
	   btnPaste = new JButton();
	   btnPaste.setToolTipText(model.getLocalString("toolbar.paste"));
	   btnPaste.setIcon(new ImageIcon("icons/clipboard-paste.png"));
	   btnPaste.setBorder(new EmptyBorder(2,2,2,2));
	   btnPaste.setOpaque(false);
	   btnPaste.setActionCommand("Paste");
	   add(btnPaste);  
	   add(Box.createHorizontalStrut(7));
	   
	   btnDelete = new JButton();
	   btnDelete.setToolTipText(model.getLocalString("toolbar.delete"));
	   btnDelete.setIcon(new ImageIcon("icons/cross.png"));
	   btnDelete.setBorder(new EmptyBorder(2,2,2,2));
	   btnDelete.setOpaque(false);
	   btnDelete.setActionCommand("Delete");
	   add(btnDelete);
	   add(Box.createHorizontalStrut(7));
	   addSeparator();
	   
	   btnZoomIn = new JButton();
	   btnZoomIn.setToolTipText(model.getLocalString("toolbar.zoomin"));
	   btnZoomIn.setIcon(new ImageIcon("icons/magnifier-zoom-in.png"));
	   btnZoomIn.setBorder(new EmptyBorder(2,2,2,2));
	   btnZoomIn.setOpaque(false);
	   add(btnZoomIn);
	   add(Box.createHorizontalStrut(7));
	   
	   btnZoomOut = new JButton();
	   btnZoomOut.setToolTipText(model.getLocalString("toolbar.zoomout"));
	   btnZoomOut.setIcon(new ImageIcon("icons/magnifier-zoom-out.png"));
	   btnZoomOut.setBorder(new EmptyBorder(2,2,2,2));
	   btnZoomOut.setOpaque(false);
	   add(btnZoomOut);
	   add(Box.createHorizontalStrut(7));
	   
	   btnZoom = new JButton();
	   btnZoom.setToolTipText(model.getLocalString("toolbar.zoom"));
	   btnZoom.setIcon(new ImageIcon("icons/magnifier.png"));
	   btnZoom.setBorder(new EmptyBorder(2,2,2,2));
	   btnZoom.setOpaque(false);
	   add(btnZoom);
	   add(Box.createHorizontalStrut(7));
	   
	   addSeparator();
	   
	   btnUndo = new JButton();
	   btnUndo.setToolTipText(model.getLocalString("toolbar.undo"));
	   btnUndo.setIcon(new ImageIcon("icons/arrow-circle-225-left.png"));
	   btnUndo.setBorder(new EmptyBorder(2,2,2,2));
	   btnUndo.setOpaque(false);
	   btnUndo.setActionCommand("Undo");
	   add(btnUndo);
	   add(Box.createHorizontalStrut(2));
	   
	   btnRedo = new JButton();
	   btnRedo.setToolTipText(model.getLocalString("toolbar.redo"));
	   btnRedo.setIcon(new ImageIcon("icons/arrow-circle.png"));
	   btnRedo.setBorder(new EmptyBorder(2,2,2,2));
	   btnRedo.setOpaque(false);
	   btnRedo.setActionCommand("Redo");
	   add(btnRedo);
	   add(Box.createHorizontalStrut(2));
	   
	   btnSetActionCommands();
	   
	   this.model.getState().enableButtons(this);
	   setFloatable(false);
   }
   
   public void update() {
	   model.getState().enableButtons(this);
	  if(model.getToolboxModel() == null)
	  {
		  btnUndo.setEnabled(false);
	  	  btnRedo.setEnabled(false);
	  }
	  else if(model.getToolboxModel().getSelectedModel() != null)
	  {
	 	 btnUndo.setEnabled(!model.getToolboxModel().getSelectedModel().isUndoStackEmpty());
	 	 btnRedo.setEnabled(!model.getToolboxModel().getSelectedModel().isRedoStackEmpty());  
	  }
	  if(Clipboard.getClipboard().isEmpty())
		  btnPaste.setEnabled(false);
	  else
		  btnPaste.setEnabled(true);
   }
   
   @Override
   protected void paintComponent(Graphics g)
   {
	    // Create the 2D copy
	    Graphics2D g2 = (Graphics2D)g.create();

	    // Apply vertical gradient
	    g2.setPaint(new GradientPaint(0, 0, model.getTheme().getControl(), 0, getHeight(), model.getTheme().getControlShadow()));
	    g2.fillRect(0, 0, getWidth(), getHeight());

	    // Dipose of copy
	    g2.dispose();
   }
   
   public void enableNewDocument(Boolean enabled)
   {
	   btnNewDocument.setEnabled(enabled);
   }
   
   public void enableNewProject(Boolean enabled)
   {
	   btnNewProject.setEnabled(enabled);
   }
  
   public void enableOpen(Boolean enabled)
   {
	   btnOpen.setEnabled(enabled);
   }
  
   public void enableSave(Boolean enabled)
   {
	   btnSave.setEnabled(enabled);
   }
   public void enableSaveAll(Boolean enabled)
   {
	   btnSaveAll.setEnabled(enabled);
   }
   public void enableDelete(Boolean enabled)
   {
	   btnDelete.setEnabled(enabled);
   }
   public void enableCut(Boolean enabled)
   {
	   btnCut.setEnabled(enabled);
   }
   public void enableCopy(Boolean enabled)
   {
	   btnCopy.setEnabled(enabled);
   }
   public void enablePaste(Boolean enabled)
   {
	   btnPaste.setEnabled(enabled);
   }
   public void enableZoomIn(Boolean enabled)
   {
	   btnZoomIn.setEnabled(enabled);
   }
   public void enableZoomOut(Boolean enabled)
   {
	   btnZoomOut.setEnabled(enabled);
   }
   public void enableZoom(Boolean enabled)
   {
	   btnZoom.setEnabled(enabled);
   }
   public void enableUndo(Boolean enabled)
   {
	   btnUndo.setEnabled(enabled);
   }
   public void enableRedo(Boolean enabled)
   {
	   btnRedo.setEnabled(enabled);
   }
   
   private void btnSetActionCommands()
   {
	   btnDelete.setActionCommand("Delete");
	   btnSave.setActionCommand("Save");
	   btnRedo.setActionCommand("Redo");
	   btnUndo.setActionCommand("Undo");
	   btnCopy.setActionCommand("Copy");
	   btnPaste.setActionCommand("Paste");
	   btnCut.setActionCommand("Cut");
	   btnZoomIn.setActionCommand("ZoomIn");
	   btnZoomOut.setActionCommand("ZoomOut");
	   btnZoom.setActionCommand("ResetZoom");
	   btnNewDocument.setActionCommand("NewAlgorithm");
   }
   
   public void registerNewProjectListener(NewProjectActionListener listener)
   {
	   btnNewProject.addActionListener(listener);
   }
   public void registerOpenProjectListener(OpenProjectActionListener listener)
   {
	   btnOpen.addActionListener(listener);
   }
   
   public void registerToolbarCommandsListener(ToolbarCommandsListener listener)
   {
	   btnDelete.addActionListener(listener);
	   btnSave.addActionListener(listener);
	   btnRedo.addActionListener(listener);
	   btnUndo.addActionListener(listener);
	   btnCopy.addActionListener(listener);
	   btnPaste.addActionListener(listener);
	   btnCut.addActionListener(listener);
	   //btnNewProject.addActionListener(listener);
	   btnZoomIn.addActionListener(listener);
	   btnZoomOut.addActionListener(listener);
	   btnZoom.addActionListener(listener);
	   btnNewDocument.addActionListener(listener);
   }

public ToolbarModel getModel() {
	return model;
}
}