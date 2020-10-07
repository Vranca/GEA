package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import utility.Localization;

public class AboutView extends JDialog
{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutView()
	{   
		int width = 550;
        int height = 400;
        
        setIconImage(new ImageIcon("icons/gea.png").getImage());     
		
        setSize(new Dimension(width, height));
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(Localization.getInstance().getResources().getString("about.settitle"));
        setLayout(new BorderLayout());
           
        JPanel panelHeader = new JPanel();
        panelHeader.setPreferredSize(new Dimension(width,100));
        
        panelHeader.setLayout(new FlowLayout());
        JLabel labelaIkonica = new JLabel(new ImageIcon("icons/gea.png"));
        
        JPanel iconPanel = new JPanel();
        iconPanel.add(labelaIkonica);
        iconPanel.setPreferredSize(new Dimension(70, 70));
    
        panelHeader.add(iconPanel);
        JLabel labelaNaslov = new JLabel(Localization.getInstance().getResources().getString("about.labelanaslov"));
        
        panelHeader.add(Box.createVerticalStrut(50));
        labelaNaslov.setFont(new Font("Arial", Font.BOLD, 18));
        panelHeader.add(labelaNaslov);        
        
        JPanel panelBottom = new JPanel();
        panelBottom.setPreferredSize(new Dimension(width,60));
        JButton btnClose = new JButton(Localization.getInstance().getResources().getString("about.close"));
        btnClose.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				dispose();		
			}
        });
        panelBottom.add(btnClose);
        
        JPanel panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(width,60));
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        String message = Localization.getInstance().getResources().getString("about.version") + System.getProperty("os.name") + " \n\n"+Localization.getInstance().getResources().getString("about.authors")+"\n - "+Localization.getInstance().getResources().getString("about.marko")+",\n - "+ Localization.getInstance().getResources().getString("about.dejana")+",\n - "+ Localization.getInstance().getResources().getString("about.stevan")+",\n - "+ Localization.getInstance().getResources().getString("about.milan")+",\n - "+Localization.getInstance().getResources().getString("about.rade");
        textArea.append(message);
        textArea.setBackground(null);
        textArea.setEditable(false);
        panelCenter.add(textArea);
        
        
        add(panelHeader, BorderLayout.NORTH);
        add(panelBottom,BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);
		
        setVisible(true);
		
		
	}
	
}


