package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import algorithmElements.Symbol;
import models.ToolboxModel;
import views.ToolboxView;

public class PreviewElementActionListener implements ActionListener
{

	ToolboxModel toolboxModel=null;
	ToolboxView toolboxView=null;
	Symbol elementPreview=null;
	public PreviewElementActionListener(ToolboxView toolboxview,ToolboxModel toolboxModel)
	{
		this.toolboxView=toolboxview;
		this.toolboxModel=toolboxModel;
		this.elementPreview=(Symbol) toolboxModel.getPreviewElement();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton)
		{
			JButton btn = (JButton) e.getSource();
			Color color=JColorChooser.showDialog(btn,toolboxModel.getLocalString("toolbox.selectcolor"),toolboxModel.getSelectedModel().getBackgroundColor());    
			btn.setBackground(color);
		}
		int fontSize = Integer.parseInt(toolboxView.getFontSizeTextField().getText());                               
		Color backColor = toolboxView.getBackColorButton().getBackground();                     
		Color borderColor = toolboxView.getBorderColorButton().getBackground();                       
		int borderThickness = Integer.parseInt(toolboxView.getBorderThicknessTextField().getText());
		int elementHeight = Integer.parseInt(toolboxView.getElementHeightTextField().getText());           
		Color foreColor = toolboxView.getForeColorButton().getBackground();                           
		int elementWidth = Integer.parseInt(toolboxView.getElementWidthTextField().getText());             
		String text = toolboxView.getTextTextField().getText();                                                        
		                                                                              
		toolboxModel.updatePreview(fontSize,backColor,borderColor,borderThickness,elementHeight,foreColor,elementWidth,text);
	}
	

}
