public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero");
        Enemy enemy = new Enemy("Goblin");

        Game game = new Game(player, enemy);
        game.startGame();

        player.attack(enemy);
        enemy.attack(player);
    }
}
