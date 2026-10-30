package components;

import java.awt.*;
import javax.swing.*;

public class Draw extends JPanel{
	public Draw(int x, int y){
		this.setBounds(this.getX(),this.getY(), this.getWidth(), this.getHeight());
		
	
	
	}

	public void paint(Graphics g ) {
		
		Graphics g2D = (Graphics2D) g;
		g2D.setColor(Color.white);
		((Graphics2D) g2D).setStroke(new BasicStroke(3));
		//g2D.setPaintMode(Color.black);
	
		//g2D.fillRect(0, 0, 2000, 2000);
		((Graphics2D) g2D).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

		g2D.setColor(new Color(0,0,0));
//		g2D.drawArc(this.getX()-150,this.getY()+400,(int)(this.getWidth()*1.21) ,(int)(this.getHeight()*0.5),0,180);
		g2D.setColor(new Color(22, 27, 33));
		g2D.fillArc(this.getX()-150,this.getY()+400,(int)(this.getWidth()*1.21) ,(int)(this.getHeight()*0.5),0,180);
		g2D.fillRect(this.getX()-150,this.getY()+600, 2000, 2000);
		((Graphics2D) g2D).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//this.getX()-400,this.getY()+390,2335,900,0,180
		//0,250,1535,1080,0,180
		
		
		
		
	}


}
