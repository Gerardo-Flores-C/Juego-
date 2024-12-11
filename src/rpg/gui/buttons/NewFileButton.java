package rpg.gui.buttons;

import rpg.gui.StartWindow;
import rpg.gui.buttons.events.NewPlayerEvent;

/**
 * Clase que representa un botón para crear una nueva partida.
 * Este botón permite al usuario iniciar un nuevo juego en un slot especificado.
 */
public class NewFileButton extends BaseButton {

    private int slot;  // El slot donde se guardará la nueva partida.
    private StartWindow startWindow;  // La ventana de inicio donde se muestra el botón.

    /**
     * Constructor que inicializa el botón para crear una nueva partida.
     *
     * @param slot El slot donde se guardará la nueva partida.
     * @param startWindow La ventana de inicio donde se encuentra el botón.
     */
    public NewFileButton(int slot, StartWindow startWindow) {

        // Llama al constructor de la clase base (BaseButton) con el texto "Nueva Partida"
        super("Nueva Partida");

        this.slot = slot;  // Asigna el slot donde se guardará la nueva partida.
        this.startWindow = startWindow;  // Asigna la ventana de inicio.

        // Añade un action listener que maneja el evento de crear una nueva partida.
        addActionListener(new NewPlayerEvent(slot, startWindow));
    }
}
