package rpg.gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
 * Clase personalizada para la interfaz de usuario de un JLabel con un icono y texto.
 * Se encarga de renderizar un icono y texto con un diseño y un estilo visual específico.
 */
public class GameLabelUI extends BasicLabelUI {

    protected final Dimension size; // Dimensiones del icono
    protected final ImageIcon icon; // Icono a mostrar
    protected Rectangle paintIconR = new Rectangle(); // Rectángulo donde se pinta el icono
    protected Rectangle paintTextR = new Rectangle(); // Rectángulo donde se pinta el texto

    /**
     * Constructor que recibe el tamaño y el icono.
     *
     * @param size El tamaño del icono a mostrar.
     * @param icon El icono que se va a mostrar.
     */
    public GameLabelUI(Dimension size, ImageIcon icon) {
        this.size = size;
        this.icon = icon;
    }

    /**
     * Establece los valores predeterminados para el componente JLabel.
     * Se asegura de que el fondo sea transparente y que no tenga borde.
     *
     * @param c El JLabel que tiene el icono y el texto.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false); // El fondo debe ser transparente
        c.setBorder(null);   // Sin borde
    }

    /**
     * Dibuja el icono y el texto en el componente JLabel.
     * El texto se centra dentro del área disponible, y se dibuja el icono al lado.
     *
     * @param g El objeto Graphics que se usa para dibujar.
     * @param c El componente JLabel que contiene el icono y el texto.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c;
        FontMetrics fm = g.getFontMetrics();

        // Se ajusta el texto para que quepa correctamente en el área
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight());

        // Cálculo de la posición del texto en base al tamaño del icono
        int textX = 40 + ((paintIconR.width - 40 - (fm.stringWidth(label.getText()))) / 2);
        int textY = paintTextR.y + fm.getAscent();

        Graphics2D g2d = (Graphics2D) g;

        // Configura el suavizado y la interpolación para mejorar la calidad gráfica
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el icono en el componente JLabel
        g2d.drawImage(icon.getImage(), 0, 0, size.width, size.height, c);

        // Dibuja el texto con las coordenadas calculadas
        super.paintEnabledText(label, g, clippedText, textX, textY);
    }

    /**
     * Organiza y ajusta el texto dentro del área disponible para que se dibuje correctamente.
     *
     * @param label El JLabel que contiene el texto.
     * @param fm Las métricas de la fuente para obtener el ancho y la altura del texto.
     * @param width El ancho disponible para el texto.
     * @param height La altura disponible para el texto.
     * @return El texto ajustado (en caso de que se necesite recortar o modificar).
     */
    protected String layout(JLabel label, FontMetrics fm, int width, int height) {
        Insets insets = label.getInsets(null);
        String text = label.getText(); // El texto que se va a mostrar
        Icon icon = (label.isEnabled()) ? label.getIcon() : label.getDisabledIcon();

        // Calcula el área donde se puede dibujar el icono y el texto
        Rectangle paintViewR = new Rectangle();
        paintViewR.x = insets.left;
        paintViewR.y = insets.top;
        paintViewR.width = width - (insets.left + insets.right);
        paintViewR.height = height - (insets.top + insets.bottom);

        // Ajuste de las áreas donde se pintarán el icono y el texto
        paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
        paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;

        return layoutCL(label, fm, text, icon, paintViewR, paintIconR, paintTextR);
    }
}
