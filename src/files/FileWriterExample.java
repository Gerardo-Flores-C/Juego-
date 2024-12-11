package files;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileWriterExample {

    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame frame = new JFrame("Escribir y Guardar Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear un JTextArea para que el usuario pueda escribir el texto
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Agregar el JTextArea a un JScrollPane

        // Crear un botón "Guardar"
        JButton saveButton = new JButton("Guardar");

        // Acción al presionar el botón "Guardar"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ruta del archivo que se va a crear
                String filePath = "C:\\Users\\faudo\\IdeaProjects\\Equipo-5-RPG\\src\\files\\READ.md";  // Asegúrate de que la carpeta "files" exista

                // Guardar el contenido del JTextArea en un archivo .txt
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(textArea.getText());  // Escribir el contenido del JTextArea en el archivo
                    JOptionPane.showMessageDialog(frame, "Archivo guardado exitosamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Ocurrió un error al guardar el archivo:\n" + ex.getMessage());
                }
            }
        });

        // Agregar el JScrollPane (con el JTextArea) y el botón a la ventana
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(saveButton, BorderLayout.SOUTH);

        // Hacer la ventana visible
        frame.setVisible(true);
    }
}
