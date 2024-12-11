package rpg.gui.buttons;

/**
 * Clase que representa un botón para salir del juego.
 * Hereda de la clase BaseButton y asigna el evento de salida al hacer clic en el botón.
 */
public class ExitButton extends BaseButton {

    /**
     * Constructor de la clase ExitButton.
     * Inicializa el botón con el texto "Salir" y asigna un evento que cierra la aplicación al hacer clic.
     */
    public ExitButton() {

        // Llama al constructor de BaseButton para establecer el texto del botón
        super("Salir");

        // Añade un ActionListener al botón que ejecutará el cierre de la aplicación
        addActionListener(e -> System.exit(0));
    }
}
