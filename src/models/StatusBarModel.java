/***********************************************************************
 * Module:  StatusBarModel.java
 * Author:  User
 * Purpose: Defines the Class StatusBarModel
 ***********************************************************************/

package models;

import javax.swing.plaf.metal.MetalTheme;

import utility.Localization;

public class StatusBarModel extends AbstractSubject 
{
	private ApplicationState state = null;
	private MetalTheme theme = null;
	private Localization localization = null;
	
   /** @param theme */
   public StatusBarModel() 
   {
	   localization = Localization.getInstance();
   }

	public final ApplicationState getState()
	{
		return state;
	}
	
	public final void setState(ApplicationState newState) 
	{
		this.state = newState;
		notifySubscribers();
	}
	
	public final MetalTheme getTheme() 
	{
		return theme;
	}
	
	public final void setTheme(MetalTheme newTheme)
	{
		this.theme = newTheme;
	}
	
	public String getLocalString(String key)
	{
		return localization.getResources().getString(key);
	}

}