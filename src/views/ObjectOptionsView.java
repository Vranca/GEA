package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import actionListeners.ObjectButtonListener;
import actionListeners.ObjectColorListener;
import actionListeners.ObjectPropertiesListener;
import algorithmElements.FlatVisualStyle;
import algorithmElements.Symbol;
import models.WorkspaceModel;

public class ObjectOptionsView extends JDialog implements Subscriber 
{
	private static final long serialVersionUID = 1L;
	
	private JPanel panelElement=null;
	private JPanel panelProperties=null;
	private JPanel panelStyle=null;
	private JPanel panelWest=null;
	private JLabel labelaText=null;
	private JLabel labelaFontSize=null;
	private JLabel labelaBackColor=null;
	private JLabel labelaForeColor=null;
	private JLabel labelaBorderThickness=null;
	private JLabel labelaBorderColor=null;
	private JLabel labelaWidth=null;
	private JLabel labelaHeight=null;
	private JTextField textTextField=null;
	private JTextField fontSizeTextField=null;
	private JButton backColorButton=null;
	private JButton foreColorButton=null;
	private JTextField borderThicknessTextField=null;
	private JButton borderColorButton=null;
	private JTextField widthTextField=null;
	private JTextField heightTextField=null;
	private Border border=null;
	private Font font =null;
	private Border titledBorder=null;
	private JLabel labelaStyle=null;
	private JPanel panelEast=null;
	private JPanel panelLabela=null;
	private ElementPreview panelAlgorithm=null;
	private JLabel labelaElement=null;
	private JButton applyButton = null;
	private JButton resetButton = null;
	
	Symbol previewElement = null;
	
	public ObjectOptionsView(Symbol selectedElement) 
	{
		previewElement = (Symbol) selectedElement.copy();
		
		panelElement=new JPanel();
		panelProperties=new JPanel();
		panelStyle=new JPanel();
		panelWest=new JPanel();
		panelEast=new JPanel();
		
		panelWest.setPreferredSize(new Dimension(300,300));
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelElement,BorderLayout.NORTH);
		
		panelElement.setPreferredSize(new Dimension(300,200));
		panelElement.setLayout(new FlowLayout());
		
		WorkspaceModel preview = WorkspaceModel.getPreviewModel();
		preview.removeAllAlgorithmElements();
		preview.addAlgorithmElements(previewElement);
		
		panelAlgorithm = new ElementPreview(preview);
		
		panelLabela=new JPanel();
		panelLabela.setLayout(new BorderLayout());
		labelaElement=new JLabel("Preview");
		panelLabela.add(labelaElement,BorderLayout.WEST);
		panelLabela.setPreferredSize(new Dimension(250,20));
		panelAlgorithm.setPreferredSize(new Dimension(280,150));
		panelAlgorithm.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		panelElement.add(panelLabela);
		panelElement.add(panelAlgorithm);
		
		panelWest.add(panelProperties,BorderLayout.CENTER);
		panelEast.setLayout(new BorderLayout());
		panelStyle.setPreferredSize(new Dimension(280, 180));
		panelEast.add(panelStyle,BorderLayout.NORTH);
		
		JPanel applyAndResetPanel = new JPanel();
		applyButton=new JButton("Apply");
		resetButton=new JButton("Reset");
		
		applyAndResetPanel.add(resetButton);
		applyAndResetPanel.add(applyButton);
		
		
		panelEast.add(applyAndResetPanel,BorderLayout.SOUTH);
		
		
		JScrollPane scrollWest=new JScrollPane(panelWest);
		JScrollPane scrollStyle=new JScrollPane(panelEast);
		
		panelProperties.setLayout(new GridLayout(2,2));
		panelProperties.setPreferredSize(new Dimension(300,100));
		labelaText=new JLabel("Text: ");
		labelaFontSize=new JLabel("FontSize: ");
		labelaHeight=new JLabel("Height:");
		labelaWidth=new JLabel("Width:");
		textTextField=new JTextField(previewElement.getText());
		fontSizeTextField=new JTextField(Integer.toString(previewElement.getFontSize()));
		heightTextField=new JTextField(Integer.toString(previewElement.getHeight()));
		widthTextField=new JTextField(Integer.toString(previewElement.getWidth()));
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(labelaText);
		panel1.add(labelaFontSize);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(labelaHeight);
		panel2.add(labelaWidth);
		
		JPanel panel3=new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		panel3.add(textTextField);
		panel3.add(fontSizeTextField);
		
		JPanel panel4=new JPanel();
		panel4.setLayout(new GridLayout(2, 1));
		panel4.add(heightTextField);
		panel4.add(widthTextField);
		
		panelProperties.add(panel1);
		panelProperties.add(panel3);
		panelProperties.add(panel2);
		panelProperties.add(panel4);
		
		border = BorderFactory.createLineBorder(Color.GRAY, 1, true);
		font = new Font("Courier New", Font.ITALIC, 12);
		titledBorder = BorderFactory.createTitledBorder(border, "Style", TitledBorder.CENTER, TitledBorder.TOP, font, Color.BLACK);
		panelStyle.setBorder(titledBorder);

		labelaBackColor=new JLabel("BackColor: ");
		labelaForeColor=new JLabel("ForeColor: ");
		labelaBorderThickness=new JLabel("Border Thickness:");
		labelaBorderColor=new JLabel("Border Color:");
		backColorButton=new JButton();
		backColorButton.setBackground(previewElement.getBackgroundColor());
		
		foreColorButton=new JButton();
		foreColorButton.setBackground(previewElement.getVisualStyle().getTextColor());
			
		borderThicknessTextField=new JTextField(Integer.toString(previewElement.getBorderThickness()));
		
		borderColorButton=new JButton();
		borderColorButton.setBackground(previewElement.getBorderColor());
		
		JPanel panel5=new JPanel();
		panel5.setLayout(new GridLayout(2,1));
		panel5.add(labelaBackColor);
		panel5.add(labelaForeColor);
		
		JPanel panel6=new JPanel();
		panel6.setLayout(new GridLayout(2,1));
		panel6.add(backColorButton);
		panel6.add(foreColorButton);
		
		JPanel panel7=new JPanel();
		panel7.setLayout(new GridLayout(2,1));
		panel7.add(labelaBorderThickness);
		panel7.add(labelaBorderColor);
		
		JPanel panel8=new JPanel();
		panel8.setLayout(new GridLayout(2,1));
		panel8.add(borderThicknessTextField);
		panel8.add(borderColorButton);
		
		String[] stringStyle={"Flat"};
		JComboBox<?> styleList = new JComboBox<Object>(stringStyle);
		labelaStyle=new JLabel("Visaul Style:");
		JPanel panel9=new JPanel();
		panel9.setLayout(new GridLayout(2,1,10,10));
		panel9.add(styleList);
		JPanel panel10=new JPanel();
		panel10.setLayout(new GridLayout(2,1,10,10));
		panel10.add(labelaStyle);
		

		panelStyle.setLayout(new GridLayout(3,3));
		panelStyle.add(panel5);
		panelStyle.add(panel6);
		panelStyle.add(panel7);
		panelStyle.add(panel8);
		panelStyle.add(panel10);
		panelStyle.add(panel9);
	

		
	
		setResizable(false);
		setVisible(true);
		setSize(new Dimension(600,350));
		setIconImage(new ImageIcon("icons/gea.png").getImage());
		setTitle("Algoritham Options");
		setLayout(new BorderLayout());
		add(scrollWest,BorderLayout.WEST);
		add(scrollStyle,BorderLayout.EAST);		
	}

	public void resetElement(Symbol oldElement)
	{
		previewElement.setVisualStyle(new FlatVisualStyle(oldElement.getVisualStyle()));
		previewElement.setText(new String(oldElement.getText()));
		previewElement.setFontSize(oldElement.getFontSize());
	}
	
	public void registerColorListener(ObjectColorListener listener)
	{
		backColorButton.setActionCommand("Background");
		foreColorButton.setActionCommand("Foreground");
		borderColorButton.setActionCommand("Border");
		
		backColorButton.addActionListener(listener);
		foreColorButton.addActionListener(listener);
		borderColorButton.addActionListener(listener);
	}
	
	public void registerPropertiesListener(ObjectPropertiesListener listener)
	{
		textTextField.addActionListener(listener);
		fontSizeTextField.addActionListener(listener);
		heightTextField.addActionListener(listener);
		widthTextField.addActionListener(listener);
		borderThicknessTextField.addActionListener(listener);
	}
	
	public void registerButtonListener(ObjectButtonListener listener) 
	{
		applyButton.setActionCommand("Apply");
		resetButton.setActionCommand("Reset");
		
		applyButton.addActionListener(listener);
		resetButton.addActionListener(listener);
	}

	@Override
	public void update() {
		textTextField.setText(previewElement.getText());
		fontSizeTextField.setText(Integer.toString(previewElement.getFontSize()));
		heightTextField.setText(Integer.toString(previewElement.getHeight()));
		widthTextField.setText(Integer.toString(previewElement.getWidth()));
		borderThicknessTextField.setText(Integer.toString(previewElement.getBorderThickness()));
		
		backColorButton.setBackground(previewElement.getBackgroundColor());
		foreColorButton.setBackground(previewElement.getVisualStyle().getTextColor());
		borderColorButton.setBackground(previewElement.getBorderColor());
		
		revalidate();
		repaint();
	}

	public final JTextField getTextTextField() {
		return textTextField;
	}

	public final JTextField getFontSizeTextField() {
		return fontSizeTextField;
	}

	public final JTextField getBorderThicknessTextField() {
		return borderThicknessTextField;
	}

	public final JTextField getWidthTextField() {
		return widthTextField;
	}

	public final JTextField getHeightTextField() {
		return heightTextField;
	}

	public final Symbol getPreviewElement() {
		return previewElement;
	}
	
}