package rpg.items;
// Paquete donde se encuentra la clase Equipment, en el subpaquete "items" dentro del proyecto RPG.

import rpg.enums.Rarity;
// Importa la enumeración Rarity, que define la rareza de los objetos (por ejemplo, común, raro, legendario).

import rpg.enums.Slot;
// Importa la enumeración Slot, que define las ranuras de equipamiento donde se puede usar este objeto (por ejemplo, cabeza, cuerpo, manos).

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que clasifica los tipos de objetos en el juego (por ejemplo, arma, armadura, misceláneo).

import rpg.enums.Stats;
// Importa la enumeración Stats, que define las estadísticas que puede afectar este equipo (por ejemplo, HP, ATTACK, DEFENSE).

import rpg.interfaces.Equipable;
// Importa la interfaz Equipable, que define los métodos que debe implementar cualquier objeto que pueda ser equipado.

import java.util.HashMap;
// Importa la clase HashMap, utilizada para almacenar las estadísticas del equipo junto con sus valores.

/**
 * Clase abstracta que representa un objeto de equipo en el juego.
 * Hereda de la clase Item y implementa la interfaz Equipable.
 */
public abstract class Equipment extends Item implements Equipable {
    // La clase Equipment extiende Item y debe implementar los métodos definidos en la interfaz Equipable.

    protected Slot slot;
    // Variable de instancia que indica en qué ranura del personaje se equipa este objeto.

    protected Rarity rarity;
    // Variable de instancia que indica la rareza del equipo.

    protected HashMap<Stats, Integer> stats;
    // Estructura de datos que almacena las estadísticas del equipo y sus valores correspondientes.

    /**
     * Método que define la lógica para equipar el objeto.
     * Este método debe ser sobrescrito en las clases concretas de equipo.
     */
    @Override
    public void equip() {
        // Implementar lógica de equipamiento.
        // Por ejemplo, aumentar las estadísticas del personaje o actualizar el estado visual.
    }

    /**
     * Método que define la lógica para desequipar el objeto.
     * Este método debe ser sobrescrito en las clases concretas de equipo.
     */
    @Override
    public void unequip() {
        // Implementar lógica de desequipamiento.
        // Por ejemplo, revertir los efectos del equipo en las estadísticas del personaje.
    }

    /**
     * Método que devuelve la ranura donde se equipa este objeto.
     * @return slot
     */
    public Slot getSlot() {
        return slot;
    }

    /**
     * Método que devuelve la rareza del equipo.
     * @return rarity
     */
    public Rarity getRarity() {
        return rarity;
    }

    /**
     * Método que devuelve las estadísticas del equipo.
     * @return stats
     */
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}
