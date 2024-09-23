import javax.swing.*;

public class Game {
    private Player player;
    private Enemy enemy;

    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        JOptionPane.showMessageDialog(null, "¡El juego ha comenzado!");

        // Bucle que continuará hasta que uno de los personajes muera
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha ganado.");
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " ha ganado.");
        }
    }
}
