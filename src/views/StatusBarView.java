/***********************************************************************
 * Module:  StatusBarView.java
 * Author:  User
 * Purpose: Defines the Class StatusBarView
 ***********************************************************************/

package views;

import models.StatusBarModel;
import utility.Localization;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBarView extends JPanel implements Subscriber 
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusBarModel model = null;
	private JLabel label = null;
   
   /** @param model */
   public StatusBarView(StatusBarModel model) 
   {
	   this.model = model;
	   setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	   setPreferredSize(new Dimension(0,25));
	   setBorder(BorderFactory.createRaisedBevelBorder());
	   
	   label = new JLabel();
	   label.setForeground(model.getTheme().getControlTextColor());
	   label.setText("Status: " + model.getState().toString());
	   add(Box.createHorizontalStrut(5));
	   add(label);
	   
	   Localization.getInstance().addSubscribers(this);
   }
   
   public void update() {
      // TODO: implement
	   label.setText(model.getLocalString("statusbar.state") + model.getState().toString());
   }

}