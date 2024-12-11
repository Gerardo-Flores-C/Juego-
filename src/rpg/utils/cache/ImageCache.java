package rpg.utils.cache;
// Define el paquete donde se encuentra la clase ImageCache, en el subpaquete "utils.cache" dentro del proyecto RPG.

import javax.swing.*;
// Importa las clases necesarias de la biblioteca Swing, específicamente ImageIcon, que se utiliza para trabajar con imágenes en interfaces gráficas.

import java.awt.image.BufferedImage;
// Importa BufferedImage, una clase que permite trabajar con imágenes de forma más eficiente.

import java.util.HashMap;
// Importa HashMap, una implementación de la interfaz Map que permite almacenar pares clave-valor.

import java.util.Map;
// Importa la interfaz Map, que define el contrato para estructuras de datos que almacenan pares clave-valor.

/**
 * Clase ImageCache que administra un caché de imágenes para evitar cargas repetidas desde el disco.
 * Utiliza un mapa para almacenar las imágenes cargadas por nombre y ruta.
 */
public class ImageCache {

    // Definición de la ruta base donde se encuentran las imágenes.
    private static final String IMAGE_PATH = "Imagenes/";
    // Ruta donde se almacenan las imágenes, prefijada para simplificar la gestión.

    // Mapa estático para almacenar las imágenes cargadas.
    private static final Map<String, BufferedImage> CACHE = new HashMap<>();
    // Usamos un HashMap para almacenar imágenes asociadas a un nombre único (clave).

    /**
     * Método para agregar una imagen al caché.
     * @param name Nombre clave para la imagen.
     * @param path Ruta relativa de la imagen a cargar.
     * @return La imagen cargada desde el archivo.
     */
    public static BufferedImage addImage(String name, String path) {
        // Método estático para agregar imágenes al caché.

        BufferedImage image;
        // Variable para almacenar la imagen cargada.

        if (!CACHE.containsKey(name)) {
            // Si el caché no contiene la imagen con el nombre proporcionado...

            image = ImageLoader.loadImage(IMAGE_PATH + path);
            // Carga la imagen utilizando la clase ImageLoader, combinando la ruta base con la ruta relativa.

            CACHE.put(name, image);
            // Almacena la imagen cargada en el caché con el nombre como clave.
        } else {
            // Si la imagen ya está en el caché...
            image = CACHE.get(name);
            // Recupera la imagen desde el caché.
        }
        return image;
        // Devuelve la imagen (ya sea recién cargada o recuperada del caché).
    }

    /**
     * Método para obtener una imagen desde el caché.
     * @param imageName Nombre de la imagen que se desea obtener.
     * @return La imagen solicitada o null si no está en el caché.
     */
    public static BufferedImage getImage(String imageName) {
        // Método estático para obtener una imagen desde el caché.

        return CACHE.getOrDefault(imageName, null);
        // Devuelve la imagen si existe en el caché, o null si no se encuentra.
    }

    /**
     * Método para obtener un ImageIcon desde el caché.
     * @param imageName Nombre de la imagen que se desea obtener.
     * @return Un ImageIcon creado a partir de la imagen del caché.
     */
    public static ImageIcon getImageIcon(String imageName) {
        // Método estático para obtener un ImageIcon desde el caché.

        return new ImageIcon(getImage(imageName));
        // Devuelve un ImageIcon creado a partir de la imagen almacenada en el caché.
    }
}
