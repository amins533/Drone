package components;


import javax.swing.JTextField;
import java.awt.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RoundedJTextField extends JTextField {
	
	private int radius;
	
    public RoundedJTextField(int radius) {
    	
        this.radius = radius;
        
        setBorder(new RoundedBorder(radius)); // Aplica el borde redondeado
        setFont(new Font("Tahoma", Font.PLAIN, 18)); // Fuente para el texto
    }
	
    @Override
    protected void paintComponent(Graphics g) {
        // Obtener el Graphics2D para más control sobre el dibujo
        Graphics2D g2 = (Graphics2D) g;
        // Establecer antialiasing para bordes más suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo con esquinas redondeadas
        g2.setColor(getBackground()); // Usamos el color de fondo del JTextField
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Dibuja el texto sobre el fondo redondeado
        super.paintComponent(g);
    }
    
}