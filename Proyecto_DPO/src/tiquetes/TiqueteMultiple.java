package tiquetes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Eventos.Evento;
import Usuarios.Usuario;

public abstract class TiqueteMultiple extends Tiquete {

    private static int contadorIds = 1;

    protected List<TiqueteIndividual> tiquetesIncluidos;

    public TiqueteMultiple() {
    	super();
    }
    public TiqueteMultiple(List<TiqueteIndividual> tiquetes,double precioBasePaquete,double porcentajeServicio,double cobroEmision) {
        if (tiquetes == null || tiquetes.isEmpty()) {
            throw new IllegalArgumentException("El paquete debe tener al menos un tiquete");
        }
        this.id = "TM-" + contadorIds++;
        this.tiquetesIncluidos = new ArrayList<>(tiquetes);
        this.precioBase = precioBasePaquete;
        this.porcentajeServicio = porcentajeServicio;
        this.cobroEmision = cobroEmision;
        this.evento = tiquetes.get(0).getEvento();
    }

    public List<TiqueteIndividual> getTiquetesIncluidos() {
        return Collections.unmodifiableList(tiquetesIncluidos);
    }

    @Override
    public Evento getEvento() {
        return evento;
    }

    public void transferirPaqueteA(Usuario nuevoDueno) {
        if (!transferible) {
            throw new IllegalStateException("Este paquete no es transferible");
        }
        this.duenoActual = nuevoDueno;
        for (TiqueteIndividual t : tiquetesIncluidos) {
            t.setDuenoActual(nuevoDueno);
        }
    }
}