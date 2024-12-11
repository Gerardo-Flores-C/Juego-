package rpg.enums;

import rpg.utils.cache.ImageCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Enumeración que define los diferentes tipos de barras en el juego.
 * Cada tipo de barra tiene una imagen de contenedor, un ícono y la propia barra.
 */
public enum BarType {

    LIFE,       // Barra de vida
    MAGIC,      // Barra de magia
    EXPERIENCE; // Barra de experiencia

    // Imágenes asociadas a cada tipo de barra
    BufferedImage container;  // Imagen del contenedor de la barra
    BufferedImage icon;       // Imagen del ícono de la barra
    BufferedImage bar;        // Imagen de la barra

    /**
     * Constructor para cada tipo de barra.
     * Se encarga de cargar las imágenes correspondientes desde la caché.
     */
    BarType() {
        switch (this) {
            case LIFE -> {  // Configuración de la barra de vida
                container = ImageCache.addImage("life_container", "bars/life_container.png");  // Contenedor de vida
                icon = ImageCache.addImage("life_icon", "bars/life_icon.png");                 // Ícono de vida
                bar = ImageCache.addImage("life_bar", "bars/life_bar.png");                    // Barra de vida
            }
            case MAGIC -> {  // Configuración de la barra de magia
                container = ImageCache.addImage("magic_container", "bars/magic_container.png");  // Contenedor de magia
                icon = ImageCache.addImage("magic_icon", "bars/magic_icon.png");                 // Ícono de magia
                bar = ImageCache.addImage("magic_bar", "bars/magic_bar.png");                    // Barra de magia
            }
            case EXPERIENCE -> {  // Configuración de la barra de experiencia
                container = ImageCache.addImage("exp_container", "bars/exp_container.png");  // Contenedor de experiencia
                icon = ImageCache.addImage("exp_icon", "bars/exp_icon.png");                 // Ícono de experiencia
                bar = ImageCache.addImage("exp_bar", "bars/exp_bar.png");                    // Barra de experiencia
            }
        }
    }

    /**
     * Obtiene la imagen del contenedor de la barra.
     *
     * @return la imagen del contenedor
     */
    public BufferedImage getContainer() {
        return container;
    }

    /**
     * Obtiene la imagen del ícono de la barra.
     *
     * @return la imagen del ícono
     */
    public BufferedImage getIcon() {
        return icon;
    }

    /**
     * Obtiene la imagen de la barra.
     *
     * @return la imagen de la barra
     */
    public BufferedImage getBar() {
        return bar;
    }
}
