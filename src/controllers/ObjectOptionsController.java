package controllers;

import actionListeners.ObjectButtonListener;
import actionListeners.ObjectColorListener;
import actionListeners.ObjectPropertiesListener;
import algorithmElements.Symbol;
import views.ObjectOptionsView;

public class ObjectOptionsController
{
	private Symbol model = null;
	private ObjectOptionsView view = null;
	
	public ObjectOptionsController(Symbol model, ObjectOptionsView view)
	{
		this.model = model;
		this.view = view;
		
		this.view.registerColorListener(new ObjectColorListener(this.view));
		this.view.registerPropertiesListener(new ObjectPropertiesListener(this.view));
		this.view.registerButtonListener(new ObjectButtonListener(this.model, this.view));
	}

}
