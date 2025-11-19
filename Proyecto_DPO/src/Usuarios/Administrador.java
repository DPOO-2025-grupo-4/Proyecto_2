package Usuarios;

import java.time.LocalDateTime;
import java.util.Objects;

import Eventos.Evento;
import Eventos.Venue;
import tiquetes.TiqueteIndividual;

public class Administrador extends Usuario {
	public Administrador() {}
	public Administrador(String nombre, String email, String login, String password) {
		super(nombre, email, login, password,"ADMINISTRADOR");
	}
	 
	 /*public void autorizarReembolso(Tiquete_individual tiquete, double monto) {
	        Objects.requireNonNull(tiquete, "tiquete");
	        if (monto < 0) throw new IllegalArgumentException("el monto no puede ser un numero negativo");
	        tiquete.autorizarReembolso(monto);     
	        Usuario usuario = tiquete.getDuenoActual();
	        if (usuario != null) usuario.acreditarSaldo(monto);
	 }
	 public double consultarFinanzas(Finanzas finanzas) {
	        Objects.requireNonNull(finanzas, "finanzas");
	        return finanzas.calcularGananciasTiquetera(); 
	 }*/

}