package rpg.items.Miscs;
// Paquete donde se encuentra la clase WolfPelt, en el subpaquete "Miscs" dentro de "items".

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que define los tipos de objetos disponibles en el juego.

import rpg.items.Miscs.Misc;
// Importa la clase base Misc, que representa un tipo genérico de objeto misceláneo.

import rpg.utils.cache.ImageCache;
// Importa una clase ImageCache, posiblemente utilizada para gestionar imágenes en caché.
// **(Nota: En este código no se utiliza, por lo que podría ser eliminado si no es necesario).**

import javax.swing.*;
// Importa las clases del paquete Swing, posiblemente para elementos gráficos (no utilizado en este código).

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados.

/**
 * The type Wolf pelt.
 */
// Clase que representa una "Piel de lobo" como un objeto en el juego.
public class WolfPelt extends Misc implements Serializable {
    // La clase WolfPelt extiende la clase Misc y puede ser serializada.

    @Override
    // Anotación que indica que este método sobrescribe un método definido en la clase base Misc.
    protected void initItem() {
        // Método que inicializa las propiedades específicas del objeto "Piel de lobo".
        this.itemType = ItemType.MISC;
        // Asigna el tipo de objeto como "MISC" (misceláneo).
        this.name = "Piel de lobo";
        // Establece el nombre del objeto como "Piel de lobo".
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        // Establece una descripción para el objeto, indicando que puede ser vendida.
        this.price = 50;
        // Define el precio del objeto en 50 (posiblemente una moneda del juego).
        this.consumable = false;
        // Indica que el objeto no es consumible (no se gasta al usarse).
        this.stackable = true;
        // Indica que el objeto es apilable (puede almacenarse en varias cantidades en una misma ranura de inventario).
        this.quantity = 1;
        // Establece la cantidad inicial del objeto como 1.
    }

    @Override
    // Anotación que indica que este método sobrescribe un método definido en la clase base Misc.
    public void use() {
        // Método que define el comportamiento cuando se intenta usar la "Piel de lobo".
        System.out.println("No puedes usar una piel de lobo.");
        // Imprime un mensaje en la consola indicando que el objeto no se puede usar.
    }
}
