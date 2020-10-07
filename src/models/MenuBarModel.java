/***********************************************************************
 * Module:  MenuBarModel.java
 * Author:  User
 * Purpose: Defines the Class MenuBarModel
 ***********************************************************************/

package models;

import javax.swing.plaf.metal.MetalTheme;

import utility.Localization;

public class MenuBarModel extends AbstractSubject 
{
	MenuBarState state = null;
	MetalTheme theme = null;
	Localization localization = null;
	
   /** @param theme */
   public MenuBarModel() 
   {
	   localization = Localization.getInstance();
   }

	public final MenuBarState getState() 
	{
		return state;
	}
	
	public final void setState(MenuBarState newState) 
	{
		this.state = newState;
		notifySubscribers();
	}
	
	public MetalTheme getTheme()
	{
		return this.theme;
	}
	
	public void setTheme(MetalTheme newTheme)
	{
		this.theme = newTheme;
	}

	public final Localization getLocalization() {
		return localization;
	}

	public String getLocalString(String key)
	{
		return localization.getResources().getString(key);
	}
}