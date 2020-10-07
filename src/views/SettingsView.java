package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import actionListeners.LanguageActionListener;
import actionListeners.ResetPreviewActionListener;
import actionListeners.SetDefaultWorkspaceActionListener;
import actionListeners.SettingsApplyThemeActionListener;
import actionListeners.SettingsCloseActionListener;
import actionListeners.SettingsLanguageActionListener;
import actionListeners.SettingsLayoutActionListener;
import actionListeners.SettingsTreeActionListener;
import actionListeners.WorkspaceDefaultBackColorActionListener;
import actionListeners.WorkspaceDefaultSizeActionListener;
import actionListeners.WorkspaceDefualtGridlinesSpacingActionListener;
import actionListeners.WorkspaceDefulatPropertiesShowGridListener;
import models.SettingsModel;
import utility.ButtonMultiGroup;
import utility.DarkMetalTheme;
import utility.LightMetalTheme;
import utility.Localization;

public class SettingsView extends JDialog implements Subscriber 
{
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTheme=null;
	private JPanel panelTree=null;
	private Border titledBorder=null;
	private Border border = null;
	private Font font=null;
	private JPanel panelLanguage=null;
	private JPanel panelPosition=null;
	private CardLayout cardPanelLayout=null;
	private JPanel card=null;
	private JPanel panelGeneral=null;
	private JPanel panelProject=null;
	private JPanel panelToolbox=null;
	private JPanel panelWorkspace=null;
	
	private WorkspaceDefaultPropertiesView workspacePropertiesView=null;
	private JLabel darkLabel=null;
	private JLabel  lightLabel=null;
	private JComboBox<String> themeList=null;
	private JButton buttonApplyTheme=null;
	private JPanel panelThemeList=null;
	private JPanel panelApplyTheme=null;
	private JPanel panelLanguageList=null;
	private JPanel panelApplyLanguage=null;
	private JLabel labelaLanguage1=null;
	private JLabel labelaLanguage2=null;
	private JLabel labelaLanguage3=null;
	private JComboBox<?> languageList=null;
	private JButton buttonApplyLanguage=null;
	private JTree tree=null;
	private JRadioButton buttonLeftProject=null;
	private JRadioButton buttonRightProject=null;
	private JRadioButton buttonCenterProject=null;
	private JRadioButton buttonLeftWorkspace=null;
	private JRadioButton buttonRightWorkspace=null;
	private JRadioButton buttonCenterWorkspace=null;
	private JRadioButton buttonLeftToolBox=null;
	private JRadioButton buttonRightToolBox=null;
	private JRadioButton buttonCenterToolBox=null;
	private ButtonMultiGroup btnGroup =null;
	private JPanel panelButtonsProject=null;
	private JPanel panelButtonsToolbox=null;
	private JPanel panelButtonsWorkspace=null;
	private JPanel panelButtonApplyLayout=null;
	private JButton buttonApplyLayout=null;
	

	public WorkspaceDefaultPropertiesView getWorkspacePropertiesView() {
			return workspacePropertiesView;
		}

		public void setWorkspacePropertiesView(WorkspaceDefaultPropertiesView workspacePropertiesView) {
			this.workspacePropertiesView = workspacePropertiesView;
		}
	public SettingsView(SettingsModel settingsModel,ApplicationView applicationView) 
	{
			super(applicationView);
		 	DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		 	DefaultMutableTreeNode general = new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.general"));
		 	root.add(general);
		    DefaultMutableTreeNode display= new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.layout"));
		    general.add(display);
		    DefaultMutableTreeNode theme = new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.colortheme"));
		    general.add(theme);
		    DefaultMutableTreeNode language= new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.language"));
		    general.add(language);
		    DefaultMutableTreeNode project = new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.project"));
		    root.add(project);
		    DefaultMutableTreeNode workspace=new DefaultMutableTreeNode(Localization.getInstance().getResources().getString("settings.algorithmoptions"));
		    project.add(workspace);
		    
		    tree = new JTree(root);
		    tree.setRootVisible(false);
		    tree.setShowsRootHandles(true);
		    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		    JScrollPane scrollPane = new JScrollPane(tree);
		    setSize(600, 400);
		    setVisible(true);
		    setTitle(Localization.getInstance().getResources().getString("settings.preferences"));
		    setMinimumSize(new Dimension(300,200));
		    setIconImage(new ImageIcon("icons/gea.png").getImage());
		   panelTree=new JPanel();
		   panelTree.setLayout(new BorderLayout());
		   panelTree.add(scrollPane,BorderLayout.CENTER);
		   panelTree.setPreferredSize(new Dimension(200,400));
		   add(panelTree,BorderLayout.WEST);
		   border = BorderFactory.createLineBorder(Color.GRAY, 1, true);
		   font = new Font("Arial", Font.ITALIC, 12);
		   
		   panelTheme=new JPanel();
		   //String[] stringStyle={"Dark Theme","Light Theme"};
		   //String[] stringStyle1={"Light Theme","Dark Light"};
		   darkLabel=new JLabel("Dark Theme");
		   lightLabel= new JLabel("Light Theme");
		   darkLabel.setVisible(true);
		   lightLabel.setVisible(true);
		   
		   themeList = new JComboBox<String>();
		   themeList.addItem(darkLabel.getText());
		   themeList.addItem(lightLabel.getText());
		   
		   
			if(settingsModel.getModelMediator().getTheme() instanceof DarkMetalTheme)
			{
				
				 themeList.setSelectedItem(darkLabel.getText());
			}
			else if(settingsModel.getModelMediator().getTheme() instanceof LightMetalTheme)
			{
				
				themeList.setSelectedItem(lightLabel.getText());
			}
		   
		
		   
		   
		   buttonApplyTheme=new JButton("Apply Theme");
		   panelTheme.setLayout(new BorderLayout());
		   panelThemeList=new JPanel();
		   panelApplyTheme=new JPanel();
		   panelThemeList.add(themeList);
		   panelApplyTheme.add(buttonApplyTheme);
		   panelTheme.add(panelThemeList,BorderLayout.CENTER);
		   panelTheme.add(panelApplyTheme,BorderLayout.SOUTH);
		   
		   panelLanguage=new JPanel();
		   String[] stringLanguage={"English","Srpski latinica","Српски ћирилица"};
		   languageList = new JComboBox<Object>(stringLanguage);
		   labelaLanguage1=new JLabel("English");
		   labelaLanguage2=new JLabel("Srpski latinica");
		   labelaLanguage3=new JLabel("Српски ћирилица");

		   
		   languageList.add(labelaLanguage1);
		   languageList.add(labelaLanguage2);
		   languageList.add(labelaLanguage3);
		   panelLanguage.setLayout(new BorderLayout());
		   panelLanguageList=new JPanel();
		   panelApplyLanguage=new JPanel();
		   panelLanguageList.add(languageList);
		   
		   buttonApplyLanguage=new JButton("Apply Language");
		   panelApplyLanguage.add(buttonApplyLanguage);
		   panelLanguage.add(panelLanguageList,BorderLayout.CENTER);
		   panelLanguage.add(panelApplyLanguage,BorderLayout.SOUTH);
		   
		   panelPosition=new JPanel();
		   panelPosition.setLayout(new GridLayout(8,1));
		  
		   JLabel labelaProjcetB=new JLabel("Position Project Browser:");
		   JLabel labelaToolBox=new JLabel("Position ToolBox:");
		   JLabel labelaWorkspace=new JLabel("Posotion Workspace:");
		   
		   btnGroup = new ButtonMultiGroup();
		   btnGroup.createGroup();
	
		   buttonLeftProject=new JRadioButton("Left");
		   buttonLeftProject.setActionCommand("Left Project");
		   btnGroup.addButtonToLastGroup(buttonLeftProject);
		   
		   buttonCenterProject=new JRadioButton("Center");
		   buttonCenterProject.setActionCommand("Center Project");
		   btnGroup.addButtonToLastGroup(buttonCenterProject);
		   
		   buttonRightProject=new JRadioButton("Right");
		   buttonRightProject.setActionCommand("Right Project");
		   btnGroup.addButtonToLastGroup(buttonRightProject);
		   
		   
		   
		   btnGroup.createGroup();
		   
		   buttonLeftWorkspace=new JRadioButton("Left");
		   buttonLeftWorkspace.setActionCommand("Left Workspace");
		   btnGroup.addButtonToLastGroup(buttonLeftWorkspace);
		   
		   buttonCenterWorkspace=new JRadioButton("Center");
		   buttonCenterWorkspace.setActionCommand("Center Workspace");
		   btnGroup.addButtonToLastGroup(buttonCenterWorkspace);
		   
		   buttonRightWorkspace=new JRadioButton("Right");
		   buttonRightWorkspace.setActionCommand("Right Workspace");
		   btnGroup.addButtonToLastGroup(buttonRightWorkspace);
		   
		
		      
		   btnGroup.createGroup();
		   
		   buttonLeftToolBox=new JRadioButton("Left");
		   buttonLeftToolBox.setActionCommand("Left ToolBox");
		   btnGroup.addButtonToLastGroup(buttonLeftToolBox);
		   
		   buttonCenterToolBox=new JRadioButton("Center");
		   buttonCenterToolBox.setActionCommand("Center ToolBox");
		   btnGroup.addButtonToLastGroup(buttonCenterToolBox); 
		   
		   buttonRightToolBox=new JRadioButton("Right");
		   buttonRightToolBox.setActionCommand("Right ToolBox");
		   btnGroup.addButtonToLastGroup(buttonRightToolBox);
		   
		   

		   panelPosition.setLayout(new GridLayout(4,1));
		   
		   panelProject=new JPanel();
		   panelProject.setLayout(new BorderLayout());
		   panelProject.add(labelaProjcetB,BorderLayout.NORTH);
		   panelButtonsProject=new JPanel();
		   panelButtonsProject.setLayout(new FlowLayout());
		   panelButtonsProject.add(buttonLeftProject);
		   panelButtonsProject.add(buttonCenterProject);
		   panelButtonsProject.add(buttonRightProject);
		   panelProject.add(panelButtonsProject,BorderLayout.CENTER);
		   
		   panelToolbox=new JPanel();
		   panelToolbox.setLayout(new BorderLayout());
		   panelToolbox.add(labelaToolBox,BorderLayout.NORTH);
		   panelButtonsToolbox=new JPanel();
		   panelButtonsToolbox.setLayout(new FlowLayout());
		   panelButtonsToolbox.add(buttonLeftToolBox);
		   panelButtonsToolbox.add(buttonCenterToolBox);
		   panelButtonsToolbox.add(buttonRightToolBox);
		   panelToolbox.add(panelButtonsToolbox,BorderLayout.CENTER);
		   
		   panelWorkspace=new JPanel();
		   panelWorkspace.setLayout(new BorderLayout());
		   panelWorkspace.add(labelaWorkspace,BorderLayout.NORTH);
		   panelButtonsWorkspace=new JPanel();
		   panelButtonsWorkspace.setLayout(new FlowLayout());
		   panelButtonsWorkspace.add(buttonLeftWorkspace);
		   panelButtonsWorkspace.add(buttonCenterWorkspace);
		   panelButtonsWorkspace.add(buttonRightWorkspace);
		   panelWorkspace.add(panelButtonsWorkspace,BorderLayout.CENTER);
		   
		   buttonApplyLayout=new JButton("Apply Layout");
		   panelButtonApplyLayout=new JPanel();
		   panelButtonApplyLayout.setLayout(new FlowLayout());
		   panelButtonApplyLayout.add(buttonApplyLayout);
		
		   panelPosition.add(panelProject);
		   panelPosition.add(panelWorkspace);
		   panelPosition.add(panelToolbox);
		   panelPosition.add(panelButtonApplyLayout);
		   workspacePropertiesView = new WorkspaceDefaultPropertiesView(settingsModel.getWorkspacePreviewModel(), settingsModel.getWorkspaceDefaultModel());
		   JScrollPane scrollPanePosition = new JScrollPane(panelPosition);
		   JScrollPane scrollPaneTheme = new JScrollPane(panelTheme);
		   JScrollPane scrollPaneLanguage = new JScrollPane(panelLanguage);
		   JScrollPane scrollPanelAlgorithmOptions = new JScrollPane(workspacePropertiesView);
 
		   panelGeneral=new JPanel();
		   
		    card=new JPanel();
		   cardPanelLayout=new CardLayout();
		   card.setLayout(cardPanelLayout);
		   card.add(panelGeneral,"1");
		   card.add(scrollPanePosition,"2");
		   card.add(scrollPaneTheme,"3");
		   card.add(scrollPaneLanguage,"4");
		   card.add(scrollPanelAlgorithmOptions,"5");
		   
		   cardPanelLayout.show(card,"1");
		   add(card,BorderLayout.CENTER);
		   revalidate();
	}

	public void registerWorkspaceShowGridListener(WorkspaceDefulatPropertiesShowGridListener listener)
	{
		workspacePropertiesView.getShowGridlines().addActionListener(listener);
	}
	public void registerResetPreviewActionListener(ResetPreviewActionListener listener)
	{
		workspacePropertiesView.getButtonReset().addActionListener(listener);
	}
	public void registerSettingsTreeActionListener(SettingsTreeActionListener listener)
	{
		   tree.addTreeSelectionListener(listener);
	}
	public void registerWorkspaceDefaultBackColorActionListener(WorkspaceDefaultBackColorActionListener listener)
	{
		workspacePropertiesView.getButtonBackColor().addActionListener(listener);
	}
	public void registerWorkspaceDefaultGridlinesSpacingActionListener(WorkspaceDefualtGridlinesSpacingActionListener listener)
	{
		workspacePropertiesView.getTextGridlinesSpacing().addActionListener(listener);
	}
	public void registerWorkspaceDefaultSizeActionListener(WorkspaceDefaultSizeActionListener listener)
	{
		workspacePropertiesView.getTextHeightSize().addActionListener(listener);
		workspacePropertiesView.getTextWidhtSize().addActionListener(listener);
	}
	public void registerSettingsLanguageActionListener(SettingsLanguageActionListener listener)
	{
		languageList.addActionListener(listener);
	}
	public void registerApplyLanguageActionListener(LanguageActionListener listener)
	{
		buttonApplyLanguage.addActionListener(listener);
	}
	public void registerSettingsCloseActionListener(SettingsCloseActionListener listener)
	{
		buttonApplyLanguage.addActionListener(listener);
		buttonApplyTheme.addActionListener(listener);
	}
	public void registerSettingsApplyThemeActionListener(SettingsApplyThemeActionListener listener)
	{
		buttonApplyTheme.addActionListener(listener);
	}
	public void registerSettingsLayoutActionListener(SettingsLayoutActionListener listener)
	{
		buttonApplyLayout.addActionListener(listener);
	}
	public void registerSetDefualtWorkspaceActionListener(SetDefaultWorkspaceActionListener listener)
	{
		workspacePropertiesView.getButtonApply().addActionListener(listener);
	}
	public JButton getButtonApplyTheme() {
		return buttonApplyTheme;
	}

	public void setButtonApplyTheme(JButton buttonApplyTheme) {
		this.buttonApplyTheme = buttonApplyTheme;
	}

	public JComboBox<String> getThemeList() {
		return themeList;
	}

	public void setThemeList(JComboBox<String> themeList) {
		this.themeList = themeList;
	}

	public JButton getButtonApplyLanguage() {
		return buttonApplyLanguage;
	}

	public void setButtonApplyLanguage(JButton buttonApplyLanguage) {
		this.buttonApplyLanguage = buttonApplyLanguage;
	}

	public JComboBox<?> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(JComboBox<?> languageList) {
		this.languageList = languageList;
	}

	public JRadioButton getButtonLeftProject() {
		return buttonLeftProject;
	}

	public void setButtonLeftProject(JRadioButton buttonLeftProject) {
		this.buttonLeftProject = buttonLeftProject;
	}

	public JRadioButton getButtonRightProject() {
		return buttonRightProject;
	}

	public void setButtonRightProject(JRadioButton buttonRightProject) {
		this.buttonRightProject = buttonRightProject;
	}

	public JRadioButton getButtonCenterProject() {
		return buttonCenterProject;
	}

	public void setButtonCenterProject(JRadioButton buttonCenterProject) {
		this.buttonCenterProject = buttonCenterProject;
	}

	public JRadioButton getButtonLeftWorkspace() {
		return buttonLeftWorkspace;
	}

	public void setButtonLeftWorkspace(JRadioButton buttonLeftWorkspace) {
		this.buttonLeftWorkspace = buttonLeftWorkspace;
	}

	public JRadioButton getButtonRightWorkspace() {
		return buttonRightWorkspace;
	}

	public void setButtonRightWorkspace(JRadioButton buttonRightWorkspace) {
		this.buttonRightWorkspace = buttonRightWorkspace;
	}

	public JRadioButton getButtonCenterWorkspace() {
		return buttonCenterWorkspace;
	}

	public void setButtonCenterWorkspace(JRadioButton buttonCenterWorkspace) {
		this.buttonCenterWorkspace = buttonCenterWorkspace;
	}

	public JRadioButton getButtonLeftToolBox() {
		return buttonLeftToolBox;
	}

	public void setButtonLeftToolBox(JRadioButton buttonLeftToolBox) {
		this.buttonLeftToolBox = buttonLeftToolBox;
	}

	public JRadioButton getButtonRightToolBox() {
		return buttonRightToolBox;
	}

	public void setButtonRightToolBox(JRadioButton buttonRightToolBox) {
		this.buttonRightToolBox = buttonRightToolBox;
	}

	public JRadioButton getButtonCenterToolBox() {
		return buttonCenterToolBox;
	}

	public void setButtonCenterToolBox(JRadioButton buttonCenterToolBox) {
		this.buttonCenterToolBox = buttonCenterToolBox;
	}
	 public JButton getButtonApplyLayout() {
		return buttonApplyLayout;
	}

	public void setButtonApplyLayout(JButton buttonApplyLayout) {
		this.buttonApplyLayout = buttonApplyLayout;
	}
	

	public ButtonMultiGroup getBtnGroup() {
		return btnGroup;
	}

	public void setBtnGroup(ButtonMultiGroup btnGroup) {
		this.btnGroup = btnGroup;
	}

	public void displayCards(){
		 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                 tree.getLastSelectedPathComponent();
		 Object nodeInfo = node.getUserObject();
		 if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.layout")))
		 {
			 titledBorder = BorderFactory.createTitledBorder(border, Localization.getInstance().getResources().getString("settings.layout"), TitledBorder.CENTER, TitledBorder.TOP, font, Color.BLACK);
			 panelPosition.setBorder(titledBorder);
			 cardPanelLayout.show(card, "2");
		 }
		 else if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.colortheme")))
		 {
			 titledBorder = BorderFactory.createTitledBorder(border, Localization.getInstance().getResources().getString("settings.colortheme"), TitledBorder.CENTER, TitledBorder.TOP, font, Color.BLACK);
			 panelTheme.setBorder(titledBorder);
			 cardPanelLayout.show(card, "3");
		 }
		 else if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.language")))
		 {
			 titledBorder = BorderFactory.createTitledBorder(border, Localization.getInstance().getResources().getString("settings.language"), TitledBorder.CENTER, TitledBorder.TOP, font, Color.BLACK);
			 panelLanguage.setBorder(titledBorder);
			 cardPanelLayout.show(card, "4");
		 }
		 else if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.project")))
		 {
			 cardPanelLayout.show(card, "1");
		 }
		 else if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.general")))
		 {
			 cardPanelLayout.show(card, "1");
		 }
		 else if(nodeInfo.equals(Localization.getInstance().getResources().getString("settings.algorithmoptions")))
		 {
			 cardPanelLayout.show(card, "5");
		 }
		
	}
	@Override
	public void update() {
		
	
	
		revalidate();
		this.repaint();
	}
	}
