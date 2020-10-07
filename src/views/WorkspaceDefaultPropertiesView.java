package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import models.WorkspaceModel;


public class WorkspaceDefaultPropertiesView extends JPanel implements Subscriber
{
	 private static final long serialVersionUID = 1L;
	 JPanel panelNorth=null;
	 JPanel panelCenter=null;
	 JPanel panelSouth=null;
	 WorkspaceView panelWorkspace=null;
	 JPanel panelProperties=null;
	 JLabel labelaGridlines=null;
	 JLabel labelaSpacingGridlines=null;
	 JLabel labelaBackgroundColor=null;
	 JCheckBox showGridlines=null;
	 TextField textGridlinesSpacing=null;
	 JButton buttonBackColor=null;
	 JButton buttonReset=null;
	 JButton buttonApply=null;
	 Border titledBorder=null;
	 Border border = null;
	 Font font=null;
	 JLabel labelaWidthSize=null;
	 JLabel labelaHeightSize=null;
	 TextField textWidhtSize=null;
	 TextField textHeightSize=null;
	 JScrollPane scroolWorkspace=null;
	 Boolean showGrid=null;
	 WorkspaceModel model = null;
	

	public WorkspaceDefaultPropertiesView(WorkspaceModel previewWorkspaceModel, WorkspaceModel defaultWorkspaceModel)
	{
		panelNorth=new JPanel();
		
		panelCenter=new JPanel();
		
		panelSouth=new JPanel();
		
		model = previewWorkspaceModel;
		
		panelWorkspace=new WorkspaceView(model);
		
		panelNorth.setPreferredSize(new Dimension(350,150));
		
		panelWorkspace.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		scroolWorkspace=new JScrollPane(panelWorkspace);
		panelNorth.add(scroolWorkspace	);
		
		panelProperties=new JPanel();
		panelProperties.setLayout(new GridLayout(6,6));
		labelaGridlines=new JLabel("Gridlines: ");
		showGridlines=new JCheckBox("Show Gridlines");
		labelaSpacingGridlines=new JLabel("Gridlines Spacing: ");
		textGridlinesSpacing=new TextField();
		textGridlinesSpacing.setText(20+"");
		textGridlinesSpacing.setForeground(Color.BLACK);
		labelaBackgroundColor=new JLabel("Background Color");
		buttonBackColor=new JButton();
		showGridlines.setSelected(true);
		showGridlines.setSelected(defaultWorkspaceModel.getShowGrid());
		buttonBackColor.setBackground(defaultWorkspaceModel.getBackgroundColor());
		
		labelaHeightSize=new JLabel("Workspace Height:");
		labelaWidthSize=new JLabel("Workspace Width:");
		textHeightSize=new TextField();
		textHeightSize.setText(Integer.toString((int)defaultWorkspaceModel.getWorkspaceSize().getHeight()));
		textHeightSize.setForeground(Color.BLACK);
		textWidhtSize=new TextField();
		textWidhtSize.setText(Integer.toString((int)defaultWorkspaceModel.getWorkspaceSize().getWidth()));
		textWidhtSize.setForeground(Color.black);
		
		panelProperties.add(labelaGridlines);
		panelProperties.add(showGridlines);
		panelProperties.add(labelaSpacingGridlines);
		panelProperties.add(textGridlinesSpacing);
		panelProperties.add(labelaBackgroundColor);
		panelProperties.add(buttonBackColor);
		panelProperties.add(labelaHeightSize);
		panelProperties.add(textHeightSize);
		panelProperties.add(labelaWidthSize);
		panelProperties.add(textWidhtSize);
		
		panelCenter.add(panelProperties);
		
		buttonApply=new JButton("Apply");
		buttonReset=new JButton("Reset");
		panelSouth.add(buttonReset);
		panelSouth.add(buttonApply);
		setLayout(new BorderLayout());
		font = new Font("Arial", Font.ITALIC, 12);
		 titledBorder = BorderFactory.createTitledBorder(border, "Algorithm Options", TitledBorder.CENTER, TitledBorder.TOP, font, Color.BLACK);
		 setBorder(titledBorder);
		add(panelSouth,BorderLayout.SOUTH);
		add(panelNorth,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
	}
	


	public JCheckBox getShowGridlines() {
		return showGridlines;
	}

	public void setShowGridlines(JCheckBox showGridlines) {
		this.showGridlines = showGridlines;
	}

	public TextField getTextGridlinesSpacing() {
		return textGridlinesSpacing;
	}

	public void setTextGridlinesSpacing(TextField textGridlinesSpacing) {
		this.textGridlinesSpacing = textGridlinesSpacing;
	}

	public JButton getButtonBackColor() {
		return buttonBackColor;
	}

	public void setButtonBackColor(JButton buttonBackColor) {
		this.buttonBackColor = buttonBackColor;
	}



	public TextField getTextWidhtSize() {
		return textWidhtSize;
	}

	public void setTextWidhtSize(TextField textWidhtSize) {
		this.textWidhtSize = textWidhtSize;
	}

	public TextField getTextHeightSize() {
		return textHeightSize;
	}

	public void setTextHeightSize(TextField textHeightSize) {
		this.textHeightSize = textHeightSize;
	}

	public void setModel(WorkspaceModel model)
	{
		this.panelWorkspace.setModel(model);
	}
	public Boolean getShowGrid() {
		return showGrid;
	}
	public void setShowGrid(Boolean showGrid) {
		this.showGrid = showGrid;
	}



	public JButton getButtonApply() {
		return buttonApply;
	}



	public JButton getButtonReset() {
		return buttonReset;
	}



	public void setButtonReset(JButton buttonReset) {
		this.buttonReset = buttonReset;
	}



	public void setButtonApply(JButton buttonApply) {
		this.buttonApply = buttonApply;
	}



	public final WorkspaceView getPanelWorkspace() {
		return panelWorkspace;
	}



	public final void setPanelWorkspace(WorkspaceView panelWorkspace) {
		this.panelWorkspace = panelWorkspace;
	}



	@Override
	public void update() 
	{
		showGridlines.setSelected(model.getShowGrid());
		textGridlinesSpacing.setText(Integer.toString(model.getGridSize()));
		textHeightSize.setText(Integer.toString((int)model.getWorkspaceSize().getHeight()));
		textWidhtSize.setText(Integer.toString((int)model.getWorkspaceSize().getWidth()));
		buttonBackColor.setBackground(model.getBackgroundColor());
	}


}
