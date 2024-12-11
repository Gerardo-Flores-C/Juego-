package rpg.items.Miscs;
// Paquete donde se encuentra la clase Key, en el subpaquete "Miscs" dentro de "items".

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que define los tipos de objetos disponibles en el juego.

import rpg.items.Item;
// Importa la clase base Item, posiblemente de la que hereda la clase Misc.

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados.


// Clase para objetos de tipo Llave
public class Key extends Misc implements Serializable {
    // La clase Key extiende la clase Misc y puede ser serializada.

    private String doorId;
    // Variable de instancia que almacena el identificador de la puerta que la llave puede desbloquear.

    public Key() {
        // Constructor de la clase Key.
        this.doorId = doorId;
        // Inicializa la variable doorId. **(Nota: esta línea tiene un posible error, ya que asigna a `this.doorId` el valor de sí misma en lugar de recibir un parámetro. Debería corregirse para recibir un argumento).**
    }

    public String getDoorId() {
        // Método público que devuelve el identificador de la puerta que la llave puede desbloquear.
        return doorId;
    }

    @Override
    // Anotación que indica que este método sobrescribe el método toString() de la clase base.
    public String toString() {
        // Método que devuelve una representación en forma de cadena del objeto.
        return super.toString() + " - Unlocks Door ID: " + doorId;
        // Llama al método toString() de la clase base y agrega información sobre la puerta que desbloquea la llave.
    }

    @Override
    // Anotación que indica que este método sobrescribe el método initItem() de la clase base Misc.
    protected void initItem() {
        // Método que inicializa las propiedades del objeto Key.
        this.itemType = ItemType.MISC;
        // Asigna el tipo de objeto como "MISC" (misceláneo).
        this.name = "Piel de lobo";
        // Establece el nombre del objeto como "Piel de lobo". **(Nota: Esto podría ser un error o un placeholder, ya que debería ser el nombre de una llave).**
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        // Establece una descripción para el objeto. **(Nota: Esto también parece ser un placeholder incorrecto para una llave).**
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
    // Anotación que indica que este método sobrescribe un método de la clase base.
    public void use() {
        // Método vacío que define el comportamiento cuando se usa la llave.
        // Actualmente, no tiene funcionalidad implementada.
    }
}
