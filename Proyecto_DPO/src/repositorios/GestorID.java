package repositorios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Eventos.Evento;
import Eventos.Venue;
import Usuarios.Usuario;

public class GestorID {
	public HashMap<String, Integer> contadores;
	private static final String ARCHIVO = "Archivos_Persistidos/ID_Instancias.json";
	
	
	public GestorID() {
		contadores = new HashMap<String,Integer>();
	}
	
	public void guardar() {
        try (Writer writer = new FileWriter(ARCHIVO)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            System.out.println("IDs guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GestorID cargar() {
        try (Reader reader = new FileReader(ARCHIVO)) {
            Gson gson = new Gson();
            GestorID repo = gson.fromJson(reader, GestorID.class);
            if (repo == null) {
                repo = new GestorID();
            }
            return repo;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo ID_Instancias.json no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GestorID();
    }
    
    public void inicializarIDs() {
    	Venue.setIdSecuencial(contadores.get("VENUE"));
    	Evento.setIdSecuencial(contadores.get("EVENTO"));
    	Usuario.setIdSecuencial(contadores.get("USUARIO"));
    }
    public void finalizarIDs() {
    	contadores.put("VENUE", Venue.getIdSecuencial());
    	contadores.put("EVENTO", Evento.getIdSecuencial());
    	contadores.put("USUARIO", Usuario.getIdSecuencial());
    }
}
