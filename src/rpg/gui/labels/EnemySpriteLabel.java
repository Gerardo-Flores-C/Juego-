package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Clase que representa una etiqueta (JLabel) que muestra el sprite de un enemigo.
 * Se utiliza para mostrar la imagen del enemigo en la interfaz gráfica del juego.
 */
public class EnemySpriteLabel extends JLabel {

    private ImageIcon icon;  // Icono (imagen) del enemigo
    private Enemy enemy;  // Instancia del enemigo cuya imagen se va a mostrar

    /**
     * Constructor que inicializa la etiqueta con el enemigo y su sprite.
     *
     * @param enemy El enemigo cuya imagen se va a mostrar.
     */
    public EnemySpriteLabel(Enemy enemy) {

        this.enemy = enemy;
        initComponents();  // Inicializa los componentes (imagen del enemigo)
        setUI(new EnemyLabelUI(icon));  // Establece la interfaz gráfica personalizada para la etiqueta
    }

    /**
     * Inicializa los componentes de la etiqueta, incluyendo la imagen del enemigo y el tamaño adecuado.
     */
    public void initComponents() {

        icon = enemy.getSprite();  // Obtiene el sprite (imagen) del enemigo
        setPreferredSize(getMinDimension());  // Establece el tamaño preferido de la etiqueta
        setSize(getMinDimension());  // Establece el tamaño real de la etiqueta
        setIcon(icon);  // Establece la imagen del enemigo como icono de la etiqueta
    }

    /**
     * Calcula las dimensiones mínimas de la etiqueta basadas en el tamaño de la imagen del sprite del enemigo.
     * Si la imagen es demasiado grande, se escala para ajustarse al tamaño máximo permitido.
     *
     * @return Las dimensiones mínimas de la etiqueta, basadas en la imagen.
     */
    private Dimension getMinDimension() {

        // Si la imagen es más grande que los límites establecidos, se escala
        if (icon.getIconWidth() > 250 || icon.getIconHeight() > 150) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());  // Devuelve las dimensiones de la imagen
    }

    /**
     * Actualiza el sprite del enemigo en la etiqueta. Este método es útil cuando el sprite del enemigo cambia durante el juego.
     */
    public void updateSprite() {

        icon = enemy.getSprite();  // Obtiene el nuevo sprite del enemigo
        setUI(new EnemyLabelUI(icon));  // Actualiza la interfaz gráfica de la etiqueta
        setPreferredSize(getMinDimension());  // Actualiza el tamaño preferido de la etiqueta
        setSize(getMinDimension());  // Actualiza el tamaño real de la etiqueta
        setIcon(icon);  // Establece la nueva imagen del enemigo
        revalidate();  // Vuelve a validar el componente
        repaint();  // Vuelve a dibujar el componente
    }

    /**
     * Establece un nuevo enemigo para la etiqueta, cambiando su imagen.
     *
     * @param enemy El nuevo enemigo cuya imagen se va a mostrar.
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;  // Establece el nuevo enemigo
    }
}
