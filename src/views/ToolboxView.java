/***********************************************************************
 * Module:  ToolboxView.java
 * Author:  User
 * Purpose: Defines the Class ToolboxView
 ***********************************************************************/

package views;

import models.ToolboxModel;
import utility.Localization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

import actionListeners.AddElementButtonListener;
import actionListeners.StyleButtonActionListener;
import actionListeners.PreviewElementActionListener;
import actionListeners.ToolboxStateChangeListener;
import actionListeners.ToolboxWorkspacePropertiesListener;
import algorithmElements.Symbol;

public class ToolboxView extends JPanel implements Subscriber, DraggableContent 
{
   private static final long serialVersionUID = 1L;
	   
   private ToolboxModel model = null;
	   
   private JPanel titlePanel = null;
   private JLabel titleLabel = null;
   private WorkspaceTabbedView tabbedPane = null;
   private JButton terminalButton = null;
   private JButton annotationButton = null;
   private JButton processButton = null;
   private JButton decisionButton = null;  
   private JButton inputOutputButton = null;  
   private JButton predefinedProcessButton = null; 
   private JButton offPageConnector = null; 
   private JButton onPageConnector = null; 
   private JLabel textLabel = null;
   private JLabel fontSizeLabel = null;
   private JLabel backgroundColorLabel = null;
   private JLabel foreColorLabel = null;
   private JLabel borderThicknessLabel = null;
   private JLabel borderColorLabel = null;
   private JLabel elementWidthLabel = null;
   private JLabel elementHeightLabel = null;
   private JTextField textTextField = null;
   private JTextField fontSizeTextField = null;                    
   private JTextField borderThicknessTextField = null;             
   private JTextField elementWidthTextField = null;                
   private JTextField elementHeightTextField = null;               
   private JButton resetButton = null;                             
   private JButton applyButton = null;                             
   private JButton defaultStyleButton = null;                      
   private JButton borderColorButton = null;                       
   private JButton foreColorButton = null;                         
   private JButton backColorButton = null;                         
   private JLabel workspaceColorChooserLabel = null;               
   private JButton workspaceColorChooserButton = null;             
   private ElementPreview elementPanel = null;                     
   private JButton btnSelect = null;                               
   private JButton btnMove = null;                                 
   private JButton btnGroup = null;                                
   private JButton btnConnector = null;                            
   private JButton btnGridlines = null;                            
   private JButton btnResize = null;                               
   private JButton btnLabel = null;                                
   private JButton btnZoom = null;                                 
                                                                   
	
	public JTextField getTextTextField() {
		return textTextField;
	}
	
	public void setTextTextField(JTextField textTextField) {
		this.textTextField = textTextField;
	}
	
	public JTextField getFontSizeTextField() {
		return fontSizeTextField;
	}
	
	public void setFontSizeTextField(JTextField fontSizeTextField) {
		this.fontSizeTextField = fontSizeTextField;
	}
	
	public JTextField getBorderThicknessTextField() {
		return borderThicknessTextField;
	}
	
	public void setBorderThicknessTextField(JTextField borderThicknessTextField) {
		this.borderThicknessTextField = borderThicknessTextField;
	}
	
	public JTextField getElementWidthTextField() {
		return elementWidthTextField;
	}
	
	public void setElementWidthTextField(JTextField elementWidthTextField) {
		this.elementWidthTextField = elementWidthTextField;
	}
	
	public JTextField getElementHeightTextField() {
		return elementHeightTextField;
	}
	
	public void setElementHeightTextField(JTextField elementHeightTextField) {
		this.elementHeightTextField = elementHeightTextField;
	}
	
	public JButton getBorderColorButton() {
		return borderColorButton;
	}
	
	public void setBorderColorButton(JButton borderColorButton) {
		this.borderColorButton = borderColorButton;
	}
	
	public JButton getForeColorButton() {
		return foreColorButton;
	}
	
	public void setForeColorButton(JButton foreColorButton) {
		this.foreColorButton = foreColorButton;
	}
	
	public JButton getBackColorButton() {
		return backColorButton;
	}
	
	public void setBackColorButton(JButton backColorButton) {
		this.backColorButton = backColorButton;
	}

   public void update() 
   {   
	   if(model.getPreviewElement()!=null)
	   {
		   if(model.getPreviewElement() instanceof Symbol)
		   {
			   Symbol symbolPreview = (Symbol) model.getPreviewElement();
			   this.textTextField.setText(symbolPreview.getText());
			   this.fontSizeTextField.setText(String.valueOf(symbolPreview.getFontSize()));
			   this.borderThicknessTextField.setText(String.valueOf(symbolPreview.getBorderThickness()));
			   this.elementWidthTextField.setText(String.valueOf(symbolPreview.getWidth()));
			   this.elementHeightTextField.setText(String.valueOf(symbolPreview.getHeight()));
			   this.backColorButton.setBackground(symbolPreview.getBackgroundColor());
			   this.foreColorButton.setBackground(symbolPreview.getVisualStyle().getTextColor());
			   this.borderColorButton.setBackground(symbolPreview.getBorderColor());
			   
		   }
	   }
	   else
	   {
		   this.textTextField.setText("");
		   this.fontSizeTextField.setText("");
		   this.borderThicknessTextField.setText("");
		   this.elementWidthTextField.setText("");
		   this.elementHeightTextField.setText("");
		   this.backColorButton.setBackground(Color.white);
		   this.foreColorButton.setBackground(Color.white);
		   this.borderColorButton.setBackground(Color.white);
	   }
	   if(model.getSelectedModel()!=null)
		   workspaceColorChooserButton.setBackground(model.getSelectedModel().getBackgroundColor());
	   repaint();
	   updateLanguage();
   }
   
   /** @param model */
   public ToolboxView(ToolboxModel model) 
   {
	   this.model = model;
	   tabbedPane = new WorkspaceTabbedView();
	      
       setLayout(new BorderLayout());      
       setPreferredSize(new Dimension(250, 800));
       setMinimumSize(new Dimension(200, 800));
       setMaximumSize(new Dimension(250, 1000));

       setBorder(BorderFactory.createRaisedBevelBorder());
       setBackground(model.getTheme().getWindowBackground());
       
       titlePanel = new JPanel();
       titlePanel.setLayout(new BorderLayout());
       titlePanel.setSize(0,30);
       titlePanel.setBorder(BorderFactory.createRaisedBevelBorder());
       titlePanel.setBackground(model.getTheme().getWindowTitleBackground());
       
       titleLabel = new JLabel(model.getLocalString("toolbox"));
       titleLabel.setBorder(new EmptyBorder(0,0,0,50));
       titleLabel.setForeground(model.getTheme().getWindowTitleForeground());
       titlePanel.add(titleLabel, BorderLayout.WEST);

       
       addWorkspaceTab(tabbedPane);
       addElementTab(tabbedPane);
       add(titlePanel, BorderLayout.NORTH);
       add(tabbedPane,BorderLayout.CENTER);
       
       Localization.getInstance().addSubscribers(this);
   }

	public final ToolboxModel getModel() 
	{
		return model;
	}

	@Override
	public void addDragListener(DragListener dragListener)
	{
		   addMouseListener(dragListener);
		   addMouseMotionListener(dragListener);
		   
		   titlePanel.addMouseListener(dragListener);
		   titlePanel.addMouseMotionListener(dragListener);
		   
		   titleLabel.addMouseListener(dragListener);
		   titleLabel.addMouseMotionListener(dragListener);
		   
	}

	public void addWorkspaceTab(WorkspaceTabbedView tabbedPane)
	{
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.LINE_AXIS));
		centerPanel.setPreferredSize(new Dimension(0,180));
	//	centerPanel.setMaximumSize(new Dimension(0,180));
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		northPanel.setLayout(new GridLayout(2, 4,10,10));
		northPanel.setPreferredSize(new Dimension(0,100));
		

		
		JPanel southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
		southPanel.setLayout(new GridLayout(1, 2,2,2));
		southPanel.setPreferredSize(new Dimension(0,30));

		addScrollPane(centerPanel);
    	panel.add(centerPanel,BorderLayout.CENTER);
    	
    	addButtons(northPanel);
    	panel.add(northPanel,BorderLayout.NORTH);
    	
    	
    	addColorChooser(southPanel);
    	panel.add(southPanel,BorderLayout.SOUTH);
    	
		tabbedPane.addTab(model.getLocalString("toolbox.workspace"), panel);
	}
	
	public void addScrollPane(JPanel scrollPanePanel)
	{
		JPanel elementPanel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(elementPanel);
		scrollPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		scrollPane.setSize(scrollPanePanel.getWidth(),scrollPanePanel.getHeight());
	
		elementPanel.setLayout(new BoxLayout(elementPanel, BoxLayout.Y_AXIS));
		addElements(elementPanel);
		

		
		scrollPanePanel.add(Box.createHorizontalStrut(10));
		scrollPanePanel.add(scrollPane);
		scrollPanePanel.add(Box.createHorizontalStrut(10));
		
	
		
	}
	
	public void addButtons(JPanel buttonPanel)
	{
		btnSelect = new JButton();
		btnSelect.setBorder(BorderFactory.createEmptyBorder());
		btnSelect.setToolTipText("Select");
		btnSelect.setIcon(new ImageIcon("icons/cursor.png"));
		btnSelect.setActionCommand("Selection");
		
	
		buttonPanel.add(btnSelect);
		
		btnMove = new JButton();
		btnMove.setToolTipText("Move");
		btnMove.setBorder(BorderFactory.createEmptyBorder());
		btnMove.setIcon(new ImageIcon("icons/arrow-move.png"));
		btnMove.setActionCommand("Move");
		
		buttonPanel.add(btnMove);
		
		btnConnector = new JButton();
		btnConnector.setToolTipText("Connector");
		btnConnector.setBorder(BorderFactory.createEmptyBorder());
		btnConnector.setIcon(new ImageIcon("icons/connector.png"));
		btnConnector.setActionCommand("Connector");
		
		buttonPanel.add(btnConnector);
		
		btnGridlines = new JButton();
		btnGridlines.setToolTipText("Gridlines");
		btnGridlines.setBorder(BorderFactory.createEmptyBorder());
		btnGridlines.setIcon(new ImageIcon("icons/grid.png"));	
		btnGridlines.setActionCommand("Gridlines");
		buttonPanel.add(btnGridlines);
		
		btnResize = new JButton();
		btnResize.setToolTipText("Resize");
		btnResize.setBorder(BorderFactory.createEmptyBorder());
		btnResize.setIcon(new ImageIcon("icons/zone-resize.png"));
		

		buttonPanel.add(btnResize);
		
		btnGroup = new JButton();
		btnGroup.setToolTipText("Group");
		btnGroup.setBorder(BorderFactory.createEmptyBorder());
		btnGroup.setIcon(new ImageIcon("icons/group.png"));
		btnGroup.setActionCommand("Group");
		
		
		
		buttonPanel.add(btnGroup);
		
		btnLabel = new JButton();
		btnLabel.setToolTipText("Label");
		btnLabel.setBorder(BorderFactory.createEmptyBorder());
		btnLabel.setIcon(new ImageIcon("icons/layer-shape-text-icon.png"));
		btnLabel.setActionCommand("Label");
		buttonPanel.add(btnLabel);
		
		btnZoom = new JButton();
		btnZoom.setToolTipText("Zoom");
		btnZoom.setBorder(BorderFactory.createEmptyBorder());
		btnZoom.setIcon(new ImageIcon("icons/magnifier.png"));
		btnZoom.setActionCommand("Zoom");
		buttonPanel.add(btnZoom);		
	}
	
	public void addElements(JPanel elementsPanel)
	{
		JPanel terminalPanel = new JPanel(new BorderLayout());
		terminalButton = new JButton(new ImageIcon((new ImageIcon("resources/Terminal.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		terminalButton.setBorder(BorderFactory.createEmptyBorder());
		terminalButton.setActionCommand("Terminal");
		terminalPanel.add(terminalButton, BorderLayout.CENTER);
		
		
		elementsPanel.add(terminalPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel processPanel = new JPanel(new BorderLayout());
		processButton = new JButton(new ImageIcon((new ImageIcon("resources/Process.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		processButton.setBorder(BorderFactory.createEmptyBorder());
		processButton.setActionCommand("Process");
		processPanel.add(processButton, BorderLayout.CENTER);
		
		
		elementsPanel.add(processPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel annotationPanel = new JPanel(new BorderLayout());
		annotationButton = new JButton(new ImageIcon((new ImageIcon("resources/Annonation.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		annotationButton.setBorder(BorderFactory.createEmptyBorder());
		annotationButton.setActionCommand("Annotation");
		annotationPanel.add(annotationButton, BorderLayout.CENTER);
		
		elementsPanel.add(annotationPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel decisionPanel = new JPanel(new BorderLayout());
		decisionButton = new JButton(new ImageIcon((new ImageIcon("resources/Decision.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		decisionButton.setBorder(BorderFactory.createEmptyBorder());
		decisionButton.setActionCommand("Decision");
		decisionPanel.add(decisionButton, BorderLayout.CENTER);
		
		elementsPanel.add(decisionPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel inputOutputPanel = new JPanel(new BorderLayout());
		inputOutputButton = new JButton(new ImageIcon((new ImageIcon("resources/IO.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		inputOutputButton.setBorder(BorderFactory.createEmptyBorder());
		inputOutputButton.setActionCommand("InputOutput");
		inputOutputPanel.add(inputOutputButton, BorderLayout.CENTER);
		
		elementsPanel.add(inputOutputPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel predefinedProcessPanel = new JPanel(new BorderLayout());
		predefinedProcessButton = new JButton(new ImageIcon((new ImageIcon("resources/Predefined Process.png").getImage()).getScaledInstance( 120, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		predefinedProcessButton.setBorder(BorderFactory.createEmptyBorder());
		predefinedProcessButton.setActionCommand("PredefinedProcess");
		predefinedProcessPanel.add(predefinedProcessButton, BorderLayout.CENTER);
		
		elementsPanel.add(predefinedProcessPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel onPageConnectorPanel = new JPanel(new BorderLayout());
		onPageConnector = new JButton(new ImageIcon((new ImageIcon("resources/Conector.png").getImage()).getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		onPageConnector.setBorder(BorderFactory.createEmptyBorder());
		onPageConnector.setActionCommand("OnPageConnector");
		onPageConnectorPanel.add(onPageConnector, BorderLayout.CENTER);
		
		elementsPanel.add(onPageConnectorPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
		
		JPanel offPageConnectorPanel = new JPanel(new BorderLayout());
		offPageConnector = new JButton(new ImageIcon((new ImageIcon("resources/Off-Page connector.png").getImage()).getScaledInstance( 100, 60,  java.awt.Image.SCALE_SMOOTH ) ));
		offPageConnector.setBorder(BorderFactory.createEmptyBorder());
		offPageConnector.setActionCommand("OffPageConnector");
		offPageConnectorPanel.add(offPageConnector, BorderLayout.CENTER);
		
		elementsPanel.add(offPageConnectorPanel);
		elementsPanel.add(Box.createVerticalStrut(2));
	}

	public void addElementTab(JTabbedPane tabbedPane)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(0,300));
	//	centerPanel.setMaximumSize(new Dimension(0,180));
		
		
		JPanel northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		northPanel.setLayout(new BoxLayout(northPanel,BoxLayout.Y_AXIS));
		northPanel.setPreferredSize(new Dimension(0,150));
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(0,50));

		
		JLabel previewLabel = new JLabel(model.getLocalString("toolbox.preview"));
		
		
		northPanel.add(previewLabel);
		showSelectedElement(northPanel);
		
		
		
		addElementProperties(centerPanel);
		addDefaultStyleButton(centerPanel);
		addResetAndApplyButtons(southPanel);
		
    	panel.add(northPanel,BorderLayout.NORTH);
    	panel.add(centerPanel,BorderLayout.CENTER);
    	panel.add(southPanel,BorderLayout.SOUTH);
    
		tabbedPane.addTab(model.getLocalString("toolbox.element"), panel);
	}
	
	public void addDefaultStyleButton(JPanel panel)
	{
		JPanel defaultPanel = new JPanel();
		defaultPanel.setPreferredSize(new Dimension(0,50));
		
		defaultStyleButton = new JButton(model.getLocalString("toolbox.setdefaultsistyle"));
		defaultPanel.add(defaultStyleButton);

		panel.add(defaultPanel,BorderLayout.NORTH);
		
	}
	
	public void showSelectedElement(JPanel northPanel)
	{
		elementPanel = new ElementPreview(model);
		
		elementPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		elementPanel.setPreferredSize(new Dimension(180,100));
		
		northPanel.add(elementPanel);
	}
	
	public void addElementProperties(JPanel panel)
	{
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		centralPanel.setLayout(new GridLayout(8, 2,10,10));
		centralPanel.setPreferredSize(new Dimension(0,250));
		
		
		JScrollPane scrollPane = new JScrollPane(centralPanel);
		
		textLabel = new JLabel(model.getLocalString("toolbox.text"));
		textLabel.setToolTipText(textLabel.getText());
		centralPanel.add(textLabel);
		
		textTextField= new JTextField();
		
		centralPanel.add(textTextField);

		
		fontSizeLabel = new JLabel(model.getLocalString("toolbox.fontsize"));
		fontSizeLabel.setToolTipText(fontSizeLabel.getText());
		centralPanel.add(fontSizeLabel);
		
		fontSizeTextField= new JTextField();
		
		centralPanel.add(fontSizeTextField);
		
		backgroundColorLabel = new JLabel(model.getLocalString("toolbox.backcolor"));
		backgroundColorLabel.setToolTipText(backgroundColorLabel.getText());
		centralPanel.add(backgroundColorLabel);
		
		backColorButton = new JButton();
		backColorButton.addActionListener(new PreviewElementActionListener(this, this.getModel()));

		centralPanel.add(backColorButton);
		
		
		foreColorLabel = new JLabel(model.getLocalString("toolbox.forecolor"));
		foreColorLabel.setToolTipText(foreColorLabel.getText());
		centralPanel.add(foreColorLabel);
		
		
		foreColorButton = new JButton();
		foreColorButton.addActionListener(new PreviewElementActionListener(this, this.getModel()));
		
		
		centralPanel.add(foreColorButton);
	 
		
		
		borderThicknessLabel = new JLabel(model.getLocalString("toolbox.borderthickness"));
		borderThicknessLabel.setToolTipText(borderThicknessLabel.getText());

		centralPanel.add(borderThicknessLabel);
		
		borderThicknessTextField = new JTextField();
		
		centralPanel.add(borderThicknessTextField);
		
		borderColorLabel = new JLabel(model.getLocalString("toolbox.bordercolor"));
		borderColorLabel.setToolTipText(borderColorLabel.getText());
		centralPanel.add(borderColorLabel);
		
		borderColorButton = new JButton();
		borderColorButton.addActionListener(new PreviewElementActionListener(this, this.getModel()));
		
		
		centralPanel.add(borderColorButton);
		
		elementWidthLabel = new JLabel(model.getLocalString("toolbox.width"));
		elementWidthLabel.setToolTipText(elementWidthLabel.getText());
		centralPanel.add(elementWidthLabel);
		
		elementWidthTextField= new JTextField();
		
		centralPanel.add(elementWidthTextField);
		
		elementHeightLabel = new JLabel(model.getLocalString("toolbox.height"));
		elementHeightLabel.setToolTipText(elementHeightLabel.getText());
		centralPanel.add(elementHeightLabel);
		
		elementHeightTextField = new JTextField();
		
		centralPanel.add(elementHeightTextField);
		
		
		panel.add(scrollPane,BorderLayout.CENTER);
		
	}

	public void addResetAndApplyButtons(JPanel panel)
	{
		resetButton = new JButton(model.getLocalString("toolbox.reset"));
		panel.add(resetButton);
		
		applyButton = new JButton(model.getLocalString("toolbox.apply"));
		panel.add(applyButton);
	}
	
	public void registerAddCommandListeners(AddElementButtonListener listener)
	{
		terminalButton.addActionListener(listener);
		annotationButton.addActionListener(listener);
		processButton.addActionListener(listener);
		decisionButton.addActionListener(listener);
		inputOutputButton.addActionListener(listener);
		predefinedProcessButton.addActionListener(listener);
		onPageConnector.addActionListener(listener);
		offPageConnector.addActionListener(listener);
		btnLabel.addActionListener(listener);
	}

	public void registerStyleButtonListener(StyleButtonActionListener listener)
	{
		applyButton.setActionCommand("Apply");
		resetButton.setActionCommand("Reset");
		defaultStyleButton.setActionCommand("Default");
		
		applyButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		defaultStyleButton.addActionListener(listener);
	}
	public void registerPreviewElementListener(PreviewElementActionListener listener)
	{
		textTextField.addActionListener(listener);
		fontSizeTextField.addActionListener(listener);
		borderThicknessTextField.addActionListener(listener);
		elementWidthTextField.addActionListener(listener);
		elementHeightTextField.addActionListener(listener);
	}
	public void addColorChooser(JPanel panel)
	{
		workspaceColorChooserLabel = new JLabel(model.getLocalString("toolbox.selectcolor"));
		panel.add(workspaceColorChooserLabel);
		
		workspaceColorChooserButton = new JButton();
		workspaceColorChooserButton.setActionCommand("BackgroundColor");
		workspaceColorChooserButton.setPreferredSize(new Dimension(60,50));
		panel.add(workspaceColorChooserButton);
	}
	   public void registerToolboxStateChangeListener(ToolboxStateChangeListener listener)
	   {
		   btnSelect.addActionListener(listener);
		   btnConnector.addActionListener(listener);
		   btnMove.addActionListener(listener);
		   btnZoom.addActionListener(listener);
	   }
	
	public ElementPreview getElementPanel() {
		return elementPanel;
	}

	public final WorkspaceTabbedView getTabbedPane() {
		return tabbedPane;
	} 
	
	private void updateLanguage() {
		titleLabel.setText(model.getLocalString("toolbox"));
	}

	public void registerToolboxWorkspacePropertiesListener(ToolboxWorkspacePropertiesListener listener)
	{
		workspaceColorChooserButton.addActionListener(listener);
		btnGroup.addActionListener(listener);
		btnGridlines.addActionListener(listener);
	}
		
}