package tiquetes;


import java.util.List;

import Usuarios.Usuario;

public class PaqueteDeluxe extends TiqueteMultiple {

    private String descripcionBeneficios;

    public PaqueteDeluxe() {
    	super();
    }
    public PaqueteDeluxe(List<TiqueteIndividual> tiquetes,double precioBasePaquete,double porcentajeServicio,double cobroEmision, String descripcionBeneficios) {
        super(tiquetes, precioBasePaquete, porcentajeServicio, cobroEmision);
        this.descripcionBeneficios = descripcionBeneficios;
        this.transferible = false;
    }

    public String getDescripcionBeneficios() {
        return descripcionBeneficios;
    }
}