package Usuarios;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import tiquetes.Tiquete;
import tiquetes.TiqueteIndividual;

public class Cliente extends Usuario {
private String documento;
private String telefono;
private final Set<Tiquete> tiquetes= new HashSet<>();

public Cliente() {}
public Cliente (String nombre, String email, String login, String password,String documento, String telefono) {
	super(nombre,email,login,password, "CLIENTE");
	this.documento=Objects.requireNonNull(documento,"documento");
	this.telefono=Objects.requireNonNull(telefono,"telefono");
}

public String getDocumento() {
	return documento;
}

public String getTelefono() {
	return telefono;
}
public Set<Tiquete> getTiquet(){
	return tiquetes;
}
public void agregarTiquete(Tiquete tiquete) {
    Objects.requireNonNull(tiquete, "tiquete");
    tiquetes.add(tiquete);
}
}
