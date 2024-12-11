package rpg.items.Miscs;
// Paquete donde se encuentra la clase Book, perteneciente al subpaquete "Miscs" dentro de "items".

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que define los tipos de objetos posibles en el juego.

import rpg.items.Item;
// Importa la clase base Item, de la que posiblemente hereda la clase Misc.

import java.io.Serializable;
// Importa la interfaz Serializable, que permite que los objetos de esta clase puedan ser serializados (convertidos en una secuencia de bytes para guardarlos o transmitirlos).

// Clase para objetos de tipo Libro
public class Book extends Misc implements Serializable {
    // La clase Book extiende (hereda de) la clase Misc y además implementa la interfaz Serializable.

    @Override
    // Anotación que indica que este método sobrescribe un método definido en una clase base o interfaz.
    public void initItem() {
        // Método que inicializa las propiedades del objeto Book.
        this.itemType = ItemType.MISC;
        // Asigna el tipo de objeto como "MISC" (misceláneo) usando el enum ItemType.
        this.name = "Piel de lobo";
        // Asigna el nombre del objeto como "Piel de lobo".
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        // Asigna una descripción del objeto.
        this.price = 50;
        // Establece el precio del objeto en 50 (probablemente una moneda del juego).
        this.consumable = false;
        // Indica que el objeto no es consumible (no desaparece al ser usado).
        this.stackable = true;
        // Indica que el objeto es apilable (pueden almacenarse múltiples unidades en una sola ranura de inventario).
        this.quantity = 1;
        // Establece la cantidad inicial del objeto como 1.
    }

    @Override
    // Anotación que indica que este método sobrescribe un método de la clase base.
    public void use() {
        // Método vacío que define el comportamiento cuando se usa el objeto.
        // Actualmente, este método no tiene funcionalidad implementada.
    }
}
