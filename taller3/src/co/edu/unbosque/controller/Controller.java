package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ViewFacade vF;

	public Controller() {
		// TODO Auto-generated constructor stub
		vF = new ViewFacade();
		asignarLectores();
	}

	public void run() {
		vF.getvP().setVisible(true);
	}

	private void asignarLectores() {
		vF.getvP().getBotonBuscar().addActionListener(this);
		vF.getvP().getBotonBuscar().setActionCommand("btnBuscar");
		vF.getvP().getComboBoxIdioma().addActionListener(this);
		vF.getvP().getComboBoxIdioma().setActionCommand("comboBoxI");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "btnBuscar": {
			buscarDefinicion();
			break;
		}
		}

	}

	private void buscarDefinicion() {
	    String palabra = vF.getvP().getFieldPalabra().getText().trim().toLowerCase();
	    String idioma = (String) vF.getvP().getComboBoxIdioma().getSelectedItem();

	    String archivoPalabras = null;
	    String archivoDefiniciones = null;

	    // Asignar archivos según el idioma seleccionado
	    switch (idioma.toLowerCase()) {
	        case "español":
	            archivoPalabras = "config/palabras_es.properties";
	            archivoDefiniciones = "config/definiciones_es.properties";
	            break;
	        case "checo":
	            archivoPalabras = "config/palabras_cz.properties";
	            archivoDefiniciones = "config/definiciones_cz.properties";
	            break;
	        case "aleman":
	            archivoPalabras = "config/palabras_de.properties";
	            archivoDefiniciones = "config/definiciones_de.properties";
	            break;
	        case "noruego":
	            archivoPalabras = "config/palabras_nr.properties";
	            archivoDefiniciones = "config/definiciones_nr.properties";
	            break;
	        case "griego":
	            archivoPalabras = "config/palabras_gr.properties";
	            archivoDefiniciones = "config/definiciones_gr.properties";
	            break;
	        case "chino":
	            archivoPalabras = "config/palabras_ch.properties";
	            archivoDefiniciones = "config/definiciones_ch.properties";
	            break;
	    }

	    // Intentar cargar los archivos y buscar la palabra
	    try {
	        if (FileHandler.loadProperties(archivoPalabras, archivoDefiniciones)) {
	            // Verificar si la palabra existe en el idioma seleccionado
	            if (FileHandler.palabraExiste(palabra)) {
	                String definicion = FileHandler.obtenerDefinicion(palabra);
	                vF.getvP().getTextAreaResultado().setText("Definición: " + definicion);
	            } else {
	                // Si la palabra no está en el idioma seleccionado, verificar en otros idiomas
	                String idiomaCorrecto = verificarPalabraEnOtrosIdiomas(palabra, idioma);
	                if (idiomaCorrecto != null) {
	                    vF.getvP().getTextAreaResultado().setText("La palabra no está en el idioma seleccionado. Está en " + idiomaCorrecto);
	                } else {
	                    vF.getvP().getTextAreaResultado().setText("La palabra no está añadida en ningún archivo de propiedades.");
	                }
	            }
	        } else {
	            // Si no se pudieron cargar los archivos
	            vF.getvP().getTextAreaResultado().setText("Seleccione otro idioma.");
	        }
	    } catch (Exception e) {
	        // Capturar cualquier otra excepción inesperada
	        vF.getvP().getTextAreaResultado().setText("Error inesperado: " + e.getMessage());
	    }
	}

	private String verificarPalabraEnOtrosIdiomas(String palabra, String idiomaSeleccionado) {
	    // Definir los archivos de propiedades de los otros idiomas
	    String[][] archivosIdiomas = {
	        {"español", "config/palabras_es.properties", "config/definiciones_es.properties"},
	        {"Checo", "config/palabras_cz.properties", "config/definiciones_cz.properties"},
	        {"Alemán", "config/palabras_de.properties", "config/definiciones_de.properties"},
	        {"Griego", "config/palabras_gr.properties", "config/definiciones_gr.properties"},
	        {"Noruego", "config/palabras_nr.properties", "config/definiciones_nr.properties"},
	        {"Chino", "config/palabras_ch.properties", "config/definiciones_ch.properties"}
	    };

	    // Verificar en los otros archivos de propiedades
	    for (String[] archivo : archivosIdiomas) {
	        String idioma = archivo[0];
	        String archivoPalabras = archivo[1];
	        String archivoDefiniciones = archivo[2];

	        // Evitar verificar el idioma seleccionado
	        if (!idiomaSeleccionado.toLowerCase().equals(idioma.toLowerCase())) {
	            try {
	                if (FileHandler.loadProperties(archivoPalabras, archivoDefiniciones)) {
	                    if (FileHandler.palabraExiste(palabra)) {
	                        // Si la palabra existe en este idioma, retornar el nombre del idioma
	                        return idioma;
	                    }
	                }
	            } catch (Exception e) {
	                // Manejar la excepción si ocurre un error al cargar otro archivo
	                e.printStackTrace();
	            }
	        }
	    }

	    // Retornar null si la palabra no está en ningún otro idioma
	    return null;
	}
}
