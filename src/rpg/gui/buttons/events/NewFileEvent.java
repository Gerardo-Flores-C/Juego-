package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.MainWindow;
import rpg.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que maneja el evento de creación de un nuevo archivo de guardado.
 * Implementa la interfaz ActionListener para gestionar la acción de iniciar una nueva partida.
 */
public class NewFileEvent implements ActionListener {

    // Número de la ranura de guardado donde se almacenará la nueva partida
    int slot;
    // Referencia a la ventana de creación de archivo
    NewFileWindow window;

    /**
     * Constructor de la clase NewFileEvent.
     * @param slot número de la ranura de guardado donde se almacenará la nueva partida.
     * @param window instancia de la ventana desde donde se inicia la nueva partida.
     */
    public NewFileEvent(int slot, NewFileWindow window) {
        this.slot = slot;
        this.window = window;
    }

    /**
     * Método sobrescrito que se ejecuta cuando se activa el evento de acción.
     * Se ejecuta cuando el jugador presiona el botón para crear una nueva partida.
     * @param e el evento de acción que se ha producido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cierra la ventana de creación de nuevo archivo
        window.dispose();

        // Crea un nuevo jugador con el nombre ingresado en la ventana
        Player player = new Player(window.getName());

        // Guarda la nueva partida en la ranura especificada
        player.save(slot);

        // Abre la ventana principal del juego con el nuevo jugador
        new MainWindow(player, slot);
    }
}
