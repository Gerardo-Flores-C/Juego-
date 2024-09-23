public class Main {
    public static void main(String[] args) {
        Player player = new Player("sobreviviente");
        Enemy enemy = new Enemy("ZOMBIE");

        Game game = new Game(player, enemy);
        game.startGame();
    }
}

