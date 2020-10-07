package actionListeners;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import controllers.WorkspaceController;
import models.WorkspaceModel;
import utility.Localization;
import views.ApplicationView;
import views.WorkspaceTabbedView;
import views.WorkspaceView;

public class TabClickAdapter extends MouseAdapter
{
	private WorkspaceTabbedView tabbedPane;
	private ApplicationView appView = null;

    public TabClickAdapter ( WorkspaceTabbedView tabbedPane )
    {
        super ();
        this.tabbedPane = tabbedPane;
        this.appView = (ApplicationView) tabbedPane.getTopLevelAncestor();
    }

    public void mousePressed ( MouseEvent e )
    {
        final int index = tabbedPane.getUI ().tabForCoordinate ( tabbedPane, e.getX (), e.getY () );
        if ( index != -1 )
        {
            if ( SwingUtilities.isLeftMouseButton ( e ) )
            {
                if ( tabbedPane.getSelectedIndex () != index )
                {
                    tabbedPane.setSelectedIndex ( index );
                }
                else if ( tabbedPane.isRequestFocusEnabled () )
                {
                    tabbedPane.requestFocusInWindow ();
                }
            }
            else if ( SwingUtilities.isMiddleMouseButton ( e ) )
            {
                tabbedPane.removeTabAt ( index );
                appView.getToolboxView().getModel().getOpenWorkspaceModels().get(index).removeAllSubscribers();
                appView.getToolboxView().getModel().getOpenWorkspaceModels().remove((appView.getToolboxView().getModel().getOpenWorkspaceModels().get(index)));
            }
            else if ( SwingUtilities.isRightMouseButton ( e ) )
            {
                final JPopupMenu popupMenu = new JPopupMenu ();

          final JMenuItem close = new JMenuItem ( Localization.getInstance().getResources().getString("tabclickadapter.close") );
          
        close.addActionListener ( new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
                tabbedPane.removeTabAt ( index );
                appView.getToolboxView().getModel().getOpenWorkspaceModels().get(index).removeAllSubscribers();
                appView.getToolboxView().getModel().getOpenWorkspaceModels().remove((appView.getToolboxView().getModel().getOpenWorkspaceModels().get(index)));
            }
        } );
        popupMenu.add ( close );
        
        final JMenuItem closeOthers = new JMenuItem ( Localization.getInstance().getResources().getString("tabclickadapter.closeothers") );
        
        closeOthers.addActionListener ( new ActionListener ()
        {
            public void actionPerformed ( ActionEvent e )
            {
            	
            	WorkspaceModel workspaceModel = appView.getToolboxView().getModel().getOpenWorkspacesModel().getWorkspaceModelAt(index);
            	
                tabbedPane.removeAll();
                for(WorkspaceModel model : appView.getToolboxView().getModel().getOpenWorkspaceModels() )
                {
                	model.removeAllSubscribers();
                }
                 appView.getToolboxView().getModel().removeAllOpenWorkspaceModels();
                
                 appView.getToolboxView().getModel().addOpenWorkspaceModels(workspaceModel);;
                 workspaceModel.addSubscribers(appView.getToolboxView().getModel());
                 workspaceModel.addSubscribers(appView.getToolbarView());
				 WorkspaceView workspaceView = new WorkspaceView(workspaceModel);
				 appView.getWorkspaceTabbedView().addWorkspaceToTabbedPane(workspaceView, workspaceModel.getName());
				 new WorkspaceController(workspaceModel, workspaceView);
            }
        } );
        popupMenu.add ( closeOthers );
        
        final JMenuItem closeAll = new JMenuItem ( Localization.getInstance().getResources().getString("tabclickadapter.closeall") );
        
            closeAll.addActionListener ( new ActionListener ()
            {
                public void actionPerformed ( ActionEvent e )
                {
                    tabbedPane.removeAll ();
                    for(WorkspaceModel workspaceModel : appView.getToolboxView().getModel().getOpenWorkspaceModels() )
                    {
                    	workspaceModel.removeSubscribers(appView.getToolboxView().getModel());
                    	workspaceModel.removeSubscribers(appView.getToolbarView());
                    }
                    appView.getToolboxView().getModel().removeAllOpenWorkspaceModels();
                }
            } );
            popupMenu.add ( closeAll );

            final Rectangle tabBounds = tabbedPane.getBoundsAt ( index );
            popupMenu.show ( tabbedPane, tabBounds.x, tabBounds.y + tabBounds.height );
            }
        }
    }

}
