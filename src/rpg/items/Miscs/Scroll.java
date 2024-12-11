package rpg.items.Miscs;
// Paquete donde se encuentra la clase Scroll, en el subpaquete "Miscs" dentro de "items".

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que define los tipos de objetos disponibles en el juego.

import rpg.items.Item;
// Importa la clase base Item, de la que hereda la clase Misc.

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados.

/**
 * Clase para objetos de tipo Pergamino
 */
public class Scroll extends Misc implements Serializable {
    // La clase Scroll extiende la clase Misc y puede ser serializada.

    private String spell;
    // Variable de instancia que almacena el nombre del hechizo que contiene el pergamino.

    private int manaCost;
    // Variable de instancia que almacena el costo de maná necesario para usar el hechizo.

    public Scroll() {
        // Constructor de la clase Scroll.
        this.spell = spell;
        // Asigna el valor de la variable spell. **(Nota: Esto no es correcto, ya que está asignando la misma variable a sí misma. Debería recibir un parámetro en el constructor).**

        this.manaCost = manaCost;
        // Asigna el valor de la variable manaCost. **(Nota: Al igual que spell, debería recibir un parámetro en el constructor).**
    }

    @Override
    // Anotación que indica que este método sobrescribe un método definido en la clase base.
    public void use() {
        // Método vacío que define el comportamiento cuando se usa el pergamino.
        // Actualmente, no tiene funcionalidad implementada.
    }

    public String getSpell() {
        // Método público que devuelve el nombre del hechizo almacenado en el pergamino.
        return spell;
    }

    public int getManaCost() {
        // Método público que devuelve el costo de maná del hechizo.
        return manaCost;
    }

    @Override
    // Anotación que indica que este método sobrescribe el método toString() de la clase base.
    public String toString() {
        // Método que devuelve una representación en forma de cadena del objeto Scroll.
        return super.toString() + " - Spell: " + spell + ", Mana Cost: " + manaCost;
        // Llama al método toString() de la clase base y agrega información sobre el hechizo y su costo de maná.
    }

    @Override
    // Anotación que indica que este método sobrescribe el método initItem() de la clase base Misc.
    protected void initItem() {
        // Método que inicializa las propiedades del objeto Scroll.
        this.itemType = ItemType.MISC;
        // Asigna el tipo de objeto como "MISC" (misceláneo).
        this.name = "Piel de lobo";
        // Establece el nombre del objeto como "Piel de lobo". **(Nota: Esto parece un error o un placeholder, debería ser el nombre de un pergamino).**
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        // Establece una descripción para el objeto. **(Nota: Esto también parece un placeholder incorrecto para un pergamino).**
        this.price = 50;
        // Define el precio del objeto en 50 (posiblemente una moneda del juego).
        this.consumable = false;
        // Indica que el objeto no es consumible (no se gasta al usarse, aunque esto podría ser incorrecto para un pergamino).
        this.stackable = true;
        // Indica que el objeto es apilable (puede almacenarse en varias cantidades en una misma ranura de inventario).
        this.quantity = 1;
        // Establece la cantidad inicial del objeto como 1.
    }
}
