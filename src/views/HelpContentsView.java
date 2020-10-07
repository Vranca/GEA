package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import utility.Localization;

public class HelpContentsView extends JDialog
{
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTree = null;
	private JPanel panelCard = null;
	
	
	public HelpContentsView()
	{
		// TODO Auto-generated constructor stub
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
	 	DefaultMutableTreeNode createNewProject = new DefaultMutableTreeNode(Localization.getLocalString("treenode.createnewproject"));
	 	DefaultMutableTreeNode createNewAlgorithm = new DefaultMutableTreeNode(Localization.getLocalString("treenode.createnewalgorithm"));
	 	DefaultMutableTreeNode addElements = new DefaultMutableTreeNode(Localization.getLocalString("treenode.addingelements"));
	 	DefaultMutableTreeNode elementProperties = new DefaultMutableTreeNode(Localization.getLocalString("treenode.elementproperties"));
	 	DefaultMutableTreeNode workspaceProperties = new DefaultMutableTreeNode(Localization.getLocalString("treenode.workspaceproperties"));
	 	DefaultMutableTreeNode languageOptions = new DefaultMutableTreeNode(Localization.getLocalString("treenode.language"));
	 	DefaultMutableTreeNode applicationProperties = new DefaultMutableTreeNode(Localization.getLocalString("treenode.appproperties"));
	 	
	 	root.add(createNewProject);
	 	root.add(createNewAlgorithm);
	 	root.add(addElements);
	 	root.add(elementProperties);
	 	root.add(workspaceProperties);
	 	root.add(languageOptions);
	 	root.add(applicationProperties);
	 	
	 	setIconImage(new ImageIcon("icons/gea.png").getImage());    
	 	
	 	JTree tree = new JTree(root);
	    tree.setRootVisible(false);
	    tree.setShowsRootHandles(true);
	    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	    
	    JScrollPane scrollPane = new JScrollPane(tree);
	    setSize(860, 640);
	    setVisible(true);
	    setTitle(Localization.getLocalString("helpcontents.title"));
	    setMinimumSize(new Dimension(300,200));
	    
	    panelTree=new JPanel();
		panelTree.setLayout(new BorderLayout());
		panelTree.add(scrollPane,BorderLayout.CENTER);
		panelTree.setPreferredSize(new Dimension(200,400));
		add(panelTree,BorderLayout.WEST);
		   
		CardLayout cardLayout = new CardLayout();
		panelCard = new JPanel();
		panelCard.setLayout(cardLayout);
		
		// beginNewProject
		GridLayout gridLayout = new GridLayout(2,1);
		
		JPanel panelGrid = new JPanel();
		panelGrid.setLayout(gridLayout);
		
		JLabel labelIconNewProject = new JLabel(new ImageIcon("icons/newProject.png"));
		JLabel labelIconSelectProjectName = new JLabel(new ImageIcon("icons/SelectProjectName.png"));
		
		JPanel panelBorder = new JPanel();
		panelBorder.setLayout(new BorderLayout());

		JScrollPane scrollPaneCreateNewProject = new JScrollPane(panelGrid);
		
		JTextArea textNewProject = new JTextArea(Localization.getLocalString("helpcontents.createnewproject"));
		textNewProject.setOpaque(false);
		textNewProject.setBorder(BorderFactory.createEmptyBorder(4, 0, 10, 0));
		labelIconNewProject.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorder.add(labelIconNewProject, BorderLayout.SOUTH);
		panelBorder.add(textNewProject, BorderLayout.CENTER);
		
		
		
		JPanel panelBorderSelectProjectName = new JPanel();
		panelBorderSelectProjectName.setLayout(new BorderLayout());
		
		JTextArea textSelectProjectName = new JTextArea(Localization.getLocalString("helpcontents.selectprojectname"));
		textSelectProjectName.setOpaque(false);
		textSelectProjectName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		labelIconSelectProjectName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorderSelectProjectName.add(labelIconSelectProjectName, BorderLayout.SOUTH);
		panelBorderSelectProjectName.add(textSelectProjectName, BorderLayout.CENTER);
		
		
		
		panelGrid.add(panelBorder);
		panelGrid.add(panelBorderSelectProjectName);
		
		
		
		// endNewProject
		
		//beginNewAlgorithm
		GridLayout gridLayoutNewAlgorithm = new GridLayout(3,1);
		
		JPanel panelGridNewAlgorithm = new JPanel();
		panelGridNewAlgorithm.setLayout(gridLayoutNewAlgorithm);
		
		JLabel labelIconNewAlgorithm = new JLabel(new ImageIcon("icons/newAlgorithm.png"));
		JLabel labelIconSelectAlgorithmName = new JLabel(new ImageIcon("icons/SelectAlgorithmName.png"));
		JLabel labelIconAlgorithmCreated = new JLabel(new ImageIcon("icons/AlgorithmCreated.png"));
		
		JPanel panelBorderNewAlgorithm = new JPanel();
		panelBorderNewAlgorithm.setLayout(new BorderLayout());
		
		JScrollPane scrollPaneNewAlgorithm = new JScrollPane(panelGridNewAlgorithm);
		
		JTextArea textNewAlgorithm = new JTextArea(Localization.getLocalString("helpcontents.createnewalgorithm"));
		textNewAlgorithm.setOpaque(false);
		textNewAlgorithm.setBorder(BorderFactory.createEmptyBorder(4, 0, 10, 0));
		labelIconNewAlgorithm.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorderNewAlgorithm.add(labelIconNewAlgorithm, BorderLayout.SOUTH);
		panelBorderNewAlgorithm.add(textNewAlgorithm, BorderLayout.CENTER);
		
		
		
		JPanel panelBorderSelectAlgorithmName = new JPanel();
		panelBorderSelectAlgorithmName.setLayout(new BorderLayout());
		
		JTextArea textSelectAlgorithmName = new JTextArea(Localization.getLocalString("helpcontents.selectalgorithmname"));
		textSelectAlgorithmName.setOpaque(false);
		textSelectAlgorithmName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		labelIconSelectAlgorithmName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorderSelectAlgorithmName.add(labelIconSelectAlgorithmName, BorderLayout.SOUTH);
		panelBorderSelectAlgorithmName.add(textSelectAlgorithmName, BorderLayout.CENTER);
		
		JTextArea textAlgorithmCreated = new JTextArea(Localization.getLocalString("helpcontents.algorithmcreated"));
		textAlgorithmCreated.setOpaque(false);
		textAlgorithmCreated.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		labelIconAlgorithmCreated.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JPanel panelBorderAlgorithmCreated = new JPanel();
		panelBorderAlgorithmCreated.setLayout(new BorderLayout());
		
		panelBorderAlgorithmCreated.add(labelIconAlgorithmCreated, BorderLayout.SOUTH);
		panelBorderAlgorithmCreated.add(textAlgorithmCreated, BorderLayout.CENTER);
		
		panelGridNewAlgorithm.add(panelBorderNewAlgorithm);
		panelGridNewAlgorithm.add(panelBorderSelectAlgorithmName);
		panelGridNewAlgorithm.add(panelBorderAlgorithmCreated);
		
		// endNewAlgorithm
		
		// beginToolbox
		
		GridLayout gridLayoutAddingElements = new GridLayout(2,1);
		
		JPanel panelGridAddElement = new JPanel();
		panelGridAddElement.setLayout(gridLayoutAddingElements);
		
		JLabel labelIconAddElement = new JLabel(new ImageIcon("icons/AddElement.png"));
		JLabel labelIconElementAdded = new JLabel(new ImageIcon("icons/ElementAdded.png"));
		
		JPanel panelBorderAddElement = new JPanel();
		panelBorderAddElement.setLayout(new BorderLayout());
		
		JPanel panelBorderElementAdded = new JPanel();
		panelBorderElementAdded.setLayout(new BorderLayout());
		
		JTextArea textElementAdded = new JTextArea(Localization.getLocalString("helpcontents.elementadded"));
		textElementAdded.setOpaque(false);
		textElementAdded.setBorder(BorderFactory.createEmptyBorder(10, 0 ,10 ,0));
		labelIconElementAdded.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JScrollPane scrollPaneAddElement = new JScrollPane(panelGridAddElement);
		
		JTextArea textAddElement = new JTextArea(Localization.getLocalString("helpcontents.addingelement"));
		textAddElement.setOpaque(false);
		textAddElement.setBorder(BorderFactory.createEmptyBorder(4, 0, 10, 0));
		labelIconAddElement.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorderAddElement.add(labelIconAddElement, BorderLayout.SOUTH);
		panelBorderAddElement.add(textAddElement, BorderLayout.CENTER);
		
		panelBorderElementAdded.add(labelIconElementAdded, BorderLayout.SOUTH);
		panelBorderElementAdded.add(textElementAdded, BorderLayout.CENTER);
		
		panelGridAddElement.add(panelBorderAddElement);
		panelGridAddElement.add(panelBorderElementAdded);
		
		
		// endToolbox
		
		// beginElementProperties
		
		GridLayout gridLayoutElementProperties = new GridLayout(3,1);
		
		JPanel panelGridElementProperties = new JPanel();
		panelGridElementProperties.setLayout(gridLayoutElementProperties);
		
		JLabel labelIconElementProperties = new JLabel(new ImageIcon("icons/ElementProperties.png"));
		JLabel labelIconElementPropertiesPreview = new JLabel(new ImageIcon("icons/ElementPropertiesPreview.png"));
		JLabel labelIconElementPropertiesApplied = new JLabel(new ImageIcon("icons/ElementPropertiesApplied.png"));
		
		JPanel panelBorderElementProperties = new JPanel();
		panelBorderElementProperties.setLayout(new BorderLayout());
		
		JPanel panelBorderElementPropertiesPreview = new JPanel();
		panelBorderElementPropertiesPreview.setLayout(new BorderLayout());
		
		JPanel panelBorderElementPropertiesApplied = new JPanel();
		panelBorderElementPropertiesApplied.setLayout(new BorderLayout());
		
		JTextArea textElementProperties = new JTextArea(Localization.getLocalString("helpcontents.selectelement"));
		JTextArea textElementPropertiesPreview = new JTextArea(Localization.getLocalString("helpcontents.previewelement"));
		JTextArea textElementPropertiesApplied = new JTextArea(Localization.getLocalString("helpcontents.applyelement"));
		
		JScrollPane scrollPaneElementProperties = new JScrollPane(panelGridElementProperties);
		
		textElementProperties.setOpaque(false);
		textElementProperties.setBorder(BorderFactory.createEmptyBorder(4,0,10,0));
		labelIconElementProperties.setBorder(BorderFactory.createLoweredBevelBorder());
		
		textElementPropertiesPreview.setOpaque(false);
		textElementPropertiesPreview.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		labelIconElementPropertiesPreview.setBorder(BorderFactory.createLoweredBevelBorder());
		
		textElementPropertiesApplied.setOpaque(false);
		textElementPropertiesApplied.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		labelIconElementPropertiesApplied.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelBorderElementProperties.add(labelIconElementProperties, BorderLayout.SOUTH);
		panelBorderElementProperties.add(textElementProperties, BorderLayout.CENTER);
		
		panelBorderElementPropertiesPreview.add(labelIconElementPropertiesPreview, BorderLayout.SOUTH);
		panelBorderElementPropertiesPreview.add(textElementPropertiesPreview, BorderLayout.CENTER);
		
		panelBorderElementPropertiesApplied.add(labelIconElementPropertiesApplied, BorderLayout.SOUTH);
		panelBorderElementPropertiesApplied.add(textElementPropertiesApplied, BorderLayout.CENTER);
		
		
		panelGridElementProperties.add(panelBorderElementProperties);
		panelGridElementProperties.add(panelBorderElementPropertiesPreview);
		panelGridElementProperties.add(panelBorderElementPropertiesApplied);
		// end ElementProperties
		
		// beginLanguageOptions
		
		GridLayout gridLayoutLanguageOptions = new GridLayout(2,1);
		
		JPanel panelGridLanguageOptions = new JPanel();
		panelGridLanguageOptions.setLayout(gridLayoutLanguageOptions);
		
		JLabel labelIconLanguageOptions = new JLabel(new ImageIcon("icons/LanguageOptions.png"));
		
		JPanel panelBorderLanguageOptions = new JPanel();
		panelBorderLanguageOptions.setLayout(new BorderLayout());
		
		
		JTextArea textLanguageOptions = new JTextArea(Localization.getLocalString("helpcontents.languageoption"));
		textLanguageOptions.setOpaque(false);
		textLanguageOptions.setBorder(BorderFactory.createEmptyBorder(10, 0 ,10 ,0));
		labelIconLanguageOptions.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JScrollPane scrollPaneLanguageOptions = new JScrollPane(panelGridLanguageOptions);
		
		
		panelBorderLanguageOptions.add(labelIconLanguageOptions, BorderLayout.SOUTH);
		panelBorderLanguageOptions.add(textLanguageOptions, BorderLayout.CENTER);
		
		
		panelGridLanguageOptions.add(panelBorderLanguageOptions);
		
		
		
		// endLanguageOptions
		
		// beginApplicationPreferences
		
		GridLayout gridLayoutApplicationPreferences = new GridLayout(2,1);
				
		JPanel panelGridApplicationPreferences = new JPanel();
		panelGridApplicationPreferences.setLayout(gridLayoutApplicationPreferences);
				
		JLabel labelIconApplicationPreferences = new JLabel(new ImageIcon("icons/ApplicationPreferences.png"));
				
		JPanel panelBorderApplicationPreferences = new JPanel();
		panelBorderApplicationPreferences.setLayout(new BorderLayout());
				
				
		JTextArea textApplicationPreferences = new JTextArea(Localization.getLocalString("helpcontents.preferences"));
		textApplicationPreferences.setOpaque(false);
		textApplicationPreferences.setBorder(BorderFactory.createEmptyBorder(10, 0 ,10 ,0));
		labelIconApplicationPreferences.setBorder(BorderFactory.createLoweredBevelBorder());
				
		JScrollPane scrollPaneApplicationPreferences = new JScrollPane(panelGridApplicationPreferences);
				
				
		panelBorderApplicationPreferences.add(labelIconApplicationPreferences, BorderLayout.SOUTH);
		panelBorderApplicationPreferences.add(textApplicationPreferences, BorderLayout.CENTER);
				
				
		panelGridApplicationPreferences.add(panelBorderApplicationPreferences);
				
				
				
		// endLanguageOptions
		
		// beginWorkspace
		
		GridLayout gridLayoutWorkspace = new GridLayout(2,1);
		
		JPanel panelGridWorkspace = new JPanel();
		panelGridWorkspace.setLayout(gridLayoutWorkspace);
		
		JLabel labelIconWorkspace = new JLabel(new ImageIcon("icons/Workspace.png"));
		JLabel labelIconWorkspacePreview = new JLabel(new ImageIcon("icons/WorkspacePreview.png"));
		
		
		JPanel panelBorderWorkspace = new JPanel();
		panelBorderWorkspace.setLayout(new BorderLayout());
		
		JPanel panelBorderWorkspacePreview = new JPanel();
		panelBorderWorkspacePreview.setLayout(new BorderLayout());
		
		JTextArea textWorkspace = new JTextArea(Localization.getLocalString("helpcontents.applyworkspace"));
		JTextArea textWorkspacePreview = new JTextArea(Localization.getLocalString("helpcontents.previewworkspace"));
		
		
		JScrollPane scrollPaneWorkspace = new JScrollPane(panelGridWorkspace);
		
		textWorkspace.setOpaque(false);
		textWorkspace.setBorder(BorderFactory.createEmptyBorder(4,0,10,0));
		labelIconWorkspace.setBorder(BorderFactory.createLoweredBevelBorder());
		
		textWorkspacePreview.setOpaque(false);
		textWorkspacePreview.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		labelIconWorkspacePreview.setBorder(BorderFactory.createLoweredBevelBorder());
		
		
		
		panelBorderWorkspace.add(labelIconWorkspace, BorderLayout.SOUTH);
		panelBorderWorkspace.add(textWorkspace, BorderLayout.CENTER);
		
		panelBorderWorkspacePreview.add(labelIconWorkspacePreview, BorderLayout.SOUTH);
		panelBorderWorkspacePreview.add(textWorkspacePreview, BorderLayout.CENTER);
		
		
		
		panelGridWorkspace.add(panelBorderWorkspace);
		panelGridWorkspace.add(panelBorderWorkspacePreview);
		
		
		// endWorkspace
				
		
		panelCard.add(scrollPaneCreateNewProject, "1");
		panelCard.add(scrollPaneNewAlgorithm, "2");
		panelCard.add(scrollPaneAddElement, "3");
		panelCard.add(scrollPaneElementProperties, "4");
		panelCard.add(scrollPaneWorkspace, "5");
		panelCard.add(scrollPaneLanguageOptions, "6");
		panelCard.add(scrollPaneApplicationPreferences, "7");
		
		
		
		
		   tree.addTreeSelectionListener(new TreeSelectionListener() {
				
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				 DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                      tree.getLastSelectedPathComponent();
				 Object nodeInfo = node.getUserObject();
				 if(nodeInfo== (Localization.getLocalString("treenode.createnewproject")))
				 {
					 
					 cardLayout.show(panelCard, "1");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.createnewalgorithm")))
				 {
					 cardLayout.show(panelCard, "2");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.addingelements")))
				 {
					 cardLayout.show(panelCard, "3");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.elementproperties")))
				 {
					 cardLayout.show(panelCard, "4");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.workspaceproperties")))
				 {
					 cardLayout.show(panelCard, "5");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.language")))
				 {
					 cardLayout.show(panelCard, "6");
				 }
				 else if (nodeInfo == (Localization.getLocalString("treenode.appproperties")))
				 {
					 cardLayout.show(panelCard, "7");
				 }
			}
		});
		   
		   add(panelCard, BorderLayout.CENTER);
	}
}
