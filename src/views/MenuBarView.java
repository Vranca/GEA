/***********************************************************************
 * Module:  MenuBarView.java
 * Author:  User
 * Purpose: Defines the Class MenuBarView
 ***********************************************************************/

package views;

import models.MenuBarModel;
import utility.Localization;

import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actionListeners.CloseAllProjectsListener;
import actionListeners.CloseProjectActionListener;
import actionListeners.LanguageActionListener;
import actionListeners.MenuHelpListener;
import actionListeners.NewProjectActionListener;
import actionListeners.OpenProjectActionListener;
import actionListeners.OptionsClickActionListener;
import actionListeners.SaveAsListener;
import actionListeners.ToolbarCommandsListener;
import actionListeners.ToolboxWorkspacePropertiesListener;

public class MenuBarView extends JMenuBar implements Subscriber 
{
   private static final long serialVersionUID = 1L;
   
   private MenuBarModel model = null;
   
   private JMenu menuFile = null;
   private JMenuItem menuItemNewProject = null;
   
   private JMenuItem menuItemNewAlgorithm = null;
   
   private JMenuItem menuItemLanguage1 = null;
   private JMenuItem menuItemLanguage2 = null;
   private JMenuItem menuItemLanguage3 = null;
   private JMenuItem menuItemOpenProject=null;
   private JMenuItem menuItemClose =null;
   private JMenuItem menuItemCloseAll=null;
   private JMenuItem menuItemSave=null;
   private JMenuItem menuItemSaveAs=null;
   private JMenuItem menuItemSaveAll=null;
   private JMenuItem menuItemAbout=null;
   private JMenuItem menuItemHelpContents=null;
   private JMenuItem menuItemUndo=null;
   private JMenuItem menuItemRedo=null;
   private JMenuItem menuItemPaste=null;
   private JMenuItem menuItemCopy=null;
   private JMenuItem menuItemCut=null;
   private JMenuItem menuItemDelete=null;
   private JMenuItem menuItemSelect=null;
   private JMenuItem menuItemSelectAll=null;
   private JMenuItem menuAlgorithmOptions=null;
   private JMenuItem menuObjectOptions=null;
   private JMenuItem menuPreferences=null;
   private JMenuItem menuItemShowGuidelines=null; 
   private JMenuItem menuItemZoomIn=null;
   private JMenuItem menuItemZoomOut=null;
   private JMenuItem menuItemDefaultZoom=null;

   private JMenu menuView = null;

   private JMenu menuOptions = null;

   private JMenu menuEdit = null;

   private JMenu menuHelp = null;

   private JMenu menuNew = null;
   
   private JMenu menuLanguage = null;
 
   
   /** @param model */
   public MenuBarView(MenuBarModel model) 
   {
	   super();
	   this.model = model;	   
	   
	   addMenuFile();
	   addMenuEdit();
	   addMenuView();
	   addMenuOptions();
	   addMenuHelp();
	   
	   model.getState().enableMenuItems(this);
	   Localization.getInstance().addSubscribers(this);
   }
   public void addMenuFile()
   {	   
	   menuFile = new JMenu(model.getLocalString("menufile"));
	   menuFile.setOpaque(false);

	   menuFile.setMnemonic(KeyEvent.VK_F);
	   
	   menuNew = new JMenu(model.getLocalString("menufile.new"));
	   menuNew.setPreferredSize(new Dimension(150,20));

	   menuItemNewProject = new JMenuItem(model.getLocalString("menufile.newproject"));
	   menuItemNewProject.setPreferredSize(new Dimension(100,20));

	   menuItemNewAlgorithm = new JMenuItem(model.getLocalString("menufile.newalgorithm"));
	   menuItemNewAlgorithm.setPreferredSize(new Dimension(100,20));
	   
	 
	   menuNew.add(menuItemNewProject);
	   menuNew.add(menuItemNewAlgorithm);
	   menuFile.add(menuNew);
	   
	   menuItemOpenProject = new JMenuItem(model.getLocalString("menufile.openproject"));
	   menuItemOpenProject.setPreferredSize(new Dimension(150,20));
	   
	   menuFile.add(menuItemOpenProject);
	   
	   menuFile.addSeparator();
	   
	   menuItemClose = new JMenuItem(model.getLocalString("menufile.close"));
	   menuItemClose.setPreferredSize(new Dimension(150,20));
	   
	   menuItemCloseAll = new JMenuItem(model.getLocalString("menufile.closeall"));
	   menuItemCloseAll.setPreferredSize(new Dimension(150,20));
	   
	   menuFile.add(menuItemClose);
	   menuFile.add(menuItemCloseAll);
	   menuFile.addSeparator();
	   
	   menuItemSave = new JMenuItem(model.getLocalString("menufile.save"));
	   menuItemSave.setPreferredSize(new Dimension(150,20));
	   
	   menuItemSaveAs = new JMenuItem(model.getLocalString("menufile.saveas"));
	   menuItemSaveAs.setPreferredSize(new Dimension(150,20));
	   
	   menuItemSaveAll = new JMenuItem(model.getLocalString("menufile.saveall"));
	   menuItemSaveAll.setPreferredSize(new Dimension(150,20));
	   
	   menuFile.add(menuItemSave);
	   menuFile.add(menuItemSaveAs);
	   menuFile.add(menuItemSaveAll);	   
	   
	   add(menuFile);  
   }

   
public void addMenuHelp() {
	   
	   menuHelp = new JMenu(model.getLocalString("menuhelp"));
	   menuHelp.setOpaque(false);
	   
	   menuHelp.setMnemonic(KeyEvent.VK_H);
	   
	   menuItemAbout = new JMenuItem(model.getLocalString("menuhelp.about"));
	   menuItemAbout.setPreferredSize(new Dimension(150,20));
	   
	   menuItemHelpContents = new JMenuItem(model.getLocalString("menuhelp.helpcontents"));
	   menuItemHelpContents.setActionCommand("Help");
	   menuItemHelpContents.setPreferredSize(new Dimension(150,20));

	   
	   menuHelp.add(menuItemHelpContents);
	   menuHelp.addSeparator();
	   menuHelp.add(menuItemAbout);
	   
	   add(menuHelp);
	   
	   
   }
   public void addMenuEdit()
   {
	   menuEdit = new JMenu(model.getLocalString("menuedit"));
	   menuEdit.setOpaque(false);

	   menuEdit.setMnemonic(KeyEvent.VK_E);
	   
	   menuItemUndo = new JMenuItem(model.getLocalString("menuedit.undo"));
	   menuItemUndo.setPreferredSize(new Dimension(150,20));
	   
	   menuItemRedo = new JMenuItem(model.getLocalString("menuedit.redo"));
	   menuItemRedo.setPreferredSize(new Dimension(150,20));
	   
	   menuEdit.add(menuItemUndo);
	   menuEdit.add(menuItemRedo);
	   menuEdit.addSeparator();
	   
	   menuItemCut = new JMenuItem(model.getLocalString("menuedit.cut"));
	   menuItemUndo.setPreferredSize(new Dimension(150,20));
	   
	   menuItemCopy = new JMenuItem(model.getLocalString("menuedit.copy"));
	   menuItemRedo.setPreferredSize(new Dimension(150,20));
	   
	   menuItemPaste = new JMenuItem(model.getLocalString("menuedit.paste"));
	   menuItemUndo.setPreferredSize(new Dimension(150,20));
	   
	   menuEdit.add(menuItemCut);
	   menuEdit.add(menuItemCopy);
	   menuEdit.add(menuItemPaste);
	   menuEdit.addSeparator();
	   
	   menuItemDelete = new JMenuItem(model.getLocalString("menuedit.delete"));
	   menuItemUndo.setPreferredSize(new Dimension(150,20));
	   
	   menuItemSelect = new JMenuItem(model.getLocalString("menuedit.select"));
	   menuItemRedo.setPreferredSize(new Dimension(150,20));
	   
	   menuItemSelectAll = new JMenuItem(model.getLocalString("menuedit.selectall"));
	   menuItemUndo.setPreferredSize(new Dimension(150,20));
	   
	   menuEdit.add(menuItemDelete);
	   menuEdit.add(menuItemSelect);
	   menuEdit.add(menuItemSelectAll);
	   	   
	   add(menuEdit);	   
   }
   
   public void addMenuOptions()
   {
	   menuOptions = new JMenu(model.getLocalString("menuoptions"));
	  
	   menuOptions.setOpaque(false);
	   menuOptions.setMnemonic(KeyEvent.VK_O);
	   
	   menuLanguage = new JMenu(model.getLocalString("menuoptions.language"));
	   menuLanguage.setPreferredSize(new Dimension(150,20));
	   
	  menuItemLanguage1 = new JMenuItem(model.getLocalString("menuoptions.languageenglish"));
	  menuItemLanguage1.setPreferredSize(new Dimension(100,20));
	  menuItemLanguage1.setActionCommand("enUS");
	  
	  menuItemLanguage2 = new JMenuItem(model.getLocalString("menuoptions.languageserbianlatin"));
	  menuItemLanguage2.setPreferredSize(new Dimension(100,20));
	  menuItemLanguage2.setActionCommand("srBA");
	  
	  menuItemLanguage3 = new JMenuItem(model.getLocalString("menuoptions.languageserbiancyrillic"));
	  menuItemLanguage3.setPreferredSize(new Dimension(100,20));
	  menuItemLanguage3.setActionCommand("srRS");
	  
	  menuLanguage.add(menuItemLanguage1);
	  menuLanguage.add(menuItemLanguage2);
	  menuLanguage.add(menuItemLanguage3);
	  
	  
	  menuAlgorithmOptions = new JMenuItem(model.getLocalString("menuoptions.algorithmoptions"));
	  menuAlgorithmOptions.setActionCommand("Algorithm Options");
	  menuAlgorithmOptions.setPreferredSize(new Dimension(100,20));
	  
	  menuObjectOptions = new JMenuItem(model.getLocalString("menuoptions.objectoptions"));
	  menuObjectOptions.setPreferredSize(new Dimension(100,20));
	  menuObjectOptions.setActionCommand("Object Options");
	  
	  menuPreferences = new JMenuItem(model.getLocalString("menuoptions.preferences"));
	  menuPreferences.setActionCommand("Preferences");
	  menuPreferences.setPreferredSize(new Dimension(100,20));
	  
	  
	  
	 
	  menuOptions.add(menuLanguage);
	  menuOptions.addSeparator();
	  menuOptions.add(menuAlgorithmOptions);
	  menuOptions.add(menuObjectOptions);
	  menuOptions.addSeparator();
	  menuOptions.add(menuPreferences);
	  
	  add(menuOptions);
   }
   
   public void addMenuView()
   {
	   menuView = new JMenu(model.getLocalString("menuview"));
	   menuView.setOpaque(false);

	   menuView.setMnemonic(KeyEvent.VK_V);
	   
	   menuItemShowGuidelines = new JMenuItem(model.getLocalString("menuview.showguidelines"));
	   menuItemShowGuidelines.setPreferredSize(new Dimension(150,20));
	   
	   menuView.add(menuItemShowGuidelines);
	   menuView.addSeparator();
	   
	   menuItemZoomIn = new JMenuItem(model.getLocalString("menuview.zoomin"));
	   menuItemZoomIn.setPreferredSize(new Dimension(150,20));
	   
	   menuItemZoomOut = new JMenuItem(model.getLocalString("menuview.zoomout"));
	   menuItemZoomOut.setPreferredSize(new Dimension(150,20));
	   
	   menuItemDefaultZoom = new JMenuItem(model.getLocalString("menuview.defaultzoom"));
	   menuItemDefaultZoom.setPreferredSize(new Dimension(150,20));
	   
	   menuView.add(menuItemZoomIn);
	   menuView.add(menuItemZoomOut);
	   menuView.add(menuItemDefaultZoom);
	   
	   
	   add(menuView);
   }
   
   public void registerNewProjectlistener(NewProjectActionListener projectActionListener)
   {
	   menuItemNewProject.addActionListener(projectActionListener);	
   } 

   @Override
   protected void paintComponent(Graphics g)
   {
	   	Graphics2D g2 = (Graphics2D)g.create();

	    // Apply vertical gradient
	    g2.setPaint(new GradientPaint(0, 0, model.getTheme().getControl(), 0, getHeight()/2, model.getTheme().getControl()));
	    g2.setPaint(new GradientPaint(0, getHeight()/2, model.getTheme().getControl(), 0, getHeight(), model.getTheme().getControlShadow()));
	    g2.fillRect(0, 0, getWidth(), getHeight());

	    // Dipose of copy
	    g2.dispose();
   }
   
   public void update() 
   {
	   model.getState().enableMenuItems(this);
	   updateLanguage();
   }
   
   private void updateLanguage()
   {
	   menuFile.setText(model.getLocalString("menufile"));
	   menuItemNewProject.setText(model.getLocalString("menufile.newproject"));
	   menuOptions.setText(model.getLocalString("menuoptions"));
	   menuLanguage.setText(Localization.getLocalString("menuoptions.language"));
	   menuEdit.setText(model.getLocalString("menuedit"));
       
	   menuHelp.setText(model.getLocalString("menuhelp"));
	           
	   menuNew.setText(model.getLocalString("menufile.new"));
	   
	   menuItemNewAlgorithm.setText(model.getLocalString("menufile.newalgorithm"));
	   
	   menuItemLanguage1.setText(model.getLocalString("menuoptions.languageenglish"));
	   menuItemLanguage2.setText(model.getLocalString("menuoptions.languageserbianlatin"));
	   menuItemLanguage3.setText(model.getLocalString("menuoptions.languageserbiancyrillic"));
	   menuItemOpenProject.setText(model.getLocalString("menufile.openproject"));
	   menuItemClose.setText(model.getLocalString("menufile.close"));
	   menuItemCloseAll.setText(model.getLocalString("menufile.closeall"));
	   menuItemSave.setText(model.getLocalString("menufile.save"));
	   menuItemSaveAs.setText(model.getLocalString("menufile.saveas"));
	   menuItemSaveAll.setText(model.getLocalString("menufile.saveall"));
	   menuItemAbout.setText(model.getLocalString("menuhelp.about"));
	   menuItemHelpContents.setText(model.getLocalString("menuhelp.helpcontents"));
	   menuItemUndo.setText(model.getLocalString("menuedit.undo"));
	   menuItemRedo.setText(model.getLocalString("menuedit.redo"));
	   menuItemPaste.setText(model.getLocalString("menuedit.paste"));
	   menuItemCopy.setText(model.getLocalString("menuedit.copy"));
	   menuItemCut.setText(model.getLocalString("menuedit.cut"));
	   menuItemDelete.setText(model.getLocalString("menuedit.delete"));
	   menuItemSelect.setText(model.getLocalString("menuedit.select"));
	   menuItemSelectAll.setText(model.getLocalString("menuedit.selectall"));
	   menuAlgorithmOptions.setText(model.getLocalString("menuoptions.algorithmoptions"));
	   menuObjectOptions.setText(model.getLocalString("menuoptions.objectoptions"));
	   menuPreferences.setText(model.getLocalString("menuoptions.preferences"));
	   menuItemShowGuidelines.setText(model.getLocalString("menuview.showguidelines")); 
	   menuItemZoomIn.setText(model.getLocalString("menuview.zoomin"));
	   menuItemZoomOut.setText(model.getLocalString("menuview.zoomout"));
	   menuItemDefaultZoom.setText(model.getLocalString("menuview.defaultzoom"));
	 
   }
  
   
   public void enableItemNewAlgorithm(Boolean enabled)
   {
	   menuItemNewAlgorithm.setEnabled(enabled);
   }
   public void enableItemClose(Boolean enabled)
   {
	   menuItemClose.setEnabled(enabled);
   }
   public void enableItemCloseAll(Boolean enabled)
   {
	   menuItemCloseAll.setEnabled(enabled);
   }
   public void enableItemSave(Boolean enabled)
   {
	   menuItemSave.setEnabled(enabled);
   }
   public void enableItemSaveAs(Boolean enabled)
   {
	   menuItemSaveAs.setEnabled(enabled);
   }
   public void enableItemSaveAll(Boolean enabled)
   {
	   menuItemSaveAll.setEnabled(enabled);
   }
   public void enableItemUndo(Boolean enabled)
   {
	   menuItemUndo.setEnabled(enabled);
   }
   public void enableItemRedo(Boolean enabled)
   {
	   menuItemRedo.setEnabled(enabled);
   }
   public void enableItemPaste(Boolean enabled)
   {
	   menuItemPaste.setEnabled(enabled);
   }
   public void enableItemCopy(Boolean enabled)
   {
	   menuItemCopy.setEnabled(enabled);
   }
   public void enableItemCut(Boolean enabled)
   {
	   menuItemCut.setEnabled(enabled);
   }   
   public void enableItemDelete(Boolean enabled)
   {
	   menuItemDelete.setEnabled(enabled);
   }
   public void enableItemSelect(Boolean enabled)
   {
	   menuItemSelect.setEnabled(enabled);
   }
   public void enableItemSelectAll(Boolean enabled)
   {
	   menuItemSelectAll.setEnabled(enabled);
   }
   public void enableAlgorithmOptions(Boolean enabled)
   {
	   menuAlgorithmOptions.setEnabled(enabled);
   }
   public void enableObjectOptions(Boolean enabled)
   {
	   menuObjectOptions.setEnabled(enabled);
   }
   public void enableItemShowGuidelines(Boolean enabled)
   {
	   menuItemShowGuidelines.setEnabled(enabled);
   }
   public void enableItemZoomIn(Boolean enabled)
   {
	   menuItemZoomIn.setEnabled(enabled);
   }
   
   public void enableItemZoomOut(Boolean enabled)
   {
	   menuItemZoomOut.setEnabled(enabled);
   }   
   public void enableItemDefaultZoom(Boolean enabled)
   {
	   menuItemDefaultZoom.setEnabled(enabled);
   }
   public void registerSettingsClikActionListener(OptionsClickActionListener listener)
   {
	   menuPreferences.addActionListener(listener);
   }
   
   public void registerLanguageListener(LanguageActionListener listener)
   {
	   menuItemLanguage1.addActionListener(listener);
	   menuItemLanguage2.addActionListener(listener);
	   menuItemLanguage3.addActionListener(listener);
   }
   
   public void registerOptionsListener(OptionsClickActionListener listener)
   {
	   menuPreferences.addActionListener(listener);
	   menuAlgorithmOptions.addActionListener(listener);
	   menuObjectOptions.addActionListener(listener);
   }
   
   public void registerMenuBarCommandsListener(ToolbarCommandsListener listener)
   {
	   menuItemNewAlgorithm.setActionCommand("NewAlgorithm");
	   menuItemCopy.setActionCommand("Copy");
	   menuItemCut.setActionCommand("Cut");
	   menuItemDelete.setActionCommand("Delete");
	   menuItemPaste.setActionCommand("Paste");
	   menuItemSave.setActionCommand("Save");
	   menuItemUndo.setActionCommand("Undo");
	   menuItemRedo.setActionCommand("Redo");
	   menuItemZoomIn.setActionCommand("ZoomIn");
	   menuItemZoomOut.setActionCommand("ZoomOut");
	   menuItemDefaultZoom.setActionCommand("ResetZoom");
	   
	   menuItemNewAlgorithm.addActionListener(listener);
	   menuItemCopy.addActionListener(listener);
	   menuItemCut.addActionListener(listener);
	   menuItemDelete.addActionListener(listener);
	   menuItemPaste.addActionListener(listener);
	   menuItemSave.addActionListener(listener);
	   menuItemUndo.addActionListener(listener);
	   menuItemRedo.addActionListener(listener);
	   menuItemZoomIn.addActionListener(listener);
	   menuItemZoomOut.addActionListener(listener);
	   menuItemDefaultZoom.addActionListener(listener);
   }
   public void registerHelpListener(MenuHelpListener listener)
   {
	   menuItemHelpContents.setActionCommand("Help");
	   menuItemAbout.setActionCommand("About");
	   
	   menuItemHelpContents.addActionListener(listener);
	   menuItemAbout.addActionListener(listener);
   }
   
   public void registerOpenProjectListener(OpenProjectActionListener listener)
   {
	   menuItemOpenProject.addActionListener(listener);
   }
   
   public void registerCloseProjectListener(CloseProjectActionListener listener)
   {
	   menuItemClose.addActionListener(listener);
   }
   public void registerCloseAllProjectsListener(CloseAllProjectsListener listener)
	{
		menuItemCloseAll.addActionListener(listener);
	}
   public void registerShowGridlinesActionListener(ToolboxWorkspacePropertiesListener listener)
   {   
	   menuItemShowGuidelines.setActionCommand("Gridlines");
	   
	   menuItemShowGuidelines.addActionListener(listener);   
   }
   
   public void registerSaveAsListener(SaveAsListener listener)
   {
	   menuItemSaveAs.addActionListener(listener);
   }

}