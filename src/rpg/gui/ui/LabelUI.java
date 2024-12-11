package rpg.gui.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de un JLabel con un icono y borde.
 * Se encarga de configurar el borde y el fondo del JLabel.
 */
public class LabelUI extends BasicLabelUI {

    private Dimension size; // Tamaño del icono
    ImageIcon icon; // Icono a mostrar

    /**
     * Constructor que recibe el tamaño y el icono.
     *
     * @param size El tamaño del icono a mostrar.
     * @param icon El icono que se va a mostrar.
     */
    public LabelUI(Dimension size, ImageIcon icon) {
        this.size = size;
        this.icon = icon;
    }

    /**
     * Establece los valores predeterminados para el componente JLabel.
     * Se asegura de que el fondo sea transparente y que tenga un borde de 5 píxeles de grosor, de color negro.
     *
     * @param c El JLabel que tiene el icono y el texto.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false); // El fondo debe ser transparente
        c.setBorder(new LineBorder(Color.BLACK, 5));   // Borde de 5 píxeles de grosor y color negro
    }
}
