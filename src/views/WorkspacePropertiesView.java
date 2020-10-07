package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import actionListeners.ModelPropertiesButtonListener;
import actionListeners.ModelPropertiesListener;
import models.WorkspaceModel;

public class WorkspacePropertiesView extends JDialog implements Subscriber
{
	private static final long serialVersionUID = 1L;
	
	private JPanel panelNorth=null;
	private JPanel panelCenter=null;
	private JPanel panelSouth=null;
	private WorkspaceView panelWorkspace=null;
	private JPanel panelProperties=null;
	private JLabel labelaGridlines=null;
	private JLabel labelaSpacingGridlines=null;
	private JLabel labelaBackgroundColor=null;
	private JCheckBox showGridlines=null;
	private JTextField textGridlinesSpacing=null;
	private JButton buttonBackColor=null;
	private JButton buttonReset=null;
	private JButton buttonApply=null;
 
	private WorkspaceModel previewModel = null;
	
	public WorkspacePropertiesView(WorkspaceModel selectedModel) 
	{
		super();
		
		previewModel = WorkspaceModel.getPreviewModel();
		
		previewModel.setBackgroundColor(selectedModel.getBackgroundColor());
		previewModel.setGridSize(selectedModel.getGridSize());
		previewModel.setShowGrid(selectedModel.getShowGrid());
		
		previewModel.addSubscribers(this);
		
		panelNorth=new JPanel();
		panelNorth.setPreferredSize(new Dimension(400,120));
		
		panelCenter=new JPanel();
		
		panelSouth=new JPanel();
		panelSouth.setPreferredSize(new Dimension(400,50));
		
		panelWorkspace=new WorkspaceView(previewModel);
		previewModel.addSubscribers(panelWorkspace);
		
		panelWorkspace.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		panelNorth.add(panelWorkspace);
		
		panelProperties=new JPanel();
		panelProperties.setLayout(new GridLayout(3,3));
		panelProperties.setPreferredSize(new Dimension(300, 80));
		labelaGridlines=new JLabel("Gridlines: ");
		showGridlines=new JCheckBox("Show Gridlines");
		showGridlines.setSelected(selectedModel.getShowGrid());
		labelaSpacingGridlines=new JLabel("Gridlines Spacing: ");
		textGridlinesSpacing=new JTextField(Integer.toString(selectedModel.getGridSize()));
		labelaBackgroundColor=new JLabel("Background Color");
		textGridlinesSpacing.setEnabled(selectedModel.getShowGrid());
		
		buttonBackColor=new JButton();
		buttonBackColor.setBackground(selectedModel.getBackgroundColor());
		buttonBackColor.setActionCommand("Color");
		
		panelProperties.add(labelaGridlines);
		panelProperties.add(showGridlines);
		panelProperties.add(labelaSpacingGridlines);
		panelProperties.add(textGridlinesSpacing);
		panelProperties.add(labelaBackgroundColor);
		panelProperties.add(buttonBackColor);
		
		panelCenter.add(panelProperties);
		
		buttonApply=new JButton("Apply");
		buttonApply.setActionCommand("Apply");
		
		buttonReset=new JButton("Reset");
		buttonReset.setActionCommand("Reset");
		
		panelSouth.add(buttonReset);
		panelSouth.add(buttonApply);
		
		setSize(new Dimension(420,300));		
		setTitle("Algorithm Options");
		setLayout(new BorderLayout());
		add(panelSouth,BorderLayout.SOUTH);
		add(panelNorth,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
	}

	public final WorkspaceView getPanelWorkspace() {
		return panelWorkspace;
	}

	public final void setPanelWorkspace(WorkspaceView panelWorkspace) {
		this.panelWorkspace = panelWorkspace;
	}

	public final WorkspaceModel getPreviewModel() {
		return previewModel;
	}

	public final void setPreviewModel(WorkspaceModel previewModel) {
		this.previewModel = previewModel;
	}
	
	public void resetProperties(WorkspaceModel oldModel)
	{
		previewModel.setShowGrid(oldModel.getShowGrid());
		previewModel.setGridSize(oldModel.getGridSize());
		previewModel.setBackgroundColor(oldModel.getBackgroundColor());
	}
	
	public void registeModelPropertiesListener(ModelPropertiesListener listener)
	{
		showGridlines.addActionListener(listener);
		textGridlinesSpacing.addActionListener(listener);
		buttonBackColor.addActionListener(listener);
	}

	public final JCheckBox getShowGridlines() {
		return showGridlines;
	}

	public final JTextField getTextGridlinesSpacing() {
		return textGridlinesSpacing;
	}

	public final JButton getButtonBackColor() {
		return buttonBackColor;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		showGridlines.setSelected(previewModel.getShowGrid());

		textGridlinesSpacing.setText(Integer.toString(previewModel.getGridSize()));
		textGridlinesSpacing.setEnabled(previewModel.getShowGrid());
		buttonBackColor.setBackground(previewModel.getBackgroundColor());
		revalidate();		
		repaint();
	}
	
	public void registerButtonListener(ModelPropertiesButtonListener listener)
	{
		buttonApply.addActionListener(listener);
		buttonReset.addActionListener(listener);
	}
}

