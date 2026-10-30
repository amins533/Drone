package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicRadioButtonUI;

 class CustomRadioButtonUI extends BasicRadioButtonUI {
    private final int circleSize = 16;

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable anti-aliasing for smooth drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the custom circle
        int x = 5;
        int y = (c.getHeight() - circleSize) / 2;

        if (model.isEnabled()) {
            g2d.setColor(Color.GRAY); // Default circle color
            if (model.isSelected()) {
                g2d.setColor(Color.BLACK); // Selected state color
            }
        } else {
            g2d.setColor(Color.LIGHT_GRAY); // Disabled state color
        }
        g2d.fillOval(x, y, circleSize, circleSize);

        // Draw the inner dot if selected
        if (model.isSelected()) {
            g2d.setColor(Color.WHITE);
            g2d.fillOval(x + 4, y + 4, circleSize - 8, circleSize - 8);
        }

        // Draw the label text
        g2d.setColor(button.getForeground());
        g2d.setFont(button.getFont());
        g2d.drawString(button.getText(), x + circleSize + 10, c.getHeight() / 2 + g2d.getFontMetrics().getAscent() / 2 - 2);

        g2d.dispose();
    }

//    @Override
//    public Dimension getPreferredSize(JComponent c) {
//        return new Dimension(150, 30); // Custom preferred size
//    }
}
