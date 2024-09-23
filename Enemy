import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

public class Enemy {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();

        // Inicialización de estadísticas
        this.stats.put(Stats.HP, 80);
        this.stats.put(Stats.MAX_HP, 80);
        this.stats.put(Stats.MP, 30);
        this.stats.put(Stats.MAX_MP, 30);
        this.stats.put(Stats.ATTACK, 15);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 10);
        this.stats.put(Stats.DEXTERITY, 8);
        this.stats.put(Stats.LUCK, 3);
        this.stats.put(Stats.ACCURACY, 75);
        this.stats.put(Stats.EVASION, 8);
        this.stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
        this.stats.put(Stats.CRITICAL_HIT_DAMAGE, 150); // 150% de daño en críticos
    }

    public String getName() {
        return this.name;
    }

    public int getStat(Stats stat) {
        return this.stats.get(stat);
    }

    public void receiveDamage(int damage) {
        int evasion = this.stats.get(Stats.EVASION);
        Random rand = new Random();

        // Probabilidad de evasión
        if (rand.nextInt(100) < evasion) {
            JOptionPane.showMessageDialog(null, this.name + " esquivó el ataque!");
            return;
        }

        // Calcular daño reducido por defensa
        int defense = this.stats.get(Stats.DEFENSE);
        int finalDamage = Math.max(damage - defense, 0); // El daño no puede ser negativo

        int currentHP = this.stats.get(Stats.HP);
        currentHP -= finalDamage;
        this.stats.put(Stats.HP, currentHP);

        JOptionPane.showMessageDialog(null, this.name + " recibió " + finalDamage + " de daño. HP restante: " + currentHP);
    }

    public boolean isAlive() {
        return this.stats.get(Stats.HP) > 0;
    }

    public void attack(Player player) {
        int accuracy = this.stats.get(Stats.ACCURACY);
        Random rand = new Random();

        // Comprobar si el ataque acierta
        if (rand.nextInt(100) > accuracy) {
            JOptionPane.showMessageDialog(null, this.name + " falló el ataque.");
            return;
        }

        int damage = this.stats.get(Stats.ATTACK);

        // Comprobación de golpe crítico
        int criticalChance = this.stats.get(Stats.CRITICAL_HIT_CHANCE);
        if (rand.nextInt(100) < criticalChance) {
            damage = (damage * this.stats.get(Stats.CRITICAL_HIT_DAMAGE)) / 100;
            JOptionPane.showMessageDialog(null, this.name + " realizó un golpe crítico!");
        }



        JOptionPane.showMessageDialog(null, this.name + " ataca a " + player.getName() + " causando " + damage + " de daño.");
        player.receiveDamage(damage);
    }
}
