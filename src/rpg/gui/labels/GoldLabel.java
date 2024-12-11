package rpg.gui.labels;

import rpg.gui.WindowConstants;
import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta personalizada que muestra la cantidad de oro en el juego.
 * Extiende la clase `PortraitLabel` para agregar una imagen y texto relacionados con el oro.
 */
public class GoldLabel extends PortraitLabel {

    /**
     * Constructor de la clase GoldLabel. Configura el estilo de la etiqueta
     * con la fuente, color y alineación adecuados.
     */
    public GoldLabel() {
        super();
        // Establece la fuente en negrita con un tamaño de 20 puntos.
        setFont(WindowConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        // Establece el color del texto a negro.
        setForeground(Color.BLACK);
        // Alineación vertical y horizontal del texto en el centro.
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        // Establece la posición del texto en el centro de la etiqueta.
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }

    /**
     * Inicializa los componentes de la etiqueta, incluyendo la imagen y el texto.
     * En este caso, se carga una imagen desde la caché y se establece el texto
     * que representa la cantidad de oro (inicialmente "1000").
     */
    @Override
    public void initComponents() {
        // Agrega la imagen del oro a la caché con la clave "gold".
        ImageCache.addImage("gold", "labels/goldLabel.png");
        // Obtiene la imagen del oro desde la caché y la asigna al icono.
        icon = ImageCache.getImageIcon("gold");
        // Establece el tamaño preferido de la etiqueta según el tamaño de la imagen.
        setPreferredSize(new Dimension(
                icon.getIconWidth(), icon.getIconHeight()));
        // Establece el icono de la etiqueta (la imagen del oro).
        setIcon(icon);
        // Establece el texto de la etiqueta a "1000", que representa la cantidad de oro.
        setText("1000");
    }
}
