package Eventos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tiquetes.TiqueteIndividual;
import Usuarios.Promotor;

public class Evento {
private String tipoEvento;
private int idEvento;
private String fechaEvento;
private Venue venueAsociado;
private int capacidadEvento;
private int capacidadActualLocalidades;
private TreeMap<Integer, Localidad> localidades;
private Promotor promotorEvento;
private static int idSecuencial = 1;
private int idLocalidad = 1;
private static String estadoActivo = "ACTIVO";
private static String estadoCancelado = "CANCELADO";
private static String estadoFinalizado = "FINALIZADO";
private String estado;
private static double cobroEmision;
private static int porcentajeServicio;

public Evento() {
	
}

public Evento(int capacidadEvento, String tipoEvento,String fechaEvento, Venue venueAsociado, Promotor promotor) 
throws Exception{
	this.venueAsociado = venueAsociado;
	this.capacidadEvento = capacidadEvento;
	this.tipoEvento = tipoEvento;
	this.fechaEvento = fechaEvento;
	try {
		asignarVenue(venueAsociado);
	} catch (Exception e) {
		throw e;
	}
	this.promotorEvento = promotor;
	idEvento = idSecuencial;
	idSecuencial ++;
	localidades = new TreeMap<Integer, Localidad>();
	estado = estadoActivo;
	
}
public static void setIdSecuencial(int idActual) {
	idSecuencial = idActual;
}
public static int getIdSecuencial() {
	return idSecuencial;
}
public double getCobroEmision() {
	return cobroEmision;
}
public int getPorcentajeServicio() {
	return porcentajeServicio;
}
public void setCobroEmision(double cobro) {
	cobroEmision = cobro;
}
public void setPorcentajeServicio(int porcentaje) {
	porcentajeServicio = porcentaje;
}
public void setEstado(String estado) {
	if (estado == estadoCancelado) {
		this.estado = estadoCancelado;
	}
	else if (estado == estadoFinalizado) {
		this.estado = estadoFinalizado;
	}
}
public String getEstado() {
	return estado;
}
public void agregarLocalidad(Localidad localidad) throws Exception{
	if (localidad.getCapacidad() > capacidadEvento || localidad.getCapacidad() + capacidadActualLocalidades > capacidadEvento) {
		throw new Exception("La capacidad de la localidad es mayor de lo que puede soportar el evento");
	}
	//set idlocalidad para mantener un id en cada localidad segun evento
	localidad.setIdLocalidad(idLocalidad);
	
	//mandarse a si mismo para asociarse con la localidad
	localidad.setEventoAsociado(this);
	//Meter la localidad a localidades
	localidades.put(idLocalidad, localidad);
	capacidadActualLocalidades += localidad.getCapacidad();
	idLocalidad ++;
}
public void eliminarLocalidad(int idLocalidad) {
	if(localidades.get(idLocalidad)!= null) {
		capacidadActualLocalidades -= localidades.get(idLocalidad).getCapacidad();
		localidades.remove(idLocalidad);
	}
}
public void asignarVenue(Venue venue) throws Exception {
	if(venue.getDisponible() == true) {
		if (venue.getCapacidadMaxima() > capacidadEvento) {
			venue.ocuparVenue();
			venueAsociado = venue;
		}
		else {
			throw new Exception ("Capacidad del evento supera la del venue:");
		}
	}
	else {
		throw new Exception ("Venue ya ocupado");
	}
	
}

public Localidad getLocalidadPorID(int id) {
	return localidades.get(id);
}
public ArrayList<Localidad> getLocalidadesDisponibles(){
	ArrayList<Localidad> rst = new ArrayList<Localidad>();
	for (Map.Entry<Integer, Localidad> localidad: localidades.entrySet()){
		Localidad valor = localidad.getValue();
		if (valor.getDisponible() == true) {
			rst.add(valor);
		}
	}
	return rst;
}
public int getDisponibilidad() {
	int rst = 0;
	for (Map.Entry<Integer, Localidad> localidad: localidades.entrySet()){
		Localidad valor = localidad.getValue();
		rst += valor.contarDisponibilidad();
	}
	return rst;
}
public String getTipoEvento() {
	return tipoEvento;
}
public void setTipoEvento(String tipoEvento) {
	this.tipoEvento = tipoEvento;
}
public int getIdEvento() {
	return idEvento;
}
public String getFechaEvento() {
	return fechaEvento;
}
public void setFechaEvento(String fechaEvento) {
	this.fechaEvento = fechaEvento;
}
public Venue getVenueAsociado() {
	return venueAsociado;
}
public void setVenueAsociado(Venue venueAsociado) {
	this.venueAsociado = venueAsociado;
}
public int getCapacidadEvento() {
	return capacidadEvento;
}
public void setCapacidadEvento(int capacidadEvento) {
	this.capacidadEvento = capacidadEvento;
}
public TreeMap<Integer, Localidad> getLocalidades() {
	return localidades;
}
public Promotor getPromotorEvento() {
	return promotorEvento;
}



}
