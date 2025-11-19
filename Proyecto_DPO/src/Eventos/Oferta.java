package Eventos;

import java.time.LocalDate;

import Usuarios.Promotor;

public class Oferta {
	private String fechaInicio;
	private String fechaFin;
	private int porcentajeDescuento;
	private boolean esActiva;
	private transient Localidad localidadAsociada;
	
	public Oferta() {}
	public Oferta(String fechaInicio, String fechaFin, int porcentajeDescuento, Localidad localidad) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.porcentajeDescuento = porcentajeDescuento;
		esActiva = true;
		localidadAsociada = localidad;
	}
	
	public double aplicarDescuento() {
		double precio = localidadAsociada.getPrecio();
		double rst = precio * porcentajeDescuento / 100;
		return rst;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}


	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}


	public boolean esActiva() {
		return esActiva;
	}
	public void desactivarDescuento() {
		this.esActiva = false;
		localidadAsociada.setOferta(null);
	}

	public Localidad getLocalidadAsociada() {
		return localidadAsociada;
	}

	
	
}
