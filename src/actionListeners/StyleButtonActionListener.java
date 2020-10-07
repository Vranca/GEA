package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ToolboxModel;

public class StyleButtonActionListener implements ActionListener
{

	ToolboxModel toolboxModel=null;
	public StyleButtonActionListener(ToolboxModel toolboxModel)
	{
		this.toolboxModel=toolboxModel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
		case "Apply":
			toolboxModel.applyPreviewElement();
			break;
		case "Reset":
			toolboxModel.resetPreview();
			break;
		case "Default":
			toolboxModel.setDefaultStyle();
			break;

		default:
			break;
		}
		

	}

}
