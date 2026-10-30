package components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

public class RoundedBorder implements Border {
	
    private int radius;
    
    private int topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius;

    public RoundedBorder(int radius) {
    	
        this.radius = radius;
        
    }

    public RoundedBorder(int topLeft, int topRight, int bottomLeft, int bottomRight) {
    	
    	this.radius = 0;
    	
        this.topLeftRadius = topLeft;
        this.topRightRadius = topRight;
        this.bottomLeftRadius = bottomLeft;
        this.bottomRightRadius = bottomRight;
        
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
    	
    	if(radius > 0) {
    		
    		return new Insets(radius, radius, radius, radius);
    		
    	}
    	
    	int topInset = Math.max(topRightRadius, topLeftRadius);
    	int leftInset = Math.max(topLeftRadius, bottomLeftRadius);
    	int bottomInset = Math.max(bottomRightRadius, bottomLeftRadius);
    	int rightInset = Math.max(topRightRadius, bottomRightRadius);
    	
    	return new Insets(topInset, leftInset, bottomInset, rightInset);
    	
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	
        Graphics2D g2 = (Graphics2D) g;
        
        int arcWidth = radius > 0 ? radius : topLeftRadius + topRightRadius;
        int arcHeight = radius > 0 ? radius : bottomLeftRadius + bottomRightRadius;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arcWidth, arcHeight));
        
    }
}