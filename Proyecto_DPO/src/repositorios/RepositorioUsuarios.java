package repositorios;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Eventos.Evento;
import Usuarios.Administrador;
import Usuarios.Cliente;
import Usuarios.Promotor;
import Usuarios.Usuario;

public class RepositorioUsuarios{

	public Map<String, Administrador> administradores;
	public Map<String, Promotor> promotores;
	public Map<String, Cliente> clientes;

	private static final String ARCHIVO = "Archivos_Persistidos/ARCHIVO_USUARIOS.json";
	
	public RepositorioUsuarios(){
		administradores = new HashMap<String, Administrador>();
		promotores = new HashMap<String, Promotor>();
		clientes = new HashMap<String, Cliente>();
	}

    public void guardar() {
    	System.out.println(new File("Archivos_Persistidos").getAbsolutePath());
        try (Writer writer = new FileWriter(ARCHIVO)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            System.out.println("Usuarios guardados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RepositorioUsuarios cargar() {
        try (Reader reader = new FileReader(ARCHIVO)) {
            Gson gson = new Gson();
            RepositorioUsuarios repo = gson.fromJson(reader, RepositorioUsuarios.class);
            if (repo == null) {
                repo = new RepositorioUsuarios();
            }
            return repo;
        } catch (FileNotFoundException e) {
            System.out.println("Archivo usuarios.json no encontrado. Se creará uno nuevo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RepositorioUsuarios();
    }
    public void agregarUsuario(Usuario c) {
    	String rol = c.getRol();
    	if (rol.equals("ADMINISTRADOR")) {
    		administradores.put(c.getLogin(), (Administrador) c);
    	}
    	else if(rol.equals("PROMOTOR")) {
    		promotores.put(c.getLogin(), (Promotor) c);
    	}
    	else if(rol.equals("CLIENTE")) {
    		clientes.put(c.getLogin(), (Cliente) c);
    	}
    }
    public void eliminarUsuario(String login, String rol) {
    	if(rol.equals("ADMINISTRADOR")) {
    		administradores.remove(login);
    	}
    	else if (rol.equals("PROMOTOR")) {
    		promotores.remove(login);
    	}
    	else if(rol.equals("CLIENTE")) {
    		clientes.remove(login);
    	}
    }
    
    public Usuario getUsuario(String login) {
    	Usuario admin = administradores.get(login);
    	Usuario prom = promotores.get(login);
    	Usuario cli = clientes.get(login);
    	if(admin != null) {
    		return admin;
    	}
    	else if(prom != null) {
    		return prom;
    		
    	}
    	else if(cli != null) {
    		return cli;
    	}
    	else {
    		return null;
    	}
    	
    }
    

    public List<Cliente> getClientes(){
    	List<Cliente> nueva = new ArrayList<Cliente>(clientes.values());
    	return nueva;
    }
    public List<Administrador> getAdministradores(){
    	List<Administrador> nueva = new ArrayList<Administrador>(administradores.values());
    	return nueva;
    }
    public List<Promotor> getPromotores(){
    	List<Promotor> nueva = new ArrayList<Promotor>(promotores.values());
    	return nueva;
    }

    
}