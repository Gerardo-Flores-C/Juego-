package rpg.utils.cache;



import rpg.entities.Player;
// Importa la clase Player, que representa al personaje del jugador en el juego.

import javax.swing.*;
// Importa la biblioteca Swing, aunque no se utiliza en este código (posiblemente quedó por error o se usará en futuras versiones).

import java.awt.*;
// Importa la biblioteca AWT, aunque no se utiliza en este código.

import java.io.*;
// Importa las clases necesarias para trabajar con entrada y salida de datos, incluyendo serialización de objetos.

/**
 * Clase FileManager que maneja la carga y guardado de partidas del juego.
 */
public class FileManager {
    // Clase que proporciona métodos estáticos para guardar y cargar el estado del jugador en archivos.

    private static final String BASE_PATH = "files/";
    // Ruta base donde se almacenarán los archivos de guardado del juego.

    /**
     * Método estático que carga una partida desde un archivo.
     * @param slot Número de la ranura de guardado.
     * @return El objeto Player cargado desde el archivo.
     * @throws FileNotFoundException Si el archivo no se encuentra o no se puede leer.
     */
    public static Player loadGame(int slot) throws FileNotFoundException {
        // Método que carga un archivo de guardado específico basado en el número de ranura (slot).

        Player player;
        // Variable para almacenar el objeto Player que se cargará desde el archivo.

        String fileName = BASE_PATH + "player_" + slot + ".dat";
        // Nombre del archivo de guardado basado en la ruta base y el número de ranura.

        try {
            // Bloque try para intentar leer el archivo de guardado.
            player = (Player) new ObjectInputStream(
                    // Crea un ObjectInputStream para leer objetos desde el archivo.
                    new FileInputStream(fileName)).readObject();
            // Abre el archivo y lee un objeto Player desde él.
        } catch (IOException | ClassNotFoundException e) {
            // Captura excepciones relacionadas con la entrada/salida o si la clase Player no se encuentra.
            throw new FileNotFoundException("No se encontró el archivo");
            // Lanza una excepción si no se puede leer el archivo.
        }

        return player;
        // Devuelve el objeto Player cargado desde el archivo.
    }

    /**
     * Método estático que guarda una partida en un archivo.
     * @param player Objeto Player que se desea guardar.
     * @param slot Número de la ranura de guardado.
     */
    public static void saveGame(Player player, int slot) {
        // Método que guarda el estado del jugador en un archivo específico basado en el número de ranura.

        ObjectOutputStream oos;
        // Variable para el flujo de salida que escribe objetos en un archivo.

        try {
            // Bloque try para intentar escribir el archivo de guardado.
            oos = new ObjectOutputStream(
                    // Crea un ObjectOutputStream para escribir el objeto Player en el archivo.
                    new FileOutputStream(BASE_PATH + "player_" + slot + ".dat"));
            // Abre un archivo para escribir, creando el archivo si no existe.

            oos.writeObject(player);
            // Escribe el objeto Player en el archivo.

            oos.close();
            // Cierra el flujo de salida para liberar recursos.
        } catch (IOException e) {
            // Captura excepciones relacionadas con la entrada/salida.
            e.printStackTrace();
            // Imprime el stack trace si ocurre un error durante el guardado.
        }
    }
}
