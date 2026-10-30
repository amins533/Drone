package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

//import components.RoundedBorder;

public class RoundedJButton extends JButton {
	private int radius;
    private boolean isHovered = false; // Tracks hover state

    public RoundedJButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false); // Prevent default button painting
        setFocusPainted(true); // Remove focus outline
        setBorder(new RoundedBorder(radius)); // Use the RoundedBorder

        // Add mouse listener for hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
                repaint(); // Trigger repaint to show glow
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor to hand
                repaint(); // Trigger repaint to remove glow
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw glow if hovered
        if (isHovered) {
            g2.setColor(new Color(244, 255, 246));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }

        // Paint button background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Paint text and other content
        super.paintComponent(g);
    }

    public boolean getIsHovered() {
    	
    	return isHovered;
    	
    }

}