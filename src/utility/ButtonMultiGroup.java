package utility;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ButtonMultiGroup
{
	protected java.util.List<ButtonGroup> buttonGroups = null;
	private ActionListener buttonDeselecter = null;
	
	public ButtonMultiGroup()
	{
		buttonGroups = new Vector<ButtonGroup>();
		buttonDeselecter = new ButtonDeselecter();
	}
	
	public void createGroup()
	{
		buttonGroups.add(new ButtonGroup());
	}
	
	public void addButtonToGroup(AbstractButton button, int groupIndex)
	{
		if(groupIndex >= buttonGroups.size())
			return;
		
		button.addActionListener(buttonDeselecter);
		buttonGroups.get(groupIndex).add(button);
	}
	
	public void addButtonToLastGroup(AbstractButton button)
	{
		if(buttonGroups.isEmpty())
			createGroup();
		
		int index = buttonGroups.size() - 1;
		
		addButtonToGroup(button, index);
	}
	
	public Boolean areAllSelected()
	{
		Boolean areAllSelected = true;
		
		for(ButtonGroup bg : buttonGroups)
		{
			Boolean groupHasSelection = false;
			for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); )
			{
				AbstractButton button = buttons.nextElement();
				if(button.isSelected())
				{
					groupHasSelection = true;
					break;
				}
				
			}
			areAllSelected = areAllSelected && groupHasSelection;
			
			for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); )
			{
				AbstractButton button = buttons.nextElement();
				button.setEnabled(true);
			}
		}
		
		return areAllSelected;
	}
	
	public java.util.List<Integer> getSelectedInedices()
	{
		java.util.List<Integer> indices = new Vector<Integer>();
		
		for(ButtonGroup bg : buttonGroups)
		{
			int index = 0;
			for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); )
			{
				AbstractButton button = buttons.nextElement();
				if(button.isSelected())
				{
					indices.add(index);
					break;
				}
				index++;			
			}
		}
				
		return indices;
	}
	
	private class ButtonDeselecter implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{			
			JRadioButton radioButton = (JRadioButton) e.getSource();
			
			for(ButtonGroup bg : buttonGroups)
			{
				JRadioButton selectedButton = new JRadioButton();
				
				for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); )
				{
					AbstractButton button = buttons.nextElement();
					if(button.isSelected())
					{
						selectedButton = (JRadioButton) button;
						break;
					}
					
				}
				
				
				if((selectedButton.getText().equals(radioButton.getText())) && (selectedButton != radioButton))
				{
					bg.clearSelection();
				}
				for(Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements(); )
				{
					AbstractButton button = buttons.nextElement();
					button.setEnabled(true);
				}
			}
		}
		
	}

}
