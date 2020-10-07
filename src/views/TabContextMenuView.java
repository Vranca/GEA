package views;

import javax.swing.JPopupMenu;

import utility.Localization;

public class TabContextMenuView extends JPopupMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPopupMenu menuClose = null;
	private JPopupMenu menuCloseAll = null;
	private JPopupMenu menuCloseOthers = null;
	
	public TabContextMenuView()
	{
		super();
		
		menuClose = new JPopupMenu(Localization.getInstance().getResources().getString("tabclickadapter.close"));
		menuCloseAll = new JPopupMenu(Localization.getInstance().getResources().getString("tabclickadapter.closeall"));
		menuCloseOthers = new JPopupMenu(Localization.getInstance().getResources().getString("tabclickadapter.closeothers"));
		
		add(menuClose);
		add(menuCloseAll);
		add(menuCloseOthers);
	}
}
