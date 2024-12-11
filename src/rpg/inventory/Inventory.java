package rpg.inventory;

import rpg.exceptions.InventoryFullException;
import rpg.exceptions.ItemNotFoundException;
import rpg.items.Item;
import rpg.items.Armors.Armor;
import rpg.items.Miscs.Misc;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Inventory representa el inventario de un jugador, que contiene una lista de objetos Item.
 */
public class Inventory implements Serializable {

    /**
     * Lista de objetos Item que contiene el inventario.
     */
    private final ArrayList<Item> items;

    /**
     * Capacidad máxima del inventario.
     */
    private int capacity;

    /**
     * Constructor de la clase Inventory, establece la capacidad inicial a 15 y crea una nueva lista de items.
     */
    public Inventory() {
        this.capacity = 15; // La capacidad inicial del inventario es 15
        items = new ArrayList<>(); // Inicializa la lista de items vacía
    }

    /**
     * Agrega un nuevo item al inventario.
     *
     * @param item El item que se desea agregar al inventario.
     */
    public void addItem(Item item) {
        try {
            // Si el inventario no está lleno, agrega el item
            if (!isFull())
                items.add(item);
            else
                throw new InventoryFullException(); // Lanza una excepción si el inventario está lleno
        } catch (InventoryFullException e) {
            // Muestra un mensaje si el inventario está lleno
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina un item del inventario.
     *
     * @param item El item que se desea eliminar.
     */
    public void removeItem(Item item) {
        try {
            // Intenta eliminar el item de la lista
            items.remove(item);
        } catch (Exception e) {
            // Muestra un mensaje si no se encuentra el item
            System.out.println("Item not found");
        }
    }

    /**
     * Obtiene un item específico mediante su índice en el inventario.
     *
     * @param index El índice del item que se desea obtener.
     * @return El item en el índice especificado.
     */
    public Item getItem(int index) {
        return items.get(index); // Devuelve el item en el índice dado
    }

    /**
     * Obtiene un item mediante su nombre.
     *
     * @param item El item que se busca por su nombre.
     * @return El item encontrado en el inventario.
     * @throws ItemNotFoundException Si el item no se encuentra en el inventario.
     */
    public Item getItem(Item item) throws ItemNotFoundException {
        Item found = null; // Variable para almacenar el item encontrado
        // Recorre la lista de items para buscar el item por su nombre
        for (Item i : items) {
            if (i.getName().equals(item.getName())) { // Compara el nombre del item
                found = i;
                break;
            }
        }
        // Si no se encuentra el item, lanza una excepción
        if (found == null) {
            throw new ItemNotFoundException();
        }
        return found; // Devuelve el item encontrado
    }

    /**
     * Obtiene el número de items en el inventario.
     *
     * @return El número de items en el inventario.
     */
    public int getItemCount() {
        return items.size(); // Devuelve la cantidad de items en el inventario
    }

    /**
     * Verifica si el inventario está lleno.
     *
     * @return Verdadero si el inventario está lleno, falso si no.
     */
    public boolean isFull() {
        return items.size() == capacity; // Verifica si la cantidad de items es igual a la capacidad máxima
    }

    /**
     * Verifica si el inventario está vacío.
     *
     * @return Verdadero si el inventario está vacío, falso si no.
     */
    public boolean isEmpty() {
        return items.isEmpty(); // Devuelve verdadero si la lista de items está vacía
    }

    /**
     * Limpia el inventario eliminando todos los items.
     */
    public void clear() {
        items.clear(); // Elimina todos los items del inventario
    }

    /**
     * Aumenta la capacidad del inventario en una cantidad especificada.
     *
     * @param amount La cantidad en la que se desea aumentar la capacidad del inventario.
     */
    public void increaseCapacity(int amount) {
        capacity += amount; // Aumenta la capacidad
        items.ensureCapacity(capacity); // Asegura que la lista de items pueda contener la nueva capacidad
    }

    /**
     * Obtiene todos los items de tipo Armor en el inventario.
     *
     * @return Una lista de objetos Armor que están en el inventario.
     */
    public ArrayList<Armor> getArmors() {
        ArrayList<Armor> armors = new ArrayList<>(); // Lista para almacenar los items de tipo Armor
        // Recorre todos los items en el inventario
        for (Item item : items) {
            if (item instanceof Armor) { // Si el item es una instancia de Armor
                armors.add((Armor) item); // Lo agrega a la lista de armaduras
            }
        }
        return armors; // Devuelve la lista de armaduras
    }

    /**
     * Obtiene todos los items de tipo Misc (misceláneos) en el inventario.
     *
     * @return Una lista de objetos Misc que están en el inventario.
     */
    public ArrayList<Misc> getMiscs() {
        ArrayList<Misc> miscs = new ArrayList<>(); // Lista para almacenar los items de tipo Misc
        // Recorre todos los items en el inventario
        for (Item item : items) {
            if (item instanceof Misc) { // Si el item es una instancia de Misc
                miscs.add((Misc) item); // Lo agrega a la lista de misceláneos
            }
        }
        return miscs; // Devuelve la lista de misceláneos
    }

    /**
     * Obtiene todos los items en el inventario.
     *
     * @return Una lista de todos los items en el inventario.
     */
    public ArrayList<Item> getItems() {
        return items; // Devuelve la lista completa de items en el inventario
    }
}
