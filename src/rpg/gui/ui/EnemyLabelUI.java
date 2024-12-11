package rpg.gui.ui;

import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.*;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de un icono de enemigo.
 * Permite la visualización del icono de un enemigo con ciertos efectos gráficos.
 */
public class EnemyLabelUI extends BasicLabelUI {

    private final ImageIcon icon;

    /**
     * Constructor que recibe un icono de imagen.
     *
     * @param icon El icono que se va a mostrar.
     */
    public EnemyLabelUI(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Establece los valores predeterminados para el componente JLabel.
     * Se asegura de que el fondo sea transparente y que no tenga borde.
     *
     * @param c El JLabel que representa el icono del enemigo.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false); // El fondo debe ser transparente
        c.setBorder(null);   // Sin borde
    }

    /**
     * Dibuja el icono del enemigo en el componente JLabel.
     * Aplica un suavizado de imágenes y una interpolación de alta calidad para mejorar la apariencia gráfica.
     *
     * @param g El objeto Graphics que se usa para dibujar.
     * @param c El componente JLabel que representa el icono del enemigo.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;

        // Configura el suavizado y la interpolación para mejorar la calidad gráfica
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // Dibuja el icono en el componente JLabel
        g2d.drawImage(icon.getImage(), 0, 0, icon.getIconWidth(),
                icon.getIconHeight(), c);
    }
}
