package main;
import controllers.ApplicationController;
import models.ApplicationModel;
import views.*;

public class MainClass
{

	public static void main(String[] args) 
	{		
		ApplicationModel applicationModel = new ApplicationModel();
		ApplicationView applicationView = new ApplicationView(applicationModel);
		new ApplicationController(applicationModel, applicationView);
	}
}
