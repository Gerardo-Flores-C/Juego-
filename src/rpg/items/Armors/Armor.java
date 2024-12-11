package rpg.items.Armors;

import rpg.enums.ArmorType;
import rpg.items.Equipment;

/**
 * La clase Armor es una clase abstracta que representa una armadura en el sistema de equipo del juego.
 * Esta clase hereda de Equipment y proporciona una estructura básica para armaduras específicas.
 */
public abstract class Armor extends Equipment {

    /**
     * Tipo de armadura, definido por la enumeración ArmorType.
     */
    protected ArmorType armorType;

    /**
     * Obtiene el tipo de armadura.
     *
     * @return El tipo de armadura (ArmorType).
     */
    public ArmorType getArmorType() {
        return armorType; // Devuelve el tipo de armadura asociado a esta instancia
    }

    /**
     * Método para proteger al jugador con la armadura.
     * Este método debería ser implementado con la lógica de protección específica de cada tipo de armadura.
     */
    public void protect() {
        // Implementar lógica de protección de la armadura
        // Este método puede ser sobrecargado en las clases que heredan de Armor para definir
        // cómo la armadura protege al jugador (por ejemplo, reduciendo daño, aumentando defensa, etc.)
    }
}

