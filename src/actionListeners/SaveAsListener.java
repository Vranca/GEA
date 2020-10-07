package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import utility.ModelMediator;
import views.ApplicationView;

public class SaveAsListener implements ActionListener
{
	ModelMediator mediator = null;
	
	public SaveAsListener(ApplicationView view)
	{
		mediator = view.getModel().getModelMediator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			 File selectedFile = jfc.getSelectedFile();
			 mediator.saveAs(selectedFile);
		}
	}

}
