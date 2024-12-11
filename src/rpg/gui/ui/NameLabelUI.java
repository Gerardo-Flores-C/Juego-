package rpg.gui.ui;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase personalizada para la interfaz de usuario de una etiqueta de nombre con un fondo gráfico.
 * La etiqueta se muestra con imágenes a los lados y el texto centrado.
 */
public class NameLabelUI extends GameLabelUI {

    private final BufferedImage[] icons; // Iconos que forman el fondo gráfico de la etiqueta

    /**
     * Constructor que inicializa los iconos para los bordes de la etiqueta.
     * Los iconos se cargan desde las imágenes almacenadas en caché.
     */
    public NameLabelUI() {
        super(null, null);
        icons = new BufferedImage[3]; // Inicializamos un arreglo para los tres iconos
        // Cargamos las imágenes desde la caché de imágenes
        ImageCache.addImage("name_l", "Labels/name_label_left.png");
        ImageCache.addImage("name_c", "Labels/name_label_center.png");
        ImageCache.addImage("name_r", "Labels/name_label_right.png");
        icons[0] = ImageCache.getImage("name_l"); // Icono izquierdo
        icons[1] = ImageCache.getImage("name_c"); // Icono central
        icons[2] = ImageCache.getImage("name_r"); // Icono derecho
    }

    /**
     * Configura los valores predeterminados para la etiqueta JLabel.
     * Establece la fuente, el color, y la alineación del texto y ajusta el tamaño basado en el texto.
     *
     * @param c El JLabel al que se le aplicarán las configuraciones.
     */
    @Override
    protected void installDefaults(JLabel c) {
        c.setFont(WindowConstants.LABEL_FONT); // Fuente predeterminada
        c.setForeground(Color.BLACK); // Color de texto negro
        c.setVerticalAlignment(JLabel.CENTER); // Alineación vertical centrada
        c.setHorizontalAlignment(JLabel.CENTER); // Alineación horizontal centrada
        c.setVerticalTextPosition(JLabel.CENTER); // Posición vertical del texto centrado
        c.setHorizontalTextPosition(JLabel.CENTER); // Posición horizontal del texto centrado
        FontMetrics metrics = c.getFontMetrics(c.getFont()); // Medimos las métricas de la fuente
        int textWidth = metrics.stringWidth(c.getText()); // Calculamos el ancho del texto
        c.setPreferredSize(new Dimension(textWidth + 44, 51)); // Establecemos el tamaño preferido
    }

    /**
     * Dibuja los iconos de fondo y el texto sobre la etiqueta.
     * El texto se ajusta y se dibuja sobre el fondo gráfico compuesto por los iconos cargados.
     *
     * @param g El objeto Graphics utilizado para dibujar.
     * @param c El componente (JLabel) al que se le dibuja el contenido.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        JLabel label = (JLabel) c; // Cast de JComponent a JLabel
        FontMetrics fm = g.getFontMetrics(); // Obtenemos las métricas de la fuente
        String clippedText = layout(label, fm, c.getWidth(), c.getHeight()); // Layout del texto
        int stringWidth = fm.stringWidth(label.getText()); // Ancho del texto
        int textY = paintTextR.y; // Posición vertical del texto
        Graphics2D g2d = (Graphics2D) g; // Obtenemos el contexto gráfico
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Mejoramos la calidad de los gráficos
        g2d.drawImage(icons[0], 0, 0, icons[0].getWidth(), icons[0].getHeight(), c); // Dibuja el icono izquierdo
        g2d.translate(icons[0].getWidth(), 0); // Mueve el cursor gráfico al final del icono izquierdo
        g2d.drawImage(icons[1], 0, 0, stringWidth, icons[1].getHeight(), c); // Dibuja el icono central con el tamaño del texto
        g2d.translate(stringWidth, 0); // Mueve el cursor gráfico al final del texto
        g2d.drawImage(icons[2], 0, 0, icons[2].getWidth(), icons[2].getHeight(), c); // Dibuja el icono derecho
        g2d.translate(-stringWidth, 0); // Restaura la posición del cursor gráfico
        g2d.drawString(clippedText, 0, textY + fm.getAscent()); // Dibuja el texto centrado
    }
}
