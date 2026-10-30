package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import components.Draw;
import components.RoundedJButton;


public class Window extends JFrame implements ActionListener{
	//initialization--------------------------------------------------------------------------------
	DronesDashboard dashboards = new DronesDashboard();
	int width =0,height=0;
	JFrame frame =new JFrame();
	JPanel panel=new JPanel();
	JPanel panel1=new JPanel();
	Draw panel2=new Draw(frame.getX(),frame.getY());
	JLabel label=new JLabel("<html>DRONE<html>", SwingConstants.CENTER);
	ImageIcon icon = new ImageIcon(getClass().getResource("/ressources/drone.255x256.png"));
	ImageIcon image2 = new ImageIcon(getClass().getResource("/ressources/move125.png"));
	ImageIcon image3 = new ImageIcon(getClass().getResource("/ressources/Resize image project.png"));
	ImageIcon image4 = new ImageIcon(getClass().getResource("/ressources/dashboard125.png"));
	ImageIcon image5 = new ImageIcon(getClass().getResource("/ressources/menu32x32.png"));
	ImageIcon image6 = new ImageIcon(getClass().getResource("/ressources/glass.png"));
	JMenuBar menu=new JMenuBar();
	JMenu file;
	JMenu edit;
	JMenuItem overview;
	JMenuItem catalogue;
	JMenuItem dashboard;
	JMenuItem dynamics;
	JMenuItem credits;
	Draw draw;
	{
	}
	JButton button1 = new RoundedJButton("catalogue", 39);
	JButton button2 = new RoundedJButton("Dynamics", 39);
	JButton button3 = new RoundedJButton("dashboard",39);
	
	{
		//Window design--------------------------------------------------------------------------------
		draw = new Draw(frame.getX(),frame.getY());
		label.setFont(new Font("ARIAL",Font.BOLD,250));
		label.setForeground(Color.DARK_GRAY);
		
		label.setOpaque(false);
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(1000,300));
		
		
		//MENU---------------------------------------------------------------------------
		{
			file =new JMenu();
			edit =new JMenu("MENU");
			overview=new JMenuItem("Overview");
			catalogue=new JMenuItem("◍ Drone catalogue");
			dynamics=new JMenuItem("◍ Drone dynamics");
			dashboard=new JMenuItem("◍ Drone dashboard");
			credits=new JMenuItem("© Credits");
			overview.setFont(new Font(null,Font.BOLD,15));
			catalogue.setFont(new Font(null,Font.BOLD,15));
			dynamics.setFont(new Font(null,Font.BOLD,15));
			dashboard.setFont(new Font(null,Font.BOLD,15));
			credits.setFont(new Font(null,Font.BOLD,15));
			menu.setBackground(new Color(250,250,250));
			file.setIcon(image5);
			file.add(overview);
			file.add(catalogue);
			file.add(dynamics);
			file.add(dashboard);
			file.add(credits);
			
//			overview.setPreferredSize(new Dimension(200, 300));

			
			overview.addActionListener(this);
			catalogue.addActionListener(this);
			dashboard.addActionListener(this);
			dynamics.addActionListener(this);
			credits.addActionListener(this);
			
			overview.setIcon(image6);
			overview.setBorder(new TitledBorder("Drone"));
			catalogue.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			dynamics.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			dashboard.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			
			credits.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			credits.setHorizontalTextPosition(JMenuItem.LEFT);
			catalogue.setHorizontalTextPosition(JMenuItem.LEFT);
			dynamics.setHorizontalTextPosition(JMenuItem.LEFT);
			dashboard.setHorizontalTextPosition(JMenuItem.LEFT);
		    
		    menu.add(file);
		    menu.add(edit);
		    
		    edit.setFont(new Font("ARIAL",Font.BOLD,15));
		    edit.setForeground(Color.black);
		    edit.setHorizontalTextPosition(0);
		    edit.setEnabled(false);
		    
		    //Buttons--------------------------------------------------------------------------------------
		    button1.addActionListener(this);
		    button2.addActionListener(this);
		    button3.addActionListener(this);
		    button1.setFocusable(false);
		    button2.setFocusable(false);
		    button3.setFocusable(false);
		    button1.setIcon(image3);
		    button2.setIcon(image2);
		    button3.setIcon(image4);
		    button1.setHorizontalTextPosition(JButton.CENTER);
		    button1.setVerticalTextPosition(JButton.BOTTOM);
		    
		    button2.setHorizontalTextPosition(JButton.CENTER);
		    button2.setVerticalTextPosition(JButton.BOTTOM);
		    
		    button3.setHorizontalTextPosition(JButton.CENTER);
		    button3.setVerticalTextPosition(JButton.BOTTOM);
		    
		    button1.setLayout(new BoxLayout(button1, BoxLayout.Y_AXIS));
		    button2.setLayout(new BoxLayout(button2, BoxLayout.Y_AXIS));
		    button3.setLayout(new BoxLayout(button3, BoxLayout.Y_AXIS));

//		    button1.setSize(220, 220);
//		    button2.setSize(220, 220);
//		    button3.setSize(220, 220);
//		    button1.setIconTextGap(10);
//		    button2.setIconTextGap(15);
//		    button3.setIconTextGap(10);
		    button1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		    button2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		    button3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		    
		    //panels-------------------------------------------------------------------------------------
		    panel1.setOpaque(false);
		    panel1.setLayout(new GridLayout(1,3,60,0));
		    
		    panel1.add(button1);
		    panel1.add(button2);
		    
		    panel1.add(button3);
		    panel.add(panel1,BorderLayout.CENTER);

		}
		//frame--------------------------------------------------------------------------------------------------
		frame.add(panel,BorderLayout.SOUTH);
		frame.add(panel2);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menu);
		frame.setTitle("Drone");
		frame.setBounds(0, 0, 1200, 820);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(1200,820));
		frame.setIconImage(icon.getImage());
		frame.setBackground(new Color(244, 170, 80));
		frame.add(label);
		frame.setResizable(true);
		
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
			panel2.setBounds(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	        width = frame.getWidth();
	        height = frame.getHeight();
	        
	    }});
		frame.setVisible(true);
		
		
	}
	

	void remove() {
		frame.remove(panel);
		frame.remove(panel2);
		frame.remove(label);
		//frame.dispose();
	}
	
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button1||e.getSource()==catalogue) {
		remove();
		frame.setVisible(false);
		frame.setBackground(new Color(244, 170, 80));
		frame.setVisible(true);
		frame.setBackground(new Color(244, 170, 80));
	}
	if(e.getSource()==button2||e.getSource()==dynamics) {
		remove();
	}
	if(e.getSource()==button3||e.getSource()==dashboard) {
		remove();
		frame.add(dashboards.contentPanePanel);
		frame.revalidate();
		
	}
	if(e.getSource()==overview) {
		remove();
	}
	if(e.getSource()==credits) {
		remove();
	}
}
}