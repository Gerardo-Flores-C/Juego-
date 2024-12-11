package rpg.gui.buttons.events;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.gui.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que maneja el evento de ataque en el juego.
 * Implementa la interfaz ActionListener para gestionar las acciones de los botones.
 */
public class AttackEvent implements ActionListener {

    // Referencia a la ventana principal del juego
    private final MainWindow game;

    /**
     * Constructor de la clase AttackEvent.
     * @param game instancia de la ventana principal del juego.
     */
    public AttackEvent(MainWindow game) {
        this.game = game;
    }

    /**
     * Método sobrescrito que se ejecuta cuando se activa el evento de acción.
     * Se ejecuta cuando el jugador presiona el botón de ataque.
     * @param e el evento de acción que se ha producido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtiene la instancia del enemigo actual en el juego
        Enemy enemy = this.game.getEnemy();
        // Obtiene la instancia del jugador actual en el juego
        Player player = this.game.getPlayer();

        if (enemy != null) {  // Verifica que haya un enemigo presente en la batalla
            // Muestra el resultado del ataque del jugador al enemigo en la interfaz
            this.game.appendText(player.attack(enemy));

            // Si el enemigo sigue vivo, contraataca al jugador
            if (enemy.isAlive())
                this.game.appendText(enemy.attack(player));

            // Comprueba el estado del juego después del ataque
            this.game.checkGameStatus();
        }
    }
}
