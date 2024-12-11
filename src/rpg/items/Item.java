package rpg.items;
// Paquete donde se encuentra la clase Item, en el subpaquete "items" dentro del proyecto RPG.

import rpg.enums.ItemType;
// Importa la enumeración ItemType, que clasifica los tipos de objetos en el juego (por ejemplo, equipo, consumible, misceláneo).

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados.

/**
 * Clase abstracta que representa un objeto genérico en el juego.
 * Todos los objetos del juego heredarán de esta clase.
 */
public abstract class Item implements Serializable {
    // La clase Item es abstracta y define las propiedades y comportamientos básicos de cualquier objeto en el juego.

    protected String name;
    // Variable protegida que almacena el nombre del objeto.

    protected String description;
    // Variable protegida que almacena la descripción del objeto.

    protected int price;
    // Variable protegida que almacena el precio del objeto en la moneda del juego.

    protected ItemType itemType;
    // Variable protegida que almacena el tipo de objeto, utilizando la enumeración ItemType.

    /**
     * Constructor de la clase Item.
     * Llama al método initItem() para inicializar las propiedades del objeto.
     */
    public Item() {
        initItem();
    }

    /**
     * Método abstracto que debe ser implementado por las clases que hereden de Item.
     * Se utiliza para inicializar las propiedades específicas de cada objeto.
     */
    protected abstract void initItem();

    /**
     * Método que devuelve el nombre del objeto.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devuelve la descripción del objeto.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que devuelve el precio del objeto.
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Método que devuelve el tipo de objeto.
     * @return itemType
     */
    public ItemType getItemType() {
        return itemType;
    }
}
