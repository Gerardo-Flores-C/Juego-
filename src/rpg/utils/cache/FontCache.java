package rpg.utils.cache;
// Paquete donde se encuentra la clase FontCache, en el subpaquete "utils.cache" dentro del proyecto RPG.

import java.awt.*;
// Importa la clase Font de la biblioteca AWT (Abstract Window Toolkit), que es utilizada para trabajar con fuentes tipográficas.

import java.io.FileInputStream;
// Importa FileInputStream para leer archivos, aunque no se usa en este código directamente.

import java.io.IOException;
// Importa IOException, que es utilizada para manejar errores de entrada/salida, aunque tampoco se utiliza directamente en este código.

import java.util.HashMap;
// Importa la clase HashMap, utilizada para almacenar pares de claves y valores (en este caso, nombres de fuentes y objetos Font).

import java.util.Map;
// Importa la interfaz Map, que es implementada por HashMap y otras clases similares.

/**
 * Clase FontCache para manejar fuentes tipográficas en el juego.
 * Utiliza un caché estático para almacenar fuentes y cargarlas de forma eficiente.
 */
public class FontCache {

    // Un mapa estático que almacena fuentes cargadas con su nombre como clave.
    public static final Map<String, Font> cache = new HashMap<>();

    // Constructor estático que se ejecuta una vez cuando la clase es cargada,
    // se usa para inicializar el caché con una fuente predeterminada "Arial".
    static {
        cache.put("Arial", new Font("Arial", Font.PLAIN, 12));
        // Agrega la fuente "Arial" al caché con un tamaño de 12 y estilo normal.
    }

    /**
     * Método que añade una nueva fuente personalizada al caché.
     * Si la fuente ya está en el caché, la devuelve; de lo contrario, la carga desde un archivo.
     * @param fontName Nombre de la fuente.
     * @param fontPath Ruta del archivo de la fuente.
     * @return La fuente cargada.
     */
    public static Font addFont(String fontName, String fontPath) {
        // Método que permite agregar una fuente al caché, cargándola desde un archivo si no existe.

        Font font;
        // Variable para almacenar la fuente cargada.

        if (!cache.containsKey(fontName)) {
            // Si la fuente no está en el caché...
            font = FontLoader.loadFont(fontPath);
            // Carga la fuente desde el archivo usando un método (presumiblemente en la clase FontLoader).
            if (font == null) {
                // Si la carga de la fuente falla...
                System.err.println("Error al cargar la fuente personalizada. Usando Arial como fuente predeterminada.");
                font = cache.get("Arial");  // Usa la fuente "Arial" ya cargada en el caché.
            }
            cache.put(fontName, font);
            // Agrega la fuente al caché con su nombre como clave.
        } else {
            // Si la fuente ya está en el caché, la obtiene.
            font = cache.get(fontName);
        }
        return font;
        // Devuelve la fuente cargada o la obtenida del caché.
    }

    /**
     * Método para obtener una fuente del caché con un estilo y tamaño específicos.
     * Si la fuente no existe, se usa "Arial" como fuente predeterminada.
     * @param fontName Nombre de la fuente.
     * @param style Estilo de la fuente (normal, negrita, etc.).
     * @param size Tamaño de la fuente.
     * @return La fuente solicitada con el estilo y tamaño especificados.
     */
    public static Font getFont(String fontName, int style, int size) {
        // Método que obtiene una fuente del caché, o devuelve "Arial" si no se encuentra.

        Font font = cache.get(fontName);
        // Intenta obtener la fuente del caché.

        if (font == null) {
            // Si no se encuentra la fuente...
            System.err.println("Fuente no encontrada en el cache: " + fontName + ". Usando Arial como fuente predeterminada.");
            font = cache.get("Arial");  // Usa "Arial" como fuente predeterminada.
        }
        return font.deriveFont(style, size);
        // Devuelve la fuente con el estilo y tamaño especificados (crea una nueva fuente derivada).
    }

    /**
     * Método que obtiene una fuente del caché con estilo normal (PLAIN) y tamaño 12.
     * @param fontName Nombre de la fuente.
     * @return La fuente solicitada con estilo normal y tamaño 12.
     */
    public static Font getFont(String fontName) {
        // Sobrecarga de getFont() que devuelve la fuente con estilo normal (PLAIN) y tamaño 12.

        return getFont(fontName, Font.PLAIN, 12);
        // Llama a la versión más general de getFont() con estilo normal y tamaño 12.
    }

    /**
     * Método que obtiene una fuente del caché con estilo normal (PLAIN) y el tamaño especificado.
     * @param fontName Nombre de la fuente.
     * @param size Tamaño de la fuente.
     * @return La fuente solicitada con estilo normal y el tamaño especificado.
     */
    public static Font getFont(String fontName, int size) {
        // Sobrecarga de getFont() que devuelve la fuente con estilo normal y el tamaño especificado.

        return getFont(fontName, Font.PLAIN, size);
        // Llama a la versión más general de getFont() con estilo normal y el tamaño dado.
    }
}
