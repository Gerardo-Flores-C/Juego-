package rpg.items.weapons;
// Paquete donde se encuentra la clase Weapon, en el subpaquete "weapons" dentro de "items".

import rpg.enums.WeaponType;
// Importa la enumeración WeaponType, que define los diferentes tipos de armas disponibles en el juego.

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que clasifica los tipos de objetos (por ejemplo, equipo, misceláneo, consumible).

import rpg.items.Equipment;
// Importa la clase base Equipment, de la que hereda la clase Weapon.

/**
 * Clase abstracta que representa un arma en el juego.
 */
public abstract class Weapon extends Equipment {
    // La clase Weapon extiende la clase Equipment y define características específicas de las armas.

    protected WeaponType weaponType;
    // Variable de instancia que almacena el tipo específico de arma (por ejemplo, espada, lanza, arco).

    /**
     * Método que devuelve el tipo de arma.
     * @return weaponType
     */
    public WeaponType getWeaponType() {
        // Método público que devuelve el tipo de arma.
        return weaponType;
    }

    /**
     * Método para realizar un ataque de corte con el arma.
     */
    public void slash() {
        // Método público que define la lógica para un ataque de corte.
        // Actualmente, no está implementado.
        // Se puede sobrescribir en clases derivadas para definir un comportamiento específico.
    }
}


