package rpg.gui.labels;

import rpg.gui.ui.NameLabelUI;

import javax.swing.*;

/**
 * Clase que representa una etiqueta que muestra el nombre del jugador o del enemigo.
 * Esta clase extiende `JLabel` y personaliza su apariencia con una interfaz de usuario (UI) específica.
 */
public class NameLabel extends JLabel {

    /**
     * Constructor de la clase `NameLabel`.
     * Inicializa la etiqueta con el nombre proporcionado y aplica el estilo de la interfaz de usuario.
     *
     * @param name El nombre que se mostrará en la etiqueta.
     */
    public NameLabel(String name) {
        // Llama al constructor de la clase JLabel con el nombre inicial.
        super(name);
        // Establece la interfaz de usuario personalizada para la etiqueta de nombre.
        setUI(new NameLabelUI());
    }

    /**
     * Actualiza el texto de la etiqueta con un nuevo nombre.
     * Además, vuelve a aplicar el estilo de la interfaz de usuario para asegurarse
     * de que el diseño se mantenga consistente.
     *
     * @param name El nuevo nombre que se mostrará en la etiqueta.
     */
    public void updateLabel(String name) {
        // Establece el nuevo texto en la etiqueta.
        setText(name);
        // Vuelve a aplicar la interfaz de usuario personalizada.
        setUI(new NameLabelUI());
        // Revalida y repinta el componente para reflejar los cambios visuales.
        revalidate();
        repaint();
    }
}
