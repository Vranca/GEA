package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import models.WorkspaceModel;
import views.WorkspacePropertiesView;

public class ModelPropertiesListener implements ActionListener
{
	WorkspacePropertiesView view = null;
	WorkspaceModel model = null;
	
	public ModelPropertiesListener(WorkspacePropertiesView view)
	{
		this.view = view;
		model = view.getPreviewModel();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = null;
		if(e.getActionCommand().equals("Color"))
		{
			color = JColorChooser.showDialog(view.getButtonBackColor(), "Workspace background color", model.getBackgroundColor());
		}
		int gridSize = Integer.parseInt(view.getTextGridlinesSpacing().getText());
		boolean showGrid = view.getShowGridlines().isSelected();
		
		model.setGridSize(gridSize);
		model.setShowGrid(showGrid);
		if(color != null)
			model.setBackgroundColor(color);
	}

}
