package repositorios;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Eventos.Venue;

public class RepositorioVenues{
    public Map<String,  Map<Integer,Venue>> venues;
    private static final String ARCHIVO = "Archivos_Persistidos/ARCHIVO_VENUES.json";

    public RepositorioVenues() {
        venues = new HashMap<String, Map<Integer,Venue>>();
    }

    public void agregarVenue(Venue venue) {
    	Map<Integer,Venue> estado = venues.get(venue.getEstado());
		if(estado == null) {
			Map<Integer,Venue> nuevoMapa = new HashMap<Integer,Venue>();
			nuevoMapa.put(venue.getIdVenue(), venue);
			venues.put(venue.getEstado(), nuevoMapa);
		}
		else {
			estado.put(venue.getIdVenue(), venue);
		}
    }

    public void aprobarVenue(Venue venue) {
		Map<Integer,Venue> estado = venues.get(venue.getEstado());
		estado.remove(venue.getIdVenue());
		venue.setEstado("ACTIVO");
		agregarVenue(venue);
    }

    public void desactivarVenue(Venue venue) {
        Map<Integer,Venue> estado = venues.get(venue.getEstado());
        estado.remove(venue.getIdVenue());
        
    }

    public void guardar() {
        try (Writer writer = new FileWriter(ARCHIVO)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            System.out.println("Venues guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RepositorioVenues cargar() {
        try (Reader reader = new FileReader(ARCHIVO)) {
            Gson gson = new Gson();
            RepositorioVenues repo = gson.fromJson(reader, RepositorioVenues.class);
            if (repo == null) {
                repo = new RepositorioVenues();
            }
            return repo;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo venues.json no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RepositorioVenues();
    }
    
    public Map<String, Map<Integer, Venue>> getVenues() {
        return venues;
    }
    public List<Venue> getVenuesActivos(){
    Map<Integer,Venue> estado = venues.get("ACTIVO");
   	List<Venue>rst = new ArrayList<Venue>(estado.values());
   	return rst;
    }
    public List<Venue>getVenuesInactivos(){
        Map<Integer,Venue> estado = venues.get("INACTIVO");
        List<Venue>rst = new ArrayList<Venue>(estado.values());
       	return rst;
    }
    public Venue getVenueActivo(int id) {
    	Map<Integer,Venue> activos = venues.get("ACTIVO");
    	Venue rst = activos.get(id);
    	return rst;
    }
    public Venue getVenueInactivo(int id) {
    	Map<Integer,Venue> inactivos = venues.get("INACTIVO");
    	Venue rst = inactivos.get(id);
    	return rst;
    }
    

}
