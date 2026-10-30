package gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class mainmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		 JRadioButton customRadioButton = new JRadioButton("Custom Radio Button") {
             @Override
             public void updateUI() {
                 setUI(new CustomRadioButtonUI());
             }
         };
		panel.setBackground(Color.black);
		frame.setBounds(0, 0, 500, 500);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0,0,0));
		frame.add(panel);
		panel.setOpaque(false);
		panel.add(customRadioButton);
		
		frame.setVisible(true);
	}

}
