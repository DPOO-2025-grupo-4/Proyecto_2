package Usuarios;
import java.time.LocalDateTime;
import java.util.Objects;

import repositorios.RepositorioUsuarios;



public abstract class Usuario {
protected int id;
protected String nombre;
protected String email;
protected String login;
protected String password;
protected double saldo;
protected  String fechaRegistro;
protected String rol;
private static int idSecuencial = 1;

public Usuario() {}
public Usuario (String nombre, String email, String login, String password, String rol) {
	this.id = idSecuencial;
	idSecuencial ++;
	this.nombre=Objects.requireNonNull(nombre,"nombre");
	this.email=Objects.requireNonNull(email,"email");
	this.login=Objects.requireNonNull(login,"login");
	this.password=Objects.requireNonNull(password,"password");
	this.saldo= 0;
	this.fechaRegistro = LocalDateTime.now().toString();
	this.rol = rol;
}
public static void setIdSecuencial(int idActual) {
	idSecuencial = idActual;
}
public static int getIdSecuencial() {
	return idSecuencial;
}
public void acreditarSaldo(double monto) {
	if(monto<=0) throw new IllegalArgumentException("El monto debe ser positivo y mayor a cero");
	this.saldo+= monto;
}
public void debitarSaldo(double monto) {
	if (monto <= 0) throw new IllegalArgumentException("Monto debe ser positivo");
	if (monto > this.saldo) throw new IllegalStateException("Saldo insuficiente");
	this.saldo -= monto;
}
public int getId() {
	return id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = Objects.requireNonNull(nombre,"nombre");
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = Objects.requireNonNull(email,"email");
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = Objects.requireNonNull(login,"login");
}
public String getFechaRegistro() {
	return fechaRegistro;
}
public double getSaldo() {
	return saldo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRol() {
	return rol;
}

}