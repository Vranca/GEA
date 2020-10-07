package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algorithmElements.FlatVisualStyle;
import algorithmElements.Symbol;
import views.ObjectOptionsView;

public class ObjectButtonListener implements ActionListener
{
	private Symbol model = null;
	private ObjectOptionsView view = null;
	
	public ObjectButtonListener(Symbol model, ObjectOptionsView view)
	{
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
		case "Apply":
			model.setVisualStyle(new FlatVisualStyle(view.getPreviewElement().getVisualStyle()));
			model.setText(view.getPreviewElement().getText());
			model.setFontSize(view.getPreviewElement().getFontSize());
			break;
		case "Reset":
			view.resetElement(model);
			break;

		default:
			break;
		}
		
		view.update();
	}

}
