/***********************************************************************
 * Module:  ProjectBrowserView.java
 * Author:  User
 * Purpose: Defines the Class ProjectBrowserView
 ***********************************************************************/

package views;

import models.Project;
import models.ProjectBrowserModel;
import models.WorkspaceModel;
import utility.Localization;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

public class ProjectBrowserView extends JPanel implements Subscriber, DraggableContent
{
   private static final long serialVersionUID  =   1L;
   
   protected ProjectBrowserModel model         = null;
   
   private JPanel titlePanel                   = null;
   private JLabel titleLabel                   = null;
   private DefaultMutableTreeNode openProjects = null;
   private JTree tree                          = null;
   DefaultTreeModel treeModel                  = null;
   JScrollPane scrollPane = null;

   /** @param model */
   public ProjectBrowserView(ProjectBrowserModel model) 
   {
      this.model = model;
      
      setLayout(new BorderLayout());      
      setPreferredSize(new Dimension(200, 800));
      setMinimumSize(new Dimension(200, 800));
      setMaximumSize(new Dimension(200, 1000));

      setBorder(BorderFactory.createRaisedBevelBorder());
      setBackground(model.getTheme().getWindowBackground());
 
      titlePanel = new JPanel();
      titlePanel.setLayout(new BorderLayout());
      titlePanel.setSize(0,30);
      titlePanel.setBackground(model.getTheme().getWindowTitleBackground());
      titlePanel.setBorder(BorderFactory.createRaisedBevelBorder());
      
      titleLabel = new JLabel(model.getLocalString("projectbrowser"));
      titleLabel.setForeground(model.getTheme().getWindowTitleForeground());
      titleLabel.setBorder(new EmptyBorder(0,0,0,50));
      titlePanel.add(titleLabel, BorderLayout.WEST);
      

      
      openProjects = new DefaultMutableTreeNode("Open projects");
      treeModel = new DefaultTreeModel(openProjects, true);
      
      
      tree = new JTree(openProjects, true);
      tree.setModel(treeModel);
      tree.setRootVisible(false);
      tree.setEditable(true);
      
      scrollPane = new JScrollPane(tree);
      scrollPane.setPreferredSize(this.getSize());
      
      add(titlePanel, BorderLayout.NORTH);
      
      add(scrollPane, BorderLayout.CENTER); 
      
      Localization.getInstance().addSubscribers(this);
   }

   public final ProjectBrowserModel getModel() 
   {
	   return model;
   }

   @Override
   public void addDragListener(DragListener dragListener) 
   {
	   addMouseListener(dragListener);
	   addMouseMotionListener(dragListener);
	   
	   titlePanel.addMouseListener(dragListener);
	   titlePanel.addMouseMotionListener(dragListener);
	   
	   titleLabel.addMouseListener(dragListener);
	   titleLabel.addMouseMotionListener(dragListener);
	
   }
   
   public void addProject(String projectName)
   {	
	   Boolean projectExists = false;
	   DefaultMutableTreeNode project = new DefaultMutableTreeNode(projectName);
	    
	   for ( int i = 0; i < openProjects.getChildCount(); i++)
	   {
	   		if ( (openProjects.getChildAt(i).toString() == projectName) && (openProjects.getChildAt(i).getAllowsChildren()) )
	   			projectExists = true;
	   }
	   
	   if ( !projectExists )
	   {
		   treeModel.insertNodeInto(project, openProjects, openProjects.getChildCount());
		   tree.setSelectionPath(new TreePath(project));
	   }
   }
      
   public void addAlgorithmToProject(String algorithmName, String projectName)
   {
	   DefaultMutableTreeNode algorithmNode = new DefaultMutableTreeNode(algorithmName, false);
	   
	   for ( int i = 0; i < openProjects.getChildCount(); i++)
	   {
		   if ( (projectName.equals(openProjects.getChildAt(i).toString())) && (openProjects.getChildAt(i).getAllowsChildren()) )
		   {
			   Boolean algorithmExists = false;
			   DefaultMutableTreeNode projectNode = (DefaultMutableTreeNode)openProjects.getChildAt(i);
			   
			   for ( int j = 0; j < projectNode.getChildCount(); j++ )
			   {
				   if ( projectNode.getChildAt(j).toString() == algorithmName )
					   algorithmExists = true;
			   }
			   
			   if ( !algorithmExists )
			   {
				   treeModel.insertNodeInto(algorithmNode, projectNode, projectNode.getChildCount());
				   tree.scrollPathToVisible(new TreePath(algorithmNode.getPath()));
			   }
			   break;
		   }
			   
	   }
   }
   
   public JTree getTree() {
	return tree;
}

   public void setTree(JTree tree) {
	   this.tree = tree;
   }
   public void registerTreeSelectionListener(MouseListener listener)
   {
	  tree.addMouseListener(listener);
   }
   public void registerTreeModelListener(TreeModelListener listener)
   {
	  treeModel.addTreeModelListener(listener);
   }
   
   public void update()
   {
	   if(model.getRemovedNode() != null)
	   {
		   if(model.getRemovedNode().getParent() != null)
			   treeModel.removeNodeFromParent(model.getRemovedNode());
		   else
		   {
			   model.getRemovedNode().setParent((MutableTreeNode) treeModel.getRoot());
			   DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
			   root.remove(model.getRemovedNode());
			   treeModel.reload();
			   
		   }
	   }
	   for ( Project project : model.getOpenProjects() )
	   {
		   addProject(project.getName());
		   for( WorkspaceModel algorithm : project.getAlgorithms() )
		   {
			   addAlgorithmToProject(algorithm.getName(), project.getName());
			 
		   }
		 
	   }
	  
	   updateLanguage();
	   revalidate();
	   repaint();
   }
   @Override
	public String toString() {
		return "ProjectBrowser";
	}
   
   private void updateLanguage() {
	   titleLabel.setText(model.getLocalString("projectbrowser"));
   }
}