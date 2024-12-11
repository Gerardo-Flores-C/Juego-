package rpg;
// Define el paquete en el que se encuentra la clase InventoryWindow dentro del proyecto RPG.

import javax.swing.*;
// Importa las clases de la biblioteca Swing para crear interfaces gráficas, incluyendo JFrame, JTable y JScrollPane.

import javax.swing.table.DefaultTableModel;
// Importa DefaultTableModel, que es una implementación de la interfaz TableModel para usar en la tabla JTable.

import java.awt.*;
// Importa la biblioteca AWT para usar contenedores como BorderLayout.

import java.util.List;
// Importa la clase List para poder trabajar con listas de objetos.

import rpg.items.Item;
// Importa la clase Item, que representa los ítems del inventario en el sistema.

public class InventoryWindow extends JFrame {
// Declara la clase InventoryWindow, que extiende JFrame para crear una ventana de interfaz gráfica.

    private JTable itemsTable;
    // Declara una variable de tipo JTable que se usará para mostrar la lista de ítems.

    private DefaultTableModel tableModel;
    // Declara una variable de tipo DefaultTableModel que manejará los datos de la tabla.

    public InventoryWindow(List<Item> items) {
        // Constructor de la clase que recibe una lista de ítems para mostrar en la ventana.

        // Configuración de la ventana
        this.setTitle("Inventario de Ítems");
        // Establece el título de la ventana a "Inventario de Ítems".

        this.setSize(600, 400);
        // Establece el tamaño de la ventana a 600 píxeles de ancho y 400 píxeles de alto.

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establece la operación por defecto cuando se cierra la ventana, en este caso, salir de la aplicación.

        this.setLayout(new BorderLayout());
        // Establece el layout (diseño) de la ventana a BorderLayout, para organizar componentes en 5 áreas (Norte, Sur, Este, Oeste, Centro).

        // Crear columnas de la tabla
        String[] columnNames = {"Nombre", "Descripción", "Precio", "Tipo"};
        // Define los nombres de las columnas de la tabla: "Nombre", "Descripción", "Precio", y "Tipo".

        // Crear modelo de tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        // Crea un nuevo modelo de tabla usando los nombres de columnas definidos y sin filas iniciales (0 filas).

        itemsTable = new JTable(tableModel);
        // Crea una nueva tabla utilizando el modelo de tabla previamente definido.

        // Agregar items a la tabla
        for (Item item : items) {
            // Recorre cada ítem en la lista de ítems proporcionada al constructor.

            Object[] rowData = {
                    // Crea un arreglo de objetos con los datos del ítem para agregarlo como una fila en la tabla.

                    item.getName(),
                    // Obtiene el nombre del ítem usando el método getName().

                    item.getDescription(),
                    // Obtiene la descripción del ítem usando el método getDescription().

                    item.getPrice(),
                    // Obtiene el precio del ítem usando el método getPrice().

                    item.getItemType().name()  // Usamos .name() para mostrar el nombre del enum
                    // Obtiene el tipo de ítem usando getItemType() y lo convierte en su representación de cadena usando .name() para mostrar el nombre del tipo de enum.
            };
            tableModel.addRow(rowData);
            // Agrega la fila de datos a la tabla utilizando el modelo de tabla.
        }

        // Agregar la tabla a un scroll pane
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        // Crea un JScrollPane, que permite hacer scroll en la tabla cuando el contenido excede el tamaño de la ventana.

        this.add(scrollPane, BorderLayout.CENTER);
        // Agrega el JScrollPane al centro de la ventana usando el layout BorderLayout.

        // Hacer la ventana visible
        this.setVisible(true);
        // Establece la ventana como visible.
    }
}
