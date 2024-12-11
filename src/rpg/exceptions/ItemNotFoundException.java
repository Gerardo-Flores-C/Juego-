package rpg.exceptions;

/**
 * Excepción personalizada que se lanza cuando un ítem no se encuentra en el inventario.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Constructor de la excepción que inicializa el mensaje por defecto "Item not found".
     */
    public ItemNotFoundException() {
        super("Item not found");  // Llama al constructor de la clase padre Exception con el mensaje de error.
    }
}
