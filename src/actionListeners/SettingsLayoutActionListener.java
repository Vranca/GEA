package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import models.SettingsModel;
import views.SettingsView;

public class SettingsLayoutActionListener implements ActionListener
{

	private SettingsView settingsView = null;
	private SettingsModel settingsModel = null;
	private Vector<Integer> position = null;
	
	public SettingsLayoutActionListener(SettingsView settingsViews, SettingsModel settingsModel)
	{
		this.settingsView = settingsViews;
		this.settingsModel = settingsModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(settingsView.getBtnGroup().areAllSelected())
		{
			position = new Vector<Integer>(settingsView.getBtnGroup().getSelectedInedices());
			settingsModel.setLayout(position.elementAt(0),	position.elementAt(1), position.elementAt(2));
			settingsView.dispose();				
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Nisu izabrane sve pozicije!");
		}
	}

}
