package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {
    private JTextField fieldPalabra;
    private JComboBox<String> comboBoxIdioma;
    private JTextArea textAreaResultado;
    private String[] language = { "Español", "Alemán", "Checo", "Griego", "Noruego", "Chino" };
    private JLabel textPalabra;
    private JLabel textIdioma;
    private JButton botonBuscar;

    // Colores pastel
    private Color colorFondo = new Color(245, 245, 220); // Beige claro
    private Color colorComponentes = new Color(255, 228, 225); // Rosa claro
    private Color colorTexto = new Color(50, 50, 50); // Gris oscuro
    private Color colorBoton = new Color(176, 224, 230); // Azul claro

    public VentanaPrincipal() {
        setTitle("Traductor de Palabras");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout()); // Cambiamos el layout
        setBackground(colorFondo); // Fondo de la ventana

        // Inicializamos los componentes
        fieldPalabra = new JTextField(20);
        comboBoxIdioma = new JComboBox<>(language);
        botonBuscar = new JButton("Buscar Definición");
        textAreaResultado = new JTextArea(5, 30);
        textPalabra = new JLabel("Introduce una palabra:");
        textIdioma = new JLabel("Selecciona el idioma:");

        // Personalización de los componentes
        textAreaResultado.setLineWrap(true);
        textAreaResultado.setWrapStyleWord(true);
        textAreaResultado.setEditable(false);
        textAreaResultado.setBackground(colorComponentes);
        textAreaResultado.setFont(new Font("Arial", Font.PLAIN, 14));
        textAreaResultado.setBorder(new EmptyBorder(10, 10, 10, 10)); // Bordes internos

        fieldPalabra.setFont(new Font("Arial", Font.PLAIN, 14));
        fieldPalabra.setBackground(colorComponentes);

        comboBoxIdioma.setBackground(colorComponentes);
        comboBoxIdioma.setFont(new Font("Arial", Font.PLAIN, 14));

        botonBuscar.setFont(new Font("Arial", Font.BOLD, 16));
        botonBuscar.setBackground(colorBoton);
        botonBuscar.setForeground(colorTexto);

        textPalabra.setFont(new Font("Arial", Font.BOLD, 16));
        textPalabra.setForeground(colorTexto);

        textIdioma.setFont(new Font("Arial", Font.BOLD, 16));
        textIdioma.setForeground(colorTexto);

        // Configuramos el layout con GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadimos los componentes en el GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(textPalabra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(fieldPalabra, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(textIdioma, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(comboBoxIdioma, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(botonBuscar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(textAreaResultado), gbc);

        // Fondo de la ventana
        getContentPane().setBackground(colorFondo);
    }

    public JTextField getFieldPalabra() {
        return fieldPalabra;
    }

    public void setFieldPalabra(JTextField fieldPalabra) {
        this.fieldPalabra = fieldPalabra;
    }

    public JComboBox<String> getComboBoxIdioma() {
        return comboBoxIdioma;
    }

    public void setComboBoxIdioma(JComboBox<String> comboBoxIdioma) {
        this.comboBoxIdioma = comboBoxIdioma;
    }

    public JTextArea getTextAreaResultado() {
        return textAreaResultado;
    }

    public void setTextAreaResultado(JTextArea textAreaResultado) {
        this.textAreaResultado = textAreaResultado;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public void setBotonBuscar(JButton botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public JLabel getTextPalabra() {
        return textPalabra;
    }

    public void setTextPalabra(JLabel textPalabra) {
        this.textPalabra = textPalabra;
    }

    public JLabel getTextIdioma() {
        return textIdioma;
    }

    public void setTextIdioma(JLabel textIdioma) {
        this.textIdioma = textIdioma;
    }

}
