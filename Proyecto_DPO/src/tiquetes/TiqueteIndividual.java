package tiquetes;
import Eventos.Evento;
import Eventos.Localidad;
import Usuarios.Usuario;


public class TiqueteIndividual extends Tiquete {

    private static int contadorIds = 1;

    private transient Localidad localidad;
    private boolean reembolsado;

    public TiqueteIndividual() {
    	super();
    }
    public TiqueteIndividual(Evento evento,Localidad localidad,double porcentajeServicio,double cobroEmision) {
        this.id = "T-" + contadorIds++;
        this.evento = evento;
        this.localidad = localidad;
        this.porcentajeServicio = porcentajeServicio;
        this.cobroEmision = cobroEmision;
        this.precioBase = localidad.getPrecio();
        //this.duenoActual = comprador;
        this.reembolsado = false;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
    




    public boolean fueReembolsado() {
        return reembolsado;
    }

    public void autorizarReembolso(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        this.reembolsado = true;
    }
}