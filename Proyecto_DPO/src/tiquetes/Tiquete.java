package tiquetes;
import Eventos.Evento;
import Usuarios.Usuario;

public abstract class Tiquete {

    protected String id;
    protected transient Evento evento;
    protected double precioBase;
    protected double porcentajeServicio;
    protected double cobroEmision;
    protected transient Usuario duenoActual;
    protected boolean transferible = true;
    private String asiento; 
    private int descuento = 0;
    private double precioTotal;
    public Tiquete() {}
    public String getId() {
        return id;
    }
    public String getAsiento() {
        return asiento;
    }
    public void setAsiento(String asiento) {
    	this.asiento = asiento;
    }
    public void setComprador (Usuario comprador) {
    	duenoActual = comprador;
    }

    public Evento getEvento() {
        return evento;
    }

    public Usuario getDuenoActual() {
        return duenoActual;
    }

    public void setDuenoActual(Usuario duenoActual) {
        this.duenoActual = duenoActual;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPorcentajeServicio() {
        return porcentajeServicio;
    }

    public double getCobroEmision() {
        return cobroEmision;
    }

    public double getPrecioTotal() {
    	return precioTotal;
    }
    public void setPrecioTotal() {
        double recargoServicio = (precioBase * porcentajeServicio) / 100;
        double subtotal = precioBase + recargoServicio + cobroEmision;

        if (descuento > 0) {
            subtotal = subtotal * (1 - descuento / 100.0);
        }

        this.precioTotal = subtotal;
    }
    public void setDescuento(int descuento)
    {
    	this.descuento = descuento;
    }

    public boolean esTransferible() {
        return transferible;
    }
}