package rpg.items.Armors;

import rpg.enums.ArmorType;
import rpg.enums.ItemType;
import rpg.enums.Stats;
import rpg.items.Armors.Armor;

import java.util.HashMap;

/**
 * La clase GoldenArmor representa un tipo específico de armadura (un casco de madera en este caso).
 * Esta clase extiende de Armor, proporcionando detalles específicos sobre esta armadura.
 */
public class GoldenArmor extends Armor {

    /**
     * Inicializa las características específicas del casco de madera.
     * Establece el tipo de armadura, nombre, descripción, precio y estadísticas.
     */
    @Override
    protected void initItem() {
        // Asigna el tipo de armadura (en este caso un casco)
        armorType = ArmorType.HELMET;

        // Establece el nombre y descripción del objeto
        name = "Casco de madera";
        description = "Un casco de madera. No es muy resistente, pero es mejor que nada.";

        // Define el precio del casco
        price = 10;

        // Establece las estadísticas del casco (en este caso, defensa)
        stats = new HashMap<>();
        stats.put(Stats.DEFENSE, 2); // Aumenta la defensa en 2
    }

    /**
     * Lógica de protección que simula el uso del casco de madera.
     * Este método sobrescribe el método `protect` de la clase base Armor.
     */
    public void protect() {
        // Simula la protección del casco, mostrando un mensaje indicando que el casco se rompe después de un golpe.
        System.out.println("El casco de madera te protege de un golpe y se rompe.");
    }
}
