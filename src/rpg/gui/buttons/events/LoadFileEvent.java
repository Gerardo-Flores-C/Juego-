package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.gui.MainWindow;
import rpg.gui.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que maneja el evento de carga de un archivo de guardado del juego.
 * Implementa la interfaz ActionListener para gestionar la acción de cargar una partida.
 */
public class LoadFileEvent implements ActionListener {

    // Número de la ranura de guardado que se va a cargar
    private int slot;
    // Referencia a la ventana de inicio desde la que se carga el archivo
    private StartWindow startWindow;

    /**
     * Constructor de la clase LoadFileEvent.
     * @param slot número de la ranura de guardado a cargar.
     * @param startWindow instancia de la ventana de inicio desde donde se carga la partida.
     */
    public LoadFileEvent(int slot, StartWindow startWindow) {
        this.slot = slot;
        this.startWindow = startWindow;
    }

    /**
     * Método sobrescrito que se ejecuta cuando se activa el evento de acción.
     * Se ejecuta cuando el jugador presiona el botón para cargar una partida.
     * @param e el evento de acción que se ha producido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Carga el jugador desde la ranura de guardado especificada
        Player player = Player.load(slot);

        // Imprime en consola el nombre del jugador cargado (para depuración)
        System.out.println("C_X " + player.getName());

        // Cierra la ventana de inicio una vez cargada la partida
        startWindow.dispose();

        // Si la carga del jugador fue exitosa, se abre la ventana principal del juego
        if (player != null) {
            new MainWindow(player, slot);
        }
    }
}
