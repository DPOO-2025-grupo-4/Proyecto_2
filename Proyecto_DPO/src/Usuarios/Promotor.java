package Usuarios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import Eventos.Evento;
import Eventos.Localidad;
import Eventos.Oferta;
import Eventos.Venue;
import tiquetes.Tiquete;
import tiquetes.TiqueteIndividual;

public class Promotor extends Usuario{
private int reputacion;
private String nit;
private static int idSecuencial = 1;
private final Set<Tiquete> tiquetes= new HashSet<>();

public Promotor() {}
public Promotor(String nombre, String email, String login, String password,int reputacion, String nit ) {
	super(nombre,email,login,password,"PROMOTOR");
	if (reputacion<0) throw new IllegalArgumentException("La reputacion no puede ser menor a 0");
	this.reputacion= reputacion;
	this.nit=Objects.requireNonNull(nit,"nit");
}
public int getReputacion() {
	return reputacion;
}
public String getNit() {
	return nit;
}
public void agregarTiquete(Tiquete tiquete) {
    Objects.requireNonNull(tiquete, "tiquete");
    tiquetes.add(tiquete);
}
}