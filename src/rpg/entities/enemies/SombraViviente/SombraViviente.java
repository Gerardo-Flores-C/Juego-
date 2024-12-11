package rpg.entities.enemies.SombraViviente;
import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.enums.EnemyType;
import rpg.enums.Stats;
import rpg.exceptions.EnemyDeathException;
import rpg.utils.cache.ImageCache;
import rpg.utils.cache.Randomized;

import javax.swing.*;

public class SombraViviente extends Enemy {

    /**
     * Agregar constructor para Sombra Viviente
     */
    public SombraViviente() {

        super("Sombra Viviente");
        ImageCache.addImage("SombraViviente", "Enemies/SombraViviente.png");
    }

    @Override
    public String attack(Player player) {
        return "";
    }

    @Override
    public void getLoot() {
        System.out.println("The Sombra Viviente drops a bag of coins.");
    }

    @Override
    protected void initCharacter() {
        this.type = EnemyType.BASIC;
        this.stats.put(Stats.MAX_HP, 35);
        this.stats.put(Stats.HP, 35);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 2);
        this.stats.put(Stats.EXPERIENCE, 20);
        this.stats.put(Stats.GOLD, 10);
    }

    @Override
    public String attack(GameCharacter enemy) {
        String message;
        // Se elige un número aleatorio entre 1 y 100
        int random = Randomized.getRandomInt(1, 100);
        // 50% de probabilidad de atacar normalmente
        // 25% de probabilidad de morder
        // 25% de probabilidad de lanzar una roca
        int attack = (random <= 50) ? 3 : (random <= 75) ? 2 : 1;
        // Se elige el ataque a realizar
        switch (attack) {
            case 1:
                try {
                    message = throwRock(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            La Sombra Viviente se burla de ti, te ataca con su guadaña y te hace 4 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            case 2:
                try {
                    message = savageBite(enemy);
                } catch (EnemyDeathException e) {
                    enemy.getStats().put(Stats.HP, 0);
                    message = """
                            La sombra Viviente te escupe y te hace 2 de daño.
                            ¡Has muerto!
                            """;
                }
                break;
            default:
                message = ((GameCharacter) this).attack(enemy);
                break;
        }
        return message;
    }

    protected String throwRock(GameCharacter enemy) throws EnemyDeathException {
        int damage = 2;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s lanza una roca a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    protected String savageBite(GameCharacter enemy) throws EnemyDeathException {
        int damage = 3;
        int newHP = reduceHP(enemy, damage);
        String enemyName = enemy.getName();
        String message = String.format("""
                ¡%s muerde salvajemente a %s por %d de daño!
                %s tiene %d HP restantes.
                """, this.name, enemyName, damage, enemyName, newHP);
        return message;
    }

    @Override
    public ImageIcon getSprite() {

        return ImageCache.getImageIcon("SombraViviente");
    }
}
