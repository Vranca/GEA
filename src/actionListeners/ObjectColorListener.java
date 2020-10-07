package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import algorithmElements.Symbol;
import views.ObjectOptionsView;

public class ObjectColorListener implements ActionListener
{
	private Symbol model = null;
	private ObjectOptionsView view = null;
	
	public ObjectColorListener(ObjectOptionsView view)
	{
		this.view = view;
		this.model = view.getPreviewElement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = JColorChooser.showDialog(view, "Workspace background color", model.getBackgroundColor());
		
		switch (e.getActionCommand())
		{
		case "Background":
			model.getVisualStyle().setBackgroundColor(color);
			break;
		case "Foreground":
			model.getVisualStyle().setTextColor(color);
			break;
		case "Border":
			model.getVisualStyle().setBorderColor(color);
			break;

		default:
			break;
		}
		view.update();
	}

}
