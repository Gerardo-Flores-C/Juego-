package rpg.gui.labels;

import rpg.enums.BarType;
import rpg.gui.ui.BarLabelUI;

import javax.swing.*;

/**
 * Clase que representa una etiqueta (JLabel) que muestra una barra de progreso.
 * Se usa para mostrar barras como vida, maná o experiencia en el juego.
 */
public class BarLabel extends JLabel {

    private int barValue;  // Valor actual de la barra
    private int maxValue;  // Valor máximo de la barra
    private final BarType type;  // Tipo de barra (vida, maná, experiencia)

    /**
     * Constructor que inicializa la etiqueta de la barra con el valor actual, el valor máximo y el tipo de barra.
     *
     * @param value El valor actual de la barra.
     * @param maxValue El valor máximo de la barra.
     * @param type El tipo de barra (por ejemplo, vida, maná, experiencia).
     */
    public BarLabel(int value, int maxValue, BarType type) {

        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    /**
     * Método que inicializa los componentes de la barra, incluyendo la configuración de la barra y la interfaz gráfica.
     */
    public void initComponents() {

        setBarValue(barValue);  // Establece el valor de la barra
        setUI(new BarLabelUI(type));  // Establece la interfaz gráfica de la barra según el tipo
    }

    /**
     * Establece el valor actual de la barra y actualiza el texto de la etiqueta.
     *
     * @param value El nuevo valor de la barra.
     */
    public void setBarValue(int value) {

        this.barValue = value;
        // Actualiza el texto mostrado con el valor actual y el valor máximo de la barra
        setText(String.format("%d / %d", value, maxValue));
    }

    /**
     * Obtiene el valor actual de la barra.
     *
     * @return El valor actual de la barra.
     */
    public int getBarValue() {
        return barValue;
    }

    /**
     * Actualiza el valor y el valor máximo de la barra, y refresca su visualización.
     *
     * @param value El nuevo valor actual de la barra.
     * @param maxValue El nuevo valor máximo de la barra.
     */
    public void updateBar(int value, int maxValue) {

        setMaxValue(maxValue);  // Establece el nuevo valor máximo
        setBarValue(value);  // Establece el nuevo valor actual
        setUI(new BarLabelUI(type));  // Actualiza la interfaz gráfica de la barra
        revalidate();  // Vuelve a validar el componente
        repaint();  // Vuelve a dibujar el componente
    }

    /**
     * Establece el valor máximo de la barra.
     *
     * @param value El nuevo valor máximo.
     */
    public void setMaxValue(int value) {
        this.maxValue = value;
    }

    /**
     * Obtiene el valor máximo de la barra.
     *
     * @return El valor máximo de la barra.
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * Obtiene el tipo de la barra (vida, maná, experiencia).
     *
     * @return El tipo de la barra.
     */
    public BarType getType() {
        return type;
    }
}
