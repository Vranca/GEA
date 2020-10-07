package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import algorithmElements.AlgorithmElement;
import algorithmElements.Symbol;
import controllers.ObjectOptionsController;
import controllers.SettingsController;
import controllers.WorkspacePropertiesController;
import models.ApplicationModel;
import models.SettingsModel;
import models.WorkspaceModel;
import utility.ModelMediator;
import views.ApplicationView;
import views.ObjectOptionsView;
import views.SettingsView;
import views.WorkspacePropertiesView;

public class OptionsClickActionListener implements ActionListener
{

	ModelMediator modelMediator = null;
	public OptionsClickActionListener(ApplicationView applicationView)
	{
		ApplicationModel applicationModel = applicationView.getModel();
		modelMediator = applicationModel.getModelMediator();
	}
	public OptionsClickActionListener(WorkspaceModel workspaceModel)
	{
		modelMediator = workspaceModel.getModelMediator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
			case "Preferences":
			{
				if(modelMediator.getSettingsModel() == null)
				{
					new SettingsModel(modelMediator);
				}
				
				SettingsView settingsView=new SettingsView(modelMediator.getSettingsModel(),modelMediator.getApplicationView());
				new SettingsController(settingsView, modelMediator.getSettingsModel());
				
				break;
			}
			case "Algorithm Options":
			{
				WorkspacePropertiesView workspacePropertiesView = new WorkspacePropertiesView(modelMediator.getToolboxModel().getSelectedModel());
				new WorkspacePropertiesController(modelMediator.getToolboxModel().getSelectedModel(), workspacePropertiesView);
				
				break;
			}
			case "Object Options":
			{
				WorkspaceModel selectedModel = modelMediator.getToolboxModel().getSelectedModel();
				if(selectedModel.getSelectedAlgorithmElements().size() == 1)
				{
					AlgorithmElement selectedElement = selectedModel.getSelectedAlgorithmElements().get(0);
					if(selectedElement instanceof Symbol)
					{
						Symbol selectedSymbol = (Symbol) selectedElement;
						ObjectOptionsView objectOptionsView = new ObjectOptionsView(selectedSymbol);
						new ObjectOptionsController(selectedSymbol, objectOptionsView);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Can't edit this element!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "You can only edit one element at a time!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
				break;
			}
		}
		
	}

}
