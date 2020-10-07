package utility;

import java.util.Locale;
import java.util.ResourceBundle;

import models.AbstractSubject;

public class Localization extends AbstractSubject
{
	private static Localization instance = null;
	
	private Locale locale = null;
	private ResourceBundle resources = null;
	
	private Localization(String language, String country)
	{
		setLocalization(language, country);
	}

	public static Localization getInstance(String language, String country)
	{
		if ( instance == null )
			instance = new Localization(language, country);
		return instance;
	}
	
	public static Localization getInstance()
	{
		if ( instance == null )
			instance = new Localization("en", "US");
		return instance;
	}

	public final Locale getLocale() {
		return locale;
	}
	
	public void setLocalization(String language, String country)
	{
		locale = new Locale(language, country);
		ResourceBundle.clearCache();
		resources = ResourceBundle.getBundle("languages.ApplicationResources", locale);
		
		notifySubscribers();
	}

	public final void setLocale(Locale locale) {
		this.locale = locale;
	}

	public final ResourceBundle getResources() {
		return resources;
	}

	public final void setResources(ResourceBundle resources) {
		this.resources = resources;
	}
	
	public static String getLocalString(String key)
	{
		return getInstance().getResources().getString(key);
	}
}
