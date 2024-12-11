package rpg.items.Miscs;
// Paquete donde se encuentra la clase BuildingMaterial, en el subpaquete "Miscs" dentro de "items".

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que define los tipos de objetos disponibles en el juego.

import rpg.items.Item;
// Importa la clase base Item, posiblemente la clase principal de la jerarquía de objetos.

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados.


// Clase para objetos de tipo Material de Construcción
public class BuildingMaterial extends Misc implements Serializable {
    // La clase BuildingMaterial extiende la clase Misc y puede ser serializada.

    private String materialType;
    // Variable de instancia que almacena el tipo de material de construcción.

    private int quantity;
    // Variable de instancia que almacena la cantidad de material disponible.

    public String getMaterialType() {
        // Método público que devuelve el tipo de material de construcción.
        return materialType;
    }

    @Override
    // Anotación que indica que este método sobrescribe un método definido en una clase base o interfaz.
    public void use() {
        // Método vacío que define el comportamiento cuando se usa el objeto.
        // Actualmente, no tiene funcionalidad implementada.
    }

    public int getQuantity() {
        // Método público que devuelve la cantidad de material de construcción.
        return quantity;
    }

    @Override
    // Anotación que indica que este método sobrescribe el método toString() de la clase base.
    public String toString() {
        // Método que devuelve una representación en forma de cadena del objeto.
        return super.toString() + " - Material Type: " + materialType + ", Quantity: " + quantity;
        // Llama al método toString() de la clase base y agrega información específica sobre el tipo y la cantidad del material.
    }

    @Override
    // Anotación que indica que este método sobrescribe el método initItem() de la clase base Misc.
    protected void initItem() {
        // Método que inicializa las propiedades del objeto BuildingMaterial.
        this.itemType = ItemType.MISC;
        // Asigna el tipo de objeto como "MISC" (misceláneo).
        this.name = "Piel de lobo";
        // Establece el nombre del objeto como "Piel de lobo".
        this.description = "Una piel de lobo. Se puede vender por un buen precio.";
        // Establece una descripción para el objeto.
        this.price = 50;
        // Define el precio del objeto en 50 (posiblemente una moneda del juego).
        this.consumable = false;
        // Indica que el objeto no es consumible (no se gasta al usarse).
        this.stackable = true;
        // Indica que el objeto es apilable (puede almacenarse en varias cantidades en una misma ranura de inventario).
        this.quantity = 1;
        // Establece la cantidad inicial del objeto como 1.
    }
}
