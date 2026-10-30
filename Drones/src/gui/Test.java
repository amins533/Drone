package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import components.RoundedJButton;

public class Test {
	JFrame frame =new JFrame();
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	JPanel panel3=new JPanel();
	JPanel panel4=new JPanel();
	JButton button1 = new RoundedJButton("catalogue", 39);
	JButton button2 = new RoundedJButton("Dynamics", 39);
	JButton button3 = new RoundedJButton("dashboard",39);
	{
		
	    button1.setFocusable(false);
	    button2.setFocusable(false);
	    button3.setFocusable(false);
	    
	    button1.setHorizontalTextPosition(JButton.CENTER);
	    button1.setVerticalTextPosition(JButton.BOTTOM);
	    button2.setHorizontalTextPosition(JButton.CENTER);
	    button2.setVerticalTextPosition(JButton.BOTTOM);
	    button3.setHorizontalTextPosition(JButton.CENTER);
	    button3.setVerticalTextPosition(JButton.BOTTOM);
	    button1.setLayout(new GridLayout(2,1));
	    button2.setLayout(new GridLayout(2,1));
	    button3.setLayout(new GridLayout(2,1));
	    button1.setSize(200, 200);
	    button2.setSize(200, 200);
	    button3.setSize(200, 200);
	    button1.setFont(new Font("Arial Black", Font.PLAIN, 20));
	    button1.setIconTextGap(10);
	    button2.setIconTextGap(15);
	    button3.setIconTextGap(20);
	    button2.setFont(new Font("Arial Black", Font.PLAIN, 13));
	    button3.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		panel1.setBackground(Color.black);
		panel1.setPreferredSize(new Dimension(1000,300));
		panel2.setPreferredSize(new Dimension(300,300));
		panel3.setPreferredSize(new Dimension(300,300));
		panel4.setPreferredSize(new Dimension(900,300));
		panel4.setLayout(new GridLayout(1,3,10,10));
		panel4.add(button1);
		panel4.add(button2);
		panel4.add(button3);
		//panel1.add(panel2,BorderLayout.WEST);
		panel1.add(panel4,BorderLayout.CENTER);
		//panel1.add(panel3,BorderLayout.EAST);
		panel2.setBackground(Color.BLUE);
		panel3.setBackground(Color.red);
		panel4.setBackground(Color.YELLOW);
		
		frame.add(panel1,BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(1200,820));
		frame.setBackground(new Color(135,135,135));
		frame.setResizable(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
	}

}
