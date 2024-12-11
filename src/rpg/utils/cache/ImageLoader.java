package rpg.utils.cache;
// Define el paquete donde se encuentra la clase ImageLoader, en el subpaquete "utils.cache" dentro del proyecto RPG.

import javax.imageio.ImageIO;
// Importa la clase ImageIO, que proporciona métodos para leer y escribir imágenes.

import javax.swing.*;
// Importa las clases necesarias de la biblioteca Swing, específicamente JOptionPane, para mostrar cuadros de diálogo.

import java.awt.image.BufferedImage;
// Importa la clase BufferedImage, que se usa para representar imágenes de alta calidad en memoria.

import java.io.File;
// Importa la clase File, que se utiliza para representar archivos y directorios en el sistema de archivos.

import java.io.IOException;
// Importa la excepción IOException, que se lanza cuando ocurre un error al manejar archivos o datos de entrada/salida.

/**
 * Clase ImageLoader para cargar imágenes desde archivos utilizando ImageIO.
 * Proporciona un método para leer imágenes desde un archivo en el sistema.
 */
public class ImageLoader {

    /**
     * Método estático para cargar una imagen desde una ruta especificada.
     * @param path Ruta al archivo de la imagen.
     * @return La imagen cargada como un objeto BufferedImage, o null si ocurre un error.
     */
    public static BufferedImage loadImage(String path) {
        // Método estático que carga una imagen desde un archivo dado su path.

        try {
            // Intenta ejecutar el bloque de código que sigue.

            return ImageIO.read(new File(path));
            // Usa ImageIO.read() para cargar la imagen desde el archivo especificado por la ruta.
            // Retorna un objeto BufferedImage que representa la imagen cargada.
        } catch (IOException e) {
            // Si ocurre una excepción al intentar leer el archivo (por ejemplo, si el archivo no se encuentra o no es una imagen válida)...

            JOptionPane.showConfirmDialog(null, "Error al cargar la imagen: " + path,
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            // Muestra un cuadro de diálogo con un mensaje de error, indicando que no se pudo cargar la imagen.
        }
        return null;
        // Si ocurre un error, se retorna null.
    }
}
