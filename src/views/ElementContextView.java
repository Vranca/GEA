package views;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import utility.Localization;

public class ElementContextView extends JPopupMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu menuEdit = null;
	private JMenuItem menuMove = null;
	private JMenuItem menuResize = null;
	private JMenuItem menuZoomIn = null;
	private JMenuItem menuZoomOut = null;
	
	private JMenuItem menuItemEditCopy = null;
	private JMenuItem menuItemEditCut = null;
	private JMenuItem menuItemEditPaste = null;
	private JMenuItem menuItemEditSelectAll = null;
	private JMenuItem menuItemEditUndo = null;
	private JMenuItem menuItemEditRedo = null;
	
	
	public ElementContextView() {
		super();
		
		menuEdit = new JMenu(Localization.getInstance().getResources().getString("menuedit"));
		menuItemEditCopy = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.copy"));
		menuItemEditCut = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.cut"));
		menuItemEditPaste = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.paste"));
		menuItemEditSelectAll = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.selectall"));
		menuItemEditUndo = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.undo"));
		menuItemEditRedo = new JMenuItem(Localization.getInstance().getResources().getString("menuedit.redo"));
		
		menuEdit.setVisible(true);

		menuEdit.add(menuItemEditCut);
		menuEdit.add(menuItemEditCopy);
		menuEdit.add(menuItemEditPaste);
		menuEdit.addSeparator();
		menuEdit.add(menuItemEditSelectAll);
		menuEdit.add(menuItemEditUndo);
		menuEdit.add(menuItemEditRedo);
		
		menuMove = new JMenuItem(Localization.getInstance().getResources().getString("elementcontextview.move"));
		menuMove.setVisible(true);
		menuResize = new JMenuItem(Localization.getInstance().getResources().getString("elementcontextview.resize"));
		menuResize.setVisible(true);
		menuZoomIn = new JMenuItem(Localization.getInstance().getResources().getString("menuview.zoomin"));
		menuZoomIn.setVisible(true);
		menuZoomOut = new JMenuItem(Localization.getInstance().getResources().getString("menuview.zoomout"));
		menuZoomOut.setVisible(true);
		
		
		
		add(menuEdit);
		addSeparator();
		add(menuMove);
		add(menuResize);
		addSeparator();
		add(menuZoomIn);
		add(menuZoomOut);
	}
}
