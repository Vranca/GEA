/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  User
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/

package models;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

import com.google.gson.Gson;

import utility.Localization;
import utility.ModelMediator;
import views.ApplicationView;
import views.ProjectBrowserView;
import views.Subscriber;
import utility.ApplicationConfiguration;
import utility.DarkMetalTheme;
import utility.LightMetalTheme;

public class ApplicationModel extends AbstractSubject implements Subscriber 
{
   private MenuBarModel menuBarModel = null;
   private StatusBarModel statusBarModel = null;
   private ToolbarModel toolbarModel = null;
   private MetalTheme theme = null;   
   private ApplicationState state = null;
   private ApplicationConfiguration config = null;
   private Localization localization = null;
   private ModelMediator modelMediator = null;
   
   private int projectBrowserPosition;
   private int workspacePosition;
   private int toolboxPosition;
   
   public ApplicationModel() 
   {   
	   try (FileReader jsonFile =new FileReader("resources\\config.json"))
	   {
		   Gson gson = new Gson();
		   config = gson.fromJson(jsonFile, ApplicationConfiguration.class);
	   } catch (FileNotFoundException e)
	   {
		   e.printStackTrace();
	   } catch (IOException e)
	   {
		   e.printStackTrace();
	   };
	   
	   this.modelMediator = new ModelMediator();
	   modelMediator.setApplicationModel(this);
	
	   localization = Localization.getInstance(config.getLanguage(), config.getCountry());
	
	   menuBarModel = new MenuBarModel();
	   toolbarModel = new ToolbarModel();
	   statusBarModel = new StatusBarModel();
	   
	   projectBrowserPosition = config.getProjectBrowserPosition();
	   workspacePosition = config.getWorkspacePosition();
	   toolboxPosition = config.getToolboxPosition();
	   
	   switch(config.getTheme())
	   {
	   case "light":
		   setTheme(new LightMetalTheme());
		   break;
	   case "dark":
		   setTheme(new DarkMetalTheme());
		   break;
	   default:
		   setTheme(new DefaultMetalTheme());
		   break;
	   }
	   
	  
	   
	   setState(new IdleState());
   }
   
   /** @param newState */
   public void setState(ApplicationState newState) 
   {
	   this.state = newState;
	   this.menuBarModel.setState((MenuBarState)state);
	   this.toolbarModel.setState((ToolbarState)state);
	   this.statusBarModel.setState(state);
	   
	   notifySubscribers();
   }
   
   public ApplicationState getState() 
   {
      return this.state;
   }
   
   public void setTheme(MetalTheme newTheme) 
   {
	   this.theme = newTheme;
	   menuBarModel.setTheme(theme);
	   statusBarModel.setTheme(theme);
	   toolbarModel.setTheme(theme);
   }
   
   public MetalTheme getTheme() 
   {
      return this.theme;
   }

   public void updateTheme(Component frame)
   {
		MetalLookAndFeel.setCurrentTheme(theme);
		try
		{
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} 
		catch (UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
   }
   
   public final MenuBarModel getMenuBarModel() 
   {
	   return menuBarModel;
   }

	public final StatusBarModel getStatusBarModel() {
		return statusBarModel;
	}
	
	public final ToolbarModel getToolbarModel() {
		return toolbarModel;
	}

	public final int getDefaultWidth() {
		return config.getWidth();
	}

	public final void setDefaultWidth(int newDefaultWidth) {
		config.setWidth(newDefaultWidth);
	}

	public final int getDefaultHeight() {
		return config.getHeight();
	}

	public final void setDefaultHeight(int newDefaultHeight) {
		config.setHeight(newDefaultHeight);
	}

	public final Localization getLocalization() {
		return localization;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public String getLocalString(String key)
	{
		return localization.getResources().getString(key);
	}
	
	public Receiver getReceiver(ApplicationView applicationView)
	{
		ProjectBrowserView pbView = state.getProjectBrowserView(applicationView);
		ProjectBrowserModel pbModel = pbView.getModel();
		
		if(pbModel.getSelectedNode() != null || applicationView.getToolboxView() == null)
		{
			return pbModel;
		}
		else 
		{
			ToolboxModel tbModel = state.getToolboxView(applicationView).getModel();
			return tbModel.getSelectedModel();
		}
	}

	
	public ModelMediator getModelMediator() {
		return modelMediator;
	}

	public void setModelMediator(ModelMediator modelMediator) {
		this.modelMediator = modelMediator;
	}

	public final int getProjectBrowserPosition() {
		return projectBrowserPosition;
	}

	public final void setProjectBrowserPosition(int projectBrowserPosition) {
		this.projectBrowserPosition = projectBrowserPosition;
	}

	public final int getWorkspacePosition() {
		return workspacePosition;
	}

	public final void setWorkspacePosition(int workspacePosition) {
		this.workspacePosition = workspacePosition;
	}

	public final int getToolboxPosition() {
		return toolboxPosition;
	}

	public final void setToolboxPosition(int toolboxPosition) {
		this.toolboxPosition = toolboxPosition;
	}
	
	public void updateConfiguration()
	{
		 config.updateConfig(this);
	}

	public final ApplicationConfiguration getConfig() {
		return config;
	}

	public final void setConfig(ApplicationConfiguration config) {
		this.config = config;
	}
	public void saveConfig()
	{
		Gson gson = new Gson();
		try
		{
			FileWriter writer = new FileWriter("resources/config.json");
		
			gson.toJson(config,writer);
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}