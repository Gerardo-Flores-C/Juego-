package rpg.gui.labels;

import rpg.utils.cache.ImageCache;

import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Clase que representa una etiqueta personalizada para mostrar el sprite (imagen) del jugador.
 * Esta clase extiende `PortraitLabel` y define cómo inicializar y mostrar la imagen del jugador.
 */
public class PlayerSpriteLabel extends PortraitLabel {

    /**
     * Constructor de la clase `PlayerSpriteLabel`.
     * Inicializa el componente con las configuraciones necesarias para mostrar el sprite del jugador.
     */
    public PlayerSpriteLabel() {
        super();
    }

    /**
     * Inicializa los componentes de la etiqueta del sprite del jugador.
     * Carga la imagen del sprite desde la caché, establece su tamaño y la coloca en la etiqueta.
     */
    @Override
    public void initComponents() {
        // Carga la imagen del sprite del jugador desde la caché.
        ImageCache.addImage("playerSprite", "personajes/personaje.png");
        icon = ImageCache.getImageIcon("playerSprite");

        // Establece las dimensiones preferidas, tamaño máximo y mínimo de la etiqueta.
        setPreferredSize(new Dimension(300, 300));
        setSize(new Dimension(400, 400));
        setMaximumSize(new Dimension(300, 300));
        setMinimumSize(new Dimension(300, 300));

        // Establece la imagen como el icono de la etiqueta.
        setIcon(icon);
    }
}
