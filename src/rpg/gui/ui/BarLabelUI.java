package rpg.gui.ui;

import rpg.enums.BarType;
import rpg.gui.WindowConstants;
import rpg.gui.labels.BarLabel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase personalizada para gestionar la interfaz de usuario de las barras de vida o recursos (como energía o maná).
 * Utiliza imágenes predefinidas para representar los iconos y las barras de progreso.
 */
public class BarLabelUI extends BasicLabelUI {

    private final BarType type;

    /**
     * Constructor que recibe el tipo de barra (vida, maná, etc.).
     *
     * @param type El tipo de la barra (BarType).
     */
    public BarLabelUI(BarType type) {
        this.type = type;
    }

    /**
     * Establece los valores predeterminados para el componente JLabel.
     * Ajusta la apariencia del texto y la alineación.
     *
     * @param c El JLabel que representa la barra.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false); // El fondo debe ser transparente
        c.setBorder(null); // Sin borde
        c.setForeground(Color.WHITE); // Color del texto blanco
        c.setFont(WindowConstants.BAR_LABEL_FONT); // Establece la fuente de la barra
        c.setVerticalAlignment(JLabel.BOTTOM); // Alineación vertical al fondo
        c.setVerticalTextPosition(JLabel.BOTTOM); // Texto alineado abajo
        c.setHorizontalAlignment(JLabel.RIGHT); // Alineación horizontal a la derecha
        c.setHorizontalTextPosition(JLabel.RIGHT); // Texto alineado a la derecha
    }

    /**
     * Devuelve el tamaño preferido para el componente, que es el ancho de la barra.
     *
     * @param c El componente JLabel que representa la barra.
     * @return El tamaño preferido.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Devuelve el tamaño mínimo para el componente, que es el ancho de la barra.
     *
     * @param c El componente JLabel que representa la barra.
     * @return El tamaño mínimo.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Devuelve el tamaño máximo para el componente, que es el ancho de la barra.
     *
     * @param c El componente JLabel que representa la barra.
     * @return El tamaño máximo.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getBarWidth();
    }

    /**
     * Dibuja el texto de la barra de forma que esté centrado y ligeramente desplazado.
     *
     * @param l El JLabel que representa la barra.
     * @param g El objeto Graphics que se usa para dibujar.
     * @param s El texto a dibujar.
     * @param textX La posición X donde dibujar el texto.
     * @param textY La posición Y donde dibujar el texto.
     */
    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int textMiddle = g.getFontMetrics(g.getFont()).stringWidth(s) / 2;
        g.drawString(s, textX - textMiddle - 5, textY + 3); // Dibuja el texto ligeramente desplazado
    }

    /**
     * Dibuja la barra de progreso en la interfaz, junto con los iconos y la barra de contenedor.
     *
     * @param g El objeto Graphics que se usa para dibujar.
     * @param c El componente JLabel que representa la barra.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        BarLabel barLabel = (BarLabel) c;
        BufferedImage icon = type.getIcon(); // Obtiene el icono asociado a la barra
        BufferedImage container = type.getContainer(); // Obtiene el contenedor de la barra
        BufferedImage bar = type.getBar(); // Obtiene la imagen de la barra

        // Obtiene el valor y el valor máximo de la barra
        int barValue = getBarValue(barLabel);
        int maxValue = getMaxBarValue(barLabel);

        // Dimensiones para el dibujo del icono y la barra
        int iconX = 0;
        int iconY = 0;
        int iconWidth = WindowConstants.BAR_ICON.width;
        int iconHeight = WindowConstants.BAR_ICON.height;
        int displayX = WindowConstants.BAR_ICON.width - 2;
        int displayY = iconY;
        int displayWidth = WindowConstants.BAR_DISPLAY.width;
        int displayHeight = WindowConstants.BAR_DISPLAY.height;

        // Ancho de la barra en función del valor
        int barWidth = (int) ((double) barValue / maxValue * 157);
        int barHeight = 17;
        int barX = iconWidth + 8;
        int barY = iconY + 10;

        // Dibuja el icono, contenedor y barra de progreso
        g2d.drawImage(icon, iconX, iconY, iconWidth, iconHeight, null);
        g2d.drawImage(container, displayX, displayY, displayWidth, displayHeight, null);
        g2d.drawImage(bar, barX, barY, barWidth, barHeight, null);

        super.paint(g, c); // Llama al método base para el resto del procesamiento de dibujo
    }

    /**
     * Obtiene el valor actual de la barra desde el JLabel.
     *
     * @param c El componente JLabel que representa la barra.
     * @return El valor actual de la barra.
     */
    private int getBarValue(JLabel c) {
        return ((BarLabel) c).getBarValue(); // Llama al método de BarLabel para obtener el valor
    }

    /**
     * Obtiene el valor máximo de la barra desde el JLabel.
     *
     * @param c El componente JLabel que representa la barra.
     * @return El valor máximo de la barra.
     */
    private int getMaxBarValue(JLabel c) {
        return ((BarLabel) c).getMaxValue(); // Llama al método de BarLabel para obtener el valor máximo
    }

    /**
     * Devuelve el ancho total de la barra, que incluye el icono y la barra de progreso.
     *
     * @return Las dimensiones de la barra.
     */
    private Dimension getBarWidth() {
        Dimension iconSize = WindowConstants.BAR_ICON;
        Dimension displaySize = WindowConstants.BAR_DISPLAY;
        int width = iconSize.width + displaySize.width; // Suma el ancho del icono y de la barra de progreso
        return new Dimension(width, iconSize.height); // Devuelve la dimensión total
    }
}
