package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileHandler {
	private static Properties palabrasProps;
	private static Properties definicionesProps;
	private static String mensajeError;

	// Método para cargar archivos de propiedades en función del idioma
	public static boolean loadProperties(String archivoPalabras, String archivoDefiniciones) {
		palabrasProps = new Properties();
		definicionesProps = new Properties();
		mensajeError = null;

		try {
			palabrasProps.load(new FileInputStream(archivoPalabras));
			definicionesProps.load(new FileInputStream(archivoDefiniciones));
			return true; // Carga exitosa
		} catch (IOException e) {
			mensajeError = "Error al cargar los archivos de propiedades: " + e.getMessage();
			return false; // Error en la carga
		}
	}

	// Verifica si la palabra existe
	public static boolean palabraExiste(String palabra) {
		return palabrasProps.containsKey(palabra);
	}

	// Obtiene la definición de la palabra
	public static String obtenerDefinicion(String palabra) {
		return definicionesProps.getProperty(palabra, "Definición no encontrada.");
	}

	// Devuelve el mensaje de error si hubo problemas en la carga de archivos
	public static String getMensajeError() {
		return mensajeError;
	}
}
