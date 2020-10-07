package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algorithmElements.Symbol;
import views.ObjectOptionsView;

public class ObjectPropertiesListener implements ActionListener
{
	private Symbol model = null;
	private ObjectOptionsView view = null;
	
	public ObjectPropertiesListener(ObjectOptionsView view)
	{
		this.view = view;
		this.model = this.view.getPreviewElement();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int width = Integer.parseInt(view.getWidthTextField().getText());
		int height = Integer.parseInt(view.getHeightTextField().getText());
		String text = view.getTextTextField().getText();
		int borderThickness = Integer.parseInt(view.getBorderThicknessTextField().getText());
		int fontSize = Integer.parseInt(view.getFontSizeTextField().getText());
		
		model.setFontSize(fontSize);
		model.setText(text);
		model.getVisualStyle().setHeight(height);
		model.getVisualStyle().setWidth(width);
		model.getVisualStyle().setBorderThickness(borderThickness);
		
		view.update();
	}

}
