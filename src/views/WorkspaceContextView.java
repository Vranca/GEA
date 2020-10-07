package views;


import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import actionListeners.AddElementButtonListener;
import actionListeners.OptionsClickActionListener;
import actionListeners.SelectActionListener;
import actionListeners.ToolbarCommandsListener;
import actionListeners.ToolboxStateChangeListener;
import actionListeners.ToolboxWorkspacePropertiesListener;
import utility.Localization;

public class WorkspaceContextView extends JPopupMenu
{
	private static final long serialVersionUID = 1L;
	private JMenu menuNew = null ;
	private JMenuItem menuItemNewTerminal = null ;
	private JMenuItem menuItemNewProcess = null ;
	private JMenuItem menuItemNewAnnotation = null ;
	private JMenuItem menuItemNewConnection = null ;
	private JMenuItem menuItemNewDecision = null ;
	private JMenuItem menuItemNewOffPageConnector = null ;
	private JMenuItem menuItemNewOnPageConnector = null ;
	private JMenuItem menuItemNewPredefinedProcess = null ;
	private JMenuItem menuItemNewInputOutput = null ;
	private JMenu menuEdit = null ;
	private JMenuItem menuItemEditPaste = null ;
	private JMenuItem menuItemEditCopy = null ;
	private JMenuItem menuItemEditUndo = null ;
	private JMenuItem menuItemEditRedo = null ;
	private JMenuItem menuGridlines = null ;
	private JMenuItem menuProperties = null ;
	private JMenuItem menuItemEditSelectAll = null;
	
	public WorkspaceContextView ()
	{
		super();
		setPreferredSize(new Dimension(200,100));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		menuNew = new JMenu(Localization.getLocalString("workspacecontextview.new"));
		menuItemNewTerminal = new JMenuItem(Localization.getLocalString("workspacecontextview.terminal"));
		menuItemNewTerminal.setActionCommand("Terminal");
		menuItemNewProcess = new JMenuItem(Localization.getLocalString("workspacecontextview.process"));
		menuItemNewProcess.setActionCommand("Process");
		menuItemNewAnnotation = new JMenuItem(Localization.getLocalString("workspacecontextview.annotation"));
		menuItemNewAnnotation.setActionCommand("Annotation");
		menuItemNewConnection = new JMenuItem(Localization.getLocalString("workspacecontextview.connection"));
		menuItemNewConnection.setActionCommand("Connection");
		menuItemNewDecision = new JMenuItem(Localization.getLocalString("workspacecontextview.decision"));
		menuItemNewDecision.setActionCommand("Decision");
		menuItemNewOnPageConnector = new JMenuItem(Localization.getLocalString("workspacecontextview.onpagecon"));
		menuItemNewOnPageConnector.setActionCommand("OnPageConnector");
		menuItemNewOffPageConnector = new JMenuItem(Localization.getLocalString("workspacecontextview.offpagecon"));
		menuItemNewOffPageConnector.setActionCommand("OffPageConnector");
		menuItemNewPredefinedProcess = new JMenuItem(Localization.getLocalString("workspacecontextview.predefinedprocess"));
		menuItemNewPredefinedProcess.setActionCommand("PredefinedProcess");
		menuItemNewInputOutput = new JMenuItem(Localization.getLocalString("workspacecontextview.inputoutput"));
		menuItemNewInputOutput.setActionCommand("InputOutput");
		
		menuNew.setVisible(true);

		
		menuNew.add(menuItemNewTerminal);
		menuNew.add(menuItemNewProcess);
		menuNew.add(menuItemNewAnnotation);
		menuNew.add(menuItemNewConnection);
		menuNew.add(menuItemNewDecision);
		menuNew.add(menuItemNewOnPageConnector);
		menuNew.add(menuItemNewOffPageConnector);
		menuNew.add(menuItemNewPredefinedProcess);
		menuNew.add(menuItemNewInputOutput);
		
		menuEdit = new JMenu(Localization.getInstance().getResources().getString("menuedit"));
		menuItemEditPaste = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.paste"));
		menuItemEditCopy = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.copy"));
		menuItemEditUndo = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.undo"));
		menuItemEditRedo = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.redo"));
		menuItemEditSelectAll = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.selectall"));
		
		
		menuEdit.setVisible(true);
		
		menuEdit.add(menuItemEditPaste);
		menuEdit.add(menuItemEditCopy);
		menuEdit.add(menuItemEditSelectAll);
		menuEdit.addSeparator();
		menuEdit.add(menuItemEditUndo);
		menuEdit.add(menuItemEditRedo);
		
		menuGridlines = new JMenuItem(Localization.getInstance().getResources().getString("workspacecontextview.gridlines"));
		menuGridlines.setVisible(true);
		
		menuProperties = new JMenuItem(Localization.getInstance().getResources().getString("workspacecontextview.properties"));
		menuProperties.setVisible(true);
		
		add(menuNew);
		addSeparator();
		add(menuEdit);
		add(menuGridlines);
		add(menuProperties);
		
	}
	public void registerAddCommandListeners(AddElementButtonListener listener)
	{
		menuItemNewTerminal.addActionListener(listener);
		menuItemNewProcess.addActionListener(listener);
		menuItemNewAnnotation.addActionListener(listener);
		menuItemNewDecision.addActionListener(listener);
		menuItemNewOnPageConnector.addActionListener(listener);
		menuItemNewOffPageConnector.addActionListener(listener);
		menuItemNewPredefinedProcess.addActionListener(listener);
		menuItemNewInputOutput.addActionListener(listener);
		
		menuItemSetActionCommands();
	} 
	
	public void registerConnectionListener(ToolboxStateChangeListener listener)
	{
		menuItemNewConnection.addActionListener(listener);
		menuItemNewConnection.setActionCommand("Connector");
	}
	
	private void menuItemSetActionCommands()
	 {
		   
		   menuItemEditRedo.setActionCommand("Redo");
		   menuItemEditUndo.setActionCommand("Undo");
		   menuItemEditCopy.setActionCommand("Copy");
		   menuItemEditPaste.setActionCommand("Paste");
		   menuGridlines.setActionCommand("Gridlines");
		   menuProperties.setActionCommand("Algorithm Options");
		  
		  
	 }
	  public void registerToolbarCommandsListener(ToolbarCommandsListener listener)
	   {
		   menuItemEditRedo.addActionListener(listener);
		   menuItemEditUndo.addActionListener(listener);
		   menuItemEditCopy.addActionListener(listener);
		   menuItemEditPaste.addActionListener(listener);
	   }
	  public void registerWorkspaceProperties(ToolboxWorkspacePropertiesListener listener)
	  {
		  menuGridlines.addActionListener(listener);
	  }
	  public void registerOptionsClickActionListener(OptionsClickActionListener listener)
	  {
		  menuProperties.addActionListener(listener);
	  }
	  public void registerSelectActionListener(SelectActionListener listener)
	  {
		  menuItemEditSelectAll.addActionListener(listener);
	  }
}
