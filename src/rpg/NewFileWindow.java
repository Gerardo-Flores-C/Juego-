package rpg;
// Define el paquete de la clase, en este caso "rpg", que es probablemente un juego o aplicación.

import rpg.gui.buttons.CreateButton;
// Importa la clase CreateButton, que probablemente representa un botón personalizado para la acción de crear un jugador.

import rpg.gui.buttons.ExitButton;
// Importa la clase ExitButton, que probablemente representa un botón personalizado para la acción de salir.

import rpg.gui.labels.PortraitLabel;
// Importa la clase PortraitLabel, que probablemente es un label personalizado para mostrar una imagen del retrato.

import rpg.gui.panels.NewPlayerPanel;
// Importa la clase NewPlayerPanel, que es un panel personalizado para la interfaz de crear un nuevo jugador.

import javax.swing.*;
// Importa las clases de la biblioteca Swing para crear interfaces gráficas de usuario (GUIs).

import java.awt.*;
// Importa las clases de AWT para crear interfaces gráficas (en este caso, específicamente para trabajar con colores y fuentes).

public class NewFileWindow extends JFrame {
// Define la clase NewFileWindow, que extiende JFrame, lo que significa que representa una ventana de la interfaz gráfica.

    private int slot;
    // Declara un entero para identificar el slot donde se guardará el jugador.

    private JTextField playerName;
    // Declara un campo de texto (JTextField) donde el usuario podrá ingresar el nombre del jugador.

    private JButton cancelButton;
    // Declara un botón (JButton) que probablemente se usará para cancelar la creación del jugador.

    private JButton createButton;
    // Declara un botón (JButton) que probablemente se usará para crear al jugador.

    private JPanel mainPanel;
    // Declara un panel principal (JPanel) donde se organizarán los componentes de la ventana.

    private JLabel portraitLabel;
    // Declara un JLabel para mostrar el retrato del jugador.

    private JLabel infoLabel;
    // Declara un JLabel para mostrar información o instrucciones (en este caso, para ingresar el nombre del jugador).

    public NewFileWindow(int slot) {
        // Constructor de la clase que recibe un parámetro entero `slot`, que se usará para identificar el slot donde se guardará el jugador.

        this.slot = slot;
        // Asigna el valor del slot al atributo `slot` de la clase.

        this.setContentPane(mainPanel);
        // Establece el panel principal como el contenido de la ventana.

        pack();
        // Ajusta el tamaño de la ventana para que se acomode a los componentes dentro de ella.

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establece el comportamiento por defecto al cerrar la ventana: salir de la aplicación.

        this.setLocationRelativeTo(null);
        // Centra la ventana en la pantalla.

        this.setResizable(false);
        // Establece que la ventana no se puede redimensionar.

        this.setVisible(true);
        // Hace que la ventana sea visible.

        playerName.setFont(new Font("Retron", Font.BOLD, 18));
        // Establece la fuente del campo de texto del nombre del jugador a "Retron", negrita y tamaño 18.

        playerName.setBackground(new Color(0, 0, 0, 0));
        // Establece el fondo del campo de texto a transparente (Color RGBA con valor 0).

        playerName.setForeground(Color.WHITE);
        // Establece el color del texto del campo de texto a blanco.
    }

    private void createUIComponents() {
        // Método para inicializar los componentes de la interfaz de usuario.

        mainPanel = new NewPlayerPanel();
        // Crea un nuevo panel de jugador, personalizado (NewPlayerPanel) que se establecerá como el panel principal.

        portraitLabel = new PortraitLabel();
        // Crea un nuevo label para el retrato del jugador, personalizado (PortraitLabel).

        infoLabel = new JLabel();
        // Crea un nuevo label para la información o instrucciones.

        infoLabel.setOpaque(false);
        // Establece que el label de información sea transparente (no tenga fondo opaco).

        infoLabel.setFont(new Font("Retron", Font.BOLD, 18));
        // Establece la fuente del label de información a "Retron", negrita y tamaño 18.

        infoLabel.setForeground(Color.WHITE);
        // Establece el color del texto del label de información a blanco.

        infoLabel.setText("Introduce el nombre de tu personaje:");
        // Establece el texto que aparecerá en el label de información.

        cancelButton = new ExitButton();
        // Crea un nuevo botón de salir, personalizado (ExitButton).

        createButton = new CreateButton(slot, this);
        // Crea un nuevo botón de crear, personalizado (CreateButton), pasando el slot y la referencia a la ventana (this).
    }

    public String getName() {
        // Método para obtener el nombre del jugador que se ha ingresado en el campo de texto.

        return playerName.getText();
        // Retorna el texto que se ha ingresado en el campo de texto `playerName`.
    }
}
